<div align="justify">

<!--
<div align="center">
  <img src="https://bonosvip.com/img/logo_newsletter.jpg?v=2" width="400px">
</div>
-->

# Elaboración de diagramas de clases

## Introducción

  En esta Unidad aprenderemos a:
  - Identificar las herramientas para la elaboración de diagramas de clases.
  - Interpretar el significado de diagramas de clases.
  - Generar código a partir de un diagrama de clases.
  - Generar un diagrama de clases mediante ingeniería inversa.

## ¿Qué es un diagrama de clases?

  El diagrama de clases es uno de los diagramas incluidos en UML 2.5 clasificado dentro de los diagramas de estructura y, como tal, se utiliza para representar los elementos que componen un sistema de información desde un punto de vista estático.

  Es importante destacar que, por esta misma razón, este diagrama no incluye la forma en la que se comportan a lo largo de la ejecución los distintos elementos, esa función puede ser representada a través de un diagrama de comportamiento, como por ejemplo un diagrama de secuencia o un diagrama de casos de uso.

  El diagrama de clases es un diagrama puramente orientado al modelo de programación orientado a objetos, ya que define las clases que se utilizarán cuando se pase a la fase de construcción y la manera en que se relacionan las mismas. Se podría equiparar, salvando las distancias, al famoso diagrama de modelo Entidad-Relación (E/R), no recogido en UML, tiene una utilidad similar: la representación de datos y su interacción. Ambos diagramas muestran el modelo lógico de los datos de un sistema.

### Elementos de un diagrama de clases

  El diagrama UML de clases está formado por los elementos: __clases, relaciones e interfaces__.

