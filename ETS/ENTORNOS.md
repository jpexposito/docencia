
# Entornos integrados de desarrollo

## Introducción

En esta Unidad aprenderemos a:

- Instalar entornos de desarrollo, propietarios y libres.
- Personalizar y automatizar el entorno de desarrollo.
- Generar ejecutables a partir de código fuente.
- Identificar las características comunes y específicas de diversos entornos de desarrollo.

### Conceptos

- Codigo fuente
- Codigo intermedio u objeto
- Codigo binario
- Bibliotecas (librerías)
- Compilar
- Enlazar (Link)
- Interpretar


## Herramientas básicas


### Lo básico

- Editor de texto: permite escribir código fuente
- Compilador: genera código objeto a partir del código fuente
- Enlazador: agrupa varios archivos objeto en uno binario
- Interprete: lee código fuente y genera código binario para su ejecución


### Bibliotecas (o librerías) (I)

> Conjunto de archivos objeto que extienden la funcionalidad del lenguaje

- __Biblioteca estándar__ del lenguaje
- __Bibliotecas adicionales__


### Bibliotecas (o librerías) (II)

- __Biblioteca estándar del lenguaje C__
  - Entrada y salida por terminal
  - Manejo de archivos
  - Funciones matemáticas
- __Biblioteca estándar del lenguaje Java__
  - Entrada y salida por terminal
  - Manejo de archivos
  - Funciones matemáticas
  - Interfaz gráfica 
  - Red
  - Bases de datos
  - Gráficos (sólo 2D)


### Bibliotecas (o librerías) (III)

- Cada biblioteca está compuesta por varios archivos objeto
- Tipos
  - bibliotecas dinámicas (.DLL o .so) (.jar en Java)
    - muy usadas
  - bibliotecas estática (.LIB o .a)
    - menos usadas actualmente


### Bibliotecas (o librerías) (IV)

- Una biblioteca se compone de 2 partes:
  - Especificación (ofrece una API)
  - Implementación 

__API__ = Interfaz de Programación de Aplicaciones


### Entorno necesario en java

- JRE: necesario para ejecutar programas
  - JVM (inteprete java)
  - Biblioteca estándar
- JDK: necesario para desarrollar programas
  - Herramientas: javac, jar, javadoc, ...


### Construir (Build) (I) 

> Construir (Build) = Compilar + Enlazar

- Dos opciones:
 - Herramientas de construcción
 - Servidor de construcción


### Construir (Build) (II) 
#### __Herramientas de construcción__

  - make, ninja (C, C++)
  - ant, maven, gradle (Java)
  - grunt, gulp (Javascript)
  - rake (ruby)


### Construir (Build) (III) 
#### __Archivos de construcción (buildfiles)__

  - make: __Makefile__
  - ninja: __build.ninja__
  - ant: __build.xml__
  - maven: __pom.xml__
  - gradle: __build.gradle__
  - grunt: __Gruntfile.js__
  - gulp: __gulpfile.js__
  - rake: __Rakefile__


### Construir (Build) (IV) 

- Generadores de archivos de construcción
  - CMake: CMakeLists.txt
  - Meson: meson.build  


### Construir (Build) (V) 

 - Servidores de construcción
  - Jenkins 
  - TravisCI
  - CircleCI
  - Bamboo
  - TeamCity

## Entornos integrados de desarrollo (IDE)

### Evolución histórica

Una de las fases en el proceso de desarrollo de software es la fase de codificación, en la cual se hace uso de algún lenguaje de programación para pasar todas las acciones que debía llevar a cabo la aplicación a algún lenguaje que la máquina fuera capaz de entender y ejecutar. 

También se hizo alusión a herramientas de apoyo al proceso de programación. 

En esta unidad vamos a analizar, instalar y ejecutar estas herramientas para entender su acción y efecto. 

Muchas personas aprenden a programar utilizando un editor de texto simple, compilador y depurador. Pero la mayoría, finalmente, terminan haciendo uso de algún entorno de desarrollo integrado para crear aplicaciones. 

Un entorno integrado de desarrollo (IDE), es un tipo de software compuesto por un conjunto de herramientas de programación. 

En concreto, el IDE se compone de: 

- Editor de código de programación. 
- Compilador. 
- Intérprete.
- Depurador. 
- Constructor de interfaz gráfico. 

Los primeros entornos de desarrollo integrados nacieron a principios de los años 70, y se popularizaron en la década de los 90. Tienen el objetivo de ganar fiabilidad y tiempo en los proyectos de software. Proporcionan al programador una serie de componentes con la misma interfaz gráfica, con la consiguiente comodidad, aumento de eficiencia y reducción de tiempo de codificación. 

