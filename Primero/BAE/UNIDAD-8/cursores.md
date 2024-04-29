<div align="justify">

# Cursores en MySQL

___En base de datos un Cursor es un mecanismo el cual nos permite procesar fila por fila el resultado de una consulta__.

>SQL es un lenguaje orientado a conjuntos. Si nosotros deseamos alterar ciertos elementos en nuestra colección tendremos que hacerlo mediante condicione. Única y exclusivamente los elementos que cumpla con dichas condiciones podrán ser alterados. ___Con los cursores podremos trabajar con cada uno de los elementos (filas) de nuestra consulta sin tener que obtener nuevos conjuntos. Esto nos permitirá ser mucho más flexibles al momento de manipular la información___.

Para nosotros poder hacer uso de un cursor será necesario seguir los siguientes pasos:
 - Crear un cursor a partir de una sentencia SQL.
 - Apertura del cursor.
 - Acceso a datos.
 - Cierre del cursor.

>Es importante mencionar que en __MySQL__ los cursores solo podrán ser utilizados __dentro de stored procedures__.

## Ejemplo.

_1.-Crear un stored procedure el cual incremente en 10 el número de páginas de cada libro (tabla libros). En consola debemos visualizar el título, el anterior número de páginas y el actual número de páginas de cada libro_.

Bien, este ejemplo nos permitirá comprender de una mejor manera el uso de cursores.

Veamos como pudiese quedar nuestro stored procedure.

```sql
DELIMITER //

DROP PROCEDURE IF EXISTS facilito_procedure//
CREATE PROCEDURE facilito_procedure()
BEGIN

  DECLARE var_id INTEGER;
  DECLARE var_paginas INTEGER;
  DECLARE var_titulo VARCHAR(255);
  DECLARE var_final INTEGER DEFAULT 0;

  DECLARE cursor1 CURSOR FOR SELECT libro_id, titulo, paginas FROM libros;

  DECLARE CONTINUE HANDLER FOR NOT FOUND SET var_final = 1;

  OPEN cursor1;

  bucle: LOOP

    FETCH cursor1 INTO var_id, var_titulo, var_paginas;

    IF var_final = 1 THEN
      LEAVE bucle;
    END IF;

    UPDATE libros SET paginas = var_paginas + 10 WHERE libro_id = var_id;

    SELECT
      var_titulo AS  'titulo',
      var_paginas AS 'Anterior',
      paginas AS 'Incremento'
      FROM libros WHERE libro_id = var_id;


  END LOOP bucle;
  CLOSE cursor1;

END//
DELIMITER ;
```

Dentro del stored procedure lo primero que hacemos es declarar todas las variables que usaremos. En este caso como trabajaremos con el título y el número de páginas de cada libro declaró tres nuevas variables: __var_id, var_paginas, var_titulo__.

Para tener un control sobre la iteración de cada uno de los elementos en la consulta declaró una cuarta variable llamada __var_final__, cuyo valor comienza en 0.

Una vez hemos declarado todas las variables procedemos a crear nuestro cursor. ___El cursor se creará a partir de una consulta SQL___. En este caso la consulta no es demasiado compleja, sin embargo, _si así lo deseamos podemos crear un cursos a partir de una consulta con joins, order, group etc.._.

Con la sentencia

```sql
DECLARE CONTINUE HANDLER FOR NOT FOUND SET var_final = 1;
```

>Indicamos que una vez todos los elementos (filas) dentro de nuestro cursor hayan sido iterados la variable var_final tomará un nuevo valor, de 0 a 1.

Para comenzar la iteración de los elementos será necesario abrir el cursor.

```sql
OPEN cursor1;
```

La iteración la logramos utilizando un __Loop__, el cual será controlado a partir de la variable __var_final__.

```sql
    IF var_final = 1 THEN
            --Si ya no existen más elementos finalizamos el ciclo.
      LEAVE bucle;
    END IF;
```

Al nosotros usar la cláusula Fetch obtenemos el elemento (fila) actual de nuestra consulta y avanzamos al siguiente elemento.

En este caso como en nuestra consulta hemos obtenido 3 columnas (id, titulo, páginas) asignamos el valor de cada una de las columnas a nuestras variables. Es importante mencionar que los valores podrán ser asignados únicamente a variables del mismo tipo, no podremos asignar un varchar a una variable de tipo integer.

El orden es importante.

```sql
FETCH cursor1 INTO var_id, var_titulo, var_paginas;
````

Una vez hemos realizado todas las tareas correspondientes y se han iterado todos los elementos (filas) el siguiente paso será cerrar el cursor.

```sql
close cursor1
````

Para ejecutar nuestro stored prcedure ejecutaremos la siguiente sentencia.

```sql
call facilito_procedure();
```

</div>