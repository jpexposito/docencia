
<div align="justify">

# Ejercicios de ArrayList

Teniendo como referencia: la documentación, los ejemplos realizados en clase, y los que se encuentran en el siguiente [enlace](../../Ejemplos/).

_Primera Parte_
---

Realiza:

- Crea un programa que declare e inicialice un ArrayList de enteros. Luego, agrega números pares del 1 al 10 a la lista.
  - Crea un programa que demuestre el comportamiento correcto del programa __App__+__NombreIdentificativo__, o __test unitarios__ que sistituyen a este.
- Escribe un método en una clase llamada OperacionesArrayList que reciba un ArrayList de cadenas y devuelva la cantidad de elementos que comienzan con la letra 'A'.
  a la lista.
  - Crea un programa que demuestre el comportamiento correcto del programa __App__+__NombreIdentificativo__, o __test unitarios__ que sistituyen a este.
- Implementa una clase Alumno con atributos como nombre, apellido y calificaciones (un ArrayList de float). Crea instancias de esta clase para representar a varios alumnos y calcula el promedio de calificaciones.
  a la lista.
  - Crea un programa que demuestre el comportamiento correcto del programa __App__+__NombreIdentificativo__, o __test unitarios__ que sistituyen a este.
- Crea un programa que compare dos ArrayList de enteros y devuelva true si tienen al menos un elemento en común, de lo contrario, devuelve false.
  a la lista.
  - Crea un programa que demuestre el comportamiento correcto del programa __App__+__NombreIdentificativo__, o __test unitarios__ que sistituyen a este.
- Escribe un método en la clase OperacionesArrayList que reciba un ArrayList de números y devuelva una nueva lista con solo los números pares.
- Implementa una clase Curso que contenga un ArrayList de alumnos. Agrega métodos para agregar y eliminar alumnos, así como para calcular la media de las calificaciones de todo el curso.
  a la lista.
  - Crea un programa que demuestre el comportamiento correcto del programa __App__+__NombreIdentificativo__, o __test unitarios__ que sistituyen a este.
- Crea un programa que elimine los elementos duplicados de un ArrayList de cadenas y muestre la lista resultante.
- Escribe un método en la clase OperacionesArrayList que reciba un ArrayList de enteros y devuelva true si todos los elementos son mayores que 10.
  a la lista.
  - Crea un programa que demuestre el comportamiento correcto del programa __App__+__NombreIdentificativo__, o __test unitarios__ que sistituyen a este.
- Implementa una clase RegistroClientes que contenga un ArrayList de objetos Cliente. Cada __cliente__ tiene un __nombre__, un __número__ de cliente y un __saldo__. Escribe métodos para agregar __clientes__, __buscar clientes__ por número y realizar una __transacción__ (_actualizar el saldo_).
- Crea un programa que lea una lista de nombres desde el teclado y los almacene en un ArrayList. Luego, ordena la lista alfabéticamente e imprímela.
  a la lista.
  - Crea un programa que demuestre el comportamiento correcto del programa __App__+__NombreIdentificativo__, o __test unitarios__ que sistituyen a este.

## ¿Qué debemos tener en cuenta para resolver estos ejercicios?

- Expresiones Regulares. _Debes de saber utilizar expresiones regulares para validar que un String comienza por A_.
- Recuerda siempre declarar los métodos __toString__ y __equals__.
- Sigue los apuntes para que veas distintos ejemplos de los métodos que se piden implementar.

_Segunda Parte_
--- 
- El siguiente ejercicio tiene como objetivo la comprensión de jerarquías en programación, así como el uso de __List de colecciones__. Para ello debe de implementarse las siguientes estruturas:
  - Una clase abstracta llamada Persona que contenga los siguientes atributos:
    - nombre (String).
    - dni.
    - fechaNacimiento(String).
    - Define el método __anios__, que retorno un __int__ que calcule la edad a partir de la fecha de nacimiento.
  - Una clase Nota que cotenga los siguientes atributos:
    - nombre (String).
    - valor (float).
  - Define una clase asbtracta llamada Trabajador que exitiende de Persona y que contenga:
    - nombre (String).
    - salario (float).
  - Crea una clase abstracta llamada Empleado que extienda de Trabajador.
  - Crea una clase llamada Profesor que extienda Empleado. La clase Profesor debe tener un atributo adicional:
    - especialidad(String). 
  - Crea una clase llamada Alumno que herede de Persona. La clase Alumno debe tener un atributo adicional:
    - notas List<Nota>.
  - Crea una clase llamada Aula que esta compuesta por las siguientes propiedades:
    - nombre String.
    - profesor Profesor.
    - alumnos List<Alumno>.
  - Crea la clase Colegio que estará compuesta por los siguientes atributos:
    - nombre String.
    - dirección String.
    - ubicación String.
    - aulas List<Aula>.
  
  - Agrega métodos específicos de la forma más eficas para:
    - Obtener la nota máxima de todos los alumnos en el colegio.
    - Obtener la nota media de una clase específica.
    - Obtener la nota media de todo el colegio.
    - Obtener la información del salario medio de los profesores.
    - Obtener el salario máximo y mínimo de los profesores.
    - Obtener la información de un Profesor, un alumno o una clase específica a través de su dni.
    - Obtener la edad media de los profesores, y alumnos.
    - No se permiten elementos duplicados en ninguna de las listas creadas.
    
    __Nota__:
    - Realiza el ejercicio creando una clase __abstracta__, en el paquete __ies.puerto.abstractas__ _(Los métodos abstractos_ ___NO___ _comienzan por_ ___I___ _)_ y realizando la implemetación de los __métodos abstractos__ en una clase declarada en el paquete __ies.puerto.implementation__.
    - ___CREA LAS CLASES CON LOS NOMBRES ADECUADOS EN FUNCIÓN DEL TIPO DE CLASE QUE SEA Y EL PAQUETE DONDE ESTE___.  
    - Crea un programa que demuestre el comportamiento correcto del programa __AppNombreIndentificativo__, o __test unitarios__ que sistituyen a este.

</div>