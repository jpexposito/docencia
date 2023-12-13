<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

__"null"__ significa "dato desconocido" o "valor inexistente". No es lo mismo que un valor "0", una cadena vacía o una cadena literal "null".

A veces, puede desconocerse o no existir el dato correspondiente a algún campo de un registro. En estos casos decimos que el campo puede contener valores nulos.

Por ejemplo, en una tabla de libro, podemos tener valores nulos en el campo "precio" porque es posible que para algunos libros no le hayamos establecido el precio para la venta.

En contraposición, tenemos campos que no pueden estar vacíos jamás.

Veamos un ejemplo. Tenemos nuestra tabla "libro". El campo "titulo" no debería estar vacío nunca, igualmente el campo "autor". Para ello, al crear la tabla, debemos especificar que dichos campos no admitan valores nulos:

```sql
create table libro(
  titulo text not null,
  autor text not null,
  editorial text null,
  precio real
 );
 ```
Para especificar que un campo no admita valores nulos, debemos colocar "not null" luego de la definición del campo.
En el ejemplo anterior, los campos "editorial" y "precio" si admiten valores nulos.
Cuando colocamos "null" estamos diciendo que admite valores nulos (caso del campo "editorial"); por defecto, es decir, si no lo aclaramos, los campos permiten valores nulos (caso del campo "precio")
Es común no disponer la cláusula null ya que es el valor por defecto para todo campo.

Si ingresamos los datos de un libro, para el cual aún no hemos definido el precio podemos colocar "null" para mostrar que no tiene precio:

```sql
insert into libro (titulo,autor,editorial,precio)
  values('El aleph','Borges','Emece',null);
```

Note que el valor "null" no es una cadena de caracteres, no se coloca entre comillas.
Entonces, si un campo acepta valores nulos, podemos ingresar "null" cuando no conocemos el valor.

También podemos colocar "null" en el campo "editorial" si desconocemos el nombre de la editorial a la cual pertenece el libro que vamos a ingresar:

```sql
insert into libro (titulo,autor,editorial,precio)
  values('Alicia en el pais','Lewis Carroll',null,25);
 ```

 Si intentamos ingresar el valor "null" en campos que no admiten valores nulos (como "titulo" o "autor"), SQLite no lo permite, muestra un mensaje y la inserción no se realiza; por ejemplo:
 
 ```sql
 insert into libros (titulo,autor,editorial,precio)
  values(null,'Borges','Siglo XXI',25);
  ```

 Para recuperar los registros que contengan el valor "null" en algún campo, no podemos utilizar los operadores relacionales vistos anteriormente: = (igual) y <> (distinto); debemos utilizar los operadores "is null" (es igual a null) y "is not null" (no es null): 

```sql
 select * from libro
  where precio is null;
  ```

que no es lo mismo que:

```sql
 select * from libro
  where precio=0;
``` 





</div>