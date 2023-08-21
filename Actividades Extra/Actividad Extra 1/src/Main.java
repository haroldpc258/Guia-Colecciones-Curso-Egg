import tienda.productos.entidades.Producto;
import tienda.productos.servicios.ProductoService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        ProductoService service = new ProductoService();
        ArrayList<Producto> inventarioProductos = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n-------- MENÚ --------");
            System.out.println("1. Crear producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Mostar inventario de productos");
            System.out.println("5. Vender producto");
            System.out.println("6. Reponer producto");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    inventarioProductos = service.agregarProductosInventario(inventarioProductos);
                    break;
                case 2:
                    if (!inventarioProductos.isEmpty()) {
                        service.eliminarProducto(inventarioProductos);
                    } else {
                        System.out.println("\nNo hay ningún producto para eliminar.");
                    }
                    break;
                case 3:
                    if (!inventarioProductos.isEmpty()) {
                        service.actualizarProducto(inventarioProductos);
                    } else {
                        System.out.println("\nNo hay ningún producto para actualizar.");
                    }
                    break;
                case 4:
                    if (!inventarioProductos.isEmpty())
                        service.mostrarProductos(inventarioProductos);
                    else {
                        System.out.println("\nNo hay ningún producto para mostrar.");
                    }
                    break;
                case 5:
                    if (!inventarioProductos.isEmpty())
                        service.ventaProducto(inventarioProductos);
                    else {
                        System.out.println("\nNo hay ningún producto para vender.");
                    }
                    break;
                case 6:
                    if (!inventarioProductos.isEmpty())
                        service.reposicionProducto(inventarioProductos);
                    else {
                        System.out.println("\nNo hay ningún producto para reponer.");
                    }
                    break;
                default:
                    System.out.println("\nLa opción no es válida. Inténtelo nuevamente.");

            }
        } while (opcion != 0);

        System.out.println("\nHasta pronto...");
    }
}