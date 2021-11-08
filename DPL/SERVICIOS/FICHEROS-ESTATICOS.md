<div align="justify">

# Ficheros Estáticos.

Reflexiona
----------

  ¿Es necesario que todas las páginas web se modifiquen constantemente? ¿Un blog sería útil si el contenido no sufre cambios? ¿Y un manual? ¿Si actualizamos un manual la página deja de ser estática?

<div align="center">
  <img src="https://httpd.apache.org/images/httpd_logo_wide_new.png"  />
</div>


  Todas aquellas páginas web que durante el tiempo no cambian su contenido no necesariamente son estáticas. Una página estática puede modificarse, actualizando su contenido y seguir siendo estática, ¿entonces? Entonces debemos diferenciar cuando accedemos a una página web entre código ejecutable en el lado del servidor y en el lado del cliente -equipo que solicita la página mediante el cliente web (navegador)-. Si al acceder a una página web no es necesaria la intervención de código en el lado del servidor -por ejemplo código PHP- o en el lado del cliente -por ejemplo **javascript**\- entonces entenderemos que la página es estática, si por el contrario es necesaria la intervención en el lado del servidor y/o en el lado del cliente entenderemos que la página es dinámica.

  Ofrecer páginas estáticas es simple, puesto que solamente se necesita que el servidor web disponga de soporte html/xhtml/css o incluso solamente html/xhtml. En cuánto a configuración y administración del servidor es el caso más simple: solamente se necesita un soporte mínimo base de instalación del servidor Apache, esto es, no se necesita por ejemplo soporte PHP. En cuánto a rendimiento del servidor, sigue siendo el caso más beneficioso: no necesita de ejecución de código en el lado del servidor para visionar la página y tampoco necesita ejecución de código en el lado del cliente, lo que significa menos coste de y memoria en el servidor y en el cliente, y por lo tanto una mayor rapidez en el acceso a la información de la página.

  Para poder ofrecer páginas estáticas mediante el servidor Apache simplemente copias la página en la ruta correspondiente donde quieres que se visione la página. Así por ejemplo cuando se instala Apache en un GNU/Linux se crean una serie de rutas en el equipo servidor similar a la estructura siguiente.

__Rutas de interés en la instalación de Apache (apache2)__.


```
/etc/apache2/sites-available/

├── 000-default.conf

└── default-ssl.conf

/var/www/html/

└── index.html

/etc/apache2/mods-available/mime.conf

/etc/apache2/apache2.conf

```
En la instalación de Apache se crea una página web en **`/var/www/html/index.html`** referenciada a través del archivo __default (/etc/apache/sites-available/default)__, éste contiene la configuración por defecto, generada en la instalación de Apache, para esa página. Si solamente quieres servir una página web la forma más fácil de hacerlo sería sustituyendo la página **index.html,** referenciada en **default,** por la página que quieres servir, por ejemplo `empresa.html`. Puedes comprobarlo siguiendo el procedimiento:

1.  Abres el navegador en la página por defecto creada en la instalación de Apache: `index.html`**.**
2.  Sustituyes los archivos en el servidor. Ten en cuenta que la página a servir debe siempre poseer el nombre `index.html`**.**
3.  Pulsas F5 en el navegador para actualizar la página y la página que verás será la tuya.

Si lo que quieres es servir otra página, por ejemplo `empresa.html`, simplemente no le cambies como antes el nombre, deja el que posee la página. Ahora podrás ver dos páginas en el servidor: la página `index.html` y la página `empresa.html`. Si lo que quieres es servir más páginas pues, como antes, simplemente vas subiendo al servidor las páginas e incluso podrías organizarlas en carpetas.

Para saber más
--------------

Te proponemos que hagas un viaje por la página web de [documentación de Apache](https://httpd.apache.org/docs/).



</div>
