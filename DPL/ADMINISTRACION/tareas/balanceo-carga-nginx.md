<div align="justify">

# BALANCEO DE CARGA EN NGINX

## Introducción

  __NGINX__, demás de utilizarse como servidor Web estático o dinámico, dispone de otras características desarrolladas en él (cómo la mayoría de servidores HTTP), en este caso explicamos que es y cómo realizar __proxy inverso__, también llamado servidor de paso. ___Esta opción que permite recuperar recursos del mismo servidor o de otro de forma trasparente para el cliente web, promoviendo otro contenido estático y/o dinámico___.

</br>

<div align="center">
  <img src="https://jelastic.com/blog/wp-content/uploads/2014/10/server-diagram_2.png" >
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
        proxy_pass http://localhost:8083/app-web-demo/;
    }
  }

  ```
 - Reinicia Nginx.

  ```console
    sudo systemctl reload nginx
  ```
  - Accede a __midominio.com__ e indica cual es la respuesta.
  - Vamos a añadir un poco más de configuración y ver el comportamiento:
    - Edite el archivo /etc/nginx/sites-available/midominio.com.conf y añada la siguiente configuración:
  ```console
  http {
      upstream server_group_wildfly {
          least_conn;
          server http://localhost:8081/app-web-demo;
          server http://localhost:8082/app-web-demo;
          server http://localhost:8083/app-web-demo;
          server http://localhost:8084/app-web-demo backup;
      }

      server {
          location / {
              proxy_pass http://server_group_wildfly;
          }
      }
  }
  ```

  - La directiva least_conn en el grupo de hosts llamado backend define que NGINX envíe las peticiones entre los servidores __localhost 8081-8083__, ___dependiendo del host que tenga el menor número de conexiones activas___. __NGINX__ utiliza el servidor __localhost:8084__ sólo como respaldo en caso de que los otros dos hosts no estén disponibles.
  - Con la directiva __proxy_pass__ establecida en http://server_group_wildfly, __NGINX__ actúa como un proxy inverso y utiliza el grupo de hosts backend para distribuir las peticiones basándose en la configuración de este grupo.

  En lugar del método de equilibrio de carga least_conn, puede especificar:
  - __No hay método para utilizar round robin y distribuir las peticiones de manera uniforme entre los servidores__.
  - __ip_hash__ para enviar solicitudes de una dirección de cliente al mismo servidor basándose en un hash calculado a partir de los tres primeros octetos de la dirección IPv4 o de la dirección IPv6 completa del cliente.
  - __hash__ para determinar el servidor basándose en una clave definida por el usuario, que puede ser una cadena, una variable o una combinación de ambas. El parámetro consistent configura que NGINX distribuya las peticiones entre todos los servidores basándose en el valor de la clave hash definida por el usuario.
  - __random__ para enviar solicitudes a un servidor seleccionado al azar.

Realiza cambios en el método de establecer el servidor de destino, indicando por ejemplo __random__, de manera que verifiques el comportamiento. Además, puedes parar las instancias entre la __8081:8083__, para determinar si el nodo que se encuentra en __backup__ realiza su función correctamente.
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
