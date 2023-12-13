<div align="justify">

<div align="center">
<img src="https://miro.medium.com/v2/resize:fit:1400/format:webp/0*YRLPcqx9hsm4JT87.png" width="400px"/>
</div>


# Sqlite desde linea de comandos.

Las bases de datos SQLite son archivos portátiles multiplataforma. Pueden almacenarse en diversos dispositivos de almacenamiento y se pueden transferir a través de diferentes ordenadores.

Los Comandos Meta se utilizan para examinar una base de datos. Estos nos permiten operar y manipular la configuración de la __BBDD__.

| Comando | Descripción |
| ------ | ------| 
| .show |Muestra los valores actuales de varios parámetros |
| .databases | Proporciona nombres de bases de datos y archivos | 
| .quit | Salir del programa sqlite3 | 
| .tables | Mostrar tablas actuales | 
| .schema | Pantalla de esquema de la tabla | 
| .header | Mostrar u ocultar el encabezado de la tabla de salida | 
| .mode | Selecciona el modo de la tabla de salida | 
| .dump | Base de datos de volcado en formato de texto SQL | 

# Ejemplos de uso de los comandos

Casi todos los sitios web hoy en día cuentan con una sección de comentarios. Para publicar un comentario, el usuario debe enviar los siguientes datos:
 - Nombre
 - Correo electrónico
 - Sitio web
 - Comentario

De ellos, sólo el sitio web URL es opcional También hay que definir una columna que numere los comentarios. Le vamos a llamar __post_id__.

Podemos definir los tipos de datos de las columnas (atributos) de la siguiente manera:

| Atributo | Tipo de datos Necesario |
| ------ | ------ |
| post_id | INTEGER| 
| name | TEXT | 
| email | TEXT | 
| website_url | TEXT | 
| comment | TEXT | 

Creamos una base de datos. Si todavía estás en el programa de sqlite3, sal con .Quit en el indicador de sqlite. A continuación, ejecutea el comando:

```sql
sqlite3 comment_section.db
````

Esto creará un archivo de base de datos __comment_section.db__ en el directorio de trabajo actual.

> __Nota__: Si __NO__ se asigna un nombre de archivo a continuación del comando, sqlite3 crea automáticamente una base de datos temporal. Es lo que ha ocurrido cuando entramos en el comando sqlite3 por primera vez.

Crearemos la tabla:

```sql
CREATE TABLE comments (
    post_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    website_url TEXT NULL,
    comment TEXT NOT NULL );
 ````

__NOT NULL__ asegura que el valor particular no se deja en blanco en un registro. __PRIMARY KEY y AutoIncrement__ elaboran el atributo __post_id__.

Añadiremos una entrada:

```sql
INSERT INTO comments ( name, email, website_url, comment )
VALUES ( 'Shivam Mamgain', 'xyz@gmail.com',
'shivammg.blogspot.com', 'Great tutorial for beginners.' );
```

Vamos ahora a mostrar ahora los datos insertados:

```sql
SELECT post_id, name, email, website_url, comment FROM comments;
```

Esto recupera todas las filas de la tabla. La tabla resultante podría ser confusa al no llevar encabezados ni la adecuada separación entre columnas. Para esto, tenemos que modificar algunos parámetros.

```sql
Escribe .show
```

Para mostrar los atributos de la columna, escribe:

```sql
 .headers ON
````
 
Para mostrar las filas en el estilo de columna, escribe .mode column.
Introduce de nuevo __SELECT__ y compara el resultado.

## Otros comandos

- Abrir una base datos desde __SQLite3__.

    ```sql
    qlite> .open nombre.db
    ```

* Listar las tablas de la base de datos:
    
    ```sql
    sqlite> .tables
    ```

* Ver esquema de creación de la tabla.
    
    ```sql
    sqlite> .schema nombretabla
    ```

* Para salir del prompt de sqlite3
    
    ```sql
    sqlite> .exit
    ```
* Exportar la bbdd a un fichero __.sql__.     
    
    ```sql
    sqlite> .output fichero.sql
    sqlite> .dump
    sqlite> .exit 
    ```

    También podríamos realizar un __dump__ de una tabla específica, con el siguiente comando:

    ```sql
    sqlite> .output fichero.sql
    sqlite> .dump nombre_tabla
    sqlite> .exit 
    ```

    Realiza un __dump__ de la __bbdd__ que acabas de crear y verifica el fichero __.sql__ que has creado.

    Realiza ahora el siguiente comando:

    ```sql
    sqlite> .output fichero_schema.sql
    sqlite> .schema
    sqlite> .quit  
    ``` 

    En este momento verifica el contenido del fichero __.sql__ que has creado y compara los resultados.

    >__Nota__.  

* Importar un fichero __.sql__.

    ```sql
    sqlite> .read fihero.sql
    ```

</div>