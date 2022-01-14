<div align="justify">

# Ejercicios cortos xml-xsd

<!--
<div align="center">
  <img width="300px" src="https://www.spgtalleres.com/_images/news/248/7562_modal.jpg">
</div>

-->
  El siguiente ejercicio tiene como objetivo trabajar distintos elementos de tipo xml-xsd.

  1. Ejercicio:
    Dado el documento "marcadores.xml":

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
      <marcadores xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:noNamespaceSchemaLocation="marcadores.xsd">
         <pagina>
            <nombre>jpexposito</nombre>
            <descripcion>Profesor de informática.</descripcion>
            <url>http://www.jpexposito.com/</url>
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

    Define el fichero __xsd que realice la validación__.

    <details>
      <summary>PULSA PARA VER LA SOLUCIÓN CORRECTA:</summary>


    </details>

  2. Ejercicio:

  Dado el archivo "personas.xsd":

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xs:element name="personas">
      <xs:complexType>
        <xs:sequence>
          <xs:element name="persona" maxOccurs="unbounded">
            <xs:complexType mixed="true">
              <xs:sequence>
                <xs:element name="nombre" type="xs:string"/>
                <xs:element name="ciudad" type="xs:string"/>
                <xs:element name="edad" type="xs:positiveInteger"/>
              </xs:sequence>
            </xs:complexType>
          </xs:element>
        </xs:sequence>
      </xs:complexType>
    </xs:element>
  </xs:schema>
  ```

  Utilizando los elementos "nombre", "ciudad" y "edad", escribir el código de un documento XML que pueda ser validado por "personas.xsd" y que almacene la siguiente información:
  - "Eva vive en París y tiene 25 años."
  - "Giovanni vive en Florencia y tiene 26 años."

  <details>
    <summary>PULSA PARA VER LA SOLUCIÓN CORRECTA:</summary>


  </details>

  3. Ejercicio:  

  Escribir un XML Schema para el siguiente documento XML, e incluir los cambios necesarios en el mismo para referenciar al esquema creado. Se debe cumplir también lo siguiente:
  - Todos los elementos que aparecen en el documento instancia de abajo son obligatorios y deben aparecer siempre en el mismo orden.
  - Se deben definir dos tipos de datos, “tipoPersona” (los elementos “persona” son de este tipo) “info” (los elementos “datos” son de este tipo).
  - El atributo “nacimiento” es de tipo “date”.
  - El elemento “comentario” no es obligatorio; si aparece lo hace sólo 1 vez.

  ```xml
  <?xml version="1.0" encoding="ISO-8859-1"?>
  <persona nacimiento="1999-10-20" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:noNamespaceSchemaLocation="XMLSchemaBasicos03_persona.xsd"   >
      <datos>
          <nombre>Pepe</nombre>
          <apellidos>Garcia</apellidos>
          <dni>25390952</dni>
      </datos>
      <comentario>buena gente...</comentario>
  </persona>
  ```
  ___Realiza la mejor validación xsd que sea posible___.

  <details>
    <summary>PULSA PARA VER LA SOLUCIÓN CORRECTA:</summary>


  </details>


  4. Ejercicio:

  En el siguiente ejemplo se define un elemento llamado "letras" con la restricción de que puede tomar por valor cero o más (*) letras minúsculas de la _"a"_ a la _"z"_:

  ```xml
  <xs:element name="letras">
     <xs:simpleType>
        <xs:restriction base="xs:string">
           <xs:pattern value="([a-z])*"/>
        </xs:restriction>
     </xs:simpleType>
  </xs:element>
  ```
  __Nota__: los paréntesis de la expresión regular se pueden omitir, escribiendo simplemente: [a-z]*

  Realizar los cambios necesarios en el código del ejemplo anterior para que "letras" pueda tomar por valor uno o más pares (+) de letras, y cada par de letras deberá estar formado por una letra mayúscula seguida de otra minúscula. Por ejemplo, "HoLa" sería admitido, pero no lo sería "Hola", "HOLa", "hola", etc.

  <details>
    <summary>PULSA PARA VER LA SOLUCIÓN CORRECTA:</summary>

  </details>

  5. Ejercicio:

  Dado el siguiente documento XML:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
    <fichas xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:noNamespaceSchemaLocation="fichas.xsd">
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

    Escribir el contenido del archivo __"fichas.xsd"__ que permita validarlo, teniendo en cuenta que el elemento "clave" debe poder tomar por valor un mínimo de cuatro caracteres y un máximo de diez. Dichos caracteres pueden ser indistintamente letras mayúsculas o minúsculas de la "a" a la "z", o dígitos del "0" al "9". La restricción solamente podrá aplicarse al elemento "clave".

    Para ello, se debe utilizar __xs:pattern__ y también:
    - __xs:minLength__ que permite especificar la longitud mínima.
    - __xs:maxLength__ que permite especificar la longitud máxima.

    <details>
      <summary>PULSA PARA VER LA SOLUCIÓN CORRECTA:</summary>
    </details>

    6. Ejercicio:

    Dado el siguiente xml:

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
  <aeropuerto xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="aeropuerto.xsd">
     <nombre>JFK</nombre>
     <vuelos>
        <vuelo código="V22" estado="R">
           <diario />
           <origen>New York</origen>
           <destino>Chicago</destino>
           <hora-salida>09:30:00</hora-salida>
           <hora-llegada>11:30:00</hora-llegada>
        </vuelo>
        <vuelo código="V23" estado="C">
           <origen>New York</origen>
           <destino>Miami</destino>
           <hora-salida>10:15:00</hora-salida>
           <hora-llegada>11:15:00</hora-llegada>
        </vuelo>
     </vuelos>
     <fecha>2013-12-20</fecha>
  </aeropuerto>
  ```

  Escribir el código del archivo "aeropuerto.xsd" que permita validarlo, teniendo en cuenta que:
  - No debe utilizarse ni group ni attributeGroup.
  - El nombre del aeropuerto, los vuelos y la fecha pueden aparecer en distinto orden.
  - Se tiene que indicar que el código ha de ser único (esto se puede hacer definiéndolo de tipo xs:ID) y obligatorio para cada vuelo.
  - Haciendo uso pattern indicar que los posibles estados de un vuelo son C (Cancelado), E (En hora), R (Retrasado). Dicha restricción sólo debe poder ser utilizada por el atributo estado. El valor por defecto debe ser E.
  - Debe permitirse aparecer desde cero hasta ilimitados elementos vuelo y, para cada uno de ellos, se tiene que guardar la información en el mismo orden en el que aparece en el panel.
  - Para indicar si un vuelo es diario, se debe utilizar un elemento vacío que, respecto a cada vuelo, podrá aparecer (en el caso de sí ser diario) o no aparecer (en el caso contrario).
  - Respecto a los elementos nombre, origen, destino, hora-llegada, hora-salida y fecha, cada uno de ellos debe definirse del tipo que se considere más apropiado, de entre los proporcionados por XML Schema.

  <details>
    <summary>PULSA PARA VER LA SOLUCIÓN CORRECTA:</summary>


  </details>
