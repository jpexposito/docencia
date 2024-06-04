<div align="justify">

<div align="center">
<img src="https://www.ciset.es/images/Glosario/mysql.png" width="250px"/>
</div>


## Introducción

Un Sistema de Gestión de Bases de Datos Relacionales (SGBDRs) es un programa que nos permite crear, actualizar y administrar una base de datos relacional. La mayoría de los sistemas de gestión de bases de datos relacionales utilizan SQL para acceder a la base de datos.

Hay que tener en cuenta que pueden existir diferencias en la sintaxis SQL utilizada por los distintos SGBDRs.

Los SGBDRs más usados actualmente son:

- SQLite (Hemos trabajado con él).
- MySQL
- MariaDB
- PostgreSQL
- OracleDB
- SQL Server

## MySQL

__MySQL__ es un sistema de administración de bases de datos de código abierto, que comúnmente se instala como parte de la popular pila LAMP (Linux, Apache, MySQL, PHP/Python/Perl). Implementa el modelo relacional y utiliza el Structured Query Language (más conocido como SQL) para administrar los datos.

Este apartado se explicará cómo instalar MySQL versión 8 en un servidor Ubuntu 20.04. Al completarlo, tendrá una base de datos relacional funcional que puede usar para crear su próximo sitio web o aplicación.

### Requisitos previos

Para este apartado, necesitará lo siguiente:

Un servidor Ubuntu 20.04.

>__Nota__: 
Vamos a crear una máquina virtual en VirtualBox con la última versión de Ubuntu Server donde vamos a instalar todo el software necesario para realizar nuestras primeras prácticas con el sistema gestor de bases de datos MySQL.
Ten en cuenta que la tarjeta de red de la máquina virtual tiene que estar configurada en modo adaptador puente.


### Paso 1: Instalar MySQL

En Ubuntu 20.04, puede instalar MySQL usando el repositorio de paquetes APT. 
Hemos de actualizar la lista de paquetes del repositorio.

Se debe actualizar el índice de paquetes en su servidor si no lo ha hecho recientemente.

```
sudo apt update
```

A continuación, instale el paquete mysql-server:

```
sudo apt install mysql-server
```

Estos comandos instalarán MySQL, pero no le solicitará establecer una contraseña ni realizar otros cambios de configuración. Debido a que esto deja su instalación de MySQL sin proteger, abordaremos esto a continuación.

##### ¿Cómo acceder a MySQL Server desde consola con el usuario root?

Una vez que hemos instalado MySQL Server en nuestro sistema vamos a acceder a la consola de MySQL. En primer lugar vamos a iniciar una sesión como root:

```
sudo su
```

Una vez que hemos iniciado una sesión como root vamos a iniciar la consola de MySQL también como root sin necesidad de indicarle ningún password (no es necesario usar el modificador -p).

```sql
mysql -u root 
```

Una vez hecho esto ya tendríamos acceso a la consola de MySQL como root.

Para salir hemos de ejecutar:

```sql
exit;
````

### Paso 2: Configurar MySQL

Para nuevas instalaciones de MySQL, querrá ejecutar la secuencia de comandos incluida en DBMS. Esta secuencia de comandos cambia algunas de las opciones predeterminadas menos seguras para cosas como inicios de sesión root remotos y usuarios de ejemplo.

Ejecute la secuencia de comandos de seguridad con sudo:

```sql
 ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password by 'mynewpassword';
```

Enlace de la [solución](https://stackoverflow.com/questions/72135856/endless-loop-in-mysql-secure-installation).
 
```
sudo mysql_secure_installation
```

Esto lo guiará a través de una serie de instrucciones mediante las cuales podrá realizar cambios en las opciones de seguridad de su instalación de MySQL. En la primera solicitud se le preguntará si desea configurar el complemento de validación de contraseña, que puede usar para probar la seguridad de la contraseña de MySQL.

Si decide configurar el complemento para validar la contraseña, la secuencia de comandos le solicitará elegir un nivel de validación de contraseña. Para el nivel más alto, que se selecciona ingresando 2, se solicitará que la contraseña tenga al menos ocho caracteres e incluya una combinación de mayúsculas, minúsculas y números y caracteres especiales:

```
Output
Securing the MySQL server deployment.

Connecting to MySQL using a blank password.

VALIDATE PASSWORD COMPONENT can be used to test passwords
and improve security. It checks the strength of password
and allows the users to set only those passwords which are
secure enough. Would you like to setup VALIDATE PASSWORD component?

Press y|Y for Yes, any other key for No: Y

There are three levels of password validation policy:

LOW    Length >= 8
MEDIUM Length >= 8, numeric, mixed case, and special characters
STRONG Length >= 8, numeric, mixed case, special characters and dictionary                  file

Please enter 0 = LOW, 1 = MEDIUM and 2 = STRONG:
 2
```

Independientemente de que opte por configurar el complemento para validar la contraseña, la siguiente solicitud tendrá que ver con establecer una contraseña para el usuario root de MySQL. Introduzca y luego confirme una contraseña segura que elija:

```
Output
Please set the password for root here.

