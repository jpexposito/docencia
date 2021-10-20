<div align="justify">

# PRIMEROS PASOS EN MAVEN

## Introducción

 En el mundo del desarrollo Java, desde mi opinión, una herramienta revolucionó la creación y gestión de proyectos en este lenguaje. Esta es como no, maven, una herramienta que es mucho más que un gestor de dependencias dentro de nuestro proyecto. Apache Maven o comúnmente conocido como “Maven” es una herramienta esencial para los programadores en Java. Éste nos ayudará a construir nuestro proyecto, manejar dependencias, generar documentación y muchísimas cosas más. Nosotros podemos ver su capacidad para solventar problemas, conociendo como era el trabajo de los desarrolladores java pre-maven, “por definirlos de alguna forma”.

 <div align="center">
  <img src="https://jpexposito.com/wp-content/uploads/2021/02/maven-logo.png" alt="maven" >
 </div>

 Cuando nosotros necesitamos añadir una librería a nuestro proyecto, lo que se realizaba era acudir a internet y descargar la dependencia en cuestión, pero esto no es una buena práctica.

## Unos minutos con Maven

 Ejecutados los pasos anteriores, podremos comenzar a conocer la herramienta. Comenzaremos creando nuestro primer proyecto de forma manual. Para ello seguiremos el siguiente manual, y describiremos los comandos utilizados y los ficheros creados y su contenido.

#### Creación de un proyecto
 Para la creación hemos de ejecutar el siguiente comando, desde una terminal (windows / linux / mac).

```console
 mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
 ```
 Además también se podrá crear el proyecto con la ayuda del __IDE__ con el que estemos trabajando.

 Una vez ejecutada, y tras unos segundos de la descarga de las librerías necesarias por primera vez, obtendremos la siguiente estructura.

```console
my-app
|-- pom.xml
`-- src
    |-- main
    |   `-- java
    |       `-- com
    |           `-- mycompany
    |               `-- app
    |                   `-- App.java
    `-- test
        `-- java
            `-- com
                `-- mycompany
                    `-- app
                        `-- AppTest.java
```

 Para comprender de una forma correcta la función de cada una de las carpetas y ficheros creados de forma automática, podemos consultar la documentación oficial.Inicialmente haré hincapié sólo en los siguientes directorios o ficheros:
 - src/main/java: Código fuente de nuestra aplicación.
 - src/main/resources: Ficheros de configuración de nuestra aplicación.
 - src/test/java: Código fuente de nuestros test.
 - src/test/resources: Ficheros para la ejecución de nuestros test.
 - …

 Existen otros que se crearán en función del tipo de proyecto que vayamos a construir, o los comandos que ejecutemos a través de maven (javadoc, …).

#### Ciclo de Vida

 El ciclo de vida de maven se puede resumir a través de la siguiente imagen:
 <div align="center">
  <img width="200px" src="https://jpexposito.com/wp-content/uploads/2021/02/lifecycle-maven.jpg" alt="maven" >
  <p>Fuente: Libro Maven Lifecycle</p>
 </div>

 Para la ejecución de los distintos comandos que supondrán la ejecución hasta la fase que deseemos realizar, hemos de situarnos en el directorio donde se encuentre el fichero pom.xml.

#### Comandos más destacados:

 - mvn clean.- Realiza una limpieza de las clases generadas hasta el momento.
 - mvn compile.- Compila nuestro proyecto.
 - mvn package.- Genera el empaquetado del proyecto, generalmente un jar si no se especifica otro tipo.
 - mvn install.- LLeva el empaquetado (jar) a nuestro repositorio local. Queda “visible” para otros proyectos maven en nuestro ordenador.
 - mvn deploy.- Lleva el empaquetado (jar) a nuestro servidor de librerías. Queda “visible” para otros proyectos maven en otros ordenadores. Este comando necesita que a maven se le haya indicado dónde está dicho servidor.
 - mvn javadoc:javadoc.- Genera la documentación javadoc de nuestro proyecto.
 - mvn site.- Genera documentación html del proyecto. Por supuesto, necesitamos haber escrito en determinados ficheros el contenido de esa documentación.

 Además maven proporciona comandos para adaptarse a los ide´s como:
 - mvn eclipse:eclipse.
 - mvn idea:idea.

 Por último, el conjunto de comandos, para las distintas fases del ciclo de vida de maven, en el siguiente [link](https://jpexposito.com/lets-go-maven/).


 #### Instalación en Linux

   Para realizar la instalación en Linux hemos de ejecutar desde una consola el siguiente comando:

  ```
   sudo apt install maven
  ```

   Para verificar la instalación, ejecute mvn -version:
  ```
   mvn -version
  ```

   La salida debería verse así:

  ```
  Apache Maven 3.6.3
   Maven home: /usr/share/maven
   Java version: 11.0.7, vendor: Ubuntu, runtime: /usr/lib/jvm/java-11-openjdk-amd64
   Default locale: en_US, platform encoding: UTF-8
   OS name: "linux", version: "5.4.0-29-generic", arch: "amd64", family: "unix"
  ```

  Con esto podeís comenzar a disfrutar de un buen compañero de viaje en el desarrollo con Java.

  <div align="center">
   <img src="https://i1.wp.com/suayed.iztacala.unam.mx/wp-content/uploads/2014/07/despedida.jpg?resize=300%2C225&ssl=1" alt="disfrutar" >
  </div>

</div>
