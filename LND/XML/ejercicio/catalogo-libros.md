<div align="justify">

# CATALOGO DE LIBROS


<div align="center">
  <img width="300px" src="https://estaticos.muyinteresante.es/uploads/images/test/5899d3b75cafe85ef18b4568/test-libros0.jpg">
</div>

## Descripción del Ejercicio

Convertir el DTD que se muestra a continuación en un XML schema, teniendo en cuenta lo siguiente:
- El esquema se guarda en un archivo de nombre “catalogo_libros.xsd”.
- Se deben definir dos tipos de datos simples para el mes (“tipoMes”) y el año __(“tipoAnyo”)__, como restricciones del tipo __“positiveInteger”__. El mes tiene que ser un valor comprendido entre __1 y 12__, y el año entre __1900 y 2011__.
También se define el tipo __“tipoNombre”__, que será el utilizado para los elementos __“titulo”__, __“autor”__ y __“editor”__. Se trata de una restricción del tipo “string” en la que los valores tienen entre __0 y 100 caracteres__.
Del mismo modo se define el tipo __“tipoISBN”__, para el elemento _ISBN_, como un tipo string que tiene entre __13 y 17 caracteres__.


  El dtd a utilizar será:
```xml
<!ELEMENT catalogoLibro (libro)*>
<!ELEMENT libro (titulo, autor+, fecha, ISBN, editor)>
<!ATTLIST libro
categoria (autobiografia | noficcion | ficcion) #REQUIRED
enstock (true | false) “false”
revisor CDATA “”>
<!ELEMENT titulo (#PCDATA)>
<!ELEMENT autor (#PCDATA)>
<!ELEMENT fecha(mes?, anyo)>
<!ELEMENT ISBN (#PCDATA)>
<!ELEMENT editor (#PCDATA)>
<!ELEMENT mes (#PCDATA)>
<!ELEMENT anyo (#PCDATA)>
```
Se pide realizar el fichero __xsd__, que realice la validación, con las restricciones indicadas.



</div>
