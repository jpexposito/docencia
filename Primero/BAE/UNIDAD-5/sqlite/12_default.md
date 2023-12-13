<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Podemos establecer valores por defecto para los campos cuando creamos la tabla. Para ello utilizamos __default__ al definir el campo. Por ejemplo, queremos que el valor por defecto del campo __autor__ de la tabla __libros__ sea __desconocido__ y el valor por defecto del campo __cantidad__ sea __0__:

```sql
drop table if exists libro;

create table libro(
	codigo integer primary key,
	titulo text,
	autor text not null default 'desconocido', 
	editorial text,
	precio real,
	cantidad integer default 0
 );
```

Si al ingresar un nuevo registro omitimos los valores para el campo "autor" y "cantidad", SQLite insertará los valores por defecto; en "autor" colocará "desconocido" y en cantidad "0".

Entonces, si al definir el campo explicitamos un valor mediante la cláusula "default", ése será el valor por defecto.

Si ejecutamos el comando:

```sql
insert into libro (titulo,precio)
  values ('El gato con botas',100);
```

> __Nota__. En el campo autor se almacena la cadena 'desconocido', en el campo cantidad se almacena el valor '0'. En el campo editorial se almacena null ya que no indicamos ningún valor por defecto.


</div>