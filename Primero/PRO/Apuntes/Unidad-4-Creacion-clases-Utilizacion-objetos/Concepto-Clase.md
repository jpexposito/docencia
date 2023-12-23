<div align="justify">

# Clase en Programación y en Java

<div align="center">
<img src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhENxGbVg7xwg9NpvEtFb3hrvEfbnLnorkIKjuNv9ejnqjkC1VCyRAN-dVhIgvX4XwPARMuSQpfVgHynPHosdIpV2riqQXZmpvf1Xofin4Q82xgZcnHVK1XZ2PEPgrfK16C2NHBj5oIENUvt--anyR73wofWFtr2Mv4J37eMEFM1F0gjfPDq8l3b4sGew/w640-h268-rw/objecto.webp">
</div>

## Clase en Programación

En programación orientada a objetos, una **clase** es un modelo o plantilla para crear objetos. Un objeto es una instancia de una clase, y cada clase define un conjunto de atributos (variables) y métodos (funciones) comunes a todos sus objetos. La clase actúa como un plano o prototipo que especifica la estructura y el comportamiento de los objetos que se pueden crear a partir de ella.

### Características de una Clase:

1. **Atributos (Variables de Instancia):** Representan las características o datos que poseen los objetos de la clase.

2. **Métodos (Funciones de Instancia):** Definen las operaciones o acciones que pueden realizar los objetos de la clase.

3. **Constructores:** Métodos especiales llamados cuando se crea un nuevo objeto. Se utilizan para inicializar los atributos de la clase.

4. **Encapsulamiento:** La encapsulación implica ocultar los detalles internos de la implementación de una clase y proporcionar una interfaz para interactuar con los objetos.

## Clase en Java

Java es un lenguaje de programación orientado a objetos, y la creación de clases es esencial en su diseño. Aquí hay un ejemplo básico de cómo se define y utiliza una clase en Java:

### Ejemplo en Java:

```java
// Definición de una clase en Java
public class Persona {
    // Atributos
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }

    // Método getter para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Método setter para actualizar la edad
    public void setEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }
}

// Uso de la clase en el programa principal
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la clase Persona
        Persona persona1 = new Persona("Juan", 25);

        // Llamar a un método de la clase
        persona1.saludar();

        // Utilizar métodos getter y setter
        String nombrePersona1 = persona1.getNombre();
        System.out.println("Nombre: " + nombrePersona1);

        persona1.setEdad(26);
        persona1.saludar();
    }
```

>__Recuerda__: En este ejemplo, la clase Persona tiene __atributos (nombre y edad)__, un constructor para inicializar esos atributos, un método __(saludar)__ para mostrar un saludo, y __métodos getter y setter__ para acceder y actualizar los atributos. La clase se utiliza creando una instancia (persona1) y llamando a sus métodos.

Las clases en Java proporcionan un mecanismo poderoso para organizar y estructurar código, permitiendo la creación de programas modulares y reutilizables.

</div>