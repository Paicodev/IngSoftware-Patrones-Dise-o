package ar.edu.patrones.strategy.estrategias;

import ar.edu.patrones.modelo.Pedido;
import ar.edu.patrones.strategy.EstrategiaEntrega;

import java.util.Objects;

/** El cliente retira el pedido en el local: no hay costo de entrega. */
public final class EntregaRetiro implements EstrategiaEntrega {

    @Override
    public double calcularCosto(Pedido pedido) {
        Objects.requireNonNull(pedido, "El pedido es obligatorio.");
        return 0.0;
    }
}
