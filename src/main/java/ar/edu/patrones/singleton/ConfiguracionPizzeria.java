package ar.edu.patrones.singleton;

/**
 * Configuración general y única de la pizzería.
 *
 * <p>La clase aplica el patrón Singleton: su constructor es privado
 * y todas las partes del programa acceden a la misma instancia mediante
 * {@link #getInstance()}.</p>
 */
public final class ConfiguracionPizzeria {

    private static final ConfiguracionPizzeria INSTANCIA =
            new ConfiguracionPizzeria();

    private final String nombrePizzeria;
    private final int tiempoPreparacionMinutos;

    /**
     * Constructor privado para impedir que otras clases creen instancias.
     */
    private ConfiguracionPizzeria() {
        this.nombrePizzeria = "Pizzería La Esquina";
        this.tiempoPreparacionMinutos = 20;
    }

    /**
     * Devuelve la única instancia de la configuración.
     *
     * @return instancia única de {@code ConfiguracionPizzeria}
     */
    public static ConfiguracionPizzeria getInstance() {
        return INSTANCIA;
    }

    /**
     * Obtiene el nombre del local.
     *
     * @return nombre de la pizzería
     */
    public String getNombrePizzeria() {
        return nombrePizzeria;
    }

    /**
     * Obtiene el tiempo estimado de preparación.
     *
     * @return tiempo estimado en minutos
     */
    public int getTiempoPreparacionMinutos() {
        return tiempoPreparacionMinutos;
    }
}
