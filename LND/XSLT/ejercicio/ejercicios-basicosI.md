<div align="justify">


<div align="center">
 	<img src="https://ftp.homepage-webhilfe.de/Bilder/Themen/XML/XSLT/Transformation.png">
</div>

</br>

## Ejercicio I XSLT

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ies nombre="IES Francisco de los Rios" web="http://www.iesfranciscodelosrios.es" >
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
  - Mostrar en párrafos cada uno de los nombres de los ciclos.
  - Mostrar en una lista sin numerar los nombres de los ciclos y entre paréntesis su grado.
  - Mostrar en una lista numerada los nombres de los ciclos ordenados alfabéticamente de manera descendente y entre paréntesis su grado.
  - Mostrar en una etiqueta H1 el nombre del instituto y luego en una tabla con su fila encabezado las siguientes columnas, nombre del ciclo y año. Si el año es mayor al 2009 la letra será de color verde, si es igual al 2009 de color azul y si es menor al 2009 de color rojo.


## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
