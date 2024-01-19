<div align="justify">


# Colecciones

Java proporciona una amplia variedad de estructuras de datos a través del framework de Colecciones __(Collections Framework)__. Estas __colecciones__ facilitan el _almacenamiento, manipulación y gestión de grupos de objetos_. Las principales interfaces y clases relacionadas con colecciones en Java se encuentran en el paquete __java.util__.

## Interfaces Principales del Framework de Colecciones

### Collection

- Representa una colección de objetos. __No garantiza ningún orden específico para sus elementos__.
- Subinterfaces: __List, Set, y Queue__.

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

- Ventajas: _Tamaño dinámico, acceso rápido_, __PERMITE ELEMENTOS DUPLICADOS__.
- Uso: Cuando se necesite una __lista ordenada__ y __se realicen operaciones frecuentes de inserción y acceso__.

    ```java
    // Ejemplo de construcción de una lista con ArrayList
    List<String> lista = new ArrayList<>();
    lista.add("Elemento 1");
    lista.add("Elemento 2");
    ```
<div align="center">    
<img src="https://miro.medium.com/v2/resize:fit:670/0*5w9-ibvGwT1EpeH9.png" width="250px">
</div>

### LinkedList

Basado en una __lista doblemente enlazada__.
_Ofrece inserciones y eliminaciones rápidas en cualquier posición_.

- Ventajas: _Inserciones y eliminaciones rápidas en cualquier posición_, implementa la __interfaz Deque__.
- Uso: Cuando se _necesite_ una __lista__ y se __realicen operaciones frecuentes de inserción y eliminación en cualquier posición__.

```java
LinkedList<String> linkedList = new LinkedList<>();

// Agregar elementos al final de la lista
linkedList.add("Elemento 1");
linkedList.add("Elemento 2");
linkedList.add("Elemento 3");

// Mostrar la LinkedList
System.out.println("LinkedList actual: " + linkedList);

// Agregar un elemento al principio de la lista
linkedList.addFirst("Elemento 0");
// Agregar un elemento al final de la lista
linkedList.addLast("Elemento 4");
```

<div align="center"> 
<img src="https://qph.cf2.quoracdn.net/main-qimg-41cdfa9a815220598f2c03f1bccaeff8"/>
</div>

###  HashSet
Implementación basada en una tabla hash.
Ofrece ___operaciones rápidas para agregar, eliminar y comprobar la existencia de un elemento__.

- Ventajas: __Garantiza elementos únicos__, _operaciones_ __rápidas de inserción, eliminación y búsqueda__.
- Uso: Cuando se necesite una __colección sin duplicados__ y el _orden de los elementos_ __NO__ sea importante.

```java
// Crear un HashSet de tipo String
HashSet<String> hashSet = new HashSet<>();

// Agregar elementos al conjunto
hashSet.add("Elemento 1");
hashSet.add("Elemento 2");
hashSet.add("Elemento 3");

// Mostrar el HashSet actual
System.out.println("HashSet actual: " + hashSet);

// Intentar agregar un elemento duplicado (no se permiten duplicados en un conjunto)
boolean seAgregoDuplicado = hashSet.add("Elemento 2");
```

<div align="center"> 
<img src="https://media.geeksforgeeks.org/wp-content/uploads/ArrayListVsHashSet.png"/>
</div>

### LinkedHashSet

Mientras que __HashSet__ __NO__ garantiza un orden específico de los elementos, __LinkedHashSet__ mantiene el __orden__ de __inserción__, es decir, el orden en el que los elementos fueron agregados.

```java
inkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

// Agregar elementos al conjunto
linkedHashSet.add("Elemento 3");
linkedHashSet.add("Elemento 1");
linkedHashSet.add("Elemento 2");
// Mostrar el LinkedHashSet actual (se mantendrá el orden de inserción)
System.out.println("LinkedHashSet actual: " + linkedHashSet);
// Intentar agregar un elemento duplicado (no se permiten duplicados en un conjunto)
boolean seAgregoDuplicado = linkedHashSet.add("Elemento 2");
System.out.println("¿Se agregó duplicado? " + seAgregoDuplicado);

// Mostrar el LinkedHashSet después de intentar agregar un duplicado
System.out.println("LinkedHashSet después de intentar agregar un duplicado: " + linkedHashSet);

// Verificar si el conjunto contiene un elemento específico
boolean contieneElemento = linkedHashSet.contains("Elemento 3");
System.out.println("¿Contiene 'Elemento 3'? " + contieneElemento);

// Eliminar un elemento del conjunto
linkedHashSet.remove("Elemento 1");

```

## Map

Un mapa en Java es una interfaz que representa una colección de pares __clave-valor__, donde cada __clave es única__ y se __asigna a un único valor__. La principal característica de los mapas es que __NO permiten claves duplicadas__.

### Características Principales

1. **Claves Únicas:** Cada clave en un mapa es única; no puede haber dos claves iguales en un mismo mapa.
2. **Asociación de Clave-Valor:** Cada clave se asocia a un único valor. Sin embargo, diferentes claves pueden asociarse al mismo valor.
3. **Implementaciones:** Java proporciona varias implementaciones de la interfaz `Map`, como `HashMap`, `TreeMap`, `LinkedHashMap`, entre otros, cada una con sus propias características y comportamientos.
4. **No Garantiza Orden:** Aunque algunas implementaciones, como `LinkedHashMap`, mantienen el orden de inserción, el orden en general no está garantizado para todos los mapas.

