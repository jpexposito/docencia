<div align="justify">

# MULTINACIONAL


<div align="center">
  <img src="https://thinkandstart.com/assets/multinacional.jpg">
</div>

## Descripción del Ejercicio

  Una multinacional que opera en bolsa necesita un formato de intercambio de datos para que sus programas intercambien información sobre los mercados de acciones.

  En general todo archivo constará de un listado de cosas como se detalla a continuación:
  - En el listado aparecen siempre _uno o varios futuros, después una o varias divisas, después uno o varios bonos y una o varias letras_.
  - Todos ellos tienen un atributo precio que es obligatorio
  - Todos ellos tienen un elemento vacío que indica de donde es el producto anterior: __Madrid__, __Nueva York__, __Frankfurt__ o __Tokio__.
  - Las divisas y los bonos tienen un atributo optativo que se usa para indicar si el producto ha sido estable en el pasado o no.
  - Un futuro es un valor esperado que tendrá un cierto producto en el futuro. Se debe incluir este producto en forma de elemento. También puede aparecer un elemento mercado que indique el país de procedencia del producto.
  - Todo bono tiene un elemento país_de_procedencia para saber a qué estado pertenece. Debe tener tres elementos extra llamados __valor_deseado__, __valor_mínimo__ y __valor_máximo__ para saber los posibles precios.
  - Las divisas tienen siempre un nombre pueden incluir uno o más tipos de cambio para otras monedas.
  - Las letras tienen siempre un tipo de interés pagadero por un país emisor. El país emisor también debe existir y debe ser siempre de uno de los países cuyas capitales aparecen arriba (es decir __España__, __EEUU__, __Alemania__ y __Japón__.

Se pide realizar el fichero __dtd__ y __xml__ correspondiente, que valide este fichero que cumpla las restricciones indicadas en la descripción.

## Entrega

  Recuerda que debes de crear el informe (con tu interpretación) en __pdf__ junto con el __dtd__ y __xml__ , generando un zip y subirlo a la plataforma.
  La __no entrega en plazo supone la no corrección del ejercicio con la correspondiente nota (0)__

<!--

<div align="center">

  __A TRABAJAR__

  <img width="600px" src="https://aws.admagazine.com/prod/designs/v1/assets/1260x630/96113.jpg">
</div>

-->

<details>
  <summary>PULSA PARA VER LA SOLUCIÓn CORRECTA:</summary>
  - Un xml válido sería:

  ```
  <?xml version="1.0" encoding="utf-8"?>
  <listado>
          <futuro precio="11.28">
                  <producto>Cafe</producto>
                  <mercado>América Latina</mercado>
                  <ciudad_procedencia>
                          <frankfurt/>
                  </ciudad_procedencia>
          </futuro>
          <divisa precio="183">
                  <nombre_divisa>Libra esterlina</nombre_divisa>
                  <tipo_de_cambio>2.7:1 euros</tipo_de_cambio>
                  <tipo_de_cambio>1:0.87 dólares</tipo_de_cambio>
                  <ciudad_procedencia>
                          <madrid/>
                  </ciudad_procedencia>
          </divisa>
          <bono precio="10000" estable="si">
                  <pais_de_procedencia>
                          Islandia
                  </pais_de_procedencia>
                  <valor_deseado>9980</valor_deseado>
                  <valor_minimo>9950</valor_minimo>
                  <valor_maximo>10020</valor_maximo>
                  <ciudad_procedencia>
                          <tokio/>
                  </ciudad_procedencia>
          </bono>
          <letra precio="45020">
                  <tipo_de_interes>4.54%</tipo_de_interes>
                  <pais_emisor>
                          <espania/>
                  </pais_emisor>
                  <ciudad_procedencia>
                          <madrid/>
                  </ciudad_procedencia>
          </letra>
  </listado>
  ```
  - Un dtd válido sería:

  ```
  <!DOCTYPE listado [
          <!ELEMENT listado (futuro+, divisa+, bono+, letra+)>
          <!ATTLIST futuro precio CDATA #REQUIRED>
          <!ATTLIST divisa precio CDATA #REQUIRED>
          <!ATTLIST bono precio CDATA #REQUIRED>
          <!ATTLIST letra precio CDATA #REQUIRED>
          <!ELEMENT ciudad_procedencia (madrid|nyork|frankfurt|tokio)>
          <!ELEMENT madrid EMPTY>
          <!ELEMENT nyork EMPTY>
          <!ELEMENT frankfurt EMPTY>
          <!ELEMENT tokio EMPTY>
          <!ATTLIST divisa estable CDATA #IMPLIED>
          <!ATTLIST bono estable CDATA #IMPLIED>
          <!ELEMENT futuro (producto, mercado?, ciudad_procedencia)>
          <!ELEMENT producto (#PCDATA)>
          <!ELEMENT mercado (#PCDATA)>
          <!ELEMENT bono (pais_de_procedencia,valor_deseado,
                          valor_minimo, valor_maximo, ciudad_procedencia)>
          <!ELEMENT valor_deseado (#PCDATA)>
          <!ELEMENT valor_minimo (#PCDATA)>
          <!ELEMENT valor_maximo (#PCDATA)>
          <!ELEMENT pais_de_procedencia (#PCDATA)>
          <!ELEMENT divisa (nombre_divisa,
                          tipo_de_cambio+, ciudad_procedencia)>
          <!ELEMENT nombre_divisa (#PCDATA)>
          <!ELEMENT tipo_de_cambio (#PCDATA)>
          <!ELEMENT letra (tipo_de_interes, pais_emisor,ciudad_procedencia)>
          <!ELEMENT tipo_de_interes (#PCDATA)>
          <!ELEMENT pais_emisor (espania|eeuu|alemania|japon)>
          <!ELEMENT espania     EMPTY>
          <!ELEMENT eeuu        EMPTY>
          <!ELEMENT alemania    EMPTY>
          <!ELEMENT japon       EMPTY>
  ]>
  ```

</details>


</div>
