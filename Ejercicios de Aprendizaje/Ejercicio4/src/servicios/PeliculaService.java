package servicios;

import entidades.Pelicula;

import java.util.*;

public class PeliculaService {

    Scanner scanner;

    public PeliculaService() {
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public LinkedList<Pelicula> creacionPeliculas(LinkedList<Pelicula> inventarioPeliculas) {

        System.out.println("\nCREANDO PELÍCULAS...");

         do {
            Pelicula nuevaPelicula = new Pelicula();
            System.out.print("\nIngrese el titulo: ");
            nuevaPelicula.setTitulo(scanner.next());

            System.out.print("Ingrese el nombre del director: ");
            nuevaPelicula.setDirector(scanner.next());

            System.out.print("Ingrese la duración en horas: ");
            nuevaPelicula.setDuracion(scanner.nextDouble());

            inventarioPeliculas.add(nuevaPelicula);
            System.out.println("\nLa película se ha registrado exitosamente...");
            System.out.print("\nDesea crear una nueva Película? (s/n): ");

        } while (scanner.next().equalsIgnoreCase("s"));

         return inventarioPeliculas;
    }

    public void mostrarPeliculas(LinkedList<Pelicula> inventarioPeliculas) {

        int indice = 1;
        System.out.println("\nINVENTARIO DE PELÍCULAS.");
        for (Pelicula pelicula : inventarioPeliculas) {
            System.out.println(indice + ". " + pelicula.toString());
            indice++;
        }
    }

    public LinkedList<Pelicula> filtrarPorDuracion(LinkedList<Pelicula> inventarioPeliculas) {

        System.out.println("\nFILTRANDO POR DURACIÓN.");
        LinkedList<Pelicula> inventarioFiltrado = new LinkedList<>();
        System.out.print("Ingrese la duración mínima que desea buscar: ");
        Double duracionFiltrar = scanner.nextDouble();

        for (Pelicula p : inventarioPeliculas) {
            if (p.getDuracion() >= duracionFiltrar) {
                inventarioFiltrado.add(p);
            }
        }

        return inventarioFiltrado;
    }

    public LinkedList<Pelicula> ordenarPorDuracion(LinkedList<Pelicula> inventarioPeliculas) {

        //inventarioPeliculas.sort((p1, p2) -> p1.getDuracion().compareTo(p2.getDuracion()));
        //inventarioPeliculas.sort(Comparator.comparing(Pelicula::getDuracion));

        inventarioPeliculas.sort(new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula p1, Pelicula p2) {
                return p1.getDuracion().compareTo(p2.getDuracion());
            }
        });

        System.out.println("\nSe ha ordenado por Duración.");

        return inventarioPeliculas;
    }

    public LinkedList<Pelicula> ordenarPorTitulo(LinkedList<Pelicula> inventarioPeliculas) {

        inventarioPeliculas.sort(new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula p1, Pelicula p2) {
                return p1.getTitulo().compareTo(p2.getTitulo());
            }
        });

        System.out.println("\nSe ha ordenado por Título.");

        return inventarioPeliculas;
    }

    public LinkedList<Pelicula> ordenarPorDirector(LinkedList<Pelicula> inventarioPeliculas) {

        inventarioPeliculas.sort(new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula p1, Pelicula p2) {
                return p1.getDirector().compareTo(p2.getDirector());
            }
        });

        System.out.println("\nSe ha ordenado por Director.");

        return inventarioPeliculas;
    }

}
