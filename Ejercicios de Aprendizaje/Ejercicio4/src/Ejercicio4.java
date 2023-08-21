import entidades.Pelicula;
import servicios.PeliculaService;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ejercicio4 {
    public static void main(String[] args) {

        PeliculaService service = new PeliculaService();
        LinkedList<Pelicula> inventarioPelicula= new LinkedList<>();

        inventarioPelicula.add(new Pelicula("Avatar", "James Cameron", 162.5));
        inventarioPelicula.add(new Pelicula("Inception", "Christopher Nolan", 148.2));
        inventarioPelicula.add(new Pelicula("The Godfather", "Francis Ford Coppola", 175.0));
        inventarioPelicula.add(new Pelicula("Interstellar", "Christopher Nolan", 169.5));
        inventarioPelicula.add(new Pelicula("Forrest Gump", "Robert Zemeckis", 142.0));
        inventarioPelicula.add(new Pelicula("The Shawshank Redemption", "Frank Darabont", 142.0));
        inventarioPelicula.add(new Pelicula("Titanic", "James Cameron", 195.0));


        inventarioPelicula = service.creacionPeliculas(inventarioPelicula);
        service.mostrarPeliculas(inventarioPelicula);

        service.mostrarPeliculas(service.filtrarPorDuracion(inventarioPelicula));

        inventarioPelicula = service.ordenarPorDuracion(inventarioPelicula);
        service.mostrarPeliculas(inventarioPelicula);

        inventarioPelicula = service.ordenarPorTitulo(inventarioPelicula);
        service.mostrarPeliculas(inventarioPelicula);

        inventarioPelicula = service.ordenarPorDirector(inventarioPelicula);
        service.mostrarPeliculas(inventarioPelicula);
    }
}