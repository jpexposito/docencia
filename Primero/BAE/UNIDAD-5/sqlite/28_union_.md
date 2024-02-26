<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

La cláusula __UNION__ se utiliza para combinar los resultados de dos o más consultas en un solo conjunto de resultados. 

```sql
SELECT columnas FROM tabla1
UNION
SELECT columnas FROM tabla2;
```

La cláusula __UNION__ combina los resultados de las dos consultas, eliminando cualquier duplicado que pueda existir entre ellas.

>__Nota__:_Si deseas incluir duplicados, puedes usar_. ___UNION ALL___.

Las consultas dentro de un __UNION__ _deben devolver el mismo número de columnas y los tipos de datos deben ser compatibles entre sí_. Si las columnas no coinciden en número o tipo de datos, SQLite generará un error.

_El orden de las filas en el resultado del UNION no está garantizado a menos que utilices la cláusula_ ___ORDER BY___.

```sql
SELECT nombre, 'Empleado' AS tipo FROM empleados
UNION
SELECT nombre, 'Cliente' AS tipo FROM clientes
ORDER BY nombre;
```

</div>