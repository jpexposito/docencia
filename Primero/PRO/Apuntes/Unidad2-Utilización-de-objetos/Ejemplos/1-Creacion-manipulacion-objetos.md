# Ejercicios de declaraciónfÑ¡ y manipulación de clases

## Ejercicio 1: Creación de una Clase y Objetos

### Descripción:

Crea una clase llamada Coche con las siguientes propiedades: marca, modelo, año, y precio. Luego, crea dos objetos de la clase Coche e imprime sus detalles.

```java
public class Coche {
    String marca;
    String modelo;
    int anio;
    double precio;
    
    public Coche(String marca, String modelo, int anio, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }
    
    public void mostrarDetalles() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("anio: " + anio);
        System.out.println("Precio: $" + precio);
    }
}

public class Main {
    public static void main(String[] args) {
        Coche coche1 = new Coche("Toyota", "Corolla", 2022, 25000.00);
        Coche coche2 = new Coche("Honda", "Civic", 2021, 23000.00);
        
        coche1.mostrarDetalles();
        System.out.println("-----------------------");
        coche2.mostrarDetalles();
    }
}
```

## Ejercicio 2: Encapsulación y Métodos Getter/Setter

### Descripción:

Modifica la clase Coche del ejercicio anterior para encapsular sus propiedades y agregar métodos getter y setter para acceder y modificar dichas propiedades.

```java
public class Coche {
    private String marca;
    private String modelo;
    private int anio;
    private double precio;
    
    // Métodos getter
    public String getMarca() {
        return marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public int getAnio() {
        return anio;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    // Métodos setter
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    // Resto del código...
}
``` 