# Análisis del Patrón Observer

​` a. Problema `

- ​En el contexto de la pizzería, el sistema maneja la clase Pedido, la cual transita por distintos estados definidos en EstadoPedido (RECIBIDO, EN PREPARACION, LISTO, ENTREGADO).  
​- El problema principal surge porque múltiples partes del sistema (como la pantalla de la cocina, la aplicación del cliente o el sistema de delivery) necesitan enterarse inmediatamente cuando ocurre un cambio en el estado de un pedido.  
​- Si la clase que gestiona el pedido interactúa directamente con todos estos componentes para avisarles del cambio, se genera un alto nivel de acoplamiento, lo que hace que el código sea rígido, difícil de mantener y propenso a errores al agregar nuevos requerimientos.  
​
` b. Solución `

- ​El patrón Observer resuelve esto definiendo una dependencia de uno a muchos, aislando el estado central (el sujeto) de los objetos que necesitan reaccionar a sus cambios (los observadores).  
​- Para este proyecto, la solución se basa en un contrato común que no debe modificarse: la interfaz ObservadorPedido que expone el método actualizar(EventoPedido evento).  
​- De esta manera, el sujeto (Pedido) mantiene internamente una lista genérica de objetos que implementan ObservadorPedido y, cuando ocurre un cambio de estado, simplemente itera sobre esa lista llamando al método actualizar y pasándole el EventoPedido correspondiente.  
​
` c. Consecuencias`

​Ventajas:
- ​Se promueve un bajo acoplamiento entre el sujeto y los observadores, permitiendo que ambos varíen de forma independiente.  
​- Facilita el cumplimiento del principio de abierto/cerrado, ya que se pueden incorporar nuevos tipos de observadores en el futuro sin necesidad de alterar el código del Pedido.  
​
Desventajas/Implicancias:

- ​Los observadores son notificados de manera implícita, lo que significa que no hay garantías sobre el orden de ejecución y puede ser difícil rastrear el flujo del programa durante la depuración de errores.  
​- Si los observadores no se desvinculan correctamente del sujeto cuando ya no son necesarios, pueden generarse fugas de memoria (memory leaks).