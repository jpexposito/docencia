<div align="justify">

# Repaso Consultas

jercicios básicos de SQL con sus soluciones. Para usar con la base de datos [Sakila](file/sakila-es-data.sql). Las soluciones propuestas son para MySQL pero en gran parte son compatibles con SQL Server u otros motores. También incluyen algunas explicaciones.

La mayoría de los ejercicios fueron sacados de internet, traducidos o modificados.

## Queries de lectura

### 1. Muestra el nombre y apellido de todos los actores.
<details>
<summary>Solución</summary><p>

```sql
SELECT
  first_name  AS "Nombre",
  last_name   AS "Apellido"
FROM actor;
```
</p></details>

### 2. Muestra el nombre y apellido de cada actor en una sola columna, en mayúscula. Nombra la columna "Nombre del actor".
<details>
<summary>Solución</summary><p>

```sql
SELECT
  UCASE(CONCAT_WS(" ", first_name, last_name)) AS "Nombre del actor"
FROM actor;
```

También sirve **UPPER** en lugar de **UCASE**:
```sql
SELECT
  UPPER(CONCAT_WS(" ", first_name, last_name)) AS "Nombre del actor"
FROM actor;
```
**Tip**: La función *CONCAT_WS* concatena los datos que recibe y los separa usando el primer parámetro como separador.
</p></details>

### 3. Muestra el ID, nombre y apellido de un actor, de quien solo tienes el nombre "Joe".
<details>
<summary>Solución</summary><p>

```sql
SELECT
  actor_id    AS "ID",
  first_name  AS "Nombre",
  last_name   AS "Apellido"
FROM actor
WHERE first_name = "Joe";
```
</p></details>

### 4. Encuentra los actores cuyo apellido contenga "GEN".
<details>
<summary>Solución</summary><p>

```sql
SELECT
  first_name  AS "Nombre",
  last_name   AS "Apellido"
FROM actor
WHERE last_name LIKE "%GEN%";
```
**Tip**: La palabra **LIKE** permite comparar un dato con un patrón sencillo. Aquí el símbolo % cuenta como comodín para cualquier conjunto de caracteres.
</p></details>

### 5. Encuentra los actores cuyo apellido contenga "LI". Ordena las filas por apellido y nombre (en ese orden).
<details>
<summary>Solución</summary><p>

```sql
SELECT
  first_name  AS "Nombre",
  last_name   AS "Apellido"
FROM actor
WHERE last_name LIKE "%LI%"
ORDER BY `Nombre`, `Apellido`;
```
**Tip**: Aquí referenciamos al nombre y apellido por sus _alias_, usando el símbolo de tilde invertido (**no con comillas**). Eso solo es posible en _ORDER BY_, _GROUP BY_ o _HAVING_.
</p></details>

### 6. Usando la función IN, muestra el nombre y apellido de todos los clientes llamados "Terry", "Jessie" o "Alice".
<details>
<summary>Solución</summary><p>

```sql
SELECT
  first_name  AS "Nombre",
  last_name   AS "Apellido"
FROM customer
WHERE first_name IN ("Terry", "Jessie", "Alice");
```
</p></details>

### 7. Muestra el apellido de cada actor y la cantidad de actores que tienen ese apellido.
<details>
<summary>Solución</summary><p>

```sql
SELECT
  last_name   AS "Apellido",
  COUNT(*)    AS "Cantidad de actores"
FROM actor
GROUP BY last_name;
```
**Tip**: Cuando usamos **COUNT** es necesario usar **GROUP BY** para agrupar el resultado según otra columna.
</p></details>

### 8. Muestra el apellido y la cantidad de actores que tienen ese apellido, pero solo los apellidos compartidos por dos o más actores.
<details>
<summary>Solución</summary><p>

```sql
SELECT
  last_name   AS "Apellido",
  COUNT(*)    AS "Cantidad de actores"
FROM actor
GROUP BY last_name
HAVING `Cantidad de actores` >= 2;
```
**Tip**: **HAVING** cumple la misma función que **WHERE**, pero se usa después de **GROUP BY**. Puede tomar los valores resultantes al agrupar. En este caso no sirve _WHERE_ porque hay que comparar el valor de _COUNT(*)_ después de agrupar.
</p></details>

### 9. Usando _joins_, muestra el nombre, apellido y dirección de cada miembro del _staff_.
<details>
<summary>Solución</summary><p>

```sql
SELECT
  s.first_name                              AS "Nombre",
  s.last_name                               AS "Apellido",
  COALESCE(a.address, "No tiene dirección") AS "Dirección"
FROM staff AS s
JOIN address AS a ON a.address_id = s.address_id;
```
**Tip**: Cuando desplegamos datos de un campo *nullable* (que puede contener *NULL*), es conveniente usar **COALESCE** para mostrar un texto por defecto si no se encuentra un dato.
</p></details>

### 10. Muestra el total de dinero recaudado por cada empleado durante agosto del 2005.
<details>
<summary>Solución</summary><p>

