<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>

  1. Teniendo en cuenta el siguiente __XML__. Escriba las expresiones _XPath_ que devuelvan la respuesta deseada.

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
  /grafico/circunferencia
  ```

 - La cuarta recta.

 ```
 /grafico/recta[4]
 ```

 - Los centros de las circunferencias.

 ```
 /grafico/circunferencia/centro
 ```

 - El último punto.

 ```
 /grafico/punto[last()]
 ```

 - El rectángulo con identificador e32.

 ```
 /grafico/rectangulo[@id="e32"]
 ```

 - Todos los radios de las circunferencias.

 ```
 /grafico/circunferencia/radio
 ```

 - El radio de la circunferencia de identificador e2.

 ```
 /grafico/circunferencia[@id="e2"]/radio
 ```

 - El radio de la quinta circunferencia.

 ```
 /grafico/circunferencia[5]/radio
 ```

 - Todos los radios de circunferencia mayores de 10.

 ```
 /grafico/circunferencia/radio[.>10]
 ```

 - Las unidades en las que se han expresado todos los números.

 ```
 /grafico/@unidades
 ```

 - El identificador de la quinta entidad de dibujo.

 ```
 /grafico/*[5]/@id
 ```

 - Las rectas cuyo punto inicial (p1) sea el centro de coordenadas (0,0).

 ```
 /grafico/recta[p1/x/text()=0][p1/y/text()=0]
 ```

 - Las rectas cuyo punto inicial esté en el segundo cuadrante.

 ```
 /grafico/recta[p1/x/text()<=0][p1/y/text()>=0]
 ```

 - Los puntos que se encuentren en el cuarto cuadrante.

 ```
 /grafico/punto[x/text()>=0][y/text()<=0]
 ```

 - El cuarto de los rectángulos

 ```
 /grafico/rectangulo[4]
 ```

 - Todas las coordenadas y de todas las rectas.

 ```
 /grafico/recta/y
 ```

 - Todas las coordenadas y de todas las entidades de dibujo.

 ```
 /grafico//y
 ```

 - Los puntos finales de todos los rectángulos.

 ```  
 /grafico/rectangulo/p2
 ```

 - Todas las rectas cuya coordenada x del punto inicial sea mayor que la coordenada x del punto final.

 ```
 /grafico/recta[p1/x/text()>p2/x/text()]
 ```

 - ¿Cuántos puntos hay en total?

 ```
 count(/grafico/punto)
 ```

 - ¿Cuántos puntos hay en el primer cuadrante?

 ```
 count(/grafico/punto[x/text()>=0][y/text()>0])
 ```

 - ¿Cuántas circunferencias tienen radio mayor de 20?

 ```
 count(/grafico/circunferencia[radio/text()>20])
 ```

 - ¿Cuántas entidades de dibujo hay en total?

 ```
 count(/grafico/*)
 ```

 - ¿Cuántas coordenadas x hay definidas en total?

 ```
 count(/grafico//x)
 ```

 - Todas los rectángulos cuyo lado horizontal sea el doble de largo que el vertical.

 ```
 /grafico/rectangulo[p2/x/text()-p1/x/text()=2*(p2/y/text()-p1/y/text())]
 ```

  2. Dada la solución propuesta para almacenar la información sobre las facturas de una empresa, determinar la expresión XPath que selecciona:

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
  /facturacion/factura[descuento]
  ```

  - Las facturas anteriores al año en curso.

  ```
  /facturacion/factura[@fecha<"2013-01-01"]
  ```

  - El número de facturas a las que se les aplicó un descuento mayor del 5%.

  ```
  /facturacion/factura/[descuento/text()>5][descuento/@unidad="porcentaje"]
  ```

  - Las facturas a nombre de "Perico de los Palotes".

  ```
  /facturacion/factura[cliente/nombre/text()="Perico de los Palotes"]
  ```

  - Las facturas con cinco productos diferentes.

  ```
  /facturacion/factura[count(productos)=5]
  ```

  - Las productos de la factura con identificador "f1" cuyo iva fuese del 21%.

  ```
  /facturacion/factura[@id="f1"]/productos[iva/text()="21"]
  ```

  - Todas las facturas en las que se facturó algún ratón.

  ```
  /facturacion/factura[producto/@denominacion="ratón"]
  ```

  - Todas las facturas en las que el número total de artículos comprados fuese de más de 10.Investigue si hay alguna función que sirva para sumar.

  ```
  /facturacion/factura[sum(productos/cantidad)>10]
  ```

  - El número de facturas de emitidas en noviembre de 2012.

  ```
  /facturacion/factura[@fecha<"2012-12-01"][@fecha>"2012-10-31"]
  ```

  - Las facturas emitidas a residentes en Cazorla.

  ```
  /facturacion/factura[cliente/cp/text()="23470"]
  ```

  - El número de facturas que sólo contienen un producto.

  ```
  /facturacion/factura[count(producto)=1]
  ```

  - Las facturas sin productos gravados al 21%.

  ```
  /facturacion/facturas[count(producto[iva/text()="21"])=0]
  ```

  3. Dada la solución propuesta para almacenar la información sobre los libros y préstamos en una biblioteca, determinar la expresión XPath que devuelve:

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
  count(/biblioteca/socios/socio)
  ```

  - La dirección del socio que se llama "Perico de los Palotes".

  ```
  /biblioteca/socios/socio[nombre/text()="Perico de los Palotes"]/direccion
  ```

  - Los libros cuyo año de edición sea 1985.

  ```
  /biblioteca/catalogo/libro[año/text()="1985"]
  ```

  - Los libros de la editorial Alfaguara.

  ```
  /biblioteca/catalogo/libro[editorial/text()="Alfaguara"]
  ```

  - El número total de ejemplares que hay en la biblioteca.

  ```
  count(/biblioteca/catalogo/libro/ejemplar)
  ```

  - Todos los libros cuyo autor sea "Miguel De Cervantes".

  ```
  /biblioteca/catalogo/libro[autor/text()="Miguel de Cervantes"]
  ```
  - El número de ejemplares del libro con identificador L1.

  ```
  count(/biblioteca/catalogo/libro[@id="L1"]/ejemplar)
  ```

  - El número total de ejemplares prestados.

  ```
  count(/biblioteca/catalogo/libro/ejemplar[@socio])
  ```

  - El número total de ejemplares no prestados.

  ```
  count(/biblioteca/catalogo/libro/ejemplar[not(@socio)])
  ```

  - El número de ejemplares prestados al socio "s1".

  ```
  count(/biblioteca/catalogo/libro/ejemplar[@socio="s1"])
  ```
  - Los libros que se han prestado al socio "s1".

  ```
  /biblioteca/catalogo/libro[ejemplar/@socio="s1"]
  ```

  - Los libros que no están prestados al socio "s1".

  ```
  /biblioteca/catalogo/libro[count(ejemplar[@socio="s1"])=0]
  ```


  - Los libros que se han prestado al socio "s1", pero no al socio "s2".

  ```
  /biblioteca/catalogo/libro[ejemplar/@socio="s1"][count(ejemplar[@socio="s2"])=0]
  ```

  - El número de ejemplares de libros de la editorial Castalia

  ```
  count(/biblioteca/catalogo/libro[editorial/text()="Castalia"]/ejemplar)
  ```

  - Los identificadores de los socios que tiene algún libro en préstamo.(distinct-values es una función de XPath 2.0, por lo que xmlstarlet no la admite.)

  ```
  distinct-values(/biblioteca/catalogo/libro/ejemplar/@socio)
  ```

  - Los ejemplares aún disponibles (no prestados) de "Don Quijote de La Mancha".

  ```
  /biblioteca/catalogo/libro[nombre/text()="Don Quijote de la Mancha"]/ejemplar[not(@socio)]
  ```

  - Los libros de los que quedan menos de dos ejemplares en la biblioteca.

  ```
  /biblioteca/catalogo/libro[count(ejemplar[not(@socio)])<2]
  ```

  - Los libros de los que no se ha prestado ningún ejemplar.

  ```
  /biblioteca/catalogo/libro[count(ejemplar/@socio)=0]
  ```

  - Los libros que tiene todos los ejemplares prestados

  ```
  /biblioteca/catalogo/libro[count(ejemplar[not(@socio)])=0]
  ```

  - Los libros que tiene más ejemplares en préstamo que aún en la biblioteca.

  ```
  /biblioteca/catalogo/libro[count(ejemplar) div 2 < count(ejemplar/@socio)]
  ```

  4. Dada la solución propuesta para almacenar la información sobre los coches que vende un concesionario, determinar la expresión XPath que devuelve:

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
  /flota/marca/@nombre
  ```

  - El nombre de los modelos de la marca Renault que vende el concesionario.

  ```
  /flota/marca[@nombre="Renault"]/modelo/@nombre
  ```

  - Los modelos de cinco plazas.

  ```
  /flota/marca/modelo[plazas/text()="5"]
  ```

  - Los modelos que tienen una cilindrada mayor a 300.

  ```
  /flota/marca/modelo[cilindrada/text()>"300"]
  ```

  - El modelo Megane.

  ```
  /flota/marca/modelo[@nombre="Megane"]
  ```

  - El último modelo de todas las marcas.

  ```
  /flota/marca/modelo[last()]
  ```

  - El número de marcas que vende el concesionario.

  ```
  count(/flota/marca)
  ```

  - El número de modelos que vende el concesionario.

  ```
  count(/flota/marca/modelo)
  ```

  - El cliente de identificador. p1.

  ```
  /flota/cliente[@id="p1"]
  ```

  - El número de clientes.

  ```
  count(/flota/cliente)
  ```

  - Los coches que ha reservado el cliente p1.

  ```
  /flota/coche[@reservado="p1"]
  ```

  - Los coches nuevos (no tienen kilometraje).

  ```
  /flota/coche[not(@km)]
  ```

  - Los coches reservados.

  ```
  /flota/coche[@reservado]
  ```

  - El número de coches reservados.

  ```
  count(/flota/coche[@reservado])
  ```

  - El número de coches Clio.

  ```
  count(/flota/coche[@modelo="Clio"])
  ```

  - Los Clio reservados.

  ```
  /flota/coche[@modelo="Clio"][@reservado]
  ```

  - Los coches de segunda mano reservados.

  ```
  /flota/coche[@km][@reservado]
  ```

  - Los coches reservados que sean Clio o Megane.

  ```
  /flota/coche[@modelo="Clio" or @modelo="Megane"][@reservado]
  ```

  - Los coches nuevos no reservados aún.

  ```
  /flota/coche[not(@km)][not(@reservado)]
  ```

  - Los coches reservados seminuevos (de menos de 500 km).

  ```
  /flota/coche[@reservado][@km<500]
  ```

## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
