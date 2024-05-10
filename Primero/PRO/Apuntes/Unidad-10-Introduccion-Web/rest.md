<div align="justify">

# Notaciones básicas para construir servicios

<div align="center">
    <img src="img/rest.png" width="400px">
</div>

PI es el acrónimo de **interfaz de programación de aplicaciones** (*application programming interface* en inglés). Es un conjunto de reglas bien definidas que se utilizan para especificar formalmente la comunicación entre dos componentes de software. 

## API REST
En la actualidad existen distintas clases de API, y hoy hablaremos un poco más acerca de las **API REST**. 

**¿Qué es una API REST?**
Una API REST es una interfaz de comunicación entre sistemas de información que usa el protocolo de transferencia de hipertexto (*hypertext transfer protocol* o HTTP, por su siglas en inglés) para obtener datos o ejecutar operaciones sobre dichos datos en diversos formatos, como pueden ser XML o JSON.

Se basa en el modelo cliente-servidor donde el cliente es el que solicita obtener los recursos o realizar alguna operación sobre dichos datos, mientras que el servidor es aquel ente que entrega o procesa dichos datos a solicitud del cliente.

**Criterios de API REST**
Existen diversos criterios para identificar si una API es REST o no. Algunos de ellos son que:

- Debe usar una arquitectura cliente-servidor.
- Las ejecuciones de la API no deben considerar el estado del cliente, el estado de peticiones anteriores o algún indicador almacenado que haga variar su comportamiento. La comunicación debe ser sin estado (*stateless*).
- Ha de estar orientada a recursos, usando las operaciones estándar de los verbos HTTP.
- Hace uso de la URL como identificador único de los recursos.
- Debe ser hipermedia: cuando se consulte un recurso, este debe contener links o hipervínculos de acciones o recursos que lo complementen.

**Diferencia entre RESTful y RESTless**
A menudo escuchamos estos términos al momento de diseñar, construir o interactuar con API. La diferencia es sencilla. Llamamos **RESTful** a todas aquellas API que cumplen completamente los criterios REST; mientras que llamamos **RESTless** a aquellas API que no cumplen del todo con los criterios REST.

Por ejemplo, una API que utiliza el verbo POST para todas sus operaciones no es una API RESTful, si no una API RESTless.

**¿Qué es la API Specification?**
La especificación de una API, o API Spec, es aquella documentación donde se describe el comportamiento de una API, también conocido como el contrato de la API. La finalidad de dicha documentación es guiar al desarrollador que va a integrar el uso de la API en su sistema. Es tal la importancia que ha tomado este rubro que existen diversas herramientas y estándares creados específicamente para describir una API REST como son RAML, Swagger y el estándar OpenAPI.

Los componentes primordiales que se describen en un API Spec son los siguientes:

- Verbo HTTP
- URL orientada a recursos
- HTTP Status

A continuación, verás una tabla de ejemplo para ilustrar estos conceptos:

| VERBO HTTP | URL DEL RECURSO | ACCIÓN | HTTP STATUS |
|------------|-----------------|--------|-------------|
| GET        | /libros         | Obtener una lista de libros | 200 - OK |
|            |                 |                               | 204 - Not Content: cuando no hay libros a listar |
| GET        | /libros/{id-libro} | Obtener detalle de un libro | 200 - OK |
|            |                 |                               | 404 - Not Found: cuando no existe el libro buscado |
| POST       | /libros         | Crear un recurso nuevo libro | 201 - Created |
| PUT        | /libros/{id-libro} | Modificar un recurso libro completamente | 200 - OK |
|            |                 |                               | 400 - Bad request: cuando algún parámetro enviado no cumple con las reglas |
| PATCH      | /libros/{id-libro} | Modificar un recurso libro parcialmente | 200 - OK |
|            |                 |                               | 201 - Created: si el recurso a modificar no existe se crea en automático |
|            |                 |                               | 400 - Bad request: cuando algún parámetro enviado no cumple con las reglas |
| DELETE     | /libros/{id-libro} | Eliminar un recurso libro   | 201 - Not Content: es el status standard a regresar en un verbo DELETE |

Las **API REST** han aportado mucho en la forma de comunicación entre sistemas. Al día de hoy, un gran porcentaje de las empresas que usan la tecnología para aportar valor a sus productos tienen **API REST** como forma estándar de comunicación.

Existe una cantidad enorme de API disponibles en Internet para agregar valor a cualquier desarrollo de software, ya sea para tercerizar algún módulo necesario para el sistema en cuestión (como timbrado de facturas, pagos online, etc.) o simplemente para mejorar la experiencia del usuario, como la geolocalización, el acceso con cuentas de redes sociales y demás.

## Referencias

- [Ejemplo simple](https://github.com/rashm1n/CXF-JAXRS/).
- [Nociones básicas de Rest-Api](https://blog.hubspot.es/website/que-es-api-rest)

</div>