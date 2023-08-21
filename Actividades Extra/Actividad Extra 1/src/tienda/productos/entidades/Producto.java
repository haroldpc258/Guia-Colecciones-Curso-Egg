package tienda.productos.entidades;

public class Producto {

    String nombre;
    String catergoria;
    Double precio;
    Integer cantidad;

    public Producto() {
    }

    public Producto(String nombre, String catergoria, Double precio, Integer cantidad) {
        this.nombre = nombre;
        this.catergoria = catergoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCatergoria() {
        return catergoria;
    }

    public void setCatergoria(String catergoria) {
        this.catergoria = catergoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{ " +
                "nombre='" + nombre + '\'' +
                ", catergoria='" + catergoria + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}' +
                "\n";
    }
}
