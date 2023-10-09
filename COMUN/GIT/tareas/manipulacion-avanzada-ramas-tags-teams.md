<div align="justify">

# Manipulación avanzados de Git, GitHub y Markdown

## Notas

- Este ejercicio es continuación del anterior por lo que
tendréis que seguir trabajando en el repositorio.

- También tendreís que ir poniendo los **comandos** que habéis tenido que utilizar durante todos los ejercicios
y las **explicaciones y capturas de pantalla** que consideréis **necesarias** al fichero README.md del citado repositorio.

## Crear una rama v0.2

- Crear una rama **v0.2**.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

 ```console
  git branch v0.2
 ```
</details>

- Posiciona tu carpeta de trabajo en esta rama.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

 ```console
  git checkout v0.2
 ```
</details>

## Añadir fichero 2.txt

- Añadir un fichero **2.txt** en la rama **v0.2**.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

 ```console
  touch 2.txt
  git add .
  git commit -m "añadido 2.txt"
```
</details>

## Crear rama remota v0.2

- Subir los cambios al reposiorio remoto.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

 ```console
  git push origin v0.2
 ```
</details>

## Merge directo

- Posicionarse en la rama **master**.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

 ```console
  git checkout master
```
</details>

- Hacer un merge de la rama **v0.2** en la rama **master**.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

 ```console
  git merge v0.2 -m "merge v0.2 sin conflictos"
 ```
</details>

## Merge con conflicto

- En la rama **master** poner **Hola** en el fichero **1.txt** y hacer commit.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

 ```console
  git checkout master
  echo "Hola" >> 1.txt
  git add .
  git commit -m "hola en 1.txt"
 ```
</details>

- Posicionarse en la rama **v0.2** y poner **Adios** en el fichero "1.txt" y hacer commit.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

 ```console
  git checkout v0.2
  echo "Adios" >> 1.txt
  git add .
  git commit -m "adios en 1.txt"
 ```
</details>

- Posicionarse de nuevo en la rama **master** y hacer un merge con la rama **v0.2**

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

 ```console
  git checkout master
  git merge v0.2
  vim 1.txt
  git add .
  git commit -m "arreglado merge en 1.txt"
 ```
</details>

## Listado de ramas

- Listar las ramas con merge y las ramas sin merge.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

 ```console
  git branch --merged
  git branch --no-merged
 ```
</details>

## Arreglar conflicto

- Arreglar el conflicto anterior y hacer un commit.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

 ```console
  vim 1.txt
  git add .
  git commit -m "arreglado merge en 1.txt"
 ```
</details>

## Borrar rama

- Crear un tag **v0.2**

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
  git tag v0.2
```
</details>

- Borrar la rama **v0.2**

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
  git branch -d v0.2
```
</details>

## Listado de cambios

- Listar los distintos commits con sus ramas y sus tags.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
  git config --global alias.list 'log --oneline --decorate --graph --all'
  git list
```

## Crear una organización

- Crear una organización llamada **tunombredeusuariodegithub**

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
  En el menú de GitHub > Pulsar en el icono “+” > Pinchar en “New organization”
```
</details>

## Crear equipos

- Crear 2 equipos en la organización **tunombredeusuariodegithub**,
uno llamado **administradores** con más permisos y otro **colaboradores** con menos permisos.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
  Ir a http://github.com/tunombredeusuariodegithub/repositorio_tarea4 > Pinchar en "Teams" > Pulsar en "New team"
```
</details>


- Meter a [github.com/jpexposito](http://github.com/jpexposito) y a 2 de vuestros
compañeros de clase en el equipo **administradores**.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
  Ir a http://github.com/tunombredeusuariodegithub > Pinchar en "Teams" > Seleccionar el equipo "administradores" > Pulsar en "New member"
```
</details>


- Meter a [github.com/jpexposito](http://github.com/jpexposito) y a otros 2 de vuestros
compañeros de clase en el equipo **colaboradores**.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
  Ir a http://github.com/tunombredeusuariodegithub > Pinchar en "Teams" > Seleccionar el equipo "colaboradores" > Pulsar en "New member"
```
</details>


## Crear un index.html

- Crear un index.html que se pueda ver como página web en la organización.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
  Ir a http://github.com/tunombredeusuariodegithub > Pulsar en "New"
  Añadir un repositorio llamado tunombredeusuariodegithub.github.io
  Añadir un index.html a dicho repositorio
```
</details>


## Crear pull requests

- Hacer 2 forks de 2 repositorios **tunombredeusuariodegithub.github.io**
de 2 organizaciones de las que no seais ni administradiores ni colaboradores.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
  Ir a http://github.com/tunombredeusuariodegithub/tunombredeusuariodegithub.github.io > Pulsar en "Fork"
```
</details>


- Crearos una rama en cada fork.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
  En tu repo forkeado creas una rama.
```
</details>

- En cada rama modificar el fichero **index.html** añadiendo vuestro nombre.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
  Situada en dicha rama modificar el fichero index.html.
```
</details>

- Con cada rama hacer un pull request.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
  Ir a http://github.com/tunombredeusuariodegithub/tunombredeusuariodegithub.github.io > Pinchar en "Pull requests"
  Pulsar en "New pull request"
```
</details>

## Gestionar pull requests

- Aceptar los pull requests que lleguen a los repositorios de tu organización.

<details>
  <summary>PULSA PARA VER LA SOLUCIÓN:</summary>

```console
Dentro del repositorio de la organización gestionar dichos pull requets.
```
</details>