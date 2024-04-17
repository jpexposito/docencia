<div align="justify">

# JPA

JPA es la _propuesta estándar_ que ofrece __Java__ para implementar un ___Framework Object Relational Mapping (ORM)___, que permite interactuar con la base de datos por medio de objetos, de esta forma, JPA es el encargado de convertir los objetos Java en instrucciones para el Manejador de Base de Datos (MDB).

Cuando empezamos a trabajamos con bases de datos en Java lo primero que nos enseñan es a utiliza el API de JDBC el cual nos permite realizar consultas directas a la base de datos a través de consultas SQL nativas. JDBC por mucho tiempo fue la única forma de interactuar con las bases de datos, pero representaba un gran problema y es que Java es un lenguaje orientado a objetos y se tenía que convertir los atributos de las clases en una consulta SQL como _SELECT, INSERT, UPDATE, DELTE_, etc. lo que ___ocasionaba un gran esfuerzo de trabajo___ y  _provoca muchos errores en tiempo de ejecución, debido principalmente a que las consultas SQL se tenían que generar frecuentemente al vuelo_.

>__Nota__:_Diferencias entre [JDBC-JPA](JDBC-JPA.md)_.

Una de las cosas más importantes para comprender que es JPA es entender que JPA es una especificación y no un Framework como tal, ¿pero quiere decir esto exactamente?, pues bien, una especificación no es más que un documento en el cual se plasman las reglas que debe de cumplir cualquier proveedor que dese desarrollar una implementación de JPA, de tal forma que cualquier persona puede  tomar la especificación y desarrollar su propia implementación de JPA, ¿Esto quiere decir que pueden existir muchas implementaciones de JPA? la respuesta es sí, de echo en la actualidad existen varios proveedor como lo son los siguientes:

- Hibernate
- ObjectDB
- TopLink
- EclipseLink
- OpenJPA

Dentro de las implementaciones más utilizadas están __Hibernate__, EclipseLink & TopLink, las dos primeras son las más utilizadas en el mundo open source y TopLink es muy utilizada en desarrollos y productos relacionados con Oracle. Antes de preguntarnos cuál es la diferencia entre todas estas implementaciones tenemos que comprender que en teoría todas debería de ofrecer la misma funcionalidad y el mismo comportamiento, lo que nos permitiría migrar entre una implementación a otra sin afectar en nada nuestra aplicación. Desde luego esto es solo teoría, ya que en la actualidad no todas las implementaciones implementan al 100% la especificación de JPA, además en escenario muy concretos puede que se comporten ligeramente diferente, por lo que puede requerir realizar algunos ajustes antes de migrar correctamente de proveedor.

<div align="center">
    <img src="img/orm.png">
</div>

## Entremos en detalle

<div align="center">
    <img src="img/jpa-api-arquitectura.png" width="400px">
</div>

| Unidades               | Descripción                                                                                                    |
|------------------------|----------------------------------------------------------------------------------------------------------------|
| __EntityManagerFactory__  | Esta es una clase de fábrica de EntityManager. Crea y gestiona múltiples instancias EntityManager.            |
| __EntityManager__         | Es una interfaz, que gestiona la persistencia de objetos. Funciona como instancia de consulta.                 |
| Entidad                | Las entidades son los objetos de persistencia, tiendas como registros en la base de datos.                     |
| __EntityTransaction__      | Tiene una relación de uno a uno con EntityManager. Para cada método EntityManager, se mantienen las        |
|                        | operaciones de EntityTransaction clase.                                                                       |
| __Persistencia__           | Esta clase contiene métodos estáticos para obtener EntityManagerFactory.                                       |
| __Consulta__               | Esta interfaz es implementada por cada proveedor JPA relacional para obtener objetos que cumplan los criterios.|

>___Nota___: _Aunque parezca complicado lo iremos viendo más simple con un pequeño ejemplo_.

