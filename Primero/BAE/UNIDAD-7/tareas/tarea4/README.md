<div align="justify">

# Trabajo con Sakila

Vamos a realizar el trabajo con una BBDD existente en la documentación  oficial de MySql. Su nombre es __Sakila__.

El __diagrama ER__ de esta BBDD es el siguiente:

<div align="center">
<img width="700" src="../../img/sakila-er.png"/>
</div>


La base de datos está disponible en la [web oficial de MySQL](https://dev.mysql.com/doc/index-other.html).

A continuación se debe de realizar la carga de la BBDD. 

Sigue los siguientes [pasos para la carga del esquema y los datos](https://dev.mysql.com/doc/sakila/en/sakila-installation.html).


Se pide:
- Realiza la carga de la BBDD de Sakila, tal y como se muestra en los enlaces proporcionados.
- Realiza cada una de las siguientes consultas:
    - Actores que tienen de primer nombre __Scarlett__.
    - Actores que tienen de apellido __Johansson__.
    - Actores que contengan una __O__ en su nombre.
    - Actores que contengan una __O__ en su nombre y en una __A__ en su apellido.
    - Actores que contengan dos __O__ en su nombre y en una __A__ en su apellido.
    - Actores donde su tercera letra sea __B__.
    - Ciudades que empiezan por __a__.
    - Ciudades que acaban por __s__.
    - Ciudades del country __61__.
    - Ciudades del country __Spain__.
    - Ciudades con nombres compuestos.
    - Películas con una duración entre __80 y 100__.
    - Peliculas con un rental_rate entre __1 y 3__.
    -  Películas con un titulo de más de __12 letras__.
    - Peliculas con un rating de __PG__ o __G__.
    - Peliculas que no tengan un rating de __NC-17__.
    - Peliculas con un rating __PG__ y duracion de más de __120__.
    - ¿Cuantos actores hay?
    - ¿Cuántas ciudades tiene el country __Spain__?
    - ¿Cuántos countries hay que empiezan por __a__?
    - Media de duración de peliculas con __PG__.
    - Suma de __rental_rate__ de todas las peliculas.
    - Pelicula con mayor duración.
    - Película con menor duración.
    - Mostrar las ciudades del country __Spain__ (multitabla).
    - Mostrar el nombre de la película y el nombre de los actores.
    - Mostrar el nombre de la película y el de sus categorías.
    - Mostrar el country, la ciudad y dirección de cada miembro del staff.
    - Mostrar el country, la ciudad y dirección de cada customer.
    - Numero de películas de cada __rating__
    - Cuantas películas ha realizado el actor __ED CHASE__.
    - Media de duración de las películas cada categoría.

>__Nota__: _Se debe de mostrar la salida de cada una de las consultas_.

A continuación se muestran algunas de las vistas que se han utilizado en la base de datos Sakila:

```sql
--
-- View structure for view `customer_list`
--

CREATE VIEW customer_list AS
SELECT 
  cu.customer_id AS ID, 
    CONCAT(cu.first_name, _utf8mb4' ', cu.last_name) AS name, 
    a.address AS address, 
    a.postal_code AS `zip code`,
  a.phone AS phone, 
    city.city AS city, 
    country.country AS country, 
    IF(cu.active, _utf8mb4'active',_utf8mb4'') AS notes, 
    cu.store_id AS SID
FROM 
  customer AS cu JOIN address AS a 
    ON cu.address_id = a.address_id 
    JOIN city 
    ON a.city_id = city.city_id
  JOIN country 
    ON city.country_id = country.country_id;
--
-- View structure for view `film_list`
--

CREATE VIEW film_list AS
SELECT 
  film.film_id AS FID, 
    film.title AS title, 
    film.description AS description, 
    category.name AS category, 
    film.rental_rate AS price,
  film.length AS length, 
    film.rating AS rating, 
    GROUP_CONCAT(CONCAT(actor.first_name, _utf8mb4' ', actor.last_name) SEPARATOR ', ') AS actors
FROM 
  category LEFT JOIN film_category 
    ON category.category_id = film_category.category_id 
    LEFT JOIN film 
    ON film_category.film_id = film.film_id
  JOIN film_actor 
    ON film.film_id = film_actor.film_id
  JOIN actor 
    ON film_actor.actor_id = actor.actor_id
GROUP BY film.film_id, category.name;
```

Conociendo es estos momentos ya la __BBDD__, se pide:
- Muestra el resultado de la consulta de las vistas que se proporcionan.
- Crea __5__ vistas sobre la __BBDD__, y realizar la consulta, para mostrar los resultados. ___Las vistas deben de tener 3 o más tablas de la BBDD___.

## Referencias

- [Introducción a Sakila BBDD](https://dev.mysql.com/doc/sakila/en/sakila-introduction.html).
- [Ejemplos de uso de Sakila](https://dev.mysql.com/doc/sakila/en/sakila-usage.html).
- [Apuntes sobre índices](../../Indices.md).

</div>