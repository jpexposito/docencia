# XML y DTD: Definición de esquemas y vocabularios en XML

## Introducción.

  Una DTD es un documento que define la estructura de un documento XML: los elementos, atributos, entidades, notaciones, etc, que pueden aparecer, el orden y el número de veces que pueden aparecer, cuáles pueden ser hijos de cuáles, etc. El procesador XML utiliza la DTD para verificar si un documento es válido, es decir, si el documento cumple las reglas del DTD.

## Utilización de métodos de definición de documentos XML.

  La DTD o documento de definición de tipos indica el formato que debe tener el documento XML, es decir las etiquetas que serán válidas y las que no para realizar un cierto tipo de documento. La DTD puede definirse en la propia página o en una página aparte.
## Asociación con documentos XML.

  Podemos poner la misma DTD dentro del documento , veamos un ejemplo sencillo:

```xml
<?xml version="1.0" encoding="iso-8859-15"?>
<!DOCTYPE saludo [
  <!ELEMENT saludo (hola,nombre)>
    <!ELEMENT hola (#PCDATA)>
    <!ELEMENT nombre (#PCDATA)>
]>
<saludo>
  <hola>Hola mundo</hola>
  <nombre>Soy Anyelguti</nombre>
</saludo>
```

  Una forma de realizarlo más ordenado sería la siguiente:

```xml
  <?xml version="1.0" encoding="iso-8859-15"?>
  <!DOCTYPE saludo SYSTEM "saludo.dtd">
  <saludo>
    <hola>Hola mundo</hola>
  <nombre>Soy Anyelguti</nombre>
```
  El documento DTD asociado, es decir el archivo saludo.dtd será el siguiente:

```console
<!ELEMENT saludo (hola,nombre)>
   <!ELEMENT hola (#PCDATA)>
   <!ELEMENT nombre (#PCDATA)>
```

  El contenido del "doctype" lo ponemos en un archivo aparte, al cual hacemos referencia en el documento XML.

