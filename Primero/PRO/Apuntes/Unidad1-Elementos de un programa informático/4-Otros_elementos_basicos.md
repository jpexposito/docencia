<div align="justify">

# Trabajo con elementos y ordenación

Supongamos que tenemos 5 números, puedes utilizar un enfoque simple de comparación e intercambio. Aquí tienes un ejemplo en Java:

```java
public class OrdenarNumeros {

    public static void main(String[] args) {
        int num1 = 30;
        int num2 = 10;
        int num3 = 50;
        int num4 = 20;
        int num5 = 40;

        // Ordenamos los números
        if (num1 > num2) { 
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if (num2 > num3) { 
            int temp = num2;
            num2 = num3;
            num3 = temp;
        }
        if (num3 > num4) {
            int temp = num3;
            num3 = num4;
            num4 = temp; 
        }
        if (num4 > num5) {
            int temp = num4;
            num4 = num5;
            num5 = temp;
        }
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
            }
        if (num2 > num3) {
            int temp = num2;
            num2 = num3;
            num3 = temp;
        }
        if (num3 > num4) {
            int temp = num3;
            num3 = num4;
            num4 = temp;
        }
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if (num2 > num3) {
            int temp = num2;
            num2 = num3;
            num3 = temp;
        }
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        // Mostramos los números ordenados
        System.out.println("Números ordenados: " + num1 + ", " + num2 + ", " + num3 + ", " + num4 + ", " + num5);
    }
}

```


# Arrays Unidimensionales

Un array es una estructura para guardar un conjunto de objetos de la misma clase. Se accede a cada elemento individual del array mediante un número entero denominado índice (index en inglés). 0 es el índice del primer elemento y n-1 es el índice del último elemento, siendo n, la dimensión del array.

Para declarar un array se usa la siguiente sintaxis:

```
tipo_de_dato[] nombre_del_array;
```

Por, ejemplo, para declarar un array de enteros escribimos lo siguiente:
```java
int[] numeros;
```
Para crear un array de 4 números enteros escribimos lo siguiente:

```java
numeros = new int[4];
```

La declaración y la creación del array se puede hacer en una misma línea:

```java
int[] numeros = new int[4];
```

Para inicializar el array de 4 enteros escribimos lo siguiente:

```java
int[] numeros = new int[4];
numeros[0] = 2;
numeros[1] = -4;
numeros[2] = 15;
numeros[3] = -25;
```

Los arrays se pueden declarar, crear e inicializar en una misma línea, de la siguiente manera:

```java
int[] numeros = {2, -4, 15, -25};
String[] nombres = {"Juan", "José", "Miguel", "Antonio"};
```

Para imprimir a los elementos de array nombres se escribe

```java
for(int i=0; i < nombres.length; i++){
System.out.println(nombres[i]);
}
```

Un array tiene la propiedad __length__, que retorna su número de elementos.

Veamos algunos ejemplos:

1. Inicializar y Acceder a Elementos en un Array:

```java
public class EjemploArrays {

    public static void main(String[] args) {
        // Inicializar un arreglo de enteros
        int[] numeros = {10, 20, 30, 40, 50};

        // Acceder a elementos del arreglo
        System.out.println("El primer elemento es: " + numeros[0]);
        System.out.println("El segundo elemento es: " + numeros[1]);
    }
}

```

2. Recorrer un Array con un Bucle:

```java
public class EjemploArrays {

    public static void main(String[] args) {
        // Inicializar un arreglo de cadenas
        String[] nombres = {"Juan", "María", "Carlos", "Elena"};

        // Recorrer el arreglo e imprimir los elementos
        for (String nombre : nombres) {
            System.out.println("Nombre: " + nombre);
        }
    }
}

```

3. Encontrar el Valor Máximo en un Array:

```java
public class EjemploArrays {

    public static void main(String[] args) {
        int[] numeros = {30, 10, 50, 20, 40};

        int maximo = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }

        System.out.println("El valor máximo es: " + maximo);
    }
}

```

4. Copiar un Array a Otro:

```java
public class EjemploArrays {

    public static void main(String[] args) {
        int[] arregloOriginal = {1, 2, 3, 4, 5};
        int[] copia = new int[arregloOriginal.length];

        // Copiar elementos del arreglo original a la copia
        for (int i = 0; i < arregloOriginal.length; i++) {
            copia[i] = arregloOriginal[i];
        }

        // Imprimir la copia
        System.out.println("Copia del arreglo original:");
        for (int elemento : copia) {
            System.out.print(elemento + " ");
        }
    }
}

```

5. Ordenar un Array:


```java
import java.util.Arrays;

public class EjemploArrays {

    public static void main(String[] args) {
        int[] numeros = {30, 10, 50, 20, 40};

        // Ordenar el arreglo
        Arrays.sort(numeros);

        // Imprimir el arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}

```

Sin Sort

```java
public class EjemploBubbleSort {

    public static void main(String[] args) {
        int[] numeros = {30, 10, 50, 20, 40};

        // Llamamos a la función de ordenación
        bubbleSort(numeros);

        // Imprimimos el arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // Intercambiar arr[j] y arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

```

En este ejemplo, la función __bubbleSort__ implementa el algoritmo de ordenación _Bubble Sort_. Funciona _comparando elementos adyacentes y los intercambia si están en el orden incorrecto. Este proceso se repite hasta que el arreglo esté completamente ordenado_.

Por favor, ten en cuenta que __Bubble Sort__ __NO__ es la opción más eficiente para grandes conjuntos de datos, ya que tiene una complejidad de tiempo de __O(n^2)__. Para conjuntos de datos más grandes, se recomiendan algoritmos más eficientes como __QuickSort o MergeSort__.

</div>