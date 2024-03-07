<div align="justify">

# Correspondencia Sqlite3-MySql

## Comandos Básicos entre SQLite3 y MySQL

| Acción             | SQLite3                             | MySQL                               |
|--------------------|-------------------------------------|-------------------------------------|
| Crear una base de datos | `sqlite3 nombre_basedatos.db`   | `CREATE DATABASE nombre_basedatos;` |
| Conectar a una base de datos | `.open nombre_basedatos.db`      | `USE nombre_basedatos;`            |
| Crear una tabla    | `CREATE TABLE nombre_tabla (columna1 TIPO, columna2 TIPO, ...);` | `CREATE TABLE nombre_tabla (columna1 TIPO, columna2 TIPO, ...);` |
| Insertar datos     | `INSERT INTO nombre_tabla VALUES (valor1, valor2, ...);`     | `INSERT INTO nombre_tabla VALUES (valor1, valor2, ...);` |
| Seleccionar datos  | `SELECT * FROM nombre_tabla;`    | `SELECT * FROM nombre_tabla;`      |
| Mostrar tablas     | `.tables`                        | `SHOW TABLES;`                     |
| Ver esquema        | `.schema nombre_tabla`           | `DESCRIBE nombre_tabla;`           |
| Leer archivo SQL   | `.read archivo.sql`              | `source archivo.sql;`              |
| Actualizar datos   | `UPDATE nombre_tabla SET columna1 = valor1, columna2 = valor2 WHERE condicion;` | `UPDATE nombre_tabla SET columna1 = valor1, columna2 = valor2 WHERE condicion;` |
| Eliminar datos     | `DELETE FROM nombre_tabla WHERE condicion;` | `DELETE FROM nombre_tabla WHERE condicion;` |
| Borrar tabla       | `DROP TABLE nombre_tabla;`        | `DROP TABLE nombre_tabla;`         |
| Cerrar la base de datos | `.exit`                        | `EXIT;`                             |


</div>