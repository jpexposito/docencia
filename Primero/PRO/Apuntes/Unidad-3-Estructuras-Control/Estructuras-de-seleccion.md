<div align="justify">

# Estructuras de Selección en Java

Las estructuras de selección en Java permiten que un programa tome decisiones basadas en condiciones específicas. Las estructuras más comunes son if, else if, else y el operador ternario ? :. Aquí tienes una explicación de cómo funcionan:

## Estructura if simple:

```java
int edad = 20;

if (edad >= 18) {
    System.out.println("Eres mayor de edad");
}
```

El bloque de código dentro del if se ejecutará solo si la condición es verdadera.

## Estructura if y else:

```java
int edad = 15;

if (edad >= 18) {
    System.out.println("Eres mayor de edad");
} else {
    System.out.println("Eres menor de edad");
}
```

El bloque dentro del if se ejecutará si la condición es verdadera; de lo contrario, se ejecutará el bloque dentro del else.

### Estructura if, else if y else:

```java
int edad = 15;

if (edad >= 18) {
    System.out.println("Eres mayor de edad");
} else if (edad >= 13) {
    System.out.println("Eres un adolescente");
} else {
    System.out.println("Eres un niño");
}
```

Se evalúan múltiples condiciones en orden. Se ejecutará el bloque del primer if o else if cuya condición sea verdadera.

## Operador Ternario ? ::

```java
int edad = 20;

String mensaje = (edad >= 18) ? "Eres mayor de edad" : "Eres menor de edad";
System.out.println(mensaje);
```

El operador ternario permite asignar un valor a una variable basándose en una condición. Es una forma más concisa de escribir una estructura if-else.
## Switch-Case:

```java
char letra = 'A';

switch (letra) {
    case 'A':
        System.out.println("La letra es A");
        break;
    case 'B':
        System.out.println("La letra es B");
        break;
    default:
        System.out.println("Letra desconocida");
}
```

__switch__ se utiliza para seleccionar uno de varios bloques de código para ejecutar, dependiendo del valor de una expresión.



</div>