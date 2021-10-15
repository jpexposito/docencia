<div align="justify">

# Tarea Sistema de Información


<div align="center">
  <img width="300px" src="https://www3.gobiernodecanarias.org/medusa/edublog/iespuertodelacruztelesforobravo/wp-content/uploads/sites/408/2021/06/logotipo-fondo-transparente-4.png">
</div>


## Se pide

 Diseñar un documento XML válido que permita estructurar la información para permitir su gestión informática de los alumnos de un modulo del ciclo formativo DAW. Aplicarlo al módulo de Lenguajes de Marcas y Sistemas de Gestión de Información sabiendo que tiene asignadas 4 horas semanales y es de carácter obligatorio. El modulo se imparte entre el 15 de septiembre de 2010 y el 30 de junio de 2022. Hay matriculados dos alumnos:
  - Ana Fernández Gutiérrez con nif 16965696L teléfono 789654321 email ana.fdezgtrrez@hotmail.com, su dirección es C/ El Percebe, 13 de Santander CP 39302 No hay información sobre las faltas de asistencia o sus notas hasta el momento.
  - Pepito Grillo con nif 98765432H teléfono 656566555 email yhyh@yahoo.com, su dirección es Avd. El Pez, 5 de Suances CP 39401. Su nota es "apto" y no tiene faltas de asistencia.


## Entrega

  - Recuerda que debes de generar el informe en __pdf__ + __github__ (enlace en la descripción de la entrega de la tarea).
  - La entrega fuera de hora supondrá un __40%__ menos de la __nota__.


 <details>
   <summary>PULSA PARA VER LA RESPUESTA CORRECTA:</summary>

En el tercer ejercicio hay que crear un XML que ayude a estructurar la información de los alumnos de un módulo de ciclo formativo, la estructura del XML es la siguiente
  - Elemento raíz __ciclo-formativo__
    - Elemento  __ciclo__ , atributo: _nombre_
      - Elemento __asignaturas__
        - Elemento  __asignatura__
          - Elemento __nombre__
          - Elemento __horas__
          - Elemento __obligatorio__
          - Elemento __duración__
            - Elemento __inicio__
              - Elemento __dia__
              - Elemento __mes__
              - Elemento __año__
            - __fin__
              - Elemento __dia__
              - Elemento __mes__
              - Elemento __año__
          - Elemento __alumnos__
            - Elemento__alumno__ , atributo: _numero_
              - Elemento __contacto__
                - Elemento __nombre__
                - Elemento __apellido__
                - Elemento __primer__
                - Elemento __segundo__
                - Elemento __teléfono__
                  Elemento __email__
                - Elemento __dirección__
                  - Elemento __calle__ ,atributo: _tipo_
                  - Elemento provincia
                  - Elemento código-postal
              - Elemento __faltas__
              - Elemento __notas__


   El elemento raíz es “ciclo-formativo” como pueden existir diferentes ciclos formativos dentro de la raíz se incluye el elemento “ciclo” con el atributo “nombre”.
   Dentro del ciclo pueden existir varias “asignaturas” las cuales tienen diferentes horas semanales y pueden ser obligatorias o no, además, podrían tener diferentes fechas de inicio y fin si se tratasen por ejemplo de asignaturas cuatrimestrales, por ese motivo se ha incluido dentro del ciclo el atributo “nombre” para diferenciar los diferentes ciclos que en nuestro caso sería “DAM”.
   A su vez, en una asignatura se pueden matricular varios “alumnos”, por eso se anida el elemento “alumno” donde cada alumno se identifica a través del atributo número donde cada alumno tiene un número asignado en función al orden que ocupe en la lista, que normalmente suele estar ordenada por orden alfabético del apellido. Cada alumno posee sus “datos de contacto” que serían: nombre, apellidos, DNI, dirección, teléfono o email entre otras además de datos relacionados con la asignatura como las faltas de asistencia o las notas del alumno. Por otra parte, al existir caracteres especiales como la “ñ” en año, se ha escogido la codificación ISO-8859-1 que admite dichos caracteres, quedando el XML de la siguiente forma.

  ```xml
<ciclo-formativo>
  <ciclo nombre="DAM">
    <asignaturas>
      <asignatura>
        <nombre>Lenguaje de Marcas y Sistea de Gestión de Información</nombre>
        <horas>4</horas>
        <obligatorio>si</obligatorio>
        <duracion>
          <inicio>
            <dia>15</dia>
            <mes>septiembre</mes>
            <año>2010</año>
          </inicio>
          <fin>
            <dia>30</dia>
            <mes>Junio</mes>
            <año>2011</año>
          </fin>
        </duracion>
        <alumnos>
          <alumno numero="1">
            <contacto>
              <nombre>Ana</nombre>
              <apellido>  
                <primer>Fernández</primer>
                <segundo>Gutierrez</segundo>
              </apellido>
              <nif>16965696L</nif>
              <telefono>789654321</telefono>
              <email>ana.fdezgtrrez@hotmail.com</email>
            </contacto>
            <direccion>
              <calle tipo="calle">El Percebe</calle>
              <numero>13</numero>
              <provincia>Santander</provincia>
              <codigo-postal>39302</codigo-postal>
            </direccion>
            <faltas/>
            <notas/>
          </alumno>
          <alumno numero="2">
            <contacto>
              <nombre>Pepito</nombre>
              <apellido>
                <primer>Grillo</primer>
              </apellido>
              <nif>98765432H</nif>
              <telefono>656566555 </telefono>
              <email>yhyh@yahoo.com</email>
            </datos-contacto>
            <direccion>
              <calle tipo="avenida">El Pez</calle>
              <numero>5</numero>
              <provincia>Suances</provincia>
              <codigo-postal>39401</codigo-postal>
            </direccion>
            <faltas>0</faltas>
            <notas>apto</notas>
          </alumno>
        </alumnos>
      </asignatura>
    </asignaturas>
  </ciclo>
</ciclo-formativo>
```

   <details>
</div>
