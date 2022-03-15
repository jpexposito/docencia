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

  ```

- Las especies vegetales con un peligro alto de extinción.

  ```xml

  ```

- El número de especies animales en peligro bajo de extinción.

  ```xml

  ```

- El número de especies en peligro alto de extinción.

  ```xml

  ```

- El nombre común de las especies vegetales en peligro alto de extinción

  ```xml

  ```

- El peligro de extinción del animal de nombre común "Lince ibérico"

  ```xml

  ```

- El número de parques nacionales.

  ```xml

  ```

- El número de parques en Canarias.

  ```xml

  ```

- Los parques de la provincia de Huelva.

  ```xml

  ```

- Los parques con una extensión mayor de 30.000 hectáreas.

  ```xml

  ```

- El total de presupuestos.

  ```xml

  ```

- El total de ejemplares en los parques de identificador "a1".

  ```xml

  ```

- El número de especies de interés en Doñana.

  ```xml

  ```

- El número de ejemplares animales de interés en Doñana.

  ```xml

  ```

- El parque de Timanfaya.

  ```xml

  ```

- Los especies animales de interés de Garajonay.

  ```xml

  ```

- Las comunidades autónomas con parques nacionales.

  ```xml

  ```

- Las provincias con parques nacionales.

  ```xml

  ```

- Los parques nacionales con menos de veinte especies de interés

  ```xml

  ```

- El número de parque nacionales que sólo tiene como especies de interés animales.

  ```xml

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

  ```

- Los varones del municipio.

  ```xml

  ```

- Las mujeres del municipio.

  ```xml

  ```

- El número de habitantes de los que se tiene registrado el padre.

  ```xml

  ```

- El número de habitantes de los que se tienen registrados padre y madre.

  ```xml

  ```

- Los habitantes que se llaman Perico.

  ```xml

  ```

- El listado de identificadores de personas que son padre.

  ```xml

  ```

- El listado de identificadores de personas que son madre.

  ```xml

  ```

- Los habitantes de padre conocido que han nacido en Cazorla.

  ```xml

  ```

- Los datos de los habitantes cuyo padre tienen identificador "h01".

  ```xml

  ```


## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
