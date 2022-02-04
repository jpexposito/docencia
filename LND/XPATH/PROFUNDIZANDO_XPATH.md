<div align="justify">


<div align="center">
 	<img src="https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2019/01/Picture1-7-291x180.png">
</div>

</br>

Para todos los ejemplos siguiente vamos a tomar como referencia el siguiente documento XML:

```xml
<bib url="http://www.iespuerto.com">
  <book id="1">
    <title>TCP/IP Illustrated</title>
    <author>Stevens</author>
    <publisher>Addison-Wesley</publisher>
    <year>2002</year>
  </book>
  <book id="2">
    <title>Advanced Programming in the Unix Environment</title>
    <author>Stevens</author>
    <publisher>Addison-Wesley</publisher>
    <year>2004</year>
  </book>
  <book id="3">
    <title>Data on the Web</title>
    <author>Abiteboul</author>
    <author>Buneman</author>
    <author>Suciu</author>
    <year>2006</year>
  </book>
</bib>

```

## Herramientas para el manejo de XPath

  Para probar XPath podemos utilizar el software libre [BaseX](https://basex.org/) o cualquier otro que comentamos aquí.

  Y de manera online podemos utilizar [xpathtester](http://www.xpathtester.com/xpath).

## Direccionamiento o localización

  El direccionamiento o localización es una ruta o camino de nodos de un documento XML que nos permitirán seleccionar un conjunto de ellos.

  El direccionamiento puede ser:
  - _Absoluto_: si siempre se incluye el nodo raíz.
  - _Relativo_: si se empieza a hacer referencia a los nodos desde un nodo diferente al nodo raíz.

  Las expresiones que se pueden utilizar en un direccionamiento XPath son:
  - _nodo_.	Elemento de nombre nodo.
  - _/nodo_.	El nodo se encuentra en la raíz del documento.
  - _nodo1/nodo2_.	El nodo2 es hijo directo de nodo1.
  - _nodo1//nodo2_.	El nodo2 es hijo del nodo1 pero puede haber nodos intermedios.
  - //nodo	El nodo está ubicado en cualquier nivel debajo del nodo raíz.
  - _@atributo_	Atributo de nombre atributo.
  - _*_.	Cualquier elemento.
  - _@*_.	Cualquier atributo.
  - _._	Nodo actual.
  - _.._	Nodo padre.

  Pongamos algunos ejemplos de su uso.

  Para listar los títulos de los libros de la biblioteca:

  ```
  /bib/book/author
  ```

  Para listar los autores sin indicar de qué nodo son hijos:
  ```
  //author
  ```

  Para listar los identificadores de los libros:
  ```
  /bib/book/@id
  ```

  Para listar todos los atributos de cualquier nodo:
  ```
  //@*
  ```
  El acceso al contenido textual del nodo se puede realizar con la siguiente función:
  - _text()_: Devuelve el texto del nodo.

  Por ejemplo, para listar sólo los títulos de los libros de la biblioteca sin las etiquetas:
  ```
  /bib/book/author/text()
  ```

### Filtrar el acceso a elementos

  El direccionamiento de XPath también permite filtrar el conjunto de nodos o información a la que se accede mediante la consulta utilizando condiciones en nodos. El filtro se especifica mediante corchetes [ ] seguidos del nodo al que se le aplica dicho filtro.

  Podemos utilizar los siguientes operadores:
  - _and_.	 
  - _or_.	 
  - _not_.	 
  - _=_.	 
  - _!=_.	 
  - _<_.	 
  - _>_.	 
  - _<=_.	 
  - _>=_.	 
  - _to_	Rango.
  - _+_	Suma.
  - _-_	Resta.
  - _*_	Multiplicación.
  - _div_	División.
  - _mod_	Resto de la división.
  - _|_	Unión de resultados.

  Podemos utilizar las siguientes funciones de XPath, como más importantes.

### Funciones numéricas

  - _round()_	Redondeo	round(3.14) = 3.
  - _abs()_	Valor absoluto	abs(-7) = 7.
  - _floor()_	Redondeo
  - _inferior_	floor(7.3) = 7
  - ceiling	Redondeo superior	ceiling(7.3) = 8

### Funciones de cadena

  substring()	Subcadena	substring('TicArte', 1, 4) = TicA
  starts-with()	Cadena comienza por	starts-with('XML', 'X') = true
  ends-with()	Cadena finaliza por	ends-with('XML', 'X') = false
  contains()	Cadena contiene	contains('XML', 'ML') = true
  normalize-space()	Espacios normalizados	normalize-space(' Doc XML ') = 'Doc XML'
  translate()	Cambia caracteres en una cadena	translate('Doc XML', 'Doc', 'File') = 'File XML'
  string-length()	Longitud de una cadena	string-length('TicArte') = 7
  upper-case()	Cadena a mayúsculas	upper-case('xml') = 'XML'
  lower-case()	Cadena a minúsculas	lower-case('XML') = 'xml'

### Funciones de posición de elementos

  position() = n	Nodo que se encuentra en la posición 'n'
  elemento[n]	Nodo en la posición 'n' de los que se llaman nodo
  last()	El último nodo de un conjunto
  last() - i	El último menos i nodos

### Funciones de nodos

  name()	Nombre del nodo actual
  text()	Contenido textual del nodo
  root()	Elemento raíz
  node()	Nodos descendientes del actual
  comment()	Comentarios del nodo
  processing-instruction()	Instrucciones de procesamiento
  exists()	Si existe el nodo o no
  empty()	Si el nodo está vacío o no

### Funciones de agregado

  count()	Contar los nodos
  avg()	Media del contenido de los nodos
  max()	Valor máximo del contenido de los nodos
  min()	Valor mínimo del contenido nodos
  sum()	Suma del contenido de los nodos

  A continuación exponemos una serie de ejemplos que ayuden a clarificar el uso de filtros.

  Mostrar todos los autores y publicadores. Utilizaremos el operador unión para unir los dos conjuntos de nodos:

  ```
  /bib/book/author|/bib/book/publisher
  ```

  Suponiendo que el documento XML tiene libros y diccionarios, podemos ver todos los autores:

  ```
  /bib/(book|dictionary)/author
  ```

  Mostrar el libro número 2:

  ```
  /bib/book[position()=2]
  /bib/book[2]
  ```

  Mostrar del libro número 2 al número 3:

  ```
  /bib/book[position()=2 to 3]
  ```

  Mostrar el último libro:
  ```
  /bib/book[last()]
  ```

  Mostrar los libros anteriores al año 2003. Los números no necesitan comillas.

  ```
  /bib/book[year<2003]
  ```

  Mostrar los libros cuyo autor sea Stevens. Las cadenas deben ir siempre entre comillas. Se muestran diferentes formas de conseguir lo mismo.

  ```
  /bib/book[author="Stevens"]
  /bib[book/author="Stevens"]/book
  //author[.="Stevens"]/..
  ```

  Mostrar el título de los libros cuyo autor sea Stevens. Hay que fijarse que la condición va en el nodo book pero luego mostramos el nodo title que contiene.

  ```
  /bib/book[author="Stevens"]/title
  ```

  Se podría hacer la condición también en title, pero puede ser más lioso:

  ```
  /bib/book/title[../author="Stevens"]
  ```

  Mostrar los títulos de los libros cuyo identificador sea el 2:

  ```
  /bib/book[@id="2"]/title
  ```

  Mostrar los títulos de los libros de Stevens publicados en el 2002. Podemos utilizar el operador and.

  ```
  /bib/book[author="Stevens" and year=2002]/title
  ```

  Mostrar los títulos de los libros de Stevens publicados en el 2002. Podemos concatenar diferentes condiciones, cada una en sus corchetes, que es el mismo significado que el operador and.

  ```
  /bib/book[author="Stevens"][year=2002]/title
  ```

  Mostrar los títulos de los libros que comienzan por 'T':

  ```
  /bib/book[starts-with(title,"T")]/title
  ```

  Mostrar los títulos de los libros que tengan una longitud de más de 10 caracteres:

  ```
  /bib/book[string-length(title)>10]/title
  ```  

  Consultas XPath anidadas
  Las consultas XPath anidadas consisten en incluir una consulta XPath que devuelta un cierto valor dentro de la condición de otra consulta XPath.

  Por ejemplo, mostrar todos los títulos de los libros del autor que escribió "TCP/IP Illustrated". Si nos fijamos, en ningún caso nos están diciendo el nombre del autor, por lo que tendremos que hacer una consulta previa para localizarlo. Los pasos serían los siguientes:

  1) Encontrar primero al autor del libro "TCP/IP Illustrated", pero mostrando sólo el texto sin las etiquetas. Esta consulta nos devolverá Stevens.

  ```
  /bib/book[title="TCP/IP Illustrated"]/author/text()
  ```

  2) A continuación debemos encontrar todos los libros que escribió dicho autor, en nuestro caso Stevens.

  ```
  /bib/book[author="Stevens"]/title
  ```

  3) Pero claro, la consulta anterior no es la correcta, porque no podemos usar el nombre de Stevens. Tendremos que sustuir la consulta 1 dentro de la consulta 2, pero eliminando las comillas dobles:

  ```
  /bib/book[author=/bib/book[title="TCP/IP Illustrated"]/author/text()]/title
  ```  

  Sintaxis abreviada y compleja
  Existen dos sintaxis diferentes a la hora de escribir consultas XPath:
  - _Sintaxis abreviada_: más sencilla y fácil de leer. Todos los ejemplos anteriores corresponden a esta sintaxis.
  - _Sintaxis compleja_: más larga y compleja de leer. Utiliza los ejes para nombrar los elementos.

