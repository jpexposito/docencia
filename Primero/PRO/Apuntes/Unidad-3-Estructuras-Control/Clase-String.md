<div align="justify">

# Clase String

La clase __String__ en Java ofrece muchos métodos útiles para manipular cadenas de texto.

>__IMPORTANTE__: Vamos a trabajar cob la cadena "Hola, mundo!".

## length()

Devuelve la longitud de la cadena.

```java
String str = "Hola, mundo!";
int length = str.length(); // 
```

>__Devuelve 12__

## charAt(int index)

Devuelve el carácter en la posición dada.

```java
char ch = str.charAt(0); // 
```

>__Devuelve 'H'__.

## substring(int beginIndex) y substring(int beginIndex, int endIndex)

Devuelve una subcadena de la cadena actual.

```java
String sub1 = str.substring(0, 4); // Devuelve "Hola"
String sub2 = str.substring(5);    // Devuelve ", mundo!"
```

## concat(String str) o + 

Concatena dos cadenas.

```java
String concatStr = str.concat(" ¡Adiós!"); // Devuelve "Hola, mundo! ¡Adiós!"
```

## toLowerCase() y toUpperCase()

Convierte la cadena a minúsculas o mayúsculas, respectivamente.

```java
String lower = str.toLowerCase(); // Devuelve "hola, mundo!"
String upper = str.toUpperCase(); // Devuelve "HOLA, MUNDO!"
```

## trim()

Elimina los espacios en blanco al principio y al final de la cadena.

```java
String withSpaces = "   Hola, mundo!   ";
String trimmed = withSpaces.trim(); // Devuelve "Hola, mundo!"
```

## equals(Object another) y equalsIgnoreCase(String another)

Compara cadenas.

```java
String anotherStr = "Hola, mundo!";
boolean isEqual = str.equals(anotherStr); // Devuelve true
```

## startsWith(String prefix) y endsWith(String suffix)

Verifica si la cadena comienza o termina con la subcadena dada.

```java
boolean startsWith = str.startsWith("Hola");   // Devuelve true
boolean endsWith = str.endsWith("¡Adiós!");     // Devuelve false
```
</div>