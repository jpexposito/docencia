<div align="justify">

# Clases (Abstractas) en Proramación

Una __clase abstracta__ es una clase que __NO PUEDE SER INSTANCIADA__ directamente y generalmente se utiliza como __una clase base__ para __otras clases__. Puede contener __métodos abstractos__, que son __declarados pero no implementados__ en la clase abstracta, o __métodos con funcionalidad__ que definen el __comportamiento base__ para el conjunto de clases que extienden. Las __subclases__ que __heredan__ de la __clase abstracta deben proporcionar implementaciones concretas para estos métodos abstractos__.

## Sintaxis

```java
abstract class MiClaseAbstracta {
    // Atributos y métodos comunes
    // ...

    // Método abstracto (sin implementación)
    abstract void metodoAbstracto();

        @Override
    public String toString() {
        return "Por defecto se muestra este mensaje";
    }
}
```

## Ejemplo

```java
// Definición de la clase abstracta
abstract class Figura {
    // Atributos comunes
    String color;

    // Constructor
    public Figura(String color) {
        this.color = color;
    }

    // Método abstracto que debe ser implementado por las subclases
    abstract double calcularArea();
}

// Subclase que hereda de la clase abstracta
public class Circulo extends Figura {
    double radio;

    // Constructor
    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    // Implementación del método abstracto
    @Override
    double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}

// Subclase que hereda de la clase abstracta
public class Cuadrado extends Figura {
    double lado;

    // Constructor
    public Cuadrado(String color, double lado) {
        super(color);
        this.lado = lado;
    }

    // Implementación del método abstracto
    @Override
    double calcularArea() {
        return Math.pow(lado, 2);
    }
}

// Clase principal para probar las clases abstractas
public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo("Rojo", 5.0);
        Cuadrado cuadrado = new Cuadrado("Azul", 4.0);

        // Utilizando las implementaciones de los métodos abstractos
        System.out.println("Área del círculo: " + circulo.calcularArea());
        System.out.println("Área del cuadrado: " + cuadrado.calcularArea());
    }
}
```

>__Nota__:En este ejemplo, la __clase Figura__ es una __clase abstracta__ que contiene un __atributo común (color) y un método abstracto (calcularArea)__. Las clases __Circulo y Cuadrado__ son subclases de __Figura__ y proporcionan __implementaciones concretas__ para el _método abstracto_ __calcularArea__.

</div>