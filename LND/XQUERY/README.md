<div align="justify">


# XQUERY

<div align="center">
 	<img src="https://www.w3schools.com/xml/pic_xpath.gif">
</div>

## Introducción

  XQuery es un lenguaje de consulta que permite extraer información de bases de datos o documentos XML. Se puede decir que XQuery es a XML lo mismo que SQL a las bases de datos relacionales.

  XQuery se basa en el lenguaje [XPath](../XPATH) para el acceso a los nodos XML, pudiendo utilizar todos sus operadores y funciones.

  Se trata de una recomendación del W3C:

  - XQuery 3.0
  - XQuery 1.0

  El lenguaje XQuery es muy amplio y complejo. Aquí sólo pretendemos hacer una introducción a su uso para hacernos una idea de su potencial junto a documentos XML.

  Para todos los ejemplos siguiente vamos a tomar como referencia el siguiente documento XML:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <bib>
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

## Consultas

  Las consultas _XQuery_ se componen de cinco cláusulas, que debido a sus iniciales se las conoce como _FLWOR_. Definimos cada una de ellas:

  - ___FOR___: Indica qué nodos se van a seleccionar desde la base de datos XML o desde un documento XML.
  - ___LET___: Permite declarar variables a las que se le asignan valores.
  - ___WHERE___: Permite introducir condiciones que deben cumplir los nodos seleccionados por la cláusula __«for»__.
  - ___ORDER BY___: Permite ordenar los nodos antes de su visualización.
  - ___RETURN___: Devuelve los resultados. Es la única cláusula obligatoria.

  Aunque también se añade a éstas la siguiente cláusula:

  - ___GROUP BY___: Permite agrupar por nodos similares.


### Cláusula «for» y «return»

  Con la cláusula __«for»__ recuperaremos una serie de nodos mediante una consulta __XPath__ y los introduciremos en una variable para poder utilizarla en la cláusula __«return»__. Hay que señalar que la cláusula __«return»__ se ejecutará una vez por cada nodo que devuelva la cláusula __«for»__.

  ```
  for $book in /bib/book
  return $book/title
  ```

  En este caso el nodo __«title»__ se imprime junto con las etiquetas:

  ```
  <title>TCP/IP Illustrated</title>
  <title>Advanced Programming in the Unix Environment</title>
  <title>Data on the Web</title>
  ```

  Como no hemos indicado ningún documento tras __«in»__ la consulta se lanzará contra la base de datos que tengamos abierta en nuestro programa. El resto de ejemplos del manual se realizarán de esta manera, pero si quieremos lanzar la consulta contra un documento XML que no es una base de datos podemos hacerlo usando __«doc»__:

  ```
  for $book in doc("bib.xml")/bib/book
  return $book/title
  ```

  Si queremos imprimir nuestras propias etiquetas en la cláusula __«return»__, tendremos que encerrar la variable entre llaves { }:

  ```
  for $book in /bib/book
  return <titulo>{$book/title/text()}</titulo>
  ```

  Obteniendo como resultado:

  ```
  <titulo>TCP/IP Illustrated</titulo>
  <titulo>Advanced Programming in the Unix Environment</titulo>
  <titulo>Data on the Web</titulo>
  ```

  Podemos utilizar __«at»__ dentro de la cláusula __«for»__ para obtener una variable con la numeración de los nodos que se van a recorrer:

  ```
  for $book at $i in /bib/book
  return <titulo>({$i}) {$book/title/text()}</titulo>
  ```

  Lo hemos utilizado para incluirlo dentro de la etiqueta __«titulo»__:

  ```
  <titulo>(1) TCP/IP Illustrated</titulo>
  <titulo>(2) Advanced Programming in the Unix Environment</titulo>
  <titulo>(3) Data on the Web</titulo>
  ```

  Si quisiéramos englobar todas las etiquetas anteriores en una superior, tendríamos que encerrar la consulta completa entre llaves { } como vemos en este ejemplo:

  ```
  <biblioteca>
  {
    for $book in /bib/book
    return <titulo>{$book/title/text()}</titulo>
  }
  </biblioteca>
  ```

  Obteniendo la salida:

  ```
  <biblioteca>
    <titulo>TCP/IP Illustrated</titulo>
    <titulo>Advanced Programming in the Unix Environment</titulo>
    <titulo>Data on the Web</titulo>
  </biblioteca>
  ```

  También podemos utilizar la estrucutra condicional __«if»__ dentro de la cláusula __«return»__ para modificar el resultado en función de alguna condición:

  ```
  for $book in /bib/book
  return
    <book>
      {$book/title}
      {if ($book/year/text() > 2003) then (
        <new />
      ) else (
        <out-dated />
      )}
    </book>
  ```

  Obteniendo la salida:

  ```
  <book>
    <title>TCP/IP Illustrated</title>
    <out-dated/></book>
  <book>
    <title>Advanced Programming in the Unix Environment</title>
    <new/>
  </book>
  <book>
    <title>Data on the Web</title>
    <new/>
  </book>
  ```

