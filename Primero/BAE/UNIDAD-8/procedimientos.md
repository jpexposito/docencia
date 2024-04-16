<div align="justify">

# Procedimientos en MySQL

En esta unidad vamos a estudiar los procedimientos que son objetos que contienen código SQL y se almacenan asociados a una base de datos. El resumen sería:

- __Procedimiento almacenado__: Es un objeto que se crea con la sentencia __CREATE PROCEDURE__ y se invoca con la sentencia __CALL__. Un procedimiento puede tener cero o muchos parámetros de entrada y cero o muchos parámetros de salida.

## Procedimientos

Un procedimiento almacenado es un __conjunto de instrucciones SQL__ que se almacena asociado a una base de datos. Es un objeto que se crea con la sentencia CREATE PROCEDURE y se invoca con la sentencia __CALL__. Un procedimiento puede tener ___cero o muchos parámetros de entrada___ y ___cero o muchos parámetros de salida___.

### Sintaxis

```sql
CREATE
    [DEFINER = { user | CURRENT_USER }]
    PROCEDURE sp_name ([proc_parameter[,...]])
    [characteristic ...] routine_body

proc_parameter:
    [ IN | OUT | INOUT ] param_name type

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

Nota > Puede encontrar más información en la [documentación oficial de MySQL](https://dev.mysql.com/doc/refman/8.0/en/create-procedure.html).

### DELIMITER

Para definir un procedimiento almacenado es necesario modificar temporalmente el carácter separador que se utiliza para delimitar las sentencias SQL.

El carácter separador que se utiliza por defecto en SQL es el punto y coma __(;)__. En los ejemplos que vamos a realizar en esta unidad vamos a utilizar los caracteres __$$__ para delimitar las instrucciones SQL, __pero es posible utilizar cualquier otro carácter__.

__Ejemplo__:

En este ejemplo estamos configurando los caracteres __$$__ como los separadores entre las sentencias SQL.

```sql
DELIMITER $$ -- comienzo del delimitador
```

__Ejemplo__:

En este ejemplo volvemos a configurar que el carácter separador es el punto y coma.

```sql
DELIMITER ;  -- comienzo del delimitador
```

### Uniendo Todo

Si unimos todo lo visto hasta ahora tendríamos:

```sql
DELIMITER // -- comienzo del delimitador
CREATE PROCEDURE nombre_procedimiento
BEGIN
  /* CODIGO EN SQL A EJECUTAR */
END //  -- fin del delimitador
```

Un ejemplo simple de un procedimiento:

```sql
DELIMITER // -- comienzo del delimitador
CREATE PROCEDURE total_paises
BEGIN
  SELECT COUNT(*)
  FROM pais
END // -- fin del delimitador
```

### Parámetros de entrada, salida y entrada/salida

En los procedimientos almacenados podemos tener parámetros.

```sql
DELIMITER // -- comienzo del delimitador
CREATE PROCEDURE nombre_procedimiento ( TIPOPARAMETRO parametro1 TIPOVALOR, ...)
BEGIN
  /* CODIGO EN SQL A EJECUTAR */
END // -- fin del delimitador
```

Exisen tres tipos de parámetros:

- __Entrada__: Se indican poniendo la palabra reservada __IN__ delante del nombre del parámetro. ___Estos parámetros no pueden cambiar su valor dentro del procedimiento, es decir, cuando el procedimiento finalice estos parámetros tendrán el mismo valor que tenían cuando se hizo la llamada al procedimiento___. En programación sería equivalente al _paso por valor de un parámetro_.
- __Salida__: Se indican poniendo la palabra reservada __OUT__ delante del nombre del parametro. Estos parámetros cambian su valor dentro del procedimiento. Cuando se hace la llamada al procedimiento empiezan con un valor inicial y cuando finaliza la ejecución del procedimiento pueden terminar con otro valor diferente. En programación sería equivalente al paso por referencia de un parámetro.
- __Entrada/Salida__: Es una combinación de los tipos __IN y OUT__. Estos parámetros se indican poniendo la palabra reservada IN/OUT delante del nombre del parámetro.

__Ejemplo__:

_En este ejemplo, se muestra la cabecera de un procedimiento llamado___ __listar_productos__ _que sólo tiene el parámetro gama que es de entrada (IN)_.

```sql
CREATE PROCEDURE listar_productos(IN gama VARCHAR(50))
```

__Ejemplo__:

_Aquí se muestra la cabecera de un procedimiento llamado_ ___contar_productos___ _que tiene el parámetro gama de entrada (IN) y el parámetro total de salida (OUT)_.

```sql
CREATE PROCEDURE contar_productos(IN gama VARCHAR(50), OUT total INT UNSIGNED)
```

__Ejemplo de un procedimiento con parámetros de entrada___

_Escriba un procedimiento llamado_ ___listar_productos___ _que reciba como entrada el nombre de la gama y muestre un listado de todos los productos que existen dentro de esa gama. Este procedimiento no devuelve ningún parámetro de salida, lo que hace es mostrar el listado de los productos_.

```sql
DELIMITER $$ -- comienzo del delimitador
DROP PROCEDURE IF EXISTS listar_productos$$ -- eliminamos el procedimiento si existiera
CREATE PROCEDURE listar_productos(IN gama VARCHAR(50))
BEGIN
  SELECT *
  FROM producto
  WHERE producto.gama = gama;
