<div align="justify">

# Encapsulación y Visibilidad

## Encapsulación

La __encapsulación__ es uno de los __cuatro conceptos fundamentales de la programación orientada a objetos (POO)__, junto con la __herencia__, el __polimorfismo__ y la __abstracción__. La encapsulación se refiere a la _ocultación de la implementación interna de un objeto y la restricción de acceso directo a sus atributos y métodos_.

## Beneficios de la Encapsulación

- __Seguridad__: Protege la integridad de los datos al evitar modificaciones no autorizadas.
- __Modularidad__: Facilita el cambio y mantenimiento del código al aislar el comportamiento interno.
- __Reutilización__: Permite reutilizar objetos sin preocuparse por su implementación interna.

```java
public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
        }
    }
}
```

>__Nota__:En este ejemplo, el atributo saldo es _privado_ __(private)__, lo que significa que sólo puede ser accedido directamente desde dentro de la clase __CuentaBancaria__. Se proporcionan métodos _públicos_ __(public)__ como __getSaldo, depositar y retirar__ para interactuar con el saldo de manera controlada.

## Visibilidad

En Java, la visibilidad se refiere a los modificadores de acceso que determinan desde qué lugares se puede acceder a __clases, interfaces, métodos y atributos__.

### Modificadores de Acceso

- __public__: Accesible desde cualquier clase.
- __protected__: Accesible desde la misma clase, subclases y clases del mismo paquete.
- __default (sin modificador)__: Accesible solo desde clases del mismo paquete.
- __private__: Accesible solo desde la misma clase.

### Ejemplo de Modificadores de Acceso

```java
public class Ejemplo {
    public int publico;           // Accesible desde cualquier clase.
    protected int protegido;      // Accesible desde la misma clase, subclases y clases del mismo paquete.
    int porDefecto;               // Accesible solo desde clases del mismo paquete.
    private int privado;          // Accesible solo desde la misma clase.

    // Métodos y constructor...
}
```

>__Nota__:En resumen, la __encapsulación y la visibilidad__ son __conceptos esenciales en la programación orientada a objetos para garantizar la _seguridad, modularidad y reutilización_ del código.

</div>