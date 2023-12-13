<div align="justify">

<div align="center">
<img src="https://luciamonterorodriguez.com/wp-content/uploads/2021/03/computer-1331579_640.png" width="200px"/>
</div>

Vamos a crear un pequeña BBDD que contenga la información de __usuarios__.
Para ello debes de seguir los siguientes pasos:

> __Nota__. Una tabla es una estructura de datos que organiza los datos en columnas y filas; cada columna es un campo (o atributo) y cada fila, un registro. 
- La intersección de una columna con una fila, contiene un dato específico, un solo valor. 
- Cada registro contiene un dato por cada columna de la tabla.
- Cada campo (columna) debe tener un nombre. El nombre del campo hace referencia a la información que almacenará.
- Cada campo (columna) también debe definir el tipo de dato que almacenará: _números enteros, números reales, caracteres_ etc.


Las tablas forman parte de una base de datos.

Nosotros trabajaremos con la base de datos llamada "base_tarea1".

Toda tabla debe ser definida con un nombre que la identifique y con el cual accederemos a ella.

Creamos una tabla llamada "__usuario__", escribiendo:

```sql
create table usuario (
	 nombre text,
	 clave text
);
```
Para borrar la tabla de la base de datos debemos de ejecutar el siguiente comando:

```
drop table usuario;
```

</div>