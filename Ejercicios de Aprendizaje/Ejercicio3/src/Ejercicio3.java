import ejercicio3.entidades.Alumno;
import ejercicio3.servicios.AlumnoService;

import java.util.ArrayList;

public class Ejercicio3 {
    public static void main(String[] args) {

        AlumnoService service = new AlumnoService();
        ArrayList<Alumno> alumnos = new ArrayList<>();
        service.fabricaAlumnos(alumnos);
        service.mostrarAlumnos(alumnos);
        Double notaFinal = service.notaFinal(alumnos);
    }


}