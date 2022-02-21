<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>

1. Dada la solución propuesta para almacenar la información sobre los parques nacionales, determinar la expresión _XQuery_ que devuelve:

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

  ```

  ```

- Las especies vegetales con un peligro alto de extinción.

  ```

  ```

- El número de especies animales en peligro bajo de extinción.

  ```

  ```

- El número de especies en peligro alto de extinción.

  ```

  ```

- El nombre común de las especies vegetales en peligro alto de extinción

  ```

  ```

- El peligro de extinción del animal de nombre común "Lince ibérico"

  ```

  ```

- El número de parques nacionales.

  ```

  ```

- El número de parques en Canarias.

  ```

  ```

- Los parques de la provincia de Huelva.

  ```

  ```

- Los parques con una extensión mayor de 30.000 hectáreas.

  ```

  ```

- El total de presupuestos.

  ```

  ```

- El total de ejemplares en los parques de identificador "a1".

  ```

  ```

- El número de especies de interés en Doñana.

  ```

  ```

- El número de ejemplares animales de interés en Doñana.

  ```

  ```

- El parque de Timanfaya.

  ```

  ```

- Los especies animales de interés de Garajonay.

  ```

  ```

- Las comunidades autónomas con parques nacionales.

  ```

  ```

- Las provincias con parques nacionales.

  ```

  ```

- Los parques nacionales con menos de veinte especies de interés

  ```

  ```

- El número de parque nacionales que sólo tiene como especies de interés animales.

  ```

  ```

2. Dada la solución propuesta para almacenar la información sobre los habitantes de un municipio, determinar la expresión _XQuery_ que devuelve:

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

  ```

  ```

- Los varones del municipio.

  ```

  ```

- Las mujeres del municipio.

  ```

  ```

- El número de habitantes de los que se tiene registrado el padre.

  ```

  ```

- El número de habitantes de los que se tienen registrados padre y madre.

  ```

  ```

- Los habitantes que se llaman Perico.

  ```

  ```

- El listado de identificadores de personas que son padre.

  ```

  ```

- El listado de identificadores de personas que son madre.

  ```

  ```

- Los habitantes de padre conocido que han nacido en Cazorla.

  ```

  ```

- Los datos de los habitantes cuyo padre tienen identificador "h01".

  ```

  ```


## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
