<div align="justify">

# Trabajo con procedimientos y funciones

```sql
CREATE DATABASE IF NOT EXISTS ejercicios_db;
USE ejercicios_db;

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    edad INT,
    email VARCHAR(50)
);

INSERT INTO usuarios (nombre, edad, email) VALUES
('Juan', 25, 'juan@example.com'),
('María', 30, 'maria@example.com'),
('Pedro', 35, 'pedro@example.com'),
('Ana', 28, 'ana@example.com'),
('Luis', 40, 'luis@example.com'),
('Laura', 22, 'laura@example.com'),
('Carlos', 33, 'carlos@example.com'),
('Sofía', 27, 'sofia@example.com'),
('Diego', 29, 'diego@example.com'),
('Elena', 31, 'elena@example.com');
```

Se pide realizar los procedimientos y funciones:

- Crea un procedimiento almacenado que muestre todos los usuarios de la tabla.

- Crea una función que devuelva el promedio de edad de todos los usuarios.

- Crea un procedimiento almacenado que inserte un nuevo usuario en la tabla.

- Crea una función que devuelva el nombre del usuario más joven.

- Crea un procedimiento almacenado que actualice la edad de un usuario dado su nombre.

- Crea una función que devuelva el número total de usuarios en la tabla.

- Crea un procedimiento almacenado que elimine un usuario dado su email.

- Crea una función que devuelva el nombre del usuario más viejo.

- Crea un procedimiento almacenado que ordene los usuarios por edad de forma ascendente y muestre el resultado.

- Crea una función que devuelva el email del usuario con la edad más alta.
## Referencias

- [Apuntes sobre procedimientos y funciones](../../procedimientos.md).

</div>