Normalmente, un IDE está dedicado a un determinado lenguaje de programación. No obstante, las últimas versiones de los IDE tienden a ser compatibles con varios lenguajes (por ejemplo, Eclipse, NetBeans, Microsoft Visual Studio) mediante la instalación de plugins adicionales. 

En este tema, nuestro interés se centra en conocer los entornos de desarrollo, los tipos, en función de su licencia y del lenguaje de programación hacia el cual están enfocados. 

Casi todas las personas que empiezan a programar utilizan un editor simple de textos y un compilador-depurador instalado en su equipo. Sin embargo, prácticamente todas acaban utilizando un entorno de desarrollo. 

#### Evolución Histórica

En las décadas de utilización de la tarjeta perforada como sistema de almacenamiento el concepto de Entorno de Desarrollo Integrado IDE sencillamente no tenía sentido. 

Los programas estaban escritos con diagramas de flujo y entraban al sistema a través de las tarjetas perforadas. Posteriormente, eran compilados. 

El primer lenguaje de programación que utilizó un IDE fue el BASIC (que fue el primero en abandonar también las tarjetas perforadas o las cintas de papel). 

Éste primer IDE estaba basado en consola de comandos exclusivamente (normal por otro lado, si tenemos en cuenta que hasta la década de los 90 no entran en el mercado los sistemas operativos con interfaz gráfica). Sin embargo, el uso que hace de la gestión de archivos, compilación y depuración; es perfectamente compatible con los IDE actuales. 

A nivel popular, el primer IDE puede considerarse que fue el IDE llamado Maestro. 
Nació a principios de los 70 y fue instalado por unos 22.000 programadores en todo el mundo. Lideró este campo durante los años 70 y 80. 

El uso de los entornos integrados de desarrollo se ratifica y afianza en los 90 y hoy en día contamos con infinidad de IDE, tanto de licencia libre como no. 

No hay unos entornos de desarrollo más importantes que otros. La elección del IDE más adecuado dependerá del lenguaje de programación que vayamos a utilizar para la codificación de las aplicaciones y el tipo de licencia con la que queramos trabajar. 

### Funciones de un entorno de desarrollo

Como sabemos, los entornos de desarrollo están compuestos por una serie de herramientas software de programación, necesarias para la consecución de sus objetivos.

Estas herramientas son: 
 - Un editor de código fuente. 
 - Un compilador y/o un intérprete. 
 - Automatización de generación de herramientas. Un depurador. 

Las funciones de los IDE son: 
 - Editor de código. 
 - Auto-completado de código, atributos y métodos de clases. 
 - Identificación automática de código. 
 - Herramientas de concepción visual para crear y manipular componentes visuales. 
 - Asistentes y utilidades de gestión y generación de código. 
 - Archivos fuente en unas carpetas y compilados a otras. 
 - Compilar proyectos complejos en un solo paso. 
 - Control de versiones: tener un único almacén de archivos compartido por todos los colaboradores de un proyecto. Ante un error, mecanismo de auto-recuperación a un estado anterior estable. 
 - Soportar cambios de varios usuarios de manera simultánea. 
 - Generar de documentación integrado. 
 - Detectar de errores de sintaxis en tiempo real. 

Otras funciones importantes son: 
 - Ofrece refactorización de código: cambios menores en el código que facilitan su legibilidad sin alterar su funcionalidad (por ejemplo cambiar el nombre a una variable). 
 - Permite introducir automáticamente tabulaciones y espaciados para aumentar la legibilidad. 
 - Depuración: seguimiento de variables, puntos de ruptura y mensajes de error del intérprete. 
 - Aumentar las funcionalidades a través de la gestión de sus módulos y  plugins. 
 - Administrar las interfaces de usuario (menús y barras de herramientas). 
 - Administrar configuraciones del usuario. 

### Ejemplos

<img align="center" width="300" height="300" src="../img/ide.png" alt="Entornos de desarrollo integrado">

- Destinados principalmente a C++:
  - DevC++
  - Microsoft Visual Studio
  - QtCreator
- Destinados principalmente a Java:
  - Netbeans
  - Eclipse
  - IntelJ IDEA
  - Oracle JDeveloper


### Herramientas en las que se apoya un IDE Java

#### JDK

  Necesario para desarrollar programas, ejecutarlos o generar su documentación interna.

#### Maven

  Herramienta adoptada por Java para la gestión de librerías.

### Tareas asociadas

 - [Tarea 1: Instalación de OpenJDK 8](tareas/tarea-jdk.md)    
 - [Tarea 2: Instalación de Maven](tareas/tarea-maven.md)  
 - [Tarea 3: Instalación de los IDE´s especificados](tareas/tarea-ide.md) 


