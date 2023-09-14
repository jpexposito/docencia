<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>

1. Repaso de expresiones simples

Dado el siguiente documento XML, escriba las expresiones XPath que devuelvan la respuesta deseada (mostrada en los cuadros).

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ies>
  <nombre>IES Puerto la Cruz</nombre>
  <web>http://www.iespuertolacruz.org</web>
  <ciclos>
    <ciclo id="ASIR">
      <nombre>Administración de Sistemas Informáticos en Red</nombre>
      <grado>Superior</grado>
      <decretoTitulo año="2009" />
    </ciclo>
    <ciclo id="DAW">
      <nombre>Desarrollo de Aplicaciones Web</nombre>
      <grado>Superior</grado>
      <decretoTitulo año="2010" />
    </ciclo>
    <ciclo id="SMR">
      <nombre>Sistemas Microinformáticos y Redes</nombre>
      <grado>Medio</grado>
      <decretoTitulo año="2008" />
    </ciclo>
  </ciclos>
</ies>
```

- Obtén el valor de xpad. Nombre del Instituto:

```
<nombre>IES Abastos</nombre>
```

Obtén el valor de xpad .Página web del Instituto:

```
http://www.iesabastos.org
```

Obtén el valor de xpad. Nombre de los Ciclos Formativos:

```
Administración de Sistemas Informáticos en Red
Desarrollo de Aplicaciones Web
Sistemas Microinformáticos y Redes
```

Obtén el valor de xpad. Siglas por las que se conocen los Ciclos Formativos:

```
 id="ASIR"
 id="DAW"
 id="SMR"
```

Obtén el valor de xpad. Años en los que se publicaron los decretos de título de los Ciclos Formativos:

```
 año="2009"
 año="2010"
 año="2008"
```

Obtén el valor de xpad. Ciclos Formativos de Grado Medio (se trata de obtener el elemento <ciclo> completo):
```
<ciclo id="SMR">
  <nombre>Sistemas Microinformáticos y Redes</nombre>
  <grado>Medio</grado>
  <decretoTitulo año="2008"/>
</ciclo>
```

Obtén el valor de xpad. Nombre de los Ciclos Formativos de Grado Superior:

```
<nombre>Administración de Sistemas Informáticos en Red</nombre>
<nombre>Desarrollo de Aplicaciones Web</nombre>
```

Obtén el valor de xpad. Nombre de los Ciclos Formativos anteriores a 2010:

```
Administración de Sistemas Informáticos en Red
Sistemas Microinformáticos y Redes
```

Obtén el valor de xpad. Nombre de los Ciclos Formativos de 2008 o 2010:

```
Desarrollo de Aplicaciones Web
Sistemas Microinformáticos y Redes
```


2. Expresiones simples

Dado el siguiente documento XML, escriba las expresiones XPath que devuelvan la respuesta deseada (mostrada en los cuadros).

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

- Obtén el valor de xpad. Nombre de los módulos que se imparten en el Instituto:

```
Aplicaciones web
Gestión de bases de datos
Lenguajes de marcas y sistemas de gestión de información
Implantación de aplicaciones web
```

Obtén el valor de xpad. Nombre de los módulos del ciclo ASIR:

```
Gestión de bases de datos
Lenguajes de marcas y sistemas de gestión de información
Implantación de aplicaciones web
```

Obtén el valor de xpad. Nombre de los módulos que se imparten en el segundo curso de cualquier ciclo:

```
Aplicaciones web
Implantación de aplicaciones web
```

Obtén el valor de xpad. Nombre de los módulos de menos de 5 horas semanales:

```
Aplicaciones web
Lenguajes de marcas y sistemas de gestión de información
```

Obtén el valor de xpad. Nombre de los módulos que se imparten en el primer curso de ASIR:

```
Gestión de bases de datos
Lenguajes de marcas y sistemas de gestión de información
```
Obtén el valor de xpad. Horas semanales de los módulos de más de 3 horas semanales:

```
4
5
5
```


3. Expresiones anidadas
Dado el siguiente documento XML, escriba las expresiones XPath que devuelvan la respuesta deseada (mostrada en los cuadros).

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ies>
  <nombre>IES Abastos</nombre>
  <web>http://www.iesabastos.org</web>
  <ciclos>
    <ciclo id="ASIR">
      <nombre>Administración de Sistemas Informáticos en Red</nombre>
      <grado>Superior</grado>
      <decretoTitulo año="2009" />
    </ciclo>
    <ciclo id="DAW">
      <nombre>Desarrollo de Aplicaciones Web</nombre>
      <grado>Superior</grado>
      <decretoTitulo año="2010" />
    </ciclo>
    <ciclo id="SMR">
      <nombre>Sistemas Microinformáticos y Redes</nombre>
      <grado>Medio</grado>
      <decretoTitulo año="2008" />
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

- Obtén el valor de xpad. Nombre de los módulos del ciclo "Sistemas Microinformáticos y Redes" (en la expresión final no deben aparecer las siglas SMR):

```
Aplicaciones web
```
- Obtén el valor de xpad. Nombre de los ciclos que incluyen el módulo "Lenguajes de marcas y sistemas de gestión de información":

```
Administración de Sistemas Informáticos en Red
Desarrollo de Aplicaciones Web
```

- Obtén el valor de xpad. Nombre de los módulos de ciclos de Grado Superior:

```
Gestión de bases de datos
Lenguajes de marcas y sistemas de gestión de información
Implantación de aplicaciones web
```

- Obtén el valor de xpad. Nombre de los módulos de ciclos cuyo título se aprobó en 2008:

```
Aplicaciones web
```
- Obtén el valor de xpad. Grado de los ciclos con módulos de primer curso:

```
Superior
Superior
```


## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.

</div>
