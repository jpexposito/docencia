<div align="justify">

# Empaquetado de Clases

## Introducción

El empaquetado de clases en Java se refiere a la __organización y agrupación de clases y otros recursos relacionados__ en _paquetes_. Los paquetes proporcionan una forma de __modularizar el código__ y __evitar conflictos de nombres__ al permitir la utilización de clases con el mismo nombre provenientes de diferentes paquetes.

## Estructura de Paquetes

- __Paquete__: Un paquete es una colección de clases y otros paquetes relacionados que proporcionan un espacio de nombres único para las clases que contiene.

- __Estructura de Directorios__: En el sistema de archivos, __un paquete__ _se representa_ como una __estructura de directorios__. Por ejemplo, el paquete com.ejemplo se correspondería con el directorio __ies/puerto/__ en el sistema de archivos.

##  Declaración de Paquetes

Para declarar una clase dentro de un paquete en Java, se utiliza la palabra clave __package__ seguida del __nombre del paquete__ en la parte superior del archivo de código fuente de la clase.

```java
package ies.puerto;

public class MiClase {
    // Código de la clase...
}
```

## Importación de Paquetes

Para utilizar clases de otros paquetes en un archivo de código fuente, es necesario importar el paquete o la clase específica utilizando la palabra clave import.

```java
import com.ejemplo.MiClase;

public class OtraClase {
    public static void main(String[] args) {
        MiClase instancia = new MiClase();
        // Operaciones con la instancia...
    }
}
```

También es posible importar todas las clases de un paquete utilizando el carácter _comodín_ __*__.

```java
import com.ejemplo.*;

public class OtraClase {
    // Código de la clase...
}
```

## Convenciones de Nomenclatura para Paquetes

Los nombres de paquetes suelen ser en _minúsculas y pueden incluir subpaquetes separados por puntos_, como __ies.puerto__.

Se recomienda utilizar una estructura de nomenclatura de paquetes basada en el dominio de Internet de la organización o individuo, como __com/org/[id_pais]__ como __es__.__nombreorganizacion__.

>__Nota__:
El empaquetado de clases en Java mediante el uso de paquetes facilita la __organización, modularización y reutilización del código__, contribuyendo a un __desarrollo más estructurado y mantenible__ de aplicaciones y sistemas software.



</div>