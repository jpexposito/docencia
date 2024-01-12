<div align="justify">

# Funciones básicas en SQL

__SQL__ proporciona una variedad de funciones incorporadas que puedes utilizar en tus consultas. Algunas de las funciones más comunes en SQLite:

| Categoría                   | Función                           | Descripción                                               |
|-----------------------------|-----------------------------------|-----------------------------------------------------------|
| **Funciones de Texto**      | `LENGTH(str)`                     | Devuelve la longitud de la cadena.                         |
|                             | `SUBSTR(str, start, length)`       | Devuelve una subcadena de la cadena dada.                 |
|                             | `UPPER(str)`, `LOWER(str)`         | Convierte la cadena a mayúsculas o minúsculas.            |
| **Funciones Numéricas**     | `ABS(x)`                          | Devuelve el valor absoluto de x.                           |
|                             | `ROUND(x)`, `CEIL(x)`, `FLOOR(x)` | Redondeo de números.                                      |
|                             | `MAX(x, y, ...)`, `MIN(x, y, ...)` | Devuelve el valor máximo o mínimo entre los argumentos.   |
| **Funciones de Fecha y Hora**| `CURRENT_DATE`, `CURRENT_TIME`, `CURRENT_TIMESTAMP` | Devuelven la fecha, la hora o la marca de tiempo actuales. |
|                             | `DATE(str)`, `TIME(str)`, `DATETIME(str)` | Extraen partes de una fecha o marca de tiempo.             |
| **Funciones de Agregación**  | `SUM(column)`, `AVG(column)`      | Realizan operaciones de suma y promedio en una columna.    |
|                             | `COUNT(column)`, `MAX(column)`, `MIN(column)` | Realizan operaciones de conteo, máximo y mínimo en una columna. |
| **Funciones de Conversión**  | `CAST(expr AS type)`              | Convierte una expresión a un tipo de datos específico.    |
| **Funciones de Manipulación de Cadenas** | `CONCAT(str1, str2, ...)`  | Concatena cadenas.                                        |
| **Funciones de Control de Flujo** | `CASE WHEN condition THEN result END` | Realiza evaluaciones condicionales.                       |

Veamos algunas de ellas a través de ejemplos:

```sql
-- Crear la tabla 'empleados'
CREATE TABLE empleados (
    codigo INTEGER PRIMARY KEY,
    nombre TEXT,
    apellido TEXT,
    salario REAL
);

-- Insertar datos en la tabla 'empleados'
INSERT INTO empleados VALUES (1, 'Juan', 'Pérez', 50000.00);
INSERT INTO empleados VALUES (2, 'María', 'López', 60000.00);
INSERT INTO empleados VALUES (3, 'Pedro', 'García', 55000.00);
INSERT INTO empleados VALUES (4, 'Ana', 'Martínez', 70000.00);
INSERT INTO empleados VALUES (5, 'Carlos', 'Rodríguez', 48000.00);
INSERT INTO empleados VALUES (6, 'Laura', 'Sánchez', 75000.00);
INSERT INTO empleados VALUES (7, 'José', 'Fernández', 62000.00);
INSERT INTO empleados VALUES (8, 'Sara', 'Gómez', 58000.00);
INSERT INTO empleados VALUES (9, 'Javier', 'Díaz', 67000.00);
INSERT INTO empleados VALUES (10, 'Carmen', 'Ruiz', 53000.00);
```

Ahora si lanzamos la siguiente consulta:

```sql
SELECT * FROM empleados;
```

Obtendremos como resultado:

| codigo | nombre  | apellido    | salario  |
|--------|---------|-------------|----------|
| 1      | Juan    | Pérez       | 50000.0  |
| 2      | María   | López       | 60000.0  |
| 3      | Pedro   | García      | 55000.0  |
| 4      | Ana     | Martínez    | 70000.0  |
| 5      | Carlos  | Rodríguez   | 48000.0  |
| 6      | Laura   | Sánchez     | 75000.0  |
| 7      | José    | Fernández   | 62000.0  |
| 8      | Sara    | Gómez       | 58000.0  |
| 9      | Javier  | Díaz        | 67000.0  |
| 10     | Carmen  | Ruiz        | 53000.0  |

## Funciones de Texto

- __UPPER y LOWER__ para obtener nombres en mayúsculas y minúsculas:

```sql
SELECT UPPER(nombre) AS nombre_mayusculas, LOWER(nombre) AS nombre_minusculas FROM empleados;
```

| nombre_mayusculas | nombre_minusculas |
|---------------------|---------------------|
| JUAN                | juan                |
| MARÍA               | maría               |
| PEDRO               | pedro               |
| ANA                 | ana                 |
| CARLOS              | carlos              |
| LAURA               | laura               |
| JOSÉ                | josé                |
| SARA                | sara                |
| JAVIER              | javier              |
| CARMEN              | carmen              |

