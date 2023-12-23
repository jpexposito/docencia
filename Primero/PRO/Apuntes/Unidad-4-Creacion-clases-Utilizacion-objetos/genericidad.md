# Genericidad

La genericidad es un concepto en programación que se refiere a la capacidad de escribir código que puede trabajar con diferentes tipos de datos sin tener que especificar los tipos de datos concretos de antemano. Esto facilita la reutilización del código y la creación de estructuras de datos y algoritmos más flexibles y genéricos.

## Ventajas de la Genericidad

1. **Reutilización de Código:** La genericidad permite escribir componentes y algoritmos que se pueden reutilizar con diferentes tipos de datos sin necesidad de duplicar código.

2. **Flexibilidad:** Los componentes genéricos pueden adaptarse a diferentes situaciones, lo que los hace más versátiles.

3. **Seguridad de Tipos:** A pesar de no especificar tipos de datos concretos, los sistemas de tipos de lenguajes de programación fuertes como Java o C# pueden garantizar la seguridad de tipos en tiempo de compilación.

4. **Claridad del Código:** La genericidad puede hacer que el código sea más claro y fácil de entender, ya que los nombres de variables y métodos pueden reflejar mejor su propósito en lugar de centrarse en tipos específicos.

## Ejemplos de Genericidad

### Ejemplo en Java

En Java, la genericidad se logra a través de las clases y métodos genéricos. Por ejemplo, aquí hay una clase genérica que representa una caja que puede contener cualquier tipo de objeto:

```java
public class Caja<T> {
    private T contenido;

    public Caja(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
}
