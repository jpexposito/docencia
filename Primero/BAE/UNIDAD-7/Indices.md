<div align="justify">

# Índices en MySQL

Un ___índice es un puntero a una fila de una determinada tabla de nuestra base de datos___._Un puntero no es más que una referencia que asocia el valor de una determinada columna (o el conjunto de valores de una serie de columnas) con las filas que contienen ese valor (o valores) en las columnas que componen el puntero_.


__Los índices mejoran el tiempo de recuperación de los datos en las consultas realizadas contra nuestra base de datos__. 

_La creación de índices implica un aumento en el tiempo de ejecución sobre aquellas consultas de inserción, actualización y eliminación realizadas sobre los datos afectados por el índice. Del mismo modo, los índices necesitan un espacio para almacenarse, por lo que también tienen un coste adicional en forma de espacio en disco_.

<div align="center">
<img src="img/indices.png"/>
</div>

## ¿Para qué?

Los índices se emplean para __encontrar las filas que contienen los valores específicos de las columnas empleadas en la consulta de una forma más rápida__. _Si no existiesen índices, MySQL empezaría buscando por la primera fila de la tabla hasta la última buscando aquellas filas que cumplen los valores establecidos para las columnas empleadas en la consulta. Esto implica que, cuanto más filas tenga la tabla, más tiempo tardará en realizar la consulta. En cambio, si la tabla contiene índices en las columnas empleadas en la consulta, MySQL tendría una referencia directa hacia los datos sin necesidad de recorrer secuencialmente todos ellos_.

En general, MySQL emplea los índices para las siguientes acciones:
- __Encontrar las filas que cumplen la condición WHERE__ de la consulta cuyas columnas estén indexadas.
- __Para recuperar las filas de otras tablas cuando se emplean operaciones de tipo JOIN__. Para ello, es importante que los índices sean del mismo tipo y tamaño ya que aumentará la eficiencia de la búsqueda. Por ejemplo: una operación de tipo JOIN sobre dos columnas que tengan un índice del tipo INT(10).
- __Disminuir el tiempo de ejecución de las consultas con ordenación (ORDER BY) o agrupamiento (GROUP BY)__ si todas las columnas presentes en los criterios forman parte de un índice.
- __Si la consulta emplea una condición simple cuya columna de la condición está indexada__, las filas serán recuperadas directamente a partir del índice, sin pasar a consular la tabla.

## Tipos

Cuando creamos un índices lo hacemos con el objectivo de _acelerar futuras busquedas sobre los datos que poseemos_. ___Cada motor de base de datos ofrece distintos tipos de índices pero varias son comunes y algunos son mas especificos para cada DB___. __MySQL__ _hay_ ___5___ _tipos de índices_.
A continuación, vamos a analizar los distintos tipos de índices que se pueden crear y las condiciones que deben cumplir cada uno de ellos:
- __INDEX (NON-UNIQUE)__: este tipo de índice se refiere a un índice normal, no único. Esto implica que admite valores duplicados para la columna (o columnas) que componen el índice. No aplica ninguna restricción especial a los datos de la columna (o columnas) que componen el índice sino que se emplea simplemente para mejorar el tiempo de ejecución de las consultas.
- __UNIQUE__: este tipo de índice se refiere a un índice en el que todas las columnas deben tener un valor único. Esto implica que no admite valores duplicados para la columna (o columnas) que componen el índice. Aplica la restricción de que los datos de la columna (o columnas) deben tener un valor único.
- __PRIMARY__: este tipo de índice se refiere a un índice en el que todas las columnas deben tener un valor único (al igual que en el caso del índice UNIQUE) pero con la limitación de que sólo puede existir un índice PRIMARY en cada una de las tablas. Aplica la restricción de que los datos de la columna (o columnas) deben tener un valor único.
- __FULLTEXT__: estos índices se emplean para realizar búsquedas sobre texto __(CHAR, VARCHAR y TEXT)__. Estos índices se componen por todas las palabras que están contenidas en la columna (o columnas) que contienen el índice. No aplica ninguna restricción especial a los datos de la columna (o columnas) que componen el índice sino que se emplea simplemente para mejorar el tiempo de ejecución de las consultas. Soportado a partir de __MySQL 5.7__.
- __SPATIAL__: estos índices se emplean para realizar búsquedas sobre datos que componen formas geométricas representadas en el espacio. Soportado a partir de __MySQL 5.7__.
_Es importante destacar que todos estos índices pueden construirse empleando una o más columnas. Del mismo modo, el orden de las columnas que se especifique al construir el orden es relevante para todos los índices menos para el FULLTEXT (ya que este índice mira en TODAS las columnas que componen el índice)_.

