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

Hay que tener en cuenta que el resultado de una consulta siempre será una tabla de datos, que puede tener una o varias columnas y ninguna, una o varias filas.

El hecho de que el resultado de una consulta sea una tabla es muy interesante porque nos permite realizar cosas como almacenar los resultados como una nueva en la base de datos. También será posible combinar el resultado de dos o más consultas para crear una tabla mayor con la unión de los dos resultados. Además, los resultados de una consulta también pueden consultados por otras nuevas consultas.

### Cláusula SELECT

Nos permite indicar cuáles serán las columnas que tendrá la tabla de resultados de la consulta que estamos realizando. Las opciones que podemos indicar son las siguientes:
- El __nombre__ de una columna de la tabla sobre la que estamos realizando la consulta. Será una columna de la tabla que aparece en la cláusula __FROM__.
- Una constante que aparecerá en todas las filas de la tabla resultado.
- Una expresión que nos permite calcular nuevos valores.

#### Cómo obtener los datos de todas las columnas de una tabla (SELECT *)

Vamos a crear en primer lugar la siguiente bbdd.

```sql
-- Crear la tabla 'alumno'
CREATE TABLE alumno (
    id INTEGER PRIMARY KEY,
    nombre TEXT,
    apellido1 TEXT,
    apellido2 TEXT,
    fecha_nacimiento DATE,
    tiene_hermanos TEXT,
    telefono INTEGER
);

-- Insertar datos en la tabla 'alumno'
INSERT INTO alumno VALUES(1, 'María', 'Sánchez', 'Pérez', '1990-12-01', 'no', NULL);
INSERT INTO alumno VALUES(2, 'Juan', 'Sáez', 'Vega', '1998-04-02', 'no', 618253876);
INSERT INTO alumno VALUES(3, 'Pepe', 'Ramírez', 'Gea', '1988-01-03', 'no', NULL);
INSERT INTO alumno VALUES(4, 'Lucía', 'Sánchez', 'Ortega', '1993-06-13', 'sí', 678516294);
INSERT INTO alumno VALUES(5, 'Paco', 'Martínez', 'López', '1995-11-24', 'no', 692735409);
INSERT INTO alumno VALUES(6, 'Irene', 'Gutiérrez', 'Sánchez', '1991-03-28', 'sí', NULL);
INSERT INTO alumno VALUES(7, 'Cristina', 'Fernández', 'Ramírez', '1996-09-17', 'no', 628349590);
INSERT INTO alumno VALUES(8, 'Antonio', 'Carretero', 'Ortega', '1994-05-20', 'sí', 612345633);
INSERT INTO alumno VALUES(9, 'Manuel', 'Domínguez', 'Hernández', '1999-07-08', 'no', NULL);
INSERT INTO alumno VALUES(10, 'Daniel', 'Moreno', 'Ruiz', '1998-02-03', 'no', NULL);
```

Si deseamos obtener el siguiente resultado:

| id  | nombre    | apellido1  | apellido2 | fecha_nacimiento | tiene_hermanos | telefono   |
|----|------------|------------|-----------|------------------|-----------------|------------|
| 1  | María      | Sánchez    | Pérez     | 1990-12-01       | no              |            |
| 2  | Juan       | Sáez       | Vega      | 1998-04-02       | no              | 618253876  |
| 3  | Pepe       | Ramírez    | Gea       | 1988-01-03       | no              |            |
| 4  | Lucía      | Sánchez    | Ortega    | 1993-06-13       | sí              | 678516294  |
| 5  | Paco       | Martínez   | López     | 1995-11-24       | no              | 692735409  |
| 6  | Irene      | Gutiérrez  | Sánchez   | 1991-03-28       | sí              |            |
| 7  | Cristina   | Fernández  | Ramírez   | 1996-09-17       | no              | 628349590  |
| 8  | Antonio    | Carretero  | Ortega    | 1994-05-20       | sí              | 612345633  |
| 9  | Manuel     | Domínguez  | Hernández | 1999-07-08       | no              |            |
| 10 | Daniel     | Moreno     | Ruiz      | 1998-02-03       | no              |            |

Hemos de ejecutar el siguiente comando:

```sql
SELECT * FROM alumno;
```

>__Nota__: El __carácter *__ es un comodín que utilizamos para indicar que __queremos seleccionar todas las columnas de la tabla__. La consulta anterior devolverá __todos los datos de la tabla__.

#### Cómo obtener los datos de algunas columnas de una tabla

Si queremos obtener los datos de una única columna, por ejemplo __nombre__, debemos ejecutar el comando:

```sql
select nombre from alumno;
```

Con la siguiente salida:

| nombre    |
|------------|
| María      |
| Juan       |
| Pepe       |
| Lucía      |
| Paco       |
| Irene      |
| Cristina   |
| Antonio    |
| Manuel     |
| Daniel     |

>__Nota__: Si queremos seleccionar un varias columnas sólo debemos indicar nombre de las columnas separadas por __,__.

```sql
select nombre, apellido1, apellido2 from alumno
```

Con la siguiente salida:

| nombre    | apellido1  | apellido2 |
|------------|------------|-----------|
| María      | Sánchez    | Pérez     |
| Juan       | Sáez       | Vega      |
| Pepe       | Ramírez    | Gea       |
| Lucía      | Sánchez    | Ortega    |
| Paco       | Martínez   | López     |
| Irene      | Gutiérrez  | Sánchez   |
| Cristina   | Fernández  | Ramírez   |
| Antonio    | Carretero  | Ortega    |
| Manuel     | Domínguez  | Hernández |
| Daniel     | Moreno     | Ruiz      |


</div>