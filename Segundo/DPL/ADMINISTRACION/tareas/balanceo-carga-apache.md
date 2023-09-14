<div align="justify">

# BALANCEO DE CARGA EN APACHE

## Introducción

  Apache, demás de utilizarse como servidor Web estático o dinámico, dispone de otras características desarrolladas en él (cómo la mayoría de servidores HTTP), en este caso explicamos que es y cómo realizar __proxy inverso__, también llamado servidor de paso. ___Esta opción que permite recuperar recursos del mismo servidor o de otro de forma trasparente para el cliente web, promoviendo otro contenido estático y/o dinámico___.

</br>

<div align="center">
  <img src="http://httpd.apache.org/docs/trunk/es/images/reverse-proxy-arch.png" >
</div>


### ¿Cómo funciona el proxy inverso?

  En este escenario el propio servicio no genera contenido ni aloja datos, en su lugar el contenido se obtiene de los servidores Backend, que normalmente tienen conexión directa con redes internas. Cuando el servicio web recibe una petición de un cliente, se hace una petición a uno de estos servidores Backend gestionándola y generando el contenido. Entonces envía el contenido al servidor proxy (Apache en este caso) y este envía la respuesta al cliente.

  Hay múltiples razones para la implementación de esta función, entre ellas, ___seguridad, alta disponibilidad, balanceo de carga y centralización de autorización___. Normalmente en estas implementaciones que la arquitectura y el diseño de la infraestructura de los servidores __Backend__ suelen estar aislados/protegidos del exterior __(DMZ)__; la única conexión debería ser con el servidor proxy (qué recibe y proporciona la respuesta al cliente).

### ¿Qué protocolos admite Apache Proxy?

  Apache admite los protocolos más populares, así como varios algoritmos de equilibrio de carga diferentes (los módulos de terceros pueden agregar soporte para protocolos adicionales) y se debe cargar el conjunto de módulos para proporcionar las funciones necesarias. Estos módulos se pueden incluir estáticamente en el momento de la compilación o dinámicamente a través de su directiva.

  El conjunto debe incluir:

  - mod_proxy, que proporciona capacidades básicas de proxy.
  - mod_proxy_balancer, o más módulos balanceadores si se requiere balanceo de carga.
  Uno o más módulos de protocolos para proxy admitidos:
    - AJP13 (Apache JServe protocolo versión 1.3): mod_proxy_ajp.
    - CONNECT (para SSL): mod_proxy_connect.
    - FastCGI: mod_proxy_fcgi.
    - FTP: mod_proxy_ftp.
    - HTTP/0.9, HTTP/1.0, and HTTP/1.1: mod_proxy_http.
    - HTTP/2.0: mod_proxy_http2.
    - SCGI: mod_proxy_scgi.
    - UWSGI: mod_proxy_uwsgi.
    - WS and WSS (Web-sockets): mod_proxy_wstunnel.

## Realización de la tarea

  En esta práctica deberá automatizar la instalación y configuración de una aplicación web sobre cuatro nodos. Vamos a usar una máquina virtual con Apache HTTP Server como un proxy inverso para hacer de balanceador de carga. El objetivo de esta práctica, es crear una __arquitectura de alta disponibilidad que sea escalable y redundante__, de modo que podamos __balancear__ la carga entre todos los frontales web.

  La arquitectura estará formada por:
  - Un __balanceador__ de carga, implementado con un Apache HTTP Server configurado como proxy inverso. Este se encuentra ya instalado, y sólo requiere la instalación.
  - Una capa de front-end, formada por cuatro servidores web con la aplicación corriendo. Aplicación Web [__jsp__](https://github.com/jpexposito/docencia/tree/master/COMUN/ejemplos/java/app-web-demo) que hemos utilizado en otras tareas. Para ello necesitará crear:
    - 4 instancias de la aplicación desplegadas en otras ocasiones basada en [__jsp__](https://github.com/jpexposito/docencia/tree/master/COMUN/ejemplos/java/app-web-demo), y puerto, tal y como se ha realizado en otras tareas(__8081, 8082, 8083, 8084__).
  - Recuerda que en la instalación de nodos o servicios necesarios, también sería posible instalar un servidor de BBDD en MySql por ejemplo, pero en este caso no será necesario.  

### Activación de los módulos necesarios en Apache

 El primer paso será la activación de los nodos necesarios en Apache. Los módulos necesarios son:

  ```console
  a2enmod proxy
  a2enmod proxy_http
  a2enmod proxy_ajp
  a2enmod rewrite
  a2enmod deflate
  a2enmod headers
  a2enmod proxy_balancer
  a2enmod proxy_connect
  a2enmod proxy_html
  a2enmod lbmethod_byrequests
  ```

  Si quisieramos desactivar un módulo, deberemos de utilizar:

  ```console
  a2dismod proxy_ajp
  ```

  Una vez realizada la activación de los módulos es necesario realizar un reinicio del servicio Apache:

```console
  systemctl restart apache2
```


### Configuración de Apache para trabajar como balanceador de carga para el tráfico HTTP

  Editamos el archivo 000-default.conf que está en el directorio /etc/apache2/sites-available:

```
  sudo nano /etc/apache2/sites-available/000-default.conf
```

  Añadimos las directivas [Proxy](http://httpd.apache.org/docs/trunk/es/howto/reverse_proxy.html) y [ProxyPass](http://httpd.apache.org/docs/trunk/es/howto/reverse_proxy.html) dentro de VirtualHost.

```
<VirtualHost *:80>
  # Dejamos la configuración del VirtualHost como estaba
  # sólo hay que añadir las siguiente directivas: Proxy y ProxyPass

  <Proxy balancer://mycluster>
      # Server 1
      BalancerMember http://IP-HTTP-SERVER-1:8081

      # Server 2
      BalancerMember http://IP-HTTP-SERVER-2:8082

      # Server 3
      BalancerMember http://IP-HTTP-SERVER-3:8083

      # Server 4
      BalancerMember http://IP-HTTP-SERVER-4:8084
  </Proxy>

  ProxyPass / balancer://mycluster/
</VirtualHost>

```
Tendremos que reemplazar IP-HTTP-SERVER-1, IP-HTTP-SERVER-2, IP-HTTP-SERVER-3, y IP-HTTP-SERVER-4, en nuestro caso deberá de ser __localhost__ para las máquinas que estamos utilizando como Front-End.


## Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la instalación y se muestre la instalación de _Balanceo carga Apache_, con 4 nodos en __Wildfly, jsp, y Docker__. Describe cada uno de los pasos que has realizado.

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

## Referencias

- [Proxy Inverso Apache](http://httpd.apache.org/docs/trunk/es/howto/reverse_proxy.html).
</div>
