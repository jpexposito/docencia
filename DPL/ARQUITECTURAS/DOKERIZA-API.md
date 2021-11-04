<div align="justify">

# Dokeriza tu api

<div align="center">
    <img src="https://d33wubrfki0l68.cloudfront.net/93ee40c27f242103d8c3b215ed1346436f5cdcdf/c1152/img/2017/12/docker_compose.jpg">
</div>


## Introducción

  Gracias a Docker podemos construir entornos sencillos, de manera muy fácil y que se pueden ejecutar en cualquier máquina sin importar el sistema operativo que tenga.


## ¿Recuerda qué es docker?

  Por si no conoces docker te dejo por aquí la definición de wikipedia.

  ___Docker es un proyecto de código abierto que automatiza el despliegue de aplicaciones dentro de contenedores de software, proporcionando una capa adicional de abstracción y automatización de virtualización de aplicaciones en múltiples sistemas operativos.___


## Uso y creación de imagenes en Docker

### Uso de imágenes

  En primer lugar, debes de recordar el uso e instalación de __wildfly__ en [docker](tareas/instalacion-wildfly-docker.md), que hemos realizado.

  En ella realizaban dos pasos para el despliegue de __wildfly__.
  - Primero:
  ```console
    sudo docker pull jboss/wildfly:25.0.0.Final
  ```
  - Segundo:
  ```console
  sudo docker images
  ```
  obtenniendo

  ```console
  REPOSITORY      TAG            IMAGE ID       CREATED       SIZE
  jboss/wildfly   25.0.0.Final   856694040847   3 weeks ago   736MB
  hello-world     latest         feb5d9fea6a5   5 weeks ago   13.3kB
  ```

  Como podemos observar tenemos descargadas ___dos imágenes___ listas para ejecutar.

### Creación de imágenes

  Para poder crear una ___contenedor___ con ___nuestro sistema o aplicación___, la primera tarea que debemos hacer es crear una ___imagen de esta___.

  Gracias a un fichero llamado __“Dockerfile”__ podremos crear nuestra imagen. En este fichero definiremos las configuraciones necesarias para la correcta creación de nuestra imagen.

#### Definición del fichero DockerFile de aplicación  

__Dockerfile__
  ```
  FROM XXXXXX
  WORKDIR XXXXXX
  COPY XXXXXX
  RUN XXXXXX
  COPY XXXXXX
  RUN XXXXXX
  CMD XXXXXX
  ```

  Explicación de cada propiedad:

  - __FROM__: en este caso al ser una aplicación realizada con NestJS es necesario utilizar node. En esta ocasión utilizaremos la versión 10 de node.
  - __WORKDIR__: es el directorio interno del contenedor en el cual se copiará el proyecto
  - __COPY__: copia el package.json de nuestro proyecto para después realizar la instalación.
  - __RUN__: Realizamos la instalación de los paquetes
  - __COPY__: Copiamos todo el sistema de archivos
  - __RUN__: Construimos nuestra aplicación
  - __CMD__: Escribimos el comando con el que se ejecutará la aplicación dentro del contenedor.

#### Construcción de la imagen

  El fichero Dockerfile debe estar en la raíz de nuestro proyecto

  En el terminal situándonos en la raíz del proyecto, ejecutamos en siguiente comando para crear la imagen de nuestra aplicación.

  ```console
  sudo docker build -t [nombre_de_imagen]
  ```

  Una vez termine el proceso podremos comprobar que nuestra imagen se ha creado ejecutando el siguiente comando:

  ```console
  sudo docker image ls
  ```

#### Creación de contenedor

  Para crear el contenedor lo haremos con la ayuda de __docker-compose__.

  ```
  version: '3.3'
  services:
   nest-api:
     image: nest-api #nombre de la imagen que hemos creado
     restart: always
     container_name: nest-api
     ports:
       - '3000:3000'
  ```

  Y ejecutamos:

  ```console
  docker-compose up -d
  ```
  Tendremos nuestro contenedor creado.

</div>
