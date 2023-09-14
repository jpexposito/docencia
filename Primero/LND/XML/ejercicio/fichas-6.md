
<div align="justify">

# Ejercicio calificable

  Dado el siguiente fichero:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
      <xs:element name="fichas">
          <xs:complexType>
              <xs:sequence>
                  <xs:element name="ficha" type="infoPersonaAmpliada" maxOccurs="unbounded" />
              </xs:sequence>
          </xs:complexType>
      </xs:element>
      <xs:complexType name="infoPersonaAmpliada">
          <xs:complexContent>
              <xs:extension base="infoPersona">
                  <xs:sequence>
                      <xs:element name="ciudad" type="xs:string" />
                      <xs:element name="pais" type="xs:string" />
                  </xs:sequence>
              </xs:extension>
          </xs:complexContent>
      </xs:complexType>
      <xs:complexType name="infoPersona">
          <xs:sequence>
              <xs:element name="nombre" type="xs:string" />
              <xs:element name="edad" type="edadPersona" />
          </xs:sequence>
          <xs:attribute name="numero" type="xs:integer" />
      </xs:complexType>
      <xs:simpleType name="edadPersona">
          <xs:restriction base="xs:integer">
              <xs:minExclusive value="-1" />
              <xs:maxExclusive value="131" />
          </xs:restriction>
      </xs:simpleType>
  </xs:schema>
  ```

  Añadir, al archivo “fichas.xsd”, la definición de un nuevo elemento complexType llamado “__infoPersonaAmpliada2__” que amplíe la definición de “infoPersonaAmpliada”, permitiendo validar el siguiente documento XML:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <fichas xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="fichas.xsd">
    <ficha numero="1">
        <nombre>Eva</nombre>
        <edad>25</edad>
        <ciudad>París</ciudad>
        <pais>Francia</pais>
        <telefono>999888777</telefono>
    </ficha>
    <ficha numero="2">
        <nombre>Giovanni</nombre>
        <edad>26</edad>
        <ciudad>Florencia</ciudad>
        <pais>Italia</pais>
        <telefono>111222333</telefono>
    </ficha>
  </fichas>
  ```  
</div>
