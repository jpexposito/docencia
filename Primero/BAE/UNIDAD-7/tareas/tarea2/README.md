<div align="justify">

# Tarea 2 de trabajo con índices

<div align="center">
<img src="../../img/indices.png"/>
</div>

Una empresa guarda los siguientes datos de sus clientes, con los siguientes campos:
- documento char (8) not null,
- nombre varchar(30) not null,
- domicilio varchar(30),
- ciudad varchar(20),
- provincia varchar (20),
- telefono varchar(11)

Se pide: 
- Elimine la tabla "cliente" si existe. 
    >__Nota__:_Muestra el comando y la salida_.
- Cree la tabla si clave primaria y incluye a posteriori esta.
    >__Nota__:_Muestra el comando y la salida_. 
- Define los siguientes indices:
   - Un índice único por el campo "documento" y un índice común por ciudad y provincia.
        >__Nota__:_Muestra el comando y la salida. Justifica el tipo de indice en un comentario_. 
    - Vea los índices de la tabla.
        >__Nota__:_Muestra el comando y la salida __"show index"___.
- Agregue un índice único por el campo "telefono".
    >__Nota__:_Muestra el comando y la salida_.
- Elimina los índices.
    >__Nota__:_Muestra el comando y la salida_.
    
## Referencias

- [Índices en MySql](https://dev.mysql.com/doc/refman/8.0/en/mysql-indexes.html).
- [Apuntes sobre índices](../../Indices.md).

</div>