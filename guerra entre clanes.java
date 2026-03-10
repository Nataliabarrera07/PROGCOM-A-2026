import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System. some);
        
        int c = 0;
        double suma = 0;

        System.out.print("Ingrese la cantidad de estudiantes: ");
        int n = sc.nextInt();

        // Creamos un arreglo para almacenar las notas
        double[] notas = new double[n];

        // Primer ciclo: Lectura y suma
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese la nota del estudiante " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
            suma += notas[i];
        }

        double prom = suma / n;

        // Segundo ciclo: Conteo y salida de estudiantes sobre el promedio
        for (int i = 0; i < n; i++) {
            if (notas[i] > prom) {
                c++;
                System.out.println("El estudiante " + (i + 1) + " tiene una nota mayor al promedio");
            }
        }

        System.out.println("El promedio es: " + prom);
        System.out.println("Cantidad de estudiantes sobre el promedio: " + c);
        
        sc.close();
    }
}


import java.util.Scanner;

public class Elecciones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // votos de los 5 candidatos
        int[] votos = {0, 0, 0, 0, 0};

        System.out.print("Cuantos usuarios votan: ");
        int n = sc.nextInt();

        // primera votación
        for (int i = 0; i < n; i++) {
            System.out.print("Vote por un candidato (1-5): ");
            int voto = sc.nextInt();

            if (voto >= 1 && voto <= 5) {
                votos[voto - 1]++;
            } else {
                System.out.println("Voto invalido");
            }
        }

        // mostrar votos
        System.out.println("Resultados primera vuelta:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Candidato " + (i + 1) + ": " + votos[i] + " votos");
        }

        // encontrar los dos mayores
        int primero = 0;
        int segundo = 0;

        for (int i = 0; i < 5; i++) {
            if (votos[i] > votos[primero]) {
                primero = i;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (i != primero && votos[i] > votos[segundo]) {
                segundo = i;
            }
        }

        System.out.println("Pasan a segunda vuelta:");
        System.out.println("Candidato " + (primero + 1));
        System.out.println("Candidato " + (segundo + 1));

        // segunda votación
        int[] votos2 = {0, 0};

        System.out.println("Segunda vuelta");

        for (int i = 0; i < n; i++) {
            System.out.print("Vote por " + (primero + 1) + " o " + (segundo + 1) + ": ");
            int voto = sc.nextInt();

            if (voto == primero + 1) {
                votos2[0]++;
            } else if (voto == segundo + 1) {
                votos2[1]++;
            } else {
                System.out.println("Voto invalido");
            }
        }

        // resultados finales
        System.out.println("Resultados finales:");
        System.out.println("Candidato " + (primero + 1) + ": " + votos2[0] + " votos");
        System.out.println("Candidato " + (segundo + 1) + ": " + votos2[1] + " votos");

        if (votos2[0] > votos2[1]) {
            System.out.println("Ganador: Candidato " + (primero + 1));
        } else {
            System.out.println("Ganador: Candidato " + (segundo + 1));
        }

        sc.close();
    }
}

import java.util.Scanner;

public class Restaurante {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // lista de precios
        int[] precios = {20000, 25000, 18000, 24500, 3000, 7000, 3500, 4000, 2500};

        int total = 0;

        System.out.print("Cuantos clientes hubo hoy: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("Menu");
            System.out.println("1 Combo1");
            System.out.println("2 Combo2");
            System.out.println("3 Combo3");
            System.out.println("4 Combo4");
            System.out.println("5 Papas");
            System.out.println("6 Jugos naturales");
            System.out.println("7 Cerveza");
            System.out.println("8 Agua");
            System.out.println("9 Gaseosa");

            System.out.print("Seleccione una opcion: ");
            int