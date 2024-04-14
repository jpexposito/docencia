<div align="justify">

# Diferencia entre JDBC (Java Database Connectivity) y JPA (Java Persistence API)

### JDBC (Java Database Connectivity):

JDBC es una API de Java que proporciona métodos y clases para interactuar directamente con una base de datos relacional.

- Con JDBC, los desarrolladores deben escribir código detallado para establecer conexiones, crear y enviar consultas SQL, manejar resultados y manejar transacciones manualmente.
- JDBC es de bajo nivel y requiere que los desarrolladores gestionen muchos aspectos de la interacción con la base de datos de forma explícita.
- Es más adecuado para aplicaciones donde se requiere un control fino sobre las operaciones de base de datos y la eficiencia es crítica.

### JPA (Java Persistence API):

JPA es una API de Java que proporciona métodos y clases de alto nivel para mapear objetos Java a tablas en una base de datos relacional.

- Con JPA, los desarrolladores pueden trabajar con objetos de dominio en lugar de SQL, lo que facilita el desarrollo de aplicaciones orientadas a objetos y reduce la cantidad de código necesario.
- JPA se basa en el patrón de diseño ORM (Mapeo Objeto-Relacional), que permite que las clases Java se mapeen automáticamente a tablas en la base de datos y viceversa.
- JPA maneja automáticamente muchas tareas comunes, como la gestión de conexiones, la generación de consultas SQL y la gestión de transacciones, lo que simplifica el desarrollo y reduce la posibilidad de errores.
- Es más adecuado para aplicaciones donde se prioriza la productividad y la facilidad de mantenimiento sobre el rendimiento de la base de datos.

## Un ejemplo con lo básico

### JDBC

```java
Connection conn = DriverManager.getConnection(url, username, password);
Statement stmt = conn.createStatement();
String sql = "INSERT INTO personas (nombre, edad) VALUES ('Juan', 30)";
stmt.executeUpdate(sql);
stmt.close();
conn.close();
```

### JPA

```java
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
EntityManager entityManager = entityManagerFactory.createEntityManager();

entityManager.getTransaction().begin();
Persona persona = new Persona();
persona.setNombre("Juan");
persona.setEdad(30);
entityManager.persist(persona);
entityManager.getTransaction().commit();

entityManager.close();
entityManagerFactory.close();
```


</div>