package servicio;

import entidades.Habitacion;
import entidades.Reserva;

import java.time.LocalDate;
import java.util.*;

public class ReservaService {

    Scanner scanner;
    int id;

    public ReservaService() {
        scanner = new Scanner(System.in).useDelimiter("\n");
        id = 1;
    }

    public Reserva crearReserva(PersonaService ps, List<Habitacion> habDisponibles) {

        System.out.println("\nCREANDO RESERVA.");

        Reserva nuevaReserva = new Reserva();

        System.out.print("¿Para cuántas personas desea la habitación?: ");
        nuevaReserva.setCantidadPersonas(scanner.nextInt());

        if (nuevaReserva.getCantidadPersonas() > 3) {
            System.out.println("\nLo siento, no disponemos de habitaciones con la capacidad para este número de personas. \n" +
                    "Considere distribursen en las habitaciones disponibles.");
            return null;
        }

        System.out.println("\nInformación fecha de llegada.");
        System.out.print("Ingrese el día: ");
        int dia = scanner.nextInt();
        System.out.print("Ingrese el mes: ");
        int mes = scanner.nextInt();
        System.out.print("Ingrese el año: ");
        int annio = scanner.nextInt();

        nuevaReserva.setFechaLlegada(LocalDate.of(annio, mes, dia));

        System.out.println("\nInformación fecha de salida.");
        System.out.print("Ingrese el día: ");
        dia = scanner.nextInt();
        System.out.print("Ingrese el mes: ");
        mes = scanner.nextInt();
        System.out.print("Ingrese el año: ");
        annio = scanner.nextInt();

        nuevaReserva.setFechaSalida(LocalDate.of(annio, mes, dia));

        nuevaReserva.setId(id);
        Habitacion habitacion = asignarHabitacion(nuevaReserva, habDisponibles);
        if (habitacion == null)
            return null;

        nuevaReserva.setHabitacionReserva(habitacion);

        nuevaReserva.setPersonaReserva(ps.crearPersona());

        id++;

        System.out.println("\nLa reserva se ha creado correctamente...");
        return nuevaReserva;
    }

    public Habitacion asignarHabitacion(Reserva nuevaReserva, List<Habitacion> habDisponibles) {

        for (Habitacion hab : habDisponibles) {

            if (hab.getCapacidadPersonas().equals(nuevaReserva.getCantidadPersonas())) {

                if (hab.getReservaciones().isEmpty()) {
                    hab.getReservaciones().add(nuevaReserva);
                    return hab;
                }

                Iterator<Reserva> it = hab.getReservaciones().iterator();
                Reserva previewReserva = null;

                while (it.hasNext()) {

                    Reserva currentReserva = it.next();
                    if (previewReserva == null && nuevaReserva.getFechaSalida().isBefore(currentReserva.getFechaLlegada())) {
                        hab.getReservaciones().add(nuevaReserva);
                        return hab;
                    }

                    if (previewReserva != null) {
                        if (nuevaReserva.getFechaSalida().isBefore(currentReserva.getFechaLlegada()) && nuevaReserva.getFechaLlegada().isAfter(previewReserva.getFechaSalida())) {
                            hab.getReservaciones().add(nuevaReserva);
                            return hab;
                        }
                    }
                    previewReserva = currentReserva;
                }

                if (nuevaReserva.getFechaLlegada().isAfter(previewReserva.getFechaSalida())) {
                    hab.getReservaciones().add(nuevaReserva);
                    return hab;
                }
            }
        }

        System.out.println("\nLo siento, no hay habitaciones disponibles para este número de personas en esta fecha :( ...");

        return null;
    }

    public Map<Integer, Reserva> modificarReserva(Map<Integer, Reserva> reservaciones, List<Habitacion> habitaciones, PersonaService ps) {

        System.out.println("\nMODIFICANDO RESERVA.");
        System.out.print("Ingrese el ID de la reservación a modificar: ");
        Integer id = scanner.nextInt();

        if (reservaciones.containsKey(id)) {
            Reserva reservaToModificar = reservaciones.get(id);

            reservaToModificar.getHabitacionReserva().getReservaciones().remove(reservaToModificar);

            System.out.println("\nA continuación deberá ingresar nuevamente la información.");
            Reserva reservaModificada = crearReserva(ps, habitaciones);

            if (reservaModificada != null) {

                this.id--;

                reservaModificada.setId(id);
                reservaciones.replace(id, reservaModificada);

                mostrarReserva(reservaModificada);

                System.out.println("\nSe ha realizado la modificación exitosamente...");
            } else {
                reservaToModificar.getHabitacionReserva().getReservaciones().add(reservaToModificar);
                System.out.println("\nNo se pudo registrar la modificación. Inténtelo nuevamente...");
            }
        } else {
            System.out.println("\nNo se ha podido encontrar el ID ingresado. Inténtelo nuevamente...");
        }

        return reservaciones;
    }

    public Map<Integer, Reserva> eliminarReserva(Map<Integer, Reserva> reservaciones) {

        System.out.println("\nELIMINANDO RESERVA.");
        System.out.print("Ingrese el ID de la reservación a eliminar: ");
        Integer id = scanner.nextInt();

        if (reservaciones.containsKey(id)) {
            Reserva reservaEliminar = reservaciones.remove(id);

            reservaEliminar.getHabitacionReserva().getReservaciones().remove(reservaEliminar);

            System.out.println("\nSe ha eliminado exitosamente la reservación...");
            return reservaciones;
        }

        System.out.println("\nNo se ha podido encontrar el ID ingresado. Inténtelo nuevamente...");
        return reservaciones;
    }

    public Map<Integer, Reserva> reservaToAlojamiento(Map<Integer, Reserva> reservaciones, Map<Integer, Reserva> alojamientos) {

        System.out.println("\nALOJAMIENTO.");
        System.out.print("Ingrese el ID de la reservación que la reserva a ocupar: ");
        Integer id = scanner.nextInt();

        if (reservaciones.containsKey(id)) {

            alojamientos.put(id, reservaciones.remove(id));
            System.out.println("\nSe ha ocupado exitosamente la reserva...");
            return alojamientos;
        }

        System.out.println("\nNo se ha podido encontrar el ID ingresado. Inténtelo nuevamente...");
        return alojamientos;
    }

    public void mostrarReserva(Reserva reserva) {
        System.out.println("\nINFORMACIÓN DE LA RESERVA. \n" + reserva.toString());
    }

    public void mostrarListaReservaciones(Map<Integer, Reserva> reservaciones) {

        System.out.println("\nLISTA DE RESERVACIONES.");

        for (Map.Entry<Integer, Reserva> entry : reservaciones.entrySet()) {
            System.out.println(entry.getValue());
        }

        /*for (Reserva reserva : reservaciones.values()) {
            System.out.println("\n" + reserva);
        }*/
    }
}
