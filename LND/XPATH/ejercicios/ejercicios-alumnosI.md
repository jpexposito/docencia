<div align="justify">


<div align="center">
 	<img src="https://upload.wikimedia.org/wikipedia/commons/9/91/XQuery_and_XPath_Data_Model_type_hierarchy.png">
</div>

</br>

1. Dada la siguiente información de alumnos de un centro:

```
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="transformar.xsl"?>
<instituto codigo="38010700" nombre="IES Domingo Pérez Minik">
    <curso codigo="1" nombre="1º ASIR">
        <alumno cial="A18X111">
            <nombre>Javier</nombre>
            <apellidos>Márquez Fernández</apellidos>
            <!-- Javier Márquez NO es un alumno repetidor -->
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Lenguajes de marcas</asignatura>
                <nota>8</nota>
                <asignatura>Redes</asignatura>
                <nota>7</nota>
                <asignatura>Fundamentos de hardware</asignatura>
                <nota>3</nota>
                <asignatura>Sistemas Operativos</asignatura>
                <nota>6</nota>
            </notas>
        </alumno>
        <alumno cial="A27M242">
            <nombre>María</nombre>
            <apellidos>Álvarez Pérez</apellidos>
            <repetidor>True</repetidor>
            <notas>
                <asignatura>Lenguajes de marcas</asignatura>
                <nota>5</nota>
                <asignatura>Redes</asignatura>
                <nota>5</nota>
                <asignatura>Fundamentos de hardware</asignatura>
                <nota>7</nota>
                <asignatura>Sistemas Operativos</asignatura>
                <nota>6</nota>
            </notas>
        </alumno>
        <alumno cial="A90R112">
            <nombre>Iván</nombre>
            <apellidos>Rodríguez Pérez</apellidos>
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Lenguajes de marcas</asignatura>
                <nota>4</nota>
                <asignatura>Redes</asignatura>
                <nota>9</nota>
                <asignatura>Fundamentos de hardware</asignatura>
                <nota>9</nota>
                <asignatura>Sistemas Operativos</asignatura>
                <nota>3</nota>
            </notas>
        </alumno>
    </curso>
    <curso codigo="2" nombre="2º ASIR">
        <alumno cial="A92T861">
            <nombre>Marcos</nombre>
            <apellidos>Domínguez</apellidos>
            <repetidor>True</repetidor>
            <notas>
                <asignatura>Seguridad Informática</asignatura>
                <nota>5</nota>
                <asignatura>Planificación de redes</asignatura>
                <nota>8</nota>
                <asignatura>Servicios web</asignatura>
                <nota>7</nota>
                <asignatura>Prácticas de empresa</asignatura>
                <nota>APTO</nota>
            </notas>
        </alumno>
        <alumno cial="A92R003">
            <nombre>Luis Fernando</nombre>
            <apellidos>Jiménez Pérez</apellidos>
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Seguridad Informática</asignatura>
                <nota>3</nota>
                <asignatura>Planificación de redes</asignatura>
                <nota>4</nota>
                <asignatura>Servicios web</asignatura>
                <nota>4</nota>
                <asignatura>Prácticas de empresa</asignatura>
                <nota>No APTO</nota>
            </notas>
        </alumno>
        <alumno cial="A87R122">
            <nombre>Elena</nombre>
            <apellidos>Ramírez</apellidos>
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Seguridad Informática</asignatura>
                <nota>6</nota>
                <asignatura>Planificación de redes</asignatura>
                <nota>10</nota>
                <asignatura>Servicios web</asignatura>
                <nota>8</nota>
                <asignatura>Prácticas de empresa</asignatura>
                <nota>APTO</nota>
            </notas>
        </alumno>
    </curso>
    <curso codigo="3" nombre="1º DAI">
        <alumno cial="A95M600">
            <nombre>Irina</nombre>
            <apellidos>Lugo Lugo</apellidos>
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Programación</asignatura>
                <nota>8</nota>
                <asignatura>Análisis</asignatura>
                <nota>7</nota>
                <asignatura>Medios</asignatura>
                <nota>3</nota>
                <asignatura>Multimedia</asignatura>
                <nota>6</nota>
            </notas>
        </alumno>
        <alumno cial="A92R543">
            <nombre>Genaro</nombre>
            <apellidos>Hernández Hernández</apellidos>
            <repetidor>True</repetidor>
            <notas>
                <asignatura>Programación</asignatura>
                <nota>5</nota>
                <asignatura>Análisis</asignatura>
                <nota>5</nota>
                <asignatura>Medios</asignatura>
                <nota>7</nota>
                <asignatura>Multimedia</asignatura>
                <nota>6</nota>
            </notas>
        </alumno>
        <alumno cial="A92R590">
            <nombre>Miguel</nombre>
            <apellidos>Rodríguez</apellidos>
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Programación</asignatura>
                <nota>4</nota>
                <asignatura>Multimedia</asignatura>
                <nota>3</nota>
            </notas>
        </alumno>
    </curso>
</instituto>  
```

