package ejercicio3.entidades;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

    private String nombre;
    private List<Integer> notas;

    public Alumno() {
        notas = new ArrayList<>();
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
        notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public void setNotas(List<Integer> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", notas=" + notas +
                '}';
    }
}
