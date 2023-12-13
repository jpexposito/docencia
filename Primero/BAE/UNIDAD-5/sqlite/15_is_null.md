<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Hemos aprendido los operadores relacionales:
 - __=__ (igual)
 - __<>__ (distinto)
 - __>__ (mayor)
 - __<__ (menor)
 - __>=__ (mayor o igual)
 - __<=__ (menor o igual)

Existen otro operador que podemos utilizar en una condición: __is null__.

Se emplea el operador __is null__ para recuperar los registros en los cuales esté almacenado el valor __null__ en un campo específico:

```sql
 select * from libro
  where editorial is null;
```
Para obtener los registros que no contiene __null__, se puede emplear __is not null__, esto mostrará los registros con valores conocidos:

```sql
select * from libro where precio is not null;  
```

</div>