- Obtén el listado de alumnos del instituto.

```xml
  /instituto/curso/alumno

  ó si quiero sólo el nombre

  /instituto/curso/alumno/nombre
```

- Obtén el primer alumno que esta en el segundo curso.

```
/instituto/curso[@codigo=2]/alumno[1]
```

- Obtén el nombre y apellidos de todos los alumnos de 1º de ASIR.

```
/instituto/curso[@nombre="1º ASIR"]/alumno/nombre | /instituto/curso[@nombre="1º ASIR"]/alumno/apellidos
```

- Obtén el nombre de todos los alumnos que comiencen por __M__.

```
/instituto/curso/alumno[starts-with(nombre, "M")]/nombre
```

- Obtén todos los alumnos (Nombre) de 1º de Asir que hayan suspendido,(__<5__), Lenguajes de marcas.

```
/instituto/curso[@codigo=1]/alumno[notas/nota[1]<5]/nombre/text()
```

- Obtén todos los alumnos (Nombre) de 2º de Asir que hayan aprobado, (__>=5__), Seguridad Informática.

```
/instituto/curso[@codigo=2]/alumno[notas/nota[1]>=5]/nombre/text()
```

- Obtén todos los alumnos (Cial) de 1º DAI que hayan aprobado, (__>=5__), Programación.

```
/instituto/curso[@codigo=3]/alumno[notas/nota[1]>=5]/@cial
```

- Obtén las notas de la alumna __Irina Lugo Lugo__.

```
/instituto/curso/alumno[nombre="Irina" and apellidos="Lugo Lugo"]/notas/nota/text()
```

- Obtén todos los ciales de los alumnos.

```
/instituto/curso/alumno/@cial
```

- Obtén todas las notas del alumno con cial __A95M600__.

```
/instituto/curso/alumno[@cial="A95M600"]/notas/nota/text()
```

- Obtén todos los apellidos de todos los alumnos.

```
/instituto/curso/alumno/apellidos/text()
```

- Obtén todos todos los ciales de los alumnos de 2 de ASIR.

```
/instituto/curso[@nombre="2º ASIR"]/alumno/@cial
```

- Obtén todos toda la información de texto del alumno con cial A95M600.

```
/instituto/curso/alumno[@cial="A95M600"]//text()
```

- Obtén el nombre del curso donde esté el alumno con cial A95M600.

```
/instituto/curso[alumno/@cial="A95M600"]/@nombre
```

- Obtén el nombre de aquellos alumnos que son repetidores.

```
/instituto/curso/alumno[repetidor="True"]/nombre/text()
```

- Obtén el nombre de todos los alumnos de 1º de ASIR que tengan atributo cial (da igual el valor del cial).

```
/instituto/curso[@nombre="1º ASIR"]/alumno[@cial]/nombre/text()
```

- Obtén todos los nombres de los alumnos salvo del que tiene cial=A18X111.

```
/instituto/curso/alumno[@cial!="A18X111"]/nombre/text()
```

- Obtén los nombres de los alumnos del fichero, salvo aquellos que sean de último de curso.

