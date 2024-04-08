
<div align="justify">

# Personajes de Marvel

<div align="center">
  <img src="images/marvel-personas.png">
</div>

Has sido contratado para desarrollar un pequeño sistema de gestión de personajes de Marvel que permita realizar operaciones __CRUD__ (_Crear, Leer, Actualizar y Eliminar_) a través de __BBDD__.

Tu tarea es implementar las siguientes funcionalidades:

- __Crear un nuevo personaje__: _El usuario debería poder agregar un nuevo personaje proporcionando su nombre, alias, género, y un conjunto de poderes asociados_.  
- __Leer información de todos los personajes__: El sistema debería ser capaz de mostrar la información de todos los personajes almacenados en los archivos en los tres formatos.
- __Actualizar información de un personaje__: _El usuario debería poder actualizar la información de un personaje existente, como cambiar su alias o agregar/quitar poderes_.
- __Eliminar un personaje__: _El usuario debería poder eliminar un personaje de la base de datos_.

>___Nota___: _No es necesario implementar una interfaz de usuario, puedes trabajar_ ___TEST__. En caso de que te resulte complicado implementa una interfaz de línea de comandos simple para interactuar con el sistema_.
>___IMPORTA___:_Recuerda que la simplicidad y la claridad del código son importantes, así como el manejo correcto de errores y excepciones._

>__Nota__:
  
  - __Persona__:
    - _nombre_
    - _alias_
    - _genero_
    - _poderes_
      - _poder1_
      - _poder2_
      - _..._



- __SQL las pruebas (personajes)__:

  ```sql
  CREATE TABLE IF NOT EXISTS Personajes (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      nombre TEXT NOT NULL,
      alias TEXT NOT NULL,
      genero TEXT
  );

  CREATE TABLE IF NOT EXISTS Poderes (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      personaje_id INTEGER NOT NULL,
      poder TEXT NOT NULL,
      FOREIGN KEY(personaje_id) REFERENCES Personajes(id)
  );

  INSERT INTO Personajes (nombre, alias, genero) VALUES 
      ('Iron Man', 'Tony Stark', 'Masculino'),
      ('Spider-Man', 'Peter Parker', 'Masculino');

  INSERT INTO Poderes (personaje_id, poder) VALUES 
      (1, 'Vuelo'),
      (1, 'Armadura tecnológica avanzada'),
      (1, 'Rayos láser'),
      (2, 'Agilidad sobrehumana'),
      (2, 'Trepamuros'),
      (2, 'Sentido arácnido');
  ```
>__Nota__: ___Corrige todo aquello que sea neceario, e implementa un crud, verificado con Test___.

</div>