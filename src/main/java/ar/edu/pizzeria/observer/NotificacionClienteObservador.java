package ar.edu.pizzeria.observer;

import ar.edu.pizzeria.modelo.EventoPedido;
import ar.edu.pizzeria.modelo.Pedido;

/**
 * Observador concreto encargado de notificar al cliente sobre el estado de su pedido.
 */
public class NotificacionClienteObservador implements ObservadorPedido {

    @Override
    public void actualizar(EventoPedido evento) {
        if (evento == null || evento.getPedido() == null) {
            return;
        }

        Pedido pedido = evento.getPedido();
        System.out.println("[NOTIFICACIÓN CLIENTE] Estimado/a " + pedido.getCliente() 
                + ", su pedido #" + pedido.getId() 
                + " ha cambiado de estado a: " + pedido.getEstado());
    }
}
