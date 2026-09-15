## ANALISIS DEL DISEÑO CREACIONAL SINGLETON
## Contexto y Problema a Resolver
En el sistema de gestión de la pizzería, existen parámetros y configuraciones globales que deben ser consistentes en todo el ciclo de vida de la aplicación. Estos incluyen, por ejemplo:
* Nombre y datos de la sucursal.
* Horarios de atención y estado del local (abierto/cerrado).
* Parámetros operativos (impuestos, cargos base, límites de pedidos simultáneos).

### Problemas de un enfoque sin Singleton:
**Inconsistencia de datos:** Si distintas partes del sistema (gestión de pedidos, facturación, servicios de entrega) instancian sus propios objetos de configuración, cualquier cambio en los parámetros en un módulo no se reflejará en los demás.
**Consumo innecesario de memoria:** Crear múltiples instancias de un componente que solo debe contener un estado global resulta redundante e ineficiente.
**Falta de un punto de acceso unificado:** Sin un mecanismo centralizado, se tiende a pasar la instancia de configuración como parámetro a través de múltiples capas de clases, aumentando el acoplamiento innecesariamente.

---

## Solución Aplicada
Se implementó el patrón **Singleton** mediante la clase `ConfiguracionPizzeria`. Este patrón asegura que:
1. **Instancia Única:** Existe exactamente una sola instancia de `ConfiguracionPizzeria` en toda la aplicación.
2. **Acceso Global:** Provee un método estático público (`getInstance()`) que actúa como el único punto de acceso global a dicha instancia.

### Elementos clave del diseño:
**Constructor privado:** Evita que otras clases utilicen el operador `new ConfiguracionPizzeria()`.
**Atributo estático privado:** Almacena la única referencia de la clase.
**Método de acceso público y estático:** Controla la creación y retorno de la instancia única (inicialización temprana o lazy/perezosa según se requiera).


## Ventajas y Desventajas

### Ventajas:
**Consistencia absoluta:** Todos los módulos que consultan la configuración obtienen exactamente los mismos valores en tiempo de ejecución.
**Control estricto de instanciación:** Se previene la sobrecarga de memoria y la creación descontrolada de instancias duplicadas.
**Inicialización controlada:** Permite inicializar recursos solo cuando realmente se necesitan (si se usa instanciación bajo demanda).

### Desventajas / Puntos a considerar:
**Dificultad en pruebas unitarias (Testing):** Al mantener un estado global y constructores privados, es más complejo aislar las pruebas o sustituir la clase mediante objetos simulados (*mocks*).
**Posible violación del Principio de Responsabilidad Única (SRP):** La clase resuelve dos responsabilidades a la vez: su lógica de negocio (gestionar configuraciones) y el control de su propio ciclo de vida.
**Concurrencia (Thread-Safety):** En entornos multihilo, la creación perezosa (*lazy initialization*) requiere sincronización adecuada para evitar condiciones de carrera (*race conditions*).



## Conexión con la Arquitectura del Proyecto
`ConfiguracionPizzeria` interactúa conceptualmente con el resto de los módulos de la pizzería sirviendo de base informativa para:
**Servicios de Entrega (Strategy):** Consultar tarifas base globales o recargos configurados en el local.
**Gestor de Pedidos (Observer):** Validar si la pizzería se encuentra abierta antes de recibir o despachar eventos de nuevos pedidos.