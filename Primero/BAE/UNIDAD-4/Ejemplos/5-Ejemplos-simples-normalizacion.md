<div align="justify">

Vamos a considerar un ejemplo en el que tenemos una base de datos con información sobre cursos y sus requisitos, donde algunos requisitos son multievaluados y otros son atributos complejos.

Base de Datos No Normalizada: Cursos

## Tabla: Cursos

| CursoID | Nombre          | Requisitos                             |
|---------|-----------------|----------------------------------------|
| 1       | Matemáticas      | Algebra, Cálculo I                      |
| 2       | Informática      | Programación I, Algoritmos              |
| 3       | Literatura       | Análisis Literario, Historia de la Literatura |

En este ejemplo, el atributo __Requisitos__ es multievaluado, ya que cada curso puede tener múltiples requisitos. Además, algunos requisitos, como __Análisis Literario__ y __Historia de la Literatura__, podrían considerarse atributos complejos.

## Primera Forma Normal (1NF)

Una Relación está en __1FN__ ___si y sólo si___ _cada atributo es atómico_.


| CursoID | Nombre          | Requisitos                             |
|---------|-----------------|----------------------------------------|
| 1       | Matemáticas      | Algebra                     |
| 1       | Matemáticas      | Cálculo I                      |
| 2       | Informática      | Programación I              |
| 2       | Informática      | Algoritmos              |
| 3       | Literatura       | Análisis Literario |
| 3       | Literatura       | Historia de la Literatura |



## Segunda Forma Normal (2NF)

___HAY QUE RECORDAR QUE PARA ESTAR EN LA 2FN, HA DE ESTAR EN LA 1FN___.

(Una Relación esta en __2FN si y sólo si está en 1FN__ y _todos los atributos que_ ___NO___ _forman parte de la_ __Clave Principal__ _tienen dependencia funcional completa de ella_.)

Para abordar el atributo multievaluado, creamos una nueva tabla llamada __Requisitos__.

## Tabla: Cursos

| CursoID | Nombre          |
|---------|-----------------|
| 1       | Matemáticas      |
| 2       | Informática      |
| 3       | Literatura       |

## Tabla: Requisitos

| CursoID | Requisito                 |
|---------|---------------------------|
| 1       | Algebra                   |
| 1       | Cálculo I                 |
| 2       | Programación I            |
| 2       | Algoritmos                |
| 3       | Análisis Literario        |
| 3       | Historia de la Literatura |

__Sólo destacar que debemos crear una clave primaria para la tabla requisito__.

| RequsitoID | CursoID | Nombre                  |
|---------| ---------| --------------------------|
| 1001    | 1       | Algebra                   |
| 1002    | 1       | Cálculo I                 |
| 1003    | 2       | Programación I            |
| 1004    | 2       | Algoritmos                |
| 1005    | 3       | Análisis Literario        |
| 1006    | 3       | Historia de la Literatura |

## Tercera Forma Normal (3NF)

___HAY QUE RECORDAR QUE PARA ESTAR EN LA 3FN, HA DE ESTAR EN LA 2FN___.

(Una Relación esta en __3FN__ ___si y sólo si está en 2FN y no existen dependencias transitivas___. Todas las dependencias funcionales deben ser respecto a la clave principal)

___No hay dependencias transitivas en ninguna de las tablas, por lo que ya está en 3NF___.





</div>