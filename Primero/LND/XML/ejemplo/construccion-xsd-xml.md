<div align="justify">

# Construcción de un documento XSD en función de un XML

<div align="center">
    <img src="https://www.lego.com/cdn/cs/set/assets/blt3d4f323d762c8a35/10693.jpg?fit=crop&format=jpg&quality=80&width=800&height=600&dpr=1" />
</div>


  Vamos a echar un vistazo a este documento XML llamado __shiporder.xml__ :

```xml
<?xml version=__1.0__ encoding="UTF-8"?>

<shiporder orderid=__889923__
xmlns:xsi=__http://www.w3.org/2001/XMLSchema-instance__
xsi:noNamespaceSchemaLocation=__shiporder.xsd__>
  <orderperson>John Smith</orderperson>
  <shipto>
    <name>Ola Nordmann</name>
    <address>Langgt 23</address>
    <city>4000 Stavanger</city>
    <country>Norway</country>
  </shipto>
  <item>
    <title>Empire Burlesque</title>
    <note>Special Edition</note>
    <quantity>1</quantity>
    <price>10.90</price>
  </item>
  <item>
    <title>Hide your heart</title>
    <quantity>1</quantity>
    <price>9.90</price>
  </item>
</shiporder>
```

  El documento XML anterior consiste en un elemento de la raíz, __shiporder__ , que contiene un atributo necesario llamado __orderid__ . El __shiporder__ elemento contiene tres diferentes elementos hijo: __orderperson__ , __shipto__ y __item__ . El __item__ elemento aparece dos veces, y contiene un __title__ , una opción __note__ elemento, una __quantity__ , y un __price__ elemento.

  La línea anterior: xmlns: xsi = __http://www.w3.org/2001/XMLSchema-instance__ le dice al analizador XML que este documento debe ser validada con un esquema. La línea: xsi: noNamespaceSchemaLocation = __shiporder.xsd__ especifica el lugar donde reside el esquema (here it is in the same folder as __shiporder.xml__) .

## Crear un esquema XML

  Ahora queremos crear un esquema para el documento XML anterior.

  Comenzamos con la apertura de un nuevo archivo que llamaremos __shiporder.xsd__ . Para crear el esquema podríamos simplemente seguir la estructura del documento XML y definir cada elemento como lo encontramos. Vamos a empezar con la declaración XML estándar seguido de la xs: element esquema que define un esquema:

  ```xml
  <?xml version=__1.0__ encoding=__UTF-8__ ?>
  <xs:schema xmlns:xs=__http://www.w3.org/2001/XMLSchema__>
  ...
  </xs:schema>

  ```

  En el esquema anterior se utiliza el espacio de nombres estándar (xs) , y el URI asociado a este espacio de nombres es la definición del lenguaje de esquema, que tiene el valor estándar de http://www.w3.org/2001/XMLSchema.

  A continuación, tenemos que definir el __shiporder__ elemento. Este elemento tiene un atributo y contiene otros elementos, por lo cual consideramos como un tipo complejo. Los elementos secundarios del __shiporder__ elemento está rodeado por un xs: elemento de secuencia que define una secuencia ordenada de elementos sub:

  ```xml
  <xs:element name="shiporder">
    <xs:complexType>
      <xs:sequence>
        ...
      </xs:sequence>
    </xs:complexType>
  </xs:element>

  ```

  Entonces tenemos que definir el __orderperson__ elemento como un tipo simple (porque no contiene ningún atributo o de otros elementos). El tipo (xs:string) es precedido por el prefijo de espacio de nombres asociado con el esquema XML que indica un esquema predefinido tipo de datos:

  ```xml
  <xs:element name="orderperson" type="xs:string"/>
  ```
  A continuación, tenemos que definir dos elementos que son del tipo complejo: __shipto__ y __item__ . Comenzamos definiendo la __shipto__ elemento:

  ```xml
  <xs:element name="shipto">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="name" type="xs:string"/>
        <xs:element name="address" type="xs:string"/>
        <xs:element name="city" type="xs:string"/>
        <xs:element name="country" type="xs:string"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>

  ```

  Con esquemas podemos definir el número de posibles ocurrencias de un elemento con los maxOccurs y atributos minOccurs. maxOccurs especifica el número máximo de ocurrencias de un elemento y minOccurs especifica el número mínimo de ocurrencias de un elemento. El valor predeterminado para ambos maxOccurs y minOccurs es 1!

  Ahora podemos definir el __item__ elemento. Este elemento puede aparecer varias veces dentro de un __shiporder__ elemento. Esto se especifica mediante el establecimiento de la maxOccurs atributo del __item__ elemento __unbounded__ lo que significa que no puede haber tantas ocurrencias del __item__ elemento como desee el autor. Observe que la __note__ elemento es opcional. Hemos especificado esta configurando los minOccurs atribuyen a cero:

  ```xml
  <xs:element name="item" maxOccurs="unbounded">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="title" type="xs:string"/>
        <xs:element name="note" type="xs:string" minOccurs="0"/>
        <xs:element name="quantity" type="xs:positiveInteger"/>
        <xs:element name="price" type="xs:decimal"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
  ```

  Ahora podemos declarar el atributo de la __shiporder__ elemento. Dado que este es un atributo necesario especificamos uso = __required__.

