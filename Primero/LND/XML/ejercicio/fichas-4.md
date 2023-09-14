
<div align="justify">

# Ejercicio calificable

  Dado el siguiente fichero:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
<fichas xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="fichas.xsd">
    <ficha numero="01" letra="Z">
        <codigo>11</codigo>
        <nombre>Ana Sanz Tin</nombre>
    </ficha>
    <ficha numero="02">
        <codigo>12</codigo>
        <nombre>Iker Rubio Mol</nombre>
    </ficha>
</fichas>
  ```

  Escribir el contenido del archivo “fichas.xsd” que permita validarlo, teniendo en cuenta que:
  - Tanto el atributo numero como el elemento “código” utilizan la misma restricción que solamente les
  permite tomar un valor entero expresado con dos dígitos comprendidos entre "00" y "19".
  - El atributo letra puede tomar por valor una de las siguientes letras: "X", "Y" o "Z". La restricción debe
  definirse de forma que solamente pueda ser utilizada por dicho atributo.
  - Para cada ficha se tiene que indicar un número, obligatoriamente. Sin embargo, la letra es opcional.

</div>
