<div align="justify">


<div align="center">
 	<img src="https://ftp.homepage-webhilfe.de/Bilder/Themen/XML/XSLT/Transformation.png">
</div>

</br>

## Ejercicio IV XSLT

1. Dado el siguiente documento XML, escriba y enlace las hojas de estilo XSLT que devuelvan la respuesta deseada.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<reyes>
  <persona>
    <nombre>Reina Victoria</nombre>
    <vida nacimiento="1819" pais="Reino Unido" muerte="1901" />
    <monarca>
      <cargo>Reina</cargo>
      <pais>Reino Unido</pais>
    </monarca>
  </persona>

  <persona>
    <nombre>Emperatriz Victoria</nombre>
    <vida nacimiento="1840" pais="Reino Unido" muerte="1901" />
    <monarca>
      <cargo>Emperatriz</cargo>
      <pais>Alemania</pais>
    </monarca>
  </persona>

  <persona>
    <nombre>Princesa Alicia</nombre>
    <vida nacimiento="1843" pais="Reino Unido" muerte="1878" />
  </persona>

  <persona>
    <nombre>Princesa Beatriz</nombre>
    <vida nacimiento="1857" pais="Reino Unido" muerte="1944" />
  </persona>

  <persona>
    <nombre>Guillermo II</nombre>
    <vida nacimiento="1859" pais="Alemania" muerte="1941" />
    <monarca>
      <cargo>Emperador</cargo>
      <pais>Alemania</pais>
    </monarca>
  </persona>

  <persona>
    <nombre>Reina Sofía</nombre>
    <vida nacimiento="1870" pais="Alemania" muerte="1932" />
    <monarca>
      <cargo>Reina</cargo>
      <pais>Grecia</pais>
    </monarca>
  </persona>

  <persona>
    <nombre>Victoria Eugenia de Battenger</nombre>
    <vida nacimiento="1887" pais="Alemania" muerte="1969" />
    <monarca>
      <cargo>Reina</cargo>
      <pais>España</pais>
    </monarca>
  </persona>

  <persona>
    <nombre>Emperatriz Alexandra</nombre>
    <vida nacimiento="1872" pais="Alemania" muerte="1918" />
    <monarca>
      <cargo>Emperatriz</cargo>
      <pais>Rusia</pais>
    </monarca>
  </persona>
</reyes>
```

Dado el anterior documento XML, realiza las siguientes transformaciones XSLT:
- Muestra el nombre, cargo y país de cada uno de los reyes.

Solución:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output encoding="UTF-8" indent="yes" method="html" version="5.0"/>
  <xsl:template match="/">
    <xsl:apply-templates select="reyes/persona"/>
  </xsl:template>
  <xsl:template match="/reyes/persona/nombre">
    <xsl:value-of select="."/>
  </xsl:template>
</xsl:stylesheet>
```

- Muestra el nombre, el país de nacimiento y el año de cada uno de los reyes.

Solución:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output encoding="UTF-8" indent="yes" method="html" version="5.0"/>
  <xsl:template match="/">
    <html>
      <head/>
      <body>
        <xsl:for-each select="//persona">
          <ul>
            <li>
              <xsl:value-of select="nombre"/>
            </li>
            <li>
              <xsl:value-of select="vida/@nacimiento"/>
            </li>
            <li>
              <xsl:value-of select="vida/@pais"/>
            </li>
          </ul>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
```

- Muestra el nombre y país de todas las personas que hayan sido reinas.

Solución:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output encoding="UTF-8" indent="yes" method="html" version="5.0"/>
  <xsl:template match="/">
    <html>
      <head/>
      <body>
        <xsl:for-each select="//persona">
          <xsl:if test="monarca/cargo = 'Reina'">
          <ul>
            <li>
              <xsl:value-of select="nombre"/>
            </li>
            <li>
              <xsl:value-of select="monarca/cargo"/>
            </li>
            <li>
              <xsl:value-of select="monarca/pais"/>
            </li>
          </ul>
          </xsl:if>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
```

- Muestra el nombre y fecha de nacimiento y muerte de todas las personas cuya fecha de muerte sean anterior a 1900.

Solución:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output encoding="UTF-8" indent="yes" method="html" version="5.0"/>
  <xsl:template match="/">
    <html>
      <head/>
      <body>
        <xsl:for-each select="//persona">
          <xsl:if test="vida/@muerte &lt; 1900">
          <ul>
            <li>
              <xsl:value-of select="nombre"/>
            </li>
            <li>
              <xsl:value-of select="vida/@nacimiento"/>
            </li>
            <li>
              <xsl:value-of select="vida/@muerte"/>
            </li>
          </ul>
          </xsl:if>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
