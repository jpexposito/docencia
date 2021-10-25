<div align="justify">

# XSD

## Introducción

  Los esquemas XML son un mecanismo radicalmente distinto de crear reglas para validar ficheros XML. Se caracterizan por:
  - Estar escritos en XML. Por lo tanto, las mismas bibliotecas que permiten procesar ficheros XML de datos permitirían procesar ficheros XML de reglas.
  - Son mucho más potentes:
     - Ofrecen soporte a tipos de datos con comprobación de si el contenido de una etiqueta es de tipo integer, date o de otros tipos.
     - Permite añadir restricciones como indicar valores mínimo y máximo para un número o determinar el patrón que debe seguir una cadena válida.
  - Ofrecen la posibilidad de usar espacios de nombres. Los espacios de nombres son similares a los __paquetes Java__:Permiten a personas distintas el definir etiquetas con el mismo nombre pudiendo luego distinguir etiquetas iguales en función del espacio de nombres que importemos.

## ¿Qué nos aportan?

### Un ejemplo

  Supongamos que deseamos tener ficheros XML con un solo elemento llamado <cantidad> que debe tener dentro un número.

  ```xml
  <cantidad>20</cantidad>
  ```

  Un posible esquema sería el siguiente:

  ```xml
  <xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">
     <xsd:element name="cantidad" type="xsd:integer"/>
  </xsd:schema>

```

### ¿Qué contiene este fichero?

  - _En primer lugar se indica que este fichero va a usar unas etiquetas ya definidas en un espacio de nombres (o XML Namespace, de ahí xmlns). Esa definición se hace en el espacio de nombres que aparece en la URL. Nuestro validador no descargará nada, esa URL es oficial y todos los validadores la conocen_. Las etiquetas de ese espacio de nombres van a usar un prefijo que en este caso será __xsd__. Nótese que el prefijo puede ser como queramos (podría ser __abcd__ o __zztop__), pero la costumbre es usar __xsd__.
  - Se indica que habrá un solo elemento y que el tipo de ese elemento es __<xsd:integer>__. Es decir, un entero básico.


  Si probamos el fichero de esquema con el fichero de datos que hemos indicado veremos que efectivamente el fichero XML de datos es ___válido___. Sin embargo, si en lugar de una cantidad incluyésemos una cadena, veríamos que el fichero ___no se validaría___.


### Tipos de datos básicos

  La figura siguiente (tomada de la web del W3C) ilustra todos los tipos así como sus relaciones de herencia:

<div align="center">
  <img width="300px" src="https://www.w3.org/TR/xmlschema-2/type-hierarchy.gif">
</div>

  Los principales tipos serán:
  - __xsd:byte__: entero de 8 bits.
  - __xsd:short__: entero de 16 bits.
  - __xsd:int__: número entero de 32 bits.
  - __xsd:long__: entero de 64 bits.
  - __xsd:integer__: número entero sin límite de capacidad.
  - __xsd:unsignedByte__: entero de 8 bits sin signo.
  - __xsd:unsignedShort__: entero de 16 bits sin signo.
  - __xsd:unsignedInt__: entero de 32 bits sin signo.
  - __xsd:unsignedLong__: entero de 64 bits sin signo.
  - __xsd:string__: cadena de caracteres en la que los espacios en blanco se respetan.
  - __xsd:normalizedString__: cadena de caracteres en la que los espacios en blanco no se respetan y se reemplazarán secuencias largas de espacios o fines de línea por un solo espacio.
  - __xsd:date__: permite almacenar fechas que deben ir obligatoriamente en formato AAAA-MM-DD (4 digitos para el año, seguidos de un guión, seguido de dos dígitos para el mes, seguidos de un guión, seguidos de dos dígitos para el día del mes)
  - __xsd:time__: para almacenar horas en formato HH:MM:SS.C
  - __xsd:datetime__: mezcla la fecha y la hora separando ambos campos con una T mayúscula. Esto permitiría almacenar 2020-10-17T10:40:22.6.
  - __xsd:duration__. Para indicar períodos. Se debe empezar con ___P___ y luego indicar el número de años, meses, días, minutos o segundos. Por ejemplo ___P1Y4M21DT8H___ indica un período de 1 año, 4 meses, 21 días y 8 horas. Se aceptan períodos negativos poniendo -P en lugar de P.
  - __xsd:boolean__: acepta solo valores ___true___ y ___false___.
  - __xsd:anyURI__: acepta URIs.
  - __xsd:anyType__: es como la clase Object en Java. Será el tipo del cual heredaremos cuando no vayamos a usar ningún tipo especial como tipo padre.

