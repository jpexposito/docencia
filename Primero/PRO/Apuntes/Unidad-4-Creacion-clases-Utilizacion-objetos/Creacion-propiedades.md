<div align="justify">

# Creación de Atributos en Java

En Java, un atributo es una variable que pertenece a una clase. Estos atributos representan el estado o las características de los objetos creados a partir de esa clase.

## Declaración de Atributos

Para declarar un atributo en Java, se especifica el tipo de dato del atributo seguido de su nombre. Por ejemplo:

```java
public class Persona {
    // Declaración de atributos
    String nombre;
    int edad;
    double altura;
}
```

En el ejemplo anterior, la clase `Persona` tiene tres atributos: `nombre` de tipo `String`, `edad` de tipo `int` y `altura` de tipo `double`.

## Inicialización de Atributos

Los atributos se pueden inicializar en el momento de su declaración o en el constructor de la clase:

```java
public class Persona {
    String nombre = "Juan";
    int edad;
    double altura;

    // Constructor
    public Persona(int edad, double altura) {
        this.edad = edad;
        this.altura = altura;
    }
}
```

## Acceso a Atributos

Para el acceso a los atributos de una clase, se debe de hacer uso de los __gettes/setters__.

No obstante, se puede utilizar la notación de punto (`.`):

```java
Persona persona = new Persona(25, 1.75);
String nombrePersona = persona.nombre;
int edadPersona = persona.edad;
```

## Modificadores de Acceso

Java proporciona modificadores de acceso para controlar la visibilidad de los atributos:

- `public`: Accesible desde cualquier clase.
- `private`: Accesible solo dentro de la propia clase.
- `protected`: Accesible dentro del mismo paquete y subclases.

```java
public class Persona {
    public String nombrePublico;
    private int edadPrivada;
    protected double alturaProtegida;
}
```

Estos son los fundamentos sobre la creación y manejo de atributos en Java. Los atributos definen el estado de un objeto y son esenciales para la programación orientada a objetos.


</div>
