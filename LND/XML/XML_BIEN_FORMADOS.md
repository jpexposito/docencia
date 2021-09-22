
<div align="justify">

# Elaboración de documentos XML bien formados.

  En un documento XML no debe ponerse un elemento que contenga un dato además de otros elementos. Si bien esta situación no genera errores de sintaxis, se dificultará el procesado posterior que pudiera aplicarse al documento. Por ejemplo:

```xml
 <alumno>Juan
 <apellidos>Garrido Fdez.</apellidos>
 </alumno>
```
 Como se ve en el ejemplo, el elemento alumno contiene el dato "Juan" además del elemento apellidos. El dato "Juan" queda mezclado con el elemento apellidos, por lo que no se puede acceder a dicho dato de forma independiente. Por tanto, debe definirse otro elemento para el dato __Juan__, es decir que cada dato debe tener su etiqueta asociada, del modo:
 
```xml
<alumno>
<nombre>Juan</nombre>
<apellidos>Garrido Fdez.</apellidos>
</alumno>
```

Cuando un documento tiene un elemento que se repite porque la información que se desea almacenar así lo requiere, no debe numerarse dicho elemento. Se tiende a añadir el número en el propio nombre del elemento pero no es correcto. Por ejemplo:

__ES INCORRECTO:__ 

```xml
<AlumnosCiclo>
<alumno1>Juan Garrido</alumno1>
<alumno2>José Gómez</alumno2>
<alumno3>Jesús García</alumno3>
<alumno4>Pedro López</alumno4>
etc.
etc.
</AlumnosCiclo>
```

__ES CORRECTO:__

```xml
<AlumnosCiclo>
<alumno>Juan Garrido</alumno>
<alumno>José Gómez</alumno>
<alumno>Jesús García</alumno>
<alumno>Pedro López</alumno>
etc.
etc.
</AlumnosCiclo>
```

Escrito de este último modo se facilita el posterior procesado del documento; además los alumnos están ordenados según el orden en que se escriben, por lo que numerarlos es innecesario. Por otra parte, al añadir un número al nombre de la etiqueta, cada etiqueta tendrá un nombre distinto, es decir la etiqueta alumno1 no es la misma que alumno2; son etiquetas distintas, por lo que será más difícil procesar el documento (se verá en temas posteriores). A veces interesa añadir elementos simplemente para estructurar mejor el documento, así como para hacerlo más legible. Por ejemplo:

```xml
<integrantes>
<lista_alumnos>
<alumno>...</alumno>
<alumno>...</alumno>
...
</lista_alumnos>
<lista_profesores>
<profesor>...</profesor>
<profesor>...</profesor>
...
</lista_profesores>
</integrantes>
```

En ese ejemplo, las etiquetas __<lista_alumnos></lista_alumnos> y <lista_profesores></lista_profesores>__ podrían eliminarse, quedando:

```xml
<integrantes>
<alumno>...</alumno>
<alumno>...</alumno>
...
<profesor>...</profesor>
<profesor>...</profesor>
...
</integrantes>
```

 El documento sería igualmente correcto, pero al incluir las etiquetas citadas el código queda más claro y estructurado, ya que existe una etiqueta que da acceso a todos los alumnos y otra que da acceso a todos los profesores.

## Atributos.

 Permiten añadir propiedades a los elementos de un documento. Los atributos no pueden organizarse en ninguna jerarquía, no pueden contener ningún otro elemento o atributo y no reflejan ninguna estructura lógica.

 No se debe utilizar un atributo para contener información susceptible de ser dividida. 

__Ejemplo__.

