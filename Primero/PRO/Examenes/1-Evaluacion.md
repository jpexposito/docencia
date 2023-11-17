<div align="justify">

Realiza los siguientes ejercicios. Se debe de trabajar con __array´s, búcles (for/while/do while), y condicionales (if/else/else if, switc ), y/o clases__, siempre y cuando sea necesario.

## Ejercicio1: Triángulo equilátero 

### Descripción

Escribir un programa en que dibuje un triángulo equilátero como muestra la figura. El usuario deberá ingresar la altura (número de filas que compondrán el triángulo), y el programa imprimirá en la consola el triángulo correspondiente.
En este ejemplo se trata de un trángulo con 5 filas.

```code
    1
   111
  11111
 1111111
111111111
```

Se pide:

- Crear __solicite al usuario el número de filas__ para el triángulo equilátero.
- Utiliza estructuras de control (for o while) para dibujar el triángulo.
- Imprime el triángulo en la consola para representar cada elemento del triángulo.
- Asegúrate de que el triángulo sea equilátero, es decir, que tenga lados iguales y ángulos iguales.
- Comenta tu código de manera clara para explicar el propósito de cada sección.
- Utiliza buenas prácticas de programación, incluyendo nombres de variables descriptivos y un formato limpio y legible.
- Si el número de filas ingresado es 0 o negativo, muestra un mensaje de error indicando que el número de filas debe ser positivo.

## Ejercicio2: Crea la clase que representa la información de un Estudiante (2 puntos)

El objetivo de este ejercicio es crear una clase en Java llamada Ejercicio2 que represente a un estudiante con atributos como nombre, edad, peso y altura. Además, se debe implementar un método para calcular el Índice de Masa Corporal (IMC) del estudiante.

Se pide:
 - Crea una clase llamada Ejercicio2.
 La clase debe tener los siguientes atributos: 
 - nombre (String): Nombre del estudiante.
 - edad (int): Edad del estudiante.
 - peso (double): Peso del estudiante en kilogramos.
 - altura (double): Altura del estudiante en metros.
 - Implementa __todos__ constructor que permita inicializar los atributos.
 - Implementa métodos getter y setter para cada atributo.
 - Implementa un método llamado calcularIMC que calcule y devuelva el Índice de Masa Corporal (IMC) del estudiante. La fórmula del IMC es:
  
    ```code
    imc = peso / (altura * altura)
    ```
 - Crea un método mostrarInformacion que imprima en la consola la información del estudiante, incluyendo el IMC calculado.

## Ejercicio3: Domino 

### Descripción

Escriba un programa que muestre por pantalla todas las fichas del dominó. La ficha __en blanco__ se representan con un __0__.

| Ficha 1 | Ficha 2 | Ficha 3 | Ficha 4 | Ficha 5 | Ficha 6 | Ficha 7 |
|---------|---------|---------|---------|---------|---------|---------|
| 0:0     | 0:1     | 0:2     | 0:3     | 0:4     | 0:5     | 0:6     |  
|         | 1:1     | 1:2     | 1:3     | 1:4     | 1:5     | 1:6     |  
|         |         | 2:2     | 2:3     | 2:4     | 2:5     | 2:6     | 
|         |         |         | 3:3     | 3:4     | 3:5     | 3:6     |  
|         |         |         |         | 4:4     | 4:5     | 4:6     | 
|         |         |         |         |         | 5:5     | 5:6     | 
|         |         |         |         |         |         | 6:6     | 

- Representa las fichas de domino tal y como muestra la imagen.
- Implenta la visualización de las fichas del domino.
- Contruye un método/función que permita extrar una ficha del domino y sustituya dicha ficha por el valor __X:X__.
- Implenta la visualización de las fichas del domino, tras la extracción de fichas.

## Ejercicio 4: Juego de las 5 Puertas

### Descripción

Implementar un programa que simule un juego de las 5 puertas. Cada puerta está numerada del 1 al 5. Al inicio, todas las puertas están cerradas. El jugador puede realizar acciones para abrir, cerrar o cambiar el estado de una puerta.

Crea una clase llamada Ejercicio4 que modele el juego de las 5 puertas.

Al iniciar el juego, todas las puertas deben estar cerradas.

Implementa métodos en la clase para las siguientes acciones:
- abrirPuerta(int numeroPuerta): Abre la puerta especificada.
- cerrarPuerta(int numeroPuerta): Cierra la puerta especificada.
- cambiarEstadoPuerta(int numeroPuerta): Cambia el estado de la puerta especificada.
- mostrarEstadoPuertas: Muestra el estado de todas las puertas.

## Ejercicio 5: Mes del año 

### Descripción

Implementa un programa para determinar el nombre del mes correspondiente a un número dado. Realiza el programa creando dos métodos:
- public tipoDato mesIfSele(tipoDato __numero__).
- public tipoDato mesSwitch(tipoDato __numero__).

Ambós métodos tendrán como parámetro de entrada un número.


</div>