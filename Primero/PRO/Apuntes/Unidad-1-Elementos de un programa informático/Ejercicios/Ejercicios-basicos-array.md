<div align="justify">

# Ejercicios de Array´s en Java

Realiza los siguientes ejercicios. Se debe de trabajar con __array´s, búcles (for/while/do while), y condicionales (if/else/else if)__, siempre y cuando sea necesario.

## Ejercicio 1: Suma de Elementos

_Escribe un programa que calcule la suma de todos los elementos en un array de enteros_.

### Explicación

Este programa calcula la suma de todos los elementos en el array, por ejemlo __{1, 2, 3, 4, 5}__. En cada iteración del bucle, se agrega el valor del elemento actual al acumulador suma. Al final, se imprime el resultado de la suma, que en este caso es 15.

- Declaración y asignación del array:

    ```java
    int[] array = {1, 2, 3, 4, 5};
    ```
 
  - Se declara un array llamado array que puede contener enteros.
  - Se inicializa el array con los valores {1, 2, 3, 4, 5}. Esto significa que el array tiene cinco elementos con los valores 1, 2, 3, 4 y 5 respectivamente.
- Inicialización de la variable de suma:

    ```java
    int suma = 0;
    ```

  - Se declara e inicializa una variable suma con el valor __0__. Esta variable se utilizará para almacenar la suma de los elementos del array.

- Iteración a través del array:

    ```java
    for (int i = 0; i < array.length; i++) {
        suma += array[i];
    }
    ```

  - Se utiliza un bucle __for__ para iterar sobre cada elemento del array.
  - __i__ es un contador que comienza en 0 y se incrementa en cada iteración hasta que alcanza la longitud del array (array.length).
  - __array[i]__ accede al elemento en la posición i del array y lo suma a la variable suma.
- Imprimir el resultado:

    ```java
    System.out.println("La suma de los elementos es: " + suma);
    ```

  - Se imprime en la consola el resultado de la suma.   

__Se pide__:

- Realiza el ejercicio plateado, utilizando funciones.
- Realiza __test__ que verifiquen el correcto comportamiento de la función/es creada/s.

Comó ayuda en el primer ejercicio toma el siguiente código de ejemplo:

```java
public class Ejercicio1 {
    public static void main(String[] args) {

        public int sumar() {
            int[] array = {1, 2, 3, 4, 5};
            int suma = 0;

            for (int i = 0; i < array.length; i++) {
                suma += array[i];
            }
        }    

        System.out.println("La suma de los elementos es: " + suma);
    }
}

```

## Ejercicio 2: Promedio

Calcula el promedio de los elementos en un array de números en punto flotante.

### Explicación:

Declaración y asignación del array:
Supongamos que tenemos el siguiente array de números en punto flotante:

```java
float[] array = {1.5f, 2.5f, 3.5f, 4.5f, 5.5f};
```

Inicialización de la variable de suma y promedio:
Inicializamos dos variables, suma y promedio:

```java
float suma = 0;
float promedio;
```

Iteración a través del array:
Recorremos el array y sumamos cada elemento a la variable suma:

```java
for (int i = 0; i < array.length; i++) {
    suma += array[i];
}
```

Cálculo del promedio: Una vez que tenemos la suma de todos los elementos, calculamos el promedio:

```java
promedio = suma / array.length;
```

__El resultado final es el promedio de los elementos en el array__.

| Elemento | Suma Parcial |
|----------|--------------|
|   1.5    |     1.5      |
|   2.5    |     4.0      |
|   3.5    |     7.5      |
|   4.5    |    12.0      |
|   5.5    |    17.5      |

**Suma Total:** 17.5

**Promedio:** 3.5

Esta tabla representa el proceso paso a paso de calcular el promedio de los elementos en el array {1.5, 2.5, 3.5, 4.5, 5.5}. Cada fila muestra el elemento actual y la suma parcial acumulada. Al final, se presenta la suma total y el promedio calculado.

__Se pide__:

- Realiza el ejercicio plateado, utilizando funciones.
- Realiza __test__ que verifiquen el correcto comportamiento de la función/es creada/s.

## Ejercicio 3: Mayor y Menor

Encuentra el valor máximo y mínimo en un array de enteros.

### Explicación

Utiliza los ejemplos de los apuntes proporcionados para realizar este ejercicio.

__Se pide__:

- Realiza el ejercicio plateado, utilizando funciones.
- Realiza __test__ que verifiquen el correcto comportamiento de la función/es creada/s.

## Ejercicio 4: Números Pares

Imprime los números pares de un array de enteros.

### Explicación