#### Clases

  __Las clases son el elemento principal del diagrama y representa, como su nombre indica, una clase dentro del paradigma de la orientación a objetos__. Este tipo de elementos normalmente se utilizan para representar __conceptos o entidades del “negocio”__. _Una clase define un grupo de objetos que comparten características, condiciones y significado_. La manera más rápida para encontrar clases sobre un enunciado, sobre una idea de negocio o, en general, sobre un tema concreto es buscar los sustantivos que aparecen en el mismo. ___Por poner algún ejemplo, algunas clases podrían ser: Animal, Persona, Mensaje, Expediente…___ Es un concepto muy amplio y resulta fundamental identificar de forma efectiva estas clases, en caso de no hacerlo correctamente se obtendrán una serie de problemas en etapas posteriores, teniendo que volver a hacer el análisis y perdiendo parte o todo el trabajo que se ha hecho hasta ese momento.

  _Bajando de nivel_ una clase está compuesta por _tres elementos_: ___nombre de la clase, atributos, funciones___. Estos elementos se incluyen en la representación (o no, dependiendo del nivel de análisis).

  Para representar la clase con estos elementos se utiliza una caja que es dividida en tres zonas utilizando para ello lineas horizontales:
  - __La primera de las zonas se utiliza para el nombre de la clase__. En caso de que la clase sea ___abstracta___ se utilizará su nombre en ___cursiva___.
  - __La segunda de las zonas se utiliza para escribir los atributos de la clase__, ___uno por línea y utilizando el siguiente formato___:

  ```
    visibilidad nombre_atributo : tipo = valor-inicial { propiedades }
  ```
  Aunque esta es la forma “oficial” de escribirlas, __es común simplificando únicamente poniendo el nombre y el tipo o únicamente el nombre__.
  - __La última de las zonas incluye cada una de las funciones que ofrece la clase__. De forma parecida a los atributos, sigue el siguiente formato:

  ```
  visibilidad nombre_funcion { parametros } : tipo-devuelto { propiedades }
  ```

  _De la misma manera que con los atributos, se suele simplificar indicando únicamente el nombre de la función y, en ocasiones, el tipo devuelto._

  <div align="center">
    <img src="https://diagramasuml.com/wp-content/uploads/2018/08/Diagrama-de-clases_html_2aa23387.gif" width="150px">
  </div>

  </br>

  Tanto los atributos como las funciones incluyen al principio de su descripción la visibilidad que tendrá. Esta visibilidad se identifica escribiendo un símbolo y podrá ser:
  - __(+) Pública__. Representa que se puede acceder al atributo o función desde cualquier lugar de la aplicación.
  - __(-) Privada__. Representa que se puede acceder al atributo o función únicamente desde la misma clase.
  - __(#) Protegida__. Representa que el atributo o función puede ser accedida únicamente desde la misma clase o desde las clases que hereden de ella (clases derivadas).

  _Estos tres tipos de visibilidad son los más comunes. No obstante, pueden incluirse otros en base al lenguaje de programación que se esté usando (no es muy común). Por ejemplo: (/) Derivado o (~) Paquete._

  Un ejemplo de clase podría ser el siguiente:

  <div align="center">
    <img src="https://diagramasuml.com/wp-content/uploads/2018/08/Diagrama-de-clases_html_m17f15da7.gif" width="150px">
  </div>

  En caso de que un _atributo o función sea estático_, se representa en el diagrama __subrayando su nombre__.

  __Recuerden:__ _Una característica estática se define como aquella que es compartida por cada clase y no instanciada para cada uno de los objetos de esa clase. Es un concepto muy común_.

#### Relaciones

  Una __relación identifica una dependencia__. Esta dependencia puede ser entre dos o _más clases (más común) o una clase hacía sí misma (menos común, pero existen), este último tipo de dependencia se denomina dependencia reflexiva_.

  ___Las relaciones se representan con una linea que une las clases, esta línea variará dependiendo del tipo de relación___.

  Las relaciones en el diagrama de clases tienen varias propiedades, que dependiendo la profundidad que se quiera dar al diagrama se representarán o no. Estas propiedades son las siguientes:
  - __Multiplicidad__. Es decir, el número de elementos de una clase que participan en una relación. Se puede indicar un número, un rango… Se utiliza n o * para identificar un número cualquiera.
  - __Nombre de la asociación__. En ocasiones se escriba una indicación de la asociación que ayuda a entender la relación que tienen dos clases. Suelen utilizarse verbos como por ejemplo: __“Una empresa contrata a n empleados”__.

  <div align="center">
    <img src="https://diagramasuml.com/wp-content/uploads/2018/08/Clase8.png" width="350px">
  </div>

##### Tipos de relaciones

  Un diagrama de clases incluye los siguientes tipos de relaciones:
  - __Asociación__.
  - __Agregación__.
  - __Composición__.
  - __Dependencia__.
  - __Herencia__.

###### Asociación

  Este tipo de relación es el más común y se utiliza para representar dependencia semántica. Se representa con una simple linea continua que une las clases que están incluidas en la asociación.

  _Un ejemplo de asociación podría ser:_ __“Una mascota pertenece a una persona”__.


  <div align="center">
    <img src="https://diagramasuml.com/wp-content/uploads/2018/08/clases2.png" width="350px">
  </div>


##### Agregación

  Es __una representación jerárquica que indica a un objeto y las partes que componen ese objeto__. Es decir, representa relaciones en las que un objeto es parte de otro, pero aun así debe tener existencia en sí mismo.

  __Se representa con una línea que tiene un rombo__ en la parte de la clase que es una agregación de la otra clase (es decir, __en la clase que contiene las otras__).

  Un ejemplo de esta relación podría ser: __“Las mesas están formadas por tablas de madera y tornillos o, dicho de otra manera, los tornillos y las tablas forman parte de una mesa”. Como ves, el tornillo podría formar parte de más objetos, por lo que interesa especialmente su abstracción en otra clase__.

  <div align="center">
    <img src="https://diagramasuml.com/wp-content/uploads/2018/08/clases3.png" width="200px">
  </div>

##### Composición

La composición es similar a la agregación, representa una relación jerárquica entre un objeto y las partes que lo componen, pero de una forma más fuerte. En este caso, los elementos que forman parte no tienen sentido de existencia cuando el primero no existe. Es decir, cuando el elemento que contiene los otros desaparece, deben desaparecer todos ya que no tienen sentido por sí mismos sino que dependen del elemento que componen. Además, suelen tener los mismos tiempo de vida. Los componentes no se comparten entre varios elementos, esta es otra de las diferencias con la agregación.

Se representa con una linea continua con un rombo relleno en la clase que es compuesta.

_Un ejemplo de esta relación sería:_ __“Un vuelo de una compañía aerea está compuesto por pasajeros, que es lo mismo que decir que un pasajero está asignado a un vuelo”__.

<div align="center">
  <img src="https://diagramasuml.com/wp-content/uploads/2018/08/clases4.png" width="200px">
</div>

###### Diferencia entre agregación y composición
La diferencia entre agregación y composición es semántica, por lo que a veces no está del todo definida. Ninguna de las dos tienen análogos en muchos lenguajes de programación (como por ejemplo Java).

Un __“agregado”__ _representa un todo que comprende varias partes_; de esta manera, un Comité es un agregado de sus Miembros. Una reunión es un agregado de una agenda, una sala y los asistentes. En el momento de la implementación, esta relación no es de contención. (Una reunión no contiene una sala). Del mismo modo, las partes del agregado podrían estar haciendo otras cosas en otras partes del programa, por lo que podrían ser referenciadas por varios objetos que nada tienen que ver. En otras palabras, no existe una diferencia de nivel de implementación entre la agregación y una simple relación de “usos”. En ambos casos, un objeto tiene referencias a otros objetos. Aunque no existe una diferencia en la implementación, definitivamente vale la pena capturar la relación en el diagrama UML, tanto porque ayuda a comprender mejor el modelo de dominio, como porque puede haber problemas de implementación que pueden pasar desapercibidos. Podría permitir relaciones de acoplamiento más estrictas en una agregación de lo que haría con un simple “uso”, por ejemplo.

__La composición__, por otro _lado, implica un acoplamiento aún más estricto que la agregación, y definitivamente implica la contención_. El requisito básico es que, si una clase de objetos (llamado “contenedor”) se compone de otros objetos (llamados “elementos”), entonces los elementos aparecerán y también serán destruidos como un efecto secundario de crear o destruir el contenedor. Sería raro que un elemento no se declare como privado. Un ejemplo podría ser el nombre y la dirección del Cliente. Un cliente sin nombre o dirección no tiene valor. Por la misma razón, cuando se destruye al cliente, no tiene sentido mantener el nombre y la dirección. (Compare esta situación con la agregación, donde destruir al Comité no debe causar la destrucción de los miembros, ya que pueden ser miembros de otros Comités).

##### Dependencia

Se utiliza este tipo de relación para representar que una clase requiere de otra para ofrecer sus funcionalidades. Es muy sencilla y se representa con una flecha discontinua que va desde la clase que necesita la utilidad de la otra flecha hasta esta misma.

Un ejemplo de esta relación podría ser la siguiente:

<div align="center">
  <img src="https://diagramasuml.com/wp-content/uploads/2018/08/clases5.png" width="200px">
</div>

##### Herencia  

  Otra relación muy común en el diagrama de clases es la herencia. Este tipo de relaciones permiten que una clase (clase hija o subclase) reciba los atributos y métodos de otra clase __(clase padre o superclase)__. Estos atributos y métodos recibidos se suman a los que la clase tiene por sí misma. Se utiliza en relaciones “es un”.

  Un ejemplo de esta relación podría ser la siguiente: Un pez, un perro y un gato son animales.

  <div align="center">
    <img src="https://diagramasuml.com/wp-content/uploads/2018/08/clases6.png" width="200px">
  </div>

  En este ejemplo, las tres clases ___(Pez, Perro, Gato) podrán utilizar la función respirar, ya que lo heredan de la clase animal, pero solamente la clase Pez podrá nadar, la clase Perro ladrar y la clase Gato maullar___. La clase Animal podría plantearse ser definida abstracta, aunque no es necesario.

##### Interfaces

  Una interfaz es una entidad que declara una serie de atributos, funciones y obligaciones. Es una especie de contrato donde toda instancia asociada a una interfaz debe de implementar los servicios que indica aquella interfaz.

  Dado que únicamente son declaraciones no pueden ser instanciadas.

  Las interfaces se asocian a clases. Una asociación entre una clase y una interfaz representa que esa clase cumple con el contrato que indica la interfaz, es decir, incluye aquellas funciones y atributos que indica la interfaz.

  Su representación es similar a las clases, pero indicando arriba la palabra <<interface>>.

  <div align="center">
    <img src="https://diagramasuml.com/wp-content/uploads/2018/08/clases15.png" width="150px">
  </div>

### Cómo dibujar un diagrama de clases

  Los diagramas de clase van de la mano con el diseño orientado a objetos. Por lo tanto, saber lo básico de este tipo de diseño es una parte clave para poder dibujar diagramas de clase eficaces.
  Este tipo de diagramas son solicitados cuando se está describiendo la vista estática del sistema o sus funcionalidades. Unos pequeños pasos que puedes utilizar de guía para construir estos diagramas son los siguientes:
  - __Identifica los nombres de las clase__.
  - El __primer paso__ es _identificar los objetos primarios del sistema_. __Las clases suelen corresponder a sustantivos dentro del dominio del problema__.
  - __Distingue las relaciones__.
  - __El siguiente paso es determinar cómo cada una de las clases u objetos están relacionados entre sí. Busca los puntos en común y las abstracciones entre ellos; esto te ayudará a agruparlos al dibujar el diagrama de clase.__
  - __Crea la estructura__.
  _Primero, agrega los nombres de clase y vincúlalos con los conectores apropiados, prestando especial atención a la cardinalidad o las herencias. Deja los atributos y funciones para más tarde, una vez que esté la estructura del diagrama resuelta_.

### Buenas prácticas en la construcción del diagrama de clases

  Te recomiendo seguir estas indicaciones o consejos, que, aunque no son obligatorios, harán que tus diagramas de clases sean de mayor utilidad:
  - Los diagramas de clase pueden tender a volverse incoherentes a medida que se expanden y crecen. Es mejor evitar la creación de diagramas grandes y dividirlos en otros más pequeños que se puedan vincular entre sí más adelante.
  - Usando la notación de clase simple, puedes crear rápidamente una visión general de alto nivel de su sistema. Se puede crear un diagrama detallado por separado según sea necesario, e incluso vincularlo al primero para una referencia fácil.
  - Cuantas más líneas se superpongan en sus diagramas de clase, más abarrotado se vuelve y, por tanto, más se complica utilizarlo. El lector se confundirá tratando de encontrar el camino. Asegúrate de que no haya dos líneas cruzadas entre sí, a no ser que no haya más remedio.
  - Usa colores para agrupar módulos comunes. Diferentes colores en diferentes clases ayudan al lector a diferenciar entre los diversos grupos.

### Ejemplos de diagrama de clases

#### Diagrama de clases clínica veterinaria

<div align="center">
  <img src="https://diagramasuml.com/wp-content/uploads/2018/11/clases.png">
</div>

#### Diagrama de clases zoológico

<div align="center">
  <img src="https://diagramasuml.com/wp-content/uploads/2018/11/clases.jpg">
</div>

#### Diagrama de clases de una tienda

<div align="center">
  <img src="https://diagramasuml.com/wp-content/uploads/2019/03/3clases.png">
</div>

#### Diagrama de clases gestión de biblioteca

<div align="center">
  <img src="https://diagramasuml.com/wp-content/uploads/2019/10/metricaclases.png">
</div>

#### Diagrama de clases centro educativo

<div align="center">
  <img src="https://diagramasuml.com/wp-content/uploads/2020/11/93CB39A8-A17C-49EE-AA93-C7E6648D7601.jpeg" >
</div>
