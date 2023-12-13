<div align="justify">

<div align="center">
<img src="https://luciamonterorodriguez.com/wp-content/uploads/2021/03/computer-1331579_640.png" width="200px"/>
</div>

> __Nota__. Seguiremos trabajando con la tabla __usuario__.

Los operadores relacionales (o de comparación) nos permiten comparar dos expresiones, que pueden ser variables, valores de campos, etc.

Hemos aprendido a especificar condiciones de igualdad para seleccionar registros de una tabla; por ejemplo:

```sql
select nombre,clave
  from usuarios
  where clave='predrito';
```

> __Nota__.Utilizamos el operador relacional de igualdad.

Los operadores relacionales vinculan un campo con un valor para que SQLite compare cada registro (el campo especificado) con el valor dado.

Los operadores relacionales son los siguientes:

| __Operador__ | __Descripción__ |
| ------| -----|
| =	| igual |
| <> | distinto | 
| >	| mayor | 
| <	| menor |
| >= | mayor o igual |
| <= | menor o igual |

A continuación vamos a añadir un nuevo elemento a la BBDD:

```sql
insert into usuario (nombre, clave) values ('Juan Perez','juanito');
```
Podemos seleccionar los registros cuya clave sea diferente de 'pedrito', para ello usamos la condición:

```sql
select nombre,clave
  from usuario
  where clave<>'pedrito';
```

</div>