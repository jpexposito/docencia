<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>


Vamos a trabajar con el fichero __universidad.xml__ que se muestra.

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>

<universidad>

    <nombre>Universidad de Victoria</nombre>
    <pais>Espania</pais>

<!-- CARRERAS -->

    <carreras>

        <carrera id="c01">
            <nombre>I.T. Informatica</nombre>
            <plan>2003</plan>
            <creditos>250</creditos>
            <centro>Escuela de Informatica</centro>
        </carrera>

        <carrera id="c02">
            <nombre>Dipl. Empresariales</nombre>
            <plan>2001</plan>
            <creditos>275</creditos>
            <centro>Facultad de Ciencias Sociales</centro>
        </carrera>

        <carrera id="c03">
            <nombre>Dipl. Relaciones Laborales</nombre>
            <plan>2001</plan>
            <creditos>280</creditos>
            <centro>Facultad de Ciencias Sociales</centro>
            <subdirector>Alfonso Marti­n  Luque</subdirector>
        </carrera>

        <carrera id="c04">
            <nombre>Lic. Quimica</nombre>
            <plan>2003</plan>
            <creditos>175</creditos>
            <centro>Facultad de Ciencias Experimentales</centro>
        </carrera>

        <carrera id="c05">
            <nombre>Lic. Biologia</nombre>
            <plan>2001</plan>
            <creditos>175</creditos>
            <centro>Facultad de Ciencias Experimentales</centro>
        </carrera>

        <carrera id="c06">
            <nombre>Lic. Humanidades</nombre>
            <plan>1980</plan>
            <creditos>475</creditos>
            <centro>Facultad de Humanidades</centro>
        </carrera>

    </carreras>
<!-- ASIGNATURAS -->

    <asignaturas>

        <asignatura id="a01" titulacion="c01">
            <nombre>Ofimatica</nombre>
            <creditos_teoricos>3</creditos_teoricos>
            <creditos_practicos>1.5</creditos_practicos>
            <trimestre>1</trimestre>
        </asignatura>

        <asignatura id="a02" titulacion="c01">
            <nombre>Ingenieria del Software</nombre>
            <creditos_teoricos>6</creditos_teoricos>
            <creditos_practicos>1.5</creditos_practicos>
            <trimestre>2</trimestre>
        </asignatura>

        <asignatura id="a03" titulacion="c02">
            <nombre>Administracion de Empresas</nombre>
            <creditos_teoricos>4</creditos_teoricos>
            <creditos_practicos>1.5</creditos_practicos>
            <trimestre>1</trimestre>
        </asignatura>

        <asignatura id="a04" titulacion="c02">
            <nombre>Derecho Internacional</nombre>
            <creditos_teoricos>4</creditos_teoricos>
            <creditos_practicos>5</creditos_practicos>
            <trimestre>1</trimestre>
        </asignatura>

        <asignatura id="a05" titulacion="c04">
            <nombre>Pedagogia</nombre>
            <creditos_teoricos>4</creditos_teoricos>
            <creditos_practicos>1.5</creditos_practicos>
            <trimestre>2</trimestre>
        </asignatura>

        <asignatura id="a06" titulacion="c03">
            <nombre>Didactica</nombre>
            <creditos_teoricos>4</creditos_teoricos>
            <creditos_practicos>3</creditos_practicos>
            <trimestre>2</trimestre>
        </asignatura>

        <asignatura id="a07" titulacion="c04">
            <nombre>Tecnologi­a de los Alimentos</nombre>
            <creditos_teoricos>1.5</creditos_teoricos>
            <creditos_practicos>7.5</creditos_practicos>
            <trimestre>2</trimestre>
        </asignatura>

        <asignatura id="a08" titulacion="c01">
            <nombre>Bases de Datos</nombre>
            <creditos_teoricos>4.5</creditos_teoricos>
            <creditos_practicos>5.5</creditos_practicos>
            <trimestre>1</trimestre>
        </asignatura>

        <asignatura id="a09" titulacion="c06">
            <nombre>Historia del Pensamiento</nombre>
            <creditos_teoricos>6</creditos_teoricos>
            <creditos_practicos>0</creditos_practicos>
            <trimestre>2</trimestre>
        </asignatura>

    </asignaturas>

