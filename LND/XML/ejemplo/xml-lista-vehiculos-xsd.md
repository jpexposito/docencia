<div align="justify">

# Ejercicio Clase Lista Notas


<div align="center">
  <img width="300px" src="https://www.e4e-soluciones.com/wp-content/uploads/2020/04/factura-de-la-luz-1000x675.jpg">
</div>

## Se pide

  Definir una XSD que valide el documento XML que se muestra a continuación.

  Ejemplo de xml:

  ```xml
  <?xml version="1.0" encoding="ISO-8859-1"?>
  <vehiculos  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:noNamespaceSchemaLocation="XMLSchemaBasicos02_todoterrenos.xsd">
    <vehiculo>
      <nombre>Count Zero</nombre>
      <modelo>Series I, 80"</modelo>
      <fabricacion>
        <inicio>
          <dia>21</dia>
          <mes>July</mes>
          <anyo>1949</anyo>
        </inicio>
        <fin>
          <dia>9</dia>
          <mes>August</mes>
          <anyo>1949</anyo>
        </fin>
      </fabricacion>
      <modificaciones>
        <modificacion>Change Engine</modificacion>
        <modificacion>Change pedals</modificacion>
        <modificacion>Change gearbox</modificacion>
        <modificacion>Fit Rollcage</modificacion>
      </modificaciones>
    </vehiculo>
  </vehiculos>
  ```
<!--
 <details>
   <summary>PULSA PARA VER LA RESPUESTA:</summary>

 ```xml
 <?xml version = "1.0" encoding="ISO-8859-1"?>
<xsd:schema xmlns:xsd = "http://www.w3.org/2001/XMLSchema">
  <xsd:element name = "vehiculos">
   <xsd:complexType>
    <xsd:sequence>
     <xsd:element ref = "vehiculo" maxOccurs = "unbounded"/>
    </xsd:sequence>
   </xsd:complexType>
  </xsd:element>

  <xsd:element name = "vehiculo">
   <xsd:complexType>
    <xsd:sequence>
     <xsd:element name = "nombre" type = "xsd:string" maxOccurs = "unbounded"/>
     <xsd:element name = "modelo" type = "xsd:string"/>
     <xsd:element name = "fabricacion">
      <xsd:complexType>
       <xsd:sequence>
        <xsd:element ref = "inicio"/>
        <xsd:element ref = "fin"/>
       </xsd:sequence>
      </xsd:complexType>
     </xsd:element>
     <xsd:element name = "modificaciones">
      <xsd:complexType>
       <xsd:sequence>
        <xsd:element name = "modificacion" type = "xsd:string" maxOccurs = "unbounded"/>
       </xsd:sequence>
      </xsd:complexType>
     </xsd:element>
    </xsd:sequence>
   </xsd:complexType>
  </xsd:element>

  <xsd:element name = "inicio">
   <xsd:complexType>
    <xsd:sequence>
     <xsd:element ref = "dia"/>
     <xsd:element ref = "mes"/>
     <xsd:element ref = "anyo"/>
    </xsd:sequence>
   </xsd:complexType>
  </xsd:element>

  <xsd:element name = "fin">
   <xsd:complexType>
    <xsd:sequence>
     <xsd:element ref = "dia"/>
     <xsd:element ref = "mes"/>
     <xsd:element ref = "anyo"/>
    </xsd:sequence>
   </xsd:complexType>
  </xsd:element>

  <xsd:element name = "dia" type = "xsd:string"/>
  <xsd:element name = "mes" type = "xsd:string"/>
  <xsd:element name = "anyo" type = "xsd:string"/>

</xsd:schema>

 ```
 </details>
-->

</div>
