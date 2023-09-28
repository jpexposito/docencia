<div align="justify">

# Sistema Gestión de ventas de Automóviles

<div align="center">
<img src="img/venta-coche.png" width="400px"/>
</div>

“Se desea diseñar una base de datos para almacenar y gestionar la información empleada por una empresa dedicada a la venta de automóviles, teniendo en cuenta los siguientes aspectos: La empresa dispone de una serie de coches para su venta. Se necesita conocer la matrícula, marca y modelo, el color y el precio de venta de cada coche. Los datos que interesa conocer de cada cliente son el NIF, nombre, dirección, ciudad y número de teléfono: además, los clientes se diferencian por un código interno de la empresa que se incrementa automáticamente cuando un cliente se da de alta en ella. Un cliente puede comprar tantos coches como desee a la empresa. Un coche determinado solo puede ser comprado por un único cliente. El concesionario también se encarga de llevar a cabo las revisiones que se realizan a cada coche. Cada revisión tiene asociado un código que se incrementa automáticamente por cada revisión que se haga. De cada revisión se desea saber si se ha hecho cambio de filtro, si se ha hecho cambio de aceite, si se ha hecho cambio de frenos u otros. Los coches pueden pasar varias revisiones en el concesionario”.

Se pide:
1. Identifica las posibles __entidades y las relaciones__.
2. Proponer las frases que describan el problema.
3. Generar los entidades y relaciones de cada frase que hayas detectado, sin indicar cardinalidad, etc.
4. Monta correctamente todas las entidades y sus relaciones.
5. Colocar los atributos a cada entidad e interrelación.
6. Indica la cardinalidad de las relaciones.

__Recuerda que__:
- Rombo: Relación con la entidad.
- Rectángulo: Entidades
- Ovalo: Atributos
- (x,y): Cardinalidad; estas hacen referencia ala cantidad de relación entre una entidad y otra.
- Atributo subrayado: Es el campo clave o índice; este ordena toda la información.

<details>
      <summary>Paso 1</summary>

| Sustantivos | Verbos |
| -- | -- |
|  Automóviles, Cliente, Revisión  |  Necesitar, Conocer, LLevar, Comprar, Desear, Realizar  |

Propiedades:
- Automóvil: Matrícula, marca, modelo, color y precio.
- Cliente: RFC, nombre, dirección, ciudad y número de teléfono.
- Revisión: Código, cambio de filtro, cambio de aciete y cambio de frenos.

</details>

<details>
      <summary>Entidaddes-Relaciones</summary>

  </br>
  <img src="img/automoviles-relaciones.drawio.png">
  </br>
  
</details>

<details>
      <summary>Diagrama</summary>

  </br>
  <img src="img/automoviles-diagrama.drawio.png">
  </br>
  
</details>


</div>