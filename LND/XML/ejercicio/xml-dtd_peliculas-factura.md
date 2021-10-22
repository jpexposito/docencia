<div align="justify">

# Ejercicio Clase Factura Video Club


<div align="center">
  <img src="https://imagenes.20minutos.es/files/image_656_370/uploads/imagenes/2020/04/28/cine-peliculas-estreno-plataformas-streaming-00.png">
</div>

## Se pide

  Definir una DTD que valide el documento XML que se muestra a continuación. ___Corrige aquello que consideres importante___.

  Proporcionar un XML y DTD que permita validar los documentos del videoclub según los requisitos abajo indicados. Crear un ejemplar de documento XML con 2 facturas que sea de tipo válido según esta DTD.
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
  
  ```

<!--
 <details>
   <summary>PULSA PARA VER LA RESPUESTA:</summary>

 ```xml
<?xml version="1.0" encoding="ISO-8859-1" ?>

<!DOCTYPE cartelera [


 <!ELEMENT cartelera (película)*>
 <!ELEMENT película (título, título_original?, nacionalidad, género, (clasificación | sin_clasificar), sinopsis, director, reparto, web?, cartel?) >
 <!ELEMENT título (#PCDATA)>
 <!ELEMENT título_original (#PCDATA)>
 <!ELEMENT nacionalidad (#PCDATA)>
 <!ELEMENT género (#PCDATA)>
 <!ELEMENT clasificación EMPTY>
 <!ELEMENT sin_clasificar EMPTY>
 <!ELEMENT sinopsis (#PCDATA)>
 <!ELEMENT director (#PCDATA)>
 <!ELEMENT reparto (actor)+>
 <!ELEMENT web (#PCDATA)>
 <!ELEMENT cartel (#PCDATA)>
 <!ELEMENT actor (#PCDATA)>


 <!ATTLIST película código ID #REQUIRED>
 <!ATTLIST película duración CDATA "">
 <!ATTLIST película año CDATA "2003">
 <!ATTLIST clasificación edad (8 | 12 | 16 | 18 | tp) #REQUIRED>
]>
 ```
 </details>
-->

</div>
