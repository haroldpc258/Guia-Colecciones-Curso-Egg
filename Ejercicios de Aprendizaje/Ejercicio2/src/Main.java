import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> razasPerro = new ArrayList<>();

        System.out.println("\nRAZAS DE PERRO.");

        while (true) {

            System.out.print("\nIngrese una raza de perro: ");
            razasPerro.add(scanner.nextLine());

            System.out.print("\nDesea seguir ingresando razas (s/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("s"))
                break;
        }

        System.out.print("Ingrese una de las razas almacenadas anteriormente: ");
        String razaEliminar = scanner.nextLine();

        /*for (String raza : razasPerro) {
            if (raza.equalsIgnoreCase(razaEliminar)) {
                razasPerro.remove(raza);
            }
        }*/

        boolean encontre = false;
        Iterator<String> it = razasPerro.iterator();
        while (it.hasNext()) {

            String raza = it.next();
            if (raza.equalsIgnoreCase(razaEliminar)) {
                it.remove();
                encontre = true;
            }
        }

        if(!encontre) {
            System.out.println("No se encontró la raza en la lista.");
        }

        razasPerro.sort(null);
        System.out.println(razasPerro);
    }
}