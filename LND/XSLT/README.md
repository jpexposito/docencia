<div align="justify">


# XSLT

  <div align="center">
   	<img src="https://ftp.homepage-webhilfe.de/Bilder/Themen/XML/XSLT/Transformation.png">
  </div>

## Introducción

  __XSLT (eXtensible Stylesheet Language for Transformations)__ es un lenguaje que permite aplicar una transformación a un documento XML para obtener otro documento XML, un documento HTML o un documento de texto plano.

  La hoja de estilos XSLT con las reglas de transformación es también un documento de texto XML en sí, generalmente con extensión __.xsl__, por lo que se podrá comprobar si está bien formado o no.

  El funcionamiento lo podemos observar en la siguiente imagen:

  <div align="center">
   	<img src="https://www.ticarte.com/sites/su/users/7/image/xslt_resumen.png">
  </div>

  A un documento XML se le pueden aplicar una o varias transformaciones XSLT e incluso una transformación CSS. Las hojas de estilos XSLT son más útiles que las hojas de estilos CSS porque:

  Permiten cambiar el orden los elementos.
  - Permiten realizar operaciones con sus valores.
  - Permiten agrupar elementos.
  - ​De ahí que se suelan utilizar en combinación más que decantarse por una u otra hoja de estilos.

  XSLT es un estándar del W3C:
   - __XSLT 1.0__.
   - __XSLT 2.0__.
   - __XSLT 3.0__.

  Para todos los ejemplos siguiente vamos a tomar como referencia el siguiente documento XML:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <bib url="http://www.ticarte.com">
    <book id="1">
      <title>TCP/IP Illustrated</title>
      <author>Stevens</author>
      <publisher>Addison-Wesley</publisher>
      <year>2002</year>
    </book>
    <book id="2">
      <title>Advanced Programming in the Unix Environment</title>
      <author>Stevens</author>
      <publisher>Addison-Wesley</publisher>
      <year>2004</year>
    </book>
    <book id="3">
      <title>Data on the Web</title>
      <author>Abiteboul</author>
      <author>Buneman</author>
      <author>Suciu</author>
      <year>2006</year>
    </book>
  </bib>
  ```

## Herramientas para el manejo de transformaciones XSLT

  Para diseñar hojas de transformaciones XSLT podemos utilizar el software libre XML Copy Editor o cualquier otro software que comentamos aquí.

  Para probarlo sólo tenemos que abrir el documento XML en el navegador Mozilla Firefox, Microsoft Edge o Microsoft Internet Explorer para ver el resultado de la transformación. El navegador Google Chrome por defecto no aplica las transformaciones.

  En el navegador podemos utilizar la opción del botón derecho "Inspeccionar elemento" para comprobar los resultados de la transformación, ya que si elegimos "Ver código fuente" se nos abrirá el documento XML original sin ninguna transformación.

## Aplicar al documento XML una hoja de estilos XSLT

  El primer paso será definir en la cabecera del documento XML qué hoja de estilos XSLT se va a aplicar como vemos a continuación:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <?xml-stylesheet type="text/xsl" href="bib.xsl"?>
  <bib>
  ```

  Este documento XML podemos abrirlo en los navegadores que hemos indicado anteriormente.

  ___Recordamos que las hojas de estilos XSLT deben estar bien formadas, pero no van a validar___.

## Estructura básica de una hoja de estilos XSLT

 La estructura básica de un documento XSLT es la que se muestra a continuación. Al no contener ninguna regla de transformación todos los nodos se enviarán por defecto a la salida de la transformación.

 ```xml
 <?xml version="1.0" encoding="UTF-8"?>
 <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
 </xsl:stylesheet>
 ```

