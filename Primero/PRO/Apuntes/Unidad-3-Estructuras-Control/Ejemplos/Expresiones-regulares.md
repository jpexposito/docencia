<div align="justify">

# Expresiones Regulares

## Validar si una cadena contiene solo dígitos

```java
import java.util.regex.Pattern;

public class DigitValidator {
    public static void main(String[] args) {
        String input = "12345";

        // Expresión regular para validar solo dígitos
        String regex = "\\d+";

        if (Pattern.matches(regex, input)) {
            System.out.println("La cadena contiene solo dígitos.");
        } else {
            System.out.println("La cadena no contiene solo dígitos.");
        }
    }
}
```

## Validar si una cadena representa un nombre simple (solo letras y espacios)

```java
import java.util.regex.Pattern;

public class NameValidator {
    public static void main(String[] args) {
        String input = "John Doe";

        // Expresión regular para validar un nombre simple
        String regex = "^[a-zA-Z ]+$";

        if (Pattern.matches(regex, input)) {
            System.out.println("La cadena representa un nombre válido.");
        } else {
            System.out.println("La cadena no representa un nombre válido.");
        }
    }
}
```

## Extraer las palabras que comienzan con "java" de una cadena

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaWordExtractor {
    public static void main(String[] args) {
        String text = "Java es un lenguaje de programación. JavaScript es diferente de Java.";

        // Expresión regular para encontrar palabras que comienzan con "java"
        String regex = "\\bjava\\w*\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Palabra encontrada: " + matcher.group());
        }
    }
}
```

## Extraer información de fechas (día, mes y año) de una cadena:

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtractor {
    public static void main(String[] args) {
        String input = "Fechas: 15-02-2022 y 25-12-2023";

        // Expresión regular con grupos para extraer día, mes y año
        String regex = "(\\d{2})-(\\d{2})-(\\d{4})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String day = matcher.group(1);
            String month = matcher.group(2);
            String year = matcher.group(3);

            System.out.println("Día: " + day);
            System.out.println("Mes: " + month);
            System.out.println("Año: " + year);
        }
    }
}
```

## Validar un formato de dirección de correo electrónico

>__Nota__: Esta sería una posible implementación

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        String email = "usuario@dominio.com";

        // Expresión regular para validar una dirección de correo electrónico simple
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println("La dirección de correo electrónico es válida.");
        } else {
            System.out.println("La dirección de correo electrónico no es válida.");
        }
    }
}
```

</div>