<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>

  1. Teniendo en cuenta el siguiente __XML__. Escriba las expresiones _XQuery_ que devuelvan la respuesta deseada.

  ```xml
  <?xml version="1.0" encoding="utf-8" standalone="no"?>
<!DOCTYPE grafico
  SYSTEM 'grafico.dtd'>
<grafico unidades="cm">
    <punto id="e1">
        <x>1</x>
        <y>2</y>
    </punto>
    <circunferencia id="e2">
        <centro>
            <x>0</x>
            <y>0</y>
        </centro>
        <radio>20</radio>
    </circunferencia>
    <recta id="e3">
        <p1>
            <x>4</x>
            <y>5</y>
        </p1>
        <p2>
            <x>8</x>
            <y>7</y>
        </p2>
    </recta>
    <rectangulo id="e4">
        <p1>
            <x>10</x>
            <y>1</y>
        </p1>
        <p2>
            <x>12</x>
            <y>12</y>
        </p2>
    </rectangulo>
  </grafico>
  ```

 - Todas las circunferencias.

  ```

  ```

 - La cuarta recta.

 ```

 ```

 - Los centros de las circunferencias.

 ```

 ```

 - El último punto.

 ```

 ```

 - El rectángulo con identificador e32.

 ```

 ```

 - Todos los radios de las circunferencias.

 ```

 ```

 - El radio de la circunferencia de identificador e2.

 ```

 ```

 - El radio de la quinta circunferencia.

 ```

 ```

 - Todos los radios de circunferencia mayores de 10.

 ```

 ```

 - Las unidades en las que se han expresado todos los números.

 ```

 ```

 - El identificador de la quinta entidad de dibujo.

 ```

 ```

 - Las rectas cuyo punto inicial (p1) sea el centro de coordenadas (0,0).

 ```

 ```

 - Las rectas cuyo punto inicial esté en el segundo cuadrante.

 ```

 ```

 - Los puntos que se encuentren en el cuarto cuadrante.

 ```

 ```

 - El cuarto de los rectángulos

 ```

 ```

 - Todas las coordenadas y de todas las rectas.

 ```

 ```

 - Todas las coordenadas y de todas las entidades de dibujo.

 ```

 ```

 - Los puntos finales de todos los rectángulos.

 ```  

 ```

 - Todas las rectas cuya coordenada x del punto inicial sea mayor que la coordenada x del punto final.

 ```

 ```

 - ¿Cuántos puntos hay en total?

 ```

 ```

 - ¿Cuántos puntos hay en el primer cuadrante?

 ```

 ```

 - ¿Cuántas circunferencias tienen radio mayor de 20?

 ```

 ```

 - ¿Cuántas entidades de dibujo hay en total?

 ```

 ```

 - ¿Cuántas coordenadas x hay definidas en total?

 ```

 ```

 - Todas los rectángulos cuyo lado horizontal sea el doble de largo que el vertical.

 ```

 ```

  2. Dada la solución propuesta para almacenar la información sobre las facturas de una empresa, determinar la expresión _XQuery_ que selecciona:

  ```xml
  <?xml version="1.0" encoding="utf-8" standalone="no" ?>
<!DOCTYPE facturacion
  SYSTEM 'facturas.dtd'>
<facturacion>
    <factura fecha="2013-10-21" id="f1">
        <cliente>
            <nombre>Perico de los Palotes</nombre>
            <dni>11223344</dni>
            <direccion>C/ callo, 2</direccion>
            <cp>23111</cp>
            <poblacion>La que sea</poblacion>
        </cliente>
        <producto denominacion="raton">
            <cantidad>10</cantidad>
            <precio>6</precio>
            <iva>21</iva>
        </producto>
        <producto denominacion="teclado">
            <cantidad>5</cantidad>
            <precio>5</precio>
            <iva>21</iva>
        </producto>
        <!-- Más productos comprados en la misma venta -->
        <descuento unidad="porcentaje">5.5</descuento>
    </factura>
    <!-- Más facturas -->
</facturacion>
  ```

  - Las facturas que tenían algún descuento.

  ```

  ```

  - Las facturas anteriores al año en curso.

  ```

  ```

  - El número de facturas a las que se les aplicó un descuento mayor del 5%.

  ```

  ```

  - Las facturas a nombre de "Perico de los Palotes".

  ```

  ```

  - Las facturas con cinco productos diferentes.

  ```

  ```

  - Las productos de la factura con identificador "f1" cuyo iva fuese del 21%.

  ```

  ```

  - Todas las facturas en las que se facturó algún ratón.

  ```

  ```

  - Todas las facturas en las que el número total de artículos comprados fuese de más de 10.Investigue si hay alguna función que sirva para sumar.

  ```

  ```

  - El número de facturas de emitidas en noviembre de 2012.

  ```

  ```

  - Las facturas emitidas a residentes en Cazorla.

  ```

  ```

  - El número de facturas que sólo contienen un producto.

  ```

  ```

  - Las facturas sin productos gravados al 21%.

  ```

  ```

  3. Dada la solución propuesta para almacenar la información sobre los libros y préstamos en una biblioteca, determinar la expresión _XQuery_ que devuelve:

  ```xml
  <?xml version="1.0" encoding="utf-8" standalone="no" ?>
  <!DOCTYPE biblioteca
    SYSTEM 'libros.dtd'>
  <biblioteca>
      <socios>
          <socio id="s1">
              <nombre>Perico de los Palotes</nombre>
              <dni>11223344</dni>
              <direccion>C/ Callo, 2. 23111. Donde-sea.</direccion>
          </socio>
          <!-- Resto de socios -->
      </socios>
      <catalogo>
          <libro id="L1">
              <isbn>XXX</isbn>
              <nombre>don Quijote de la Mancha</nombre>
              <editorial>Castalia</editorial>
              <año>1985</año>
              <autor>Miguel de Cervantes</autor>
              <!-- El primero no está prestado, el segundo sí -->
              <ejemplar id="L1e1"/>
              <ejemplar fecha="2013-10-21" id="L1e2" plazo="15" socio="s1"/>
              <!-- Más ejemplares -->
          </libro>
          <!-- Más libros -->
      </catalogo>
  </biblioteca>
  ```

  - El número de socios de la biblioteca.

  ```

  ```

  - La dirección del socio que se llama "Perico de los Palotes".

  ```

  ```

  - Los libros cuyo año de edición sea 1985.

  ```

  ```

  - Los libros de la editorial Alfaguara.

  ```

  ```

  - El número total de ejemplares que hay en la biblioteca.

  ```

  ```

  - Todos los libros cuyo autor sea "Miguel De Cervantes".

  ```

  ```
  - El número de ejemplares del libro con identificador L1.

  ```

  ```

  - El número total de ejemplares prestados.

  ```

  ```

  - El número total de ejemplares no prestados.

  ```

  ```

  - El número de ejemplares prestados al socio "s1".

  ```

  ```
  - Los libros que se han prestado al socio "s1".

  ```

  ```

  - Los libros que no están prestados al socio "s1".

  ```

  ```


  - Los libros que se han prestado al socio "s1", pero no al socio "s2".

  ```

  ```

  - El número de ejemplares de libros de la editorial Castalia

  ```

  ```

  - Los identificadores de los socios que tiene algún libro en préstamo.(distinct-values es una función de XPath 2.0, por lo que xmlstarlet no la admite.)

  ```

  ```

  - Los ejemplares aún disponibles (no prestados) de "Don Quijote de La Mancha".

  ```

  ```

  - Los libros de los que quedan menos de dos ejemplares en la biblioteca.

  ```

  ```

  - Los libros de los que no se ha prestado ningún ejemplar.

  ```

  ```

  - Los libros que tiene todos los ejemplares prestados

  ```

  ```

  - Los libros que tiene más ejemplares en préstamo que aún en la biblioteca.

  ```

  ```

  4. Dada la solución propuesta para almacenar la información sobre los coches que vende un concesionario, determinar la expresión _XQuery_ que devuelve:

