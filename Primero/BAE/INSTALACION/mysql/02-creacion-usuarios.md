<div align="justify">

<div align="center">
<img src="https://www.ciset.es/images/Glosario/mysql.png" width="250px"/>
</div>


## Cómo crear un nuevo usuario

Comencemos creando un nuevo usuario en el shell de MySQL:

```sql
CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'password';
```

>__Nota__: Al añadir usuarios en el shell de MySQL, especificaremos el host del usuario como localhost, y no la dirección IP del servidor. localhost es un nombre de host que significa “este equipo”, y MySQL trata este nombre de host en particular de manera especial: cuando un usuario con ese host inicia sesión en MySQL, intentará conectarse al servidor local utilizando un archivo de socket de Unix. Por lo tanto, localhost se utiliza normalmente cuando planea conectarse implementando SSH a su servidor o cuando está ejecutando el cliente mysql local para conectarse al servidor MySQL local.

En este momento, newuser no tiene permisos para hacer nada con las bases de datos. De hecho, incluso si newuser intenta iniciar sesión (con la contraseña, password), no podrá acceder al shell de MySQL.

Por lo tanto, lo primero que se debe hacer es proporcionar al usuario acceso a la información que necesitará.

```sql
GRANT ALL PRIVILEGES ON * . * TO 'newuser'@'localhost';
```

Los asteriscos en este comando se refieren a la base de datos y la tabla (respectivamente) a los que pueden acceder. Este comando específico permite al usuario leer, editar, ejecutar y realizar todas las tareas en todas las bases de datos y tablas.

Tenga en cuenta que en este ejemplo estamos otorgando a __newuser__ acceso de root completo a todo en nuestra base de datos. Si bien esto es útil para explicar algunos conceptos de MySQL, puede ser poco práctico para la mayoría de casos de uso y podría poner la seguridad de su base de datos en alto riesgo.

Una vez que haya finalizado los permisos que desea configurar para sus nuevos usuarios, asegúrese siempre de volver a cargar todos los privilegios.

- __FLUSH PRIVILEGES__;
Sus cambios ahora estarán vigentes.

    Cómo otorgar diferentes permisos de usuario
    Aquí se incluye una breve lista de otros posibles permisos comunes que los usuarios pueden disfrutar.

- __ALL PRIVILEGES__:       Como vimos antes, esto le otorgaría a un usuario de MySQL acceso completo a una base de datos designada (o si no se selecciona ninguna base de datos, acceso global a todo el sistema).
- __CREATE__:     Permite crear nuevas tablas o bases de datos.
- __DROP__: Permite eliminar tablas o bases de datos.
- __DELETE__: Permite eliminar filas de las tablas.
- __INSERT__: Permite insertar filas en las tablas.
- __SELECT__: Les permite usar el comando SELECT para leer las bases de datos.
- __UPDATE__: Permite actualizar las filas de las tablas.
- __GRANT OPTION__: Permite otorgar o eliminar privilegios de otros usuarios.
Para proporcionar un permiso a un usuario específico, puede usar este marco:

```sql
GRANT type_of_permission ON database_name.table_name TO 'username'@'localhost';
````

Si desea darle a un usuario acceso a cualquier base de datos o a cualquier tabla, asegúrese de poner un asterisco (*) en el lugar del nombre de la base de datos o de la tabla.

Cada vez que actualice o cambie un permiso, asegúrese de usar el comando Flush Privileges.

Si necesita revocar un permiso, la estructura es casi la misma que para otorgar un permiso:

```sql
REVOKE type_of_permission ON database_name.table_name FROM 'username'@'localhost';
````

Tenga en cuenta que, cuando revoca permisos, la sintaxis requiere que utilice FROM en lugar de TO, como se utiliza para otorgar permisos.

Puede revisar los permisos actuales de un usuario ejecutando lo siguiente:

```sql
SHOW GRANTS FOR 'username'@'localhost';
````

Al igual que puede eliminar bases de datos con DROP, también puede usar DROP para eliminar un usuario por completo:

```sql
DROP USER 'username'@'localhost';
````

Para probar su nuevo usuario, cierre sesión escribiendo lo siguiente:

```
quit
````

y vuelva a iniciar sesión con este comando en el terminal:

```sql
mysql -u [username] -p
```