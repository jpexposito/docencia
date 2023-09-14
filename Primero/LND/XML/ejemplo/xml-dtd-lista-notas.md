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
  <nota dia="23/01/2010" hora="13:15">
    <para>Miguel</para>
    <de>Juan</de>
    <titulo>Informes</titulo>
    <contenido>Te he dejado los informes en el casillero</contenido>
  </nota>
</lista_de_notas>
  ```

 <details>
   <summary>PULSA PARA VER LA RESPUESTA:</summary>

 ```xml
 <!ELEMENT lista_de_notas (nota+)>
 <!ELEMENT nota (para, de, titulo, contenido)>
 <!ELEMENT para (#PCDATA)>
 <!ELEMENT de (#PCDATA)>
 <!ELEMENT titulo (#PCDATA)>
 <!ELEMENT contenido (#PCDATA)>
 <!ATTLIST nota dia CDATA #IMPLIED>
 <!ATTLIST nota hora CDATA #IMPLIED>


 ```
 </details>


</div>
