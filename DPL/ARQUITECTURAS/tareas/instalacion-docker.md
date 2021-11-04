<div align="justify">

# Tarea: Instalación de Docker en linux

## Paso 1: Instalar Docker

  Es posible que la versión del paquete de instalación de Docker disponible en el repositorio oficial de Ubuntu no sea la más reciente. Para asegurarnos de contar con la versión más reciente, instalaremos Docker desde el repositorio oficial de Docker. Para hacerlo, agregaremos una nueva fuente de paquetes y la clave GPG de Docker para garantizar que las descargas sean válidas, y luego instalaremos el paquete.

  Primero, actualice su lista de paquetes existente:

  ```console
  sudo apt update
  ```

  A continuación, instale algunos paquetes de requisitos previos que permitan a apt usar paquetes a través de HTTPS:

  ```console
  sudo apt install apt-transport-https ca-certificates curl software-properties-common
  ```

  Luego, añade la clave de GPG para el repositorio oficial de Docker en su sistema:

  ```console
  curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
  ```

  Agrega el repositorio de Docker a las fuentes de APT:

  ```console
  sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"
  ```

  A continuación, actualice el paquete de base de datos con los paquetes de Docker del repositorio recién agregado:

  ```console
  sudo apt update
  ```

  Asegúrate de estar a punto de realizar la instalación desde el repositorio de Docker en lugar del repositorio predeterminado de Ubuntu:

  ```console
  apt-cache policy docker-ce
  ```

  Si bien el número de versión de Docker puede ser distinto, verá un resultado como el siguiente:

```
  Installed: (none)
  Candidate: 5:19.03.9~3-0~ubuntu-focal
  Version table:
     5:19.03.9~3-0~ubuntu-focal 500
        500 https://download.docker.com/linux/ubuntu focal/stable amd64 Packages
```

  Observa que docker-ce no está instalado, pero la opción más viable para la instalación es del repositorio de Docker para Ubuntu 20.04 (focal).

  Por último, instale Docker:

  ```console
  sudo apt install docker-ce
  ```

  Con esto, Docker quedará instalado, el demonio se iniciará y el proceso se habilitará para ejecutarse en el inicio. Compruebe que funcione:

  ```console
  sudo systemctl status docker
  ```

  El resultado debe ser similar al siguiente, y mostrar que el servicio está activo y en ejecución:

  ```
  docker.service - Docker Application Container Engine
       Loaded: loaded (/lib/systemd/system/docker.service; enabled; vendor preset>
       Active: active (running) since Fri 2021-10-29 19:21:13 WEST; 28min ago
  TriggeredBy: ● docker.socket
         Docs: https://docs.docker.com
     Main PID: 3169 (dockerd)
        Tasks: 10
       Memory: 38.3M
       CGroup: /system.slice/docker.service
               └─3169 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/cont>
```

  La instalación de Docker ahora le proporcionará no solo el servicio de Docker (demonio) sino también la utilidad de línea de comandos docker o el cliente de Docker. Más adelante, exploraremos la forma de usar el comando docker en este tutorial.

## Paso 2: Trabajar con imágenes de Docker

  Los contenedores de Docker se construyen con imágenes de Docker. Por defecto, Docker obtiene estas imágenes de Docker Hub, un registro de Docker gestionado por Docker, la empresa responsable del proyecto Docker. Cualquiera puede alojar sus imágenes en Docker Hub, de modo que la mayoría de las aplicaciones y las distribuciones de Linux que necesitará tendrán imágenes alojadas allí.

  Para verificar si puede acceder a imágenes y descargarlas de Docker Hub, escriba lo siguiente:

```console
  sudo docker run hello-world
```

  El resultado indicará que Docker funciona de forma correcta:

```console
Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

```

## Paso 3: Administrar contenedores de Docker

  Después de usar Docker durante un tiempo, tendrá muchos contenedores activos (en ejecución) e inactivos en su computadora. Para ver los activos, utilice lo siguiente:

```console
  sudo docker ps
```

  Verá una salida similar a la siguiente:

```console
CONTAINER ID        IMAGE               COMMAND             CREATED   
```

  A través de este tutorial, inició dos contenedores: uno de la imagen hello-world y otro de la imagen ubuntu. Ambos contenedores ya no están en ejecución, pero aún existen en su sistema.

  Para ver todos los contenedores, activos e inactivos, ejecute docker ps con el conmutador -a:

```console
  docker ps -a
```

  Verás un resultado similar a esto:

  ```console
  sudo   docker ps -a
  CONTAINER ID   IMAGE         COMMAND    CREATED          STATUS                      PORTS     NAMES
  b2c5683bc38f   hello-world   "/hello"   14 minutes ago   Exited (0) 14 minutes ago             kind_curran
  ```

  Para ver el último contenedor que creó, páselo al conmutador -l:
```console
  sudo docker ps -l
```

  ```console
  CONTAINER ID   IMAGE         COMMAND    CREATED          STATUS                      PORTS     NAMES
  b2c5683bc38f   hello-world   "/hello"   24 minutes ago   Exited (0) 23 minutes ago             kind_curran
  ```

  Listar las imágenes de Docker de nuevo mostrará la nueva imagen, así como la anterior de la que se derivó:

  ```console
  sudo docker images
  ```

  con salida:

  ```console
  REPOSITORY    TAG       IMAGE ID       CREATED       SIZE
hello-world   latest    feb5d9fea6a5   5 weeks ago   13.3kB
  ```
<!--
### Paso 4: Introducir imágenes de Docker en un repositorio de Docker

  El siguiente paso lógico después de crear una nueva imagen a partir de una imagen existente es compartirla con algunos de sus __compañeros de trabajo__ ó __amigos__, con todo el mundo en Docker Hub, o en otro registro de Docker al que tenga acceso. Para introducir una imagen a [Docker Hub](https://hub.docker.com/) o a cualquier otro registro de Docker, deberá tener una cuenta en el sistema.

  En este paso verás cómo introducir una imagen de Docker en Docker Hub. Para aprender a crear su propio registro privado de Docker.

  Para introducir su imagen, primero inicie sesión en Docker Hub.

  ```
    sudo docker login -u docker-registry-username
  ```

  Se le solicitará autenticarse usando su contraseña de Docker Hub. Si especificó la contraseña correcta, la autenticación tendrá éxito.
-->
