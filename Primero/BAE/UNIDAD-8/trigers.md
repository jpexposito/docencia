<div align="justify">

# Trigers en MySQL

<div align="center">
<img src="https://dinahosting.com/blog/upload/2022/04/triggers.jpg" width="500px"/>
</div>

Con la ayuda de los __triggers__ en __MySQL__ podemos conseguir automatizar acciones sin necesidad de desarrollar lógica en otros lenguajes.

___Un trigger o disparador___ es una _regla que se asocia a una tabla_. Mediante esta __regla__, _se ejecutan una serie de instrucciones cuando se producen ciertos eventos sobre una tabla_. Los eventos son: __INSERT, UPDATE o DELETE__.

_Para poder realizar triggers es necesario que tengas permisos para ejecutar esas consultas_. Además, es necesario tener una base de datos MySQL con una versión superior a la __5.0.2__.

_Las posibilidades de modificar información gracias a los triggers son infinitas_. Gracias a ellos podrás mantener tu base de datos actualizada y al día, sin preocuparte por nada más.

### Creación de triggers

Para poder realizar triggers y automatizar acciones, _necesitamos una base de datos MySQL y una tabla sobre la que realizar consultas_. Si ya poseemos esto, lo primero que necesitamos hacer es definirlo. Para ello escogemos un __nombre para identificarlo__, de manera que luego podamos borrar o buscar el trigger en nuestra base de datos. _Antes de la instrucción_ ___CREATE___ _es imprescindible declarar un_ __delimitador__.

```sql
DELIMITER $$
CREATE TRIGER nombre_trigger
```

El siguiente paso a realizar es definir cuando se va a ejecutar. Las posibilidades son __AFTER(después) o BEFORE(antes)__ (orden). Recuerda que las órdenes que aceptan triggers son __INSERT, DELETE y UPDATE__.

```sql
DELIMITER $$
CREATE TRIGGER nombre_trigger
AFTER INSERT ON nombre_tabla
```

Ahora deberíamos indicar la estructura del trigger, es decir, en donde se van a aplicar los cambios que queramos, en nuestro caso lo vamos a hacer para todas las filas __(FOR EACH ROW)__

```sql
DELIMITER $$
CREATE TRIGGER nombre_trigger
AFTER INSERT ON nombre_tabla
FOR EACH ROW
```

Por último, introducimos entre __BEGIN y END__ las líneas de código SQL que queremos ejecutar. También es necesario que cierres el delimitador definido al comienzo.

```sql
DELIMITER $$
CREATE TRIGGER nombre_trigger
AFTER INSERT ON nombre_tabla
FOR EACH ROW
BEGIN
//Instrucciones SQL
END;$$
```

>__Nota__:_Con este código, a partir de ahora, después de ejecutar un_ ___INSERT___ _en_ ___nombre_tabla___ _se ejecutarán las instrucciones declaradas dentro del_ ___BEGIN___.

Recuerda que puedes eliminar un trigger haciendo uso de la sentencia DROP TRIGGER.

```sql
DROP TRIGGER nombre_trigger;
````
## Instrucciones a emplear dentro de los triggers

Habitualmente lo que se introduce dentro de los disparadores son instrucciones condicionales, en otras palabras secuencias que se ejecutarán si se da un caso concreto, aunque no es obligatorio. Para poder manejar estas instrucciones condicionales tenemos las variables __OLD__ y __NEW__.

### Variable NEW

___NEW___ almacena el valor que aporta la consulta a la base de datos. Con esta variable podemos acceder a los datos introducidos. Con ___NEW.nombre_columna___ se _almacenará la información con el nuevo valor que tendrá ese registro modificado_ (desde un ___UPDATE___ o ___INSERT___) en la tabla. Los trigger relacionados con ___DELETE___ no tendrán disponible la variable ___NEW___.

### Variable OLD

___OLD___ a diferencia de ___NEW___, almacena el valor de las columnas que van a ser __borradas o eliminadas__. Al igual que pasa con ___NEW, OLD___ no está disponible en todas las instrucciones, más concretamente el valor no se puede recuperar cuando la instrucción es un ___INSERT___.

### Ejemplos de triggers
#### Comprobación de datos

Imaginemos que tenemos una tabla clientes en la que almacenamos su edad. Para evitar problemas en el tratamiento de los datos, queremos evitar que se introduzcan edades negativas. Podríamos hacer algo parecido a:

```sql
DELIMITER $$

