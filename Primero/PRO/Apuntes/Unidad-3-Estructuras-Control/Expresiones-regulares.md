<div align="justify">

# Expresiones Regulares

Las ___expresiones regulares___, también conocidas como __regex__ o __regexp__, son __patrones de búsqueda__ y __manipulación de cadenas__ de texto. Son _herramientas poderosas y flexibles utilizadas en diversos lenguajes_ de programación, incluyendo Java, para realizar operaciones avanzadas en cadenas. 

## ¿Cómo trabajamos con expresiones?

Las expresiones regulares en Java se gestionan a través de la clase java.__util.regex.Pattern__. La clase __Pattern__ representa un patrón de expresión regular compilado. Puedes usar __Pattern__ para crear un objeto Matcher, que se utiliza para realizar operaciones de coincidencia en una cadena.

```java
//Creamos un patron
import java.util.regex.*;

String regex = "patron";
Pattern pattern = Pattern.compile(regex);
```

y a continuación:

```java
Matcher matcher = pattern.matcher("cadena");
```

### Funciones Básicas

#### matches()

Verifica si toda la cadena coincide con el patrón.

```java
boolean esCoincidencia = matcher.matches();
```

#### find()

Busca la próxima subcadena que coincide con el patrón.

```java
boolean encontrado = matcher.find();
```

### Operadores en expresiones regulares

| Operador  | Descripción                                      | Ejemplo                |
|-----------|--------------------------------------------------|------------------------|
| `.`       | Coincide con cualquier carácter excepto nueva línea | `a.b` coincide con "aab", "abb", "acb", etc. |
| `^`       | Coincide con el inicio de la cadena               | `^abc` coincide con "abc" al inicio de la cadena. |
| `$`       | Coincide con el final de la cadena                | `xyz$` coincide con "xyz" al final de la cadena. |
| `*`       | Coincide con cero o más repeticiones del elemento anterior | `a*b` coincide con "ab", "aab", "aaab", etc. |
| `+`       | Coincide con una o más repeticiones del elemento anterior | `a+b` coincide con "ab", "aab", "aaab", etc. |
| `?`       | Coincide con cero o una repetición del elemento anterior | `a?b` coincide con "ab" o "b". |
| `\`       | Escapa el significado especial de un carácter      | `\.` coincide con el carácter punto literal. |
| `[]`      | Coincide con cualquier carácter dentro de los corchetes | `[aeiou]` coincide con cualquier vocal. |
| `[^]`     | Coincide con cualquier carácter que no esté dentro de los corchetes | `[^0-9]` coincide con cualquier carácter que no sea un dígito. |
| `()`      | Agrupa elementos para aplicar operadores a una expresión completa | `(abc)+` coincide con "abc", "abcabc", etc. |
| `\d`      | Coincide con un dígito (equivalente a `[0-9]`)   | `\d{3}` coincide con tres dígitos. |
| `\w`      | Coincide con un carácter de palabra (letras, dígitos, guiones bajos) | `\w+` coincide con una o más palabras. |
| `\s`      | Coincide con un carácter de espacio en blanco     | `\s*` coincide con cero o más espacios en blanco. |
| `|`       | Operador lógico "o"                               | `a|b` coincide con "a" o "b". |

### Grupos y Capturas

Los __grupos__ y las __capturas__ en expresiones regulares se utilizan para __agrupar partes específicas__ de una coincidencia y para extraer esa información después de realizar una búsqueda. Puedes crear grupos utilizando paréntesis __()__ en tu expresión regular. 

```java
String regex = "(\\d{3})-(\\d{2})";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher("123-45");

if (matcher.matches()) {
    String grupo1 = matcher.group(1); // Contiene "123"
    String grupo2 = matcher.group(2); // Contiene "45"
}
```

</div>