<div align="justify">

# Trabajo con cursores la BBDD Empleados

La base de datos de __"empleados"__ es un sistema diseñado para gestionar información relacionada con los empleados de una empresa. Esta base de datos está estructurada en torno a la entidad principal "empleados", que contiene información detallada sobre cada empleado. La estructura de la base de datos se compone de una única tabla principal llamada "empleados".

La tabla "empleados" está diseñada con las siguientes columnas:

- __id__: Esta columna sirve como identificador único para cada empleado. Es de tipo entero y se genera automáticamente utilizando la propiedad AUTO_INCREMENT.
- __nombre__: Almacena el nombre completo de cada empleado. Es de tipo cadena de caracteres (VARCHAR) con una longitud máxima de 100 caracteres.
- __salario__: Esta columna registra el salario de cada empleado. Se define como un número decimal (DECIMAL) con una precisión de 10 dígitos en total y 2 dígitos después del punto decimal.

```sql
CREATE DATABASE IF NOT EXISTS empresa;
USE empresa;

CREATE TABLE empleados (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    salario DECIMAL(10, 2)
);

INSERT INTO empleados (nombre, salario) VALUES
('Juan', 3000.00),
('María', 3500.00),
('Pedro', 3200.00);
```

Veamos la tabla:

```sql
mysql> select * from empleados;
+----+--------+---------+
| id | nombre | salario |
+----+--------+---------+
|  1 | Juan   | 3300.00 |
|  2 | María  | 3850.00 |
|  3 | Pedro  | 3520.00 |
+----+--------+---------+
```


Vamos a crear distintos procedimientos que harán uso de cursores. Vamos a ver un ejemplo y ver como se define y comporta.

  1. Crea un procedimiento que aumente el salario de los empleados en un porcentaje dado:
  
      ```code
      salario * (1 + porcentaje / 100) 
      ```

      El procedimiento que resulta el problema planteado será el siguiente:

      ```sql
        DELIMITER //
        CREATE PROCEDURE aumentar_salarios(IN porcentaje DECIMAL(5,2))
        BEGIN
            DECLARE done INT DEFAULT FALSE;
            DECLARE emp_id INT;
            DECLARE emp_nombre VARCHAR(100);
            DECLARE emp_salario DECIMAL(10, 2);
            DECLARE cur CURSOR FOR SELECT id, nombre, salario FROM empleados;
            DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

            OPEN cur;
            read_loop: LOOP
                FETCH cur INTO emp_id, emp_nombre, emp_salario;
                IF done THEN
                    LEAVE read_loop;
                END IF;
                UPDATE empleados SET salario = salario * (1 + porcentaje / 100) WHERE id = emp_id;
            END LOOP;
            CLOSE cur;
        END //
        DELIMITER ;
      ```

      Donde:

     - __DELIMITER //__: Esto establece el delimitador de sentencias a //. Esto es necesario porque los procedimientos almacenados en MySQL pueden contener puntos y comas, lo que podría confundir al intérprete si no se establece un delimitador personalizado.
     - __CREATE PROCEDURE aumentar_salarios(IN porcentaje DECIMAL(5,2))__: Esta línea crea un nuevo procedimiento almacenado llamado aumentar_salarios. Toma un parámetro de entrada porcentaje que es de tipo DECIMAL(5,2), lo que significa que puede aceptar números decimales con un máximo de 5 dígitos en total, 2 de los cuales pueden estar después del punto decimal.
     - __BEGIN__: Inicia el bloque de código del procedimiento almacenado.
     - __DECLARE done INT DEFAULT FALSE;__: Declara una variable local llamada done que se usará para controlar la terminación del bucle del cursor.
     - __DECLARE emp_id INT;, DECLARE emp_nombre VARCHAR(100);, DECLARE emp_salario DECIMAL(10, 2);__: Declara variables locales para almacenar el id, nombre y salario de los empleados que se recuperarán del cursor.
     - __DECLARE cur CURSOR FOR SELECT id, nombre, salario FROM empleados;__: Declara un cursor llamado cur que recupera los id, nombre y salario de la tabla empleados.
     - __DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;__: Declara un manejador que se activará cuando ya no haya más filas para leer en el cursor. Establece la variable done en TRUE, lo que indica que se ha completado el bucle del cursor.
     - __OPEN cur;__: Abre el cursor para comenzar a recorrer los registros de la tabla empleados.
     - __read_loop__: LOOP: Etiqueta del bucle para que pueda ser interrumpido con la instrucción LEAVE.
     - __FETCH cur INTO emp_id, emp_nombre, emp_salario;__: Recupera el siguiente conjunto de valores del cursor y los almacena en las variables declaradas.
     __IF done THEN LEAVE read_loop; END IF;__: Verifica si se han recuperado todas las filas del cursor. Si es así, sale del bucle utilizando la etiqueta LEAVE.
     - __UPDATE empleados SET salario = salario * (1 + porcentaje / 100) WHERE id = emp_id;__: Actualiza el salario del empleado multiplicándolo por el porcentaje dado.
     - __END LOOP;__: Fin del bucle.
     - __CLOSE cur;__: Cierra el cursor.
     - __END //__: Fin del procedimiento almacenado.

      Realicemos la llamada al procedimiento:

        ```sql
        CALL aumentar_salarios(10);
        ```

      Salida:

        ```sql
          +----+--------+---------+
          | id | nombre | salario |
          +----+--------+---------+
          |  1 | Juan   | 3300.00 |
          |  2 | María  | 3850.00 |
          |  3 | Pedro  | 3520.00 |
          +----+--------+---------+
          3 rows in set (0,00 sec)
        ```

