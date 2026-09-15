package ar.edu.patrones.observer;

import ar.edu.patrones.modelo.EstadoPedido;
import ar.edu.patrones.modelo.EventoPedido;
import ar.edu.patrones.modelo.Pedido;

import java.util.ArrayList;
import java.util.List;

/**
 * Sujeto observable que gestiona los pedidos y notifica a los observadores
 * ante cualquier cambio en el estado de un pedido.
 */
public class GestorPedidos {
    private final List<ObservadorPedido> observadores;

    public GestorPedidos() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(ObservadorPedido o) {
        if (o != null && !observadores.contains(o)) {
            observadores.add(o);
        }
    }

    public void quitarObservador(ObservadorPedido o) {
        observadores.remove(o);
    }

    public void notificar(EventoPedido evento) {
        for (ObservadorPedido observador : observadores) {
            observador.actualizar(evento);
        }
    }

    public void cambiarEstado(Pedido pedido, EstadoPedido nuevoEstado) {
        if (pedido == null || nuevoEstado == null) {
            throw new IllegalArgumentException("El pedido y el nuevo estado no pueden ser nulos.");
        }
        pedido.setEstado(nuevoEstado);
        EventoPedido evento = new EventoPedido("CAMBIO_ESTADO", pedido);
        notificar(evento);
    }
}