```xml
<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<biblioteca>
<documento tipo_docum="libro" titulo="XML práctico" editorial="Ediciones Eni">
<tipo> <libro isbn="978-2-7460-4958-1" edicion="1" paginas="347"></libro> </tipo>
<autor nombre="Sebastien Lecomte"></autor>
<autor nombre="Thierry Boulanger"></autor>
<autor nombre="Ángel Belinchon Calleja" funcion="traductor"></autor>
<prestado lector="Pepito Grillo">
<fecha_pres dia="13" mes="mar" año="2009"></fecha_pres>
<fecha_devol dia="21" mes="jun" año="2009"></fecha_devol>
</prestado>
</documento>
</biblioteca>
```
 __Guarda el fichero y ejecutalo con un navegador__

 Vemos que los elementos aparecen coloreados en ciruela, los nombres de los atributos en negro y sus valores en azul. En ese ejemplo todos los datos están almacenados en atributos y ninguno en elementos.
 Como se observa en el ejemplo, los atributos se definen y dan valor dentro de una etiqueta de inicio de un elemento. Para guardar un valor en un atributo se usa el signo igual, =. El valor del atributo irá entre comillas simples o dobles. Por ejemplo:
 - Elemento: autor
  - Atributo: nombre
  - Valor del atributo: Roberto Lemus
 Se escribirá:
 
 ```xml
<autor nombre="Roberto Lemus"></autor>
```

 Como ese elemento autor no guarda ningún dato (el dato está en el atributo), se puede cerrar el elemento autor como sigue:

```xml
<autor nombre="Sebastien Lecomte" />
```

 Si un mismo elemento tiene varios atributos, se escriben separados por un espacio. Por ejemplo:
 - Elemento: libro
 - Atributos: isbn, edicion, paginas

 Se escribirá:

```xml
<libro isbn="978-2-7460-4958-1" edicion="1" paginas="347" />
```

 Los nombres de los atributos han de cumplir las mismas reglas que los de los elementos y no pueden contener el carácter menor que, <. Un elemento puede guardar un valor además de tener atributos. Por ejemplo:

```xml
 <autor funcion="traductor">Ángel Belinchon Calleja</autor>
```
 Vemos que el elemento autor guarda el nombre del autor (Ángel Belinchon Calleja), sin usar el signo = y sin comillas. Por otra parte, ese elemento tiene el atributo funcion, que guarda el valor "traductor" usando el signo = y las comillas.

 Puede haber algún atributo vacío, es decir sin valor asignado (valor nulo). Para ello se escriben las comillas seguidas después del signo =. No debe dejarse el signo = sin las comillas. Por

 Ejemplo:

```
CORRECTO: <autor funcion="">Ángel Belinchon Calleja</autor>
INCORRECTO: <autor funcion= >Ángel Belinchon Calleja</autor>
```
 Cualquier dato puede guardarse como un elemento o como un atributo dentro de un elemento. Por ejemplo, las dos líneas siguientes guardan el dato "Juan" y ambas son correctas sintácticamente:

```xml
<autor>Juan</autor>
<autor nombre="Juan" />
```
 Sin embargo, como norma general se puede indicar que un elemento suele guardar el dato principal, mientras que los atributos guardarán características adicionales del elemento en cuestión. Por ejemplo, si se considera que el nombre del alumno es el dato principal y la edad es una característica secundaria, quedaría:

```xml
<alumno edad="21" >Juan Garrido</alumno>
```

El dato del nombre del alumno se guarda en el elemento, mientras que la edad se guarda en el atributo. Por otra parte, cuando un elemento sólo guarda un dato, en general no es conveniente guardar dicho dato en un atributo, sino guardarlo directamente en el elemento. Por ejemplo:

__NO ES CONVENIENTE__:

```xml
 <autor nombre="Juan" />
```

Quedaría mejor y con menos código del modo siguiente:

```xml
<autor>Juan</autor>
```

En este caso, no se utiliza atributo y por tanto no es necesario inventar un identificador (nombre) para ese atributo. Por ello es mejor de este modo. Sin embargo, puede interesar el uso del atributo en esa situación si el código quedara más legible y más fácil de entender.
### Datos.

 Es importante tener en cuenta que al guardar un dato no se debe almacenar la parte que sea fija (común) en todos los ítems iguales del documento XML. Por ejemplo, para guardar la edad de los alumnos no debe guardarse la palabra "años", ya que todas las edades del documento se van a expresar en años, es decir que lo siguiente no sería correcto:

_INCORRECTO: por almacenar la palabra_ __años__. 
```xml
<alumno edad="21 años">Juan Garrido</alumno>
<alumno edad="30 años">José Fuentes</alumno>
<alumno edad="19 años">Ramón Gómez</alumno>
```

 Eso afecta tanto a atributos como a elementos. Sería incorrecto: __INCORRECTO__: por almacenar la palabra _años_.

