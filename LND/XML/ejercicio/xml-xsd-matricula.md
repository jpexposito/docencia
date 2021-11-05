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

<!--
<details>
    <summary>PULSA PARA VER LA RESPUESTA:</summary>
-->
