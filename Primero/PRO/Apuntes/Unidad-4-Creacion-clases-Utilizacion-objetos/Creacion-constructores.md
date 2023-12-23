<div align="justify">

# Constructores en Java

En Java, un **constructor** es un método especial dentro de una clase que se llama automáticamente cuando se crea una instancia (objeto) de la clase. Su propósito principal es inicializar los atributos de la clase y realizar cualquier configuración necesaria para que el objeto sea utilizado de manera adecuada.

## Características Clave de los Constructores:

1. **Nombre Idéntico al de la Clase:** El nombre del constructor debe ser exactamente el mismo que el nombre de la clase a la que pertenece.

2. **No Tiene Tipo de Retorno:** A diferencia de otros métodos, el constructor no tiene un tipo de retorno explícito, ni siquiera `void`.

3. **Puede Sobrecargarse:** Una clase puede tener múltiples constructores, y se pueden diferenciar por el número y tipo de parámetros que aceptan (sobrecarga de constructores).

## Ejemplo de Constructor en Java:

```java
public class Persona {
    // Atributos
    private String nombre;
    private int edad;

    // Constructor sin parámetros (por defecto)
    public Persona() {
        this.nombre = "Sin Nombre";
        this.edad = 0;
    }

    // Constructor con parámetros
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos getter y setter...

    // Otros métodos...
}
```

>__Nota__:En este ejemplo, la clase __Persona__ tiene _dos constructores_: uno __sin parámetros (por defecto)__ y __otro con parámetros__. El constructor sin parámetros inicializa la instancia con valores predeterminados, mientras que el constructor con parámetros permite especificar valores al crear un objeto de la clase.

## Uso de Constructores en el Programa Principal

```java
public class Main {
    public static void main(String[] args) {
        // Crear instancias utilizando los constructores
        Persona persona1 = new Persona(); // Constructor sin parámetros
        Persona persona2 = new Persona("Juan", 25); // Constructor con parámetros

        // Acceder a los atributos de las instancias
        System.out.println("Persona 1: " + persona1.getNombre() + ", Edad: " + persona1.getEdad());
        System.out.println("Persona 2: " + persona2.getNombre() + ", Edad: " + persona2.getEdad());
    }
}
```

En este fragmento de código, se crean dos instancias de la clase Persona utilizando los diferentes constructores. Esto ilustra cómo los constructores proporcionan flexibilidad al permitir la creación de objetos con o sin parámetros específicos.

Los constructores son una __parte esencial de la programación en Java__, ya que garantizan que los objetos se inicialicen correctamente y estén listos para su uso.

</div>
