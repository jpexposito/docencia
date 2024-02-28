<div align="justify">

# Tienda Informática

<div align="center">
<img src="https://ultimainformatica.com/img/cms/TIENDAS/NIVARIA/CC%20NIVARIA_%208FEB_18_WEB.jpg" width="600px"/>
</div>

Siguiento con la tarea anterior, recordando que las tablas tenían la estructura siguiente:

producto:
  - codigo: entero
  - nombre: texto
  - precio: real
  - codigo_fabricante: entero

fabricante
  - codigo: entero 
  - nombre: texto


Almacena el contenido en un fichero y realiza la inserción a través de la sentencia de __sqlite__ que consideres adecuada.
>Nota: Se debe de leer el fichero, utiliza el comando __.help__ para conocer el comando adecuado.

___Apollate en las funciones del lenguaje sql y sqlite__:
- [Funciones de core](https://www.sqlite.org/lang_corefunc.html). 
- [Funciones de fechas](https://www.sqlite.org/lang_datefunc.html).

Realiza las siguientes consultas, indicando, la consulta y la salida que has obtenido.

## Consultas Multitabla:

### Consultas con multitabla con clausula where:

- Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos.
- Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos. Ordene el resultado por el nombre del fabricante, por orden alfabético.
- Devuelve una lista con el identificador del producto, nombre del producto, identificador del fabricante y nombre del fabricante, de todos los productos de la base de datos.
- Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más barato.
- Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
- Devuelve una lista de todos los productos del fabricante Lenovo.
- Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€.
- Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packardy Seagate. Sin utilizar el operador IN.
- Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packardy Seagate. Utilizando el operador IN.
- Devuelve un listado con el nombre y el precio de todos los productos de los fabricantes cuyo nombre termine por la vocal e.
- Devuelve un listado con el nombre y el precio de todos los productos cuyo nombre de fabricante contenga el carácter w en su nombre.
- Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos que tengan un precio mayor o igual a 180€. Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente)
- Devuelve un listado con el identificador y el nombre de fabricante, solamente de aquellos fabricantes que tienen productos asociados en la base de datos.

### Consultas con multitabla con LEFT JOIN y RIGHT JOIN
- Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene cada uno de ellos. El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
- Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
>__Nota:__¿Pueden existir productos que no estén relacionados con un fabricante? Justifique su respuesta.

### Consultas realizando calculos

- Calcula el número total de productos que hay en la tabla productos.
- Calcula el número total de fabricantes que hay en la tabla fabricante.
- Calcula el número de valores distintos de identificador de fabricante aparecen en la tabla productos.
- Calcula la media del precio de todos los productos.
- Calcula el precio más barato de todos los productos.
- Calcula el precio más caro de todos los productos.
- Lista el nombre y el precio del producto más barato.
- Lista el nombre y el precio del producto más caro.
- Calcula la suma de los precios de todos los productos.
- Calcula el número de productos que tiene el fabricante Asus.
- Calcula la media del precio de todos los productos del fabricante Asus.
- Calcula el precio más barato de todos los productos del fabricante Asus.
- Calcula el precio más caro de todos los productos del fabricante Asus.
- Calcula la suma de todos los productos del fabricante Asus.
- Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial.
- Muestra el número total de productos que tiene cada uno de los fabricantes. El listado también debe incluir los fabricantes que no tienen ningún producto. El resultado mostrará dos columnas, una con el nombre del fabricante y otra con el número de productos que tiene. Ordene el resultado descendentemente por el número de productos.
- Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes. El resultado mostrará el nombre del fabricante junto con los datos que se solicitan.
- Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200€. No es necesario mostrar el nombre del fabricante, con el identificador del fabricante es suficiente.
- Muestra el nombre de cada fabricante, junto con el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200€. Es necesario mostrar el nombre del fabricante.
- Calcula el número de productos que tienen un precio mayor o igual a 180€.
- Calcula el número de productos que tiene cada fabricante con un precio mayor o igual a 180€.
- Lista el precio medio los productos de cada fabricante, mostrando solamente el identificador del fabricante.
- Lista el precio medio los productos de cada fabricante, mostrando solamente el nombre del fabricante.
- Lista los nombres de los fabricantes cuyos productos tienen un precio medio mayor o igual a 150€.
- Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.
- Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €. No es necesario mostrar el nombre de los fabricantes que no tienen productos que cumplan la condición.

> Ejemplo del resultado esperado:

| nombre	| total |
| ----- |  ----- |
| Lenovo | 2 |
| .... | .. |

- Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €. El listado debe mostrar el nombre de todos los fabricantes, es decir, si hay algún fabricante que no tiene productos con un precio superior o igual a 220€ deberá aparecer en el listado con un valor igual a 0 en el número de productos.

Ejemplo del resultado esperado:

| nombre	| total |
| ----- |  ----- |
| Lenovo | 2 |
| .... | .. |

- Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 1000 €.
- Devuelve un listado con el nombre del producto más caro que tiene cada fabricante. El resultado debe tener tres columnas: nombre del producto, precio y nombre del fabricante. El resultado tiene que estar ordenado alfabéticamente de menor a mayor por el nombre del fabricante.

### Subconsultas (En la cláusula WHERE)(Sin utilizar INNER JOIN)

- Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).
- Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo. (Sin utilizar INNER JOIN).
- Lista el nombre del producto más caro del fabricante Lenovo.
- Lista el nombre del producto más barato del fabricante Hewlett-Packard.
- Devuelve todos los productos de la base de datos que tienen un precio mayor o igual al producto más caro del fabricante Lenovo.
- Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de todos sus productos.

