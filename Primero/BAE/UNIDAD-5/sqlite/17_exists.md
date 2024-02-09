<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Se utiliza __exists__ para verificar si una subconsulta devuelve algún resultado. La sintaxis general es la siguiente:.

```sql
SELECT column1, column2, ...
FROM table_name
WHERE EXISTS (subquery);
```

>__Nota__: _¿Cúal es la principal diferencia con el [in](17_in.md)? Como puedes observar, en el in damos un conjunto de valores, y aquí provehemos una subconsulta para realizar el filtrado. Muy similar al in pero no igual_.

Aquí, __subquery__ _es una consulta SQL que se ejecuta dentro de la cláusula_ ___exists___. La consulta principal (en el ejemplo anterior, el SELECT principal) solo devolverá filas si la subconsulta devuelve algún resultado.

__La subconsulta puede ser cualquier consulta SQL válida__, como una selección simple de datos de una tabla, una combinación de tablas, una agregación de datos, etc. El resultado de la subconsulta no se usa directamente en la consulta principal; en su lugar, se utiliza para determinar si existen filas que cumplan ciertas condiciones.

Por ejemplo, supongamos que tienes una tabla llamada clientes y quieres encontrar todos los pedidos que existen para los clientes que tengan al menos un pedido. Puedes usar __exists__ para lograrlo de la siguiente manera:

```sql
SELECT *
FROM pedidos
WHERE EXISTS (
    SELECT 1
    FROM clientes
    WHERE clientes.cliente_id = pedidos.cliente_id
);
```

_Esta consulta seleccionará todos los pedidos (pedidos) donde exista al menos una coincidencia en la tabla clientes utilizando el_ ___cliente_id___.

>___En resumen___, ___exists___ _es una cláusula útil para filtrar resultados en función de si una subconsulta devuelve algún resultado o no_.

</div>