import entidades.Pais;
import servicios.PaisService;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio5 {
    public static void main(String[] args) {

        PaisService service = new PaisService();
        Set<Pais> paises = new HashSet<>();

        paises = service.crearPaises(paises);
        service.mostrarPaises(paises);

        paises = service.ordenarPaises(paises);
        service.mostrarPaises(paises);

        service.eliminarPais(paises);
        service.mostrarPaises(paises);
    }
}