<div align="justify">

# Subconsultas

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Las __subconsultas__ (también conocidas como _subselects o consultas anidadas_) en SQL son consultas que se incorporan __dentro__ de otras __consultas más grandes__, __permitiendo realizar operaciones más complejas y avanzadas__. Una subconsulta se utiliza dentro de una cláusula __WHERE, FROM, HAVING__, o __SELECT__ de otra consulta __principal__.

Hay __dos tipos__ principales de __subconsultas__: las subconsultas __correlacionadas__ y las subconsultas __no correlacionadas__.

##  Subconsultas No Correlacionadas

_La subconsulta_ ___NO___ _depende de la consulta principal y puede ejecutarse de forma independiente_.

```sql
SELECT nombre
FROM clientes
WHERE id_cliente IN (SELECT id_cliente FROM ventas);
```

_La subconsulta devuelve una lista de id_cliente que ha realizado alguna venta, y luego la consulta principal selecciona los nombres de los clientes cuyos IDs están en esa lista_.

## Subconsultas Correlacionadas

_La subconsulta_ ___DEPENDE___ _de la consulta principal y se ejecuta una vez por cada fila procesada en la consulta principal_.

```sql
SELECT modelo, precio
FROM coches c
WHERE precio > (SELECT AVG(precio) FROM coches WHERE marca = c.marca);
```

_La subconsulta calcula el precio promedio de los coches de la misma marca para cada fila de la consulta principal, y luego la consulta principal selecciona los coches cuyo precio es mayor que el promedio de su propia marca_.

Las subconsultas se utilizan para realizar varias tareas, incluyendo:

- __Filtrar datos__: Usar una subconsulta en la cláusula __WHERE__ para filtrar filas basadas en un conjunto de resultados de otra consulta.

- __Realizar operaciones de comparación__: Comparar valores de una columna con el resultado de una subconsulta.

- __Realizar cálculos más complejos__: Utilizar subconsultas en la cláusula SELECT para realizar cálculos más avanzados.

- __Trabajar con múltiples tablas__: Utilizar subconsultas para relacionar o filtrar datos entre múltiples tablas en una base de datos.

Las subconsultas son una herramienta poderosa y versátil en SQL, pero es importante usarlas de manera eficiente y comprender cómo afectan el rendimiento de las consultas. 

>__Nota__: _Además, la optimización y la escritura clara de subconsultas pueden contribuir significativamente a la_ ___legibilidad___ _y_ ___mantenimiento___ _del código SQL_.

</div>