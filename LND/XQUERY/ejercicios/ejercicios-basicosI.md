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
- Mostrar los libros cuyo precio sea menor o igual a 30. Primero incluyendo la condición en la cláusula "where" y luego en la ruta del XPath.
- Mostrar sólo el título de los libros cuyo precio sea menor o igual a 30.
- Mostrar sólo el título sin atributos de los libros cuyo precio sea menor o igual a 30.
- Mostrar el título y el autor de los libros del año 2005, y etiquetar cada uno de ellos con "lib2005".
- Mostrar los años de publicación, primero con "for" y luego con "let" para comprobar la diferencia entre ellos. Etiquetar la salida con "publicacion".
- Mostrar los libros ordenados primero por "category" y luego por "title" en una sola consulta.
- Mostrar cuántos libros hay, y etiquetarlo con "total".
- Mostrar los títulos de los libros y al final una etiqueta con el número total de libros.
- Mostrar el precio mínimo y máximo de los libros.
- Mostrar el título del libro, su precio y su precio con el IVA incluido, cada uno con su propia etiqueta. Ordénalos por precio con IVA.
- Mostrar la suma total de los precios de los libros con la etiqueta "total".
- Mostrar cada uno de los precios de los libros, y al final una nueva etiqueta con la suma de los precios.
- Mostrar el título y el número de autores que tiene cada título en etiquetas diferentes.
- Mostrar en la misma etiqueta el título y entre paréntesis el número de autores que tiene ese título.
- Mostrar los libros escritos en años que terminen en "3".
- Mostrar los libros cuya categoría empiece por "C".
- Mostrar los libros que tengan una "X" mayúscula o minúscula en el título ordenados de manera descendente.
- Mostrar el título y el número de caracteres que tiene cada título, cada uno con su propia etiqueta.
- Mostrar todos los años en los que se ha publicado un libro eliminando los repetidos. Etiquétalos con "año".
- Mostrar todos los autores eliminando los que se repiten y ordenados por el número de caracteres que tiene cada autor.
- Mostrar los títulos en una tabla de HTML.

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
- Mostrar los nombres de los bailes seguidos con el número de plazas entre paréntesis, ambos dentro de la misma etiqueta "losbailes".
- Mostrar los nombres de los bailes cuyo precio sea mayor de 30.
- Mostrar los nombres de los bailes cuyo precio sea mayor de 30 y la moneda "euro".
- Mostrar los nombres y la fecha de comienzo de los bailes que comiencen el mes de enero (utiliza para buscarlo la cadena de texto "/1/").
- Mostrar los nombres de los profesores y la sala en la que dan clase, ordénalos por sala.
- Mostrar los nombres de los profesores eliminando los repetidos y acampañar cada nombre con todas las salas en la que da clase, ordénalos por nombre.
- Mostrar la media de los precios de todos los bailes.
- Mostrar la suma de los precios de los bailes de la sala 1.
- Mostrar cuántas plazas en total oferta el profesor "Jesus Lozano".
- Mostrar el dinero que ganaría la profesora "Laura Mendiola" si se completaran todas las plazas de su baile, sabiendo que sólo tiene un baile.
- Mostrar el dinero que ganaría el profesor "Jesus Lozano" si se completaran todas las plazas de su baile, pero mostrando el beneficio de cada baile por separado.
- Mostrar el dinero que ganaría la profesora "Laura" (no conocemos su apellido) si se completaran todas las plazas de su baile.
- Mostrar el nombre del baile, su precio y el precio con un descuento del 15% para familias numerosas. Ordenar por el nombre del baile
- Mostrar todos los datos de cada baile excepto la fecha de comienzo y de fin.
- Mostrar en una tabla de HTML los nombres de los bailes y su profesor, cada uno en una fila.



## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