### Las etiquetas

  Empezamos a ver cómo se construye el documento DTD. Este documento indica qué etiquetas y atributos debe tener el documento XML, y cómo deben ser estas. Empezaremos por las etiquetas:
  - Las etiquetas de XML se indican mediante una etiqueta en DTD que empieza por la palabra __!ELEMENT__.
  - A continuación ponemos el nombre de la etiqueta.
  - Después indicamos el contenido de la etiqueta. Este puede ser:
  - Otras etiquetas : En ese caso indicamos el nombre de las etiquetas entre paréntesis:

    ```console
      <!ELEMENT saludo (hola,nombre)>
    ```

  - En este caso podemos poner una serie de operadores (que veremos más adelante) para indicar cuántas etiquetas de cada nombre podemos poner.
  - Cadena de texto : lo indicaremos mediante la instrucción entre paréntesis (#PCDATA).

  ```console
  <!ELEMENT nombre (#PCDATA)>
  ```

  Elemento vacío : lo indicamos mediante la instrucción EMTPY (sin paréntesis):

  ```console
  <!ELEMENT foto EMPTY>
  ```

  En todos los casos los elementos pueden llevar atributos. Veremos más adelante cómo indicar los atributos en la DTD.


###  Operadores

  En el primero de los casos, cuando una etiqueta tiene etiquetas hijos, la etiqueta principal no puede llevar texto (pero si atributos). Al indicar las etiquetas dependientes dentro del paréntesis debemos indicar las veces que se puede repetir cada etiqueta. De no indicar nada ésta se deberá poner una única vez.
  Los operadores se encargan de indicar lo anterior, y son unos signos que se ponen al final del nombre de cada etiqueta ej:

  ```
  <!ELEMENT direccion (nombre,alias+,telefono*,domicilio?)>
  ```

  En el ejemplo después de algunos nombres de etiquetas dependientes, hemos puesto algunos signos como _+, * , ?_. Estos son los operadores. Veamos qué es lo que significan:
  - Sin operador : la etiqueta debe estar obligatoriamente una sóla vez.
  - \+ : La etiqueta debe aparecer una o más veces (Mínimo una).
  - \* : La etiqueta puede aparecer cero, una, o más veces .
  - \? : La etiqueta puede aparecer cero, o una vez, pero no más de una.
  - \| : En la etiqueta puede haber uno u otro elemento de los indicados, pero sólo uno de ellos, ejemplo:

  ```
  <!ELEMENT telefono (fijo | movil | #PCDATA)>
  ```
  En el último caso podemos elegir poner dentro de la etiqueta "telefono", la etiqueta "fijo", o la etiqueta "movil" o un contenido de texto, pero sólo una cosa de estas tres.

### Los atributos

  En la DTD debemos indicar también qué atributos tiene cada elemento y sus características.

  Inmediatamente después de declarar un elemento debemos declarar sus atributos. Los atributos de un elemento se declaran todos dentro de la misma etiqueta __<!ATTLIST nombre_elemento .... >__ :

```
  <!ELEMENT foto EMPTY>
  <!ATTLIST foto
     ruta CDATA "objetos/avatar.gif"
     comentario CDATA #IMPLIED
     numero ID #REQUIRED
     >
```

  Dentro de la etiqueta , indicamos primero el nombre del elemento al que corresponden los atributos, y después la lista de atributos. Para cada atributo pondremos tres indicadores: El nombre, el tipo y la frecuencia.
  console
  __EL NOMBRE :__ es el nombre que tendrá el atributo.
  __EL TIPO :__ indica qué tipo de contenido podemos poner en el valor del atributo. Éste se indica mediante:
   - CDATA : Podemos poner cualquier texto siempre que esté conforme con las reglas de escritura para XML:
   - comentario CDATA #IMPLIED
   - NMTOKEN : sólo puede contener letras, dígitos, punto [ . ], guión [ - ], subrayado [ _ ] y dos puntos [ : ] valor _NMTOKEN #REQUIRED_
   - NMTOKENS : puede contener los mismos caracteres que _NMTOKEN_ más espacios en blanco. Se entiende por espacios en blanco uno o más espacios, retornos de carro o tabuladores.
   - lista_valores NMTOKENS #REQUIRED
   - ID : Debe cumplir las mismas condiciones que NMTOKEN, pero además debe empezar por una letra, y el valor debe ser distinto en cada uno de los elementos que tengan este atributo.
  _alias ID #REQUIRED_
  - IDREF : el atributo debe ser el mismo que el de otro atributo id indicado anteriormente (referencia a otro elemento).
  _grupo IDREF #IMPLIED_
  - IDREFs : como IDREF pero podemos poner poner más de un elemento como referencia, estos irán separados en el XML simplemente por espacios.
  _grupos IDREF #IMPLIED_
  - (valor1 | valor2 | ... |valorX) : los posibles valores del atributo vienen indicados por una lista de valores. Estos se indican entre paréntesis separados por el signo [ | ].
  sexo (varón | mujer) #REQUIRED
  - LA FRECUENCIA: Aunque aquí lo llamamos así, el tercer identificador que aparece en la declaración de un atributo indica en primer lugar si el atributo es obligatorio o no, y ademas puede indicar su valor por defecto en caso de que no aparezca. Sus posibles valores son:
    - __#REQUIRED__ : El atributo debe ponerse obligatoriamente.
    nombre CDATA #REQUIRED
    - __#IMPLIED__ : El atributo es opcional, puede no ponerse.
    _comentario CDATA #IMPLIED_
    - __"valor_defecto"__ : Se indica entre comillas el valor por defecto del atributo. Caso de no ponerse se entenderá que está puesto con su valor por defecto.
    _ruta CDATA "objetos/avatar.gif"_
    - __#FIXED "valor"__ : El atributo es obligatorio, y además debe tener como valor el indicado después de la palabra #FIXED
    realizacion CDATA #FIXED "anyelguti".

### Validador

  ¿Cómo podemos saber si un documento XML es válido conforme a su DTD? La mayoría de los navegadores no tienen en cuenta si el documento se ajusta a su DTD sino simplemente si el documento está bien formado. Es decir sólo tienen en cuenta que el documento se ajuste a las normas básicas de creación de archivos XML.

  Sin embargo, ya vimos en la primera página de este manual que podemos poner el atributo standalone="yes" en la primera declaración del archivo XML para comprobar si el XML se ajusta a la DTD:

  ```xml
  <?xml version="1.0" encode="UTF-7" standalone="yes"?>
  ```

## Herramientas de creación y validación.

  Existen numerosas herramientas de validación, algunas de ellas online y con estas trabajaremos:
  - http://xmlvalidator.new-studio.org/
  - https://www.w3schools.com/xml/xml_validator.asp
  - https://www.xmlvalidation.com/
