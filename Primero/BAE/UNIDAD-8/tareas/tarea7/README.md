<div align="justify">

# ¿El salario?

<div align="center">
<img width="400" src="https://www.gestion.org/wp-content/uploads/2017/08/que-integra-el-salario-base-de-cotizacion-768x452.jpg"/>

</div>

Ejercicios de repaso:

- Dado el siguiente procedimiento:

```sql

-- Paso 1
CREATE TABLE t (s1 INT, PRIMARY KEY (s1));

-- Paso 2
DELIMITER $$
CREATE PROCEDURE test(IN a INT, OUT b INT)
BEGIN
    SET b = 0;
    WHILE a > b DO
        SET b = b + 1;
        IF b != 2 THEN
            INSERT INTO t VALUES (b);
        END IF
    END WHILE;
END;
```

¿Qué valores tendría la tabla t y qué valor devuelve la sentencia SELECT value en cada caso (a y b)? Justifique la respuesta.

```sql
-- a)
CALL test(-10, @value);
SELECT @value;

-- b)
CALL test(10, @value);
SELECT @value;
```

- Escriba un procedimiento llamado obtener_numero_empleados que reciba como parámetro de entrada el código de una oficina y devuelva el número de empleados que tiene.

____Escriba una sentencia SQL que realice una llamada al procedimiento realizado para comprobar que se ejecuta correctamente___.

- Escriba una función llamada cantidad_total_de_productos_vendidos que reciba como parámetro de entrada el código de un producto y devuelva la cantidad total de productos que se han vendido con ese código.

Escriba una sentencia SQL que realice una llamada a la función realizada para comprobar que se ejecuta correctamente.

- Crea una tabla que se llame productos_vendidos que tenga las siguientes columnas:
    - id (entero sin signo, auto incremento y clave primaria)
    - codigo_producto (cadena de caracteres)
    - cantidad_total (entero)
    
    Escriba un procedimiento llamado estadísticas_productos_vendidos que para cada uno de los productos de la tabla producto calcule la cantidad total de unidades que se han vendido y almacene esta información en la tabla productos_vendidos.

 
    - Calcular la cantidad total de productos vendidos. En este paso será necesario utilizar la función cantidad_total_de_productos_vendidos desarrollada en el ejercicio.
    - Insertar en la tabla productos_vendidos los valores del código de producto y la cantidad total de unidades que se han vendido para ese producto en concreto.

## Referencias

- [Tipos de Datos en MySql](https://dev.mysql.com/doc/refman/8.0/en/data-types.html).
- [Sentencia Update](https://dev.mysql.com/doc/refman/8.0/en/update.html)

</div>