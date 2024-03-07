-- Crear la base de datos de alumnos si no existe
CREATE DATABASE IF NOT EXISTS alumnos;

-- Seleccionar la base de datos
USE alumnos;

CREATE TABLE IF NOT EXISTS estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    edad INT,
    curso VARCHAR(50)
);

INSERT INTO estudiantes (nombre, edad, curso) VALUES
('Juan', 20, 'Matemáticas'),
('María', 22, 'Historia'),
('Carlos', 21, 'Física');

SELECT * FROM estudiantes;
