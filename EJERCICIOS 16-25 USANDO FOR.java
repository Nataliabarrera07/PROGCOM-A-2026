16.
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
System.out.print("Ingresa el número : ");
        int numero = scanner.nextInt();
        System.out.println("Tabla de multiplicar del " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
        System.out.println();

	}
}

17.
//Numeros naturales
        System.out.print("Ingresa el número : ");
        int n = scanner.nextInt();
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        System.out.println("La suma de los números naturales hasta " + n + " es: " + suma);
        System.out.println();

18.
//Calculo de factorial
        System.out.print("Ingresa el número del cual quieres calcular el factorial: ");
        int numero2 = scanner.nextInt();
        int factorial = 1;
        for (int i = 1; i <= numero2; i++) {
            factorial *= i;
        }
        System.out.println("El factorial de " + numero2 + " es: " + factorial);
        System.out.println();

19.
//números de la serie Fibonacci
        System.out.print("Ingresa la cantidad de números de la serie Fibonacci que quieres ver: ");
        int n2 = scanner.nextInt();
        int a = 0, b = 1, c;
        System.out.print("Los primeros " + n2 + " números de la serie Fibonacci son: ");
        for (int i = 0; i < n2; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
        System.out.println();

20.
//Adivina el color
        String[] colores = {"rojo", "verde", "azul", "amarillo", "naranja", "morado", "blanco", "negro", "gris", "rosa"};
        String colorAleatorio = colores[(int)(Math.random() * 10)];
        int intentos = 0;
        boolean adivinado = false;
        while (intentos < 10 && !adivinado) {
            System.out.print("Adivina el color (tienes " + (10 - intentos) + " intentos): ");
            String respuesta = scanner.nextLine().toLowerCase();
            if (respuesta.equals(colorAleatorio)) {
                System.out.println("¡Correcto! El color era " + colorAleatorio);
                adivinado = true;
            } else {
                System.out.println("Incorrecto. Inténtalo de nuevo.");
            }
            intentos++;
        }
        if (!adivinado) {
            System.out.println("Lo siento, no lograste adivinar el color. El color era " + colorAleatorio);
        }
        System.out.println();

21.
//números pares del 1 al 100.
        System.out.println("Los números pares del 1 al 100 son:");
        for (int i = 2; i <= 100; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

22.
//suma de los dígitos de un número.
        System.out.print("Ingresa un número: ");
        int numero3 = scanner.nextInt();
        int suma2 = 0;
        while (numero3 > 0) {
            suma2 += numero3 % 10;
            numero3 /= 10;
        }
        System.out.println("La suma de los dígitos es: " + suma2);
        System.out.println();

23.
//número es primo.
        System.out.print("Ingresa un número: ");
        int numero4 = scanner.nextInt();
        boolean esPrimo = true;
        for (int i = 2; i <= Math.sqrt(numero4); i++) {
            if (numero4 % i == 0) {
                esPrimo = false;
                break;
            }
        }
        if (esPrimo && numero4 > 1) {
            System.out.println(numero4 + " es un número primo.");
        } else {
            System.out.println(numero4 + " no es un número primo.");
        }
        System.out.println();

24.
//patrón de un triángulo con asteriscos.
System.out.println("Patrón de un triángulo con asteriscos:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

25.
//calculo de la potencia de un número 
        System.out.print("Ingresa la base: ");
        int base = scanner.nextInt();
        System.out.print("Ingresa el exponente: ");
        int exponente = scanner.nextInt();
        int resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        System.out.println(base + " elevado a " + exponente + " es: " + resultado);
    }
}