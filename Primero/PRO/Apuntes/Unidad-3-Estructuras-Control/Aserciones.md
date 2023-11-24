<div align="justify">

Las __aserciones__ son declaraciones que se utilizan para expresar suposiciones sobre el estado del programa en puntos críticos. Estas aserciones se introdujeron en __Java 1.4__ y se ___utilizan principalmente para detectar errores y bugs durante el desarrollo y las pruebas___.

En el código Java, las aserciones se implementan mediante la palabra __clave assert__.

```java
assert expresion : mensaje;
```

- **expresion**: Es la expresión booleana que se espera que sea true. Si es false, se lanza una excepción AssertionError.
- **mensaje**: Es un mensaje opcional que se mostrará si la aserción falla.

** Habilitar Aserciones

- [Visual Studio Code](https://learn.microsoft.com/es-es/visualstudio/liveshare/use/enable-accessibility-features-visual-studio-code).
- [Intelijj](https://www.jetbrains.com/es-es/resharper/features/coding_assistance.html).

** Ejemplo de uso

En este ejemplo, si la variable edad es negativa, se lanzará una excepción AssertionError con el mensaje proporcionado.

```java
public class EjemploAserciones {

    public static void main(String[] args) {
        int edad = -1;

        // Suponiendo que la edad no puede ser negativa
        assert edad >= 0 : "La edad no puede ser negativa";

        // Resto del código...
    }
}

```


</div>