### __<xsl:output>__

  En su interior podemos utilizar la etiqueta <xsl:output> que nos indicará el tipo de documento al que vamos a transformar el documento XML de entrada. Se permiten los siguientes atributos:
  - __method__: define el formato de salida (xml, html o text).
  - __version__: define la versión del formato de salida.
  - __enconding__: juego de caracteres de salida. Por defecto UTF-8.
  - __indent__: indenta la salida de la transformación (yes o no).

  ___Veamos un ejemplo___: (_\<xsl:output method="html" version="5.0" encoding="UTF-8" indent="yes" />_)

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="html" version="5.0" encoding="UTF-8" indent="yes" />

  </xsl:stylesheet>
  ```

## Diseño con Plantillas

__<xsl:template> / <xsl:apply-templates> / <xsl:value-of>__.

La transformación se basa en el uso de plantillas (templates) con la etiqueta <xsl:template> que se aplicarán a cada nodo o atributo del documento según se va recorriendo éste, sustituyendo de esa manera el nodo por el contenido de su plantilla.

La hoja de estilos debe tener al menos una plantilla que suele corresponder con el nodo raíz, aunque puede ser de otro nodo. Si esta plantilla no contiene nada, como en el siguiente ejemplo, no se enviará nada como salida de la transformación:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes" />
  <xsl:template match="/">
  </xsl:template>
</xsl:stylesheet>
```

__NOTA__: _En los siguientes ejemplos eliminaremos las etiquetas_  ___\<xsl:stylesheet> y <xsl:output>___ para abreviar los ejemplos.

Lo normal es que tengamos más plantillas, una para cada nodo de nuestro documento XML. Utilizaremos la etiqueta __<xsl:apply-templates>__ para mostrar en una plantilla la transformación de otra. Prestar atención a los atributos que se utilizan, en __<xsl:template>__ se utiliza __"match"__ y en __<xsl:apply-templates>__ se utiliza __"select"__.

En el siguiente ejemplo la plantilla raíz transformará cada nodo __"book"__ de su interior por su plantilla. Hay que ver como las plantillas __<xsl:template>__ utilizan rutas __XPath__ absolutas para identificar los nodos a los que hacen referencia, pero __<xsl:apply-templates>__ utilizará, normalmente, rutas __XPath__ relativas al nodo de contexto en el que se esté llamando. Este ejemplo aún no muestra nada en la salida.

```xml
<!-- Plantilla raíz -->
<xsl:template match="/">
  <xsl:apply-templates select="bib/book" />
</xsl:template>

<!-- Plantilla book -->
<xsl:template match="/bib/book">
</xsl:template>
```

En el interior de una plantilla podemos utilizar la etiqueta __<xsl:value-of>__ para imprimir el valor que contiene el nodo, utilizando expresiones __XPath__ para acceder a ellas. Tomaremos como nodo contexto el nodo en el que estamos trabajando o estamos posicionados actualmente. El ejemplo anterior lo podemos modificar mostrando en la plantilla __"book"__ el contenido del nodo __"title"__, para mostrar todos los títulos de los libros:

```xml
<!-- Plantilla raíz -->
<xsl:template match="/">
  <xsl:apply-templates select="bib/book" />
</xsl:template>

<!-- Plantilla book -->
<xsl:template match="/bib/book">
  <xsl:value-of select="title" />
</xsl:template>
```

En el ejemplo anterior hemos mostrado el valor del nodo __"title"__ desde __book"__, pero podemos crear también una nueva plantilla para el nodo __"title"__ y que dicha plantilla muestre directamente su valor de la siguiente manera. Mirar de nuevo cómo se utilizan las rutas absolutas y relativas en __XPath__.

```xml
<!-- Plantilla raíz -->
<xsl:template match="/">
  <xsl:apply-templates select="bib/book" />
</xsl:template>

<!-- Plantilla book -->
<xsl:template match="/bib/book">
  <xsl:apply-templates select="title" />
</xsl:template>

<!-- Plantilla title -->
<xsl:template match="/bib/book/title">
  <xsl:value-of select="." />
</xsl:template>
```

Si una plantilla lo único que tiene es mostrar el valor de su nodo se podría __eleminar__, obteniéndose el mismo resultado. En el siguiente ejemplo eliminamos la plantilla del nodo __"title"__ y aún así el resultado es el mismo que el ejemplo anterior:

```xml
<!-- Plantilla raíz -->
<xsl:template match="/">
  <xsl:apply-templates select="bib/book" />
</xsl:template>

<!-- Plantilla book -->
<xsl:template match="/bib/book">
  <xsl:apply-templates select="title" />
</xsl:template>
```

