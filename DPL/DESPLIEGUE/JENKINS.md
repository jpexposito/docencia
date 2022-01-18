<div align="justify">

# JENKINS.  

<div align="center">
  <img src="https://i.blogs.es/2f5035/jenkins/1366_2000.png" width="500px" />
</div>

## Introducción

  Al enfrentar tareas técnicas repetitivas, encontrar soluciones de automatización que funcionen puede volverse una tarea en sí. Con Jenkins, un servidor de automatización de código abierto, puede administrar de manera eficiente las tareas, desde la compilación a la implementación de software. Jenkins está basado en Java y puede instalarse desde paquetes de Ubuntu o descargando y ejecutando su archivo de aplicación web (WAR): una colección de archivos que componen una aplicación web completa para ejecutarse en un servidor.

## Instalación en Ubuntu

  Ahora veremos la instalación Jenkins en Ubuntu 20.04, iniciaremos el servidor de desarrollo y crearemos un usuario administrativo para que empiece a explorar las funcionalidades de Jenkins.

### Requisitos previos

  Para seguir estos pasos debemos tener:
  - __Un servidor de Ubuntu 20.04__ configurado con un usuario sudo no root y un firewall conforme a la guía de configuración inicial de servidores de Ubuntu 20.04. Recomendamos empezar con al menos 1 GB de RAM. Para asesorarse sobre la planificación de la capacidad de una instalación de Jenkins a escala de producción, consulte las “Recomendaciones de Hardware” de Jenkins.
  - __Open JDK 11__ instalado conforme a nuestros lineamientos sobre la instalación de versiones específicas de OpenJDK en Ubuntu 20.04.

### Paso 1: Instalar Jenkins

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

### Paso 2: Iniciar Jenkins

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

### Paso 3: Abrir el firewall

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

### Paso 4: Configurar Jenkins

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

## Instalación de Jenkins en Docker

  Vamos a realizar la misma instalación de _Jenkins_ a través de __Docker__.

### Requisitos

  - Tener docker instalado.
  - Tener docker-compose instalado.

