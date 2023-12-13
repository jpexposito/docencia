<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Con la cláusula __distinct__ se especifica que los registros con ciertos datos duplicados sean obviadas en el resultado. Por ejemplo, queremos conocer todos los autores de los cuales tenemos libros, si utilizamos esta sentencia:

```sql
 select autor from libro;
```

Aparecen repetidos. Para obtener la lista de autores sin repetición usamos:

```sql
 select distinct autor from libro;
```

También podemos tipear:

```sql
 select autor from libro
  group by autor;
```

Note que en los tres casos anteriores aparece __null__ como un valor para __autor__· Si sólo queremos la lista de autores conocidos, es decir, no queremos incluir __null__ en la lista, podemos utilizar la sentencia siguiente:

```sql
 select distinct autor from libro
  where autor is not null;
```
Para contar los distintos autores, sin considerar el valor __null__ usamos:

```sql
 select count(distinct autor)
  from libro;
```

Note que si contamos los autores sin __distinct__, no incluirá los valores __null__ pero si los repetidos:

```sql
 select count(autor)
  from libro;
```  
Esta sentencia cuenta los registros que tienen autor.

Podemos combinarla con __where__. Por ejemplo, queremos conocer los distintos autores de la editorial __Planeta__:

```sql
 select distinct autor from libro
  where editorial='Planeta';
```

También puede utilizarse con __group by__ para contar los diferentes autores por editorial:

```sql
 select editorial, count(distinct autor)
  from libro
  group by editorial;
```

La cláusula __distinct__ afecta a todos los campos presentados. Para mostrar los títulos y editoriales de los libros sin repetir títulos ni editoriales, usamos:

```sql
 select distinct titulo,editorial
  from libro
  order by titulo;
```  
Note que los registros no están duplicados, aparecen títulos iguales pero con editorial diferente, cada registro es diferente.

> __Nota__. Entonces, __distinct__ elimina registros duplicados.
</div>