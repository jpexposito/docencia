<div align="justify">

<div align="center">
<img src="https://www.comunidadbaratz.com/wp-content/uploads/Sabes-cuales-son-los-libros-mas-vendidos-de-2017-a-traves-de-Internet-en-Espana.jpg" width="200px"/>
</div>

Existe un operador que se usa para realizar comparaciones exclusivamente de cadenas, __like__ y __not like__.

Hemos realizado consultas utilizando operadores relacionales para comparar cadenas. Por ejemplo, sabemos recuperar los libros cuyo autor sea igual a la cadena __Borges__:

```sql
 select * from libro
  where autor='Borges';
```

El operador igual (__=__) nos permite comparar cadenas de caracteres, pero al realizar la comparación, busca coincidencias de cadenas completas, realiza una búsqueda exacta.

Imaginemos que tenemos registrados estos 2 libros:

 __El Aleph__, __Borges__;
 __Antologia poetica__, __J.L. Borges__;

Si queremos recuperar todos los libros de __Borges__ y especificamos la siguiente condición:

```sql
 select * from libro
 where autor='Borges';
```

sólo aparecerá el primer registro, ya que la cadena __Borges__ no es igual a la cadena __J.L. Borges__.

Esto sucede porque el operador __=__ (igual), también el operador __<>__ (distinto) comparan cadenas de caracteres completas. Para comparar porciones de cadenas utilizamos los operadores __like__ y __not like__.

Entonces, podemos comparar trozos de cadenas de caracteres para realizar consultas. Para recuperar todos los registros cuyo autor contenga la cadena __Borges__ debemos codificar en SQLite:

```sql
 select * from libro
  where autor like '%Borges%';
```

El símbolo __%__ (porcentaje) reemplaza cualquier cantidad de caracteres (incluyendo ningún caracter). Es un caracter comodín. __like__ y __not like__ son operadores de comparación que señalan igualdad o diferencia.

Para seleccionar todos los libros que comiencen con __M__:

```sql
 select * from libro
  where titulo like 'M%';
```
Note que el símbolo __%__ ya no está al comienzo, con esto indicamos que el título debe tener como primera letra la __M__ y luego, cualquier cantidad de caracteres.

Para seleccionar todos los libros que NO comiencen con __M__:

```sql
 select * from libro
  where titulo not like 'M%';
```

Así como __%__ reemplaza cualquier cantidad de caracteres, el guión bajo _____ reemplaza un caracter, es otro caracter comodín. Por ejemplo, queremos ver los libros de __Lewis Carroll__ pero no recordamos si se escribe __Carroll__ o __Carrolt__, entonces tipeamos esta condición:

```sql
 select * from libro
  where autor like '%Carrol';
```

> __Nota__. __like__ se emplea con tipos de datos __text__.

</div>