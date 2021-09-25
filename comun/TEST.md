<div align="justify">

# TESTING EN PROGRAMACIÓN

## Introducción

 Para comprender el concepto de calidad y cobertura de código o “code coverage”, debemos de hablar de pruebas unitarias o “unit tests”. Para lograrlo se va a hacer uso de un lenguaje coloquial y accesible, incluso para personas que no poseen habilidades de programación. No obstante te puedes pasar por el siguiente [enlace](https://jpexposito.com/preparing-development-environment-java/) y seguir documentando.

 A medida que vamos desarrollando un proyecto, se incrementa la posibilidad de introducir de forma accidental diversos errores. Esto se produce principalmente porque somos humanos.

 Una práctica habitual es descomponer nuestro código en partes pequeñas que seamos capaces de probar, llamadas funciones o métodos. Podemos ver estas funciones o métodos, en adelante funciones, como pequeñas acciones que sumadas realizan una acción mayor, o simples cajas que forman parte de otra caja. Un ejemplo, podría ser, un programa, calculadora (caja), que permite realizar operaciones simples de cálculo (suma + resta + multiplicación + división). De esta forma estas operaciones serán cajas simples que forman parte de la gran caja.

<div align="center">

__Programa => “La gran caja”__

__Operaciones => “cajas simples”__


<img src="https://jpexposito.com/wp-content/uploads/2021/03/idea-test.png" >

</div>

A este concepto, se le conoce como divide y vencerás o descomponer un gran problema en pequeños problemas para encontrar una mejor solución.

Teniendo en cuenta lo anterior, podemos encapsular las funcionalidades (construir cajas pequeñas), lo que nos permite diagnosticar y resolver los problemas (errores) con mayor facilidad.

Ahora vamos a trabajar en encontrar y solventar los problemas que detectemos. Para conseguirlo vamos a hacer uso del concepto de “unit test” o test unitario, en adelante test (Probar las cosas para saber que funcionan correctamente).

### Ejemplo Práctico

 Mi abuela tenía una calculadora para realizar los cálculos necesarios para vender su queso, una o dos veces por semana.
 <div align="center">
 <img src="https://jpexposito.com/wp-content/uploads/2021/03/abuela.png" >
</div>
 Este ejemplo resulta muy simple, pero pongamos que mi abuela se equivoca, y realiza una división por 0, cuál es el resultado correcto.
 La pregunta que te harás en estos momentos es por qué se producen estos errores, éstas son las principales causas:

 - Factor humano. Todos somos humanos menos yo.
 - Prisas. “Lo tienes que tener terminado para ayer”.
 - Exceso de seguridad en uno mismo. Nos creemos “Superman”. ¡Superman no!, pero Lobezno, sí que soy.
 - Complejidad del problema (caja) a resolver.

__Los test, tienen como principal misión evitar estos errores, y garantizar un programa eficiente.__

## ¿Qué es un test?

 Un test es una prueba, que tiene como objetivo detectar fallos en nuestras funciones durante el proceso de desarrollo.

 Mientras desarrollamos nuestro código, hemos de desarrollar de forma paralela los diferentes test para tener la certeza que nuestro programa es una solución robusta (eficiente).

### ¿Para qué sirven los test?

 Pensemos en un robot, bueno tal vez mi abuela eso no lo entiende, pero si la persona mayor detrás del visillo, que vigila el correcto funcionamiento de nuestro programa (calculadora), que para mi abuela servía para realizar los cálculos cuando vendía su queso. Bueno ese robot, (persona detrás del visillo), es el encargado de analizar el resultado de nuestras funciones (cajas), tanto cuando los parámetros de entrada (elementos) son correctos, como cuando estos no lo son, y la respuesta de la caja es la incorrecta. Es decir tenemos todo controlado, __La abuela del visillo lo tiene todo controlado__.

### ¿Por qué son además importantes en el desarrollo en cualquier lenguaje de programación?

 La respuesta es simple. __FORMA PARTE DEL CICLO DE DESARROLLO DE DESARROLLO__

 <div align="center">
 <img src="https://cdn-bjcjl.nitrocdn.com/HQYXfZvlijlYvwqzOZEqIWtqVqwJebrr/assets/static/optimized/rev-95dba2d/wp-content/uploads/2020/02/ciclo-de-vida-desarrollo-software-movil.gif" >

</div>

__Para trabajar de forma idónea los test debemos de ayudarnos de [maven](MAVEN.md)__. Además de la inyección de librerías, podremos hacer uso de los distintos pluyings para completar nuestros proyectos.

## Mi primer proyecto en Maven y Test

<div align="center">
    <img width="300px" src="https://www.sneakerlost.es/hubfs/Como-atraer-y-retener-alumnos-extranjeros-01.png" alt="alumnos">
</div>

 Para comenzar con maven y test vamos a realizar un pequeño proyecto para entender cuales son sus puntos fuertes y en que nos puede ayudar.
 Debemos ejecutar el siguiente comando:

```console
 mvn archetype:generate -DgroupId=es.iespuerto.instituto -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -Darc
```

 Una vez realizado este paso, y pasados unos segundos debemos impotar el proyecto en nuestro __IDE__ favorito. __Archico->Importar Proyecto__ generalmente.

 El ejemplo que vamos a realizar consiste en realizar una app llamada _Instituto_ que contenga las clases y el alumnado que pertenece a estas.

 - Instituto, contiene de 1..n clases, y la clase contienen de 1..m alumnos.
 - La clase _Alumno_ contiene:
   - Nombre
   - Apellidos
   - Edad
 - La clase _Clase_ contiene:
   - Numero
   - Curso
   - Alumnos
 - La clase _Instituto_ contiene:
   - Clases.    
 - Métodos/Funciones:
   - Calcular el número de alumnos por clase.
   - Calcular el número total de alumnos en el instituto.
   - Calcular el número total de alumnos mayor de 25 años.
   - Calcular el número de alumnos que comienzan por A.
 - _Vamos a realizar todo esto de forma estructuturada y con test_.

<details>
  <summary>PULSA PARA VER LA RESPUESTA CORRECTA:</summary>

  En primer lugar debemos de crear cada una de las clases que pide el ejercicio, con las distintas propiedades.
  - [Alumno.java](alumnos/src/main/java/es/iespuerto/jpexposito/Alumno.java)
  - [Clase.java](alumnos/src/main/java/es/iespuerto/jpexposito/Clase.java)
  - [Instituto.java](alumnos/src/main/java/es/iespuerto/jpexposito/Instituto.java)

Para continuar con la creación de los distintos __test__ de las clases anteriores:
  - [ClaseTest.java](alumnos/src/test/java/es/iespuerto/jpexposito/ClaseTest.java)
  - [InsitutoTest.java](alumnos/src/test/java/es/iespuerto/jpexposito/InsitutoTest.java)
  - [UtilsTest.java](alumnos/src/test/java/es/iespuerto/jpexposito/UtilsTest.java) Como clase de apoyo.

Hemos de ejecutar en la raiz del proyecto:

```console
  mvn clean install
```

Obteniendo el listado de test que se ejecutan, así como su resultado. Por último, si ver la cobertura de test que se ha obtenido.
    __alumnos/target/jacoco-out/index.html__.


  </details>

</div>
