<div align="justify">

<div align="center">
<img src="https://luciamonterorodriguez.com/wp-content/uploads/2021/03/computer-1331579_640.png" width="200px"/>
</div>

Vamos a seguir interactuando con nuesta base de datos de __usuario__.
> __Nota__. Para ello debes de  realizar la tarea anterior a esta.

> __Recuerda__: Un registro es una fila de la tabla que contiene los datos propiamente dichos. Cada registro tiene un dato por cada columna.

## Insert

Usamos __insert into__. Especificamos los nombres de los campos entre paréntesis y separados por comas y luego los valores para cada campo, también entre paréntesis y separados por comas.

```sql
insert into usuario (nombre, clave) values ('Pedro Perez','pedrito');
```

Es importante ingresar los valores en el mismo orden en que se nombran los campos, si ingresamos los datos en otro orden, los datos se guardan de modo incorrecto.

Note que los datos ingresados, como corresponden a campos de cadenas de caracteres se colocan entre comillas simples. Las comillas simples son OBLIGATORIAS.

Para ver los registros de una tabla usamos __select__:

```sql
select nombre,clave from usuario;
```
__ó__

```sql
select * from usuario;
```

> __Práctica__: _Realiza la inserción de 5 registros más, y realiza el select con una clausula_ __where__ _asociada_.

Algo muy importante al trabajar con la herramienta SQLite Browser es que si queremos que todos los cambios queden registrados en la base de datos abierta debemos presionar la opción __Guardar cambios__.

</div>