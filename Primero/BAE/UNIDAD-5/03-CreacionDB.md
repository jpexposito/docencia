# Creación de Base de datos

Existen muchas formas de crear la base de datos, desde leerla de un **CSV**, descargar un archivo en el caso de sqlite o incluso usar una
serie de comandos para generarla de cero.

Dado que importar un archivo CSV puede depender del tipo de base que se use, usaremos ya sea el archivo **sqlite** o las
instrucciones que generan la base de datos.

## Archivos sqlite.db 

Los archivos son la alternativa mas sencilla y directa ya que solo necesitan ser descargados y colocados en la carpeta
local y comenzar con los ejercicios.

Estos se encuentran en la carpeta **base\_de\_datos** de este repositorio.

## Archivos con instrucciones SQL

En la carpeta **archivos_sql** se guardan los archivos que contienen solo comandos SQL. En la misma se guardan los
archivos que se ejecutarn para crear desde cero las bases de datos.
La ejecución se puede hacer de varias formas:

- Copiando y pegando las instrucciones

- Leyendo el archivo de la base de datos dentro de la línea de comando sqlite.

```code
sqlite>.read base_de_datos.sql
```

- Usando el archivo directamente al abrir sqlite

```code
sqlite3 base_de_datos.db < base_de_datos.sql
```

La ventaja como ya lo mencionaba es que en el caso de los archivos **sql** las instrucciones se encuentran en SQL
directamente y son excelentes como una referencia del lenguaje.
