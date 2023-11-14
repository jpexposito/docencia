<div align="justify">

# Ejemplos de Normalización

Supongamos que tenemos la siguiente base de datos:

| Estudiante_ID | Nombre    | Curso_ID | Descripción     | Profesor     |
|---------------|-----------|----------|-----------------|--------------|
| 1             | Juan      | 101      | Matemáticas     | Dr. Rodríguez |
| 1             | Juan      | 102      | Historia         | Dr. Pérez     |
| 2             | Maria     | 101      | Matemáticas     | Dr. Rodríguez |
| 3             | Carlos    | 103      | Ciencias        | Dr. Gómez     |
| 3             | Carlos    | 104      | Literatura       | Dr. García    |

## Primera Forma Normal (1NF)

Para llevar la base de datos a __1NF__, eliminamos las repeticiones y obtenemos:

| Estudiante_ID | Nombre    | Curso_ID | Descripción     | Profesor     |
|---------------|-----------|----------|-----------------|--------------|
| 1             | Juan      | 101      | Matemáticas     | Dr. Rodríguez |
| 1             | Juan      | 102      | Historia         | Dr. Pérez     |
| 2             | Maria     | 101      | Matemáticas     | Dr. Rodríguez |
| 3             | Carlos    | 103      | Ciencias        | Dr. Gómez     |
| 3             | Carlos    | 104      | Literatura       | Dr. García    |

Cada fila ahora tiene valores atómicos, cumpliendo con __1NF__.

## Segunda Forma Normal (2NF)

En 2NF, buscamos eliminar dependencias parciales. En este caso, identificamos que el Profesor depende solo del Curso_ID. Creamos dos tablas separadas:

__Estudiantes__

| Estudiante_ID | Nombre    |
|---------------|-----------|
| 1             | Juan      |
| 2             | Maria     |
| 3             | Carlos    |

__Cursos__

| Curso_ID | Descripción     | Profesor     |
|----------|-----------------|--------------|
| 101      | Matemáticas     | Dr. Rodríguez |
| 102      | Historia         | Dr. Pérez     |
| 103      | Ciencias        | Dr. Gómez     |
| 104      | Literatura       | Dr. García    |

## Tercera Forma Normal (3NF)

En 3NF, eliminamos las dependencias transitivas. Observamos que la Descripción del curso depende solo del Curso_ID. Creamos una tabla adicional:

__Descripciones_Cursos__


| Curso_ID | Descripción     |
|----------|-----------------|
| 101      | Matemáticas     |
| 102      | Historia         |
| 103      | Ciencias        |
| 104      | Literatura       |

Ahora, tenemos tres tablas en 3NF: __Estudiantes, Cursos y Descripciones_Cursos__. Cada tabla tiene una clave primaria única y las dependencias funcionales se han eliminado. Este es un ejemplo básico, y en situaciones más complejas, se pueden requerir más pasos para lograr la normalización adecuada.

</div>