### Ejes

  Los ejes son expresiones que permiten acceder a trozos del árbol XML apoyándose en las relaciones de parentesco entre los nodos. En las siguientes definiciones, el nodo de contexto se refiere al nodo al que se le está aplicando el eje.
  - _self::_.	Devuelve el propio nodo de contexto. Equivale a .
  - _child::_.	Devuelve los nodos hijo del nodo de contexto.
  - _parent::_.	Devuelve el nodo padre del nodo de contexto. Equivale a ..
  - _ancestor::_.	Devuelve los nodos antepasados (padre, abuelo, ...) del nodo de contexto.
  - _ancestor-or-self::_.	Devuelve los nodos anteasados (padre, abuelo, ...) además del propio nodo de contexto.
  - _descendant::_.	Devuelve los nodos descendientes (hiejo, nieto, ...) del nodo de contexto.
  - _descendant-or-self::_.	Devuelve los nodos descendientes (hijo, nieto, ...) además del propio nodo de contexto. Equivale a //
  - _following::_.	Devuelve los nodos que aparezcan después del nodo de contexto en el documento, excluyendo a los nodos descendientes, los atributos y los nodos de espacio de nombres.
  - _preceding::_.	Devuelve los nodos que aparezcan antes del nodo de contexto en el documento, exluyendo a los nodos ascendientes, los atributos y los nodos de espacio de nombres.
  - _following-sibling::_.	Devuelve los hermanos menores del nodo de contexto.
  preceding-sibling::	Devuelve los hermanos mayores del nodo de contexto.
  - _attribute::_.	Atributos del nodo de contexto.
  - _namespace::_.	Espacio de nombres del nodo de contexto.

  Ejemplos de sintaxis compleja
  Para listar todos los títulos de los libros:

  ```
  /child::bib/child::book/child::title
  ```

  ```
  /bib/book/title
  ```

  Para listar los hermanos menores del segundo autor:

  ```
  /bib/book/author[2]/following-sibling::*
  ```

  Para listar los descendientes de elemento ráiz en los que el nodo se llame year:

  ```
  /bib/descendant::year
  ```

  ```
  /bib//year
  ```

</div>
