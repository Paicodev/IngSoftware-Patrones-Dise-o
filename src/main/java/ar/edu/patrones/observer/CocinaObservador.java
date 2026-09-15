package ar.edu.patrones.observer;

import ar.edu.patrones.modelo.EstadoPedido;
import ar.edu.patrones.modelo.EventoPedido;
import ar.edu.patrones.modelo.Pedido;

/**
 * Observador concreto que representa la estación de cocina.
 * Reacciona cuando un pedido ingresa o comienza a prepararse.
 */
public class CocinaObservador implements ObservadorPedido {

    @Override
    public void actualizar(EventoPedido evento) {
        if (evento == null || evento.getPedido() == null) {
            return;
        }

        Pedido pedido = evento.getPedido();
        EstadoPedido estado = pedido.getEstado();

        if (estado == EstadoPedido.RECIBIDO) {
            System.out.println("[COCINA] Pedido #" + pedido.getId() + " recibido para cliente " 
                    + pedido.getCliente() + ". Pizzas a preparar: " + pedido.getPizzas());
        } else if (estado == EstadoPedido.EN_PREPARACION) {
            System.out.println("[COCINA] Pedido #" + pedido.getId() + " en preparación en el horno.");
        }
    }
}