## Sintaxis 

La sintaxis básica extraída de su web oficial:

```sql
CREATE [ONLINE|OFFLINE] [UNIQUE|FULLTEXT SPATIAL] INDEX index_name
    [index_type]
    ON tbl_name (index_col_name,...)
    [index_option] ...

```

Supongamos que tenemos la siguiente tabla en nuestra __BBDD__.

```sql
-- Podemos ejecutar la misma sentencia pero solo se ejecutara si la DB no existe.
CREATE DATABASE IF NOT EXISTS damdaw;

-- Creamos una tabla
CREATE TABLE usuarios(id int, nombre varchar(50), apellidos varchar(70));

```

Teniendo en cuenta que la __BBDD__ queda como sigue:

```sql
mysql> DESCRIBE usuarios;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| id        | int(11)     |      |     | NULL    |       |
| nombre    | varchar(50) | YES  |     | NULL    |       |
| apellidos | varchar(70) | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)
```

Veamos ahora la creación de cada uno de los tipos de índices que nos permiten __MySQL__.

Podemos seguir __dos caminos__ para la creación de índices. __Uno__ en el momento de creación de la tabla, o __dos__, detectando una necesidad, se incluye un índice.

#### Creación de la tabla

```sql
CREATE TABLE nombreTabla(campo1 tipoDato, campo2 tipoDato,..
  INDEX [nombreIndice] (campo1 [,campo2...]));
```
#### Modificación de la tabla

```sql
ALTER TABLE nombreTabla ADD INDEX [nombreIndice] (campo1 [,campo2...]);
```

__Ó__

```sql
CREATE INDEX nombreIndice ON nombreTabla(campo1 [,campo2...]);
```

___Ambas sentencias piden el nombre del índice, sin embargo con la sentencia CREATE INDEX el nombre es obligatorio.___

Por ejemplo, para la siguiente definición de tabla:

```sql
CREATE TABLE usuarios(id int, nombre varchar(50), apellidos varchar(70));
```

Se puede crear un índice en la columna apellidos con una sentencia ALTER TABLE:

```sql
ALTER TABLE usuarios ADD INDEX idx_apellidos (apellidos);
````

O bien, con una sentencia __CREATE INDEX__:

```sql
CREATE INDEX idx_apellidos ON usuarios(apellidos);
````

### Índice Unique

Los índices únicos son básicamente como los índices ordinarios, excepto que los valores duplicados no son permitidos. 

Siguiendo el ejemplo que hemos definido anteriormente, tenemos la tabla:

```sql
CREATE TABLE usuarios(id int, nombre varchar(50),
 apellidos varchar(70));
````

Podríamos crear un índice UNIQUE en la columna nombre, y un índice UNIQUE en la columna apellidos.

```sql
ALTER TABLE usuarios ADD UNIQUE idx_nombre (nombre);
```
y

```sql
CREATE UNIQUE INDEX idx_apellidos ON usuarios(apellidos);
````

_En el primer caso hacemos uso del comando_ ___ALTER TABLE___ _, y en el segundo caso creamos el índice con la sentencia_ ___CREATE INDEX___.

### Índices de clave primaria

