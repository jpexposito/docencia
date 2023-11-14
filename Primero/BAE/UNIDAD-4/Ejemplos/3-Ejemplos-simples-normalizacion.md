<div align="justify">

# Ejemplos de Normalización

 Supongamos que tenemos una base de datos que almacena información sobre __libros, autores y editoriales__.

 __Base de datos__:

| ISBN          | Título                    | Autor                   | Editorial     | Ciudad        |
|---------------|---------------------------|-------------------------|---------------|---------------|
| 123-456-789   | "Introducción a la BD"    | "Smith, Johnson"        | "Editorial A" | "Ciudad A"    |
| 234-567-890   | "Programación en Python"  | "Brown, Davis, Wilson"  | "Editorial B" | "Ciudad B"    |
| 345-678-901   | "SQL Avanzado"            | "Johnson, Lee"          | "Editorial C" | "Ciudad C"    |

## Primera Forma Normal (1NF)

| ISBN          | Título                    | Autor                   | Editorial     | Ciudad        |
|---------------|---------------------------|-------------------------|---------------|---------------|
| 123-456-789   | "Introducción a la BD"    | "Smith"                 | "Editorial A" | "Ciudad A"    |
| 123-456-789   | "Introducción a la BD"    | "Johnson"               | "Editorial A" | "Ciudad A"    |
| 234-567-890   | "Programación en Python"  | "Brown"                 | "Editorial B" | "Ciudad B"    |
| 234-567-890   | "Programación en Python"  | "Davis"                 | "Editorial B" | "Ciudad B"    |
| 234-567-890   | "Programación en Python"  | "Wilson"                | "Editorial B" | "Ciudad B"    |
| 345-678-901   | "SQL Avanzado"            | "Johnson"               | "Editorial C" | "Ciudad C"    |
| 345-678-901   | "SQL Avanzado"            | "Lee"                   | "Editorial C" | "Ciudad C"    |

En la 1NF, hemos __descompuesto la columna de autores, creando una fila separada para cada autor__.

## Segunda Forma Normal (2NF)

Para la 2NF, necesitamos asegurarnos de que cada atributo no clave sea totalmente dependiente de la clave primaria. En este caso, la clave primaria es el ISBN.


#### Tabla Libros

| ISBN          | Título                    | Editorial     |
|---------------|---------------------------|---------------|
| 123-456-789   | "Introducción a la BD"    | "Editorial A" |
| 234-567-890   | "Programación en Python"  | "Editorial B" |
| 345-678-901   | "SQL Avanzado"            | "Editorial C" |

#### Tabla Autores:

| ISBN          | Autor        |
|---------------|--------------|
| 123-456-789   | "Smith"      |
| 123-456-789   | "Johnson"    |
| 234-567-890   | "Brown"      |
| 234-567-890   | "Davis"      |
| 234-567-890   | "Wilson"     |
| 345-678-901   | "Johnson"    |
| 345-678-901   | "Lee"        |

En la __2NF__, hemos separado la información de autores y libros en dos tablas distintas, donde la clave primaria de la tabla de autores incluye el ISBN para garantizar la dependencia total.

## Tercera Forma Normal (3NF):

En la 3NF, debemos eliminar las dependencias transitivas.

#### Tabla Libros:
| ISBN          | Título                    | Editorial     |
|---------------|---------------------------|---------------|
| 123-456-789   | "Introducción a la BD"    | "Editorial A" |
| 234-567-890   | "Programación en Python"  | "Editorial B" |
| 345-678-901   | "SQL Avanzado"            | "Editorial C" |

#### Tabla Autores:
| Autor ID | Autor        |
|----------|--------------|
| 1        | "Smith"      |
| 2        | "Johnson"    |
| 3        | "Brown"      |
| 4        | "Davis"      |
| 5        | "Wilson"     |
| 6        | "Lee"        |

#### Tabla LibrosAutores:
| ISBN          | Autor ID |
|---------------|----------|
| 123-456-789   | 1        |
| 123-456-789   | 2        |
| 234-567-890   | 3        |
| 234-567-890   | 4        |
| 234-567-890   | 5        |
| 345-678-901   | 2        |
| 345-678-901   | 6        |

En la __3NF__, hemos creado una tabla separada para los autores y sus identificadores, eliminando así la dependencia transitiva de la tabla de libros. La tabla LibrosAutores vincula las tablas Libros y Autores.

</div>