<div align="justify">

# Reconocimiento de las características de lenguajes de marcas


## Introducción.

Un **lenguaje de marcas** es un modo de codificar un documento donde, junto con el texto, se incorporan etiquetas, marcas o anotaciones con información adicional relativa a la estructura del texto o su formato de presentación. Permiten hacer explícita la estructura de un documento, su contenido semántico o cualquier otra información lingüística o extralingüística que se quiera hacer patente.  
Todo lenguaje de marcas está definido en un documento denominado DTD (Document Type Definition). En él se establecen las marcas, los elementos utilizados por dicho lenguaje y sus correspondientes etiquetas y atributos, su sintaxis y normas de uso.

```xml
<carta>  
<fecha>22/11/2006</fecha>  
<presentacion>Estimado cliente:</presentacion>  
<contenido>bla bla bla bla …</contenido>  
<firma>Don Jose Gutiérrez González</firma>  
</carta>
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

  __Nosotros utilizaremos para trabajar un editor de texto inicialmente__ <img src="https://www.easyappcode.com/upload/post-716768416.jpg" alt="Instalacion SublimeText" style="width:24px;height:24px;" alt="Sublime text">, conocido como Sublime Text y quebes de instalar.

## XML (eXtensible Markup Language) Estructura y Sintaxis. 

 El XML, o Lenguaje de Etiquetas Extendido, es un lenguaje de etiquetas creadas por el programador, que estructuran y guardan de forma ordenada la información. No representa datos por sí mismo, solamente organiza la estructura.

 El XML ahorra tiempos de desarrollo y proporciona ventajas, dotando a webs y aplicaciones de una forma realmente potente de guardar la información. Además, se ha convertido en un formato universal que ha sido asimilado por todo tipo de sistemas operativos y dispositivos móviles.

Al igual que en HTML, un documento XML es un documento de texto, en este caso con extensión _.xml_, compuesto de parejas de etiquetas, estructuradas en árbol, que describen una función en la organización del documento, que puede editarse con cualquier editor de texto y que es interpretado por los navegadores web. Es decir, el documento se edita y se guarda en un fichero con extensión .xml (por ejemplo _Alumnos.xml_) con un editor de textos; posteriormente dicho fichero se puede abrir con el navegador para que lo interprete y muestre el resultado. Si el documento XML tiene errores, el navegador no lo mostrará correctamente. Los navegadores no detectan todos los errores; es mejor utilizar un validador XML. Las características básicas de XML son: 
 - Dado que XML se concibió para trabajar en la Web, es directamente compatible con protocolos que ya funcionan, como HTTP y los URL.
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

 Un ejemplo de comentario puede ser:
 ``` xml 
<?xml version="1.0" encoding="iso-8859-1"?>
<!-- Esto es un comentario; será ignorado por cualquier procesado -->
<libro>
...
</libro> 
``` 
 Los documentos XML pueden estar formados por una parte opcional, llamada prólogo, y otra parte obligatoria, llamada ejemplar. 


### El prólogo.

Si se incluye, el prólogo debe preceder al ejemplar del documento. Su inclusión facilita el procesado de la información del ejemplar. El prólogo está dividido en dos partes:
 -  La declaración XML: en el caso de incluirse ha de ser la primera línea del documento; de no ser así se genera un error que impide que el documento sea procesado.
 El hecho de que esta declaración sea opcional permite el procesamiento de documentos _HTML_ y _SGML_ como si fueran XML; si fuera obligatoria éstos deberían incluir una declaración de versión XML que no tienen.
 La declaración XML puede tener tres funciones: 
   - Declaración de la versión de XML usada para elaborar el documento.
   Para ello se utiliza la etiqueta:
 ``` xml 
<?xml versión= "1.0" ?>
 ```
  En este caso indica que el documento fue creado para la versión 1.0 de XML.
   - Declaración de la codificación empleada para representar los caracteres.
   Determina el conjunto de caracteres que se utiliza en el documento. Para ello se escribe:
 ``` xml 