```
/instituto/curso[not(starts-with(@nombre, "2"))]/alumno/nombre/text()
```

- Obtén el nombre del penúltimo alumno de 1º de DAI.

```
/instituto/curso[@nombre="1º DAI"]/alumno[last()-1]/nombre/text()
```

- Obtén todos los nombres de aquellos alumnos cuya suma de notas sea mayor que 23.

```
/instituto/curso/alumno[sum(notas/nota)>23]/nombre/text()
```

- Obtén todos los alumnos cuyo nombre comience por M y que sean repetidores.

```
/instituto/curso/alumno[starts-with(nombre, "M") and repetidor="True"]/nombre/text()
```

- Obtén toda la información de los alumnos que tengan Pérez como alguno de sus apellidos.

```
/instituto/curso/alumno[contains(apellidos, "Pérez")]
```

- Obtén todos los alumnos que tienen menos de 4 materias.

```
/instituto/curso/alumno[sum(asignaturas)<4]/nombre/text()
```



2. Dada la solución propuesta para almacenar la información sobre __noticias__, determinar la expresión XPath que devuelve:

```
<Category name="News">
    <Feed name="MSN Reporter" downloadDate="04/04/2011 23:58:44">
        <item>
            <title>Vuelo 447 Rio-Paris, imágenes de los restos del Airbus en el fondo del mar</title>
            <link>http://reporter.es.msn.com/articles/noticias/244374?ocid=MSNToolbar100</link>
            <description>Hallan cadáveres entre los restos del Airbus de Air France que desapareció en 2009
Partes del motor y las alas de la aeronave se encuentran en el Océano Atlántico</description>
            <author>chupidos</author>
            <comments></comments>
            <pubDate>Mon, 04 Apr 2011 22:36:00 GMT</pubDate>
            <imageLocation />
            <imageAttribution></imageAttribution>
        </item>
        <item>
            <title>Gestiona todo tu correo a través de Hotmail - Artículo - Canal Windows Live - MSN</title>
            <link>http://reporter.es.msn.com/articles/entretenimiento/244373?ocid=MSNToolbar100</link>
            <description></description>
            <author>yuly</author>
            <comments></comments>
            <pubDate>Mon, 04 Apr 2011 21:40:00 GMT</pubDate>
            <imageLocation />
            <imageAttribution></imageAttribution>
        </item>
        <item>
            <title>El vanguardismo llega a los nuevos museos - Listas - MSN Viajes</title>
            <link>http://reporter.es.msn.com/articles/motor/244372?ocid=MSNToolbar100</link>
            <description></description>
            <author>HOY</author>
            <comments></comments>
            <pubDate>Mon, 04 Apr 2011 21:00:00 GMT</pubDate>
            <imageLocation />
            <imageAttribution></imageAttribution>
        </item>
        <item>
            <title>La inyección de una espuma plástica no frena el escape de agua radiactiva de Fukushima-1 - MSN Noticias</title>
            <link>http://reporter.es.msn.com/articles/noticias/244371?ocid=MSNToolbar100</link>
            <description>Japón pide ayuda al exterior al verse desbordada.ONU</description>
            <author>PAsturias</author>
            <comments></comments>
            <pubDate>Mon, 04 Apr 2011 19:03:00 GMT</pubDate>
            <imageLocation />
            <imageAttribution></imageAttribution>
        </item>
        <item>
            <title>LAS MIL CARAS DE BELEN ESTEBAN ..NO TE PIERDAS ESTE POST ¿ CUANDO APRENDIO A GESTICULAR ASI?</title>
            <link>http://reporter.es.msn.com/articles/entretenimiento/244370?ocid=MSNToolbar100</link>
            <description></description>
            <author>DUNALUNA</author>
            <comments></comments>
            <pubDate>Mon, 04 Apr 2011 14:46:00 GMT</pubDate>
            <imageLocation />
            <imageAttribution></imageAttribution>
        </item>
        <item>
            <title>PASOS A SEGUIR PARA UNA ALIMENTACION SANA Y ERRORES QUE SOLEMOS COMETER AL HACER DIETA </title>
            <link>http://reporter.es.msn.com/articles/Salud/244369?ocid=MSNToolbar100</link>
            <description></description>
            <author>DUNALUNA</author>
            <comments></comments>
            <pubDate>Mon, 04 Apr 2011 14:44:00 GMT</pubDate>
            <imageLocation />
            <imageAttribution></imageAttribution>
        </item>
        <item>
            <title>EL NIÑO THAILANDÉS Y LA SERPIENTE GIGANTE. UNA FASCINANTE AMISTAD. VÍDEO E IMÁGENES</title>
            <link>http://reporter.es.msn.com/articles/entretenimiento/244368?ocid=MSNToolbar100</link>
            <description></description>
            <author>DUNALUNA</author>
            <comments></comments>
            <pubDate>Mon, 04 Apr 2011 14:44:00 GMT</pubDate>
            <imageLocation />
            <imageAttribution></imageAttribution>
        </item>
        <item>
            <title>Satélite de la NASA medirá la salinidad de la superficie de los océanos</title>
            <link>http://reporter.es.msn.com/articles/noticias/244367?ocid=MSNToolbar100</link>
            <description>La nave Aquarius/SAC-D hará el mapa mundial de los océanos una vez cada siete días
Pequeños cambios en la salinidad pueden tener efectos a gran escala en la circulación oceánica y la forma en que el océano modera el clima</description>
            <author>chupidos</author>
            <comments></comments>
            <pubDate>Mon, 04 Apr 2011 14:41:00 GMT</pubDate>
            <imageLocation />
            <imageAttribution></imageAttribution>
        </item>
        <item>
            <title>PASOS A SEGUIR PARA UNA ALIMENTACION SANA Y ERRORES QUE SOLEMOS COMETER AL HACER DIETA</title>
            <link>http://reporter.es.msn.com/articles/Salud/244366?ocid=MSNToolbar100</link>
            <description></description>
            <author>DUNALUNA</author>
            <comments></comments>
            <pubDate>Mon, 04 Apr 2011 14:39:00 GMT</pubDate>
            <imageLocation />
            <imageAttribution></imageAttribution>
        </item>
        <item>
            <title>Cuando Me Enamoro Juan Luis Guerra y Enrique Igleseias ...preciosa cancion</title>
            <link>http://reporter.es.msn.com/articles/Video/244365?ocid=MSNToolbar100</link>
            <description></description>
            <author>DUNALUNA</author>
            <comments></comments>
            <pubDate>Mon, 04 Apr 2011 14:37:00 GMT</pubDate>
            <imageLocation />
            <imageAttribution></imageAttribution>
        </item>
    </Feed>
</Category>
```

