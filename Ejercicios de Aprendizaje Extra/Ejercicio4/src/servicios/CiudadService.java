package servicios;

import entidades.Ciudad;

import java.util.Map;
import java.util.Scanner;

public class CiudadService {

    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Ciudad crearCiudad() {

        Ciudad nuevaCiudad = new Ciudad();
        System.out.println("\nINGRESANDO NUEVA CIUDAD.");

        System.out.print("Ingrese el nombre de la ciudad: ");
        nuevaCiudad.setName(scanner.next());

        System.out.print("Ingrese su código postal: ");
        nuevaCiudad.setPostalCode(scanner.nextInt());

        return nuevaCiudad;
    }

    public Map<Integer, String> agregarCiudad(Map<Integer, String> ciudades, Ciudad nuevaCiudad) {

        ciudades.put(nuevaCiudad.getPostalCode(), nuevaCiudad.getName());
        return ciudades;
    }

    public void mostrarCiudades(Map<Integer, String> ciudades) {

        System.out.println("\nLISTA DE CIUDADES.");
        int indice = 1;
        for (Map.Entry<Integer, String> entry : ciudades.entrySet()) {
            System.out.println(indice + ". Ciudad: " + entry.getValue() + ", Código Postal: " + entry.getKey());
            indice++;
        }
    }

    public void buscarCiudad(Map<Integer, String> ciudades) {

        System.out.println("\nBUSCANDO UNA CIUDAD.");

        System.out.print("Ingrese el cógigo postal de la ciudad a buscar: ");
        Integer codigoBuscando = scanner.nextInt();

        if (ciudades.containsKey(codigoBuscando)) {
            System.out.println("\nLa ciudad que estas buscando es: " + ciudades.get(codigoBuscando));
        } else {
            System.out.println("\nEl código postal no se encuentra registrado...");
        }
    }

    public Map<Integer, String> eliminarCiudad(Map<Integer, String> ciudades) {

        System.out.println("\nELIMINANDO CIUDAD.");

        System.out.print("Ingrese el código postal de la ciudad a eliminar: ");
        Integer codigoEliminar = scanner.nextInt();

        if (ciudades.containsKey(codigoEliminar)) {
            ciudades.remove(codigoEliminar);
            System.out.println("\nLa ciudad se ha eliminado exitosamente...");
        } else {
            System.out.println("\nEl código postal no se encuentra registrado...");
        }

        return ciudades;
    }
}
