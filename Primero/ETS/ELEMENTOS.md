# ELEMENTOS DEL DESARROLLO DE SOFTWARE


## Introducción


### En esta Unidad aprenderemos a

- Reconocer la relación de los programas con los componentes del sistema informático.
- Diferenciar código fuente, objeto y ejecutable.
- Identificar las fases de desarrollo de una aplicación informática.
- Clasificar los lenguajes de programación.


### Tipos de software

- **De sistema** (Sistema operativo, drivers -controladores-)
- **De aplicación** (Suite ofimática, Navegador, Edición de imagen, ...)
- **De desarrollo** (Editores, compiladores, interpretes, ...)

Los drivers son los controladores de dispositivos.

[//]: # (dafdasdf afddafads)

### Relación Hardware-Software  

- **Disco duro** :
almacena de forma permanente los archivos ejecutables y los archivos de datos.

- **Memoria RAM** :
almacena de forma temporal el código binario de los archivos ejecutables y los archivos de datos necesarios.

- **CPU** :
lee y ejecuta instrucciones almacenadas en memoria RAM, así como los datos necesarios.

- **E/S**:
recoge nuevos datos desde la entrada, se muestran los resultados, se leen/guardan a disco, ...


El disco duro se considera un periférico de E/S (Entrada/Salida).

La CPU se llama también UCP (en inglés), procesador o microprocesador.


### Códigos fuente, objeto y ejecutable

- __Código fuente__: archivo de texto legible escrito en un lenguaje de programación.
- __Código objeto__ (intermedio): archivo binario no ejecutable.
- __Código ejecutable__: archivo binario ejecutable.

Sólo válido para **lenguajes compilados: C, C++, Java**.

En **lenguajes interpretados** no exite código objeto, ni binario. Solo código fuente. Por ejemplo: PHP, Javascript, ...

**El código objeto en Java se denomina ByteCode**.


## Ciclo de vida del software


### Ingeniería de software

> Disciplina que estudia los principios y metodologías para el desarrollo y mantenimiento de sistemas software.

- Algunos autores consideran que "___desarrollo de software___" es un término más apropiado que "___ingeniería de software___" puesto que este último implica niveles de rigor y prueba de procesos que no son apropiados para todo tipo de desarrollo de software.
- [Ingeniería del software](https://es.wikipedia.org/wiki/Ingenier%C3%ADa_de_software)


### Desarrollo de software

<img align="center" src="../img/pasos-desarrollo-software.png" alt="Fases principales del desarrollo de software">


#### ___Fases principales___

- __ANÁLISIS__  
- __DISEÑO__
- __CODIFICACIÓN__
- __PRUEBAS__
- __MANTENIMIENTO__  


#### __ANÁLISIS__

- Se determina y define claramente las necesidades del cliente y se especifica los requisitos que debe cumplir el software a desarrollar.
- La **especificación de requisitos** debe:
  - Ser completa y sin omisiones
  - Ser concisa y sin trivialidades
  - Evitar ambigüedades. Utilizar lenguaje formal.
  - Evitar detalles de diseño o implementación
  - Ser entendible por el cliente
  - Separar requisitos funcionales y no funcionales
  - Dividir y jerarquizar el modelo
  - Fijar criterios de validación


#### __DISEÑO__

- Se descompone y organiza el sistema en elementos componentes que pueden ser desarrollados por separado.
- Se especifica la interrelación y funcionalidad de los elementos componentes.
- Las actividades habituales son las siguientes:
  - Diseño arquitectónico
  - Diseño detallado
  - Diseño de datos
  - Diseño de interfaz de usuario


#### __CODIFICACIÓN__

- Se escribe el código fuente de cada componente.
- Pueden utilizarse distintos lenguajes informáticos:
  - __Lenguajes de programación__: C, C++, Java, Javascript, ...
  - __Lenguajes de otro tipo__: HTML, XML, JSON, ...


#### __PRUEBAS__

- El principal objetivo de las pruebas debe ser conseguir que el programa funcione incorrectamente y que se descubran defectos.
- Deberemos someter al programa al máximo número de situaciones diferentes.


#### __MANTENIMIENTO__

- Durante la explotación del sistema software es necesario realizar cambios ocasionales.
- Para ello hay que rehacer parte del trabajo realizado en las fases previas.
- Tipos de mantenimiento:
  - __Correctivo__: se corrigen defectos.
  - __Perfectivo__: se mejora la funcionalidad.
  - __Evolutivo__: se añade funcionalidades nuevas.
  - __Adaptativo__: se adapta a nuevos entornos.


###  Resultado tras cada fase (I)

- Ingeniería de sistemas: __Especificación del sistema__
- ANÁLISIS: __Especificación de requisitos del software__
- DISENO arquitectónico: __Documento de arquitectura del software__
- DISENO detallado: __Especificación de módulos y funciones__
- CODIFICACIÓN: __Código fuente__


###  Resultado tras cada fase (II)

( _Continuación_ )

- PRUEBAS de unidades: __Módulos utilizables__
- PRUEBAS de integración: __Sistema utilizable__
- PRUEBAS del sistema: __Sistema aceptado__
- Documentación: __Documentación técnica y de usuario__
- MANTENIMIENTO: __Informes de errores y control de cambios__


### Metodología de desarrollo de software

Las metodologías de desarrollo de software son un conjunto de técnicas y métodos organizativos que se aplican para diseñar soluciones de software informático. El objetivo de las distintas metodologías es el de intentar organizar los equipos de trabajo para que estos desarrollen las funciones de un programa de la mejor manera posible.

Cuando se trata de desarrollar productos o soluciones para un cliente o mercado concreto, es necesario tener en cuenta factores como los costes, la planificación, la dificultad, el equipo de trabajo disponible, los lenguajes utilizados, etc. Todos ellos se engloban en una metodología de desarrollo que permite organizar el trabajo de la forma más ordenada posible.

El desarrollo de software puede ser un sector especialmente complejo, sobre todo cuando se trata de grandes aplicativos y equipos de trabajo. Ponerse a desarrollar un producto sin una metodología clara desembocará en un proceso aún más complejo, que conducirá a problemas, retrasos, errores y, en definitiva, un mal resultado final.

El trabajo con una metodología de desarrollo de software permite reducir el nivel de dificultad, organizar las tareas, agilizar el proceso y mejorar el resultado final de las aplicaciones a desarrollar.

- Modelos clásicos (predictivos)
  - Modelo en cascada
  - Modelo en V
- Modelo de construcción de prototipos
- Modelos evolutivos o incrementales
  - Modelo en espiral (iterativos)
  - Metodologías ágiles (adaptativos)

<img align="center" src="../img/metodologias-desarrollo-software.jpeg" alt="Metodologías de desarrollo">

### Modelo en cascada (I)

<img align="center" src="../img/metodologia-cascada.png" alt="Metodologia cascada">


### Modelo en cascada (II)

- Modelo de mayor antigüedad.
- Identifica las fases principales del desarrollo software.
- Las fases han de realizarse en el orden indicado.
- El resultado de una fase es la entrada de la siguiente fase.
- Es un modelo bastante rígido que se adapta mal al cambio continuo de especificaciones.
- Existen diferentes variantes con mayor o menor cantidad de actividades.


### Modelo en V (I)

<img align="center" src="../img/metodologia-v.png" alt="Metodologia en v">

### Modelo en V (II)

- Modelo muy parecido al modelo en cascada.
- Visión jerarquizada con distintos niveles.
- Los niveles superiores indican mayor abstracción.
- Los niveles inferiores indican mayor nivel de detalle.
- El resultado de una fase es la entrada de la siguiente fase.
- Existen diferentes variantes con mayor o menor cantidad de actividades.


### Prototipos (I)

- A menudo los requisitos no están especificados claramente:
  - por no existir experiencia previa.
  - por omisión o falta de concreción del usuario/cliente.

<img align="center" src="../img/metodologia-prototipo.jpeg" alt="Modelo de construcción de prototipos">


### Prototipos (II)

- Proceso:
  - Se crea un prototipo durante la __fase de análisis__ y es probado por el usuario/cliente para refinar los requisitos del software a desarrollar.
  - Se repite el paso anterior las veces necesarias.


### Prototipos (III)

- Tipos de prototipos:
  - __Prototipos rápidos__
    - El prototipo puede estar desarrollado usando otro lenguaje y/o herramientas.
    - Finalmente el prototipo se desecha.
  - __Prototipos evolutivos__
    - El prototipo está diseñado en el mismo lenguaje y herramientas del proyecto.
    - El prototipo se usa como base para desarrollar el proyecto.


### Modelo en espiral (I)

- Desarrollado por Boehm en 1988.
- La actividad de ___ingeniería___ corresponde a las fases de los modelos clásicos: análisis, diseño, codificación, ...

<img align="center" src="../img/metodologia-espiral.png" alt="Modelo en espiral">


### Modelo en espiral (II)
#### ___Aplicado a la programación orientada a objetos___

- En la actividad de ___ingeniería___ se da gran importancia a la reutilización de código.


### Metodologías ágiles (I)

- Son métodos de ingeniería del software basados en el desarrollo iterativo e incremental.
- Los requisitos y soluciones evolucionan con el tiempo según la necesidad del proyecto.
- El trabajo es realizado mediante la colaboración de equipos auto-organizados y multidisciplinarios, inmersos en un proceso compartido de toma de decisiones a corto plazo.
- Las metodologías más conocidas son:
  - Kanban
  - Scrum
  - XP (eXtreme Programming)


### Metodologías ágiles (II)

[Manifiesto por el Desarrollo Ágil](https://es.wikipedia.org/wiki/Manifiesto_%C3%A1gil)

- __Individuos e interacciones__ sobre procesos y herramientas
- __Software funcionando__ sobre documentación extensiva
- __Colaboración con el cliente__ sobre negociación contractual
- __Respuesta ante el cambio__ sobre seguir un plan


#### __Kanban (I)__

- También se denomina "sistema de tarjetas".
- __Desarrollado inicialmente por Toyota para la industria de fabricación de productos__.
- __Controla por demanda__ la fabricación de los productos necesarios en la cantidad y tiempo necesarios.
- Enfocado a entregar el máximo valor para los clientes, utilizando los recursos justos.
- [Lean manufacturing](https://es.wikipedia.org/wiki/Lean_manufacturing)
- [Kanban en desarrollo software](https://dosideas.com/noticias/metodologias/184-como-usar-kanban-en-el-desarrollo-de-software)


#### __Kanban (II)__

Pizarra kanban

<img align="center" src="../img/metodologia-kanban.png" alt="Pizarra kanban">


##### Algunas Herramientas Online

###### Trello

Trello fue vendida por la nada despreciable suma de 425 millones de dólares. La popular aplicación de productividad ya cuenta con 19 millones de usuarios registrados y es considerada por muchos una de las mejores aplicaciones para aplicar el método Kanban para organizar tareas. Esto no quiere decir que sea la única, hay muchas opciones similares.

<img align="center" src="https://images.ctfassets.net/rz1oowkt5gyp/7pYWhpQ3vnntxoShaImNws/777fabbf069416489167ab92027ce086/board.png?w=1200&fm=webp" alt="Pizarra kanban">


###### KanbanFlow

  KanbanFlow como su nombre lo deja bien claro, es un tablero Kanban que te permite organizar tu trabajo de una forma visual y te ayuda a simplificar la comunicación en equipo para aumentar tu productividad. Es una aplicación sumamente sencilla que se enfoca completamente en la popular técnica de productividad.

  <img align="center" src="https://i.blogs.es/0d08a2/kanbanflowboard_1000/1366_2000.png" alt="Pizarra kanban">


###### Archmule

  Archmule es una alternativa genial y bastante simplificada a Trello. Funciona de la misma manera, un gran tablero con columnas desde las que puedes arrastrar diferentes tareas en forma de tarjetas. También tienes una página de inicio en la que se te muestra un resumen con lo más importante de cada actualización de cada equipo o proyecto que sigues.

  <img align="center" src="https://i.blogs.es/36368a/hero-devices/1366_2000.png" alt="Pizarra kanban">

  Existen otras muchas herramientas [Online](https://www.genbeta.com/a-fondo/ocho-alternativas-gratuitas-a-trello-para-gestionar-tareas-y-equipos).

#### __Scrum (I)__

- Modelo de desarrollo incremental.
- Iteraciones (__sprint__) regulares cada 2 a 4 semanas.
- Al principio de cada iteración se establecen sus __objetivos priorizados__ (__sprint backlog__).
- Al finalizar cada iteración se obtiene una __entrega parcial utilizable por el cliente__.
- Existen reuniones diarias para tratar la marcha del _sprint_.


#### __Scrum (II)__

<img align="center" src="../img/metodologia-scrum.png" alt="Proceso SCRUM">


#### __XP (Programación extrema) (I)__

__Valores__

- Simplicidad
- Comunicación
- Retroalimentación
- Valentía o coraje
- Respeto o humildad


#### __XP (Programación extrema) (II)__

__Características__

- Diseño sencillo
- Pequeñas mejoras continuas
- Pruebas y refactorización
- Integración continua
- __Programación por parejas__
- __El cliente se integra en el equipo de desarrollo__
- Propiedad del código compartida
- Estándares de codificación
- 40 horas semanales

<img align="center" src="../img/metodologia-xp.jpeg" alt="Proceso SCRUM">



## Lenguajes de programación


###  Obtención de código ejecutable

- Para obtener código binario ejecutable tenemos 2 opciones:
  - __Compilar__
  - __Interpretar__


### Proceso de compilación/interpretación

- La compilación/interpretación del código fuente se lleva a cabo en dos fases:
  1. __Análisis léxico__
  2. __Análisis sintáctico__
- Si no existen errores, se genera el código objeto correspondiente.
- Un código fuente correctamente escrito no significa que funcione según lo deseado.
- No se realiza un análisis semántico.


### Lenguajes compilados

- Ejemplos: C, C++
- Principal ventaja: Ejecución muy eficiente.
- Principal desventaja: Es necesario compilar cada vez que el código fuente es modificado.


### Lenguajes interpretados

- Ejemplos: PHP, Javascript
- Principal ventaja: El código fuente se interpreta directamente.
- Principal desventaja: Ejecución menos eficiente.


### JAVA (I)

- Lenguajes compilado e interpretado.
- El código fuente Java __se compila__ y se obtiene un código binario intermedio denominado __bytecode__.
- Puede considerarse código objeto pero destinado a la máquina virtual de Java en lugar de código objeto nativo.
- Después este __bytecode__ __se interpreta__ para ejecutarlo.


### JAVA (II)

- Ventajas:
  - Estructurado y Orientado a Objetos
  - Relativamente fácil de aprender
  - Buena documentación y base de usuarios
- Desventajas:
  - Menos eficiente que los lenguajes compilados


### Tipos (I)

- Según la forma en la que operan:
  - __Declarativos__: indicamos el resultado a obtener sin especificar los pasos.
  - __Imperativos__: indicamos los pasos a seguir para obtener un resultado.


### Tipos (II)

- Tipos de __lenguajes declarativos__:
  - Lógicos: Utilizan reglas. Ej: Prolog
  - Funcionales: Utilizan funciones. Ej: Lisp, Haskell
  - Algebraicos: Utilizan sentencias. Ej: SQL
- Normalmente son lenguajes interpretados.


### Tipos (III)

- Tipos de __lenguajes imperativos__:
  - Estructurados: C
  - Orientados a objetos: Java
  - Multiparadigma: C++, Javascript
- Los lenguajes orientados a objetos son también lenguajes estructurados.
- Muchos de estos lenguajes son compilados.


### Tipos (IV)

- Tipos de lenguajes según nivel de abstracción:
  - Bajo nivel: ensamblador
  - Medio nivel: C
  - Alto nivel: C++, Java


### Evolución

- Código binario
- Ensamblador
- Lenguajes estructurados
- Lenguajes orientados a objetos


### Historia simplificada

[Historia simplificada](http://rigaux.org/language-study/diagram-light.png)

<img align="center" src="http://rigaux.org/language-study/diagram-light.png" alt="Historia simplificada">


### Historia detallada

[Historia detallada](http://rigaux.org/language-study/diagram.png)
<img align="center" src="http://rigaux.org/language-study/diagram.png" alt="Historia detallada">


### Criterios para la selección de un lenguaje

- Campo de aplicación
- Experiencia previa
- Herramientas de desarrollo
- Documentación disponible
- Base de usuarios
- Reusabilidad
- Transportabilidad
- Imposición del cliente
