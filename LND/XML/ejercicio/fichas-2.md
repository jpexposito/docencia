
<div align="justify">

# Ejercicio calificable

  Dado el siguiente fichero:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
<fichas xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="fichas.xsd">
    <ficha numero="1">
        <nombre>Ana Sanz Tin</nombre>
        <edad>22</edad>
    </ficha>
    <ficha numero="2">
        <nombre>Iker Rubio Mol</nombre>
        <edad>23</edad>
    </ficha>
</fichas>
  ```
  Escribir el contenido del archivo __“fichas.xsd”__ que permita validarlo, teniendo en cuenta que se debe definir la __“edad”__ con la restricción de que el valor que tome no pueda ser menor que 0 ni mayor que 130. Además, en vez de __xs:minInclusive__ y __xs:maxInclusive__, se debe utilizar:
  - xs:minExclusive que sirve para especificar que el valor debe ser mayor que el indicado.
  - xs:maxExclusive que sirve para especificar que el valor debe ser menor que el indicado.
