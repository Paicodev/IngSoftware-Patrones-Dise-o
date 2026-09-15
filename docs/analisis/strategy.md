# Análisis del patrón Strategy

## Problema

La pizzería puede ofrecer distintas modalidades de entrega. Cada modalidad calcula el costo de una manera diferente: por ejemplo, el retiro en el local no tiene costo y el delivery suma una tarifa. Si el cálculo se resolviera con condicionales dentro de una única clase, cada nueva modalidad obligaría a modificar esa clase y aumentaría el riesgo de afectar las modalidades ya existentes.

Además, la modalidad puede cambiar para un mismo pedido. El sistema necesita seleccionar el algoritmo de cálculo en tiempo de ejecución sin alterar los datos del pedido ni duplicar lógica.

## Solución

Se aplica **Strategy** para encapsular cada algoritmo de cálculo de entrega detrás del contrato común `EstrategiaEntrega`:

```java
double calcularCosto(Pedido pedido);
```

Los participantes de la solución son:

- **EstrategiaEntrega**: interfaz que define la operación común para cualquier forma de entrega.
- **EntregaRetiro**: estrategia concreta que devuelve costo cero, porque el cliente retira el pedido en el local.
- **EntregaDelivery**: estrategia concreta que aplica una tarifa base de $500 y un adicional de $100 por cada pizza del pedido.
- **ServicioEntrega**: contexto que conserva una referencia a la estrategia elegida, delega el cálculo y permite reemplazarla mediante `setEstrategia`.
- **Pedido**: objeto de dominio que aporta las pizzas necesarias para realizar el cálculo.

De este modo, `ServicioEntrega` no necesita conocer los detalles de cada fórmula. En la demostración, el mismo pedido primero usa `EntregaRetiro` y luego cambia a `EntregaDelivery`; solo cambia el algoritmo delegado, no el pedido ni el contexto.

## Consecuencias

### Ventajas

- **Extensibilidad:** se puede agregar, por ejemplo, una estrategia de delivery express o una tarifa por zona implementando la misma interfaz, sin modificar `ServicioEntrega`.
- **Menor acoplamiento:** el contexto depende de la abstracción `EstrategiaEntrega`, no de clases concretas ni de condicionales para cada modalidad.
- **Responsabilidades claras:** cada estrategia concentra una única regla de cálculo, lo que facilita leerla, probarla y modificarla de forma aislada.
- **Variación en tiempo de ejecución:** la modalidad puede cambiar para un pedido sin reconstruir el objeto ni cambiar el código del contexto.

### Desventajas e implicancias

- **Más clases:** para un problema muy pequeño, crear una clase por modalidad puede parecer más complejo que un único condicional.
- **Elección explícita:** otro componente debe decidir qué estrategia corresponde y asignarla al `ServicioEntrega`.
- **Contrato estable:** todas las estrategias deben respetar `calcularCosto(Pedido pedido)` y definir con claridad qué datos del pedido usan.
- **Reglas coherentes:** las tarifas, adicionales y casos especiales deben acordarse con el negocio para que las estrategias no produzcan resultados contradictorios.

## Demostración implementada

`StrategyDemo` crea un pedido con dos pizzas y usa el mismo `ServicioEntrega` con dos estrategias:

1. Con `EntregaRetiro`, el costo mostrado es `$0.00`.
2. Al cambiar a `EntregaDelivery`, el costo es `$700.00`: `$500` de tarifa base más `$100` por cada una de las dos pizzas.

La demostración evidencia el objetivo central del patrón: cambiar el comportamiento de cálculo sin modificar la clase `Pedido` ni la lógica del contexto.

## Posible extensión

Una nueva clase, por ejemplo `EntregaDeliveryExpress`, podría implementar `EstrategiaEntrega` y aplicar una tarifa distinta. No sería necesario editar las estrategias existentes ni `ServicioEntrega`; únicamente se elegiría esa nueva estrategia cuando corresponda.
