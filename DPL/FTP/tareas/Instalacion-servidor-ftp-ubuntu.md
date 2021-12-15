<div align="justify">

# INSTALACIÓN Y ADMINISTRACIÓN DE SERVIDORES DE TRANSFERENCIA DE ARCHIVOS

<div align="center">
  <img src="https://www.solvetic.com/uploads/tutorials/monthly_02_2017/92cb9d0f7130667c0cb2bcb20219fdee.png" >
</div>

## Introducción

  Con la popularización de los servidores NAS en entornos domésticos, y por supuesto, en entornos de pequeñas y medianas empresas, uno de los protocolos más utilizados para la transferencia de archivos y carpetas es el __FTP__.

  Para ello vamos a realizar la instalación de un servidor __FTP__ en nuestro servidor local.

## Pre-Requisitos
- Disponer de una máquina Ubuntu 20.04.
- Internet.


## ¿Cómo instalar FTP?

  Vamos a instalar el servidor __FTP vsFTPd__ en Ubuntu 20.04  desde los repositorios de la distribución, así que la primera acción será actualizar la información de los repositorios:

  ```console
    sudo apt update
  ```

### Instalando el paquete vsftpd

  ```console
    sudo apt install -y vsftpd
  ```

  obteniendo un mensaje similar

  ```console
  Reading package lists... Done
  Building dependency tree       
  Reading state information... Done
  The following additional packages will be installed:
    cron libcap2 libpopt0 libwrap0 logrotate netbase ssl-cert
  Suggested packages:
    anacron checksecurity default-mta | mail-transport-agent bsd-mailx | mailx
    openssl-blacklist
  The following NEW packages will be installed:
  ...
  ```

  Tras la descarga e instalación del servidor FTP vsFTPd se crea un nuevo servicio en Ubuntu 20.04, el servicio _vsftpd.service o vsftpd_, que queda en ejecución y habilitado para iniciar automáticamente con cada arranque del sistema.

  Podemos comprobar el estado del servidor FTP en cualquier momento con el comando __systemctl status vsftpd__.

  Si el firewall UFW está activado en Ubuntu debemos de permitir el acceso a los puertos estándar del servicio FTP, como son el puerto de comandos:

  ```console
    sudo ufw allow ftp
  ```

  Y el puerto de datos, para el modo activo:

  ```console
    sudo ufw allow ftp-data
  ```

### Verificar el servicio FTP en Ubuntu

  Podemos hacer una prueba rápida del funcionamiento del servicio conectando desde otra máquina con un cliente como puede ser un navegador, usando el protocolo __ftp://__ e indicando la dirección IP.

  Por ejemplo, el servidor __Ubuntu__ que usamos es accesible a través de la url 192.168.0.1, así que podemos utilizar __ftp://192.168.0.1__.

  Si todo va bien se mostrará un __diálogo de identificación__, ya que por defecto vsFTPd sólo permite el acceso a usuarios locales. Puedes realizar una prueba de autenticación a través del usuario local, utilizando el __usuario root__ que hayas definido.

### Configurar el servidor FTP

  Para configurar el servidor FTP vsFTPd en trabajaremos sobre su archivo de configuración principal, __vsftpd.conf__, que se encuentra en la ruta __/etc/__.

  Veamos algunos de los ejemplos de configuración del servidor FTP vsFTPd más habituales.

### Instalación de un cliente o utilización de un cliente

<div align="center">
  <img src="https://www.redeszone.net/app/uploads-redeszone.net/2018/10/FileZilla-Logo-930x452.jpg" width="200px" >
