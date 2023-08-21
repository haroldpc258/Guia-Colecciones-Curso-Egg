package ejercicio3.servicios;

import ejercicio3.entidades.Alumno;

import java.util.ArrayList;
import java.util.Scanner;

public class AlumnoService {

    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public Alumno crearAlumno() {

        Alumno alumno = new Alumno();

        System.out.print("Ingrese el nombre del alumno: ");
        alumno.setNombre(scanner.next());

        System.out.print("\nIngrese la cantidad de notas del alumno: ");
        int cantidad = scanner.nextInt();

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese nota " + (i + 1) + ": ");
            Integer nota = scanner.nextInt();
            alumno.getNotas().add(nota);
        }

        System.out.println("Creación exitosa...");

        return alumno;
    }

    public void agregarAlumno(ArrayList<Alumno> alumnos, Alumno alumno) {
        alumnos.add(alumno);
    }

    public ArrayList<Alumno> fabricaAlumnos(ArrayList<Alumno> alumnos) {

        do {
            System.out.println("\nIngresando un nuevo alumno...");
            Alumno alumno = crearAlumno();
            agregarAlumno(alumnos, alumno);
            System.out.print("\nDesea ingresar un alumno nuevo? (s/n): ");
        } while (scanner.next().equalsIgnoreCase("s"));
        
        return alumnos;
    }

    public void mostrarAlumnos(ArrayList<Alumno> alumnos) {
        System.out.println("\nLista de Alumnos...");
        System.out.println(alumnos.toString());
    }

    public Double notaFinal(ArrayList<Alumno> alumnos) {

        System.out.print("\nIngrese el nombre del alumno a calcular nota: ");
        String nombreAlumno = scanner.next();
        Double notaFinal = 0.0;

        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombreAlumno)) {
                for (Integer nota : alumno.getNotas()) {
                    notaFinal += nota;
                }
                notaFinal = notaFinal/alumno.getNotas().size();
                System.out.println("La nota final del alumno es: " + notaFinal);
                return notaFinal;
            }
        }
        return -1.0;
    }
}
