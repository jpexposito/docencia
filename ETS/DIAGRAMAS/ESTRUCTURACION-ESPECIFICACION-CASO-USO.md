<div align="justify">

# ESTRUCTURACIÓN Y ESPECIFICACIÓN DE LOS CASOS DE USO

## Introducción

  Los CU forman parte de las especificaciones de UML 2.0, así como de metodologías de desarrollo, los mismos son empleados para la especificación de requerimientos funcionales.

  El propósito es esta página es presentar una guía para la construcción de Casos de Uso (CU o UC), ello implica los pasos para la construcción del diagrama, la especificación de los CU y la forma en como deben estructurarse para aprovechar las bondades de reutilización, modularización y herencia entre CU.

  Este documento está dirigido a los analistas de requerimientos y los revisores internos de los documentos relacionados con los CU con el objeto de establecer los criterios que permitan evaluar si los CU han sido escritos de forma útil, comprensible, portable, completa y sin ambigüedades.

  Cada analista de requerimientos debe conocer profundamente el significado de escribir CU y el empleo que a éstos se les dará. Los casos de uso son una manera de capturar requerimientos, para ser expresados a los equipos de análisis, quienes encontrarán en estos su principal fuente para identificar objetos y clases.

  Pueden definirse varios estilos de CU dependiendo de las características del sistema a ser descrito, en este documento se encontrarán igualmente las pautas para cada uno de los estilos autorizados por la Organización, así como los criterios que permiten identificar cuándo cada criterio debe ser utilizado y por qué.

  El documento es producido como una recopilación de buenas prácticas y conceptos de varias fuentes de literatura, libros, cursos de requerimientos, presentaciones sobre requerimientos de IBM Rational, entre otros. El documento representa un esfuerzo para realizar, de manera consistente casos de uso, manteniendo el espíritu de lo que es un caso de uso y no una especificación tradicional o un algoritmo.

  Otros documentos relacionados con esta guía son la “Guía para la clasificación y trazabilidad de los requerimientos”, “Guía para el análisis de CU”, “Checklist de validación de CU” y “Pautas para la construcción del glosario”.

## ¿Cuando utilizar los Casos de Uso?

  Los casos de uso son un tipo de requerimientos utilizados para especificar funcionalidad, especialmente en sistemas con un alto grado de interacción hombre/máquina (y pueden ser utilizados hasta en sistemas de batch). En esencia los casos de uso describen los intercambios entre el sistema que se está describiendo y las personas o sistemas externos que interactúan con el primero, por lo tanto son muy útiles para describir funcionalidades a varios tipos de usuarios y con muchas interfaces.

## ¿Para qué sirven los Casos de Uso?

  Los casos de uso son útiles para capturar requerimientos, ayudar a definir la arquitectura, establecer las pautas para el diseño y las pruebas funcionales. ___Los CU son una guía de los elementos que serán incluidos en los documentos de usuarios para las aplicaciones, así como la forma en como éstos deben ser empleados. Los CU también establecen las bases para los protocolos de comunicación entre aplicaciones y el diseño de las interfaces gráficas, entre otros___.

  ___La validez de los casos de uso viene dada cuando los usuarios e involucrados del sistema aceptan el funcionamiento propuesto en los CU, siempre que la redacción de los mismo sea buena, no dejando cabida a ambigüedades.___

  Entonces los casos de uso deben ser útiles y ofrecer valor tanto al equipo de usuarios e involucrados como a los desarrolladores del proyecto.

## ¿Qué es un Modelo de CU y que son los CU?  

  Los casos de uso describen secuencias de acciones que realiza un sistema y que lleva a un resultado de valor a un actor específico.

  Un modelo de CU está compuesto por dos partes, un diagrama (gráfico) y una parte textual. El diagrama muestra las relaciones entre actores y casos de uso, así como las relaciones entre los CU y entre actores – en caso que existan –. La parte textual muestra la descripción escrita en lenguaje natural que narra los pasos y demás características del caso de uso.


## ¿Qué son los actores y cómo identificarlos?

- Actor es algo o alguien fuera del Sistema que interactúa con el Sistema.

- Un actor especifica un rol que alguna entidad externa adopta cuando interactúa con el sistema directamente. Puede representar un rol de usuario o un rol jugado por otro sistema o hardware que toca la frontera del sistema.

La siguiente es la lista de preguntas que permiten identificar a los actores que interactuarán con el Sistema:
- ¿Quién o qué utiliza el Sistema?
- ¿Qué roles toman en la interacción?
- ¿Quién toma información del Sistema?
- ¿Quién provee información al Sistema?
- ¿En qué parte de la compañía es utilizado el Sistema?
- ¿Quién instala, soporta y mantiene el Sistema?
- ¿Quién inicia y termina la ejecución del sistema?
- ¿Qué otros sistemas utilizan el Sistema?
- ¿Ocurre algo en algún momento específico?


