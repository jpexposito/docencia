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

## Tipos de Exceptions

### Excepciones Verificadas (Checked Exceptions)

- IOException: Esta excepción se lanza cuando ocurre un error durante la lectura o escritura de archivos, o cuando hay problemas con las operaciones de entrada/salida.

    ```java
    try {
        // Operaciones de entrada/salida que pueden lanzar IOException
    } catch (IOException e) {
        // Manejo de la excepción
    }
    ```

- SQLException: Se lanza cuando se producen errores relacionados con operaciones de bases de datos.

    ```java
    try {
        // Operaciones de bases de datos que pueden lanzar SQLException
    } catch (SQLException e) {
        // Manejo de la excepción
    }
    ```

### Excepciones No Verificadas (Unchecked Exceptions)
- ArithmeticException: Se lanza cuando se produce una operación aritmética ilegal, como la división por cero.

    ```java
    try {
        // Operación aritmética que puede lanzar ArithmeticException
    } catch (ArithmeticException e) {
        // Manejo de la excepción
    }
    ```

- NullPointerException: Se lanza cuando se intenta acceder a un objeto que es null.

    ```java
    try {
        // Operación que puede lanzar NullPointerException
    } catch (NullPointerException e) {
        // Manejo de la excepción
    }
    ```

- ArrayIndexOutOfBoundsException: Ocurre cuando se intenta acceder a un índice fuera del rango válido de un array.

    ```java
    try {
        // Operación con arrays que puede lanzar ArrayIndexOutOfBoundsException
    } catch (ArrayIndexOutOfBoundsException e) {
        // Manejo de la excepción
    }
    ```

- IllegalArgumentException: Se lanza cuando un método recibe un argumento ilegal.

    ```java
    try {
        // Llamada a un método con un argumento ilegal que puede lanzar IllegalArgumentException
    } catch (IllegalArgumentException e) {
        // Manejo de la excepción
    }
    ```

## Definición de Exceptiones

En Java, puedes definir tus propias excepciones personalizadas creando clases que extiendan la clase Exception o alguna de sus subclases. Aquí hay un ejemplo básico de cómo podrías definir tu propia excepción personalizada:

```java
// Definición de una excepción personalizada
class MiExcepcionPersonalizada extends Exception {
    public MiExcepcionPersonalizada(String mensaje) {
        super(mensaje);
    }
}

// Clase que utiliza la excepción personalizada
class ClaseQueUsaExcepcion {
    public void metodoConExcepcion() throws MiExcepcionPersonalizada {
        // Algunas condiciones que podrían lanzar la excepción
        boolean algunaCondicion = false;

        if (algunaCondicion) {
            // Lanzar la excepción personalizada
            throw new MiExcepcionPersonalizada("¡Esto es una excepción personalizada!");
        }

        // Resto del código
    }
}

// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        ClaseQueUsaExcepcion objeto = new ClaseQueUsaExcepcion();

        try {
            objeto.metodoConExcepcion();
        } catch (MiExcepcionPersonalizada e) {
            // Manejar la excepción personalizada
            System.out.println("¡Se ha producido una excepción personalizada! Mensaje: " + e.getMessage());
        }
    }
}
```

### Descripción del uso de Exceptions

En este ejemplo:

- La clase __MiExcepcionPersonalizada__ extiende la clase __Exception__ y tiene un __constructor__ que toma un mensaje como parámetro. Este mensaje se puede utilizar para proporcionar información adicional sobre la excepción.

- La clase __ClaseQueUsaExcepcion__ tiene un _método_ llamado __metodoConExcepcion__ que puede lanzar la excepción personalizada en ciertas condiciones.

- En el método main, se crea una instancia de __ClaseQueUsaExcepcion__ y se llama al método metodoConExcepcion dentro de un bloque __try-catch__. Si se lanza la excepción personalizada, se captura en el bloque catch y se maneja adecuadamente.



</div>