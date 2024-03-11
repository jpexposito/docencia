
<div align="justify">

# Personajes de Marvel

<div align="center">
  <img src="images/marvel-personas.png">
</div>

Has sido contratado para desarrollar un pequeño sistema de gestión de personajes de Marvel que permita realizar operaciones __CRUD__ (_Crear, Leer, Actualizar y Eliminar_) utilizando diferentes formatos de archivos: __XML, JSON y CSV__.

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


Ficheros para las pruebas:

- __csv__:

  ```csv
  nombre,alias,genero,poderes
  Iron Man,Tony Stark,Masculino,"Vuelo, Armadura tecnológica avanzada, Rayos láser"
  Spider-Man,Peter Parker,Masculino,"Agilidad sobrehumana, Trepamuros, Sentido arácnido"

  ```

- __xml__:

  ```xml
  <personajes>
    <personaje>
      <nombre>Iron Man</nombre>
      <alias>Tony Stark</alias>
      <genero>Masculino</genero>
      <poderes>
        <poder>Vuelo</poder>
        <poder>Armadura tecnológica avanzada</poder>
        <poder>Rayos láser</poder>
      </poderes>
    </personaje>
    <personaje>
      <nombre>Spider-Man</nombre>
      <alias>Peter Parker</alias>
      <genero>Masculino</genero>
      <poderes>
        <poder>Agilidad sobrehumana</poder>
        <poder>Trepamuros</poder>
        <poder>Sentido arácnido</poder>
      </poderes>
    </personaje>
  </personajes>
  ```

- __json__:

  ```json
  [
      {
        "nombre": "Iron Man",
        "alias": "Tony Stark",
        "genero": "Masculino",
        "poderes": [
          "Vuelo",
          "Armadura tecnológica avanzada",
          "Rayos láser"
        ]
      },
      {
        "nombre": "Spider-Man",
        "alias": "Peter Parker",
        "genero": "Masculino",
        "poderes": [
          "Agilidad sobrehumana",
          "Trepamuros",
          "Sentido arácnido"
        ]
      }
    ]
  ```
  
</div>