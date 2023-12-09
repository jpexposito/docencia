<div align="justify">

# Tipos de Datos en SQLite, MySQL y MariaDB

| Tipo de Dato  | SQLite                       | MySQL                      | MariaDB                    | Descripción                                      |
|---------------|------------------------------|----------------------------|----------------------------|--------------------------------------------------|
| **Numéricos** |                              |                            |                            |                                                  |
| INTEGER       | INTEGER                      | INT                        | INT                        | Números enteros                                   |
| REAL          | REAL                         | FLOAT                      | FLOAT                      | Números de punto flotante                         |
| NUMERIC       | NUMERIC                      | DECIMAL                    | DECIMAL                    | Números decimales                                 |
| TEXT          | TEXT                         | TEXT                       | TEXT                       | Texto, cadenas de caracteres                      |
| BLOB          | BLOB                         | LONGBLOB                   | LONGBLOB                   | Datos binarios grandes                            |
|               |                              |                            |                            |                                                  |
| **Fecha/Hora**|                              |                            |                            |                                                  |
| DATE          | DATE                         | DATE                       | DATE                       | Fecha                                            |
| TIME          | TIME                         | TIME                       | TIME                       | Hora                                             |
| DATETIME      | DATETIME                     | DATETIME                   | DATETIME                   | Fecha y hora                                     |
|               |                              |                            |                            |                                                  |
| **Otros**     |                              |                            |                            |                                                  |
| CHAR          | -                            | CHAR                       | CHAR                       | Cadena de longitud fija                          |
| VARCHAR       | -                            | VARCHAR                    | VARCHAR                    | Cadena de longitud variable                      |
| TIMESTAMP     | -                            | TIMESTAMP                  | TIMESTAMP                  | Marca de tiempo                                  |
| YEAR          | -                            | YEAR                       | YEAR                       | Año (en formato de cuatro dígitos)              |

* Notas:
  - En SQLite, el tipo de dato `INTEGER` se utiliza para todos los enteros, independientemente del tamaño.
  - Los tipos de datos `CHAR` y `VARCHAR` en SQLite son generalmente tratados como `TEXT`.
  - Algunos tipos de datos en MySQL y MariaDB pueden tener modificadores (por ejemplo, `CHAR(255)`).

</div>