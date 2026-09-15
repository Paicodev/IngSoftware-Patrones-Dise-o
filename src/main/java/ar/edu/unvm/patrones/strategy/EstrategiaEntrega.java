package ar.edu.unvm.patrones.strategy;

import ar.edu.unvm.patrones.dominio.Pedido;

/** Contrato común para calcular el costo de una modalidad de entrega. */
public interface EstrategiaEntrega {
    double calcularCosto(Pedido pedido);
}
