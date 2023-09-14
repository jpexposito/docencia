<div align="justify">

# INSTALACIÓN Y ADMINISTRACIÓN DE SERVIDORES DE TRANSFERENCIA DE ARCHIVOS

<div align="center">
  <img src="https://www.redeszone.net/app/uploads-redeszone.net/2019/11/portada-core-ftp.png" >
</div>

## ¿En qué consiste un FTP?

  FTP significa __protocolo de transferencia de archivos__, por sus siglas en inglés. Veámoslo con detalle. Básicamente, un __protocolo__ es un conjunto de procedimientos o reglas que permiten que los dispositivos electrónicos se comuniquen entre sí. FTP es el conjunto de reglas que los dispositivos de una red TCP/IP (es decir, Internet) utilizan para transferir archivos. Cuando usas Internet, en realidad estás usando varios protocolos. Para navegar, utilizas HTTP. Para enviar y recibir mensajes instantáneos, XMPP. Y el FTP es solo el protocolo que se utiliza para mover los archivos.

## ¿Qué es un servidor FTP?

  Los servidores FTP son las aplicaciones de software que permiten la transferencia de archivos de un dispositivo a otro. Puede sonar complejo, pero, básicamente, los servidores FTP son sencillamente ordenadores que tienen una dirección FTP y están dedicados a recibir conexiones FTP. Llevan a cabo dos tareas sencillas que se conocen como __get__ and __put__, que podemos traducir como __obtener__ y __colocar/poner__, respectivamente. Es decir, puedes obtener archivos desde un servidor FTP o colocar archivos en el servidor FTP. Al subir archivos, se transferirán desde tu dispositivo personal al servidor. Alternativamente, al descargarlos, se transferirán desde el servidor hasta tu dispositivo personal. ___A nivel básico, por tanto, los servidores FTP son el punto medio entre el destinatario y el emisor.___

___PROPORCIONA EL INTERCAMBIO ENTRE DOS (CLIENTE <-> SERVIDOR)___

## ¿Cómo funciona el FTP?

  El FTP es un protocolo cliente-servidor. Es decir, el cliente solicita los archivos y el servidor los ofrece. El FTP requiere dos canales básicos para establecer una conexión: el canal de comando (que inicia la instrucción, transporta información básica; p. ej., a qué archivos hay que acceder) y el canal de datos (transfiere los datos de archivo entre dos dispositivos). Para establecer una conexión, los usuarios necesitarán proporcionar credenciales al servidor FTP, que generalmente usa el puerto número 21 como el modo de comunicación por defecto. También es importante tener en cuenta que hay dos modos de conexión FTP distintos: activo y pasivo.

### Pasivo

  En el modo activo, el servicio toma un papel activo al aprobar una solicitud de datos. Sin embargo, el modo activo puede encontrarse con problemas con los cortafuegos, que bloquean sesiones no autorizadas de terceros. Y aquí es donde entra en juego el modo pasivo. En el modo pasivo, el servidor no mantiene de forma activa la conexión. Esto significa que el usuario establece tanto el canal de datos como el canal de comando. Básicamente, el servidor __escucha__, pero no participa de forma activa, permitiendo que el otro dispositivo gestione la carga de trabajo.

### ¿Qué problemas resuelve el FTP?

  El FTP suele utilizarse para gestionar grandes volúmenes de archivos, por lo que resulta muy útil en el desarrollo web. Al hacer cambios en una web, puedes gestionar las transferencias de archivo con una sesión FTP, lo cual permite subir de forma sencilla archivos específicos, añadir imágenes, mover plantillas web y mucho más. De forma similar, los profesionales de TI pueden usar el protocolo de transferencia de archivos para transferir grandes lotes de archivos del servidor dentro de un sistema cerrado.

### ¿Cuáles son las ventajas y desventajas del FTP?

  El FTP tiene un par de ventajas que merece la pena mencionar. Debido a que lleva vigente bastante tiempo, la mayoría de la gente ya está familiarizada con él. Y hay muchas herramientas para el ordenador (como FileZilla, WinSCP y Cyberduck, entre otras) que simplifican mucho el uso del FTP. También debemos destacar que cuenta con dos funciones muy útiles, como la capacidad de transferir varios archivos a la vez, de reanudar una transferencia cuando se pierde la conexión y de programar transferencias.

  Sin embargo, hay una desventaja bastante significativa asociada al FTP, y es la falta de seguridad. El FTP se inventó en 1970 y, como tal, antecede a muchas medidas de ciberseguridad en las que actualmente confiamos en el mundo moderno. No se diseñó para ser un protocolo seguro y las transferencias FTP no están cifradas. Esto implica que los hackers pueden leer con relativa facilidad tus contraseñas, nombres de usuario y otros datos confidenciales si capturan tus paquetes de datos (p. ej., mediante un ataque de captura de paquetes).

  Debido a estas brechas de seguridad, la compatibilidad con el FTP es cada vez menor y han surgido diferentes opciones que lo reemplazan, como el SFTP, HTTPS, AS2 y FTPS. En 2020, Google Chrome desactivó el FTP por defecto y Firefox eliminó el FTP de su código. Por tanto, si sigues usando servidores FTP para procesos importantes de tu empresa, puede que haya llegado el momento de buscar una alternativa. Ahora, veamos con detenimiento uno de estas soluciones que lo reemplazan: el SFTP.

### ¿Qué es el SFTP?

 Básicamente, el ___SFTP___ (también conocido como protocolo de transferencia de archivos SSH) es un protocolo independiente que funciona sobre un flujo de datos de Secure Shell (SHH) para ofrecer un nivel superior de protección cuando estás a transfiriendo archivos. A diferencia de los clientes FTP, que usan el puerto 21, el SFTP utiliza el puerto 22. Debido a que el FTP es un protocolo inseguro, se suele preferir el SFTP, ya que ofrece funciones de seguridad subyacentes, además de la capacidad de adjuntarse a una conexión SSH.

## Reflexión

  Si bien es cierto que el __FTP es una opción muy efectiva para transferir archivos, también lo es que está algo desfasada__ y otros protocolos de red ya disponibles la han superado, como el __SFTP__ como servicio.

  En modo gráfico, la principal diferencia sera:

  <div align="center">
    <img src="https://cdn.educba.com/academy/wp-content/uploads/2019/10/FTP-vs-SFTP.png.webp" >
  </div>

</div>