### Subconsultas con ALL y ANY

- Devuelve el producto más caro que existe en la tabla producto sin hacer uso de MAX, ORDER BY ni LIMIT.
- Devuelve el producto más barato que existe en la tabla producto sin hacer uso de MIN, ORDER BY ni LIMIT.
- Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando ALL o ANY).
- Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando ALL o ANY).

### Subconsultas con IN y NOT IN

- Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando IN o NOT IN).
- Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando IN o NOT IN).

###  Subconsultas con EXISTS y NOT EXISTS

- Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando EXISTS o NOT EXISTS).
- Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando EXISTS o NOT EXISTS).

###  Subconsultas correlacionadas

- Lista el nombre de cada fabricante con el nombre y el precio de su producto más caro.
- Devuelve un listado de todos los productos que tienen un precio mayor o igual a la media de todos los productos de su mismo fabricante.
- Lista el nombre del producto más caro del fabricante Lenovo.

###  Subconsultas (En la cláusula HAVING)

- Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número de productos que el fabricante Lenovo.

## Entrega

Se debe de entregar:
 - Un fichero __Nombre_Apellido1_Apellido2.sql__ con:
   - Sentencias para la creación de la BBDD.
   - Sentencias para la inserción de los elementos.
   - Sentencias con cada una de las consultas solicitadas.
 - Salida de datos en cada una de las consultas.
 - Fichero __tienda.db__.


 __Solución__:

Sentencias sql para la creación de tablas e inserción de datos:

