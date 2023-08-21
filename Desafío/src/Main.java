import entidades.Habitacion;
import entidades.Reserva;
import servicio.HabitacionService;
import servicio.PersonaService;
import servicio.ReservaService;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {

        HabitacionService hs = new HabitacionService();
        PersonaService ps = new PersonaService();
        ReservaService rs = new ReservaService();
        List<Habitacion> habitaciones = hs.crearHabitaciones();
        Map<Integer, Reserva> reservaciones = new HashMap<>();
        Map<Integer, Reserva> alojamientos = new HashMap<>();

        menu(hs, ps, rs, habitaciones, reservaciones, alojamientos);
    }

    public static void menu(HabitacionService hs, PersonaService ps, ReservaService rs, List<Habitacion> habitaciones, Map<Integer, Reserva> reservaciones, Map<Integer, Reserva> alojamientos) {

        int opcion;
        do{
            System.out.println("\n----------- MENÚ -----------");
            System.out.println("1. Crear una Reservación");
            System.out.println("2. Modificar una Reservación");
            System.out.println("3. Eliminar una Reservación");
            System.out.println("4. Reserva a Alojamiento");
            System.out.println("5. Mostrar Reservación");
            System.out.println("6. Mostrar lista de Reservaciones");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Reserva nuevaReserva = rs.crearReserva(ps, habitaciones);
                    if (nuevaReserva != null) {
                        reservaciones.put(nuevaReserva.getId(), nuevaReserva);
                        rs.mostrarReserva(nuevaReserva);
                    } else {
                        System.out.println("\nNo se pudo registrar la reservación...");
                    }
                    break;
                case 2:
                    if (!reservaciones.isEmpty()) {
                        reservaciones = rs.modificarReserva(reservaciones, habitaciones, ps);
                    } else {
                        System.out.println("\nEn el momento no hay ninguna reservación existente.");
                    }
                    break;
                case 3:
                    if (!reservaciones.isEmpty()) {
                        reservaciones = rs.eliminarReserva(reservaciones);
                    } else {
                        System.out.println("\nEn el momento no hay ninguna reservación existente.");
                    }
                    break;
                case 4:
                    if (!reservaciones.isEmpty()) {
                        alojamientos = rs.reservaToAlojamiento(reservaciones, alojamientos);
                    } else {
                        System.out.println("\nEn el momento no hay ninguna reservación existente.");
                    }
                    break;
                case 5:
                    if (!reservaciones.isEmpty()) {
                        System.out.print("\nIngrese el ID de la reserva que desea visualizar: ");
                        Integer id = scanner.nextInt();

                        if (reservaciones.containsKey(id)) {
                            rs.mostrarReserva(reservaciones.get(id));
                        }
                        else {
                            System.out.println("\nVerifique el ID ingresado e inténtelo de nuevo.");
                        }
                    } else {
                        System.out.println("\nNo hay reservas para mostrar.");
                    }
                    break;
                case 6:
                    if (!reservaciones.isEmpty()) {
                        rs.mostrarListaReservaciones(reservaciones);
                    } else {
                        System.out.println("\nNo hay reservas para mostrar.");
                    }
                    break;
                case 0:
                    System.out.println("\nHasta pronto...");
                    break;
                default:
                    System.out.println("\nLa opción no es válida. Inténtelo nuevamente.");
            }

            System.out.println();
            for (Habitacion habitacion : habitaciones) {
                System.out.println(habitacion.getReservaciones());
            }

        } while (opcion != 0);
    }
}