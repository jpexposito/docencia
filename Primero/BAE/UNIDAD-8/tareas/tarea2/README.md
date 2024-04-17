<div align="justify">

# Trabajo con la BBDD Jardineria

Vamos a realizar el trabajo con una BBDD existente en la documentación  oficial de MySql. Su nombre es __jardineria__.

El __diagrama ER__ de esta BBDD es el siguiente:

<div align="center">
<img width="700" src="img/er.png"/>
</div>

Se pide realizar los procedimientos y funciones:

Realice los siguientes procedimientos y funciones sobre la base de datos jardineria.
- Función  __calcular_precio_total_pedido__
  >__Nota__:Dado un código de pedido la función debe calcular la suma total del pedido. Tenga en cuenta que un pedido puede contener varios productos diferentes y varias cantidades de cada producto.
   - Parámetros de entrada: codigo_pedido (INT)
   - Parámetros de salida: El precio total del pedido (FLOAT)
- Función  __calcular_suma_pedidos_cliente__
  >__Nota__:Dado un código de cliente la función debe calcular la suma total de todos los pedidos realizados por el cliente. Deberá hacer uso de la función calcular_precio_total_pedido que ha desarrollado en el apartado anterior.
  - Parámetros de entrada: codigo_cliente (INT)
  - Parámetros de salida: La suma total de todos los pedidos del cliente (FLOAT)

- Función __calcular_suma_pagos_cliente__
  >__Nota__:Dado un código de cliente la función debe calcular la suma total de los pagos realizados por ese cliente.
  - Parámetros de entrada: codigo_cliente (INT)
  - Parámetros de salida: La suma total de todos los pagos del cliente (FLOAT)
- Procedimiento __calcular_pagos_pendientes__
  >__Nota__:Deberá calcular los pagos pendientes de todos los clientes. Para saber si un cliente tiene algún pago pendiente deberemos calcular cuál es la cantidad de todos los pedidos y los pagos que ha realizado. Si la cantidad de los pedidos es mayor que la de los pagos entonces ese cliente tiene pagos pendientes.

### Carga de datos

- Realiza la carga de la BBDD de [Jardineria](file/jardineria.sql) y describe los pasos que has realizado.


## Referencias

- [Apuntes sobre procedimientos y funciones](../../procedimientos.md).

</div>