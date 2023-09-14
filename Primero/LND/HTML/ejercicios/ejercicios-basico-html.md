<div align="justify">

# EJERCICIOS-BASICOS-HTML


__Realiza cada uno de los ejemplos propuestos y realiza sube cada uno de los ejemplos a git con la captura de pantalla del resultado de cada página__.


## ESTRUCTURA INTERNA DE UNA PÁGINA HTML
  Confeccionar una página que muestre los nombres de 5 lenguajes de programación separados por un guión.

```html
<html>
  <head></head>
  <body>PHP - Java - JavaScript - C -
C++</body>
</html>
```

## SALTO DE LÍNEA <BR>

  Confeccionar una página HTML que muestre distintos lenguajes de programación, mostrarlos uno por línea.

  ```html
  <html>
  <head></head>
  <body>PHP
    <br>JavaScript
      <br>Java
        <br>C
          <br>C++</body>
        </html>  
  ```

___Ejecuta desde el navegador y realiza una captura.___

### PÁRRAFO <P>
  Confeccione una página que muestre dos párrafos. En el primero agregar varios saltos de línea.

```html
<html>
  <head></head>
  <body>
    <p>SQL, Structure Query Language (Lenguaje de Consulta Estructurado) es un lenguaje de
programacion para trabajar con base de datos relacionales como MySQL, Oracle, etc.
      <br>MySQL es un interpretador de SQL, es un servidor de base de datos.
        <br>MySQL permite crear base de datos y tablas, insertar datos, modificarlos, eliminarlos,
ordenarlos, hacer consultas y realizar muchas operaciones, etc., resumiendo: administrar bases
de datos.</p>
        <p>Este tutorial tiene por objetivo acercar los conceptos iniciales para introducirse en el mundo de
las bases de datos.</p>
      </body>
    </html>
```

## TÍTULOS <H1 – H6>
  Confeccionar una página que contenga un título de primer nivel \<h1\> y luego dos títulos de nivel \<h2\>. Definir un párrafo para cada título de segundo nivel.

```html
<html>
<head>
</head>
<body>
<h1>Tipos de datos en MySQL</h1>
<h2>varchar</h2>
<p>
se usa para almacenar cadenas de caracteres. Una cadena es una secuencia de caracteres. Se coloca
entre comillas (simples): 'Hola'.<br>
El tipo "varchar" define una cadena de longitud variable en la cual determinamos el máximo de
caracteres. Puede guardar hasta 255 caracteres. Para almacenar cadenas de hasta 30 caracteres,
definimos un campo de tipo varchar(30).
</p>
<h2>int</h2>
<p>
Se usa para guardar valores numéricos enteros, de -2000000000 a 2000000000
aproximadamente.<br> Definimos campos de este tipo cuando queremos representar, por
ejemplo, cantidades.
</p>
</body>
</html>
```

## ÉNFASIS \<EM> \<STRONG>

  Crear una página que contenga cuatro párrafos. En el primero enfatizar con el máximo nivel y en los otros párrafos emplear el elemento de enfatizar de menor fuerza.

  ```html
  <html>
  <head>
  </head>
  <body>
  <p><strong>Típos de datos</strong> en MySQL</p>
  <p><em>TEXTO</em>: Para almacenar texto usamos cadenas de caracteres. Las cadenas se
  colocan entre comillas simples. Podemos almacenar dígitos con los que no se realizan
  operaciones matemáticas, por ejemplo, códigos de identificación, números de documentos,
  números telefónicos. Tenemos los siguientes tipos: varchar, char y text.</p>
  <p><em>NUMEROS</em>: Existe variedad de tipos numéricos para representar enteros,
  negativos, decimales. Para almacenar valores enteros, por ejemplo, en campos que hacen
  referencia a cantidades, precios, etc., usamos el tipo integer. Para almacenar valores con
  decimales utilizamos: float o decimal.</p>
  <p><em>FECHAS Y HORAS</em>: para guardar fechas y horas dispone de varios tipos: date
  (fecha), datetime (fecha y hora), time (hora), year (año) y timestamp.</p> </body>
  </html>

  ```
  ## HIPERVÍNCULO A OTRA PÁGINA DEL MISMO SITIO \<A>

  Confeccionar una página principal que tenga un hipervínculo a otra página secundaria. La página secundaria debe tener también un hipervínculo a la página principal.
### pagina1.html

```html
<html>
<head>
</head>
<body>
<h1>Página principal.</h1>
<a href="pagina2.html">Noticias</a>
</body>
</html>
```

### pagina2.html

```html
<html>
<head>
</head>
<body>
<h1>Noticias.</h1>
<a href="pagina1.html">Salir.</a>
</body>
</html>
```

## HIPERVÍNCULO A OTRO SITIO DE INTERNET \<A>

Confeccionar una página que contenga un enlace al sitio de google.

### pagina1.html

```html
<html>
<head>
</head>
<body>
<a href="http://www.google.com">Buscador Google</a>
</body>
</html>
```

## HIPERVÍNCULO A UN CLIENTE DE CORREO \<A>

Confeccionar una página que contenga un hipervínculo configurando la propiedad href de tal manera que abra un cliente de correo.

```html
<html>
<head>
</head>
<body>
<h1>Contacto</h1>
<a href="mailto:juanancaravaca@gmail.com">Enviar mail.</a>
</body>
</html>
```

ANCLAS DE PÁGINA
Ejemplo: Confeccionar una página que contenga cuatro anclas, luego definir cuatro hipervínculos que
se enlacen con dichas anclas.

