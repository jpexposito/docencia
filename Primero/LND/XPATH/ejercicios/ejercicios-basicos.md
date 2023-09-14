<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>

  1. Teniendo en cuenta el siguiente __XML__. Escriba las expresiones _XPath_ que devuelvan la respuesta deseada.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <ies>
    <nombre>IES Puerto la Cruz</nombre>
    <web>http://www.iespuertolacruz.org</web>
    <ciclos>
      <ciclo id="ASIR">
        <nombre>Administración de Sistemas Informáticos en Red</nombre>
        <grado>Superior</grado>
        <decretoTitulo año="2019" />
      </ciclo>
      <ciclo id="DAW">
        <nombre>Desarrollo de Aplicaciones Web</nombre>
        <grado>Superior</grado>
        <decretoTitulo año="2022" />
      </ciclo>
      <ciclo id="SMR">
        <nombre>Sistemas Microinformáticos y Redes</nombre>
        <grado>Medio</grado>
        <decretoTitulo año="2021" />
      </ciclo>
    </ciclos>
  </ies>
  ```
  </br>

  - Mostrar el nombre del instituto.

  ```
  /ies/nombre
  ```

  - Mostrar la página web del instituto sin etiquetas.

  ```
  /ies/web/text()
  ```

  - Mostrar el nombre de los ciclos formativos sin etiquetas.

    ```
    /ies/ciclos/ciclo/nombre/text()
    ```

  - Mostrar las siglas por las que se conocen los ciclos formativos.

    ```
    /ies/ciclos/ciclo/@id
    ```

  - Mostrar los años en los que se publicaron los decretos de los ciclos formativos.

    ```
    /ies/ciclos/ciclo/decretoTitulo/@año
    ```

  - Mostrar toda la información de los ciclos formativos de grado medio.

    ```
    /ies/ciclos/ciclo[grado="Medio"]
    ```

  - Mostrar los nombres de los ciclos formativos de grado superior.

    ```
    /ies/ciclos/ciclo[grado="Superior"]/nombre
    ```

  - Mostrar los nombres de los ciclos formativos anteriores a 2020 sin etiquetas.

    ```
    /ies/ciclos/ciclo[decretoTitulo/@año<2020]/nombre/text()
    ```

  - Mostrar los nombres de los ciclos formativos de 2008 o de 2010.

    ```
    /ies/ciclos/ciclo[decretoTitulo/@año=2008 or decretoTitulo/@año=2010]/nombre
    ```

2. Teniendo en cuenta el siguiente __XML__. Escriba las expresiones _XPath_ que devuelvan la respuesta deseada.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <ies>
    <modulos>
      <modulo id="0228">
        <nombre>Aplicaciones web</nombre>
        <curso>2</curso>
        <horasSemanales>4</horasSemanales>
        <ciclo>SMR</ciclo>
      </modulo>
      <modulo id="0372">
        <nombre>Gestión de bases de datos</nombre>
        <curso>1</curso>
        <horasSemanales>5</horasSemanales>
        <ciclo>ASIR</ciclo>
      </modulo>
      <modulo id="0373">
        <nombre>Lenguajes de marcas y sistemas de gestión de información</nombre>
        <curso>1</curso>
        <horasSemanales>3</horasSemanales>
        <ciclo>ASIR</ciclo>
        <ciclo>DAW</ciclo>
      </modulo>
      <modulo id="0376">
        <nombre>Implantación de aplicaciones web</nombre>
        <curso>2</curso>
        <horasSemanales>5</horasSemanales>
        <ciclo>ASIR</ciclo>
      </modulo>
    </modulos>
  </ies>
  ```
  </br>

 - Mostrar el nombre sin etiquetas de los módulos que se imparten en el instituto.

   ```
   /ies/modulos/modulo/nombre/text()
   ```

 - Mostrar el nombre de los módulos que se imparten en ciclo formativo ASIR.

   ```
   /ies/modulos/modulo[ciclo="ASIR"]/nombre
   ```

 - Mostrar el nombre de los módulos que se imparten en segundo curso de cualquier ciclo formativo.

   ```
   /ies/modulos/modulo[curso="2"]/nombre
   ```

 - Mostrar el nombre de los módulos que tengan menos de 5 horas semanales.

   ```
   /ies/modulos/modulo[horasSemanales<5]/nombre
   ```

 - Mostrar el nombre de los módulos que se imparten en el primer curso del ciclo formativo ASIR.

   ```
   /ies/modulos/modulo[curso=1 and ciclo="ASIR"]/nombre
   /ies/modulos/modulo[curso=1][ciclo="ASIR"]/nombre
   ```

 - Mostrar las horas semanales sin etiquetas de los módulos que se imparten en más de 3 horas semanales.

   ```
   /ies/modulos/modulo[horasSemanales>3]/horasSemanales/text()
   ```

