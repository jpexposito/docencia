<div align="justify">

# Apache Tomcal, instalación y configuración

## Paso 1: Descargar Apache Tomcat 9

Descarga Apache Tomcat 9 desde el [sitio web oficial de Apache Tomcat](https://tomcat.apache.org/download-90.cgi). En la etiqueta __Binary Distributions__, y descarga un zip o tar extension.

```bash
wget https://downloads.apache.org/tomcat/tomcat-9/v9.0.xx/bin/apache-tomcat-9.0.xx.tar.gz
```

## Paso 2: Extraer el archivo comprimido

Extrae el archivo tar.gz en el directorio deseado.

```bash
tar -zxvf apache-tomcat-9.0.xx.tar.gz -C /directorio_destino
```

## Paso 3: Configurar variables de entorno

Configura las variables de entorno para facilitar el uso de Tomcat.

>___En el caso de linux___:

```bash
export CATALINA_HOME=/opt/apache-tomcat-9.0.xx
export PATH=$PATH:$CATALINA_HOME/bin
```

_Esta acción no es obligatoria_.

## Paso 4: Configurar permisos

Asegúrate de que el usuario tenga los permisos necesarios.

```bash
chown -R /opt/apache-tomcat-9.0.xx
chmod 755 /opt/apache-tomcat-9.0.xx/bin
```

## Paso 5: Iniciar y Detener Tomcat

Para iniciar Tomcat, navega al directorio de instalación y ejecuta el script startup.sh:

```bash
cd /opt/apache-tomcat-9.0.xx/bin
./startup.sh
```

Para detener Tomcat, ejecuta el script shutdown.sh:

```bash
cd /opt/apache-tomcat-9.0.xx/bin
./shutdown.sh
```

## Paso 6: Acceder a Tomcat

Accede a la interfaz de administración de Tomcat en tu navegador web visitando http://localhost:8080.

```code
http://localhost:8080
```

## Paso 7: Configurar un usuario administrador

Para acceder a las herramientas de administración de Tomcat, necesitas configurar un usuario administrador en el archivo `tomcat-users.xml`.

Abre el archivo `tomcat-users.xml` ubicado en el directorio `conf` dentro del directorio de instalación de Tomcat:

```bash
nano /opt/apache-tomcat-9.0.xx/conf/tomcat-users.xml
```

Agrega las siguientes líneas dentro del elemento <tomcat-users>:

```xml
<role rolename="manager-gui"/>
<role rolename="admin-gui"/>
<user username="admin" password="tu_contraseña" roles="manager-gui,admin-gui"/>
```
</div>