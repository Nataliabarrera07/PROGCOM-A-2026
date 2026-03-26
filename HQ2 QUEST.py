import pygame
import sys
import random

# --- Configuración y Estética ---
ANCHO, ALTO = 850, 650
FPS = 60
COLOR_FONDO = (10, 10, 18)

# Paletas de colores mejoradas
OPCIONES_BOLA = {
    "NEÓN": (0, 255, 255),
    "FUEGO": (255, 69, 0),
    "ESMERALDA": (50, 255, 50),
    "ELÉCTRICO": (255, 0, 255),
    "BLANCO": (255, 255, 255)
}

# Colores para el modo arcoíris
COLORES_ARCOIRIS = [
    (255, 0, 0), (255, 127, 0), (255, 255, 0), (0, 255, 0), 
    (0, 0, 255), (75, 0, 130), (148, 0, 211), (0, 255, 255)
]

class Juego:
    def __init__(self):
        pygame.init()
        self.pantalla = pygame.display.set_mode((ANCHO, ALTO))
        # Nombre en la ventana
        pygame.display.set_caption("ARKANOID - Edición Definitiva") 
        self.reloj = pygame.time.Clock()
        self.fuente_logo = pygame.font.SysFont("Impact", 90) # Un poco más grande para el título
        self.fuente_ui = pygame.font.SysFont("Arial", 22, bold=True)
        
        self.estado = "MENU_COLOR"
        self.color_tema = (255, 255, 255)
        self.es_modo_blanco = False
        self.puntos = 0
        self.vidas = 3
        self.nivel = 1
        self.flash_fondo = 0 
        
        self.reset_entorno()

    def reset_entorno(self):
        self.velocidad_actual = 5 + self.nivel
        self.paleta = pygame.Rect(ANCHO//2 - 70, ALTO - 50, 140, 15)
        self.bola = pygame.Rect(ANCHO//2, ALTO - 150, 14, 14)
        self.bola_vel = [self.velocidad_actual, -self.velocidad_actual]
        
        self.ladrillos = []
        filas = 7 
        columnas = 10
        for f in range(filas):
            for c in range(columnas):
                r = pygame.Rect(c * 82 + 18, f * 26 + 100, 78, 22)
                if self.es_modo_blanco:
                    color = (200, 200, 200) if (f + c) % 2 == 0 else (255, 255, 255)
                else:
                    color = COLORES_ARCOIRIS[f % len(COLORES_ARCOIRIS)]
                self.ladrillos.append({'rect': r, 'color': color})

    def dibujar_menu(self):
        self.pantalla.fill(COLOR_FONDO)
        # --- AQUÍ CAMBIAMOS EL TÍTULO ---
        titulo = self.fuente_logo.render("ARKANOID", True, (255, 255, 255))
        self.pantalla.blit(titulo, (ANCHO//2 - titulo.get_width()//2, 70))
        
        subtitulo = self.fuente_ui.render("SELECCIONA TU ESTILO", True, (150, 150, 150))
        self.pantalla.blit(subtitulo, (ANCHO//2 - subtitulo.get_width()//2, 170))
        
        self.botones = []
        for i, (nombre, color) in enumerate(OPCIONES_BOLA.items()):
            rect = pygame.Rect(ANCHO//2 - 110, 230 + (i * 55), 220, 45)
            self.botones.append((rect, color, nombre))
            
            m_pos = pygame.mouse.get_pos()
            esta_encima = rect.collidepoint(m_pos)
            b_color = color if esta_encima else (30, 30, 50)
            t_color = (0, 0, 0) if (esta_encima and nombre == "BLANCO") else (255, 255, 255)
            
            pygame.draw.rect(self.pantalla, b_color, rect, border_radius=12)
            if not esta_encima:
                pygame.draw.rect(self.pantalla, color, rect, 2, border_radius=12)
                
            txt = self.fuente_ui.render(nombre, True, t_color)
            self.pantalla.blit(txt, (rect.centerx - txt.get_width()//2, rect.centery - txt.get_height()//2))

    def actualizar(self):
        self.paleta.centerx = pygame.mouse.get_pos()[0]
        self.paleta.clamp_ip(self.pantalla.get_rect())

        self.bola.x += self.bola_vel[0]
        self.bola.y += self.bola_vel[1]

        if self.bola.left <= 0 or self.bola.right >= ANCHO: self.bola_vel[0] *= -1
        if self.bola.top <= 85: self.bola_vel[1] *= -1

        if self.bola.colliderect(self.paleta) and self.bola_vel[1] > 0:
            self.flash_fondo = 35
            diff = (self.bola.centerx - self.paleta.centerx) / (self.paleta.width / 2)
            self.bola_vel[0] = diff * (self.velocidad_actual + 2)
            self.bola_vel[1] = -abs(self.bola_vel[1])
            self.bola_vel[0] *= 1.03
            self.bola_vel[1] *= 1.03

        for l in self.ladrillos[:]:
            if self.bola.colliderect(l['rect']):
                self.ladrillos.remove(l)
                self.bola_vel[1] *= -1
                self.puntos += 15
                self.flash_fondo = 20
                break

        if self.bola.bottom > ALTO:
            self.vidas -= 1
            if self.vidas <= 0: self.estado = "MENU_COLOR"
            else: 
                self.bola.center = (ANCHO//2, ALTO - 150)
                self.bola_vel = [self.velocidad_actual, -self.velocidad_actual]

        if not self.ladrillos:
            self.nivel += 1
            self.reset_entorno()

    def dibujar_juego(self):
        bg_flash = [min(255, c + self.flash_fondo) for c in COLOR_FONDO]
        self.pantalla.fill(bg_flash)
        if self.flash_fondo > 0: self.flash_fondo -= 2
        
        pygame.draw.rect(self.pantalla, (15, 15, 30), (0, 0, ANCHO, 85))
        pygame.draw.line(self.pantalla, self.color_tema, (0, 85), (ANCHO, 85), 2)
        
        info_txt = f"SCORE: {self.puntos:05}  |  NIVEL: {self.nivel}  |  VIDAS: {self.vidas}"
        texto = self.fuente_ui.render(info_txt, True, self.color_tema)
        self.pantalla.blit(texto, (ANCHO//2 - texto.get_width()//2, 35))

        for l in self.ladrillos:
            pygame.draw.rect(self.pantalla, l['color'], l['rect'], border_radius=5)
            borde_color = (255, 255, 255) if self.es_modo_blanco else (255, 255, 255, 100)
            pygame.draw.rect(self.pantalla, borde_color, l['rect'], 1, border_radius=5)

        pygame.draw.rect(self.pantalla, self.color_tema, self.paleta, border_radius=8)
        pygame.draw.circle(self.pantalla, self.color_tema, self.bola.center, 11, 2)
        pygame.draw.circle(self.pantalla, (255, 255, 255), self.bola.center, 7)

        pygame.display.flip()

    def main_loop(self):
        while True:
            for e in pygame.event.get():
                if e.type == pygame.QUIT: pygame.quit(); sys.exit()
                if e.type == pygame.MOUSEBUTTONDOWN:
                    if self.estado == "MENU_COLOR":
                        for rect, color, nombre in self.botones:
                            if rect.collidepoint(e.pos):
                                self.color_tema = color
                                self.es_modo_blanco = (nombre == "BLANCO")
                                self.puntos = 0; self.vidas = 3; self.nivel = 1
                                self.reset_entorno()
                                self.estado = "JUGANDO"

            if self.estado == "MENU_COLOR":
                self.dibujar_menu()
                pygame.display.flip()
            else:
                self.actualizar()
                self.dibujar_juego()
            
            self.reloj.tick(FPS)

if __name__ == "__main__":
    Juego().main_loop()