package ar.edu.pizzeria.modelo;

/**
 * Representa una pizza ofrecida en la pizzería.
 */
public class Pizza {
    private String nombre;
    private double precio;

    public Pizza(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}
