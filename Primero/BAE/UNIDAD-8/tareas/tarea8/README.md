<div align="justify">

# Trabajo con la BBDD Alumnos

Crea una base de datos llamada test que contenga una tabla llamada alumnos con las siguientes columnas:

- Tabla alumnos:
  - id (entero sin signo)
  - nombre (cadena de caracteres)
  - apellido1 (cadena de caracteres)
  - apellido2 (cadena de caracteres)
  - nota (número real)

    <details>
      <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

      ```sql
      
        CREATE DATABASE test;

        USE test;

        CREATE TABLE alumnos (
            id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
            nombre VARCHAR(50) NOT NULL,
            apellido1 VARCHAR(50) NOT NULL,
            apellido2 VARCHAR(50) NOT NULL,
            nota FLOAT NOT NULL
        );

      ```

    </details>  

Crea los siguientes __triggers__:
- Trigger1:_trigger_check_nota_before_insert_.
  - Se ejecuta sobre la tabla alumnos.
  - Se ejecuta antes de una operación de inserción.
  - Si el nuevo valor de la nota que se quiere insertar es negativo, se guarda como 0.
  - Si el nuevo valor de la nota que se quiere insertar es mayor que 10, se guarda como 10.

    <details>
      <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

      ```sql
      CREATE TRIGGER trigger_check_nota_before_insert
      BEFORE INSERT ON alumnos
      FOR EACH ROW
      BEGIN
          IF NEW.nota < 0 THEN
              SET NEW.nota = 0;
          ELSEIF NEW.nota > 10 THEN
              SET NEW.nota = 10;
          END IF;
      END;
      ```

    </details>

- __Trigger2__ : _trigger_check_nota_before_update_.
  - Se ejecuta sobre la tabla alumnos.
  - Se ejecuta antes de una operación de actualización.
  - Si el nuevo valor de la nota que se quiere actualizar es negativo, se guarda como 0.
  - Si el nuevo valor de la nota que se quiere actualizar es mayor que 10, se guarda como 10.

    <details>
      <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

      ```sql
      CREATE TRIGGER trigger_check_nota_before_update
      BEFORE UPDATE ON alumnos
      FOR EACH ROW
      BEGIN
          IF NEW.nota < 0 THEN
              SET NEW.nota = 0;
          ELSEIF NEW.nota > 10 THEN
              SET NEW.nota = 10;
          END IF;
      END;

      ```

    </details>

Una vez creados los triggers escriba varias sentencias de inserción y actualización sobre la tabla alumnos y verifica que los triggers se están ejecutando correctamente.

Crea el siguiente procedimiento:
- __Procedimiento1__:
  - Crea un procedimiento que permita realizar la inserción de un número de alumnos, con una nota mímina y máxima. Estos valores pueden oscilar entre 3, y 10.
  - Crea un procedimiento que permita realizar la inserción de un número de alumnos, con una nota mímina y máxima. Estos valores pueden oscilar entre -10, y 12.

```sql
-- implementa un procedimiento que realice la siguiente acción con datos aleatorios
INSERT INTO alumnos (nombre, apellido1, apellido2, nota) VALUES ('Juan', 'Pérez', 'Gómez', -5);
```

Realiza los procedimientos y verifica el comportamiento llamando a este con los parámetros adecuados.

## Referencias

- [Apuntes sobre triggers](../../trigers.md).
- [Apuntes sobre procedimientos y funciones](../../procedimientos.md).

</div>