También se puede utilizar __<xsl:apply-templates>__ sin seleccionar ningún nodo concreto, de esa manera se aplicarán todas las plantillas que existan para los nodos que se recorran. Si en el ejemplo anterior no utilizamos __"select"__ dentro de la plantilla __"book"__ se mostrará por salida todos los datos de los nodos que contenga dentro __"book"__, existan o no sus plantillas.

```xml
<!-- Plantilla raíz -->
<xsl:template match="/">
  <xsl:apply-templates select="bib/book" />
</xsl:template>

<!-- Plantilla book -->
<xsl:template match="/bib/book">
  <xsl:apply-templates />
</xsl:template>

<!-- Plantilla title -->
<xsl:template match="/bib/book/title">
  <xsl:value-of select="." />
</xsl:template>
```

Como hemos dicho, dentro de la etiqueta __<xsl:value-of>__ podemos utilizar las funciones de __XPath__ para obtener nuevos resultados, en este ejemplo para calcular la media:

```xml
<!-- Plantilla raíz -->
<xsl:template match="/">
  <xsl:value-of select="sum(/bib/book/year) div count(/bib/book/year)" />
</xsl:template>
```

Y también para seleccionar nodos concretos por ejemplo:

```xml
<!-- Plantilla raíz -->
<xsl:template match="/">
  <xsl:apply-templates select="bib/book[3]" />
</xsl:template>
```

Los atributos también pueden transformarse creándoles una plantilla como vemos en el siguiente ejemplo:

```xml
<!-- Plantilla raíz -->
<xsl:template match="/">
  <xsl:apply-templates select="bib/book" />
</xsl:template>

<!-- Plantilla book -->
<xsl:template match="/bib/book">
  <xsl:apply-templates select="@id" />
</xsl:template>

<!-- Plantilla atributo id -->
<xsl:template match="/bib/book/@id">
  <xsl:value-of select="." />
</xsl:template>
```

### Ejemplo completo

En el siguiente ejemplo más completo utilizaremos las plantillas para transformar el documento XML a una lista con formato HTML donde cada elemento de la lista sea el nombre del libro y el año de publicación entre paréntesis, situando el código HTML en sus plantillas correspondientes:

```xml
<!-- Plantilla raíz -->
<xsl:template match="/">
  <html>
    <head>
    </head>
    <body>
      <xsl:apply-templates select="bib" />
    </body>
    </html>
</xsl:template>

<!-- Plantilla bib -->
<xsl:template match="/bib">
  <ul>
    <xsl:apply-templates select="book" />
  </ul>
</xsl:template>

<!-- Plantilla book -->
<xsl:template match="/bib/book">
  <li>
    <xsl:apply-templates select="title" />
    <xsl:apply-templates select="year" />
  </li>
</xsl:template>

<!-- Plantilla title -->
<xsl:template match="/bib/book/title">
  <xsl:value-of select="." />
</xsl:template>

<!-- Plantilla year -->
<xsl:template match="/bib/book/year">
  (<xsl:value-of select="." />)
</xsl:template>
```

## Diseño en bucle con sólo la plantilla raíz

__<xsl:for-each>__

El mismo ejemplo anterior se puede realizar utilizando solamente la plantilla raíz y haciendo uso de la etiqueta __<xsl:for-each>__, que permite pasar por todos los nodos seleccionados, como si se tratara de un bucle __"for"__ en programación:

```xml
<!-- Plantilla raíz -->
<xsl:template match="/">
  <html>
    <head>
    </head>
    <body>
      <xsl:for-each select="bib">
        <ul>
        <xsl:for-each select="book">
          <li>
          <xsl:value-of select="title" />
          </li>
        </xsl:for-each>
        </ul>
      </xsl:for-each>
    </body>
    </html>
</xsl:template>
```

### Ordenación de nodos

__<xsl:sort>__

