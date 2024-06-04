<div align="justify">

<div align="center">
<img src="https://maximorlov.com/images/mysql-phpmyadmin-docker.png?w=1000"/>
</div>

# Creación de un contenedor Docker con phpMyAdmin

## Requisitos

Para poder ejecutar contenedores Docker es necesario tener instalado Docker Community Edition (CE) en nuestro equipo.

En la web oficial encontrará la información necesaria para realizar la instalación de Docker CE sobre Windows, macOS, Ubuntu, Debian, Fedora y CentOS.

## Cómo enlazar phpMyAdmin con un contenedor Docker con MySQL o MariaDB

Para este ejemplo usaremos la imagen oficial de [phpmyadmin](https://hub.docker.com/r/phpmyadmin/phpmyadmin/).

Para conectar dos contenedores podemos hacerlo de dos formas:

- Utilizando legacy container links con el flag --link, en la bridge network.
- Utilizando una user-defined bridge network.

### Solución 1. Legacy container links con el flag --link, en la bridge network

Los enlaces permiten que los contenedores se descubran entre sí y transfieran de manera segura información sobre un contenedor a otro contenedor. Para crear un enlace se utiliza el flag –link.

>__Nota__: En primer lugar debe existir un contenedor con MySQL Server.

Lanza el comando:

```
sudo docker ps -a
```

En función de la salida obtenida dedes de:
- Conocer el __puerto__ de conexión y __credenciales__ para poder conectar a la BBDD. No obstante y parea evitar problemas para el contenedor. y eliminalo.

    ```
    docker stop ...
    docker rm ...
    ````
- Lanzar un contener docker de __MySQL__:
    ````
    docker run -d \
    --rm \
    --name mysqlc \
    -p 3306:3306 \
    -e MYSQL_ROOT_PASSWORD=root \
    -v mysql_data:/var/lib/mysql \
    mysql:8.0
    ```
Una vez que la instancia de MySQL está en ejecución podemos crear el contenedor con phpMyAdmin.

```
docker run -d \
--rm \
--name phpmyadminc \
--link mysqlc \
-e PMA_HOST=mysqlc \
-p 8080:80 \
phpmyadmin
````

La variable de entorno __PMA_HOST__ nos permite indicar el nombre del contenedor con el que quiero conectarme desde __phpMyAdmin__.

En lugar de la variable de entorno PMA_HOST podía haber utilizado la variable PMA_ARBITRARY=1.

La única diferencia es que con __PMA_ARBITRARY=1__ nos aparece un campo de texto en la página de login de __phpMyAdmin__ _donde tenemos que indicar el nombre del contenedor al que queremos conectarme_ y con __PMA_HOST__ no hay que escribir nada porque se configura automáticamente.

Con el flag __--link mysqlc__ hemos creado un enlace entre los contenedores __mysql__ y __phpmyadminc__.

En el archivo __/etc/hosts__ del contenedor __phpmyadminc__ _se ha añadido una nueva línea que permite resolver la dirección_ __IP del contenedor de MySQL__ a partir de su nombre __(mysqlc) o su ID__.

>__Nota__:Por ejemplo si el ID del contenedor de MySQL (mysqlc) fuese 8411f6064e44 el archivo /etc/hosts tendría un contenido similar a este:

```
127.0.0.1 localhost
::1 localhost ip6-localhost ip6-loopback
fe00::0 ip6-localnet
ff00::0 ip6-mcastprefix
ff02::1 ip6-allnodes
ff02::2 ip6-allrouters
172.17.0.3  mysqlc 8411f6064e44
172.17.0.4  c25ca9a48fb3
```

Podemos comprobar que el contendedor phpmyadminc puede conectar con el contenedor mysqlc abriendo un navegador web y accediendo a la URL: http://localhost:8080.

### Solución 2. Utilizando una user-defined bridge network

En primer lugar creamos una __user-defined bridge network__.

```
docker network create my-net
```

Creamos un contenedor con MySQL indicando que queremos que esté en la red __--network my-net__.

````
docker run -d \
--rm \
--name mysqlc \
--network my-net \
-p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=root \
-v mysql_data:/var/lib/mysql \
mysql:8.0
````

Creamos un contenedor con phpMyAdmin indicando que queremos que esté en la red __--network my-net__.

```
docker run -d \
--rm \
--name phpmyadminc \
--network my-net \
-e PMA_HOST=mysqlc \
-p 8080:80 \
phpmyadmin
````

Comprobamos que el contendedor phpmyadminc puede conectar con el contenedor mysql abriendo un navegador web y accediendo a la URL: [http://localhost:8080](http://localhost:8080).


## Ejemplo de uso con MariaDB y phpMyAdmin

Creamos un contenedor con MariaDB con persistencia de datos.

```
docker run -d \
--rm \
--name mariadbc \
-p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=root \
-v mariadb_data:/var/lib/mysql \
mariadb:10
```

Creamos un contenedor con phpMyAdmin que esté __enlazado__ con el contenedor anterior.

```
docker run -d \
--rm \
--name phpmyadminc \
--link mariadbc \
-e PMA_HOST=mariadbc \
-p 8080:80 \
phpmyadmin
```

## ¿Cómo comprobar que los contenedores están en ejecución?

Una vez que hemos iniciado los contenedores podemos comprobar que se están ejecutando con el siguiente comando:

```
sudo docker ps
````

Deberíamos obtener una salida similar a esta.

```
CONTAINER ID        IMAGE                   COMMAND                  CREATED             STATUS              PORTS                            NAMES
19a928aac23c        phpmyadmin/phpmyadmin   "/run.sh supervisord…"   3 seconds ago       Up 3 seconds        9000/tcp, 0.0.0.0:8080->80/tcp   phpmyadminc
acd81669c572        mariadb                 "docker-entrypoint.s…"   19 seconds ago      Up 18 seconds       0.0.0.0:3306->3306/tcp           mariadbc
```

## ¿Cómo detener los contenedores?

Para detener un contenedor en primer lugar tenemos que conocer cuál es su ID. Para obtenerlo podemos hacer uso del comando docker ps.

```
docker ps
```

obteniendo:

```
CONTAINER ID        IMAGE                   COMMAND                  CREATED             STATUS              PORTS                            NAMES
19a928aac23c        phpmyadmin/phpmyadmin   "/run.sh supervisord…"   3 seconds ago       Up 3 seconds        9000/tcp, 0.0.0.0:8080->80/tcp   phpmyadminc
acd81669c572        mariadb                 "docker-entrypoint.s…"   19 seconds ago      Up 18 seconds  
```

En la primera columna podemos ver cuál es el CONTAINER ID. Una vez localizado el identificador ejecutamos el comando docker stop y le pasamos como parámetro el identificador del contenedor que queremos detener.

Para el caso anterior deberíamos ejecutar:

```
docker stop 19a928aac23c
docker stop acd81669c572
```


</div>