### Derivaciones

  Prácticamente en cualquier esquema XML crearemos tipos nuevos (por establecer un símil es como si programásemos clases Java). Todos nuestros tipos tienen que heredar de otros tipos pero a la hora de «heredar» tenemos más posibilidades que en Java (dondo solo tenemos el ___extends___). En concreto podemos heredar de 4 formas:
  - Poniendo restricciones (restriction). Consiste en tomar un tipo y crear otro nuevo en el que no se puede poner cualquier valor.
  - Extendiendo un tipo (extension). Se toma un tipo y se crea uno nuevo añadiendo cosas a los posibles valores que pueda tomar el tipo inicial.
  - Haciendo listas (lists). Es como crear vectores en Java.
  - Juntando otros tipos para crear tipos complejos (union). Es como crear clases Java en las que añadimos atributos de tipo int, String, etc…

  En general, las dos derivaciones más usadas con diferencia son las restricciones y las extensiones, que se comentan por separado en los puntos siguientes.

### Tipos simples y complejos

  Todo elemento de un esquema debe ser de uno de estos dos tipos.
  - Un elemento es de tipo simple si no permite dentro ni elementos hijo ni atributos.
  - Un elemento es tipo complejo si permite tener dentro otras cosas (que veremos en seguida). Un tipo complejo puede a su vez tener contenido simple o contenido complejo:
    - Los que son de contenido simple no permiten tener dentro elementos hijo pero sí permiten atributos.
    - Los que son de contenido complejo sí permiten tener dentro elementos hijo y atributos.

El diagrama siguiente refleja como funciona la estructuración de tipos de los XML Schema.

