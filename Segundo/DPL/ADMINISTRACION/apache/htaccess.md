# Configuración de apache mediante archivo .htaccess

Un fichero ``.htaccess`` (hypertext access), también conocido como archivo de configuración distribuida, es un fichero especial, popularizado por el Servidor HTTP Apache que nos permite definir diferentes directivas de configuración para cada directorio (con sus respectivos subdirectorios) sin necesidad de editar el archivo de configuración principal de Apache.

Para permitir el uso de los ficheros .htaccess o restringir las directivas que se puedn aplicar usamos ela directiva [AllowOverride](http://httpd.apache.org/docs/2.4/mod/core.html#allowoverride>), que puede ir acompañada de una o varias opciones: ``All``, ``AuthConfig``, ``FileInfo``, ``Indexes``, ``Limit``, ... Estudia para que sirve cada una de las opciones.

**Ejercicios**

Utiliza una cuenta de un servidor remoto para comprobar el uso de ``.htacces``. Crea un directorio dentro de html_public y crea un fichero .htaccess que nos permita:

1. Deshabilitar la opción de listar los ficheros en ese directorio.
2. Hacer que la página entrada.html se visualice por defecto.
3. Hacer que los ficheros txt no sean accesibles.
4. (Se debe hacer en local) Redireccionar a una página (por ejemplo la web del instituto) excepto a unas determinadas IP
5. Crear una lista de IPs prohibidas
6. Protege tu directorio y ficheros con autentificación básica
7. Crear una página personalizada para cada tipo de error
8. Crea una redirección permanente: cuando entremos en este directorio salte a www,google.es
9. Permitir la entrada desde un cliente en concreto (utilizando el nombre del host), si no se entra desde esa máquina, pedir autentificación.
10. Usar negociación de contenidos: tener dos páginas en distinto idioma y configurar en el .htaccess que idioma es el prioritario.
