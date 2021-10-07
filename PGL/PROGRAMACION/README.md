<div align="justify">

# Programación de una App

<div align="center">

  <img width="400px" src="https://www.vivires.com/blog/wp-content/uploads/2017/11/construir-una-casa.jpg">

</div>

## Introducción

  En esta unidad vamos a comenzar a desarrollar nuestra propia app. Inicialmente se realizará en __Java__, dado que es el lenguaje que más conoce el alumno.

## Requisitos

  El alumno debe de haber creado los diagramas especificados:
  - Modelo Entidad - Relación.
  - Diagrama de Casos de Uso.
  - Diagrama de Paquetes.

## Arquitectura  

  A estas alturas fijo que muchos de vosotros ya habéis oido hablar sobre los componentes de arquitectura de Android. No obstante, vamos a repasar qué son y cómo se utilizan en una aplicación Android junto con el patrón arquitectónico MVVM (modelo – vista – modelo de vista). Además, haremos una comparativa entre MVVM y el patrón arquitectónico MVC (modelo – vista – controlador), el más utilizado tradicionalmente en Android junto con MVP (modelo – vista – presentador).

### MVC vs MVVM

  Vamos a empezar repasando un poco estos dos patrones de diseño de la capa de presentación y su uso en Android.

  En el patrón de arquitectura MVC (modelo – vista – controlador), basado en el principio de separación de intereses:

  - El modelo contiene la información con la que el sistema trabaja, proporcionándosela a la vista para que pueda mostrarla y permitiendo realizar cambios en ella desde el controlador.
  - El controlador responde a acciones del usuario, modificando el modelo cuando sea necesario. Además, se comunica con la vista para que se actualice con los últimos cambios del modelo.
  - La vista presenta al usuario la información del modelo.


  Uno de los errores más comunes a la hora de utilizar MVC en Android ha sido y aún sigue siendo __utilizar una Activity como controlador__, haciéndola responsable de tareas de las que no debería ocuparse, como llamar directamente al modelo para realizar una modificación de algún dato, cuando esto debería ser tarea del controlador. Esto es claramente una violación del principio de responsabilidad única y al usar una __Activity__ como _controlador_ le estamos haciendo dependiente de la plataforma, por lo que su código podría verse afectado cuando la Activity sea destruida por el sistema.

  Si queremos aplicar correctamente MVC en Android, __las activities y fragments solo deberían ocuparse de mostrar los datos__ y __notificar los eventos del usuario al controlador, siendo los únicos componentes ligados a la plataforma__. __(IMP)__, _Los controladores y modelos deberían ser clases separadas sin ninguna dependencia con Android, haciéndolos así más fáciles de testear_. Este concepto es muy importante.

  En el __patrón arquitectónico MVVM__ _(modelo – vista – modelo de vista)_:

  - __El modelo__, al igual que en _MVC_, __representa la capa de datos__ y/o __lógica de negocio__.
  - __La vista__ presenta _la información_ y es activa, reaccionando a cambios en el modelo, de forma similar a un patrón MVC activo.
  - __El modelo de vista__ es un _actor intermediario_ entre el _modelo y la vista_ y contiene toda la lógica de presentación.

<div align="center">

  <img width="400px" src="https://ahorasomos.izertis.com/solidgear/wp-content/uploads/2019/06/MVVMPattern-1.png">

</div>

  Ahora que hemos presentado estos dos patrones, __¿por qué usar MVVM en lugar de MVC?__

  - _La vista en MVC depende del modelo y del controlador para obtener datos o modificarlos. Si hay un cambio en la vista que implique un cambio en el modelo necesita al controlador para hacerlo mientras que si hay datos nuevos, depende del modelo para traerlos. En el caso del MVVM, la vista solo depende del modelo de la vista para obtener datos o modificarlos, además nadie tiene que decirle que actualice los datos como haría el controlador en MVC pasivo, ya que está observando cambios en el modelo directamente_.

  - _El modelo en MVC puede tener demasiadas responsabilidades como obtener los datos de fuentes de datos, informar al controlador sobre cambios en esos datos y prepararlos para que se puedan mostrar en la vista._ __En MVVM el modelo queda totalmente desacoplado de la vista y solo contiene información, nunca acciones para manipularla__.
  - _En MVC no queda muy claro quién se debería encargar de la lógica de presentación ya que el modelo solo debería enviar datos en crudo a la vista y por otro lado, llevar esta lógica a la vista complicaría algunos tests. En MVVM, esta responsabilidad es muy clara y cae en manos del modelo de la vista._

## Componentes arquitectónicos de Android

  Estos componentes lanzados por el equipo de Android hace ya un par de años nos facilitan mucho la vida a la hora de implementar un patrón MVVM en Android, además de hacer nuestras aplicaciones más robustas, mantenibles y fáciles de probar.

  - LiveData:
    - Objetos que notifican a la vista cuando hay cambios en la base de datos.
    - Son conscientes de los ciclos de vida, por lo que nos ayudan a evitar crashes cuando una Activity se detiene por ejemplo.
    - ViewModel:
    - Clases responsables de preparar y manejar los datos de una Activity o Fragment.
    - Permite que los datos sobrevivan a cambios de configuración como rotaciones de pantalla, minimizando el uso de onSaveInstanceState()para guardar y recuperar datos.
    - Expone la información a través de un LiveData observado desde la vista.
  - Room:
    - Librería __ORM (Object-Relational mapping)__: _convierte objetos SQLite a objetos Java/Kotlin automáticamente_.
    - Validación SQL en tiempo de compilación.
    - Devuelve objetos LiveData para observar cambios en la base de datos.

