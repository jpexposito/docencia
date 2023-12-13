<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Hemos visto que SQLite tiene una función que nos permite contar registros.

Existe además de la función count las funciones sum, min, max y avg. Todas estas funciones retornan __null__ si ningún registro cumple con la condición del __where__, excepto __count__ que en tal caso retorna cero.

El tipo de dato del campo determina las funciones que se pueden emplear con ellas.

Las relaciones entre las funciones de agrupamiento y los tipos de datos es la siguiente:
  - __count__: se puede emplear con cualquier tipo de dato.
  - __min y max__: con cualquier tipo de dato.
  - __sum y avg__: sólo en campos de tipo numérico.

La función __sum()__ retorna la suma de los valores que contiene el campo especificado. Si queremos saber la cantidad total de libros que tenemos disponibles para la venta, debemos sumar todos los valores del campo __cantidad__:

```sql
 select sum(cantidad)
  from libro;
```

Para averiguar el valor máximo o mínimo de un campo usamos las funciones __max()__ y __min()__ respectivamente.
Queremos saber cuál es el mayor precio de todos los libros:

```sql
 select max(precio)
  from libro;
```

Entonces, dentro del paréntesis de la función colocamos el nombre del campo del cuál queremos el máximo valor.

La función __avg()__ retorna el valor promedio de los valores del campo especificado. Queremos saber el promedio del precio de los libros referentes a __PHP__:

```sql
 select avg(precio)
  from libro
  where titulo like '%PHP%';
```

Ahora podemos entender porque estas funciones se denominan __funciones de agrupamiento__, porque operan sobre conjuntos de registros, no con datos individuales.

Tratamiento de los valores nulos:

Si realiza una consulta con la función __count__ de un campo que contiene 18 registros, 2 de los cuales contienen valor nulo, el resultado devuelve un total de 16 filas porque no considera aquellos con valor nulo.

> __Nota__. Todas las funciones de agregado, excepto __count(*)__, excluye los valores nulos de los campos. __count(*)__ cuenta todos los registros, incluidos los que contienen __null__.

</div>