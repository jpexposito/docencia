<div align="justify">

En Java, la herencia es un mecanismo fundamental de la programación orientada a objetos que permite que una clase __(denominada subclase o clase derivada)__ herede atributos y métodos de otra clase (denominada superclase o clase base). La utilización de clases heredadas permite la reutilización de código y facilita la estructuración y organización del software.

A continuación, se describen algunos conceptos y ejemplos relacionados con la utilización de clases heredadas en Java:

## Declaración de Clases Heredadas

Para que una clase herede de otra, se utiliza la palabra clave extends seguida del nombre de la superclase.

```java
public class Superclase {
    // Atributos y métodos
}

public class Subclase extends Superclase {
    // Atributos y métodos adicionales
}
```

## Acceso a Atributos y Métodos Heredados

Una subclase puede acceder a los atributos y métodos públicos o protegidos de su superclase utilizando la notación de punto (.).

```java
public class Vehiculo {
    public void acelerar() {
        System.out.println("Acelerando...");
    }
}

public class Coche extends Vehiculo {
    public void encender() {
        System.out.println("Coche encendido.");
    }
}

// Uso
Coche miCoche = new Coche();
miCoche.acelerar();  // Método heredado
miCoche.encender();  // Método de la subclase
```

## Constructores en Clases Heredadas

Cuando se crea una instancia de una subclase, se invoca automáticamente el constructor de la superclase. Si la superclase no tiene un constructor sin argumentos, se debe utilizar la palabra clave super para llamar a un constructor específico de la superclase.

```java
public class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }
}

public class Estudiante extends Persona {
    private int codigo;

    public Estudiante(String nombre, int codigo) {
        super(nombre);  // Llamada al constructor de la superclase
        this.codigo = codigo;
    }
}
```

## Métodos sobrescritos (@Override)

Una subclase puede proporcionar una implementación específica de un método heredado de su superclase. Para indicar que un método en la subclase sobrescribe un método en la superclase, se utiliza la anotación @Override.

```java
public class Animal {
    public void emitirSonido() {
        System.out.println("Haciendo sonido...");
    }
}

public class Perro extends Animal {
    @Override
    public void emitirSonido() {
        System.out.println("Ladrando...");
    }
}
```

## Conclusión
La herencia en Java es un mecanismo poderoso que permite la creación de jerarquías de clases y la reutilización de código. Al utilizar clases heredadas de manera efectiva, se puede mejorar la estructura, mantenibilidad y organización del código en aplicaciones Java.

</div>
