<div align="justify">

<div align="center">
<img src="https://img2.rtve.es/i/?w=1600&i=1618740837832.jpg" width="200px"/>
</div>

El tipo de dato especifica el tipo de información que puede guardar un campo: caracteres, números, etc.

Estos son algunos tipos de datos básicos de SQLite:
- __text__: se usa para almacenar cadenas de caracteres. Una cadena es una secuencia de caracteres. Se coloca entre comillas (simples); ejemplo: 'Hola', 'Juan Perez'. El tipo "text" define una cadena de longitud variable.
 - __integer__: se usa para guardar valores numéricos enteros. Definimos campos de este tipo cuando queremos representar, por ejemplo, cantidades.
- __real__: se usa para almacenar valores numéricos con decimales. Se utiliza como separador el punto (.). Definimos campos de este tipo para precios, por ejemplo.
- __blob__: se usa para almacenar valores en formato binario (imágenes, archivos de sonido etc.)

Antes de crear una tabla debemos pensar en sus campos y optar por el tipo de dato adecuado para cada uno de ellos.
_Por ejemplo, si en un campo almacenaremos números enteros, el tipo "real" sería una mala elección; si vamos a guardar precios, el tipo "real" es más adecuado, no así "integer" que no tiene decimales._

```sql
 create table libro(
	titulo text,
	autor text,
	editorial text,
	precio real,
	cantidad integer
 );
```

</div>