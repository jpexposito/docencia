<div align="justify">

<div align="center">
<img src="https://www.ciset.es/images/Glosario/mysql.png" width="250px"/>
</div>

# Creación de un contenedor Docker con MySQL Server

## Requisitos

Para poder ejecutar contenedores Docker es necesario tener instalado Docker Community Edition (CE) en nuestro equipo.

En la web oficial encontrará la información necesaria para realizar la instalación de Docker CE sobre Windows, macOS, Ubuntu, Debian, Fedora y CentOS.

## Cómo crear un contenedor sin persistencia de datos

Un contenedor Docker que no tiene persistencia de datos quiere decir que cuando finalice la ejecución perderá todo el contenido que hayamos creado durante la ejecución. Es decir, si durante la ejecución del contenedor hemos creado varias bases de datos en MySQL Server, éstas se perderán cuando el contenedor se detenga.

El comando que podríamos usar para lanzar nuestro contenedor Docker con MySQL Server sin persistencia de datos podría ser el siguiente:

```
docker run -d --rm --name mysql -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 mysql:8.0
```

__docker run__ es el comando que nos permite crear un contenedor a partir de una imagen Docker.

El __parámetro -d__ nos permite ejecutar el contenedor en modo detached, es decir, ejecutándose en segundo plano.

El __parámetro --rm__ hace que cuando salgamos del contenedor, éste se elimine y no ocupe espacio en nuestro disco.

El __parámetro --name__ nos permite asignarle un nombre a nuestro contenedor. Si no le asignamos un nombre Docker nos asignará un nombre automáticamente.

El __parámetro e__ es para pasarle al contenedor una variable de entorno. En este caso le estamos pasando la variable de entorno __MYSQL_ROOT_PASSWORD__ con el valor de la contraseña que tendrá el usuario root para MySQL Server.

El __parámetro -p__ nos permite mapear los puertos entre nuestra máquina local y el contenedor. En este caso, estamos mapeando el puerto 3306 de nuestra máquina local con el __puerto 3306__ del contenedor.

__mysql:8.0__ es el nombre de la imagen y la versión que vamos a utilizar para crear el contenedor. Si no se indica lo contrario buscará las imágenes en el repositorio oficial Docker Hub.

## Cómo cambiar el plugin de autenticación en las versiones de MySQL Server superiores a la 8.0

A partir de la versión 8.0 de MySQL Server, el plugin de autenticación que se utiliza por defecto es __caching_sha2_password__, mientras que en las versiones inferiores o iguales a la 5.7 se utiliza __mysql_native_password__.

El plugin de autenticación caching_sha2_password no está soportado por las versiones de PHP anteriores a la 7.4, por lo tanto, si queremos conectar con MySQL Server 8.0 desde una apliación web que utilice una versión de PHP inferior a la 7.4, tendremos que utilizar el plugin de autenticación mysql_native_password.

El comando que podríamos usar para lanzar nuestro contenedor Docker con MySQL Server 8.0 sin persistencia de datos y con el plugin de autenticación mysql_native_password podría ser el siguiente:

```
docker run -d --rm --name mysql -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 mysql:8 --default-authentication-plugin=mysql_native_password
```

Observe que en este caso la imagen que hemos escogido ha sido mysql:8 y después del nombre de la imagen hemos utilizado el comando:

```
--default-authentication-plugin=mysql_native_password
```
para indicar cuál será el método de autenticación que queremos utilizar.

## Cómo crear un contenedor con persistencia de datos

Si queremos que los datos del contenedor sean persistentes tenemos que crear un volumen donde vamos a indicar el directorio de nuestra máquina local vamos a almacenar el directorio /var/lib/mysql, que es el directorio que utiliza MySQL Server para almacenar las bases de datos.

Para crear un volumen utilizamos el parámetro -v.

Docker nos ofrece dos posibilidades para implementar persistencia de datos en los contenedores:

- __bind mount__: pueden estar almacenados en cualquier directorio del sistema de archivos de la máquina host. Estos archivos pueden ser consultados o modificados por otros procesos de la máquina host o incluso por otros contenedores Docker.

- __volume__: se almacenan en la máquina host dentro del área del sistema de archivos que gestiona Docker. Otros procesos de la máquina host no deberían modificar estos archivos, sólo deberían ser modificados por contenedores Docker.


En la documentación oficial podemos encontrar más información sobre el uso de volumenes en Docker.

Ejemplo de uso del parámetro -v para crear un volumen de tipo bind_mount:

```
-v /home/jpexposito/data:/var/lib/mysql
```

En este caso el directorio /home/jpexposito/data de nuestra máquina local estará sincronizado con el directorio /var/lib/mysql del contenedor con MySQL Server.

