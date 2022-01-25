
<div align="justify">

# Ejercicio calificable

  Dado el siguiente fichero:

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

  Escribir el contenido del archivo “fichas.xsd” que permita validarlo, teniendo en cuenta que el elemento “clave” debe poder tomar por valor un mínimo de cuatro caracteres y un máximo de diez. Dichos caracteres pueden ser indistintamente letras mayúsculas o minúsculas de la "a" a la "z", o dígitos del "0" al "9". La restricción solamente podrá aplicarse al elemento “clave”. Para ello, se debe utilizar xs:pattern y también:
  - xs:minLength que permite especificar la longitud mínima.
  - xs:maxLength que permite especificar la longitud máxima.
  
</div>
