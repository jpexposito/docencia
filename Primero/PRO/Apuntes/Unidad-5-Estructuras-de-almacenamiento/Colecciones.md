<div align="justify">


# Colecciones

ava proporciona una amplia variedad de estructuras de datos a través del framework de Colecciones __(Collections Framework)__. Estas colecciones facilitan el almacenamiento, manipulación y gestión de grupos de objetos. Las principales interfaces y clases relacionadas con colecciones en Java se encuentran en el paquete __java.util__.

## Interfaces Principales del Framework de Colecciones

### Collection

- Representa una colección de objetos. __No garantiza ningún orden específico para sus elementos__.
- Subinterfaces: List, Set, y Queue.

#### List

Colección ordenada que __PERMITE__ elementos duplicados.

>Nota: __Implementaciones notables: ArrayList, LinkedList, y Vector__.

#### Set

Colección que __NO PERMITE__ elementos duplicados. __NO GARANTIZA__ un orden específico.

>Nota: __Implementaciones notables: HashSet, TreeSet, y LinkedHashSet__.

#### Queue

Colección diseñada para mantener una secuencia específica para insertar y acceder a los elementos.

>Nota: __Implementaciones notables:PriorityQueue__.

#### Map

Colección de __pares clave-valor. Cada clave debe ser única__.

>Nota: __Implementaciones notables: HashMap, TreeMap, LinkedHashMap, Hashtable, y Properties__.

## Implementaciones y Características

### ArrayList

Basado en arrays dinámicos.  Permite acceso rápido a los elementos, pero puede ser más lento en operaciones de inserción y eliminación en el medio.

- Ventajas: Tamaño dinámico, acceso rápido, permite elementos duplicados.
- Uso: Cuando se necesite una lista ordenada y se realicen operaciones frecuentes de inserción y acceso.

### LinkedList

Basado en una lista doblemente enlazada.
Ofrece inserciones y eliminaciones rápidas en cualquier posición.

- Ventajas: Inserciones y eliminaciones rápidas en cualquier posición, implementa la interfaz Deque.
- Uso: Cuando se necesite una lista y se realicen operaciones frecuentes de inserción y eliminación en cualquier posición.

###  HashSet
Implementación basada en una tabla hash.
Ofrece operaciones rápidas para agregar, eliminar y comprobar la existencia de un elemento.

- Ventajas: Garantiza elementos únicos, operaciones rápidas de inserción, eliminación y búsqueda.
- Uso: Cuando se necesite una colección sin duplicados y el orden de los elementos no sea importante.

### HashMap

Implementación basada en una tabla hash.
Ofrece acceso rápido a los valores a través de sus claves.

- Ventajas: Almacena pares clave-valor, acceso rápido a los valores a través de las claves, permite claves y valores null.
- Uso: Cuando se necesite asociar claves únicas con valores y realizar operaciones frecuentes de búsqueda, inserción y eliminación.

## Resumen de ventajas y uso

- __ArrayList__: Uso ideal cuando se requiere un acceso rápido a los elementos y se realizan operaciones frecuentes de lectura.
- __LinkedList__: Beneficioso cuando se realizan operaciones frecuentes de inserción y eliminación en cualquier posición, o se necesita una cola o pila.
- __HashSet__: Útil cuando se necesita asegurar que no haya elementos duplicados y el orden no es una preocupación.
- __HashMap__: Esencial para almacenar pares clave-valor y cuando se requiere un acceso rápido a los valores a través de sus claves.

## Características y ejemplos

### ArrayList:

- __Uso__: Cuando necesitas una lista redimensionable y no estás tan preocupado por el acceso rápido aleatorio.
- __Ejemplo__: Almacenar y manejar una lista de nombres de estudiantes en un curso.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> estudiantes = new ArrayList<>();
        estudiantes.add("Juan");
        estudiantes.add("María");
        estudiantes.add("Pedro");

        for (String estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
}
```


### LinkedList:

- __Uso__: Para operaciones de inserción y eliminación frecuentes en la parte media de la lista.
- __Ejemplo__: Implementar una cola o lista doblemente enlazada.

```java

```


### HashSet:

- __Uso__: Cuando necesitas garantizar la unicidad de elementos y no te importa el orden.
- __Ejemplo__: Almacenar un conjunto de identificadores únicos para usuarios registrados.

```java
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> usuarios = new HashSet<>();
        usuarios.add("usuario1");
        usuarios.add("usuario2");
        usuarios.add("usuario3");

        for (String usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}
```


### LinkedHashSet:

- __Uso__: Cuando deseas preservar el orden de inserción pero también garantizar la unicidad.
- __Ejemplo__: Mantener un registro de eventos en el orden en que ocurrieron, pero sin duplicados.

```java

```


### TreeSet:

- __Uso__: Cuando necesitas elementos ordenados naturalmente o según un comparador.
- __Ejemplo__: Mantener una lista de palabras ordenadas alfabéticamente o por longitud.

```java

```


### HashMap:

- __Uso__: Cuando necesitas un mapeo eficiente de claves a valores y no te importa el orden.
- __Ejemplo__: Almacenar y recuperar información sobre productos basada en su código de barras.

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> productos = new HashMap<>();
        productos.put(1, "Laptop");
        productos.put(2, "Teléfono");
        productos.put(3, "Tablet");

        System.out.println(productos.get(2));  // Debería imprimir "Teléfono"
    }
}
```


### LinkedHashMap:

- __Uso__: Cuando deseas un mapeo con orden de inserción y la eficiencia de un HashMap.
- __Ejemplo__: Mantener un registro de pedidos en el orden en que se realizaron.

```java

```


### TreeMap:

- __Uso__: Cuando necesitas un mapeo ordenado basado en las claves.
- __Ejemplo__: Implementar un directorio telefónico que esté ordenado alfabéticamente por nombres.

```java

```


### PriorityQueue:

- __Uso__: Para almacenar elementos en un orden específico (por ejemplo, el menor elemento primero).
- __Ejemplo__: Implementar un algoritmo de búsqueda en grafos como el algoritmo de Dijkstra.

```java

```


### ArrayDeque:

- __Uso__: Cuando necesitas una pila o una cola eficiente basada en un arreglo.
- __Ejemplo__: Mantener un historial de navegación en un navegador web.

```java
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<String> historialNavegacion = new ArrayDeque<>();
        historialNavegacion.push("https://www.google.com");
        historialNavegacion.push("https://www.openai.com");

        System.out.println(historialNavegacion.pop());  // Debería imprimir "https://www.openai.com"
    }
}
```


## Conclusión

Las estructuras de datos en el framework de Colecciones de Java proporcionan soluciones flexibles y eficientes para una amplia gama de necesidades de programación.

>Nota: ___Cada estructura y clase en Java está diseñada para adaptarse a diferentes necesidades y escenarios de aplicación. La elección adecuada depende de los requisitos específicos del problema y de las operaciones que se realizarán con los datos.___



</div>