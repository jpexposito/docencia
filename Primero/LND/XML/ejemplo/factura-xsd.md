<div align="justify">

# Ejercicio de Factura XSD

  Dado el siguiente xml de una factura:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <factura xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:noNamespaceSchemaLocation="factura.xsd"
  número="27" fecha="2013-12-18" moneda="Euro">
     <datos-emisor>
        <nombre>Librería Pérez</nombre>
        <cif>44555666-B</cif>
        <teléfono>777888999</teléfono>
     </datos-emisor>
     <datos-cliente>
        <nombre>Biblioteca Txantrea</nombre>
        <cif>33111222-A</cif>
        <teléfono>333999444</teléfono>
     </datos-cliente>
     <detalle-factura importe="86.12">
        <línea código-artículo="AW7" tipo="Libro">
           <descripción>Analítica Web 2.0</descripción>
           <cantidad>1</cantidad>
           <oferta />
           <pvp>25.12</pvp>
        </línea>
        <línea código-artículo="CP5" tipo="DVD">
           <descripción>Curso de HTML</descripción>
           <cantidad>2</cantidad>
           <pvp>30.5</pvp>
        </línea>
     </detalle-factura>
  </factura>
  ```

  Escribir el código del archivo __"factura.xsd"__ que permita validarlo, teniendo en cuenta que:
  - Exceptuando los elementos datos-emisor, datos-cliente y detalle-factura, que no tienen porqué aparecer en este orden, el resto de elementos representados en el documento XML, sí deben escribirse obligatoriamente en el orden en el que aparecen.
  - Excepto para los hijos directos del elemento factura, siempre que sea posible agrupar al menos dos elementos o dos atributos, se debe usar group o attributeGroup, respectivamente.
  - Respecto al número de la factura (que debe ser un valor entero mayor que 0) y su fecha de emisión (de tipo xs:date), hay que indicar que son atributos obligatorios.
  - El atributo moneda debe indicarse que es un valor fijo.
  - Los nombres del emisor y cliente, así como, la descripción de cada artículo, deben ser del mismo tipo, al que llamaremos tipoTexto, y donde debe indicarse que los valores admitidos para dichos elementos pueden ser cadenas de un mínimo de 5 caracteres y un máximo de 20.
  - Haciendo uso pattern hay que indicar que el valor del cif debe estar formado por una cadena de ocho dígitos del 0 al 9, seguidos de un guión "-" y una letra mayúscula de la "A" a la "Z". Dicha restricción sólo debe poder ser utilizada por el elemento cif.
  - Haciendo uso pattern hay que indicar que el valor del teléfono debe estar formado por una cadena de nueve dígitos del 0 al 9. Dicha restricción sólo debe poder ser utilizada por el teléfono.
  - Al menos tiene que aparecer una línea de detalle y como máximo 15.
  - El importe debe indicarse que es obligatorio.
  - El importe y el pvp deben ser del mismo tipo, al que llamaremos tipoPrecio, y donde debe indicarse, sin hacer uso de pattern, que los valores admitidos por este tipo pueden ser números decimales mayores que 0, pero no mayores que 999. Además, dichos valores podrán contener cinco dígitos como máximo y, de ellos, sólo dos podrán ser decimales.
  - El código del artículo ha de ser único y obligatorio para cada artículo.
  - Sin hacer uso pattern indicar que los posibles tipos de un artículo son Libro, DVD o Varios, no permitiéndose otro valor. Para ello, se debe definir un tipo de dato llamado tipoArtículo, que debe poder ser utilizado por otros atributos o elementos. Ahora bien, hay que tener en cuenta que este atributo es opcional.
  - La cantidad de artículos indicada en cada línea, debe ser un valor entero mayor que 0.
Para indicar si un artículo está de oferta, se debe utilizar un elemento vacío que, respecto a cada artículo, podrá aparecer (en el caso de sí estar de oferta) o no aparecer (en el caso contrario).
No hay que definir más tipos de datos que los especificados en el ejercicio: tipoTexto, tipoArtículo y tipoPrecio.

<!--
<details>
  <summary>PULSA PARA VER LA RESPUESTA:</summary>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

  <xs:element name="factura">
    <xs:complexType>
      <xs:all>

        <xs:element name="datos-emisor">
          <xs:complexType>
            <xs:sequence>
              <xs:group ref="datosEmpresa"/>
            </xs:sequence>
          </xs:complexType>
        </xs:element>

        <xs:element name="datos-cliente">
          <xs:complexType>
            <xs:sequence>
              <xs:group ref="datosEmpresa"/>
            </xs:sequence>
          </xs:complexType>
        </xs:element>

        <xs:element name="detalle-factura">
          <xs:complexType>
            <xs:sequence>
              <xs:element name="línea" maxOccurs="15">
                <xs:complexType>
                  <xs:sequence>
                    <xs:group ref="datosLínea"/>
                  </xs:sequence>
                  <xs:attributeGroup ref="atributosLínea"/>
                </xs:complexType>
              </xs:element>
            </xs:sequence>
            <xs:attribute name="importe" type="tipoPrecio"
             use="required"/>
          </xs:complexType>
        </xs:element>

      </xs:all>
      <xs:attributeGroup ref="atributosFactura"/>
    </xs:complexType>
  </xs:element>

  <xs:group name="datosEmpresa">
    <xs:sequence>
      <xs:element name="nombre" type="tipoTexto"/>
      <xs:element name="cif">
        <xs:simpleType>
          <xs:restriction base="xs:string">
            <xs:pattern value="\d{8}-[A-Z]"/>
          </xs:restriction>
        </xs:simpleType>
      </xs:element>
      <xs:element name="teléfono">
        <xs:simpleType>
          <xs:restriction base="xs:string">
            <xs:pattern value="\d{9}"/>
          </xs:restriction>
        </xs:simpleType>
      </xs:element>
    </xs:sequence>
  </xs:group>

  <xs:group name="datosLínea">
    <xs:sequence>
      <xs:element name="descripción" type="tipoTexto"/>
      <xs:element name="cantidad" type="xs:positiveInteger"/>
      <xs:element name="oferta" minOccurs="0"/>
      <xs:element name="pvp" type="tipoPrecio"/>
    </xs:sequence>
  </xs:group>

  <xs:attributeGroup name="atributosFactura">
    <xs:attribute name="número" type="xs:positiveInteger"
     use="required"/>
    <xs:attribute name="fecha" type="xs:date" use="required"/>
    <xs:attribute name="moneda" fixed="Euro"/>
  </xs:attributeGroup>

  <xs:attributeGroup name="atributosLínea">
    <xs:attribute name="código-artículo" type="xs:ID"
     use="required"/>
    <xs:attribute name="tipo" type="tipoArtículo"/>
  </xs:attributeGroup>

  <xs:simpleType name="tipoTexto">
    <xs:restriction base="xs:string">
      <xs:minLength value="5"/>
      <xs:maxLength value="20"/>
    </xs:restriction>
  </xs:simpleType>

  <xs:simpleType name="tipoArtículo">
    <xs:restriction base="xs:string">
      <xs:enumeration value="Libro"/>
      <xs:enumeration value="DVD"/>
      <xs:enumeration value="Varios"/>
    </xs:restriction>
  </xs:simpleType>  

  <xs:simpleType name="tipoPrecio">
    <xs:restriction base="xs:decimal">
      <xs:minExclusive value="0"/>
      <xs:maxInclusive value="999"/>
      <xs:totalDigits value="5"/>
      <xs:fractionDigits value="2"/>
    </xs:restriction>
  </xs:simpleType>

</xs:schema>
```
-->

</details>