## Funciones Numéricas

- __ROUND__ para redondear el salario a dos decimales.

```sql
SELECT nombre, apellido, ROUND(salario, 2) AS salario_redondeado FROM empleados;
```

| nombre | apellido   | salario_redondeado |
|--------|------------|---------------------|
| Juan   | Pérez      | 50000.0             |
| María  | López      | 60000.0             |
| Pedro  | García     | 55000.0             |
| Ana    | Martínez   | 70000.0             |
| Carlos | Rodríguez | 48000.0             |
| Laura  | Sánchez    | 75000.0             |
| José   | Fernández  | 62000.0             |
| Sara   | Gómez      | 58000.0             |
| Javier | Díaz       | 67000.0             |
| Carmen | Ruiz       | 53000.0             |

## Funciones de Fecha y Hora

__CURRENT_DATE__ para obtener la fecha actual.

```sql
SELECT CURRENT_DATE AS fecha_actual FROM empleados LIMIT 1;
```

| fecha_actual |
|--------------|
| 2024-01-12   |

## Funciones de Agregación.

- __COUNT__ para contar el número de registros.

```sql
SELECT COUNT(*) AS total_empleados FROM empleados;
```

| total_empleados |
|-----------------|
| 10              |

## Funciones de Conversión

- __CAST__ para convertir el salario a un entero.

```sql
SELECT nombre, apellido, CAST(salario AS INTEGER) AS salario_entero FROM empleados;
```

| nombre | apellido   | salario_entero |
|--------|------------|-----------------|
| Juan   | Pérez      | 50000           |
| María  | López      | 60000           |
| Pedro  | García     | 55000           |
| Ana    | Martínez   | 70000           |
| Carlos | Rodríguez | 48000           |
| Laura  | Sánchez    | 75000           |
| José   | Fernández  | 62000           |
| Sara   | Gómez      | 58000           |
| Javier | Díaz       | 67000           |
| Carmen | Ruiz       | 53000           |

## MariaDB, MySql y Sqlite

| Categoría                   | Función (SQLite)                     | Función (MySQL/MariaDB)                | Ejemplo (SQLite)                                 | Ejemplo (MySQL/MariaDB)                            |
|-----------------------------|-------------------------------------|----------------------------------------|--------------------------------------------------|----------------------------------------------------|
| **Funciones de Texto**      | `UPPER(str)`, `LOWER(str)`           | `UPPER(str)`, `LOWER(str)`             | `SELECT UPPER('hello') AS mayusculas;`           | `SELECT UPPER('hello') AS mayusculas;`             |
| **Funciones Numéricas**     | `ABS(x)`, `ROUND(x)`, `CEIL(x)`      | `ABS(x)`, `ROUND(x)`, `CEIL(x)`        | `SELECT ABS(-5) AS valor_absoluto;`              | `SELECT ABS(-5) AS valor_absoluto;`                |
| **Funciones de Fecha y Hora**| `CURRENT_DATE`, `CURRENT_TIME`      | `CURRENT_DATE`, `CURRENT_TIME`         | `SELECT CURRENT_DATE AS fecha_actual;`          | `SELECT CURRENT_DATE AS fecha_actual;`            |
| **Funciones de Agregación**  | `SUM(column)`, `AVG(column)`, `COUNT(column)` | `SUM(column)`, `AVG(column)`, `COUNT(column)` | `SELECT AVG(salario) AS promedio_salario FROM empleados;` | `SELECT AVG(salario) AS promedio_salario FROM empleados;` |
| **Funciones de Conversión**  | `CAST(expr AS type)`                | `CAST(expr AS type)`                   | `SELECT CAST('123' AS INTEGER) AS entero;`      | `SELECT CAST('123' AS SIGNED) AS entero;`         |
| **Funciones de Manipulación de Cadenas** | `CONCAT(str1, str2, ...)` | `CONCAT(str1, str2, ...)`, `CONCAT_WS(separator, str1, str2, ...)` | `SELECT CONCAT('Hola', ' ', 'Mundo') AS concatenado;` | `SELECT CONCAT('Hola', ' ', 'Mundo') AS concatenado;` |
| **Funciones de Control de Flujo** | `CASE WHEN condition THEN result END` | `CASE WHEN condition THEN result ELSE else_result END` | `SELECT CASE WHEN salario > 50000 THEN 'Alto' ELSE 'Bajo' END AS rango_salario;` | `SELECT CASE WHEN salario > 50000 THEN 'Alto' ELSE 'Bajo' END AS rango_salario;` |


</div>