END
$$ -- fin del delimitador
```

El ejemplo anterior sería:

```sql
DELIMITER // -- comienzo del delimitador
CREATE PROCEDURE total_paises_nombrados_como
(IN palabra CHAR(20))
BEGIN
  SELECT COUNT(*) FROM pais
  WHERE nombre LIKE palabra;
END // -- fin del delimitador
```

### Llamada de procedimientos con CALL

Para hacer la llamada a un procedimiento almacenado se utiliza la palabra reservada __CALL__.

__Ejemplo__:

```sql
DELIMITER // -- comienzo del delimitador
CREATE PROCEDURE total_paises_nombrados_como
(IN palabra CHAR(20))
BEGIN
  SELECT COUNT(*) FROM pais
  WHERE nombre LIKE palabra;
END // -- fin del delimitador


CALL total_paises_nombrados_como('españa');
/* devolvería el resultado de la consulta */
```

### Ejemplos de procedimientos con parámetros de salida

__Ejemplo__:

_Escriba un procedimiento llamado_ ___contar_productos___ _que reciba como entrada el nombre de la gama y devuelva el número de productos que existen dentro de esa gama. Resuelva el ejercicio de dos formas distintas, utilizando SET y SELECT ... INTO._

__Solución 1. Utilizando SET__

```sql
DELIMITER $$ -- comienzo del delimitador
DROP PROCEDURE IF EXISTS contar_productos$$
CREATE PROCEDURE contar_productos(IN gama VARCHAR(50), OUT total INT UNSIGNED)
BEGIN
  SET total = ( -- Estamos asignando a la variable total el resultado
    SELECT COUNT(*) 
    FROM producto 
    WHERE producto.gama = gama);
END

$$ -- fin del delimitador

DELIMITER ; -- comienzo del delimitador
CALL contar_productos('Herramientas', @total);
SELECT @total;-- fin del delimitador
```

__Solución 2. Utilizando SELECT ... INTO__

```sql
DELIMITER $$
DROP PROCEDURE IF EXISTS contar_productos$$
CREATE PROCEDURE contar_productos(IN gama VARCHAR(50), OUT total INT UNSIGNED)
BEGIN
  SELECT COUNT(*) 
  INTO total -- almacenamos el valor del count en la variables total
  FROM producto 
  WHERE producto.gama = gama;
END
$$ -- fin del delimitador

DELIMITER ; -- comienzo del delimitador
CALL contar_productos('Herramientas', @total);
SELECT @total; -- fin del delimitador
```

__Ejemplo:__

_Escribe un procedimiento que se llame_ ___calcular_max_min_media__, _que reciba como parámetro de entrada el nombre de la gama de un producto y devuelva como salida tres parámetros. El precio máximo, el precio mínimo y la media de los productos que existen en esa gama. Resuelva el ejercicio de dos formas distintas, utilizando_ ___SET y SELECT ... INTO___.

__Solucioń 1. Utilizando SET__

```sql
DELIMITER $$ -- comienzo del delimitador
DROP PROCEDURE IF EXISTS calcular_max_min_media$$
CREATE PROCEDURE calcular_max_min_media(
  IN gama VARCHAR(50),
    OUT maximo DECIMAL(15, 2),
        OUT minimo DECIMAL(15, 2),
            OUT media DECIMAL(15, 2)
)
BEGIN
  SET maximo = (
    SELECT MAX(precio_venta)
    FROM producto
        WHERE producto.gama = gama);
  
  SET minimo = (
    SELECT MIN(precio_venta)
    FROM producto
        WHERE producto.gama = gama);
  
  SET media = (
    SELECT AVG(precio_venta)
    FROM producto
        WHERE producto.gama = gama);
