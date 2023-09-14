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
  for $circunferencia in /grafico/circunferencia
  return $circunferencia
  ```

 - La cuarta recta.

 ```
 for $recta in /grafico/recta[4]
 return $recta
 ```

 - Los centros de las circunferencias.

 ```
 for $centro in /grafico/circunferencia/centro
 return $centro
 ```

 - El último punto.

 ```
 for $punto in /grafico/punto[last()]
 return $punto
 ```

 - El rectángulo con identificador e32.

 ```
 for $rectangulo in /grafico/rectangulo
 where $rectangulo/@id="e32"
 return $rectangulo
 ```

 - Todos los radios de las circunferencias.

   ```
   for $radio in /grafico/circunferencia/radio
   return $radio
   ```

 - El radio de la circunferencia de identificador e2.

   ```
   for $circunferencia in /grafico/circunferencia[@id = "e2"]/radio
   return $circunferencia

   ó

   for $circunferencia in /grafico/circunferencia
   where $circunferencia/@id="e2"
   return $circunferencia/radio
   ```

 - El radio de la quinta circunferencia.

   ```
   for $circunferencia in /grafico/circunferencia
   return $circunferencia[5]/radio

   o

   for $circunferencia in /grafico/circunferencia[5]/radio
   return $circunferencia
   ```

 - Todos los radios de circunferencia mayores de 10.

   ```
   for $radio in /grafico/circunferencia/radio
    where $radio/text()>"10"
    return $radio

    ó

    for $circunferencia in /grafico/circunferencia[radio > 10]/radio
    return $circunferencia
   ```

 - Las unidades en las que se han expresado todos los números.

   ```
   for $unidades in /grafico/@unidades
   return $unidades
   ```

 - El identificador de la quinta entidad de dibujo.

   ```
   for $id in /grafico/*[5]/@id
   return $id
   ```

 - Las rectas cuyo punto inicial (p1) sea el centro de coordenadas (0,0).

   ```
   for $rectas in /grafico/recta
    where $rectas//x > 0 and $rectas//y > 0
    return $rectas
   ```

 - Las rectas cuyo punto inicial esté en el segundo cuadrante.

   ```
   for $rectas in /grafico/recta
    where $rectas//x < 0 and $rectas//y > 0
    return $rectas
   ```

 - Los puntos que se encuentren en el cuarto cuadrante.

   ```
   for $punto in /grafico/punto
    where $punto/x > 0 and $punto/y < 0
    return $punto
   ```

 - El cuarto de los rectángulos

   ```
   for $rectangulo in /grafico/rectangulo
   return $rectangulo[4]
   ```

 - Todas las coordenadas y de todas las rectas.

   ```
   for $coordenadas in (/grafico/recta//y | /grafico/recta//x)
   return $coordenadas
   ```

 - Todas las coordenadas y de todas las entidades de dibujo.

   ```
   for $coordenadas in (/grafico//x | /grafico//y)
    return $coordenadas
   ```

 - Los puntos finales de todos los rectángulos.

   ```  
   for $final in /grafico/rectangulo/p2
   return $final
   ```

 - Todas las rectas cuya coordenada x del punto inicial sea mayor que la coordenada x del punto final.

   ```
   for $rectas in /grafico/recta
   where $rectas[p1/x/text() > p2/x/text()]
   return $rectas
   ```

 - ¿Cuántos puntos hay en total?

   ```
   for $numPuntos in count(/grafico/punto)
    return $numPuntos

      ó

  for $punto in /grafico/punto
    return count($punto)
   ```

 - ¿Cuántos puntos hay en el primer cuadrante?

   ```
   for $punto in /grafico/punto
    where $punto//x > 0 and $punto//y > 0
    return count($punto)
   ```

 - ¿Cuántas circunferencias tienen radio mayor de 20?

   ```
   for $circunferencias in /grafico/circunferencia
    where $circunferencias/radio/text()>"20"
    return count($circunferencias)
   ```

 - ¿Cuántas entidades de dibujo hay en total?

   ```
   for $grafico in /grafico
   return count($grafico)
   ```

 - ¿Cuántas coordenadas x hay definidas en total?

   ```
   for $grafico in /grafico
   return count($grafico//x)
   ```

 - Todas los rectángulos cuyo lado horizontal sea el doble de largo que el vertical.

   ```
   for $rectangulo in /grafico/rectangulo[x/text()=2*y]
   return $rectangulo

  ó

  for $rectangulo in /grafico/rectangulo
  where $rectangulo[p2/x-p1/x=2*(p2/y-p1/y)]
  return $rectangulo
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
  for $facturas in /facturacion/factura
  where $facturas/descuento
  return $facturas

  ó

  for $facturas in /facturacion/factura
  where $facturas/descuento > 0
  return $facturas
  ```
  _La segunda solución es más óptima_.

  - Las facturas anteriores al año en curso.

  ```
  for $facturas in /facturacion/factura
  where $facturas/@fecha < "2022/01/01"
  return $facturas
  ```

  - El número de facturas a las que se les aplicó un descuento mayor del 5%.

  ```
  for $facturas in /facturacion/factura
  where $facturas/descuento > 5
  return count($facturas)
  ```
  _Similar a la consulta: Las facturas que tenían algún descuento_.

  - Las facturas a nombre de "Perico de los Palotes".

  ```
  for $facturas in /facturacion/factura
  where $facturas//nombre = "Perico de los Palotes"
  return $facturas
  ```

  - Las facturas con cinco productos diferentes.

  ```
  for $factura in /facturacion/factura
  where $factura/@id = "f1" and $factura//iva > 21
  return $factura/producto
  ```

  - Las productos de la factura con identificador "f1" cuyo iva fuese del 21%.

  ```
  for $factura in /facturacion/factura
  where $factura/@id = "f1" and $factura//iva = 21
  return $factura/producto
  ```

  - Todas las facturas en las que se facturó algún ratón.

  ```
  for $factura in //factura
  where $factura/producto/@denominacion="raton"
  return $factura
  ```

  - Todas las facturas en las que el número total de artículos comprados fuese de más de 10.Investigue si hay alguna función que sirva para sumar.

  ```
  for $factura in /facturacion/factura
  where sum($factura//cantidad) > 10
  return $factura
  ```

  - El número de facturas de emitidas en noviembre de 2012.

  ```
  for $factura in /facturacion/factura
  where /facturacion/factura/@fecha="2012-11-%"
  return count($factura)

  ó

  for $factura in /facturacion/factura
  where $factura/@fecha < "2012/12/01" and $factura/@fecha > "2012/10/31"
  return count($factura)
  ```

  - Las facturas emitidas a residentes en Cazorla.

  ```
  for $factura in /facturacion/factura
  where $factura//poblacion = "Cazorla"
  return $factura
  ```

  - El número de facturas que sólo contienen un producto.

  ```
  for $facturas in /facturacion/factura
  where count($facturas/producto) = 1
  return $facturas
  ```
  _Si fuera 2 obtendrían resultado_.

  - Las facturas sin productos gravados al 21%.

  ```
  for $factura in /facturacion/factura
  where $factura//iva < 21
  return $factura
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
  for $biblioteca in /biblioteca
  return count($biblioteca/socios/socio)
  ```

  - La dirección del socio que se llama "Perico de los Palotes".

  ```
  for $biblioteca in /biblioteca
  where $biblioteca/socios//nombre = "Perico de los Palotes"
  return $biblioteca//direccion
  ```

  - Los libros cuyo año de edición sea 1985.

  ```
  for $libro in /biblioteca/catalogo/libro[año="1985"]
  return $libro
  ```

  - Los libros de la editorial Alfaguara.

  ```
  for $libro in /biblioteca/catalogo/libro[editorial="Alfaguara"]
  return $libro
  ```
  _Si el filtro fuera Castalia tendríamos resultado_.

  - El número total de ejemplares que hay en la biblioteca.

  ```
  for $libro in count(/biblioteca/catalogo/libro/ejemplar)
  return $libro
  ```

  - Todos los libros cuyo autor sea "Miguel De Cervantes".

  ```
  for $libro in /biblioteca/catalogo/libro[autor="Miguel de Cervantes"]
  return $libro
  ```
  - El número de ejemplares del libro con identificador L1.

  ```
  for $libro in count(/biblioteca/catalogo/libro[@id="L1"]/ejemplar)
  return $libro
  ```

  - El número total de ejemplares prestados.

  ```
  for $libro in count(/biblioteca/catalogo/libro/ejemplar[@socio])
  return $libro
  ```

  - El número total de ejemplares no prestados.

  ```
  for $libro in count(/biblioteca/catalogo/libro/ejemplar[not(@socio)])
  return $libro
  ```

  - El número de ejemplares prestados al socio "s1".

  ```
  for $libro in count(/biblioteca/catalogo/libro/ejemplar[@socio="s1"])
  return $libro
  ```
  - Los libros que se han prestado al socio "s1".

  ```
  for $libro in //libro[ejemplar/@socio="s1"]
  return $libro
  ```

  - Los libros que no están prestados al socio "s1".

  ```
  for $libro in //libro[count(ejemplar[@socio="s1"])=0]
  return $libro
  ```

  - Los libros que se han prestado al socio "s1", pero no al socio "s2".

  ```
  for $i in /biblioteca/catalogo/libro[ejemplar/@socio="s1"]
  [count(ejemplar[@socio="s2"])=0]
  return $i

  ```
  - El número de ejemplares de libros de la editorial Castalia

  ```
  for $libro in
  count(/biblioteca/catalogo/libro[editorial/text()="Castalia"]/ejemplar)
  return $libro
  ```

  - Los identificadores de los socios que tiene algún libro en
  préstamo.(distinct-values es una función de XPath 2.0, por lo que
  xmlstarlet no la admite.)

  ```
  for $libro in distinct-values(/biblioteca/catalogo/libro/ejemplar/@socio)
  return $libro
  ```

  - Los ejemplares aún disponibles (no prestados) de "Don Quijote de La
  Mancha".

  ```
  for $libro in ///libro[nombre="Don Quijote de la Mancha"]/ejemplar[not(@socio)]
  return $libro
  ```

  - Los libros de los que quedan menos de dos ejemplares en la biblioteca.

  ```
  for $libro in //libro[count(ejemplar[not(@socio)])<2]
  return
  ```

  - Los libros de los que no se ha prestado ningún ejemplar.

  ```
  for $libro in //libro[count(ejemplar/@socio)=0]
  return $libro
  ```  
  - Los libros que tiene todos los ejemplares prestados

  ```
  for $libro in //libro[count(ejemplar[not(@socio)])=0]
  return $libro
  ```

  - Los libros que tiene más ejemplares en préstamo que aún en la
  biblioteca.

  ```
  for $libro in //libro[count(ejemplar) div 2 < count(ejemplar/@socio)]
  return $libro
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
  for $marca in //marca/@nombre
  return $marca
  ```

  - El nombre de los modelos de la marca Renault que vende el concesionario.

  ```
  for $modelo in //marca[@nombre="Renault"]/modelo/@nombre
  return $modelo
  ```

  - Los modelos de cinco plazas.

  ```
  for $modelo in /flota/marca/modelo[plazas="5"]
  return $modelo
  ```

  - Los modelos que tienen una cilindrada mayor a 300.

  ```
  for $modelo in //modelo[cilindrada>"300"]
  return $modelo
  ```

  - El modelo Megane.

  ```
  for $modelo in //modelo[@nombre="Megane"]
  return $modelo
  ```

  - El último modelo de todas las marcas.

  ```
  for $modelo in //modelo[last()]
  return $modelo
  ```

  - El número de marcas que vende el concesionario.

  ```
  for $marca in count(/flota/marca)
  return $marca
  ```

  - El número de modelos que vende el concesionario.

  ```
  for $modelos in count(/flota/marca/modelo)
  return $modelos
  ```

  - El cliente de identificador. p1.

  ```
  for $coche in //cliente[@id="p1"]
  return $coche
  ```

  - El número de clientes.

  ```
  for $coche in //coche[@reservado="p1"]
  return $coche
  ```

  - Los coches que ha reservado el cliente p1.

  ```
  for $  in //coche[@reservado="p1"]
  return $coche
  ```

  - Los coches nuevos (no tienen kilometraje).

  ```
  for $coche in //coche[not(@km)]
  return $coche
  ```

  - Los coches reservados.

  ```
  for $coche in /flota/coche[@reservado]
  return $coche
  ```

  - El número de coches reservados.

  ```
  for $coche in count(/flota/coche[@reservado])
  return $coche
  ```

  - El número de coches Clio.

  ```
  for $coche in count(/flota/coche[@modelo="Clio"])
  return $coche
  ```
- Los Clio reservados.

  ```
  for $coche in /flota/coche[@modelo="Clio"]
  return $coche
  ```

- Los coches de segunda mano reservados.

  ```
  for $coche in //coche[@km][@reservado]
  return $coche
  ```

- Los coches reservados que sean Clio o Megane.

  ```
  for $coche in /flota/coche[@modelo="Clio" or @modelo="Megane"][@reservado]
  return $coche
  ```
- Los coches nuevos no están reservados aún.

  ```
  for $coche in /flota/coche[not(@km)][not(@reservado)]
  return $coche
  ```

- Los coches reservados seminuevos (de menos de 500 km).

    ```
    for $coche in /flota/coche[@reservado and @km<500]
    return $coche
    ```

## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
