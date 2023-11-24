<div align="justify">

# Manejo de Excepciones

En Java, las excepciones son eventos que ocurren durante la ejecución de un programa y que interrumpen el flujo normal de instrucciones. Estas situaciones excepcionales pueden ser causadas por diversos motivos, como errores de programación, problemas de hardware o condiciones imprevistas.

## Tipos de Excepciones en Java

Las excepciones en Java se dividen en dos categorías principales:

### Excepciones Verificadas (Checked Exceptions)

Son aquellas que el compilador obliga a manejar explícitamente mediante try, catch y finally o declarando que el método las arrojará con la palabra clave throws.

```java
try {
    // Código que puede arrojar una excepción verificada
} catch (ExcepcionVerificada e) {
    // Manejo de la excepción
}
```

__ó__

```java
try {
    // Código que puede arrojar una excepción verificada
} catch (ExcepcionVerificada e) {
    // Manejo de la excepción
} finally{
    // Operaciones que siempre se realizan
}
```

### Excepciones No Verificadas (Unchecked Exceptions)

Son excepciones que el compilador no obliga a manejar. Incluyen subtipos de RuntimeException y generalmente se deben a errores en la lógica del programa.

```java
// Código que puede arrojar una excepción no verificada
throw new ExcepcionNoVerificada();
```

## Bloques try, catch y finally

El manejo de excepciones se realiza mediante bloques __try, catch y opcionalmente__ _finally_:
- __try__: Contiene el código que puede arrojar una excepción.
- __catch__: Captura y maneja la excepción. Puedes tener múltiples bloques catch para diferentes tipos de excepciones.
- __finally__: Contiene el código que se ejecutará siempre, independientemente de si se produce una excepción o no. __Es opcional__.

Ejemplo:

```java
try {
    // Código que puede arrojar una excepción
} catch (TipoDeExcepcion e) {
    // Manejo de la excepción
} finally {
    // Código que se ejecuta siempre
}
```

## Lanzar Excepciones

_Puedes lanzar excepciones explícitamente usando la palabra clave_ ___throw___. _Esto es útil para indicar condiciones de error en_ ___tu código__.

```java
if (condicionDeError) {
    throw new TipoDeExcepcion("Mensaje descriptivo");
}
```

## Declarar Excepciones

Cuando defines un método que podría lanzar una excepción verificada, debes declararla utilizando la palabra clave __throws__.

```java
public void metodo() throws ExcepcionVerificada {
    // Código que puede arrojar una excepción verificada
}
```

</div>