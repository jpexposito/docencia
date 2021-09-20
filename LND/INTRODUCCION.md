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
**Ejemplo**
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

### Comparación de XML con HTML. 

| XML | HTML |
| ------------- | ------------- |   
| Es un perfil de SGML | Es una aplicación de SGML.  |
| Especifica cómo deben definirse conjuntos de etiquetas aplicables a un tipo de documento.  | Aplica un conjunto limitado de etiquetas sobre un único tipo de documento.  |
| Modelo de hiperenlaces complejo.  | Modelo de hiperenlaces simple.  |
| El navegador es una plataforma para el desarrollo de aplicaciones.  | El navegador es un visor de páginas.  |
| Fin de la guerra de los navegadores y etiquetas propietarias.   | El problema de la "no compatibilidad" y las diferencias entre navegadores ha alcanzado un punto en el que la solución es difícil. |
|  |  |
 

 	 
**Ejemplo**

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
__Crea el código anterior y ejecutalo en cualquier navegador, para ver su resultado__

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
__Crea el código anterior y ejecutalo en cualquier navegador, para ver su resultado__
 
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

## Etiquetas.

 Los lenguajes de marcas utilizan una serie de etiquetas especiales intercaladas en un documento de texto sin formato. Dichas etiquetas serán posteriormente interpretadas por los intérpretes del lenguaje y ayudan al procesado del documento.  
 Las etiquetas se escriben encerradas entre ángulos, es decir < y >. Normalmente, se utilizan dos etiquetas: una de inicio y otra de fin para indicar que ha terminado el efecto que queríamos presentar. La única diferencia entre ambas es que la de cierre lleva una barra inclinada "/" antes del código. 
``` xml 
<etiqueta>texto que sufrirá las consecuencias de la etiqueta</etiqueta>  
``` 
Por ejemplo, en HTML  
```html 
<u>Esto está subrayado</u> 
``` 
Al interpretarlo en un navegador se verá así:  
***Esto está subrayado***  
 
 Las últimas especificaciones emitidas por el W3C indican la necesidad de que vayan escritas siempre en minúsculas para considerar que el documento está correctamente creado.  

## Herramientas de edición.

Para trabajar en XML es necesario editar los documentos y luego procesarlos, por tanto tenemos dos tipos de herramientas:  
 - Editores XML 
  Una característica de los lenguajes de marcas es que se basan en la utilización de ficheros de texto plano por lo que basta utilizar un procesador de texto normal y corriente para construir un documento XML. 

  Para crear documentos XML complejos e ir añadiendo datos es conveniente usar algún editor XML. Estos nos ayudan a crear estructuras y etiquetas de los elementos usados en los documentos, además algunos incluyen ayuda para la creación de otros elementos como DTD, hojas de estilo CSS o XSL, ... El W3C ha desarrollado un editor de HTML, XHTML, CSS y XML gratuito cuyo nombre es Amaya.  
 - Procesadores XML 
  Para interpretar el código XML se puede utilizar cualquier navegador. Los procesadores de XML permiten leer los documentos XML y acceder a su contenido y estructura. Un procesador es un conjunto de módulos de software entre los que se encuentra un parser o analizador de XML que comprueba que el documento cumple las normas establecidas para que pueda abrirse. Estas normas pueden corresponderse con las necesarias para trabajar sólo con documentos de tipo válido o sólo exigir que el documento esté bien formado, primeros se conocen como validadores y los segundos como no validadores. El modo en que los procesadores deben leer los datos XML está descrito en la recomendación de XML establecida por W3C.  
  Para publicar un documento XML en Internet se utilizan los procesadores XSLT, que permiten generar archivos HTML a partir de documentos XML.  
  Puesto que XML se puede utilizar para el intercambio de datos entre aplicaciones, hay que recurrir a motores independientes que se ejecutan sin que nos demos cuenta. Entre estos destacan "XML para Java" de IBM, JAXP de Sun, etc.

  __Nosotros utilizaremos para trabajar un editor de texto inicialmente__ <img src="https://www.easyappcode.com/upload/post-716768416.jpg" alt="Instalacion SublimeText">

## XML (eXtensible Markup Language) Estructura y Sintaxis. 

 El XML, o Lenguaje de Etiquetas Extendido, es un lenguaje de etiquetas creadas por el programador, que estructuran y guardan de forma ordenada la información. No representa datos por sí mismo, solamente organiza la estructura.

 El XML ahorra tiempos de desarrollo y proporciona ventajas, dotando a webs y aplicaciones de una forma realmente potente de guardar la información. Además, se ha convertido en un formato universal que ha sido asimilado por todo tipo de sistemas operativos y dispositivos móviles.

Al igual que en HTML, un documento XML es un documento de texto, en este caso con extensión _.xml_, compuesto de parejas de etiquetas, estructuradas en árbol, que describen una función en la organización del documento, que puede editarse con cualquier editor de texto y que es interpretado por los navegadores web. Es decir, el documento se edita y se guarda en un fichero con extensión .xml (por ejemplo _Alumnos.xml_) con un editor de textos; posteriormente dicho fichero se puede abrir con el navegador para que lo interprete y muestre el resultado. Si el documento XML tiene errores, el navegador no lo mostrará correctamente. Los navegadores no detectan todos los errores; es mejor utilizar un validador XML. Las características básicas de XML son: 
 - Dado que XML se concibió para trabajar en la Web, es directamente compatible con protocolos
que ya funcionan, como HTTP y los URL.
 - Todo documento que verifique las reglas de XML está conforme con SGML.
 - No se requieren conocimientos de programación para realizar tareas sencillas en XML.
 - Los documentos XML son fáciles de crear.
 - La difusión de los documentos XML está asegurada, ya que cualquier procesador de XML puede leer un documento de XML.
 - El marcado de XML es legible.
 - El diseño XML es formal y conciso.
 - XML es extensible, adaptable y aplicable a una gran variedad de situaciones.
 - XML es orientado a objetos.
 - Todo documento XML se compone exclusivamente de datos de marcado y datos carácter entremezclados. Los datos carácter son los que forman la verdadera información del documento XML.

 El proceso de creación de un documento XML pasa por varias etapas en las que el éxito de cada una de ellas se basa en la calidad de la anterior. Estas etapas son:
 - Especificación de requisitos.
 - Diseño de etiquetas.
 - Marcado de los documentos

 El marcado en XML consiste en etiquetas que se añaden a un texto para estructurar el contenido del documento. Esta información extra permite a los ordenadores "interpretar" los textos. El marcado es todo lo que se sitúa entre los caracteres _"<"_ y _">"_ o _"&"_ y _";"_.

 El marcado puede ser tan rico como se quiera. Resultará interesante detectar necesidades futuras y crear documentos con una estructura fácilmente actualizable.

 Los documentos XML pueden tener comentarios, que no son procesados por el intérprete XML; éste los ignora. Estos comentarios se incluyen entre las cadenas _"<!--"_ y _"-->"_ y pueden estar en cualquier posición en el documento salvo:
 - Antes del prólogo.
 - Dentro de una etiqueta. 

## Elaboración de documentos XML bien formados.

## Utilización de espacios de nombres en XML.
