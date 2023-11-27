<div align="justify">

# Manejo de Excepciones

## Ejemplo 1: Excepción Verificada (FileNotFoundException)

### Código

```java
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class ManejoDeExcepciones {
    public static void main(String[] args) {
        try {
            // Intentar abrir un archivo que no existe
            File archivo = new File("archivo.txt");
            FileReader lector = new FileReader(archivo);
        } catch (FileNotFoundException e) {
            // Manejo de la excepción
            System.out.println("El archivo no se encontró: " + e.getMessage());
        }
    }
}
```

### Explicación:

___En este ejemplo, se intenta abrir un archivo que no existe__.

La __clase FileReader__ puede lanzar una excepción __FileNotFoundException__.
La excepción es capturada por el bloque __catch__, donde se imprime un mensaje indicando que el archivo no se encontró.

## Ejemplo 2: Excepción No Verificada (ArithmeticException)

### Código

```java
public class ManejoDeExcepciones {
    public static void main(String[] args) {
        int numerador = 10;
        int denominador = 0;

        try {
            // Intentar dividir por cero
            int resultado = numerador / denominador;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            // Manejo de la excepción
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }
}
```

### Explicación

En este caso, se intenta dividir un número por cero, lo que causa una excepción aritmética.
La excepción __ArithmeticException__ es capturada por el __bloque catch__.
Se imprime un mensaje indicando el error aritmético.

## Ejemplo 3: Uso de finally

### Código

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManejoDeExcepciones {
    public static void main(String[] args) {
        BufferedReader lector = null;

        try {
            // Intentar leer un archivo
            lector = new BufferedReader(new FileReader("archivo.txt"));
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            // Manejo de la excepción
            System.out.println("Error de lectura: " + e.getMessage());
        } finally {
            // Cerrar el recurso (lector) en el bloque finally para garantizar su cierre
            try {
                if (lector != null) {
                    lector.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el lector: " + e.getMessage());
            }
        }
    }
}
```

### Explicación

Se intenta leer un archivo utilizando un __BufferedReader__.
La excepción __IOException__ es capturada en el bloque __catch__, con un mensaje de error.
El bloque __finally__ se utiliza para __cerrar el recurso (lector) de manera segura__, independientemente de si se produjo una excepción o no.


Ejemplo 1: Excepción simple sin información adicional
java
Copy code
class MiExcepcionSimple extends Exception {
    public MiExcepcionSimple() {
        super("¡Esto es una excepción simple!");
    }
}

class ClaseQueLanzaExcepcion {
    public void metodoConExcepcion() throws MiExcepcionSimple {
        throw new MiExcepcionSimple();
    }
}

public class Main {
    public static void main(String[] args) {
        ClaseQueLanzaExcepcion objeto = new ClaseQueLanzaExcepcion();

        try {
            objeto.metodoConExcepcion();
        } catch (MiExcepcionSimple e) {
            System.out.println("¡Se ha producido una excepción simple! Mensaje: " + e.getMessage());
        }
    }
}
## Ejemplo 4: Excepción con información adicional

### Código

```java

class MiExcepcionConInformacion extends Exception {
    private int codigoError;

    public MiExcepcionConInformacion(int codigoError, String mensaje) {
        super(mensaje);
        this.codigoError = codigoError;
    }

    public int getCodigoError() {
        return codigoError;
    }
}

class ClaseQueLanzaExcepcionConInformacion {
    public void metodoConExcepcion() throws MiExcepcionConInformacion {
        int codigoError = 404; // Código de error personalizado
        throw new MiExcepcionConInformacion(codigoError, "¡Esto es una excepción con información!");
    }
}

public class Main {
    public static void main(String[] args) {
        ClaseQueLanzaExcepcionConInformacion objeto = new ClaseQueLanzaExcepcionConInformacion();

        try {
            objeto.metodoConExcepcion();
        } catch (MiExcepcionConInformacion e) {
            System.out.println("¡Se ha producido una excepción con información! Código de error: " + e.getCodigoError() + ", Mensaje: " + e.getMessage());
        }
    }
}
```

### Explicación

Estos ejemplos muestran cómo puedes definir excepciones personalizadas con y sin información adicional. Puedes adaptar estas clases según tus necesidades específicas y agregar métodos o propiedades adicionales según sea necesario.







</div>