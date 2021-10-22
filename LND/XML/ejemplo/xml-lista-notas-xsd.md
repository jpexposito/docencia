<div align="justify">

# Ejercicio Clase Lista Notas


<div align="center">
  <img width="300px" src="https://www.e4e-soluciones.com/wp-content/uploads/2020/04/factura-de-la-luz-1000x675.jpg">
</div>

## Se pide

  Definir una DTD que valide el documento XML que se muestra a continuación.

  Ejemplo de xml:
  ```xml
<lista_de_notas>
  <nota>
    <para>Pedro</para>
    <de>Laura</de>
    <titulo>Recordatorio</titulo>
    <contenido>A las 7:00 pm en la puerta del teatro</contenido>
  </nota>
</lista_de_notas>
  ```
<!--
 <details>
   <summary>PULSA PARA VER LA RESPUESTA:</summary>

 ```xml
 <?xml version="1.0" encoding="ISO-8859-1"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
<xs:element name="nota">
<xs:complexType>
<xs:sequence>
<xs:element name="para" type="xs:string"/>
<xs:element name="de" type="xs:string"/>
<xs:element name="titulo" type="xs:string"/>
<xs:element name="contenido" type="xs:string"/>
</xs:sequence>
</xs:complexType>
</xs:element>
</xs:schema>

 ```
 </details>
-->

</div>
