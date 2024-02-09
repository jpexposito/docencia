
<div align="justify">

# Ejercicios de List/Set/HashMap clases abstractas e interfaces.

Teniendo como referencia: la documentación, los ejemplos realizados en clase, y los que se encuentran en el siguiente [enlace](../../Ejemplos/), además de la documentación [proporcionada](../../README.md).

Vamos a realizar una aplicación para llevar la contabilidad de una tienda.

Para ello crea las siguientes estructuras y clases:

Realiza:

- Crea una __interfaz__ llamada __IProducto__ que contenga los siguientes métodos:
  - float precioMaximo();
  - int cantidadDisponible();
- Crea una clase __abstracta__ llamada __Producto__, que implementa __IProducto__ con las siguientes propiedades:
  - nombre (String).
  - precio (float).
  - fechaEntrada(String).
  - udi(String).

  >__Nota__: Crea los contructores, getters/setters necesarios, asi como los métodos __toString()__, y __equals()__. Además el __udi__ es el identificador único de un producto.

- Crea la clase __Alimento__ que __extiente__ de __Producto__ y que permite como precio máximo, su precio * __1,23__.
  - Además posee un método:
    - int diasDisponible(). Qué calcula cuantos días sobre la fecha de entrada del alimento, estará este sin caducar (fechaActual - fechaEntrada).
    - boolean caducado(). Función que determina si un alimento esta caducado. (__mayor a 30 dias de diferencia__).
- Crea la clase __Electronica__ que __extiente__ de __Producto__ y que permite como precio máximo, su precio * __1,6__.
- Crea la clase __Soubenir__ que __extiente__ de __Producto__ y que permite como precio máximo, su precio * __1,4__.
- Crea una clase llamada __Supermercado__ que contenga:
  - List<Alimento> alimentos de tipo __HashSet__.
  - List<Electronica> electronica de tipo __ArrayList__.
  - HasMap<Soubenir> soubenirs de tipo __HashMap__.
  - Crea los siguientes métodos:
    - addAlimento.
    - removeAlimento.
    - obtenerAlimento.
    - addElectronica.
    - removeElectronica.
    - obtenerElectronica.
    - addSoubenir.
    - removeSoubenir.
    - obtenerSoubenir.
    - obtenerAlimientosCaducados.
    - precioAlimentos.
    - precioElectronica.
    - precioSoubenirs.
    - precioProductos.
>__Nota__: _No se permiten elementos duplicados_. Verifica que existe siempre el elemento antes de (__añadir/eliminar/obtener__);

- __Crea los métodos necesarios (menú) para__:
  - Añadir.
  - Mostrar.
  - Eliminar.
  - Modificar.
    >__Nota__: _Para cualquier tipo de elemento_.

Estrucura de la solución que se pretende:

```code
es.ies.puerto.abstractas
  
es.ies.puerto.interfaces
  
es.ies.puerto.productos
  
es.ies.puerto.app
  AppTienda
```

Elementos para verificar el correcto funcionamiento:

- Alimentos
  ```csv
  nombre,precio,fechaEntrada,udi
  Alimento1,2.50,2024-01-01,udi1
  Alimento2,3.50,2024-01-02,udi2
  Alimento3,4.50,2024-01-03,udi3
  Alimento4,5.50,2024-01-04,udi4
  Alimento5,6.50,2024-01-05,udi5
  Alimento6,7.50,2024-01-06,udi6
  Alimento7,8.50,2024-01-07,udi7
  Alimento8,9.50,2024-01-08,udi8
  Alimento9,10.50,2024-01-09,udi9
  Alimento10,11.50,2024-01-10,udi10
  ```

- Electronica
  ```csv
  nombre,precio,fechaEntrada,udi
  Electronico1,500.00,2022-02-01,udi1
  Electronico2,501.00,2022-02-02,udi2
  Electronico3,502.00,2022-02-03,udi3
  Electronico4,503.00,2022-02-04,udi4
  Electronico5,504.00,2022-02-05,udi5
  Electronico6,505.00,2022-02-06,udi6
  Electronico7,506.00,2022-02-07,udi7
  Electronico8,507.00,2022-02-08,udi8
  Electronico9,508.00,2022-02-09,udi9
  Electronico10,509.00,2022-02-10,udi10
  ```

- Soubenirs
  ```csv
  nombre,precio,fechaEntrada,udi
  Soubenir1,10.00,2022-03-01,udi1
  Soubenir2,11.00,2022-03-02,udi2
  Soubenir3,12.00,2022-03-03,udi3
  Soubenir4,13.00,2022-03-04,udi4
  Soubenir5,14.00,2022-03-05,udi5
  Soubenir6,15.00,2022-03-06,udi6
  Soubenir7,16.00,2022-03-07,udi7
  Soubenir8,17.00,2022-03-08,udi8
  Soubenir9,18.00,2022-03-09,udi9
  Soubenir10,19.00,2022-03-10,udi10
  ```


</div>