END
$$ -- fin del delimitador

DELIMITER ; -- comienzo del delimitador
CALL calcular_max_min_media('Herramientas', @maximo, @minimo, @media);
SELECT @maximo, @minimo, @media; -- fin del delimitador
```

__Solucioń 2. Utilizando SELECT ... INTO__

```sql
DELIMITER $$ -- comienzo del delimitador
DROP PROCEDURE IF EXISTS calcular_max_min_media$$
CREATE PROCEDURE calcular_max_min_media(
  IN gama VARCHAR(50),
    OUT maximo DECIMAL(15, 2),
        OUT minimo DECIMAL(15, 2),
            OUT media DECIMAL(15, 2)
)
BEGIN
  SELECT 
    MAX(precio_venta),
    MIN(precio_venta),
    AVG(precio_venta)
    FROM producto
  WHERE producto.gama = gama
    INTO maximo, minimo, media;
END
$$ -- fin del delimitador

DELIMITER ; -- comienzo del delimitador
CALL calcular_max_min_media('Herramientas', @maximo, @minimo, @media);
SELECT @maximo, @minimo, @media; -- obtenemos los valores de las variables obtenidas
```
## Variables Locales

Dependiendo de la complejidad de un procedimiento almacenado, MySQL nos brinda la posibilidad de definir variables para almacenar valores temporales y efectuar operaciones con los mismos.

Utilizamos la palabra clave ___'declare'___ seguida del nombre de la variable, el tipo de dato que almacena y el valor por defecto que almacena:

```sql
declare [nombre de la variable] [tipo de dato] default [valor por defecto];
```

Una variable que no define la sección del 'default' almacena por defecto null.

Un ejemplo de definir una variable:

```sql
declare total int default 100;
```

Confeccionemos un procedimiento almacenado que reciba dos enteros, defina una variable local que almacene la suma de dichos valores y seguidamente ejecute el comando select para recuperar el contenido de dicha variable local:

```sql
drop procedure if exists pa_sumar;

delimiter //
create procedure pa_sumar(
  in v1 int,
  in v2 int)
begin
  declare suma int;
  set suma=v1+v2;
  select suma;  
end //
delimiter ;

call pa_sumar(4,5);
```

Para modificar una variable utilizamos la palabra clave set:

```sql
  set suma=v1+v2;
```

## Sentencia IF

Como cualquier otro lenguaje procedimental el gestor de base de datos MySQL dispone la estructura condicional if para tomar decisiones dentro de un procedimiento almacenado.

La sintaxis de la estructura condicional if simple es:

```sql
if [condición] then
   [instrucciones]
end if;
```

La sintaxis de la estructura condicional if compuesta es:

```sql
if [condición] then
   [instrucciones]
else
   [instrucciones]
end if;
```

La sintaxis de la estructura condicional if anidada es:

```sql
if [condición] then
   [instrucciones]
elseif [condición] then
   [instrucciones]
elseif [condición] then
   [instrucciones]
elseif [condición] then
   [instrucciones]
......
else
   [instrucciones]
end if;
```

Confeccionaremos un procedimiento almacenado que muestre el mayor de 2 enteros que le pasamos como parámetro:

```sql
drop procedure if exists pa_mayor;

delimiter //
create procedure pa_mayor(
  in valor1 int,
  in valor2 int)
begin
  if valor1>valor2 then
    select valor1;
  else
    select valor2;
  end if;
end //
delimiter ;

call pa_mayor(20, 400);
```

Podemos utilizar operadores lógicos en una condición de un if, crearemos un nuevo procedimiento almacenado que muestre el mayor de 3 enteros:

```sql
drop procedure if exists pa_mayor3;

delimiter //
create procedure pa_mayor3(
  in valor1 int,
  in valor2 int,
  in valor3 int)
