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

Como vemos, la etiqueta __<persona>__ no la hemos llamado __<persona1>, <persona2>__, etc. Sería un error. No es necesario numerar, ya que el orden en que se escriben las personas ya puede indicar su numeración.
No tenemos algunos datos, por ejemplo el teléfono del trabajo de la primera persona; en ese caso se puede poner el elemento vacío: __<teltrabajo/>__. Otra opción en esta situación es no incluir el elemento en cuestión (no escribirlo), como hemos hecho con el piso de la segunda persona, que simplemente no está puesto el elemento. Es aconsejable la primera opción, es decir ponerlo vacío. Lo mismo ocurre con los atributos, que pueden dejarse vacíos, como el número de la primera persona (numero=""), o no ponerlos.

Los comentarios colocados entre __<!-- ... -->__ no son obligatorios; se pueden utilizar como
notas aclaratorias.


	</details>

</div>

<div align="center">
    <a href="XML.md"><img src="../../img/before.png" alt="Etiquetas" style="width:42px;height:42px;"></a>
    <a href="README.md"><img src="../../img/home.png" alt="XML Home" style="width:42px;height:42px;"></a>
    <a href="ESPACIO_NOMBRES.md"><img src="../../img/next.png" alt="XML" style="width:42px;height:42px;"> 
</div>