<!-- ALUMNOS -->

    <alumnos>

        <alumno id="e01">
            <apellido1>Rivas</apellido1>
            <apellido2>Santos</apellido2>
            <nombre>VÃ­ctor Manuel</nombre>
            <sexo>Hombre</sexo>
            <estudios>
                <carrera codigo="c01"/>
                <asignaturas>
                    <asignatura codigo="a01"/>
                    <asignatura codigo="a03"/>
                    <asignatura codigo="a05"/>
                    <asignatura codigo="a09"/>
                </asignaturas>
            </estudios>
        </alumno>

        <alumno id="e02">
            <apellido1>Perez</apellido1>
            <apellido2>Garci­a</apellido2>
            <nombre>Luisa</nombre>
            <sexo>Mujer</sexo>
            <estudios>
                <carrera codigo="c02"/>
                <asignaturas>
                    <asignatura codigo="a02"/>
                    <asignatura codigo="a01"/>
                </asignaturas>
                <proyecto>Web de IBM.com</proyecto>
            </estudios>

        </alumno>

        <alumno id="e03" beca="si">
            <apellido1>Perez</apellido1>
            <apellido2>Romero</apellido2>
            <nombre>Fernando</nombre>
            <sexo>Hombre</sexo>
            <estudios>
                <carrera codigo="c02"/>
                <asignaturas>
                    <asignatura codigo="a02"/>
                    <asignatura codigo="a01"/>
                    <asignatura codigo="a04"/>
                    <asignatura codigo="a09"/>
                </asignaturas>
            </estudios>
        </alumno>

        <alumno id="e04">
            <apellido1>Avalan</apellido1>
            <apellido2>Jimenez</apellido2>
            <nombre>Maria</nombre>
            <sexo>Mujer</sexo>
            <estudios>
                <carrera codigo="c01"/>
                <asignaturas>
                    <asignatura codigo="a02"/>
                    <asignatura codigo="a01"/>
                    <asignatura codigo="a07"/>
                </asignaturas>
                <proyecto>Estudio de Salinidad del Pantano Iris</proyecto>
            </estudios>
        </alumno>

    </alumnos>

</universidad>
```

- Obten la siguiente información:
 - Pais de la Universidad.
 - Nombres de las Carreras.
 - Años de plan de estudio de las carreras.
 - Nombres de todos los alumnos.
 - Identificadores de todas las carreras.
 - Datos de la carrera cuyo id es c01.
 - Centro en que se estudia de la carrera cuyo id es c02.
 - Nombre de las carreras que tengan subdirector.
 - Nombre de los alumnos que estén haciendo proyecto.
 - Códigos de las carreras en las que hay algún alumno matriculado.
 - Apellidos y Nombre de los alumnos con beca.
 - Nombre de las asignaturas de la titulación c04.
 - Nombre de las asignaturas de segundo trimestre.
 - Nombre de las asignaturas quse no tienen 4 créditos teóricos.
 - Código de la carrera que estudia el último alumno.
 - Código de las asignaturas que estudian mujeres.
 - Nombre de los alumnos que matriculados en la asignatura a02.
 - Códigos de las carreras que estudian los alumnos matriculados en alguna asignatura.
 - Apellidos de todos los hombres.
 - Nombre de la carrera que estudia Víctor Manuel.
 - Nombre de las asignaturas que estudia Luisa.
 - Primer apellido de los alumnos matriculados en Ingeniería del Software.
 - Nombre de las carreras que estudian los alumnos matriculados en la asignatura Tecnología de los Alimentos.
 - Nombre de los alumnos matriculados en carreras que no tienen subdirector.
 - Nombre de las alumnos matriculados en asignaturas con 0 créditos prácticos y que estudien la carrera de I.T. Informática .
 - Nombre de los alumnos que estudian carreras cuyos planes son anteriores a 2002.

__Genera un informe con las soluciones de cada uno de los ejercicios propuestos__.
