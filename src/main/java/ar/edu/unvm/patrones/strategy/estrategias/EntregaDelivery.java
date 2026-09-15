package ar.edu.unvm.patrones.strategy.estrategias;

import ar.edu.unvm.patrones.dominio.Pedido;
import ar.edu.unvm.patrones.strategy.EstrategiaEntrega;

import java.util.Objects;

/** Calcula delivery con una tarifa base y un adicional por cada pizza del pedido. */
public final class EntregaDelivery implements EstrategiaEntrega {
    private static final double TARIFA_BASE = 500.0;
    private static final double ADICIONAL_POR_PIZZA = 100.0;

    @Override
    public double calcularCosto(Pedido pedido) {
        Objects.requireNonNull(pedido, "El pedido es obligatorio.");
        return TARIFA_BASE + ADICIONAL_POR_PIZZA * pedido.getPizzas().size();
    }
}
