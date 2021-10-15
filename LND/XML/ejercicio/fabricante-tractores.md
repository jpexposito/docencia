<div align="justify">

# FABRICA DE TRACTORES


<div align="center">
  <img width="300px" src="https://t2.ev.ltmcdn.com/es/posts/7/2/7/img_funcionamiento_de_los_tractores_727_600.jpg">
</div>

## Descripción del Ejercicio

  Un fabricante de tractores desea unificar el formato XML de sus proveedores y para ello ha indicado que necesita que los archivos XML cumplan las siguientes restricciones:
  - Un pedido consta de uno o más tractores.
  - Un tractor consta de uno o más componentes.
  - Un componente tiene los siguientes elementos:
    - nombre del fabricante (atributo obligatorio).
    - fecha de entrega (si es posible, aunque puede que no aparezca, si aparece el dia es optativo, pero el mes y el año son obligatorios).
    - También se necesita saber del componente si es frágil o no.
    - También debe aparecer un elemento peso del componente y dicho elemento peso tiene un atributo unidad del peso (kilos o gramos).
    - un elemento número de serie y puede que aparezca o no un elemento kmmaximos indicando que el componente debe sustituirse tras un cierto número de kilómetros.


  Un posible fichero de ejemplo que podría validar sería este:
```xml
<pedido>
    <tractor>
        <componente nombrefabricante="Ebro">
            <fechaentrega>
                <mes>12</mes> <anio>2021</anio>
            </fechaentrega>
            <fragil/>
            <peso unidad="kg">12</peso>
            <numserie>00A</numserie>
        </componente>
        <componente nombrefabricante="Avia">
            <fechaentrega>
                <dia>12</dia><mes>1</mes><anio>2022</anio>
            </fechaentrega>
            <nofragil/>
            <peso unidad="g">1450</peso>
            <numserie>00D</numserie>
            <kmmaximos>25000</kmmaximos>
        </componente>
    </tractor>
    <tractor>
        <componente nombrefabricante="John Deere">
            <fragil/>
            <peso unidad="g">770</peso>
            <numserie>43Z</numserie>
        </componente>
    </tractor>
</pedido>
```
Se pide realizar el fichero __dtd__, que valide este fichero o el que el alumno proponga siempre y cuando se cumpla las restricciones indicadas en la descripción.

## Entrega

  - Recuerda que debes de crear el informe en __pdf__ (con tu interpretación),junto con el __dtd__ , generando un zip y subirlo a la plataforma.
  La __no entrega en plazo supone la no corrección del ejercicio con la correspondiente nota (0)__

<div align="center">

  __A TRABAJAR__

  <img width="600px" src="https://www.legaltoday.com/wp-content/uploads/2020/10/teletrabajo4-1024x576.jpg">
</div>
