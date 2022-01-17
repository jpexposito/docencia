<div align="justify">

# JENKINS.  

<div align="center">
  <img src="https://i.blogs.es/2f5035/jenkins/1366_2000.png" width="500px" />
</div>

## Introducción

  Al enfrentar tareas técnicas repetitivas, encontrar soluciones de automatización que funcionen puede volverse una tarea en sí. Con Jenkins, un servidor de automatización de código abierto, puede administrar de manera eficiente las tareas, desde la compilación a la implementación de software. Jenkins está basado en Java y puede instalarse desde paquetes de Ubuntu o descargando y ejecutando su archivo de aplicación web (WAR): una colección de archivos que componen una aplicación web completa para ejecutarse en un servidor.

  Ahora veremos la instalación Jenkins en Ubuntu 20.04, iniciaremos el servidor de desarrollo y crearemos un usuario administrativo para que empiece a explorar las funcionalidades de Jenkins.

## Requisitos previos

  Para seguir estos pasos debemos tener:
  - __Un servidor de Ubuntu 20.04__ configurado con un usuario sudo no root y un firewall conforme a la guía de configuración inicial de servidores de Ubuntu 20.04. Recomendamos empezar con al menos 1 GB de RAM. Para asesorarse sobre la planificación de la capacidad de una instalación de Jenkins a escala de producción, consulte las “Recomendaciones de Hardware” de Jenkins.
  - __Open JDK 11__ instalado conforme a nuestros lineamientos sobre la instalación de versiones específicas de OpenJDK en Ubuntu 20.04.

## Paso 1: Instalar Jenkins

  La versión de Jenkins incluida con los paquetes predeterminados de Ubuntu suele ser anterior a la última versión disponible del propio proyecto. Para asegurarse de tener las correcciones y características más recientes, utilice los paquetes que mantiene el proyecto para instalar Jenkins.

  Primero, agrega la clave del repositorio al sistema:

```console
  wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add
```
 Una vez que haya agregado la clave, el sistema devolverá el __resultado OK__.

 A continuación, vamos a anexar la dirección del repositorio de paquetes de Debian a sources.list del servidor:

```console
  sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
```

  Una vez que se hayan ingresado ambos comandos, ejecutaremos update de manera que apt utilice el nuevo repositorio. __REALIZA ESTE PASO SÓLO SI HAY MUCHO TIEMPO QUE NO ACTUALIZAS EL SISTEMA, O TIENES PROBLEMAS EN EL SIGUIENTE PASO__.

  ```console
    sudo apt update
  ```

  Por último, instalaremos Jenkins y sus dependencias.

  ```console
    sudo apt install jenkins
  ```

  Ahora que Jenkins y sus dependencias están instaladas, iniciaremos el servidor de Jenkins.

## Paso 2: Iniciar Jenkins

  Iniciemos Jenkins utilizando systemctl:

```console
  sudo systemctl start jenkins
```

  Debido a que systemctl no muestra un resultado de estado, utilizaremos el comando status para verificar que Jenkins se haya iniciado de forma correcta:

  ```console
  sudo systemctl status jenkins
  ```

  Si todo salió bien, la primera parte del resultado de estado mostrará que el servicio está activo y configurado para iniciarse en el arranque:

```console
Output
● jenkins.service - LSB: Start Jenkins at boot time
   Loaded: loaded (/etc/init.d/jenkins; generated)
   Active: active (exited) since Fri 2022-01-05 21:21:46 UTC; 45s ago
     Docs: man:systemd-sysv-generator(8)
    Tasks: 0 (limit: 1137)
   CGroup: /system.slice/jenkins.service
```   

  Ahora que Jenkins está activo y funcionando, ajustaremos las reglas de nuestro firewall para poder acceder a él desde un navegador web a fin de completar la configuración inicial.

