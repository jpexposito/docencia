<div align="justify">

# Estructura de un programa en Java
## Objetivos

- Describir la estructura del código fuente de una aplicación Java.
- Presentar los conceptos de comentario y de identificador dentro del código fuente de un programa.

Esta unidad tiene como objetivo mostrar dos elementos típicos del código fuente: los comentarios y los identificadores. La estructura de un programa de __Java__ es similar a la de un programa de __C/C++__. Por su diseño, permite a los programadores de cualquier otro lenguaje leer código en Java sin mucha dificultad. Java emplea siempre la Programación Orientada a Objetos por lo que todo el código se incluye dentro de las clases. Aunque ya se explicarán detenidamente más adelante, las clases son combinaciones de datos __(constantes y variables) y rutinas (métodos)__.

## La Clase Principal y el Método main()

Un programa puede construirse empleando varias clases. En el caso más simple se utilizará una única clase. Esta clase contiene el programa, rutina o método principal: main() y en éste se incluyen las sentencias del programa principal. Estas sentencias se separan entre sí por caracteres de punto y coma.
La estructura de un programa simple en Java es la siguiente:

```java
public class ClasePrincipal {
public static void main(String[] args) {
sentencia_1;
sentencia_2;
// comentario_1
...
sentencia_N;
}
}
```
Ejemplo de un programa en Java llamado que muestra un mensaje por la pantalla del ordenador llamado HolaMundo.java:

```java
/**
* La clase HolaMundo construye un programa que
* muestra un mensaje en pantalla
*/
public class HolaMundo {
public static void main(String[] args) {
System.out.println("Hello World!");
}
}
```

Como se ha indicado anteriormente, en un programa de Java todo se organiza dentro de clases. En el ejemplo anterior, __HolaMundo__ es el nombre de la clase principal y del archivo que contiene el código fuente. Todos los programas o aplicaciones independientes escritas en __Java__ tienen un método __main()__ o principal que, a su vez, contiene un conjunto de sentencias.

### ¿Qué Significa cada Término de la Clase Principal?

La primera parte del programa corresponde a la definición de la clase:
- __public__: es un modificador de acceso que determina quién puede acceder a las clases o propiedades y métodos de una clase.
- __class__: palabra reservada que se utiliza para definir una clase. Contiene un conjunto de propiedades y métodos que luego sirven de modelo o plantilla para crear objetos o instancias de esa clase.
- __HolaMundo__: es un identificador de clase, no una palabra reservada, que identifica a la clase pública que se ha creado.
>__Resumiendo__, esta línea define una clase pública identificada como ___HolaMundo__.

```java
public class HolaMundo {
…
}
```

La segunda parte del programa corresponde a la definición del método main:
- __public__: cada método en una clase puede ser público, protegido o privado dependiendo del nivel de acceso que el programador quiere darle. public significa que el método puede ser accedido desde cualquier otro método que tenga una instancia de esta clase.
- __static__: un método puede ser de instancia o de clase. Un método no estático es un método de instancia (que necesita una instancia de la clase donde se declara para ser invocado) y un método estático es un método de clase (no necesita una instancia de la clase donde se declara para ser invocado).
- __void__: Los métodos pueden devolver algo, por ejemplo, un método que suma dos números, devuelve el resultado de la suma; pero hay métodos que no devuelven nada y que sólo ejecutan acciones. Dichos métodos se declaran con la palabra reservada void (vacío) como tipo de retorno.
- __main()__: Es el nombre del método que la máquina virtual de Java busca para comenzar a ejecutar un programa. Siempre ha de llamarse main.
- __String__: Es una clase que define cadenas de caracteres. Gracias a la clase String, Java puede manipular textos.
- __String args[]__: Cualquier clase que se declara con corchetes “__[ ]__”, quiere decir que lo que tienes no es una instancia de esa clase, sino un array de objetos de dicha clase. Por ejemplo, ___String[]___ meses contendría los nombres de los meses del año. El método main() de Java necesita un String[] porque el usuario de nuestro programa puede pasar parámetros extra desde la línea de comando a nuestro programa. Esos parámetros, el programador los recibe a través de ese array.

