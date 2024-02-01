<div align="justify">

# Mapas

Un mapa en Java es una interfaz que representa una colección de pares __clave-valor__, donde cada __clave es única__ y se __asigna a un único valor__. La principal característica de los mapas es que __NO permiten claves duplicadas__.

## Características Principales

1. **Claves Únicas:** Cada clave en un mapa es única; no puede haber dos claves iguales en un mismo mapa.
2. **Asociación de Clave-Valor:** Cada clave se asocia a un único valor. Sin embargo, diferentes claves pueden asociarse al mismo valor.
3. **Implementaciones:** Java proporciona varias implementaciones de la interfaz `Map`, como `HashMap`, `TreeMap`, `LinkedHashMap`, entre otros, cada una con sus propias características y comportamientos.
4. **No Garantiza Orden:** Aunque algunas implementaciones, como `LinkedHashMap`, mantienen el orden de inserción, el orden en general no está garantizado para todos los mapas.

## Operaciones Comunes

- **put(K key, V value):** Asocia el valor especificado con la clave especificada en el mapa.
- **get(Object key):** Devuelve el valor asociado con la clave especificada, o `null` si el mapa no contiene la clave.
- **remove(Object key):** Elimina la clave y su valor asociado del mapa.
- **containsKey(Object key):** Verifica si el mapa contiene la clave especificada.
- **containsValue(Object value):** Verifica si el mapa contiene el valor especificado.

## Uso Típico:

Los mapas son extremadamente útiles en situaciones donde necesitas mapear claves a valores, como en la representación de registros, configuraciones, o cualquier otra estructura de datos donde la clave proporciona una forma eficiente de recuperar un valor asociado.

## Implementaciones Comunes:

- **HashMap:** Una de las implementaciones más utilizadas. Es eficiente para operaciones básicas (como `put` y `get`) y no garantiza ningún orden específico.
- **TreeMap:** Implementación basada en árboles que mantiene las claves ordenadas naturalmente o según un comparador proporcionado.
- **LinkedHashMap:** Combina la rápida recuperación de `HashMap` con la capacidad de mantener el orden de inserción.

### HashMap

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

### TreeMap

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

### LinkedHashMap

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


---

>__Nota__:En resumen, los mapas en Java proporcionan una estructura de datos flexible y poderosa para mapear claves a valores, ofreciendo diferentes implementaciones para adaptarse a diversas necesidades y escenarios de uso.


</div>