### Cláusula «let»

  La cláusula __«let»__ nos va a permitir crear variables con cierto contenido. La diferencia con __«for»__ es que ésta sólo se ejecutaría una sola vez con la cláusula __«return»__. La cláusula __«let»__ asigna las variables mediante los caracteres __«:=»__. Si el ejemplo anterior lo realizáramos con __«let»__:

  ```
  let $books := /bib/book
  return <titulo>{$books/title}</titulo>
  ```

  Podemos observar como la etiqueta __«titulo»__ sólo aparece una vez, es decir, no se repite para cada nodo como en el caso de la cláusula __«for»__.

  ```
  <titulo>
    <title>TCP/IP Illustrated</title>
    <title>Advanced Programming in the Unix Environment</title>
    <title>Data on the Web</title>
  </titulo>
  ```

  La clasula __«let»__ nos va a permitir utilizar funciones de agrupación, como calcular la media, la suma, contar, etc. Estas son las mismas funciones que las que se utilizan en el leguaje __XPath__ y que podéis repasar aquí. Podemos por ejemplo buscar el año más alto que exista mediante la función __«max»__ para ver el último libro que se ha escrito:

  ```
  let $books := /bib/book
  return <last_year>{max($books/year)}</last_year>
  ```

  Y la salida sería:

  ```
  <last_year>2006</last_year>
  ```

### Cláusula «for» y «let»

  Podemos combinar las cláusulas __«for»__ y __«let»__. De esta manera conseguimos que la clasula «let» se ejecute una vez por cada nodo, al igual que hace la clasula __«return»__. Por ejemplo, si queremos contar el número de autores que tiene cada libro podemos utilizar la siguiente consulta:

  ```
  for $book in /bib/book
  let $autores := count($book/author)
  return
    <libro>
      <titulo>{$book/title/text()}</titulo>
      <autores>{$autores}</autores>
    </libro>
    ```

  Lo que conseguimos es que para cada nodo que pasa por la cláusula __«for»__ utilicemos __«let»__ para incluir en la variable __«$autores»__ la cuenta de nodos __«author»__ de dicho libro que tenemos en la variable __«$book»__, consiguiendo el siguiente resultado:

  ```
  <libro>
    <titulo>TCP/IP Illustrated</titulo>
    <autores>1</autores>
  </libro>
  <libro>
    <titulo>Advanced Programming in the Unix Environment</titulo>
    <autores>1</autores>
  </libro>
  <libro>
    <titulo>Data on the Web</titulo>
    <autores>3</autores>
  </libro>
  ```

  Aunque este mismo caso también lo podríamos realizar sin utilizar la clásula __«let»__:

  ```
  for $book in /bib/book
  return
    <libro>
      <titulo>{$book/title/text()}</titulo>
      <autores>{count($book/author)}</autores>
    </libro>
    ```

### Cláusula «where»

  Con la cláusula __«where»__ podemos filtrar los nodos que se seleccionan en la cláusula __«for»__, para ello también podemos utilizar los mismos operadores y funciones que en el leguaje XPath y que podéis repasar aquí. MUY IMPORTANTE, la cláusula __«where»__ NO filtraría los nodos si los estamos obteniedo con __«let»__. Por ejemplo podemos buscar los títulos de un determinado autor:

  ```
  for $book in /bib/book
  where $book/author = "Stevens"
  return $book/title
  ```

  Y el resultado sería:

  ```
  <title>TCP/IP Illustrated</title>
  <title>Advanced Programming in the Unix Environment</title>
  ```

  La misma consulta anterior se podría realizar de igual manera filtrando los nodos en la consulta XPath sin tener que utilizar la cláusula __«where»__:

  ```
  for $book in /bib/book[author = "Stevens"]
  return $book/title
  ```

  Un ejemplo más con la cláusula __«where»__ utilizando una función:

```
  for $book in /bib/book
  where starts-with($book/author, "S")
  return $book/title
```   

### Cláusula «order by»

  Con la cláusula __«order by»__ podemos ordenar los nodos antes de que empiece a ejecutarse la cláusula __«return»__, ya que como sabemos, la salida será la misma que el orden que tengan los nodos en el documento o base de datos XML. Podemos ordenar por diferentes campos separándolos por coma.

  ```
  for $book in /bib/book
  order by $book/title
  return $book/title
  ```

  Obteniendo la salida:

  ```
  <title>Advanced Programming in the Unix Environment</title>
  <title>Data on the Web</title>
  <title>TCP/IP Illustrated</title>
  ```

### Cláusula «group by»

  Con la cláusula __«group by»__ podemos agrupar los nodos en función de un valor de nodo o de atributo:

  ```
  for $book in /bib/book
  group by $publisher := $book/publisher
  return <group dept="{$publisher}" count="{count($book)}"/>
  ```

  Obteniendo la salida:

  ```
  <group dept="Addison-Wesley" count="2"/>
  <group dept="" count="1"/>
  ```

### Otros ejemplos de funciones y operadores

  La función __«distinct-values»__ nos permite dentro de la cláusula __«for»__ o __«let»__ seleccionar sólo los nodos que tengan valores diferentes. Pero hay que tener en cuenta que los devuelve sin sus etiquetas, como si usáramos __«/text()»__:

  ```
  for $autor in distinct-values(/bib/book/author)
  where $autor
  ```

  El operador __«except»__ nos permite eliminar nodos de la salida de la consulta, pero para ello es obligatorio utilizar __«/*»__ en el nodo donde vayamos a utilizarlo como vemos en el ejemplo. En este caso también se devuelve el libro sin etiquetas, de ahí que le hayamos incluido nosotros nuestras propias etiquetas en el __«return»__:

  ```
  for $book in /bib/book
  return <libro>{$book/* except $book/year except $book/author}</libro>
  ```

## Herramientas online  
  - [videlibri](https://www.videlibri.de/cgi-bin/xidelcgi).

</div>
