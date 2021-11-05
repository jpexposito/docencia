<div align="justify">

# Validar Persona

Escribir un XML Schema para el siguiente documento XML, e incluir los cambios necesarios en el mismo para referenciar al esquema creado. Se debe cumplir también lo siguiente:
- Todos los elementos que aparecen en el documento instancia de abajo son obligatorios y deben aparecer siempre en el mismo orden.
- Se deben definir dos tipos de datos, __tipoPersona__ (los elementos __persona__ son de este tipo) __info__ (los elementos “datos” son de este tipo).
- El atributo __nacimiento__ es de tipo __date__.
- El elemento __comentario__ no es obligatorio; si aparece lo hace sólo 1 vez.

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<persona nacimiento="1999-10-20">
	<datos>
		<nombre>Pepe</nombre>
		<apellidos>Garcia</apellidos>
		<dni>25390952</dni>
	</datos>
	<comentario>buena gente...</comentario>
</persona>


<details>
  <summary>PULSA PARA VER LA SOLUCIÓn CORRECTA:</summary>
  - Un xsd válido sería:

  ```xml
  <?xml version = "1.0" encoding="ISO-8859-1"?>
<xsd:schema xmlns:xsd = "http://www.w3.org/2001/XMLSchema">
	<xsd:element name="persona" type="tipoPersona"/>
	<xsd:element name="comentario" type="xsd:string"/>
	<xsd:complexType name="tipoPersona">
		<xsd:sequence>
			<xsd:element name="datos"     type="info"/>
			<xsd:element ref="comentario" minOccurs="0"/>
		</xsd:sequence>
		<xsd:attribute name="nacimiento" type="xsd:date"/>
	</xsd:complexType>
	<xsd:complexType name="info">
		<xsd:sequence>
			<xsd:element name="nombre"    type="xsd:string"/>
			<xsd:element name="apellidos" type="xsd:string"/>
			<xsd:element name="dni"       type="xsd:string"/>
		</xsd:sequence>
	</xsd:complexType>
</xsd:schema>
</details>
  ```
