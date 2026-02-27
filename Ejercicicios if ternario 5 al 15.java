import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a, b, c: ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        double d = Math.pow(b, 2) - 4 * a * c;

        String resultado = (d > 0) ? "Dos raíces: " + ((-b + Math.sqrt(d)) / (2 * a)) + " y " + ((-b - Math.sqrt(d)) / (2 * a)) :
                          (d == 0) ? "Raíz única: " + (-b / (2 * a)) : "Sin raíces reales";
        System.out.println(resultado);
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número: ");
        int n = sc.nextInt();
        System.out.println(n % 2 == 0 ? "Es Par" : "Es Impar");
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Año: ");
        int y = sc.nextInt();
        System.out.println(((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) ? "Bisiesto" : "No bisiesto");
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: "); String nom = sc.nextLine();
        System.out.print("Edad: "); int ed = sc.nextInt();
        System.out.println(ed >= 70 ? nom + " tiene PRIORIDAD" : nom + " espera turno normal");
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N1, N2, N3: ");
        double n1 = sc.nextDouble(), n2 = sc.nextDouble(), n3 = sc.nextDouble();
        double mayor = (n1 >= n2 && n1 >= n3) ? n1 : (n2 >= n3 ? n2 : n3);
        System.out.println("El mayor es: " + mayor);
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Lados: ");
        double l1 = sc.nextDouble(), l2 = sc.nextDouble(), l3 = sc.nextDouble();
        String tipo = (l1 == l2 && l2 == l3) ? "Equilátero" : (l1 == l2 || l1 == l3 || l2 == l3 ? "Isósceles" : "Escaleno");
        System.out.println("Tipo: " + tipo);
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: "); String n = sc.nextLine();
        System.out.print("Peso y Altura: ");
        double p = sc.nextDouble(), h = sc.nextDouble();
        double imc = p / (h * h);
        String cat = (imc < 18.5) ? "Bajo peso" : (imc < 25 ? "Normal" : (imc < 30 ? "Sobrepeso" : "Obesidad"));
        System.out.println(n + " tiene " + cat + " (IMC: " + String.format("%.2f", imc) + ")");
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N1, N2 y Op: ");
        double n1 = sc.nextDouble(), n2 = sc.nextDouble();
        char op = sc.next().charAt(0);
        Object res = (op == '+') ? n1+n2 : (op == '-') ? n1-n2 : (op == '*') ? n1*n2 : (op == '/' && n2 != 0) ? n1/n2 : "Error";
        System.out.println("Resultado: " + res);
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nota (0-100): ");
        int nota = sc.nextInt();
        char letra = (nota >= 90) ? 'A' : (nota >= 80 ? 'B' : (nota >= 70 ? 'C' : (nota >= 60 ? 'D' : 'F')));
        System.out.println("Calificación: " + letra);
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Día (1-7): ");
        int d = sc.nextInt();
        String dia = (d==1)?"Lun":(d==2)?"Mar":(d==3)?"Mie":(d==4)?"Jue":(d==5)?"Vie":(d==6)?"Sab":(d==7)?"Dom":"Invalido";
        System.out.println(dia);
    }
}

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Lados A, B, C: ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        String res = (a+b>c && a+c>b && b+c>a) ? ((a==b && b==c) ? "Equilátero" : (a==b || a==c || b==c ? "Isósceles" : "Escaleno")) : "No es triángulo";
        System.out.println(res);
    }
}