New password:

Re-enter new password:
```

Si utilizó el complemento para validar la contraseña, recibirá un comentario acerca de la seguridad de su contraseña nueva. A continuación, la secuencia de comandos le consultará si desea continuar con la contraseña que introdujo o si desea introducir una nueva. Suponiendo que esté conforme con la seguridad de la contraseña que acaba de introducir, ingrese Y para continuar con la secuencia de comandos:

```
Output
Estimated strength of the password: 100
Do you wish to continue with the password provided?(Press y|Y for Yes, any other key for No) : Y
```

Desde allí, puede pulsar Y y luego ENTER para aceptar los valores predeterminados para todas las preguntas siguientes. Con esto, se eliminarán algunos usuarios anónimos y la base de datos de prueba, se deshabilitarán las credenciales de inicio de sesión remoto de root y se cargarán estas nuevas reglas para que MySQL aplique de inmediato los cambios que realizó.

Tenga en cuenta que aunque ha configurado una contraseña para el root user de MySQL, este usuario no está configurado para autenticar con una contraseña cuando se conecte al shell de MySQL. Si lo desea, puede ajustar este ajuste siguiendo el Paso 3.

### Paso 3: Ajustar la autenticación y los privilegios de usuario (opcional)

En los sistemas Ubuntu con MySQL 5.7 (y versiones posteriores), el usuario root de MySQL se configura para la autenticación usando el complemento auth_socket de manera predeterminada en lugar de una contraseña. Esto en muchos casos proporciona mayor seguridad y utilidad, pero también puede generar complicaciones cuando deba permitir que un programa externo (como phpMyAdmin) acceda al usuario.

Para usar una contraseña para conectar con MySQL como root, deberá cambiar su método de autenticación de auth_socket a otro complemento, como caching_sha2_password o mysql_native_password. Para hacer esto, abra la consola de MySQL desde su terminal:

```
sudo mysql -p
```

A continuación, compruebe con el siguiente comando el método de autenticación utilizado por una de sus cuentas de usuario de MySQL:

```sql
SELECT user,authentication_string,plugin,host FROM mysql.user;
```

```
Output
+------------------+------------------------------------------------------------------------+-----------------------+-----------+
| user             | authentication_string                                                  | plugin                | host      |
+------------------+------------------------------------------------------------------------+-----------------------+-----------+
| debian-sys-maint | $A$005$lS|M#3K #XslZ.xXUq.crEqTjMvhgOIX7B/zki5DeLA3JB9nh0KwENtwQ4 | caching_sha2_password | localhost |
| mysql.infoschema | $A$005$THISISACOMBINATIONOFINVALIDSALTANDPASSWORDTHATMUSTNEVERBRBEUSED | caching_sha2_password | localhost |
| mysql.session    | $A$005$THISISACOMBINATIONOFINVALIDSALTANDPASSWORDTHATMUSTNEVERBRBEUSED | caching_sha2_password | localhost |
| mysql.sys        | $A$005$THISISACOMBINATIONOFINVALIDSALTANDPASSWORDTHATMUSTNEVERBRBEUSED | caching_sha2_password | localhost |
| root             |                                                                        | auth_socket           | localhost |
+------------------+------------------------------------------------------------------------+-----------------------+-----------+
5 rows in set (0.00 sec)
```

En este ejemplo, puede ver que, en efecto, el usuario root se autentica utilizando el complemento de auth_socket. Para configurar la cuenta root para autenticar con una contraseña, ejecute una instrucción ALTER USER para cambiar qué complemento de autenticación utiliza y establecer una nueva contraseña.

Asegúrese de cambiar password por una contraseña segura de su elección, y tenga en cuenta que este comando cambiará la contraseña root que estableció en el Paso 2:

```
ALTER USER 'root'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'nueva_contraseña';
```

>__Nota__: La instrucción ALTER USER previa establecer el root user de MySQL para autenticar con el complemento __caching_sha2_password__. Según la documentación oficial de MySQL, __caching_sha2_password__ es el complemento de autenticación preferido por MySQL, ya que proporciona un cifrado de contraseña más seguro que el anterior, aunque aún usado ampliamente, __mysql_native_password__.

>__Nota__: Sin embargo, muchas aplicaciones PHP, como por ejemplo phpMyAdmin, no funcionan de forma fiable con caching_sha2_password. Si planea usar esta base de datos con una aplicación PHP, es posible que desee establecer root para que autentique con mysql_native_password:

```sql
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
```

A continuación, ejecute FLUSH PRIVILEGES para indicar al servidor que vuelva a cargar la tabla de permisos y aplique sus nuevos cambios:

```
FLUSH PRIVILEGES;
```

Compruebe de nuevo los métodos de autenticación empleados por cada uno de sus usuarios para confirmar que root deje de realizarla usando el complemento de auth_socket:

```sql
SELECT user,authentication_string,plugin,host FROM mysql.user;
```

```
Output
+------------------+------------------------------------------------------------------------+-----------------------+-----------+
| user             | authentication_string                                                  | plugin                | host      |
+------------------+------------------------------------------------------------------------+-----------------------+-----------+
| debian-sys-maint | $A$005$lS|M#3K #XslZ.xXUq.crEqTjMvhgOIX7B/zki5DeLA3JB9nh0KwENtwQ4 | caching_sha2_password | localhost |
| mysql.infoschema | $A$005$THISISACOMBINATIONOFINVALIDSALTANDPASSWORDTHATMUSTNEVERBRBEUSED | caching_sha2_password | localhost |
| mysql.session    | $A$005$THISISACOMBINATIONOFINVALIDSALTANDPASSWORDTHATMUSTNEVERBRBEUSED | caching_sha2_password | localhost |
| mysql.sys        | $A$005$THISISACOMBINATIONOFINVALIDSALTANDPASSWORDTHATMUSTNEVERBRBEUSED | caching_sha2_password | localhost |
| root             | *3636DACC8616D997782ADD0839F92C1571D6D78F                              | caching_sha2_password | localhost |
+------------------+------------------------------------------------------------------------+-----------------------+-----------+
5 rows in set (0.00 sec)
```

Puede ver en este resultado de ejemplo que el root user de MySQL ahora autentica usando caching_sha2_password. Una vez que confirme esto en su propio servidor, podrá cerrar el shell de MySQL:
```
exit
```

Por otra parte, para el flujo de trabajo de algunos puede resultar más conveniente la conexión a MySQL con un usuario dedicado. Para crear dicho usuario, abra el shell de MySQL de nuevo:

```
sudo mysql
```

>__Nota__: Si tiene la autenticación por contraseña habilitada para root, como se ha descrito anteriormente, deberá usar un comando diferente para acceder al shell de MySQL. A través de lo siguiente, se ejecutará su cliente de MySQL con privilegios de usuario regulares y solo obtendrá privilegios de administrador dentro de la base de datos mediante la autenticación:

```sql
mysql -u root -p
```

A partir de ahí, cree un usuario nuevo y asigne una contraseña segura:

```sql
CREATE USER 'sammy'@'localhost' IDENTIFIED BY 'password';
```

Luego, conceda a su nuevo usuario los privilegios apropiados. Por ejemplo, con el siguiente comando podría conceder privilegios de usuario a todas las tablas dentro de la base de datos, así como la facultad de añadir, cambiar y eliminar privilegios de usuario:

```sql
GRANT ALL PRIVILEGES ON *.* TO 'sammy'@'localhost' WITH GRANT OPTION;
```

Tenga en cuenta que en este momento no necesita ejecutar el comando FLUSH PRIVILEGES de nuevo. Este comando solo es necesario cuando modifica las tablas de concesión usando instrucciones como INSERT, UPDATE o DELETE. Debido a que creó un nuevo usuario, en vez de modificar uno existente, FLUSH PRIVILEGES no es necesario aquí.

Después de esto, cierre el shell de MySQL:

```
exit
```

Finalmente, vamos a probar la instalación de MySQL.

### Paso 4: Probar MySQL

Independientemente de cómo lo haya instalado, MySQL debería comenzar a ejecutarse automáticamente. Para probar esto, compruebe su estado.

```
systemctl status mysql.service
```

Visualizará un resultado similar al siguiente:

```
Output
● mysql.service - MySQL Community Server
     Loaded: loaded (/lib/systemd/system/mysql.service; enabled; vendor preset: enabled)
     Active: active (running) since Tue 2020-04-21 12:56:48 UTC; 6min ago
   Main PID: 10382 (mysqld)
     Status: "Server is operational"
      Tasks: 39 (limit: 1137)
     Memory: 370.0M
     CGroup: /system.slice/mysql.service
             └─10382 /usr/sbin/mysqld
```

Si MySQL no está ejecutándose, puede iniciarlo con sudo __systemctl start mysql__.

Como comprobación adicional, puede intentar establecer conexión con la base de datos usando la herramienta __mysqladmin__, que es un cliente que le permite ejecutar comandos administrativos. Por ejemplo, este comando dice conectar a MySQL como __root (-u root)__, solicitud de contraseña __(-p)__, y devolver la versión.

```
sudo mysqladmin -p -u root version
```

El resultado debería ser similar a este:

```
Output
mysqladmin  Ver 8.0.19-0ubuntu5 for Linux on x86_64 ((Ubuntu))
Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Server version		8.0.19-0ubuntu5
Protocol version	10
Connection		Localhost via UNIX socket
UNIX socket		/var/run/mysqld/mysqld.sock
Uptime:			10 min 44 sec

Threads: 2  Questions: 25  Slow queries: 0  Opens: 149  Flush tables: 3  Open tables: 69  Queries per second avg: 0.038
```

Esto significa que MySQL está funcionando.

</div>