<?xml versión= "1.0" encoding="iso-8859-1" ?>
 ``` 
   _En este caso se usa el código iso-8859-1 (Latin-1)_.
   Los códigos más importantes son:
 
 | Estándar ISO | Descripción |
 | -------------| ------------- |
 |  UTF-8 (Unicode) | Conjunto de caracteres universal | 
 | ISO -8859-1 (Latin-1) | Europa occidental, Latinoamérica | 
 | ISO -8859-2 (Latin-2) | Europa central y oriental | 
 | ISO -8859-3 (Latin-3) | Sudoeste de Europa | 
 | ISO -8859-4 (Latin-4) | Países Escandinavos, Bálticos | 
 | ISO -8859-5 |  Cirílico | 
 | ISO -8859-6 |  Árabe | 
 | ISO -8859-7 |  Griego | 
 | ISO -8859-8 |  Hebreo | 
 | ISO -8859-9 |  Turco | 
 | ISO-8859-10 |  Lapón. Nórdico, esquimal | 
 | EUC-JP oder Shitf_JIS |  Japonés | 

  El valor por defecto para encoding es UTF-8; es decir que ese es el valor que coge cuando no se escribe encoding. Por tanto, las dos líneas siguientes hacen lo mismo:
 ``` xml 
<?xml versión= "1.0" encoding="UTF-8" ?>
<?xml versión= "1.0" ?>
 ```
  - Declaración de la autonomía del documento.
  Informa de si el documento necesita de otro para su interpretación. Para ello se escribe:
 ``` xml 
<?xml versión= "1.0" encoding="iso-8859-1" standalone="yes" ?>
 ```
  En este caso, el documento es independiente (valor __yes__); de no ser así, el atributo standalone hubiese tomado el valor __no__.
 - La declaración del tipo de documento: define qué tipo de documento estamos creando para ser procesado correctamente; toda declaración de tipo de documento comienza por la cadena:
  ``` xml 
<!DOCTYPE Nombre_Tipo ...>
 ``` 
 De momento no usaremos la etiqueta DOCTYPE, por lo que no la escribiremos en nuestros documentos XML. Más adelante se explicará en detalle y comenzaremos a utilizarla.  

### Los elementos.

 Es la parte más importante de un documento XML, ya que contiene los datos reales del documento. Está formado por elementos anidados.

 Los elementos son los distintos bloques de información que permiten definir la estructura de un documento XML. Están delimitados por una etiqueta de apertura y una etiqueta de cierre. A su vez los elementos pueden estar formados por otros elementos y/o por atributos.
_Ejemplo._

```xml 
<?xml version="1.0" encoding="iso-8859-1"?>
<libro>
<titulo>XML practico</titulo>
<autor>Sebastien Lecomte</autor>
<autor>Thierry Boulanger</autor>
<editorial>Ediciones Eni</editorial>
<isbn>978-2-7460-4958-1</isbn>
<edicion>1</edicion>
<paginas>347</paginas>
</libro>
```
 El elemento raíz o ejemplar es el elemento <libro>, que a su vez está compuesto de los elementos __<titulo>, <autor>, <editorial>, <isbn>, <edicion> y <paginas>__. El elemento __<libro>__ se cierra al final con la etiqueta __</libro>__, por lo que el resto de elementos están todos dentro del  elemento <libro>. En realidad, en todo documento XML, todos sus elementos están dentro (o pertenecen) al elemento raíz o ejemplar. Éste siempre se abre al inicio (<libro> en este caso) y se cierra al final (en este caso </libro>).

 Todos los datos (toda información o datos carácter) de un documento XML han de pertenecer a un elemento del mismo. En ese ejemplo, el dato  __XML practico__ pertenece al elemento <titulo>.
 
 Los nombres de las etiquetas han de ser autodescriptivos (autodocumentados), lo que facilita el trabajo que se hace con ellas. Por ejemplo, para guardar el título de un libro no conviene llamar a la etiqueta <etiq1>, sino que es mucho mejor llamarla <titulo>.

 La formación de elementos ha de cumplir ciertas normas para que queden perfectamente definidos y que el documento XML al que pertenecen pueda ser interpretado por los procesadores XML sin generar ningún error. Dichas reglas son:
 - En todo documento XML debe existir un elemento raíz y sólo uno.
 - Todos los elementos tienen una etiqueta de inicio y otra de cierre. En el caso de que en el documento existan elementos vacíos (sin información), se pueden sustituir las etiquetas de inicio y cierre por una de elemento vacío. Ésta se construye como la etiqueta de inicio, pero añadiendo el carácter "/" antes del ">". Es decir:
 ```xml 
