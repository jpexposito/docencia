<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Existen en SQLite funciones que nos permiten contar registros, calcular sumas, promedios, obtener valores máximos y mínimos. Estas funciones se denominan funciones de agregado y operan sobre un conjunto de valores (registros), no con datos individuales y devuelven un único valor.

Imaginemos que nuestra tabla __libros__ contiene muchos registros. Para averiguar la cantidad sin necesidad de contarlos manualmente usamos la función __count()__:

```sql
 select count(*)
  from libro;
```

La función __count()__ cuenta la cantidad de registros de una tabla, incluyendo los que tienen valor nulo.

También podemos utilizar esta función junto con la cláusula __where__ para una consulta más específica. Queremos saber la cantidad de libros de la editorial __Planeta__:

```sql
 select count(*)
  from libro
  where editorial='Planeta';
```

Para contar los registros que tienen precio (sin tener en cuenta los que tienen valor nulo), usamos la función __count()__ y en los paréntesis colocamos el nombre del campo que necesitamos contar:

```sql
 select count(precio)
  from libro;
```

Note que __count(*)__ retorna la cantidad de registros de una tabla (incluyendo los que tienen valor __null__) mientras que __count(precio)__ retorna la cantidad de registros en los cuales el campo __precio__ no es nulo. No es lo mismo. __count(*)__ cuenta registros, si en lugar de un asterisco colocamos como argumento el nombre de un campo, se contabilizan los registros cuyo valor en ese campo NO es nulo.
</div>