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

  ```

  - Mostrar una tabla con el nombre del disco en verde si el año es posterior al 2000, y en rojo si el año es anterior al 2000.

  ```xml

  ```


## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