<elemento></elemento> es igual que <elemento/>
```
 - Al anidar elementos hay que tener en cuenta que no puede cerrarse un elemento que contenga algún otro elemento que aún no se haya cerrado. Dicho de otro modo, si un primer elemento contiene otro segundo elemento, éste segundo debe cerrarse antes que el primero.
 - El nombre de las etiquetas de inicio y de cierre de un mismo elemento ha de ser idéntico, respetando las mayúsculas y minúsculas. Ese nombre puede ser cualquier cadena alfanumérica que no contenga espacios y no comience ni por el carácter dos puntos, __:__, ni por la cadena "xml" en ninguna de sus versiones en que se cambien mayúsculas y minúsculas (__XML__, __XmL__, __xML__, ...). Es aconsejable no utilizar caracteres como la ñ, vocales con tilde, signos de puntuación, etc.
 - El contenido de los elementos (el dato o información) no puede contener la cadena __]]>__ por compatibilidad con SGML. Además no se pueden utilizar directamente los caracteres indicados a continuación; si se quiere usar alguno de esos caracteres en un dato, debe sustituirse por lo indicado en la columna de la derecha:

   
 | Descripción | Carácter |Sustituir por |   
 | -------------| -------------| ------------- |   
 | mayor que  | > |  \&gt; |    
 | menor que | <  | \&lt; |    
 | ampersand |  &  | \&amp; |    
 | comillas dobles  | " |  \&quot; |    
 | apóstrofe  | ‘ |  \&apos; |    

 Por ejemplo, para usar el & en un dato se pondría:
 ```xml
 <empresa>Juan &amp; Asociados</empresa>
 ```

En el navegador se vería: __Juan & Asociados__

 - Para utilizar algún carácter especial (incluidos los anteriores), como _£, ©, ®_, etc., hay que escribir la expresión _&#D; o &#xH_, donde D y H se corresponden con el número decimal o hexadecimal respectivamente del carácter que se quiere representar en el código UNICODE. Por ejemplo, para incluir el carácter de Euro, €, se usarían las cadenas _&#8364_; (en decimal) o _&#x20AC_; (en hexadecimal). El código UNICODE puede verse en: http://unicode-table.com

 __Ejemplo. Incluir el carácter € en un documento XML.__
 ```xml
<precio>365 &#x20AC;</precio> 
 ```

  ```xml
 <precio>365 &#8364;</precio>
 ```

 Para evitar problemas con las vocales con tilde (á é í ó ú Á É Í Ó Ú) y la ñ (mayúscula o minúscula), los más fiable es utilizar sus códigos __UNICODE__.

 __Ejemplo.__
  ```xml
<nombre>José Cañas Álvarez</nombre>
 ```

debería escribirse como:
 ```xml
<nombre>Jos&#233; Ca&#241;as &#193;lvarez</nombre>
 ```

## Elaboración de documentos XML bien formados.

  En un documento XML no debe ponerse un elemento que contenga un dato además de otros elementos. Si bien esta situación no genera errores de sintaxis, se dificultará el procesado posterior que pudiera aplicarse al documento. Por ejemplo:
```xml
 <alumno>
