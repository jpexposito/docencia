
<div align="justify">

# Clasificación.

En los años 70 continúa surgen unos lenguajes informáticos, distintos de los lenguajes de programación, orientados a la gestión de información. Con el desarrollo de los editores y procesadores de texto surgen los primeros lenguajes informáticos especializados en tareas de descripción y estructuración de información: los lenguajes de marcas. Paralelamente, también, surgen otros lenguajes informáticos orientados a la representación, almacenamiento y consulta eficiente de grandes cantidades de datos: lenguajes y sistemas de bases de datos.  
Los lenguajes de marcas surgieron, inicialmente, como lenguajes formados por el conjunto de códigos de formato que los procesadores de texto introducen en los documentos para dirigir el proceso de presentación (impresión) mediante una impresora. Como en el caso de los lenguajes de programación, inicialmente estos códigos de formato estaban ligados a las características de una máquina, programa o procesador de textos concreto y, en ellos, inicialmente no había nada que permitiese al programador (formateador de documentos en este caso) abstraerse de las características del procesador de textos y expresar de forma independiente a éste la estructura y la lógica interna del documento.  

Código de marcas anterior a GML. Las etiquetas son de invención propia.  
Dado el siguiente documento:
```  
<times 14><color verde><centrado> Este texto es un ejemplo para mostrar la utilización primitiva de las marcas</centrado></color></times 14>  
<color granate><times 10><cursiva>Para realiza este ejemplo se utilizan etiquetas de nuestra invención. </cursiva> Las partes importantes del texto pueden resaltarse usando la <negrita>negrita</negrita>, o el <subrayar>subrayado</subrayar></times 10></color>  Al imprimirlo se obtendría:
```
El resultado sería:

```html
Este texto es un ejemplo para mostrar la utilización primitiva de las marcas 
 
Para realiza este ejemplo se utilizan etiquetas de nuestra invención. Las partes importantes del texto pueden resaltarse usando la negrita, o el subrayado  
```

Posteriormente, se añadieron como medio de presentación a la pantalla. Los códigos de estilo de visualización anteriores ya no aparecen, y se emplean otros medios para marcados, distintos de la inclusión a mano de cadenas formateadoras, ahora ese proceso se automatiza y basta pulsar una combinación de teclas, o pulsar un botón, para lograr los resultados requeridos. Aunque esto es sólo una abstracción, para su uso interno las aplicaciones siguen utilizando marcas para delimitar aquellas partes del texto que tienen un formato especial.  
Este marcado estaba exclusivamente orientado a la presentación de la información, aunque pronto se percataron de las posibilidades del marcado y le dieron nuevos usos que resolvían una gran variedad de necesidades, apareció el formato generalizado.  

## GML (Generalizaed Markup Language). 

 Uno de los problemas que se conocen desde hace décadas en la informática es la falta de estandarización en los formatos de información usados por los distintos programas.  

 Para resolver este problema, en los años sesenta IBM encargó a Charles F. Goldfab la construcción de un sistema de edición, almacenamiento y búsqueda de documentos legales. Tras analizar el funcionamiento de la empresa llegaron a la conclusión de que para realizar un buen procesado informático de los documentos había que establecer un formato estándar para todos los documentos que se manejaban en la empresa. Con ello se lograba gestionar cualquier documento en cualquier departamento y con cualquier aplicación, sin tener en cuenta dónde ni con qué se generó el documento. Dicho formato tenía que ser válido para los distintos tipos de documentos legales que utilizaba la empresa, por tanto, debía ser flexible para que se pudiera ajustar a las distintas situaciones.  

 El formato de documentos que se creó como resultado de este trabajo fue GML, cuyo objetivo era describir los documentos de tal modo que el resultado fuese independiente de la plataforma y la aplicación utilizada.  

## SGML (Standard Generalized Markup Language). 
 
 El formato GML evolucionó hasta que en 1986 dio lugar al estándar ISO 8879 que se denominó SGML. Éste era un lenguaje muy complejo y requería de unas herramientas de software caras. Por ello su uso ha quedado relegado a grandes aplicaciones industriales.   

Ejemplo  

**Documento SGML sencillo:**
```xml  
<email>  
 	<remitente>  
 	 	<persona>  
 	 	 	<nombre> Pepito </nombre>  
 	 	 	<apellido> Grillo </apellido>  
 	 	</persona>  
 	</remitente>  
 	<destinatario>  
 	 	<direccion> pinocho@hotmail.com </direccion>  
 	</destinatario>  
 	<asunto>¿quedamos?</asunto>  
 	<mensaje> Hola, he visto que ponen esta noche la película que querías ver. ¿Te apetece ir?</mensaje>  
</email> 
```
_[Visualizar en el navegador el email.xml](ejemplo/email.xml)_

