<div align="justify">

# EJERCICIOS RESUELTOS

## EJERCICIO 1

 Para crear los códigos XML descargaremos el programa "XML Copy Editor", como hemos indicado anteriormente, y lo instalamos en nuestro equipo. Aunque ya este programa nos indica si el documento XML está "Bien-Formado", es conveniente pasarlo por el validador de W3C (por ser la institución oficial).

Un ejemplo es el siguiente. Se desea diseñar un documento XML "bien formado" que permita almacenar una agenda de teléfonos, con una estructura lógica y fácilmente legible. La agenda tendrá el título "Agenda para el trabajo" y la categoría "Importante". De cada persona se desea almacenar el nombre y los apellidos, la dirección (calle, piso, ciudad y CP) y los números de teléfono de casa, trabajo y móvil. Grabar la menos dos personas con los datos:

- Juan Garrido Pinto, en calle Grande, piso 1, letra A, de Badajoz, con CP 06003; tiene 2 teléfonos, el móvil 622111111 y el de casa 942232323.

- Jesús Rodríguez Hdez., en calle Mayor, nº 7, de Zafra, con CP 06300; tiene 3 teléfonos, el móvil 611333333, el de casa 924000000 y el del trabajo 924999999. 

<details>
	  <summary>PULSA PARA VER LA RESPUESTA CORRECTA:</summary>

```xml
<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<!-- Documento XML: almacenamiento de una agenda personal -->
<agenda titulo="Agenda para el trabajo">
 <categoria>Importante</categoria>
 <persona>
	 <nombre>Juan</nombre>
	 <apellidos>Garrido Pinto</apellidos>
	 <direccion>
	 	<calle numero="">Grande</calle>
		 <piso letra="A">1</piso>
		 <ciudad>Badajoz</ciudad>
		 <codigo_postal>06003</codigo_postal>
	</direccion>
	<telefonos>
	 	<telmovil>622111111</telmovil>
	 	<telcasa>942232323</telcasa>
	 	<teltrabajo/> <!-- No tiene tfno del trabajo -->
	</telefonos>
 </persona>
 <persona>
	 <nombre>Jesús</nombre>
	 <apellidos>Rodríguez Hdez.</apellidos>
	 <direccion>
		 <calle numero="7">Mayor</calle>
		 <!-- No tiene piso -->
		 <ciudad>Zafra</ciudad>
		 <codigo_postal>06300</codigo_postal>
	</direccion>
	<telefonos>
	 <telmovil>611333333</telmovil>
	 <telcasa>924000000</telcasa>
	 <teltrabajo>924999999</teltrabajo>
	</telefonos>
 </persona>
</agenda>
```

Como vemos, la etiqueta __<persona>__ no la hemos llamado __<persona1>__, __<persona2>__, etc. Sería un error. No es necesario numerar, ya que el orden en que se escriben las personas ya puede indicar su numeración.
No tenemos algunos datos, por ejemplo el teléfono del trabajo de la primera persona; en ese caso se puede poner el elemento vacío: __<teltrabajo/>__. Otra opción en esta situación es no incluir el elemento en cuestión (no escribirlo), como hemos hecho con el piso de la segunda persona, que simplemente no está puesto el elemento. Es aconsejable la primera opción, es decir ponerlo vacío. Lo mismo ocurre con los atributos, que pueden dejarse vacíos, como el número de la primera persona (numero=""), o no ponerlos.

Los comentarios colocados entre __<!-- ... -->__ no son obligatorios; se pueden utilizar como
notas aclaratorias.


</details>



## EJERCICIO 2

 Diseñar un documento XML "bien formado" que permita estructurar de forma correcta y lógica la información de los préstamos en una biblioteca.

 La biblioteca tiene el nombre "Biblioteca El Estudio", con dirección: calle Mayor, 3, en Villapuebla. La biblioteca tiene documentos. Cada documento tiene su tipo (libro, revista, artículo, etc.), título y editorial, además de varios autores. Cada autor tiene nombre; además el autor también podría tener función. Los datos de cada documento prestado serán el lector, la fecha del préstamo (día, mes y año) y la fecha de devolución (que puede estar vacía).

El documento XML debe tener grabados los siguientes datos:
 - Libro con título "Programación básica", de la editorial "PSP". Sus 2 autores son: Juan García y Manuel López, cuya función es "Revisión técnica"; se ha prestado a José Pinto el 3 de octubre de 2015 y lo ha devuelto el 9.
- Revista con título "Ordenadores Plus", de la editorial "ZEF". Sus 3 autores son: David Hernández, José Ramírez y Fernando Gómez; se ha prestado a "Ramón Rivas" el 5 de octubre de 2015 y aún no lo ha devuelto.

<details>
	  <summary>PULSA PARA VER LA RESPUESTA CORRECTA:</summary>