```sql
create table fabricante(
    codigo integer primary key,
    nombre text
);

create table producto(
    codigo integer primary key,
    nombre text,
    precio real,
    codigo_fabricante integer references fabricante(codigo)
);

INSERT INTO fabricante VALUES(1, 'Asus');
INSERT INTO fabricante VALUES(2, 'Lenovo');
INSERT INTO fabricante VALUES(3, 'Hewlett-Packard');
INSERT INTO fabricante VALUES(4, 'Samsung');
INSERT INTO fabricante VALUES(5, 'Seagate');
INSERT INTO fabricante VALUES(6, 'Crucial');
INSERT INTO fabricante VALUES(7, 'Gigabyte');
INSERT INTO fabricante VALUES(8, 'Huawei');
INSERT INTO fabricante VALUES(9, 'Xiaomi');
INSERT INTO producto VALUES(1, 'Disco duro SATA3 1TB', 86.99, 5);
INSERT INTO producto VALUES(2, 'Memoria RAM DDR4 8GB', 120, 6);
INSERT INTO producto VALUES(3, 'Disco SSD 1 TB', 150.99, 4);
INSERT INTO producto VALUES(4, 'GeForce GTX 1050Ti', 185, 7);
INSERT INTO producto VALUES(5, 'GeForce GTX 1080 Xtreme', 755, 6);
INSERT INTO producto VALUES(6, 'Monitor 24 LED Full HD', 202, 1);
INSERT INTO producto VALUES(7, 'Monitor 27 LED Full HD', 245.99, 1);
INSERT INTO producto VALUES(8, 'Portátil Yoga 520', 559, 2);
INSERT INTO producto VALUES(9, 'Portátil Ideapd 320', 444, 2);
INSERT INTO producto VALUES(10, 'Impresora HP Deskjet 3720', 59.99, 3);
INSERT INTO producto VALUES(11, 'Impresora HP Laserjet Pro M26nw', 180, 3);

```

 ### Consultas con multitabla con clausula where:

- Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos.

```sql
select producto.nombre, producto.precio, fabricante.nombre from producto, fabricante where fabricante.codigo = producto.codigo_fabricante;

-- con join
select p.nombre, p.precio, f.nombre from producto as p join fabricante as f on f.codigo = p.codigo_fabricante;

```

- Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos. Ordene el resultado por el nombre del fabricante, por orden alfabético.

```sql
select producto.nombre, producto.precio, fabricante.nombre from producto, fabricante where fabricante.codigo = producto.codigo_fabricante order by fabricante.nombre;

-- con join
select p.nombre, p.precio, f.nombre from producto as p join fabricante as f on f.codigo = p.codigo_fabricante order by f.nombre;

```

- Devuelve una lista con el identificador del producto, nombre del producto, identificador del fabricante y nombre del fabricante, de todos los productos de la base de datos.

```sql
select producto.codigo, producto.nombre, fabricante.codigo, fabricante.nombre from producto, fabricante where producto.codigo_fabricante = fabricante.codigo;

-- con join
select p.codigo, p.nombre, f.codigo, f.nombre from producto as p join fabricante as f on f.codigo = p.codigo_fabricante;

```

- Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más barato.

```sql
select p.nombre, min(p.precio) as precio, f.nombre from producto as p, fabricante as f where f.codigo = p.codigo_fabricante;

-- con subconsulta
SELECT producto.nombre, producto.precio, fabricante.nombre from fabricante, producto where producto.codigo_fabricante = fabricante.codigo and producto.precio = (SELECT min(precio) from producto);

-- con join
select p.nombre, min(p.precio) as precio, f.nombre from producto as p join fabricante as f on f.codigo = p.codigo_fabricante;
```

- Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.

```sql
select p.nombre, max(p.precio) as precio, f.nombre from producto as p, fabricante as f where f.codigo = p.codigo_fabricante;

-- con subconsulta
SELECT producto.nombre, producto.precio, fabricante.nombre from fabricante, producto where producto.codigo_fabricante = fabricante.codigo and producto.precio = (SELECT max(precio) from producto);

-- con join
select p.nombre, mmax(p.precio) as precio, f.nombre from producto as p join fabricante as f on f.codigo = p.codigo_fabricante;
```

- Devuelve una lista de todos los productos del fabricante Lenovo.

```sql
SELECT * from producto, fabricante where producto.codigo_fabricante = fabricante.codigo and fabricante.nombre = 'Lenovo';

-- coin join
select p.* from producto as p join fabricante as f on f.codigo = p.codigo_fabricante where f.nombre in ("Lenovo");

```

- Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€.

```sql
SELECT * from producto, fabricante where producto.codigo_fabricante = fabricante.codigo and fabricante.nombre = 'Crucial' and producto.precio > 200;

-- coin join
select p.* from producto as p join fabricante as f on f.codigo = p.codigo_fabricante where f.nombre in ("Crucial") and p.precio > 200;
```

- Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packardy Seagate. Sin utilizar el operador IN.

