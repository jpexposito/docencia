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

---

>__Nota__:En resumen, los mapas en Java proporcionan una estructura de datos flexible y poderosa para mapear claves a valores, ofreciendo diferentes implementaciones para adaptarse a diversas necesidades y escenarios de uso.


</div>