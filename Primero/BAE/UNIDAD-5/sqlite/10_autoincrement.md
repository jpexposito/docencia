<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

El gestor de base de datos SQLite administra de una forma muy particular los campos con autoincremento. En SQLite cuando definimos un campo de tipo Integer y dicho campo es primary key luego dicho campo si en un insert no lo cargamos se genera en forma automática con el último valor para dicho campo más 1.

Si por ejemplo creamos la tabla libros y definimos su campo codigo como clave primaria:

```sql
drop table if exists libro;
 
create table libro(
	codigo integer,
	titulo text,
	autor text,
	editorial text,
	primary key (codigo)
);
```

Seguidamente insertamos dos filas en la tabla sin hacer referencia al campo codigo:

```sql
insert into libro (titulo,autor,editorial)
  values('El aleph','Borges','Planeta');
  
insert into libro (titulo,autor,editorial)
  values('Martin Fierro','Jose Hernandez','Paidos'); 

```

Luego podemos comprobar que en el campo codigo se cargó un valor numérico en forma automática:

```sql
select codigo, titulo, autor, editorial from libro;
```


</div>