begin
  if valor1>valor2 and valor1>valor3 then
    select valor1;
  elseif valor2>valor3 then
    select valor2;
  else
    select valor3;
  end if;
end //
delimiter ;

call pa_mayor3(200, 40, 4000);
```

## Sentencia CASE

Otra estructura condicional disponible en MySQL es la estructura ___'case'___.

Se utiliza cuando hay múltiples condiciones y remplaza a la estructuras ___if/elseif___.

Hay dos variantes con la estructura case. Veamos la primera:

```sql
case [variable] 
  when [valor1] then
    [instrucciones1]
  when [valor2] then
    [instrucciones2]
  when [valor3] then
    [instrucciones3]
  ....
  else
    [instrucciones]
end case;
```

La estructura case simple analiza el contenido de una variable y lo compara con una serie de valores posibles, en caso que coincida con alguno de ellos ejecuta el bloque de instrucciones respectivo. _Dispone de una sección else que se ejecuta cuando la variable analizada no coincide con los valores indicados en los_ ___when___.

```sql
delimiter //
create procedure ejemploProcedimiento (in p1 int)
    begin
        declare var int ;
        set var = p1 +2 ;
        case var
            when 2 then insert into lista values (66666);
            when 3 then insert into lista values (4545665);
            else insert into lista values (77777777);
        end case;
    end;
//
```

## Estructuras Repetitivas (while)

Hemos visto en los conceptos anteriores las instrucciones de MySQL que nos permiten definir estructuras condicionales dentro de los procedimientos almacenados. Ahora veremos que comandos disponemos para repetir bloques de instrucciones.

La primer estructura repetitiva que disponemos y es común a la mayoría de los lenguajes de programación es el 'while'.

while
La sintaxis es la siguiente:

```sql
while [condición] do
  [instrucciones]
end while;
```

El ___bloque de instrucciones encerrado entre while y end while se repite mientras la condición se verifique verdadera___.

## Llamar a otro procedimiento desde un procedimiento existente

_Un procedimiento almacenado puede llamar a otro procedimiento almacenado_. El procedimiento que es invocado por otro debe existir cuando creamos el procedimiento que lo llama. Es decir, _si un procedimiento_ ___A___ _llama a otro procedimiento_ ___B___, _B debe existir al crear A_.

Creamos un procedimiento almacenado que reciba 2 números enteros y nos retorne el producto de los mismos:

```sql
drop procedure if exists pa_multiplicar;
 
delimiter // 
create procedure pa_multiplicar(
  in numero1 int,
  in numero2 int,
  out producto int)
begin
  set producto=numero1*numero2;
end // 
delimiter ;


call pa_multiplicar(20,3,@resu);

select @resu;
```

Hasta ahora hemos planteado un procedimiento almacenado y su llamada para ver si su algoritmo genera el resultado deseado.

Ahora crearemos un segundo procedimiento almacenado que nos retorne el factorial de un número que llamará al procedimiento __pa_multiplicar__:

```sql
drop procedure if exists pa_multiplicar;
 
delimiter // 
create procedure pa_multiplicar(
  in numero1 int,
  in numero2 int,
  out producto int)
begin
  set producto=numero1*numero2;
end // 
delimiter ;


drop procedure if exists pa_factorial;

delimiter // 
create procedure pa_factorial(
  in numero int,
  out resultado int)
begin  
  declare num int;
  set resultado=1;
  set num=numero;
  while num>1 do
     call pa_multiplicar(resultado,num,resultado);
     set num=num-1;
  end while;
end //    
delimiter ;

call pa_factorial(5, @resu);
select @resu;
```

El procedimiento almacenado ___pa_factorial___ en su algoritmo llama al procedimiento ___pa_multiplicar___.

## Recursividad

En MySQL podemos codificar procedimientos almacenados que se llamen en forma recursiva como ocurre en otros lenguajes de programación.

Es una característica que hay que usar con cuidado ya que puede afectar la eficiencia de nuestros algoritmos. Por defecto MySQL tiene desactiva la posibilidad de hacer llamadas recursivas.

Para activar la posibilidad de hacer llamadas recursivas debemos modificar la variable del sistema ___max_sp_recursion_depth__ indicando la cantidad de llamadas recursivas posibles:

```sql
SET @@session.max_sp_recursion_depth = 10; 
```

</div>