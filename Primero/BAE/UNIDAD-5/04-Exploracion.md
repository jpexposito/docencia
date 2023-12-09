# Exploración de la Base de datos

## Bases Disponibles

En el caso de Bases relacionales como MySQL, SQL o PostgreSQL, estas tienen un servicio que funciona en una maquina, por
lo tanto pueden tener una o mas bases de datos funcionando en ellas. El acceso a las mismas depende de los permisos que
se le asignan a cada usuario. 

Por el tipo de base de datos, depende el listado de las bases disponibles. Listaremos los métodos para MySQL y SQL, los
métodos de otras bases se pueden encontrar en línea.

- MySQL `SHOW databases;`

- SQL `EXEC sp_databases` ó `SELECT name FROM master.dbo.sysdatabases`

En el caso particular de **sqlite** cada archivo corresponde a una base, si bien se pueden adjuntar otras bases en
general abrir el archivo seleccionaría la base a utilizar.

```code
sqlite3 basededatos.db
```

O ya con la línea de comandos sqlite 

```code
sqlite>.open basededatos.db
```

>**Nota:**
> Sin no existiera la base se crea la misma temporalmente y si no se salva se desturirá.

En caso de tener varias bases de datos adjuntas, existe un comando interno de **sqlite** que permite revisar las bases
disponibles `.databases` 

## Tablas de la Base seleccionada

Las bases suelen tener dentro de ellas una o mas tablas, que son arreglos de filas y columnas. 
Las diferentes bases tiene diferentes estructuras y por lo tanto diferentes formas de revisar las tablas existentes.

Algunas de las bases de datos se pueden acceder de la siguiente forma:

- MySQL `SHOW TABLES;`

- SQL `SELECT tablespace_name, table_name FROM dba_tables;`

En **sqlite** existe un comando interno para listar las tablas `.tables` o se puede usar el comando:

```sql
SELECT name FROM sqlite_master WHERE type='table';
```
Este último tiene la ventaja de mostrar incluso las tablas que fueron adjuntadas.

> **Nota:**
> En **sqlite** se puede revisar ademas la estructura de la base, mediante el comando `.schema` que es mucho mas
> detallado y conociendo un poco mas de _sql_ es un recurso muy útil de información.

## Revisar contenido de una tabla

Una ves identificada la tabla podemos revisar su contenido, para esto usaremos la tabla **libros** de la base
**librosDB**:

```sql
SELECT * FROM libro;
```

Revisando cada parte tenemos:

- **SELECT** Define que columnas queremos extraer
- **\*** Es un caracter especial que permite extraer todas las columnas
- **FROM** Esta palabra clave permite señalar de que tabla se obtiene la información 
- _libros_ en este caso es el nombre de la tabla que vamos a consultar.

> **Nota:**
> Si bien SQL permite escribir en minuscula o mayuscula es recomendable tener las plabras clabe en mayúsculas y las
> palabras reservadas del lenguaje **SQL** en mayúsculas.

Si ejecutamos este código podemos ver que tiene las columnas _Autor_, _Titulo_, _ISBN_ y _Editorial_.
Estas columnas pueden extraerse por su nombre, sustituyendo el asterisco por los títulos de las columnas separados por
comas.

```sql
SELECT Autor, Editorial FROM libro;
```

>__Nota__:Por lo tanto se pueden seleccionar cualquier combinación de columnas para extraer la información que contienen.
