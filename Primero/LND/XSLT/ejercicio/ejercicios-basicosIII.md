<div align="justify">


<div align="center">
 	<img src="https://ftp.homepage-webhilfe.de/Bilder/Themen/XML/XSLT/Transformation.png">
</div>

</br>

## Ejercicio III XSLT

```xml
<catalogo>
  <artistas>
    <artista id="uno">
      <nombre>Carlos Jean</nombre>
      <nacionalidad>España</nacionalidad>
    </artista>
    <artista id="dos">
      <nombre>Miguel Rios</nombre>
      <nacionalidad>España</nacionalidad>
    </artista>
    <artista id="tres">
      <nombre>La Mala</nombre>
      <nacionalidad>España</nacionalidad>
    </artista>
    <artista id="cuatro">
      <nombre>Etta James</nombre>
      <nacionalidad>USA</nacionalidad>
    </artista>
  </artistas>
  <discograficas>
    <discografica id="uno">
      <nombre>Motown</nombre>
      <nacionalidad>USA</nacionalidad>
    </discografica>
    <discografica id="dos">
      <nombre>Subterfuge</nombre>
      <nacionalidad>España</nacionalidad>
    </discografica>
    <discografica id="tres">
      <nombre>Sony</nombre>
      <nacionalidad>USA</nacionalidad>
    </discografica>
  </discograficas>
  <cds>
    <cd autor="uno" disc="dos">
      <titulo>Bad Jean</titulo>
      <precio>15</precio>
      <año>2000</año>
    </cd>
    <cd autor="dos" disc="tres">
      <titulo>Rock and Rios</titulo>
      <precio>12</precio>
      <año>1982</año>
    </cd>
    <cd autor="tres" disc="tres">
      <titulo>Malamarismo</titulo>
      <precio>10.90</precio>
      <año>2008</año>
    </cd>
    <cd autor="cuatro" disc="uno">
      <titulo>At last</titulo>
      <precio>13</precio>
      <año>1979</año>
    </cd>
    <cd autor="cuatro" disc="uno">
      <titulo>Chess soul sisters</titulo>
      <precio>16</precio>
      <año>1980</año>
    </cd>
    <cd autor="dos" disc="dos">
      <titulo>Michael Rios</titulo>
      <precio>10</precio>
      <año>1973</año>
    </cd>
    <cd autor="uno" disc="dos">
      <titulo>Party Stereo</titulo>
      <precio>13</precio>
      <año>2009</año>
    </cd>
    <cd autor="tres" disc="tres">
      <titulo>Dirty Bailarina</titulo>
      <precio>13</precio>
      <año>1979</año>
    </cd>
  </cds>
</catalogo>
```

  Dado el anterior documento XML, realiza las siguientes transformaciones XSLT de dos maneras distintas, primero utilizando una plantilla (template) para cada elemento y atributo que se necesite transformar, y segundo utilizando sólo la plantilla raíz y bucles (for-each) para cada elemento que se necesite transformar.

  - Mostrar una lista con los autores españoles.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="/">
      <html>
        <xsl:apply-templates select="catalogo/artistas/artista" />
      </html>
    </xsl:template>

    <xsl:template match="catalogo/artistas/artista">
      <xsl:if test="nacionalidad = 'España'">
        <li>
          <xsl:value-of select="nombre" />
        </li>
        </xsl:if>
    </xsl:template>
  ```

  Indicamos que sólo se aplique __catalogo/artistas/artista__ de modo que el resto se ignora. Después utilizamos la sentencia __if__ para filtrar los resultados.

  Otra forma de realizarlo es a través de un bucle for:

  ```xml

  <?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="UTF-8" indent="yes" method="html" version="5.0"/>
	<xsl:template match="/">
		<html>
			<head/>
			<body>
				<ol>
					<xsl:for-each select="catalogo/artistas/artista">
						<xsl:if test="nacionalidad = 'España'">
							<li>
								<xsl:value-of select="nombre"/>
							</li>
						</xsl:if>
					</xsl:for-each>
				</ol>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
  ```

  - Mostrar una tabla con el nombre del disco en verde si el año es posterior al 2000, y en rojo si el año es anterior al 2000.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  	<xsl:output encoding="UTF-8" indent="yes" method="html" version="5.0"/>
  	<xsl:template match="/">
  		<html>
  			<head/>
  			<body>
  				<xsl:apply-templates select="catalogo/cds"/>
  			</body>
  		</html>
  	</xsl:template>
  	<xsl:template match="/catalogo/cds">
  		<table>
  			<xsl:apply-templates select="cd"/>
  		</table>
  	</xsl:template>
  	<xsl:template match="/catalogo/cds/cd">
  		<tr>
  			<xsl:choose>
  				<xsl:when test="año &gt; 2000">
  					<td>
  						<font color="green"/>
  						<xsl:apply-templates select="titulo"/>
  					</td>
  				</xsl:when>
  				<xsl:otherwise>
  					<td>
  						<font color="red"/>
  						<xsl:apply-templates select="titulo"/>
  					</td>
  				</xsl:otherwise>
  			</xsl:choose>
  		</tr>
  	</xsl:template>
  </xsl:stylesheet>
  ```
  O a través de un bucle for:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  	<xsl:output encoding="UTF-8" indent="yes" method="html" version="5.0"/>
  	<xsl:template match="/">
  		<html>
  			<head/>
  			<body>
  				<table>
  					<xsl:for-each select="catalogo/cds/cd">
  						<tr>
  							<xsl:choose>
  								<xsl:when test="año &gt; 2000">
  									<td>
  										<font color="green"/>
  										<xsl:apply-templates select="titulo"/>
  									</td>
  								</xsl:when>
  								<xsl:otherwise>
  									<td>
  										<font color="red"/>
  										<xsl:apply-templates select="titulo"/>
  									</td>
  								</xsl:otherwise>
  							</xsl:choose>
  						</tr>
  					</xsl:for-each>
  				</table>
  			</body>
  		</html>
  	</xsl:template>
  </xsl:stylesheet>
  ```

## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
