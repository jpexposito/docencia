<div align="justify">

Dada la siguiente tabla de BBDD que almacena información de cursos, estudiantes y profesores. Realiza la normalización.

Conjunto de Datos Inicial:


| EstudianteID | Nombre      | Curso                   | Profesor       |
|--------------|-------------|-------------------------|----------------|
| 1            | Juan Pérez  | Matemáticas Básicas     | Dr. Rodríguez   |
| 2            | María López | Introducción a la Física| Dra. Gómez      |
| 3            | Carlos Ruiz | Matemáticas Básicas     | Dr. Rodríguez   |


## Primera Forma Normal (1NF)

La tabla original ya está en 1NF porque cada celda contiene un solo valor.

## Segunda Forma Normal (2NF)

(Una Relación esta en __2FN si y sólo si está en 1FN__ y _todos los atributos que_ ___NO___ _forman parte de la_ __Clave Principal__ _tienen dependencia funcional completa de ella_.). __Sacamos a otra tabla, aquellos atributos que no tengan dependencia con la clave principal si existe__.

### Tabla Estudiante

| EstudianteID | Nombre      | CursoID | 
|--------------|-------------|---------|
| 1            | Juan Pérez  | 1       | 
| 2            | María López | 2       | 
| 3            | Carlos Ruiz | 1       |

Se crea la tabla __Cursos_.

### Tabla de Cursos

| CursoID | Curso                   | ProfesorID    |
|---------|-------------------------|---------------|
| 1       | Matemáticas Básicas     | Dr. Rodríguez |
| 2       | Introducción a la Física| Dra. Gómez |


## Tercera Forma Normal (3NF)

(Una Relación esta en __3FN__ ___si y sólo si está en 2FN y no existen dependencias transitivas___. Todas las dependencias funcionales deben ser respecto a la clave principal).

Esto significa lo siguiente. La tabala Cursos tiene una dependencia transitiva, ya que almacena información que no le compete que es el profesor. Eliminamos esa dependencia transitiva creando la tabla __Profesor__ y la relacionamos con el curso.

### Tabla Estudiante


| EstudianteID | Nombre      | CursoID |
|--------------|-------------|---------|
| 1            | Juan Pérez  | 1       |
| 2            | María López | 2       |
| 3            | Carlos Ruiz | 1       |

### Tabla de Cursos

| CursoID | Curso                   | ProfesorID |  
|---------|-------------------------|------------|
| 1       | Matemáticas Básicas     | 1          |
| 2       | Introducción a la Física| 2          |

### Tabla de Profesores

| ProfesorID | Profesor       |
|------------|----------------|
| 1          | Dr. Rodríguez   |
| 2          | Dra. Gómez      |

La solución final tras la ___normalización queda en que la tabla se ha transformado en 3 tablas con la información normalizada___.

</div>