Utiliza los ejemplos de los apuntes proporcionados para realizar este ejercicio.

__Se pide__:

- Realiza el ejercicio plateado, utilizando funciones.
- Realiza __test__ que verifiquen el correcto comportamiento de la función/es creada/s.

## Ejercicio 5: Buscar Elemento

Dado un valor específico, encuentra su posición en el array o indica si no está presente.

### Explicación

Utiliza los ejemplos de los apuntes proporcionados para realizar este ejercicio.

__Se pide__:

- Realiza el ejercicio plateado, utilizando funciones.
- Realiza __test__ que verifiquen el correcto comportamiento de la función/es creada/s.

## Ejercicio 6: Matriz Transpuesta

Dada una matriz cuadrada, encuentra su transpuesta.

### Explicación

La matriz transpuesta de una matriz cuadrada es una operación que implica __intercambiar sus filas y columnas__. Esto significa que los elementos que estaban en las filas de la matriz original ahora estarán en las columnas de la matriz transpuesta y viceversa. La matriz transpuesta se denota comúnmente con una __"T"__ sobrescrita, por ejemplo, __"A^T"__ para la matriz transpuesta de __"A"__.

Veamos un ejemplo de lo que se pedi:

#### Matriz Original

Aquí hay una matriz original de 3x3:

```code
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
```

##### Matriz Transpuesta

La matriz transpuesta se obtiene intercambiando filas por columnas:

```code
| 1 | 4 | 7 |
| 2 | 5 | 8 |
| 3 | 6 | 9 |
```

En la matriz transpuesta, los elementos que estaban en la primera fila de la matriz original ahora están en la primera columna, los elementos de la segunda fila están en la segunda columna y los elementos de la tercera fila están en la tercera columna.

## Ejercicio 7: Ordenar en Orden Ascendente

Ordena un array de enteros en orden ascendente.

### Explicación

Utiliza los ejemplos de los apuntes proporcionados para realizar este ejercicio.

__Se pide__:

- Realiza el ejercicio plateado, utilizando funciones.
- Realiza __test__ que verifiquen el correcto comportamiento de la función/es creada/s.

## Ejercicio 8: Eliminar Duplicados

Elimina elementos duplicados de un array, y muestra finalmente los valores iniciales del array y el resultado final.

### Explicación

Utiliza los ejemplos de los apuntes proporcionados para realizar este ejercicio.

__Se pide__:

- Realiza el ejercicio plateado, utilizando funciones.
- Realiza __test__ que verifiquen el correcto comportamiento de la función/es creada/s.

## Ejercicio 9: Combinar Dos Arrays

Combina dos arrays ordenados en uno solo manteniendo el orden.

### Explicación

Utiliza los ejemplos de los apuntes proporcionados para realizar este ejercicio.

__Se pide__:

- Realiza el ejercicio plateado, utilizando funciones.
- Realiza __test__ que verifiquen el correcto comportamiento de la función/es creada/s.

## Ejercicio 10: Matriz Diagonal

Comprueba si una matriz es diagonal (todos los elementos fuera de la diagonal principal son cero).

### Explicación:

Una matriz diagonal __es una matriz cuadrada__ en la cual __todos los elementos fuera de la diagonal principal son 0__. La diagonal principal es la secuencia de elementos que va desde la esquina superior izquierda hasta la esquina inferior derecha de la matriz.

#### Matriz Original (Ej1)

```code
| 1 | 0 | 0 |
| 0 | 4 | 0 |
| 0 | 0 | 9 |
```

En esta matriz, __todos los elementos fuera de la diagonal principal son cero. Los elementos en la diagonal principal (1, 4 y 9) pueden ser cualquier valor, pero los demás deben ser cero para que se considere una matriz diagonal__.

#### Matriz Original (Ej2)

```code
| 2 | 0 | 0 | 0 |
| 0 | 7 | 0 | 0 |
| 0 | 0 | 5 | 0 |
| 0 | 0 | 0 | 3 |
```

Al igual que en el caso anterior se trata de una __matriz diagonal__.

#### Matriz Original (Ej3)

```code
| 1 | 0 | 2 |
| 0 | 3 | 0 |
| 0 | 0 | 5 |
```

Esta matriz __NO es diagonal__ _porque tiene elementos diferentes de cero fuera de la diagonal principal_ (en este caso, el 2 y el 3).

> __Nota__: _A la hora de ejecutar el algoritmo ten en cuena las condiciones a evaluar en una matriz diagonal_.

__Se pide__:

- Realiza el ejercicio plateado, utilizando funciones.
- Realiza __test__ que verifiquen el correcto comportamiento de la función/es creada/s.

</div>