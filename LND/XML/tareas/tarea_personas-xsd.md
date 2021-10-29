<div align="justify">

# Personas

Proporcionar un XML schema que refleje esta jerarquía suponiendo que __nacimiento__ es un elemento opcional y hay al menos una dirección. Para la jerarquía de datos que se muestra a continuación, y teniendo en cuenta los siguientes requisitos:
- Dependiendo de si la persona es _hombre o mujer_, aparecerá en el documento elemento __varón__ (como en el gráfico) o el elemento __hembra__.
- Los valores del atributo __dia__ están comprendidos entre 1 y 31. Definir el tipo __tipoDia__ para ello.
Los valores del atributo __mes__ son de tipo cadena y tienen que coincidir con uno de los meses del año. Definir el tipo __tipoMes__ para ello.
- Los valores del atributo __anyo__ están comprendidos entre 1900 y 2011. Definir el tipo __tipoAnyo__ para ello.
- Los valores de __nombre__, __calle__, __población__ y __provincia__ tienen como máximo 50 caracteres. Definir el tipo __tipoNombre__ para ello.
- El código postal es un entero de 5 dígitos. Definir el tipo __tipoCodPostal__ para ello.


<div align="center">
  <img width="300px" src="https://6d0131f9-a-62cb3a1a-s-sites.googlegroups.com/site/todoxmldtd/ejercicios/enunciados/35-ejercicios-xmlschema-avanzados/ejercicio-xmlschema-avanzado-4-obtener-schema-a-partir-de-una-jerarquia-de-datos/esquema.jpg?attachauth=ANoY7cpAu3b9alheZboWnZDbZhffqL00YS0v2hVeFFvJe54h0cg0XV7nJqk8j-Ti2si2PoftVQYBtF4fpefi69Z9Ks1Hc0wRKYkQc5jFkk3boS8L1rpFlsLyE0T_6X3wtocx467tWxCexEth9mYsQHkDH1NcDdiIVT4Or8e3_vyVh2XlWHYjRl4zIJyenoneoLHpFQ5AY5Lj1UujpFai3sdXtvn108FwM0hvgSvFyFgz65F-wAAuRd8lwM6j5VQuQfDdsVH2wD1kaDsNzQNniB4mvWAS2Qq_hoqxf5ZDxRyz4RJug3qjGKJaBNEnEnx90JsX7ODDN1kCxghVRw6PEERFOSgBBfYT8FhEUwmJ9F-NZS6syNhtJ4ozj-x7uWN-sdHMaOUw_OLFKXuBjfU32jRbdaBzCHr0JA%3D%3D&attredirects=0">
</div>

  Generar un fichero XML instancia que referencie al schema y contenga los siguientes datos:
  - Elemento 1:
    - Juan Pardo.
    - Fecha de nacimiento: 10 de Abril de 1982
    - Dirección: Caoba, 1, Madrid
    - 28005 Madrid
  - Elemento 2:
    - María López.
    - Dirección1: Roncato,1, Illescas
    - 45200 Toledo
    - Dirección2: Paseo de la Esperanza 15, 1º A, Madrid
    - 28005 Madrid

<!--
<details>
  <summary>PULSA PARA VER LA RESPUESTA CORRECTA:</summary>
```xml
<?xml version='1.0' encoding="ISO-8859-1"?>

<personas xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:noNamespaceSchemaLocation="personas.xsd">
 <persona>
    <nombre>Juan Pardo</nombre>
    <nacimiento dia="10" mes="Abril" anyo="1982"/>
    <direccion>
       <calle>Caoba, 1</calle>
       <poblacion>Madrid</poblacion>
       <provincia>Madrid</provincia>
       <cpostal>28005</cpostal>
    </direccion>
    <varon />
 </persona>
 <persona>
    <nombre>María López</nombre>
    <direccion>
       <calle>Roncato, 1</calle>
       <poblacion>Illescas</poblacion>
       <provincia>Toledo</provincia>
       <cpostal>45200</cpostal>
    </direccion>
    <direccion>
       <calle>Paseo de la Esperanza, 15 - 1º A</calle>
       <poblacion>Madrid</poblacion>
       <provincia>Madrid</provincia>
       <cpostal>28005</cpostal>
    </direccion>
    <hembra />
 </persona>
</personas>
```

