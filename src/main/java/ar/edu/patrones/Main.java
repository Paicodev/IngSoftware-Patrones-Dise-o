package ar.edu.patrones;

import java.util.ArrayList;
import java.util.List;

import ar.edu.patrones.modelo.EstadoPedido;
import ar.edu.patrones.modelo.EventoPedido;
import ar.edu.patrones.modelo.Pedido;
import ar.edu.patrones.modelo.Pizza;
import ar.edu.patrones.observer.CocinaObservador;
import ar.edu.patrones.observer.DeliveryObservador;
import ar.edu.patrones.observer.GestorPedidos;
import ar.edu.patrones.observer.NotificacionClienteObservador;
import ar.edu.patrones.singleton.ConfiguracionPizzeria;
import ar.edu.patrones.strategy.ServicioEntrega;
import ar.edu.patrones.strategy.estrategias.EntregaDelivery;
import ar.edu.patrones.strategy.estrategias.EntregaRetiro;

/**
 * Demostración principal integrada de la Pizzería.
 * 
 * Muestra el uso práctico y la interacción de los 3 patrones:
 * 1. SINGLETON : Consulta de la configuración global de la pizzería desde cualquier punto.
 * 2. OBSERVER  : Notificación automática a cocina, cliente y delivery ante cambios de estado.
 * 3. STRATEGY  : Cálculo dinámico de costos de envío (Retiro vs Delivery) sin alterar el Pedido.
 */
public class Main {

    public static void main(String[] args) {
        // -----------------------------------------------------------------------
        // 1. PATRÓN SINGLETON: Configuración global única
        // -----------------------------------------------------------------------
        // Obtenemos la única instancia global de la configuración de la pizzería.
        // En cualquier parte del sistema donde llamemos a getInstance(), obtendremos el mismo objeto.
        ConfiguracionPizzeria config = ConfiguracionPizzeria.getInstance();

        System.out.println("==========================================================================");
        System.out.println("      SISTEMA DE GESTIÓN DE PEDIDOS - " + config.getNombrePizzeria().toUpperCase());
        System.out.println("      Tiempo estimado base de preparación: " + config.getTiempoPreparacionMinutos() + " minutos");
        System.out.println("==========================================================================\n");

        // Demostración técnica de Singleton: verificamos que dos variables apunten al mismo objeto
        ConfiguracionPizzeria configSegundaConsulta = ConfiguracionPizzeria.getInstance();
        System.out.println(">>> [SINGLETON] ¿Misma instancia en todo el sistema? " + (config == configSegundaConsulta));
        System.out.println();

        // -----------------------------------------------------------------------
        // 2. CREACIÓN DE UN PEDIDO DE DOMINIO
        // -----------------------------------------------------------------------
        System.out.println(">>> CREANDO NUEVO PEDIDO...");
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Muzzarella Especial", 8500.0));
        pizzas.add(new Pizza("Fugazzeta Rellena", 9500.0));

        Pedido pedido = new Pedido("PED-2026", "Carlos Gardel", pizzas, EstadoPedido.RECIBIDO);
        System.out.println("Pedido registrado: #" + pedido.getId() + " | Cliente: " + pedido.getCliente());
        System.out.println("Pizzas solicitadas: " + pedido.getPizzas());
        System.out.println("Subtotal de Pizzas: $" + String.format("%.2f", pedido.calcularTotal()));
        System.out.println();

        // -----------------------------------------------------------------------
        // 3. PATRÓN OBSERVER: Registro de áreas interesadas y notificación
        // -----------------------------------------------------------------------
        System.out.println(">>> [OBSERVER] REGISTRANDO OBSERVADORES Y SIMULANDO ESTADOS");
        System.out.println("--------------------------------------------------------------------------");
        GestorPedidos gestor = new GestorPedidos();

        // El Sujeto (GestorPedidos) registra a los observadores (Cocina, Cliente, Delivery)
        gestor.agregarObservador(new CocinaObservador());
        gestor.agregarObservador(new NotificacionClienteObservador());
        gestor.agregarObservador(new DeliveryObservador());

        // Evento 1: Pedido ingresado
        System.out.println("[Paso 1] Notificando pedido recibido:");
        gestor.notificar(new EventoPedido("PEDIDO_RECIBIDO", pedido));
        System.out.println();

        // Evento 2: Cocina empieza a preparar
        System.out.println("[Paso 2] Transición de estado -> EN_PREPARACION:");
        gestor.cambiarEstado(pedido, EstadoPedido.EN_PREPARACION);
        System.out.println();

        // Evento 3: Pedido terminado en cocina
        System.out.println("[Paso 3] Transición de estado -> LISTO:");
        gestor.cambiarEstado(pedido, EstadoPedido.LISTO);
        System.out.println();

        // -----------------------------------------------------------------------
        // 4. PATRÓN STRATEGY: Cálculo del costo según modalidad de entrega
        // -----------------------------------------------------------------------
        System.out.println(">>> [STRATEGY] CÁLCULO DE COSTOS DE ENVÍO Y TOTALES");
        System.out.println("--------------------------------------------------------------------------");
        
        // Creamos el ServicioEntrega configurado inicialmente con la estrategia Retiro en Local
        ServicioEntrega servicioEntrega = new ServicioEntrega(new EntregaRetiro());
        double costoRetiro = servicioEntrega.calcularCosto(pedido);
        System.out.printf("Modalidad A [EntregaRetiro]   => Costo Envío: $%.2f | Total a Pagar: $%.2f%n",
                costoRetiro, pedido.calcularTotal() + costoRetiro);

        // El cliente decide cambiar la forma de entrega a Delivery: cambiamos la estrategia dinámicamente
        servicioEntrega.setEstrategia(new EntregaDelivery());
        double costoDelivery = servicioEntrega.calcularCosto(pedido);
        System.out.printf("Modalidad B [EntregaDelivery] => Costo Envío: $%.2f | Total a Pagar: $%.2f%n",
                costoDelivery, pedido.calcularTotal() + costoDelivery);
        System.out.println();

        // -----------------------------------------------------------------------
        // 5. FINALIZACIÓN DEL PEDIDO (OBSERVER)
        // -----------------------------------------------------------------------
        System.out.println("[Paso 4] Transición final -> ENTREGADO:");
        gestor.cambiarEstado(pedido, EstadoPedido.ENTREGADO);
        System.out.println();

        System.out.println("==========================================================================");
        System.out.println("      PROCESO FINALIZADO EXITOSAMENTE EN " + config.getNombrePizzeria().toUpperCase());
        System.out.println("==========================================================================");
    }
}
