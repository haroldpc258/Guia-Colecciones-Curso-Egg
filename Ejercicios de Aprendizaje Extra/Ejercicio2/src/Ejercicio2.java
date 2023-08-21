import entidades.CantanteFamoso;
import servicios.CantanteFamosoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        CantanteFamosoService service = new CantanteFamosoService();
        List<CantanteFamoso> listaCantantes = new ArrayList<>();

        listaCantantes.add(new CantanteFamoso("Michael Jackson", "Thriller"));
        listaCantantes.add(new CantanteFamoso("Madonna", "The Immaculate Collection"));
        listaCantantes.add(new CantanteFamoso("Elvis Presley", "Elvis' Christmas Album"));
        listaCantantes.add(new CantanteFamoso("Mariah Carey", "Music Box"));
        listaCantantes.add(new CantanteFamoso("The Beatles", "Sgt. Pepper's Lonely Hearts Club Band"));

        int opcion;
        do{
            System.out.println("\n----------- MENÚ -----------");
            System.out.println("1. Ingresar un nuevo Cantante");
            System.out.println("2. Eliminar un Cantante");
            System.out.println("3. Mostrar lista de Cantantes");
            System.out.println("0. Salir");
            System.out.print("\nSeleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listaCantantes = service.agregarCantante(listaCantantes);
                    break;
                case 2:
                    if (!listaCantantes.isEmpty()) {
                        listaCantantes = service.eliminarCantante(listaCantantes);
                    } else {
                        System.out.println("\nNo existe ningún cantante para eliminar de la lista.");
                    }
                    break;
                case 3:
                    if (!listaCantantes.isEmpty()) {
                        service.mostrarCantantes(listaCantantes);
                    } else {
                        System.out.println("\nNo hay cantantes para mostrar.");
                    }
                    break;
                case 0:
                    System.out.println("\nHasta pronto...");
                    break;
                default:
                    System.out.println("\nLa opción no es válida. Inténtelo nuevamente.");
            }
        } while (opcion != 0);
    }
}