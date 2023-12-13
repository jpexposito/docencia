<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Con la restricción "foreign key" se define un campo (o varios) cuyos valores coinciden con la clave primaria de la misma tabla o de otra, es decir, se define una referencia a un campo con una restricción "primary key" o "unique" de la misma tabla o de otra.

La integridad referencial asegura que se mantengan las referencias entre las claves primarias y las externas. Por ejemplo, controla que si se agrega un código de editorial en la tabla "libros", tal código exista en la tabla "editoriales".

También controla que no pueda eliminarse un registro de una tabla ni modificar la clave primaria si una clave externa hace referencia al registro. Por ejemplo, que no se pueda eliminar o modificar un código de "editoriales" si existen libros con dicho código.

Trabajamos con las tablas "libro" y "editorial".
Eliminamos primero las tablas si ya existen:

```sql
drop table if exists libro;
drop table if exists editorial;
```
Creamos las dos tablas y definimos la restricción "foreign key" en la tabla "libro":

```sql
create table editorial(
	codigo integer primary key,
	nombre text
);

create table libro(
	codigo integer primary key,
	titulo text,
	autor text, 
	precio real,
	codigo_editorial integer	references editorial(codigo)
);
```

Creamos una restricción __foreign key__ para establecer el campo __codigo_editorial__ como clave externa que haga referencia al campo __codigo__ de __editorial__.

Cargamos tres registros en la tabla __editorial__:

```sql
 insert into editorial(nombre) values('Planeta');
 insert into editorial(nombre) values('Emece');
 insert into editorial(nombre) values('Siglo XXI');
 ```

 Cargamos una serie de registros en la tabla "libro" respetando la restricción impuesta en el campo __codigo_editorial__:

```sql
insert into libro (titulo, autor, codigo_editorial, precio)
  values('El aleph', 'Borges', 2, 34);
 insert into libro (titulo, autor, codigo_editorial, precio)
  values('Antología poética', 'Borges', 1, 39.50);
 insert into libro (titulo, autor, codigo_editorial, precio)
  values('Java en 10 minutos', 'Mario Molina', 1, 50.50);
 insert into libro (titulo, autor, codigo_editorial, precio)
  values('Alicia en el pais de las maravillas', 'Lewis Carroll', 2, 19.90);
 insert into libro (titulo, autor, codigo_editorial, precio)
  values('Martin Fierro', 'Jose Hernandez', 2, 25.90);
 insert into libro (titulo, autor, codigo_editorial, precio)
  values('Martin Fierro', 'Jose Hernandez', 3, 16.80);
```

Las filas se agregan en forma correcta ya que en el campo __codigo_editorial__ se ingresan siempre valores comprendidos entre __1 y 3__, que son los códigos de editoriales existentes.

Intentemos de ingresar una fila con __codigo_editorial__ que no exista en la tabla "editoriales":

```sql
 insert into libro(titulo, autor, codigo_editorial) 
  values('JSP basico','Tornado Luis',7);
```

> Nota. ¿Qué sucede?

</div>