# VirtualHosting con Apache

## Introducción al VirtualHosting

El término Hosting Virtual se refiere a hacer funcionar más de un sitio web (tales como ``www.company1.com`` y ``www.company2.com``) en una sola máquina. Los sitios web virtuales pueden estar "basados en direcciones IP", lo que significa que cada sitio web tiene una dirección IP diferente, o "basados en nombres diferentes", lo que significa que con una sola dirección IP están funcionando sitios web con diferentes nombres (de dominio). Apache fue uno de los primeros servidores web en soportar hosting virtual basado en direcciones IP.

El servidor web Apache2 se instala por defecto con un host virtual. La configuración de este sitio la podemos encontrar en:

    /etc/apache2/sites-available/000-default.conf

Cuyo contenido podemos ver:

	<VirtualHost *:80>
	        #ServerName www.example.com
	        ServerAdmin webmaster@localhost
	        DocumentRoot /var/www/html
	        ErrorLog ${APACHE_LOG_DIR}/error.log
	        CustomLog ${APACHE_LOG_DIR}/access.log combined
	</VirtualHost>

Donde encontramos los siguientes parámetros:

* [ServerName](https://httpd.apache.org/docs/2.4/mod/core.html#servername)
* [ServerAdmin](https://httpd.apache.org/docs/2.4/mod/core.html#serveradmin)
* [DocumentRoot](https://httpd.apache.org/docs/2.4/mod/core.html#documentroot)
* [ErrorLog](https://httpd.apache.org/docs/2.4/mod/core.html#errorlog)
* [CustomLog](http://httpd.apache.org/docs/current/mod/mod_log_config.html#customlog)


Y por defecto este sitio virtual está habilitado, por lo que podemos comprobar que existe un enlace simbólico a este fichero en el directorio ``/etc/apache2/sites-enables``:

    lrwxrwxrwx 1 root root   35 Oct  3 15:24 000-default.conf -> ../sites-available/000-default.conf

Podemos habilitar o deshabilitar nuestros host virtuales utilizando los siguientes comandos:

	a2ensite
	a2dissite

En el fichero de configuración general ``/etc/apache2/apache2.conf`` nos encontramos las opciones de configuración del directorio padre del indicado en la directiva ``DocumentRoot`` (suponemos que todos los host virtuales van a estar guardados en subdirectorios de este directorio):

	...
	<Directory /var/www/>
		Options Indexes FollowSymLinks
		AllowOverride None
		Require all granted
	</Directory>
	...

## Configuración de VirtualHosting

El objetivo de esta práctica es la puesta en marcha de dos sitios web utilizando el mismo servidor web apache. Hay que tener en cuenta lo siguiente:

* Cada sitio web tendrá nombres distintos.
* Cada sitio web compartirán la misma dirección IP y el mismo puerto (80).

Queremos construir en nuestro servidor web apache dos sitios web con las siguientes características:

* El nombre de dominio del primero será ``www.iespuerto.org``, su directorio base será ``/var/www/iespuerto`` y contendrá una página llamada ``index.html``, donde sólo se verá una bienvenida a la página del Instituto Gonzalo Nazareno.
* En el segundo sitio vamos a crear una página donde se pondrán noticias por parte de los departamento, el nombre de este sitio será ``www.departamentospuerto.org``, y su directorio base será ``/var/www/departamentos``. En este sitio sólo tendremos una página inicial ``index.html``, dando la bienvenida a la página de los departamentos del instituto.

Para conseguir estos dos sitios virtuales debes seguir los siguientes pasos:

1. Los ficheros de configuración de los sitios webs se encuentran en el directorio ``/etc/apache2/sites-available``, por defecto hay dos ficheros, uno se llama ``000-default.conf`` que es la configuración del sitio web por defecto. Necesitamos tener dos ficheros para realizar la configuración de los dos sitios virtuales, para ello vamos a copiar el fichero ``000-default.conf``:

    cd /etc/apache2/sites-available
    cp 000-default.conf iespuerto.conf
    cp 000-default.conf departamentos.conf

	De esta manera tendremos un fichero llamado ``iespuerto.conf`` para realizar la configuración del sitio web ``www.iespuerto.org``, y otro llamado ``departamentos.conf`` para el sitio web ``www.departamentospuerto.org``.

2. Modificamos los ficheros ``iespuerto.conf`` y ``departamentos.conf``, para indicar el nombre que vamos ausar para acceder al host virtual (``ServerName``) y el directorio detrabajo (``DocumentRoot``).
3. No es suficiente crear los ficheros de configuración de cada sitio web, es necesario crear un enlace simbólico a estos ficheros dentro del directorio ``/etc/apache2/sites-enabled``, para ello:

        a2ensite iespuerto
        a2ensite departamentos

	La creación de los enlaces simbólicos se puede hacer con la instrucción ``a2ensite nombre_fichero_configuracion``, para deshabilitar el sitio tenemos que borrar el enlace simbólico o usar la instrucción ``a2dissite nombre_fichero_configuracion``.

4. Crea los directorios y los ficheros index.html necesarios en ``/var/www`` y reiniciamos el servicio.

5. Para terminar lo único que tendremos que hacer es cambiar el fichero hosts en los clientes y poner dos nuevas líneas donde se haga la conversión entre los dos nombre de dominio y la dirección IP del servidor.


```eval_rst
.. note:

	Repite el ejercicio cambiando los directorios de trabajo a ``/srv/www``. ¿Qué modificación debes hacer en el fichero ``/etc/apache2/apache2.conf``?
```
