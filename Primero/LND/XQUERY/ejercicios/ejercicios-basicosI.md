<div align="justify">


<div align="center">
 	<img src="https://www.w3schools.com/xml/pic_xpath.gif">
</div>

</br>


1. Dado el siguiente documento XML realiza las siguientes consultas con XQuery (se eliminan las tildes para evitar problemas de compatibilidad de caracteres):

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <bookstore>
    <book category="COOKING">
      <title lang="en">Everyday Italian</title>
      <author>Giada De Laurentiis</author>
      <year>2005</year>
      <price>30.00</price>
    </book>
    <book category="CHILDREN">
      <title lang="en">Harry Potter</title>
      <author>J K. Rowling</author>
      <year>2005</year>
      <price>29.99</price>
    </book>
    <book category="WEB">
      <title lang="en">XQuery Kick Start</title>
      <author>James McGovern</author>
      <author>Per Bothner</author>
      <author>Kurt Cagle</author>
      <author>James Linn</author>
      <author>Vaidyanathan Nagarajan</author>
      <year>2003</year>
      <price>49.99</price>
    </book>
    <book category="WEB">
      <title lang="en">Learning XML</title>
      <author>Erik T. Ray</author>
      <year>2003</year>
      <price>39.95</price>
    </book>
  </bookstore>
  ```

- Mostrar los títulos de los libros con la etiqueta "titulo".
  ```
  for $titulo in /bookstore/book/title/text()
  return <titulo>{$titulo}</titulo>​​
  ```
- Mostrar los libros cuyo precio sea menor o igual a 30. Primero incluyendo la condición en la cláusula "where" y luego en la ruta del XPath.

  ```
  for $libro in /bookstore/book
  where $libro/price <= 30
  return $libro
  ```

- Mostrar sólo el título de los libros cuyo precio sea menor o igual a 30.

  ```
  for $libro in /bookstore/book
  where $libro/price <= 30
  return $libro/title
  ```

- Mostrar sólo el título sin atributos de los libros cuyo precio sea menor o igual a 30.

  ```
  for $libro in /bookstore/book[price<=30]
  return <title>{$libro/title/text()}</title>
  ```

- Mostrar el título y el autor de los libros del año 2005, y etiquetar cada uno de ellos con "lib2005".

  ```
  for $libro in /bookstore/book
  where $libro/year=2005
  return <lib2005>{$libro/title,$libro/author}</lib2005>
  ```

- Mostrar los años de publicación, primero con "for" y luego con "let" para comprobar la diferencia entre ellos. Etiquetar la salida con "publicacion".

  ```
  for $year in /bookstore/book/year
  return <publicacion>{$year}</publicacion>
  ```

- Mostrar los libros ordenados primero por "category" y luego por "title" en una sola consulta.

  ```
  for $libro in /bookstore/book
  order by $libro/@category,$libro/title
  return $libro
  ```

- Mostrar cuántos libros hay, y etiquetarlo con "total".

  ```
  let $num_libro := count(/bookstore/book)
  return <total>{$num_libro}</total>
  ```

- Mostrar los títulos de los libros y al final una etiqueta con el número total de libros.

  ```
  let $total := count (/bookstore/book),
    $titulos := (
      for $libro in /bookstore/book/title
      return <titulo>{$libro/text()}</titulo>)
    return
      <resultado>
        {$titulos}
        <total_libros>{$total}</total_libros>
      </resultado>
  ```

- Mostrar el precio mínimo y máximo de los libros.

  ```
  let $max := max(/bookstore/book/price),
    $min := min(/bookstore/book/price)
  return
  <resultado>
    <max>{$max}</max>
    <min>{$min}</min>
  </resultado>
  ```

- Mostrar el título del libro, su precio y su precio con el IVA incluido, cada uno con su propia etiqueta. Ordénalos por precio con IVA.

  ```
  for $libro in /bookstore/book
  let $precio_iva := ($libro/price * 1.21)
  order by $precio_iva
  return
  <libro>
    <titulo>{$libro/title/text()}</titulo>
    <precio>{$libro/price/text()} €</precio>
    <precio_iva>{$precio_iva} €</precio_iva>
  </libro>

  for $libro in /bookstore/book
  order by $libro/price * 1.21
  return
  <libro>
    <titulo>{$libro/title/text()}</titulo>
    <precio>{$libro/price/text()} €</precio>
    <precio_iva>{$libro/price * 1.21} €</precio_iva>
  </libro>
  ```

- Mostrar la suma total de los precios de los libros con la etiqueta "total".

  ```
  let $libros := /bookstore/book
  return <total>{sum($libros/price)}</total>
  ```

- Mostrar cada uno de los precios de los libros, y al final una nueva etiqueta con la suma de los precios.

  ```
  <libros>
  {
    for $libro in /bookstore/book
    return $libro/price
  }
  {
    let $libros := /bookstore/book
    return <total>{sum($libros/price)}</total>
  }
  </libros>
  ```

- Mostrar el título y el número de autores que tiene cada título en etiquetas diferentes.

  ```
  for $libro in /bookstore/book
  return
    <libro>
      {$libro/title}
      <autores>{count($libro/author)}</autores>
    </libro>
  ```

- Mostrar en la misma etiqueta el título y entre paréntesis el número de autores que tiene ese título.

  ```
  for $libro in /bookstore/book
  return <libro>{$libro/title/text()} ({count($libro/author)})</libro>
  ```

- Mostrar los libros escritos en años que terminen en "3".

  ```
  for $libro in /bookstore/book
  where ends-with($libro/year, "3")
  return $libro
  ```

- Mostrar los libros cuya categoría empiece por "C".

  ```
  for $libro in /bookstore/book
  where starts-with($libro/@category, "C")
  return $libro

  for $libro in /bookstore/book[starts-with(@category, "C")]
  return $libro
  ```

- Mostrar los libros que tengan una "X" mayúscula o minúscula en el título
ordenados de manera descendente.

  ```
  for $libro in /bookstore/book
  where contains($libro/title, "x") or contains($libro/title, "X")
  order by $libro/title descending
  return $libro

  for $libro in /bookstore/book
  where contains(lower-case($libro/title), "x")
  order by $libro/title descending
  return $libro

  for $libro in /bookstore/book[contains(lower-case(title), "x")]
  order by $libro/title descending
  return $libro
  ```

- Mostrar el título y el número de caracteres que tiene cada título, cada uno con su propia etiqueta.

  ```
  for $libro in /bookstore/book
  return
    <libro>
      {$libro/title}
      <length>{string-length($libro/title)}</length>
    </libro>
  ```

- Mostrar todos los años en los que se ha publicado un libro eliminando los repetidos. Etiquétalos con "año".

  ```
  for $año in distinct-values(/bookstore/book/year)
  return <año>{$año}</año>
  ```

- Mostrar todos los autores eliminando los que se repiten y ordenados por el número de caracteres que tiene cada autor.

  ```
  for $autor in distinct-values(/bookstore/book/author)
  order by string-length($autor)
  return <autor>{$autor}</autor>
  ```

- Mostrar los títulos en una tabla de HTML.

  ```
  <table>
  {
    for $libro in /bookstore/book
    return
      <tr>
        <td>{$libro/title/text()}</td>
      </tr>
  }
  </table>
  ```

2. Dado el siguiente documento XML realiza las siguientes consultas con XQuery (se eliminan las tildes para evitar problemas de compatibilidad de caracteres):

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <bailes>
    <baile id="1">
      <nombre>Tango</nombre>
      <precio cuota="mensual" moneda="euro">27</precio>
      <plazas>20</plazas>
      <comienzo>1/1/2011</comienzo>
      <fin>1/12/2011</fin>
      <profesor>Roberto Garcia</profesor>
      <sala>1</sala>
    </baile>
    <baile id="2">
      <nombre>Cha-cha-cha</nombre>
      <precio cuota="trimestral" moneda="euro">80</precio>
      <plazas>18</plazas>
      <comienzo>1/2/2011</comienzo>
      <fin>31/7/2011</fin>
      <profesor>Miriam Gutierrez</profesor>
      <sala>1</sala>
    </baile>
    <baile id="3">
      <nombre>Rock</nombre>
      <precio cuota="mensual" moneda="euro">30</precio>
      <plazas>15</plazas>
      <comienzo>1/3/2011</comienzo>
      <fin>1/12/2011</fin>
      <profesor>Laura Mendiola</profesor>
      <sala>1</sala>
    </baile>
    <baile id="4">
      <nombre>Merengue</nombre>
      <precio cuota="trimestral" moneda="dolares">75</precio>
      <plazas>12</plazas>
      <comienzo>1/1/2011</comienzo>
      <fin>1/12/2011</fin>
      <profesor>Jesus Lozano</profesor>
      <sala>2</sala>
    </baile>
    <baile id="5">
      <nombre>Salsa</nombre>
      <precio cuota="mensual" moneda="euro">32</precio>
      <plazas>10</plazas>
      <comienzo>1/5/2011</comienzo>
      <fin>1/12/2011</fin>
      <profesor>Jesus Lozano</profesor>
      <sala>2</sala>
    </baile>
    <baile id="6">
      <nombre>Pasodoble</nombre>
      <precio cuota="anual" moneda="euro">320</precio>
      <plazas>8</plazas>
      <comienzo>1/1/2011</comienzo>
      <fin>31/12/2011</fin>
      <profesor>Miriam Gutierrez</profesor>
      <sala>1</sala>
    </baile>
  </bailes>
  ```

