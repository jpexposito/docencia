<div align="justify">

# Gestión Centro Profesores. 

<div align="center">
  <img src="https://www.magisnet.com/wp-content/uploads/2020/02/clima-escolar.jpeg" width="600px" />
</div>

Se desea desarrollar una aplicación de gestión de las calificaciones de los alumnos
para satisfacer las numerosas quejas de los profesores, por el uso del lápiz y papel.
La aplicación debe de cumplir los temas que se describen a continuación:
El profesor recibe las actas en blanco de las asignaturas de las que es responsable, en formato electrónico. El acta contiene los siguientes datos de la asignatura (titulación,campus, curso académico, denominación de la asignatura, convocatoria y grupo) y la lista de alumnos matriculados (niu, nif, nombre y apellidos). Alguna de las acciones que puede hacer el profesor son:
 - Completar un acta con las notas de los alumnos.
 - Añadir o borrar un alumno de un acta.
 - Integrar las actas de varios grupos de una misma asignatura en una sola acta.
 - Otras de las opciones que se le exige a la aplicación, para satisfacer completamente las necesidades del profesor, son las siguientes:
    - Permitir la consulta de la siguiente información de cualquier alumno seleccionado _DNI, N.° EXPEDIENTE, Lista de asignaturas en las que está matriculado el alumno (Código asignatura-Nombre asignatura)_.
    - Obtener una estadística de las calificaciones obtenidas por los alumnos en un determinado grupo de una asignatura. En esta estadística se tendrá para cada posible calificación:
      - Número de personas con esa calificación, Porcentaje sobre los presentados, Porcentaje sobre el total del grupo.
    - Consultar el porcentaje de personas sobre el total del grupo que se han presentado y el de los que no se han presentado.
 - Poder visualizar un gráfico indicativo del número de personas que han obtenido una calificación entre 0-0.99, 1-1.99, 2-2.99, 3-3.99, 4-4.99, 5-5.99, 6-6.99, 8-8.99, 9-10; indicándose la nota media obtenida por la clase.
 - Disponer de una calculadora que permita realizar las operaciones de suma, resta, multiplicación, división. Esta calculadora se activará cuando se vayan a introducir las notas a algún alumno de forma que una vez realizada la operación aritmética, pulsando un botón se vuelque el resultado en la casilla donde se están introduciendo las calificaciones, redondeándose a dos cifras decimales.
 - Permitir la importación y exportación de la lista de alumnos con sus calificaciones a un formato compatible con MS Excel.
 - Imprimir las actas y la lista provisional de calificaciones.

Finalmente, como una ampliación extra, a la cual sólo podrá acceder quien se
identifique inicialmente como administrador de la aplicación, se deben permitir:
 - __CRUD__ _(Altas/Bajas/Modificación y Consulta)_ para cada uno de los siguientes grupos:.
   - __Asignaturas__, teniendo en cuenta que una asignatura sólo se puede dar en un único curso (primero, segundo, tercero...) y que cada curso está formado ponlos datos sobre el número máximo de alumnos, número mínimo de créditos troncales y número mínimo de créditos optativos. Algunos de los datos que vamos a poder consultar de una asignatura son el nombre, número de créditos y cuatrimestre en el que se imparte.
   - __Titulaciones__, teniendo en cuenta que una titulación sólo se da en un campus determinado y los datos que podemos consultar son el nombre, el número de créditos o carga lectiva global, si es de 1.° o 2.' ciclo, ...
   - __Grupos__, en los que podemos consultar el número máximo de alumnos permitidos, si es un grupo de mañana, de tarde o de noche, y cuál es el código empleado para identificar el grupo.
   - __Alumnos__:
     - Consultar aquellos alumnos que no se pueden matricular y el motivo de ello.
     - Consultar el historial académico de un alumno.


__Solución__:

Vamos a realizar el análisis de cada uno de los parrafos del ejercicio.
>__Información__: El profesor recibe las actas en blanco de las asignaturas de las que es responsable, en formato electrónico.

En primer lugar vemos que existe un actor llamado __profesor__ sobre el que recae el gran peso de la operaciones que realiza la aplicación. En segundo lugar observamos que hay un agente que proveo las actas, que podríamos llamar __generador de Actas__. El primer _caso de uso_ será el envío de actas, por este actor.
- __Generar Actas__: _Enviar Actas_. __C.U.1.__

  >__Información__:El acta contiene los siguientes datos de la asignatura (titulación,campus, curso académico, denominación de la asignatura, convocatoria y grupo) y la lista de alumnos matriculados (niu, nif, nombre y apellidos).
  Esta información no es de vital importancia para detectar los casos de uso que existen, pero si contiene información de datos que debería almacenarse en una __BBDD__ _(titulación,campus, curso académico, denominación de la asignatura, convocatoria y grupo) y la lista de alumnos matriculados (niu, nif, nombre y apellidos)_. 

