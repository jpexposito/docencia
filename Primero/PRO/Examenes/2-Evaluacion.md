<div align="justify">

<img src="img/ultramarinos.png">

Vamos a desarrollar un sistema de gestión de inventario para una cadena de tiendas de ultramarinos. El sistema debe manejar productos de diferentes categorías, como __alimentos, aparatos electrónicos, souvenirs y productos de cuidado personal__. Cada categoría de producto tiene sus propias características y restricciones, que a continuación se describen:

- Define tres interfaces llamadas __IVendible, ISaludable y IRecomendable__:
  - __IVendible__ debe tener métodos para __calcular el (float) precio máximo y la (int) cantidad disponible de un producto__.
  - __ISaludable__ debe tener métodos para calcular __(int) cuántos días quedan hasta la caducidad del producto__ y __(boolean) verificar si el producto está caducado__.
  - __IRecomendable__ debe tener métodos para __(boolean) recomendar el producto (popularidad > 7)__ y __(int) calcular su popularidad__ _(retorna la popularidad del producto)_.
- Crea tres clases abstractas llamadas __Producto, ProductoFresco  y ProductoRecomendable__:
  - __Producto__ debe implementar la interfaz __IVendible__ y contener las propiedades comunes a todos los productos: _nombre (String), precio(String), fecha de entrada (String) y un identificador único (String)_.
  - __ProductoFresco__ debe extender __Producto__ e implementar la interfaz __ISaludable__. Esta clase debe incluir una propiedad adicional para la __fecha de caducidad(String)__.
  - __ProductoRecomendable__ debe extender __Producto__ e implementar la interfaz __IRecomendable__. Esta clase debe incluir métodos para __recomendar el producto__ _(popularidad > 7)_ y __calcular su popularidad__ _(retorna el valor de la propiedad)_.
- Implementa las siguientes clases con sus respectivas características:
-  __Alimento__: debe ser una subclase de __ProductoFresco__ y debe tener un método para __(int) calcular la cantidad de días antes de la caducidad__ y para __(boolean) verificar si está caducado__. Calcular el precio __máximo (1,35*precio)__.
- __Aparato__: debe ser una subclase de __Producto__ y debe tener un método para (float) calcular el precio __máximo (1,42*precio)__.
- __Souvenir__: debe ser una subclase de __Producto__ y debe tener un método para (float) calcular el precio __máximo(1,3*precio)__.
- __CuidadoPersonal__: debe ser una subclase de ProductoRecomendable y debe incluir métodos para recomendar el producto y calcular su popularidad,calcular el precio __máximo (1,8*precio)__.
- Crea una clase Tienda que tenga las siguientes características:
- Debe contener listas __(List/Set/HasMap)__ para almacenar _cada tipo de producto_.
- Debe tener métodos para _agregar, eliminar y obtener productos de cada lista_.
- Debe incluir métodos para _calcular el precio total de cada tipo de producto_ y el _precio total de todos los productos en la tienda_. _(Los alimentos caducados no se pueden vender)_.
- Debe de tener un método que _calcule cual es la ganancia de cada una de las listas de los productos y de toda la tienda_. (Los alimentos caducados no se pueden vender).
- Implementa un método que muestre la _cantidad de productos disponibles de cada uno de los tipos que existe_.
- Asegúrate de manejar adecuadamente la duplicación de productos y de verificar su existencia antes de realizar operaciones de añadir, eliminar u obtener.
- Implementa un menú interactivo que permita al usuario realizar operaciones como añadir, mostrar, eliminar y modificar productos en la tienda.
- Un producto de cuidado personal, se considera cuando tiene una popularidad de mayor o igual a 7.
- Implementa un método que muestre aquellos productos que muestren aquellos que lo cumplen.
- Asegúrate de hacer uso de las interfaces y clases abstractas definidas previamente en tus implementaciones.

</div>