```java
public static void main(String[] args) {
…
}
```
La tercera parte del código corresponde a las sentencias:
- __System.out.println()__: es un método contenido en la __API de Java SE__ que _imprime por pantalla el texto que se le pasa entre paréntesis_, en este caso imprimirá el mensaje ___Hello World!___:

```java
System.out.println("Hello World!");
```

Documentación Oracle sobre cómo crear la aplicación Hello World! en Java, esta [aqui.](
https://docs.oracle.com/javase/tutorial/getStarted/application/)

## Elementos del Lenguaje Java

### Sentencias
Una sentencia _es una orden que se le da al programa para realizar una tarea específica_, esta puede ser: mostrar un mensaje en la pantalla, declarar una variable (para reservar espacio en memoria), inicializarla, llamar a una función, etc. Las sentencias acaban con el carácter __“;”__. Este carácter separa una sentencia de la siguiente. Normalmente, las sentencias se ponen unas debajo de otras (una en cada línea), aunque sentencias cortas pueden colocarse en una misma línea. Algunos ejemplos de sentencias:

```java
int i=1;
import java.awt.*;
System.out.println("Mi primer programa");
rect.mover(10, 20);
```

> __Nota:__ En el lenguaje Java, los caracteres espacio en blanco se pueden emplear libremente. Como podremos ver en los siguientes ejemplos, es muy importante para la legibilidad de un programa la colocación de unas líneas debajo de otras empleando tabuladores. El editor del IDE nos ayudará a realizar esta tarea de manera automática sin apenas percibirlo.

### Bloques de código
Un bloque de código no es más que una agrupación de sentencias que están agrupados entre llaves __“{ … }”__..
Ejemplo de bloque de código:

```java
int edad= 15;

if (edad < 18) { //comienzo del bloque
    System.out.println("Es menor");
} // fin de bloque
```

>__¿Qué hacer el programa?__ En el ejemplo anterior, hay una sentencia condicional donde se pregunta si el valor de la variable edad es menor de 18, en caso de que se cumpla la condición, se imprime el mensaje por pantalla “Usuario menor de 18 año”el conjunto de sentencias se reduce a tres sentencias, que llaman a los métodos predefinidos en Java print y println que permiten visualizar texto por el dispositivo de salida de datos (por defecto la pantalla).

### Expresiones
Una expresión es todo aquello que se puede poner a la derecha del operador de asignación __“=”__. Por ejemplo:
```java
x = 123;
y = (x + 100) / 4;
area = circulo.calcularArea(2.5);
Rectangulo r = new Rectangulo(10, 10, 200, 300);
```

- __La primera expresión__ asigna un valor a la variable __x__.
- __La segunda__, realiza una operación aritmética y el resultado se asigna a la variable y.
- __La tercera__, es una llamada a una función miembro calcularArea desde un objeto círculo de una clase determinada y el resultado se asigna a la variable area.
- __La cuarta__, reserva espacio en memoria para un objeto de la clase Rectangulo mediante la llamada a una función especial que tienen todas las clases denominada constructor.

### Comentarios
Un comentario es un texto adicional que se añade al código para explicar su funcionalidad, bien a otras personas que lean el programa, o al propio autor como recordatorio. Los comentarios son una parte importante de la documentación de un programa. Los comentarios son ignorados por el compilador, por lo que no incrementan el tamaño del archivo ejecutable; se puede, por tanto, añadir libremente al código para que pueda entenderse mejor.
El primer tipo de comentarios __son los comentarios de una sola línea__. En ellos se utiliza la secuencia de caracteres __//__. El compilador ignora todo lo que se incluya entre la secuencia de caracteres __// y el final de la línea__.
Por ejemplo:

```java
// Este es un comentario estilo C++, llega al final de la linea
sentencia_1;
```

>__Nota__: La pareja de caracteres __//__ hay que escribirla sin dejar ningún espacio en blanco entre ellos.


El segundo tipo de comentarios son los comentarios de múltiples líneas. En ellos se utilizan las secuencias de caracteres __/* para abrir el comentario y */__ para _cerrar el comentario_.
Por ejemplo:

```java
/* En este otro comentario estilo C, el final
lo indica la marca */
sentencia_1;
```

>__Nota__: Los comentarios pueden incluir cualquier carácter válido en Unicode y no pueden anidarse.


Estos dos formatos de comentario se emplean para los denominados comentarios de implementación. Los comentarios de implementación se utilizan en el programa fuente para resaltar código o para aclarar un desarrollo en particular.
Además, en Java existe un tercer tipo de comentario llamados comentarios de documentación (doc comments) que facilita la generación de documentación en formato HTML al emplear algunas herramientas de documentación (por ejemplo, Javadoc incluida en el Kit de Desarrollo de Java). Los comentarios para la documentación se emplean para describir la especificación del código, desde una perspectiva independiente cómo se ha implementado y ser leído por desarrolladores que no tengan necesariamente el código fuente a la vista. Ejemplos de este tipo de comentarios:

```java
/** Comentario estilo javadoc, se incluye
automáticamente en documentacion HTML */
/**
* Muchos programadores
* suelen incluir un asterisco
* al principio de cada linea del
* comentario para facilitar su lectura
*/
```

>__Nota__: Los comentarios deberían contener sólo información relevante para la lectura y comprensión del programa. Todos los programas deben empezar por un comentario que describa el propósito general del programa.

Artículo de Oracle sobre cómo escribir comentarios de documentación para la herramienta [Javadoc](
https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html).


### Convención para los comentarios al inicio de los programas

Todos los archivos fuente deberían comenzar con un comentario liste el nombre de la clase, información de la versión, fecha y el aviso de copyright:

```java
/**
* The HelloWorld program implements an application that
* simply displays "Hello World!" to the standard output.
*
* @author Joatham Perez Exposito
* @version 1.0
* @since 15-09-2023
*/
public class HelloWorld {
public static void main(String[] args) {
// Imprime el texto Hello, World! en la salida estándar.
System.out.println("Hello World!");
}
}
```
A continuación, se muestran algunas etiquetas (tags) que reconoce la herramienta Javadoc:

| Etiqueta | Descripción |Sintaxis|
|------|------|------|
| __@author__ |Añade el autor de una clase | _@autor nombre_ |
| __@version__ | Añade el número de la versión de la clase | _@version versión_ |
| __@since__ | Añade información de la creación de la clase | _@since fecha_|
| __@deprecated__ |Indica que el método o clase es obsoleto (propio de versiones anteriores) y que no se recomienda su uso. | _@deprecated descripción_ |

### Identificadores

Los identificadores son nombres que se les asignan a variables, métodos, clases, ..., en el código fuente de un programa. Los identificadores sólo existen en el código del programa fuente y no en el programa objeto (resultado de la compilación del programa fuente). Todo nuevo identificador que se emplee en un programa Java debe definirse previamente a su utilización. Las normas para la construcción de un identificador empleando el lenguaje de programación Java son las siguientes:
_Un identificador comienza por una letra, un carácter de subrayado “_” o un carácter de dólar “$”. Aunque no se recomienda emplear el carácter $, ya que el compilador suele utilizarlos de forma interna para crear identificadores propios_.
- Los siguientes caracteres pueden ser también dígitos, pero no pueden emplearse espacios en blanco u otros caracteres como el signo de interrogación (?) o el signo del tanto por ciento (%).
- No hay límite máximo de caracteres.
- En los identificadores del código fuente de un programa en Java se distinguen las mayúsculas de las minúsculas. Por ejemplo, las palabras casa, CASA y Casa son tres identificadores diferentes (El lenguaje Java es sensible a las mayúsculas).
- Pueden incluir caracteres Unicode, con lo que se pueden emplear secuencias de escape /uxxxx para representar estos caracteres.
- No puede emplearse el identificador de una variable o cualquier otro elemento del código fuente del programa para otro ya existente en el mismo bloque. Excepción: variable miembro y local con el mismo identificador.
- Existe una serie de palabras reservadas que no pueden emplearse como identificadores por el programador en el código fuente para otros usos. Por ejemplo, la palabra double se utiliza para definir un tipo de dato real y la palabra for se emplea para construir un tipo determinado de bucle.

En la siguiente tabla se muestran las palabras reservadas en Java.

<img src="images/identificadores.png" />

Las palabras reservadas se pueden clasificar en las siguientes categorías:
- __Tipos de datos__: boolean, float, double, int, char.
• __Sentencias condicionales__: if, else, switch.
• __Sentencias iterativas: for, do, while, continue__.
• __Tratamiento de las excepciones__: _try, catch, finally, throw_.
• __Estructura de datos__: _class, interface, implements, extends_.
• __Modificadores y control de acceso__: _public, private, protected, transient_.
- Otras: _super, null, this_.
A continuación, se muestran los nombres de métodos reservados en Java cuyo significado y utilización se explicará más adelante cuando se mencione la clase predefinida Object2:

    <img src="images/object.png" />

#### Recomendaciones a la hora de escribir identificadores

Aunque la forma de escribir los identificadores en Java no está normalizada, a continuación, se dan algunas recomendaciones para la elección de estos identificadores:
- Todos los identificadores han de comenzar con una letra, el carácter subrayado __“_”__ o el carácter dollar __“\$”__. ___Aunque se puede no se debe por buenas prácticas utilizar "_" ó "\$".__
- Puede incluir, pero no comenzar por un número.
- No puede incluir el carácter espacio en blanco.
- Distingue entre letras mayúsculas y minúsculas.
- No se pueden utilizar las palabras reservadas como identificadores.
Además de estas restricciones, hay ciertas convenciones que hacen que el programa sea más legible, pero que no afectan a la ejecución del programa. La primera y fundamental es la de encontrar un nombre que sea significativo, de modo que el programa sea lo más legible posible. El tiempo que se pretende ahorrar eligiendo nombres cortos y poco significativos se pierde con creces cuando se revisa el programa después de cierto tiempo:

    <img src="images/Convencion.png" />

#### Estilos de escritura

__CamelCase__ es un estilo de escritura que se aplica a frases o palabras compuestas. El nombre se debe a que las mayúsculas a lo largo de una palabra en ___CamelCase se asemejan a las jorobas de un camello__. El término CamelCase se podría traducir como literalmente como Mayúsculas/Minúsculas Camello.
Existen dos tipos de estilos de escritura CamelCase:
- UpperCamelCase: cuando la primera letra de cada una de las palabras es mayúscula.
- lowerCamelCase: igual que la anterior con la excepción de que la primera letra es minúscula.

>__Nota__: Ejemplo de UpperCamelCase: _EjemploDeUpperCamelCase_
Ejemplo de lowerCamelCase: _ejemploDeLowerCamelCase_. Utilizaremos ___lowerCamelCase___.

#### Convenciones para la Legibilidad del Programa Fuente

__Identación__ consiste en aplicar una sangría al código, mejorando así su legibilidad. Aunque la definición exacta de la indentación (espacios vs tabuladores) no se especifica en el lenguaje Java, se recomienda emplear una secuencia de cuatro espacios en blanco o tabulador como unidad de indentación.
Por otro lado, se recomienda evitar las líneas de más de 80 caracteres en el código fuente ya que no se manejan correctamente por muchos terminales y herramientas de edición. En el caso de que una sentencia sea muy grande se recomienda especificarla en dos líneas:
Ejemplo de una sentencia definida en dos líneas:

```kava
longName1 = longName2 * (longName3 + longName4 - longName5)
+ 4 * longname6; // PREFER
```

Ejemplo de la declaración de un método en dos líneas:

```java
private static synchronized horkingLongMethodName(int anArg,
    Object anotherArg, String yetAnotherArg,
    Object andStillAnother) {
    ...
}
```

</div>