</div>

  Para la realización del acceso y su configuración debemos de disponer o instalar un __cliente ftp__.

  Para ello si siempre que no se disponga de uno debemos de instalar por ejemplo __filezilla__, a través del siguiente [enlace](https://filezilla-project.org/download.php?platform=win64).

___SI ES NECESARIO REALIZA LA INSTALACIÓN___


#### Modo Pasivo

  La configuración por defecto del servidor __FTP vsFTPd en Ubuntu__ utiliza el modo activo, lo que sólo permitirá conexiones de clientes que no se encuentren tras un firewall y que no intenten cambiar automáticamente al modo pasivo.

  Por ejemplo, intenta crear una conexión al servidor ftp que tienes instalado desde un cliente (__Filezilla__), o en la propia máquina y ___comprueba el resultado a través de la terminal___.

<details>
  <summary>MOTIVO</summary>

  La máquina cliente impide la apertura de puertos de conexión para datos que solicita el servidor FTP.

  Incluso si accedemos desde una máquina Windows sin firewall, aunque con el cliente de consola podríamos acceder sin problemas, al tratar de acceder desde navegadores como Google Chrome la operación debería fallar.

</details>

  Por lo tanto __configurar el modo pasivo__ del __servidor FTP en Ubuntu__ será útil para muchos escenarios. Para ello editaremos __vsftpd.conf__:

  ```console
    sudo nano /etc/vsftpd.conf
  ```

  Añadiremos las siguientes directivas al final del archivo de configuración:

  ```console
  ...
  pasv_enable=YES
  pasv_min_port=30000
  pasv_max_port=30050

  ```

___Obviamente puedes elegir el rango de puertos que te interese___.

  Terminada la configuración, guardamos los cambios y recargamos la configuración del servicio:

  ```console
    sudo systemctl reload vsftpd
  ```

  Si el __servidor Ubuntu__ tiene activado el __firewall UFW__, habrá que permitir el acceso al rango de puertos que acabamos de configurar:

  ```console
    sudo ufw allow 30000:30050/tcp
  ```

  Ahora, cuando intentamos conectar con el cliente de consola desde la máquina protegida con firewall, bastará activar el modo pasivo con el comando passive después de la autenticación, con lo que las transferencias de datos funcionarán:

  ___Realiza la verificación de acceso a través del cliente filezilla y desde terminal___.

  El servidor __FTP vsFTPd en Ubuntu__  puede trabajar simultáneamente con acceso anónimo y con usuarios del sistema, así que habrá que indicar al cliente que utilicemos una u otra forma para conectar.

  Acceso de usuarios del sistema
  Por defecto el servidor FTP vsFTPd trabaja con los usuarios del sistema, que deberán autenticarse debidamente para acceder al servicio. Si sólo quieres usuarios anónimos podrás desactivar el acceso a usuarios del sistema modificando la directiva local_enable:

```console
  ...
  local_enable=YES
  ...
```

  Cambiando el valor YES por NO se desactivará el acceso a los usuarios locales.

  Pero si deseas mantenerlos hay ciertos ajustes que pueden ser interesantes, como que los usuarios locales puedan escribir en sus directorios:

  ```console
    ...
    # Uncomment this to enable any form of FTP write command.
    #write_enable=YES
    ...
  ```

  Descomentando la directiva write_enable manteniendo el valor YES los usuarios podrán crear o eliminar archivos y directorios:


  ```console
    ...
    # Uncomment this to enable any form of FTP write command.
    write_enable=YES
    ...
  ```

  Otra característica que puedes activar es el enjaulado de los usuarios, y es que por defecto los usuarios locales pueden navegar por todo el sistema de archivos de Ubuntu, cuando podría ser más interesante que solamente pudieran acceder a sus directorios personales. Para eso buscamos la directiva chroot_local_user y lo activamos:

  ```console
    chroot_local_user=YES
  ```

  Esta característica no se puede activar si la raíz del directorio personal (es decir, el directorio /home/usuario) es escribible, para evitar eliminar archivos o directorios esenciales, así que o cambiamos los permisos de estos directorios (como ocurre en servicios de hosting, por ejemplo), o añadimos la directiva allow_writeable_chroot:

  ```console
    chroot_local_user=YES
    allow_writeable_chroot=YES
  ```

#### Seguridad TLS

  En el caso de acceder con usuarios externos es importante usar conexiones cifradas. Para cifrar las conexiones se utiliza una clave RSA y un certificado, por lo que la configuración por defecto del servidor FTP vsFTPd hace referencia al certificado que incluye en Ubuntu, el paquete ___ssl-cert___. Sin embargo, este certificado normalmente está creado para el nombre de máquina, por lo que si accedemos con un dominio el cliente FTP podría mostrar una advertencia.

  Por ejemplo, la máquina Ubuntu sobre la que desarrollamos este tutorial tiene el nombre de máquina __daw__ y es accesible en el dominio y hemos definido un dominio local, como por ejemplo __daw.dpl__, por lo que si estuviera activado el modo SSL y accediésemos con un cliente como Filezilla usando el dominio recibiríamos un aviso:

  El cliente nos avisa de que hemos accedido al servicio FTP de la máquina __daw.dpl__, pero el certificado que proporciona el servidor está asociado al nombre __daw.dpl__. La conexión es posible y totalmente funcional, aunque el aviso puede ser molesto o simplemente poco «profesional».

  Como alternativa podemos instalar certificados firmados para el dominio con el que vayamos a conectar, o crear certificados autofirmados, por ejemplo con el comando openssl:

  ```console
  sudo openssl req -x509 -newkey rsa:2048 -days 3650 -nodes -out /etc/ssl/certs/daw.dpl.crt -keyout /etc/ssl/private/daw.dpl.key

  ```

  Nos aseguraremos de consignar en el campo «Common Name» el dominio al que queremos asociar el certificado (daw.dpl en este ejemplo):

  ```console
    ...
    Common Name (e.g. server FQDN or YOUR name) []:ubuntu2004.local.lan
    ...
  ```

  Editamos vsftpd.conf y buscamos la sección de configuración SSL:

  ```console
    ...
    # This option specifies the location of the RSA certificate to use for SSL
    # encrypted connections.
    rsa_cert_file=/etc/ssl/certs/ssl-cert-snakeoil.pem
    rsa_private_key_file=/etc/ssl/private/ssl-cert-snakeoil.key
    ssl_enable=NO
    ...
  ```

  Cambiaremos el valor NO por YES y actualizaremos las rutas del certificado y la clave privada si no queremos usar los archivos por defecto:

  ```console
    ...
    rsa_cert_file=/etc/ssl/certs/daw.dpl.crt
    rsa_private_key_file=/etc/ssl/private/daw.dpl.key
    ssl_enable=YES
    ...
  ```
  Guardados los cambios conviene reiniciar el servidor FTP:

  ```console
    sudo systemctl restart vsftpd
  ```

  Ahora, al establecer conexión cifrada observaremos que sí coincide el nombre común del certificado con el dominio que usamos para conectar:


  Como detalle, el servidor FTP vsFTPd no cifra las conexiones anónimas, por lo que para algunos clientes habrá que especificar que se conecte con el protocolo estándar al acceder anónimamente.

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

- [Instalación cliente ftp windows](https://www.redeszone.net/tutoriales/servidores/core-ftp-cliente-ftp-windows/).

</div>