Juan
<apellidos>Garrido Fdez.</apellidos>
</alumno>
 ```
 Como se ve en el ejemplo, el elemento alumno contiene el dato "Juan" además del elemento apellidos. El dato "Juan" queda mezclado con el elemento apellidos, por lo que no se puede acceder a dicho dato de forma independiente. Por tanto, debe definirse otro elemento para el dato __Juan__, es decir que cada dato debe tener su etiqueta asociada, del modo:
 
```xml
<alumno>
<nombre>Juan</nombre>
<apellidos>Garrido Fdez.</apellidos>
</alumno>
```

Cuando un documento tiene un elemento que se repite porque la información que se desea almacenar así lo requiere, no debe numerarse dicho elemento. Se tiende a añadir el número en el propio nombre del elemento pero no es correcto. Por ejemplo:

```xml
<AlumnosCiclo>
<alumno1>Juan Garrido</alumno1>
<alumno2>José Gómez</alumno2>
<alumno3>Jesús García</alumno3>
<alumno4>Pedro López</alumno4>
etc.
etc.
</AlumnosCiclo>
```

 __Lo correcto sería__:

```xml
<AlumnosCiclo>
<alumno>Juan Garrido</alumno>
<alumno>José Gómez</alumno>
<alumno>Jesús García</alumno>
<alumno>Pedro López</alumno>
etc.
etc.
</AlumnosCiclo>
```

Escrito de este último modo se facilita el posterior procesado del documento; además los alumnos están ordenados según el orden en que se escriben, por lo que numerarlos es innecesario. Por otra parte, al añadir un número al nombre de la etiqueta, cada etiqueta tendrá un nombre distinto, es decir la etiqueta alumno1 no es la misma que alumno2; son etiquetas distintas, por lo que será más difícil procesar el documento (se verá en temas posteriores). A veces interesa añadir elementos simplemente para estructurar mejor el documento, así como para hacerlo más legible. Por ejemplo:

```xml
<integrantes>
<lista_alumnos>
<alumno>...</alumno>
<alumno>...</alumno>
...
</lista_alumnos>
<lista_profesores>
<profesor>...</profesor>
<profesor>...</profesor>
...
</lista_profesores>
</integrantes>
```

En ese ejemplo, las etiquetas __<lista_alumnos></lista_alumnos> y <lista_profesores></lista_profesores>__ podrían eliminarse, quedando:

```xml
<integrantes>
<alumno>...</alumno>
<alumno>...</alumno>
...
<profesor>...</profesor>
<profesor>...</profesor>
...
</integrantes>
```

 El documento sería igualmente correcto, pero al incluir las etiquetas citadas el código queda más claro y estructurado, ya que existe una etiqueta que da acceso a todos los alumnos y otra que da acceso a todos los profesores.

### Atributos.

 Permiten añadir propiedades a los elementos de un documento. Los atributos no pueden organizarse en ninguna jerarquía, no pueden contener ningún otro elemento o atributo y no reflejan ninguna estructura lógica.

 No se debe utilizar un atributo para contener información susceptible de ser dividida. 

__Ejemplo__.

```xml
<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<biblioteca>
<documento tipo_docum="libro" titulo="XML práctico" editorial="Ediciones Eni">
<tipo> <libro isbn="978-2-7460-4958-1" edicion="1" paginas="347"></libro> </tipo>
<autor nombre="Sebastien Lecomte"></autor>
<autor nombre="Thierry Boulanger"></autor>
<autor nombre="Ángel Belinchon Calleja" funcion="traductor"></autor>
<prestado lector="Pepito Grillo">
<fecha_pres dia="13" mes="mar" año="2009"></fecha_pres>
<fecha_devol dia="21" mes="jun" año="2009"></fecha_devol>
</prestado>
</documento>
</biblioteca>
```
 __Guarda el fichero y ejecutalo con un navegador__

 Vemos que los elementos aparecen coloreados en ciruela, los nombres de los atributos en negro y sus valores en azul. En ese ejemplo todos los datos están almacenados en atributos y ninguno en elementos.
 Como se observa en el ejemplo, los atributos se definen y dan valor dentro de una etiqueta de inicio de un elemento. Para guardar un valor en un atributo se usa el signo igual, =. El valor del atributo irá entre comillas simples o dobles. Por ejemplo:
 - Elemento: autor
  - Atributo: nombre
  - Valor del atributo: Roberto Lemus
 Se escribirá:
 
 ```xml
<autor nombre="Roberto Lemus"></autor>
```

 Como ese elemento autor no guarda ningún dato (el dato está en el atributo), se puede cerrar el elemento autor como sigue:

```xml
<autor nombre="Sebastien Lecomte" />
```

 Si un mismo elemento tiene varios atributos, se escriben separados por un espacio. Por ejemplo:
 - Elemento: libro
 - Atributos: isbn, edicion, paginas

 Se escribirá:

```xml
<libro isbn="978-2-7460-4958-1" edicion="1" paginas="347" />
```

 Los nombres de los atributos han de cumplir las mismas reglas que los de los elementos y no pueden contener el carácter menor que, <. Un elemento puede guardar un valor además de tener atributos. Por ejemplo:

```xml
 <autor funcion="traductor">Ángel Belinchon Calleja</autor>
