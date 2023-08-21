package servicios;

import entidades.CantanteFamoso;

import java.util.List;
import java.util.Scanner;

public class CantanteFamosoService {

    Scanner scanner;

    public CantanteFamosoService() {
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public CantanteFamoso crearCantante() {

        System.out.println("\nAgregando un nuevo Cantante Famoso...");

        CantanteFamoso nuevoCantante = new CantanteFamoso();
        System.out.print("\nIngrese el nombre del cantante: ");
        nuevoCantante.setNombre(scanner.next());

        System.out.print("\nIngrese el nombre de su disco con más ventas: ");
        nuevoCantante.setDiscoConMasVentas(scanner.next());

        return nuevoCantante;
    }

    public List<CantanteFamoso> agregarCantante(List<CantanteFamoso> listaCantantes) {

        listaCantantes.add(crearCantante());

        System.out.println("\nSe ha ingresado exitosamente el nuevo Cantante...");

        return listaCantantes;
    }

    public List<CantanteFamoso> eliminarCantante(List<CantanteFamoso> listaCantantes) {

        System.out.println("\nEliminando Cantante.");

        System.out.print("\nIngrese el nombre del cantante a eliminar: ");
        String nombreEliminar = scanner.next();

        for (CantanteFamoso cantante : listaCantantes) {
            if (cantante.getNombre().equalsIgnoreCase(nombreEliminar)) {
                listaCantantes.remove(cantante);
                System.out.println("\nSe ha eliminado exitosamente...");
                return listaCantantes;
            }
        }

        System.out.println("\nNo se ha encontrado este nombre en la lista de cantantes...");
        return listaCantantes;
    }

    public void mostrarCantantes(List<CantanteFamoso> listaCantantes) {

        int indice = 1;
        System.out.println("\nLista de Cantantes Famosos.");
        for (CantanteFamoso cantante : listaCantantes) {
            System.out.println(indice + ". Nombre: " + cantante.getNombre() + ", Disco con más ventas: " + cantante.getDiscoConMasVentas());
            indice++;
        }
    }
}
