<div align="justify">

# Ejemplos de Normalización

# 1ª Forma Normal (1NF) en Bases de Datos

Las tablas deben satisfacer ciertos criterios:

1. **Valores Atómicos:** Cada celda de la tabla debe contener un solo valor, evitando la presencia de valores múltiples o compuestos. Esto asegura que cada dato sea atómico.
2. **Identificador Único:** Cada fila en la tabla debe tener un identificador único (clave primaria) que permita distinguir entre registros.

Hemos de prestar atensión a las propiedades __multivaluadas y las compuestas__.

## Personas que poseen teéfonos

Se trata del caso (**Valores Atómicos**).

| ID | Nombre          | Teléfonos          |
|----|-----------------|-------------------|
| 1  | Juan Pérez      | 555-1234, 555-5678 |

Vemos que tiene un valor multivaluado __(Teléfonos)__.

El paso a __1FN__ queda como sigue:

| ID | Nombre      | Teléfono   |
|----|-------------|------------|
| 1  | Juan Pérez  | 555-1234   |
| 1  | Juan Pérez  | 555-5678   |

Existen valores repetidos, con lo cual construimos la tabla teléfono.

| ID (__PK__) | Nombre      |
|----|-------------|
| 1  | Juan Pérez  |

| ID (__FK__) | Teléfono (__PK__)  |
|----|------------|
| 1  | 555-1234   | 
| 1  | 555-5678   | 

Interpretamos que una persona __SÓLO PUEDE TENER UN TELÉFONO__

## Personas que poseen direcciones

Se trata de una propiedad compuesta (**Identificador Único**).

| Nombre      | Direccion |
|-------------|-----------|
| Juan Pérez  | Ciudad A  |
| Ana Gómez   | Ciudad A |

Existen valores repetidos y que son compuestos. Por este motivo realizamos la transformación.

| Nombre      |
|-------------|
| Juan Pérez  |
| Ana Gómez   |

pasa a:

| ID (__PK__) | Nombre |
|----|-------------|
| 1  | Juan Pérez  |
| 2  | Ana Gómez   |

y

| Direccion |
|-----------|
| Ciudad A  |
| Ciudad A |

pasa a la tabla __Vive__:

| ID_Persona (__PK,FK__) | ID_Ciudad (__PK,FK__)  |
|----|------------|
| 1  | 1   |
| 2  | 1   |

y la tabla __Dirección__:

| ID (__PK__) | Nombre |
|----|-------------|
| 1  | A  |

Con lo cual se ha transformado en 3 tablas, dado que consideramos que una persona puede tener varias direcciones y en una dirección puede pertenecer a varias personas.

</div>