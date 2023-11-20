<div align="justify">

# Villanos

<div align="center">
<img src="img/villanos.png" width="400px"/>
</div>

Tenemos una empresa dedicada al mundo de las __series__ que tiene como objetivo la gestión de la información de estas.

La representación de la información dentro de la BBDD es la siguiente:

|Código | Episodio | Nombre Serie | Villanos | Fecha Estreno | Ratings | 
|-----|-----|-----|-----|-----|-----|
|100 | 01 | Batman | Gatubela,Doomsday |  2014 | 5.9,8.1,4.3 |
|100 | 02 | Batman | Gatubela,Doomsday |  2014 | 7.1,9,3.5 |
|100 | 03 | Batman | Gatubela,Doomsday |  2014 | 5.9,8.1,4.3 | 
|200 | 01 | Batman | Gatubela,Doomsday |  2015 | 3.5,7.8,7.1 | 
|200 | 02 | Batman | Gatubela,Doomsday |  2015 | 7.8,7.1 | 
|300 | 01 | Superman | Doomsday,LexLuthor |  2013 | 5.9,8.1,4.3 | 
|300 | 02 | Superman | Doomsday,LexLuthor |  2014 | 3.5,7.8,7.1 | 
|300 | 03 | Superman | Doomsday,LexLuthor |  2015 | 4.5 | 
|300 | 04 | Superman | Doomsday,LexLuthor |  2015 | 5.9,4.3 | 
|400 | 01 | El Capitán América | LexLuthor,Gatubela |  2013 | 4.3,9 | 
|400 | 02 | El Capitán América | LexLuthor,Gatubela |  2014 | 9.5,4.3,6.7 | 


Se pide:

1. Comprobar si se cumple la 1ª Forma Normal.
2. Normalizar si no se cumple el apartado 2.
3. Comprobar si se cumple la 2ª Forma Normal.
4. Normalizar si no se cumple el apartado 4.
5. Comprobar si se cumple la 3ª Forma Normal.
6. Normalizar si no se cumple el apartado 5.
7. Indicar claves de todas las tablas resultantes.
9. Genera el __diagrama E/R resultante__.

## 1 Forma Normal

La __bbdd__ no se encuentra en 1FN dado que todas propiedades no es atómicas. Podemos observar que el campo _villano_ y _raitins_ son valores multievaluados.

La __bbdd__ en __1FN_ quedará como sigue:

Código | Episodio | Nombre Serie | Villanos | Fecha Estreno | Ratings | 
|-----|-----|-----|-----|-----|-----|
|100 | 01 | Batman | Gatubela |  2014 | 5.9|
|100 | 01 | Batman | Gatubela |  2014 | 8.1|
|100 | 01 | Batman | Gatubela |  2014 | 4.3 |
|100 | 01 | Batman | Doomsday |  2014 | 5.9 |
|100 | 01 | Batman | Doomsday |  2014 | 8.1 |
|100 | 01 | Batman | Doomsday |  2014 | 4.3 |
|100 | 02 | Batman | Gatubela |  2014 | 7.1 |
|100 | 02 | Batman | Gatubela |  2014 | 9 |
|100 | 02 | Batman | Gatubela |  2014 | 3.5 |
|100 | 02 | Batman | Doomsday |  2014 | 7.1 |
|100 | 02 | Batman | Doomsday |  2014 | 9 |
|100 | 02 | Batman | Doomsday |  2014 | 3.5 |
|100 | 03 | Batman | Gatubela |  2014 | 5.9 | 
|100 | 03 | Batman | Gatubela |  2014 | 8.1| 
|100 | 03 | Batman | Gatubela |  2014 | 4.3 | 
|100 | 03 | Batman | Doomsday |  2014 | 5.9 | 
|100 | 03 | Batman | Doomsday |  2014 | 8.1| 
|100 | 03 | Batman | Doomsday |  2014 | 4.3 | 
|200 | 01 | Batman | Gatubela|  2015 | 3.5 | 
|200 | 01 | Batman | Gatubela|  2015 | 7.8 | 
|200 | 01 | Batman | Gatubela|  2015 | 7.1 | 
|200 | 01 | Batman | Doomsday|  2015 | 3.5 | 
|200 | 01 | Batman | Doomsday|  2015 | 7.8 | 
|200 | 01 | Batman | Doomsday|  2015 | 7.1 | 
|200 | 02 | Batman | Gatubela |  2015 | 7.8 | 
|200 | 02 | Batman | Gatubela |  2015 | 7.1 | 
|200 | 02 | Batman | Doomsday |  2015 | 7.8 | 
|200 | 02 | Batman | Doomsday |  2015 | 7.1 | 
|300 | 01 | Superman | Doomsday |  2013 | 5.9 | 
|300 | 01 | Superman | Doomsday |  2013 | 8.1 | 
|300 | 01 | Superman | Doomsday |  2013 | 4.3 | 
|300 | 01 | Superman | LexLuthor |  2013 | 5.9 | 
|300 | 01 | Superman | LexLuthor |  2013 | 8.1 | 
|300 | 01 | Superman | LexLuthor |  2013 | 4.3 | 
|300 | 02 | Superman | Doomsday |  2014 | 3.5 | 
|300 | 02 | Superman | Doomsday |  2014 | 7.8 | 
|300 | 02 | Superman | Doomsday |  2014 | 7.1 | 
|300 | 02 | Superman | LexLuthor |  2014 | 3.5 | 
|300 | 02 | Superman | LexLuthor |  2014 | 7.8 | 
|300 | 02 | Superman | LexLuthor |  2014 | 7.1 | 
|300 | 03 | Superman | Doomsday |  2015 | 4.5 | 
|300 | 03 | Superman | LexLuthor |  2015 | 4.5 | 
|300 | 04 | Superman | Doomsday |  2015 | 5.9 | 
|300 | 04 | Superman | Doomsday |  2015 | 4.3 | 
|400 | 01 | El Capitán América | LexLuthor |  2013 | 4.3 |
|400 | 01 | El Capitán América | LexLuthor |  2013 | 9 |
|400 | 01 | El Capitán América | Gatubela |  2013 | 4.3 |
|400 | 01 | El Capitán América | Gatubela |  2013 | 9 |
|400 | 02 | El Capitán América | LexLuthor |  2014 | 9.5 | 
|400 | 02 | El Capitán América | LexLuthor |  2014 | 4.3 | 
|400 | 02 | El Capitán América | LexLuthor |  2014 | 6.7 | 
|400 | 02 | El Capitán América | Gatubela |  2014 | 9.5 | 
|400 | 02 | El Capitán América | Gatubela |  2014 | 4.3 | 
|400 | 02 | El Capitán América | Gatubela |  2014 | 6.7 | 

## 2 Forma Normal

Una Relación esta en __2FN si y sólo si está en 1FN y todos los atributos que NO forman parte de la Clave Principal tienen dependencia funcional completa de ella__.

En la __bbdd__ quedará en __2FN__ de la siguiente forma:

### Tabla Serie

|Código __(PK)__ | Nombre |
|-----|-----|
|100 | Batman | 
|200 | Batman | 
|300 | Superman |
|400 | El Capitán América |

y el resto que forma parte de los episodios.

### Episodios


|Episodio | Villanos | Fecha Estreno | Ratings | 
|-----|-----|-----|-----|
| 01 | Gatubela |  2014 | 5.9|
| ... | ... |  ... | ...|

## 3 Forma Normal

Una Relación esta en __3FN si y sólo si está en 2FN y no existen dependencias transitivas__. Todas las dependencias __funcionales deben ser respecto a la clave principal__.

Nuestra __bbddd__ quedará en __3FN__ de la siguiente forma.

### Episodio

|idEpisodio __(PK)__ | Numero | Fecha | codigoSerie __(FK)__ |
|-----|-----|-----|-----| 
| 10001| 01 |  2014 | 100|
| ... | ... |  ... | ...|

Una relación __N:M__ entre serie y villanos, al tratarse de valores multievaluados. 

### Villano

|idVillano __(PK)__ | Nombre | 
|-----|-----|-----|
| 100001 | Gatubela |
| ... | ... | 

y una tabla __N:M__ Episodio_Villano.


### Episodio_Villano

|idEpisodio __(PK,FK)__ | idVillano __(PK,FK)__| 
|-----|-----|
| 01 | 100001 |
| ... | ... | 

Una relación __N:M__ entre serie y ratings, al tratarse de valores multievaluados.

### Ratings

|id __(PK)__ |  
|-----|
| 5.9 |
| ... | 

y una tabla __N:M__ Episodio_Ratings.


### Episodio_Villano

|idEpisodio __(PK,FK)__ | idRatings __(PK,FK)__| 
|-----|-----|
| 01 | 5.9 |
| ... | ... |

>__Nota__: Reflexiona sobre le número total de tablas que se generan, y crea el __modelo ER__.

</div>