### Operaciones Comunes

- **put(K key, V value):** Asocia el valor especificado con la clave especificada en el mapa.
- **get(Object key):** Devuelve el valor asociado con la clave especificada, o `null` si el mapa no contiene la clave.
- **remove(Object key):** Elimina la clave y su valor asociado del mapa.
- **containsKey(Object key):** Verifica si el mapa contiene la clave especificada.
- **containsValue(Object value):** Verifica si el mapa contiene el valor especificado.

#### HashMap

Implementación basada en una __tabla hash__.
Ofrece acceso _rápido a los valores a través de sus claves_.

- Ventajas: Almacena pares __clave-valor__, acceso rápido a los valores a través de las __claves__, _permite claves y valores_ __null__.
- Uso: Cuando se necesite asociar __claves únicas con valores__ y realizar operaciones frecuentes de __búsqueda, inserción y eliminación__.

```java
// Crear un HashMap donde la clave es de tipo String y el valor es de tipo Integer
HashMap<String, Integer> hashMap = new HashMap<>();

// Agregar pares clave-valor al mapa
hashMap.put("Clave1", 10);
hashMap.put("Clave2", 20);
hashMap.put("Clave3", 30);

// Mostrar el HashMap actual
System.out.println("HashMap actual: " + hashMap);

// Obtener el valor asociado a una clave específica
int valorClave2 = hashMap.get("Clave2");
System.out.println("Valor asociado a 'Clave2': " + valorClave2);

// Verificar si el mapa contiene una clave específica
boolean contieneClave = hashMap.containsKey("Clave1");
System.out.println("¿Contiene 'Clave1'? " + contieneClave);
```

```java
// Crear un HashMap donde la clave es el DNI (String) y el valor es la Persona
HashMap<String, Persona> mapaPersonas = new HashMap<>();

// Crear instancias de la clase Persona
Persona persona1 = new Persona("Juan", "12345678A");
Persona persona2 = new Persona("María", "87654321B");

// Agregar pares clave-valor al mapa
mapaPersonas.put(persona1.getDni(), persona1);
mapaPersonas.put(persona2.getDni(), persona2);
```

#### TreeMap

Implementación basada en árboles que mantiene las claves ordenadas naturalmente o según un comparador proporcionado.

```java
TreeMap<String, Integer> treeMap = new TreeMap<>();

// Agregar pares clave-valor al mapa
treeMap.put("Tres", 3);
treeMap.put("Uno", 1);
treeMap.put("Dos", 2);

// Mostrar el TreeMap actual (orden natural de las claves)
System.out.println("TreeMap actual: " + treeMap);

// Obtener y mostrar el valor asociado a una clave específica
int valorClaveDos = treeMap.get("Dos");
System.out.println("Valor asociado a 'Dos': " + valorClaveDos);

// Verificar si el mapa contiene una clave específica
boolean contieneClave = treeMap.containsKey("Tres");
System.out.println("¿Contiene 'Tres'? " + contieneClave);

// Modificar el valor asociado a una clave existente
treeMap.put("Uno", 10);

// Mostrar el TreeMap después de modificar un valor
System.out.println("TreeMap después de modificar 'Uno': " + treeMap);

// Eliminar una entrada del mapa utilizando la clave
treeMap.remove("Tres");

```

#### LinkedHashMap

Combina la rápida recuperación de `HashMap` con la capacidad de mantener el orden de inserción.

```java
// Crear un LinkedHashMap donde la clave es de tipo String y el valor es de tipo Integer
LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

// Agregar pares clave-valor al mapa
linkedHashMap.put("Tres", 3);
linkedHashMap.put("Uno", 1);
linkedHashMap.put("Dos", 2);

// Mostrar el LinkedHashMap actual (orden de inserción)
System.out.println("LinkedHashMap actual: " + linkedHashMap);

// Obtener y mostrar el valor asociado a una clave específica
int valorClaveDos = linkedHashMap.get("Dos");
System.out.println("Valor asociado a 'Dos': " + valorClaveDos);

// Verificar si el mapa contiene una clave específica
boolean contieneClave = linkedHashMap.containsKey("Tres");
System.out.println("¿Contiene 'Tres'? " + contieneClave);

// Modificar el valor asociado a una clave existente
linkedHashMap.put("Uno", 10);

// Mostrar el LinkedHashMap después de modificar un valor
System.out.println("LinkedHashMap después de modificar 'Uno': " + linkedHashMap);

// Eliminar una entrada del mapa utilizando la clave
linkedHashMap.remove("Tres");

// Mostrar el LinkedHashMap después de eliminar una entrada
System.out.println("LinkedHashMap después de eliminar 'Tres': " + linkedHashMap);

// Obtener el tamaño del LinkedHashMap
int tamaño = linkedHashMap.size();
System.out.println("Tamaño del LinkedHashMap: " + tamaño);

// Limpiar (eliminar todas las entradas) del LinkedHashMap
linkedHashMap.clear();
```

## Conclusión

Las estructuras de datos en el __framework de Colecciones__ de Java proporcionan __soluciones flexibles y eficientes__ para una amplia gama de necesidades de programación.

>Nota: ___Cada estructura y clase en Java está diseñada para adaptarse a diferentes necesidades y escenarios de aplicación. La elección adecuada depende de los requisitos específicos del problema y de las operaciones que se realizarán con los datos.___



</div>