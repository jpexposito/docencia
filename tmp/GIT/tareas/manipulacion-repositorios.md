# Tarea 2: Manipulación de repositorios en Git

## Introducción

 La siguiente tarea tiene como objetivo que el alumno se familiarice con la creación y manipulación de repositorios en _GIT_. Para conseguirlo se irán describiendo los pasos necesarios para la realización de cada una de las acciones necesarias. 

## Requisitos previos

 Disponer de una distribución Linux, y realizada la tarea [instalación y configuración de git](instalacion-git.md)  


## Tareas

### Tarea: Configuración

 Configurar Git definiendo el nombre del usuario, el correo electrónico y activar el coloreado de la salida. Mostrar la configuración final.
 
```
  git config --global user.name "Your-Full-Name"
  git config --global user.email "your-email-address"
  git config --global color.ui auto
  git config --list
```

### Tarea: Creación de un repositorio

 Crear un repositorio nuevo con el nombre _dpl_ y mostrar su contenido.

```
 mkdir dpl
 cd dpl
 git init
 ls -la
 ```

### Tarea: Comprobar el estado del repositorio

 - Comprobar el estado del repositorio.

 - Crear un fichero indice.txt con el siguiente contenido:
   - Capítulo 1: Instalación de Git por el alumno XXX _(donde XXX es el nombre del alumno)_
   - Capítulo 2: Flujo de trabajo básico
 - Comprobar de nuevo el estado del repositorio.
 - Añadir el fichero a la zona de intercambio temporal.
 - Volver a comprobar una vez más el estado del repositorio.

```
 git status
 cat > indice.txt
 Capítulo 1: Instalación de Git por el alumno XXX
 Capítulo 2: Flujo de trabajo básico
 Ctrl+D
 git status
 git add indice.txt
 git status
``` 

### Tarea: Realizando Commit´s 

 Realizar un commit de los últimos cambios con el mensaje __Añadido índice de la asignatura DPL.__ y ver el estado del repositorio.

```
git commit -m "Añadido índice de la asignatura DPL."
git status
``` 

### Tarea: Modificación de ficheros

 - Cambiar el fichero indice.txt para que contenga lo siguiente:
   - Capítulo 1: Instalación de Git por el alumno XXX _(donde XXX es el nombre del alumno)_
   - Capítulo 2: Flujo de trabajo básico
   - Capítulo 3: Gestión de ramas
   - Capítulo 4: Repositorios remotos
 - Mostrar los cambios con respecto a la última versión guardada en el repositorio.
 - Hacer un commit de los cambios con el mensaje __Añadido los capitulos 3 y 4__.

```
cat > indice.txt
Capítulo 1: Instalación de Git por el alumno XXX _(donde XXX es el nombre del alumno)_
Capítulo 2: Flujo de trabajo básico
Capítulo 3: Gestión de ramas
Capítulo 4: Repositorios remotos
Ctrl+D
git diff
git add indice.txt
git commit -m "Añadido los capitulos 3"
``` 

### Tarea: Historial

 - Mostrar los cambios de la última versión del repositorio con respecto a la anterior.
 - Cambiar el mensaje del último commit por __Añadido el capitulo sobre gestión de ramas al índice.__
 - Volver a mostrar los últimos cambios del repositorio.

```
git show
git commit --amend -m "Añadido el capitulo sobre gestión de ramas al índice."
git show
```


## Informe:

Realiza un informe indicando los pasos que has seguido para la instalación de la versión _2.29.3_ de _GIT_ y se muestre la versión de _GIT_ que esta corriendo en el sistema, la cual debe indicar la versión 2.29.3.
Además el informe debe de contener:
 - Titulo de la tarea.
 - Nombre y Apellidos.
 - Indice
 - Pasos descritos.
 - Capturas de pantalla.

### A tener en cuenta:
- Se pasará el programa antí copia para verificar autenticidad.
- + 5 faltas de ortografía se baja dos puntos.
- Al menos (1 folio indice, al menos 3 desarrollo de la práctica)
- Carecer faltas de ortografía.
- Capturas de pantalla con los resultados obtenidos. 