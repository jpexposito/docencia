<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>

1. Dada la solución propuesta para almacenar la información sobre los parques nacionales, determinar la expresión XPath que devuelve:

```xml
<?xml version="1.0" encoding="utf-8" standalone="no"?>
<!DOCTYPE parques
  SYSTEM '09parques.dtd'>
<parques>
    <especies>
        <vegetal id="f1">
            <comun>Junco rarísimo</comun>
            <cientifico>Juncus rarisimus</cientifico>
            <extincion>bajo</extincion>
        </vegetal>
        <animal id="a1">
            <comun>Lince ibérico</comun>
            <cientifico>Lynx pardinus</cientifico>
            <extincion>alto</extincion>
        </animal>
    </especies>
    <parque nombre="Doñana">
        <provincia>Huelva</provincia>
        <ca>Andalucía</ca>
        <extension unidades="Ha">10000</extension>
        <presupuesto>1000000</presupuesto>
        <flora id="f1"/>
        <fauna ejemplares="40" id="a1"/>
    </parque>
</parques>  
```

- El número de especies vegetales.

  ```xml
  count(/parques/especies/vegetal)
  ```
- Las especies vegetales con un peligro alto de extinción.

  ```xml
  parques/especies/vegetal[extincion="alto"]
  ```
- El número de especies animales en peligro bajo de extinción.

  ```xml
  count(/parques/especies/animal[extincion="bajo"])
  ```

- El número de especies en peligro
alto de extinción.

  ```xml
  count(/parques/especies/*[extincion="bajo"])
  ```

- El nombre común de las especies vegetales en peligro alto de extinción

  ```xml
  /parques/especies/vegetal[extincion="alto"]/comun
  ```

- El peligro de extinción del animal de nombre común "Lince ibérico"

  ```xml
  /parques/especies/animal[comun="Lince ibérico"]/extincion
  ```

- El número de parques nacionales.

  ```xml
  count(/parques/parque)
  ```

- El número de parques en Canarias.

  ```xml
  count(/parques/parque[ca="Canarias"]) 
  ```

Los parques de la provincia de Huelva.

  ```xml
  count(/parques/parque[provincia="Huelva"])
  ```

- Los parques con una extensión mayor de 30.000 hectáreas.

  ```xml
  parques/parque[extension>30000]
  ```

- El total de presupuestos.

  ```xml
  sum(/parques/parque/presupuesto)
  ```

- El total de ejemplares en los parques de identificador "a1".

  ```xml
  sum(/parques/parque/fauna[@id="a1"]/@ejemplares)
  ```

- El número de especies de interés en Doñana.

  ```xml
  count(/parques/parque[@nombre="Doñana"]/flora ||
  /parques/parque[@nombre="Doñana"]/fauna)
  ```

- El número de ejemplares animales de interés en Doñana.

  ```xml
  sum(/parques/parque[@nombre="Doñana"]/fauna/@ejemplar)
  ```

- El parque de Timanfaya.

  ```xml
  /parques/parque[@nombre="Timanfaya"]
  ```

- Los especies animales de interés de Garajonay.

  ```xml
  /parques/parque[@nombre="Garajonay"]/fauna
  ```

- Las comunidades autónomas con parques nacionales.

  ```xml
  /parques/parque/ca
  ```

- Las provincias con parques nacionales.

  ```xml
  /parques/parque/provincia
  ```

- Los parques nacionales con menos de veinte especies de interés

  ```xml
  /parques/parque/provincia
  ```

- El número de parque nacionales que sólo tiene como especies de interés animales.

  ```xml
    /parques/parque[fauna][count(flora)=0]
  ```

2. Dada la solución propuesta para almacenar la información sobre los habitantes de un municipio, determinar la expresión XPath que devuelve:

```xml
<?xml version="1.0" encoding="utf-8" standalone="no" ?>
<!DOCTYPE poblacion
  SYSTEM '10ayuntamiento.dtd'>
<poblacion>
    <habitante id="h01" sexo="hombre">
        <nombre>Perico</nombre>
        <apellidos>de los Palotes</apellidos>
        <direccion>c/ Callo, 5</direccion>
        <tlfo>953123456</tlfo>
        <nacimiento>Úbeda</nacimiento>
    </habitante>
    <habitante id="h02" sexo="mujer">
        <nombre>María</nombre>
        <apellidos>Lagartona</apellidos>
        <direccion>c/ Callo, 5</direccion>
        <tlfo>953123456</tlfo>
        <nacimiento>Marmolejo</nacimiento>
    </habitante>
    <habitante id="h03" madre="h02" padre="h01" sexo="hombre">
        <nombre>Felipe</nombre>
        <apellidos>el Hermoso</apellidos>
        <direccion>c/ Callo, 5</direccion>
        <tlfo>953123456</tlfo>
        <nacimiento>Cazorla</nacimiento>
    </habitante>
</poblacion>
```

- El número de habitantes del municipio.

  ```xml
  count(/poblacion/habitante)
  ```

- Los varones del municipio.

  ```xml
  /poblacion/habitante[@sexo="hombre"]
  ```

- Las mujeres del municipio.

  ```xml
  /poblacion/habitante[@sexo="mujer"]
  ```

- El número de habitantes de los que se tiene registrado el padre.

  ```xml
  /poblacion/habitante[@padre]
  ```

- El número de habitantes de los que se tienen registrados padre y madre.

  ```xml
  /poblacion/habitante[@padre][@madre]
  ```

- Los habitantes que se llaman Perico.

  ```xml
  /poblacion/habitante[nombre="Perico"]
  ```

- El listado de identificadores de personas que son padre.

  ```xml
  /poblacion/habitante/@padre
  ```

- El listado de identificadores de personas que son madre.

  ```xml
  /poblacion/habitante/@madre
  ```

- Los habitantes de padre conocido que han nacido en Cazorla.

  ```xml
  poblacion/habitante[@padre][nacimiento="Cazorla"]
  ```

- Los datos de los habitantes cuyo padre tienen identificador "h01".

  ```xml
  /poblacion/habitante[@padre="h01"]
  ```


## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