- Mostrar cada uno de los nombres de los bailes con la etiqueta "losbailes".

  ```
  for $baile in /bailes/baile
  return <losbailes>{$baile/nombre/text()}</losbailes>
  ```

- Mostrar los nombres de los bailes seguidos con el número de plazas entre paréntesis, ambos dentro de la misma etiqueta "losbailes".

  ```
  for $baile in /bailes/baile
  return <losbailes>{$baile/nombre/text()} ({$baile/plazas/text()})</losbailes>
  ```

- Mostrar los nombres de los bailes cuyo precio sea mayor de 30.

  ```
  for $baile in /bailes/baile
  where $baile/precio > 30
  return $baile/nombre
  for $baile in /bailes/baile[precio > 30]
  return $baile/nombre
  ```

- Mostrar los nombres de los bailes cuyo precio sea mayor de 30 y la moneda "euro".

  ```
  for $baile in /bailes/baile
  where $baile/precio > 30 and $baile/precio/@moneda = "euro"
  return $baile/nombre
  for $baile in /bailes/baile[precio > 30 and precio/@moneda = "euro"]
  return $baile/nombre
  ```

- Mostrar los nombres y la fecha de comienzo de los bailes que comiencen el mes de enero (utiliza para buscarlo la cadena de texto "/1/").

  ```
  for $baile in /bailes/baile
  where contains($baile/comienzo, "/1/")
  return
     <baile>
        {$baile/profesor}
        {$baile/comienzo}
     </baile>
  ```

