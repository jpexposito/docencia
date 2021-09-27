<div align="justify">

# HISTORIA EN UN REPOSITORIO GIT

## Mostrar el estado de un repositorio

 __git status__ muestra el estado de los cambios en el repositorio desde la última versión guardada. En particular, muestra los ficheros con cambios en el directorio de trabajo que no se han añadido a la zona de intercambio temporal y los ficheros en la zona de intercambio temporal que no se han añadido al repositorio.

## Mostrar el historial de versiones de un repositorio

 __git log__ muestra el historial de commits de un repositorio ordenado cronológicamente. Para cada commit muestra su código hash, el autor, la fecha, la hora y el mensaje asociado.

 Este comando es muy versátil y muestra la historia del repositorio en distintos formatos dependiendo de los parámetros que se le den. Los más comunes son:
  - __oneline__ muestra cada _commit_ en una línea produciendo una salida más compacta.
  - __graph__ muestra la historia en forma de _grafo_.

## Mostrar los datos de un commit

 - __git show__ muestra el usuario, el día, la hora y el mensaje del último commit, así como las diferencias con el anterior.
 - __git show <commit>__ muestra el usuario, el día, la hora y el mensaje del commit indicado, así como las diferencias con el anterior.

## Mostrar el historial de cambios de un fichero

 __git annotate__ muestra el contenido de un fichero anotando cada línea con información del commit en el que se introdujo.

 Cada línea de la salida contiene los 8 primeros dígitos del código hash del commit correspondiente al cambio, el autor de los cambio, la fecha, el número de línea del fichero y el contenido de la línea.

## Mostrar las diferencias entre versiones

 - __git diff__ muestra las diferencias entre el directorio de trabajo y la zona de intercambio temporal.

 - __dit diff --cached__ muestra las diferencias entre la zona de intercambio temporal y el último commit.

 - __git diff HEAD__ muestra la diferencia entre el directorio de trabajo y el último commit.


<div align="center">
    <a href="OPERACIONES_AVANZADAS.md"><img src="../../img/before.png" alt="OPERACIONES AVANZADAS" style="width:42px;height:42px;"></a>
    <a href="README.md"><img src="../../img/home.png" alt="XML Home" style="width:42px;height:42px;"></a>
    <a href="SEGURIDAD.md"><img src="../../img/next.png" alt="SEGURIDAD" style="width:42px;height:42px;">
</div>

</div>
