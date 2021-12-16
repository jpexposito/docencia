<div align="justify">

# INSTALACIÓN Y ADMINISTRACIÓN DE SERVIDORES DE TRANSFERENCIA DE ARCHIVOS

<div align="center">
  <img src="https://ugeek.github.io/blog/images-blog/sftp.png" width="200px" >
</div>


## Introducción

  Como se describe en [los conceptos iniciales](../README.md), __SFTP__ es la abreviatura de Secure File Transfer Protocol (Protocolo de transferencia segura de archivos). Este protocolo permite transferir datos cifrados entre tu ordenador local y el espacio web del que dispones en tu hosting de STRATO a través de Secure Shell (SSH).

  Una forma de realizar instalaciones de forma sencilla y automatizada, es a través de [docker](https://www.docker.com/).

  <div align="center">
    <img src="https://www.docker.com/sites/default/files/d8/styles/large/public/2021-08/Moby-run.png?itok=oGhAc1XC" width="400px" >
  </div>

## Pasos

  Vamos a realizar la instalación de __SFTP__ siguiendo los siguientes pasos, y aprendiendo algunos comandos nuevos en docker.

  En primer lugar vamos a realizar la búsqueda de imágenes creadas, y contrastadas en [https://hub.docker.com](https://hub.docker.com/search?q=sftp&type=image).

  Como podemos ver existen ya diferentes imágenes creadas para la isntalación de __SFTP__.

  Además de ello podemos realizar la búsqueda a través del siguiente comando:

  ```console
    docker search sftp
  ```
  con la siguiente salida:

  ```console
NAME                      DESCRIPTION                                     STARS     OFFICIAL   AUTOMATED
atmoz/sftp                Easy to use SFTP server                         402                  [OK]
drakkan/sftpgo            Official build of SFTPGo. SFTP/FTP/WebDAV se…   20                   
writl/sftp                SFTP-Server with changeable uid and gid         14                   [OK]
emberstack/sftp           SFTP (SSH File Transfer Protocol) server usi…   12                   
turgon37/sftp-ldap        Docker image running a SFTP server with a LD…   5                    [OK]
netresearch/sftp          Easy to use SFTP (SSH File Transfer Protocol…   3                    [OK]
markusmcnugen/sftp        Fork of atmoz SFTP docker container built wi…   3                    [OK]
amimof/sftp               A fast and secure SFTP server that runs in a…   3                    [OK]
asavartzeth/sftp          A dockerized sftp server, using the openssh …   2                    [OK]
hectormolinero/sftp       A Docker image with an OpenSSH server config…   2                    
chessracer/sftp-s3fs      SFTP with built-in s3fs - Aws s3 mounted to …   2                    [OK]
corilus/sftp              Securely share your files, with full rsyslog…   1                    
yakworks/sftp             sftp with fail2ban and kubernetes support       1                    
noc0lour/sftp             simple sftp/scp/rsync container with rssh       0                    [OK]
proatria/sftpplus-trial   Trial version for SFTPPlus.                     0                    
ahatting/sftp             Source project: hub.docker.com/r/atmoz/sftp/    0                    
famartinez76/sftp2525     Modified version of the atmoz/sftp image but…   0                    
ez123/sftp                sftp                                            0                    [OK]
famartinez76/sftp2222     Modified version of the atmoz/sftp image but…   0                    
cvitkoilm/sftp            Fork of atmoz/sftp that will work on Azure w…   0                    [OK]
rabii17/sftp                                                              0                    
rsmdockers/sftp                                                           0                    
mauwii/sftp                                                               0                    
dazoe/sftp                simple sftp docker                              0                    
triskellesolutions/sftp                                                   0           
  ```

## Trabajar con la imagen atmoz  

  Vamos a utiliza la imagen desarrollada por __atmoz__, sobre __sftp__.

  Para ello vamos a realizar los siguientes pasos:

  ```console
  docker run --name mysftp -p 2294:22 -d atmoz/sftp admin:admin:::upload
  ```
  donde cada uno de los parámetros representa:
  - __name__, nombre del contenedor mysftp
  - admin: admin ::: upload donde foo es el nombre de usuario, pass es la contraseña, upload es el archivo cargado se guardará en el directorio / home / foo / upload en el contenedor.
  -p 22:22 asigna el puerto 22 del host al puerto 22 del contenedor, de modo que el puerto 22 del host de ubicación se reenviará al puerto 22 del contenedor.
  -d atmoz / sftp usa la imagen atmoz / sftp en el centro de acoplamiento para crear un contenedor.

## Verificar la imagen

  Para verificar la descarga imagen anterior, lanzamos el siguiente comando:

  ```console
    docker ps | grep sftp
  ```

  obteniendo un resultado similar al siguiente:
  ```console
    ffa078007f2e   atmoz/sftp   "/entrypoint admin:a…"   4 minutes ago   Up 4 minutes   0.0.0.0:2294->22/tcp   mysftp
  ```
  Podemos realizar la prueba de acceso al servidor __FTP__. Para ello podemos lanzar los siguientes comandos:

  ```console
  docker ps

  CONTAINER ID   IMAGE        COMMAND                  CREATED          STATUS          PORTS                  NAMES
  ffa078007f2e   atmoz/sftp   "/entrypoint admin:a…"   13 minutes ago   Up 13 minutes   0.0.0.0:2294->22/tcp   mysftp

  docker inspect ffa078007f2e | grep "IPAddress"
              "SecondaryIPAddresses": null,
              "IPAddress": "172.17.0.2",
                      "IPAddress": "172.17.0.2",

  ```

### Configurar el directorio home en la máquina host.

  Para realizar la confifuración del directorio de home de __SFTP__ hemos de ejecutar el siguiente comando:

  ```console
    docker run --name mysftp2 -v /host/upload:/home/admin/upload --privileged=true -p 2295:22 -d atmoz/sftp admin:admin:1001
  ```

  donde:
  - __v / host / upload: / home / admin / upload__. Donde el frente de los dos puntos es el directorio del host, la parte posterior se monta en el directorio en el contenedor, si el directorio local / host / uplaod no existe, se creará automáticamente.
  - __--privileged = true__. Debido a las reglas de seguridad de selinux de linux, es necesario agregar privilegios al contenedor.
  - __--name mysftp2__. El nombre también se cambia. Debido a que el nombre no se puede repetir, el puerto también se repite, el contenedor no se iniciará.


### SFTP Multiusuario

  Si deseamos configurar varios usuarios para sftp, hay dos formas:
  - Creemos usuarios en el contenedor y asignamos permisos.
  - Escribimos archivos de usuario en el host y los montamos en el contenedor.

__El primer método se puede utilizar directamente en el ejemplo anterior__.

  El segundo método es que implementaremos a continuación.

  Para ello debemos de escribir el siguiente comando:

  ```console
  docker run --name mysftp3 -v /host/users.conf:/etc/sftp/users.conf:ro -v /home/sftp:/home --privileged=true -p 2296:22 -d atmoz/sftp
  ```
  siguiendo la explicación de los casos anteriores tenemos:
  - __-v /host/users.conf:/etc/sftp/users.conf:ro__ mapea el __/host/users.conf__ local al __/etc/sftp/users.conf__ del contenedor, y es de solo lectura en el contenedor.
  - __-v / home / sftp: / home asigna el directorio local / home / sftp__ al contenedor __/ home__ para almacenar los archivos cargados.

  No olvides crear el archivo __/host/users.conf__ en el directorio local.

```console
  nano /host/users.conf

  xiaoming:123:1001:100
  goudan:abc:1002:100
  erzhu:xyz:1003:100

```

  Donde usuario: contraseña: uid: gid Nombre de usuario: Contraseña: Id. De usuario: Id. De grupo.

## Realización del informe

  Realiza un informe indicando los pasos que has seguido para la instalación del servicio __FTP__ y donde se muestre cada uno de los pasos detallados, pasos y problemas encontrados.

  Además el informe debe de contener:
   - Titulo de la tarea.
   - Nombre y Apellidos.
   - Indice.
   - Pasos descritos.
   - Carecer faltas de ortografía.
   - Capturas de pantalla con los resultados. obtenidos.
   - Incluye el enlace de tu cuenta _GitHub_ en el detalle de la tarea.



## Referencias

- [¿Qué es sftp?](https://www.strato.es/faq/hosting/que-es-sftp-y-como-se-utiliza/).

</div>