```sql
SELECT * from producto, fabricante where producto.codigo_fabricante = fabricante.codigo and (fabricante.nombre = 'Asus' or fabricante.nombre = 'Hewllet-Packad' or fabricante.nombre = 'Seagate');

-- con join
select p.* from producto as p join fabricante as f on f.codigo = p.codigo_fabricante where (f.nombre = "Asus" or f.nombre = "Hewlett-Packardy" or f.nombre = "Seagate");
```

- Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packardy Seagate. Utilizando el operador IN.

```sql
SELECT * from fabricante, producto where producto.codigo_fabricante = fabricante.codigo and fabricante.nombre in ('Asus', 'Hewlett-Packard', 'Seagete');

-- con join

select p.* from producto as p join fabricante as f on f.codigo = p.codigo_fabricante where f.nombre in ("Asus", "Hewlett-Packardy", "Seagate");
```

- Devuelve un listado con el nombre y el precio de todos los productos de los fabricantes cuyo nombre termine por la vocal e.

```sql
-- con like
select producto.nombre, producto.precio, fabricante.nombre from producto, fabricante where producto.codigo_fabricante = fabricante.codigo and fabricante.nombre like '%e';

-- con regexp
select p.nombre, p.precio from producto as p join fabricante as f on f.codigo = p.codigo_fabricante where f.nombre regexp "e$";
```

- Devuelve un listado con el nombre y el precio de todos los productos cuyo nombre de fabricante contenga el carácter w en su nombre.

```sql
-- con like
select producto.nombre, producto.precio, fabricante.nombre from producto, fabricante where producto.codigo_fabricante = fabricante.codigo and fabricante.nombre like '%w%';

-- con regexp

select p.nombre, p.precio from producto as p, fabricante as f where f.codigo = p.codigo_fabricante and f.nombre regexp ".*w.*";

-- con join
select p.nombre, p.precio from producto as p join fabricante as f on f.codigo = p.codigo_fabricante where f.nombre regexp ".*w.*";
```

- Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos que tengan un precio mayor o igual a 180€. Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente)

```sql
select producto.nombre, producto.precio, fabricante.nombre from producto, fabricante where producto.codigo_fabricante = fabricante.codigo and producto.precio >= 180 order by precio desc, producto.nombre;

-- con join

select p.nombre, p.precio, f.nombre from producto as p join fabricante as f on f.codigo = p.codigo_fabricante where p.precio >= 180 order by p.precio desc, p.nombre;
```

- Devuelve un listado con el identificador y el nombre de fabricante, solamente de aquellos fabricantes que tienen productos asociados en la base de datos.

```sql
select fabricante.codigo, fabricante.nombre from fabricante, producto where fabricante.codigo = producto.codigo_fabricante; 

-- con join
select f.codigo, f.nombre from producto as p join fabricante as f on f.codigo = p.codigo_fabricante where p.codigo_fabricante is not null; 

```

### Consultas con multitabla con LEFT JOIN y RIGHT JOIN
- Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene cada uno de ellos. El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.

```sql
select * from fabricante as f left join producto as p on f.codigo = p.codigo_fabricante;
```

- Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
>__Nota:__¿Pueden existir productos que no estén relacionados con un fabricante? Justifique su respuesta.

```sql
select * from fabricante as f left join producto as p on f.codigo = p.codigo_fabricante where p.codigo_fabricante is null;
```

### Consultas realizando calculos

- Calcula el número total de productos que hay en la tabla productos.

```sql
select count(codigo) from producto;
```

- Calcula el número total de fabricantes que hay en la tabla fabricante.

```sql
select count(codigo) from fabricante;
```

- Calcula el número de valores distintos de identificador de fabricante aparecen en la tabla productos.

```sql
select count(distinct codigo_fabricante) from producto;
```

- Calcula la media del precio de todos los productos.

```sql
select avg(precio) from producto;
```

- Calcula el precio más barato de todos los productos.

```sql
select min(precio) from producto;
```

- Calcula el precio más caro de todos los productos.

```sql
select max(precio) from producto;
```

