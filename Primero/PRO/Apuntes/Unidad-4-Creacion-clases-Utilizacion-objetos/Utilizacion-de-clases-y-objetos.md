<div align="justify">

# Utilización de Clases y Objetos en Java

Java es un lenguaje de programación orientado a objetos, lo que significa que utiliza clases y objetos como componentes fundamentales para representar y modelar la lógica de una aplicación. Aquí se presenta una visión general de cómo se utilizan las clases y objetos en Java.

## Definición de una Clase

Una clase en Java es una plantilla o un plano para crear objetos. Define ___propiedades/atributos___ (_variables_) y ___métodos___ (_funciones_) que representan las ___características___ y el ___comportamiento___ de los objetos.

```java
public class Persona {
    // Atributos
    private String nombre;
    private int edad;
    
// Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para edad
    public int getEdad() {
        return edad;
    }

    // Setter para edad
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método
    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
}
```

## Creación de Objetos

Un objeto es una instancia única de una clase. Para crear un objeto en Java, utilizamos la palabra clave `new` seguida del constructor de la clase.

```java
public class Main {
    public static void main(String[] args) {
        // Creación de un objeto de la clase Persona
        Persona persona1 = new Persona();
        
        // Asignación de valores a los atributos del objeto
        persona1.setNombre("Juan");
        persona1.setEdad(25);
        
        // Llamada a un método del objeto
        persona1.saludar();  // Salida: "Hola, soy Juan"
    }
}
```

## Instanciación de Objetos

El proceso de crear un objeto a partir de una clase se denomina instanciación. Cada vez que se instancia una clase, se crea una nueva copia o instancia de esa clase.

```java
Persona persona2 = new Persona();
persona2.setNombre("Maria");
persona2.setEdad(30);
persona2.saludar();  // Salida: "Hola, soy Maria"
```

## Beneficios de las Clases y Objetos

- **Reutilización de Código**: Las clases permiten encapsular la lógica y el comportamiento, lo que facilita la reutilización del código.
- **Modularidad**: Las clases ayudan a organizar y estructurar el código en módulos coherentes y relacionados.
- **Abstracción**: Las clases proporcionan una abstracción de los datos y el comportamiento, ocultando los detalles internos y mostrando solo la interfaz externa.

## Consideraciones Finales

___Las clases y objetos son fundamentales en Java y en la programación orientada a objetos en general. Proporcionan un mecanismo poderoso para modelar y representar entidades del mundo real en el código___.

</div>