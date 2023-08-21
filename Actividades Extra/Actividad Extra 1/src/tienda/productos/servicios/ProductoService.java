package tienda.productos.servicios;

import tienda.productos.entidades.Producto;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductoService {

    Scanner scanner;

    public ProductoService() {
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public Producto crearProducto() {

        Producto nuevoProducto = new Producto();

        System.out.println("\nCREANDO NUEVO PRODUCTO.");

        System.out.print("Ingrese el Nombre: ");
        nuevoProducto.setNombre(scanner.next());

        System.out.print("Ingrese la Categoría: ");
        nuevoProducto.setCatergoria(scanner.next());

        System.out.print("Ingrese el Precio: ");
        nuevoProducto.setPrecio(scanner.nextDouble());

        System.out.print("Ingrese la cantidad en Inventario: ");
        nuevoProducto.setCantidad(scanner.nextInt());

        return nuevoProducto;
    }

    public ArrayList<Producto> agregarProductosInventario(ArrayList<Producto> inventarioProductos) {

        inventarioProductos.add(crearProducto());
        return inventarioProductos;
    }

    public void mostrarProductos(ArrayList<Producto> inventarioProductos) {

        System.out.println(inventarioProductos.toString());
    }

    public ArrayList<Producto> eliminarProducto(ArrayList<Producto> inventarioProductos) {

        System.out.print("\nIngrese el nombre del producto que desea eliminar: ");
        String productoEliminar = scanner.next();

        Producto producto = buscarPorNombre(inventarioProductos, productoEliminar);

        if (producto != null) {
            inventarioProductos.remove(producto);
            return inventarioProductos;
        }

        System.out.println("No es posible eliminar un producto que no existe en la tienda.");
        return inventarioProductos;
    }

    public ArrayList<Producto> actualizarProducto(ArrayList<Producto> inventarioProductos) {

        System.out.print("\nIngrese el nombre del producto que desea actualizar: ");
        String productoActualizar = scanner.next();

        Producto producto = buscarPorNombre(inventarioProductos, productoActualizar);

        if (producto != null) {
            inventarioProductos.set(inventarioProductos.indexOf(producto), crearProducto());
            return inventarioProductos;
        }

        System.out.println("No es posible actualizar un producto que no existe en la tienda.");
        return inventarioProductos;
    }


    public Producto buscarPorNombre(ArrayList<Producto> inventarioProductos, String productoBuscar) {

        for (Producto producto : inventarioProductos) {
            if (producto.getNombre().equalsIgnoreCase(productoBuscar)) {
                return producto;
            }
        }
        return null;
    }
    public boolean ventaProducto(ArrayList<Producto> inventarioProductos) {

        System.out.print("\nIngrese el nombre del producto que desea vender: ");
        String productoVender = scanner.next();

        Producto producto = buscarPorNombre(inventarioProductos, productoVender);

        if (producto != null) {
            if (producto.getCantidad() > 0) {
                producto.setCantidad(producto.getCantidad() - 1);
                return true;
            } else {
                System.out.println("\nLo siento. En el momento no hay ejemplares de este producto.");
                return false;
            }
        }

        System.out.println("\nLo siento, no existe este producto en la tienda.");
        return false;
    }

    public void reposicionProducto(ArrayList<Producto> inventarioProductos) {

        System.out.print("\nIngrese el nombre del producto que desea reponer: ");
        String productoReponer = scanner.next();

        Producto producto = buscarPorNombre(inventarioProductos, productoReponer);

        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + 1);
        } else {
            System.out.println("No puede reponer un producto que no existe en la tienda.");
        }
    }
}