La especificación de una caso de uso debe describir el modo
en que un actor interactúa con el sistema. Es una narración que describe el rol desempeñado por los actor en su interacción con el sistema.

Lo más importante de los casos de uso es su descripción, mucho más que los diagramas de casos de uso.

Aunque hay descripciones de media página, y algunas de __30__, es más habitual que ocupen entre __5 y 15__ páginas.


|  Actor | XXX (Nombre del Actor) |
|---|---|
| Descripción  | _Breve descripción del actor_  |
| Características  | _Características que describen al actor_ |
| Relaciones | _Relaciones que tiene con otros actores. Básicamente cuando realiza las mismas acciones que otro actor._  |
| Referencias | _Que casos de uso realiza_ |   
|  Notas |  _Notas adicionales_ |
| Autor  | _Quien desarrolla la especificación del actor_ |
|Fecha | _Fecha de la especificación_ |

|  Atributo |||
|---|---|---|
| _Nombre_  | _Descripción_  | _Tipo_ |
| | |


___El diagrama de CU no debe reflejar ni el flujo de control ni el flujo de datos, sino de asociaciones que son canales de comunicación.___

  Los casos de uso reflejan las relaciones entre los actores y los casos de uso.


## ¿Qué son Casos de Uso y cómo identificarlos?

  Los ___Casos de Uso___ representan lo que un actor desea que haga el Sistema. Los casos de uso definen una secuencia de acciones ejecutadas por un sistema que producen un resultado observable de valor para un actor.

  Los casos de uso son siempre iniciados por un actor y son escritos desde el punto de vista del actor.

  La siguiente es la lista de preguntas que permiten identificar los casos de uso dentro de las fronteras de un sistema:
  - ¿Qué funciones del sistema son requeridas por un actor específico?
  - ¿El sistema guarda o recupera información? Si es así ¿Qué actores disparan esta acción?
  - ¿Qué ocurre cuando el sistema cambia de estado? ¿Algún actor es notificado?
  - ¿Algún evento externo afecta al sistema? ¿Qué notifica el sistema respecto de estos eventos?
  - ¿El sistema interactúa con algún sistema externo?
  - ¿El sistema genera algún reporte?

### ¿Como especificar Casos de Uso?

  La especificación de los casos de uso se refiere a la descripción de cada una de las partes definidas para lograr su descripción completa. En la organización, la especificación de los Casos de Uso se hará bajo el formato presentado a continuación. El siguiente cuadro muestra las partes y las indicaciones básicas para iniciar su redacción. En las siguientes secciones del documento se presentan las recomendaciones que hacen que la redacción de CU sea más fácil, sencilla de leer y escribir.

  |  Caso de Uso	CU | XXX  |
  |---|---|
  | Fuentes  | _Documento que sustenta el caso de uso_  |
  | Actor  |  _Actores que participan en el caso de uso_ |
  | Descripción | _Descripción del caso de uso_  |
  | Flujo básico | _Descripción paso a paso de la ejecución. (1->2->3.)_ |
  | Pre-condiciones | _Que debe ocurrir con anterioridad_  |  
  | Post-condiciones  | _Que debe ocurrir con posterioridad_  |  
  |  Requerimientos | _Que debe de exister para que el caso de uso se ejecute. Ej: Tarjeta de crédito_  |
  |  Notas |  _Notas adicionales_ |
  | Autor  | _Quien desarrolla la especificación del actor_ |
  |Fecha | _Fecha de la especificación_ |


## Ejemplos de especificación de Casos de Uso

  La especificación de casos de uso, se realiza tanto en sistema públicos como privados. Algunos ejemplos en sistemas públicos son:
  - [Comunidad autónoma de Andalucía](https://www.juntadeandalucia.es/servicios/madeja/contenido/recurso/416).
  - [Comunidad autónoma de Canarias](http://www.gobiernodecanarias.org/platino/ext/doc/servicio-spic/2.0/CasosDeUso/CasosDeUso.html).

  Como podemos observar la especificación de los casos de uso difiere un función de las necesidades y de las personas a las que este destinada el documento.

  En la [Comunidad autónoma de Andalucía](https://www.juntadeandalucia.es/servicios/madeja/contenido/recurso/416), se ha descrito la especificación a uso general, mientras que en la [Comunidad autónoma de Canarias](http://www.gobiernodecanarias.org/platino/ext/doc/servicio-spic/2.0/CasosDeUso/CasosDeUso.html), se ha descrito la especificación para un perfil técnico que hará uso del sistema y que se combina con otros diagramas.

</div>
