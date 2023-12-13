<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Es posible obtener salidas en las cuales una columna sea el resultado de un cálculo y no un campo de una tabla.

Los operadores aritméticos permiten realizar cálculos con valores numéricos.
Son: multiplicación (*), división (/) y módulo (%) (el resto de dividir números), suma (+) y resta (-).

Si por ejemplo tenemos la tabla libro con los siguientes datos:

```sql
drop table if exists libro;

create table libro(
	codigo integer primary key,
	titulo text,
	autor text not null, 
	editorial text,
	precio real,
	cantidad integer
);

insert into libro (titulo,autor,editorial,precio,cantidad)
  values('El aleph','Borges','Planeta',15,100);
 insert into libro (titulo,autor,editorial,precio,cantidad)
  values('Martin Fierro','Jose Hernandez','Emece',22.20,200);
 insert into libro (titulo,autor,editorial,precio,cantidad)
  values('Antologia poetica','Borges','Planeta',40,150);
 insert into libro (titulo,autor,editorial,precio,cantidad)
  values('Aprenda PHP','Mario Molina','Emece',18.20,200);
 insert into libro (titulo,autor,editorial,precio,cantidad)
  values('Cervantes y el quijote','Borges','Paidos',36.40,100);
 insert into libro (titulo,autor,editorial,precio,cantidad)
  values('Manual de PHP', 'J.C. Paez', 'Paidos',30.80,100);
 insert into libro (titulo,autor,editorial,precio,cantidad)
  values('Harry Potter y la piedra filosofal','J.K. Rowling','Paidos',45.00,500);
 insert into libro (titulo,autor,editorial,precio,cantidad)
  values('Harry Potter y la camara secreta','J.K. Rowling','Paidos',46.00,300);
 insert into libro (titulo,autor,editorial,precio,cantidad)
  values('Alicia en el pais de las maravillas','Lewis Carroll','Paidos',null,50);
  
 select titulo, precio,cantidad,precio*cantidad
  from libro;
```

Si queremos saber el precio de cada libro con un 10% de descuento podemos incluir en la sentencia los siguientes cálculos:

```sql
select titulo, precio,precio*0.1,precio-(precio*0.1)
  from libro;  
```
También podemos actualizar los datos empleando operadores aritméticos, por ejemplo reducir el 10% del precio de todos los libros:

```sql
update libro set precio=precio-(precio*0.1); 
```
El operador de concatenación se obtiene con los caracteres __||__.

Para concatenar el título, el autor y la editorial de cada libro usamos el operador de concatenación ("||"):

```sql
 select titulo||'-'||autor||'-'||editorial
  from libro;
```

> __Nota__. Note que concatenamos además unos guiones para separar los campos.


</div>