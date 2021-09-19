# Operaciones esenciales y avanzadas en GIT

<img width="50%" src="https://yosoy.dev/wp-content/uploads/2014/08/local-remote.png" alt="Top respositorio de codigo">


# Operaciones esenciales y avanzadas en GIT

## Introducción

 En este capitulo vamos a tratar distintas operaciones en git. Inicialmente comenzaremos con los comandos básicos, para familiarizarnos, para continuar con comandos más avanzados.


## Operaciones esenciales 


### git init

 Con este comando le indicamos que el directorio donde nos encontremos comenzará a ser versionado bajo GIT.

__Ejemplo de uso__:

```
 Ejemplo de uso
```

###  git status

 Con este comando veremos el estado actual de nuestra carpeta versionada, así como archivos que no están versionados, archivos modificados, archivos eliminados, etc., como veras este comando será de gran ayuda de ahora adelante.

__Ejemplo de uso__:


```
 Ejemplo de uso
```

 Los mensajes que podremos ver con este comando pueden ser los siguientes:

 Untracked files: nos mostrará todos los archivos que no han sido agregados al repositorio aun.
 Changes to be committed: nos indica que archivos serán agregado a nuestro commit

### git add

 Este comando nos ayuda a agregar nuestros archivos que no esta bajo versionamiento (los Untracked files que vimos anteriormente).

__Ejemplo de uso__:

```
 Ejemplo de uso
```

### git commit -m «mensaje»

 Este comando es muy importante ya que es el que da comienzo al seguimiento de nuestros archivos que hayamos agregado con el comando «git add», como podemos ver con el parámetro -m le indicamos un mensaje, el cual debe describir en pocas palabras la razón del commit.

__Ejemplo de uso__:

```
 Ejemplo de uso
```

### git remote add origin url_del_repositorio

 Como si fuera poco, hasta ahora todos nuestros comandos vistos (1 al 4) han sido puro trabajo local, con el comando git remote add agregamos nuestro repositorio a un servidor remoto, y como lo hacemos bueno debemos de tener ya creado nuestro repositorio git en un servidor y este nos brindará la url, un ejemplo sería: git@github.com:miurl/mi_repositorio.git (Ejemplo:)

__Ejemplo de uso__:

```
 Ejemplo de uso
```

### git push -u origin master

 Con este comando empujamos todo lo que tengamos en nuestros commits al repositorio remoto, para este caso a: git@github.com:miurl/mi_repositorio.git

__Ejemplo de uso__:

```
 Ejemplo de uso
```

Con este comando tenemos que tener en cuenta que nuestra llave publica debe de estar agregada en el servidor remoto.

### git pull

 Este comando nos baja los cambios que haya trabajado otra persona en el mismo repositorio, es recomendable siempre que trabajemos con un respositorio que no hayamos iniciado nosotros hacer siempre un git pull primero antes de comenzar a trabajar en los archivos.

__Ejemplo de uso__:

```
 Ejemplo de uso
```

 Como vemos en la imagen se había agregado el archivo README.md, por lo tanto este fue bajado a nuestra versión local del repositorio.

### git remote -v

 Con este comando podemos ver la url remota del repositorio en el que nos encontremos.

__Ejemplo de uso__:

```
 Ejemplo de uso
```

### git clone url_del_repositorio nombre_local

 Si queremos hacer una copia en nuestro directorio local de un repositorio existente usaremos este comando como lo mostramos a continuación:

__Ejemplo de uso__:

```
 Ejemplo de uso
```

### git branch –all

<img width="50%" src="https://gitbookdown.dallasdatascience.com/img/git_branch_merge.png" alt="fork">

 En git se trabaja con branches (ramas en español), originalmente se crea la rama master por defecto, a raíz de esto nosotros podemos crear nuestras propias ramas branch, siendo claro una copia de la rama master en primera instancia, dicho esto con el comando git branch –all podemos ver todas las ramas que tenga el proyecto.

```
 Ejemplo de uso
```