_Una clave primaria es un índice sobre uno o más campos donde cada valor es único y ninguno de los valores son_ ___NULL___.

Por ejemplo, suponiendo que ya tenemos en nuestro sistema una tabla que fue creada de la siguiente manera (sin clave primaria, y con el campo id aceptando valores NULL):

```sql
CREATE TABLE usuarios(id int, nombre varchar(50), apellidos varchar(70));
```

Podemos crear una clave primaria sobre el campo id con esta sentencia:

```sql
ALTER TABLE usuarios MODIFY id INT NOT NULL, ADD PRIMARY KEY(id);
```

Teniendo como resultado:

```sql
mysql> DESCRIBE usuarios;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| id        | int(11)     |      | PRI | 0       |       |
| nombre    | varchar(50) | YES  |     | NULL    |       |
| apellidos | varchar(70) | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
```

> ___Nota___: _Compara el resultado con el valor obtenido en la definición de la tabla de la BBDD_.

### Índices de texto completo

Los índices de texto completo son del tipo ___FULLTEXT__, y pueden contener uno o más campos del tipo __CHAR, VARCHAR y TEXT__. _Un índice de texto completo está diseñado para facilitar y optimizar la búsqueda de palabras clave en tablas que tienen grandes cantidades de información en campos de texto_.

Siguiendo con el ejemplo anterior:

```sql
CREATE TABLE usuarios(id int, nombre varchar(50), apellidos varchar(70));
````

Podríamos crear un índice ___FULLTEXT___ en la columna __nombre__, en la columna __apellidos__, o bien, un índice que ocupe __ambos campos__. A continuación se muestran los tres casos.

```sql
CREATE FULLTEXT INDEX idx_nombre ON usuarios(nombre);

CREATE FULLTEXT INDEX idx_apellidos ON usuarios(apellidos);

CREATE FULLTEXT INDEX idx_nombre_apellidos ON usuarios(nombre,apellidos);
```

### Índices compuestos

Los índices compuestos son simplemente aquellos que ___están basados en múltiples columnas___. MySQL únicamente usa un índice por tabla cuando está procesando una consulta. Esto significa que si tenemos varias columnas que frecuentemente aparecen juntas en una cláusula WHERE, tenemos la oportunidad de acelerar estas consultas al crear un índice compuesto.

Siguiendo con el ejemplo utilizado:

```sql
CREATE TABLE usuarios(id int, nombre varchar(50), apellidos varchar(70));
```

podemos crear el siguiente indice:

```sql
ALTER TABLE usuarios ADD INDEX idx_nombre(nombre, apellidos);
```

### Índices de parte de campos

En las columnas __CHAR__ y __VARCHAR__ se nos permite crear un índice que no use el campo por completo. Retomemos el ejemplo anterior de la tabla usuarios. A pesar de que el nombre de una persona puede ser de hasta __50 caracteres__, es muy común que los nombres de las personas sean diferentes en los primeros __10 caracteres__. Al usar un índice de 10 caracteres en lugar de 50, el índice será más pequeño, y permitirá que las consultas __INSERT__ y __UPDATE__ sean más rápidas, a la vez que no se afecta la velocidad de las consultas __SELECT__.

Teniendo como base el ejemplo que hemos utilizado.

```sql
CREATE TABLE usuarios(id int, nombre varchar(50), apellidos varchar(70));
```

Para crear un índice como parte de un campo, sólo se tiene que especificar el tamaño entre paréntesis después del nombre de la columna. Por ejemplo, nuestro índice idx_nombre pudo haber sido creado también de la siguiente manera:

```sql
ALTER TABLE usuarios ADD INDEX idx_nombre(nombre(10), apellidos(20));;
```

## Referencias.

- [Crear Índices](https://dev.mysql.com/doc/refman/8.0/en/create-index.html).
- [Eliminar Índices](https://dev.mysql.com/doc/refman/8.0/en/drop-index.html).

</div>