- Mostrar los nombres de los profesores y la sala en la que dan clase, ordénalos por sala.

  ```
  for $baile in /bailes/baile
  order by $baile/sala
  return
     <baile>
        {$baile/profesor}
        {$baile/sala}
     </baile>
  ```

- Mostrar los nombres de los profesores eliminando los repetidos y acampañar cada nombre con todas las salas en la que da clase, ordénalos por nombre.

  ```
  for $profesor in distinct-values(/bailes/baile/profesor)
  let $salas := /bailes/baile[profesor=$profesor]/sala
  order by $profesor
  return
     <profesores>
       <nombre>{$profesor}</nombre>
       {$salas}
     </profesores>
  ```

- Mostrar la media de los precios de todos los bailes.

  ```
  let $baile := /bailes/baile
  return <media>{avg($baile/precio)}</media>
  ```

- Mostrar la suma de los precios de los bailes de la sala 1.

  ```
  let $baile := /bailes/baile[sala=1]
  return <total_sala_1>{sum($baile/precio)}</total_sala_1>
  ```

- Mostrar cuántas plazas en total oferta el profesor "Jesus Lozano".

  ```
  let $baile := /bailes/baile[profesor = "Jesus Lozano"]
  return <plazas>{sum($baile/plazas)}</plazas>
  ```

- Mostrar el dinero que ganaría la profesora "Laura Mendiola" si se completaran todas las plazas de su baile, sabiendo que sólo tiene un baile.

  ```
  let $baile := /bailes/baile[profesor = "Laura Mendiola"]
  return $baile/plazas * $baile/precio
  ```

- Mostrar el dinero que ganaría el profesor "Jesus Lozano" si se completaran todas las plazas de su baile, pero mostrando el beneficio de cada baile por separado.

  ```
  for $baile in /bailes/baile
  where $baile/profesor = "Jesus Lozano"
  return <beneficio>{$baile/plazas * $baile/precio}</beneficio>
  ```

- Mostrar el dinero que ganaría la profesora "Laura" (no conocemos su apellido) si se completaran todas las plazas de su baile.

  ```
  for $baile in /bailes/baile
  where starts-with($baile/profesor, "Laura")
  return <beneficio>{$baile/plazas * $baile/precio}</beneficio>

  for $baile in /bailes/baile[starts-with(profesor, "Laura")]
  return <beneficio>{$baile/plazas * $baile/precio}</beneficio>
  ```

- Mostrar el nombre del baile, su precio y el precio con un descuento del 15% para familias numerosas. Ordenar por el nombre del baile.

  ```
  for $baile in /bailes/baile
  order by $baile/nombre
  return
     <baile>
        {$baile/nombre}
        <precio>{$baile/precio/text()}</precio>
        <fam_numerosa>{$baile/precio * 0.85}</fam_numerosa>
     </baile>
  ```

- Mostrar todos los datos de cada baile excepto la fecha de comienzo y de fin.

  ```
  for $baile in /bailes/baile
  return <baile>{$baile/* except $baile/comienzo except $baile/fin}</baile>
  ```

- Mostrar en una tabla de HTML los nombres de los bailes y su profesor, cada uno en una fila.

  ```
  <table> {
    for $baile in /bailes/baile
    return <tr><td>{$baile/nombre/text()}</td><td>{$baile/profesor/text()}</td></tr>
  } </table>
  ```



## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