CREATE TRIGGER comprobar_edad
AFTER INSERT ON cliente
FOR EACH ROW 
BEGIN
    IF NEW.edad<0
      THEN SET NEW.edad = 0;
    END IF; 
END; $$
````

Con este sencillo trigger evitaremos que en nuestra base de datos se puedan guardar edades menores a cero, de manera que podríamos omitir esta comprobación en desarrollos que hiciésemos con estos datos.

#### Realización de un histórico de productos

En este ejemplo no emplearemos una sentencia condicional. Imaginemos que tenemos una tienda online. Quizás nos interese tener una tabla en la que guardamos todos los productos que hemos tenido en nuestro catálogo en algún momento. Podríamos introducir los datos dentro del histórico siempre que introdujésemos un nuevo producto. Sin embargo, ___¿No sería más sencillo automatizar un histórico de los productos?___. Gracias a los trigger podremos realizarlo sin tener que ejecutar dos instrucciones separadas.

```sql
DELIMITER $$
CREATE TRIGGER trigger_producto_historico 
AFTER INSERT ON producto
FOR EACH ROW
BEGIN 
   INSERT INTO producto_historico(id, descripcion, precio)
   VALUES (NEW.id, NEW.descripcion, NEW.precio, CURDATE());
END; $$
```

De esta forma, cada vez que incluyamos un producto nuevo, este también se añadirá a la tabla __producto_historico__, y aunque posteriormente borremos el artículo de la tabla producto, este seguirá existiendo en __producto_historico__.

A través de los ejemplos que hemos visto, hemos descubierto que _gracias a los disparadores o triggers podemos automatizar acciones fácilmente con MySQL y mantener nuestra base de datos actualizada_. Trabajar con bases de datos es una tarea delicada, por ello. Si quieres más información sobre los Triggers y su funcionamiento, recuerda que tienes a mano la documentación de MySQL.

### Algunos ejemplos

En la base de datos __Sakila__ podemos encontrar los siguientes ejemplos:

#### Sobre la tabla actor

```sql
CREATE TRIGGER actor_trigger_ai AFTER INSERT ON actor
 BEGIN
  UPDATE actor SET last_update = DATETIME('NOW')  WHERE rowid = new.rowid;
 END
;
 
CREATE TRIGGER actor_trigger_au AFTER UPDATE ON actor
 BEGIN
  UPDATE actor SET last_update = DATETIME('NOW')  WHERE rowid = new.rowid;
 END
;
```

#### Sobre la tabla country

```sql
CREATE TRIGGER country_trigger_ai AFTER INSERT ON country
 BEGIN
  UPDATE country SET last_update = DATETIME('NOW')  WHERE rowid = new.rowid;
 END
;
 
CREATE TRIGGER country_trigger_au AFTER UPDATE ON country
 BEGIN
  UPDATE country SET last_update = DATETIME('NOW')  WHERE rowid = new.rowid;
 END
;
```

#### Sobre la tabla city

```sql
CREATE TRIGGER city_trigger_ai AFTER INSERT ON city
 BEGIN
  UPDATE city SET last_update = DATETIME('NOW')  WHERE rowid = new.rowid;
 END
;
 
CREATE TRIGGER city_trigger_au AFTER UPDATE ON city
 BEGIN
  UPDATE city SET last_update = DATETIME('NOW')  WHERE rowid = new.rowid;
 END
;
```

## Referencias.

- [Documentación Trigers](https://dev.mysql.com/doc/refman/8.0/en/triggers.html).
- [Visualizar Trigers](https://dev.mysql.com/doc/refman/8.0/en/show-triggers.html).


- [Ejemplos Trigers Sakila](https://dev.mysql.com/doc/sakila/en/sakila-structure-triggers.html
).

- [Ejemplos Trigers](https://dev.mysql.com/doc/refman/8.0/en/trigger-syntax.html
).

</div>