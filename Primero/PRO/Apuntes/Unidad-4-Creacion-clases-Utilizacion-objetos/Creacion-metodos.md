<div align="justify">

En Java, un método es un bloque de código que realiza una tarea específica. 

## Sintaxis Básica

### Definición de un Método sin Parámetros y sin Valor de Retorno

```java
public void miMetodo() {
    // Cuerpo del método
    System.out.println("Hola, este es mi método.");
}
```

- __public void miMetodo()__: Indica que el método es público, no tiene un valor de retorno (void), y se llama miMetodo.
- __{...}__: Contiene el cuerpo del método donde se ejecutan las instrucciones.

### Definición de un Método con Parámetros y con Valor de Retorno

```java
public int sumar(int num1, int num2) {
    // Cuerpo del método
    int suma = num1 + num2;
    return suma;
}
```

- __public int sumar(int num1, int num2)__: Indica que el método es público, devuelve un valor entero (int), se llama sumar, y acepta dos parámetros de tipo entero num1 y num2.
- __{...}__: Contiene el cuerpo del método donde se ejecutan las instrucciones. En este caso, se suma num1 y num2, y el resultado se devuelve.

### Llamada a Métodos

```java
// Llamada al método sin parámetros y sin valor de retorno
miMetodo();

// Llamada al método con parámetros y con valor de retorno
int resultado = sumar(5, 3);
System.out.println("La suma es: " + resultado);
```

En este ejemplo, se llama a los métodos __miMetodo()__ y __sumar(5, 3)__ para ejecutar sus respectivas funciones.

La creación de métodos en Java __permite encapsular lógica específica y facilita la reutilización del código en diferentes partes de un programa__.

</div>
