<div align="justify">

# Sistema de Gestión de Biblioteca (Proyecto)

<div align="center">
  <img src="https://ethic.es/wp-content/uploads/2023/10/biblioteca.png" />
</div>

## Enunciado

Desarrolla un sistema de llamado Gestión de Biblioteca que permita a los __bibliotecarios__ buscar, prestar y devolver libros en una __biblioteca__. El sistema debe tener una _interfaz de usuario simple (Main con menú)_ y proporcionar funcionalidades básicas de administración de libros, como: (_obtenerInformacion (identificadorLibro),prestarLibro(identificadorLibro),devolverLibro(identificadorLibro),agregarComentario(identificadorLibro),consultarComentarios(identificadorLibro),verificarDisponibilidad(identificadorLibro)_). Además el sistema permitirá dar de alta/modificación/búsqueda/eliminación de usuarios y libros.

Teniendo en cuenta lo anterior, nuestro sistema debe contemplar trabajar con la siguiente información:

### Libro

- __Atributos__: ISBN, título, autor, año de publicación, cantidad de copias disponibles, etc.
- __Métodos__: obtenerInformacion(), prestarLibro(), devolverLibro(), etc.

### Usuario

- __Atributos__: nombre, número de identificación, historial de préstamos, etc.
- __Métodos__: solicitarPrestamo(), devolverLibro(), consultarHistorial(), etc.

### Préstamo

- __Atributos__: fecha de préstamo, fecha de devolución prevista, libro prestado, usuario que lo solicitó, etc.
- __Métodos__: calcularMulta(), renovarPrestamo(), etc.

### Biblioteca

- __Atributos__: lista de libros disponibles, lista de usuarios registrados, historial de préstamos, etc.
- __Métodos__: buscarLibro(), registrarUsuario(), realizarPrestamo(), etc.

### EmpleadoBiblioteca

- __Atributos__: nombre, número de empleado, horario laboral, etc.
- __Métodos__: procesarPrestamo(), gestionarDevolucion(), etc.

### CategoriaLibro

- __Atributos__: nombre de la categoría, descripción, lista de libros en la categoría, etc.
- __Métodos__: agregarLibro(), quitarLibro(), etc.

## Reserva

- __Atributos__: usuario que hizo la reserva, libro reservado, fecha de vencimiento de la reserva, etc.
- __Métodos__: confirmarReserva(), cancelarReserva(), etc.

## Editorial

- __Atributos__: nombre de la editorial, lista de libros publicados, etc.
- __Métodos__: agregarLibro(), listarLibrosPublicados(), etc.

## Evento

- __Atributos__: nombre del evento, fecha, descripción, lista de libros relacionados con el evento, etc.
- __Métodos__: agregarLibroRelacionado(), notificarParticipantes(), etc.

## Comentario

- __Atributos__: usuario que hizo el comentario, libro comentado, texto del comentario, etc.
- __Métodos__: agregarComentario(), eliminarComentario(), etc.

El sistema permitirá además las siguientes acciones:
- El usuario:
  - El usuario busca un libro por título, autor o categoría.
  - El usuario selecciona un libro disponible y lo presta.
  - El usuario devuelve un libro prestado.
  - El usuario deja un comentario en un libro.
  - El usuario selecciona una categoría y ve la lista de libros en esa categoría.


- El bibliotecario:
  - El bibliotecario registra a un nuevo usuario en el sistema.  
  - El bibliotecario agrega un nuevo libro al sistema.
  - El bibliotecario realiza un préstamo a un usuario.
  - El bibliotecario procesa la devolución de un libro.
  - El bibliotecario gestiona las reservas de libros (visualiza información/modifica).
  

Realiza:
 - Diagrama de Casos de Uso del proyecto especificado.
 - Diagrmama de Clases del proyecto especificado. Diseña un diagrama de clases que represente las relaciones entre las clases mencionadas anteriormente, incluyendo las asociaciones, agregaciones, composiciones y herencias necesarias.
 - Realiza la implementación del Diagrama de Clases.
   - Definición de las clases.
     - Propiedades.
     - Métodos.
     - Getters/Setters.  
 Asegúrate de incluir los métodos necesarios para realizar las operaciones descritas en los casos de uso.   

</div>