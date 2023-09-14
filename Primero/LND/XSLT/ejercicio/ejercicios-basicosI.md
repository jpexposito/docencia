<div align="justify">


<div align="center">
 	<img src="https://ftp.homepage-webhilfe.de/Bilder/Themen/XML/XSLT/Transformation.png">
</div>

</br>

## Ejercicio I XSLT

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ies nombre="IES Puerto la Cruz" web="http://www.iespuertolacruz.es" >
  <ciclos>
    <ciclo id="ASIR">
      <nombre>Administración de Sistemas Informáticos en Red</nombre>
      <grado>Superior</grado>
      <decretoTitulo año="2009" />
    </ciclo>
    <ciclo id="DAW">
      <nombre>Desarrollo de Aplicaciones Web</nombre>
      <grado>Superior</grado>
      <decretoTitulo año="2010" />
    </ciclo>
    <ciclo>
      <nombre>Desarrollo de Aplicaciones Multiplataforma</nombre>
      <grado>Superior</grado>
      <decretoTitulo año="2010" />
    </ciclo>
    <ciclo id="SMR">
      <nombre>Sistemas Microinformáticos y Redes</nombre>
      <grado>Medio</grado>
      <decretoTitulo año="2008" />
    </ciclo>
  </ciclos>
</ies>
```

  Dado el anterior documento XML, realiza las siguientes transformaciones XSLT de dos maneras distintas, primero utilizando una plantilla (template) para cada elemento y atributo que se necesite transformar, y segundo utilizando sólo la plantilla raíz y bucles (for-each) para cada elemento que se necesite transformar.

  - Mostrar los nombres de los ciclos sin etiquetas.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

     <!-- Plantilla raíz -->
    <xsl:template match="/">
      <xsl:apply-templates select="ies/ciclos/ciclo/nombre" />
    </xsl:template>

    <!-- Plantilla nombre -->
    <xsl:template match="/ies/ciclos/ciclo/nombre">
      <xsl:value-of select="." />
    </xsl:template>
  </xsl:stylesheet>
  ```

  - Mostrar en párrafos cada uno de los nombres de los ciclos.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes" />

     <!-- Plantilla raíz -->
    <xsl:template match="/">
      <html>
        <body>
          <xsl:apply-templates select="ies/ciclos/ciclo/nombre" />
        </body>
      </html>
    </xsl:template>

    <!-- Plantilla nombre -->
    <xsl:template match="/ies/ciclos/ciclo/nombre">
      <p><xsl:value-of select="." /></p>
    </xsl:template>
  </xsl:stylesheet>
  ```

  - Mostrar en una lista sin numerar los nombres de los ciclos y entre paréntesis su grado.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes" />

     <!-- Plantilla raíz -->
    <xsl:template match="/">
      <html>
        <body>
            <xsl:apply-templates select="ies/ciclos" />
        </body>
      </html>
    </xsl:template>

    <!-- Plantilla ciclos -->
    <xsl:template match="/ies/ciclos">
      <ul><xsl:apply-templates select="ciclo" /></ul>
    </xsl:template>

    <!-- Plantilla ciclo -->
    <xsl:template match="/ies/ciclos/ciclo">
      <li><xsl:apply-templates select="nombre" /> (<xsl:apply-templates select="grado" />)</li>
    </xsl:template>

    <!-- Plantilla nombre -->
    <xsl:template match="/ies/ciclos/ciclo/nombre">
      <xsl:value-of select="." />
    </xsl:template>

    <!-- Plantilla grado -->
    <xsl:template match="/ies/ciclos/ciclo/grado">
      <xsl:value-of select="." />
    </xsl:template>
  </xsl:stylesheet>

  ```

  - Mostrar en una lista numerada los nombres de los ciclos ordenados alfabéticamente de manera descendente y entre paréntesis su grado.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes" />

     <!-- Plantilla raíz -->
    <xsl:template match="/">
      <html>
        <body>
            <xsl:apply-templates select="ies/ciclos" />
        </body>
      </html>
    </xsl:template>

    <!-- Plantilla ciclos -->
    <xsl:template match="/ies/ciclos">
      <ol>
        <xsl:apply-templates select="ciclo" >
          <xsl:sort select="nombre" order="descending" />
        </xsl:apply-templates>
      </ol>
    </xsl:template>

    <!-- Plantilla ciclo -->
    <xsl:template match="/ies/ciclos/ciclo">
      <li><xsl:apply-templates select="nombre" /> (<xsl:apply-templates select="grado" />)</li>
    </xsl:template>

    <!-- Plantilla nombre -->
    <xsl:template match="/ies/ciclos/ciclo/nombre">
      <xsl:value-of select="." />
    </xsl:template>

    <!-- Plantilla grado -->
    <xsl:template match="/ies/ciclos/ciclo/grado">
      <xsl:value-of select="." />
    </xsl:template>
  </xsl:stylesheet>
  ```


  - Mostrar en una etiqueta H1 el nombre del instituto y luego en una tabla con su fila encabezado las siguientes columnas, nombre del ciclo y año. Si el año es mayor al 2009 la letra será de color verde, si es igual al 2009 de color azul y si es menor al 2009 de color rojo.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes" />

   <!-- Plantilla raíz -->
  <xsl:template match="/">
    <html>
      <body>
          <xsl:apply-templates select="ies" />
      </body>
    </html>
  </xsl:template>

  <!-- Plantilla ies -->
  <xsl:template match="/ies">
    <h1><xsl:value-of select="@nombre" /></h1>
    <xsl:apply-templates select="ciclos" />
  </xsl:template>

  <!-- Plantilla ciclos -->
  <xsl:template match="/ies/ciclos">
    <table border="1">
      <tr><th>Nombre</th><th>Año</th></tr>
      <xsl:apply-templates select="ciclo" />
    </table>
  </xsl:template>

  <!-- Plantilla ciclo -->
  <xsl:template match="/ies/ciclos/ciclo">
    <tr>
      <td><xsl:apply-templates select="nombre" /></td>
      <td><xsl:apply-templates select="decretoTitulo" /></td>
    </tr>
  </xsl:template>

  <!-- Plantilla nombre -->
  <xsl:template match="/ies/ciclos/ciclo/nombre">
    <xsl:value-of select="." />
  </xsl:template>

  <!-- Plantilla decretoTitulo -->
  <xsl:template match="/ies/ciclos/ciclo/decretoTitulo">
    <xsl:choose>
      <xsl:when test="@año &gt; 2009">
        <span style="color: green;"><xsl:value-of select="@año" /></span>
      </xsl:when>
      <xsl:when test="@año &lt; 2009">
        <span style="color: red"><xsl:value-of select="@año" /></span>
      </xsl:when>
      <xsl:otherwise>
        <span style="color: blue"><xsl:value-of select="@año" /></span>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
</xsl:stylesheet>
  ```


## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
