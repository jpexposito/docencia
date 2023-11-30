<div align="justify">

# Clase Integer

La clase __Integer__ en Java es una envoltura __(wrapper)__ alrededor del tipo de datos __primitivo int__. Algunos de los métodos comunes proporcionados por la clase Integer incluyen:

## parseInt(String s)

Convierte una cadena en un entero primitivo.

```java
String str = "123";
int num = Integer.parseInt(str); // Devuelve 123
```

## valueOf(int i)

Devuelve un objeto Integer para el valor dado.

```java
int value = 42;
Integer integerValue = Integer.valueOf(value);
```

## intValue()

Devuelve el valor entero primitivo de este objeto Integer.

```java
Integer integerValue = Integer.valueOf(42);
int intValue = integerValue.intValue(); // Devuelve 42
```

## toString()

Convierte el valor Integer a una cadena.

```java
Integer integerValue = Integer.valueOf(42);
String stringValue = integerValue.toString(); // Devuelve "42"
```

## compareTo(Integer anotherInteger)

Compara dos objetos Integer. Devuelve un valor negativo si el objeto actual es menor, cero si son iguales y un valor positivo si el objeto actual es mayor.

```java
Integer num1 = 10;
Integer num2 = 5;
int result = num1.compareTo(num2); // Devuelve 1
```

## equals(Object obj)

Compara dos objetos Integer para la igualdad.

```java
Integer num1 = 10;
Integer num2 = 10;
boolean isEqual = num1.equals(num2); // Devuelve true
```

## MAX_VALUE y MIN_VALUE

Son constantes que representan el valor máximo y mínimo para un int.

```java
int maxValue = Integer.MAX_VALUE; // Devuelve 2147483647
int minValue = Integer.MIN_VALUE; // Devuelve -2147483648
```

## parseInt(String s, int radix)

Convierte una cadena en un entero primitivo utilizando la base especificada.

```java
String binaryStr = "1010";
int binaryInt = Integer.parseInt(binaryStr, 2); // Convierte a decimal, devuelve 10
```

</div>