<div align="justify">

# CLUSTERIZANDO UNA APP EN WILDFLY

## Introducción

  La instalación convencional de __Jboss__ requiere la instalación del nodo __master__, y la configuración de los nodos hijos o esclavos.


<div align="center">
  <img src="https://docs.jboss.org/jbportal/v2.6.7/referenceGuide/html/images/clustering/overview.png
" >
</div>

  En cada instalación se debe evaluar la cantidad de instancias en modo Host que se desean utilizar y la cantidad de instancias en modo __Slave__ que se levantaran en cada uno de los Hosts, por lo general esta información se obtiene a partir de las estimaciones de usuarios y llamadas concurrentes que se deberán soportar.

  Comúnmente se configura un Host por servidor (físico o virtual) pero podría levantarse más de un Host en cada servidor, si el mismo cuenta con varias IPs.

  Los pasos siguientes detallan la configuración a realizar para una infraestructura con dos Host (cada uno en un servidor distinto) con tres instancias/servers por HOST, todo agrupado en dos grupos.

  Cada grupo será administrado de forma independiente, permitiendo desplegar las aplicaciones automáticamente en todos los servidores del grupo, así como configurar propiedades de cada uno de ellos en un único archivo.

## Desplegando un Cluster de JBOSS con Docker

  Existe una buena alternativa para el despliegue en cluster, y es el uso de __docker__.

  Vamos a hacer uso de la imagen de docker de __WILDFLY__, que vimos [](instalacion-wildfly-docker.md).

  Además haremos uso de [Docker compose](../DOCKER-COMPOSE.md), contruyendo un cluster a medida, para las necesidades de nuestra aplicación.


### Construcción del proyecto

  En el siguiente [enlace](https://github.com/jpexposito/docencia/tree/master/COMUN/ejemplos/java/app-web-demo) dispones de un proyecto de una app en [Java](../../../COMUN/ejemplos/java), donde debes de realizar los siguientes cambios:
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
  Dentro de la carpeta __target__ debes de encontrar un fichero de nombre __app-web-alumno.war__, donde se especifica dentro del fichero __pom.xml__ en la etiqueta __finalName__. Este nombre se especifica dentro del fichero _pom.xml_, por si tienes curiosidad y deseas cambiarlo.

- Una vez construido el proyecto, puedes ver el resultado en ejecutando en modo local:

  ```
  mvn clean jetty:run
  ```

  viendo la salida en el navegador en la url:

  ```
  Hola Mundo!
  Este es el puerto: 8082
  ```

- Contruyendo el fichero __Dockerfile__. Tal y como vimos en la [documentación](../DOCKERIZA-API.md), hemos de construir el fichero __Dockerfile__, dentro de la carpeta de nuestra aplicación. Dicho fichero, contendrá:

    ```console
    FROM jboss/wildfly

    ARG WAR_FILE=target/*.war
    ##COPY ${JAR_FILE} app.jar

    ADD ${ARG} /opt/jboss/wildfly/standalone/deployments/

    ARG WILDFLY_NAME
    ARG CLUSTER_PW

    ENV WILDFLY_NAME=${WILDFLY_NAME}
    ENV CLUSTER_PW=${CLUSTER_PW}

    ENTRYPOINT /opt/jboss/wildfly/bin/standalone.sh -b=0.0.0.0 -bmanagement=0.0.0.0 -Djboss.server.default.config=standalone-full-ha.xml -Djboss.node.name=${WILDFLY_NAME} -Djava.net.preferIPv4Stack=true -Djgroups.bind_addr=$(hostname -i) -Djboss.messaging.cluster.password=${CLUSTER_PW}
    ```    
    Como podemos observar, se esta realizando el copiado del fichero __.war__ dentro de la carpeta __deployments__, para posteriormente crear su arranque en cluster.

    Para continuar vamos a realizar el fichero __.yml__ (_docker-compose.yml_) para la construcción del cluster.
    ```YAML
    version: '3.5'
    services:

      wildfly1:
        build:
          context: .
          args:
            WILDFLY_NAME: wildfly_1
            CLUSTER_PW: secret_password
        image: wildfly_1
        ports:
        - 8080:8080
        networks:
          wildfly_network:

      wildfly2:
        build:
          context: .
          args:
            WILDFLY_NAME: wildfly_2
            CLUSTER_PW: secret_password
        image: wildfly_2
        ports:
        - 8081:8080
        networks:
          wildfly_network:

    networks:
      wildfly_network:
        ipam:
          driver: default
    ```
    Observamos que existe:
    - Dos servidores __WILDFLY__ (1/2).
    - Distintos puertos para el arraque de cada uno.
    - __CLUSTER_PW__: clave para la construcción del __cluster__.
    - __networks__: _wildfly_network_. Subred que estamos construyendo. [Más info](https://docs.docker.com/compose/compose-file/compose-file-v2/#networks).
    - __ipam__: Configuración de la subred.[Más info](https://docs.docker.com/compose/compose-file/compose-file-v2/#enable_ipv6).

    Para la creación del cluster de __dos nodos__ vamos a ejecutar la sentencia:
    ```console
      docker-compose up
    ```
    Tras unos segundos tendremos:
    - Desplegada la aplicación.
    - Accesible a través de los puertos __8081__.

## Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la instalación y se muestre la instalación de _Docker Cluster Wildfly_.

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
