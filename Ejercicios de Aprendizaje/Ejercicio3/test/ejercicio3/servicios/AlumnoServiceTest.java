package ejercicio3.servicios;

import ejercicio3.entidades.Alumno;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class AlumnoServiceTest {

    AlumnoService as;
    InputStream originalSystemIn;

    @BeforeEach
    void setUp() {
        as = new AlumnoService();
        originalSystemIn = System.in;
    }

    @Test
    @DisplayName("Verifica si el objeto se crea correctamente")
    void crearAlumno() {
        // Prepare input
        String input = "John Doe\n" +
                "3\n" +
                "7\n" +
                "8\n" +
                "9\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        AlumnoService alumnoService = new AlumnoService();
        Alumno alumno = alumnoService.crearAlumno();


        Assertions.assertNotNull(alumno);
        Assertions.assertEquals("John Doe", alumno.getNombre());
        Assertions.assertEquals(3, alumno.getNotas().size());
        Assertions.assertEquals(7, alumno.getNotas().get(0));
        Assertions.assertEquals(8, alumno.getNotas().get(1));
        Assertions.assertEquals(9, alumno.getNotas().get(2));
    }

    @Test
    @DisplayName("Verifica si el alumno se agrega a la lista")
    void agregarAlumno() {

        ArrayList<Alumno> alumnos = new ArrayList<>();

        Alumno nuevoAlumno = new Alumno("Nuevo");
        nuevoAlumno.setNotas(new ArrayList<>(Arrays.asList(7, 8, 9)));

        as.agregarAlumno(alumnos, nuevoAlumno);

        Assertions.assertEquals(1, alumnos.size());
        Assertions.assertSame(nuevoAlumno, alumnos.get(0));
    }

    @Test
    void fabricaAlumnos() {
    }

    @Test
    void mostrarAlumnos() {
    }

    @Test
    void notaFinal() {
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
    }
}