```xml
<?xml version="1.0" encoding="utf-8" standalone="no" ?>
<!DOCTYPE flota
SYSTEM '08coches.dtd'>
<flota>
  <marca nombre="Renault">
      <modelo nombre="clio">
          <cilindrada>300</cilindrada>
          <potencia>15</potencia>
          <plazas>5</plazas>
      </modelo>
      <modelo nombre="Megane">
          <cilindrada>340</cilindrada>
          <potencia>16</potencia>
          <plazas>5</plazas>
      </modelo>
      <!-- más modelos de la marca Renault -->
  </marca>
  <!-- Más marcas -->
  <cliente id="p1">
      <nombre>Perico de los Palotes</nombre>
      <tlfo>953123456</tlfo>
      <direccion>c/ Callo, 5</direccion>
  </cliente>
  <coche id="c01" km="1000" modelo="clio"/>
  <coche id="c02" km="500" modelo="clio" reservado="p1"/>
  <coche id="c03" modelo="clio"/>
  <!-- Más coches disponibles en el concesionario -->
</flota>
```

  - Los nombres de las marcas que vende el concesionario.

  ```

  ```

  - El nombre de los modelos de la marca Renault que vende el concesionario.

  ```

  ```

  - Los modelos de cinco plazas.

  ```

  ```

  - Los modelos que tienen una cilindrada mayor a 300.

  ```

  ```

  - El modelo Megane.

  ```

  ```

  - El último modelo de todas las marcas.

  ```

  ```

  - El número de marcas que vende el concesionario.

  ```

  ```

  - El número de modelos que vende el concesionario.

  ```

  ```

  - El cliente de identificador. p1.

  ```

  ```

  - El número de clientes.

  ```

  ```

  - Los coches que ha reservado el cliente p1.

  ```

  ```

  - Los coches nuevos (no tienen kilometraje).

  ```

  ```

  - Los coches reservados.

  ```

  ```

  - El número de coches reservados.

  ```

  ```

  - El número de coches Clio.

  ```

  ```

  - Los Clio reservados.

  ```

  ```

  - Los coches de segunda mano reservados.

  ```

  ```

  - Los coches reservados que sean Clio o Megane.

  ```

  ```

  - Los coches nuevos no reservados aún.

  ```

  ```

  - Los coches reservados seminuevos (de menos de 500 km).

  ```

  ```

## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
