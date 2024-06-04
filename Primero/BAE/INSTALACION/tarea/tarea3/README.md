<div align="justify">

<div align="center">
<img src="https://www.ovhcloud.com/sites/default/files/styles/large_screens_1x/public/2021-09/ECX-1909_Hero_PostgreSQL_600x400%402x.webp" width="500px"/>
</div>

# Creación de un contenedor Docker con PostgreSQL

## Requisitos

Para poder ejecutar contenedores Docker es necesario tener instalado Docker Community Edition (CE) en nuestro equipo.

En la web oficial encontrará la información necesaria para realizar la instalación de Docker CE sobre Windows, macOS, Ubuntu, Debian, Fedora y CentOS.

## Cómo crear un contenedor sin persistencia de datos

Un contenedor Docker que no tiene persistencia de datos quiere decir que cuando finalice la ejecución perderá todo el contenido que hayamos creado durante la ejecución. Es decir, si durante la ejecución del contenedor hemos creado varias bases de datos en PostgreSQL, éstas se perderán cuando el contenedor se detenga.

El comando que podríamos usar para lanzar nuestro contenedor Docker con PostgreSQL sin persistencia de datos podría ser el siguiente:

```
docker run -d --rm --name postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 postgres
```
    
- __docker run__ es el comando que nos permite crear un contenedor a partir de una imagen Docker.
- __El parámetro -d__ nos permite ejecutar el contenedor en modo detached, es decir, ejecutándose en segundo plano.
- __El parámetro --rm__ hace que cuando salgamos del contenedor, éste se elimine y no ocupe espacio en nuestro disco.
- __El parámetro --name__ nos permite asignarle un nombre a nuestro contenedor. Si no le asignamos un nombre Docker nos asignará un nombre automáticamente.
- __El parámetro -e__ es para pasarle al contenedor variables de entorno. En este caso le estamos pasando la variable de entorno POSTGRES_PASSWORD, que contiene el valor de la contraseña del usuario postgres.
- __El parámetro -p__ nos permite mapear los puertos entre nuestra máquina local y el contenedor. En este caso, estamos mapeando el puerto __5432__ de nuestra máquina local con el puerto 5432 del contenedor.
- __postgres__ es el nombre de la imagen. Como no hemos indicado la versión que vamos a utilizar para crear el contenedor, utilizará la última versión que esté disponible. Si no se indica lo contrario buscará las imágenes en el repositorio oficial Docker Hub.

## Cómo conectarnos con el contenedor que está ejecutando PostgreSQL usando psql

Una vez que hemos creado la instancia del contenedor que está ejecutando PostgrSQL, podemos conectarnos a él para utilizar la herramienta psql.

```
docker run -it --rm --link postgres:postgres postgres psql -h postgres -U postgres
```

## Cómo conectarnos con el contenedor que está ejecutando PostgreSQL usando adminer

Podemos crear un contenedor con Adminer para utilizar una interfaz web que nos permite conectar con PostgreSQL.

Para crear un contenedor con Adminer podemos ejecutar el siguiente comando:

```
docker run -d --rm  --link postgres:db -p 8080:8080 adminer
```

Una vez hecho esto, podríamos acceder a través de la URL http://127.0.0.1:8080 desde cualquier navegador web.

## Cómo comprobar que los contenedores están en ejecución

Una vez que hemos iniciado los contenedores podemos comprobar que se están ejecutando con el siguiente comando:

```
docker ps
```

Deberíamos obtener una salida similar a esta.

```
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
a1e321c26d33        adminer             "entrypoint.sh docke…"   2 seconds ago       Up 1 second         0.0.0.0:8080->8080/tcp   admiring_poitras
4485390ebc31        postgres            "docker-entrypoint.s…"   59 seconds ago      Up 58 seconds       0.0.0.0:5432->5432/tcp   postgres
```

## Cómo detener los contenedores

Para detener un contenedor en primer lugar tenemos que conocer cuál es su ID. Para obtenerlo podemos hacer uso del comando docker ps.

```
docker ps

CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
a1e321c26d33        adminer             "entrypoint.sh docke…"   2 seconds ago       Up 1 second         0.0.0.0:8080->8080/tcp   admiring_poitras
4485390ebc31        postgres            "docker-entrypoint.s…"   59 seconds ago      Up 58 seconds       0.0.0.0:5432->5432/tcp   postgres
```

En la primera columna podemos ver cuál es el CONTAINER ID. Una vez localizado el identificador ejecutamos el comando docker stop y le pasamos como parámetro el identificador del contenedor que queremos detener.

Para el caso anterior deberíamos ejecutar:

```
docker stop a1e321c26d33
docker stop 4485390ebc31
```

</div>