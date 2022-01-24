<div align="justify">

# Creación de los Pipeline en Php

<div align="center">
  <img src="https://www.jenkins.io/doc/book/resources/pipeline/realworld-pipeline-flow.png" width="500px" />
</div>

## Requisitos

- Tener instalado Jenkins.

## Instroducción

  El presente ejercicio tiene como objetivo familiarizarse con la construcción de __Pipeline__ en __Jenkins__ y el despliegue en __apache y php__.

## Desarrollo

  Se debe de realizar la construcción de un __Pipeline__ (_hello-word-php-apache_). Vamos a realizar el despliegue de un pequeño ejemplo en php.

  El código para la creación de un _Pipeline hello-word_ en los distintos lenguajes, se encuentra en el siguiente [enlace](../PIPELINE-JENKINS.md).

  Esta tarea de clase consisten en realizar el siguiente ejemplo.

  1. Crear un repositorio en tu cuenta de __github__, de nombre __php-helloworld__.
  2. Clona el clona el proyecto en local.
  3. Crea la carpeta __src__. Añade un fichero __index.php__, , que contenga contenido en el lenguaje __php__ y una imagen personalizada y tu nombre.
  4. Vuelve a la _raiz del proyecto_.
  5. Crea el fichero __Dockerfile__. Incluye el siguiente contenido:

  ```
  FROM php:IMAGEN OFICIAL DE PHP
  COPY src/ /var/www/html
  EXPOSE 80
  ```


  Realiza la busqueda de la última imagen de php en [docker](https://hub.docker.com/_/php/), e incluye su referencia.

  6. Realiza un __push__ con todos los cambios.
  7. Crea el __Pipeline__ dentro de tu instalación de __Jenkins.alumno__, sincronizando desde tu cuenta de __github__ _(www.github.com/alumno/hello-word-php-apache.git)_ o _similar_.
  8. Ejecuta el __Pipeline__, y verificar que se ha realizado de forma correcta visualizando el navegador.

## Evaluación. Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la instalación, y configuración  ___hello-word-php-apache___.

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
  - [Pipeline Php Apache](https://github.com/mfieldhouse/docker-php-helloworld).




</div>
