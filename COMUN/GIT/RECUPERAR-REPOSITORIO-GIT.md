<div align="justify">

# RECUPERAR UN REPOSITORIO EN GIT


  <div align="center" >
   <img src="https://www.todomecanica.com/images/blog/2016/febrero/mecanico-automotriz.jpg" width="400px">
  </div>

  </br>

  Supongamos que estamos trabajando sobre un repositorio, por ejemplo [libro](https://github.com/jpexposito/libro). Para ello hemos realizado un clonado.

  ```console
    git clone https://github.com/jpexposito/libro
  ```

  Una vez realizado el clonado hemos realizado los distintos cambios dentro de la carpeta __libro__ que aloja todo el contenido del repositorio.

  Si se produce un error cuando vamos a realizar el respectivo __push__:


  ```console
    error: bad index file sha1 signature
    fatal: index file corrupt
  ```

  Vamos a resolver el problema.

## Eliminar el indice y restear

  El problema más común es que por algún motivo existan problemas con el indice del repositorio. Para ello vamos a ejecutar los siguientes comentados:

  ```console
  cd libro
  rm -f .git/index
  git reset
  git add .
  git commit -m "mensaje"
  git push
  ```

## Eliminar el directorio .git

  Si la solución anterior no ha funcionado debemos de realizar:

  ```console
  mv  libro libro_backup
  git clone https://github.com/jpexposito/libro
  cd libro_backup
  rm -rf .git
  cp -rf ../libro/.git .
  git add .
  git commit -m "comentario"
  git push
  ```

  En este momento deberemos tener todos los cambios subidos. Ahora ejecutaremos:

  ```console
  cd ..
  cd libro
  git pull
  ```  

  Con estos últimos cambios hemos traído todos los cambios que tenemos en el repositorio en la nube, y los dos directorios actualizamos.
