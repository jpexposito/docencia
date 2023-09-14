<div align="justify">

# Ejercicio de Factura XSD

  Dado el siguiente xml de un registro de conexiones:


  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
<registro xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:noNamespaceSchemaLocation="registro.xsd">
  <usuario identificador="U123">
    <apellidos-y-nombre>Sanz Tapia,Ana</apellidos-y-nombre>
    <email>asanz@jmail.com</email>
    <conexiones>
      <conexión fecha="2014-02-23" hora="19:15:40">122</conexión>
      <conexión fecha="2014-02-23" hora="20:30:22">617</conexión>
      <conexión fecha="2014-02-24" hora="11:18:31">25</conexión>
    </conexiones>
  </usuario>
  <usuario identificador="U96">
    <apellidos-y-nombre>Ruiz Hierro,Pedro</apellidos-y-nombre>
    <email>pruiz@jotmail.com</email>
    <conexiones>
      <conexión fecha="2014-02-25" hora="20:33:55">390</conexión>
    </conexiones>
  </usuario>
  <empleado identificador="E4">
    <apellidos-y-nombre>Vera Gil,Marta</apellidos-y-nombre>
    <email>mvera@yajoo.es</email>
    <conexiones/>
    <departamento>
      <marketing />
    </departamento>
  </empleado>
</registro>
  ```

  Escribir el código del archivo "registro.xsd" que permita validarlo, teniendo en cuenta que:
  - Todos los elementos y atributos son obligatorios, a menos que se indique lo contrario.
  - Siempre que sea posible agrupar al menos dos elementos o dos atributos, se debe utilizar group o attributeGroup, respectivamente.
  - Pueden aparecer de cero a ilimitados usuarios y, a continuación, de cero a ilimitados empleados.
  - Usuario debe ser de un tipo definido por nosotros al que llamaremos tipoPersona, donde hay que definir los elementos apellidos-y-nombre, email y conexiones. Por otro lado, empleado ha de ser de otro tipo llamado tipoPersonaAmpliado, definido como una extensión de tipoPersona añadiéndosele el elemento departamento. El orden en que tienen que aparecer los elementos hijo de usuario y empleado, debe ser obligatoriamente el escrito en el documento XML.
  - El valor del identificador debe ser una cadena formada por una letra "U" o "E" mayúscula, seguida de uno a cinco dígitos del 0 al 9.
  - El valor del elemento apellidos-y-nombre debe ser una cadena de entre 1 a 30 caracteres (de la "a" a la "z", mayúsculas o minúsculas, o el carácter espacio en blanco) para los apellidos, seguida del carácter coma "," y de entre 1 a otras 20 letras (de la "a" a la "z", también mayúsculas o minúsculas, o el carácter espacio en blanco) para el nombre.
  - El valor del email puede ser una cadena formada por 1 a 15 caracteres de la "a" a la "z", seguida del carácter "@", seguido de entre 1 a otras 25 letras de la "a" a la "z", seguidas del carácter punto "." y de entre otras 2 a 4 letras de la "a" a la "z".
  - De cada usuario y empleado se reflejan sus conexiones, indicando para cada conexión la cantidad de segundos que duró, que debe ser un número entero mayor que cero. Hay que tener en cuenta que, como se puede ver en el documento XML, pueden aparecer desde cero hasta ilimitados elementos conexión.
  - Respecto a los atributos fecha y hora, cada uno de ellos debe definirse del tipo que se considere más apropiado, de entre los proporcionados por XML Schema.
  - Los posibles departamentos de la empresa a los que puede pertenecer un empleado son administración, informática o marketing. De tal forma que, para cada empleado, sólo uno de ellos debe escribirse en el documento XML mediante un elemento vacío, como en este caso se ha escrito <marketing />.
  - No hay que definir más tipos de datos que los indicados en el ejercicio: tipoPersona y tipoPersonaAmpliado.


  <!--
  <details>
    <summary>PULSA PARA VER LA RESPUESTA:</summary>

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

  <xs:element name="registro">
    <xs:complexType>
      <xs:sequence>
        <xs:group ref="personas"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>

  <xs:group name="personas">
    <xs:sequence>
        <xs:element name="usuario" minOccurs="0" maxOccurs="unbounded" type="tipoPersona"/>
        <xs:element name="empleado" minOccurs="0" maxOccurs="unbounded" type="tipoPersonaAmpliado"/>
    </xs:sequence>
  </xs:group>

  <xs:complexType name="tipoPersonaAmpliado">
    <xs:complexContent>
      <xs:extension base="tipoPersona">
        <xs:sequence>
          <xs:element name="departamento">
            <xs:complexType>
              <xs:sequence>
                <xs:group ref="departamentosEmpresa"/>
              </xs:sequence>
            </xs:complexType>
          </xs:element>
        </xs:sequence>
      </xs:extension>
    </xs:complexContent>
  </xs:complexType>

  <xs:complexType name="tipoPersona">
    <xs:sequence>
      <xs:group ref="datosPersona"/>
    </xs:sequence>
    <xs:attribute name="identificador" use="required">
        <xs:simpleType>
          <xs:restriction base="xs:string">
            <xs:pattern value="[UE]\d{1,5}"/>
          </xs:restriction>
        </xs:simpleType>
    </xs:attribute>
  </xs:complexType>

  <xs:group name="datosPersona">
    <xs:sequence>

      <xs:element name="apellidos-y-nombre">
        <xs:simpleType>
          <xs:restriction base="xs:string">
            <xs:pattern value="[a-zA-Z ]{1,30},[a-zA-Z ]{1,20}"/>
          </xs:restriction>
        </xs:simpleType>
      </xs:element>

      <xs:element name="email">
        <xs:simpleType>
          <xs:restriction base="xs:string">
            <xs:pattern value="[a-z]{1,15}@[a-z]{1,25}[.][a-z]{2,4}"/>
          </xs:restriction>
        </xs:simpleType>
      </xs:element>

      <xs:element name="conexiones">
        <xs:complexType>
          <xs:sequence>
            <xs:element name="conexión" minOccurs="0"
             maxOccurs="unbounded">
              <xs:complexType>
                <xs:simpleContent>
                  <xs:extension base="xs:positiveInteger">
                    <xs:attributeGroup ref="atributosConexion"/>
                  </xs:extension>
                </xs:simpleContent>
              </xs:complexType>
            </xs:element>
          </xs:sequence>
        </xs:complexType>
      </xs:element>

    </xs:sequence>
  </xs:group>

  <xs:attributeGroup name="atributosConexion">
    <xs:attribute name="fecha" type="xs:date" use="required"/>
    <xs:attribute name="hora" type="xs:time" use="required"/>
  </xs:attributeGroup>

  <xs:group name="departamentosEmpresa">
    <xs:choice>
      <xs:element name="administración"/>
      <xs:element name="informática"/>
      <xs:element name="marketing"/>
    </xs:choice>
  </xs:group>

</xs:schema>

  ```

</div>  
