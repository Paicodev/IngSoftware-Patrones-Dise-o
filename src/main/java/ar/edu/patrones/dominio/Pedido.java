package ar.edu.patrones.dominio;
import java.util.List;
import java.util.Objects;

/** Pedido sobre el que se aplican las estrategias de entrega. */
public final class Pedido {
    private final long id;
    private final String cliente;
    private final List<Pizza> pizzas;
    private EstadoPedido estado;

    public Pedido(long id, String cliente, List<Pizza> pizzas, EstadoPedido estado) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id del pedido debe ser positivo.");
        }
        this.id = id;
        this.cliente = Objects.requireNonNull(cliente, "El cliente es obligatorio.");
        this.pizzas = List.copyOf(Objects.requireNonNull(pizzas, "La lista de pizzas es obligatoria."));
        this.estado = Objects.requireNonNull(estado, "El estado es obligatorio.");
    }

    public long getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = Objects.requireNonNull(estado, "El estado es obligatorio.");
    }
}
