<div align="justify">

<div align="center">
<img src="https://luciamonterorodriguez.com/wp-content/uploads/2021/03/computer-1331579_640.png" width="200px"/>
</div>

> __Nota__. Seguiremos trabajando con la tabla __usuario__.


Existe una cláusula, "where" con la cual podemos especificar condiciones para una consulta "select". Es decir, podemos recuperar algunos registros, sólo los que cumplan con ciertas condiciones indicadas con la cláusula "where". Por ejemplo, queremos ver el usuario cuyo nombre es "Marcelo", para ello utilizamos "where" y luego de ella, la condición:

```sql
select NOMBRECAMPO1, ..., NOMBRECAMPOn
  from NOMBRETABLA
  where CONDICION;
```

Para las condiciones se utilizan operadores relacionales (tema que trataremos más adelante en detalle). El signo __igual(=)__ es un __operador relacional__.
Para la siguiente selección de registros especificamos una condición que solicita los usuarios cuya clave es igual a "test":

```sql
select nombre,clave
  from usuario
  where clave='test';
  ```

> __Aclaración__: __No__ debemos de obtener ningún elemento. 

Sin embargo si ejecutamos la siguiente consulta debemos de obtener resultado:

```sql
select nombre,clave
  from usuario
  where clave='predrito';
  ```
 > __Aclaración__: Debemos de obtener al menos un elemento. 

</div>