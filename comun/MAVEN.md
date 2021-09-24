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


## Mi primer proyecto en Maven
 

<div align="center">
	<img width="300px" src="https://www.sneakerlost.es/hubfs/Como-atraer-y-retener-alumnos-extranjeros-01.png" alt="alumnos">
</div>

 Para comenzar con maven vamos a realizar un pequeño proyecto para entender cuales son sus puntos fuertes y en que nos puede ayudar.
 Debemos ejecutar el siguiente comando:

```console 
 mvn archetype:generate -DgroupId=es.iespuerto.instituto -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -Darc
```

 Una vez realizado este paso, y pasados unos segundos debemos impotar el proyecto en nuestro __IDE__ favorito. __Archico->Importar Proyecto__ generalmente.

 El ejemplo que vamos a realizar consiste en realizar una app llamada _Instituto_ que contenga las clases y el alumnado que pertenece a estas.

 - Instituto, contiene de 1..n clases, y la clase contienen de 1..m alumnos.
 - La clase _Alumno_ contien:
   - Nombre
   - Apellidos
   - Edad
 - La clase _Clase_ contine:
   - N-umero
   - Curso
   - Alumnos
 - La clase _Instituto_ contiene:
   - Clases.    
 - Métodos/Funciones:
   - Calcular el número de alumnso por clase.
   - Calcular el número total de alumnos en el instituto.
   - Calcular el número total de alumnos mayot de 25 años.
   - Calcular el número de alumnos que comienzan por A.
 - _Vamos a realizar todo esto de forma estructuturada y con test_.  
</div>