- Lista el nombre y el precio del producto más barato.

```sql
select nombre, min(precio) as precio from producto;
```

- Lista el nombre y el precio del producto más caro.

```sql
select nombre, max(precio) as precio from producto;
```

- Calcula la suma de los precios de todos los productos.

```sql
select sum(precio) from producto;
```

- Calcula el número de productos que tiene el fabricante Asus.

```sql
-- con in
select count(p.codigo) from producto as p, fabricante as f where p.codigo_fabricante = f.codigo and f.nombre in ("Asus");

-- con and nombre
select count(producto.precio) from producto, fabricante where fabricante.codigo = producto.codigo_fabricante and fabricante.nombre = 'Asus';
```

- Calcula la media del precio de todos los productos del fabricante Asus.

```sql
-- con and nombre
select avg(producto.precio) from producto, fabricante where fabricante.codigo = producto.codigo_fabricante and fabricante.nombre = 'Asus';

select avg(p.precio) from producto as p, fabricante as f where p.codigo_fabricante = f.codigo and f.nombre in ("Asus");
```

- Calcula el precio más barato de todos los productos del fabricante Asus.

```sql
select min(p.precio) from producto as p, fabricante as f where p.codigo_fabricante = f.codigo and f.nombre in ("Asus");
```

- Calcula el precio más caro de todos los productos del fabricante Asus.

```sql
select max(p.precio) from producto as p, fabricante as f where p.codigo_fabricante = f.codigo and f.nombre in ("Asus");
```

- Calcula la suma de todos los productos del fabricante Asus.

```sql
select sum(p.precio) from producto as p, fabricante as f where p.codigo_fabricante = f.codigo and f.nombre in ("Asus");
```

- Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial.

```sql
select max(p.precio), min(p.precio), avg(p.precio), count(p.precio) from producto as p, fabricante as f where p.codigo_fabricante = f.codigo and f.nombre in ("Crucial");
```

- Muestra el número total de productos que tiene cada uno de los fabricantes. El listado también debe incluir los fabricantes que no tienen ningún producto. El resultado mostrará dos columnas, una con el nombre del fabricante y otra con el número de productos que tiene. Ordene el resultado descendentemente por el número de productos.

```sql
-- where 
select f.nombre, count(p.codigo) as numero from fabricante as f, producto as p where p.codigo_fabricante = f.codigo or p.codigo_fabricante is null group by f.codigo order by numero desc;
---  Sin esta parte (or p.codigo_fabricante is null) no se incluyen los nulos en la clausla where
-- con join
select f.nombre, as numero from fabricante as f join producto as p on p.codigo_fabricante = f.codigo group by f.codigo order by numero desc;
```
>__Nota__: La segunda opción es mejor dado que es más eficiente y sencilla de mantener.

- Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes. El resultado mostrará el nombre del fabricante junto con los datos que se solicitan.

```sql
select f.nombre, max(p.precio), min(p.precio), avg(p.precio) from producto as p, fabricante as f where p.codigo_fabricante = f.codigo group by f.codigo;
```

- Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200€. No es necesario mostrar el nombre del fabricante, con el identificador del fabricante es suficiente.

```sql
select fabricante.codigo, max(producto.precio), min(producto.precio), avg(producto.precio), count(producto.codigo) from producto, fabricante where producto.codigo_fabricante = fabricante.codigo and producto.precio > 200;

-- con subconsulta. Evidentemente esta solución en menos eficiente
select f.codigo, max(p.precio), min(p.precio), avg(p.precio), count(p.codigo) from producto as p, fabricante as f where p.codigo_fabricante = f.codigo and p.precio > (select avg(precio) from producto where precio > 200);
```

- Muestra el nombre de cada fabricante, junto con el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200€. Es necesario mostrar el nombre del fabricante.

```sql
select f.nombre, max(p.precio), min(p.precio), avg(p.precio), count(p.codigo) from producto as p, fabricante as f where p.codigo_fabricante = f.codigo and p.precio > 200;

-- con subconsulta. Evidentemente esta solución en menos eficiente
select f.nombre, max(p.precio), min(p.precio), avg(p.precio), count(p.codigo) from producto as p, fabricante as f where p.codigo_fabricante = f.codigo and p.precio > (select avg(precio) from producto where precio > 200);
```

