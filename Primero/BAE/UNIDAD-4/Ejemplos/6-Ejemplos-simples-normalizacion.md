<div align="justify">
Una tabla que almacena información sobre libros y sus autores, donde un libro puede tener varios autores y cada autor tiene múltiples atributos.

Base de Datos No Normalizada: Libros

## Tabla: Libros


## Libros

| ISBN       | Título          | Autores                         | Dirección                                       |
|------------|-----------------|---------------------------------|-------------------------------------------------|
| 978-1-2345 | "Database 101"  | John Doe, Jane Smith             | 123 Main St, City1, Country1                    |
| 978-2-3456 | "Web Development"| Alice Johnson, Bob Williams      | 456 Oak St, City2, Country2                      |


## Primera Forma Normal (1NF)

Una Relación está en __1FN__ ___si y sólo si___ _cada atributo es atómico_.


En este caso, la columna de __Autores__ es multievaluada, ya que puede contener más de un autor, y la columna __Dirección__ es compleja porque contiene más de un atributo.


| ISBN       | Título          | Autores                         | Calle           | Ciudad | Pais        |
|------------|-----------------|---------------------------------|-----------------| --------- |--------------|
| 978-1-2345 | "Database 101"  | John Doe, Jane Smith             | 123 Main St |  City1 | Country1 |
| 978-2-3456 | "Web Development"| Alice Johnson, Bob Williams      | 456 Oak St | City2 | Country2 |

Una tabla que almacena información sobre libros y sus autores, donde un libro puede tener varios autores y cada autor tiene múltiples atributos.

Base de Datos No Normalizada: Libros

## Tabla: Libros


## Libros

| ISBN       | Título          | Autores                         | Dirección                                       |
|------------|-----------------|---------------------------------|-------------------------------------------------|
| 978-1-2345 | "Database 101"  | John Doe, Jane Smith             | 123 Main St, City1, Country1                    |
| 978-2-3456 | "Web Development"| Alice Johnson, Bob Williams      | 456 Oak St, City2, Country2                      |


## Primera Forma Normal (1NF)

Una Relación está en __1FN__ ___si y sólo si___ _cada atributo es atómico_.


En este caso, la columna de __Autores__ es multievaluada, ya que puede contener más de un autor, y la columna __Dirección__ es compleja porque contiene más de un atributo.

Volvemos _átomicos los datos compuestos__.

| ISBN       | Título          | Autores                         | Calle           | Ciudad | Pais        |
|------------|-----------------|---------------------------------|-----------------| --------- |--------------|
| 978-1-2345 | "Database 101"  | John Doe, Jane Smith             | 123 Main St |  City1 | Country1 |
| 978-2-3456 | "Web Development"| Alice Johnson, Bob Williams      | 456 Oak St | City2 | Country2 |


Volvemos _átomicos los datos multievaluados__.

| ISBN       | Título          | Autores                         | Calle           | Ciudad | Pais        |
|------------|-----------------|---------------------------------|-----------------| --------- |--------------|
| 978-1-2345 | "Database 101"  | John Doe             | 123 Main St |  City1 | Country1 |
| 978-1-2345 | "Database 101"  | Jane Smith             | 123 Main St |  City1 | Country1 |
| 978-2-3456 | "Web Development"| Alice Johnson     | 456 Oak St | City2 | Country2 |
| 978-2-3456 | "Web Development"| Bob Williams      | 456 Oak St | City2 | Country2 |



## Segunda Forma Normal (2NF)

___HAY QUE RECORDAR QUE PARA ESTAR EN LA 2FN, HA DE ESTAR EN LA 1FN__.

(Una Relación esta en __2FN si y sólo si está en 1FN__ y _todos los atributos que_ ___NO___ _forman parte de la_ __Clave Principal__ _tienen dependencia funcional completa de ella_.)


### Libros

| ISBN       | Título          |
|------------|-----------------|
| 978-1-2345 | "Database 101"  |
| 978-2-3456 | "Web Development"|

### Autores

| AutorID | Nombre         | Calle           | Ciudad | Pais        |
|---------|----------------|-------------| --------- |--------------|
| 1       | John Doe       | 123 Main St |  City1 | Country1 |
| 2       | Jane Smith     | Jane Smith  | 123 Main St |  City1 | Country1 |
| 3       | Alice Johnson  | Alice Johnson     | 456 Oak St | City2 | Country2 |
| 4       | Bob Williams   | Bob Williams      | 456 Oak St | City2 | Country2 |

Y creamos la __relación autiros y libros__.

### Autores_Libros

| ISBN       | AutorID |
|------------|---------|
| 978-1-2345 | 1       |
| 978-1-2345 | 2       |
| 978-2-3456 | 3       |
| 978-2-3456 | 4       |


## Tercera Forma Normal (3NF)

___HAY QUE RECORDAR QUE PARA ESTAR EN LA 3FN, HA DE ESTAR EN LA 2FN__.

(Una Relación esta en __3FN__ ___si y sólo si está en 2FN y no existen dependencias transitivas___. Todas las dependencias funcionales deben ser respecto a la clave principal)

La dirección de la tabla __autores__ se considera como un atributo complejo, podríamos crear una tabla Direcciones y relacionarla con la tabla Autores.

### Libros

| ISBN       | Título          |
|------------|-----------------|
| 978-1-2345 | "Database 101"  |
| 978-2-3456 | "Web Development"|

### Autores

| AutorID | Nombre         | DireccionID |
|---------|----------------|-------------|
| 1       | John Doe       | 1001        |
| 2       | Jane Smith     | 1002        |
| 3       | Alice Johnson  | 1003        |
| 4       | Bob Williams   | 1004        |

## Direcciones

| DireccionID | Calle           | Ciudad | Pais        |
|-------------|-----------------|--------|-------------|
| 1001        | 123 Main St     | City1  | Country1    |
| 1002        | 456 Oak St      | City2  | Country2    |
| 1003        | 789 Elm St      | City3  | Country3    |
| 1004        | 987 Pine St     | City4  | Country4    |

## Autores_Libros

| ISBN       | AutorID |
|------------|---------|
| 978-1-2345 | 1       |
| 978-1-2345 | 2       |
| 978-2-3456 | 3       |
| 978-2-3456 | 4       |


La base de datos se encuentra normalizada.


</div>