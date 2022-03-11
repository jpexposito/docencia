<div align="justify">


<div align="center">
 	<img src="https://ftp.homepage-webhilfe.de/Bilder/Themen/XML/XSLT/Transformation.png">
</div>

</br>

## Ejercicio II XSLT

```xml
<?xml version="1.0" encoding="UTF-8"?>
<bib url="http://www.uco.es/servicios/biblioteca/">
  <libro año="1994">
    <titulo>TCP/IP Illustrated</titulo>
    <autor>
      <apellido>Stevens</apellido>
      <nombre>W.</nombre>
    </autor>
    <editorial>Addison-Wesley</editorial>
    <precio>65.95</precio>
  </libro>
  <libro año="1992">
    <titulo>Advan Programming for Unix environment</titulo>
    <autor>
      <apellido>Stevens</apellido>
      <nombre>W.</nombre>
    </autor>
    <editorial>Addison-Wesley</editorial>
    <precio>65.95</precio>
  </libro>
  <libro año="2000">
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
  <libro año="1999">
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

  Dado el anterior documento XML, realiza las siguientes transformaciones XSLT de dos maneras distintas, primero utilizando una plantilla (template) para cada elemento y atributo que se necesite transformar, y segundo utilizando sólo la plantilla raíz y bucles (for-each) para cada elemento que se necesite transformar.

  - Mostrar una lista enumerada con todos los autores ordenados por apellidos.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes" />

     <!-- Plantilla raíz -->
    <xsl:template match="/">
      <html>
        <body>
          <ol>
            <xsl:apply-templates select="bib/libro/autor">
              <xsl:sort select="apellido" order="ascending" />
            </xsl:apply-templates>
          </ol>
        </body>
      </html>
    </xsl:template>

    <!-- Plantilla autor -->
    <xsl:template match="/bib/libro/autor">
        <li><xsl:apply-templates select="apellido" />, <xsl:apply-templates select="nombre" /></li>
    </xsl:template>

    <!-- Plantilla apellido -->
    <xsl:template match="/bib/libro/autor/apellido">
      <xsl:value-of select="." />
    </xsl:template>

    <!-- Plantilla nombre -->
    <xsl:template match="/bib/libro/autor/nombre">
      <xsl:value-of select="." />
    </xsl:template>

  </xsl:stylesheet>
  ```

  - Mostrar una lista enumerada con todos los títulos de libros cuyo precio sea menor de 100.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes" />

     <!-- Plantilla raíz -->
    <xsl:template match="/">
      <html>
        <body>
          <ol>
            <xsl:apply-templates select="bib/libro" />
          </ol>
        </body>
      </html>
    </xsl:template>

    <!-- Plantilla libro -->
    <xsl:template match="/bib/libro">
      <xsl:choose>
        <xsl:when test="precio &lt; 100">
          <li><xsl:apply-templates select="titulo" /></li>
        </xsl:when>
      </xsl:choose>
    </xsl:template>

    <!-- Plantilla titulo -->
    <xsl:template match="/bib/libro/titulo">
      <xsl:value-of select="." />
    </xsl:template>

  </xsl:stylesheet>
  ```

  - Mostrar una tabla con las siguientes columnas:
   - Precio del libro, ordenando los resultados por este campo (Nota: se ordenan como si fueran cadenas y no números).
   - Título del libro. Se mostrará el fondo de la celda en color rojo si el precio es mayor de 100.
   - Año de publicación. Se mostrará el texto en cursiva.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes" />

     <!-- Plantilla raíz -->
    <xsl:template match="/">
      <html>
        <body>
            <xsl:apply-templates select="bib" />
        </body>
      </html>
    </xsl:template>

    <!-- Plantilla bib -->
    <xsl:template match="/bib">
      <table border="1">
        <xsl:apply-templates select="libro" >
          <xsl:sort select="precio" order="ascending" data-type="number" />
        </xsl:apply-templates>
      </table>
    </xsl:template>

    <!-- Plantilla libro -->
    <xsl:template match="/bib/libro">
      <tr>
        <td><xsl:apply-templates select="precio" /></td>
        <xsl:choose>
          <xsl:when test="precio &gt; 100">
            <td style="background-color: red;"><xsl:apply-templates select="titulo" /></td>
          </xsl:when>
          <xsl:otherwise>
            <td><xsl:apply-templates select="titulo" /></td>
          </xsl:otherwise>
        </xsl:choose>
        <td><em><xsl:value-of select="@año" /></em></td>
      </tr>
    </xsl:template>

    <!-- Plantilla precio -->
    <xsl:template match="/bib/libro/precio">
      <xsl:value-of select="." />
    </xsl:template>

    <!-- Plantilla titulo -->
    <xsl:template match="/bib/libro/titulo">
      <xsl:value-of select="." />
    </xsl:template>

  </xsl:stylesheet>
  ```

  - Mostrar una tabla con una primera fila de encabezado y con las siguientes columnas:
    - Título del libro, en color rojo si el precio es mayor de 100, añadiéndole el texto "(Caro)" a continuación, ordenando los resultados por este campo.
    - Autores del libro mostrando primero el nombre y luego el apellido. Si hay más de un autor se muestran todos en la misma celda. Si no hay autor se deja en blanco. Separar palabras con espacio en blanco.
    - Editores del libro mostrando el nombre, el apellido y la afiliación. Si hay más de un editor se muestran todos en la misma celda. Si no hay editor se deja en blanco. Separar palabras con espacio en blanco.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes" />

     <!-- Plantilla raíz -->
    <xsl:template match="/">
      <html>
        <body>
            <xsl:apply-templates select="bib" />
        </body>
      </html>
    </xsl:template>

    <!-- Plantilla bib -->
    <xsl:template match="/bib">
      <table border="1">
        <tr><th>Título</th><th>Autor/es</th><th>Editor/es</th></tr>
        <xsl:apply-templates select="libro" >
          <xsl:sort select="titulo" order="ascending" />
        </xsl:apply-templates>
      </table>
    </xsl:template>

    <!-- Plantilla libro -->
    <xsl:template match="/bib/libro">
      <tr>
        <td><xsl:apply-templates select="titulo" /></td>
        <td><xsl:apply-templates select="autor" /></td>
        <td><xsl:apply-templates select="editor" /></td>
      </tr>
    </xsl:template>

    <!-- Plantilla titulo -->
    <xsl:template match="/bib/libro/titulo">
      <xsl:choose>
        <xsl:when test="../precio &gt; 100">
          <span style="color: red;"><xsl:value-of select="." /> (Caro)</span>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="." />
        </xsl:otherwise>
      </xsl:choose>
    </xsl:template>

    <!-- Plantilla autor -->
    <xsl:template match="/bib/libro/autor">
      <xsl:apply-templates select="nombre" /><xsl:text>&#10;</xsl:text><xsl:apply-templates select="apellido" /><xsl:text>&#10;</xsl:text>
    </xsl:template>

    <!-- Plantilla nombre -->
    <xsl:template match="/bib/libro/autor/nombre">
      <xsl:value-of select="." />
    </xsl:template>

    <!-- Plantilla apellido -->
    <xsl:template match="/bib/libro/autor/apellido">
      <xsl:value-of select="." />
    </xsl:template>

    <!-- Plantilla editor -->
    <xsl:template match="/bib/libro/editor">
      <xsl:apply-templates select="nombre" /><xsl:text>&#10;</xsl:text><xsl:apply-templates select="apellido" /><xsl:text>&#10;</xsl:text><xsl:apply-templates select="afiliacion" /><xsl:text>&#10;</xsl:text>
    </xsl:template>

    <!-- Plantilla nombre -->
    <xsl:template match="/bib/libro/editor/nombre">
      <xsl:value-of select="." />
    </xsl:template>

    <!-- Plantilla apellido -->
    <xsl:template match="/bib/libro/editor/apellido">
      <xsl:value-of select="." />
    </xsl:template>

    <!-- Plantilla afiliacion -->
    <xsl:template match="/bib/libro/editor/afiliacion">
      <xsl:value-of select="." />
    </xsl:template>

  </xsl:stylesheet>
  ```


## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
