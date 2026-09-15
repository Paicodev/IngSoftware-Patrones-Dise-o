package ar.edu.patrones.dominio;
import java.util.Objects;

/** Evento mínimo reservado para la posterior implementación de Observer. */
public record EventoPedido(String tipo, Pedido pedido) {

    public EventoPedido {
        Objects.requireNonNull(tipo, "El tipo de evento es obligatorio.");
        Objects.requireNonNull(pedido, "El pedido afectado es obligatorio.");
    }
}
