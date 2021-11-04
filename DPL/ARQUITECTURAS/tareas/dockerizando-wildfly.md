<div align="justify">

# Dokeriza tu Wildfly

<div align="center">
    <img src="https://d33wubrfki0l68.cloudfront.net/93ee40c27f242103d8c3b215ed1346436f5cdcdf/c1152/img/2017/12/docker_compose.jpg">
</div>


## Introducción

  Como hemos [visto](../DOKERIZA-API.md), podemos construir nuestro entorno ___customizado___ gracias a __Docker__.

  El primer ejemplo de personalización de una imagen es a través de la imagen previa que hemos descargado de __wildfly__, añadiendo una pequeña personalización a este entorno.

## Creación del fichero dockerfile para Wildfly

  - Creamos el directorio de trabajo:
  ```console
    mkdir wildfly-config
    cd wildfly-config
  ```
  - Creamos el fichero de configuración:
  ```
    nano Dockerfile
  ```
  - Añadimos la configuración de nuestra imagen:
  ```console
  # Base image
FROM jboss/wildfly:25.0.0.Final

  # Maintainer
  MAINTAINER "jpexposito" "mail@example.com"

  # Create user admin with password admin
  RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

  # Add custom configuration file
  # ADD standalone.xml /opt/jboss/wildfly/standalone/configuration/

  # Add example.war to deployments
  # ADD example.war /opt/jboss/wildfly/standalone/deployments/

  # JBoss ports
  EXPOSE 8080 9990 8009

  # Run
  CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-c", "standalone.xml"]
  ```
  - Construcción de la imagen:
  ```console
  sudo docker build -q --rm --tag=jboss/wildfly:25.0.0.Final-config .
  ```
  __Nota__:_Ojo con el último punto que eso obligatorio_.
  Obtendremos una salida similar a:
  ```
  sha256:56d2170193f556698a65abda6722ba29e877ee52b5df6b35ff3f1048d74ee381
  ```
  Verificando que existe la imagen dentro de docker:
  ```
  sudo docker images
  ```
  con la salida:
  ```
  REPOSITORY      TAG                    IMAGE ID       CREATED        SIZE
jboss/wildfly   25.0.0.Final-config    56d2170193f5   12 hours ago   736MB
  ```
  __Felicidades has construido tu primera imagen en docker__.


## Uso de la nueva imagen

  Vamos a probar la imagen recién creada. Para ello ejecutamos el comando:
  ```
  sudo docker run -d -p 8080:8080 -p 9990:9990 -p 8009:8009 --name servidor-wilfly-config -it jboss/wildfly:25.0.0.Final-config
  ```
  Teniendo en cuenta el parámetro __--name servidor-wilfly-config__ que indica el nombre del servidor que hemos creado y arrancado, y que debe de ser significativo. Obtenemos, algo similar a:
  ```
  f02cdd6962b18134ba34e6ba03331a65526c30fdcf3d961ac8d4817b7f0007e5
  ```

  Una vez realizada esta acción debes:
  - Ejecutar la sentencia:
  ```console
    sudo docker ps -a
  ```
  verificando que el contenedor esta arrancado.
  - Acceder a la consola de __wildfly__, y verificar que se puede entrar en la consola de administración con el usuario _admin_.


## Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la dockerización de __Wildfly__.

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

</div>