## HTML (HyperText Markup Language). 
 En 1989/90 Tim Berners‐Lee creó el World Wide Web y se encontró con la necesidad de organizar, enlazar y compatibilizar gran cantidad de información procedente de diversos sistemas. Para resolverlo creó un lenguaje de descripción de documentos llamado HTML, que, en realidad, era una combinación de dos estándares ya existentes:  
  - ASCII: Es el formato que cualquier procesador de textos sencillo puede reconocer y almacenar. Por tanto es un formato que permite la trasferencia de datos entre diferentes ordenadores. 
  - SGML: Lenguaje que permite dar estructura al texto, resaltando los títulos o aplicando diversos formatos al texto. 

 __HTML es una versión simplificada de SGML__, ya que _sólo se utilizaban las instrucciones absolutamente imprescindibles_. Era tan fácil de comprender que rápidamente tuvo gran aceptación logrando lo que no pudo SGML, __HTML se convirtió en un estándar general para la creación de páginas web__. Además, tanto las herramientas de software como los navegadores que permiten visualizar páginas HTML son cada vez mejores.  

 A pesar de todas estas ventajas HTML no es un lenguaje perfecto, sus principales desventajas son:  
  - No soporta tareas de impresión y diseño. 
    - El lenguaje no es flexible, ya que las etiquetas son limitadas. 
   - No permite mostrar contenido dinámico. 
   - La estructura y el diseño están mezclados en el documento. 

__Ejemplo__   

```html
	<html>  
	 	<head>  
	 	 	<title> Ejemplo de código HTML</title>  
	 	</head>  
	 	<body bgcolor="#ffffff">  
	 	 	<p></p>  
	 	 	<p>  
	 	 	 	<b>20 de octubre de 2010</b>  
	 	 	</p>  
	  <p><b> Bienvenido al modulo de “Lenguajes de Marcas y Sistemas de Gestión de Información” </b></p>  
	 	 	<p> En este curso aprender&aacute;s, entre otras cosas:<br/>  
	 	 	 	<ul>  
	 	 	 	 	<li>Las ventajas que ofrece XML </li>  
	 	 	 	 	<li>La creaci&oacute;n de documentos bien formados </li>  
	 	 	 	 	<li>La creaci&oacute;n de DTD</li>  
	 	 	 	</ul>  
	 	 	</p>  
	 	</body>  
	</html> 
``` 

_[Visualizar en el navegador el mi_primer_html.html](ejemplo/mi_primer_html.html)_

 Para resolver estos problemas de HTML el W3C establece, en 1998, el estándar internacional XML, un lenguaje de marcas puramente estructural que no incluye ninguna información relativa al diseño. Está convirtiéndose con rapidez en estándar para el intercambio de datos en la Web. A diferencia de HTML las etiquetas indican el significado de los datos en lugar del formato con el que se van a visualizar los datos.  
 XML es un metalenguaje caracterizado por:  
  - Permitir definir etiquetas propias. 
  - Permitir asignar atributos a las etiquetas. 
  - Utilizar un esquema para definir de forma exacta las etiquetas y los atributos. 
  - La estructura y el diseño son independientes. 
 
En realidad XML es un conjunto de estándares relacionados entre sí y que son:  
  - XSL, eXtensible Style Language. Permite definir hojas de estilo para los documentos XML e incluye capacidad para la transformación de documentos. 
  - XML Linking Language, incluye Xpath, Xlink y Xpointer. Determinan aspectos sobre los enlaces entre documentos XML. 
  - XML Namespaces. Proveen un contexto al que se aplican las marcas de un documento de XML y que sirve para diferenciarlas de otras con idéntico nombre válidas en otros contextos. 
  - XML Schemas. Permiten definir restricciones que se aplicarán a un documento XML. Actualmente los más usados son las DTD. 

 En realidad XML es un conjunto de estándares relacionados entre sí y que son:  
 
 __Ejemplo__

