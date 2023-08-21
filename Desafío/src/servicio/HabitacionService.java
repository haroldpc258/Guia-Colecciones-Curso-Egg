package servicio;

import entidades.Habitacion;

import java.util.ArrayList;

import java.util.List;

public class HabitacionService {


    public List<Habitacion> crearHabitaciones() {

        int numeroHabitaciones = 10;
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();

        for (int i = 1; i <= numeroHabitaciones; i++) {

            if (i < 6) {
                habitaciones.add(new Habitacion(i, 2));
            } else if (i < 9) {
                habitaciones.add(new Habitacion(i, 3));
            } else {
                habitaciones.add(new Habitacion(i, 1));
            }
        }

        return habitaciones;
    }

}
