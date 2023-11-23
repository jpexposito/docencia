<div align="justify">

# Estructuras de Repetición en Java

## Ejemplo de break

```java
// Utilizando break para salir de un bucle cuando se encuentra un número específico

public class EjemploBreak {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numeroBuscado = 7;

        for (int num : numeros) {
            System.out.println("Revisando número: " + num);

            if (num == numeroBuscado) {
                System.out.println("Número encontrado. Saliendo del bucle.");
                break;  // Sale del bucle cuando encuentra el número buscado.
            }
        }
    }
}
```

>__Nota__:En este ejemplo, el bucle for recorre el array numeros y, al encontrar el número buscado, se ejecuta break para salir del bucle.

## Ejemplo de continue

```java
// Utilizando continue para omitir la impresión de números pares

public class EjemploContinue {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Número par encontrado. Continuando con la siguiente iteración.");
                continue;  // Salta a la siguiente iteración si el número es par.
            }

            System.out.println("Número impar: " + i);
        }
    }
}
``````

En este ejemplo, el bucle __for__ itera sobre los números del __1 al 10__. Cuando encuentra un __número par__, se ejecuta __continue__, lo que __salta a la siguiente iteración__ del bucle sin ejecutar el código restante dentro del bucle para ese número en particular.



</div>