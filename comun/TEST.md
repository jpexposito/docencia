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
 <img src="https://exceldata.pe/wp-content/uploads/2017/10/search-engine-machine.gif" >
</div>

</div>