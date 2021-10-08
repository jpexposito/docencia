# XML y DTD: Definición de esquemas y vocabularios en XML

## Introducción.

  Una DTD es un documento que define la estructura de un documento XML: los elementos, atributos, entidades, notaciones, etc, que pueden aparecer, el orden y el número de veces que pueden aparecer, cuáles pueden ser hijos de cuáles, etc. El procesador XML utiliza la DTD para verificar si un documento es válido, es decir, si el documento cumple las reglas del DTD.

## Utilización de métodos de definición de documentos XML.

  La DTD o documento de definición de tipos indica el formato que debe tener el documento XML, es decir las etiquetas que serán válidas y las que no para realizar un cierto tipo de documento. La DTD puede definirse en la propia página o en una página aparte.
## Asociación con documentos XML.

  Podemos poner la misma DTD dentro del documento , veamos un ejemplo sencillo:

```xml
<?xml version="1.0" encoding="iso-8859-15"?>
<!DOCTYPE saludo [
  <!ELEMENT saludo (hola,nombre)>
    <!ELEMENT hola (#PCDATA)>
    <!ELEMENT nombre (#PCDATA)>
]>
<saludo>
  <hola>Hola mundo</hola>
  <nombre>Soy Anyelguti</nombre>
</saludo>
```

  Una forma de realizarlo más ordenado sería la siguiente:

```xml
  <?xml version="1.0" encoding="iso-8859-15"?>
  <!DOCTYPE saludo SYSTEM "saludo.dtd">
  <saludo>
    <hola>Hola mundo</hola>
  <nombre>Soy Anyelguti</nombre>
```
  El documento DTD asociado, es decir el archivo saludo.dtd será el siguiente:

```console
<!ELEMENT saludo (hola,nombre)>
   <!ELEMENT hola (#PCDATA)>
   <!ELEMENT nombre (#PCDATA)>
```

  El contenido del "doctype" lo ponemos en un archivo aparte, al cual hacemos referencia en el documento XML.

