import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        int suma = 99;
        do {
            System.out.print("\nIngrese un número: ");
            Integer nuevoNumero = scanner.nextInt();

            numeros.add(nuevoNumero);
            suma += nuevoNumero;
        } while (numeros.get(numeros.size() - 1) != -99);

        numeros.remove(numeros.size() - 1);

        System.out.println("\nLISTA DE NÚMEROS.");
        System.out.println(numeros);

        System.out.println("\nEl número de valores ingresados es: " + suma);
        System.out.println("\nLa suma de los número es: " + suma);
        System.out.println("\nEl promedio es: " + (double) suma/numeros.size());
    }
}