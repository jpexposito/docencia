<div align="justify">

# Tarea Agenda Telefónica


<div align="center">
  <img width="300px" src="https://www.reab.es/wp-content/uploads/2020/07/agenda-telefonica-678x381.jpg">
</div>  

## Se pide

 Diseñar un documento válido en XML que permita estructurar la información de una agenda de teléfonos, suponer que la información que podemos tener de una persona es su nombre y apellidos, su dirección y sus teléfonos, que pueden ser el teléfono de casa, el móvil y el teléfono del trabajo.

<!--
 <details>
   <summary>PULSA PARA VER LA RESPUESTA CORRECTA:</summary>

   Para la creación del XML definiremos como elemento raíz la “agenda” y posteriormente el elemento contacto que contendrá en su interior el resto de datos de la persona que serían nombre y apellidos, dirección y teléfonos quedando la estructura de la siguiente forma.

   - Elemento raíz __agenda__
	   - Elemento __contacto__	 atributo _numero_, en caso de tener dos personas con el mismo nombre.
		   - Elemento __nombre__
       - Elemento __apellido__
        - __primero__
        - __segundo__
	   - Elemento __direccion__
		   - Elemento __tipo__
		   - Elemento __calle__
		   - Elemento __numero__
		   - Elemento __piso__
		   - Elemento __puerta__
	   - Elemento __telefono__
		   - Elemento __movil__
		   - Elemento __fijo__
		   - Elemento __trabajo__


  El principal motivo por el que se ha elegido realizarlo de esta forma es porque el XML al ser un lenguaje diseñado para organizar el contenido de forma estructurada la forma más clara es desglosando los elementos en lugar de utilizar atributos para definir el número de la calle o el piso y puerta para que la comprensión del XML sea la más sencilla posible.

  ```xml
  <agenda>
	   <contacto numero="1">
			<nombre>Juan</nombre>
			<apellido>
        <primer>Perez</primer>
        <segundo>Hdez</segundo>
      </apellido>  
			<direccion>
        <tipo>avenida</tipo>
        <calle>La juana</calle>
        <numero>1</numero>
        <piso>2</piso>
        <puerta>D</puerta>   
      </direccion>
			<telefono>
				<fijo>91111111</fijo>
				<movil>68888888</movil>
				<trabajo>9222222</trabajo>
			</telefono>
		</persona>
		...
	</contacto>
</agenda>
  ```

</details>
-->
 </div>
