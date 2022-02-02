<div align="justify">

<div align="center">
  <img src="https://www.aulacat.cat/images/fotoscursos/1530/ingresar-en-el-ejercito-espanol.jpg" />
</div>

## Descripción

El Ministerio de Defensa desea diseñar una Base de Datos para llevar un cierto control de los soldados que realizan el servicio militar. Los datos significativos a tener en cuenta son:
- Un soldado se define por su código de soldado (único), su nombre y apellidos, y su graduación. _Decide cual puede ser el código único_.
- Existen varios cuarteles, cada uno se define por su código de cuartel, nombre y ubicación.
- Hay que tener en cuenta que existen _diferentes cuerpos del Ejército (Infantería, Artillería, Armada, ....)_, y cada uno se define por un _código de Cuerpo y denominación_.
- Los soldados están agrupados en compañías, siendo significativa para cada una de  estas, el número de compañía y la actividad principal que realiza.
  Se desea controlar los servicios que realizan los soldados (guardias, imaginarias, cuarteleros, ...), y se definen por el código de servicio y descripción.
Consideraciones de diseño:
- Un soldado pertenece a un único cuerpo y a una única compañía, durante todo el servicio militar. A una compa  a pueden pertenecer soldados de diferentes cuerpos, no habiendo relación directa entre compañías y cuerpos.
- Los soldados de una misma compañía pueden estar destinados en diferentes cuarteles, es decir, una compañía puede estar ubicada en varios cuarteles, y en un cuartel puede haber varias compañías. Eso si, un soldado sólo esta en un cuartel.
- Un soldado realiza varios servicios a lo largo de la milicia. Un mismo servicio puede ser realizado por más de un soldado (con independencia de la compañía), siendo significativa la fecha de realización.

- [Solución](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=ministerio-defensa-diagrama-clases.drawio#Uhttps%3A%2F%2Fdrive.google.com%2Fuc%3Fid%3D1SKzA5dA6_Q0ut0JOnqErcfHOTWBY8b6X%26export%3Ddownload)

</div>
