<div align="justify">

# EJERICICOS REPASO XML


<div align="center">
  <img src="https://cdn.euroinnova.edu.es/img/subidasEditor/trabajador-servicio-coche-musculoso-reparando-vehiculo_146671-19605-1611903989.webp">
</div>


Realiza los siguientes ejercicios sobre el lenguaje de marcas XML.

- Corrige el siguiente documento XML para que esté bien formado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <deportistas>
    <deportista>
      <deporte Atletismo />
      <nombre>Jesse Owens</nombre>
    <deportista>
      <deporte Natación />
      <nombre>Mark Spitz</nombre>
    </deportista>
  </deportistas>
  ```

  <details>
    <summary>PULSA PARA VER LA RESPUESTA:</summary>

  Si trabajamos con un validador, obtendremos:

  _ErrorError at line 4, column 24: not well-formed (invalid token)_.

  En las etiquetas <deporte> (líneas 4 y 7) aparecen los términos Atletismo y Natación sueltos.

  Se podría corregir escribiendo esos términos como valores de un atributo:

  ```xml
  <deporte nombre="Atletismo" />
    ...
  <deporte nombre="Natación" />
  ```
  o como texto dentro de la etiqueta:

  ```xml
    <deporte>Atletismo</deporte>
    ...
    <deporte>Natación</deporte>
  ```

  La primera etiqueta <deportista> no está cerrada.

  _ErrorError at line 10, column 3: mismatched tag_
  Se podría corregir cerrándola:
  ```xml
    <deportista>
      <deporte Atletismo />
      <nombre>Jesse Owens</nombre>
    </deportista>
    <deportista>
   ...
   ```

  Una posible solución sería entonces:
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <deportistas>
    <deportista>
      <deporte nombre="Atletismo" />
      <nombre>Jesse Owens</nombre>
    </deportista>
    <deportista>
      <deporte nombre="Natación" />
      <nombre>Mark Spitz</nombre>
    </deportista>
  </deportistas>
  ```
  ___VERIFICA TU SOLUCIÓN___

  </details>

