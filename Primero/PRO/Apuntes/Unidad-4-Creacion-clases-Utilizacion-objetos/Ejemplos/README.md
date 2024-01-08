<div align="justify">

# Ejemplos de Herencia en Java

## Herencia Básica

Supongamos que tenemos una clase base Vehiculo y queremos crear una subclase Coche que herede de Vehiculo.

```java
// Clase base
public class Vehiculo {
    public void mover() {
        System.out.println("El vehículo se está moviendo.");
    }
}

// Subclase
public class Coche extends Vehiculo {
    public void encender() {
        System.out.println("El coche está encendido.");
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Coche miCoche = new Coche();
        miCoche.mover();   // Método heredado de Vehiculo
        miCoche.encender();  // Método propio de Coche
    }
}
```

## Herencia con Constructores

En este ejemplo, la superclase Persona tiene un constructor que inicializa el nombre, y la subclase Estudiante utiliza super para llamar al constructor de la superclase.

```java
// Superclase
public class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarNombre() {
        System.out.println("Nombre: " + nombre);
    }
}

// Subclase
public class Estudiante extends Persona {
    private int codigo;

    public Estudiante(String nombre, int codigo) {
        super(nombre);  // Llamada al constructor de la superclase
        this.codigo = codigo;
    }

    public void mostrarCodigo() {
        System.out.println("Código: " + codigo);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Juan", 123);
        estudiante.mostrarNombre();
        estudiante.mostrarCodigo();
    }
}
```

## Sobrescritura de Métodos

En este ejemplo, la subclase Gato sobrescribe el método hacerSonido de la superclase Animal.

```java
// Superclase
public class Animal {
    public void hacerSonido() {
        System.out.println("El animal hace un sonido.");
    }
}

// Subclase
public class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El gato maulla.");
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Animal miGato = new Gato();
        miGato.hacerSonido();  // Método sobrescrito de la subclase
    }
}
```

## Conclusión

Estos ejemplos ilustran diferentes aspectos de la herencia en Java y cómo se puede utilizar para reutilizar código y extender funcionalidades de clases existentes.

</div>