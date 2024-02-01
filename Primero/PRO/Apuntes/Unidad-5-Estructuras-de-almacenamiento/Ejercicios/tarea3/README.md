
<div align="justify">

# Ejercicios de HashMap

Teniendo como referencia: la documentación, los ejemplos realizados en clase, y los que se encuentran en el siguiente [enlace](../../Ejemplos/), además de la documentación [proporcionada](../../Map/README.md).

_Primera Parte_
---

Esta parte de la tarea se corresponde con la actividad realizada en la [tarea2](../tarea2/).

_Segunda Parte_
---
Nuestro concecionario sigue creciendo e incluye dos nuevos tipos de __vehículos__:{__caminiones y bicicletras__}.

Para lograrlo:
- Crea la clase __Camion__ que __extiente__ de __Vehiculo__ y que permite como velocidad máxima __160__.
- Crea la clase __Bicicleta__ que __extiente__ de __Vehiculo__ y que permite como velocidad máxima __40__.
- Añade dos nuevos __hasmap__ de elemetos, para la gestión de estos elementos:
  - HasMap<Camion> _camiones_ de tipo __HashMap__.
    - Crea los siguientes métodos:
      - boolean addCamion(Camion camion);
      - boolean removeCamion(Camion camion);
      - Camion obtenerCamion(String matricula);
        >__Nota__: Verifica que existe siempre el elemento antes de (__añadir/eliminar/obtener__);
      - float velocidadMediaCamiones().
  - HasMap<Bicicleta> _bicicletras_ de tipo __HashMap__.
    - Crea los siguientes métodos:
      - boolean addBicicleta(Bicicleta bicicleta);
      - boolean removeBicicleta(Bicicleta bicicleta);
      - Bicicleta obtenerBicicleta(String matricula);
        >__Nota__: Verifica que existe siempre el elemento antes de (__añadir/eliminar/obtener__);
      - float velocidadMediaBicicletas().

>__Nota__: Datos para realizar las pruebas:

- Camiones

  ```csv
  marca,modelo,matricula,velocidad
  Chevrolet,Silverado,UVW567,150
  Ford,Ranger,LMN890,130
  Toyota,Hilux,PQR123,140
  Nissan,Navara,ABC456,145
  Dodge,Ram,XYZ789,160
  ```

- Bicicletas

  ```csv
  Trek,MountainBike,PQR456,30
  Giant,CityBike,MNO789,25
  Specialized,RoadBike,JKL012,28
  Cannondale,HybridBike,DEF345,26
  Schwinn,Cruiser,MNO678,22
  ```

- __Mejora__ la clase __AppConcecionario__ que haga uso de Concecionario, cargue sus los datos del concecionario y utilice cada uno de los métodos que se piden.
- __CREA LA CLASE O MÉTODOS NECESARIOS PARA SOLICITAR POR TECLADO UN ELEMENTOS DE CUALQUIERA DE LOS TIPOS DE VEHÍCULOS CREADOS, PUDIENDO__:
  - Insertar.
  - Modifificar.
  - Eliminar.
  - VelicidadMedia.
- __Crea los métodos necesarios (menú) para__:
  - Añadir.
  - Mostrar.
  - Eliminar.
  - Modificar.
    >__Nota__: _Para cualquier tipo de elemento (Coche/Camión/Moticicletra/Bicicleta)_.
  - Mostrar la velicidad Media de _(Coches/Camiones/Moticicletras/Bicicletas)_.
Estrucura de la solución que se pretende:

```code
es.ies.puerto.abstractas
  Vehiculo
es.ies.puerto.interfaces
  IVehiculo
es.ies.puerto.vehiculos
  Coche.
  Motocicleta.
  Bicicleta
  Camion
  Concesionario
es.ies.puerto.app
  AppConcecionario
```	
<

</div>