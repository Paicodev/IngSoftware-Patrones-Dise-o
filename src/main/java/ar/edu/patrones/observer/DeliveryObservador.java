package ar.edu.patrones.observer;

import ar.edu.patrones.modelo.EstadoPedido;
import ar.edu.patrones.modelo.EventoPedido;
import ar.edu.patrones.modelo.Pedido;

/**
 * Observador concreto que representa el área de despacho y logística / delivery.
 * Reacciona cuando el pedido está listo para salir a reparto y cuando se completa la entrega.
 */
public class DeliveryObservador implements ObservadorPedido {

    @Override
    public void actualizar(EventoPedido evento) {
        if (evento == null || evento.getPedido() == null) {
            return;
        }

        Pedido pedido = evento.getPedido();
        EstadoPedido estado = pedido.getEstado();

        if (estado == EstadoPedido.LISTO) {
            System.out.println("[DELIVERY] Pedido #" + pedido.getId() 
                    + " listo en mostrador. Asignando repartidor para entrega a " + pedido.getCliente() + ".");
        } else if (estado == EstadoPedido.ENTREGADO) {
            System.out.println("[DELIVERY] Pedido #" + pedido.getId() 
                    + " entregado exitosamente al cliente.");
        }
    }
}
