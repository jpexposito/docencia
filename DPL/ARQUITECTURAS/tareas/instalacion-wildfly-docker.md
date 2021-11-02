<div align="justify">

# Tarea: Instalación de Wildfly en Docker


<div align="center">
  <img src="../../../img/docker-wildfly.png"  />
</div>

## Paso 1: Descarga de la imagen del docker Wildfly

  Este paso es opcional ya que al construir nuestra imagen basada en el fichero __Dockerfile__ se descargará la imagen base si no la tenemos en nuestro repositorio. Vamos a descargar en concreto la versión __25.0.0.Final__ de la imagen oficial. Para ello, vamos a utilizar el tag correspondiente:

```console
  sudo docker pull jboss/wildfly:25.0.0.Final
```

  Obtendremos el siguiente resultado:

  ```console
  25.0.0.Final: Pulling from jboss/wildfly
  f87ff222252e: Pull complete
  13776e8da872: Pull complete
  0b43aea4eeb1: Pull complete
  8116b2f7ca5a: Pull complete
  f26d32e28c29: Pull complete
  Digest: sha256:35320abafdec6d360559b411aff466514d5741c3c527221445f48246350fdfe5
  Status: Downloaded newer image for jboss/wildfly:25.0.0.Final
  docker.io/jboss/wildfly:25.0.0.Final
  ```

  Ahora toca ver el listado de imagenes descargada

  ```console
  sudo docker images
  ```
  obtenniendo

  ```console
  REPOSITORY      TAG            IMAGE ID       CREATED       SIZE
  jboss/wildfly   25.0.0.Final   856694040847   3 weeks ago   736MB
  hello-world     latest         feb5d9fea6a5   5 weeks ago   13.3kB
  ```
  Ahora toca el turno de arrancar un contenedor con esta imagen y comprobar que tenemos disponible el servidor de aplicaciones:
  ```console
  sudo docker run -d -p 5000:8080 --name "servidor-desa" jboss/wildfly
  ```
  y obtendremos:

  ```console
  Unable to find image 'jboss/wildfly:latest' locally
  latest: Pulling from jboss/wildfly
  Digest: sha256:35320abafdec6d360559b411aff466514d5741c3c527221445f48246350fdfe5
  Status: Downloaded newer image for jboss/wildfly:latest
  c1bdc66aa180bda8936fb538b95faf8d18f3aec2aa97ca5da0bcd5e5f87412b6
  ```

  Donde (ver diagrama abajo):
  - __-d__ (daemon) → arranca el servidor en background
  - __-p 5000:8080__ → publica el puerto 8080 de Wildfly al  puerto 5000 del host (en nuestro caso el host es nuestro equipo)
  - __--name “servidor-desa”__ → define un alias para el contenedor
  - __c1bd…__ → es el código del contenedor (el hostname dentro de Docker)

  <div align="center">
    <img src="https://miro.medium.com/max/1400/1*jzaKCM8zvNGckaCBXf8QRQ.png"  />
  </div>

  Realizando el siguiente comando:

  ```console
    ip a
  ```

  dentro de nuestra máquina y obtendremos una salida similar a esta:

  ```console
3: docker0: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP group default
    link/ether 02:42:1e:e0:9b:4a brd ff:ff:ff:ff:ff:ff
    inet 172.17.0.1/16 brd 172.17.255.255 scope global docker0
       valid_lft forever preferred_lft forever
    inet6 fe80::42:1eff:fee0:9b4a/64 scope link
       valid_lft forever preferred_lft forever
  ```

  De este modo, si accedemos a la url: __172.17.0.1:5000__ veremos la instalación de __wildfly__.

  ## Realiza el Informe

    Realiza un informe indicando los pasos que has seguido para la instalación y se muestre la instalación de __wildfly__ en __Docker__.

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