- Obtén todos los títulos de las noticias publicadas por el autor "chupidos".

```
/Category/Feed/item[author="chupidos"]/title/text()
```

- Obtén el título de la primera noticia del autor "DUNALUNA".

```
/Category/Feed/item[author="DUNALUNA"][1]/title/text()
```

- Obtén el autor de las noticias que dentro del título tengan la palabra "Fukushima".

```
/Category/Feed/item[contains(title, "Fukushima")]/author/title()
```

- Obtén todas las noticias cuyo título (title) comience por C.

```
/Category/Feed/item[starts-with(title, "C")]
```

- Obtén todas de noticias del autor "DUNALUNA".

```
/Category/Feed/item[author="DUNALUNA"]
```

- Obtén el número de noticias del autor "chupidos".

```
/Category/Feed/sum(item[author="chupidos"]
```

- Obtén el número de noticias del autor "DUNALUNA".

```
/Category/Feed/sum(item[author="DUNALUNA"]
```

- Obtén todas las noticias que tengan descripción.

```
/Category/Feed/item[description]
```

- Obtén todas las noticias que NO tengan descripción.

```
/Category/Feed/item[count(description)<1]
```

- Obtén el número de notícias.

```
/Category/Feed/sum(item)
```

## Genera un informe con las soluciones de cada uno de los ejercicios propuestos.


</div>
