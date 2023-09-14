# Servidor Web

En este bloque del módulo vamos a estudiar el servidor Web, programa software que utilizando el protocolo HTTP, es capaz de procesor en el servidor la peticiones HTTP y generar las respuestas adecuadas. En este bloque vamos a estudiar distintos aspectos del servicio web.

* El protocolo HTTP: tipos de peticiones, tipos de respuestas, cabeceras, autentificación, control de acceso, etc.

* Vamos a usar el servidor __Apache__ y el servidor __Nginx__:

	* Configuración básica
	* Virtual Hosting
	* Mapeo de URL
	* Autentificación y control de acceso
	* Módulos
	* Módulos de multiprocesamiento
	* Ejecución de scripts en el servidor: PHP, Python,...

**Indice**
- Apache
	- [Instalación y configuración básica](apache/instalacion.md).
	- [VirtualHosting](apache/virtualHosting.md).
	- [Mapeo](apache/mapeo.md).
	- [Control de Acceso](apache/control-acceso.md).
	- [Configuración htaccess](apache/htaccess.md).


## Referencias

### Protocolo HTTP

* [Introducción al protocolo HTTP](https://github.com/josedom24/serviciosgs_doc/raw/master/web/doc/Tema10_HTTP.pdf)
* [Protocolo HTTP (Univ. Valencia) Vídeo 1](https://www.youtube.com/watch?v=wHXRmq75N_Y) Vídeo 1)
* [Protocolo HTTP (Univ. Valencia) Vídeo 2](https://www.youtube.com/watch?v=CPUbmKc3rtM)
* [Qué son los MIME Types](http://www.webtaller.com/maletin/articulos/que-son-mime-types.php)
* [Lista de cabeceras HTTP 1.1](https://en.wikipedia.org/wiki/List_of_HTTP_header_fields)

### Servidor web Apache

* [Documentación oficial servidor web Apache 2.2](http://httpd.apache.org/docs/2.2/es/)
* [Documentación oficial servidor web Apache 2.4](http://httpd.apache.org/docs/2.4/es/)
* [Updating Virtual Host Settings from Apache 2.2 to Apache 2.4](https://www.linode.com/docs/security/upgrading/updating-virtual-host-settings-from-apache-2-2-to-apache-2-4)
* [How To Migrate your Apache Configuration from 2.2 to 2.4 Syntax](https://www.digitalocean.com/community/tutorials/migrating-your-apache-configuration-from-2-2-to-2-4-syntax)

### Módulos en apache

* [Utilización de módulos en Apache](https://github.com/josedom24/serviciosgs_doc/raw/master/web/doc/apache-modular.pdf)
* [Cómo crear URLS amigables con htaccess](http://www.emenia.es/como-crear-urls-amigables-con-htaccess/)

### Servidor nginx

* [Documentación oficial de nginx](https://nginx.org/en/docs/)
