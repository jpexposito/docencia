<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>

Dado el siguiente xml, realizar las expresiones xquery para obtener los resultados que se indican:

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<bib>
    <libro anyo="1994">
        <titulo>TCP/IP Illustrated</titulo>
        <autor>
            <apellido>Stevens</apellido>
            <nombre>W.</nombre>
        </autor>
        <editorial>Addison-Wesley</editorial>
        <precio>65.95</precio>
    </libro>
    <libro anyo="1992">
        <titulo>Advanced Programming for Unix environment</titulo>
        <autor>
            <apellido>Stevens</apellido>
            <nombre>W.</nombre>
        </autor>
        <editorial>Addison-Wesley</editorial>
        <precio>65.95</precio>
    </libro>
    <libro anyo="2000">
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
    <libro anyo="1999">
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
- Listar el título de todos los libros.
- Listar año y título de todos los libros, ordenados por el año.
- Listar los libros cuyo precio sea 65.95.
- Listar los libros publicados antes del año 2000.
- Listar año y título de los libros publicados por Addison-Wesley después del año 1992.
- Listar año y título de los libros que tienen más de un autor.
- Listar año y título de los libros que tienen no tienen autor.
- Mostrar los apellidos de los autores que aparecen en el documento, sin repeticiones, ordenadosalfabéticamente.
- Por cada libro, listar agrupado en un elemento <result> su titulo y autores.
- Por cada libro, obtener su título y el número de autores, agrupados en un elemento <libro>.
</div>