## Paso 3: Abrir el firewall

  Para configurar un firewall UFW, ejecutamos:

  ```console
  sudo ufw allow 8080
  ```

  __Nota__: Si el firewall está desactivado, los siguientes comandos lo activarán y permitirán OpenSSH:

```console
sudo ufw allow OpenSSH
sudo ufw enable
```

  Compruebe el estado de ufw para confirmar las nuevas reglas:

```
sudo ufw status
```

  Observará que se permite el tráfico desde cualquier lugar al puerto 8080:

  ```console
  Output
  Status: active

  To                         Action      From
  --                         ------      ----
  OpenSSH                    ALLOW       Anywhere
  8080                       ALLOW       Anywhere
  OpenSSH (v6)               ALLOW       Anywhere (v6)
  8080 (v6)                  ALLOW       Anywhere (v6)
  ```
  Ahora que instalamos Jenkins y configuramos el firewall, podemos completar la fase de instalación y abocarnos de lleno en la configuración de Jenkins.

## Paso 4: Configurar Jenkins

  Para configurar su instalación, visite Jenkins en su puerto predeterminado, 8080, utilizando su nombre de dominio o dirección IP: http://your_server_or_domain:8080

  Debería ver la pantalla Unlock Jenkins (Desbloquear Jenkins), que muestra la ubicación de la contraseña inicial:

  <div align="center">
    <img src="https://assets.digitalocean.com/articles/jenkins-install-ubuntu-1604/unlock-jenkins.png" width="400px" />
  </div>

  En la ventana de la terminal, utilice el comando cat para mostrar la contraseña:

  ```console
  sudo cat /var/lib/jenkins/secrets/initialAdminPassword
   ```

   Copia la contraseña alfanumérica de 32 caracteres de la terminal, péguela en el campo Administrator password y luego haga clic en Continue.

   En la siguiente pantalla se muestra la opción de instalación de complementos sugeridos o selección de complementos específicos:

   <div align="center">
     <img src="https://assets.digitalocean.com/articles/jenkins-install-ubuntu-1804/customize_jenkins_screen_two.png" width="400px" />
   </div>

   Haremos clic en la opción Install suggested plugins (Instalar los complementos sugeridos), que iniciará de inmediato el proceso de instalación.

  <div align="center">
    <img src="https://assets.digitalocean.com/articles/jenkins-install-ubuntu-1804/jenkins_plugin_install_two.png" width="400px" />
  </div>

    Una vez finalizada la instalación, se le solicitará configurar el primer usuario administrativo. Es posible omitir este paso y continuar como admin utilizando la contraseña inicial que se usó anteriormente, pero nos tomaremos un momento para crear el usuario.

__Nota__: _El servidor predeterminado de Jenkins NO está cifrado, por lo que los datos ingresados con este formulario no están protegidos_.

<div align="center">
  <img src="https://assets.digitalocean.com/articles/jenkins-install-ubuntu-1804/jenkins_create_user.png" width="300px" />
</div>

  Introduzca el nombre y la contraseña de su usuario:

  Creación de usuario de Jenkins

  Configuration (Configuración de instancia) en la que se le solicitará confirmar la URL que prefiere para su instancia de Jenkins. Confirme el nombre de dominio o la dirección IP de su servidor:

  <div align="center">
    <img src="https://assets.digitalocean.com/articles/jenkins-install-ubuntu-1804/instance_confirmation.png" width="300px" />
  </div>

  Después de confirmar la información correspondiente, haga clic en Save and Finish. Como resultado, verá una página de confirmación con el texto “Jenkins is Ready!”, que corrobora que Jenkins está listo:

  <div align="center">
    <img src="https://assets.digitalocean.com/articles/jenkins-install-ubuntu-1804/jenkins_ready_page_two.png" width="300px" />
  </div>

  Haga clic en Start using Jenkins para visitar el panel principal de Jenkins:


  En este punto, habrá completado con éxito la instalación de Jenkins.

  __Ya tenemos arrancada y configurado la herramienta__.
