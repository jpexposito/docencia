<div align="justify">

# Tarea Sistema de un Almacén de pedidos


<div align="center">
  <img width="300px" src="https://agroingeniacanarias.com/wp-content/uploads/2018/10/asesoramiento-en-jardineria-1-980x735.jpg">
</div>

## Se pide

  Se necesita un formato de archivo para intercambiar productos entre almacenes de productos de jardinería y se desea una DTD que incluya estas restricciones:

  Debe haber un elemento raíz pedido que puede constar de plantas, flores y/o utensilios. Los tres elementos pueden aparecer repetidos y en cualquier orden. También pueden aparecer por ejemplo 4 plantas, 2 flores y luego 4 utensilios de nuevo.
  - Todo planta tiene un atributo obligatorio nombre.
  - Los elementos flores tiene un atributo optativo color.
  - Todo elemento utensilio debe tener dentro un elemento obligatorio número.

## Entrega

  - Recuerda que debes de generar el informe en __pdf__ + __github__ (enlace en la descripción de la entrega de la tarea).
  - La entrega fuera de hora supondrá un __40%__ menos de la __nota__.

<!--
<details>
  <summary>PULSA PARA VER LA RESPUESTA CORRECTA:</summary>

  El fichero __jardineria.dtd contendrá:

  ```xml
  <!ELEMENT pedido (planta|flor|utensilio)+>
  <!ELEMENT planta (#PCDATA)>
  <!ATTLIST planta nombre CDATA #REQUIRED>
  <!ELEMENT flor (#PCDATA)>
  <!ATTLIST flor color CDATA #IMPLIED>
  <!ELEMENT utensilio (numero)>
  <!ELEMENT numero (#PCDATA)>
  ```
  Un xml que cumple este dtd, será el siguiente:
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE pedido SYSTEM "jardineria.dtd">
   <pedido>
     <planta nombre="pino"></planta>
     <flor></flor>
     <planta nombre="helecho"/>
     <flor color="morado"/>
     <cuaderno num_hojas="150"/>
     <utensilio>
           <numero>10</numero>
     </utensilio>
     <flor color="rojo"/>
     <flor color="amarillo"/>
     <utensilio>
           <numero>2</numero>
     </utensilio>
     <utensilio>
           <numero>5</numero>
     </utensilio>
   </pedido>


 ```
<details>
-->
