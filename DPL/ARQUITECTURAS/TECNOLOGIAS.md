<div align="justify">

# TECNOLOGÍAS EN EL DESPLIEGUE DE APLICACIONES WEB

  Hemos de comprender que en desarrollo y despliegue de aplicaciones web pueden verse relacionadas diferentes tecnologías en nuestra organización.

  En este módulo describiremos algunos de ellos y continuaremos con la creación de nuestro sistema, que contemple todo lo necesario en la organización.

## APACHE

<div align="center">
  <img src="https://httpd.apache.org/images/httpd_logo_wide_new.png"  />
</div>

  Apache es un servidor web HTTP de código abierto. Está desarrollado y mantenido por una comunidad de usuarios en torno a la Apache Software Foundation.

  Actualmente y desde el 1996 es el servidor web más usado en todo el mundo debido a su seguridad y estabilidad.

### ¿Cómo funciona?

  La funcionalidad principal de este servicio web es servir a los usuarios todos los ficheros necesarios para visualizar la web. Las solicitudes de los usuarios se hacen normalmente mediante un navegador (Chrome, Firefox, Safari, etc.).

  Por ejemplo, cuando un usuario escribe en su navegador www.jpexposito.com, esa petición llegará a nuestro servidor Apache que mediante el protocolo _HTTP_ este se encargará de facilitarle los textos, imágenes, estilos, etc. que conforman la portada de nuestra web de forma segura.

  __Apache__ tiene una estructura basada en módulos, que permite activar y desactivar funcionalidades adicionales, por ejemplo, módulos de seguridad como _mod_security_, módulos de caché como Varnish, o de personalización de cabeceras como _mod_headers_. También permite ajustar los parámetros de PHP de tu hosting de forma personalizada mediante el fichero _.htaccess_.

### Ventajas y desventajas

#### Ventajas
  Las principales ventajas de usar este el servicio web son las siguientes:
  - De código abierto y gratuito, con una gran comunidad de usuarios.
  - Parches de seguridad regulares y actualizados con frecuencia.
  - Estructura basada en módulos.
  - Multiplataforma. Está disponible en servidores Windows y Linux.
  - Personalización mediante _.htaccess_ independiente en cada hosting.
  - Compatible con los principales CMS y tiendas online y plataformas e-learning.

#### Desventajas

  Sus principales desventajas son las siguientes:
  - Presenta problemas de estabilidad por encima de las 10000 conexiones.
  - Un uso abusivo de módulos pueden generar brechas de seguridad.

### Instalación y configuración básica

  Para realizar la instalación y configuración básica sigue la siguiente [tarea](tareas/instalacion-apache.md).


## APACHE-TOMCAT

<div align="center">
  <img src="http://tomcat.apache.org/res/images/tomcat.png"  />
</div>

  Estrictamente hablando, _Tomcat_ no es un servidor web como Apache HTTPS Server o NGINX.

  Comenzado en 1999 y desarrollado como un proyecto de código abierto por la Apache Software Foundation (ASF), Apache Tomcat es un contenedor Java Servlet, o contenedor web, que proporciona la funcionalidad extendida para interactuar con Java Servlets, al tiempo que implementa varias especificaciones técnicas de la plataforma Java: JavaServer Pages (JSP), Java Expression Language (Java EL) y WebSocket.

### Características

  Tomcat puede funcionar como servidor web por sí mismo. En sus inicios existió la percepción de que el uso de Tomcat de forma autónoma era sólo recomendable para entornos de desarrollo y entornos con requisitos mínimos de velocidad y gestión de transacciones. Hoy en día ya no existe esa percepción y Tomcat es usado como servidor web autónomo en entornos con alto nivel de tráfico y alta disponibilidad.

  La jerarquía de directorios de instalación de Tomcat incluye:
  - __bin__: arranque, cierre, y otros scripts y ejecutables.
  - __common__: clases comunes que pueden utilizar Catalina y las aplicaciones web.
  - __conf__: ficheros XML y los correspondientes DTD para la configuración de Tomcat.
  - __logs__: logs de Catalina y de las aplicaciones.
  - __server__: clases utilizadas solamente por Catalina.
  - __shared__: clases compartidas por todas las aplicaciones web.
  - __webapps__: directorio que contiene las aplicaciones web.
  - __work__: almacenamiento temporal de ficheros y directorios.

  <div align="center">
    <img src="https://images1.programmerclick.com/10/a9/a963912e7fca83d2aeb441228d967c8a.png"  />
  </div>


### Instalación y configuración básica

  Para realizar la instalación y configuración básica sigue la siguiente [tarea](tareas/instalacion-apache-tocat.md).


### Despliegue de una Aplicación

  Para realizar el despliegue de una aplicación sigue la siguiente [tarea](tareas/despliegue-jsp-apache-tomcat.md).


## Wildfly


### Instalación y configuración básica

  Para realizar la instalación y configuración básica sigue la siguiente [tarea](tareas/instalacion-jboss-wildfly.md).

### Arquitectura de directorios en wildfly

  La estructura de directorios sigue la arquitectura de _redhat_, dado que como se ha descrito es una producto gratuito de esta empresa, y en concreto del servicior de aplicaciones ___JBOSS___, de pago.

  Para consultar la estructura de directorios pulsa el siguiente [enlace](https://access.redhat.com/documentation/es-es/jboss_enterprise_application_platform/6.3/html/installation_guide/installation_structure).

  Vamos a centrarnos en la estructura de directorios ___standalone___.



| Nombre |	Propósito |
| ------------- | ------------- |
| _configuration/_ |	Los archivos de configuración para el servidor autónomo. Estos archivos se modifican por medio de la consola de administración y el CLI de administración y no se debe modificar directamente.|
| _deployments/_ | Información sobre los servicios implementados. El servidor autónomo incluye un escaner de implementación de manera que pueda poner los archivadores en este directorio a implementarse. Sin embargo, el enfoque que se recomienda es administrar las implementaciones usando la consola de administración o CLI de administración.|
| _data/_ |	Información sobre los servicios implementados. Los servicios se implementan usando la consola de administración y el CLI de administración en lugar de un escaner de implementación. Por lo tanto no ponga archivos en este directorio manualmente.|
| _log/_ |	Contiene los archivos de registro del tiempo de ejecución para el host y los controladores de procesos, los cuales ejecutan en la instancia local.|
| _lib/_ |	Bibliotecas externas, las cuales pertenecen al modo del servidor autónomo. Vacío por defecto.|
| _tmp/_ |	Contiene datos temporales tales como los archivos que pertenecen al mecanismo de clave compartida que el CLI de administración utiliza para autenticar a los usuarios locales en el servidor.|


### Despliegue de una Aplicación

  Para realizar el despliegue de una aplicación sigue la siguiente [tarea](tareas/despliegue-rest-ws-jboss-wildfly.md).

## Cuota de mercado de Servidores de Aplicaciones con Java

  La cuota de mercado de servidores a _30 de septiembre_ es la que muestra la siguiente imagen.

<div align="center">
  <img src="https://marvel-b1-cdn.bc0a.com/f00000000156946/www.jrebel.com/sites/rebel/files/image/2021-03/application%20server%20java%20technology.png"  />
</div>

<div align="center">
    <a href="README.md"><img src="../../img/before.png" style="width:42px;height:42px;"  />
    <a href="README.md"><img src="../../img/home.png"  style="width:42px;height:42px;" />
    <a href="CONCEPTOS.md"><img src="../../img/next.png" style="width:42px;height:42px;" />
</div>

</div>
