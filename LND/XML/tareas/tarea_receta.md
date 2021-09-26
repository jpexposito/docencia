<div align="justify">

# Tarea Receta Cocina

<div align="center">
  <img width="300px" src="https://www.trecebits.com/wp-content/uploads/2020/05/Cocina-800x445.jpg">
</div>

## Se pide

Diseñar un documento válido en XML que permita estructurar la información de las recetas de cocina de un restaurante y aplicarlo a la siguiente receta de cocina. Hay que hacerlo de modo que un sistema informático pueda realizar búsquedas por ingredientes, cantidad de comensales o nombre de la receta.

__Sopa de cebolla (4 personas)__

Ingredientes:
- 1 Kg. de cebollas.
- 2 l. de caldo de carne.
- 100 gr. mantequilla.
- 1 cucharada de harina.
- 100 gr. de queso emmental suizo o gruyére rallado.
- Pan tostado en rebanadas.
- Tomillo.
- 1 hoja de laurel.
- Pimienta.

Proceso:
- Pelar y partir las cebollas en rodajas finas.
- Rehogarlas con la mantequilla, sal y pimienta a fuego lento hasta que estén transparentes sin dorarse.
- Añadir la harina sin dejar de remover.
- Ponerlo en una cazuela con el caldo, el tomillo y el laurel.
- Dejar cocer a fuego lento durante unos 15 minutos.
-Poner las rebanadas de pan encima, espolvorear el queso y gratinar al horno.

<!--
 <details>
   <summary>PULSA PARA VER LA RESPUESTA CORRECTA:</summary>

 La estructura del XML para estructurar la información de las recetas de cocina es la siguiente:
- Elemento raíz recetas
	- Elemento __receta__
		- Elemento __nombre__
		- Elemento __comensales__
		- Elemento __ingredientes__
      - Elemento __ingrediente__ , atributos: _unidad_, _cantidad_
		Elemento __elaboracion__
			Elemento __paso__	, atributos _numero_


 Dentro del enunciado se especifica que el sistema informático que va a trabajar con el __XML__ utilizará el _nombre de la receta_, el _número de comensales_ y los _ingredientes_ para clasificar las recetas por ese motivo cada uno de ellos es un elemento dejando como atributos la cantidad de ingredientes o la unidad de medida de los mismos quedando el XML diferenciado en 4 partes: __la primera__ es el _nombre_ de la receta que se va a elaborar, el _número_ de comensales y los _ingredientes_ que a su vez se compone del elemento ingrediente donde se especifica cada uno de los ingredientes que se van a usar para preparar la receta, la _cantidad_ de ingredientes y la _unidad_ de medida. Finalmente, el __último__ elemento es la elaboración que incluye diferentes pasos para realizar la receta, donde el _número del paso_ es un atributo.

 ```xml
 <?xml version="1.0" encoding="UTF-8"?>
<recetas>
  <receta>
    <nombre>Sopa de cebolla</nombre>
    <comensales>4 personas</comensales>
    <ingredientes>
          <ingrediente cantidad="1" unidad="kilos">cebollas</ingrediente>
          <ingrediente cantidad="2" unidad="litros">caldo de carne</ingrediente>
          <ingrediente cantidad="100" unidad="gramos">mantequilla</ingrediente>
          <ingrediente cantidad="1" unidad="cucharada">harina</ingrediente>
          <ingrediente cantidad="100" unidad="gramos">queso emmental suizo o gruyére rallado</ingrediente>
          <ingrediente cantidad="al gusto" unidad="rebanadas">pan tostado</ingrediente>
           <ingrediente cantidad="1" unidad="hoja">laurel</ingrediente>
          <ingrediente>tomillo</ingrediente>
          <ingrediente>pimienta</ingrediente>
    </ingredientes>
    <elaboracion>
      <paso numero="1">Pelar y partir las cebollas en rodajas y finas</paso>
      <paso numero="2">Rehogarlas con la mantequilla, sal y pimienta a fuego lento hasta que estén transparentes sin dorarse</paso>
      <paso numero="3">Añadir la harina sin dejar de remover</paso>
      <paso numero="4">Ponerlo en una cazuela con el caldo, el tomillo y el laurel</paso>
      <paso numero="5">Dejar cocer a fuego lento durante 15 minutos</paso>
      <paso numero="6">Poner las rebanadas de pan encima. espolvorear el queso y gratinar en el horno</paso>
    </elaboracion>
  </receta>
</recetas>
 ```
 </details>
 -->

</div>
