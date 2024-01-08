<div align="justify">

# Destrucción de Objetos y Liberación de Memoria en Java

## Ejemplo 1: Referencias y Recolector de Basura

```java
public class EjemploBasico {
    public static void main(String[] args) {
        MiClase objeto1 = new MiClase();
        MiClase objeto2 = new MiClase();
        
        // Ambos objetos tienen referencias
        System.out.println("Objetos creados");

        // Liberar la referencia al primer objeto
        objeto1 = null;

        // En algún momento, el recolector de basura puede eliminar el objeto no referenciado
        // Pero el momento exacto no se puede predecir
        System.out.println("Se liberó la referencia al primer objeto");
    }
}

class MiClase {
    // Código de la clase
}
```

## Ejemplo 2: Referencias y Liberación de Recursos Externos

Supongamos que tienes una clase __ConexionBD__ que representa una _conexión a una base de datos_. Implementa la interfaz __AutoCloseable__ para asegurar que los recursos de la conexión se liberen adecuadamente.

```java
public class EjercicioConexionBD {
    public static void main(String[] args) {
        try (ConexionBD conexion = new ConexionBD()) {
            // Realizar operaciones con la conexión a la base de datos
            System.out.println("Operaciones realizadas con la conexión");
        } // La conexión se cerrará automáticamente al salir del bloque try-with-resources
    }
}

class ConexionBD implements AutoCloseable {
    // Implementar lógica para abrir la conexión

    @Override
    public void close() throws Exception {
        // Implementar lógica para cerrar la conexión y liberar recursos
        System.out.println("Conexión cerrada");
    }
}
```

>__Nota__: Esto garantiza que la conexión a la base de datos se cierre correctamente, incluso si ocurren excepciones dentro del bloque __try__.

Estos ejemplos proporcionan son ejemplo práctico del manejo de referencias y la liberación de recursos en Java.

</div>