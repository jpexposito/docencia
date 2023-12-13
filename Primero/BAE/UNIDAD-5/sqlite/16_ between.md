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

Otro operador relacional es __between__, trabaja con intervalos de valores.

Hasta ahora, para recuperar de la tabla __libro__ los libros con precio mayor o igual a 20 y menor o igual a 40, usamos 2 condiciones unidas por el operador lógico __and__:

```sql
select * from libro
  where precio>=20 and
        precio<=40;
```

Podemos usar __between__ y así simplificar la consulta:

```sql
select * from libro
  where precio between 20 and 40;
```

Averiguamos si el valor de un campo dado (precio) está entre los valores mínimo y máximo especificados (20 y 40 respectivamente) __between__ significa __entre__. 
 - Trabaja con intervalo de valores.
 - No tiene en cuenta los valores __null__.

Si agregamos el operador __not__ antes de __between__ el resultado se invierte, es decir, se recuperan los registros que están fuera del intervalo especificado. Por ejemplo, recuperamos los libros cuyo precio NO se encuentre entre 20 y 35, es decir, los menores a 15 y mayores a 25:

```sql
select * from libro
  where precio not between 20 and 35;
```

Entonces, se puede usar el operador __between__ para reducir las condiciones __where__.

</div>