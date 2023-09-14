<div align="justify">

# Ejercicio Clase Personas

  Para la jerarquía de datos que se muestra a continuación:
  - Proporcionar una DTD que refleje esta jerarquía suponiendo que “nacimiento” es un elemento opcional y hay al menos una dirección.
  - Generar un fichero XML que referencie al DTD (de manera interna y externa) y contenga dos elementos persona.

<div align="center">
  <img width="300px" src="https://sites.google.com/site/todoxmldtd/_/rsrc/1360326331545/ejercicios/enunciados/ejercicios-dtd-avanzados/ejercicio-dtd-avanzado-4-creacion-de-un-xml-y-un-dtd-a-partir-de-un-esquema/esquema.jpg">
</div>

## Se pide

  Definir un __xml__ y __dtd__ que represente la imagen anterior .


 <details>
   <summary>PULSA PARA VER LA RESPUESTA:</summary>

```xml
<?xml version='1.0' encoding="ISO-8859-1"?>
<!DOCTYPE personas SYSTEM "personas.dtd">
<personas>
 <persona>
    <nombre>Juan</nombre>
    <apellidos>Pardo</apellidos>
    <nacimiento dia="10" mes="Abril" anio="1982"/>
    <direccion>
       <calle>Caoba, 1</calle>
       <poblacion>Madrid</poblacion>
       <provincia>Madrid</provincia>
       <cpostal>28005</cpostal>
    </direccion>
    <varon />
 </persona>
 <persona>
    <nombre>María</nombre>
    <apellidos>López</apellidos>
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

```xml
<!ELEMENT personas (persona+)>
<!ELEMENT persona (nombre, apellidos, nacimiento?, direccion+, (varon | hembra))>
<!ELEMENT nombre (#PCDATA)>
<!ELEMENT apellidos (#PCDATA)>
<!ELEMENT nacimiento EMPTY>
<!ATTLIST nacimiento
     dia     CDATA    #REQUIRED
     mes     CDATA    #REQUIRED
     anio    CDATA    #REQUIRED>
<!ELEMENT direccion (calle,poblacion,provincia,cpostal)>
<!ELEMENT calle (#PCDATA)>
<!ELEMENT poblacion (#PCDATA)>
<!ELEMENT provincia (#PCDATA)>
<!ELEMENT cpostal (#PCDATA)>
<!ELEMENT varon EMPTY>
<!ELEMENT hembra EMPTY>

 ```
 </details>

</div>
