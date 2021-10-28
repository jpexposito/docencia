# Cómo instalar PHP en Ubuntu 20.04

  Vamos a instalar PHP en Ubuntu 20.04 LTS desde los repositorios de la distribución, por lo que previamente actualizaremos las listas de paquetes:

  ```console
    sudo apt update
  ```

## PHP para Apache

  Si usas Apache como servicio web, el paquete que necesitas será libapache2-mod-php:

  ```console
    sudo apt install -y php
  ```

## PHP para Ngnix

  Si usas Nginx, el paquete que necesitas es php-fpm:

  ```console
  sudo apt install -y php-fpm
  ```
  En este caso se instala PHP como servicio independiente, el servicio _php7.4-fpm.service o php7.4-fpm_, que queda iniciado y habilitado para su arranque automático junto a Ubuntu 20.04.

  Será necesario configurar Nginx para conectar con el servicio PHP-FPM, editando su archivo de configuración:

  ```console
    sudo nano /etc/nginx/sites-available/default
  ```

  Buscamos esta sección:

```
...
        # pass PHP scripts to FastCGI server
        #
        #location ~ \.php$ {
        #       include snippets/fastcgi-php.conf;
        #
        #       # With php-fpm (or other unix sockets):
        #       fastcgi_pass unix:/var/run/php/php7.4-fpm.sock;
        #       # With php-cgi (or other tcp sockets):
        #       fastcgi_pass 127.0.0.1:9000;
        #}
...

```
  Activamos el bloque location con la configuración adecuada, en este caso correspondiente al servicio PHP-FPM:
```
...
        # pass PHP scripts to FastCGI server
        #
        location ~ \.php$ {
                include snippets/fastcgi-php.conf;
        #
        #       # With php-fpm (or other unix sockets):
                fastcgi_pass unix:/var/run/php/php7.4-fpm.sock;
        #       # With php-cgi (or other tcp sockets):
        #       fastcgi_pass 127.0.0.1:9000;
        }
...
```
  Y recargamos la configuración de Nginx:

```console
  sudo systemctl reload nginx
```

#### Otras dependencias

  También se incluye PHP para consola, o PHP CLI, con el que podrás comprobar en cualquier momento la versión de PHP instalada en Ubuntu 20.04, usando el comando __php -v__ desde la terminal.

## Cómo probar PHP en Ubuntu 20.04

  Para probar PHP en Ubuntu 20.04 crearemos un pequeño archivo fácilmente accesible vía web:

```console
  sudo nano /var/www/html/info.php
```

  El contenido será únicamente la siguiente línea:

```php
  <?php phpinfo();
```

  Desde un navegador accederemos utilizando la dirección IP o dominio del servidor Ubuntu 20.04, añadiendo la ruta /info.php.

### Configuración de subdominios

  LLeva la misma configuración a los subdominios que hayas creado en tareas anteriores.
