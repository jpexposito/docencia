<div align="justify">

# DOCKER COMPOSE

<div align="center">
  <img src="https://jhymer.dev/content/images/size/w2000/2020/05/docker-compose-1.png"  />
</div>

## Introducción

_Docker Compose es una herramienta desarrollada para ayudar a definir y compartir aplicaciones de varios contenedores. Con Compose, puede crear un archivo YAML para definir los servicios y, con un solo comando, ponerlo todo en marcha o eliminarlo_.

___La gran ventaja de usar Compose es que puede definir la pila de la aplicación en un archivo, mantenerlo en la raíz del repositorio del proyecto (ahora tendrá control de versiones) y permitir que un tercero contribuya al proyecto. Un usuario solo tendría que clonar el repositorio e iniciar la aplicación Compose___. De hecho, es posible que veas bastantes proyectos en ___GitHub/GitLab___ en los que se hace exactamente esto.

## Instalación de Docker Compose

  Si ha instalado Docker Desktop para Windows o Mac, ya tiene Docker Compose. Las instancias de Play-with-Docker ya tienen Docker Compose instalado. Si está en un equipo __Linux__, tendrá que instalar Docker Compose mediante estas [instrucciones](https://docs.docker.com/compose/install/#install-compose-on-linux-systems).

  Después de la instalación, debería poder ejecutar lo siguiente y ver la información de la versión.

  ```console
    docker-compose version
  ```

## ¿Cuál es la diferencia entre Docker y Docker Compose?

  En principio, se sabe que docker utiliza un fichero para automatizar la creación de imágenes que se lee desde un archivo Dockerfile. Siendo este un documento de texto que contiene todos los comandos que un usuario puede llamar desde línea de comandos para ensamblar una imagen.

  Docker Compose es una herramienta que permite definir y ejecutar aplicaciones Docker compuesto por varios contenedores, simplificando el uso de Docker y entender de una manera sencilla.

  Docker Compose permite un tipo de sintaxis más elaborado y fácil de entender, por tal razón le ha ganado la batalla en la composición de scripts para contenerización. El fichero de instrucciones que utiliza Docker Compose es docker-compose.yml haciendo diferencia con el fichero .Dockerfile .

## Creación del archivo de Compose

  En la raíz del proyecto de la aplicación, cree un archivo denominado __docker-compose.yml__.

  En el archivo de Compose, primero se define la __versión__ del esquema. En la mayoría de los casos, es mejor usar la última versión admitida. En la Referencia de archivos de Compose puede consultar las versiones de esquema actuales y la matriz de compatibilidad.

```yaml
  version: "3.7"
```

  A continuación, defina la lista de servicios (o contenedores) que quiera ejecutar como parte de la aplicación.

  ```yaml
    version: "3.7"

    services:
  ```
  Y ahora, comenzará a migrar un servicio cada vez al archivo de Compose.

## Definición de App Service

  Recuerde que este es el comando que ha usado para definir el contenedor de la aplicación.

  ```console
  docker run -dp 3000:3000 \
    -w /app -v ${PWD}:/app \
    --network todo-app \
    -e MYSQL_HOST=mysql \
    -e MYSQL_USER=root \
    -e MYSQL_PASSWORD=secret \
    -e MYSQL_DB=todos \
    node:12-alpine \
    sh -c "yarn install && yarn run dev"
  ```

  _En primer lugar, defina la entrada del servicio y la imagen del contenedor. Puede elegir cualquier nombre para el servicio._

  El nombre se convertirá automáticamente en un alias de red, que será útil al definir el servicio MySQL.

  ```yaml
  version: "3.7"

  services:
    app:
      image: node:12-alpine

  ```
  Normalmente, verá el comando cerca de la definición de image, aunque no hay ningún requisito en la ordenación. Por tanto, continúe y muévalo al archivo.

  ```yaml
  version: "3.7"

  services:
    app:
      image: node:12-alpine
      command: sh -c "yarn install && yarn run dev"
  ```

  Para migrar el elemento __-p 3000:3000__ del comando, define el valor ports para el servicio. Aquí usará la sintaxis abreviada, pero también hay disponible una sintaxis larga más detallada.

  ```yaml
  version: "3.7"

  services:
    app:
      image: node:12-alpine
      command: sh -c "yarn install && yarn run dev"
      ports:
        - 3000:3000
  ```

  Después, migre el directorio de trabajo __(-w /app)__ y la asignación de volúmenes __(-v ${PWD}:/app)__ mediante las definiciones de working_dir y volumes. Los volúmenes también tienen una sintaxis abreviada y una larga.

  Una ventaja de las definiciones de volúmenes de Docker Compose es que se pueden usar rutas de acceso relativas al directorio actual.

  ```yaml
  version: "3.7"

  services:
    app:
      image: node:12-alpine
      command: sh -c "yarn install && yarn run dev"
      ports:
        - 3000:3000
      working_dir: /app
      volumes:
        - ./:/app
  ```

  Por último, migre las definiciones de variables de entorno con la clave environment.

  ```yaml
  version: "3.7"

  services:
    app:
      image: node:12-alpine
      command: sh -c "yarn install && yarn run dev"
      ports:
        - 3000:3000
      working_dir: /app
      volumes:
        - ./:/app
      environment:
        MYSQL_HOST: mysql
        MYSQL_USER: root
        MYSQL_PASSWORD: secret
        MYSQL_DB: todos

  ```

### Definición del servicio MySQL

  Ahora, es el momento de definir el servicio MySQL. El comando que ha usado para ese contenedor era el siguiente:

  ```console
  docker run -d \
    --network todo-app --network-alias mysql \
    -v todo-mysql-data:/var/lib/mysql \
    -e MYSQL_ROOT_PASSWORD=secret \
    -e MYSQL_DATABASE=todos \
    mysql:5.7
  ```

  En primer lugar, defina el nuevo servicio y asígnele el nombre mysql para que obtenga automáticamente el alias de red. Especifique también la imagen que se debe usar.

  ```yaml
  version: "3.7"

  services:
    app:
      # The app service definition
    mysql:
      image: mysql:5.7

  ```

  A continuación, define la asignación de volúmenes. Cuando ha ejecutado el contenedor con docker run, se ha creado automáticamente el volumen con nombre. Pero esto no sucede cuando se ejecuta con Compose. Tendrá que definir el volumen en la sección volumes: de nivel superior y, después, especificar el punto de montaje en la configuración del servicio. Para que se usen las opciones predeterminadas, solo tiene que proporcionar el nombre del volumen. Pero hay muchas más opciones disponibles.

  ```yaml
  version: "3.7"

  services:
    app:
      # The app service definition
    mysql:
      image: mysql:5.7
      volumes:
        - todo-mysql-data:/var/lib/mysql

  volumes:
    todo-mysql-data:
  ```

  Por último, solo tiene que especificar las variables de entorno.

  ```yaml
  version: "3.7"

  services:
    app:
      # The app service definition
    mysql:
      image: mysql:5.7
      volumes:
        - todo-mysql-data:/var/lib/mysql
      environment:
        MYSQL_ROOT_PASSWORD: secret
        MYSQL_DATABASE: todos

  volumes:
    todo-mysql-data:
  ```
  En este momento, el archivo ___docker-compose.yml___ completo debe tener este aspecto:

  ```yaml
  version: "3.7"

  services:
    app:
      image: node:12-alpine
      command: sh -c "yarn install && yarn run dev"
      ports:
        - 3000:3000
      working_dir: /app
      volumes:
        - ./:/app
      environment:
        MYSQL_HOST: mysql
        MYSQL_USER: root
        MYSQL_PASSWORD: secret
        MYSQL_DB: todos

    mysql:
      image: mysql:5.7
      volumes:
        - todo-mysql-data:/var/lib/mysql
      environment:
        MYSQL_ROOT_PASSWORD: secret
        MYSQL_DATABASE: todos

  volumes:
    todo-mysql-data:
  ```

  Ejecución de la pila de la aplicación.
  Ahora que tiene el archivo docker-compose.yml, puede iniciarlo.

  En primer lugar, asegúrese de que no haya otras copias de la aplicación y la base de datos en ejecución (docker ps y docker rm -f <ids>).

  Use el comando docker-compose up para iniciar la pila de la aplicación. Agregue la marca -d para ejecutar todo en segundo plano. Como alternativa, puede hacer clic con el botón derecho en el archivo de Compose y seleccionar la opción Compose Up (Activar) para la barra lateral de VS Code.

  ```console
    docker-compose up -d
  ```

  Cuando lo ejecute, la salida debería ser parecida a la siguiente:

  ```console
  Creating network "app_default" with the default driver
  Creating volume "app_todo-mysql-data" with default driver
  Creating app_app_1   ... done
  Creating app_mysql_1 ... done
  ```

  Observará que el volumen se ha creado, y también una red. De forma predeterminada, Docker Compose crea automáticamente una red específica para la pila de la aplicación (motivo por el que no ha definido una en el archivo de Compose).

  Examine los registros con el comando docker-compose logs -f. Verá los registros de cada uno de los servicios intercalados en una única secuencia. Esto es increíblemente útil cuando quiere comprobar si hay problemas relacionados con el control de tiempo. La marca -f "sigue" el registro, por lo que le proporcionará una salida en directo a medida que se genera.

  Verá una salida similar a la siguiente:

  ```console
  mysql_1  | 2021-10-03T03:07:16.083639Z 0 [Note] mysqld: ready for connections.
  mysql_1  | Version: '5.7.27'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server (GPL)
  app_1    | Connected to mysql db at host mysql
  app_1    | Listening on port 3000
  ```

  El nombre del servicio se muestra al principio de la línea (a menudo en color) para ayudar a distinguir los mensajes. Si quiere ver los registros de un servicio específico, puede agregar el nombre del servicio al final del comando logs (por ejemplo, docker-compose logs -f app).

## Referencias
- [Docker Compose Reference](https://docs.docker.com/compose/reference/).
- [Utilizando docker compose](https://dockertips.com/utilizando-docker-compose).
- [Microsoft Docker Compose](https://docs.microsoft.com/es-es/visualstudio/docker/tutorials/use-docker-compose).

</div>