```xml
<alumno><nombre>Juan Garrido</nombre><edad>21 años</edad></alumno>
<alumno><nombre>José Fuentes</nombre><edad>30 años</edad></alumno>
<alumno><nombre>Ramón Gómez</nombre><edad>19 años</edad></alumno>
```

_Lo correcto sería poner simplemente el número en la edad, sin incluir la palabra_ __años__.

```xml

(<años>21</años> o años="21").
<alumno><nombre>Juan Garrido</nombre><edad>21</edad></alumno>
<alumno><nombre>José Fuentes</nombre><edad>30</edad></alumno>
<alumno><nombre>Ramón Gómez</nombre><edad>19</edad></alumno>
```

 Esta situación se da frecuentemente con las unidades de medida (años, metros, KBytes, Kg, etc.). La unidad de medida no debe guardarse si es la misma para todos los ítems iguales del documento. Como todas la edades anteriores están expresadas en años, no es necesario indicarlo en el propio dato (se da por hecho que son años sin necesidad de escribirlo). Otro ejemplo podría ser el siguiente, suponiendo que todas las RAM se expresan en GB:

__ES INCORRECTO: <RAM>Memoria 4 GB</RAM>__
__ES CORRECTO: <RAM>4</RAM>__
 
 Ello es así porque de ese modo no se ocupa espacio en disco de forma innecesaria, además de facilitar el procesamiento del documento XML. Podemos indicar como norma general que un dato debe tener un formato fácil de comparar con otros datos (en cuanto a mayúsculas, tildes, espacios, etc.). También puede aplicarse eso por ejemplo a los precios. Si todos van en euros, no es necesario guardar la palabra __euro__ o el símbolo __€__, sólo se almacena el valor numérico. Por otra parte, si un elemento (o atributo) tiene un conjunto limitado de valores posibles, debe mantenerse el mismo formato para todos los valores que coincidan. Por ejemplo, si los valores posibles son __SI__ y __NO__, deben escribirse siempre igual en cuanto a mayúsculas,minúsculas, tildes, espacios, etc. No sería correcto guardar el elemento MayorEdad para varios alumnos como sigue:

__SERÍA INCORRECTO:__

```xml
<MayorEdad>SI</MayorEdad>
<MayorEdad>No</MayorEdad>
<MayorEdad>Si es</MayorEdad>
<MayorEdad>si</MayorEdad>
<MayorEdad>No es mayor de edad</MayorEdad>
```

__LO CORRECTO SERÍA:__

```xml
<MayorEdad>SI</MayorEdad>
<MayorEdad>NO</MayorEdad>
<MayorEdad>SI</MayorEdad>
<MayorEdad>SI</MayorEdad>
<MayorEdad>NO</MayorEdad>
```
 Otro ejemplo podría ser el elemento <TipoVia> (de una dirección), cuyos valores son __CALLE__, __AVENIDA__ y __PLAZA__. Deberán escribirse respetando siempre el mismo formato; por Ejemplo, no poner una veces __AVENIDA__ y otras __AVDA.__

 Por otra parte, el valor numérico 0 (cero) es conveniente guardarlo siempre como numérico 0 (cero) y no con el texto "Nada" o "No hay" o "No tiene", etc. Por ejemplo, si se desea guardar el número de ausencias al trabajo de empleados.

__SERÍA INCORRECTO:__

```xml
<ausencias>1<ausencias>
<ausencias>No tiene<ausencias>
<ausencias>3<ausencias>
<ausencias>Ninguna<ausencias>
```


__LO CORRECTO SERÍA:__

```xml
<ausencias>1<ausencias>
<ausencias>0<ausencias>
<ausencias>3<ausencias>
<ausencias>0<ausencias>
```

</div>

<div align="center">
    <a href="XML.md"><img src="../../img/before.png" alt="Etiquetas" style="width:42px;height:42px;"></a>
    <a href="README.md"><img src="../../img/home.png" alt="XML Home" style="width:42px;height:42px;"></a>
    <a href="ESPACIO_NOMBRES.md"><img src="../../img/next.png" alt="XML" style="width:42px;height:42px;"> 
</div>