package ar.edu.pizzeria.observer;

import ar.edu.pizzeria.modelo.EstadoPedido;
import ar.edu.pizzeria.modelo.EventoPedido;
import ar.edu.pizzeria.modelo.Pedido;
import ar.edu.pizzeria.modelo.Pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * Demostración independiente del patrón Observer para el sistema de pedidos de la pizzería.
 */
public class ObserverDemo {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("   DEMOSTRACIÓN INDEPENDIENTE: PATRÓN OBSERVER (P5)      ");
        System.out.println("==========================================================\n");

        // 1. Inicializar el Sujeto (GestorPedidos)
        GestorPedidos gestor = new GestorPedidos();

        // 2. Crear los observadores concretos
        CocinaObservador cocina = new CocinaObservador();
        NotificacionClienteObservador notificadorCliente = new NotificacionClienteObservador();
        DeliveryObservador delivery = new DeliveryObservador();

        // 3. Suscribir los observadores al gestor
        gestor.agregarObservador(cocina);
        gestor.agregarObservador(notificadorCliente);
        gestor.agregarObservador(delivery);

        // 4. Crear un pedido de ejemplo con pizzas
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Muzzarella Especial", 8500.0));
        pizzas.add(new Pizza("Fugazzeta Rellena", 9500.0));

        Pedido pedido = new Pedido("PED-101", "Geronimo", pizzas, EstadoPedido.RECIBIDO);

        System.out.println("--- 1. Evento inicial: Notificar Pedido Recibido ---");
        gestor.notificar(new EventoPedido("PEDIDO_RECIBIDO", pedido));

        System.out.println("\n--- 2. Transición: Pedido pasa a EN_PREPARACION ---");
        gestor.cambiarEstado(pedido, EstadoPedido.EN_PREPARACION);

        System.out.println("\n--- 3. Transición: Pedido pasa a LISTO ---");
        gestor.cambiarEstado(pedido, EstadoPedido.LISTO);

        System.out.println("\n--- 4. Transición: Pedido pasa a ENTREGADO ---");
        gestor.cambiarEstado(pedido, EstadoPedido.ENTREGADO);

        // 5. Demostración de desuscripción de observador
        System.out.println("\n--- 5. Desuscribir NotificacionClienteObservador ---");
        gestor.quitarObservador(notificadorCliente);

        Pedido pedido2 = new Pedido("PED-102", "Laura", List.of(new Pizza("Napolitana", 9000.0)), EstadoPedido.RECIBIDO);
        System.out.println("Cambio de estado en pedido PED-102 sin notificación a cliente:");
        gestor.cambiarEstado(pedido2, EstadoPedido.EN_PREPARACION);

        System.out.println("\n==========================================================");
        System.out.println("   FIN DE LA DEMOSTRACIÓN DEL PATRÓN OBSERVER            ");
        System.out.println("==========================================================");
    }
}
