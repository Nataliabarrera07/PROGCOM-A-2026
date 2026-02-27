
import java.lang.Math;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese a: ");
        double a = sc.nextDouble();

        System.out.print("Ingrese b: ");
        double b = sc.nextDouble();

        System.out.print("Ingrese c: ");
        double c = sc.nextDouble();

        double disc = Math.pow(b, 2) - 4 * a * c;

        if (disc > 0) {
            double x1 = (-b + Math.sqrt(disc)) / (2 * a);
            double x2 = (-b - Math.sqrt(disc)) / (2 * a);
            System.out.println("x1: " + x1 + ", x2: " + x2);
        } else if (disc == 0) {
            double x = -b / (2 * a);
            System.out.println("x: " + x);
        } else {
            System.out.println("No tiene raíces reales.");
        }

    }
    }

import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        // Creamos el objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // Solicitamos el número
        System.out.print("Introduce un número entero: ");
        int num = sc.nextInt();

        // Estructura if-else para verificar la paridad
        if (num % 2 == 0) {
            System.out.println("El número " + num + " es PAR.");
        } else {
            System.out.println("El número " + num + " es IMPAR.");
        }

        // Es buena práctica cerrar el scanner al finalizar
        sc.close();
    }
}

import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un año: ");
        int anio = sc.nextInt();

        // Aplicamos la lógica bisiesta:
        // (divisible por 4 Y NO por 100) O (divisible por 400)
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            System.out.println("El año " + anio + " es bisiesto.");
        } else {
            System.out.println("El año " + anio + " NO es bisiesto.");
        }

        sc.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitamos el nombre
        System.out.print("Escribe tu nombre: ");
        String nombre = sc.nextLine(); // Usamos nextLine para nombres completos

        // Solicitamos la edad
        System.out.print("Escribe tu edad: ");
        int edad = sc.nextInt();

        // Estructura if-else para determinar la prioridad
        if (edad >= 70) {
            System.out.println("El usuario " + nombre + " pertenece a la TERCERA EDAD.");
            System.out.println("RESULTADO: Se le da prioridad en la fila.");
        } else {
            System.out.println("El usuario " + nombre + " NO pertenece a la tercera edad.");
            System.out.println("RESULTADO: Debe esperar su turno normal.");
        }

        sc.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Clasificador de Triángulos ---");
        System.out.print("Introduce el lado 1: ");
        double l1 = sc.nextDouble();
        
        System.out.print("Introduce el lado 2: ");
        double l2 = sc.nextDouble();
        
        System.out.print("Introduce el lado 3: ");
        double l3 = sc.nextDouble();

        // Lógica de clasificación
        if (l1 == l2 && l2 == l3) {
            // Todos los lados son iguales
            System.out.println("El triángulo es: EQUILÁTERO");
        } else if (l1 == l2 || l1 == l3 || l2 == l3) {
            // Al menos dos lados son iguales
            System.out.println("El triángulo es: ISÓSCELES");
        } else {
            // Todos los lados son diferentes
            System.out.println("El triángulo es: ESCALENO");
        }

        sc.close();
    }
}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Entrada de datos
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su peso en kg: ");
        double peso = sc.nextDouble();

        System.out.print("Ingrese su altura en metros (ej. 1.75): ");
        double altura = sc.nextDouble();

        // 2. Cálculo del IMC
        double imc = peso / (altura * altura);

        // 3. Variables para los resultados
        String categoria = "";
        String recomendacion = "";

        // 4. Lógica de clasificación (Estructura if - else if - else)
        if (imc < 18.5) {
            categoria = "Bajo peso";
            recomendacion = "Es recomendable aumentar la ingesta calórica con alimentos nutritivos.";
        } else if (imc >= 18.5 && imc < 25) {
            categoria = "Normal";
            recomendacion = "¡Felicidades! Mantén una dieta equilibrada y actividad física regular.";
        } else if (imc >= 25 && imc < 30) {
            categoria = "Sobrepeso";
            recomendacion = "Considera reducir el consumo de azúcares y aumentar el ejercicio cardiovascular.";
        } else {
            categoria = "Obesidad";
            recomendacion = "Es muy importante consultar con un médico o nutricionista para un plan de salud.";
        }

        // 5. Impresión final de resultados
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Usuario: " + nombre);
        System.out.println("IMC obtenido: " + String.format("%.2f", imc)); // Limita a 2 decimales
        System.out.println("Categoría: " + categoria);
        System.out.println("Recomendación: " + recomendacion);

        sc.close();
    }
}



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Calculadora Simple ---");
        
        System.out.print("Introduce el primer número: ");
        double n1 = sc.nextDouble();
        
        System.out.print("Introduce el segundo número: ");
        double n2 = sc.nextDouble();
        
        System.out.print("Introduce la operación (+, -, *, /): ");
        // Leemos la operación como un String y tomamos el primer carácter
        char operacion = sc.next().charAt(0);

        // Lógica de la calculadora
        if (operacion == '+') {
            System.out.println("Resultado de la suma: " + (n1 + n2));
        } else if (operacion == '-') {
            System.out.println("Resultado de la resta: " + (n1 - n2));
        } else if (operacion == '*') {
            System.out.println("Resultado de la multiplicación: " + (n1 * n2));
        } else if (operacion == '/') {
            // Validación para evitar la división por cero
            if (n2 != 0) {
                System.out.println("Resultado de la división: " + (n1 / n2));
            } else {
                System.out.println("Error: No se puede dividir entre cero.");
            }
        } else {
            System.out.println("Error: Operación no reconocida.");
        }

        sc.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la nota numérica (0-100): ");
        double nota = sc.nextDouble();

        // Lógica de calificación con rangos
        if (nota < 0 || nota > 100) {
            System.out.println("Error: La nota debe estar entre 0 y 100.");
        } else if (nota >= 90) {
            System.out.println("Calificación: A");
        } else if (nota >= 80) {
            System.out.println("Calificación: B");
        } else if (nota >= 70) {
            System.out.println("Calificación: C");
        } else if (nota >= 60) {
            System.out.println("Calificación: D");
        } else {
            System.out.println("Calificación: F");
        }

        sc.close();
    }
}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número del 1 al 7: ");
        int dia = sc.nextInt();

        // Estructura if - else if para los días de la semana
        if (dia == 1) {
            System.out.println("El día es: Lunes");
        } else if (dia == 2) {
            System.out.println("El día es: Martes");
        } else if (dia == 3) {
            System.out.println("El día es: Miércoles");
        } else if (dia == 4) {
            System.out.println("El día es: Jueves");
        } else if (dia == 5) {
            System.out.println("El día es: Viernes");
        } else if (dia == 6) {
            System.out.println("El día es: Sábado");
        } else if (dia == 7) {
            System.out.println("El día es: Domingo");
        } else {
            // Caso para números fuera del rango 1-7
            System.out.println("Error: El número ingresado no corresponde a un día de la semana.");
        }

        sc.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Validación y Tipo de Triángulo ---");
        System.out.print("Lado A: ");
        double a = sc.nextDouble();
        System.out.print("Lado B: ");
        double b = sc.nextDouble();
        System.out.print("Lado C: ");
        double c = sc.nextDouble();

        // 1. Validamos si el triángulo existe
        // La suma de dos lados siempre debe ser mayor al tercero
        if (a + b > c && a + c > b && b + c > a) {
            
            // 2. Si es válido, determinamos el tipo (Anidamos otro if-else)
            if (a == b && b == c) {
                System.out.println("Resultado: Es un triángulo EQUILÁTERO válido.");
            } else if (a == b || a == c || b == c) {
                System.out.println("Resultado: Es un triángulo ISÓSCELES válido.");
            } else {
                System.out.println("Resultado: Es un triángulo ESCALENO válido.");
            }
            
        } else {
            // Si no cumple la condición matemática inicial
            System.out.println("Resultado: Los números ingresados NO pueden formar un triángulo.");
        }

        sc.close();
    }
}