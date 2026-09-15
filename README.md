# Plan de organización - proyecto de patrones para una pizzería

## Objetivo del plan

El equipo trabajará con entregas independientes para reducir bloqueos. Cada integrante tendrá una unidad completa de trabajo, con archivos propios y un resultado revisable. La integración final se hará sobre una base común y pequeña.

La independencia no significa que no existan acuerdos: antes de comenzar deben congelarse los nombres de las clases, interfaces y métodos que se muestran en este documento.

## Contratos comunes

### Modelo mínimo

- `Pizza`: nombre y precio.
- `Pedido`: id, cliente, lista de pizzas y estado.
- `EstadoPedido`: `RECIBIDO`, `EN_PREPARACION`, `LISTO`, `ENTREGADO`.
- `EventoPedido`: tipo de evento y pedido afectado.

### Observer

```java
public interface ObservadorPedido {
    void actualizar(EventoPedido evento);
}
```

### Strategy

```java
public interface EstrategiaEntrega {
    double calcularCosto(Pedido pedido);
}
```

Estos contratos se definen al principio y no se cambian durante la integración salvo que todo el grupo lo acuerde.

## División 3 x 3

La división sigue exactamente las tres consignas principales del PDF para cada patrón: diagrama UML, código y análisis. Cada entrega tiene un objetivo claro y puede desarrollarse de forma aislada.

| Integrante | Unidad de trabajo | Archivos sugeridos |
|---|---|---|
| P1 | Diagrama UML de Singleton | `docs/uml/singleton.puml` |
| P2 | Código de Singleton | `ConfiguracionPizzeria.java`, `SingletonDemo.java` |
| P3 | Análisis de Singleton | `docs/analisis/singleton.md` |
| P4 | Diagrama UML de Observer | `docs/uml/observer.puml` |
| P5 | Código de Observer | `GestorPedidos.java`, observadores y `ObserverDemo.java` |
| P6 | Análisis de Observer | `docs/analisis/observer.md` |
| P7 | Diagrama UML de Strategy | `docs/uml/strategy.puml` |
| P8 | Código de Strategy | `ServicioEntrega.java`, estrategias y `StrategyDemo.java` |
| P9 | Análisis de Strategy | `docs/analisis/strategy.md` |

## Cómo se mantiene la independencia

- Los tres responsables de UML pueden trabajar con los contratos y nombres acordados, sin esperar al código.
- Los tres responsables de análisis pueden redactar problema, solución y consecuencias sin esperar a la implementación final.
- Los tres responsables de código trabajan en paquetes separados y cada uno entrega su propia clase de demostración.
- Ningún integrante debe editar el archivo de otro patrón.

Antes de repartir las tareas, una persona prepara una única vez el esqueleto Maven, el `pom.xml`, los paquetes y las clases de dominio mínimas (`Pedido`, `Pizza`, `EstadoPedido` y `EventoPedido`). Esa preparación es el único paso común obligatorio. Después de ese commit inicial, cada integrante trabaja en archivos propios.

Cada patrón tendrá además su propia clase de demostración: `SingletonDemo`, `ObserverDemo` y `StrategyDemo`. Así nadie necesita esperar a que exista un `Main.java` compartido para demostrar su parte. El README final puede reunir los resultados cuando todas las ramas estén integradas.

## Estructura del repositorio

```text
pom.xml
README.md
docs/
  uml/
    singleton.puml
    observer.puml
    strategy.puml
src/
  main/java/
  test/java/
```

Los diagramas `.puml` se suben como código fuente. Si hay tiempo, también se exportan a PNG para incluirlos en el README o en el informe.

## Ramas

```text
main       versión final estable
develop    rama de integración
feature/*  una rama por integrante
```

Ejemplos: `feature/p1-uml-singleton`, `feature/p2-singleton`, `feature/p3-analisis-singleton`, `feature/p4-uml-observer`, `feature/p5-observer`, `feature/p6-analisis-observer`, `feature/p7-uml-strategy`, `feature/p8-strategy` y `feature/p9-analisis-strategy`.

Cada integrante crea su rama desde `develop`, realiza un commit claro y abre un Pull Request hacia `develop`. Nadie trabaja directamente sobre `main`.

## Integración

Los Pull Requests pueden integrarse a medida que lleguen porque los entregables usan archivos distintos. El orden recomendado es:

1. estructura Maven y contratos iniciales;
2. Singleton, Observer y Strategy en cualquier orden;
3. UML y documentación;
4. integración de las tres demostraciones;
5. revisión final del README;
6. merge de `develop` hacia `main`.

Si dos ramas modifican accidentalmente el mismo archivo, se conserva el contrato común y se resuelve el conflicto entre los autores antes de fusionar.

## Maven

El proyecto utilizará Java 17 y Maven. La comprobación mínima será:

```bash
mvn clean package
```

## Exposición

Aunque las entregas sean independientes, la exposición es grupal. Cada integrante debe conocer el problema, los tres patrones, sus roles, una ventaja y una desventaja de cada uno, además de la ejecución del proyecto.

La demostración final será: presentar el alcance, ejecutar Singleton, cambiar el estado de un pedido y mostrar Observer, calcular retiro y delivery con Strategy y explicar una posible extensión.

## Criterio de finalización

El repositorio estará listo cuando cada integrante haya subido un aporte identificable, el proyecto compile con Maven, los tres UML sean compatibles con PlantUML y todos puedan explicar el trabajo completo.
