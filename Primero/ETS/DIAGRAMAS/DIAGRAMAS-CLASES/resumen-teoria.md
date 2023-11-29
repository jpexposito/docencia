<div align="justify">

# Diagramas de Clases

## Definición

Los diagramas de clases son una herramienta visual utilizada en programación orientada a objetos para representar __las clases, sus atributos, métodos y las relaciones__ _entre ellas_. 

Una vez vista la teoría que puedes encontrar en el siguiente [enlace](README.md), se muestra un ejemplo para su perfecta compresión enfocado al lenguaje __java__.

## Elementos de un Diagrama de Clases

### Clase

- __Símbolo__: Rectángulo dividido en tres secciones.
- __Ejemplo__:

    ```java
    public class Persona {
        // Atributos
        private String nombre;
        private int edad;

        // Métodos
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public int getEdad() {
            return edad;
        }
    }
    ```

### Atributo

- __Símbolo__: __Lista de pares__ _nombre:tipo de dato_.

- __Ejemplo__:

    ```java
    private String nombre;
    ```

### Método

- __Símbolo__: ___Lista de nombre():tipo de retorno___.
- __Ejemplo__:

    ```java
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    ```

### Relación de Asociación

__Símbolo__: __Línea sólida que conecta dos clases__. _Puede tener una flecha indicando la dirección_.
- __Ejemplo__:

    ```java
    public class Empleado {
        private Persona persona; // Relación de asociación
    }
    ```

### Relación de Herencia

- __Símbolo__: _Línea sólida con una flecha triangular en la clase hija_.
- __Ejemplo__:

    ```java
    public class Estudiante extends Persona {
        // ... métodos y atributos adicionales para Estudiante
    }
    ```

### Relación de Agregación/Composición

- __Símbolo__: Línea con un rombo que indica la relación. Agregación es una relación más débil que la composición.
- __Ejemplo__:

    ```java
    public class Universidad {
        private List<Facultad> facultades; // Agregación
    }
    ```

### Ejemplo Completo

Supongamos que tenemos tres clases: __Persona__, __Empleado__ y __Estudiante__, y queremos representar sus relaciones en un diagrama de clases.

```java

// Clase Persona
public class Persona {
    private String nombre;
    private int edad;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }
}

// Clase Empleado que tiene una relación de asociación con Persona
public class Empleado {
    private Persona persona; // Relación de asociación
    private String puesto;

    // Métodos y atributos adicionales para Empleado
}

// Clase Estudiante que hereda de Persona
public class Estudiante extends Persona {
    private String curso;

    // Métodos y atributos adicionales para Estudiante
}
```

### Explicación

En este __ejemplo__, _Empleado_ tiene una __relación de asociación__ con _Persona_, y _Estudiante_ __hereda__ de _Persona._ 


</div>