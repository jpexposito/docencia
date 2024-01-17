<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Los operadores __regexp__ y __not regexp__ busca patrones de modo similar a __like__ y __not like__.

Una __expresión regular__ es una técnica que nos permite __identificar__ si un __TEXTO__ coincide con un __PATRÓN__ determinado.

Un ejemplo clásico es determinar si un ___email__ está correctamente almacenado(sabemos que __comienza__ con uno o más __caracteres alfanuméricos__, luego el carácter __@__ seguido de __uno o más caracteres alfanuméricos__, luego el carácter __'.'__ y finalmente otros caracteres alfabéticos).

Existe toda una serie de reglas para crear las expresiones regulares que iremos viendo.

### Problema resuelto
#### Trabajar con la tabla __libro__.

```sql
drop table if exists libro;
```

Crear la tabla con la siguiente estructura:

```sql
create table libro(
  codigo integer primary key,
  titulo text,
  autor text, 
  editorial text,
  precio real
);
```

Insertar los siguientes registros:

```sql
 insert into libro (titulo,autor,editorial,precio)
  values('El aleph','Borges','Planeta',15.50);
 insert into libro (titulo,autor,editorial,precio)
  values('Martin Fierro','Jose Hernandez','Emece',22.90);
 insert into libro (titulo,autor,editorial,precio)
  values('Antologia poetica','J.L. Borges','Planeta',39);
 insert into libro (titulo,autor,editorial,precio)
  values('Aprenda PHP','Mario Molina','Emece',19.50);
 insert into libro (titulo,autor,editorial,precio)
  values('Cervantes y el quijote','Bioy Casare- J.L. Borges','Paidos',35.40);
 insert into libro (titulo,autor,editorial,precio)
  values('El Manual de PHP', 'J.C. Paez', 'Paidos',19);
 insert into libro (titulo,autor,editorial,precio)
  values('Harry Potter y la piedra filosofal','J.K. Rowling','Paidos',45.00);
 insert into libro (titulo,autor,editorial,precio)
  values('Harry Potter y la camara secreta','J.K. Rowling','Paidos',46.00);
 insert into libro (titulo,autor,editorial,precio)
  values('Alicia en el pais de las maravillas','Lewis Carroll','Paidos',36.00);  
```

Para buscar los títulos de los libros que contengan la cadena __Ma__ en cualquier parte usamos:

```sql
 select titulo from libro
  where titulo regexp 'Ma';
```  

Los libros que contienen esta subcadena son:

```sql
Martin Fierro
El Manual de PHP
```

Para buscar los autores que tienen al menos una __H__ o una __k__ o una __w__ tipeamos:

```sql
 select titulo,autor from libro
  where autor regexp '[Hkw]';  
```

Los autores que cumplen esta expresión regular son:

```
Jose Hernandez
J.K. Rowling
J.K. Rowling
Lewis Carroll
```

Es sensible a mayúsculas y minúsculas.

Para buscar los autores que no tienen ni __H__ o una __k__ o una __w__ tipeamos:

```sql
 select autor from libro
  where autor not regexp '[Hkw]'; 
```

Para buscar los autores que tienen por lo menos una de las letras de la __a__ hasta la __d__, es decir, __a,b,c,d__, usamos:

```sql
 select autor from libro
  where autor regexp '[a-d]';  
```

Para ver los títulos que comienzan con __A__ tipeamos:

```
 select titulo from libro
  where titulo regexp '^A';  
```

Para ver los títulos que terminan en __HP__ usamos:

```
select titulo from libro
  where titulo regexp 'HP$';  
```

Para buscar títulos que contengan una __a__ luego un caracter cualquiera y luego una __e__ utilizamos la siguiente sentencia:

```
 select titulo from libro
  where titulo regexp 'a.e';
```

El punto (.) identifica cualquier caracter.

Podemos mostrar los títulos que contienen una __a__ seguida de 2 caracteres y luego una __e__:

```
select titulo from libro
  where titulo regexp 'a..e';  
```

Para buscar autores que tengan 6 caracteres exactamente usamos:

```
 select autor from libro
  where autor regexp '^......$';
```

Para buscar autores que tengan al menos 6 caracteres usamos:

```
 select autor from libro
  where autor regexp '......';
```

Cuando tenemos que buscar en el string alguno de los caracteres que tienen un significado especial en las expresiones regulares '^ $. * +? =! : | \ / () [] {} ' debemos escaparlos dentro de los corchetes.

```
 insert into libro (titulo,autor,editorial,precio)
  values('Como ganar $ en esta vida','Rodriguez Pablo','Paidos',25.00);  
 select titulo from libro
  where titulo regexp '\$';
```   
Si queremos buscar el caracter __$__ debemos anteceder el caracter de escape __\__.

Ahora veremos que podemos inicializar luego que indicamos entre corchetes el patrón a buscar la cantidad de veces que puede repetirse este patrón.
Son útiles para controlar la cantidad de repeticiones del patrón definido.

Se especifican luego del corchete donde definimos los caracteres permitidos. Verificar si el precio del libro tiene entre 3 y 6 dígitos:

```
 insert into libro (titulo,autor,editorial,precio)
  values('Python','Charles Dierbach','Wiley',100.24);    
 select titulo, precio from libro
  where precio regexp '[0-9]{3,6}'; 
```

Este último registro insertado cumple que el precio tiene entre 3 y 6 dígitos la parte entera.

## Algunos Metacaracteres Útiles:

| Símbolo | Descripción |
| -------- |  -------- | 
| __*__ | Se corresponde con cero o más incidencias.|
| __\|__ | Operador de modificación para especificar correspondencias alternativas. En pocas palabras equivale a ‘o’. Eje: 8|5 = 8 o 5. | 
| __^/$__ |  ^: representa inicio de línea; $ es fin de línea. | 
| __[ ]__ | Expresión entre corchetes para una lista de correspondencia que se corresponde con cualquiera de las expresiones representadas en la lista. | 
| __{m}__ | Se corresponde exactamente m veces. | 
| __{m,n}__ | Se corresponde al menos m veces, pero no más de n veces. | 
| __[: :]__ | Especifica una clase de carácter y se corresponde con cualquier carácter de esa clase. | 
| __\__ |Puede tener 4 significados diferentes: 1. Se representa a sí mismo. 2. Presenta el siguiente carácter. 3. Introduce un operador. 4. No hace nada. | 
| __+__ | Se corresponde con una o más incidencias. | 
| __?__ | Se corresponde con cero o una incidencia. | 
| __.__ | Se corresponde con cualquier carácter del juego de caracteres soportado, excepto NULL. | 
| __( )__ | Expresión de agrupamiento, que se trata como subexpresión única. | 
| __[==]__ | Especifica clases de equivalencia. | 
| __\n__ | Referencia a expresión anterior. |
|  __[..]__ | Especifica un elemento de intercalación como, por ejemplo, un elemento de varios caracteres. | 
| __\d__ | Equivale a un Digito (Carácter Numérico). | 
| __\D__ | Equivale a un Carácter __NO Numérico__. | 
| __\w__ | Representa un carácter alfanumérico. Incluye el underscore( _)
| __\W__ | Representa un Carácter __NO letra__. | 
| __\A__ | Equivale al inicio de una cadena de caracteres o el fin de una cadena antes de una nueva línea. | 
| __\Z__ | Representa el fin de una cadena | 
| __\s__ | Equivale a un espacio en blanco. | 
| __\S__ | Equivale a un no espacio en blando. | 

</div>