<div align="justify">

# Expresiones Regulares

Las ___expresiones regulares___, también conocidas como __regex__ o __regexp__, son __patrones de búsqueda__ y __manipulación de cadenas__ de texto. Son _herramientas poderosas y flexibles utilizadas en diversos lenguajes_ de programación, incluyendo Java, para realizar operaciones avanzadas en cadenas. 

Expresiones Regulares en Java
Las expresiones regulares en Java se gestionan a través de la clase java.util.regex.Pattern. La clase Pattern representa un patrón de expresión regular compilado. Puedes usar Pattern para crear un objeto Matcher, que se utiliza para realizar operaciones de coincidencia en una cadena.

Crear un Patrón:
java
Copy code
import java.util.regex.*;

String regex = "patron";
Pattern pattern = Pattern.compile(regex);
Crear un Matcher:
java
Copy code
Matcher matcher = pattern.matcher("cadena");
Funciones Básicas:
matches(): Verifica si toda la cadena coincide con el patrón.

java
Copy code
boolean esCoincidencia = matcher.matches();
find(): Busca la próxima subcadena que coincide con el patrón.

java
Copy code
boolean encontrado = matcher.find();
Operadores Básicos:
.: Representa cualquier carácter.

*: Representa cero o más repeticiones del carácter anterior.

+: Representa una o más repeticiones del carácter anterior.

?: Representa cero o una repetición del carácter anterior.

Caracteres Especiales:
\d: Representa un dígito.

\w: Representa un carácter alfanumérico.

\s: Representa un espacio en blanco.

Grupos y Capturas:
java
Copy code
String regex = "(\\d{3})-(\\d{2})";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher("123-45");

if (matcher.matches()) {
    String grupo1 = matcher.group(1); // Contiene "123"
    String grupo2 = matcher.group(2); // Contiene "45"
}

</div>