con el __xsd__ _personas.xsd_:

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">

 <xsd:simpleType name="tipoDia">
 <xsd:restriction base="xsd:positiveInteger">
 <xsd:minInclusive value="1"/>
 <xsd:maxInclusive value="31"/>
 </xsd:restriction>
 </xsd:simpleType>
   <xsd:simpleType name="tipoMes">
      <xsd:restriction base="xsd:string">
         <xsd:enumeration value="Enero"/>
         <xsd:enumeration value="Febrero"/>
         <xsd:enumeration value="Marzo"/>
  <xsd:enumeration value="Abril"/>
  <xsd:enumeration value="Mayo"/>
  <xsd:enumeration value="Junio"/>
  <xsd:enumeration value="Julio"/>
  <xsd:enumeration value="Agosto"/>
  <xsd:enumeration value="Septiembre"/>
  <xsd:enumeration value="Octubre"/>
  <xsd:enumeration value="Noviembre"/>
  <xsd:enumeration value="Diciembre"/>
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
 <xsd:maxLength value="50"/>
 </xsd:restriction>
 </xsd:simpleType>
 <xsd:simpleType name="tipoCodPostal">
 <xsd:restriction base="xsd:positiveInteger">
 <xsd:totalDigits value="5"/>
 </xsd:restriction>
 </xsd:simpleType>

 <xsd:element name="nombre" type="tipoNombre"/>
 <xsd:element name="apellidos" type="tipoNombre"/>
 <xsd:element name="calle" type="tipoNombre"/>
 <xsd:element name="poblacion" type="tipoNombre"/>
 <xsd:element name="provincia" type="tipoNombre"/>

 <xsd:element name="varon"/>
 <xsd:element name="hembra"/>
 <xsd:element name="cpostal" type="tipoCodPostal"/>

 <xsd:element name="nacimiento">
 <xsd:complexType>
 <xsd:simpleContent>
 <xsd:extension base="xsd:string">
 <xsd:attribute name="dia" type="tipoDia"/>
 <xsd:attribute name="mes" type="tipoMes"/>
 <xsd:attribute name="anyo" type="tipoAnyo"/>
 </xsd:extension>
 </xsd:simpleContent>
 </xsd:complexType>
 </xsd:element>

 <xsd:element name="direccion">
 <xsd:complexType>
 <xsd:sequence>
 <xsd:element ref="calle" maxOccurs="unbounded"/>
 <xsd:element ref="poblacion" maxOccurs="unbounded"/>
 <xsd:element ref="provincia" maxOccurs="unbounded"/>
 <xsd:element ref="cpostal" maxOccurs="unbounded"/>
 </xsd:sequence>
 </xsd:complexType>
 </xsd:element>

 <xsd:element name="personas">
 <xsd:complexType>
 <xsd:sequence>
 <xsd:element ref="persona" maxOccurs="unbounded"/>
 </xsd:sequence>
 </xsd:complexType>
 </xsd:element>

 <xsd:element name="persona">
 <xsd:complexType>
 <xsd:sequence>
 <xsd:element ref="nombre"/>
 <xsd:element ref="nacimiento" minOccurs="0" maxOccurs="1"/>
 <xsd:element ref="direccion" maxOccurs="unbounded"/>
 <xsd:choice>
 <xsd:element ref="varon"/>
 <xsd:element ref="hembra"/>
 </xsd:choice>
 </xsd:sequence>
 </xsd:complexType>
 </xsd:element>

</xsd:schema>
```

</details>
-->

</div>
