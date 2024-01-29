
<div align="justify">

# Ejercicios de HashSet

Teniendo como referencia: la documentación, los ejemplos realizados en clase, y los que se encuentran en el siguiente [enlace](../../Ejemplos/).

_Primera Parte_
---

Realiza:
- Crea una __interfaz__ llamada __IVehiculo__ que contenga los siguientes métodos:
  - int velocidadMaxima();
- Crea una clase __abstracta__ llamada __Vehiculo__, con las siguientes propiedades:
  - marca (String).
  - modelo (String).
  - matricula (String).
  - velocidad int.
  >__Nota__: Crea los contructores, getters/setters necesarios, asi como los métodos __toString()__, y __equals()__. Además la clase __implementa__ los métodos de __IVehiculo__.

- Crea la clase Coche que __extiente__ de __Vehículo__ y que permite como velocidad máxima __180__.
- Crea la clase __Motocicleta__ que __extiente__ de __Vehiculo__ y que permite como velocidad máxima __120__.
- Crea una clase llamada __Concesionario__ que contenga:
  - List<Coche> coches de tipo __HashSet__.
  - List<Motocicleta> motocicletas de tipo __ArrayList__.
  - Crea los siguientes métodos:
    - boolean addMotocicleta(Motocicleta motocicleta);
    - boolean removeMotocicleta(Motocicleta motocicleta);
    - Motocicleta obtenerMotocicleta(String matricula);
      >__Nota__: Verifica que existe siempre el elemento antes de (__añadir/eliminar/obtener__);
    - float velocidadMediaMotocicletas().
  - List<Coche> coches de tipo __HashSet__.
    - Crea los siguientes métodos:
      - boolean addCoche(Coche coche);
      - boolean removeCoche(Coche coche);
      - Coche obtenerCoche(String matricula);
        >__Nota__: Verifica que existe siempre el elemento antes de (__añadir/eliminar/obtener__ antes de realizar la operación);
    - float velocidadMediaCoches().
  - float velocidadMediaVehiculos(). (Coches y Motocicletas)
>__Nota__: Datos para realizar las pruebas:

- Coches:

  ```csv
  Toyota,Corolla,ABC123,60
  Honda,Civic,XYZ789,75
  Ford,Mustang,DEF456,100
  Chevrolet,Impala,GHI789,80
  Volkswagen,Golf,JKL012,65
  ```
 
 - Motocicletas:
    ```csv
    Harley-Davidson,Sportster,MNO345,50
    Yamaha,YZF R6,PQR678,90
    Ducati,Monster,STU901,70
    Suzuki,GSX-R750,VWX234,80
    Kawasaki,Ninja,ZAB567,85
    ```  
    
- Crea una clase __AppConcecionario__ que haga uso de Concecionario, cargue sus los datos del concecionario y utilice cada uno de los métodos que se piden.

Estrucura de la solución que se pretende:

```code
es.ies.puerto.abstractas
	Vehiculo
es.ies.puerto.interfaces
	IVehiculo
es.ies.puerto.vehiculos
	Coche.
	Motocicleta.
	Concesionario
es.ies.puerto.app
	AppConcecionario
```	
</div>