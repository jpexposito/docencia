<div align="justify">

# CATALOGO DE PELICULAS


<div align="center">
  <img width="300px" src="https://www.spgtalleres.com/_images/news/248/7562_modal.jpg">
</div>

## Descripción del Ejercicio

Dado el siguiente documento XML definir un XML schema que valide este documento, teniendo en cuenta las siguientes características:
- El título original de una película sólo aparecerá cuando la película no sea española.
- Es posible que en un momento dado una película esté pendiente de clasificación. En caso de que esté clasificada siempre deberá indicar los años para los que se recomienda: tp (todos los públicos), 8, 12, 16 o 18.
- No siempre existe una web con la información de la película.
- Se quiere guardar información sobre el fichero gráfico que contiene el cartel de la película. Este fichero no siempre está disponible.
- En caso de que no se proporcione el año de una película se asumirá que es el 2003.
- En el reparto deberá aparecer un actor como mínimo.
- Se deben definir los tipos de datos y usar las referencias a elementos que se consideren oportunas.


  El xml a utilizar será:
```xml
?xml version="1.0" encoding="ISO-8859-1" ?>
<cartelera  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:noNamespaceSchemaLocation="XMLSchemaAvanzados06_cartelera.xsd">

  <película código="1" duración="152" año="2002">
 <título>AQUELLAS JUERGAS UNIVERSITARIAS</título>
 <título_original>Old School</título_original>
 <nacionalidad>Estados Unidos</nacionalidad>
 <género>Comedia</género>
 <clasificación edad="tp"/>
 <sinopsis>
 Mitch, Frank y Beanie son tres amigos treintañeros cuyas vidas no son
  exactamente lo que esperaban. Mitch tiene una novia ninfómana que se mete en
 la cama con el primero que agarra. Frank se ha casado y su matrimonio nada
   tiene que ver con las juergas salvajes que organizaban años atrás. Y Beanie es
   un padre de  familia que se muere por recuperar su alocada juventud. Pero las
   cosas cambian cuando Beanie sugiere que creen su propia fraternidad, en la
   nueva casa que Mitch tiene junto al campus de la universidad. Una ocasión para
   revivir tiempos gloriosos, hacer nuevos amigos y de volver a sus viejas,
   salvajes y desmadradas juergas de estudiantes.
 </sinopsis>
 <director>Todd Philips</director>
 <reparto>
 <actor>Luke Wilson</actor>
 <actor>Will Farrel</actor>
 <actor>Vince Vaughn</actor>
 </reparto>
 <web>http://www.uip.es</web>
 <cartel>caratulas/Aquellas juergas.jpg</cartel>
  </película>
  <película código="17" duración="06">
 <título>EL ORO DE MOSCÚ</título>
 <nacionalidad>España</nacionalidad>
 <género>Comedia</género>
 <sin_clasificar/>
 <sinopsis>
   Por una extraña coincidencia del destino, alguien recibe una información
   extraconfidencial de un anciano en sus últimos segundos de vida: el secreto
   mejor guardado de la Historia. El receptor, un trabajador de hospital, se lo
   comunica secretamente a un supuesto amigo. Ambos inician una aventura
   rocambolesca y llena de misterio. Ante la inutilidad de sus intentos y muy a
   su pesar, tienen que recurrir a otras personas que así mismo van cayendo en el
   pozo sin fondo que conlleva descifrar el enigma.
   </sinopsis>
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
Se pide realizar el fichero __xsd__, que realice la validación, con las restricciones indicadas.

<!--
<details>
  <summary>PULSA PARA VER LA SOLUCIÓN CORRECTA:</summary>

  - Un xsd válido sería:

  ```
  <?xml version="1.0" encoding="ISO-8859-1" ?>
  <xsd:schema xmlns:xsd = "http://www.w3.org/2001/XMLSchema">
  <xsd:element name="t?ulo" type="xsd:string"/>
  <xsd:element name="t?ulo_original" type="xsd:string"/>
  <xsd:element name="nacionalidad" type="xsd:string"/>
  <xsd:element name="g?ero" type="xsd:string"/>
  <xsd:element name="clasificaci?" type="tipoClasificaci?"/>
  <xsd:element name="sin_clasificar"/>
  <xsd:element name="sinopsis" type="xsd:string"/>
  <xsd:element name="director" type="xsd:string"/>
  <xsd:element name="reparto" type="tipoReparto"/>
  <xsd:element name="web" type="xsd:string"/>
  <xsd:element name="cartel" type="xsd:string"/>
  <xsd:element name="actor" type="xsd:string"/>
  <xsd:simpleType name="tipoEdad">
  	<xsd:restriction base="xsd:string">
  		<xsd:enumeration value="tp"/>
  		<xsd:enumeration value="8"/>
  		<xsd:enumeration value="12"/>
  		<xsd:enumeration value="16"/>
  		<xsd:enumeration value="18"/>
  	</xsd:restriction>
  </xsd:simpleType>
  <xsd:complexType name="tipoPelicula">
  	<xsd:sequence>
  		<xsd:element ref="titulo"/>
  		<xsd:element ref="titulo_original" minOccurs="0"/>
  		<xsd:element ref="nacionalidad"/>
  		<xsd:element ref="g?ero"/>
  		<xsd:choice>
  			<xsd:element ref="clasificacion"/>
  			<xsd:element ref="sin_clasificar"/>
  		</xsd:choice>
  		<xsd:element ref="sinopsis"/>
  		<xsd:element ref="director"/>
  		<xsd:element ref="reparto"/>
  		<xsd:element ref="web" minOccurs="0"/>
  		<xsd:element ref="cartel" minOccurs="0"/>
  	</xsd:sequence>
  	<xsd:attribute name="codigo" type="xsd:positiveInteger"/>
  	<xsd:attribute name="duracion" type="xsd:positiveInteger"/>
  	<xsd:attribute name="a?" type="xsd:positiveInteger" default="2003"/>
  </xsd:complexType>
  <xsd:complexType name="tipoReparto">
  	<xsd:sequence>
  		<xsd:element ref="actor" maxOccurs="unbounded"/>
  	</xsd:sequence>
  </xsd:complexType>
  <xsd:complexType name="tipoClasificacion">
  	<xsd:simpleContent>
  	<xsd:extension base="xsd:string">
  		<xsd:attribute name="edad" type="tipoEdad" use="required"/>
  	</xsd:extension>
  	</xsd:simpleContent>
  </xsd:complexType>
  <xsd:element name="pelicula" type="tipoPelicula"/>
  <xsd:element name="cartelera">
  	<xsd:complexType>
  		<xsd:sequence>
  			<xsd:element ref="peliula"  maxOccurs="unbounded"/>
  		</xsd:sequence>
  	</xsd:complexType>
  </xsd:element>
</xsd:schema>
  ```
  -->

</details>
