<div align="justify">

# Repasando consultas I

---

Vamos a repasar consultas a través de la BBDD [jardineria](jardineria.db).

Para realizar las consulas, debes de tener en cuenta su __diagrama er__.

<img src="img/jardineria-er.png">

---

Recuerda leer bien las consulas y consultas los [apuntes](../../sqlite/), para recordar cualquier duda que tengas.

>__Nota__: _Cuando tengas una consulta larga, que creas que no sabes hacer, hazla en pequeñas partes_.



## Consultas a Realizar

### Consultas SQL sobre una tabla

- Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
- Devuelve un listado con la ciudad y el teléfono de las oficinas de España.
- Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
- Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.
- Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
- Devuelve un listado con el nombre de los todos los clientes españoles.
- Devuelve un listado con los distintos estados por los que puede pasar un pedido.
- Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos.
- Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos que no han sido entregados a tiempo.
- Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada.
- Devuelve un listado de todos los pedidos que fueron rechazados en 2009.
- Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de cualquier año.
- Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal. Ordene el resultado de mayor a menor.
- Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. Tenga en cuenta que no deben aparecer formas de pago repetidas.
- Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales y que tienen más de 100 unidades en stock. El listado deberá estar ordenado por su precio de venta, mostrando en primer lugar los de mayor precio.
- Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo representante de ventas tenga el código de empleado 11 o 30.

### Consultas multitabla (Where para unir tablas)

- Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
- Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas.
- Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas.
- Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
- Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
- Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
- Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
- Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
- Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe de sus jefe.
- Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
- Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.

### Consultas multitabla (inner join)

- Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
- Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.
- Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido.
- Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
- Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.
- Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto con los datos de la oficina donde trabajan.
- Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.
- Devuelve un listado de los productos que nunca han aparecido en un pedido.
- Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar el nombre, la descripción y la imagen del producto.
- Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales.
- Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago.
- Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe asociado.

### Consultas resumen (count,avg,...)

- ¿Cuántos empleados hay en la compañía?
- ¿Cuántos clientes tiene cada país?
- ¿Cuál fue el pago medio en 2009?
- ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.
- Calcula el precio de venta del producto más caro y más barato en una misma consulta.
- Calcula el número de clientes que tiene la empresa.
- ¿Cuántos clientes existen con domicilio en la ciudad de Madrid?
- ¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por M?
- Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende cada uno.
- Calcula el número de clientes que no tiene asignado representante de ventas.
- Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado deberá mostrar el nombre y los apellidos de cada cliente.
- Calcula el número de productos diferentes que hay en cada uno de los pedidos.
- Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de los pedidos.
- Devuelve un listado de los 20 productos más vendidos y el número total de unidades que se han vendido de cada uno. El listado deberá estar ordenado por el número total de unidades vendidas.
- La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el IGIC y el total facturado. La base imponible se calcula sumando el coste del producto por el número de unidades vendidas de la tabla detalle_pedido. El IGIC es el 7 % de la base imponible, y el total la suma de los dos campos anteriores.
- La misma información que en la pregunta anterior, pero agrupada por código de producto.
- La misma información que en la pregunta anterior, pero agrupada por código de producto filtrada por los códigos que empiecen por OR.
- Lista las ventas totales de los productos que hayan facturado más de __3000 euros__. Se mostrará el nombre, unidades vendidas, total facturado y total facturado con impuestos (7% IGIC).
- Muestre la suma total de todos los pagos que se realizaron para cada uno de los años que aparecen en la tabla pagos.

### Subconsultas en SQL

- Devuelve el nombre del cliente con mayor límite de crédito.
- Devuelve el nombre del producto que tenga el precio de venta más caro.
- Devuelve el nombre del producto del que se han vendido más unidades. (Tenga en cuenta que tendrá que calcular cuál es el número total de unidades que se han vendido de cada producto a partir de los datos de la tabla detalle_pedido)
- Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado. (Sin utilizar INNER JOIN).
- Devuelve el producto que más unidades tiene en stock.
- Devuelve el producto que menos unidades tiene en stock.
- Devuelve el nombre, los apellidos y el email de los empleados que están a cargo de Alberto Soria.
- Devuelve el nombre del cliente con mayor límite de crédito.
- Devuelve el nombre del producto que tenga el precio de venta más caro.
- Devuelve el producto que menos unidades tiene en stock.
- Devuelve el nombre, apellido1 y cargo de los empleados que no representen a ningún cliente.
- Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
- Devuelve un listado que muestre solamente los clientes que sí han realizado algún pago.
- Devuelve un listado de los productos que nunca han aparecido en un pedido.
- Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que no sean representante de ventas de ningún cliente.
- Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales.
- Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago.
- Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
- Devuelve un listado que muestre solamente los clientes que sí han realizado algún pago.
- Devuelve un listado de los productos que nunca han aparecido en un pedido.
- Devuelve un listado de los productos que han aparecido en un pedido alguna vez.

### Consultas variadas en SQL

- Devuelve el listado de clientes indicando el nombre del cliente y cuántos pedidos ha realizado. Tenga en cuenta que pueden existir clientes que no han realizado ningún pedido.
- Devuelve un listado con los nombres de los clientes y el total pagado por cada uno de ellos. Tenga en cuenta que pueden existir clientes que no han realizado ningún pago.
- Devuelve el nombre de los clientes que hayan hecho pedidos en 2008 ordenados alfabéticamente de menor a mayor.
- Devuelve el nombre del cliente, el nombre y primer apellido de su representante de ventas y el número de teléfono de la oficina del representante de ventas, de aquellos clientes que no hayan realizado ningún pago.
- Devuelve el listado de clientes donde aparezca el nombre del cliente, el nombre y primer apellido de su representante de ventas y la ciudad donde está su oficina.
- Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que no sean representante de ventas de ningún cliente.
- Devuelve un listado indicando todas las ciudades donde hay oficinas y el número de empleados que tiene.

</div>