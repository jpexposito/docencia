<div align="justify">

<div align="center">
<img src="https://luciamonterorodriguez.com/wp-content/uploads/2021/03/computer-1331579_640.png" width="200px"/>
</div>

> __Nota__. Seguiremos trabajando con la tabla __usuario__.

Para eliminar los registros de una tabla usamos el comando "delete":

```sql
delete from usuario;
```

Si no queremos eliminar todos los registros, sino solamente algunos, debemos indicar cuál o cuáles, para ello utilizamos el comando "delete" junto con la clausula "where" con la cual establecemos la condición que deben cumplir los registros a borrar.

Por ejemplo, queremos eliminar aquel registro cuyo nombre de usuario es "Marcelo":

```sql
 delete from usuario where nombre='Marcelo';
```

> __Nota__.- Esta sentencia producirá algún cambio en la __BBDD__?.

Ejecuta una sentencia que produzca la eliminación de un registro sobre la BBDD.

```sql
 delete from usuario where ....;
```

Para las pruebas ejecuta la siguiente inserciones:

```sql
insert into usuario (nombre,clave)
  values ('Marcelo','River');
insert into usuario (nombre,clave)
  values ('Susana','chapita');
insert into usuario (nombre,clave)
  values ('CarlosFuentes','Boca');
insert into usuario (nombre,clave)
  values ('FedericoLopez','Boca');
```

Seleccionamos todos los registros:

```sql
select * from usuario;
```

Realizamos nuevamente la eliminación de un registro:

```sql
 delete from usuario where nombre='Marcelo';
```

> __Nota__.- Esta sentencia producirá algún cambio en la __BBDD__?.

```sql
select * from usuario;
```

</div>