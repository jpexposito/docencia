<div align="justify">

# Paso de Parámetros en Java

En Java, los métodos son bloques de código que realizan una tarea específica y pueden ser llamados desde otras partes del programa. Los métodos permiten modularizar y reutilizar código de manera eficiente.

## Definición de un Método

Recordemos que un método en Java tiene la siguiente estructura:

```java
tipo_de_retorno nombre_del_metodo(tipo_de_parametro1 parametro1, tipo_de_parametro2 parametro2, ...) {
    // Código del método
    return valor_de_retorno; // (si el método devuelve un valor)
}
```

donde:

- __tipo_de_retorno__: Es el tipo de dato que el método devuelve. Si el método no devuelve ningún valor, se utiliza void.
- __nombre_del_metodo__: Es el nombre del método, que se utiliza para llamarlo.
- __tipo_de_parametro1, tipo_de_parametro2, etc.__: Son los tipos de datos de los parámetros que el método recibe. Pueden ser múltiples o incluso ninguno.
- __parametro1, parametro2, etc.__: Son los nombres que se utilizan dentro del método para referirse a los valores que se pasan como argumento.


## Llamada a un Método

Para llamar a un método, se utiliza el nombre del método seguido de paréntesis que pueden contener los argumentos necesarios.

```java
tipo_de_retorno resultado = nombre_del_metodo(argumento1, argumento2, ...);
```

## Paso de Parámetros

Los parámetros se utilizan para pasar valores a un método para que pueda realizar operaciones con ellos. En Java, se utilizan dos formas de pasar parámetros:

- __Por Valor__: Se pasa una copia del valor de la variable original. Esto significa que cualquier modificación al parámetro dentro del método no afecta la variable original.
- __Por Referencia__: Se pasa la referencia a la variable original. Esto permite modificar el contenido de la variable original desde el método.

### Ejemplo de Paso por Valor

```java
public void duplicar(int numero) {
    numero = numero * 2;
}

int valor = 5;
duplicar(valor);
// valor seguirá siendo 5, ya que el método duplicar trabaja con una copia del valor de 'valor'
```

### Ejemplo de Paso por Referencia

```java
public void modificarArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
        array[i] = array[i] * 2;
    }
}

int[] array = {1, 2, 3};
modificarArray(array);
// Ahora 'array' será {2, 4, 6} después de llamar al método

```

## Conclusiones

Los métodos en Java __permiten encapsular lógica__ y __reutilizar código de manera eficiente__. El __paso de parámetros__ puede realizarse por __valor o por referencia__, dependiendo del tipo de datos que se esté manejando. Entender cómo funcionan los métodos y cómo se pasan los parámetros es fundamental a la hora de programar.

</div>