___Note: Las declaraciones de atributos siempre deben ir en último lugar___:

  ```xml
  <xs:attribute name="orderid" type="xs:string" use="required"/>
  ```
  Aquí está la lista completa del archivo de esquema llamado __shiporder.xsd__ :

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

  <xs:element name="shiporder">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="orderperson" type="xs:string"/>
        <xs:element name="shipto">
          <xs:complexType>
            <xs:sequence>
              <xs:element name="name" type="xs:string"/>
              <xs:element name="address" type="xs:string"/>
              <xs:element name="city" type="xs:string"/>
              <xs:element name="country" type="xs:string"/>
            </xs:sequence>
          </xs:complexType>
        </xs:element>
        <xs:element name="item" maxOccurs="unbounded">
          <xs:complexType>
            <xs:sequence>
              <xs:element name="title" type="xs:string"/>
              <xs:element name="note" type="xs:string" minOccurs="0"/>
              <xs:element name="quantity" type="xs:positiveInteger"/>
              <xs:element name="price" type="xs:decimal"/>
            </xs:sequence>
          </xs:complexType>
        </xs:element>
      </xs:sequence>
      <xs:attribute name="orderid" type="xs:string" use="required"/>
    </xs:complexType>
  </xs:element>
  </xs:schema>
  ```

## Se divide el esquema

  El método de diseño anterior es muy simple, pero puede ser difícil de leer y mantener cuando los documentos son complejas.

  El siguiente método de diseño se basa en la definición de todos los elementos y atributos en primer lugar, y luego referirse a ellos mediante el ref atributo.

  Aquí está el nuevo diseño del archivo de esquema (__shiporder.xsd__) :

```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

  <!-- definition of simple elements -->
  <xs:element name="orderperson" type="xs:string"/>
  <xs:element name="name" type="xs:string"/>
  <xs:element name="address" type="xs:string"/>
  <xs:element name="city" type="xs:string"/>
  <xs:element name="country" type="xs:string"/>
  <xs:element name="title" type="xs:string"/>
  <xs:element name="note" type="xs:string"/>
  <xs:element name="quantity" type="xs:positiveInteger"/>
  <xs:element name="price" type="xs:decimal"/>

  <!-- definition of attributes -->
  <xs:attribute name="orderid" type="xs:string"/>

  <!-- definition of complex elements -->
  <xs:element name="shipto">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="name"/>
        <xs:element ref="address"/>
        <xs:element ref="city"/>
        <xs:element ref="country"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>

  <xs:element name="item">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="title"/>
        <xs:element ref="note" minOccurs="0"/>
        <xs:element ref="quantity"/>
        <xs:element ref="price"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>

  <xs:element name="shiporder">
    <xs:complexType>
      <xs:sequence>
        <xs:element ref="orderperson"/>
        <xs:element ref="shipto"/>
        <xs:element ref="item" maxOccurs="unbounded"/>
      </xs:sequence>
      <xs:attribute ref="orderid" use="required"/>
    </xs:complexType>
  </xs:element>

  </xs:schema>

  ```

### Uso de tipos con nombre

El tercer método de diseño define las clases o tipos, que nos permite reutilizar definiciones de elementos. Esto se hace nombrando los elementos simpleTypes y complexTypes, y luego apunte a ellos a través del type atributo del elemento.

Aquí es el tercer diseño del archivo de esquema (__shiporder.xsd__) :

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

  <xs:simpleType name="stringtype">
    <xs:restriction base="xs:string"/>
  </xs:simpleType>

  <xs:simpleType name="inttype">
    <xs:restriction base="xs:positiveInteger"/>
  </xs:simpleType>

  <xs:simpleType name="dectype">
    <xs:restriction base="xs:decimal"/>
  </xs:simpleType>

  <xs:simpleType name="orderidtype">
    <xs:restriction base="xs:string">
      <xs:pattern value="[0-9]{6}"/>
    </xs:restriction>
  </xs:simpleType>

  <xs:complexType name="shiptotype">
    <xs:sequence>
      <xs:element name="name" type="stringtype"/>
      <xs:element name="address" type="stringtype"/>
      <xs:element name="city" type="stringtype"/>
      <xs:element name="country" type="stringtype"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="itemtype">
    <xs:sequence>
      <xs:element name="title" type="stringtype"/>
      <xs:element name="note" type="stringtype" minOccurs="0"/>
      <xs:element name="quantity" type="inttype"/>
      <xs:element name="price" type="dectype"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="shipordertype">
    <xs:sequence>
      <xs:element name="orderperson" type="stringtype"/>
      <xs:element name="shipto" type="shiptotype"/>
      <xs:element name="item" maxOccurs="unbounded" type="itemtype"/>
    </xs:sequence>
    <xs:attribute name="orderid" type="orderidtype" use="required"/>
  </xs:complexType>

  <xs:element name="shiporder" type="shipordertype"/>

  </xs:schema>

  ```

  El elemento de restricción indica que el tipo de datos se deriva de un tipo de datos de espacio de nombres __W3C__ esquema XML. Por lo tanto, el siguiente fragmento significa que el valor del elemento o atributo debe ser un valor de cadena:

  ```xml
    <xs:restriction base="xs:string">
  ```

  El elemento de restricción se utiliza más a menudo para aplicar restricciones a los elementos. Mira las siguientes líneas del siguiente esquema:

  ```xml
  <xs:simpleType name="orderidtype">
    <xs:restriction base="xs:string">
      <xs:pattern value="[0-9]{6}"/>
    </xs:restriction>
  </xs:simpleType>
  ```

  Esto indica que el valor del elemento o atributo debe ser una cadena, debe ser exactamente seis caracteres en una fila, y los caracteres debe ser un número del 0 al 9.
