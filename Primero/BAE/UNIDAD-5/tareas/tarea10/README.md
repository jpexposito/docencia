# Actividad 10 - 🤝 Relaciones 👭👫👬

## ¡Vamos a practicar INNER JOIN && WHERE! 👋 
__Antes de continuar, asegurate de saber cómo unir tablas con `JOIN ON` y `WHERE`.__

Revisa la [teoria whrere](../../sqlite/03_where.md), y [teoria join](../../sqlite/26_inner_join_.md)

---

<img src="modelo-er.png">

---

## Actividad

Utilizando la base de datos `chinook` 🚁🚁 que se __adjunta__,  practica como unir tablas para hacer consultas complejas.

>__Nota__: ___Realiza cada consulta que sea posible utilizando INNER JOIN && WHERE___.

* Proporciona una consulta que muestre solo los clientes de Brasil.

* Proporciona una consulta que muestre las facturas de clientes que son de Brasil.
  La tabla resultante debe mostrar el nombre completo del cliente, ID de factura, fecha de la factura
  y país de facturación.

* Proporciona una consulta que muestre solo los empleados que son Agentes de Ventas.

* Proporciona una consulta que muestre una lista única de países de facturación de la tabla de Facturas.

* Proporciona una consulta que muestre las facturas de clientes que son de Brasil.

* Proporciona una consulta que muestre las facturas asociadas con cada agente de ventas. La tabla resultante debe incluir el nombre completo del Agente de Ventas.

* Proporciona una consulta que muestre el Total de la Factura, nombre del cliente, país y nombre del Agente de Ventas para todas las facturas y clientes.

* ¿Cuántas facturas hubo en 2009 y 2011? ¿Cuáles son las ventas totales respectivas para cada uno de esos años?

* Mirando la tabla de InvoiceLine, proporciona una consulta que CUENTE el número de ítems de línea para el ID de factura 37.

* Mirando la tabla de InvoiceLine, proporciona una consulta que CUENTE el número de ítems de línea para cada Factura. PISTA: [GROUP BY](http://www.sqlite.org/lang_select.html#resultset)

* Proporciona una consulta que incluya el nombre de la pista con cada ítem de línea de factura.

* Proporciona una consulta que incluya el nombre de la pista comprada Y el nombre del artista con cada ítem de línea de factura.

* Proporciona una consulta que muestre el número total de pistas en cada lista de reproducción. El nombre de la lista de reproducción debe estar incluido en la tabla resultante.

* Proporciona una consulta que muestre todas las pistas, pero no muestre IDs. La tabla resultante debe incluir el nombre del álbum, el tipo de medio y el género.

* Proporciona una consulta que muestre todas las facturas.

* Proporciona una consulta que muestre las ventas totales realizadas por cada agente de ventas.

* ¿Qué agente de ventas realizó más ventas en 2009?

* Escribir una consulta que muestre todas las playlists de la base de datos.

* Escribe una consulta que liste todas las canciones de una playlist.

* Escribe una consulta que liste **exclusivamente** el nombre de las canciones de una playlist concreta, con el nombre de su género y el nombre de tipo de medio.

__ADELANTE__ 🦸.