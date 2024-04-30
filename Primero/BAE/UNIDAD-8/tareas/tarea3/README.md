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

  <details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

  ```sql
  DELIMITER //

  CREATE PROCEDURE PMostrarUsuarios()
  BEGIN
      SELECT * FROM usuarios;
  END//

  DELIMITER ;
  ```

  </details> 

- Crea una función que devuelva el promedio de edad de todos los usuarios.
  
  <details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

  ```sql
  CREATE FUNCTION PromedioEdad() RETURNS DECIMAL(5,2)
  BEGIN
      DECLARE avg_age DECIMAL(5,2);
      SELECT AVG(edad) INTO avg_age FROM usuarios;
      RETURN avg_age;
  END;
  ```

  </details> 
- Crea un procedimiento almacenado que inserte un nuevo usuario en la tabla.

  <details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

  ```sql
  DELIMITER //

  CREATE PROCEDURE InsertarUsuario(
      IN p_nombre VARCHAR(50),
      IN p_edad INT,
      IN p_email VARCHAR(50)
  )
  BEGIN
      INSERT INTO usuarios (nombre, edad, email) VALUES (p_nombre, p_edad, p_email);
  END//

  DELIMITER ;
  ```

  </details> 

- Crea una función que devuelva el nombre del usuario más joven.
  
  <details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>
  
  ```sql
  CREATE FUNCTION UsuarioMasJoven() RETURNS VARCHAR(50)
  BEGIN
      DECLARE youngest_name VARCHAR(50);
      SELECT nombre INTO youngest_name FROM usuarios ORDER BY edad ASC LIMIT 1;
      RETURN youngest_name;
  END;
  ```

  </details> 

- Crea un procedimiento almacenado que actualice la edad de un usuario dado su nombre.

  <details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

  ```sql
  DELIMITER //

  CREATE PROCEDURE ActualizarEdadUsuario(
      IN p_nombre VARCHAR(50),
      IN p_nueva_edad INT
  )
  BEGIN
      UPDATE usuarios SET edad = p_nueva_edad WHERE nombre = p_nombre;
  END//

  DELIMITER ;
  ```

  </details> 

- Crea una función que devuelva el número total de usuarios en la tabla.

  <details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

  ```sql
  CREATE FUNCTION TotalUsuarios() RETURNS INT
  BEGIN
      DECLARE total INT;
      SELECT COUNT(*) INTO total FROM usuarios;
      RETURN total;
  END;
  ```

  </details> 
- Crea un procedimiento almacenado que elimine un usuario dado su email.
  
  <details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

  ```sql
  
  DELIMITER //

  CREATE PROCEDURE EliminarUsuarioPorEmail(
      IN p_email VARCHAR(50)
  )
  BEGIN
      DELETE FROM usuarios WHERE email = p_email;
  END//

  DELIMITER ;
  ```

  </details> 

- Crea una función que devuelva el nombre del usuario más viejo.
  
  <details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

  ```sql
  CREATE FUNCTION UsuarioMasViejo() RETURNS VARCHAR(50)
  BEGIN
      DECLARE oldest_name VARCHAR(50);
      SELECT nombre INTO oldest_name FROM usuarios ORDER BY edad DESC LIMIT 1;
      RETURN oldest_name;
  END;
  ```

  </details> 

- Crea un procedimiento almacenado que ordene los usuarios por edad de forma ascendente y muestre el resultado.

  <details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

  ```sql
  DELIMITER //

  CREATE PROCEDURE OrdenarUsuariosPorEdad()
  BEGIN
      SELECT * FROM usuarios ORDER BY edad ASC;
  END//

  DELIMITER ;
  ```

  </details>

- Crea una función que devuelva el email del usuario con la edad más alta.

  <details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

  ```sql
  CREATE FUNCTION EmailUsuarioMayorEdad() RETURNS VARCHAR(50)
  BEGIN
      DECLARE max_age INT;
      SELECT MAX(edad) INTO max_age FROM usuarios;
      DECLARE email VARCHAR(50);
      SELECT email INTO email FROM usuarios WHERE edad = max_age LIMIT 1;
      RETURN email;
  END;
  ```

  </details>   

## Referencias

- [Apuntes sobre procedimientos y funciones](../../procedimientos.md).

</div>