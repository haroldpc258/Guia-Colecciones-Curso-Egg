package entidades;

import java.util.Objects;

public class Persona {

    private String nombre;
    private Integer edad;
    private Long dni;
    private String pais;

    public Persona() {
    }

    public Persona(String nombre, Integer edad, Long dni, String pais) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(getNombre(), persona.getNombre()) && Objects.equals(getEdad(), persona.getEdad()) && Objects.equals(getDni(), persona.getDni()) && Objects.equals(getPais(), persona.getPais());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getEdad(), getDni(), getPais());
    }

    @Override
    public String toString() {
        return "\nInformación de la Persona: " +
                "\nNombre: '" + nombre + '\'' +
                "| Edad: " + edad +
                "| DNI: " + dni +
                "| País: '" + pais + '\'';
    }
}
