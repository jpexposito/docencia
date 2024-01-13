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

>__Nota__:La __interfaz__ _Volador_ define __dos métodos abstractos__ _(despegar y volar)_ y una __constante__ _(TIPO)_. La clase __Pajaro__ _implementa la interfaz_ __Volador__ proporcionando __implementaciones concretas__ para los métodos de la interfaz. La clase principal Main crea una instancia de Pajaro y utiliza los métodos definidos en la interfaz.

</div>