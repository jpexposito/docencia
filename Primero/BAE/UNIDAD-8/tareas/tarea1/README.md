<div align="justify">

<div align="center">
<img src="https://danielme.com/wp-content/uploads/2023/08/image-16.png" width="300">


En este ejercicio, vamos a trabajar en la creación de una base de datos simple utilizando MySQL. Esta base de datos estará diseñada para __administrar información de usuarios y productos__. Una vez que hayamos creado la base de datos y las tablas necesarias, vamos a implementar procedimientos almacenados y funciones para realizar operaciones comunes sobre estos datos.

Pasos:
- 1. Crea la bbdd. _ Utilizaremos comandos SQL para crear una base de datos llamada "SimpleDB" que contendrá dos tablas: "Users" para almacenar información de usuarios y "Products" para almacenar información de productos._

  ```sql
  CREATE DATABASE IF NOT EXISTS SimpleDB;

  USE SimpleDB;

  CREATE TABLE IF NOT EXISTS Users (
      UserID INT AUTO_INCREMENT PRIMARY KEY,
      UserName VARCHAR(50) NOT NULL,
      Email VARCHAR(100) NOT NULL
  );

  CREATE TABLE IF NOT EXISTS Products (
      ProductID INT AUTO_INCREMENT PRIMARY KEY,
      ProductName VARCHAR(100) NOT NULL,
      Price DECIMAL(10, 2) NOT NULL
  );
  ```

- 2. Realiza la inserción de algunos datos de prueba.
  
  ```sql

  INSERT INTO Users (UserName, Email) VALUES ('Juan', 'juan@example.com');
  INSERT INTO Users (UserName, Email) VALUES ('María', 'maria@example.com');
  INSERT INTO Users (UserName, Email) VALUES ('Pedro', 'pedro@example.com');

  INSERT INTO Products (ProductName, Price) VALUES ('Producto 1', 10.99);
  INSERT INTO Products (ProductName, Price) VALUES ('Producto 2', 20.50);
  INSERT INTO Products (ProductName, Price) VALUES ('Producto 3', 15.75);

  ```

  >__Nota__:_Realizar la inserción de al menos_ ___3 elementos___ _más en cada tabla_.

- 3. Crea __procedimientos almacenados__ para realizar operaciones como __insertar un nuevo usuario, actualizar el nombre de un usuario__, etc.
  - Procedimiento para insertar un nuevo usuario.
  - Procedimiento para actualizar el nombre de un usuario.
  
>__Nota__: _Realiza la invocación y la verificación de que ha funcionado correctamente_.

- 4. Implementa funciones para realizar cálculos o consultas:
  - Función para calcular el precio total de un conjunto de productos.
  - Función para contar el número de usuarios.

>__Nota__: _Realiza la invocación y la verificación de que ha funcionado correctamente_.

</div>

</div>