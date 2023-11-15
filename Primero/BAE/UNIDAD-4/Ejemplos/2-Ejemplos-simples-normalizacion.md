<div align="justify">

# Ejemplos de Normalización

Supongamos que tenemos la siguiente base de datos:

| Estudiante_ID | Nombre    | Curso_ID | Descripción     | Profesor     |
|---------------|-----------|----------|-----------------|--------------|
| 1             | Juan      | 101,102      | Matemáticas,Historia     | Dr. Rodríguez |
| 2             | Maria     | 101      | Matemáticas     | Dr. Rodríguez |
| 3             | Carlos    | 103,104      | Ciencias,Literatura       | Dr. Gómez     |

## Primera Forma Normal (1NF)

Una Relación está en __1FN__ ___si y sólo si___ _cada atributo es atómico_.

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

(Una Relación esta en __2FN si y sólo si está en 1FN__ y _todos los atributos que_ ___NO___ _forman parte de la_ __Clave Principal__ _tienen dependencia funcional completa de ella_.). En 2NF, buscamos eliminar dependencias parciales, es decir, __sacamos a otra tabla, aquellos atributos que no tengan dependencia con la clave principal si existe__. En este caso, identificamos que el __Profesor__ depende solo del __Curso_ID__, junto con la __descripción__ del mismo. Creamos dos tablas separadas:

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

(Una Relación esta en __3FN__ ___si y sólo si está en 2FN y no existen dependencias transitivas___. Todas las dependencias funcionales deben ser respecto a la clave principal).En 3NF, eliminamos las dependencias transitivas. Observamos que la Descripción del curso depende solo del Curso_ID. Creamos una tabla adicional, que es la que representa al Profesor y se elimina del curso. quedando como sigue:

__Cursos__


| Curso_ID | Descripción     |
|----------|-----------------|
| 101      | Matemáticas     |
| 102      | Historia         |
| 103      | Ciencias        |
| 104      | Literatura       |

| Profesor_ID | Profesor     |
|----------|--------------|
| 1001      | Dr. Rodríguez |
| 1002      | Dr. Pérez     |
| 1003      | Dr. Gómez     |
| 1004      | Dr. García    |

Nos faltaría relacionar la tabla __Cursos__ con __Profesor__, podemos interpretar una relacion __1:1, 1:N, o N:M__ justificando la respuesta.

Ahora, tenemos tres tablas en 3NF: __Estudiantes, Cursos y Profesor__ al menos o una adicional si tenemos relaciones __N:M__. Cada tabla tiene una clave primaria única y las dependencias funcionales se han eliminado. Este es un ejemplo básico, y en situaciones más complejas, se pueden requerir más pasos para lograr la normalización adecuada.

</div>