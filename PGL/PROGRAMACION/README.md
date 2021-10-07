<div align="justify">

# Programación de una App

<img width="400px" src="https://www.spanishlearninglab.com/wp-content/uploads/2018/01/rooms-and-parts-of-the-house-in-Spanish-lesson.png" alt="Diagrama de casos de Uso">

## Introducción

  En esta unidad vamos a comenzar a desarrollar nuestra propia app. Inicialmente se realizará en __Java__, dado que es el lenguaje que más conoce el alumno.

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

<img src="https://ahorasomos.izertis.com/solidgear/wp-content/uploads/2019/06/MVVMPattern-1.png" alt="Diagrama de casos de Uso">

  Ahora que hemos presentado estos dos patrones, __¿por qué usar MVVM en lugar de MVC?__

  - _La vista en MVC depende del modelo y del controlador para obtener datos o modificarlos. Si hay un cambio en la vista que implique un cambio en el modelo necesita al controlador para hacerlo mientras que si hay datos nuevos, depende del modelo para traerlos. En el caso del MVVM, la vista solo depende del modelo de la vista para obtener datos o modificarlos, además nadie tiene que decirle que actualice los datos como haría el controlador en MVC pasivo, ya que está observando cambios en el modelo directamente_.

  - _El modelo en MVC puede tener demasiadas responsabilidades como obtener los datos de fuentes de datos, informar al controlador sobre cambios en esos datos y prepararlos para que se puedan mostrar en la vista._ __En MVVM el modelo queda totalmente desacoplado de la vista y solo contiene información, nunca acciones para manipularla__.
  - _En MVC no queda muy claro quién se debería encargar de la lógica de presentación ya que el modelo solo debería enviar datos en crudo a la vista y por otro lado, llevar esta lógica a la vista complicaría algunos tests. En MVVM, esta responsabilidad es muy clara y cae en manos del modelo de la vista._


## Requisitos

  El alumno debe de haber creado los diagramas especificados:
  - Modelo Entidad - Relación.
  - Diagrama de Casos de Uso.
  - Diagrama de Paquetes.



## Referencias

  - [Componentes de arquitectura de Android.](https://ahorasomos.izertis.com/solidgear/componentes-de-arquitectura-de-android-de-mvc-a-mvvm/)
  - [App Sunflower.](https://github.com/android/sunflower)

  </div>
