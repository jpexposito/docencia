<div align="justify">

# BALANCEO DE CARGA EN NGINX

## Introducción

  __NGINX__, demás de utilizarse como servidor Web estático o dinámico, dispone de otras características desarrolladas en él (cómo la mayoría de servidores HTTP), en este caso explicamos que es y cómo realizar __proxy inverso__, también llamado servidor de paso. ___Esta opción que permite recuperar recursos del mismo servidor o de otro de forma trasparente para el cliente web, promoviendo otro contenido estático y/o dinámico___.

</br>

<div align="center">
  <img src="http://httpd.apache.org/docs/trunk/es/images/reverse-proxy-arch.png" >
</div>


### ¿Cómo funciona el proxy inverso?

  En este escenario el propio servicio no genera contenido ni aloja datos, en su lugar el contenido se obtiene de los servidores Backend, que normalmente tienen conexión directa con redes internas. Cuando el servicio web recibe una petición de un cliente, se hace una petición a uno de estos servidores Backend gestionándola y generando el contenido. Entonces envía el contenido al servidor proxy (Apache en este caso) y este envía la respuesta al cliente.

  Hay múltiples razones para la implementación de esta función, entre ellas, ___seguridad, alta disponibilidad, balanceo de carga y centralización de autorización___. Normalmente en estas implementaciones que la arquitectura y el diseño de la infraestructura de los servidores __Backend__ suelen estar aislados/protegidos del exterior __(DMZ)__; la única conexión debería ser con el servidor proxy (qué recibe y proporciona la respuesta al cliente).

### ¿Qué protocolos admite Apache Proxy?



## Realización de la tarea

  En esta práctica deberá automatizar la instalación y configuración de una aplicación web sobre cuatro nodos. Vamos a usar una máquina virtual con __Nginx__ HTTP Server como un proxy inverso para hacer de balanceador de carga. El objetivo de esta práctica, es crear una __arquitectura de alta disponibilidad que sea escalable y redundante__, de modo que podamos __balancear__ la carga entre todos los frontales web.

  La arquitectura estará formada por:
  - Un __balanceador__ de carga, implementado con un __Nginx__ HTTP Server configurado como proxy inverso. Este se encuentra ya instalado, y sólo requiere la instalación.
  - Una capa de front-end, formada por cuatro servidores web con la aplicación corriendo. Aplicación Web(__jsp__) que hemos utilizado en otras tareas. Para ello necesitará crear:
    - 4 instancias de la aplicación desplegadas en otras ocasiones basada en __jsp__, y puerto, tal y como se ha realizado en otras tareas(__8081, 8082, 8083, 8084__).
  - A diferencia de el [proxy inverso en Apache](balanceo-carga-apache.md), vamos a realizar el balanceo entre 3 nodos, dejando el último nodo en backend, de modo que sólo entre en uso, cuando se detecte que uno de los nodos ha __caído o esta saturado__.

### Configuración de un dominio en Nginx

  En primer lugar deberás cumplir con los siguientes requisitos:
  - Tener instalado y activado Nginx. Asegurarse de no tener los puertos __8090__ y __443__ ocupados por otro proceso como, por ejemplo, [Apache](balanceo-carga-apache.md).
  Tener corriendo una aplicación web en __localhost__ a través de un puerto arbitrario __(8081-8084)__. Recuerda que vamos utilizar los [servidores Wildfly de proxy inverso en Apache](balanceo-carga-apache.md), de una forma similar.
  - Crea un nuevo archivo de virtual host. Una buena ruta para hacerlo es "sites-available" dentro del directorio de configuración de nginx.

  ```console
  sudo nano /etc/nginx/sites-available/midominio.com.conf
  ```
  - Editar el archivo y añade la configuración para el proxy inverso.

  ```console
  server {
    #Escucha en el puerto 8090, ipv4.
    listen 8090;

    #Aquí deberás introducir el nombre de tu dominio.
    server_name midominio.com;

    access_log            /var/log/nginx/midominio.com.access.log;

    location / {
        #La configuración del proxy.
        proxy_pass http://localhost:8083/app-web-demo;
    }
  }

  ```
 - Reinicia Nginx.

  ```console
    sudo systemctl reload nginx
  ```
  - Accede a __midominio.com__ e indica cual es la respuesta.


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

- [Redhat Nginx (Balanceador de Carga)](https://access.redhat.com/documentation/es-es/red_hat_enterprise_linux/8/html/deploying_different_types_of_servers/configuring-nginx-as-an-http-load-balancer_setting-up-and-configuring-nginx).
- [Documentación Oficial Nginx (Balanceador de Carga)](
https://docs.nginx.com/nginx/admin-guide/load-balancer/http-load-balancer/)

</div>