3. Teniendo en cuenta el siguiente __XML__. Escriba las expresiones _XPath_ que devuelvan la respuesta deseada.

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
<ies>
  <nombre>IES Puerto la Cruz</nombre>
  <web>http://www.iespuertolacruz.org</web>
  <ciclos>
    <ciclo id="ASIR">
      <nombre>Administración de Sistemas Informáticos en Red</nombre>
      <grado>Superior</grado>
      <decretoTitulo año="2019" />
    </ciclo>
    <ciclo id="DAW">
      <nombre>Desarrollo de Aplicaciones Web</nombre>
      <grado>Superior</grado>
      <decretoTitulo año="2020" />
    </ciclo>
    <ciclo id="SMR">
      <nombre>Sistemas Microinformáticos y Redes</nombre>
      <grado>Medio</grado>
      <decretoTitulo año="2022" />
    </ciclo>
  </ciclos>
  <modulos>
    <modulo id="0228">
      <nombre>Aplicaciones web</nombre>
      <curso>2</curso>
      <horasSemanales>4</horasSemanales>
      <ciclo>SMR</ciclo>
    </modulo>
    <modulo id="0372">
      <nombre>Gestión de bases de datos</nombre>
      <curso>1</curso>
      <horasSemanales>5</horasSemanales>
      <ciclo>ASIR</ciclo>
    </modulo>
    <modulo id="0373">
      <nombre>Lenguajes de marcas y sistemas de gestión de información</nombre>
      <curso>1</curso>
      <horasSemanales>3</horasSemanales>
      <ciclo>ASIR</ciclo>
      <ciclo>DAW</ciclo>
    </modulo>
    <modulo id="0376">
      <nombre>Implantación de aplicaciones web</nombre>
      <curso>2</curso>
      <horasSemanales>5</horasSemanales>
      <ciclo>ASIR</ciclo>
    </modulo>
  </modulos>
</ies>
  ```
  </br>

  - Mostrar los nombres de los módulos del ciclo de "Sistemas Microinformáticos y Redes".

    ```
    /ies/ciclos/ciclo[nombre="Sistemas Microinformáticos y Redes"]/@id
    /ies/modulos/modulo[ciclo="SMR"]/nombre/text()
    /ies/modulos/modulo[ciclo=/ies/ciclos/ciclo[nombre="Sistemas Microinformáticos y Redes"]/@id]/nombre
    ```

  - Mostrar los nombres de los ciclos formativos que incluyen el módulo "Lenguajes de marcas y sistemas de gestión de información".

    ```
    /ies/modulos/modulo[nombre="Lenguajes de marcas y sistemas de gestión de información"]/ciclo/text()
    /ies/ciclos/ciclo[@id="ASIR"]/nombre
    /ies/ciclos/ciclo[@id=/ies/modulos/modulo[nombre="Lenguajes de marcas y sistemas de gestión de información"]/ciclo/text()]/nombre
    ```

  - Mostrar los nombres de los módulos de ciclos de Grado Superior.

    ```
    /ies/ciclos/ciclo[grado="Superior"]/@id
    /ies/modulos/modulo[ciclo="ASIR"]/nombre
    /ies/modulos/modulo[ciclo=/ies/ciclos/ciclo[grado="Superior"]/@id]/nombre
    ```

  - Mostrar los nombres de los módulos de los ciclos formativos cuyo título se aprobó en 2020.

    ```
    /ies/ciclos/ciclo[decretoTitulo/@año=2020]/@id
    /ies/modulos/modulo[ciclo="SMR"]/nombre
    /ies/modulos/modulo[ciclo=/ies/ciclos/ciclo[decretoTitulo/@año=2020]/@id]/nombre
    ```

  - Mostrar los grados de los ciclos formativos con módulos de primer curso.

    ```
    /ies/modulos/modulo[curso=1]/ciclo
    /ies/ciclos/ciclo[@id="ASIR"]/grado
    /ies/ciclos/ciclo[@id=/ies/modulos/modulo[curso=1]/ciclo]/grado
    ```

## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
