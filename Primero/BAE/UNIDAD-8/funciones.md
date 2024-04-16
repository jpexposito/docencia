<div align="justify">

# Funciones en MySQL

Como se ha explicado, [los procedimientos](procedimientos.md) permiten tener funcionalidades del lado de la __BBDD__ (MySQL) en lugar de de procesar los datos con algún lenguaje del lado del servidor, como __PHP/Java/etc__ .Tiene la ventaja de que viaja menos información de la base de datos al servidor web, con el consiguiente aumento del rendimiento y que estas funciones harán que podamos atacar la base de datos desde cualquier otro lenguaje __.NET/Python__, como  sin tener que volver a procesar los datos otra vez.

MySQL tiene muchas funciones que podemos usar en nuestro procedimientos almacenados y consultas, pero en ocasiones podemos necesitar crear nuestras propias funciones para hacer cosas más especializadas…

Vamos a ver cómo crear funciones en MySQL:

### Sintaxis

```sql
CREATE
    [DEFINER = { user | CURRENT_USER }]
    FUNCTION sp_name ([func_parameter[,...]])
    RETURNS type
    [characteristic ...] routine_body

func_parameter:
    param_name type

type:
    Any valid MySQL data type

characteristic:
    COMMENT 'string'
  | LANGUAGE SQL
  | [NOT] DETERMINISTIC
  | { CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA }
  | SQL SECURITY { DEFINER | INVOKER }

routine_body:
    Valid SQL routine statement
```

### Características de la función

Después de la definición del tipo de dato que devolverá la función con la palabra reservada RETURNS, tenemos que indicar las características de la función. Las opciones disponibles son las siguientes:

- __DETERMINISTIC__: Indica que la función siempre devuelve el mismo resultado cuando se utilizan los mismos parámetros de entrada.
- __NOT DETERMINISTIC__: Indica que la función no siempre devuelve el mismo resultado, aunque se utilicen los mismos parámetros de entrada. Esta es la opción que se selecciona por defecto cuando no se indica una característica de forma explícita.
- __CONTAINS SQL__: Indica que la función contiene sentencias SQL, pero no contiene sentencias de manipulación de datos. Algunos ejemplos de sentencias SQL que pueden aparecer en este caso son operaciones con variables _(Ej: SET @x = 1)_ o uso de funciones de MySQL _(Ej: SELECT NOW();)_ entre otras. Pero en ningún caso aparecerán sentencias de escritura o lectura de datos.
- __NO SQL__: Indica que la función no contiene sentencias SQL.
- __READS SQL DATA__: Indica que la función no modifica los datos de la base de datos y que contiene sentencias de lectura de datos, como la sentencia SELECT.
- __MODIFIES SQL DATA__: Indica que la función sí modifica los datos de la base de datos y que contiene sentencias como _INSERT, UPDATE o DELETE_.

Para poder crear una función en MySQL es necesario indicar al menos una de estas tres características:
- DETERMINISTIC
- NO SQL
- READS SQL DATA

Si no se indica al menos una de estas características obtendremos el siguiente mensaje de error.

```sql
ERROR 1418 (HY000): This function has none of DETERMINISTIC, NO SQL,
or READS SQL DATA in its declaration and binary logging is enabled
(you *might* want to use the less safe log_bin_trust_function_creators variable)
```

Es posible configurar el valor de la varible global log_bin_trust_function_creators a 1, para indicar a MySQL que queremos eliminar la restricción de indicar alguna de las características anteriores cuando definimos una función almacenada. Esta variable está configurada con el valor 0 por defecto y para poder modificarla es necesario contar con el privilegio SUPER.

```sql
SET GLOBAL log_bin_trust_function_creators = 1;
```

En lugar de configurar la variable global en tiempo de ejecución, es posible modificarla en el archivo de configuración de MySQL.


Puede encontrar más información en la [documentación oficial de MySQL](https://dev.mysql.com/doc/refman/8.0/en/create-procedure.html).

__Un ejemplo__:


```sql
DELIMITER //

CREATE FUCNTION holaMundo() RETURNS VARCHAR(20)
BEGIN
    RETURN ‘HolaMundo!!’;
END
//
```

Para comprobar que funciona lanzamos el siguiente comando en la consola de MySQL :

```sql
Select holaMundo();
```

El resultado será similar al siguiente:

```sql
mysql> select holaMundo()//

+--------------+
| holaMundo()  |
+--------------+
| Hola Mundo!! |
+--------------+
1 row in set (0.00 sec)
```

Para borrar una función que hayamos creado debemos lanzar el siguiente comando:

```sql
DROP FUNCTION IF EXISTS holaMundo
```

## Uso de las variables en funciones:

Las variables en las funciones se usan de igual manera que en los [procedimientos almacenados](procedimientos.md), se declaran con la sentencia __DECLARE__, y se asignan valores con la sentencia __SET__.

```sql
DELIMITER //

CREATE FUNCTION holaMundo() RETURNS VARCHAR(30)
BEGIN
  DECLARE salida VARCHAR(30) DEFAULT 'Hola mundo';
;
  SET salida = ‘Hola mundo con variables’;
  RETURN salida;
END
//
```

Esta variable es de ámbito local, y será destruida una vez finalice la función. Cabe destacar el uso de la sentencia __DEFAULT__ en conjunto con DECLARE, que asigna un valor por defecto al declarar la variable.

> __Nota__: Realiza el siguiente ejercicio. Crea la función, previa eliminación si existe, y realiza la llamada. ¿Qué resultado obtienes?

## Uso de parámetros en funciones:

```sql
DELIMITER // -- se crea el delimitador
DROP FUNCTION IF EXISTS holaMundo//

CREATE FUNCTION holaMundo(entrada VARCHAR(20)) RETURNS VARCHAR(20)
BEGIN
  DECLARE salida VARCHAR(20);
  SET salida = entrada;
  RETURN salida;
END

//-- se cierra el delimitador
```
Ahora hemos creado una función que devuelve el mismo valor que le pasamos como parámetro.

Si tecleamos :

```sql
mysql> select holaMundo("que buen profesor tengo ;)")//
+---------------------------+
| holaMundo("que buen profesor tengo ;)") |
+---------------------------+
| que buen profesor tengo ;)             |
+---------------------------+
1 row in set (0.00 sec)
```

> __Nota__: Obtenemos como resultado lo mismo que le hemos pasado como párametro.

Vamos a crear una función que acepte un __dividendo__ y un __divisor__ y haga una división sin usar el operador división:

```sql
delimiter // -- comienzo del delimitador
DROP FUNCTION IF EXISTS divide//
create function divide(dividendo int,divisor int) returns int
begin
    declare aux int; -- declaracion de la variable aux
    declare contador int;-- declaracion de la variable contador
    declare resto int; -- declaracion de la variable resto
    set contador = 0;
    set aux = 0;
    while (aux + divisor) <= dividendo do
        set aux = aux + divisor ;
        set contador = contador + 1;
    end while;
    set resto = dividendo - aux ;
    return contador;
end
// -- finalizacion del delimitador
```

> __Nota__: Como podemos observar podemos hacer uso de las mismas estructuras que se han descrito en [los procedimientos](procedimientos.md).

Simplemente llamaríamos a la función así:

```sql
SELECT divide(20,2)
```

Lo que devolvería __10__.

## Documentación y ejemplos
- [Ejemplos funciones](https://www.mysqltutorial.org/mysql-stored-function/).
- [Funciones en MySql](https://dev.mysql.com/doc/refman/8.0/en/create-procedure.html).


</div>