- Calcula el número de productos que tienen un precio mayor o igual a 180€.

```sql
select count(precio) from producto where precio >= 180;
```

- Calcula el número de productos que tiene cada fabricante con un precio mayor o igual a 180€.

```sql
select count(codigo_fabricante) from producto where precio >= 180;
```

- Lista el precio medio los productos de cada fabricante, mostrando solamente el identificador del fabricante.

```sql
select f.codigo, avg(p.precio) from producto as p, fabricante as f where p.codigo_fabricante=f.codigo group by f.codigo;
```

- Lista el precio medio los productos de cada fabricante, mostrando solamente el nombre del fabricante.

```sql
select f.nombre, avg(p.precio) from producto as p, fabricante as f where p.codigo_fabricante=f.codigo group by f.codigo;
```

- Lista los nombres de los fabricantes cuyos productos tienen un precio medio mayor o igual a 150€.

```sql
select f.nombre, avg(precio) from producto as p, fabricante as f where p.codigo_fabricante=f.codigo group by f.nombre having avg(precio) >= 150;
```

- Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.

```sql
select f.nombre, count(p.nombre) from producto as p, fabricante as f where p.codigo_fabricante=f.codigo group by f.nombre HAVING count(p.nombre) >= 2;
```

- Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €. No es necesario mostrar el nombre de los fabricantes que no tienen productos que cumplan la condición.

```sql
select f.nombre, count(p.codigo) as total from producto as p, fabricante as f where p.codigo_fabricante=f.codigo and p.precio >= 220 GROUP by f.nombre;
```

> Ejemplo del resultado esperado:

| nombre	| total |
| ----- |  ----- |
| Lenovo | 2 |
| .... | .. |

- Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €. El listado debe mostrar el nombre de todos los fabricantes, es decir, si hay algún fabricante que no tiene productos con un precio superior o igual a 220€ deberá aparecer en el listado con un valor igual a 0 en el número de productos.

Ejemplo del resultado esperado:

| nombre	| total |
| ----- |  ----- |
| Lenovo | 2 |
| .... | .. |

```sql
select f.nombre,count(f.nombre) from fabricante as f left join producto as p on pcodigo_fabricante = f.codigo where p.precio >= 220 group by f.nombre;
```
> __Nota__: En esta consulta no se puede utilizar ni la clausula where, ni el join dado que no se muestran los que tienen 0 elementos que no cumplen la condición. Es por ello que se utiliza un __left join__.

- Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 1000 €.

```sql
select f.nombre, sum(precio) from fabricante as f, producto as p where p.codigo_fabricante=f.codigo group by f.nombre having sum(precio) > 1000;
```

- Devuelve un listado con el nombre del producto más caro que tiene cada fabricante. El resultado debe tener tres columnas: nombre del producto, precio y nombre del fabricante. El resultado tiene que estar ordenado alfabéticamente de menor a mayor por el nombre del fabricante.

```sql
select p.nombre,max(p.precio), f.nombre from fabricante as f, producto as p where p.codigo_fabricante=f.codigo group by f.nombre order by f.nombre asc;

-- con subconsulta (ineficiente)
select producto.nombre, producto.precio, fabricante.nombre from fabricante, producto where producto.precio = (select max(precio) from producto) order by fabricante.nombre desc;
```
>__Nota__: Recuerda que en este caso __asc__, no es necesario ya que es por defecto.

### Subconsultas (En la cláusula WHERE)(Sin utilizar INNER JOIN)

- Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).

```sql

select p.* from producto as p, fabricante as f where f.codigo = p.codigo_fabricante and f.nombre in ("Lenovo");
```

- Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo. (Sin utilizar INNER JOIN).

