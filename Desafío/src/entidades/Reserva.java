package entidades;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Reserva {

    private Integer id;
    private Habitacion habitacionReserva;
    private Persona personaReserva;
    private Integer cantidadPersonas;
    private LocalDate fechaLlegada;
    private LocalDate fechaSalida;


    public Reserva() {
        habitacionReserva = new Habitacion();
        personaReserva = new Persona();
    }

    public Reserva(Integer id, Habitacion habitacionReserva, Persona personaReserva, Integer cantidadPersonas) {
        this.id = id;
        this.habitacionReserva = habitacionReserva;
        this.personaReserva = personaReserva;
        this.cantidadPersonas = cantidadPersonas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Habitacion getHabitacionReserva() {
        return habitacionReserva;
    }

    public void setHabitacionReserva(Habitacion habitacionReserva) {
        this.habitacionReserva = habitacionReserva;
    }

    public Persona getPersonaReserva() {
        return personaReserva;
    }

    public void setPersonaReserva(Persona personaReserva) {
        this.personaReserva = personaReserva;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva reserva)) return false;
        return Objects.equals(getId(), reserva.getId()) && Objects.equals(getHabitacionReserva(), reserva.getHabitacionReserva()) && Objects.equals(getPersonaReserva(), reserva.getPersonaReserva()) && Objects.equals(getCantidadPersonas(), reserva.getCantidadPersonas()) && Objects.equals(getFechaLlegada(), reserva.getFechaLlegada()) && Objects.equals(getFechaSalida(), reserva.getFechaSalida());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHabitacionReserva(), getPersonaReserva(), getCantidadPersonas(), getFechaLlegada(), getFechaSalida());
    }

    public static Comparator<Reserva> ordenarPorFecha() {
        return new Comparator<Reserva>() {
            @Override
            public int compare(Reserva r1, Reserva r2) {
                return r1.getFechaLlegada().compareTo(r2.getFechaLlegada());
            }
        };
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "| Cantidad de Personas: " + cantidadPersonas +
                "| Fecha de Llegada: " + fechaLlegada +
                "| Fecha de Salida: " + fechaSalida + habitacionReserva + personaReserva;
    }
}
