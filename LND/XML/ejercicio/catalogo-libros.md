<div align="justify">

# CATALOGO DE LIBROS


<div align="center">
  <img width="300px" src="https://estaticos.muyinteresante.es/uploads/images/test/5899d3b75cafe85ef18b4568/test-libros0.jpg">
</div>

## Descripción del Ejercicio

Convertir el DTD que se muestra a continuación en un XML schema, teniendo en cuenta lo siguiente:
- El esquema se guarda en un archivo de nombre “catalogo_libros.xsd”.
- Se deben definir dos tipos de datos simples para el mes (“tipoMes”) y el año __(“tipoAnyo”)__, como restricciones del tipo __“positiveInteger”__. El mes tiene que ser un valor comprendido entre __1 y 12__, y el año entre __1900 y 2011__.
También se define el tipo __“tipoNombre”__, que será el utilizado para los elementos __“titulo”__, __“autor”__ y __“editor”__. Se trata de una restricción del tipo “string” en la que los valores tienen entre __0 y 100 caracteres__.
Del mismo modo se define el tipo __“tipoISBN”__, para el elemento _ISBN_, como un tipo string que tiene entre __13 y 17 caracteres__.


  El dtd a utilizar será:
```xml
<!ELEMENT catalogoLibro (libro)*>
<!ELEMENT libro (titulo, autor+, fecha, ISBN, editor)>
<!ATTLIST libro
categoria (autobiografia | noficcion | ficcion) #REQUIRED
enstock (true | false) “false”
revisor CDATA “”>
<!ELEMENT titulo (#PCDATA)>
<!ELEMENT autor (#PCDATA)>
<!ELEMENT fecha(mes?, anyo)>
<!ELEMENT ISBN (#PCDATA)>
<!ELEMENT editor (#PCDATA)>
<!ELEMENT mes (#PCDATA)>
<!ELEMENT anyo (#PCDATA)>
```
Se pide realizar el fichero __xsd__, que realice la validación, con las restricciones indicadas.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN CORRECTA:</summary>

  - Un xsd válido sería:

  ```xml
  <?xml version="1.0" encoding="ISO-8859-1"?>
    <xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema"
    elementFormDefault="qualified"
    attributeFormDefault="qualified">

    <xsd:simpleType name="tipoMes">
      <xsd:restriction base="xsd:positiveInteger">
      <xsd:minInclusive value="1"/>
      <xsd:maxInclusive value="12"/>
      </xsd:restriction>
    </xsd:simpleType>

    <xsd:simpleType name="tipoAnyo">
      <xsd:restriction base="xsd:positiveInteger">
      <xsd:minInclusive value="1900"/>
      <xsd:maxInclusive value="2011"/>
      </xsd:restriction>
    </xsd:simpleType>

    <xsd:simpleType name="tipoNombre">
      <xsd:restriction base="xsd:string">
      <xsd:minLength value="0"/>
      <xsd:maxLength value="100"/>
      </xsd:restriction>
    </xsd:simpleType>

    <xsd:simpleType name="tipoISBN">
      <xsd:restriction base="xsd:string">
      <xsd:minLength value="13"/>
      <xsd:maxLength value="17"/>
      </xsd:restriction>
    </xsd:simpleType>

    <xsd:element name="titulo" type="tipoNombre"/>
    <xsd:element name="autor" type="tipoNombre"/>
    <xsd:element name="mes" type="tipoMes"/>
    <xsd:element name="anyo" type="tipoAnyo"/>
    <xsd:element name="ISBN" type="tipoISBN"/>
    <xsd:element name="editor" type="tipoNombre"/>

    <xsd:element name="fecha">
      <xsd:complexType>
      <xsd:sequence>
      <xsd:element ref="mes" minOccurs="0" maxOccurs="1"/>
      <xsd:element ref="anyo"/>
      </xsd:sequence>
      </xsd:complexType>
    </xsd:element>

    <xsd:element name="libro">
      <xsd:complexType>
      <xsd:sequence>
      <xsd:element ref="titulo" minOccurs="0" maxOccurs="unbounded"/>
      <xsd:element ref="autor" maxOccurs="unbounded"/>
      <xsd:element ref="fecha"/>
      <xsd:element ref="ISBN"/>
      <xsd:element ref=":editor"/>
      </xsd:sequence>
      <xsd:attribute name="categoria" use="required">
      <xsd:simpleType>
      <xsd:restriction base="xsd:string">
      <xsd:enumeration value="autobiografia"/>
      <xsd:enumeration value="noficcion"/>
      <xsd:enumeration value="ficcion"/>
      </xsd:restriction>
      </xsd:simpleType>
      </xsd:attribute>
      <xsd:attribute name="enstock" type="xsd:boolean" default="false"/>
      <xsd:attribute name="revisor" type="xsd:string" default=""/>
      </xsd:complexType>
    </xsd:element>

    <xsd:element name="catalogoLibros">
      <xsd:complexType>
      <xsd:sequence>
      <xsd:element ref="cat:libro" minOccurs="0" maxOccurs="unbounded"/>
      </xsd:sequence>
      </xsd:complexType>
      </xsd:element>
  </xsd:schema>
  ```

</details>


</div>
