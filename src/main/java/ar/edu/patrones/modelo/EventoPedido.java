package ar.edu.patrones.modelo;
/**
 * Evento emitido cuando ocurre un cambio relevante en un pedido.
 */
public class EventoPedido {
    private String tipo;
    private Pedido pedido;

    public EventoPedido(String tipo, Pedido pedido) {
        this.tipo = tipo;
        this.pedido = pedido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "EventoPedido[tipo='" + tipo + "', pedido=" + (pedido != null ? pedido.getId() : "null") + "]";
    }
}
