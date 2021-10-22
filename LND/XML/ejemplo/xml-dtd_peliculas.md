<div align="justify">

# Ejercicio Clase Película


<div align="center">
  <img src="https://imagenes.20minutos.es/files/image_656_370/uploads/imagenes/2020/04/28/cine-peliculas-estreno-plataformas-streaming-00.png">
</div>

## Se pide

  Definir una DTD que valide el documento XML que se muestra a continuación. ___Corrige aquello que consideres importante___.
  Se deben tener en cuenta las siguientes características:
  - El título original de una película sólo aparecerá cuando la película no sea española.
  - Es posible que en un momento dado una pelicula esté pendiente de clasificación. En caso de que esté clasificada siempre deberá indicar los años para los que se recomienda: tp (todos los públicos), 8, 12, 16 o 18.
  - No siempre existe una web con la información de la película.
  - Se quiere guardar información sobre el fichero gráfico que contiene el cartel de la película. Este fichero no siempre está disponible.
  - En caso de que no se proporcione el año de una película se asumirá que es el 2003.
  - En el reparto deberá aparecer un actor como mínimo.

  Ejemplo de xml:
  ```xml
  <cartelera>
  <película código="p1" duración="152" año="2002">
    <título>AQUELLAS JUERGAS UNIVERSITARIAS</título>
    <título_original>Old School</título_original>
    <nacionalidad>Estados Unidos</nacionalidad>
    <género>Comedia</género>
    <clasificación edad="tp"/>
    <sinopsis>Mitch, Frank y Beanie son tres amigos treintañeros cuyas vidas no son exactamente lo que esperaban. Mitch tiene una novia ninfómana que se mete en la cama con el primero que agarra. Frank se ha casado y su matrimonio nada
tiene que ver con las juergas salvajes que organizaban años atrás. Y Beanie es
un padre de familia que se muere por recuperar su alocada juventud. Pero las cosas cambian cuando Beanie sugiere que creen su propia fraternidad, en la nueva casa que Mitch tiene junto al campus de la universidad. Una ocasión para revivir tiempos gloriosos, hacer nuevos amigos y de volver a sus viejas, salvajes y desmadradas juergas de estudiantes.</sinopsis>
    <director>Todd Philips</director>
    <reparto>
      <actor>Luke Wilson</actor>
      <actor>Will Farrel</actor>
      <actor>Vince Vaughn</actor>
    </reparto>
    <web>http://www.uip.es</web>
    <cartel>caratulas/Aquellas juergas.jpg</cartel>
  </película>
  <película código="p17" duración="06">
    <título>EL ORO DE MOSCÚ</título>
    <nacionalidad>España</nacionalidad>
    <género>Comedia</género>
    <sin_clasificar/>
    <sinopsis>Por una extraña coincidencia del destino, alguien recibe una información extraconfidencial de un anciano en sus últimos segundos de vida: el secreto mejor guardado de la Historia. El receptor, un trabajador de hospital, se lo comunica secretamente a un supuesto amigo. Ambos inician una aventura rocambolesca y llena de misterio. Ante la inutilidad de sus intentos y muy a
su pesar, tienen que recurrir a otras personas que así mismo van cayendo en el pozo sin fondo que conlleva descifrar el enigma.</sinopsis>
    <director>Jesús Bonilla</director>
    <reparto>
      <actor>Jesús Bonilla</actor>
      <actor>Santiago Segura</actor>
      <actor>Alfredo Landa</actor>
      <actor>Concha Velasco</actor>
      <actor>Antonio Resines</actor>
      <actor>Gabino Diego, María Barranco</actor>
      <actor>María Barranco</actor>
    </reparto>
  </película>
</cartelera>
  ```

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

</div>
