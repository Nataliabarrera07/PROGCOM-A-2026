import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Ecuación Cuadrática ---");
        System.out.print("a: "); double a = sc.nextDouble();
        System.out.print("b: "); double b = sc.nextDouble();
        System.out.print("c: "); double c = sc.nextDouble();

        double d = Math.pow(b, 2) - 4 * a * c;

        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        } else if (d == 0) {
            System.out.println("x = " + (-b / (2 * a)));
        } else {
            System.out.println("No tiene soluciones reales.");
        }
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println("Es par");
        } else {
            System.out.println("Es impar");
        }
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Año: ");
        int y = sc.nextInt();

        if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
            System.out.println("Es bisiesto");
        } else {
            System.out.println("No es bisiesto");
        }
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Edad: "); int edad = sc.nextInt();

        if (edad >= 70) {
            System.out.println(nombre + " tiene prioridad en la fila.");
        } else {
            System.out.println(nombre + " turno normal.");
        }
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N1: "); double n1 = sc.nextDouble();
        System.out.print("N2: "); double n2 = sc.nextDouble();
        System.out.print("N3: "); double n3 = sc.nextDouble();

        if (n1 >= n2 && n1 >= n3) System.out.println("Mayor: " + n1);
        else if (n2 >= n1 && n2 >= n3) System.out.println("Mayor: " + n2);
        else System.out.println("Mayor: " + n3);
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Lado 1: "); double l1 = sc.nextDouble();
        System.out.print("Lado 2: "); double l2 = sc.nextDouble();
        System.out.print("Lado 3: "); double l3 = sc.nextDouble();

        if (l1 == l2 && l2 == l3) {
            System.out.println("Es un triángulo Equilátero.");
        } else if (l1 == l2 || l1 == l3 || l2 == l3) {
            System.out.println("Es un triángulo Isósceles.");
        } else {
            System.out.println("Es un triángulo Escaleno.");
        }
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: "); String nom = sc.nextLine();
        System.out.print("Peso (kg): "); double p = sc.nextDouble();
        System.out.print("Altura (m): "); double h = sc.nextDouble();

        double imc = p / (h * h);
        System.out.println(nom + " tu IMC es " + String.format("%.2f", imc));

        if (imc < 18.5) System.out.println("Categoría: Bajo peso. Come más.");
        else if (imc < 25) System.out.println("Categoría: Normal. ¡Bien!");
        else if (imc < 30) System.out.println("Categoría: Sobrepeso. Haz ejercicio.");
        else System.out.println("Categoría: Obesidad. Ve al médico.");
    }
}


import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N1: "); double v1 = sc.nextDouble();
        System.out.print("N2: "); double v2 = sc.nextDouble();
        System.out.print("Operación (+,-,*,/): "); char op = sc.next().charAt(0);

        if (op == '+') System.out.println("Suma: " + (v1 + v2));
        else if (op == '-') System.out.println("Resta: " + (v1 - v2));
        else if (op == '*') System.out.println("Multiplicación: " + (v1 * v2));
        else if (op == '/') {
            if (v2 != 0) System.out.println("División: " + (v1 / v2));
            else System.out.println("Error: Div/0");
        } else System.out.println("Opción inválida.");
    }
}

import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce nota (0-100): ");
        int nota = sc.nextInt();

        if (nota >= 90 && nota <= 100) {
            System.out.println("Calificación: A");
        } else if (nota >= 80) {
            System.out.println("Calificación: B");
        } else if (nota >= 70) {
            System.out.println("Calificación: C");
        } else if (nota >= 60) {
            System.out.println("Calificación: D");
        } else if (nota >= 0 && nota < 60) {
            System.out.println("Calificación: F");
        } else {
            System.out.println("Nota no válida.");
        }
    }
}

import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número del día (1-7): ");
        int dia = sc.nextInt();

        if (dia == 1) System.out.println("Lunes");
        else if (dia == 2) System.out.println("Martes");
        else if (dia == 3) System.out.println("Miércoles");
        else if (dia == 4) System.out.println("Jueves");
        else if (dia == 5) System.out.println("Viernes");
        else if (dia == 6) System.out.println("Sábado");
        else if (dia == 7) System.out.println("Domingo");
        else System.out.println("Error: Solo números del 1 al 7.");
    }
}


mport java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Lado A: "); double a = sc.nextDouble();
        System.out.print("Lado B: "); double b = sc.nextDouble();
        System.out.print("Lado C: "); double c = sc.nextDouble();

        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) System.out.println("Equilátero válido.");
            else if (a == b || a == c || b == c) System.out.println("Isósceles válido.");
            else System.out.println("Escaleno válido.");
        } else {
            System.out.println("No forman un triángulo.");
        }
    }
}