![](https://oscarmaestre.github.io/lenguajes_marcas/_images/Esquema-tipos.png)
Así, por ejemplo un tipo simple que no lleve ninguna restricción se puede indicar con el campo type de un element como hacíamos antes:
  ```xml
<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <xsd:element name="cantidad" type="xsd:integer"/>
</xsd:schema>
  ```
Sin embargo, si queremos indicar alguna restricción adicional ya no podremos usar el atributo type. Deberemos reescribir nuestro esquema así:

```xml
<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <xsd:simpleType>
    Aquí irán las restricciones, que hemos omitido por ahora.
   </xsd:simpleType>
</xsd:schema>
  ```

#### Ejercicio:edad de los trabajadores

  Se desea crear un esquema que permita validar la edad de un trabajador, que debe tener un valor entero de entre 16 y 65.

  Por ejemplo, este XML debería validarse:

```xml
<edad>28</edad>
  ```
Pero este no debería validarse:

```xml
<edad>-3</edad>
```
La solución podría ser algo así:

```xml
<xsd:schema
 xmlns:xsd="http://www.w3.org/2001/XMLSchema">
    <xsd:element name="edad"
                 type="tipoEdad"/>
    <xsd:simpleType name="tipoEdad">
        <xsd:restriction base="xsd:integer">
            <xsd:minInclusive value="16"/>
            <xsd:maxInclusive value="65"/>
        </xsd:restriction>
    </xsd:simpleType>
</xsd:schema>
```

##### Ejercicio: peso de productos

Se desea crear un esquema que permita validar un elemento peso, que puede tener un valor de entre 0 y 1000 pero aceptando valores con decimales, como por ejemplo 28.88

Una posible solución sería:

```xml
<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <xsd:element name="peso" type="tipoPeso"/>
  <xsd:simpleType name="tipoPeso">
    <xsd:restriction base="xsd:decimal">
      <xsd:minInclusive value="0"/>
      <xsd:maxInclusive value="1000"/>
    </xsd:restriction>
  </xsd:simpleType>
</xsd:schema>
```

#### Ejercicio: pagos validados

Crear un esquema que permita validar un elemento pago en el cual puede haber cantidades enteras de entre 0 y 3000 euros.

```xml
<xsd:schema
    xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <xsd:element name="pago" type="tipoPago"/>
  <xsd:simpleType name="tipoPago">
    <xsd:restriction base="xsd:integer">
      <xsd:minInclusive value="0"/>
      <xsd:maxInclusive value="3000"/>
    </xsd:restriction>
  </xsd:simpleType>
</xsd:schema>
```

#### Ejercicio: validación de DNIs
  Crear un esquema que permita validar un único elemento dni que valide el patrón de 7-8 cifras + letra que suelen tener los DNI en España:

```xml
<xsd:schema
    xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <xsd:element name="dni" type="tipoDNI"/>
  <xsd:simpleType name="tipoDNI">
    <xsd:restriction base="xsd:string">
      <xsd:pattern value="[0-9]{7,8}[A-Z]"/>
    </xsd:restriction>
  </xsd:simpleType>
</xsd:schema>
```

### Uniendo la herencia y el sistema de tipos

  Llegados a este punto ocurre lo siguiente:

  Por un lado tenemos que especificar si nuestros tipos serán simples o complejos (los cuales a su vez pueden ser complejos con contenido simple o complejos con contenido complejo).

  Por otro lado se puede hacer herencia ampliando cosas (extensión) o reduciendo cosas (restricciones a los valores).

  Se deduce por tanto que no podemos aplicar todas las «herencias» a todos los tipos:

  Los tipos simples no pueden tener atributos ni subelementos, por lo tanto les podremos aplicar restricciones pero nunca la extensión.

  Los tipos complejos (independientemente del tipo de contenido) sí pueden tener otras cosas dentro por lo que les podremos aplicar tanto restricciones como extensiones.

### Restricciones

  Como se ha dicho anteriormente la forma más común de trabajar es crear tipos que en unos casos aplicarán modificaciones en los tipos ya sea añadiendo cosas o restringiendo posibilidades. En este apartado se verá como aplicar restricciones.

  Si queremos aplicar restricciones para un tipo simple las posibles restricciones son:
  - __minInclusive__ para indicar el menor valor numérico permitido.
  - __maxInclusive__ para indicar el mayor valor numérico permitido.
  - __minExclusive__ para indicar el menor valor numérico que ya no estaría permitido.
  - __maxExclusive__ para indicar el mayor valor numérico que ya no estaría permitido.
  - __totalDigits__ para indicar cuantas posibles cifras se permiten.
  - __fractionDigits__ para indicar cuantas posibles cifras decimales se permiten.
  - __length__ para indicar la longitud exacta de una cadena.
  - __minLength__ para indicar la longitud mínima de una cadena.
  - __maxLength__ para indicar la longitud máxima de una cadena.
  - __enumeration__ para indicar los valores aceptados por una cadena.
  - __pattern__ para indicar la estructura aceptada por una cadena.

  Si queremos aplicar restricciones para un tipo complejo con contenido las posibles restricciones son las mismas de antes, pero además podemos añadir el elemento __<attribute>__ así como las siguientes.
  - __sequence__ para indicar una secuencia de elementos
  - __choice__ para indicar que se debe elegir un elemento de entre los que aparecen.

### Atributos

  En primer lugar es muy importante recordar que si queremos que un elemento tenga atributos entonces ya no se puede considerar que sea de tipo simple. Se debe usar ___FORZOSAMENTE___ un __complexType__. Por otro lado en los XML Schema todos los atributos son siempre opcionales, si queremos hacerlos obligatorios habrá que añadir un __«required»__.

  Un atributo se define de la siguiente manera:

  ```
    <xsd:attribute name="fechanacimiento" type="xsd:date" use="required"/>
  ```

  Esto define un atributo llamado nombre que aceptará solo fechas como valores válidos y que además es obligatorio poner siempre.

### Trabajando con Ejemplos

#### Ejemplos 1

  Crear un esquema que permita verificar algo como lo siguiente:

  ```xml
  <cantidad>20</cantidad>
  ```

  Se necesita que la cantidad tenga solo valores aceptables entre -30 y +30.

   <details>
     <summary>PULSA PARA VER LA RESPUESTA:</summary>

     La primera pregunta que debemos hacernos es ¿necesitamos crear un tipo simple o uno complejo?. _Dado que nuestro único elemento no tiene subelementos ni atributos dentro podemos afirmar que solo necesitamos un tipo simple_. (___RECUERDA SIEMPRE UTILIZAR EL MÍNIMO DE MEMORIA POSIBLE___).

     Como aparentemente nuestro tipo necesita usar solo valores numéricos y además son muy pequeños nos vamos a limitar a usar un __short__. Sobre ese short pondremos una restriccion que permita indicar los valores mínimo y máximo.

   ```xml
     <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
      <xs:element name="cantidad">
          <xs:simpleType>
              <xs:restriction base="xs:short">
                  <xs:minInclusive value="-30"/>
                  <xs:maxInclusive value="30"/>
              </xs:restriction>
          </xs:simpleType>
      </xs:element>
    </xs:schema>
   ```

   Este esquema dice que el elemento raíz debe ser cantidad. Luego indica que es un tipo simple y dentro de él indica que se va a establecer una restricción teniendo en mente que se va a «heredar» del tipo short. En concreto se van a poner dos restricciones, una que el valor mínimo debe ser -30 y otra que el valor máximo debe ser 30.

   Existe una alternativa más recomendable, que es separar los elementos de los tipos. De esa manera, se pueden «reutilizar» las definiciones de tipos.

   ```xml
    <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
      <xs:element name="cantidad" type="tipoCantidades">
      </xs:element>
      <xs:simpleType name="tipoCantidades">
              <xs:restriction base="xs:short">
                  <xs:minInclusive value="-30"/>
                  <xs:maxInclusive value="30"/>
              </xs:restriction>
      </xs:simpleType>
      </xs:schema>
   ```
   Obsérvese que hemos puesto el tipo por separado y le hemos dado el nombre __tipoCantidades__. El elemento raíz tiene su nombre y su tipo en la misma línea.

   </details>


#### Ejemplos 2 (Cantidades limitadas con atributo divisa)

  Se desea crear un esquema para validar XML en los que haya un solo elemento raíz llamado cantidad en el que se debe poner siempre un atributo «divisa» que indique en qué moneda está una cierta cantidad. El atributo divisa siempre será una cadena y la cantidad siempre será un tipo numérico que acepte decimales (por ejemplo float). El esquema debe validar los archivos siguientes:

  ```xml
    <cantidad divisa="euro">20</cantidad>
    <cantidad divisa="dolar">18.32</cantidad>

  ```

  Pero no debe validar ninguno de los siguientes:

```xml
  <cantidad>20</cantidad>
  <cantidad divisa="dolar">abc</cantidad>
```

   <details>
     <summary>PULSA PARA VER LA RESPUESTA:</summary>
      Crearemos un tipo llamado __«tipoCantidad»__. Dicho tipo ya no puede ser un simpleType ya que necesitamos que haya atributos. Como no necesitamos que tenga dentro __subelementos__ entonces este complexType llevará dentro un __simpleContent__ (y no un __complexContent__).

      Aparte de eso, como queremos __«ampliar»__ un elemento para que acepte tener dentro un atributo obligatorio __«cantidad»__ usaremos una __<extension>__. Así, el posible esquema sería este:

      ```xml
      <xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">
        <xsd:element name="cantidad" type="tipoCantidad"/>
        <xsd:complexType name="tipoCantidad">
            <xsd:simpleContent>
                <xsd:extension base="xsd:float">
                    <xsd:attribute name="divisa" type="xsd:string" use="required"/>
                </xsd:extension>
            </xsd:simpleContent>
        </xsd:complexType>
      </xsd:schema>
      ```
##### Solución al atributo con solo ciertos valores

  Ahora tendremos que crear dos tipos. Uno para el elemento __cantidad__ y otro para el atributo __divisa__. Llamaremos a estos tipos __tipoCantidad__ y __tipoDivisa__.

  La solución comentada puede encontrarse a continuación. Como puede verse, hemos includo __comentarios__. Pueden insertarse etiquetas annotation que permiten incluir anotaciones de diversos tipos, siendo la más interesante la etiqueta ___documentation___ que nos permite incluir comentarios.

  ```xml
  <xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">
      <xsd:element name="cantidad" type="tipoCantidad"/>
      <xsd:annotation>
          <xsd:documentation>
          A continuación creamos el tipo cantidad
          </xsd:documentation>
      </xsd:annotation>
      <xsd:complexType name="tipoCantidad">
          <xsd:annotation>
              <xsd:documentation>
              Como solo va a llevar atributos debemos
              usar un simpleContent
              </xsd:documentation>
          </xsd:annotation>
          <xsd:simpleContent>
              <xsd:annotation>
                  <xsd:documentation>
                  Como queremos "ampliar" un tipo/clase
                  para que lleve atributos usaremos
                  una extension
                  </xsd:documentation>
              </xsd:annotation>
              <xsd:extension base="xsd:float">
                  <xsd:attribute name="divisa" type="tipoDivisa"/>
              </xsd:extension>
          </xsd:simpleContent>
      </xsd:complexType>
      <xsd:annotation>
          <xsd:documentation>
          Ahora tenemos que fabricar el "tipoDivisa" que indica
          los posibles valores válidos para una divisa. Estas
          posibilidades se crean con una "enumeration". Nuestro
          tipo es un "string" y como vamos a restringir los posibles
          valores usaremos "restriction"
          </xsd:documentation>
      </xsd:annotation>
      <xsd:simpleType name="tipoDivisa">
          <xsd:restriction base="xsd:string">
              <xsd:enumeration value="euros"/>
              <xsd:enumeration value="dolares"/>
              <xsd:enumeration value="yenes"/>
          </xsd:restriction>
      </xsd:simpleType>
  </xsd:schema>
  ```

### Ejercicios propuestos

  Vamos a realizar dos ejercicios para comprobar si el alumno ha entendido los conceptos:
  -[Lista Notas](ejemplo/xml-lista-notas-xsd.md).
  -[Lista Vehículos](ejemplo/xml-lista-vehiculos-xsd.md).

</div>
