package ar.edu.patrones.modelo;
/**
 * Representa una pizza ofrecida en la pizzería.
 */
public class Pizza {
    private String nombre;
    private double precio;

    public Pizza(String nombre, double precio) {
       if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la pizza no puede estar vacío.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio de la pizza no puede ser negativo.");
        }
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
