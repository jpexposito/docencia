<div align="justify">

# Tarea 5: Despliegue de War en de Apache-Tomcat

<div align="center">
  <img src="http://tomcat.apache.org/res/images/tomcat.png"  />
</div>

## Introducción

  Apache Tomcat es uno de los Web Server más populares en la comunidad de Java. Este es capaz de albergar servicios o aplicaciones empaquetados como aplicaciones web. Para ello entre otras cosas deben de tener la extensión __.war__.

  En esta tarea vamos a ver como se realiza el despliegue y la eliminación de una aplicación web en este contenedor de aplicaciones.

## Estructura en Tomcat  

  Resulta muy interesante familiarizarse con las carpetas más importantes para este cometido en __Tomcat__.

### $CATALINA_HOME

  Esta variable es el punto de instalación de __Tomcat__.

### $CATALINA_BASE  

  Esta variable es el directorio de despliegue de las aplicaciones en __Tomcat__, configurable si se desea. Esta variable no se setea explícitamente, suele y debe estar asociada al valor de __$CATALINA_HOME__.

  Las aplicaciones web son desplegadas en el directorio __$CATALINA_HOME\webapps__.

## Terminología

  -  Document root. Referencia la carpeta superior de la aplicación web, donde están localizados todos los recursos: _jsp, html, clases java, e imágenes.
  - Context path. Hace referencia a la localización de la dirección del servidor y representa el nombre de la aplicación web.
  Por ejemplo, si nuestra aplicación web esta desplegada en _$CATALINA_HOME\webapps\myapp_, el acceso a la aplicación debiera de ser _http://localhost/myapp_, y el contexto de la aplicación esta en _/myapp_.
  - War. Es la extensión de los ficheros que contienen una aplicación Web, que hereda directamente de _Zip_ y es utilizado para comprimidos web. La creación de los ficheros con extensión _war_ puede ser a través de directamente el _IDE_ o a través de herramientas como _Maven_ que realizan la construcción de este tipo de ficheros, y el despliegue automático.
  ```
  <plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
        <url>http://localhost:8082/manager/text</url>
        <server>TomcatServer</server>
        <path>/myapp</path>
    </configuration>
  </plugin>
  ```
  El despliegue se realizará a través de comandos del tipo:
```console
  mvn tomcat7:deploy
```
  ,o el redespliegue:
```console
  mvn tomcat7:redeploy
```
  , por último la eliminación con:
```console
  mvn tomcat7:undeploy
```

## Creación de una App Web en Java

### Requisitos previos

  Dado que disponemos de la instalación de [JAVA](../../../comun/JDK.md), vamos a realizar la instalación de [MAVEN](../../../comun/MAVEN.md).

### Construcción del proyecto

  En el siguiente enlace dispones de un proyecto de una app en [Java](../../../comun/ejemplos/java), donde debes de realizar los siguientes cambios:
  - Fichero __web.xml__. Sustituye:
  ```console
     <display-name>app-web-alumno</display-name>  
     ```
  por:
  ```console
     <display-name>app-web-aron</display-name>
  ```
  donde _aron_ sería el nombre del alumno.
  - Fichero __index.jsp__. Realiza la sustitución del valor alumno siguiendo el mismo patrón.

  Lanza el siguiente comando:
  ```console
  mvn clean install
  ```
  Dentro de la carpeta __target__ debes de encontrar un fichero de nombre __app-web-demo.war__. Este nombre se especifica dentro del fichero _pom.xml_, por si tienes curiosidad y deseas cambiarlo.

  _No obstante, si quieres, puedes hacer uso de maven para la construcción de la aplicación web. Para ello, vamos a invocar el siguiente comando, donde alumno, debe de ser las siglas del alumno que esta realizando la tarea_.

  ```console
  mvn archetype:generate -DgroupId=es.iespuerto.alumno -DartifactId=app-alumno
    -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
  ```  
  _Tras la ejecución del comando y después de unos instantes, mientras se descargan numerosas librerías la primera vez, tendremos una aplicación web completa en Java, lo que vulgarmente se conoce como un hola mundo_.


<div align="center">
  <img width="400px" src="http://josecostaros.es/wp-content/uploads/2013/04/hola_mundo-676x450.jpg"  />
</div>


## Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la instalación, configuración y despliegue de una app en  __Apache-Tomcat__.

  Además el informe debe de contener:
   - Título de la tarea.
   - Nombre y Apellidos.
   - Índice
   - Pasos descritos.
   - Capturas de pantalla.

### A tener en cuenta:

  - Se pasará el programa antí copia para verificar autenticidad.
  - __5 faltas de ortografía se baja dos puntos__.
  - Al menos (1 folio índice, al menos 3 desarrollo de la práctica).
  - Carecer faltas de ortografía.
  - Capturas de pantalla con los resultados obtenidos.
</div>