### ¿Cómo encajan estos componentes de Android con una arquitectura multicapa?

  El patrón MVVM, al igual que MVC y MVP, es un patrón de diseño utilizado en la capa de presentación de una aplicación, pero una aplicación no se compone solo de esta capa, sino que se complementa con otras capas como la de dominio y la de datos.

  Partiendo de un ejemplo de un concesionario que desea mostrar una lista de coches en su app, veamos un diagrama con todas las capas.

<div align="center">
  <img width="400px" src="https://ahorasomos.izertis.com/solidgear/wp-content/uploads/2019/06/Android-architecture-CLEAN-1.png">
</div>

#### El Ejemplo

  Siguiendo con el ejemplo del concesionario, imaginemos que ya tienen una aplicación Android desarrollada usando el patrón MVC y que quieren cambiarla a MVVM, usando los nuevos componentes de arquitectura de Android. Es buena idea empezar con un caso de uso sencillo como puede ser pedir todos los coches del concesionario, por lo que el diagrama del punto anterior nos será útil para tener una imagen global del cambio a llevar a cabo.

  Lo primero que tenemos que pensar es por dónde vamos a empezar a rearquitecturar la aplicación, siendo lo más natural la capa de datos en mi opinión, para luego ir subiendo hasta la vista.
  - Datos:
    - La aplicación del concesionario tenía una clase encargada de acceder a la base de datos y crear objetos con la información obtenida. Este tipo de clases suelen tener multitud de lineas de código encargadas de hacer la transformación de SQLite a objetos Java y viceversa. Para ahorrarnos esta tediosa tarea podemos hacer uso de Room, creando una clase  de modelo Car que definiremos como __@Entity__ y una clase __CarDAO__, en la que incluiremos las consultas que queramos hacer a la base de datos, que en este caso será una para obtener todos los coches.
    - Lo siguiente es crear el repositorio de coches y lo haremos con una interfaz, CarRepository, que será implementada por __CarRepositoryImpl__. De esta forma cumplimos el principio de inversión de dependencias (dependemos de abstracciones y no implementaciones) y el código queda más desacoplado y fácil de testear.
    - Adicionalmente, podemos crear dos clases con sus correspondientes interfaces, __LocalCarDataSourceImpl__ que implementa __LocalCarDataSource__ y __RemoteCarDataSourceImpl__ que implementa __RemoteCarDataSource__. Al hacer que el repositorio dependa de interfaces de fuentes de datos, en un futuro podremos utilizar otras como por ejemplo JsonLocalCarDataSource si queremos leer coches de un archivo json en lugar de una base de datos o FirebaseRemoteCarDataSource para leer los coches de una base de datos remota alojada en Firebase, e incluso establecer una jerarquía de fuentes de datos si alguna de ellas fallara.
  - Dominio:
  - Si la aplicación del concesionario tenía una arquitectura bien definida, las operaciones de dominio ya deberían existir, sino es así, hay que mover toda la lógica a esta capa.
  - Siguiendo con el ejemplo de obtener los coches del concesionario, tenemos que crear la operación de dominio GetAllCarsOperation . Esta operación pedirá datos al repositorio, hará con esos datos lo que defina la lógica de negocio y se los devolverá al modelo de la vista.
- Presentación:
  - CarViewModel contendrá los datos de los coches en un LiveData que se devuelve al llamar al método cars().
  - CarsActivity necesita una lista de coches y a partir de ahora deberá pedirlos a través de CarViewModel , así que debemos buscar en el código aquellas llamadas que se hacían de otra forma con MVC y cambiarlas por algo del tipo:
```java

 carViewModel.cars.observe(this, Observer { cars ->
         // Update the cars in the adapter
         cars?.let { adapter.setCars(it) }
 })
```
 Este es un ejemplo básico de como observar cambios en un LiveData sencillo pero imaginaros que no solo queremos traer los coches sino algún error al obtener los coches de una fuente remota de datos o un estado de loading para mostrar un diálogo mientras cargan los datos. Para esto nos hace falta utilizar varias clases como Resourceo NetworkBoundResource, de las cuales podéis encontrar más información en la documentación de Android. Si hacemos uso de esas clases en CarsActivity podemos escuchar diferentes estados:
```java
 carViewModel.cars.observe(this, Observer { resource ->
         when (resource?.status) {
                 Status.SUCCESS -> {
                         dismissLoadingDialog()
                         updateCars(resource.data)
                 }
                 Status.ERROR -> {
                         dismissLoadingDialog()
                         showError(resource.message)

                 }
                 Status.LOADING -> {
                         showLoadingDialog()
                 }
 })
```
 ##  En resumen

  En esta entrada hemos repasado los conceptos de MVC y MVVM y cómo utilizar los componentes de arquitectura de Android junto con una arquitectura en capas.

  El ejemplo que hemos incluido es un buen punto de partida para los que todavía no habéis empezado a trabajar con los componentes de Android. Si queréis profundizar más en el tema os recomiendo no solo leer la documentación sobre estos componentes sino también aprender Kotlin, ya que es un buen aliado a la hora de hacer estos cambios en una aplicación Android.



## Referencias

  - [Componentes de arquitectura de Android.](https://ahorasomos.izertis.com/solidgear/componentes-de-arquitectura-de-android-de-mvc-a-mvvm/)
  - [App Sunflower.](https://github.com/android/sunflower)

  </div>
