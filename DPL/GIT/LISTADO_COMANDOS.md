# Git Avanzado: Comandos más usados

 Comencemos por describir los comandos de mayor uso:

 ## Comandos Básicos
 ___

### init

 Convierte un directorio en un repositorio Git vacío. Es el primer paso para iniciar el repositorio local en tu sistema. Después es posible agregar y confirmar archivos / directorios.

### config

 Es una función de conveniencia que se usa para establecer valores de configuración de Git a nivel de proyecto global o local.

 Dos configuraciones importantes son user.name y user.email. Estos valores establecen de qué dirección de correo electrónico y de qué nombre serán los commit en una computadora local.

### remote add

 Se usa para conectar un repositorio local con un repositorio remoto.

### git status

  Enumera todos los archivos que deben confirmarse, es decir, devuelve el estado actual del repositorio.

### git clone

  Se usa para clonar el repositorio desde el servidor remoto a la máquina local.

### git add

  Agrega los cambios en el directorio de trabajo al área de preparación de Git. Le dice a Git que desea incluir actualizaciones para un archivo en particular en el próxima commit.

  Si tienes que agregar varios archivos, puedes usar git add * .

### git push

  Se usa para cargar el contenido del repositorio local en un repositorio remoto.

### git pull

  Extrae los cambios del repositorio remoto a la computadora local.

### git checkout

  Se usa para cambiar entre las ramas. Incluso después de crear una nueva rama, todavía está en la rama principal.

### git branch

  Muestra todas las ramas y determina en qué rama se encuentra, además puede crear una nueva rama y también eliminar una rama.

### git tag

  Se usa para asignar etiquetas a el commit especificada.

### Gestión de branches/ ramas gitflow

  El modelo está bien definido y es simple, vale la pena considerar el proceso, especialmente la gestión de versiones y revisiones, incluso si no adopta las herramientas de gitflow. En el post anterior explico qué es Gitflow.

  Sus comandos fomentan la disciplina y la coherencia al simplificar la ramificación y la fusión en forma particular.

  Usar ramas, etiquetas y commit estándar de git, conservando la capacidad de cada desarrollador para usar todo el poder de git fuera de este proceso a su discreción.

  Dos ramas son permanentes: __«Master»__, que refleja un producto lanzado o por lanzar, y __«Develop»__, que incluye funciones completadas para el próximo lanzamiento.

  Las features realizan un seguimiento de las funciones, las versiones y las correcciones urgentes de las versiones. Estas ramas son temporales y viven solo hasta que se fusionan.

## Comandos Avanzados
  ___

 A continuación, te indico algunos comandos de Git avanzado:

### git merge

  Fusiona el historial de la rama especificada con la rama actual.

### git reset

  Se usa para deshacer los cambios locales en el estado de un repositorio de Git.

### git stash

  Se usa para guardar los cambios realizados que no están listos para enviarlos a un repositorio.

  Esto dará un directorio de trabajo limpio. Por ejemplo, cuando se trabaja en una nueva función que no está completa, pero un error urgente necesita atención.

### git cherry-pick

  Hoy en día, los desarrolladores trabajan en múltiples ramas como características, mejoras, errores, etc.

  Hay situaciones en las que solo es necesario seleccionar un par de commits específicos y no fusionar toda la rama en otra rama. Para ello se usa Cherry-Pick.

### git log

  Muestra el historial cronológico de commits de un repositorio.

### git rebase

  Permite cambiar fácilmente una serie de commits, modificando el historial de su repositorio. Normalmente, lo uso para editar, combinar, eliminar o revertir commits.

### git diff

  Rastrea las diferencias entre los cambios realizados en un archivo.

### merge vs rebase

  Rebase y Merge tienen el mismo propósito. Están diseñados para integrar cambios de una rama a otra. Aunque los principios de funcionamiento son diferentes.

  Digamos que tenemos una rama Master con cambios. Luego, nos ramificamos en una rama Feature y hacemos cambios adicionales.

  Al fusionar los cambios de Feature a Master, Feature agrega todos los cambios de la rama a Master. Esto dará una representación precisa del historial, además de obtener todos los cambios combinados en Master.

  Pero, si tenemos varias ramas, el gráfico se vuelve más difícil de leer al fusionar todas las ramas.

  Aquí es donde el rebase sirve como una alternativa útil para un gráfico más limpio. Rebase toma los commits de una rama y las coloca en otra rama. Cambia la estructura del árbol moviendo los commits y cambios a la rama de destino.

  Al compararlos…

  Rebase:
  Crea un historial más limpio
  Gráfico más legible
  Más difícil de resolver conflictos
  Merge:
    Conserva el historial
    Más fácil de resolver conflictos
    Más fácil de deshacer si comete un error
    Caza de bugs con Git Bisect

    Cuántas veces ha sucedido que eso que estaba funcionando la semana pasada ya no funciona. ¿Pero por qué no?

    A veces, un cambio de otra parte del código afecta su función de una manera inesperada.

    Tienes que pasar tiempo revisando el historial donde hay muchas commits que requieren mucho tiempo y son difíciles de rastrear.

    Pero, tiene que haber una manera mejor que mirar a ciegas los mensajes de commits, ¡y la hay!

### Git Bisect

  Con este comando puedes encontrar el commit exacto cuando se introdujo el error, ya que ejecuta una búsqueda binaria en el código base para ayudarte a identificar más rápidamente el commit que introdujo un problema.

  Con Git bisect, debes elegir dos commits, una buena y otra mala. Ejecuta tu código para ver si puede reproducir el error.

  Si puedes, usa git bisect bad para decirle a git que el commit está rota. Si no puedes reproducir el error, utiliza git bisect good para dar esa información a git.

  Para omitir un commit, puedes hacerlo con git bisect skip.

### Qué es y cómo usar .gitignore

  A menudo, cuando trabaja en un proyecto con Git, desea evitar que ciertos archivos o directorios se transfieran al repositorio remoto, como, por ejemplo, archivos de sistema ocultos, archivos con información confidencial y configuraciones de IDE personales.

  Con .gitignore esto se resuelve fácilmente. Este archivo contiene una lista de archivos y carpetas con un formato especial que la aplicación de control de fuente debe ignorar.
