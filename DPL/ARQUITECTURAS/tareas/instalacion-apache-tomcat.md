<div align="justify">

# Tarea 4: Instalación de Apache-Tomcat en linux

<div align="center">
  <img src="http://tomcat.apache.org/res/images/tomcat.png"  />
</div>


  En esta tarea, instalaremos el servicio web "Apache-Tomcat-10" en Ubuntu 20 como Sistema Operativo, de modo que podremos desplegar aplicaciones Java.


## Requisitos previos

  Necesitará un servidor Ubuntu 20.04 con una cuenta de superusuario no root.

  Además como requisito previo es necesario disponer de __Java__ instalado. Si no sabes como hacerlo, puedes seguir esta [guía](../../../comun/JDK.md).

## Pasos para realizar la instalación en local

### Actualización de los repositorios

  Antes de comenzar, yo diría que cualquier instalación, yo recomiendo siempre actualizar tanto el repositorio como el sistema operativo. De esta manera siempre nos vamos a asegurar que vamos a realizar en este caso instalar __Apache-Tomcat__ en una instalación de ubuntu segura y actualizada.

  Para ello ejecutamos estos dos comandos:

```console
  sudo apt update && sudo apt upgrade
```

### Instalación de Apache-Tomcat

  Vamos a descargar Tomcat 10 para Ubuntu 20.04 LTS desde la página de [descargas](https://tomcat.apache.org/download-10.cgi) del sitio oficial, donde encontraremos la última versión estable.

  Encontraremos el paquete en varios formatos, siendo el más interesante para Ubuntu 20.04 el formato _.tar.gz_, que podremos descargar directamente desde el navegador o, si trabajamos remotamente, desde consola con el comando wget:

  Abra una terminal y ejecute el siguiente comando:

```console
  wget https://downloads.apache.org/tomcat/tomcat-10/v10.0.12/bin/apache-tomcat-10.0.12.tar.gz
```

  Vamos a instalar Tomcat 10 en Ubuntu 20.04 LTS preparando la plataforma como un servicio más que corra en el sistema utilizando su propio usuario y grupo. Hemos de realizar cada uno de los siguientes pasos:
  - Creamos el nuevo usuario tomcat:
```console
sudo useradd -U -m -d /opt/tomcat -k /dev/null -s /bin/false tomcat
```
  - Descomprimimos el paquete que acabamos de descargar directamente en su ubicación definitiva:
```console
  sudo tar xf apache-tomcat-10.0.12.tar.gz -C /opt/tomcat/
```
  - Asignamos como propietario de los archivos de Tomcat 10 el usuario tomcat que hemos creado:

  ```console
    sudo chown -R tomcat: /opt/tomcat/
  ```
  - Renombrar el directorio de instalación. Como el nombre del directorio de instalación de Tomcat 10 contiene números de versión, podemos crear un enlace simbólico sin números para facilitar la instalación y configuración:

  ```console
    sudo ln -s /opt/tomcat/apache-tomcat-10.0.12/ /opt/tomcat/apache-tomcat
  ```
  - Configurar e iniciar el servicio. Para poder lanzar Tomcat 10 como servicio de Ubuntu 20.04 LTS, creamos un archivo de unidad para Systemd:

  ```console
  sudo nano /etc/systemd/system/tomcat10.service
  ```

  El contenido será el siguiente:
  ```console
  [Unit]
  Description=Tomcat 10.0 servlet container para Ubuntu 20.04 LTS
  After=network.target
  [Service]
  Type=forking
  User=tomcat
  Group=tomcat
  Environment="JAVA_OPTS=-Djava.security.egd=file:///dev/urandom"
  Environment="CATALINA_BASE=/opt/tomcat/apache-tomcat"
  Environment="CATALINA_HOME=/opt/tomcat/apache-tomcat"
  Environment="CATALINA_PID=/opt/tomcat/apache-tomcat/temp/tomcat.pid"
  Environment="CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC"
  ExecStart=/opt/tomcat/apache-tomcat/bin/startup.sh
  ExecStop=/opt/tomcat/apache-tomcat/bin/shutdown.sh
  [Install]
  WantedBy=multi-user.target
```

  - Iniciar el Servicio. Una vez guardado el archivo, podemos iniciar el servicio con el comando __systemctl__.
  ```console
    sudo systemctl start tomcat10
  ```
  - Verificar el estado del servicio. Vamos a verificar el estado del servicio. Para ello usaremos el comando systemctl status tomcat10:
  ```console
  systemctl status tomcat10
  ```  
  - Inicio automático del servicio. Si queremos que Tomcat 10 inicie automáticamente en cada arranque de Ubuntu 20.04, tendremos que habilitar el servicio:
  ```console
  sudo systemctl enable tomcat10
  ```

### Acceso a Apache-Tomcat

Para acceder a Tomcat 10 en Ubuntu 20.04 desde un navegador web indicaremos la dirección del servidor (IP, nombre DNS, dominio, etc.) y el puerto de conexión, el 8080 por defecto. Y tendremos desplegado Apache-Tomcat.

<div align="center">
  <img src="https://www.tomares.es/sites/default/files/styles/915x430/public/2018082016063450809_.jpg?itok=ZoAdyoCq"  />
</div>


#### Problemas de acceso a Apache-Tomcat

  Cabe la posibilidad de que puedas experimentar problemas de acceso debido a que el puerto se encuentra ocupado, por otra aplicación. Si fuera este el caso, debes de realizar el cambio de puerto, del _8080_ a _8082_, de forma similar a:

  - Cambia el puerto en _server.xml_
  ```console
  <Connector port="8080"       //Change this
              protocol="HTTP/1.1"
              connectionTimeout="20000"
              redirectPort="8443"
  />
  ```

  y sustituye por:
  ```console
  <Connector port="8082"       //Change this
              protocol="HTTP/1.1"
              connectionTimeout="20000"
              redirectPort="8443"
  />
  ```
  Más información [aquí](https://linuxhint.com/change-default-port-of-tomcat-server/), y realizando un poco de investigación a la hora de resolver cualquier problema.

## Cómo añadir usuarios a Tomcat

  Esto es algo bastante sencillo. Para añadir usuarios con capacidad de administrar las aplicaciones desplegadas en nuestro Tomcat sin tener que reiniciar el sevidor, debemos hacer lo siguiente:
  - Acceder al fichero conf/tomcat-users.xml
  - Buscar la etiqueta
  ```
  <tomcat-users>
  ```
  - Justo debajo de la etiqueta añadiremos una entrada parecida a la siguiente (recuerda cambiar la contraseña):
  ```console
  <user username="admin" password="admin" roles="manager-gui" />
  ```

## Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la instalación y se muestre la instalación de __Apache-Tomcat__.

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
