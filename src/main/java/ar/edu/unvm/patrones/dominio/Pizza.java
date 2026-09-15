package ar.edu.unvm.patrones.dominio;

import java.util.Objects;

/** Pizza del pedido, identificada por su nombre y precio unitario. */
public record Pizza(String nombre, double precio) {

    public Pizza {
        Objects.requireNonNull(nombre, "El nombre de la pizza es obligatorio.");
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la pizza no puede estar vacío.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio de la pizza no puede ser negativo.");
        }
    }
}
