<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>

1. Dada la solución propuesta para almacenar la información sobre los parques nacionales, determinar la expresión _XQuery_ que devuelve:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<clases xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">

   <clase id="1">
       <nombre>Tango</nombre>
       <precio cuota="mensual" moneda="euro">27</precio>
       <plazas>20</plazas>
       <comienzo>1/01/2022</comienzo>
       <fin>1/12/2022</fin>
       <profesor>Roberto Garcia</profesor>
       <sala>1</sala>
   </clase>

   <clase id="2">
       <nombre>Cha-cha-cha</nombre>
       <precio cuota="trimestral" moneda="euro">80</precio>
       <plazas>18</plazas>
       <comienzo>1/07/2022</comienzo>
       <fin>1/10/2022</fin>
       <profesor>Miriam Gutiérreza</profesor>
       <sala>1</sala>
   </clase>

   <clase id="3">
       <nombre>Rock</nombre>
       <precio cuota="mensual" moneda="euro">30</precio>
       <plazas>15</plazas>
       <comienzo>1/01/2022</comienzo>
       <fin>1/12/2022</fin>
       <profesor>Laura Mendiola</profesor>
       <sala>1</sala>
   </clase>

   <clase id="4">
       <nombre>Merengue</nombre>
       <precio cuota="trimestral" moneda="dolares">75</precio>
       <plazas>12</plazas>
       <comienzo>1/01/2022</comienzo>
       <fin>1/12/2022</fin>
       <profesor>Jesús Lozano</profesor>
       <sala>2</sala>
   </clase>

   <clase id="5">
       <nombre>Salsa</nombre>
       <precio cuota="mensual" moneda="dolares">32</precio>
       <plazas>10</plazas>
       <comienzo>1/01/2022</comienzo>
       <fin>1/12/2022</fin>
       <profesor>Jesús Lozano</profesor>
       <sala>2</sala>
   </clase>

   <clase id="6">
       <nombre>Pasodoble</nombre>
       <precio cuota="anual" moneda="euro">3200</precio>
       <plazas>8</plazas>
       <comienzo>1/01/2022</comienzo>
       <fin>1/12/2022</fin>
       <profesor>Miriam Gutierrez</profesor>
       <sala>2</sala>
   </clase>

