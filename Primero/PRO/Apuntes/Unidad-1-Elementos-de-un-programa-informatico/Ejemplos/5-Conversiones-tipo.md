<div align="justify">

# Tipos de Datos en Java

## Conversión de Enteros y Flotantes:

```java
public class ConversionTipos {
    public static void main(String[] args) {
        int entero = 5;
        double flotante = 7.8;

        // Convertir el entero a double
        double resultado1 = (double) entero;
        System.out.println("Resultado 1: " + resultado1);

        // Convertir el flotante a int
        int resultado2 = (int) flotante;
        System.out.println("Resultado 2: " + resultado2);
    }
}
```

## Conversión de Cadenas a Números:

```java
public class ConversionTipos {
    public static void main(String[] args) {
        String cadenaEntera = "123";
        String cadenaDecimal = "45.67";

        // Convertir cadena a entero
        int enteroDesdeCadena = Integer.parseInt(cadenaEntera);
        System.out.println("Entero desde cadena: " + enteroDesdeCadena);

        // Convertir cadena a double
        double decimalDesdeCadena = Double.parseDouble(cadenaDecimal);
        System.out.println("Decimal desde cadena: " + decimalDesdeCadena);
    }
}
```

## Conversión de Caracteres:

```java
public class ConversionTipos {
    public static void main(String[] args) {
        char caracter = 'A';

        // Convertir char a int (código ASCII)
        int codigoAscii = (int) caracter;
        System.out.println("Código ASCII: " + codigoAscii);

        // Convertir int a char
        char nuevoCaracter = (char) (codigoAscii + 1);
        System.out.println("Siguiente caracter: " + nuevoCaracter);
    }
}
```

## Conversión de Tipos con Autoboxing y Unboxing:

```java
public class ConversionTipos {
    public static void main(String[] args) {
        // Autoboxing: Convertir int a Integer
        Integer enteroObjeto = Integer.valueOf(42);
        System.out.println("Entero como objeto: " + enteroObjeto);

        // Unboxing: Convertir Integer a int
        int enteroDesdeObjeto = enteroObjeto.intValue();
        System.out.println("Entero desde objeto: " + enteroDesdeObjeto);
    }
}
```

</div>