<div align="justify">

# Ejercicio Clase Códigos y Sedes

  - Se necesita tener un esquema que valide un fichero en el que hay un solo elemento llamado __codigo__.

  - Dentro de código hay una cadena con una estructura rígida: 2 letras mayúsculas, seguidas de 2 cifras, seguidas a su vez de 3 letras.

  - El elemento código debe llevar un atributo sede que será de tipo cadena.

## Solución a los códigos y sedes

  Se nos piden dos cosas:
  - Restringir un tipo básico, en este caso el __string__.
  - Extender una etiqueta para que tenga un atributo.
  - Como no se puede hacer a la vez, deberemos dar dos pasos. Primero crearemos un tipo con la restricción y después crearemos un segundo tipo con la extensión.

  Cuando haya conflictos, siempre debemos crear primero la restricción y luego la extensión.

<!--
  <details>
    <summary>PULSA PARA VER LA RESPUESTA:</summary>
    
  Así, creamos primero esto:
  ```xml
  <xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">
      <xsd:element name="codigo" type="tipoCodigoRestringido"/>

      <xsd:simpleType name="tipoCodigoRestringido">
          <xsd:restriction base="xsd:string">
             <xsd:pattern value="[A-Z]{2}[0-9]{2}[A-Z]{3}"/>
          </xsd:restriction>
      </xsd:simpleType>
  </xsd:schema>
  ```
  Y después lo ampliamos para que se convierta en esto:

  ```xml
  <xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">
      <xsd:element name="codigo" type="tipoCodigo"/>

      <xsd:simpleType name="tipoCodigoRestringido">
          <xsd:restriction base="xsd:string">
              <xsd:pattern value="[A-Z]{2}[0-9]{2}[A-Z]{3}"/>
          </xsd:restriction>
      </xsd:simpleType>

      <xsd:complexType name="tipoCodigo">
          <xsd:simpleContent>
              <xsd:extension base="tipoCodigoRestringido">
                  <xsd:attribute name="sede"
                                 type="xsd:string"
                                 use="required"/>
              </xsd:extension>
          </xsd:simpleContent>
      </xsd:complexType>
  </xsd:schema>
  ```
</details>
-->
