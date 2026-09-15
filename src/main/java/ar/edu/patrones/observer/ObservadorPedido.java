package ar.edu.patrones.observer;

import ar.edu.patrones.modelo.EventoPedido;

/**
 * Interfaz para los observadores interesados en recibir actualizaciones sobre pedidos.
 */
public interface ObservadorPedido {
    void actualizar(EventoPedido evento);
}