</clases>
```

- Muestra el nombre de todos los clases.

  ```
  for $clase in /clases/clase
  return $clase/nombre/text()

  ó

  for $nombre in //nombre
  return $nombre
  ```

- Muestra el nombre y precio de todos las clases.

  ```
  for $clase in /clases/clase
  return <clases>
  	<nombre>{$clase/nombre/text()}</nombre>
  	<precio>{$clase/precio/text()}</precio>
  </clases>
  ```

- Muestra el nombre y precio de todos las clases donde su precio es mayor que 40.

  ```
  for $clase in /clases/clase
  where $clase/precio > 40
  return <clases>
  <nombre>{$clase/nombre/text()}</nombre>
  <precio>{$clase/precio/text()}</precio>
  </clases>
  ```

- Mostrar las clases ordenados por nombre.

  ```
  for $clase in /clases/clase
  order by $clase/nombre
  return $clase/nombre
  ```

- Mostrar los nombres de las clases que contienen una a.

  ```
  for $clase in /clases/clase
  where contains($clase/nombre, "a")
  return $clase/nombre
  ```

- Mostrar el nombre de las clases donde el apellido del profesor sea Lozano.

  ```
  for $clase in /clases/clase
  where contains($clase/profesor, "Lozano")
  return $clase/nombre
  ```               

- Mostrar todos las clases, excepto el 3 y 5.

  ```
  for $clase in /clases/clase
  where $clase/@id != 3 and $clase/@id != 5
  return $clase/nombre
  ```

- Mostrar profesores que den clases por una cuota mensual.

  ```
  for $clase in /clases/clase
  where $clase/precio[@cuota = "mensual"]
  return $clase/profesor
  ```

- Mostrar el nombre de las clases de la sala 1, que se pague con euros y el precio sea menor a 35.

  ```
  for $clase in /clases/clase
  where $clase/sala = 1 and $clase/precio/@moneda = "euro" and $clase/precio < 35
  return $clase/nombre
  ```

- Mostrar los nombres de las clases cuyo precio sea mayor de 30.

  ```
  for $clase in /clases/clase
  where $clase/precio > 30
  return $clase/nombre
  ```

- Mostrar los nombres de las clases cuyo precio sea mayor de 30 y la moneda "euro".

  ```
  for $clase in /clases/clase
  where $clase[precio/@moneda = "euro"]/precio>30
  return $clase/nombre/text()
  ```

- Mostrar la media de los precios de todos las clases.

  ```
  let $clase := /clases/clase
  return <media>{avg($clase/precio)}</media>
  ```
- Mostrar la suma de los precios de las clases de la sala 1.

  ```
  for $clase in /clases/clase
  where $clase/sala = 1
  return sum($clase/precio)
  ```

- Mostrar el dinero que ganaría la profesora "Laura Mendiola" si se completaran todas las plazas de su clase, sabiendo que sólo tiene una clase.

  ```
  let $clase := /clases/clase[profesor = "Laura Mendiola"]
  return $clase/plazas * $clase/precio
  ```

- Mostrar el nombre de la clase, su precio y el precio con un descuento del 15% para familias numerosas. Ordenar por el nombre de la clase.

  ```
  for $clase in /clases/clase
  order by $clase/nombre
  return
  <clase>
  <nombreClase>{$clase/nombre}</nombreClase>
  <precio>{$clase/precio}</precio>
  <familiaNumerosa>{$clase/precio * 0.85}</familiaNumerosa>
  </clase>
  ```

- Mostrar el dinero que ganaría la profesora "Laura" (no conocemos su apellido) si se completaran todas las plazas de su clase.

  ```
  for $clase in /clases/clase
  where starts-with($clase/profesor, "Laura")
  return $clase/plazas * $clase/precio

  ó

  for $clase in /clases/clase[starts-with(profesor, "Laura")]
  return <beneficio>{$clase/plazas * $clase/precio}</beneficio>

  ```

- Mostrar los nombres y la fecha de comienzo de las clases que comiencen el mes de enero (utiliza para buscarlo la cadena de texto "/1/").

  ```
  for $clase in /clases/clase
  where contains($clase/comienzo, "/1/")
  return
  <clase>
  <nombre>{$clase/nombre}</nombre>
  <fechaInicio>{$clase/comienzo}</fechaInicio>
  </clase>
  ```

- Mostrar el dinero que ganaría el profesor "Jesus Lozano" si se completaran todas las plazas de su clase, pero mostrando el beneficio de cada clase por separado.   

  ```
  for $clase in //clase
  where compare($clase/profesor, 'Jesus Lozano')
  return <beneficio>{$clase/plazas * $clase/precio}</beneficio>
  ```

2. Dada la solución propuesta para almacenar la información sobre los habitantes de un municipio, determinar la expresión _XQuery_ que devuelve:

```xml
<?xml version="1.0" encoding="ISO-8859-1" standalone="yes"?>
<notas>
    <alumno convocatoria="Septiembre">
        <nombre>Carlos</nombre>
        <apellidos>Amaya Arozamena</apellidos>
        <matricula>m019843</matricula>
        <cuestionarios>8.0</cuestionarios>
        <tareas>8.0</tareas>
        <examen>6.0</examen>
        <final>8.0</final>
    </alumno>
    <alumno convocatoria="Junio">
        <nombre>Jose</nombre>
        <apellidos>Muñoz Soto</apellidos>
        <matricula>m019872</matricula>
        <cuestionarios>7.0</cuestionarios>
        <tareas>9.0</tareas>
        <examen>7.0</examen>
        <final>8.5</final>
    </alumno>
    <alumno convocatoria="Junio">
        <nombre>Ana</nombre>
        <apellidos>Martinez de la Fuente</apellidos>
        <matricula>m097215</matricula>
        <cuestionarios>8.0</cuestionarios>
        <tareas>9.0</tareas>
        <examen>9.0</examen>
        <final>8.5</final>
    </alumno>
    <alumno convocatoria="Septiembre">
        <nombre>Roberto</nombre>
        <apellidos>Carrera Fernández</apellidos>
        <matricula>m059312</matricula>
        <cuestionarios>6.0</cuestionarios>
        <tareas>7.0</tareas>
        <examen>6.0</examen>
        <final>6.5</final>
    </alumno>
    <alumno convocatoria="Septiembre">
        <nombre>Concepción</nombre>
        <apellidos>Lalinde Priego</apellidos>
        <matricula>m034093</matricula>
        <cuestionarios>4.0</cuestionarios>
        <tareas>3.0</tareas>
        <examen>2.0</examen>
        <final>3.0</final>
    </alumno>
    <alumno convocatoria="Junio">
        <nombre>Esther</nombre>
        <apellidos>Pereda</apellidos>
        <matricula>m938762</matricula>
        <cuestionarios>2.0</cuestionarios>
        <tareas>3.0</tareas>
        <examen>2.0</examen>
        <final>2.5</final>
    </alumno>
</notas>

```

- Obtener el nombre de todos los alumnos matriculados en algún módulo.

  ```
  for $alumno in //alumno
  return $alumno/nombre
  ```

- Obtener las calificaciones del alumno de código "n43483437" en cada módulo.

  ```
  for $alumno in //alumno
  where compare($alumno/matricula,"n43483437")
  return $alumno/final
  ```

- Obtener el nombre de cada alumno ordenado por apellidos de forma descendiente.

  ```
  for $alumno in //alumno
  order by $alumno/apellidos descending
  return $alumno/nombre
  ```

- Obtener los nombres de los alumnos matriculados y sus notas ordenado por notas.

  ```
  for $alumno in //alumno
  order by $alumno/final
  return <resultado>$alumno/nombre, $alumno/final</resultado>
  ```

- Obtener los nombres y las calificaciones de los alumnos que han aprobado.

  ```
  for $alumno in //alumno
  order by $alumno/final >= 5
  return <resultado>$alumno/nombre, $alumno/final</resultado>
  ```


## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
