package ar.edu.patrones.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un pedido realizado por un cliente en la pizzería.
 */
public class Pedido {
    private String id;
    private String cliente;
    private List<Pizza> pizzas;
    private EstadoPedido estado;

    public Pedido(String id, String cliente, List<Pizza> pizzas, EstadoPedido estado) {
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas != null ? new ArrayList<>(pizzas) : new ArrayList<>();
        this.estado = estado != null ? estado : EstadoPedido.RECIBIDO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas != null ? new ArrayList<>(pizzas) : new ArrayList<>();
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido[id='" + id + "', cliente='" + cliente + "', pizzas=" + pizzas + ", estado=" + estado + "]";
    }
}
