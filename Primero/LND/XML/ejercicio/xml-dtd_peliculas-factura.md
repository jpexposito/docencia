<div align="justify">

# Ejercicio Clase Factura Video Club


<div align="center">
  <img src="https://imagenes.20minutos.es/files/image_656_370/uploads/imagenes/2020/04/28/cine-peliculas-estreno-plataformas-streaming-00.png">
</div>

## Se pide

  Definir una DTD que valide el documento XML que se muestra a continuación. ___Corrige aquello que consideres importante___.

  Proporcionar un DTD que permita validar los documentos del videoclub según los requisitos abajo indicados. Crear un ejemplar de documento XML con 2 facturas que sea de tipo válido según esta DTD.
  Una cadena de videoclubs quiere emplear una base de datos para almacenar información referente a las facturas que se hacen a los clientes. Esta información es la siguiente:
  - En un mismo documento se puede guardar información de varias facturas.
  - Cada factura está formada por dos tipos de información: datos de cliente y datos del ticket de factura propiamente dichos.
  - De los datos del cliente se desea guardar: su nombre, su primer y segundo apellidos, DNI y teléfono (uno). Además, como características del cliente, se desea conocer el identificador de cliente.
  - De los datos de la factura en si, se quiere guardar un resguardo de factura y los alquileres o compras que se incluyen en la factura. En cada factura habrá alquileres, compras o los dos. El resguardo siempre se incluye. El resguardo incluye la forma de pago y el importe total.
  - Los alquileres se realizan de películas. El alquiler de películas lleva asociada una fecha de devolución que es común a todas las películas alquiladas en la misma factura.
  - De cada película se quiere conocer su título, género, duración y los nombres y apellidos de tres actores que participan en ella. Existen dos atributos que definen a las películas: idPelicula y valoración.
  - Además, opcionalmente se puede guardar para cada película un archivo con la imagen de la carátula en formato jpg. Estos archivos los procesa una aplicación llamada “visordeimagenes.exe”, que está instalada en un directorio llamado “aplicaciones”, dentro del directorio donde está el ejemplar del documento XML. En este momento se dispone sólo de 3 carátulas, guardadas en los archivos c0360.jpg, c0437.jpg y c1201.jpg. Estos archivos están en el directorio “caratulas”, dentro del directorio de trabajo.
  - Con respecto a las compras, hay que diferenciar entre compras de DVDs y de cintas de video
  - De los DVDs interesa el título del DVD, la fecha de salida al mercado y si viene o no con extras
  -De las cintas de video se guardará el formato (VHS, por ejemplo) y si está rebobinada o no .

  Ejemplo de xml:
  ```xml
  <facturas>
   <factura>
      <datos_cliente ident="c01">
      <nombre>Antonio</nombre>
  <apellido>Moreno</apellido>
  <apellido>Flores</apellido>
  <dni>123456789X</dni>
  <tfno>916663322</tfno>
   </datos_cliente>

   <datos_factura>
      <resguardo>
     <forma_pago>efectivo</forma_pago>
 <importe_total>35</importe_total>
  </resguardo>
  <alquileres>
     <fecha>12/01/2007</fecha>
 <peliculas>
    <pelicula id_pelicula="p320" caratula="foto_p0360">
       <titulo>AQUELLAS JUERGAS UNIVERSITARIAS</titulo>
   <genero>Comedia</genero>
   <duracion>97min</duracion>
   <actores>
      <actor>
     <nombre>Luke</nombre>
                 <apellido>Wilson</apellido>
                 <apellido></apellido>
  </actor>  
      <actor>
   <nombre>Will</nombre>
                 <apellido>Farrel</apellido>
                 <apellido></apellido>
  </actor>  
      <actor>
   <nombre>Vince</nombre>
                 <apellido>Vaughn</apellido>
                 <apellido></apellido>
  </actor>  
   </actores>
     </pelicula>
 </peliculas>
  </alquileres>
  <compras>
     <dvds>
    <dvd>
       <extras/>
   <titulo>El oro de Moscú</titulo>
   <fecha_salida_mercado>2006</fecha_salida_mercado>
    </dvd>
 </dvds>
 <cintas>
    <cinta>
       <titulo>Gladiator</titulo>
   <formato>VHS</formato>
    </cinta>
 </cintas>
  </compras>
   </datos_factura>
   </factura>
</facturas>
  ```

 <details>
   <summary>PULSA PARA VER LA RESPUESTA:</summary>

 ```xml
 <!DOCTYPE facturas[

  <!-- Entidades con las imágenes de las carátulas de las películas-->
  <!ENTITY foto_p0360 SYSTEM "caratulas/p0360.jpg" NDATA jpg>  
  <!ENTITY foto_p0437 SYSTEM "caratulas/p0437.jpg" NDATA jpg>
  <!ENTITY foto_p1201 SYSTEM "caratulas/p1201.jpg" NDATA jpg>

  <!-- Elemento raiz: facturas -->
  <!ELEMENT facturas (factura*)>

  <!-- Elemento factura -->
  <!ELEMENT factura (datos_cliente, datos_factura)>

  <!-- Elemento datos_cliente -->
  <!ELEMENT datos_cliente (nombre, apellido, apellido, dni, tfno)>
  <!ATTLIST datos_cliente
     ident ID #REQUIRED>
  <!ELEMENT nombre (#PCDATA)>
  <!ELEMENT apellido (#PCDATA)>
  <!ELEMENT dni (#PCDATA)>
  <!ELEMENT tfno (#PCDATA)>

  <!-- Elemento datos_factura -->
  <!ELEMENT datos_factura (resguardo, (alquileres | compras | (alquileres,compras)))>

  <!-- Elemento resguardo -->
  <!ELEMENT resguardo (forma_pago, importe_total)>
  <!ELEMENT forma_pago (#PCDATA)>
  <!ELEMENT importe_total (#PCDATA)>

  <!-- Elemento alquileres -->
  <!ELEMENT alquileres (fecha, peliculas)>
  <!-- Elementos fecha -->
  <!ELEMENT fecha (#PCDATA)>
  <!-- Elemento peliculas -->
  <!ELEMENT peliculas (pelicula+)>

  <!-- Elemento pelicula -->
  <!ELEMENT pelicula (titulo, genero, duracion, actores)>
  <!ATTLIST pelicula
     id_pelicula ID #REQUIRED
     valoracion CDATA ""
     caratula ENTITY #IMPLIED>

  <!ELEMENT titulo (#PCDATA)>
  <!ELEMENT genero (#PCDATA)>
  <!ELEMENT duracion (#PCDATA)>
  <!-- Elemento actores -->
  <!ELEMENT actores (actor, actor, actor)>
  <!ELEMENT actor (nombre, apellido, apellido)>

  <!-- Elemento compras -->
  <!ELEMENT compras (dvds | cintas | (dvds,cintas))>
  <!-- Elemento dvds -->
  <!ELEMENT dvds (dvd+)>
  <!-- Elemento dvd -->
  <!ELEMENT dvd (extras?, titulo, fecha_salida_mercado)>
  <!ELEMENT extras EMPTY>
  <!ELEMENT fecha_salida_mercado (#PCDATA)>
  <!-- Elemento cintas -->
  <!ELEMENT cintas (cinta+)>
  <!-- Elemento cinta -->
  <!ELEMENT cinta (titulo, formato, rebobinado?)>
  <!ELEMENT formato (#PCDATA)>
  <!ELEMENT rebobinado EMPTY>
 ]>
 ```
 </details>


</div>