```sql
select p. nombre, max(p.precio) from producto as p, fabricante as f where p.codigo_fabricante = f.codigo and f.nombre in ("Lenovo")

-- con subconsulta es más ineficiente dado que se realiza dos veces la consulta
select p.* from producto as p, fabricante as f where f.codigo = p.codigo_fabricante and p.precio = (select max(p.precio) from producto as p, fabricante as f where p.codigo_fabricante = f.codigo and f.nombre in ("Lenovo"));
```

- Lista el nombre del producto más caro del fabricante Lenovo.

```sql
selec p.nombre, MAX(p.precio) from fabricante f , producto p where f.nombre ='Lenovo' and p.codigo_fabricante = f.codigo; 
```

- Lista el nombre del producto más barato del fabricante Hewlett-Packard.

```sql
selec p.nombre, min(p.precio) from fabricante f , producto p where f.nombre ='Lenovo' and p.codigo_fabricante = f.codigo;
```

- Devuelve todos los productos de la base de datos que tienen un precio mayor o igual al producto más caro del fabricante Lenovo.

```sql
select p.* from producto as p, fabricante as f where f.codigo = p.codigo_fabricante and f.nombre in ("Lenovo") and p.precio >= (select max(p.precio) from producto as p, fabricante as f where f.codigo = p.codigo_fabricante and f.nombre in ("Lenovo"));
```

- Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de todos sus productos.

```sql
select p.* from producto as p, fabricante as f where f.codigo = p.codigo_fabricante and f.nombre in ("Asus") and p.precio > (select avg(p.precio) from producto as p, fabricante as f where f.codigo = p.codigo_fabricante and f.nombre in ("Asus"));
```

### Subconsultas con ALL y ANY

- Devuelve el producto más caro que existe en la tabla producto sin hacer uso de MAX, ORDER BY ni LIMIT.

```sql
```

- Devuelve el producto más barato que existe en la tabla producto sin hacer uso de MIN, ORDER BY ni LIMIT.

```sql
```

- Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando ALL o ANY).

```sql
```

- Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando ALL o ANY).

```sql
```

> __Nota__: Por SQLITE no se puede realizar las cosultas con estos operandos.

### Subconsultas con IN y NOT IN

- Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando IN o NOT IN).

```sql
select nombre from fabricante where codigo in (select codigo_fabricante from producto);
```

- Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando IN o NOT IN).

```sql
select nombre from fabricante where codigo not in (select codigo_fabricante from producto);
```

###  Subconsultas con EXISTS y NOT EXISTS

- Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando EXISTS o NOT EXISTS).

```sql
select nombre from fabricante as f where exists (select 1 from producto where f.codigo = codigo_fabricante);
```

- Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando EXISTS o NOT EXISTS).

```sql
select nombre from fabricante as f where not exists (select * from producto where f.codigo = codigo_fabricante);
```

###  Subconsultas correlacionadas

- Lista el nombre de cada fabricante con el nombre y el precio de su producto más caro.

```sql
select f.nombre, p.nombre, p.precio from producto as p, fabricante as f where p.codigo_fabricante=f.codigo group by f.nombre;
```

- Devuelve un listado de todos los productos que tienen un precio mayor o igual a la media de todos los productos de su mismo fabricante.

```sql
select f.nombre, p.nombre, max(p.precio) from fabricante as f, producto as p where p.codigo_fabricante=f.codigo and f.nombre=(select nombre from fabricante where nombre="Lenovo");
```

- Lista el nombre del producto más caro del fabricante Lenovo.

```sql
sqlite> SELECT p.nombre, max(p.precio) from fabricante as f, producto as p where p.codigo_fabricante=f.codigo and f.nombre=(SELECT nombre from fabricante where nombre="Lenovo");
```

###  Subconsultas (En la cláusula HAVING)

- Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número de productos que el fabricante Lenovo.

```sql
select f.nombre, count(p.nombre) from fabricante as f, producto as p where p.codigo_fabricante=f.codigo group by f.nombre having count(p.nombre) = (select count(p.nombre) from fabricante as f, producto as p where p.codigo_fabricante=f.codigo and f.nombre = "Lenovo");
```
