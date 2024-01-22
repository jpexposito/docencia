<div align="justify">

# Ejemplos de trabajo con Collection

## Almacenar y Manipular Elementos de Tipo String

```java
import java.util.ArrayList;

public class EjemploArrayListString {
    public static void main(String[] args) {
        // Crear un ArrayList de Strings
        ArrayList<String> listaDeNombres = new ArrayList<>();

        // Agregar elementos a la lista
        listaDeNombres.add("Juan");
        listaDeNombres.add("María");
        listaDeNombres.add("Carlos");

        // Imprimir elementos
        System.out.println("Lista de Nombres: " + listaDeNombres);

        // Obtener y modificar un elemento
        String nombre = listaDeNombres.get(1);
        System.out.println("Nombre en la posición 1: " + nombre);

        // Eliminar un elemento
        listaDeNombres.remove("María");
        System.out.println("Lista después de eliminar a María: " + listaDeNombres);
    }
}
```

## Almacenar Objetos Personalizados

```java
import java.util.ArrayList;

class Estudiante {
    String nombre;
    int edad;

    Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}

public class EjemploArrayListObjetos {
    public static void main(String[] args) {
        // Crear un ArrayList de objetos Estudiante
        ArrayList<Estudiante> listaDeEstudiantes = new ArrayList<>();

        // Agregar objetos a la lista
        listaDeEstudiantes.add(new Estudiante("Ana", 20));
        listaDeEstudiantes.add(new Estudiante("Pedro", 22));
        listaDeEstudiantes.add(new Estudiante("Laura", 21));

        // Imprimir objetos
        System.out.println("Lista de Estudiantes: " + listaDeEstudiantes);

        // Obtener un objeto y modificar sus propiedades
        Estudiante estudiante = listaDeEstudiantes.get(1);
        estudiante.edad = 23;
        System.out.println("Lista después de modificar la edad de Pedro: " + listaDeEstudiantes);
    }
}
```

## Uso de Iteradores

```java
import java.util.ArrayList;
import java.util.Iterator;

public class EjemploArrayListIterador {
    public static void main(String[] args) {
        // Crear un ArrayList de enteros
        ArrayList<Integer> listaDeNumeros = new ArrayList<>();

        // Agregar elementos a la lista
        for (int i = 1; i <= 5; i++) {
            listaDeNumeros.add(i);
        }

        // Utilizar un iterador para recorrer la lista y realizar operaciones
        Iterator<Integer> iterador = listaDeNumeros.iterator();
        while (iterador.hasNext()) {
            int numero = iterador.next();
            System.out.println("Número: " + numero);

            // Eliminar números pares
            if (numero % 2 == 0) {
                iterador.remove();
            }
        }

        // Imprimir la lista después de eliminar números pares
        System.out.println("Lista después de eliminar números pares: " + listaDeNumeros);
    }
}
```

</div>