package ar.edu.patrones.strategy;

import ar.edu.patrones.dominio.Pedido;

import java.util.Objects;

/** Contexto de Strategy: delega el cálculo en la estrategia elegida. */
public final class ServicioEntrega {
    private EstrategiaEntrega estrategia;

    public ServicioEntrega(EstrategiaEntrega estrategia) {
        setEstrategia(estrategia);
    }

    public void setEstrategia(EstrategiaEntrega estrategia) {
        this.estrategia = Objects.requireNonNull(estrategia, "La estrategia es obligatoria.");
    }

    public double calcularCosto(Pedido pedido) {
        return estrategia.calcularCosto(Objects.requireNonNull(pedido, "El pedido es obligatorio."));
    }
}
