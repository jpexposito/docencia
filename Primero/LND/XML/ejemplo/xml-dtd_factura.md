<div align="justify">

# Ejercicio Clase Factura


<div align="center">
  <img width="300px" src="https://www.e4e-soluciones.com/wp-content/uploads/2020/04/factura-de-la-luz-1000x675.jpg">
</div>

## Se pide

  Definir una DTD que valide el documento XML que se muestra a continuación.
  Se deben tener en cuenta las siguientes características:
  - El número de factura (n_fac), número de cliente (n_cli) y número de pedido (n_ped) son valores únicos, por cada factura, cliente y pedido distintos, y son obligatorios.
  - Los números de teléfono (telefono) y fax (fax) de la empresa no tienen porqué aparecer en la factura, pero siempre que lo hagan deberán tener los mismos valores (teléfono 917776688, fax 917776699).
  - La forma de pago puede tomar los valores “efectivo”, “tarjeta” y “plazos”.
  - La moneda tiene que aparecer siempre, y siempre toma al valor “euro”.
  - El iva tiene que aparecer siempre, y su valor no puede contener caracteres especiales.


  Ejemplo de xml:
  ```xml
  <factura n_fac="f999">
  <datos_empresa>
    <nombre>Equipos Digitales S.L.</nombre>
    <dir>Av. Valladolid</dir>
    <poblacion cod_postal="28043">Madrid</poblacion>
    <provincia>Madrid</provincia>
    <cif>Q-9876543</cif>
    <telefono/>
  </datos_empresa>
  <datos_cliente n_cli="c879">
    <nombre>Darío, Bueno Gutiérrez</nombre>
    <dir_env>Av. Oporto nº7 4ºd</dir_env>
    <poblacion cod_postal="28043">Madrid</poblacion>
    <provincia>Madrid</provincia>
  </datos_cliente>
  <datos_factura n_ped="p731" iva="16" f_pago= "efectivo" moneda="euro">
    <fecha>12-01-2005</fecha>
    <linea>
      <ref>MII93000F/8</ref>
      <desc>MICRO PENTIUM IV 3000MHZ FB800</desc>
      <cant>1</cant>
      <precio>230</precio>
      <importe>266,80</importe>
    </linea>
    <linea>
      <ref>MB8QDIP4</ref>
      <desc>PLACA BASE QDI P4</desc>
      <cant>1</cant>
      <precio>180</precio>
      <importe>208,80</importe>
    </linea>
    <linea>
      <ref>MEDD512M32</ref>
      <desc>DIMM DDR 512MB 3200</desc>
      <cant>2</cant>
      <precio>40</precio>
      <importe>92,80</importe>
    </linea>
    <linea>
      <ref>HD250GSA7</ref>
      <desc>DISCO DURO 250GB S-ATA 7200</desc>
      <cant>4</cant>
      <precio>120</precio>
      <importe>556,80</importe>
    </linea>
    <base>970,00</base>
    <cuota_iva>155,20</cuota_iva>
    <total>1125,20</total>
  </datos_factura>
</factura>
  ```

 <details>
   <summary>PULSA PARA VER LA RESPUESTA:</summary>

 ```xml
<?xml version="1.0" encoding="ISO-8859-1" ?>

<!DOCTYPE factura [

 <!ELEMENT factura (datos_empresa, datos_cliente, datos_factura)>
 <!ELEMENT datos_empresa (nombre,dir,poblacion,provincia,cif,telefono?,fax?)>
 <!ELEMENT datos_cliente (nombre, dir_env, poblacion, provincia)>
 <!ELEMENT datos_factura (fecha, linea*, base, cuota_iva, total)>
 <!ELEMENT linea (ref, desc, cant, precio, importe)>
 <!ELEMENT ref (#PCDATA)>
 <!ELEMENT desc (#PCDATA)>
 <!ELEMENT cant (#PCDATA)>
 <!ELEMENT precio (#PCDATA)>
 <!ELEMENT importe (#PCDATA)>
 <!ELEMENT nombre (#PCDATA)>
 <!ELEMENT dir (#PCDATA)>
 <!ELEMENT poblacion (#PCDATA)>
 <!ELEMENT provincia (#PCDATA)>
 <!ELEMENT cif (#PCDATA)>
 <!ELEMENT telefono EMPTY>
 <!ELEMENT fax EMPTY>
 <!ELEMENT dir_env (#PCDATA)>
 <!ELEMENT fecha (#PCDATA)>
 <!ELEMENT base (#PCDATA)>
 <!ELEMENT cuota_iva (#PCDATA)>
 <!ELEMENT total (#PCDATA)>

 <!ATTLIST factura n_fac ID #REQUIRED>
 <!ATTLIST telefono num_tel CDATA #FIXED "917776688">
 <!ATTLIST fax num_fax CDATA #FIXED "917776699">
 <!ATTLIST datos_cliente n_cli ID #REQUIRED>
 <!ATTLIST datos_factura n_ped ID #REQUIRED>
 <!ATTLIST datos_factura iva NMTOKEN #REQUIRED>
 <!ATTLIST datos_factura f_pago (efectivo|tarjeta|plazos) #REQUIRED>
 <!ATTLIST datos_factura moneda CDATA #FIXED "euro">
 <!ATTLIST poblacion cod_postal CDATA "">
]>
 ```
 </details>

</div>