```

- Mostrar el cargo y nombre de los monarcas (únicamente de los monarcas) en forma de párrafos:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<p>Reina Victoria fue Reina de Reino Unido</p>
<p>Emperatriz Victoria fue Emperatriz de Alemania</p>
<p>Guillermo II fue Emperador de Alemania</p>
<p>Reina Sofía fue Reina de Grecia</p>
<p>Victoria Eugenia de Battenger fue Reina de España</p>
<p>Emperatriz Alexandra fue Emperatriz de Rusia</p>
```

Solución:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output encoding="UTF-8" indent="yes" method="html" version="5.0"/>
  <xsl:template match="/">
    <html>
      <head/>
      <body>
        <xsl:for-each select="//persona">
          <xsl:choose>
            <xsl:when test="monarca">
              <p>
                <xsl:value-of select="nombre"/>
                <xsl:text>fue </xsl:text>
                <xsl:value-of select="monarca/cargo"/>
                <xsl:text>de </xsl:text>
                <xsl:value-of select="monarca/pais"/>
              </p>
            </xsl:when>
          </xsl:choose>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
```

- Mostrar la fecha y lugar de nacimiento de todas las personas en forma de lista. El resultado contendrá todas las etiquetas necesarias para verse correctamente en el navegador:

```html
<?xml version="1.0" encoding="UTF-8"?>
<html>
  <h1>La descendencia de la Reina Victoria</h1>
  <ul>
    <li>Reina Victoria nació en 1819 en Reino Unido</li>
    <li>Emperatriz Victoria nació en 1840 en Reino Unido</li>
    <li>Princesa Alicia nació en 1843 en Reino Unido</li>
    <li>Princesa Beatriz nació en 1857 en Reino Unido</li>
    <li>Guillermo II nació en 1859 en Alemania</li>
    <li>Reina Sofía nació en 1870 en Alemania</li>
    <li>Victoria Eugenia de Battenger nació en 1887 en Alemania</li>
    <li>Emperatriz Alexandra nació en 1872 en Alemania</li>
  </ul>
</html>

```

Solución:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output encoding="UTF-8" indent="yes" method="html" version="5.0"/>
  <xsl:template match="/">
    <html>
      <head/>
      <body>
        <h1>La descendencia de la Reina Victoria</h1>
        <ul>
          <xsl:for-each select="//persona">
            <li>
              <xsl:value-of select="nombre"/>
              <xsl:text>nació en </xsl:text>
              <xsl:value-of select="vida/@nacimiento"/>
              <xsl:text>en </xsl:text>
              <xsl:value-of select="vida/@pais"/>
            </li>
          </xsl:for-each>
        </ul>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
```

2. Dado el siguiente documento XML, escriba las hojas de estilo XSLT que devuelvan la respuesta deseada.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<galerias>
  <galeria>
    <nombre>El Prado</nombre>
    <ciudad>Madrid</ciudad>
    <pais>España</pais>
  </galeria>
  <galeria>
    <nombre>British Museum</nombre>
    <ciudad>Londres</ciudad>
    <pais>Reino Unido</pais>
  </galeria>
  <galeria>
    <nombre>National Gallery</nombre>
    <ciudad>Londres</ciudad>
    <pais>Reino Unido</pais>
  </galeria>
</galerias>
```
- Convertir las etiquetas en atributos, obteniendo el siguiente resultado:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<galerias>
  <galeria nombre="El Prado" ciudad="Madrid" pais="España"/>
  <galeria nombre="British Museum" ciudad="Londres" pais="Reino Unido"/>
  <galeria nombre="National Gallery" ciudad="Londres" pais="Reino Unido"/>
</galerias>
```

 - Solución:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <xsl:template match="/">
    <galerias>
      <xsl:apply-templates />
    </galerias>
  </xsl:template>

  <xsl:template match="galeria">
    <galeria>
      <xsl:attribute name="nombre"><xsl:value-of select="nombre" /></xsl:attribute>
      <xsl:attribute name="ciudad"><xsl:value-of select="ciudad" /></xsl:attribute>
      <xsl:attribute name="pais"><xsl:value-of select="pais" /></xsl:attribute>
    </galeria>
  </xsl:template>

  </xsl:stylesheet>
  ```


- Convertir las etiquetas en atributos, obteniendo el siguiente resultado:

```xml
?xml version="1.0" encoding="UTF-8"?>
<galerias>
  <galeria>
    <nombre>El Prado</nombre>
    <ubicacion ciudad="Madrid" pais="España"/>
  </galeria>
  <galeria>
    <nombre>British Museum</nombre>
    <ubicacion ciudad="Londres" pais="Reino Unido"/>
  </galeria>
  <galeria>
    <nombre>National Gallery</nombre>
    <ubicacion ciudad="Londres" pais="Reino Unido"/>
  </galeria>