### Paso 5: Seleccionar la imagen de Jenkins en Docker Hub

  - Dirígite a [https://hub.docker.com/](https://hub.docker.com/) y buscar la imagen oficial de la herramienta Jenkins para ejecutar dentro de un contenedor Docker.

  <div align="center">
    <img src="https://www.pragma.com.co/hs-fs/hubfs/academia/Lecciones/Jenkins/Jenkins1.png?width=1200&name=Jenkins1.png" width="300px" />
  </div>

  - Descarga la imagen de Jenkins para Docker en tu ordenador de manera local. Ejecuta el siguiente comando.

  ```console
    docker pull jenkins/jenkins:lts
  ```

  - Verifica que la imagen se ha descargado correctamente.

  ```console
    docker images
  ```

  </br>

  <div align="center">
    <img src="https://www.pragma.com.co/hs-fs/hubfs/academia/Lecciones/Jenkins/Jenkins2.png?width=1200&name=Jenkins2.png" width="300px" />
  </div>

  </br>

  - Ahora ejecuta __jenkins__ como contenedor Docker __exponiendolo__ en el puerto __8080__ de tu ordenador local. Verifica __/your/home:/...__.

  ```console
  docker run -p 8080:8080 -p 50000:50000 -v /your/home:/var/jenkins_home jenkins/jenkins:lts
  ```
  - Verifica que puedas ingresar al contenedor a través del navegador web de tu preferencia.

  <div align="center">
    <img src="https://www.pragma.com.co/hs-fs/hubfs/academia/Lecciones/Jenkins/Jenkins4.png?width=1200&name=Jenkins4.png" width="300px" />
  </div>
  </br>

  Continua a través del __paso 4__.

  ___La instalación se puede realizar de una forma más eficiente, si tenemos en cuenta que es muy posible que queramos combinarlo con otras herramientas___.

## Instalación de Jenkins a través de Docker y Docker-Compose.

### Vamos a construir nuestra propia imagen con Jenkins.

  Lo primero que tenemos que hacer para construir nuestra propia imagen con Jenkins es escribir el fichero Dockerfile que contendrá las instrucciones para construir nuestra imagen.

  ```
  FROM jenkins/jenkins

  USER root
  RUN apt-get -y update && apt-get install -y maven

  USER jenkins
  COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
  RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

  ```

#### Repaso de Dockerfile

  A continuación, repasamos para que sirven las distintas líneas del fichero Dockerfile:

  - __En la línea 1__ se indica la imagen base de la que se parte para construir la nueva imagen. ___Utilizamos la misma que anteriormente___.
  - __En la línea 4__ instalamos Maven utilizando comandos apt-get. Estos comandos deben ejecutarse como usuario root. Indicamos que el usuario de ejecución es root en la línea 3.
  Tras ejecutarse los comandos apt-get, el resto de comandos pueden ejecutarse con el usuario jenkins. Establecemos el nuevo usuario de ejecución en la línea 6.
  - __En la línea 7__ copiamos el fichero plugins.txt en el directorio /usr/share/jenkins/ref/. Este fichero contiene la lista de plugins que queremos que se instalen en Jenkins.
  En la última línea se ejecuta el script install-plugins.sh que toma como entrada la lista de plugins incluidos en el fichero plugins.txt y los instala en Jenkins. Este script viene incluido en la imagen __jenkins/jenkins__.

#### Plugins.txt
  En el fichero __plugins.txt__ incluimos cada plugin que queremos que se instale en Jenkins. Se incluye un plugin por línea, tal y como puede verse a continuación:

  ```
  ace-editor
  analysis-core
  ant
  antisamy-markup-formatter
  apache-httpcomponents-client-4-api
  authentication-tokens
  branch-api
  build-monitor-plugin
  build-pipeline-plugin
  checkstyle
  cloudbees-folder
  conditional-buildstep
  copyartifact  
  credentials
  credentials-binding
  deploy
  display-url-api
  docker-commons
  docker-workflow
  durable-task
  findbugs
  git
  github
  github-api
  git-client
  git-server
  gradle
  greenballs
  handlebars
  jackson2-api
  javadoc
  jquery
  jquery-detached
  jsch
  junit
  mailer
  matrix-project
  maven-plugin
  momentjs
  nested-view
  parameterized-trigger
  pipeline-build-step
  pipeline-graph-analysis
  pipeline-input-step
  pipeline-milestone-step
  pipeline-model-api
  pipeline-model-declarative-agent
  pipeline-model-definition
  pipeline-model-extensions
  pipeline-rest-api
  pipeline-stage-step
  pipeline-stage-tags-metadata
  pipeline-stage-view
  plain-credentials
  pmd
  run-condition
  scm-api
  script-security  
  ssh-credentials
  structs
  token-macro
  workflow-aggregator
  workflow-api
  workflow-basic-steps
  workflow-cps
  workflow-cps-global-lib
  workflow-durable-task-step
  workflow-job
  workflow-multibranch
  workflow-scm-step
  workflow-step-api
  workflow-support
  ```
#### docker-compose.yml

  Escribimos un fichero docker-compose.yml:

```
version: '3'
services:
  master:
    build: jenkins
    image: dpl/jenkins:latest
    restart: unless-stopped
    hostname: jenkins
    ports:
      - "8080:8080"
      - "50000:50000"
    volumes:
      - jenkins_home:/var/jenkins_home

volumes:
  jenkins_home:
```  
Indico a continuación para que sirven las líneas más relevantes de este fichero:
  - __En la línea 4__ indicamos el directorio sobre el que se va a construir la imagen. En este caso __jenkins__, siendo un subdirectorio de donde se encuentra el fichero _docker-compose.yml_.
  - __En la línea 5__ indicamos el nombre de nuestra imagen. Podéis cambiar __dpl/jenkins:latest__ por el nombre que le queráis dar a vuestra propia imagen con Jenkins.
  - __En la línea 6__ se establece que se reinicie el contenedor a menos que se detenga explícitamente o el motor de Docker se detenga o reinicie.
  - __En la línea 7__ indicamos el hostname del contenedor.
  - __En las líneas 9 y 10__ se exponen los puertos __8080__ y __50000__ respectivamente.
  - __Las líneas de la 12 a la 15__ sirven para definir el volumen _jenkins_home_. Este volumen se utiliza para que los cambios que realicemos en la configuración de Jenkins persistan incluso tras la destrucción del contenedor.

### Construcción de la imagen

  Para construir la imagen ejecutamos el siguiente comando:

  ```
  docker-compose build
  ```
  Para arrancar el contenedor con Jenkins ejecutamos el siguiente comando:
  ```
  docker-compose up –d
  ```
  Una vez arrancado el contenedor, abrimos un navegador web y accedemos a http://localhost:8080 para entrar en la consola de administración de Jenkins.

  Para obtener la contraseña del usuario admin de Jenkins ejecutamos el siguiente comando:

  ```
  docker exec -it dockerjenkins_master_1 cat /var/jenkins_home/secrets/initialAdminPassword
  ```