```xml
<?xml version="1.0" encoding="iso-8859-1" standalone="yes"?>
<!-- Préstamos de una biblioteca -->
<biblioteca>
	<nombre>Biblioteca El Estudio</nombre>
	<direccion calle="Mayor" numero="3" localidad="Villapuebla" />
	<lista_documentos>
		<documento tipo="libro" editorial="PSP">
			<titulo>Programación básica</titulo>
			<autores>
				<autor>Juan García</autor>
				<autor funcion="Revisión técnica">Manuel López</autor>
				<!-- Este autor realiza la revisión del libro -->
			</autores>
			<prestado>
				<lector>José Pinto</lector>
				<fecha_pres>
					<dia>3</dia>
					<mes>octubre</mes>
					<anio>2015</anio>
				</fecha_pres>
				<fecha_devol>
					<dia>9</dia>
					<mes>octubre</mes>
					<anio>2015</anio>
				</fecha_devol>
			</prestado>
		</documento>
		<documento tipo="revista" editorial="ZEF">
			<titulo>Ordenadores Plus</titulo>
			<autores>
				<autor>David Hernández</autor>
				<autor>José Ramírez</autor>
				<autor>Fernando Gómez</autor>
			</autores>
			<prestado>
				<lector>Ramón Rivas</lector>
				<fecha_pres>
					<dia>5</dia>
					<mes>octubre</mes>
					<anio>2015</anio>
				</fecha_pres>
				<fecha_devol/>
				<!-- Aún no se ha devuelto -->
			</prestado>
		</documento>
	</lista_documentos>
</biblioteca>
```

 Este código se ha escrito con el programa "Sublime Text" en un fichero de texto con extensión .xml. Se ha comprobado si está __Bien-Formado__, instalando el publin __Indent X__.
 
 Debe observarse que algunos datos se han guardado como elementos y otros como atributos. Además se han incorporado comentarios al documento. Cabe destacar que los datos que tienen varias partes (como la dirección y las fechas) se guardan separando cada parte. No es conveniente guardar todo el dato en un sólo elemento o atributo: Es decir, las siguientes líneas no conviene usarlas:

```xml
<dirección>C/ Mayor, 3 - Villapuebla</direccion>
<fecha_pres>5 de octubre de 2015</fecha_pres>Es mucho mejor el siguiente código:
<direccion calle="Mayor" numero="3" localidad="Villapuebla" />
<fecha_pres>
	<dia>5</dia>
	<mes>octubre</mes>
	<anio>2015</anio>
</fecha_pres>
```
 Como se ve, se han evitado las vocales con tilde y la ñ en los nombres de elementos y atributos (direccion, numero, anio, etc.).

 Posteriormente el código se ha validado pegándolo en la página http://validator.w3.org/#validate_by_input donde han aparecido 2 avisos ("warnings"), pero ningún error, por lo que el documento está "bien formado". A continuación se ha abierto el fichero .xml con el navegador web. Al estar "bien formado" no aparecen errores y el resultado que muestra es:

 <?xml version="1.0" encoding="iso-8859-1" standalone="yes"?>
<!-- Préstamos de una biblioteca -->
<biblioteca>
	<nombre>Biblioteca El Estudio</nombre>
	<direccion calle="Mayor" numero="3" localidad="Villapuebla" />
	<lista_documentos>
		<documento tipo="libro" editorial="PSP">
			<titulo>Programación básica</titulo>
			<autores>
				<autor>Juan García</autor>
				<autor funcion="Revisión técnica">Manuel López</autor>
				<!-- Este autor realiza la revisión del libro -->
			</autores>
			<prestado>
				<lector>José Pinto</lector>
				<fecha_pres>
					<dia>3</dia>
					<mes>octubre</mes>
					<anio>2015</anio>
				</fecha_pres>
				<fecha_devol>
					<dia>9</dia>
					<mes>octubre</mes>
					<anio>2015</anio>
				</fecha_devol>
			</prestado>
		</documento>
		<documento tipo="revista" editorial="ZEF">
			<titulo>Ordenadores Plus</titulo>
			<autores>
				<autor>David Hernández</autor>
				<autor>José Ramírez</autor>
				<autor>Fernando Gómez</autor>
			</autores>
			<prestado>
				<lector>Ramón Rivas</lector>
				<fecha_pres>
					<dia>5</dia>
					<mes>octubre</mes>
					<anio>2015</anio>
				</fecha_pres>
				<fecha_devol/>
				<!-- Aún no se ha devuelto -->
			</prestado>
		</documento>
	</lista_documentos>
</biblioteca>
```


</div>
<div align="center">
    <a href="XML.md"><img src="../../img/before.png" alt="Etiquetas" style="width:42px;height:42px;"></a>
    <a href="README.md"><img src="../../img/home.png" alt="XML Home" style="width:42px;height:42px;"></a>
    <a href="ESPACIO_NOMBRES.md"><img src="../../img/next.png" alt="XML" style="width:42px;height:42px;"> 
</div>