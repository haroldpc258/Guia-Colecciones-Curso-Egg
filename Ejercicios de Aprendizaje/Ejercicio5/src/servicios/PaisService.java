package servicios;

import entidades.Pais;

import java.util.*;

public class PaisService {

    Scanner scanner;

    public PaisService() {
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public Set<Pais> crearPaises(Set<Pais> paises) {

        System.out.println("\nCREANDO PAÍSES...");

        do {
            Pais nuevoPais = new Pais();
            System.out.print("\nIngrese el nombre del país: ");
            nuevoPais.setNombre(scanner.next());

            paises.add(nuevoPais);
            System.out.println("\nEl país se ha registrado exitosamente...");
            System.out.print("\nDesea crear un nuevo País? (s/n): ");

        } while (scanner.next().equalsIgnoreCase("s"));

        return paises;
    }

    public void mostrarPaises(Set<Pais> paises) {

        int indice = 1;
        System.out.println("\nLISTA DE PAÍSES CREADOS.");
        for (Pais pais : paises) {
            System.out.println(indice + ". " + pais.toString());
            indice++;
        }
    }

    public TreeSet<Pais> ordenarPaises(Set<Pais> paises) {

        TreeSet<Pais> paisesOrdenados = new TreeSet<>(new Comparator<Pais>() {
            @Override
            public int compare(Pais o1, Pais o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        });

        paisesOrdenados.addAll(paises);

        return paisesOrdenados;
    }

    public Set<Pais> eliminarPais(Set<Pais> paises) {

        System.out.print("\nIngrese el nombre de un país a eliminar: ");
        String paisEliminar = scanner.next();

        Iterator<Pais> it = paises.iterator();

        while (it.hasNext()) {

            if (it.next().getNombre().equalsIgnoreCase(paisEliminar)) {
                it.remove();
                return paises;
            }
        }

        System.out.println("\nNo se encontró el país que desea eliminar.");
        return paises;
    }


}