```sql
SELECT
  CONCAT_WS(" ", s.first_name, s.last_name) AS "Empleado",
  SUM(p.amount)                             AS "Dinero"
FROM staff AS s
JOIN payment AS p ON p.staff_id = s.staff_id
WHERE YEAR(p.payment_date) = 2005
GROUP BY `Empleado`;
```
**Tip**: La función **YEAR** recibe como parámetro un dato de tipo fecha y devuelve solamente el año.<br>
**Tip**: La función **SUM** funciona igual que **COUNT** pero, en vez de contar cada elemento, suma sus cantidades.
</p></details>

### 11. Despliega la cantidad de actores por cada película.
<details>
<summary>Solución</summary><p>

```sql
SELECT
  f.film_id         AS "ID",
  f.title           AS "Película",
  COUNT(fa.film_id) AS "Cantidad de actores"
FROM film AS f
LEFT JOIN film_actor AS fa ON fa.film_id = f.film_id
GROUP BY f.film_id;
```
**Tip**: Usamos **LEFT JOIN** porque queremos mostrar información de todos los elementos de la tabla _film_, que en esta solución está a la izquierda (en el _FROM_). Incluso aquellos que no están asociados a un actor (no tienen actores).
</p></details>

### 12. ¿Cuántas copias hay inventariadas en el sistema de la película "Hunchback Impossible"?
<details>
<summary>Solución</summary><p>

```sql
SELECT
  f.title   AS "Película",
  COUNT(*)  AS "Cantidad"
FROM inventory AS i
RIGHT JOIN film AS f ON f.film_id = i.film_id
GROUP BY f.title
HAVING f.title = "Hunchback Impossible";
```
**Tip**: Usamos **RIGHT JOIN** para inclinar los datos hacia la tabla _film_, tomando todas las películas, incluso aquellas que no tienen copias inventariadas. De este modo si "Hunchback Impossible" tuviera 0 copias registradas, seguiría apareciendo en los resultados con 0 copias.
</p></details>

### 13. Muestra el total de dinero pagado por cada cliente, solo si ha realizado compras. Ordena los clientes por apellido de forma ascendente.
<details>
<summary>Solución</summary><p>

```sql
SELECT
  c.first_name      AS "Nombre",
  c.last_name       AS "Apellido",
  sum(p.amount)     AS "Total paid"
FROM customer AS c
JOIN payment AS p ON p.customer_id = c.customer_id
GROUP BY c.first_name, c.last_name
ORDER BY c.last_name ASC;
```
**Tip**: Usamos **INNER JOIN** (o simplemente _JOIN_) para tomar solo los elementos vinculados entre ambas tablas. Porque en este caso solo nos interesan los clientes que han hecho compras.
</p></details>

### 14. Se debe realizar una campaña de marketing en Canada. Para esto necesitas el nombre y correo electrónico de todos los clientes canadienses. Despliega esta información.
<details>
<summary>Solución</summary><p>

```sql
SELECT
  cu.first_name   AS "Nombre",
  cu.last_name    AS "Apellido",
  cu.email        AS "Email"
FROM customer AS cu
JOIN address AS ad    ON ad.address_id = cu.address_id
JOIN city AS ci       ON ci.city_id = ad.city_id
JOIN country AS co    ON co.country_id = ci.country_id
WHERE co.country = "Canada";
```
**Tip**: El primer _JOIN_ es de tipo _INNER_ porque solo nos interesan los clientes que tienen una dirección asociada. Lo siguientes también son _INNER JOIN_ porque para capturar los clientes canadienses solo nos sirven aquellos datos donde la dirección está asociada a una ciudad y un país. En otras palabras solo recogemos datos con el vínculo completo desde cliente hasta país.
</p></details>

### 15. Identifica todas las películas categorizadas como familiares (categoría "family").
<details>
<summary>Solución</summary><p>

```sql
SELECT
  f.title AS "Título"
FROM film AS f
JOIN film_category AS fc  ON fc.film_id = f.film_id
JOIN category AS c        ON c.category_id = fc.category_id
WHERE c.name LIKE "%family%";
```
</p></details>

### 16. Muestra las películas más arrendadas en orden descendente.
<details>
<summary>Solución</summary><p>

```sql
SELECT
  f.title                 AS "Película",
  COUNT(r.inventory_id)   AS "Veces arrendada"
FROM film AS f
LEFT JOIN inventory AS i  ON i.film_id = f.film_id
LEFT JOIN rental AS r     ON r.inventory_id = i.inventory_id
GROUP BY f.title
ORDER BY `Veces arrendada` DESC;
```
**Tip**: Usamos _LEFT JOIN_ para tomar todas las películas, incluyendo las que nunca han sido arrendadas.
</p></details>

### 17. Despliega el dinero recaudado por cada tienda.
<details>
<summary>Solución</summary><p>

```sql
SELECT
  store.store_id  AS "ID Tienda",
  SUM(p.amount)   AS "Dinero"
FROM store
LEFT JOIN staff         ON staff.store_id = store.store_id
LEFT JOIN payment AS p  ON p.staff_id = staff.staff_id
GROUP BY store.store_id
ORDER BY `Dinero` DESC;
```

</div>