Podemos hacer uso de la variable de entorno $PWD para indicar que queremos crear el volumen en nuestro directorio actual.

Ejemplo de uso del parámetro -v para crear un volumen de tipo bind_mount con la variable de entorno $PWD:

-v "$PWD":/var/lib/mysql
Ejemplo de uso del parámetro -v con un volumen de tipo volume:

```
-v mysql_data:/var/lib/mysql
```

El comando que podríamos usar para lanzar nuestro contenedor Docker con MySQL Server con persistencia de datos en un volumen podría ser el siguiente:

```
docker run -d --rm --name mysql -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -v mysql_data:/var/lib/mysql mysql:8.0
```

docker run es el comando que nos permite crear un contenedor a partir de una imagen Docker.

El parámetro -d nos permite ejecutar el contenedor en modo detached, es decir, ejecutándose en segundo plano.

El parámetro --rm hace que cuando salgamos del contenedor, éste se elimine y no ocupe espacio en nuestro disco.

El parámetro --name nos permite asignarle un nombre a nuestro contenedor. Si no le asignamos un nombre Docker nos asignará un nombre automáticamente.

El parámetro e es para pasarle al contenedor una variable de entorno. En este caso le estamos pasando la variable de entorno MYSQL_ROOT_PASSWORD con el valor de la contraseña que tendrá el usuario root para MySQL Server.

El parámetro -p nos permite mapear los puertos entre nuestra máquina local y el contenedor. En este caso, estamos mapeando el puerto 3306 de nuestra máquina local con el puerto 3306 del contenedor.

El parámetro -v nos permite crear un volumen para tener persistencia de datos al finalizar el contenedor.

mysql:8.0 es el nombre de la imagen y la versión que vamos a utilizar para crear el contenedor. Si no se indica lo contrario buscará las imágenes en el repositorio oficial Docker Hub.

## Cómo comprobar que el contenedor está en ejecución

Una vez que hemos iniciado el contenedor podemos comprobar que se está ejecutando con el siguiente comando:

```
docker ps
```

Deberíamos obtener una salida similar a esta.

```
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
3082ce645213        mysql:5.7.22        "docker-entrypoint.s…"   4 seconds ago       Up 2 seconds        0.0.0.0:3306->3306/tcp   mysql
```

## Cómo conectar con MySQL Server

Una vez que MySQL Server está en ejecución podemos conectarnos con cualquier cliente: MySQL Workbench, PHPMyAdmin, Adminer, etc.

Los datos de conexión serán:

```
Host: 127.0.0.1
Puerto: 3306
Usuario: root
Password: root
```

## Cómo detener el contenedor

Para detener el contenedor en primer lugar tenemos que conocer cuál es su ID. Para obtenerlo podemos hacer uso del comando docker ps.

```
docker ps
```
```
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
3082ce645213        mysql:8.0           "docker-entrypoint.s…"   4 seconds ago       Up 2 seconds        0.0.0.0:3306->3306/tcp   mysql
```

En la primera columna podemos ver cuál es el CONTAINER ID. Una vez localizado el identificador ejecutamos el comando docker stop y le pasamos como parámetro el identificador del contenedor que queremos detener.

Para el caso anterior deberíamos ejecutar:

```
docker stop 3082ce645213
```

## Ejemplo de docker-compose.yml con MySQL Server

Docker Compose es una utilidad que nos permite gestionar varios contenedores Docker de una forma sencilla. Para ello, utiliza un archivo __YAML__ donde se definen y configuran los servicios, los volúmenes y las redes que queremos crear.

Vamos a crear un archivo __docker-compose.yml__ para definir un servicio llamado mysql a partir de la imagen de MySQL Server 8.0.

```yaml
version: '3'

services:
  mysql:
    image: mysql:8.0
    ports:
      - 3306:3306
    environment:
      - MYSQL_ROOT_PASSWORD=root
      - MYSQL_DATABASE=database
      - MYSQL_USER=user
      - MYSQL_PASSWORD=password
    volumes:
      - mysql_data:/var/lib/mysql

volumes:
  mysql_data:
```

Para iniciar los servicios en segundo plano con la utilidad __docker-compose__ tenemos que ejecutar el siguiente comando.

```
docker-compose up -d
```

Para detener los servicios y mantener el volumen que hemos creado podemos ejecutar:

```
docker-compose down
```

Si además de detener los servicios queremos eliminar el volumen que hemos creado tenemos que añadir el parámetro -v.

```
docker-compose down -v
```

Para comprobar el estado de los servicios podemos ejecutar:

```
docker-compose ps
```

## Referencias

[Instalar y acceder a mysql en docker](https://www.datacamp.com/es/tutorial/set-up-and-configure-mysql-in-docker)

</div>