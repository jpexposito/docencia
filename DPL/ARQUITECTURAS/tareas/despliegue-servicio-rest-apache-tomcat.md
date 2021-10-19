<div align="justify">

# Servicios RESTful con Tomcat y Jersey

<div align="center">
  <img src="https://www.astera.com/wp-content/uploads/2020/01/rest.png"  />
</div>

## Introducción

  Si queremos utilizar JAX-RS para crear nuestros servicios RESTful de una forma sencilla podremos apoyarnos en la implementación que ha hecho Jersey del estándar JAX-RS (JSR 311 y JSR 339). Si bien necesitaremos un servidor para desplegarlos y en este caso vamos a utilizar __Tomcat 10__.

  Así que veamos que pasos tenemos que dar para poder crear servicios RESTful con Tomcat y Jersey. En todo el proceso de creación de nuestra aplicación Java con servicios RESTful nos vamos a apoyar en Maven como gestor de dependencias.

  Una API REST aprovecha los métodos HTTP descritos por Protocolo __RFC 2616__. Utiliza las siguientes solicitudes:
  - __GET__ para buscar datos.
  - __PUT__, para alterar el estado de los datos (como un objeto, archivo o bloque).
  - __POST__ para crear datos.
  - __DELETE__ métodos para eliminarlo
  Se pueden ver diferentes códigos de estado HTTP utilizados por las API REST [aquí](https://restfulapi.net/http-status-codes/).

## Ejemplos

### Facebook, Google o Microsoft

<div align="center">
  <img src="https://docs.microsoft.com/es-es/azure/active-directory-b2c/media/add-identity-provider/external-idp.png"  />
</div>

## Creando nuestro servicio restfulapi


### Requisitos previos

  Dado que disponemos de la instalación de [JAVA](../../../comun/JDK.md), vamos a realizar la instalación de [MAVEN](../../../comun/MAVEN.md).

### Construcción del proyecto

  En el siguiente [enlace](https://github.com/jpexposito/docencia/tree/master/comun/ejemplos/java/rest-service) dispones de un proyecto de una app en [Java](../../../comun/ejemplos/java).

## Despliegue del servicio

  La presente tarea tiene como objetivo el despliegue del servicio en el servidor __Tomcat__ tal y como se realizo en la tarea [anterior](despliegue-jsp-apache-tomcat.md).

### Consumo del servicio

  El despliegue del servicio se puede verificar a traves de la url __htpp:....../rest/users__ y se ataca con un cliente __rest__, por ejemplo [Advanced Rest Client](https://install.advancedrestclient.com/install).

### Problemas durante el despliegue

  Si se producen problemas en el despliegue del servicio, puedes verificar el problema en los ficheros que se encuentran alojado en la carpeta __logs__ de __Tomcat__. Los ficheros ha los que hemos de prestar atención son:
  - __catalina_fecha__.
  - __localhost_fecha__. En este fichero se mostraran los problemas de acceso, dependencias de librerías etc, como lo siguiente:

  ```console
  SEVERE [http-nio-8082-exec-6] org.apache.catalina.core.StandardContext.loadOnStartup Servlet [Jersey Web Application] in web application [/rest-service] threw load() exception
        java.lang.ClassNotFoundException: com.sun.jersey.spi.container.servlet.ServletContainer

  ```

  Para solventar ese tipo de problemas hemos de incluir las librerías en el war o dentro de la carpeta __lib__ de __Tomcat__, tal y como se describía en el siguiente [enlace](../TECNOLOGIAS.md), o dentro de la carpeta __target/rest-service/WEB-INF/lib__ del proyecto.

### Mejoras en el servicio

  _En la nota, se tendrá en cuenta la implementación de la siguiente mejora en el servicio. Se debe de realizar un nuevo método, que permita realizar la búsqueda por el campo dni, el cual hay que añadir en la clase_ __User__. _Además se debe de implementar el método_ __getUserByDni__.

## Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la instalación y se muestre la servicio __Users__ en __Apache-Tomcat__.

  Además el informe debe de contener:
   - Titulo de la tarea.
   - Nombre y Apellidos.
   - Indice
   - Pasos descritos.
   - Capturas de pantalla.

## Referencias

  Referencias para la resolución de la tarea:
  - [Migración de Tomcat 10 a 9](https://tomcat.apache.org/migration-10.html)
  - [Dependencias de librerías en Tomcat 10](https://qastack.mx/programming/9373081/how-to-set-up-jax-rs-application-using-annotations-only-no-web-xml)
  - [Using Jersey 3x + Jetty to develop endpoints](https://mkyong.com/java/java-lang-noclassdeffounderror-jakarta-servlet-servletinputstream/)

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN</summary>

  Los problemas que se detectan en el despliegue son varios. El primero de ellos relacionado con la librería __com.sun.jersey.spi.container.servlet.ServletContainer__. Como resultaría normal, el alumno buscará las librerías que se encuentran en el fichero __pom.xml__, para desplegarlas en la carpeta __lib__ de Tomcat 10__. Esta acción no será necesaria, dado que el proyecto al estar creado con ___Maven___ generará la capeta ___WEB_INF/lib___ por defecto incluyendo las librerías.
  Otra opción que ha podido atacar, es el cambio de librerías, añadiendo por ejemplo, las siguientes:
  ```xml

<dependency>
  <groupId>com.sun.jersey</groupId>
  <artifactId>jersey-server</artifactId>
  <version>1.17.1</version>
</dependency>
<dependency>
  <groupId>com.sun.jersey</groupId>
  <artifactId>jersey-core</artifactId>
  <version>1.17.1</version>
</dependency>
<dependency>
  <groupId>com.sun.jersey</groupId>
  <artifactId>jersey-servlet</artifactId>
  <version>1.17.1</version>
</dependency>

  ```

  Problemas que el alumno debe afrontar:
    - Solventar los problemas de librerías. En este caso __Maven__ hará el trabajo por nosotros.
    - Compilar el servicio con __JAVA 15__ o superior. Esto esta motivado a que el paquete para el despliegue del servicio cambia de __Tomcat 9 a 10__, y el paquete para la construcción de servicios cambia, pasado de __javax__ a __jakarta__. Este cambio queda reflejado en el fichero __pom.xml__.

```xml
    <!--
    <dependency>
      <groupId>javax.ws.rs</groupId>
      <artifactId>javax.ws.rs-api</artifactId>
      <version>2.1.1</version>
    </dependency>
    -->

    <dependency>
      <groupId>jakarta.servlet</groupId>
      <artifactId>jakarta.servlet-api</artifactId>
      <version>5.0.0</version>
    </dependency>
```

  Además de los cambios especificados, con la nueva versión existe la posibilidad de eliminar el fichero de configuración ___WEB_INF/web.xml___, e indicarlo en el plugin de Maven, que construye el war:

```xml

      <plugin>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.3.1</version>
        <configuration>
          <failOnMissingWebXml>false</failOnMissingWebXml>
        </configuration>
      </plugin>

```

  Por último sólo es necesario crear el fichero __ApplicationConfig__, que debe contener el __Path__ para el despliegue del servicio __rest__. Si prestamos atención a este fichero, veremos, que cumple la función del fichero __web.xml_

```java
@ApplicationPath("rest")
public class ApplicationConfig extends Application {
}
```

  Lo importe es que el alumno haya comprobado lo complejo que puede llegar a ser el despliegue de una solución en __Tomcat__, dado que no se tiene el control de las librerías implicadas, suponiendo un desafío para el responsable del _servidor de aplicaciones_.   
</details>


</div>
