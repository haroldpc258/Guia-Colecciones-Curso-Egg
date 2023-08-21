package servicios;

import entidades.Producto;

import java.util.Map;
import java.util.Scanner;

public class ProductoService {

    Scanner scanner;

    public ProductoService() {
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public Producto crearProducto() {

        Producto nuevoProducto = new Producto();

        System.out.println("\nINGRESANDO UN NUEVO PRODUCTO...");

        System.out.print("Ingrese el nombre del producto: ");
        nuevoProducto.setNombre(scanner.next());

        System.out.print("Ingrese el precio del producto: ");
        nuevoProducto.setPrecio(scanner.nextDouble());

        return nuevoProducto;
    }

    public Map<String, Double> agregarAlInventario(Map<String, Double> inventarioProductos, Producto nuevoProducto) {

        inventarioProductos.put(nuevoProducto.getNombre(), nuevoProducto.getPrecio());
        System.out.println("\nEl producto ha sido ingresado exitosamente...");

        return inventarioProductos;
    }

    public Map<String, Double> modificarPrecioProducto(Map<String, Double> inventarioProductos) {

        System.out.println("\nESTÁS MODIFICANDO UN PRODUCTO...");
        System.out.print("Ingrese el nombre del producto al cuál desea modificar su precio: ");
        String producto = scanner.next();

        System.out.print("Ingrese el nuevo precio: ");
        Double nuevoPrecio = scanner.nextDouble();

        if (inventarioProductos.containsKey(producto)) {
            inventarioProductos.replace(producto, nuevoPrecio);
            System.out.println("\nEl producto se ha modificado exitosamente...");
        } else {
            System.out.println("\nEl producto que está intentando modificar no existe.");
        }

        return inventarioProductos;
    }

    public Map<String, Double> eliminarProducto(Map<String, Double> inventarioProductos) {

        System.out.println("\nESTÁS ELIMINANDO UN PRODUCTO...");
        System.out.print("Ingrese el nombre del producto que desea eliminar: ");
        String producto = scanner.next();

        if (inventarioProductos.containsKey(producto)) {
            inventarioProductos.remove(producto);
            System.out.println("\nEl producto se ha eliminado exitosamente...");
        } else {
            System.out.println("\nEl producto que está intentando eliminar no existe.");
        }

        return inventarioProductos;
    }

    public void mostrarProductos(Map<String, Double> inventarioProductos) {

        System.out.println("\nLISTA DE PRODUCTOS.");

        int indice = 1;
        for (Map.Entry<String, Double> entry : inventarioProductos.entrySet()) {
            System.out.println(indice + ". " + entry.getKey() + ", Precio: " + entry.getValue());
            indice++;
        }
    }
}