</galerias>
```

Solución:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <xsl:template match="/">
    <galerias>
      <xsl:apply-templates />
    </galerias>
  </xsl:template>

  <xsl:template match="galeria">
    <galeria>
      <nombre><xsl:value-of select="nombre" /></nombre>
      <ubicacion>
        <xsl:attribute name="ciudad"><xsl:value-of select="ciudad" /></xsl:attribute>
        <xsl:attribute name="pais"><xsl:value-of select="pais" /></xsl:attribute>
      </ubicacion>
    </galeria>
  </xsl:template>

  </xsl:stylesheet>
  ```


- Convertir las etiquetas en atributos, obteniendo el siguiente resultado:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ciudades>
  <ciudad>
    <nombre>Madrid</nombre>
    <pais>España</pais>
    <galeria>El Prado</galeria>
  </ciudad>
  <ciudad>
    <nombre>Londres</nombre>
    <pais>Reino Unido</pais>
    <galeria>British Museum</galeria>
  </ciudad>
  <ciudad>
    <nombre>Londres</nombre>
    <pais>Reino Unido</pais>
    <galeria>National Gallery</galeria>
  </ciudad>
</ciudades>
```

Solución:

 ```xml
 <?xml version="1.0" encoding="UTF-8"?>
 <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
 <xsl:strip-space elements="*" />

 <xsl:template match="/">
   <ciudades>
     <xsl:apply-templates />
   </ciudades>
 </xsl:template>

 <xsl:template match="galeria">
   <ciudad>
     <nombre><xsl:value-of select="ciudad" /></nombre>
     <pais><xsl:value-of select="pais" /></pais>
     <galeria><xsl:value-of select="nombre" /></galeria>
   </ciudad>
 </xsl:template>

 </xsl:stylesheet>
 ```

- Convertir las etiquetas en atributos, obteniendo el siguiente resultado:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ciudades>
  <ciudad nombre="Madrid" pais="España">
    <galeria>El Prado</galeria>
  </ciudad>
  <ciudad nombre="Londres" pais="Reino Unido">
    <galeria>British Museum</galeria>
  </ciudad>
  <ciudad nombre="Londres" pais="Reino Unido">
    <galeria>National Gallery</galeria>
  </ciudad>
</ciudades>
```

Solución:

 ```xml
 <?xml version="1.0" encoding="UTF-8"?>
 <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
 <xsl:strip-space elements="*" />

 <xsl:template match="/">
   <ciudades>
     <xsl:apply-templates />
   </ciudades>
 </xsl:template>

 <xsl:template match="galeria">
   <ciudad>
     <xsl:attribute name="nombre"><xsl:value-of select="ciudad" /></xsl:attribute>
     <xsl:attribute name="pais"><xsl:value-of select="pais" /></xsl:attribute>
     <galeria><xsl:value-of select="nombre" /></galeria>
   </ciudad>
 </xsl:template>

 </xsl:stylesheet>
 ```

- Convertir las etiquetas en atributos, obteniendo el siguiente resultado:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<paises>
  <pais nombre="España">
    <galeria galeria="El Prado" ciudad="Madrid"/>
  </pais>
  <pais nombre="Reino Unido">
    <galeria galeria="British Museum" ciudad="Londres"/>
  </pais>
  <pais nombre="Reino Unido">
    <galeria galeria="National Gallery" ciudad="Londres"/>
  </pais>
</paises>
```

Solución:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:strip-space elements="*" />

<xsl:template match="/">
  <paises>
    <xsl:apply-templates />
  </paises>
</xsl:template>

<xsl:template match="galeria">
  <pais>
    <xsl:attribute name="nombre"><xsl:value-of select="pais" /></xsl:attribute>
    <galeria>
        <xsl:attribute name="galeria"><xsl:value-of select="nombre" /></xsl:attribute>
        <xsl:attribute name="ciudad"><xsl:value-of select="ciudad" /></xsl:attribute>
    </galeria>
  </pais>
</xsl:template>

</xsl:stylesheet>
```

## Genera un informe con las soluciones y los resultados obtenidos de cada uno de los ejercicios propuestos.

</div>
