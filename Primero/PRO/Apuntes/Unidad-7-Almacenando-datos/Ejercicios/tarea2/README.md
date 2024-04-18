
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

>___Nota___: _No es necesario implementar una interfaz de usuario, puedes trabajar_ ___TEST___. En caso de que te resulte complicado implementa una interfaz de línea de comandos simple para interactuar con el sistema_.
>___IMPORTANTE___:_Recuerda que la simplicidad y la claridad del código son importantes, así como el manejo correcto de errores y excepciones._

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
      genero TEXT
  );

  CREATE TABLE IF NOT EXISTS Alias (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      personaje_id INTEGER NOT NULL,
      alias TEXT NOT NULL,
      FOREIGN KEY(personaje_id) REFERENCES Personajes(id)
  );

  CREATE TABLE IF NOT EXISTS Poderes (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      poder TEXT NOT NULL
  );

  CREATE TABLE IF NOT EXISTS Personajes_Poderes (
      personaje_id INTEGER,
      poder_id INTEGER,
      PRIMARY KEY (personaje_id, poder_id),
      FOREIGN KEY(personaje_id) REFERENCES Personajes(id),
      FOREIGN KEY(poder_id) REFERENCES Poderes(id)
  );

  -- Inserción de datos
  INSERT INTO Personajes (nombre, genero) VALUES 
      ('Iron Man', 'Masculino'),
      ('Spider-Man', 'Masculino');

  INSERT INTO Alias (personaje_id, alias) VALUES 
      (1, 'Tony Stark'),
      (2, 'Peter Parker');

  INSERT INTO Poderes (poder) VALUES 
      ('Vuelo'),
      ('Armadura tecnológica avanzada'),
      ('Rayos láser'),
      ('Agilidad sobrehumana'),
      ('Trepamuros'),
      ('Sentido arácnido');

  INSERT INTO Personajes_Poderes (personaje_id, poder_id) VALUES 
      (1, 1), -- Iron Man tiene Vuelo
      (1, 2), -- Iron Man tiene Armadura tecnológica avanzada
      (1, 3), -- Iron Man tiene Rayos láser
      (2, 4), -- Spider-Man tiene Agilidad sobrehumana
      (2, 5), -- Spider-Man tiene Trepamuros
      (2, 6); -- Spider-Man tiene Sentido arácnido
  ```
>__Nota__: ___Corrige todo aquello que sea neceario, e implementa un crud, verificado con Test___.

</div>