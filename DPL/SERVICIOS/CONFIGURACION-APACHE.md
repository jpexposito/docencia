# Configuración básica del servidor Apache.

  Fotografía de la flecha de una veleta con la punta roja indicando la dirección del viento.

  Anteriormente hemos dicho que inicialmente la carpeta raíz del sitio web creado por Apache es /var/www/html y que el nombre del archivo índice o por defecto es index.html. Pero, ¿Cómo se puede modificar este comportamiento y otros del servidor Apache? Modificando los archivos de configuración. Vamos a verlo.

  Para modificar la configuración del servidor Apache, podemos editar el archivo principal de configuración /etc/apache2/apache2.conf o editar alguno de los archivos que incluye este archivo. Hay un gran número de directivas que podemos usar para la configuración del servidor. La siguiente tabla describe las que se pueden considerar directivas necesarias para realizar una configuración básica.

Directivas de configuración básica
Directiva	Descripción	Ejemplo de uso
ServerName	Nombre de equipo y puerto que usa el servidor para identificarse ante los clientes. En definitiva, indica el nombre del sitio web.	ServerName www.aulalinux.org:80
ServerRoot	Indica la carpeta en la que se ha instalado el servidor. No es la carpeta de archivos de configuración.	ServerRoot /usr/local/apache
Listen	Especifica los puertos del servidor en los que escucha a los clientes y opcionalmente las direcciones IP de los adaptadores de red que utiliza.	Listen 80
Listen 192.168.3.5:8080
Tiemout	Máximo tiempo en segundos que el servidor espera un nuevo mensaje de un cliente para no cerrar la conexión.	Timeout 300
KeepAlive	Para indicar que se mantenga (on) o no (off) una conexión con un cliente para varias transacciones.	KeepAlive on
KeepAlive off
DocumentRoot	Carpeta raíz que contiene todos los archivos del sitio web.	DocumentRoot var/web/
DirectoryIndex	Indica los nombres de las páginas web índice que puede entregar el servidor por defecto cuando en la petición HTTP la URL contiene sólo un nombre de carpeta.	DirectoryIndex index.html
home.html index.php
NameVirtualHost	Especifica las direcciones IP y puerto en los que el servidor recibirá peticiones para sitios web virtuales basados en nombre. Si se usa esta directiva, se deben definir los sitios virtuales dentro de una directiva <VirtualHost> … </VirtualHost>.	NameVirtualHost *:80
