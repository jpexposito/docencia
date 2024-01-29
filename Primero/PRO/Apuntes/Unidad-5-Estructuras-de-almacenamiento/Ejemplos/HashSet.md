<div align="justify">

# Ejemplos de trabajo con Collection (HashSet)

## Agregar Alumnos al Registro

Crea un HashSet para almacenar los nombres de los alumnos en un colegio. Agrega algunos nombres utilizando el método add() y muestra el registro.

```java
import java.util.HashSet;

public class Ejercicio1 {
    public static void main(String[] args) {
        HashSet<String> registroAlumnos = new HashSet<>();
        registroAlumnos.add("Juan Perez");
        registroAlumnos.add("Ana García");
        registroAlumnos.add("Carlos López");

        System.out.println("Registro de Alumnos después de agregar: " + registroAlumnos);
    }
}
```

## Verificar la Existencia de un Alumno

Crea un HashSet con nombres de alumnos y verifica si un alumno específico está matriculado utilizando contains().

```java
import java.util.HashSet;

public class Ejercicio2 {
    public static void main(String[] args) {
        HashSet<String> registroAlumnos = new HashSet<>();
        registroAlumnos.add("Luis Ramirez");
        registroAlumnos.add("María Torres");
        registroAlumnos.add("Pedro Gómez");

        String alumnoBuscado = "María Torres";
        System.out.println("¿Está " + alumnoBuscado + " matriculado? " + registroAlumnos.contains(alumnoBuscado));
    }
}
```

## Eliminar Alumno del Registro

Crea un HashSet con nombres de alumnos y elimina a un alumno específico utilizando remove().

```java
import java.util.HashSet;

public class Ejercicio3 {
    public static void main(String[] args) {
        HashSet<String> registroAlumnos = new HashSet<>();
        registroAlumnos.add("Laura González");
        registroAlumnos.add("Roberto Martínez");
        registroAlumnos.add("Sofía Díaz");

        String alumnoAEliminar = "Roberto Martínez";
        registroAlumnos.remove(alumnoAEliminar);

        System.out.println("Registro de Alumnos después de eliminar a " + alumnoAEliminar + ": " + registroAlumnos);
    }
}
```

## Obtener Cantidad de Alumnos

Crea un HashSet con nombres de alumnos y muestra la cantidad total de alumnos utilizando size().

```java
import java.util.HashSet;

public class Ejercicio4 {
    public static void main(String[] args) {
        HashSet<String> registroAlumnos = new HashSet<>();
        registroAlumnos.add("Elena Vargas");
        registroAlumnos.add("Javier Flores");

        System.out.println("Cantidad de Alumnos en el registro: " + registroAlumnos.size());
    }
}
```

## Limpiar el Registro de Alumnos

Crea un HashSet con nombres de alumnos, agrega algunos alumnos y luego utiliza clear() para vaciar el registro.

```java
import java.util.HashSet;

public class Ejercicio5 {
    public static void main(String[] args) {
        HashSet<String> registroAlumnos = new HashSet<>();
        registroAlumnos.add("Isabel Torres");
        registroAlumnos.add("Mario González");

        registroAlumnos.clear();

        System.out.println("Registro de Alumnos después de limpiar: " + registroAlumnos);
    }
}
```

## Listar Alumnos Matriculados 

Crea un HashSet con nombres de alumnos y utiliza un bucle for-each para imprimir cada alumno matriculado.

```java
import java.util.HashSet;

public class Ejercicio6 {
    public static void main(String[] args) {
        HashSet<String> registroAlumnos = new HashSet<>();
        registroAlumnos.add("Leticia Rojas");
        registroAlumnos.add("Miguel Sánchez");

        System.out.print("Alumnos matriculados: ");
        for (String alumno : registroAlumnos) {
            System.out.print(alumno + ", ");
        }
    }
}
```

## Unir dos Registros de Alumnos

Crea dos HashSet con nombres de alumnos y únelos en uno nuevo utilizando addAll().

```java
import java.util.HashSet;

public class Ejercicio7 {
    public static void main(String[] args) {
        HashSet<String> registroGrupoA = new HashSet<>();
        registroGrupoA.add("Alejandro Pérez");
        registroGrupoA.add("Laura Ramírez");

        HashSet<String> registroGrupoB = new HashSet<>();
        registroGrupoB.add("Carlos Martínez");
        registroGrupoB.add("Sandra López");

        HashSet<String> registroTotal = new HashSet<>(registroGrupoA);
        registroTotal.addAll(registroGrupoB);

        System.out.println("Registro total de Alumnos: " + registroTotal);
    }
}
```

## Verificar si el Registro de Alumnos está Vacío

Crea un HashSet con nombres de alumnos, elimina todos los alumnos y verifica si el registro está vacío utilizando isEmpty().

```java
import java.util.HashSet;

public class Ejercicio8 {
    public static void main(String[] args) {
        HashSet<String> registroAlumnos = new HashSet<>();
        registroAlumnos.add("Carmen Gómez");
        registroAlumnos.add("Francisco Ruiz");

        registroAlumnos.clear();

        System.out.println("¿El registro de Alumnos está vacío? " + registroAlumnos.isEmpty());
    }
}
```

## Convertir el Registro de Alumnos a un Array

Crea un HashSet con nombres de alumnos y conviértelo a un array utilizando toArray().

```java
import java.util.HashSet;

public class Ejercicio9 {
    public static void main(String[] args) {
        HashSet<String> registroAlumnos = new HashSet<>();
        registroAlumnos.add("Luisa Fernández");
        registroAlumnos.add("Héctor Soto");

        Object[] arrayAlumnos = registroAlumnos.toArray();

        System.out.print("Array de Alumnos: ");
        for (Object alumno : arrayAlumnos) {
            System.out.print(alumno + ", ");
        }
    }
}
```

## Comparar Registros de Alumnos

Crea dos HashSet con nombres de alumnos, compáralos y muestra los alumnos que están en ambos registros utilizando retainAll().

```java
import java.util.HashSet;

public class Ejercicio10 {
    public static void main(String[] args) {
        HashSet<String> registroGrupoA = new HashSet<>();
        registroGrupoA.add("Pedro Rodríguez");
        registroGrupoA.add("Elena Vargas");

        HashSet<String> registroGrupoB = new HashSet<>();
        registroGrupoB.add("Elena Vargas");
        registroGrupoB.add("Juan López");

        HashSet<String> alumnosComunes = new HashSet<>(registroGrupoA);
        alumnosComunes.retainAll(registroGrupoB);

        System.out.println("Alumnos comunes en ambos grupos: " + alumnosComunes);
    }
}
```

</div>