package ar.edu.pizzeria.observer;

import ar.edu.pizzeria.modelo.EventoPedido;

/**
 * Interfaz para los observadores interesados en recibir actualizaciones sobre pedidos.
 */
public interface ObservadorPedido {
    void actualizar(EventoPedido evento);
}
