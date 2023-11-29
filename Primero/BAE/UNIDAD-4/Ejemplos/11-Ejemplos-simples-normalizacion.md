<div align="justify">

# Explicación práctica de la 4 FN o FNBC

La __FNBC__ o __4 FN__ se aplica a _relaciones de base de datos para eliminar redundancias_ y _dependencias funcionales_ que podrían conducir a __anomalías en la actualización de datos__. Veamos la explicación con un pequeño ejemplo explicado:

Primero recuerda que:
- __Primera Forma Normal (1FN)__
Asegura que cada celda en una tabla contenga un sólo valor, evitando la existencia de conjuntos anidados o valores múltiples en una columna.
- __Segunda Forma Normal (2FN)__
  - Cumple con 1FN.
  - Elimina las dependencias parciales, es decir, asegura que cada columna en una tabla dependa completamente de la clave primaria.
- __Tercera Forma Normal (3FN)__
  - Cumple con 2FN.
  - Elimina las dependencias transitivas, asegurando que no haya dependencias no triviales de atributos no clave a atributos clave.
  
## Forma Normal de Boyce-Codd (FNBC) 0 4 FN.
 
- Cumple con 3FN.
- Va un paso más allá y elimina las dependencias no triviales entre atributos no clave, garantizando que todas las dependencias sean directamente sobre la clave primaria.
Para ilustrar cómo se aplica la __FNBC__, consideremos una tabla de ejemplo:

### Tabla: Estudiantes_Cursos

| Estudiante_ID | Curso_ID | Profesor_ID | Nombre_Curso | Nombre_Profesor | Departamento |
|---------------|-----------|-------------|--------------|-----------------|--------------|
| 1             | 101       | 501         | Matemáticas  | Dr. Smith       | Matemáticas  |
| 1             | 102       | 502         | Historia      | Prof. Johnson   | Historia      |
| 2             | 101       | 501         | Matemáticas  | Dr. Smith       | Matemáticas  |

En este caso, la clave primaria es __{Estudiante_ID, Curso_ID}__. Ahora, supongamos que el nombre del profesor y el departamento dependen únicamente del __Curso_ID__. En este caso, podemos dividir la tabla en dos:

### Tabla: Cursos


| Curso_ID | Nombre_Curso | Nombre_Profesor | Departamento |
|----------|--------------|-----------------|--------------|
| 101      | Matemáticas  | Dr. Smith       | Matemáticas  |
| 102      | Historia      | Prof. Johnson   | Historia      |

Tabla: Estudiantes_Cursos

| Estudiante_ID | Curso_ID |
|---------------|-----------|
| 1             | 101       |
| 1             | 102       |
| 2             | 101       |

Esto cumple con la __FNBC__ al eliminar la dependencia no trivial del atributo no clave __(Nombre_Profesor, Departamento)__ a __(Curso_ID)__ en la tabla original.

</div>