```xml
<?xml version="1.0" encoding="iso‐8859‐1"?>  
<!DOCTYPE biblioteca">  
<biblioteca>  
 	<ejemplar tipo_ejem="libro" titulo="XML practico" editorial="Ediciones Eni">  
 	 	<tipo> <libro isbn="978‐2‐7460‐4958‐1" edicion="1" paginas="347"></libro> </tipo>  
 	 	<autor nombre="Sebastien Lecomte"></autor>  
 	 	<autor nombre="Thierry Boulanger"></autor>  
 	 	<autor nombre="Ángel Belinchon Calleja" funcion="traductor"></autor>  
 	 	<prestado lector="Pepito Grillo">  
 	 	 	<fecha_pres dia="13" mes="mar" año="2009"></fecha_pres>  
 	 	 	<fecha_devol dia="21" mes="jun" año="2009"></fecha_devol>  
 	 	</prestado>  
 	</ejemplar>  
 <ejemplar tipo_ejem="revista" titulo="Todo Linux 101. Virtualización en GNU/Linux" editorial="Studio Press">  
 	 	<tipo>  
 	 	 	<revista>  
 	 	 	 	<fecha_publicacion mes="abr" año="2009"></fecha_publicacion>  
 	 	 	</revista>  
 	 	</tipo>  
 	 	<autor nombre="Varios"></autor>  
 	 	<prestado lector="Pedro Picapiedra">  
 	 	 	<fecha_pres dia="12" mes="ene" año="2010"></fecha_pres>   	 	</prestado>  
 	</ejemplar>  
</biblioteca>
```

_[Visualizar en el navegador el biblioteca.xml](ejemplo/biblioteca.xml)_


### Comparación de XML con HTML. 

| XML | HTML |
| ------------- | ------------- |   
| Es un perfil de SGML | Es una aplicación de SGML.  |
| Especifica cómo deben definirse conjuntos de etiquetas aplicables a un tipo de documento.  | Aplica un conjunto limitado de etiquetas sobre un único tipo de documento.  |
| Modelo de hiperenlaces complejo.  | Modelo de hiperenlaces simple.  |
| El navegador es una plataforma para el desarrollo de aplicaciones.  | El navegador es un visor de páginas.  |
| Fin de la guerra de los navegadores y etiquetas propietarias.   | El problema de la "no compatibilidad" y las diferencias entre navegadores ha alcanzado un punto en el que la solución es difícil. |
|  |  |
 	 
__Ejemplo__

```xml 
<?xml version="1.0" encoding="iso‐8859‐1"?>  
<!DOCTYPE libro>  
<libro>  
 	<titulo>XML practico </titulo>  
 	<autor>Sebastien Lecomte</autor>  
 	<autor>Thierry Boulanger</autor>  
 	<editorial>Ediciones Eni</editorial>  
 	<isbn>978‐2‐7460‐4958‐1</isbn>  
 	<edicion>1</edicion>  
 	<paginas>347</paginas>  
<libro>  
```
_[Visualizar en el navegador el libro.xml](ejemplo/libro.xml)_

```html 
<html>  
 	<head>  
 	 	<title>Libro</title>  
 	</head>  
 	<body>  
 	 	<h3>XML practico</h3><br>  
 	 	<p>autores: Sebastien Lecomte,  
Al interpretar este fichero con un navegador, por ejemplo Mozilla, se obtiene:  
 	 	Thierry Boulanger</p>  
 	 	<ul>  
 	 	 	<li>editorial: Ediciones Eni</li>  
 	 	 	<li>isbn:978‐2‐7460‐4958‐1</li>  
 	 	 	<li>edicion: 1 </li>  
 	 	 	<li>paginas: 347</li>  
 	 	</ul>  
 	</body>  
</html>	  
```

_[Visualizar en el navegador el libro.html](ejemplo/libro.html)_ 

### Comparación de XML con SGML. 
| XML | SGML |
| ------------- | ------------- | 
| Su uso es sencillo. | Su uso es muy complejo. |
| Trabaja con documentos bien formados, no exige que estén validados. | Sólo trabaja con documentos válidos. |
| Facilita el desarrollo de aplicaciones de bajo coste. | Su complejidad hace que las aplicaciones informáticas para procesar SGML sean muy costosas. |
| Es muy utilizado en informática y en más áreas de aplicación. | Sólo se utiliza en sectores muy específicos. | No hay una compatibilidad con HTML definida. 
| Compatibilidad e integración con HTML. | Formateo y estilos relativamente complejos.
| Formateo y estilos fáciles de aplicar. | 
| No usa etiquetas opcionales. | 

</div>

<div align="center">
	<a href="INTRODUCCION.md"><img src="../../img/before.png" alt="In" style="width:42px;height:42px;"></a>
 	<a href="INTRODUCCION.md"><img src="../../img/home.png" alt="XML Home" style="width:42px;height:42px;"></a>
 	<a href="ETIQUETAS.md"><img src="../../img/next.png" alt="Etiquetas XML" style="width:42px;height:42px;"> 
</div>