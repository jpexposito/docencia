<div align="justify">

# Agregación y Composición en Programación Orientada a objetos

En Java, la __agregación y la composición__ son dos formas de __establecer relaciones entre clases y objetos__. Ambos son __mecanismos fundamentales__ para la construcción de __estructuras de datos complejas__.

## Agregación

La agregación es una relación entre dos clases donde una clase contiene una referencia a otra, pero ambas pueden existir independientemente. La clase que contiene la referencia se conoce como la __clase contenedora__, y la clase que es __referenciada__ se conoce como la __clase contenida__.

Un ejemplo común de agregación es una relación entre una clase __"Universidad"__ y una clase __"Estudiante"__:

```java

public class Estudiante {
    private String nombre;
    private int edad;
    // Otros atributos y métodos
}

public class Universidad {
    private List<Estudiante> estudiantes;
    
    public Universidad() {
        this.estudiantes = new ArrayList<>();
    }
    
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
}
```

__En este ejemplo, la clase Universidad tiene una lista de estudiantes como referencia. Si la universidad se destruye, los estudiantes aún pueden existir de forma independiente__.

## Composición

La __composición__ es una relación más fuerte entre dos clases, donde __una clase contiene a la otra como parte fundamental de su estructura__. En una relación de composición, si la clase contenedora se destruye, también lo hacen las clases contenidas.

Un ejemplo común de composición es una relación entre una clase __"Casa"__ y una clase __"Habitación"__:

```java
public class Habitacion {
    private int area;
    // Otros atributos y métodos
    
    public Habitacion(int area) {
        this.area = area;
    }
}

public class Casa {
    private Habitacion habitacionPrincipal;
    private Habitacion habitacionSecundaria;
    
    public Casa(int areaHabitacionPrincipal, int areaHabitacionSecundaria) {
        this.habitacionPrincipal = new Habitacion(areaHabitacionPrincipal);
        this.habitacionSecundaria = new Habitacion(areaHabitacionSecundaria);
    }
}
```

_En este ejemplo, la clase Casa tiene dos habitaciones (_ __habitacionPrincipal y habitacionSecundaria__ _) como parte esencial de su estructura. Si se destruye una casa, también se destruyen sus habitaciones_.

## Conclusiones

La agregación y la composición son __dos formas importantes de establecer relaciones entre clases__. Es esencial entender cuándo usar cada una, dependiendo de la naturaleza de la relación entre los objetos que estás modelando.








</div>