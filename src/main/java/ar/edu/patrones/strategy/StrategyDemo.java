package ar.edu.patrones.strategy;

import ar.edu.patrones.dominio.EstadoPedido;
import ar.edu.patrones.dominio.Pedido;
import ar.edu.patrones.dominio.Pizza;
import ar.edu.patrones.strategy.estrategias.EntregaDelivery;
import ar.edu.patrones.strategy.estrategias.EntregaRetiro;

import java.util.List;

/** Demuestra que la modalidad de entrega puede cambiar sin modificar el pedido. */
public final class StrategyDemo {
    private StrategyDemo() {
    }

    public static void main(String[] args) {
        Pedido pedido = new Pedido(
                1,
                "Lucía",
                List.of(new Pizza("Muzzarella", 8500.0), new Pizza("Especial", 9800.0)),
                EstadoPedido.RECIBIDO
        );

        ServicioEntrega servicioEntrega = new ServicioEntrega(new EntregaRetiro());
        System.out.printf("Costo por retiro: $%.2f%n", servicioEntrega.calcularCosto(pedido));

        // El contexto conserva el pedido y cambia solamente el algoritmo de cálculo.
        servicioEntrega.setEstrategia(new EntregaDelivery());
        System.out.printf("Costo por delivery: $%.2f%n", servicioEntrega.calcularCosto(pedido));
    }
}
