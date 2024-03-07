<div align="justify">

# Migración y primeros pasos en MySql

Dada la siguiente __BBDD__ en __Sqlite3__:

```sql
CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT,
    edad INTEGER,
    correo TEXT
);

INSERT INTO usuarios (nombre, edad, correo) VALUES
('Juan', 25, 'juan@example.com'),
('María', 30, 'maria@example.com'),
('Pedro', 28, 'pedro@example.com');

CREATE TABLE IF NOT EXISTS productos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT,
    precio NUMERIC(10, 2),
    cantidad INTEGER
);

INSERT INTO productos (nombre, precio, cantidad) VALUES
('Camisa', 25.99, 100),
('Pantalón', 35.50, 80),
('Zapatos', 59.99, 50);

CREATE TABLE IF NOT EXISTS pedidos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    usuario_id INTEGER,
    producto_id INTEGER,
    cantidad INTEGER,
    fecha_pedido DATE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);

INSERT INTO pedidos (usuario_id, producto_id, cantidad, fecha_pedido) VALUES
(1, 1, 2, '2024-03-01'),
(2, 2, 1, '2024-03-02'),
(3, 3, 3, '2024-03-03');
```

Realiza la migración a __MySql__ y realiza las siguientes consultas:

- Mostrar todos los usuarios.
- Mostrar todos los productos.
- Mostrar todos los pedidos.
- Mostrar los usuarios que tienen más de 25 años.
- Mostrar los productos con un precio mayor a 50.
- Mostrar los pedidos realizados el día de hoy.
- Mostrar el total de productos en stock.
- Mostrar el promedio de edades de los usuarios.
- Mostrar los usuarios que tienen la letra 'a' en su nombre
- Mostrar los productos ordenados por precio de forma descendente.
- Mostrar los pedidos realizados por el usuario con ID 2.
- Mostrar los usuarios ordenados por edad de forma ascendente.
- Mostrar los productos con un precio entre 20 y 50.
- Mostrar los usuarios que tienen un correo de dominio 'example.com'.
- Mostrar los pedidos con una cantidad mayor a 2

</div>