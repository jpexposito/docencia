<div align="justify">

# Matrícula Alumnos

  Dado el siguiente __xml__ de __matrículas de alumnos del centro__, se pide realizar un __xsd__ para la contrucción correcta del xml:

  ```xml
  <?xml version="1.0" encoding="ISO-8859-1"?>
<!DOCTYPE matricula SYSTEM "matricula.xsd">
<matricula>
  <personal>
    <dni>99223366M</dni>
    <nombre>Juan Pardo Martín</nombre>
    <titulacion>Ingeniería Informática</titulacion>
    <curso_academico>1997/1998</curso_academico>
    <domicilios>
      <domicilio tipo="familiar">
        <nombre>C/ Principal nº1</nombre>
      </domicilio>
      <domicilio tipo="habitual">
        <nombre>C/ Secundaria nº2</nombre>
      </domicilio>
    </domicilios>
  </personal>
  <pago>
    <tipo_matricula>Matrícula Ordinaria</tipo_matricula>
  </pago>
</matricula>
  ```

  Se pide la creación del fichero __matricula.xsd__.


<details>
    <summary>PULSA PARA VER LA RESPUESTA:</summary>

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
    <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

          <xs:element name="matricula" type="tMatricula"/>
          <xs:complexType name="tMatricula">
            <xs:sequence>
              <xs:element name="personal" type="tPersonal"/>
              <xs:element name="pago" type="tPago"/>
            </xs:sequence>
          </xs:complexType>

          <xs:complexType name="tPersonal">
            <xs:all>
              <xs:element name="dni" type="xs:string"/>
              <xs:element name="nombre" type="xs:string"/>
              <xs:element name="titulacion" type="xs:string"/>
              <xs:element name="curso_academico" type="xs:string"/>
              <xs:element name="domicilios" type="tDomicilios"/>
            </xs:all>
          </xs:complexType>

          <xs:complexType name="tPago">
            <xs:all>
              <xs:element name="tipo_matricula" type="xs:string"/>
            </xs:all>
          </xs:complexType>

          <xs:complexType name="tDomicilios">
            <xs:sequence>
              <xs:element name="domicilio" type="tDomicilio" maxOccurs="unbounded"/>
            </xs:sequence>
          </xs:complexType>
          <xs:complexType name="tDomicilio">
           <xs:sequence>
             <xs:element name="nombre" type="xs:string"/>
           </xs:sequence>
            <xs:attribute name="tipo" type="xs:string"/>
        </xs:complexType>
    </xs:schema>
```
</details>   