Teniendo este ejemplo como referencia, realiza:

1. Escribe un procedimiento almacenado que aumente los salarios de todos los empleados en un 5%, pero excluya a aquellos cuyo salario sea superior a 3200. El procedimiento debe tener parámetros de entrada.
  
    <details>
      <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

      ```sql
      DELIMITER //
      CREATE PROCEDURE aumentar_salarios(IN porcentaje_aumento DECIMAL(5,2))
      BEGIN
          DECLARE done INT DEFAULT FALSE;
          DECLARE emp_id INT;
          DECLARE emp_salario DECIMAL(10, 2);
          DECLARE cur CURSOR FOR SELECT id, salario FROM empleados WHERE salario <= 3200;
          DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

          OPEN cur;
          read_loop: LOOP
              FETCH cur INTO emp_id, emp_salario;
              IF done THEN
                  LEAVE read_loop;
              END IF;
              UPDATE empleados SET salario = salario * (1 + porcentaje_aumento / 100) WHERE id = emp_id;
          END LOOP;
          CLOSE cur;
      END //
      DELIMITER ;
      ```

    </details>
2. Escribe un procedimiento almacenado que calcule el salario anual de cada empleado (asumiendo que trabajan todo el año) y lo imprima.

    <details>
        <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

      ```sql
      DELIMITER //
      CREATE PROCEDURE calcular_salario_anual()
      BEGIN
          DECLARE emp_id INT;
          DECLARE emp_nombre VARCHAR(100);
          DECLARE emp_salario DECIMAL(10, 2);
          DECLARE emp_salario_anual DECIMAL(10, 2);
          DECLARE cur CURSOR FOR SELECT id, nombre, salario FROM empleados;

          OPEN cur;
          read_loop: LOOP
              FETCH cur INTO emp_id, emp_nombre, emp_salario;
              IF emp_id IS NULL THEN
                  LEAVE read_loop;
              END IF;
              SET emp_salario_anual = emp_salario * 12;
              SELECT CONCAT('El salario anual de ', emp_nombre, ' es: ', emp_salario_anual) AS resultado;
          END LOOP;
          CLOSE cur;
      END //
      DELIMITER ;
      ```

    </details>

3. Escribe un procedimiento almacenado que cuente y muestre el número de empleados en cada rango de salario (por ejemplo, menos de 3000, entre 3000 y 5000, más de 5000). El procedimiento debe tener parámetros de entrada.

    <details>
      <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

      ```sql
      DELIMITER //
      CREATE PROCEDURE contar_empleados_por_rango(IN salario_minimo DECIMAL(10,2), IN salario_maximo DECIMAL(10,2))
      BEGIN
          DECLARE emp_count INT DEFAULT 0;
          DECLARE done INT DEFAULT FALSE;
          DECLARE cur CURSOR FOR SELECT salario FROM empleados;
          DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

          OPEN cur;
          read_loop: LOOP
              FETCH cur INTO emp_salario;
              IF done THEN
                  LEAVE read_loop;
              END IF;
              IF emp_salario >= salario_minimo AND emp_salario <= salario_maximo THEN
                  SET emp_count = emp_count + 1;
              END IF;
          END LOOP;
          CLOSE cur;

          SELECT CONCAT('Número de empleados con salario entre ', salario_minimo, ' y ', salario_maximo, ': ', emp_count) AS resultado;
      END //
      DELIMITER ;
      ```

    </details>

## Referencias

- [Apuntes sobre procedimientos y funciones](../../procedimientos.md).

</div>