Se puede ordenar la salida de los nodos mediante la etiqueta __<xsl:sort>__ situándola dentro de las etiquetas __<xsl:apply-templates>__ si se utilizan plantillas o dentro de las etiquetas __<xsl:for-each>__ si se utilizan bucles. Los siguientes atributos se pueden utilizar con ella:
- lang: __"language-code"__.
- data-type: __"text | number | qname"__.
- order: __"ascending | descending"__.
- case-order: __"upper-first | lower-first"__.

```xml
<!-- Plantilla bib -->
<xsl:template match="/bib">
  <ul>
    <xsl:apply-templates select="book">
      <xsl:sort select="title" order="ascending" />
    </xsl:apply-templates>
  </ul>
</xsl:template>
<!-- Bucle bib -->
<xsl:for-each select="/bib/book">
  <xsl:sort select="title" order="descending" />
  <xsl:value-of select="title" />
</xsl:for-each>
```

#### Estructuras condicionales

__<xsl:if>__

La etiqueta __<xsl:if>__ permite introducir una condición en la transformación mediante una condición evaluada mediante XPath en el atributo __"test"__. Pero tan simple que no admite ni siquiera la opción "else". Se pueden utilizar las expresiones y funciones de __XPath__. Hay que tener en cuenta que para utilizar los operadores __"mayor que"__ y __"menor que"__ hay que reemplazarlos por su carácter codificado en HTML.
- Mayor que: &gt;
- Menor que: &lt;

```xml
<!-- Plantilla year -->
<xsl:template match="/bib/book/year">
  <xsl:if test=". &gt; 2000">
    <strong><xsl:value-of select="." /></strong>
  </xsl:if>
  <xsl:if test=". = 2000">
    <em><xsl:value-of select="." /></em>
  </xsl:if>
  <xsl:if test=". &lt; 2000">
    <xsl:value-of select="." />
  </xsl:if>
</xsl:template>
```

__<xsl:choose> / <xsl:when> / <xsl:otherwise>__

La estructura __"choose"__ es similar al "switch" de los lenguajes de programación, permitiendo condiciones consecutivas. Se pueden utilizar las expresiones y funciones de __XPath__. Hay que tener en cuenta que para utilizar los operadores __"mayor que"__ y __"menor que"__ hay que reemplazarlos por su carácter codificado en HTML.

```xml
<!-- Plantilla year -->
<xsl:template match="/bib/book/year">
  <xsl:choose>
    <xsl:when test=". &gt; 2000">
      <strong><xsl:value-of select="." /></strong>
    </xsl:when>
    <xsl:when test=". &lt; 2000">
      <em><xsl:value-of select="." /></em>
    </xsl:when>
    <xsl:otherwise>
      <xsl:value-of select="." />
    </xsl:otherwise>
  </xsl:choose>
</xsl:template>
```

#### Generar contenido
<xsl:text>

En algunas ocasiones necesitaremos texto literal en la salida, por ejemplo espacios en blanco para separar valores. En este caso utilizaremos la etiqueta <xsl:text> con su código correspondiente:

```xml
<!-- Plantilla year -->
<xsl:template match="/bib/book/year">
  (<xsl:text>&#10;</xsl:text>
   <xsl:value-of select="." />
   <xsl:text>&#10;</xsl:text>)
</xsl:template>
```

##### <xsl:element> / <xsl:attribute>

Cuando tengamos que crear nodos nuevos en el documento de salida, con su etiquetas y atributos necesitaremos utilizar las etiquetas <xsl:element> y <xsl:attribute> para poder utilizar los valores del XML origen en dichos nodos. En el siguiente ejemplo crearemos enlace mediante HTML, es decir, una etiqueta "a" con el atributo "href" utilizando el atributo "url" del nodo "bib":

```xml
<!-- Pantilla bib -->
<xsl:template match="/bib">
  <xsl:element name="a">
    <xsl:attribute name="href">
      <xsl:value-of select="@url" />
    </xsl:attribute>
    Biblioteca
  </xsl:element>
  <ul>
    <xsl:apply-templates select="book" />
  </ul>
</xsl:template>
```



## Herramientas online  
  - [freeformatter](https://www.freeformatter.com/xsl-transformer.html).

</div>
