<div align="justify">

# Tarea 2: Instalación de Apache en linux

<div align="center">
  <img src="https://httpd.apache.org/images/httpd_logo_wide_new.png"  />
</div>


  En esta tarea, instalaremos el servicio web Apache en un nuevo Servidor Cloud con Ubuntu 20 como Sistema Operativo.

  __Apache__ es un popular servidor web multiplataforma de código abierto que, según los números, es el servidor web más popular que existe. Soportado por plataformas Unix, Microsoft Windows, Mac entre otras.

## Requisitos previos

  Necesitará un servidor Ubuntu 20.04 con una cuenta de superusuario no root.

  Habilitar los puertos necesarios para el servicio apache.

## Pasos para realizar la instalación en local

### Actualización de los repositorios

  Antes de comenzar, yo diría que cualquier instalación, yo recomiendo siempre actualizar tanto el repositorio como el sistema operativo. De esta manera siempre nos vamos a asegurar que vamos a realizar en este caso instalar __Apache__ en una instalación de ubuntu segura y actualizada.

  Para ello ejecutamos estos dos comandos:

```console
  sudo apt update && sudo apt upgrade
```

### Instalación de Apache

  Abra una terminal y ejecute el siguiente comando:

```console
  sudo apt install apache2
```

  nos podremos encontrar con un problema similar a este:

```console
apache2.service: Control process exited, code=exited, status=1/FAILURE
systemd[1]: apache2.service: Failed with result 'exit-code'.
systemd[1]: Failed to start The Apache HTTP Server.
```
  el movido será el siguiente:

```console
  (98)Address already in use: AH00072: make_sock: could not bind to address 0.0.0.0:80
```

  Debemos realizar los siguientes cambios:

```console
  sudo vi /etc/apache2/ports.conf
```

  cambia: __Listen 80__ a __Listen 8081__ y

  ```console
    sudo vi /etc/apache2/sites-enabled/000-default.conf
  ```
  cambia: __<VirtualHost: *:80>__ a __<VirtualHost: *:8081>__.

  El problema como comprenderás es que se ha producido un conflicto de puertos ya que tanto __GitLab__ como __Apache__, utilizan el mismo puerto.

  Ejecuta los siguientes comandos para reiniciar los servicios_

```console
sudo systemctl restart apache2
sudo service apache2 restart
```
  y a continuación, ajustamos la configuración del Firewall, en este caso Ubuntu usa por defecto UFW (Uncomplicated Firewall) que será utilizado en esta guía (En caso no haya sido instalado aún, puede realizarlo desde aquí). Usaremos el siguiente comando para verificar los perfiles por defecto para Apache en UFW:

```console
  sudo ufw app list
```

  hasta finalizar con un  mensaje similar a:
```console
  Available applications:
    Apache
    Apache Full
    Apache Secure
    OpenSSH
```

| Aplicación | Descripción |
| ------------- | ------------- |
| Apache  | Apertura solo del puerto 80, que permite trafico sin cifrar (No seguro).  |
| Apache Full  | Apertura tanto del puerto 80 como del puerto 443, permitiendo el tráfico cifrado (Seguro) |
| Apache Secure  | Apertura solo del puerto 443, permitiendo conexiones seguras (HTTPS) |

Para esta tarea usaremos el perfil Apache, ya que no será necesario usar una conexión cifrada.

```console
  sudo ufw allow 'Apache'
```

  Verificamos los perfiles activos:

```console
  sudo ufw status
```

  Resultado:

  ```console
  Status: active
  To             Action         From
  --             ------         ----
  Apache         ALLOW          Anywhere
  Apache (v6)    ALLOW          Anywhere (v6)
  ```
  Si fuera inactivo debes de ejecutar la siguiente instrucción:

  ```console
    sudo ufw enable
  ```
  y damos el __Y__.

  Ejecutando el mismo comando __sudo ufw status__, debemos de obtener el resultado esperado.


  Ahora verificamos que el servicio Apache esté ejecutándose correctamente, con el siguiente comando:

```console
  sudo systemctl status apache2
```

  Resultado:

```console
● apache2.service - The Apache HTTP Server
   Loaded: loaded (/lib/systemd/system/apache2.service; enabled; vendor preset: enabled)
   Active: active (running) since Tue 2021-10-05 16:11:23 WEST; 3min 2s ago
     Docs: https://httpd.apache.org/docs/2.4/
  Process: 3081 ExecStart=/usr/sbin/apachectl start (code=exited, status=0/SUCCESS)
 Main PID: 3100 (apache2)
    Tasks: 55 (limit: 4681)
   Memory: 7.2M
   CGroup: /system.slice/apache2.service
           ├─3100 /usr/sbin/apache2 -k start
           ├─3101 /usr/sbin/apache2 -k start
           └─3102 /usr/sbin/apache2 -k start
```
### Acceso

  Si obtienes el mismo resultado, puedes confirmar que el servicio se está ejecutando correctamente. También puedes acceder desde el navegador ingresando la IP publica del servidor:

  __http://tu_ip:8081__ o __localhost:8081__.

  Donde debería de mostrarte el mensaje de Bienvenida de Apache detallando de manera muy breve los directorios y archivos de configuración.

## Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la instalación y se muestre la instalación de __Apache__.

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