```
 Vemos que el elemento autor guarda el nombre del autor (Ángel Belinchon Calleja), sin usar el signo = y sin comillas. Por otra parte, ese elemento tiene el atributo funcion, que guarda el valor "traductor" usando el signo = y las comillas.

 Puede haber algún atributo vacío, es decir sin valor asignado (valor nulo). Para ello se escriben las comillas seguidas después del signo =. No debe dejarse el signo = sin las comillas. Por

 Ejemplo:

```
CORRECTO: <autor funcion="">Ángel Belinchon Calleja</autor>
INCORRECTO: <autor funcion= >Ángel Belinchon Calleja</autor>
```
 Cualquier dato puede guardarse como un elemento o como un atributo dentro de un elemento. Por ejemplo, las dos líneas siguientes guardan el dato "Juan" y ambas son correctas sintácticamente:

```xml
<autor>Juan</autor>
<autor nombre="Juan" />
```
 Sin embargo, como norma general se puede indicar que un elemento suele guardar el dato principal, mientras que los atributos guardarán características adicionales del elemento en cuestión. Por ejemplo, si se considera que el nombre del alumno es el dato principal y la edad es una característica secundaria, quedaría:

```xml
<alumno edad="21" >Juan Garrido</alumno>
```

El dato del nombre del alumno se guarda en el elemento, mientras que la edad se guarda en el atributo. Por otra parte, cuando un elemento sólo guarda un dato, en general no es conveniente guardar dicho dato en un atributo, sino guardarlo directamente en el elemento. Por ejemplo:

__NO ES CONVENIENTE__:

```xml
 <autor nombre="Juan" />
```

Quedaría mejor y con menos código del modo siguiente:

```xml
<autor>Juan</autor>
```

En este caso, no se utiliza atributo y por tanto no es necesario inventar un identificador (nombre) para ese atributo. Por ello es mejor de este modo. Sin embargo, puede interesar el uso del atributo en esa situación si el código quedara más legible y más fácil de entender.
### Datos.

 Es importante tener en cuenta que al guardar un dato no se debe almacenar la parte que sea fija (común) en todos los ítems iguales del documento XML. Por ejemplo, para guardar la edad de los alumnos no debe guardarse la palabra "años", ya que todas las edades del documento se van a expresar en años, es decir que lo siguiente no sería correcto:

_INCORRECTO: por almacenar la palabra_ __años__. 
```xml
<alumno edad="21 años">Juan Garrido</alumno>
<alumno edad="30 años">José Fuentes</alumno>
<alumno edad="19 años">Ramón Gómez</alumno>
```

 Eso afecta tanto a atributos como a elementos. Sería incorrecto: __INCORRECTO__: por almacenar la palabra _años_.

```xml
<alumno><nombre>Juan Garrido</nombre><edad>21 años</edad></alumno>
<alumno><nombre>José Fuentes</nombre><edad>30 años</edad></alumno>
<alumno><nombre>Ramón Gómez</nombre><edad>19 años</edad></alumno>
```

_Lo correcto sería poner simplemente el número en la edad, sin incluir la palabra_ __años__.

```xml

(<años>21</años> o años="21").
<alumno><nombre>Juan Garrido</nombre><edad>21</edad></alumno>
<alumno><nombre>José Fuentes</nombre><edad>30</edad></alumno>
<alumno><nombre>Ramón Gómez</nombre><edad>19</edad></alumno>
```

# Tareas a realizar en la Unidad <img src="../../img/tarea.png" alt="Tareas a Realizar" style="width:84px;height:84px;">

 - [Tarea 1: Instalación de Sublime Text 3](tareas/tarea_instalar_sublime.md)  
 - [Tarea 2: Creación de una agenda en XML](tareas/tarea_agenda.md) 
 - [Tarea 3: Creación de una receta en XML](tareas/tarea_receta.md) 
 - [Tarea 4: Creación de un sistema informático en XML](tareas/tarea_sistema_informatico.md)  

</div>

<div align="center">
 <a href="INTRODUCCION.md"><img src="../../img/home.png" alt="XML Home" style="width:42px;height:42px;"></a> <a href="CLASIFICACION.md"><img src="../../img/next.png" alt="XML Clasificación" style="width:42px;height:42px;"> 
</div>

