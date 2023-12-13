<div align="justify">

<div align="center">
<img src="https://luciamonterorodriguez.com/wp-content/uploads/2021/03/computer-1331579_640.png" width="200px"/>
</div>

> __Nota__. Seguiremos trabajando con la tabla __usuario__.

Decimos que actualizamos un registro cuando modificamos alguno de sus valores.

Para modificar uno o varios datos de uno o varios registros utilizamos el comando __"update"__ (actualizar).

Por ejemplo, en nuestra tabla "usuario", queremos cambiar los valores de todas las claves por la cadena __"RealMadrid"__:

Utilizamos __"update"__ junto al nombre de la tabla y __"set"__ junto con el campo a modificar y su nuevo valor.

El cambio afectará a todos los registros.

Podemos modificar algunos registros, para ello debemos establecer condiciones de selección con la cláusula __"where"__.
Por ejemplo, queremos cambiar el valor correspondiente a la clave de nuestro usuario llamado __"Federicolopez"__, queremos como nueva clave __"Boca"__, necesitamos una condición __"where"__ que afecte solamente a este registro:

```sql
update usuario set clave='Boca'
  where nombre='Federicolopez';
```

> __Nota__.Si SQLite no encuentra registros que cumplan con la condición del "where", no se modifica ninguno.

Las condiciones no son obligatorias, pero si omitimos la cláusula __"where"__, la actualización afectará a todos los registros.

También podemos actualizar varios campos en una sola instrucción:

```sql
 update usuario set nombre='Marceloduarte', clave='Marce'
  where nombre='Marcelo';
```

Para ello colocamos __"update"__, el __nombre de la tabla__, __"set"__ junto al nombre del campo y el nuevo valor y separado por coma, el otro nombre del campo con su nuevo valor.

</div>