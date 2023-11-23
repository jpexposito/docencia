<div align="justify">

# Estructuras de Repetición en Java

Las estructuras de repetición en Java, también conocidas como bucles, permiten ejecutar un bloque de código varias veces. Las tres estructuras principales son for, while y do-while. Aquí tienes una explicación de cómo funcionan:

## Bucle for:

```java

for (int i = 1; i <= 5; i++) {
    System.out.println("Iteración " + i);
}
```

El __bucle__ for consta de tres partes: la inicialización __(int i = 1)__, la condición de continuación __(i <= 5)__, y la expresión de incremento __(i++)__. El bloque de código dentro del bucle se ejecutará mientras la condición sea verdadera.

## Bucle while:

```java
int contador = 1;

while (contador <= 5) {
    System.out.println("Iteración " + contador);
    contador++;
}
```

El bucle __while__ sigue ejecutándose __mientras la condición sea verdadera__. Es importante asegurarse de que la condición eventualmente sea falsa para evitar un bucle infinito.

## Bucle do-while:

```java

int contador = 1;

do {
    System.out.println("Iteración " + contador);
    contador++;
} while (contador <= 5);
```

Similar al bucle while, pero la condición __se evalúa después de ejecutar el bloque de código__. Esto garantiza que el bloque de código se ejecute al menos una vez, incluso si la condición es falsa desde el principio.

## Bucle foreach (para colecciones):

```java
int[] numeros = {1, 2, 3, 4, 5};

for (int num : numeros) {
    System.out.println(num);
}
```

Utilizado para _iterar sobre elementos de una colección, como arrays_. En cada iteración, la __variable num__ _toma el valor del siguiente elemento_ en la colección.

## Control de Flujo en Bucles:

- __break__: Termina la ejecución del bucle.
- __continue__: Salta a la siguiente iteración del bucle.

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;  // Sale del bucle cuando i es 5
    }

    if (i % 2 == 0) {
        continue;  // Salta a la siguiente iteración si i es par
    }

    System.out.println(i);
}
```


</div>