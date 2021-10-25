<div align="justify">

# Cómo instalar Nginx en Linux

## Introducción
  
  Nginx es uno de los servidores web más populares del mundo y aloja algunos de los sitios más grandes y con mayor tráfico en Internet. Es una opción ligera que se puede utilizar como servidor web o proxy inverso.

  En esta guía, explicaremos cómo instalar Nginx en su servidor de Ubuntu 20.04, adaptar el firewall, administrar el proceso de Nginx y configurar bloques de servidor para alojar más de un dominio desde un solo servidor.

## Requisitos previos

  Antes de comenzar a aplicar esta guía, debe tener un non-root user normal con privilegios sudo configurado en su servidor. Para obtener información sobre cómo configurar una cuenta de usuario regular consulte nuestra Guía de configuración inicial del servidor para Ubuntu 20.04.

  Cuando disponga de una cuenta, inicie sesión como non-root user para comenzar.

## Paso 1: Instalar Nginx

  Debido a que Nginx está disponible en los repositorios predeterminados de Ubuntu, es posible instalarlo desde estos repositorios usando el sistema de paquetes apt.

  Siempre que realizamos una instalación dentro del servicior, hemos de ejecutar el siguiente comando, actualizando nuestro índice local de paquetes de modo que tengamos acceso a los listados de paquetes más recientes:

  ```console
    sudo apt update
  ```

  Podremos instalar nginx, ejecutando:

  ```console
    sudo apt install nginx
  ```

  Tras aceptar el procedimiento, apt instalará Nginx y cualquier dependencia necesaria en su servidor.

  Otros pasos para la instalación de [Nginx](https://access.redhat.com/documentation/es-es/red_hat_enterprise_linux/8/html/deploying_different_types_of_servers/setting-up-and-configuring-nginx_deploying-different-types-of-servers#installing-and-preparing-nginx_setting-up-and-configuring-nginx).


### Paso 2: Aplicar ajustes al firewall

  Antes de probar Nginx, se deben aplicar ajustes al software del firewall para permitir el acceso al servicio. Nginx se registra de forma automática como un servicio con ufw tras la instalación, lo que hace que sea sencillo permitir el acceso de Nginx.

  Enumere las configuraciones de la aplicación con las que ufw sabe trabajar escribiendo lo siguiente:

  ```console
    sudo ufw app list
  ``` 
  Debería obtener un listado de los perfiles de aplicación:

  ```console
  Output
  Available applications:
    Nginx Full
    Nginx HTTP
    Nginx HTTPS
    OpenSSH
  ```  
  
  Como se muestra en el resultado, hay tres perfiles disponibles para Nginx:
  - _Nginx Full_: este perfil abre el puerto 80 (tráfico web normal, no cifrado) y el puerto 443 (tráfico TLS/SSL cifrado)
  _ _Nginx HTTP_: este perfil abre solo el puerto 80 (tráfico web normal, no cifrado)
  _ _Nginx HTTPS_: este perfil abre solo el puerto 443 (tráfico TLS/SSL cifrado)

  Se recomienda habilitar el perfil más restrictivo, que de todos modos permitirá el tráfico que configuró. En este momento, solo tendremos que permitir el tráfico en el puerto 80.

  Puede habilitarlo escribiendo lo siguiente:
  
  ```console
    sudo ufw allow 'Nginx HTTP'
   ```

  Puede verificar el cambio escribiendo lo siguiente:
  
  ```console
    sudo ufw status
   ```

  El resultado indicará el tráfico de HTTP que se permite:
  
  ```console
    Status: active

    To                         Action      From
    --                         ------      ----
    OpenSSH                    ALLOW       Anywhere                  
    Nginx HTTP                 ALLOW       Anywhere                  
    OpenSSH (v6)               ALLOW       Anywhere (v6)             
    Nginx HTTP (v6)            ALLOW       Anywhere (v6)
  ```  

## Paso 3: Comprobar su servidor web

  Al final del proceso de instalación, Ubuntu 20.04 inicia Nginx. El 
servidor web ya debería estar activo.

  Realice una verificación con systemd init para asegurarse de que el servicio esté en ejecución escribiendo lo siguiente:

  ```console
    systemctl status nginx
  ```

   Con la siguiente salida:
  
  ```console
    ● nginx.service - A high performance web server and a reverse proxy server
       Loaded: loaded (/lib/systemd/system/nginx.service; enabled; vendor preset: enabled)
       Active: active (running) since Fri 2020-04-20 16:08:19 UTC; 3 days ago
         Docs: man:nginx(8)
     Main PID: 2369 (nginx)
        Tasks: 2 (limit: 1153)
       Memory: 3.5M
       CGroup: /system.slice/nginx.service
               ├─2369 nginx: master process /usr/sbin/nginx -g daemon on; master_process on;
               └─2380 nginx: worker process
  ```
           
  Como lo confirma este resultado, el servicio se inició correctamente. Sin embargo, la mejor forma de comprobarlo es solicitar una página de Nginx.

  Puede acceder a la página de aterrizaje predeterminada de Nginx para confirmar que el software funcione correctamente dirigiéndose a la dirección IP de su servidor. Si no conoce la dirección IP de su servidor, puede buscarla con la herramienta icanhazip.com, que le proporcionará su dirección IP pública tal como la recibió de otra ubicación en Internet:

  ```console
    curl -4 icanhazip.com
  ```

  Cuando tenga la dirección IP de su servidor, introdúzcala en la barra de direcciones de su navegador:

  ```console
    http://your_server_ip
  ```  

  __Debería de mostrar que se ejecuta correctamente Nginx.__


  Si está en esta página, su servidor se está ejecutando correctamente y está listo para ser administrado.

## Paso 4: Administrar el proceso de Nginx

  Ahora que su servidor web está listo, revisaremos algunos de los comandos básicos de administración.

  Para detener su servidor web, escriba lo siguiente:

  ```console
    sudo systemctl stop nginx
  ```
 
  Para iniciar el servidor web cuando no esté activo, escriba lo siguiente:
  
  ```console
    sudo systemctl start nginx
  ```

  Para detener y luego iniciar el servicio de nuevo, escriba lo siguiente:

 ```console
  sudo systemctl restart nginx
  ```

  Si solo está realizando cambios en la configuración, Nginx a menudo puede volver a cargase sin perder las conexiones. Para hacer esto, escriba lo siguiente:

   ```console
    sudo systemctl reload nginx
   ```
  
  De forma predeterminada, Nginx está configurado para iniciarse automáticamente cuando lo haga el servidor. Si no es lo que quiere, deshabilite este comportamiento escribiendo lo siguiente:

  ```console
    sudo systemctl disable nginx
  ```
  
  Para volver a habilitar el servicio de modo que se cargue en el inicio, puede escribir lo siguiente:

  ```console
    sudo systemctl enable nginx
  ```
  
  Ya aprendió los comandos de administración básicos y debería estar listo para configurar el sitio para alojar más de un dominio.

## Paso 5: Configurar bloques de servidor (recomendado)

  Al emplear el servidor web Nginx, se pueden utilizar bloques de servidor (similares a hosts virtuales de Apache) para encapsular los detalles de la configuración y alojar más de un dominio desde un único servidor. Configuraremos un dominio llamado your_domain, pero debería cambiarlo por su propio nombre de dominio. Para obtener más información sobre cómo configurar un nombre de dominio con DigitalOcean, consulte nuestra Introducción al DNS de DigitalOcean.

  Nginx en Ubuntu 20.04 tiene habilitado un bloque de servidor por defecto, que está configurado para suministrar documentos desde un directorio en /var/www/html. Si bien esto funciona bien para un solo sitio, puede ser difícil de manejar si aloja varios. En vez de modificar /var/www/html, vamos a crear una estructura de directorios dentro de /var/www para nuestro sitio your_domain y dejaremos /var/www/html como directorio predeterminado que se suministrará si una solicitud de cliente no coincide con otros sitios.

  Cree el directorio para your_domain como se muestra a continuación, usando el indicador -p para crear cualquier directorio principal necesario:

```console
  sudo mkdir -p /var/www/your_domain/html
``` 
  
  A continuación, asigne la propiedad del directorio con la variable de entorno $USER:

```console
  sudo chown -R $USER:$USER /var/www/your_domain/html
``` 
  
  Los permisos de los roots web deberían ser correctos si no modificó el valor umask, que establece permisos de archivos predeterminados. Para asegurarse de que sus permisos sean correctos y permitir al propietario leer, escribir y ejecutar los archivos, y a la vez conceder solo permisos de lectura y ejecución a los grupos y terceros, puede ingresar el siguiente comando

 ```console
  sudo chmod -R 755 /var/www/your_domain
 ``` 
  
  A continuación, cree una página de ejemplo index.html utilizando nano o su editor favorito:
 
 ```console
    nano /var/www/your_domain/html/index.html
 ```

  Dentro de ella, agregue el siguiente ejemplo de HTML:

 ```console
    /var/www/your_domain/html/index.html
    <html>
        <head>
            <title>Welcome to your_domain!</title>
        </head>
        <body>
            <h1>Success!  The your_domain server block is working!</h1>
        </body>
    </html>
```

  Cuando termine, escriba CTRL y X, y luego, Y y ENTER, para guardar y cerrar el archivo.

  Para que Nginx presente este contenido, es necesario crear un bloque de servidor con las directivas correctas. En vez de modificar el archivo de configuración predeterminado directamente, crearemos uno nuevo en /etc/nginx/sites-available/your_domain:

 ```console
  sudo nano /etc/nginx/sites-available/your_domain
 ```

  Péguelo en el siguiente bloque de configuración, similar al predeterminado, pero actualizado para nuestro nuevo directorio y nombre de dominio:

 ```console
    /etc/nginx/sites-available/your_domain
    server {
            listen 80;
            listen [::]:80;

            root /var/www/your_domain/html;
            index index.html index.htm index.nginx-debian.html;

            server_name your_domain www.your_domain;

            location / {
                    try_files $uri $uri/ =404;
            }
    }
  ```
___REALIZA ESTE PROCEDIMIENTO SOBRE UN PUERTO DISPONIMBLE, POR EJEMPLO 8084___.


  Más información en el siguiente [enlace](https://access.redhat.com/documentation/es-es/red_hat_enterprise_linux/8/html/deploying_different_types_of_servers/configuring-nginx-as-a-web-server-that-provides-different-content-for-different-domains_setting-up-and-configuring-nginx).

  Observe que actualizamos la configuración root en nuestro nuevo directorio y el server_name para nuestro nombre de dominio.

  A continuación, habilitaremos el archivo creando un enlace entre él y el directorio sites-enabled, en el cual Nginx obtiene lecturas durante el inicio:

 ```console
  sudo ln -s /etc/nginx/sites-available/your_domain /etc/nginx/sites-enabled/
 ```
 
  Ahora, contamos con dos bloques de servidor habilitados y configurados para responder a las solicitudes conforme a las directivas listen y server_name (puede obtener más información sobre cómo Nginx procesa estas directivas aquí):
  - __your_domain__: responderá a las solicitudes de your_domain y www.your_domain.
  - __default__: responderá a cualquier solicitud en el puerto 80 que no coincida con los otros dos bloques.
  
  Para evitar un problema de memoria de depósito de hash que pueda surgir al agregar nombres de servidor, es necesario aplicar ajustes a un valor en el archivo _/etc/nginx/nginx.conf_. Abra el archivo:
 
  ```console
    sudo nano /etc/nginx/nginx.conf
  ```

  Encuentre la directiva server_names_hash_bucket_size y borre el símbolo # para eliminar el comentario de la línea. Si utiliza nano, presione CTRL y w para buscar rápidamente palabras en el archivo.
 
 ```console
  /etc/nginx/nginx.conf
 ```

 ```console 
  http {
    ...
    server_names_hash_bucket_size 64;
    ...
  }
  ...
  ```

  Guarde y cierre el archivo cuando termine.

  A continuación, compruebe que no haya errores de sintaxis en ninguno de sus archivos de Nginx:

 ```console
  sudo nginx -t
 ``` 

  Si no hay problemas, reinicie Nginx para habilitar los cambios:
 
 ```console
  sudo systemctl restart nginx
 ```
  
  Con esto, Nginx debería proporcionar su nombre de dominio. Puede probarlo visitando http://your_domain, donde debería ver algo como esto:


## Paso 6: Familiarizarse con archivos y directorios importantes de Ngnix

  Ahora que sabe administrar el propio servicio de Nginx, debería tomarse unos minutos para familiarizarse con algunos directorios y archivos importantes:
  - __/var/www/html__: el contenido web real, que por defecto solo consta de la página predeterminada de Nginx que vio antes, se presenta desde el directorio /var/www/html. Esto se puede cambiar modificando los archivos de configuración de Nginx.
  - __/etc/nginx__: directorio de configuración de Nginx. En él se encuentran todos los archivos de configuración de Nginx.
  - __/etc/nginx/nginx.conf__: archivo de configuración principal de Nginx. Esto se puede modificar para realizar cambios en la configuración general de Nginx.
  - __/etc/nginx/sites-available/__: directorio en el que se pueden guardar bloques de servidor por sitio. Nginx no utilizará los archivos de configuración de este directorio a menos que estén vinculados al directorio sites-enabled. Normalmente, toda la configuración del bloque de servidor se realiza en este directorio y luego se habilita estableciendo un vínculo con el otro directorio.
  - __/etc/nginx/sites-enabled/__: directorio en el que se almacenan los bloques de servidor habilitados por sitio. Normalmente, estos se crean estableciendo vínculos con los archivos de configuración del directorio sites-available.
  - __/etc/nginx/snippets__: este directorio contiene fragmentos de configuración que pueden incluirse en otras partes de la configuración de Nginx. Los segmentos de configuración potencialmente repetibles reúnen las condiciones para la conversión a fragmentos.
  - __/var/log/nginx/access.log__: cada solicitud a su servidor web se registra en este archivo de registro, a menos que Nginx esté configurado para hacer algo diferente.
  - __/var/log/nginx/error.log__: cualquier error de Nginx se asentará en este registro.

  Una vez instalado su servidor web, tiene muchas opciones respecto del tipo de contenido que ofrecerá y de las tecnologías que desee usar para crear una experiencia más completa.

## Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la instalación y se muestre la instalación de __Nginx__.

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

</div>