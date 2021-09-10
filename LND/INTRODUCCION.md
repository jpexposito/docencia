# Reconocimiento de las características de lenguajes de marcas


## Introducción.

Un **lenguaje de marcas** es un modo de codificar un documento donde, junto con el texto, se incorporan etiquetas, marcas o anotaciones con información adicional relativa a la estructura del texto o su formato de presentación. Permiten hacer explícita la estructura de un documento, su contenido semántico o cualquier otra información lingüística o extralingüística que se quiera hacer patente.  
Todo lenguaje de marcas está definido en un documento denominado DTD (Document Type Definition). En él se establecen las marcas, los elementos utilizados por dicho lenguaje y sus correspondientes etiquetas y atributos, su sintaxis y normas de uso.

```xml
<carta>  
<fecha>22/11/2006</fecha>  
<presentacion>Estimado cliente:</presentacion>  
<contenido>bla bla bla bla …</contenido>  
<firma>Don Jose Gutiérrez González</firma>  </carta>
```

Aunque en la práctica, en un mismo documento pueden combinarse varios tipos diferentes de lenguajes de marca los lenguajes de marcas, éstos se pueden clasificar como sigue:  
 - De presentación: Define el formato del texto.  
 - De procedimientos: Orientado también a la presentación pero, en este caso, el programa que representa el documento debe interpretar el código en el mismo orden en que aparece.  
©Descriptivo o semántico: Describen las diferentes partes en las que se estructura el documento pero sin especificar cómo deben representarse. 

 Algunos ejemplos de lenguajes de marcado agrupados por su ámbito de utilización son:  
 - Documentación electrónica 
    - RTF (Rich Text Format): Formato de Texto Enriquecido, fue desarrollado por Microsoft en 1987. Permite el intercambio de documentos de texto ente distintos procesadores de texto.  
    - TeX: Su objetivo es la creación de ecuaciones matemáticas complejas.  
    - Wikitexto: Permite la creación de páginas wiki en servidores preparados para soportar este lenguaje.  
    - DocBook: Permite generar documentos separando la estructura lógica del documento de su formato. De este modo, dichos documentos, pueden publicarse en diferentes formatos sin necesidad de realizar modificaciones en el documento original.  
 - Tecnologías de internet 
    - HTML, XHTML: (Hypertext Markup Language, eXtensible Hypertext Markup Language): Su objetivo es la creación de páginas web.  
    - RSS: Permite la difusión de contenidos web  
 - Otros lenguajes especializados 
    - MathML (Mathematical Markup Language): Su objetivo es expresar el formalismo matemático de tal modo que pueda ser entendido por distintos sistemas y aplicaciones.  
    - VoiceXML (Voice Extended Markup Language) tiene como objetivo el intercambio de información entre un usuario y una aplicación con capacidad de reconocimiento de habla.  
    - MusicXML: Permite el intercambio de partituras entre distintos editores de partituras.   

## Clasificación.

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

### GML (Generalizaed Markup Language). 

Uno de los problemas que se conocen desde hace décadas en la informática es la falta de estandarización en los formatos de información usados por los distintos programas.  
Para resolver este problema, en los años sesenta IBM encargó a Charles F. Goldfab la construcción de un sistema de edición, almacenamiento y búsqueda de documentos legales. Tras analizar el funcionamiento de la empresa llegaron a la conclusión de que para realizar un buen procesado informático de los documentos había que establecer un formato estándar para todos los documentos que se manejaban en la empresa. Con ello se lograba gestionar cualquier documento en cualquier departamento y con cualquier aplicación, sin tener en cuenta dónde ni con qué se generó el documento. Dicho formato tenía que ser válido para los distintos tipos de documentos legales que utilizaba la empresa, por tanto, debía ser flexible para que se pudiera ajustar a las distintas situaciones.  
El formato de documentos que se creó como resultado de este trabajo fue GML, cuyo objetivo era describir los documentos de tal modo que el resultado fuese independiente de la plataforma y la aplicación utilizada.  

### SGML (Standard Generalized Markup Language). 
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
### HTML (HyperText Markup Language). 
En 1989/90 Tim Berners‐Lee creó el World Wide Web y se encontró con la necesidad de organizar, enlazar y compatibilizar gran cantidad de información procedente de diversos sistemas. Para resolverlo creó un lenguaje de descripción de documentos llamado HTML, que, en realidad, era una combinación de dos estándares ya existentes:  
 - ASCII: Es el formato que cualquier procesador de textos sencillo puede reconocer y almacenar. Por tanto es un formato que permite la trasferencia de datos entre diferentes ordenadores. 
 - SGML: Lenguaje que permite dar estructura al texto, resaltando los títulos o aplicando diversos formatos al texto. 

HTML es una versión simplificada de SGML, ya que sólo se utilizaban las instrucciones absolutamente imprescindibles. Era tan fácil de comprender que rápidamente tuvo gran aceptación logrando lo que no pudo SGML, HTML se convirtió en un estándar general para la creación de páginas web. Además, tanto las herramientas de software como los navegadores que permiten visualizar páginas HTML son cada vez mejores.  

A pesar de todas estas ventajas HTML no es un lenguaje perfecto, sus principales desventajas son:  
 - No soporta tareas de impresión y diseño. 
   - El lenguaje no es flexible, ya que las etiquetas son limitadas. 
   - No permite mostrar contenido dinámico. 
   - La estructura y el diseño están mezclados en el documento. 
**Ejemplo**   
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


## XML: estructura y sintaxis.

## Etiquetas.

## Herramientas de edición.

## Elaboración de documentos XML bien formados.

## Utilización de espacios de nombres en XML.
