# Guía rápida de MySQL

Guía rápida de MySQL donde podrás encontrar la información necesaria y los comando más utilizados.

## Conocimientos previos
Esta guía no pretende explicar los conceptos básicos de las bases de datos relacionales, por lo que está enfocada a personas que ya cuenten con un conocimiento básico sobre bases de datos relacionales.

## Tabla de contenido
- [Configuración](#configuraci-n)
- [Conexión](#conexi-n)
- [Gestión de usuarios](#gestión-de-usuarios)
- [Bases de datos](#bases-de-datos)
- [Tablas](#tablas)
- [Registros](#registros)
- [Relaciones entre tablas](#relaciones-entre-tablas)

## Configuración

### Instalación Linux
```
sudo apt-get update
sudo apt upgrade
sudo apt-get install -y mysql-server
sudo mysql_secure_installation
```
Nota: si solo quieres conectarte a una base de datos MySQL remota en lugar de albergar una base de datos en tu máquina, es suficiente con instalar el cliente MySQL con el siguiente comando: `sudo apt install mysql-client`

### Ubicación de MySQL
* Mac             */usr/local/mysql/bin*
* Windows         */Program Files/MySQL/MySQL _version_/bin*
* Xampp           */xampp/mysql/bin*

### Añadir MySQL al PATH

```bash
# Current Session
export PATH=${PATH}:/usr/local/mysql/bin
# Permanantly
echo 'export PATH="/usr/local/mysql/bin:$PATH"' >> ~/.bash_profile
```

En Windows - [https://www.qualitestgroup.com/resources/knowledge-center/how-to-guide/add-mysql-path-windows/](https://qualitestgroup.com/insights/technical-hub/how-to-add-mysql-to-the-path-in-windows/)

## Conexión
### Acceder

```bash
mysql -u root -p
```
### Salir

```sql
exit;
```

## Gestión de usuarios
### Mostrar usuarios

```sql
SELECT User, Host FROM mysql.user;
```

### Crear usuario

```sql
CREATE USER 'someuser'@'localhost' IDENTIFIED BY 'somepassword';
```

### Cambiar contraseña de usuario

```sql
SET PASSWORD FOR '<username>'@'localhost' = PASSWORD('<password>');
```

### Conceder todos los permisos en todas las bases de datos

```sql
GRANT ALL PRIVILEGES ON * . * TO 'someuser'@'localhost';
FLUSH PRIVILEGES;
```


### Conceder permisos concretos en una base de datos

```sql
GRANT SELECT,UPDATE,INSERT,DELETE ON <database_name>.* TO '<username>'@'localhost';
FLUSH PRIVILEGES;
```


### Mostrar permisos

```sql
SHOW GRANTS FOR 'someuser'@'localhost';
```

### Eliminar permisos

```sql
REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'someuser'@'localhost';
```

### Borrar usuario

```sql
DROP USER 'someuser'@'localhost';
```


## Bases de datos
### Mostrar bases de datos

```sql
SHOW DATABASES
```

### Crear una base de datos

```sql
CREATE DATABASE revistas;
```

### Borrar una base de datos

```sql
DROP DATABASE revistas;
```

### Seleccionar una base de datos

```sql
USE revistas;
```

## Tablas
### Crear una tabla

```sql
CREATE TABLE users(
id INT AUTO_INCREMENT,
   first_name VARCHAR(100),
   last_name VARCHAR(100),
   email VARCHAR(50),
   password VARCHAR(20),
   location VARCHAR(100),
   dept VARCHAR(100),
   is_admin TINYINT(1),
   register_date DATETIME,
   PRIMARY KEY(id)
);
```

### Borrar una tabla

```sql
DROP TABLE tablename;
```

### Mostrar tablas

```sql
SHOW TABLES;
```

### Añadir una nueva columna

```sql
ALTER TABLE users ADD age VARCHAR(3);
```

### Modificar una columna

```sql
ALTER TABLE users MODIFY COLUMN age INT(3);
```

### Crear y borrar índices

```sql
CREATE INDEX LIndex On users(location);
DROP INDEX LIndex ON users;
```

## Registros
### Insertar una fila (registro): INSERT

```sql
INSERT INTO users (first_name, last_name, email, is_admin, register_date)
VALUES ('Brad', 'Traversy', 'brad@gmail.com', 1, now());
```

### Insertar múltiples filas: INSERT

```sql
INSERT INTO users (first_name, last_name, email, is_admin, register_date)
VALUES ('Fred', 'Smith', 'fred@gmail.com', 0, now()),
('Sara', 'Watson', 'sara@gmail.com', 0, now()),
('Will', 'Jackson', 'will@yahoo.com', 1, now()),
('Paula', 'Johnson', 'paula@yahoo.com', 0, now()),
('Tom', 'Spears', 'tom@yahoo.com', 0, now());
```

### Consultar todos los registros: SELECT

```sql
SELECT * FROM users;
SELECT first_name, last_name FROM users;
```

### Consultas con condiciones: WHERE

```sql
SELECT * FROM users WHERE location='Massachusetts';
SELECT * FROM users WHERE location='Massachusetts' AND dept='sales';
SELECT * FROM users WHERE is_admin = 1;
SELECT * FROM users WHERE is_admin > 0;
```

### Borrar registros: DELETE

```sql
DELETE FROM users WHERE id = 6;
```

### Actualizar registros: UPDATE

```sql
UPDATE users SET email = 'freddy@gmail.com' WHERE id = 2;

```

### Ordenar registros: ORDER BY

```sql
SELECT * FROM users ORDER BY last_name ASC;
SELECT * FROM users ORDER BY last_name DESC;
```

### Concatenar columnas: CONCAT

```sql
SELECT CONCAT(first_name, ' ', last_name) AS 'Name', dept FROM users;

```

### Consultar filas distintas: DISTINCT

```sql
SELECT DISTINCT location FROM users;

```

### Consultar por rango: BETWEEN

```sql
SELECT * FROM users WHERE age BETWEEN 20 AND 25;
```

### Consultas similares: LIKE

```sql
SELECT * FROM users WHERE dept LIKE 'd%';
SELECT * FROM users WHERE dept LIKE 'dev%';
SELECT * FROM users WHERE dept LIKE '%t';
SELECT * FROM users WHERE dept LIKE '%e%';
```

### Distinto a: NOT LIKE

```sql
SELECT * FROM users WHERE dept NOT LIKE 'd%';
```

### IN

```sql
SELECT * FROM users WHERE dept IN ('design', 'sales');
```

### Funciones agregadas: COUNT, MAX, MIN, SUM, ...

```sql
SELECT COUNT(id) FROM users;
SELECT MAX(age) FROM users;
SELECT MIN(age) FROM users;
SELECT SUM(age) FROM users;
SELECT UCASE(first_name), LCASE(last_name) FROM users;

```

### Agrupar resultados: GROUP BY

```sql
SELECT age, COUNT(age) FROM users GROUP BY age;
SELECT age, COUNT(age) FROM users WHERE age > 20 GROUP BY age;
SELECT age, COUNT(age) FROM users GROUP BY age HAVING count(age) >=2;

```

## Relaciones entre tablas

### Crear tabla con cláve foránea (FOREIGN KEY)

```sql
CREATE TABLE posts(
id INT AUTO_INCREMENT,
   user_id INT,
   title VARCHAR(100),
   body TEXT,
   publish_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY(id),
   FOREIGN KEY (user_id) REFERENCES users(id)
);
```

#### Añadir datos a la tabla

```sql
INSERT INTO posts(user_id, title, body) VALUES (1, 'Post One', 'This is post one'),(3, 'Post Two', 'This is post two'),(1, 'Post Three', 'This is post three'),(2, 'Post Four', 'This is post four'),(5, 'Post Five', 'This is post five'),(4, 'Post Six', 'This is post six'),(2, 'Post Seven', 'This is post seven'),(1, 'Post Eight', 'This is post eight'),(3, 'Post Nine', 'This is post none'),(4, 'Post Ten', 'This is post ten');
```

### INNER JOIN

```sql
SELECT
  users.first_name,
  users.last_name,
  posts.title,
  posts.publish_date
FROM users
INNER JOIN posts
ON users.id = posts.user_id
ORDER BY posts.title;
```

### Crear tabla con múltiples claves foráneas

```sql
CREATE TABLE comments(
	id INT AUTO_INCREMENT,
    post_id INT,
    user_id INT,
    body TEXT,
    publish_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) references users(id),
    FOREIGN KEY(post_id) references posts(id)
);
```

#### Añadir datos a la tabla

```sql
INSERT INTO comments(post_id, user_id, body)
VALUES (1, 3, 'This is comment one'),
(2, 1, 'This is comment two'),
(5, 3, 'This is comment three'),
(2, 4, 'This is comment four'),
(1, 2, 'This is comment five'),
(3, 1, 'This is comment six'),
(3, 2, 'This is comment six'),
(5, 4, 'This is comment seven'),
(2, 3, 'This is comment seven');
```

### LEFT JOIN

```sql
SELECT
comments.body,
posts.title
FROM comments
LEFT JOIN posts ON posts.id = comments.post_id
ORDER BY posts.title;

```

### JOIN de múltiples tablas

```sql
SELECT
comments.body,
posts.title,
users.first_name,
users.last_name
FROM comments
INNER JOIN posts on posts.id = comments.post_id
INNER JOIN users on users.id = comments.user_id
ORDER BY posts.title;

```

## Colabora
Hay muchas formas de contribuir con esta guía y ayudar a mejorarla:
- Notifica los errores que encuentres.
- Sugiere nuevos ejemplos o apartados.
- Compártela con tus conocidos o en redes sociales.

