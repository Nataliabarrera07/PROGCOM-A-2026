import tkinter as tk
from tkinter import messagebox
import random

COLOR_FONDO = "#1e1e1e"
COLOR_BOTONES = "#333333"
COLOR_TEXTO = "#ffffff"
COLOR_TITULO = "#00adb5"
COLOR_VICTORIA = "#00ff7f"
COLOR_DERROTA = "#ff4d4d"

class JuegoPPTLS:
    def __init__(self, root):
        self.root = root
        self.root.title("PPTLS Pro - Extended Edition")
        self.root.geometry("600x550")
        self.root.configure(bg=COLOR_FONDO)

        
        self.reglas = {
            "Piedra 🪨": ["Tijeras ✂️", "Lagarto 🦎"],
            "Papel 📄": ["Piedra 🪨", "Spock 🖖"],
            "Tijeras ✂️": ["Papel 📄", "Lagarto 🦎"],
            "Lagarto 🦎": ["Papel 📄", "Spock 🖖"],
            "Spock 🖖": ["Piedra 🪨", "Tijeras ✂️"]
        }
        self.opciones = list(self.reglas.keys())

    
        self.modo = 0  # 1 o 2 jugadores
        self.nombre_p1 = ""
        self.nombre_p2 = ""
        self.eleccion_p1 = ""
        self.turno = 1

       
        self.main_frame = tk.Frame(self.root, bg=COLOR_FONDO)
        self.main_frame.pack(expand=True, fill="both")

        self.mostrar_menu_inicio()

    def limpiar_pantalla(self):
        for widget in self.main_frame.winfo_children():
            widget.destroy()

    def mostrar_menu_inicio(self):
        self.limpiar_pantalla()
        tk.Label(self.main_frame, text="PIEDRA, PAPEL, TIJERAS,\nLAGARTO, SPOCK", 
                 font=("Arial", 20, "bold"), bg=COLOR_FONDO, fg=COLOR_TITULO).pack(pady=30)
        
        tk.Button(self.main_frame, text="1 Jugador (vs CPU)", font=("Arial", 12), width=20, bg=COLOR_BOTONES, 
                  fg=COLOR_TEXTO, command=lambda: self.pantalla_nombres(1)).pack(pady=10)
        
        tk.Button(self.main_frame, text="2 Jugadores (Turnos)", font=("Arial", 12), width=20, bg=COLOR_BOTONES, 
                  fg=COLOR_TEXTO, command=lambda: self.pantalla_nombres(2)).pack(pady=10)

    def pantalla_nombres(self, modo):
        self.modo = modo
        self.limpiar_pantalla()
        
        tk.Label(self.main_frame, text="Registro de Jugadores", font=("Arial", 16), 
                 bg=COLOR_FONDO, fg=COLOR_TITULO).pack(pady=20)

        
        tk.Label(self.main_frame, text="Nombre Jugador 1:", bg=COLOR_FONDO, fg=COLOR_TEXTO).pack()
        self.ent_p1 = tk.Entry(self.main_frame, justify='center', font=("Arial", 12))
        self.ent_p1.pack(pady=5)
        self.ent_p1.insert(0, "Jugador 1")

        
        self.ent_p2 = None
        if modo == 2:
            tk.Label(self.main_frame, text="Nombre Jugador 2:", bg=COLOR_FONDO, fg=COLOR_TEXTO).pack()
            self.ent_p2 = tk.Entry(self.main_frame, justify='center', font=("Arial", 12))
            self.ent_p2.pack(pady=5)
            self.ent_p2.insert(0, "Jugador 2")

        tk.Button(self.main_frame, text="CONTINUAR", bg=COLOR_VICTORIA, fg=COLOR_FONDO, 
                  font=("Arial", 10, "bold"), command=self.iniciar_juego).pack(pady=20)

    def iniciar_juego(self):
        self.nombre_p1 = self.ent_p1.get() or "Jugador 1"
        if self.modo == 2:
            self.nombre_p2 = self.ent_p2.get() or "Jugador 2"
        else:
            self.nombre_p2 = "Computadora"
        
        self.jugar_ronda()

    def jugar_ronda(self):
        self.limpiar_pantalla()
        self.eleccion_p1 = ""
        self.turno = 1
        
        self.lbl_turno = tk.Label(self.main_frame, text=f"Turno de: {self.nombre_p1}", 
                                  font=("Arial", 14, "bold"), bg=COLOR_FONDO, fg=COLOR_TITULO)
        self.lbl_turno.pack(pady=20)

        self.btn_container = tk.Frame(self.main_frame, bg=COLOR_FONDO)
        self.btn_container.pack(pady=10)

        
        for opt in self.opciones:
            tk.Button(self.btn_container, text=opt, width=12, bg=COLOR_BOTONES, fg=COLOR_TEXTO,
                      activebackground=COLOR_TITULO, command=lambda o=opt: self.procesar_eleccion(o)).pack(pady=3)

        self.lbl_info = tk.Label(self.main_frame, text="Selecciona tu movimiento", 
                                 bg=COLOR_FONDO, fg=COLOR_TEXTO, font=("Arial", 10, "italic"))
        self.lbl_info.pack(pady=20)

    def procesar_eleccion(self, eleccion):
        if self.modo == 1:
            
            computadora = random.choice(self.opciones)
            self.mostrar_resultado(eleccion, computadora)
        else:
            
            if self.turno == 1:
                self.eleccion_p1 = eleccion
                self.turno = 2
                self.lbl_turno.config(text=f"Turno de: {self.nombre_p2}")
                self.lbl_info.config(text=f"{self.nombre_p1} ya eligió. ¡No hagas trampa!", fg=COLOR_VICTORIA)
            else:
                self.mostrar_resultado(self.eleccion_p1, eleccion)

    def mostrar_resultado(self, p1, p2):
        self.limpiar_pantalla()
        
        resultado_texto = ""
        color_final = COLOR_TEXTO

        if p1 == p2:
            resultado_texto = f"¡EMPATE! 🤝\nAmbos eligieron {p1}"
        elif p2 in self.reglas[p1]:
            resultado_texto = f"¡GANÓ {self.nombre_p1.upper()}! 🎉\n{p1} vence a {p2}"
            color_final = COLOR_VICTORIA
        else:
            resultado_texto = f"¡GANÓ {self.nombre_p2.upper()}! 💀\n{p2} vence a {p1}"
            color_final = COLOR_DERROTA

        tk.Label(self.main_frame, text=resultado_texto, font=("Arial", 16, "bold"), 
                 bg=COLOR_FONDO, fg=color_final, justify="center").pack(expand=True)

        
        if messagebox.askyesno("Fin de la ronda", "¿Deseas continuar jugando?"):
            self.jugar_ronda()
        else:
            self.mostrar_menu_inicio()

if __name__ == "__main__":
    ventana = tk.Tk()
    app = JuegoPPTLS(ventana)
    ventana.mainloop()