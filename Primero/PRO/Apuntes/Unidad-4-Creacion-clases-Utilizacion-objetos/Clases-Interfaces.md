<div align="justify">

# Clases (Interfaces) en Proramación

Una __interfaz__ es una __colección de métodos abstractos (sin implementación) y constantes__. Las interfaces permiten definir __CONTRATOS__ que las clases deben seguir, pero _no contienen implementaciones concretas_. Las __clases implementan interfaces proporcionando implementaciones concretas_ para los _métodos declarados en la interfaz_.

## Sintaxis

```java
publoc interface MiInterfaz {
    // Métodos abstractos
    void metodo1();
    void metodo2();

    // Constantes (implícitamente static y final)
    String CONSTANTE = "Valor constante";
}
```

## Ejemplo

```java
// Definición de la interfaz
public interface Volador {
    // Método abstracto
    void despegar();

    // Otro método abstracto
    void volar();

    // Constante
    String TIPO = "Aéreo";
}

// Clase que implementa la interfaz
class Pajaro implements Volador {
    // Implementación del método despegar
    @Override
    public void despegar() {
        System.out.println("El pájaro despega.");
    }

    // Implementación del método volar
    @Override
    public void volar() {
        System.out.println("El pájaro vuela.");
    }
}

// Clase principal para probar la interfaz
public class Main {
    public static void main(String[] args) {
        Pajaro miPajaro = new Pajaro();

        // Utilizando los métodos de la interfaz
        miPajaro.despegar();
        miPajaro.volar();

        // Accediendo a la constante de la interfaz
        System.out.println("Tipo de pájaro: " + Volador.TIPO);
    }
}
```

>__Nota__:La __interfaz__ _Volador_ define __dos métodos abstractos__ _(despegar y volar)_ y una __constante__ _(TIPO)_. La clase __Pajaro__ _implementa la interfaz_ __Volador__ proporcionando __implementaciones concretas__ para los métodos de la interfaz. La clase principal __Main__ crea _una instancia_ de __Pajaro__ y utiliza los _métodos definidos en la interfaz_.

>__IMPORTANTE__:En Java, las interfaces permiten la __implementación múltiple__, _lo que significa que una clase puede implementar más de una interfaz_. Este concepto es útil para lograr una mayor flexibilidad y reutilización de código. 

```java
// Definición de dos interfaces
interface Volador {
    void despegar();
    void volar();
}

interface Nadador {
    void nadar();
}

// Clase que implementa ambas interfaces
class AveNadadora implements Volador, Nadador {
    @Override
    public void despegar() {
        System.out.println("El ave despega.");
    }

    @Override
    public void volar() {
        System.out.println("El ave vuela.");
    }

    @Override
    public void nadar() {
        System.out.println("El ave nada.");
    }
}

// Clase principal para probar la implementación múltiple
public class Main {
    public static void main(String[] args) {
        AveNadadora miAve = new AveNadadora();

        // Utilizando los métodos de las interfaces
        miAve.despegar();
        miAve.volar();
        miAve.nadar();
    }
}
```

>__Nota__:Las interfaces Volador y Nadador definen métodos relacionados con volar y nadar, respectivamente. La clase AveNadadora implementa ambas interfaces, proporcionando implementaciones concretas para todos los métodos.

Esta capacidad de implementación múltiple a través de interfaces es una característica poderosa de Java y permite a las clases adquirir comportamientos de múltiples fuentes. ___Sin embargo, es importante manejar cuidadosamente los posibles conflictos si dos interfaces tienen métodos con el mismo nombre__. _En tales casos, la clase que implementa las interfaces debe proporcionar una implementación concreta para resolver el conflicto_.

## Similitudes y Diferencias entre Clases Abstractas e Interfaces 

Tanto las __clases abstractas como las interfaces__ son _constructos importantes_ en Java que permiten __la implementación de la abstracción y la herencia__.

### Similitudes

#### Ambos permiten la abstracción:

Tanto las clases abstractas como las interfaces permiten la creación de abstracciones, lo que significa que se pueden definir métodos sin proporcionar una implementación concreta.

#### Soportan la herencia

Ambos permiten la herencia, lo que significa que una clase puede heredar de otra clase abstracta o implementar una interfaz.

#### Pueden contener métodos abstractos

Tanto las clases abstractas como las interfaces pueden contener __métodos abstractos (sin implementación)__ que deben ser implementados por las subclases.

#### Facilitan la definición de contratos

Ambos se utilizan para definir contratos que las clases deben seguir. Es decir, proporcionan una estructura común para las clases que heredan o implementan.

### Diferencias

#### Constructores

- Clases Abstractas: _Pueden tener constructores, y las subclases pueden llamar a los constructores de la clase abstracta utilizando_ __super()__.
- Interfaces: __NO__ pueden tener constructores. No se pueden instanciar y, por lo tanto, no pueden tener un estado.
  
#### Herencia Múltiple

- Clases Abstractas: _Permiten la herencia única, ya que una clase solo puede heredar de una única clase abstracta_.
- Interfaces: Permiten la implementación múltiple, lo que significa que una clase puede implementar múltiples interfaces.

#### Implementación de Métodos

- Clases Abstractas: Pueden tener métodos con implementación (métodos concretos) además de métodos abstractos.
- Interfaces: Todos los métodos son abstractos y públicos por defecto. 

Desde Java 8, pueden tener métodos con implementación (métodos default y estáticos).

#### Estado

- Clases Abstractas: Pueden tener variables de instancia __(atributos) y pueden tener un estado__.
Interfaces: Tradicionalmente, no pueden tener variables de instancia (hasta Java 8). Desde Java 8, pueden tener variables estáticas y finales (constantes).

#### Palabra Clave

- Clases Abstractas: Se definen con la palabra clave __abstract__.
- Interfaces: Se definen con la palabra clave __interface__.

#### Uso de super y this

- Clases Abstractas: Pueden utilizar __super y this__ en sus métodos.
- Interfaces: __NO__ pueden utilizar __super y this__ en sus métodos.

>__Nota__:Ambos constructos son valiosos y se eligen según las necesidades específicas del diseño de la aplicación. En muchos casos, se utilizan de manera complementaria en la jerarquía de clases.

</div>