<div align="justify">

# MODIFICANDO Y CLUSTERIZANDO UN SERVICIO REST EN WILDFLY

## Introducción

  Una vez realizas tareas anteriores, y comenzado a construir entornos de desarrollo ágiles para nuestras app´s, en __APACHE+PHP+BBDD__, vamos a construir y desplegar una app, que requiere __wildfly__, bajo una api rest, y en el futuro una BBDD.

  Además vamos a prevenir el correcto funcionamiento de nuestra app, en tiempos de respuesta y robustez, y vamos a desplegar nuestra solución en __3__ nodos de __wildfly__.

  <div align="center">
    <img src="https://docs.jboss.org/jbportal/v2.6.7/referenceGuide/html/images/clustering/overview.png
  " >
  </div>

## Requerimientos

- Vamos a hacer uso de la imagen de docker de __WILDFLY__, que vimos en [instalación de wildfly en docker](instalacion-wildfly-docker.md).

- Realizaremos un cluster de 3 nodos en __WILDFLY__, de forma similar a [cluster wildfly](cluster-wildfly.md).

- Instalación de BBDD y phpmyadmin, de forma similar a [instalando lamp en docker](instalando-lamp-docker.md).

- Además haremos uso de [Docker compose](../DOCKER-COMPOSE.md), para especificar las necesidades de nuestro entorno.

## Aplicación a Desplegar

  Vamos a utilizar una aplicación que se encuentra disponible dentro de los ejemplos de __wildfly__. En concreto esta aplicación será [helloworld-rs](https://github.com/wildfly/quickstart/tree/main/helloworld-rs).

### Opcional

  En primer lugar puedes incluir el __plugin de jetty__, incluido en el proyecto __hola mundo__ que hemos utilizado en tareas anteriores.

  Para verificar que todo funciona correctamente en un entorno local.

  ```
  mvn clean jetty:run
  ```
  viendo la salida en el navegador en la url:
  - http://localhost:8082/{artifactId}/.
  - Salida xml en http://localhost:8082/{artifactId}/rest/xml
  - Salida JSON en: http://localhost:8082/{artifactId}/rest/json

### Recuerda

  Debes de construir:
  - Fichero _Dockerfile_.
  - Fichero _docker-compose.yml_

## Se pide

  - Desplegar el servicio rest en __3 nodos__.
  - Despliegar una __BBDD MYSQL__.
  - Desplegar __phpmyadmin y conectar a la BBDD__.
  - Opcional:
    - Añadir un nuevo método al servicio rest, devolviendo un objeto. Por ejemplo el objeto libro que se describe en el [enlace](https://jpexposito.com/building-micro-services-ii/), pero que el alumno puede adaptar a sus necesidades.
    - Realizar la conexión del servicio a la BBDD. Para ello debes de incluir elementos en la BBDD, y que el servicio se conecte a ella y pueda extraer esa información.

      ___Recuerda que estas partes son opcionales, y el alumno que las realice, será para mejorar sus necesidades o conocimientos de cara al futuro___.


## Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la instalación y se muestre la instalación de _Docker Cluster Wildfly REST service_.

  Además el informe debe de contener:
   - Titulo de la tarea.
   - Nombre y Apellidos.
   - Indice
   - Pasos descritos.
   - Capturas de pantalla.

### A tener en cuenta:

  - Se pasará el programa antí copia para verificar autenticidad.
  - __5 faltas de ortografía se baja dos puntos__.
  - Al menos (1 folio indice, al menos 3 desarrollo de la práctica).
  - Carecer faltas de ortografía.
  - Capturas de pantalla con los resultados obtenidos.

## Referencias

- [Cluster en JBOSS](https://docs.jboss.org/jbportal/v2.6.7/referenceGuide/html/clustering.html).
- [Instalación de Jboss en cluster y __modo domain__](https://myworkdayblog.wordpress.com/2014/03/25/jboss-instalacion-en-modo-domain/).
</div>
