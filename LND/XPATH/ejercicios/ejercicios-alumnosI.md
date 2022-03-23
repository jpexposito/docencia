<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>

1. Dada la siguiente información de alumnos de un centro:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="transformar.xsl"?>
<instituto codigo="38010700" nombre="IES Domingo Pérez Minik">
    <curso codigo="1" nombre="1º ASIR">
        <alumno cial="A18X111">
            <nombre>Javier</nombre>
            <apellidos>Márquez Fernández</apellidos>
            <!-- Javier Márquez NO es un alumno repetidor -->
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Lenguajes de marcas</asignatura>
                <nota>8</nota>
                <asignatura>Redes</asignatura>
                <nota>7</nota>
                <asignatura>Fundamentos de hardware</asignatura>
                <nota>3</nota>
                <asignatura>Sistemas Operativos</asignatura>
                <nota>6</nota>
            </notas>
        </alumno>
        <alumno cial="A27M242">
            <nombre>María</nombre>
            <apellidos>Álvarez Pérez</apellidos>
            <repetidor>True</repetidor>
            <notas>
                <asignatura>Lenguajes de marcas</asignatura>
                <nota>5</nota>
                <asignatura>Redes</asignatura>
                <nota>5</nota>
                <asignatura>Fundamentos de hardware</asignatura>
                <nota>7</nota>
                <asignatura>Sistemas Operativos</asignatura>
                <nota>6</nota>
            </notas>
        </alumno>
        <alumno cial="A90R112">
            <nombre>Iván</nombre>
            <apellidos>Rodríguez Pérez</apellidos>
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Lenguajes de marcas</asignatura>
                <nota>4</nota>
                <asignatura>Redes</asignatura>
                <nota>9</nota>
                <asignatura>Fundamentos de hardware</asignatura>
                <nota>9</nota>
                <asignatura>Sistemas Operativos</asignatura>
                <nota>3</nota>
            </notas>
        </alumno>
    </curso>
    <curso codigo="2" nombre="2º ASIR">
        <alumno cial="A92T861">
            <nombre>Marcos</nombre>
            <apellidos>Domínguez</apellidos>
            <repetidor>True</repetidor>
            <notas>
                <asignatura>Seguridad Informática</asignatura>
                <nota>5</nota>
                <asignatura>Planificación de redes</asignatura>
                <nota>8</nota>
                <asignatura>Servicios web</asignatura>
                <nota>7</nota>
                <asignatura>Prácticas de empresa</asignatura>
                <nota>APTO</nota>
            </notas>
        </alumno>
        <alumno cial="A92R003">
            <nombre>Luis Fernando</nombre>
            <apellidos>Jiménez Pérez</apellidos>
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Seguridad Informática</asignatura>
                <nota>3</nota>
                <asignatura>Planificación de redes</asignatura>
                <nota>4</nota>
                <asignatura>Servicios web</asignatura>
                <nota>4</nota>
                <asignatura>Prácticas de empresa</asignatura>
                <nota>No APTO</nota>
            </notas>
        </alumno>
        <alumno cial="A87R122">
            <nombre>Elena</nombre>
            <apellidos>Ramírez</apellidos>
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Seguridad Informática</asignatura>
                <nota>6</nota>
                <asignatura>Planificación de redes</asignatura>
                <nota>10</nota>
                <asignatura>Servicios web</asignatura>
                <nota>8</nota>
                <asignatura>Prácticas de empresa</asignatura>
                <nota>APTO</nota>
            </notas>
        </alumno>
    </curso>
    <curso codigo="3" nombre="1º DAI">
        <alumno cial="A95M600">
            <nombre>Irina</nombre>
            <apellidos>Lugo Lugo</apellidos>
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Programación</asignatura>
                <nota>8</nota>
                <asignatura>Análisis</asignatura>
                <nota>7</nota>
                <asignatura>Medios</asignatura>
                <nota>3</nota>
                <asignatura>Multimedia</asignatura>
                <nota>6</nota>
            </notas>
        </alumno>
        <alumno cial="A92R543">
            <nombre>Genaro</nombre>
            <apellidos>Hernández Hernández</apellidos>
            <repetidor>True</repetidor>
            <notas>
                <asignatura>Programación</asignatura>
                <nota>5</nota>
                <asignatura>Análisis</asignatura>
                <nota>5</nota>
                <asignatura>Medios</asignatura>
                <nota>7</nota>
                <asignatura>Multimedia</asignatura>
                <nota>6</nota>
            </notas>
        </alumno>
        <alumno cial="A92R590">
            <nombre>Miguel</nombre>
            <apellidos>Rodríguez</apellidos>
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Programación</asignatura>
                <nota>4</nota>
                <asignatura>Multimedia</asignatura>
                <nota>3</nota>
            </notas>
        </alumno>
    </curso>
</instituto>  
```

- Obtén el listado de alumnos del instituto.

```
  /instituto/curso/alumno

  ó si quiero sólo el nombre

  /instituto/curso/alumno/nombre
```

- Obtén el primer alumno que esta en el segundo curso.

```
    /instituto/curso[@codigo=2]/alumno[1]
```

- Obtén el nombre y apellidos de todos los alumnos de 1º de ASIR.

```xml
    /instituto/curso[@nombre="1º ASIR"]/alumno/nombre | /instituto/curso[@nombre="1º ASIR"]/alumno/apellidos
```

- Obtén el nombre de todos los alumnos que comiencen por __M__.

```xml
    /instituto/curso/alumno[starts-with(nombre, "M")]/nombre
```

## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