### Las etiquetas

  Empezamos a ver cómo se construye el documento DTD. Este documento indica qué etiquetas y atributos debe tener el documento XML, y cómo deben ser estas. Empezaremos por las etiquetas:
  - Las etiquetas de XML se indican mediante una etiqueta en DTD que empieza por la palabra __!ELEMENT__.
  - A continuación ponemos el nombre de la etiqueta.
  - Después indicamos el contenido de la etiqueta. Este puede ser:
  - Otras etiquetas : En ese caso indicamos el nombre de las etiquetas entre paréntesis:

    ```console
      <!ELEMENT saludo (hola,nombre)>
    ```

  - En este caso podemos poner una serie de operadores (que veremos más adelante) para indicar cuántas etiquetas de cada nombre podemos poner.
  - Cadena de texto : lo indicaremos mediante la instrucción entre paréntesis (#PCDATA).

  ```console
  <!ELEMENT nombre (#PCDATA)>
  ```

  Elemento vacío : lo indicamos mediante la instrucción EMTPY (sin paréntesis):

  ```console
  <!ELEMENT foto EMPTY>
  ```

  En todos los casos los elementos pueden llevar atributos. Veremos más adelante cómo indicar los atributos en la DTD.


###  Operadores

  En el primero de los casos, cuando una etiqueta tiene etiquetas hijos, la etiqueta principal no puede llevar texto (pero si atributos). Al indicar las etiquetas dependientes dentro del paréntesis debemos indicar las veces que se puede repetir cada etiqueta. De no indicar nada ésta se deberá poner una única vez.
  Los operadores se encargan de indicar lo anterior, y son unos signos que se ponen al final del nombre de cada etiqueta ej:

  ```
  <!ELEMENT direccion (nombre,alias+,telefono*,domicilio?)>
  ```

  En el ejemplo después de algunos nombres de etiquetas dependientes, hemos puesto algunos signos como _+, * , ?_. Estos son los operadores. Veamos qué es lo que significan:
  - Sin operador : la etiqueta debe estar obligatoriamente una sóla vez.
  - \+ : La etiqueta debe aparecer una o más veces (Mínimo una).
  - \* : La etiqueta puede aparecer cero, una, o más veces .
  - \? : La etiqueta puede aparecer cero, o una vez, pero no más de una.
  - \| : En la etiqueta puede haber uno u otro elemento de los indicados, pero sólo uno de ellos, ejemplo:

  ```
  <!ELEMENT telefono (fijo | movil | #PCDATA)>
  ```
  En el último caso podemos elegir poner dentro de la etiqueta "telefono", la etiqueta "fijo", o la etiqueta "movil" o un contenido de texto, pero sólo una cosa de estas tres.

### Los atributos

  En la DTD debemos indicar también qué atributos tiene cada elemento y sus características.

  Inmediatamente después de declarar un elemento debemos declarar sus atributos. Los atributos de un elemento se declaran todos dentro de la misma etiqueta __<!ATTLIST nombre_elemento .... >__ :

```
  <!ELEMENT foto EMPTY>
  <!ATTLIST foto
     ruta CDATA "objetos/avatar.gif"
     comentario CDATA #IMPLIED
     numero ID #REQUIRED
     >
```

  Dentro de la etiqueta , indicamos primero el nombre del elemento al que corresponden los atributos, y después la lista de atributos. Para cada atributo pondremos tres indicadores: El nombre, el tipo y la frecuencia.
  console
  __EL NOMBRE :__ es el nombre que tendrá el atributo.
  __EL TIPO :__ indica qué tipo de contenido podemos poner en el valor del atributo. Éste se indica mediante:
   - CDATA : Podemos poner cualquier texto siempre que esté conforme con las reglas de escritura para XML:
   - comentario CDATA #IMPLIED
   - NMTOKEN : sólo puede contener letras, dígitos, punto [ . ], guión [ - ], subrayado [ _ ] y dos puntos [ : ] valor _NMTOKEN #REQUIRED_
   - NMTOKENS : puede contener los mismos caracteres que _NMTOKEN_ más espacios en blanco. Se entiende por espacios en blanco uno o más espacios, retornos de carro o tabuladores.
   - lista_valores NMTOKENS #REQUIRED
   - ID : Debe cumplir las mismas condiciones que NMTOKEN, pero además debe empezar por una letra, y el valor debe ser distinto en cada uno de los elementos que tengan este atributo.
  _alias ID #REQUIRED_
  - IDREF : el atributo debe ser el mismo que el de otro atributo id indicado anteriormente (referencia a otro elemento).
  _grupo IDREF #IMPLIED_
  - IDREFs : como IDREF pero podemos poner poner más de un elemento como referencia, estos irán separados en el XML simplemente por espacios.
  _grupos IDREF #IMPLIED_
  - (valor1 | valor2 | ... |valorX) : los posibles valores del atributo vienen indicados por una lista de valores. Estos se indican entre paréntesis separados por el signo [ | ].
  sexo (varón | mujer) #REQUIRED
  - LA FRECUENCIA: Aunque aquí lo llamamos así, el tercer identificador que aparece en la declaración de un atributo indica en primer lugar si el atributo es obligatorio o no, y ademas puede indicar su valor por defecto en caso de que no aparezca. Sus posibles valores son:
    - __#REQUIRED__ : El atributo debe ponerse obligatoriamente.
    nombre CDATA #REQUIRED
    - __#IMPLIED__ : El atributo es opcional, puede no ponerse.
    _comentario CDATA #IMPLIED_
    - __"valor_defecto"__ : Se indica entre comillas el valor por defecto del atributo. Caso de no ponerse se entenderá que está puesto con su valor por defecto.
    _ruta CDATA "objetos/avatar.gif"_
    - __#FIXED "valor"__ : El atributo es obligatorio, y además debe tener como valor el indicado después de la palabra #FIXED
    realizacion CDATA #FIXED "anyelguti".

### Validador

  ¿Cómo podemos saber si un documento XML es válido conforme a su DTD? La mayoría de los navegadores no tienen en cuenta si el documento se ajusta a su DTD sino simplemente si el documento está bien formado. Es decir sólo tienen en cuenta que el documento se ajuste a las normas básicas de creación de archivos XML.

  Sin embargo, ya vimos en la primera página de este manual que podemos poner el atributo standalone="yes" en la primera declaración del archivo XML para comprobar si el XML se ajusta a la DTD:

  ```xml
  <?xml version="1.0" encode="UTF-7" standalone="yes"?>
  ```

### Ejemplos

#### Ejemplo 1

  Un instituto necesita registrar los cursos y alumnos que estudian en él y necesita una DTD para comprobar los documentos XML de los programas que utiliza:
  - Tiene que haber un elemento raíz listacursos. Tiene que haber uno o más cursos.
  - Un curso tiene uno o más alumnos.
  - Todo alumno tiene un DNI, un nombre y un apellido, puede que tenga segundo apellido o no.
  - Un alumno escoge una lista de asignaturas donde habrá una o más asignaturas. - Toda asignatura tiene un nombre, un atributo código y un profesor.
  - Un profesor tiene un NRP (Número de Registro Personal), un nombre y un apellido (también puede tener o no un segundo apellido).

  <details>
  	  <summary>PULSA PARA VER LA SOLUCIÓN</summary>
      Un dtd para este ejemplo sería

  ```

  <!ELEMENT listacursos (curso)+>
  <!ELEMENT curso (alumno)+>
  <!ELEMENT alumno (dni, nombre,
                      ap1, ap2?, listaasignaturas)>

  <!ELEMENT listaasignaturas (asignatura+)>
  <!ELEMENT asignatura (nombre, profesor)>
  <!ATTLIST asignatura codigo CDATA #REQUIRED>

  <!ELEMENT profesor (nrp, nombre, ap1, ap2?)>

  <!ELEMENT dni    (#PCDATA)>
  <!ELEMENT nombre (#PCDATA)>
  <!ELEMENT ap1    (#PCDATA)>
  <!ELEMENT ap2    (#PCDATA)>
  <!ELEMENT nrp    (#PCDATA)>
  ```
    Un xml asociado a este ejemplo sería:

  ```xml
  <listacursos>
      <curso>
          <alumno>
              <dni>44e</dni>
              <nombre>Juan</nombre>
              <ap1>Sanchez</ap1>
              <listaasignaturas>
                  <asignatura codigo="LM1">
                      <nombre>Leng marcas</nombre>
                      <profesor>
                          <nrp>8</nrp>
                          <nombre>Oscar</nombre>
                          <ap1>Gomez</ap1>
                      </profesor>
                  </asignatura>
              </listaasignaturas>
          </alumno>
      </curso>
  </listacursos>
  ```

</details>


#### Ejemplo 2

  Un mayorista informático necesita especificar las reglas de los elementos permitidos en las aplicaciones que utiliza en sus empresas, para ello ha indicado los siguientes requisitos:
  - Una entrega consta de uno o más lotes.
  - Un lote tiene uno o más palés
  - Todo palé tiene una serie de elementos: número de cajas, contenido y peso y forma de manipulación.
  - El contenido consta de una serie de elementos: nombre del componente, procedencia (puede aparecer 0, 1 o más países), número de serie del componente, peso del componente individual y unidad de peso que puede aparecer o no.

<!--

  <details>
  	  <summary>PULSA PARA VER LA SOLUCIÓN</summary>
      Observa como en la siguiente DTD se pone procedencia? y dentro de ella pais+. Esto nos permite que si aparece la procedencia se debe especificar uno o más países. Sin embargo si no queremos que aparezca ningun pais, el XML no necesita contener un elemento vacío.

      Un dtd para este ejemplo sería

      ```
      <!ELEMENT entrega (lote+)>
      <!ELEMENT lote (pale+)>
      <!ELEMENT pale (numcajas, contenido, peso, formamanipulacion?)>
      <!ELEMENT numcajas (#PCDATA)>
      <!ELEMENT peso (#PCDATA)>
      <!ELEMENT formamanipulacion (#PCDATA)>
      <!ELEMENT contenido (nombrecomponente, procedencia?,
                              numserie, peso, unidades)>
      <!ELEMENT nombrecomponente (#PCDATA)>
      <!ELEMENT procedencia (pais+)>
      <!ELEMENT pais (#PCDATA)>
      <!ELEMENT numserie (#PCDATA)>
      <!ELEMENT unidades (#PCDATA)>
      ```
      Un xml asociado a este ejemplo sería

      ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <!DOCTYPE entrega SYSTEM "mayorista.dtd">
      <entrega>
        <lote>
              <pale>
                <numcajas>3</numcajas>
                <contenido>
                      <nombrecomponente>Fuentes</nombrecomponente>
                      <numserie>3A</numserie>
                      <peso>2kg</peso>
                      <unidades>50</unidades>
                </contenido>
                <peso>100kg</peso>
                <formamanipulacion>Manual</formamanipulacion>
              </pale>
        </lote>
        <lote>
              <pale>
                <numcajas>2</numcajas>
                <contenido>
                      <nombrecomponente>CPUs</nombrecomponente>
                      <procedencia>
                        <pais>China</pais>
                        <pais>Corea del Sur</pais>
                      </procedencia>
                      <numserie>5B</numserie>
                      <peso>100g</peso>
                      <unidades>1000</unidades>
                </contenido>
                <peso>100kg</peso>
                <formamanipulacion>Manual</formamanipulacion>
              </pale>
        </lote>
      </entrega>
      ```
  </details>

-->


### Ejemplo 3

  Se desea crear un formato de intercambio de datos para una empresa mayorista de libros con el fin de que sus distintos programas puedan manejar la información interna. El formato de archivo debe tener la siguiente estructura:
  - El elemento raíz es __operaciones__.
  - Dentro de __operaciones__ hay uno o más elementos __operacion__.
  - Una __operacion__ puede ser __venta__, __compra__, o cualquier combinación y secuencia de ellas, pero debe haber al menos una.
  - Una venta tiene dentro un elemento __titulosvendidos__. Dentro de __titulosvendidos__ se almacenan estos datos:
    - Uno o más elementos __título__.
    - La cantidad total de libros vendidos.
    - Puede haber un elemento. __entregado__ que indique si la entrega se ha realizado.
    - Debe haber un elemento importe con un atributo obligatorio. llamado «moneda».
  - Una compra tiene dentro un elemento __tituloscomprados__. Dentro de él hay esto:
    - Uno o más elementos __titulo_.
    - Un __proveedor__.
    - Una fecha de compra, que debe desglosarse en elementos día, mes y año.

  El objetivo final debe ser validar un fichero como este:
```xml
<operaciones>
    <operacion>
        <venta>
            <titulosvendidos>
                <titulo>Don Quijote</titulo>
                <titulo>Rimas y leyendas</titulo>
                <cantidadtotal>2000</cantidadtotal>
                <importe moneda="euros">4400</importe>
            </titulosvendidos>
        </venta>
        <venta>
            <titulosvendidos>
                <titulo>Rinconete y Cortadillo</titulo>
                <titulo>Sainetes</titulo>
                <cantidadtotal>1000</cantidadtotal>
                <entregado/>
                <importe moneda="libras">290</importe>
            </titulosvendidos>
        </venta>
    </operacion>
    <operacion>
        <compra>
            <tituloscomprados>
                <titulo>De la Tierra a la Luna</titulo>
                <titulo>Barbarroja</titulo>
                <proveedor>Editorial EDSA</proveedor>
                <fechacompra>
                    <dia>10</dia>
                    <mes>6</mes>
                    <anio>2018</anio>
                </fechacompra>
            </tituloscomprados>
        </compra>
        <venta>
            <titulosvendidos>
                <titulo>Cinco semanas en globo</titulo>
                <titulo>Sainetes</titulo>
                <cantidadtotal>700</cantidadtotal>
                <entregado/>
                <importe moneda="euros">1490</importe>
            </titulosvendidos>
        </venta>
        <compra>
            <tituloscomprados>
                <titulo>De la Tierra a la Luna</titulo>
                <titulo>Barbarroja</titulo>
                <proveedor>Editorial Recopila</proveedor>
                <fechacompra>
                    <dia>2</dia>
                    <mes>12</mes>
                    <anio>2017</anio>
                </fechacompra>
            </tituloscomprados>
        </compra>
    </operacion>
</operaciones>
```

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN</summary>
    La siguiente DTD valida el fichero arriba mostrado:

    ```
    <!--El elemento raíz es operaciones y dentro de él hay uno o más elementos operación-->
    <!ELEMENT operaciones (operacion+)>
    <!--Una operación puede ser ventas o compras, en cualquier orden y repetidas las veces que sea necesario-->
    <!ELEMENT operacion (venta|compra)+>
    <!ELEMENT venta (titulosvendidos)>
    <!--Una venta tiene uno o más titulos, la cantidad de libros vendidos, puede haber un elemento entregado que indique si la entrega se ha realizado, y debe haber un elemento importe con un atributo obligatorio llamado moneda. -->
    <!ELEMENT titulosvendidos (titulo+, cantidadtotal, entregado?, importe)>
    <!--Antes de que se nos olvide, fabricamos el elemento importe y su atributo moneda-->
    <!ELEMENT importe (#PCDATA)>
    <!ATTLIST importe moneda CDATA #REQUIRED>
    <!--Fabricamos el titulo y la cantidad total-->
    <!ELEMENT titulo (#PCDATA)>
    <!ELEMENT cantidadtotal (#PCDATA)>
    <!--El elemento entregado parece que es un vacío-->
    <!ELEMENT entregado EMPTY>
    <!--Una compra tiene:

    -Uno o más títulos comprados.
    -Nombre de proveedor.
    -Una fecha de compra, que debe desglosarse en elementos día, mes y año -->
    <!ELEMENT compra (tituloscomprados)>
    <!ELEMENT tituloscomprados (titulo+, proveedor, fechacompra)>
    <!ELEMENT proveedor (#PCDATA)>
    <!--Desglosamos la fecha -->
    <!ELEMENT fechacompra (dia, mes, anio)>
    <!ELEMENT dia  (#PCDATA)>
    <!ELEMENT mes  (#PCDATA)>
    <!ELEMENT anio (#PCDATA)>
    ```

</details>


### Ejemplo 4

Un fabricante de tractores desea unificar el formato XML de sus proveedores y para ello ha indicado que necesita que los archivos XML cumplan las siguientes restricciones:
- Un pedido consta de uno o más tractores.
- Un tractor consta de uno o más componentes.
- Un componente tiene los siguientes elementos: nombre del fabricante (atributo obligatorio), fecha de entrega (si es posible, aunque puede que no aparezca, si aparece el dia es optativo, pero el mes y el año son obligatorios). También se necesita saber del componente si es frágil o no. También debe aparecer un elemento peso del componente y dicho elemento peso tiene un atributo unidad del peso (kilos o gramos), un elemento número de serie y puede que aparezca o no un elemento kmmaximos indicando que el componente debe sustituirse tras un cierto número de kilómetros.

Un posible fichero de ejemplo que podría validar sería este:

```xml
<pedido>
    <tractor>
        <componente nombrefabricante="Ebro">
            <fechaentrega>
                <mes>2018</mes> <anio>2018</anio>
            </fechaentrega>
            <fragil/>
            <peso unidad="kg">12</peso>
            <numserie>00A</numserie>
        </componente>
        <componente nombrefabricante="Avia">
            <fechaentrega>
                <dia>12</dia><mes>1</mes><anio>2019</anio>
            </fechaentrega>
            <nofragil/>
            <peso unidad="g">1450</peso>
            <numserie>00D</numserie>
            <kmmaximos>25000</kmmaximos>
        </componente>
    </tractor>
    <tractor>
        <componente nombrefabricante="John Deere">
            <fragil/>
            <peso unidad="g">770</peso>
            <numserie>43Z</numserie>
        </componente>
    </tractor>
</pedido>
```
<!--
<details>
  <summary>PULSA PARA VER LA SOLUCIÓN</summary>
    La siguiente DTD valida el fichero arriba mostrado:

```
<!ELEMENT pedido     (tractor)+>
<!ELEMENT tractor    (componente)+>
<!ELEMENT componente (fechaentrega?, (fragil|nofragil),
                      peso, numserie, kmmaximos?)>

<!ELEMENT fechaentrega (dia?, mes, anio)>
<!ELEMENT dia      (#PCDATA)>
<!ELEMENT mes      (#PCDATA)>
<!ELEMENT anio     (#PCDATA)>
<!ELEMENT fragil   EMPTY>
<!ELEMENT nofragil EMPTY >
<!ELEMENT peso     (#PCDATA)>
<!ATTLIST peso unidad CDATA #REQUIRED>
<!ELEMENT numserie  (#PCDATA)>
<!ELEMENT kmmaximos (#PCDATA)>
<!ATTLIST componente nombrefabricante CDATA #REQUIRED>
```

</details>

-->

## Herramientas de creación y validación.

  Existen numerosas herramientas de validación, algunas de ellas online y con estas trabajaremos:
  - http://xmlvalidator.new-studio.org/
  - https://www.w3schools.com/xml/xml_validator.asp
  - https://www.xmlvalidation.com/
