# Comenzando con GIT

<div align="justify">

<div align="center">
  <img src="https://git-scm.com/images/logo@2x.png" >
</div>

## Configuración

  Aunque podríamos editar directamente el fichero ~/.gitconfig (Dependiendo del sistema operativo), los siguientes comandos nos facilitarán la configuración.

### Identidad

```console
  git config --global user.name "John Doe"
  git config --global user.email johndoe@example.com
```

### Editor

```console
  git config --global core.editor vim
```

### Herramienta de diferencias

```console
  git config --global merge.tool vimdiff
```

## Comandos básicos

### git clone (Sólo una vez)

  El primer paso es traernos el repositorio a nuestro equipo con git clone. Este comando sólo se ejecuta una vez, una vez ya tengamos el repositorio en nuestro equipo ya no será necesario ejecutarlo más, sólo tendremos que ejecutar el siguiente comando, git pull, para descargarnos los cambios del repositorio remoto con el nuestro.


### git pull

  Recibir los cambios del repositorio remoto. Es conveniente ejecutar este comando andes de realizar ningún cambio en el código para evitar conflictos.

### git status

  Ver el estado del repositorio, que ficheros se han añadido, eliminado o modificado.

### git add

  Añadir los ficheros que hayan sufrido algún cambio (nuevos, modificados o eliminados) a la fase de preparación o stage.

### git commit

  Este comando es para confirmar los cambios. Para ello deberemos especificar un mensaje que resuma los cambios que hayamos hecho en los ficheros. Si ejecutamos el comando con la opción -m, podremos especificar el mensaje directamente como tercer parámetro, sino, abrirá el editor que hayamos configurado para redactarlo.

### git push

  Subir los cambios al repositorio remoto. Debemos especificar a que servidor remoto y que en rama queremos subilos. git push origin master. Con el parámetro -u, indicaremos que ese es el server y la rama por defecto si no los especificamos. git push -u origin master.

```console
  git clone git://github.com/user/project.git
  touch README
  touch main.c
  touch help.txt
  git status
  # On branch master
  # Untracked files:
  #   (use "git add &lt;file&gt;..." to include in what will be committed)
  #
  #   README
  nothing added to commit but untracked files present (use "git add" to track)
  git add *.c
  git add README
  git add .
  git commit –m 'Added README, c and files'
  git push -u origin master

```

## ¿Que pasa si tenemos nuestro código en local y queremos crear un repositorio?

  Si tenemos un proyecto en local y queremos controlar los cambios con el repositorio sólo tendremos que ejecutar el comando git init. Al ejecutar este comando, para nuestro repositorio todos los ficheros serán nuevos, tendremos que añadirlos y confirmar los cambios:

```console
  git init
  git add .
  git commit -m "initial commit"
```
## Como centralizar el código para compartirlo

### ¿Que pasa si tenemos nuestro repositorio en local y queremos centralizarlo en nuestro propio servidor?

#### En el servidor

```console
  mkdir project.git
  cd project.git
  git init --bare
```

#### En nuestra carpeta

```console
  git remote add origin user@server:/path/to/the/project.git
  git push -u origin master
```


</div>
