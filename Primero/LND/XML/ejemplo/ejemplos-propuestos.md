<div align="justify">

# Ejemplos propuestos de xml

## Ejemplo 1

```xml
  <?xml version="1.0" encoding="UTF-8"?>
<marcadores xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="marcadores.xsd">
  <pagina>
    <nombre>Abrirllave</nombre>
    <descripcion>Tutoriales de informática.</descripcion>
    <url>http://www.abrirllave.com/</url>
  </pagina>
  <pagina>
    <nombre>Wikipedia</nombre>
    <descripcion>La enciclopedia libre.</descripcion>
    <url>http://www.wikipedia.org/</url>
  </pagina>
  <pagina>
    <nombre>W3C</nombre>
    <descripcion>World Wide Web Consortium.</descripcion>
    <url>http://www.w3.org/</url>
  </pagina>
  </marcadores>
  ```

## Ejemplo 2

  ```xml
<?xml version="1.0" encoding="UTF-8"?>
<fichas xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="fichas.xsd">
  <ficha>
    <nombre>Antonio Machado Ruiz</nombre>
    <iniciales>AMR</iniciales>
    <edad>22</edad>
  </ficha>
  <ficha>
    <nombre>Mario Moreno</nombre>
    <iniciales>MM</iniciales>
    <edad>23</edad>
  </ficha>
  <ficha>
    <iniciales>ALO</iniciales>
    <nombre>Ada Lovelace</nombre>
    <edad>24</edad>
  </ficha>
  <ficha>
    <nombre>pablo ruiz picasso</nombre>
    <iniciales>prp</iniciales>
    <edad>24</edad>
  </ficha>
</fichas>
  ```

## Ejemplo 3

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
  permite tomar un valor entero expresado con dos dígitos comprendidos entre __00__ y __19__.
  - El atributo letra puede tomar por valor una de las siguientes letras: __X__, __Y__ o __Z__. La restricción debe
  definirse de forma que solamente pueda ser utilizada por dicho atributo.
  - Para cada ficha se tiene que indicar un número, obligatoriamente. Sin embargo, la letra es opcional.

## Ejemplo 4

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <fichas xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="fichas.xsd">
    <ficha>
      <nombre>Ana Sanz Tin</nombre>
      <clave>G8w2</clave>
    </ficha>
    <ficha>
      <nombre>Iker Rubio Mol</nombre>
      <clave>ag32Ue7AFF</clave>
    </ficha>
  </fichas>
  ```

  Escribir el contenido del archivo “fichas.xsd” que permita validarlo, teniendo en cuenta que el elemento “clave”
  debe poder tomar por valor un mínimo de cuatro caracteres y un máximo de diez. Dichos caracteres pueden ser
  indistintamente letras mayúsculas o minúsculas de la __a__ a la __z__, o dígitos del __0__ al __9__. La restricción
  solamente podrá aplicarse al elemento “clave”.
  Para ello, se debe utilizar xs:pattern y también:
  - xs:minLength que permite especificar la longitud mínima.
  - xs:maxLength que permite especificar la longitud máxima.

</div>
