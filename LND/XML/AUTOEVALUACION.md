<div align="justify">

# AUTOEVALUACION

- 1.- Los lenguajes de marcas se utilizan para:
  - a) Dar formato a los documentos de texto.
  - b) Definir la estructura de los datos de un documento.
  - c) Permitir el intercambio de ficheros entre diferentes aplicaciones y plataformas.
  - d) Todas las anteriores.

	<details>
	  <summary>PULSA PARA VER LA RESPUESTA CORRECTA:</summary>
	  
	 d
	  
	  ```javascript
	  console.log("I'm a code block!");
	  ```
	  
	</details>


	__RESPUESTA CORRECTA: d)__

- 2.- ¿Cuáles son las características comunes de XML y SGML?
  - a) Guardan el formato de un documento.
  - b) Guardan la estructura lógica de los documentos.
  - c) Guardan los documentos en el formato universal txt.
  - d) Guardan el formato de los documentos independientemente de la plataforma.

	__RESPUESTA CORRECTA: b)__

- 3.- ¿Cuál de las siguientes líneas es correcta?
  - a) <i>Texto en cursiva
  - b) <i>Texto en cursiva<i>
  - c) <i>Texto en cursiva</i>
  - d) <I>Texto en cursiva<I>

	__RESPUESTA CORRECTA: c)__

- 4.- Para escribir un documento XML basta con:
  - a) Software especializado para la tecnología XML
  - b) Herramientas de validación de XML.
  - c) Un block de notas y un navegador.
  - d) Un editor XML.

	__RESPUESTA CORRECTA: d)__

- 5.-Dato el código XML

```xml
<?XML version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<biblioteca>
<documento tipo_docum='libro' titulo='XML práctico' editorial='Ediciones Eni'>
<tipo> <libro isbn='978-2-7460-4958-1' edicion= paginas='347'></libro> </tipo>
<autor nombre='Sebastien Lecomte' funcion=''></autor>
<autor nombre='Thierry Boulanger'></autor>
<autor nombre='Ángel Belinchon Calleja' funcion='traductor'></autor>
<prestado lector='Pepito Grillo'>
<fecha_pres dia='13' mes='mar' año='2009'></fecha_pres>
<fecha_devol/>
</prestado>
</documento> 
</biblioteca>  	
```
 Indica cuales de las siguientes expresiones son errores del código anterior.
  - a) La cadena XML en mayúsculas de la primera línea.
  - b) El atributo edición=
  - c) Los valores de los atributos no están entre comillas dobles.
  - d) Hay algún atributo vacío.
  - e) Algunos elementos tienen más de un atributo.
  - f) Se usan mayúsculas en los datos del documento.

__RESPUESTA CORRECTA:  a) b)__

- 6.-¿Está "bien formado" el siguiente documento XML?

```xml
<?xml version="1.0"? >
<mensaje>
<destinatario>Tomas</destinatario>
<remitente>Juan</ remitente>
<asunto>
<contenido>No olvides ir a recogerme al aeropuerto mañana por la mañana!</contenido>
</mensaje>
```

	__RESPUESTA CORRECTA:  No está "bien formado", porque hay un espacio entre ? y > de la primera línea. Además el cierre de la etiqueta remitente tiene un espacio después de la barra /. Y la etiqueta
asunto no está cerrada.__


</div>

<div align="center">
    <a href="XML_BIEN_FORMADOS.md"><img src="../../img/before.png" alt="XML BIEN FORMADOS" style="width:42px;height:42px;"></a>
    <a href="README.md"><img src="../../img/home.png" alt="XML Home" style="width:42px;height:42px;"></a>
    <a href="EJERCICIOS_RESUELTOS.md"><img src="../../img/next.png" alt="ELERCICICIOS RESUELTOS" style="width:42px;height:42px;"> 
</div>