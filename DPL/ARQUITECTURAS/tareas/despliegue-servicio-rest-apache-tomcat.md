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
  Para solventar ese tipo de problemas hemos de incluir las librerías en el war o dentro de la carpeta __shared__ de __Tomcat__, tal y como se describía en el siguiente [enlace](../TECNOLOGIAS.md).

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



</div>
