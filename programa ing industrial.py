import tkinter as tk
from tkinter import ttk, messagebox

class IndustrialApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Industrial Analytics - Monitor de Eficiencia (OEE)")
        self.root.geometry("500x600")
        self.root.configure(bg="#1e1e1e")  # Fondo gris oscuro profesional

        # Estilo para los widgets
        self.style = ttk.Style()
        self.style.theme_use('clam')
        self.style.configure("TLabel", foreground="#ffffff", background="#1e1e1e", font=("Segoe UI", 10))
        self.style.configure("TButton", font=("Segoe UI", 10, "bold"), borderwidth=0)
        
        self.crear_interfaz()

    def crear_interfaz(self):
        # Header
        header = tk.Frame(self.root, bg="#007acc", height=80)
        header.pack(fill="x", pady=(0, 20))
        
        tk.Label(header, text="DASHBOARD DE PRODUCCIÓN", bg="#007acc", fg="white", 
                 font=("Segoe UI", 16, "bold")).pack(pady=20)

        # Contenedor de Entradas
        main_frame = tk.Frame(self.root, bg="#1e1e1e")
        main_frame.pack(padx=30, fill="x")

        # Campos (Etiqueta, Variable)
        self.inputs = {}
        campos = [
            ("Tiempo Total de Turno (min):", "tiempo_total"),
            ("Tiempo de Paradas/Fallas (min):", "paradas"),
            ("Capacidad Nominal (piezas/min):", "capacidad"),
            ("Total de Piezas Producidas:", "total_piezas"),
            ("Piezas Defectuosas:", "defectos")
        ]

        for texto, var_name in campos:
            lbl = ttk.Label(main_frame, text=texto)
            lbl.pack(anchor="w", pady=(10, 0))
            entry = tk.Entry(main_frame, font=("Segoe UI", 11), bg="#333333", fg="white", 
                             insertbackground="white", borderwidth=0)
            entry.pack(fill="x", ipady=5)
            self.inputs[var_name] = entry

        # Botón de Acción
        btn_calc = tk.Button(main_frame, text="ANALIZAR RENDIMIENTO", command=self.calcular_oee,
                            bg="#4caf50", fg="white", relief="flat", cursor="hand2", 
                            font=("Segoe UI", 11, "bold"), pady=10)
        btn_calc.pack(fill="x", pady=30)

        # Panel de Resultados
        self.res_frame = tk.Frame(self.root, bg="#2d2d2d", padx=15, pady=15)
        self.res_frame.pack(fill="x", padx=30)
        
        self.lbl_resultado = tk.Label(self.res_frame, text="Esperando datos...", 
                                     bg="#2d2d2d", fg="#bbbbbb", font=("Segoe UI", 12))
        self.lbl_resultado.pack()

    def calcular_oee(self):
        try:
            # Obtener datos
            t_total = float(self.inputs["tiempo_total"].get())
            t_parada = float(self.inputs["paradas"].get())
            capacidad = float(self.inputs["capacidad"].get())
            total_p = float(self.inputs["total_piezas"].get())
            defectos = float(self.inputs["defectos"].get())

            # 1. Disponibilidad
            t_operativo = t_total - t_parada
            disponibilidad = (t_operativo / t_total) * 100

            # 2. Rendimiento
            piezas_esperadas = t_operativo * capacidad
            rendimiento = (total_p / piezas_esperadas) * 100

            # 3. Calidad
            piezas_ok = total_p - defectos
            calidad = (piezas_ok / total_p) * 100

            # OEE Total
            oee = (disponibilidad/100 * rendimiento/100 * calidad/100) * 100

            # Determinar color según desempeño
            color = "#ff5252" if oee < 60 else "#ffab40" if oee < 85 else "#69f0ae"

            self.lbl_resultado.config(
                text=f"OEE GLOBAL: {oee:.1f}%\n\n"
                     f"Disponibilidad: {disponibilidad:.1f}%\n"
                     f"Rendimiento: {rendimiento:.1f}%\n"
                     f"Calidad: {calidad:.1f}%",
                fg=color, font=("Segoe UI", 13, "bold")
            )

        except Exception as e:
            messagebox.showerror("Error de Datos", "Por favor, llena todos los campos con números válidos.")

if __name__ == "__main__":
    root = tk.Tk()
    app = IndustrialApp(root)
    root.mainloop()