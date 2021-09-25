# Utilización de espacios de nombres en XML.

 Permiten definir la pertenencia de los elementos y los atributos de un documento XML al contexto de un vocabulario XML. De este modo se resuelven las ambigüedades que se pueden producir al juntar dos documentos distintos, de dos autores diferentes, que han utilizado el mismo nombre de etiqueta para representar cosas distintas.

 Los espacios de nombres, también conocidos como name spaces, permiten dar un nombre único a cada elemento, indexándolos según el nombre del vocabulario adecuado. Además están asociados a un URI que los identifica de forma única.

En el documento, las etiquetas ambiguas se sustituyen por otras en las que el nombre del elemento está precedido de un prefijo, que determina el contexto al que pertenece 
la etiqueta, seguido del signo de dos puntos. Esto es:

```xml
<prefijo:nombre_etiqueta>Valor</prefijo:nombre_etiqueta>
```

 Esta etiqueta se denomina "nombre cualificado". Al definir el prefijo hay que tener en cuenta que no se pueden utilizar espacios ni caracteres especiales y que no puede comenzar por un dígito.

 Antes de poder utilizar un prefijo de un espacio de nombres, para resolver la ambigüedad de dos o más etiquetas, es necesario declarar el espacio de nombres, es decir, asociar un índice con el URI asignado al espacio de nombres, mediante el atributo especial xmlns (XML Name Spaces).

__Ejemplo.__

 Sean los documentos XML que organizan la información sobre los profesores y los alumnos respectivamente del ciclo __DAM__:

```xml
 <?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
 <alumnos>
<nombre>Fernando Fernández González</nombre>
<nombre>Isabel González Fernández</nombre>
<nombre>Ricardo Martínez López</nombre>
</alumnos>
```

 Vemos que la misma etiqueta nombre existe en ambos documentos, se llama igual.
 Al hacer un documento conjunto sobre los miembros del ciclo ASIR no se distinguirían los nombres de los profesores de los nombres de los alumnos. Para resolverlo definiremos un espacio de nombres para cada contexto. Se pueden definir dentro del elemento raíz o ejemplar, como sigue: 

```xml
 <?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<asistentes xmlns:alumnos="http://DAW/alumnos"
xmlns:profesores="http://DAW/profesores">
<alumnos:nombre>Fernando Fernández González</alumnos:nombre>
<alumnos:nombre>Isabel González Fernández</alumnos:nombre>
<alumnos:nombre>Ricardo Martínez López</alumnos:nombre>
<profesores:nombre>Pilar Ruiz Pérez</profesores:nombre>
<profesores:nombre>Tomás Rodríguez Hernández</profesores:nombre>
</asistentes>
```

 En un espacio de nombres, el URI (http://DAM/alumnos o http://DAM/profesores) es sólo una forma de identificar de forma única al recurso (al espacio de nombre), por lo que no tiene que ser una dirección con contenido.

 Para saber más: los espacios de nombres tienen una recomendación en W3C, que se puede encontrar en [http://www.w3.org/TR/REC-xml-names/](http://www.w3.org/TR/)REC-xml-names/.
