<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Podemos ordenar el resultado de un "select" para que los registros se muestren ordenados por algún campo, para ello usamos la cláusula "order by".

Por ejemplo, recuperamos los registros de la tabla "libro" ordenados por el título:

```sql
select codigo,titulo,autor,editorial,precio from libro order by titulo;
```

Aparecen los registros ordenados alfabéticamente por el campo especificado.

También podemos colocar el número de orden del campo por el que queremos que se ordene en lugar de su nombre. Por ejemplo, queremos el resultado del "select" ordenado por "precio":

```sql
select codigo,titulo,autor,editorial,precio from libro order by 5;
```

Por defecto, si no aclaramos en la sentencia, los ordena de manera ascendente (de menor a mayor). Podemos ordenarlos de mayor a menor, para ello agregamos la palabra clave "desc":

```sql
select codigo,titulo,autor,editorial,precio from libro order by editorial desc;
```

También podemos ordenar por varios campos, por ejemplo, por "titulo" y "editorial":

```sql
select codigo,titulo,autor,editorial,precio from libro order by titulo, editorial;
```

Incluso, podemos ordenar en distintos sentidos, por ejemplo, por "titulo" en sentido ascendente y "editorial" en sentido descendente:

```sql
select codigo,titulo,autor,editorial,precio 
  from libro order by titulo asc, editorial desc;
```

Debe aclararse al lado de cada campo, pues estas palabras claves afectan al campo inmediatamente anterior.

Es posible ordenar por un campo que no se lista en la selección:

```sql
select titulo, autor
  from libro
  order by precio;
```

Se permite ordenar por valores calculados o expresiones:

```sql
select titulo, autor, editorial, precio+(precio*0.1) as preciocondescuento
  from libro
  order by preciocondescuento;
```

</div>