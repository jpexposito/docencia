<div align="justify">


<div align="center">
 	<img src="https://ftp.homepage-webhilfe.de/Bilder/Themen/XML/XSLT/Transformation.png">
</div>

</br>

## Ejercicio II XSLT

```xml
<?xml version="1.0" encoding="UTF-8"?>
<bib url="http://www.uco.es/servicios/biblioteca/">
  <libro año="1994">
    <titulo>TCP/IP Illustrated</titulo>
    <autor>
      <apellido>Stevens</apellido>
      <nombre>W.</nombre>
    </autor>
    <editorial>Addison-Wesley</editorial>
    <precio>65.95</precio>
  </libro>
  <libro año="1992">
    <titulo>Advan Programming for Unix environment</titulo>
    <autor>
      <apellido>Stevens</apellido>
      <nombre>W.</nombre>
    </autor>
    <editorial>Addison-Wesley</editorial>
    <precio>65.95</precio>
  </libro>
  <libro año="2000">
    <titulo>Data on the Web</titulo>
    <autor>
      <apellido>Abiteboul</apellido>
      <nombre>Serge</nombre>
    </autor>
    <autor>
      <apellido>Buneman</apellido>
      <nombre>Peter</nombre>
    </autor>
    <autor>
      <apellido>Suciu</apellido>
      <nombre>Dan</nombre>
    </autor>
    <editorial>Morgan Kaufmann editorials</editorial>
    <precio>39.95</precio>
  </libro>
  <libro año="1999">
    <titulo>Economics of Technology for Digital TV</titulo>
    <editor>
      <apellido>Gerbarg</apellido>
      <nombre>Darcy</nombre>
      <afiliacion>CITI</afiliacion>
    </editor>
    <editorial>Kluwer Academic editorials</editorial>
    <precio>129.95</precio>
  </libro>
</bib>
```

  Dado el anterior documento XML, realiza las siguientes transformaciones XSLT de dos maneras distintas, primero utilizando una plantilla (template) para cada elemento y atributo que se necesite transformar, y segundo utilizando sólo la plantilla raíz y bucles (for-each) para cada elemento que se necesite transformar.

  - Mostrar una lista enumerada con todos los autores ordenados por apellidos.

  ```xml

  ```

  - Mostrar una lista enumerada con todos los títulos de libros cuyo precio sea menor de 100.

  ```xml

  ```

  - Mostrar una tabla con las siguientes columnas:
   - Precio del libro, ordenando los resultados por este campo (Nota: se ordenan como si fueran cadenas y no números).
   - Título del libro. Se mostrará el fondo de la celda en color rojo si el precio es mayor de 100.
   - Año de publicación. Se mostrará el texto en cursiva.

  ```xml

  ```

  - Mostrar una tabla con una primera fila de encabezado y con las siguientes columnas:
    - Título del libro, en color rojo si el precio es mayor de 100, añadiéndole el texto "(Caro)" a continuación, ordenando los resultados por este campo.
    - Autores del libro mostrando primero el nombre y luego el apellido. Si hay más de un autor se muestran todos en la misma celda. Si no hay autor se deja en blanco. Separar palabras con espacio en blanco.
    - Editores del libro mostrando el nombre, el apellido y la afiliación. Si hay más de un editor se muestran todos en la misma celda. Si no hay editor se deja en blanco. Separar palabras con espacio en blanco.

  ```xml

  ```


## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
