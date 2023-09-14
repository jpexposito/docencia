<div align="justify">

# Ejemplos simples de programas en Java

## Ejemplo 1

```java
Public class Ejemplo1 {
	public static void main(String[] args) {
		
		//declaracion y inializacion de variables
		int N = -352;
		double A = 893.389;
		char C = '|';
		
		//muestra por pantalla
		System.out.println("Valor de la variable N -> " + N + "\nValor de la variable A -> " + A + "\nValor de la variable C -> " + C); //el valor de cada variable
		System.out.println("\nEl resultado de N+A es " + (N+A)); //la suma de N+A
		System.out.println("\nEl resultado de A-N es " + (A-N));//la diferencia de A-N
		
	}//fin main
	
}//fin class
```

## Ejemplo 2

```java
public class Ejemplo2 {
	
	public static void main(String[] args) {
		
		//declaracion y inicializacion  de variables
		int X=35, Y=57;
		double N=128.38, M=75.25;
		
		//muestra por pantalla
		System.out.println("Valor de la variable X -> " + X + "\nValor de la variable Y -> " + Y + "\nValor de la variable N -> " + N + "\nValor de la variable M -> " + M);//el valor de cada variable
		System.out.println("\nEl resultado de X+Y es " + (X+Y));//la suma X+Y
		System.out.println("\nEl resultado de X-Y es " + (X-Y));//la diferencia X-Y
		System.out.println("\nEl resultado de X*Y es " + (X*Y));//el producto X*Y
		System.out.println("\nEl resultado de X/Y es " + (X/Y));//el cociente X/Y
		System.out.println("\nEl resultado de X%Y es " + (X%Y));//el resto X%Y
		System.out.println("\nEl resultado de N+M es " + (N+M));//la suma N+M
		System.out.println("\nEl resultado de N-M es " + (N-M));//la diferencia N-M
		System.out.println("\nEl resultado de N*M es " + (N*M));//el producto N*M
		System.out.println("\nEl resultado de N/M es " + (N/M));//el cociente N/M
		System.out.println("\nEl resultado de N%M es " + (N%M));//el resto N%M
		System.out.println("\nEl resultado de X+N es " + (X+N));//la suma X+N
		System.out.println("\nEl resultado de Y/M es " + (Y/M));//el cociente Y/M
		System.out.println("\nEl resultado de Y%M es " + (Y%M));//el resto Y%M
		System.out.println("\nEl doble de X -> " + (X*2) + "\nEl doble de Y -> " + (Y*2) + "\nEl doble de N -> " + (N*2) + "\nEl doble de M -> " + (M*2));//el doble de cada variable

	}//fin main
	
}//fin class
```

## Ejemplo 3

```java
public class Ejemplo3 {

    public static void main(String[] args) {
        
        //declaracion y inicializacion de variable
        int N = 20;
        
        //incrementar N en 77
        N+=77;//instruccion
        System.out.println("El resultado de incrementar N en 77 es " + N);//resultado por pantalla

        //decrementarla en 3
        N-=3;//instruccion
        System.out.println("\nEl resultado de decrementar N en 3 es " + N);//resultado por pantalla

        //duplicar su valor
        N*=2;//instruccion
        System.out.println("\nEl resultado de duplicar el valor de N es " + N);//resultado por pantalla

    }//fin main

}//fin class
```

## Ejemplo 4

```java
public class Ejemplo4 {
    
    public static void main(String[] args) {
        
        //declaracion y inizializacion de variables
        int A=8, B=4, C=9, D=7;
        int box;//variable auxiliar

        //instrucciones
        box = B;//guardo el valor de B
        B = C;//B toma el valor de C
        C = A;//C toma el valor de A
        A = D;//A toma el valor de D
        D = box;//D toma el valor de box (B)

        //resultado por pantalla
        System.out.println("El valor de A es " + A + "\nEl valor de B es " + B + "\nEl valor de C es " + C + "\nEl valor de D es " + D);

    }//fin main
    
}//fin class

```

## Ejemplo 5

```java
public class Ejemplo5 {

    public static void main(String[] args) {
        
        //declaracion y inicializacion de variables
        int num1=63, num2=24;

        int auxSum;//variable auxiliar de suma
        int auxRes;//variable auxiliar de resta
        int auxMul;//variable auxiliar de multiplicacion
        int auxDiv;//variable auxiliar de division
        
        //operaciones en variables auxiliares
        auxSum = num1+num2;
        auxRes = num1-num2;
        auxMul = num1*num2;
        auxDiv = num1/num2;

        //resultado por pantalla
        System.out.println("El valor de la variable auxiliar de suma es " + auxSum + "\nEl valor de la variable auxiliar de resta es " + auxRes + "\nEl valor de la variable auxiliar de multiplicacion es " + auxMul + "\nEl valor de la variable auxiliar de division es " + auxDiv);

    }//fin main

}//fin class
```