El siguiente bloque de información que debemos de analizar es el siguiente:
  > __Información__:
    - Completar un acta con las notas de los alumnos.
    - Añadir o borrar un alumno de un acta.
    - Integrar las actas de varios grupos de una misma asignatura en una sola acta.
    - Otras de las opciones que se le exige a la aplicación, para satisfacer completamente las necesidades del profesor, son las siguientes:
    - Permitir la consulta de la siguiente información de cualquier alumno seleccionado _DNI, N.° EXPEDIENTE, Lista de asignaturas en las que está matriculado el alumno (Código asignatura-Nombre asignatura)_.
    - Obtener una estadística de las calificaciones obtenidas por los alumnos en un determinado grupo de una asignatura. En esta estadística se tendrá para cada posible calificación:
      - Número de personas con esa calificación, Porcentaje sobre los presentados, Porcentaje sobre el total del grupo.
      - Consultar el porcentaje de personas sobre el total del grupo que se han presentado y el de los que no se han presentado.
    - Poder visualizar un gráfico indicativo del número de personas que han obtenido una calificación entre 0-0.99, 1-1.99, 2-2.99, 3-3.99, 4-4.99, 5-5.99, 6-6.99, 8-8.99, 9-10; indicándose la nota media obtenida por la clase.
    - Disponer de una calculadora que permita realizar las operaciones de suma, resta, multiplicación, división. Esta calculadora se activará cuando se vayan a introducir las notas a algún alumno de forma que una vez realizada la operación aritmética, pulsando un botón se vuelque el resultado en la casilla donde se están introduciendo las calificaciones, redondeándose a dos cifras decimales.
    - Permitir la importación y exportación de la lista de alumnos con sus calificaciones a un formato compatible con MS Excel.
    - Imprimir las actas y la lista provisional de calificaciones.

Los casos de uso que extraemos de este texto son los siguiente:
- _Completar acta_.__C.U.2.__
- _Añadir Alumno_.__C.U.3.__
- _Borrar Alumno_.__C.U.4.__
- _Integrar Actas_.__C.U.5.__  
- _Consulta Información Alumno_. __C.U.6.__
- _Obtener Estadística Calificaciones Alumnos_.__C.U.7.__
- _Porcentaje Alumnos_.__C.U.8.__ _(Contendrá la opción de los presentados y no presentados, se especificará en la especificación de caso)_.
- _Visualizar Gráfico Calificación_. __C.U.9.__
- _Importación de Lista Alumnos_. __C.U.10.__.
- _Exportación de Lista Alumnos_ __C.U.11.__
- _Imprimir Acta_. __C.U.12.__
- _Listado Calificaciones Provisional_.__C.U.13.__
- Otros casos de Uso:
   - _Calculadora_. __C.U.14.__ Se debe de relacionar con el caso de uso correcto. __(C.U.2).__

Aunque no se indica explicitamente en el texto, el profesor se debe ___autenticar___ en el sistema, ya que se deduce del segundo párrafo _(sólo podrá acceder quien se identifique inicialmente como administrador de la aplicación_. ___No obstante como no se indica explicitamente___, podríamos obviar esto y que sólo estuviera autenticado el profesor con __ROL ADMINISTRADOR__.       

Del siguiente párrafo de información:
> Información: sólo podrá acceder quien se identifique inicialmente como __administrador__ de la aplicación, se deben permitir:
    - __CRUD__ _(Altas/Bajas/Modificación y Consulta)_ para cada uno de los siguientes grupos:.
      - __Asignaturas__, teniendo en cuenta que una asignatura sólo se puede dar en un único curso (primero, segundo, tercero...) y que cada curso está formado ponlos datos sobre el número máximo de alumnos, número mínimo de créditos troncales y número mínimo de créditos optativos. Algunos de los datos que vamos a poder consultar de una asignatura son el nombre, número de créditos y cuatrimestre en el que se imparte.
      - __Titulaciones__, teniendo en cuenta que una titulación sólo se da en un campus determinado y los datos que podemos consultar son el nombre, el número de créditos o carga lectiva global, si es de 1.° o 2.' ciclo, ...
      - __Grupos__, en los que podemos consultar el número máximo de alumnos permitidos, si es un grupo de mañana, de tarde o de noche, y cuál es el código empleado para identificar el grupo.
      - __Alumnos__:
        - Consultar aquellos alumnos que no se pueden matricular y el motivo de ello.
        - Consultar el historial académico de un alumno.

De este párrafo podemos obtener los siguientes casos de uso:
- Asignaturas:
  - Alta. __(C.U.15).__
  - Baja. __(C.U.16).__
  - Modificación. __(C.U.17).__
  - Consulta. __(C.U.18).__
- Titulación:
  - Alta. __(C.U.19).__
  - Baja. __(C.U.20).__
  - Modificación. __(C.U.21).__
  - Consulta. __(C.U.22).__
- Grupo:
  - Alta. __(C.U.23).__
  - Baja. __(C.U.24).__
  - Modificación. __(C.U.25).__
  - Consulta. __(C.U.26).__  
- Alumno:
  - Alta. __(C.U.27).__
  - Baja. __(C.U.28).__
  - Modificación. __(C.U.29).__
  - Consulta. __(C.U.30).__


Una vez analizados todos los casos de uso y los actores existentes, sólo faltará realizar la __especificación de casos de uso indicada en el [enlace](../ESTRUCTURACION-ESPECIFICACION-CASO-USO.md)__. 
  
</div>