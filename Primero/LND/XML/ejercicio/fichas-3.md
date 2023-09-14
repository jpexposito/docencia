
<div align="justify">

# Ejercicio calificable

  Dado el siguiente fichero:

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xs:element name="fichas">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="ficha" maxOccurs="unbounded">
                    <xs:complexType>
                        <xs:sequence>
                            <xs:element name="nombre" type="xs:string" />
                            <xs:element name="iniciales">
                                <xs:simpleType>
                                    <xs:restriction base="xs:string">
                                        <xs:pattern value="[A-Z][A-Z][A-Z]" />
                                    </xs:restriction>
                                </xs:simpleType>
                            </xs:element>
                            <xs:element name="edad" type="xs:integer" />
                        </xs:sequence>
                    </xs:complexType>
                </xs:element>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
</xs:schema>
  ```
Corrige el fichero para que valide el siguiente xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<fichas xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="fichas.xsd">
    <ficha>
        <nombre>Antonio Machado Ruiz</nombre>
        <iniciales>AMR</iniciales>
        <edad>22</edad>
    </ficha>
    <ficha>
        <nombre>Mario Moreno</nombre>
        <iniciales>MM</iniciales>
        <edad>23</edad>
    </ficha>
    <ficha>
        <iniciales>ALO</iniciales>
        <nombre>Ada Lovelace</nombre>
        <edad>24</edad>
    </ficha>
    <ficha>
        <nombre>pablo ruiz picasso</nombre>
        <iniciales>prp</iniciales>
        <edad>24</edad>
    </ficha>
</fichas>
```
