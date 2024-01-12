<div align="justify">

# DML

El __DML (Data Manipulation Language)__ o _Lenguaje de Manipulación de Datos_ es la parte de SQL dedicada a la _manipulación de los datos_. Las sentencias DML son las siguientes:

- __SELECT__: se utiliza para realizar consultas y extraer información de la base de datos.
- __INSERT__: se utiliza para insertar registros en las tablas de la base de datos.
- __UPDATE__: se utiliza para actualizar los registros de una tabla.
- __DELETE__: se utiliza para eliminar registros de una tabla.
En este sección nos vamos a centrar en el uso de la sentencia __SELECT__.

## Consultas básicas sobre una tabla

### Sintaxis de la instrucción SELECT

Para empezar con consultas sencillas podemos simplificar la definición anterior y quedarnos con la siguiente:

```sql
SELECT [DISTINCT] select_expr [, select_expr ...]
FROM table_references
WHERE where_condition
GROUP BY {col_name | expr | position} [ASC | DESC], ... [WITH ROLLUP]
HAVING having_condition
ORDER BY {col_name | expr | position} [ASC | DESC], ...
LIMIT {[offset,] row_COUNT | row_COUNT OFFSET offset};
```

___Es muy importante conocer en qué orden se ejecuta cada una de las cláusulas que forman la sentencia SELECT___. El orden de ejecución es el siguiente:

- Cláusula __FROM__.
  - Cláusula __WHERE__ (Es opcional, puede ser que no aparezca).
  - Cláusula __GROUP BY__ (Es opcional, puede ser que no aparezca).
  - Cláusula __HAVING__ (Es opcional, puede ser que no aparezca).
- Cláusula __SELECT__.
  - Cláusula __ORDER BY__ (Es opcional, puede ser que no aparezca).
  - Cláusula __LIMIT__ (Es opcional, puede ser que no aparezca).

</div>