- Corrige el siguiente documento XML para que esté bien formado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <pelicula>
    <titulo>Con faldas y a lo loco</titulo>
    <director>Billy Wilder</director>
  </pelicula>
  <pelicula>
    <director>Leo McCarey</director>
    <titulo>Sopa de ganso</titulo>
  </pelicula>
  <autor />barto</autor>
  ```
  <details>
    <summary>PULSA PARA VER LA RESPUESTA:</summary>
  No hay una etiqueta raíz que englobe el resto de etiquetas.

  _ErrorError at line 6, column 1: junk after document element_.

  Se podría corregir añadiendo una etiqueta raíz, cuyo nombre puede ser cualquiera, mientras no coincida con otra etiqueta, por ejemplo <peliculas>:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <peliculas>
    <pelicula>
      <titulo>Con faldas y a lo loco</titulo>
   ...
    <autor />barto</autor>
  </peliculas>
  ```
  La primera etiqueta <autor> tiene la barra de las etiquetas vacías, pero luego hay una etiqueta de cierre.
  _ErrorError at line 11, column 17: mismatched tag_.

  Se podría corregir borrando la barra:
  ```xml
  <autor>barto</autor>
  ```
  Una posible solución sería entonces:
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <peliculas>
  <pelicula>
    <titulo>Con faldas y a lo loco</titulo>
    <director>Billy Wilder</director>
  </pelicula>
  <pelicula>
    <director>Leo McCarey</director>
    <titulo>Sopa de ganso</titulo>
  </pelicula>
  <autor>barto</autor>
  </peliculas>
  ```
  ___VERIFICA TU SOLUCIÓN___
  </details>

- Corrige el siguiente documento XML para que esté bien formado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <texto>
    <Titulo>XML explicado a los niños</titulo>
    <párrafo>El <abreviatura>XML</abreviatura>define cómo crear
    lenguajes de marcas.</párrafo>
    <párrafo>Las marcas se añaden a un documento de texto
    para añadir información.</párrafo>
    <http://>www.example.org</http://>
  </texto>
  ```
  <details>
    <summary>PULSA PARA VER LA RESPUESTA:</summary>

  Las etiquetas de apertura y cierre no coinciden

  _ErrorError at line 3, column 38: mismatched tag_.

  Se podría corregir modificando la etiqueta de apertura o la de cierre, por ejemplo:

  ```xml
    <titulo>XML explicado a los niños</titulo>
  ```
  Los caracteres :// no están permitidos en las etiquetas

  _ErrorError at line 8, column 10: not well-formed (invalid token)_.

  Se podría corregir eliminando esos caracteres, por ejemplo:

  ```xml
     <http>www.example.org</http>
  ```

  Una posible solución sería entonces:
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <texto>
    <titulo>XML explicado a los niños</titulo>
    <párrafo>El <abreviatura>XML</abreviatura>define cómo crear
    lenguajes de marcas.</párrafo>
    <párrafo>Las marcas se añaden a un documento de texto
    para añadir información.</párrafo>
    <http>www.example.org</http>
  </texto>
  ```
  ___VERIFICA TU SOLUCIÓN___
  </details>


- Corrige el siguiente documento XML para que esté bien formado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <geografia mundial>
    <pais>
      <pais>España</pais>
      <continente>Europa</continente>
      <capital></capital nombre="Madrid">
    </pais>
  </geografia mundial>
  ```
  <details>
    <summary>PULSA PARA VER LA RESPUESTA:</summary>

  El nombre de las etiquetas no pueden contener espacios:

  _ErrorError at line 2, column 19: not well-formed (invalid token)_

  Se podría corregir modificando la etiqueta de apertura o la de cierre, por ejemplo:

  ```xml
    <geografia_mundial>
      ...
    </geografia_mundial>
  ```
  o

  ```xml
    <geografia-mundial>
      ...
    </geografia-mundial>
  ```
  La etiqueta de cierre no puede contener atributos:

  _ErrorError at line 6, column 24: not well-formed (invalid token)_.

  Se podría corregir escribiendo el valor en el interior de la etiqueta, por ejemplo:
  ```xml
  <capital>Madrid</capital>
  ```
  Una posible solución sería entonces:
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <geografia-mundial>
    <pais>
      <pais>España</pais>
      <continente>Europa</continente>
      <capital>Madrid</capital>
    </pais>
  </geografia-mundial>
