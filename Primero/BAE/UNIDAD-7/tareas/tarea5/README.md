<div align="justify">

# Trabajo con la BBDD Jardineria

Vamos a realizar el trabajo con una BBDD existente en la documentación  oficial de MySql. Su nombre es __jardineria__.

El __diagrama ER__ de esta BBDD es el siguiente:

<div align="center">
<img width="700" src="img/er.png"/>
</div>

Se pide:

### Carga de datos

- Realiza la carga de la BBDD de [Jardineria](file/jardineria.sql) y describe los pasos que has realizado.

### Índices

- Consulte cuáles son los índices que hay en la tabla producto utilizando las instrucciones SQL que nos permiten obtener esta información de la tabla.
- Haga uso de EXPLAIN para obtener información sobre cómo se están realizando las consultas y diga cuál de las dos consultas realizará menos comparaciones para encontrar el producto que estamos buscando. ¿Cuántas comparaciones se realizan en cada caso? ¿Por qué?.

  ```sql
  SELECT *
  FROM producto
  WHERE codigo_producto = 'OR-114';
  ````

  ```sql
  SELECT *
  FROM producto
  WHERE nombre = 'Evonimus Pulchellus';
  ```

  >Razona la respuesta, y analiza las diferencias.

- Suponga que estamos trabajando con la base de datos jardineria y queremos saber optimizar las siguientes consultas. ¿Cuál de las dos sería más eficiente?. Se recomienda hacer uso de EXPLAIN para obtener información sobre cómo se están realizando las consultas.

  ```sql
  SELECT AVG(total)
  FROM pago
  WHERE YEAR(fecha_pago) = 2008;
  ```

  ```sql
  SELECT AVG(total)
  FROM pago
  WHERE fecha_pago >= '2008-01-01' AND fecha_pago <= '2008-12-31';
  ```

  >[Lectura recomendada sobre la función YEAR y el uso de índices](https://www.mysqltutorial.org/mysql-date-functions/mysql-year-function/)

- Optimiza la siguiente consulta creando índices cuando sea necesario. Se recomienda hacer uso de EXPLAIN para obtener información sobre cómo se están realizando las consultas.

  ```sql
  SELECT *
  FROM cliente INNER JOIN pedido
  ON cliente.codigo_cliente = pedido.codigo_cliente
  WHERE cliente.nombre_cliente LIKE 'A%';
  ```

- ¿Por qué no es posible optimizar el tiempo de ejecución de las siguientes consultas, incluso haciendo uso de índices?

  ```sql
  SELECT *
  FROM cliente INNER JOIN pedido
  ON cliente.codigo_cliente = pedido.codigo_cliente
  WHERE cliente.nombre_cliente LIKE '%A%';

  SELECT *
  FROM cliente INNER JOIN pedido
  ON cliente.codigo_cliente = pedido.codigo_cliente
  WHERE cliente.nombre_cliente LIKE '%A';
  ```

- Crea un índice de tipo FULLTEXT sobre las columnas nombre y descripcion de la tabla producto.
- Una vez creado el índice del ejercicio anterior realiza las siguientes consultas haciendo uso de la función MATCH, para buscar todos los productos que:
  - Contienen la palabra planta en el nombre o en la descripción. - Realice una consulta para cada uno de los modos de búsqueda full-text que existen en MySQL (IN NATURAL LANGUAGE MODE, IN BOOLEAN MODE y WITH QUERY EXPANSION) y compare los resultados que ha obtenido en cada caso.
  - Contienen la palabra planta seguida de cualquier carácter o conjunto de caracteres, en el nombre o en la descripción.
  - Empiezan con la palabra planta en el nombre o en la descripción.
  - Contienen la palabra tronco o la palabra árbol en el nombre o en la descripción.
  - Contienen la palabra tronco y la palabra árbol en el nombre o en la descripción.
  - Contienen la palabra tronco pero no contienen la palabra árbol en el nombre o en la descripción.
  - Contiene la frase proviene de las costas en el nombre o en la descripción.
  - Crea un índice de tipo INDEX compuesto por las columnas apellido_contacto y nombre_contacto de la tabla cliente.
  - Una vez creado el índice del ejercicio anterior realice las siguientes consultas haciendo uso de EXPLAIN:
    - Busca el cliente Javier Villar. ¿Cuántas filas se han examinado hasta encontrar el resultado?
    - Busca el cliente anterior utilizando solamente el apellido Villar.
    - ¿Cuántas filas se han examinado hasta encontrar el resultado?
    - Busca el cliente anterior utilizando solamente el nombre Javier. ¿Cuántas filas se han examinado hasta encontrar el resultado? ¿Qué ha ocurrido en este caso?
  - Calcula cuál podría ser un buen valor para crear un índice sobre un prefijo de la columna nombre_cliente de la tabla cliente. Tenga en cuenta que un buen valor será aquel que nos permita utilizar el menor número de caracteres para diferenciar todos los valores que existen en la columna sobre la que estamos creando el índice.
    - En primer lugar calculamos cuántos valores distintos existen en la columna nombre_cliente. Necesitarás utilizar la función COUNT y DISTINCT.
    - Haciendo uso de la función LEFT ve calculando el número de caracteres que necesitas utilizar como prefijo para diferenciar todos los valores de la columna. Necesitarás la función COUNT, DISTINCT y LEFT.
    - Una vez que hayas encontrado el valor adecuado para el prefijo, crea el índice sobre la columna nombre_cliente de la tabla cliente.
    - Ejecuta algunas consultas de prueba sobre el índice que acabas de crear.

### Vistas

- Escriba una vista que se llame listado_pagos_clientes que muestre un listado donde aparezcan todos los clientes y los pagos que ha realizado cada uno de ellos. La vista deberá tener las siguientes columnas: nombre y apellidos del cliente concatenados, teléfono, ciudad, pais, fecha_pago, total del pago, id de la transacción

- Escriba una vista que se llame listado_pedidos_clientes que muestre un listado donde aparezcan todos los clientes y los pedidos que ha realizado cada uno de ellos. La vista deberá tener las siguientes columnas: código del cliente, nombre y apellidos del cliente concatendados, teléfono, ciudad, pais, código del pedido, fecha del pedido, fecha esperada, fecha de entrega y la cantidad total del pedido, que será la suma del producto de todas las cantidades por el precio de cada unidad, que aparecen en cada línea de pedido.

- Utilice las vistas que ha creado en los pasos anteriores para devolver un listado de los clientes de la ciudad de Madrid que han realizado pagos.

- Utilice las vistas que ha creado en los pasos anteriores para devolver un listado de los clientes que todavía no han recibido su pedido.

- Utilice las vistas que ha creado en los pasos anteriores para calcular el número de pedidos que se ha realizado cada uno de los clientes.

- Utilice las vistas que ha creado en los pasos anteriores para calcular el valor del pedido máximo y mínimo que ha realizado cada cliente.

- Modifique el nombre de las vista listado_pagos_clientes y asígnele el nombre listado_de_pagos. Una vez que haya modificado el nombre de la vista ejecute una consulta utilizando el nuevo nombre de la vista para comprobar que sigue funcionando correctamente.

- Elimine las vistas que ha creado en los pasos anteriores.

>__Nota__: ___Realiza cada una de las acciones e indica la salida de estas___.
## Referencias

- [Apuntes sobre índices](../../Indices.md).

</div>