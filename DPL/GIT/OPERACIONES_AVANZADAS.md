<div align="justify">

# OPERACIONES AVANZADAS EN GIT

<div align="center">
<img src="">
</div>

## Integrando un repositorio remoto

Para integrar un repositorio local con un repositorio remoto debes ejecutar el siguiente comando Git:

```console
git remote add origin <URL o PATH del repositorio remoto>

#Ejemplo:

 git remote add origin https://github.com/jpexposito/java.git
```

 La palabra origin no es obligatoria. Es el nombre con el que identificar al repositorio remoto (puedes añadir tantos repositorios remotos como quieras).

 También puedes hacer un checkout o clonar un repositorio remoto directamente. Esto te ahorrará el paso de crear el repositorio local, ya que se crea automáticamente y quedará conectado al repositorio remoto. Para ello ejecuta:

```console
git clone <URL o PATH del repositorio remoto>

#Ejemplo:

git clone https://github.com/jpexposito/java.git
```
❗️Recuerda configurar el nombre y el email con el que firmar los commits.

## Integrando los cambios en tu repositorio remoto

Cuando tu cambios en el repositorio local estén listos para ser integrados en el repositorio remoto, el comando a ejecutar es:

```console
git push origin <nombre_rama_local>
```
❗️Recuerda que origin es el nombre que le dimos al repositorio remoto.

## Comandos Git para crear ramas

Las ramas nos permiten trabajar en distintas funcionalidades a la vez y en distintas versiones de nuestra aplicación sin que los cambios afecten de unas a otras. Para saber más acerca de las ramas, puedes echar un ojo a la entrada en la que explico cómo trabajar con ramas.

Para crear una rama y situarte en ella ejecuta:

```console
git checkout -b <nombre_rama>
```
Si quieres cambiarte a otra rama existente:

```console
git checkout <nombre_otra_rama>
```

❗️Recuerda borrar una rama cuando ya no tengas que trabajar más en ella:

```console
git branch -d <nombre_rama>
```

## Fusionando el contenido de una rama en otra

Una vez que el trabajo en una rama secundaria de tu repositorio local ha terminado, debes integrar los cambios en una rama principal.

 __Ejemplo__:Vamos a realizar la mezcla de una rama feature a la rama dev. Para ello, debes hacer un merge de la rama feature desde dev de la siguiente manera:

```console
# Sitúate en dev
git checkout dev
# Ahora fusiona la rama feature-1
git merge feature-1
```

El comando para integrar los cambios del repositorio remoto a tu repositorio local es:

```console
 git pull
```
## Comandos Git para deshacer los cambios: revert

Es posible que en alguna ocasión los cambios realizados no sirvan y quieras volver a la versión anterior de un fichero. En ese caso, ejecuta:

```console
git checkout -- <nombre_fichero>
```

Para deshacer los cambios locales y commits y traer la última versión estable del repositorio remoto, los pasos son los siguientes:

```console
git fetch origin
git reset --hard <nombre_rama_remota>
# Ejemplo:
git reset --hard origin/dev
```

## Recomendaciones

 Los anteriores son los principales comandos Git que utilizarás en tu día a día a la hora de trabajar en tu repositorio. No obstante, sería recomendable utilizar una serie de recomendaciones y consejos para que tu repositorio no se líe ni pierdas el trabajo realizado:
  - Sigue este flujo para gestionar las ramas de tu repositorio.
  - Añade el fichero __.gitignore__ nada más crear tu repositorio local para no ensuciar el repositorio con ficheros innecesarios.
  - No incluyas en tu repositorio los ficheros de configuración de tu proyecto que crea el IDE de desarrollo.
  - Haz commits con regularidad en tu repositorio local (siempre y cuando el código esté limpio de fallos).
  - Solo integra tu repositorio local con el remoto (hacer un push) cuando el código esté realmente listo para compartir y libre de errores.
  - Para evitar conflictos en el repositorio, intenta seguir el flujo siguiente (es lo que a mí me ha funcionado):

```console
  # Clono de un repositorio remoto: Github, Gitlab, ...
  # Previamente he configurado este repositorio
  git clone <URL_repositorio_remoto>
  # Establezco los parámetros de mi usuario
  git config user.name "mi_nombre"
  git config user.email mi_usuario@gmail.com
  # Creo la rama dev a partir de master
  git checkout -b dev
  # Pusheo la rama dev en el repositorio remoto
  git push origin dev
  # Cuando tengo que desarrollar algo, creo la
  # rama correspondiente
  git checkout -b feature/feature_1
  # Voy haciendo commits sobre la rama feature_1
  # hasta que la funcionalidad está terminada
  git commit -m "Msg 1"
  git commit -m "Msg 2"
  # Cuando la funcionalidad está lista, la paso
  # a la rama dev. Para ello, me sitúo en dev
  git checkout dev
  # Actualizo la rama dev con posibles cambios
  # en el repositorio remoto
  git pull origin dev
  # Ahora sí, integro los cambios de la rama
  # feature_1 en la rama dev
  git merge --no-ff feature/feature_1
  # Pusheo la rama dev para que el resto del
  # equipo pueda ver los cambios
  git push origin dev
  # Borro la rama feature_1 porque ya no
  # me va a hacer falta
  git branch -d feature/feature_1
  ...
```
<div align="center">
    <a href="OPERACIONES_ESENCIALES.md"><img src="../../img/before.png" alt="Operaciones esenciales" style="width:42px;height:42px;"></a>
    <a href="README.md"><img src="../../img/home.png" alt="XML Home" style="width:42px;height:42px;"></a>
    <a href="HISTORIA.md"><img src="../../img/next.png" alt="History" style="width:42px;height:42px;">
</div>

</div>
