<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>

Dado el siguiente xml, realizar las expresiones xpath para obtener los resultados que se indican:

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
- Nombre de los módulos que se imparten en el Instituto:
  ```
  Aplicaciones web Gestión de bases de datos Lenguajes de marcas y sistemas de gestión de información Implantación de aplicaciones web
  ```

- Nombre de los módulos del ciclo ASIR:
  ```
  Gestión de bases de datos Lenguajes de marcas y sistemas de gestión de información Implantación de aplicaciones web
  ```
- Nombre de los módulos que se imparten en el segundo curso de cualquier ciclo:
  ```
  Aplicaciones web Implantación de aplicaciones web
  ```  
- Nombre de los módulos de menos de 5 horas semanales:
  ```
  Aplicaciones web Lenguajes de marcas y sistemas de gestión de información
  ```
- Nombre de los módulos que se imparten en el primer curso de ASIR:
  ```
  Gestión de bases de datos Lenguajes de marcas y sistemas de gestión de información
  ```
- Horas semanales de los módulos de más de 3 horas semanales:
  ```
  4 5 5
  ```

- Identificador de los módulos __(id)__ de menos de 3 horas semanales:
  ```
  0373
  ```
- Número de horas que se imparten en el primer curso de cualquiera de sus módulos.    
  ```
  8
  ```

- Número de módulos que se imparten en cualquiera de los cursos de ASIR.    
  ```
  3
  ```

- Identificador del módulo de Aplicaciones web.
  ```
  0228
```
</div>
