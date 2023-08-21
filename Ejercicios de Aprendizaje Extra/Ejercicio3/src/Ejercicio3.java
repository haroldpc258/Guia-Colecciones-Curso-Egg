import entidades.Libro;
import servicios.LibroService;

import java.util.*;

public class Ejercicio3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        LibroService service = new LibroService();
        Set<Libro> inventarioLibros = new HashSet<>();

        int opcion;
        do{
            System.out.println("\n----------- MENÚ -----------");
            System.out.println("1. Ingresar un nuevo Libro");
            System.out.println("2. Prestar un Libro");
            System.out.println("3. Devolver un Libro");
            System.out.println("4. Mostrar lista de Libros");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    service.agregarLibro(inventarioLibros);
                    break;
                case 2:
                    if (!inventarioLibros.isEmpty()) {
                        service.prestamoLibro(inventarioLibros);
                    } else {
                        System.out.println("\nNo existe ningún para prestar.");
                    }
                    break;
                case 3:
                    if (!inventarioLibros.isEmpty()) {
                        service.devolucionLibro(inventarioLibros);
                    } else {
                        System.out.println("\nNo existe ningún libro para devolver.");
                    }
                    break;
                case 4:
                    if (!inventarioLibros.isEmpty()) {
                        service.mostrarLibros(inventarioLibros);
                    } else {
                        System.out.println("\nEl inventario de libros está vacío.");
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