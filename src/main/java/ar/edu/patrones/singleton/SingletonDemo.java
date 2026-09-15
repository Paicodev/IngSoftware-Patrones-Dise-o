package ar.edu.patrones.singleton;

/**
 * Clase de demostración del patrón Singleton.
 */
public final class SingletonDemo {

    public static void main(String[] args) {
        ConfiguracionPizzeria configuracionUno =
                ConfiguracionPizzeria.getInstance();
        ConfiguracionPizzeria configuracionDos =
                ConfiguracionPizzeria.getInstance();

        System.out.println("Pizzería: " + configuracionUno.getNombrePizzeria());
        System.out.println("Preparación estimada: "
                + configuracionUno.getTiempoPreparacionMinutos() + " minutos");
        System.out.println("¿Es la misma instancia? "
                + (configuracionUno == configuracionDos));
    }
}