```
___VERIFICA TU SOLUCIÓN___

</details>

- Corrige el siguiente documento XML para que esté bien formado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <programas>
    <programa nombre="Firefox" licencia="GPL" licencia="MPL" />
    <programa nombre="OpenOffice.org" licencia=LGPL />
    <programa nombre="Inkscape" licencia="GPL" />
  </programas>
  ```
  <details>
    <summary>PULSA PARA VER LA RESPUESTA:</summary>

  Los atributos no se pueden repetir:

  _ErrorError at line 3, column 45: duplicate attribute_.

  Se podría corregir uniendo los atributos en un único atributo, por ejemplo:

  ```xml
     <programa nombre="Firefox" licencia="GPL MPL" />
  ```
  o duplicando las etiquetas, por ejemplo:
  ```xml
     <programa nombre="Firefox" licencia="GPL" />
     <programa nombre="Firefox" licencia="MPL" />
  ```
  Los valores de los atributos deben ir entre comillas:

  _ErrorError at line 4, column 46: not well-formed (invalid token)_.

  Se podría corregir añadiendo comillas, por ejemplo:
  ```xml
      <programa nombre="Inkscape" licencia="GPL" />
  ```    

  Una posible solución sería entonces:
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <programas>
    <programa nombre="Firefox" licencia="GPL MPL" />
    <programa nombre="LibreOffice" licencia="LGPL" />
    <programa nombre="Inkscape" licencia="GPL" />
  </programas>
  ```
  ___VERIFICA TU SOLUCIÓN___
  </details>

- Corrige el siguiente documento XML para que esté bien formado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <mundiales-de-futbol>
    <mundial>
      <pais="España" />
      <1982 />
    </mundial>
  </mundiales-de-futbol>
  ```
  <details>
    <summary>PULSA PARA VER LA RESPUESTA:</summary>
  Las etiquetas necesitan tener un nombre de etiqueta:

  _ErrorError at line 4, column 10: not well-formed (invalid token)_.

  Se podría corregir añadiendo un nombre de atributo, por ejemplo:

  ```xml
     <pais nombre="España" />
  ```
  o escribiendo el valor como contenido de la etiqueta, por ejemplo:
  ```xml
     <pais>España</pais>
  ```
  Los nombres de etiquetas no pueden empezar por un número:

  _ErrorError at line 5, column 6: not well-formed (invalid token)_.

  Se podría corregir añadiendo un nombre de etiqueta, por ejemplo:
  ```xml
       <año valor="1982" />
  ```
  o escribiendo el valor como contenido de una etiqueta, por ejemplo:
  ```xml
     <año>1982</año>
  ```   
  Una posible solución sería entonces:
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <mundiales-de-futbol>
    <mundial>
      <pais>España</pais>
      <año>1982</año>
    </mundial>
  </mundiales-de-futbol>
  ```
  _Nota_: Además de ello, intenta no utilizar __ñ__.

  ___VERIFICA TU SOLUCIÓN___
  </details>


- Corrige el siguiente documento XML para que esté bien formado:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <mediosDeTransporte>
    <bicicleta velocidad="v<100km/h" />
    <patinete velocidad maxima="50 km/h"
  </mediosDeTransporte>
  ```
  <details>
    <summary>PULSA PARA VER LA RESPUESTA:</summary>

  El carácter inferior a (<) sólo puede utilizarse como inicio de etiqueta:

  _ErrorError at line 3, column 26: not well-formed (invalid token)_.

  Se podría corregir escribiendo la entidad de carácter correspondiente, por ejemplo:
  ```xml
    <bicicleta velocidad="v&lt;100km/h" />
  ```
  Los nombre de atributos no pueden contener espacios:

  _ErrorError at line 4, column 23: not well-formed (invalid token)_.

  Se podría corregir modificando el nombre del atributo, por ejemplo:
  ```xml
    <patinete velocidad-maxima="50 km/h"
  ```
  Las etiquetas deben terminar por el carácter superior a (>):

  _ErrorError at line 5, column 1: not well-formed (invalid token)_.

  Se podría corregir añadiendo los caracteres /> finales, por ejemplo:
  ```xml
    <patinete velocidad-maxima="50 km/h" />
  ```

  Una posible solución sería entonces:
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <mediosDeTransporte>
    <bicicleta velocidad="v&lt;100km/h" />
    <patinete velocidad-maxima="50 km/h" />
  </mediosDeTransporte>
  ```

  ___VERIFICA TU SOLUCIÓN___
  </details>

- Crea un documento XML bien formado que almacene una agenda en la que cada contacto tenga un nombre sólo, y un número aleatorio de emails y teléfonos.

- Crea un documento XML bien formado que almacene la bandeja de entrada de un programa de correo electrónico, en el que cada correo posea la siguiente información: remitente, destinatario, asunto y cuerpo.

- Crea un documento XML bien formado que almacene la bandeja de entrada de un programa de correo electrónico, en el que cada correo posea la siguiente información: remitente (con nombre e email), destinatario (con nombre e email), asunto y cuerpo (por párrafos).

- Crea un documento XML bien formado que almacene los datos que se encuentran en esta hoja de cálculo.

- Crea un documento XML bien formado que almacene los datos que se encuentran en esta base de datos.


___NOTA:EVITA UTILIZAR CARACTERES LATINOS COMO Ñ O ´.___

</div>
