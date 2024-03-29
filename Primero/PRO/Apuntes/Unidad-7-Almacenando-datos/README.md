<div align="justify">

<div align="center">
<img src="img/database.png" with="200px">
</div>

# Almacenamiento de datos

## Introducción

Una base de datos es un sistema organizado para almacenar y recuperar información de manera eficiente. En Java, puedes interactuar con bases de datos utilizando un conjunto de APIs llamado ___JDBC___ _(Java Database Connectivity)_.


## Pasos Básicos para Trabajar con Bases de Datos en Java

### Importar Librerías JDBC

Lo primero que necesitas hacer es importar las librerías JDBC en tu proyecto. Estas librerías permiten la conexión y manipulación de la base de datos desde Java. Generalmente, estas librerías vienen incluidas en el JDK (Java Development Kit).

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
```

### Establecer una Conexión con la Base de Datos

Para interactuar con una base de datos, primero debes establecer una conexión con ella. Esto implica proporcionar la URL de conexión, el usuario y la contraseña.

```java
public Connection connect() {
    Connection conn = null;
    try {
        String url = "jdbc:sqlite:mi_base_de_datos.db";
        // Establecer conexión a la base de datos
        conn = DriverManager.getConnection(url);
    } catch (SQLException e) {
        //Se debe de tratar con una bbdd específica y no general java.sql.SQLException
    }
    return conn;
}
```

>__Nota__:La __URL de conexión a la base de datos SQLite__ _lee_ la bbdd en la ___ubicación especificada___, y en caso de que ___no exista___ _crea una nueva_.
_Se debe de trabajar con una excepción especiífica para evitar trabajar con las del modelo_ ___JDBC (java.sql.SQLException)___.

### Crear y Ejecutar Consultas SQL

Una vez que tienes una conexión establecida, puedes crear y ejecutar consultas SQL para interactuar con la base de datos. Esto incluye consultas para insertar, actualizar, eliminar y seleccionar datos.

```java
//1. Paso (Establecer la conexión a la base de datos)
Connection conn = connect();
//2. Paso (Definición de la consulta/operacion sobre la bbdd)
String sql = "Select / insert /update ...";
//3 Paso (Preparar la operación)
PreparedStatement createTableStatement = conn.prepareStatement(sql);
//4 Paso. Ejecutar la Operación
createTableStatement.executeUpdate();
```

todo esto dentro de un try ...catch()

```java
try {
    
} catch (SQLException e) {

}
```

### Procesar Resultados

Después de ejecutar una consulta SQL, obtendrás un conjunto de resultados. Debes procesar estos resultados según sea necesario. Por ejemplo, si ejecutas una consulta de selección, recibirás filas de datos que puedes leer y utilizar en tu aplicación.

```java
ResultSet resultSet = selectStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id") +
                                ", Nombre: " + resultSet.getString("nombre") +
                                ", Edad: " + resultSet.getInt("edad"));
        }
```

### Cerrar la Conexión

Es importante cerrar la conexión con la base de datos una vez que hayas terminado de trabajar con ella. Esto ayuda a liberar recursos y evitar fugas de memoria.

```java
// Cerrar la conexión a la base de datos
try {
    if (conn != null) {
        conn.close();
    }
} catch (SQLException e) {
    //Debemos manejar la excepción porque se produce una perdida de memoria y problemas de rendimiento.
}
```

### SQL y CSV

Vamos a representar los pasos de lectura sobre un fichero __.csv__ y una base de datos

| Paso                         | CSV                    | SQL en una Base de Datos                                     |
|------------------------------|----------------------------------------------|---------------------------------------------------------------|
| 1. Establecer Conexión      | Podemos verlo como acceder al fichero.``` try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {``` | Establecer una conexión a la base de datos mediante JDBC. ``` conn = DriverManager.getConnection(url);``` |
| 2. Leer Datos                | Leer línea por línea y usar `String[] linea = split(",")` para separar los valores.  | Ejecutar una sentencia SELECT con JDBC. ```java ResultSet resultSet = statement.executeQuery())```                     |
| 3. Procesar los Datos        | Procesar los valores según sea necesario. ``` String identificador = linea[0]; ```   | Procesar los resultados obtenidos de la consulta SQL. ``` String identificador = resultSet.getString("id")```        |
| 4. Cerrar el Lector          | Cerrar el `BufferedReader`.                   | Cerrar el `ResultSet` y la conexión a la base de datos.      |

>__Nota__:_Como podemos observar, los pasos para la lectura en ficheros de formatos csv, es igual a sql, teniendo en cuenta que las clases en las que nos apoyamos son diferentes._.

Veamos un ejemplos sobre [base de datos sqlite](CRUD-SQLITE.md).

</div>