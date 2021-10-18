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



</div>
