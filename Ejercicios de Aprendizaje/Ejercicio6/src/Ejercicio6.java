import entidades.Producto;
import servicios.ProductoService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Map<String, Double> inventarioProductos = new HashMap<>();

        ProductoService service = new ProductoService();

        int opcion;
        do{
            System.out.println("\n----------- MENÚ -----------");
            System.out.println("1. Introducir un producto");
            System.out.println("2. Modificar el precio de un producto");
            System.out.println("3. Eliminar un producto");
            System.out.println("4. Mostrar lista de productos");
            System.out.println("0. Salir");
            System.out.print("\nSeleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    inventarioProductos = service.agregarAlInventario(inventarioProductos, service.crearProducto());
                    break;
                case 2:
                    if (!inventarioProductos.isEmpty()) {
                        inventarioProductos = service.modificarPrecioProducto(inventarioProductos);
                    } else {
                        System.out.println("\nNo existe ningún producto para modificar.");
                    }
                    break;
                case 3:
                    if (!inventarioProductos.isEmpty()) {
                        inventarioProductos = service.eliminarProducto(inventarioProductos);
                    } else {
                        System.out.println("\nNo existe ningún producto para eliminar.");
                    }
                    break;
                case 4:
                    if (!inventarioProductos.isEmpty()) {
                        service.mostrarProductos(inventarioProductos);
                    } else {
                        System.out.println("\nNo hay productos para mostrar.");
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