<div align="justify">

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
jpexposito@MacBook-Pro-de-Joatham Downloads % mkdir git_ejemplo
jpexposito@MacBook-Pro-de-Joatham Downloads % cd git_ejemplo 
jpexposito@MacBook-Pro-de-Joatham git_ejemplo % git init
ayuda: Usando 'master' como el nombre de la rama inicial. Este nombre de rama predeterminado
ayuda: está sujeto a cambios. Para configurar el nombre de la rama inicial para usar en todos
ayuda: de sus nuevos repositorios, reprimiendo esta advertencia, llame a:
ayuda: 
ayuda: 	git config --global init.defaultBranch <nombre>
ayuda: 
ayuda: Los nombres comúnmente elegidos en lugar de 'master' son 'main', 'trunk' y
ayuda: 'development'. Se puede cambiar el nombre de la rama recién creada mediante este comando:
ayuda: 
ayuda: 	git branch -m <nombre>
Inicializado repositorio Git vacío en /Users/jpexposito/Downloads/git_ejemplo/.git/
jpexposito@MacBook-Pro-de-Joatham git_ejemplo % 

```

###  git status

 Con este comando veremos el estado actual de nuestra carpeta versionada, así como archivos que no están versionados, archivos modificados, archivos eliminados, etc., como veras este comando será de gran ayuda de ahora adelante.

__Ejemplo de uso__:


```
 jpexposito@MacBook-Pro-de-Joatham git_ejemplo % git status
 En la rama master

 No hay commits todavía

 no hay nada para confirmar (crea/copia archivos y usa "git add" para hacerles seguimiento)
 jpexposito@MacBook-Pro-de-Joatham git_ejemplo % 
```

 Los mensajes que podremos ver con este comando pueden ser los siguientes:

 Untracked files: nos mostrará todos los archivos que no han sido agregados al repositorio aun.
 Changes to be committed: nos indica que archivos serán agregado a nuestro commit

### git add

 Este comando nos ayuda a agregar nuestros archivos que no esta bajo versionamiento (los Untracked files que vimos anteriormente).

__Ejemplo de uso__:

```
 jpexposito@MacBook-Pro-de-Joatham git_ejemplo % vi index.html
 jpexposito@MacBook-Pro-de-Joatham git_ejemplo % ls
  index.html
 jpexposito@MacBook-Pro-de-Joatham git_ejemplo % git add index.html 
 jpexposito@MacBook-Pro-de-Joatham git_ejemplo % git status        
 En la rama master

 No hay commits todavía

 Cambios a ser confirmados:
   (usa "git rm --cached <archivo>..." para sacar del área de stage)
	 nuevos archivos: index.html

 jpexposito@MacBook-Pro-de-Joatham git_ejemplo %
```

### git commit -m «mensaje»

 Este comando es muy importante ya que es el que da comienzo al seguimiento de nuestros archivos que hayamos agregado con el comando «git add», como podemos ver con el parámetro -m le indicamos un mensaje, el cual debe describir en pocas palabras la razón del commit.

__Ejemplo de uso__:

```
 jpexposito@MacBook-Pro-de-Joatham git_ejemplo % git commit -m "mi primer mensaje en git"
 [master (commit-raíz) a9a7835] mi primer mensaje en git
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 index.html
 jpexposito@MacBook-Pro-de-Joatham git_ejemplo % git status                              
 En la rama master
 nada para hacer commit, el árbol de trabajo está limpio
 jpexposito@MacBook-Pro-de-Joatham git_ejemplo % 
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
```

 Como vemos en la imagen se había agregado el archivo README.md, por lo tanto este fue bajado a nuestra versión local del repositorio.

### git remote -v

 Con este comando podemos ver la url remota del repositorio en el que nos encontremos.

__Ejemplo de uso__:

```
jpexposito@MacBook-Pro-de-Joatham git_ejemplo % git remote add update git@github.com:jpexposito/test.git
jpexposito@MacBook-Pro-de-Joatham git_ejemplo % git remote -v                                               
origin	git@github.com:jpexposito/test_git (fetch)
origin	git@github.com:jpexposito/test_git (push)
update	git@github.com:jpexposito/test.git (fetch)
update	git@github.com:jpexposito/test.git (push)
jpexposito@MacBook-Pro-de-Joatham git_ejemplo % 
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


<div align="center">
    <a href="INSTALACION.md"><img src="../../img/before.png" alt="Instalacion" style="width:42px;height:42px;"></a>
    <a href="README.md"><img src="../../img/home.png" alt="XML Home" style="width:42px;height:42px;"></a>
    <a href="OPERACIONES_AVANZADAS.md"><img src="../../img/next.png" alt="OPERACIONES AVANZADAS" style="width:42px;height:42px;"> 
</div>

</div>