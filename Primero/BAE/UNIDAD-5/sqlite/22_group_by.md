<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>
Hemos aprendido que las funciones de agregado permiten realizar varios cálculos operando con conjuntos de registros.

Las funciones de agregado solas producen un valor de resumen para todos los registros de un campo. Podemos generar valores de resumen para un solo campo, combinando las funciones de agregado con la cláusula "group by", que agrupa registros para consultas detalladas.

Queremos saber la cantidad de libros de cada editorial, podemos tipear la siguiente sentencia:

```sql
 select count(*) from libro
  where editorial='Planeta';
```

y repetirla con cada valor de "editorial":

```sql
 select count(*) from libro
  where editorial='Emece';
 select count(*) from libro
  where editorial='Paidos';
 ```

Pero hay otra manera, utilizando la cláusula "group by":

```sql
 select editorial, count(*)
  from libro
  group by editorial;
```

La instrucción anterior solicita que muestre el nombre de la editorial y cuente la cantidad agrupando los registros por el campo "editorial". Como resultado aparecen los nombres de las editoriales y la cantidad de registros para cada valor del campo.

Los valores nulos se procesan como otro grupo.

Entonces, para saber la cantidad de libros que tenemos de cada editorial, utilizamos la función "count()", agregamos "group by" (que agrupa registros) y el campo por el que deseamos que se realice el agrupamiento, también colocamos el nombre del campo a recuperar; la sintaxis básica es la siguiente:

```sql
 select CAMPO, FUNCIONDEAGREGADO
  from NOMBRETABLA
  group by CAMPO;
```

También se puede agrupar por más de un campo, en tal caso, luego del "group by" se listan los campos, separados por comas. Todos los campos que se especifican en la cláusula "group by" deben estar en la lista de selección.

```sql
 select CAMPO1, CAMPO2, FUNCIONDEAGREGADO
  from NOMBRETABLA
  group by CAMPO1,CAMPO2;
```

Para obtener la cantidad libros con precio no nulo, de cada editorial utilizamos la función "count()" enviándole como argumento el campo "precio", agregamos "group by" y el campo por el que deseamos que se realice el agrupamiento (editorial):

```sql
 select editorial, count(precio)
  from libro
  group by editorial;
```  

Como resultado aparecen los nombres de las editoriales y la cantidad de registros de cada una, sin contar los que tienen precio nulo.

Recuerde la diferencia de los valores que retorna la función "count()" cuando enviamos como argumento un asterisco o el nombre de un campo: en el primer caso cuenta todos los registros incluyendo los que tienen valor nulo, en el segundo, los registros en los cuales el campo especificado es no nulo.

Para conocer el total en dinero de los libros agrupados por editorial:

```sql
 select editorial, sum(precio)
  from libro
  group by editorial;
```

Para saber el máximo y mínimo valor de los libros agrupados por editorial:

```sql
 select editorial,
  max(precio) as mayor,
  min(precio) as menor
  from libro
  group by editorial;
```

Para calcular el promedio del valor de los libros agrupados por editorial:

```sql
 select editorial, avg(precio)
  from libro
  group by editorial;
```

Es posible limitar la consulta con "where".

Si incluye una cláusula "where", sólo se agrupan los registros que cumplen las condiciones.

Vamos a contar y agrupar por editorial considerando solamente los libros cuyo precio sea menor a 30 pesos:

```sql
 select editorial, count(*)
  from libro
  where precio<30
  group by editorial;
```

</div>