<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Así como la cláusula __where__ permite seleccionar (o rechazar) registros individuales; la cláusula __having__ permite seleccionar (o rechazar) un grupo de registros.

Si queremos saber la cantidad de libros agrupados por editorial usamos la siguiente instrucción ya aprendida:

```sql
 select editorial, count(*)
  from libro
  group by editorial;
```

Si queremos saber la cantidad de libros agrupados por editorial pero considerando sólo algunos grupos, por ejemplo, los que devuelvan un valor mayor a 2, usamos la siguiente instrucción:

```sql
  select editorial, count(*) from libro
  group by editorial
  having count(*)>2;
```

Se utiliza __having__, seguido de la condición de búsqueda, para seleccionar ciertas filas retornadas por la cláusula __group by__.

Veamos otros ejemplos. Queremos el promedio de los precios de los libros agrupados por editorial, pero solamente de aquellos grupos cuyo promedio supere los 25 pesos:

```sql
 select editorial, avg(precio) from libro
  group by editorial
  having avg(precio)>25;
```

En algunos casos es posible confundir las cláusulas __where__ y __having__. Queremos contar los registros agrupados por editorial sin tener en cuenta a la editorial __Planeta__.
Analicemos las siguientes sentencias:

```sql
 select editorial, count(*) from libro
  where editorial<>'Planeta'
  group by editorial;
```

```sql
 select editorial, count(*) from libro
  group by editorial
  having editorial<>'Planeta';
```

Ambas devuelven el mismo resultado, pero son diferentes. La primera, selecciona todos los registros rechazando los de editorial __Planeta__ y luego los agrupa para contarlos. La segunda, selecciona todos los registros, los agrupa para contarlos y finalmente rechaza fila con la cuenta correspondiente a la editorial __Planeta__.

No debemos confundir la cláusula __where__ con la cláusula __having__; la primera establece condiciones para la selección de registros de un __select__; la segunda establece condiciones para la selección de registros de una salida __group by__.

Veamos otros ejemplos combinando __where__ y __having__. Queremos la cantidad de libros, sin considerar los que tienen precio nulo, agrupados por editorial, sin considerar la editorial __Planeta__:

```sql
 select editorial, count(*) from libro
  where precio is not null
  group by editorial
  having editorial<>'Planeta';
```

Aquí, selecciona los registros rechazando los que no cumplan con la condición dada en __where__, luego los agrupa por __editorial__ y finalmente rechaza los grupos que no cumplan con la condición dada en el __having__.

Se emplea la cláusula __having__ con funciones de agrupamiento, esto no puede hacerlo la cláusula __where__. Por ejemplo queremos el promedio de los precios agrupados por editorial, de aquellas editoriales que tienen más de 2 libros:

```sql
 select editorial, avg(precio) from libro
  group by editorial
  having count(*) > 2; 
```

Podemos encontrar el mayor valor de los libros agrupados y ordenados por editorial y seleccionar las filas que tengan un valor menor a 100 y mayor a 30:

```sql
 select editorial, max(precio) as mayor
  from libro
  group by editorial
  having min(precio)<100 and
  min(precio)>30
  order by editorial; 
```

Entonces, usamos la cláusula __having__ para restringir las filas que devuelve una salida __group by__. Va siempre después de la cláusula __group by__ y antes de la cláusula __order by__ si la hubiere.

</div>