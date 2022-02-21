<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>

  1. Teniendo en cuenta el siguiente __XML__. Escriba las expresiones _XQuery_ que devuelvan la respuesta deseada.

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
    for $nombre in /ies/nombre
    return $nombre
    ```

  - Mostrar la página web del instituto sin etiquetas.

    ```
    for $web in /ies/web
    return $web
    ```

  - Mostrar el nombre de los ciclos formativos sin etiquetas.

    ```
    for $ciclos in /ies/ciclos/ciclo/nombre
    return $ciclos
    ```

  - Mostrar las siglas por las que se conocen los ciclos formativos.

    ```
    for $siglas in /ies/ciclos/ciclo/@id
    return $siglas
    ```

  - Mostrar los años en los que se publicaron los decretos de los ciclos formativos.

    ```
    for $decretos in /ies/ciclos/ciclo/decretoTitulo/@año
    return $decretos
    ```

  - Mostrar toda la información de los ciclos formativos de grado medio.

    ```
    for $ciclos in /ies/ciclos/ciclo
    where $ciclos/grado = "Medio"
    return $ciclos
    ```

  - Mostrar los nombres de los ciclos formativos de grado superior.

    ```
    for $ciclos in /ies/ciclos/ciclo
    where $ciclos/grado = "Superior"
    return $ciclos/nombre
    ```

  - Mostrar los nombres de los ciclos formativos anteriores a 2020 sin etiquetas.

    ```
    for $ciclos in /ies/ciclos/ciclo
    where $ciclos/decretoTitulo/@año < "2020"
    return $ciclos/nombre
    ```

  - Mostrar los nombres de los ciclos formativos de 2008 o de 2010.

    ```
    for $ciclos in /ies/ciclos/ciclo
    where $ciclos/decretoTitulo/@año = "2008" or $ciclos/decretoTitulo/@año = "2010"
    return $ciclos/nombre
    ```

2. Teniendo en cuenta el siguiente __XML__. Escriba las expresiones _XQuery_ que devuelvan la respuesta deseada.

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
   for $modulos in /ies/modulos/modulo/nombre
   return $modulos
   ```

 - Mostrar el nombre de los módulos que se imparten en ciclo formativo ASIR.

   ```
   for $modulos in /ies/modulos/modulo
    where $modulos/ciclo = "ASIR"
    return $modulos/nombre
   ```

 - Mostrar el nombre de los módulos que se imparten en segundo curso de cualquier ciclo formativo.

   ```
   for $modulos in /ies/modulos/modulo
    where $modulos/curso = "2"
    return $modulos/nombre
   ```

 - Mostrar el nombre de los módulos que tengan menos de 5 horas semanales.

   ```
   for $modulos in /ies/modulos/modulo
    where $modulos/horasSemanales < "5"
    return $modulos/nombre
   ```

 - Mostrar el nombre de los módulos que se imparten en el primer curso del ciclo formativo ASIR.

   ```
   for $modulos in /ies/modulos/modulo
    where $modulos/curso = "1" and
    $modulos/ciclo = "ASIR"
    return $modulos/nombre
   ```

 - Mostrar las horas semanales sin etiquetas de los módulos que se imparten en más de 3 horas semanales.

   ```
   for $modulos in /ies/modulos/modulo
    where $modulos/horasSemanales > "3"
    return $modulos/horasSemanales
   ```

3. Teniendo en cuenta el siguiente __XML__. Escriba las expresiones _XQuery_ que devuelvan la respuesta deseada.

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
    for $modulos in /ies/modulos/modulo
    where $modulos/ciclo = "SMR"
    return $modulos/nombre
    ```

  - Mostrar los nombres de los ciclos formativos que incluyen el módulo "Lenguajes de marcas y sistemas de gestión de información".

    ```
    for $ciclos in /ies/ciclos/ciclo
    let $modulos := (/ies/modulos/modulo[nombre = "Lenguajes de marcas y sistemas de gestion de informacion"]/ciclo)
    where $ciclos/@id = $modulos
    return $ciclos/nombre
    ```

  - Mostrar los nombres de los módulos de ciclos de Grado Superior.

    ```
    for $modulos in /ies/modulos/modulo
    let $ciclo := (/ies/ciclos/ciclo[grado = "Superior"]/@id)
    where $modulos/ciclo = $ciclo
    return $modulos/nombre
    ```

  - Mostrar los nombres de los módulos de los ciclos formativos cuyo título se aprobó en 2020.

    ```
    for $modulos in /ies/modulos/modulo
    let $ciclo := (/ies/ciclos/ciclo[decretoTitulo/@año = "2020"]/@id)
    where $modulos/ciclo = $ciclo
    return $modulos/nombre
    ```

  - Mostrar los grados de los ciclos formativos con módulos de primer curso.

    ```
    or $ciclos in /ies/ciclos/ciclo
    let $modulos := (/ies/modulos/modulo[curso = "1"]/ciclo)
    where $ciclos/@id = $modulos
    return $ciclos/grado
    ```

## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
