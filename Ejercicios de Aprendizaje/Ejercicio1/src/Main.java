import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> razasPerro = new ArrayList<>();

        System.out.println("\nRAZAS DE PERRO.");

        do {

            System.out.print("\nIngrese una raza de perro: ");
            razasPerro.add(scanner.nextLine());

            System.out.print("\nDesea seguir ingresando razas (s/n): ");
        } while (scanner.nextLine().equalsIgnoreCase("s"));

        System.out.println(razasPerro);
    }
}