```html
<html>
<head>
</head>
<body>
<h1>Tutorial de MySQL</h1>
<a href="#introduccion">Introducción</a><br>
<a href="#mostrarbasedatos">show databases</a><br>
<a href="#creaciontabla">Creación de una tabla y mostrar sus campos</a><br>
<a href="#cargarregistros">Carga de registros a una tabla y su recuperación</a><br>
<a name="introduccion"></a>
<h2>Introducción</h2>
<p>
SQL, Structure Query Language (Lenguaje de Consulta Estructurado) es un lenguaje de
programacion para trabajar con base de datos relacionales como MySQL, Oracle, etc.<br>
MySQL es un interpretador de SQL, es un servidor de base de datos.<br></p>
<a name="mostrarbasedatos"></a>
<h2>show databases</h2>
<p>
Una base de datos es un conjunto de tablas.<br></p>
<a name="creaciontabla"></a>
<h2>Creación de una tabla y mostrar sus
campos</h2> <p>
Una base de datos almacena sus datos en tablas.<br></p>
<a name="cargarregistros"></a>
<h2>Carga de registros a una tabla y su
recuperación</h2> <p>
Usamos "insert into". Especificamos los nombres de los campos entre paréntesis y separados por
comas y luego los valores para cada campo, también entre paréntesis y separados por
comas.<br>
</p>
</body>
</html>
```

## IMÁGENES DENTRO DE UNA PÁGINA \<IMG>
Implementar una página que muestre una imagen llamada foto1.jpg que se encuentra en el
mismo servidor y en la misma carpeta donde se localiza el archivo HTML.

```html
<html>
<head>
</head>
<body>
<img src="https://avatars.githubusercontent.com/u/10197701?s=400&u=5f1e6fbfda101df156a5ad8d4f10f15f509f6e74&v=4" alt="El mejor profesor del mundo">
</body>
</html>
```

## HIPERVÍNCULO MEDIANTE UNA IMAGEN \<A> Y \<IMG>

  Confeccionar una página que muestre dos imagenes (foto1.jpg y foto2.jpg) como hipervínculos. Al ser presionados llamar a otra página. Las imágenes se encuentran en una carpeta llamada imagenes que depende directamente de la raiz del sitio.

### pagina1.html

```html
<html>
<head>
</head>
<body>
<h2>Presione alguna de las imagenes para conocer más sobre esa obra.</h2>
<a href="pagina2.html"><img src="/imagenes/foto1.jpg" alt="Pintura Geométrica"> </a>
<a href="pagina3.html"><img src="/imagenes/foto2.jpg" alt="Pintura Geométrica"> </a>
</body>
</html>
```
### pagina2.html (HACE FALTA UNA PAGINA 3 SIMILAR A ESTA)

```html
<html>
<head>
</head>
<body>
<p>Esta obra fue desarrollada en el año 2003</p>
<a href="pagina1.html">Retornar</p>
</body>
</html>
```

## LISTAS ORDENADAS \<OL>

  Mostrar el orden de llegada de tres corredores utilizando el elemento HTML ol.

```html
<html>
<head>
</head>
<body>
<ol>
<li>Rodriguez Pablo</li>
<li>Gonzalez Raul</li>
<li>Lopez Hector</li>
</ol>
</body>
</html>
```

## LISTAS ANIDADAS
Implementar una página que enumere una serie de paises en una lista ordenada y luego en
cada pais disponer una lista de hipervínculos de periódicos de dicho pais.

```html
<html>
<head>
</head>
<body>
<ol>
<li>Argentina
<ul>
<li><a href="http://www.lanacion.com.ar">La Nación</a></li>
<li><a href="http://www.clarin.com.ar">Clarín</a></li>
<li><a href="http://www.pagina12.com.ar">Página 12</a></li>
</ul>
</li>
<li>España
<ul>
<li><a href="http://www.elpais.es">El País
Digital</a></li> <li><a
href="http://www.abc.es">ABC</a></li>
<li><a href="http://www.elmundo.es">El Mundo</a></li>
</ul>
</li>
<li>México
<ul>
<li><a href="http://www.jornada.unam.mx">La Jornada</a></li>
<li><a href="http://www.el-universal.com.mx">El Universal</a></li>
</ul>
</li>
</ol>
</body>
</html>
```

## TABLAS \<TABLE>

  Confeccionar una tabla que muestre los nombre de países en una columna y su cantidad de habitantes en otra. Disponer un título de los datos que representa la tabla.

```html
<html>
<head>
</head>
<body>
<table border="1">
<caption>Población de los paises con mayor cantidad de
habitantes.</caption> <tr>
<th>Paises</th><th>Cantidad de habitantes</th>
</tr>
<tr>
<td>China</td><td>1300 millones</td>
</tr>
<tr>
<td>India</td><td>1080 millones</td>
</tr>
<tr>
<td>Estados Unidos</td><td>295 millones</td>
</tr>
</table>
</body>
</html>
```

## TABLAS CON CELDAS NO UNIFORMES \<TABLE>

Confeccionar una tabla que muestre la facturación de los últimos tres meses de los artículos:'Discos Duros', 'CPU' y 'Monitores'. La primer columna debe mostrar solo el texto 'recursos' y en la primer fila el texto 'Facturación de los últimos tres meses'.

```html
<html>
<head>
</head>
<body>
<table border="1">
<tr>
<th rowspan="4">Recursos</th><th colspan="4">Facturación de los últimos tres meses</th>
</tr>
<tr>
<td>Discos Duros</td><td>23000</td><td>27200</td><td>26000</td>
</tr>
<tr>
<td>CPU</td><td>73000</td><td>67300</td><td>51000</td>
</tr>
<tr>
<td>Monitores</td><td>53000</td><td>72000</td><td>88000</td>
</tr>
</table>
</body>
</html>
```

</div>