```java
import javax.persistence.*;
import java.util.List;

// Definición de la entidad Persona
@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    // Constructores, getters y setters
}

public class Main {
    public static void main(String[] args) {
        // Configurar la conexión a la base de datos SQLite usando un archivo de base de datos
        String url = "jdbc:sqlite:datos.db";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MiUnidadPersistencia", getJpaProperties(url));
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Iniciar una transacción
        entityManager.getTransaction().begin();

        // Crear una nueva persona
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setEdad(30);

        // Persistir la persona en la base de datos
        entityManager.persist(persona);

        // Confirmar la transacción
        entityManager.getTransaction().commit();

        // Consultar todas las personas en la base de datos
        Query query = entityManager.createQuery("SELECT p FROM Persona p");
        List<Persona> personas = query.getResultList();

        // Mostrar los resultados de la consulta
        for (Persona p : personas) {
            System.out.println("Persona: " + p.getId() + ", " + p.getNombre() + ", " + p.getEdad());
        }

        // Cerrar el EntityManager
        entityManager.close();
        entityManagerFactory.close();
    }

    // Método para configurar las propiedades JPA con la URL de conexión SQLite
    private static Map<String, String> getJpaProperties(String url) {
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.driver", "org.sqlite.JDBC");
        properties.put("javax.persistence.jdbc.url", url);
        properties.put("javax.persistence.schema-generation.database.action", "create");
        return properties;
    }
}
```

>___Importante___: _utilizamos las anotaciones en las entidades que provee el paquete_ ___javax.persistence.*;___


También podemos definir las propiedades del la conexión de base de datos a través de un fichero de configuración ___.xml___ que se denomina ___persitence.xml___ y que se almacena en el directorio: __src/main/resources/META-INF__.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
             version="2.1">

    <persistence-unit name="MiUnidadPersistencia">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <class>paquete.de.tu.clase.Persona</class>
        <properties>
            <!-- Propiedades para la configuración de la base de datos -->
            <property name="javax.persistence.jdbc.driver" value="org.sqlite.JDBC"/>
            <property name="javax.persistence.jdbc.url" value="jdbc:sqlite:datos.db"/>
            <property name="javax.persistence.schema-generation.database.action" value="validate"/>
        </properties>
    </persistence-unit>
</persistence>
```

Elementos a tener en cuenta, y __muy importantes__:

- __org.sqlite.JDBC__: Driver de la BBDD.
- __sqlite:datos.db__: Nombre de la BBDD, referenciado en _javax.persistence.jdbc.url_.
- __<class>paquete.de.tu.clase.Persona</class>__. Conjunto de clases anotadas que contienen información de las tablas de la BBDD.
- __javax.persistence.schema-generation.database.action__. Acción que se va a realizar sobre la BBDD:
  - __validate__: Esta opción hace que Hibernate valide el esquema de la base de datos. No realiza cambios en el esquema de la base de datos. Es útil en entornos de producción donde no quieres que Hibernate realice cambios automáticos en la estructura de la base de datos.
  
    ```xml
    <property name="hibernate.hbm2ddl.auto" value="validate"/>
    ```
  
  - __update__: Esta opción hace que Hibernate actualice automáticamente el esquema de la base de datos según los cambios en las entidades de tu aplicación. Por ejemplo, si agregas una nueva entidad o cambias la definición de una entidad existente, Hibernate modificará automáticamente el esquema de la base de datos para reflejar esos cambios.
    
    ```xml
    <property name="hibernate.hbm2ddl.auto" value="update"/>
    ```
  
  - __create__: Esta opción hace que Hibernate elimine y cree el esquema de la base de datos cada vez que se inicia la aplicación. Ten en cuenta que esto borrará todos los datos de la base de datos y creará un esquema nuevo desde cero. Es útil en entornos de desarrollo donde deseas tener un esquema de base de datos fresco cada vez que reinicias la aplicación.

    ```xml
    <property name="hibernate.hbm2ddl.auto" value="create"/>
    ```
  
</div>