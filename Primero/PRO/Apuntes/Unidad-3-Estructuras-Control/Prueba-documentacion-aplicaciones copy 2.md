<div align="justify">

# Pruebas, depuración y documentación de aplicaciones

Las pruebas, depuración y documentación son partes fundamentales en el desarrollo de aplicaciones en Java. Aquí tienes una breve descripción de cada una:

## Prueba (Testing)

En Java, las pruebas suelen dividirse en dos categorías principales:
 - Pruebas unitarias
 - Pruebas de integración.

### Pruebas unitarias

Las __pruebas unitarias__ evalúan componentes individuales de __TÚ CÓDIDO__ para asegurarse de que funcionen como se espera.
__JUnit__ es una popular biblioteca de pruebas unitarias en Java.
Un ejemplo de prueba unitaria con JUnit:

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MiClaseTest {
    @Test
    public void miMetodoDePrueba() {
        assertEquals(4, MiClase.sumar(2, 2));
    }
}
```

### Pruebas de integración

Las __pruebas integración__ evalúan componentes __EXTERNOS__ que utiliza  __TÚ CÓDIDO__ para asegurarse de que funcionen como se espera.
__JUnit__ es una popular biblioteca de pruebas unitarias en Java.


## Depuración (Debugging)

La depuración es el proceso de identificar y corregir errores en el código.
Puedes utilizar un entorno de desarrollo integrado (IDE) como Eclipse, IntelliJ IDEA o NetBeans para depurar tu aplicación.
Coloca puntos de interrupción en tu código y utiliza las herramientas de depuración para examinar variables, ejecutar paso a paso y encontrar problemas.

- [VS-CODE Debugging](https://code.visualstudio.com/docs/editor/debugging)-
- [IntelliJ IDEA Debugging](https://blog.jetbrains.com/idea/2020/05/debugger-basics-in-intellij-idea/).
  
## Documentación

La documentación es crucial para comprender y mantener el código a lo largo del tiempo.
__Javadoc__ es una herramienta de documentación en Java que te permite incorporar comentarios directamente en tu código fuente.
Documenta las clases y métodos utilizando comentarios Javadoc para describir su propósito, parámetros y valor de retorno.
Ejemplo de comentario Javadoc:

```java
/**
 * Esta es una clase de ejemplo.
 * Describe el propósito de la clase y su funcionamiento.
 */
public class MiClase {
    /**
     * Suma dos números enteros.
     *
     * @param a El primer número.
     * @param b El segundo número.
     * @return La suma de los dos números.
     */
    public static int sumar(int a, int b) {
        return a + b;
    }
}
```

</div>