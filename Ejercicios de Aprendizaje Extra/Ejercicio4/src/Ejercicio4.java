import entidades.Ciudad;
import servicios.CiudadService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        CiudadService service = new CiudadService();

        Map<Integer, String> mapaCiudades = new HashMap<>();

        int opcion;
        do{
            System.out.println("\n----------- MENÚ -----------");
            System.out.println("1. Agregar Ciudad");
            System.out.println("2. Eliminar Ciudad");
            System.out.println("3. Buscar Ciudad");
            System.out.println("4. Mostrar Ciudades");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    service.agregarCiudad(mapaCiudades, service.crearCiudad());
                    break;
                case 2:
                    if (!mapaCiudades.isEmpty()) {
                        mapaCiudades = service.eliminarCiudad(mapaCiudades);
                    } else {
                        System.out.println("\nNo existe ninguna ciudad para eliminar.");
                    }
                    break;
                case 3:
                    if (!mapaCiudades.isEmpty()) {
                        service.buscarCiudad(mapaCiudades);
                    } else {
                        System.out.println("\nEl mapa de ciudades esta vacío.");
                    }
                    break;
                case 4:
                    if (!mapaCiudades.isEmpty()) {
                        service.mostrarCiudades(mapaCiudades);
                    } else {
                        System.out.println("\nNo hay ciudades para mostrar.");
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