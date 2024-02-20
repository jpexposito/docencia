<div align="justify">

# Diseño y realización de pruebas

Los diferentes tipos de testing en el desarrollo de software
En esta sección vamos a ver qué tipos de testing existen con relación al desarrollo de software.

Vamos a aprender en qué consisten y en qué se diferencian tales tipos, como por ejemplo: ___unit testing, integration testing, functional testing, acceptance testing, y muchos más___.

> _Existen muchos tipos de testing, o pruebas de software, que podemos usar para confirmar que nuestro software continúa funcionando correctamente tras introducir cambios nuevos sobre nuestro código fuente_.

No todas las pruebas son iguales. Es por ello que en este artículo vamos a ver cómo difieren las principales pruebas de software.

## Introducción

_Muchas veces, cuando trabajamos de manera independiente en proyectos pequeños, no tenemos la necesidad de (o el cliente no cuenta con el presupuesto para) escribir pruebas automatizadas_.

## Unit tests

_Las pruebas unitarias son a bajo nivel (cercanas al código fuente de nuestra aplicación)_.

Este tipo de testing ___consiste en probar de forma individual las funciones y/o métodos (de las clases, componentes y/o módulos que son usados por nuestro software)___.

Debido a lo específicas que son, generalmente son las pruebas automatizadas de menor coste, y pueden ejecutarse rápidamente por un servidor de [integración continua](https://www.jenkins.io/).

_Idealmente, cuando planeamos y escribimos pruebas unitarias, debemos aislar la funcionalidad hasta un punto en que no se pueda desglosar más, y entonces escribir pruebas a partir de ello_. 

>Nota:_Estas pruebas verifican que el nombre de la_ ___función o método sea adecuado, que los nombres y tipos de los parámetros sean correctos, y así mismo el tipo y valor___ _de lo que se devuelve como resultado_.

_Dado que las pruebas unitarias no deben tener ningún tipo de dependencia, se suele reemplazar los llamados a APIs y servicios externos por funcionalidad que los imite (para que no exista interacción que vaya más allá de la unidad que está siendo probanda), por ejemplo [mockito](https://site.mockito.org/)_.

En muchos casos inclusive se suele reemplazar las consultas a bases de datos, de modo que la prueba se enfoque en operar a partir de los valores de entrada, sin depender de ninguna fuente externa.

_Si no es factible aislar el uso de bases de datos de nuestras pruebas unitarias, será importante tener en cuenta el rendimiento y buscar optimizar nuestras consultas. [Sqlite](https://www.sqlite.org/index.html) nos puede ayudar a solventar esto_.

Esto es importante, porque si nuestras pruebas unitarias son de larga duración, resultará incómodo ejecutarlas y ralentizará significativamente los tiempos de desarrollo.

Cuando se habla de __[Test Driven Development (desarrollo guiado por pruebas)](https://www.amazon.es/Driven-Development-Example-Addison-Wesley-Signature/dp/0321146530)__, se hace referencia a unit tests. Es decir, se usan pruebas de este tipo como especificaciones de lo que nuestro código debe hacer.

## Integration tests

Las pruebas de integración verifican que los diferentes módulos y/o servicios usados por nuestra aplicación funcionen en armonía cuando trabajan en conjunto.

>Nota:_Por ejemplo, pueden probar la interacción con una o múltples bases de datos, o asegurar que los microservicios operen como se espera_.

___Las pruebas de integración son típicamente el paso siguiente a las pruebas unitarias___.

Y son generalmente más costosas de ejecutar, ya que requieren que más partes de nuestra aplicación se configuren y se encuentren en funcionamiento.

## Functional tests

Las pruebas funcionales se centran en los requerimientos de negocio de una aplicación.

Estas pruebas verifican la salida (resultado) de una acción, sin prestar atención a los estados intermedios del sistema mientras se lleva a cabo la ejecución.

A veces existe cierta confusión entre "integration tests" y "functional tests", ya que ambos requieren que múltiples componentes interactúen entre sí.

_La diferencia es que, una prueba de integración puede simplemente verificar que las consultas a una base de datos se ejecuten correctamente, mientras que una prueba funcional esperaría mostrar un valor específico a un usuario, en concordancia a lo definido por los requerimientos del producto_.

## End-to-end tests

Las pruebas de punta a punta replican el comportamiento de los usuarios con el software, en un entorno de aplicación completo.

___Estas pruebas verifican que los flujos que sigue un usuario trabajen como se espera, y pueden ser tan simples como cargar una página web, iniciar sesión,
o mucho más complejas, verificando notificaciones vía email, pagos en línea, etcétera___.

Las pruebas end-to-end son muy útiles, pero son costosas de realizar; y pueden ser difíciles de mantener cuando son automatizadas.

>Nota:_Por tanto, es recomendable tener unas pocas pruebas end-to-end, que resulten claves para nuestra aplicación, y confiar en mayor medida en las pruebas a bajo nivel (como pruebas unitarias y pruebas de integración) para detectar rápidamente aquellos cambios que impactan negativamente sobre nuestra aplicación_.

## Regression testing

Las pruebas de regresión verifican un conjunto de escenarios que funcionaron correctamente en el pasado, para asegurar que continúen así.

No debemos agregar nuevas características a nuestro regression test suite hasta que las pruebas de regresión actuales pasen.
Una falla en una prueba de regresión significa que una nueva funcionalidad ha afectado otra funcionalidad que era correcta en el pasado, causando una "regresión".
Una falla en un test de regresión podría indicar también que hemos vuelto a producir un bug que ya había sido resuelto en el pasado.

## Smoke testing

Las pruebas de humo son pruebas que verifican la funcionalidad básica de una aplicación.

Se pretende que sean pruebas rápidas de ejecutar,
y su objetivo es asegurar que las características más importantes del sistema funcionan como se espera.
Los smoke tests pueden ser muy útiles: justo después de construir una nueva versión de nuestra aplicación, para decidir si estamos listos para ejecutar pruebas más costosas,o justo después de un proceso de deployment, para asegurar que la aplicación está funcionando adecuadamente en el nuevo entorno desplegado.
>Nota:_Son un conjunto de pruebas automatizadas de alto nivel, y seleccionadas estrictamente_.
Tienen lugar entre las pruebas de integración y las pruebas de regresión. Y están ahí para verificar que la funcionalidad principal del sitio opera como es debido.

## Acceptance testing

Las pruebas de aceptación son pruebas formales, ejecutadas para verificar si un sistema satisface sus requerimientos de negocio.

Estas pruebas requieren que el software se encuentre en funcionamiento, y se centran en replicar el comportamiento de los usuarios, a fin de rechazar cambios si no se cumplen los objetivos. Estos objetivos pueden ir más allá de obtener una respuesta específica, y medir el rendimiento del sistema.

>Nota:_Son usualmente un conjunto de pruebas manuales que se realizan luego de que una fase de desarrollo ha finalizado (de modo que se pueda volver rápidamente e iterar si algo no está correcto)_.
Verifican que la características de nuestro software estén alineadas con todas las especificaciones iniciales y criterios de aceptación.
Suelen realizarse luego de las pruebas unitarias o de integración, para evitar que se avance mucho con el proceso de prueba, y determinar a tiempo si se necesitan cambios significativos.
Para que este tipo de pruebas se lleve a cabo correctamente resulta importante que los responsables del proyecto definan los criterios de aceptación justo antes de empezar a trabajar en el mismo. Así mismo, cualquier requerimiento adicional que surja durante el proceso deberá verse reflejado en tales criterios de aceptación.

## Performance testing

Las pruebas de rendimiento verifican cómo responde el sistema cuando éste se encuentra bajo una alta carga.

Estos tests son no-funcionales, y pueden tener diversas formas para entender la fiabilidad,
estabilidad y disponibilidad de la plataforma.

>Nota:_Observar los tiempos de respuesta cuando se ejecuta un alto número de requests (consultas al servidor), o ver cómo se comporta el sistema ante una cantidad significativa de datos_.

Las pruebas de rendimiento son, por su naturaleza, bastante costosas de implementar y ejecutar, pero pueden ayudarnos a comprender si nuevos cambios van a degradar nuestro sistema (como hacerlo más lento o aumentar su consumo de recursos).

Las pruebas de rendimiento no fallan del mismo modo en que lo hacen las demás pruebas. En vez de ello su objetivo es recolectar métricas y definir objetivos por alcanzar.

Generalmente es buena idea realizar pruebas de este tipo ante nuevos lanzamientos y/o refactorizaciones importantes en el código.

¿Por qué y cómo automatizar nuestras pruebas?
Una persona puede ejecutar todas las pruebas antes mencionadas, pero resultaría muy costoso y contra-productivo hacer ello.

Como humanos, tenemos una capacidad limitada para realizar una gran cantidad de acciones, de manera repetible y confiable. Pero una máquina puede fácilmente hacer ello, y probar que nuestro formulario de inicio de sesión funciona correctamente, incluso en el intento #1000, y sin quejarse.

Para automatizar nuestros tests, primero necesitamos escribirlos mediante código de programación usando un testing framework que se adapte a nuestra aplicación.

___Junit,PHPUnit, Mocha, RSpec___ son ejemplos de ___testing frameworks___, que podemos usar para escribir pruebas automatizadas en _Java, PHP, Javascript, y Ruby respectivamente_.
Existen muchas opciones por cada lenguaje.

## Exploratory testing

Mientras más características y mejoras agreguemos a nuestro código, mayor será la necesidad de escribir tests para asegurar que nuestro sistema funcione apropiadamente.

Así mismo, cada vez que corregimos un bug es prudente comprobar que otros que teníamos anteriormente no vuelvan a aparecer.

Automatizar es clave para hacer esto posible, y escribir pruebas (tarde o temprano) será parte de nuestro development workflow.

Entonces la pregunta es: ¿vale la pena hacer pruebas manuales hoy en día?

Y la respuésta es: sí, y deben enfocarse en lo que se conoce como "exploratory testing", donde el objetivo es descubrir errores que no son muy obvios.

Una sesión de pruebas exploratorias no debería exceder de 2 horas, y es necesario tener bien definido el alcance, para ayudar a los evaluadores a centrarse en un área específica del software.

Una vez que todos los testers (evaluadores) han sido informados, depende de ellos probar varias acciones para verificar cómo se comporta el sistema.

Este tipo de pruebas resulta costoso por naturaleza, pero permite descubrir errores en la UI y verificar flujos complejos que siguen los usuarios.

Resulta útil principalmente cuando se agrega una nueva característica importante a nuestra aplicación, para ayudar a comprender cómo se comporta en casos extremos.

## Integración Continua

La integración continua es un proceso de desarrollo de software en el que los desarrolladores integran el código nuevo que han escrito con una mayor frecuencia a lo largo del ciclo de desarrollo, y lo añaden a la base de código al menos una vez al día.

<img src="https://www.opensourceforu.com/wp-content/uploads/2021/06/Figure-1-Standard-development-process-with-SonarQube.jpg">

## Conclusión

Así como es importante verificar que nuestros usuarios pueden usar nuestra aplicación (pueden iniciar sesión, enviar mensajes, y/o actualizar datos), es igual de importante verificar que nuestro sistema siga funcionando adecuadamente cuando se ingresen datos incorrectos o se realicen acciones inesperadas.

Necesitamos anticipar qué ocurrirá cuando un usuario cometa un error ingresando datos incoheretes,
intente guardar un formulario sin completar todos los campos,
o vaya de un paso a otro sin seguir una secuencia, con o sin malas intenciones.
Así mismo, necesitamos verificar si es posible para un usuario comprometer datos (es decir, tener acceso a recursos que no deben).

### Reflexiona

Un buen conjunto de pruebas debería ___"romper nuestra aplicación" y ayudarnos a entender sus límites___.

Y por último, las pruebas son código también, por lo que no debemos olvidarlas durante los "code review", ya que son un paso importante para el pase a producción.

</div>
