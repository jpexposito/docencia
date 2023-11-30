<div align="justify">

# Date, DateFormat y Calendar

## La Clase Date

La clase __Date__ en Java, que se encuentra en el paquete __java.util___, representa un instante específico en el tiempo con una precisión de hasta milisegundos. Sin embargo, la clase __Date ha sido declarada como obsoleta en versiones más recientes de Java__, y se sugiere utilizar las clases del paquete java.time para el manejo de fechas y horas.

Ejemplo básico de uso de Date:

```java

import java.util.Date;

public class EjemploDate {
    public static void main(String[] args) {
        // Crear una instancia de Date que representa el momento actual
        Date fechaActual = new Date();

        System.out.println("Fecha actual: " + fechaActual);
    }
}
```

## La Clase Calendar 

La clase __Calendar__ proporciona operaciones para manejar fechas y horas en un sistema de calendario específico, y se encuentra en el paquete __java.util__. Aunque Calendar también ha sido __reemplazada__ en gran medida por las clases del paquete __java.time__, todavía se utiliza en algunos casos.

Ejemplo básico de uso de Calendar:

```java
import java.util.Calendar;

public class EjemploCalendar {
    public static void main(String[] args) {
        // Obtener una instancia de Calendar representando el momento actual
        Calendar calendar = Calendar.getInstance();

        // Obtener información específica de la fecha
        int año = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH) + 1; // Sumar 1 ya que los meses comienzan desde 0
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("Fecha actual: " + dia + "-" + mes + "-" + año);
    }
}
```

### La Clase DateFormat 

La clase __DateFormat__ se encuentra en el paquete __java.text__ y se utiliza para __formatear y analizar fechas y horas__. Aquí hay un ejemplo de uso básico con SimpleDateFormat:

```java
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EjemploDateFormat {
    public static void main(String[] args) {
        // Crear una instancia de Date que representa el momento actual
        Date fechaActual = new Date();

        // Crear una instancia de SimpleDateFormat para el formato deseado
        DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        // Formatear la fecha
        String fechaFormateada = formatoFecha.format(fechaActual);

        System.out.println("Fecha formateada: " + fechaFormateada);
    }
}
```

En este ejemplo, se utiliza SimpleDateFormat para definir un formato específico __("dd-MM-yyyy HH:mm:ss")__ y luego se formatea la fecha actual utilizando ese formato.

>__Nota__:Es importante destacar que, aunque estas clases siguen siendo parte de Java, se prefieren las clases del paquete __java.time__ para el manejo de fechas y horas en aplicaciones modernas.

</div>