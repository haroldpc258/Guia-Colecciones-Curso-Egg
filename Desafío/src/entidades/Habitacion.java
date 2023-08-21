package entidades;

import java.util.*;

public class Habitacion {

    private Integer numero;
    private Integer capacidadPersonas;
    private Set<Reserva> reservaciones;


    public Habitacion() {
        reservaciones = new TreeSet<>(Reserva.ordenarPorFecha());
    }

    public Habitacion(Integer numero, Integer capacidadPersonas) {
        this.numero = numero;
        this.capacidadPersonas = capacidadPersonas;
        reservaciones = new TreeSet<>(Reserva.ordenarPorFecha());
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(Integer capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    public Set<Reserva> getReservaciones() {
        return reservaciones;
    }

    public void setReservaciones(Set<Reserva> reservaciones) {
        this.reservaciones = reservaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Habitacion that)) return false;
        return Objects.equals(getNumero(), that.getNumero()) && Objects.equals(getCapacidadPersonas(), that.getCapacidadPersonas()) && Objects.equals(getReservaciones(), that.getReservaciones());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero(), getCapacidadPersonas(), getReservaciones());
    }

    @Override
    public String toString() {
        return "\nInformación de la Habitación: " +
                "\nNúmero: " + numero +
                "| Capacidad de Personas: " + capacidadPersonas;
    }
}
