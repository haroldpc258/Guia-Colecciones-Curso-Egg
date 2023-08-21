package servicio;

import entidades.Persona;

import java.util.Scanner;

public class PersonaService {

    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Persona crearPersona() {

        System.out.println("\nA continuación deberá ingresar la información de la persona que está realizando la reserva.");
        Persona personaReserva = new Persona();

        System.out.print("Ingrese el nombre: ");
        personaReserva.setNombre(scanner.next());

        System.out.print("Ingrese la edad: ");
        personaReserva.setEdad(scanner.nextInt());

        System.out.print("Ingrese el número de identificación: ");
        personaReserva.setDni(scanner.nextLong());

        System.out.print("Ingrese el país de proveniencia: ");
        personaReserva.setPais(scanner.next());

        return personaReserva;
    }
}
