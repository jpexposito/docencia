<div align="justify">


<div align="center">
 	<img src="https://ftp.homepage-webhilfe.de/Bilder/Themen/XML/XSLT/Transformation.png">
</div>

</br>

## Ejemplos simples XSLT

Vamos a ver ejemplos de plantillas trabajando sobre el documento siguiente:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<biblioteca>
  <libro>
    <titulo>La vida está en otra parte</titulo>
    <autor>Milan Kundera</autor>
    <fechaPublicacion año="1973"/>
  </libro>
  <libro>
    <titulo>Pantaleón y las visitadoras</titulo>
    <autor fechaNacimiento="28/03/1936">Mario Vargas Llosa</autor>
    <fechaPublicacion año="1973"/>
  </libro>
  <libro>
    <titulo>Conversación en la catedral</titulo>
    <autor fechaNacimiento="28/03/1936">Mario Vargas Llosa</autor>
    <fechaPublicacion año="1969"/>
  </libro>
</biblioteca>
```

## Plantillas vacías o no existentes

Si no hay plantillas, el procesador simplemente recorre todos los nodos y extrae el texto contenido por cada nodo.

- Dada la plantilla:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  </xsl:stylesheet>
  ```
- Resultado:
```xml
<?xml version="1.0" encoding="UTF-8"?>

    La vida está en otra parte
    Milan Kundera

    Pantaleón y las visitadoras
    Mario Vargas Llosa

    Conversación en la catedral
    Mario Vargas Llosa
```
  _En el ejemplo, el resultado incluye el contenido de los nodos __<título> y <autor>__ puesto que no hay ninguna plantilla_.

- Dada la plantilla:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="autor">
    </xsl:template>

  </xsl:stylesheet>
  ```

  - Resultado:

  ```xml
    <?xml version="1.0" encoding="UTF-8"?>

    La vida está en otra parte

    Pantaleón y las visitadoras

    Conversación en la catedral
  ```

    El resultado incluye el contenido de los nodos __<titulo>__, ya que no hay regla para ellos, pero los de __<autor>__ se pierden porque la plantilla es vacía.

- Dada la plantilla:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="libro">
       <xsl:value-of select="autor"/>
    </xsl:template>

  </xsl:stylesheet>
  ```

- Resultado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>

  Milan Kundera
  Mario Vargas Llosa
  Mario Vargas Llosa
  ```

  El documento final contiene los autores de los libros porque la plantilla los genera con la instrucción __<xsl:value-of>__. Como se ha aplicado una plantilla al nodo __<libro>__, sus hijos (__\<titulo>, \<autor> y \<fechaPublicacion>__) no se recorren. Por eso, los títulos de los libros no aparecen en el documento final.

- Dada la plantilla:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="libro">
       <xsl:value-of select="titulo"/>
       <xsl:value-of select="autor"/>
    </xsl:template>

  </xsl:stylesheet>
  <?xml version="1.0" encoding="UTF-8"?>
  ```

- Resultado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>

  La vida está en otra parteMilan Kundera
  Pantaleón y las visitadorasMario Vargas Llosa
  Conversación en la catedralMario Vargas Llosa
  ```

  Se obtienen el titulo y el autor de los libros, pero uno a continuación de otro. Los saltos de línea se crean tras cada aplicación de la regla (es decir, a cada libro), pero no en el interior de la regla.

- Dada la plantilla:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="autor">
       <xsl:value-of select="."/>
    </xsl:template>

  </xsl:stylesheet>
  ```

- Resultado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>

    La vida está en otra parte
    Milan Kundera

    Pantaleón y las visitadoras
    Mario Vargas Llosa

    Conversación en la catedral
    Mario Vargas Llosa
  ```

  Los autores se obtienen gracias a la regla que extrae el contenido del nodo (el carácter punto _"."_ ___hace referencia al propio elemento)___ y _los títulos se obtienen porque al no haber reglas para ese nodo se extrae el contenido_. El resultado es el mismo que el del ejemplo 1-1, pero por motivos distintos.

- Dada la plantilla:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="fechaPublicacion">
       <xsl:value-of select="@año"/>
    </xsl:template>

  </xsl:stylesheet>
  ```

- Resultado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>

    La vida está en otra parte
    Milan Kundera
    1973

    Pantaleón y las visitadoras
    Mario Vargas Llosa
    1973

    Conversación en la catedral
    Mario Vargas Llosa
    1969
  ```

  Las ___fechas de publicación___ se obtienen gracias a la regla que _extraen el valor del atributo_ y los títulos y autores se obtienen porque al no haber reglas para ese nodo se extrae el contenido.

- Dada la plantilla:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="/">
      <html>
        <h1>Autores</h1>
        <xsl:apply-templates />
      </html>
    </xsl:template>

    <xsl:template match="libro">
       <p><xsl:value-of select="autor"/></p>
    </xsl:template>

  </xsl:stylesheet>
  ```

- Resultado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <html><h1>Autores</h1>
    <p>Milan Kundera</p>
    <p>Mario Vargas Llosa</p>
    <p>Mario Vargas Llosa</p>
  </html>
  ```
  La instrucción ___\<xsl:apply-templates>___ hace que se _apliquen a los subelementos las reglas que les sean aplicables_.

  En el ejemplo anterior, se genera la etiqueta <html> además de unos párrafos con los nombres de los autores. Este ejemplo sí que se puede ver en el navegador ya que se interpreta como html.
- Dada la plantilla:

  La instrucción ___\<xsl:strip-space>___ permite indicar si los elementos que contienen únicamente espacios en blanco se incluyen en la transformación o no.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:strip-space elements="*" />

    <xsl:template match="/">
      <html>
        <h1>Autores</h1>
        <xsl:apply-templates />
      </html>
    </xsl:template>

    <xsl:template match="libro">
       <p><xsl:value-of select="autor"/></p>
    </xsl:template>

  </xsl:stylesheet>
  ```

- Resultado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <html>
    <h1>Autores</h1>
    <p>Milan Kundera</p>
    <p>Mario Vargas Llosa</p>
    <p>Mario Vargas Llosa</p>
  </html>
  ```                              

- Dada la plantilla:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
    <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="licencia">
      <p><img>
      <xsl:attribute name="src">
        <xsl:value-of select="imagen" />
      </xsl:attribute>
      </img>
      </p>
    </xsl:template>

  </xsl:stylesheet>
```

- Resultado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <p>
    <img src="cc-bysa-88x31.png"/>
  </p>
  ```

  Para generar un atributo en una etiqueta, es necesario utilizar la instrucción ___\<xsl:attribute>___.

- Dada la plantilla:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="/">
      <html>
       <xsl:apply-templates />
      </html>
    </xsl:template>

    <xsl:template match="licencia">
      <p><img>
      <xsl:attribute name="src">
        <xsl:value-of select="imagen" />
      </xsl:attribute>
      </img>
      </p>
    </xsl:template>

  </xsl:stylesheet>
  ```

- Resultado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <html>
    <p><img src="cc-bysa-88x31.png"/></p>
  </html>
  ```

  Para que la imagen se muestre en el navegador sería necesario generar también la etiqueta __<html>__.
</div>


## Fuente:
  - [Ejemplos de hojas de estilo](https://www.mclibre.org/consultar/xml/lecciones/xml-xslt.html).
