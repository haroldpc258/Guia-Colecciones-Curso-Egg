package entidades;

public class Libro {

    private String titulo;
    private String autor;
    private Integer numEjemplaresTotales;
    private Integer numEjemplaresPrestados;

    public Libro() {
        numEjemplaresPrestados = 0;
    }

    public Libro(String titulo, String autor, Integer numEjemplaresTotales, Integer numEjemplaresPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.numEjemplaresTotales = numEjemplaresTotales;
        this.numEjemplaresPrestados = numEjemplaresPrestados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumEjemplaresTotales() {
        return numEjemplaresTotales;
    }

    public void setNumEjemplaresTotales(Integer numEjemplaresTotales) {
        this.numEjemplaresTotales = numEjemplaresTotales;
    }

    public Integer getNumEjemplaresPrestados() {
        return numEjemplaresPrestados;
    }

    public void setNumEjemplaresPrestados(Integer numEjemplaresPrestados) {
        this.numEjemplaresPrestados = numEjemplaresPrestados;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numEjemplaresTotales=" + numEjemplaresTotales +
                ", numEjemplaresPrestados=" + numEjemplaresPrestados;
    }
}
