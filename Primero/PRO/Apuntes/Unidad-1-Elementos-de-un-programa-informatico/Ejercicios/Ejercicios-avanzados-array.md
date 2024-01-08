<div align="justify">

# Ejercicios de Array´s en Java

Realiza los siguientes ejercicios. Se debe de trabajar con __array´s, búcles (for/while/do while), y condicionales (if/else/else if)__, siempre y cuando sea necesario.

## Ejericicio 1

### Descripción

- Se quiere realizar un programa que lea por teclado las 5 notas obtenidas por un alumno (comprendidas entre 0 y 10), y almacenadas en un array. A continuación debe mostrar todas las notas, la nota media, la nota más alta que ha sacado y la menor.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>

  En primer lugar hemos de crear la clase __Ejericicio1__.
  
  </br>
  
  ```java
  import java.util.Scanner;

public class Ejericicio1 {
    //Haremos uso del main
    public static void main(String[] args) {
        // Crear un array para almacenar las notas
        double[] notas = new double[5];

        // Utilizar un Scanner para leer las notas desde el teclado
        Scanner scanner = new Scanner(System.in);

        // Leer las notas
        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce la nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();

            // Verificar que la nota esté en el rango de 0 a 10
            while (notas[i] < 0 || notas[i] > 10) {
                System.out.println("Error: La nota debe estar entre 0 y 10.");
                System.out.print("Introduce la nota " + (i + 1) + " nuevamente: ");
                notas[i] = scanner.nextDouble();
            }
        }

        // Cerrar el Scanner
        scanner.close();

        // Mostrar todas las notas
        System.out.println("\nTodas las notas:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Nota " + (i + 1) + ": " + notas[i]);
        }

        // Calcular la nota media
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        double media = suma / notas.length;

        // Encontrar la nota más alta y la nota más baja
        double notaMasAlta = notas[0];
        double notaMasBaja = notas[0];

        // Realizamos la ordenacion
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > notaMasAlta) {
                notaMasAlta = notas[i];
            }
            else if (notas[i] < notaMasBaja) {
                notaMasBaja = notas[i];
            }
            //El else siguiente no es necesario ya que seria igual
        }

        // Mostrar resultados
        System.out.println("\nNota media: " + media);
        System.out.println("Nota más alta: " + notaMasAlta);
        System.out.println("Nota más baja: " + notaMasBaja);
    }
}
  ```
</details>
  </br>

## Ejericicio 2

### Descripción

Programa que declare un array de diez elementos enteros y pida números para rellenarlo hasta que se llene el vector o se introduzca un número negativo. Entonces se debe imprimir el array (sólo los elementos introducidos).

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
 
  En primer lugar hemos de crear la clase __Ejericicio2__.
 </br>

  ```java
  import java.util.Scanner;

public class Ejericicio2 {
    public static void main(String[] args) {
        // Crear un array de diez elementos enteros
        int[] numeros = new int[10];

        // Utilizar un Scanner para leer números desde el teclado
        Scanner scanner = new Scanner(System.in);

        // Pedir números al usuario hasta que se llene el array o se introduzca un número negativo
        int indice = 0;
        int numero;
        do {
            System.out.print("Introduce un número (introduce un número negativo para finalizar): ");
            numero = scanner.nextInt();

            // Verificar si el número es negativo
            if (numero >= 0) {
                // Almacenar el número en el array
                numeros[indice] = numero;
                indice++;
            } else {
                // Salir del bucle si se introduce un número negativo
                break;
            }

            // Verificar si el array está lleno
            if (indice == numeros.length) {
                System.out.println("El array está lleno. Se detiene la entrada de números.");
                break;
            }
        } while (true);

        // Cerrar el Scanner
        scanner.close();

        // Imprimir los elementos introducidos en el array
        System.out.println("\nElementos del array:");
        for (int i = 0; i < indice; i++) {
            System.out.println("Elemento " + (i + 1) + ": " + numeros[i]);
        }
    }
}

  ```


</details>

## Ejericicio 3

### Descripción

Programa que declare tres array ‘array1’, ‘array2’ y ‘array3’ de cinco enteros cada uno, pida valores para ‘array1’ y ‘array2’ y calcule array3=array1+array2, posición a posición y el total de ambos array sumados.

## Ejericicio 4

### Descripción

Diseñar el algoritmo correspondiente a un programa, que:
  - Crea una tabla bidimensional de longitud 5x5 y nombre ‘matriz’.
  - Carga la tabla con valores numéricos enteros.
  - Suma todos los elementos de cada fila y todos los elementos de cada columna visualizando los resultados en pantalla.

## Ejericicio 5

### Descripción

Diseñar el algoritmo correspondiente a un programa, que:
- Crea una tabla bidimensional de longitud 5x5 y nombre ‘diagonal’.
- Carga la tabla de forma que los componentes pertenecientes a la diagonal de la matriz tomen el valor 1 y el resto el valor 0.
- Muestra el contenido de la tabla en pantalla.

## Ejericicio 6

### Descripción

Diseñar el algoritmo correspondiente a un programa, que:
- Crea una tabla bidimensional de longitud 5x15 y nombre ‘marco’.
- Carga la tabla con dos únicos valores 0 y 1, donde el valor uno ocupará las posiciones o elementos que delimitan la tabla, es decir, las más externas, mientras que el resto de los elementos contendrán el valor 0.

```
  111111111111111
  100000000000001
  100000000000001
  100000000000001
  111111111111111
```

- Visualiza el contenido de la matriz en pantalla.

## Ejericicio 7

### Descripción

De una empresa de transporte se quiere guardar el nombre de los conductores que tiene, y los kilómetros que conducen cada día de la semana.

Para guardar esta información se van a utilizar dos array´s:
- Nombre: Array para guardar los nombres de los conductores.
- kms: Matriz para guardar los kilómetros que realizan cada día de la semana.
- Se quiere generar un nuevo vector (“total_kms”) con los kilómetros totales que realza cada conductor.
- Al finalizar se muestra la lista con los nombres de conductores y los kilómetros que ha realizado.


</div>