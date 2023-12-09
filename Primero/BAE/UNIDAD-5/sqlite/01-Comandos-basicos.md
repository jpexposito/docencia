<div align="justify">

# Comandos básicos en el tratamiento de BBDD

## Comandos Meta
Los Comandos Meta se utilizan para definir el formato de salida para tablas, examinar bases de datos y otras operaciones administrativas. Siempre empiezan con un punto . Incluso .help es un comando meta. Puedes ir a través de la lista. Aquí hay algunos frecuentes que te serán muy útiles:

| Comando | Descripción |
|-----|-----|
| .show | Muestra los valores actuales de varios parámetros|
| .databases | Proporciona nombres de bases de datos y archivos|
|.quit | Salir del programa sqlite3|
|.tables| Mostrar tablas actuales|
|.schema|Pantalla de esquema de la tabla|
|.header|Mostrar u ocultar el encabezado de la tabla de salida|
|.mode|elecciona el modo de la tabla de salida|
|.dump| Base de datos de volcado en formato de texto SQL|

## Comandos estándar
Los Comandos Meta se utilizan para examinar una base de datos. Los Comandos SQL estándar se utilizan para operar en una base de datos. Los comandos estándar se pueden clasificar en tres grupos:
- Data Definition Language : Proporcionan la estructura y métodos de almacenamiento para acceder a los datos desde el sistema de base de datos.
  - CREATE
  - ALTER
  - DROP
- Data Manipulation Language: Permite a los usuarios manipular (añadir / modificar / eliminar) los datos.
  - INSERT
  - UPDATE
  - DELETE
- Data Query Language : Permite a los usuarios recuperar los datos necesarios de la base de datos.
  - SELECT
 
 > __Nota__: SQLite utiliza muchos otros comandos estándar, muchos de los cuales figuran en esta lista. Aquí vamos a ver una introducción de nivel principiante, vemos sólo los comandos antes mencionados.

Las bases de datos SQLite son archivos portátiles multiplataforma. Pueden almacenarse en diversos dispositivos de almacenamiento y se pueden transferir a través de diferentes ordenadores.

Casi todos los sitios web hoy en día cuentan con una sección de comentarios. Para publicar un comentario, el usuario debe enviar los siguientes datos:
 - Nombre
 - Correo electrónico
 - Sitio web
 - Comentario

De ellos, sólo el sitio web URL es opcional. También hay que definir una columna que numere los comentarios. Le vamos a llamar post_id.

Podemos definir los tipos de datos de las columnas (atributos) de la siguiente manera:

| Atributo |Tipo de datos |  Necesario |
| ----- |----- |----- |
| post_id | INTEGER| |
| name | TEXT | |
| email | TEXT | |
| website_url | TEXT | |
| comment | TEXT| |

Aquí puedes ver la documentación para los diferentes tipos de datos y clases de almacenamiento previstos en SQLite3. 


Creamos una base de datos. Si todavía estás en el programa de sqlite3, sal con __.Quit__ en el indicador de sqlite. A continuación, ejecutea el comando:

```
sqlite3 comment_section.db
```
Esto creará un archivo de base de datos comment_section.db en el directorio de trabajo actual.

Nota: Si no se asigna un nombre de archivo a continuación del comando, sqlite3 crea automáticamente una base de datos temporal. Es lo que ha ocurrido cuando entramos en el comando sqlite3 por primera vez.

CREATE TABLE
Para almacenar los comentarios hay que definir una tabla. Vamos a darle el nombre de comments . Para crearla, introduce lo siguiente:
```
CREATE TABLE comments (
    post_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    website_url TEXT NULL,
    comment TEXT NOT NULL );
```    
NOT NULL  asegura que el valor particular no se deja en blanco en un registro. PRIMARY KEY y AutoIncrement elaboran el atributo post_id.

Para comprobar si la tabla se ha creado, emite el comando meta .tables. Se mostrará el nombre de la tabla comments.
```
SQLite3
```

> __Nota__: Para obtener el esquema de la tabla escribe .schema comments

Ahora que la tabla se ha creado, necesitamos introducir datos.

Insertar filas
Supongamos que un usuario ha introducido un comentario con los detalles:
```
Name    : Shivam Mamgain
Email   : xyz@gmail.com
Website : shivammg.blogspot.com
Comment : Great tutorial for beginners.
```

Para añadirlo, utilizamos el comando INSERT.
```
INSERT INTO comments ( name, email, website_url, comment )
VALUES ( 'Shivam Mamgain', 'xyz@gmail.com',
'shivammg.blogspot.com', Great tutorial for beginners.' );
```

No se ha proporcionado el valor para post_id, a pesar de que se define como NOT NULL. Esto es porque no es necesario ya que es un campo AutoIncrement.

### SELECT

Hemos aprendido a insertar datos en la tabla. Para recuperar los datos utilizamos el comando SELECT.

```
SELECT post_id, name, email, website_url, comment
FROM comments;
```
Lo anterior también se puede escribir como:
```
SELECT *
FROM comments;
```
Esto recupera todas las filas de la tabla. La tabla resultante podría ser confusa al no llevar encabezados ni la adecuada separación entre columnas. Para esto, tenemos que modificar algunos parámetros.
Escribe __.show__

Para mostrar los atributos de la columna, escribe __.headers ON__ .
Para mostrar las filas en el estilo de columna, escribe .mode column.
Introduce de nuevo SELECT.

> __Nota__: Selecciona el modo de pantalla que más te convenga. Escribe .help y utiliza .mode para buscar. Se mostrarán los distintos valores que .mode tiene.

### UPDATE

Supongamos que el email para 'Shivam Mamgain' ha cambiado a 'zyx@email.com'. Necesitamos actualizar la fila. Escribe la siguiente sentencia:

```
UPDATE comments
SET email = 'zyx@email.com'
WHERE name = 'Shivam Mamgain';
```

Esto cambia el atributo email para el name 'Shivam Mamgain' a 'zyx@email.com'.

> __Nota__: El atributo name no es único, por lo que la afirmación anterior puede afectar a más de una fila. Por cada name = 'Shivam Mamgain' el email se establece en 'zyx@email.com'. Para actualizar una fila específica, usar el atributo post_id. Se define como una PRIMARY KEY y siempre será único.

### DELETE
Para DELETE (borrar) una o varias filas de la tabla podemos utilizar la condición WHERE, al igual que en UPDATE.

Supongamos que tenemos que eliminar una fila con post_id 9. Podemos introducir el comando:
```
DELETE FROM comments
WHERE post_id = 9;
```
Si queremos eliminar los comentarios publicados por 'Bart Simpson' y 'Homer Simpson'. Podemos ejecutar la siguiente consulta:
```
DELETE FROM comments
WHERE name = 'Bart Simpson' OR name = 'Homer Simpson';
```
### ALTER

Para añadir columnas a una tabla se utiliza el comando ALTER. En la web, la mayoría de la gente no siempre utiliza su nombre real. Por lo general, lo hacen bajo un alias, un username. Vamos a añadir una columna llamada username a nuestra tabla:
```
ALTER TABLE comments
ADD COLUMN username TEXT;
```
Esto crea una columna username en comments y establece su tipo de datos en TEXT. El valor de username para las filas ya insertadas se establece en NULL.

El comando ALTER también se utiliza para cambiar el nombre de las tablas. Vamos a cambiar el nombre de la tabla comments por Coms.
```
ALTER TABLE comments
RENAME TO Coms;
```
### DROP

Este comando borra toda la tabla. La tabla Coms se puede eliminar con la siguiente consulta:

```
DROP TABLE Coms;
```
</div>