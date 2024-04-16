 <div align="justify">

# Lo Básico en Programación SQL

SQL (Structured Query Language) es un lenguaje de programación utilizado para interactuar con bases de datos relacionales. Aunque principalmente se utiliza para consultar y manipular datos, también proporciona características de programación para realizar tareas más complejas.

## 1. Declaración de Variables

Puedes declarar variables en SQL para almacenar valores temporales que se utilizan en tus consultas y procedimientos almacenados.

```sql
DECLARE @nombre_de_variable tipo_de_dato;
SET @nombre_de_variable = valor;
```

Además podemos asignar el valor a una o más variables como resultado de una consulta.

```sql
SELECT campo1, campo2, . . . INTO variable1, variable2, . . . 
FROM nombre_tabla WHERE . . .
```

Por último también podemos definir un valor por defecto a una variable:

```sql
DECLARE nombre_variable tipo_variable [DEFAULT valor];
```

## 2. Estructuras de Control de Flujo

### Condicionales (IF-ELSE)

Los condicionales __IF-ELSE__ se utilizan para ejecutar bloques de código dependiendo de una condición.

```sql
IF condición THEN
    sentencias;
ELSE
    sentencias;] . . .
END IF;
```

Un ejemplo más complejo:

```sql
IF condicion THEN
    sentencias;
[ELSEIF condicion2 THEN
    sentencias;] . . .
[ELSE 
    sentencias;]
END IF
```

### Case

```sql
CASE variable
    WHEN valor1 THEN
        sentencias;
    [WHEN valor2 THEN
        sentencias;] . . .
    [ELSE 
        sentencias;]
END CASE
 
CASE
    WHEN condicion THEN
        sentencias;
    [WHEN condicion2 THEN
        sentencias;] . . .
    [ELSE 
        sentencias;]
END CASE
```

### LOOP

Los bucles LOOP no incoporan condición de salida, sino que debe ser implementada utilizando la instrucción LEAVE

```sql
[etiqueta_inicio:] LOOP
    sentencias;
END LOOP [etiqueta_fin]
```

### LEAVE

Se utiliza para romper la ejecución de cualquier instrucción de control de flujo que se haya etiquetado, normalmente bucles __LOOP__.

```sql
LEAVE etiqueta;
```

### ITERATE

Sólo puede aparecer en instrucciones de bucle __({LOOP, REPEAT y WHILE)__. 
Indica que el bucle debe volver a ejecutarse

```sql
ITERATE etiqueta;
Sentencia REPEAT
[etiqueta_inicio:] REPEAT
    sentencias;
UNTIL condicion
END REPEAT [etiqueta_fin]
Sentencia WHILE
[etiqueta_inicio:] WHILE condicion DO
    sentencias;
END WHILE [etiqueta_fin]
```

## 3. Manejo de Errres

SQL proporciona opciones para manejar errores que pueden ocurrir durante la ejecución de consultas y procedimientos almacenados.

### Captura de Errores

Puedes utilizar bloques __TRY-CATCH__ para capturar y manejar errores.

```sql
BEGIN TRY
    -- Código que puede generar errores
END TRY
BEGIN CATCH
    -- Manejo de errores
END CATCH;
```

### Lanzamiento de Errores

Puedes lanzar errores manualmente utilizando la instrucción __THROW__.

```sql
IF condición THEN
    THROW 50000, 'Mensaje de error personalizado', 1;
END IF;

```

 </div>