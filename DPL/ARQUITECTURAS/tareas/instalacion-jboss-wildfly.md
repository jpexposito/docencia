<div align="justify">

# Tarea 6: Instalación de Wildfly en linux

<div align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/a/a3/Wildfly_logo.png"  />
</div>


  En esta tarea, instalaremos el contenedor de aplicaciones __Wildfly__ en _Ubuntu 20.04_, de modo que podremos desplegar aplicaciones [JAVA](../../../comun/JDK.md).


## Requisitos previos

  Necesitará un servidor Ubuntu 20.04 con una cuenta de _superusuario_ no root.

  Además como requisito previo es necesario disponer de __Java__ instalado. Si no sabes como hacerlo, puedes seguir esta [guía](../../../comun/JDK.md).

  Además y para ir adelantando para siguientes tareas, debes realizar la instalación de [MAVEN](../../../comun/MAVEN.md).

## Pasos para realizar la instalación en local

### Actualización de los repositorios

  Antes de comenzar, yo diría que cualquier instalación, yo recomiendo siempre actualizar tanto el repositorio como el sistema operativo. De esta manera siempre nos vamos a asegurar que vamos a realizar en este caso instalar __Wildfly__ en una instalación de ubuntu segura y actualizada.

  Para ello ejecutamos estos dos comandos:

```console
  sudo apt update && sudo apt upgrade
```

### Instalación de WildFly

  Vamos a descargar _Wildfly_  para Ubuntu 20.04 LTS desde la página de [descargas](https://www.wildfly.org/) del sitio oficial, donde encontraremos la última versión estable.

  Encontraremos el paquete en varios formato _ZIP_, que podremos descargar directamente desde el navegador o, si trabajamos remotamente, desde consola con el comando wget:

  Abra una terminal y ejecute el siguiente comando:

```console
  wget https://github.com/wildfly/wildfly/releases/download/25.0.0.Final/wildfly-25.0.0.Final.zip
```

  Vamos a instalar Wildfly 10 en Ubuntu 20.04 LTS preparando la plataforma como un servicio más que corra en el sistema utilizando su propio usuario y grupo. Hemos de realizar cada uno de los siguientes pasos:
  - Creamos el nuevo grupo y usuario wildfly:  
```console
sudo groupadd -r wildfly
sudo useradd -r -g wildfly -d /opt/wildfly -s /sbin/nologin wildfly
```
  - Descomprimimos el paquete que acabamos de descargar directamente en su ubicación definitiva:
```console
sudo tar xf /tmp/wildfly-25.0.0.Final.zip -C /opt/
```
  - Creamos un link simbólico al directorio:

  ```console
  sudo ln -s /opt/wildfly-25.0.0.Final.zip /opt/wildfly

  ```
  - Damos acceso al usuario y grupo wildfly:

  ```console
    sudo chown -RH wildfly: /opt/wildfly
  ```
  - Configurar e iniciar el servicio. :

  ```console
  sudo mkdir -p /etc/wildfly

sudo cp /opt/wildfly/docs/contrib/scripts/systemd/wildfly.conf /etc/wildfly/

sudo nano /etc/wildfly/wildfly.conf

**WILDFLY_BIND=0.0.0.0**

sudo cp /opt/wildfly/docs/contrib/scripts/systemd/launch.sh /opt/wildfly/bin/

sudo sh -c 'chmod +x /opt/wildfly/bin/*.sh'

sudo cp /opt/wildfly/docs/contrib/scripts/systemd/wildfly.service /etc/systemd/system/

sudo systemctl daemon-reload

```

  - Iniciar el Servicio. Una vez guardado el archivo, podemos iniciar el servicio con el comando __systemctl__.
  ```console
    sudo systemctl start wildfly
  ```
  - Verificar el estado del servicio. Vamos a verificar el estado del servicio. Para ello usaremos el comando systemctl status wildfly:
  ```console
  sudo systemctl status wildfly
  ```  
  - Inicio automático del servicio. Si queremos que wildfly inicie automáticamente en cada arranque de Ubuntu 20.04, tendremos que habilitar el servicio:
  ```console
  sudo systemctl enable wildfly
  ```

### Configurar a Wildfly

  Vamos a permitir el tráfico por un puerto específico, por ejemplo el puerto __8083__:
  ```console
  sudo ufw allow 8083/tcp
  ```

### Acceso a Wildfly

Para acceder a Wildfly en Ubuntu 20.04 desde un navegador web indicaremos la dirección del servidor (IP, nombre DNS, dominio, etc.) y el puerto de conexión, el __8083__. Y tendremos desplegado Wildfly.

<div align="center">
  <img src="https://www.desatatupotencial.org/wp-content/uploads/2020/11/apps-magia-iphone-ipad.jpg"  />
</div>

## Cómo añadir usuarios a WildFly

  Esto es algo bastante sencillo. Para añadir usuarios con capacidad de administrar las aplicaciones desplegadas en nuestro WildFly, debemos hacer lo siguiente:
  - Creamos el usuario administrador
  ```comsole
  sudo /opt/wildfly/bin/add-user.sh
  ```
  - Seleccionamos la opción __a__, indicando que es un usuario de __gestión__.
  - Obtendremos un mensaje similar al siguiente:
```console
$ ./add-user.sh

What type of user do you wish to add?
 a) Management User (mgmt-users.properties)
 b) Application User (application-users.properties)
(a): a

Enter the details of the new user to add.
Using realm 'ManagementRealm' as discovered from the existing property files.
Username : admin123
Password recommendations are listed below. To modify these restrictions edit the add-user.properties configuration file.
 - The password should be different from the username
 - The password should not be one of the following restricted values {root, admin, administrator}
 - The password should contain at least 8 characters, 1 alphabetic character(s), 1 digit(s), 1 non-alphanumeric symbol(s)
Password :
Re-enter Password :
What groups do you want this user to belong to? (Please enter a comma separated list, or leave blank for none)[  ]:
About to add user 'admin123' for realm 'ManagementRealm'
Is this correct yes/no? yes
Added user 'admin123' to file
 value="UGFzc3dvcmQxMjM="
 ... />
```
  - Debes de configurarlo según tus necesidades. Más información en el siguiente [enlace](https://docs.wildfly.org/17/Admin_Guide.html#add-user-utility).

### Gestionar la consola de forma remota

  Hemos de realizar la configuración. Ejecuta el siguiente comando:
```console
  sudo nano /etc/wildfly/wildfly.conf

  WILDFLY_CONSOLE_BIND=0.0.0.0

  sudo nano /opt/wildfly/bin/launch.sh
```

  lanzando:
```console
  $WILDFLY_HOME/bin/domain.sh -c $2 -b $3 -bmanagement $4

  else

  $WILDFLY_HOME/bin/standalone.sh -c $2 -b $3 -bmanagement $4
```

  Esta ejecución indica en que modo deseamos lanzar el servidor (_standalone o domain_).

  Para finalizar hemos de realizar:

```console
  sudo systemctl restart wildfly

  sudo nano /etc/systemd/system/wildfly.service

  ExecStart=/opt/wildfly/bin/launch.sh $WILDFLY_MODE $WILDFLY_CONFIG $WILDFLY_BIND $WILDFLY_CONSOLE_BIND

  sudo systemctl daemon-reload

  sudo systemctl restart wildfly
```  

  y abriríamos la consola de _cli_

```console
  cd /opt/wildfly/bin/
  ./jboss-cli.sh --connect
```

  Como puedes ver __WildFly__, en su defecto _Jboss_ es un mundo.

## Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la instalación y se muestre la instalación de __WildFly__.

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
