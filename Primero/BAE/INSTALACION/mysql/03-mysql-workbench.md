<div align="justify">

<div align="center">
<img src="https://www.mysql.com/common/images/products/MySQL_Workbench_Visual_Design_Windows.gif" width="250px"/>
</div>

## MySQL WorkBench

__MySQL WorkBench__ es la herramienta oficial para trabajar con MySQL desde una interfaz gráfica de usuario. Con esta herramienta podemos diseñar, crear y consultar bases de datos.

### Instalación de MySQL WorkBench

Descarga e instala la última versión de MySQL WorkBench, siguiendo las instrucciones del siguiente [enlace](https://downloads.mysql.com/archives/workbench/).
  Seleccionando la versión del S.O. 



### Configuración de una nueva conexión

Una vez instalado MySQL WorkBench vamos a configurar una nueva conexión para conectar con MySQL.

Los parámetros de conexión que tenemos que configurar son los siguientes:

- Connection name.
- Connection method.
- Hostname.
- Port.
- Username.
- Password.
- Default schema.

#### Connection name

Será el nombre con el que queremos etiquetar esta conexión, para no tener que volver a escribir los parámetros de conexión cada vez que queramos conectar con MySQL.

#### Connection method
Usaremos Standard (TCP/IP).

#### Hostname

Si MySQL se está ejecutando en la misma máquina donde tenemos instalado MySQL WorkBench el hostname será __127.0.0.1__ en otro caso debemos conocer la ip la máquina.

Si MySQL se está ejecutando en otra máquina, por ejemplo en una máquina virtual, el hostname será la dirección IP de la máquina remota.

#### Port

El puerto en el que se ejecuta MySQL por defecto es el 3306.

#### Username y Password

Utilizaremos las credenciales del usuario con el que nos queremos conectar a MySQL.

#### Default Schema

Si queremos conectarnos a una base de datos específica aquí pondremos el nombre de dicha base de datos. Si queremos acceder a todas las bases de datos a las que tiene acceso el usuario con el que estamos conectando, entonces lo dejaremos en blanco.

## Configuración de MySQL

Si MySQL se está ejecutando en una máquina remota, diferente a la máquina donde tenemos instalado MySQL WorkBench tendremos que realizar la siguiente configuración.

Edita el archivo de configuración:

````
sudo nano /etc/mysql/mysql.conf.d/mysqld.cnf
````

Busca la directiva de configuración bind-address dentro del bloque de [mysqld]:

````
[mysqld]
bind-address = 127.0.0.1
````

En la configuración por defecto, MySQL sólo permite conexiones desde localhost (127.0.0.1). Habrá que modificar este valor por la dirección IP de la máquina donde se está ejecutando el servicio de MySQL.

````
[mysqld]
bind-address = IP_SERVIDOR_MYSQL
````

Si nuestra máquina dispone más de una interfaz de red podemos poner la dirección IP 0.0.0.0 para permitir que se puedan conectar a MySQL desde cualquiera de las interfaces de red disponibles.

````
[mysqld]
bind-address = 0.0.0.0
````

Una vez hecho esto tenemos que reiniciar el servicio de MySQL:

````
sudo /etc/init.d/mysql restart
````

### Asignando privilegios a los usuarios de MySQL

Ahora tenemos que asignar privilegios al usuario de MySQL que vamos a utilizar para conectarnos desde la máquina remota.

```
mysql -u root -p  
```

````
mysql> GRANT ALL PRIVILEGES ON DATABASE.* TO USERNAME@IP-MÁQUINA-REMOTA IDENTIFIED BY 'PASSWORD';

mysql> FLUSH PRIVILEGES;
````

````
mysql> exit;
````

Si queremos permitir que un usuario se pueda conectar desde cualquier dirección IP podemos utilizar el comodín %. De modo que tendríamos que realizar lo siguiente:

````
mysql -u root -p  
````

````
mysql> GRANT ALL PRIVILEGES ON DATABASE.* TO USERNAME@'%' IDENTIFIED BY 'PASSWORD';
````

````
mysql> FLUSH PRIVILEGES;
````

````
mysql> exit;
````

>__Nota__:Tenga en cuenta que tendrá que reemplazar los valores __DATABASE, USERNAME y IP-MÁQUINA-REMOTA__ por los valores que necesite.

Si en lugar de asignar permisos sobre una base de datos concreta queremos dar permisos para todas las bases de datos podemos usar el comodín *. Por ejemplo, si queremos crear un usuario root que se puede conectar desde cualquier máquina, que tiene privilegios sobre todas las bases de datos que existen y cuya contraseña es root tendríamos que ejecutar la siguiente sentencia SQL:

````
mysql -u root -p  
````

````
mysql> GRANT ALL PRIVILEGES ON *.* TO root@'%' IDENTIFIED BY 'root';
````

````
mysql> FLUSH PRIVILEGES;
````

````
mysql> exit;
````

### Comprobamos la lista de usuarios de MySQL

Los usuarios de MySQL se almacenan en la tabla mysql.user. La clave primaria de esta tabla está formada por los valores user y host, de modo que cada fila vendrá identificada por un nombre de usuario y el host desde el que puede conectarse.

La siguiente consulta nos devuelve el listado de usuarios que tenemos en MySQL y desde qué host pueden conectarse:

```sql
SELECT user,host FROM mysql.user;
```

En nuestra caso la consulta anterior devuelve el siguiente resultado:

```sql
+------------------+--------------+
| user             | host         |
+------------------+--------------+
| root             | %            |
| root             | localhost    |
| debian-sys-maint | localhost    |
| phpmyadmin       | localhost    |
| mysql.session    | localhost    |
| mysql.sys        | localhost    |
+------------------+--------------+
````

También podemos consultar qué permisos específicos tiene un determinado usuario. La siguiente consulta nos devuelve los permisos que tiene el usuario root:

```sql
SHOW GRANTS FOR root;
````

```sql
+------------------------------------------------+
| Grants for root@%                              |
+------------------------------------------------+
| GRANT ALL PRIVILEGES ON *.* TO 'root'@'%'      |
+------------------------------------------------+
````

### Comprobamos que podemos conectarnos a MySQL

Ahora vamos a comprobar que podemos conectarnos con MySQL desde otra máquina. Podemos comprobarlo conectando con el shell de mysql:

```sql
mysql -u USERNAME -p -h IP-SERVIDOR-MYSQL
```

O haciendo un telnet al puerto donde está corriendo el servicio de MySQL:

```
telnet IP-SERVIDOR-MYSQL 3306
````

Si no podemos conectarnos a MySQL revisaremos que el servicio está activo y que no tenemos ningún firewall que nos esté filtrando el puerto del servicio donde se ejecuta MySQL.

</div>
