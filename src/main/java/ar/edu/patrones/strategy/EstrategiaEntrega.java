package ar.edu.patrones.strategy;

import ar.edu.patrones.modelo.Pedido;

/** Contrato común para calcular el costo de una modalidad de entrega. */
public interface EstrategiaEntrega {
    double calcularCosto(Pedido pedido);
}
