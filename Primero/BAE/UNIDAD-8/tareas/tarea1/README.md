<div align="justify">

<div align="center">
<img src="https://bookdown.org/paranedagarcia/database/images/database.jpg?w=700"/>
</div>


Dadas las siguientes tablas :
cientifico:
  - id: texto
  - nombre: texto
  - apellido1: texto
  - apellido2: texto

cientifico_proyecto
  - ref_cientifico:  texto 
  - ref_proyecto:  texto

proyecto:
  - id: texto
  - nombre: texto
  - horas: entero

Se pide:

Crea la estrucuta de tablas en función de las propiedades y sus nombres para determinar las claves primarias, claves foraneas.

Genera en pseudocódigo el procedimiento para cada una de las consultas que se plantean, definiciendo las distintas tablas, y en pseudocódigo el procedimiento, especificando:
- Nombre del procedimiento/s por consulta.
- Valores de entrada.
- Valores de salida. 
- Llamadas entre distintos procedimientos

Realiza las siguientes consultas:
1. Sacar una relación completa de los científicos asignados a cada proyecto. Mostrar DNI, Nombre del científico, identificador del proyecto y nombre del proyecto.

2. Obtener el número de proyectos al que está asignado cada científico (mostrar el DNI y el nombre).
3. Obtener el numero de científicos asignados a cada proyecto (mostrar el identificador del proyecto y el nombre del proyecto).
4. Obtener el número de horas de dedicación de cada científico.
5. Obtener el DNI y nombre de los científicos que se dedican a más de un proyecto y cuya dedicación media a cada proyecto sea superior __a un número de horas superior a 10, por ejemplo 11 horas__.


</div>