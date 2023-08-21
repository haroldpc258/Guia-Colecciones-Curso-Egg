package servicios;

import entidades.Libro;

import java.util.Scanner;
import java.util.Set;

public class LibroService {

    Scanner scanner;

    public LibroService() {
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public Libro crearLibro() {

        Libro nuevoLibro = new Libro();
        System.out.println("\nINGRESANDO UN NUEVO LIBRO");

        System.out.print("Ingrese el título del libro: ");
        nuevoLibro.setTitulo(scanner.next());

        System.out.print("Ingrese el nombre del autor: ");
        nuevoLibro.setAutor(scanner.next());

        System.out.print("Ingrese el número de ejemplares Totales: ");
        nuevoLibro.setNumEjemplaresTotales(scanner.nextInt());

        return nuevoLibro;
    }

    public void agregarLibro(Set<Libro> inventarioLibros) {

        inventarioLibros.add(crearLibro());

        System.out.println("\nEl libro se ha ingresado correctamente...");

    }

    public boolean prestamoLibro(Set<Libro> inventarioLibros) {

        System.out.println("\nPRESTANDO UN LIBRO.");
        System.out.print("\nIngrese el nombre el libro a prestar: ");
        String libroPrestar = scanner.next();

        for (Libro libro : inventarioLibros) {
            if (libro.getTitulo().equalsIgnoreCase(libroPrestar)) {
                if (libro.getNumEjemplaresTotales() > libro.getNumEjemplaresPrestados()) {
                    libro.setNumEjemplaresPrestados(libro.getNumEjemplaresPrestados() + 1);
                    System.out.println("\nEl préstamo se ha registrado correctamente...");
                    return true;
                } else {
                    System.out.println("\nLo siento, no hay ejemplares disponibles para prestar...");
                    return false;
                }
            }
        }

        System.out.println("\nLo siento, el libro no se encuentra en la biblioteca...");
        return false;
    }

    public boolean devolucionLibro(Set<Libro> inventarioLibros) {

        System.out.println("\nDEVOLVIENDO UN LIBRO.");
        System.out.print("\nIngrese el nombre el libro a devolver: ");
        String libroDevuelto = scanner.next();

        for (Libro libro : inventarioLibros) {
            if (libro.getTitulo().equalsIgnoreCase(libroDevuelto)) {
                if (libro.getNumEjemplaresPrestados() > 0) {
                    libro.setNumEjemplaresPrestados(libro.getNumEjemplaresPrestados() - 1);
                    System.out.println("\nLa devolución se ha registrado correctamente...");
                    return true;
                } else {
                    System.out.println("\nLo siento, parece que este ejemplar no te lo prestaron en esta biblioteca...");
                    return false;
                }
            }
        }

        System.out.println("\nLo siento, verifica el título del libro que estas devolviendo...");
        return false;
    }

    public void mostrarLibros(Set<Libro> inventarioLibros) {

        System.out.println("\nLISTA DE LIBROS.");
        int indice = 1;
        for (Libro libro : inventarioLibros) {
            System.out.println(indice + ". " + libro.toString());
            indice++;
        }
    }
}
