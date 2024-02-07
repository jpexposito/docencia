<div align="justify">

# Where and Join

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

## Where

### Función

La cláusula __WHERE__ se utiliza para filtrar filas de una tabla basándose en una condición específica.

### Uso

Se aplica después de la cláusula FROM en una consulta SQL.

### Sintaxis

La sintaxis básica es __SELECT columnas FROM tabla WHERE condición__;, donde _condición_ es la expresión lógica que determina qué filas serán seleccionadas.

### Ejemplo

```sql
SELECT * FROM coches WHERE color = 'rojo';
```

## Inner Join

### Función

La cláusula INNER JOIN se utiliza para combinar filas de dos o más tablas basándose en una condición de unión específica.

### Uso

Se utiliza para unir tablas en función de columnas que tienen valores coincidentes.

### Sintaxis

La sintaxis básica es __SELECT columnas FROM tabla1 INNER JOIN tabla2 ON tabla1.columna = tabla2.columna;__, donde columna es la columna común que se utiliza para unir las tablas.

### Ejemplo

```sql
SELECT clientes.nombre, coches.modelo FROM clientes INNER JOIN coches ON clientes.id_coche = coches.id;
```

## Similitudes && Diferencias

| Aspecto      | WHERE                                                | INNER JOIN                                           |
|--------------|------------------------------------------------------|------------------------------------------------------|
| Función      | Se utiliza para filtrar filas de una tabla.         | Se utiliza para combinar filas de múltiples tablas. |
| Uso          | Se aplica después de la cláusula FROM.               | Se utiliza para unir tablas antes de aplicar condiciones adicionales.|
| Sintaxis     | SELECT columnas FROM tabla WHERE condición;          | SELECT columnas FROM tabla1 INNER JOIN tabla2 ON condición; |
| Ejemplo      | SELECT * FROM coches WHERE color = 'rojo';          | SELECT clientes.nombre, coches.modelo FROM clientes INNER JOIN coches ON clientes.id_coche = coches.id; |

</div>