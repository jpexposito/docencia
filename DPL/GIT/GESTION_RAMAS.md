<div align="justify">

# GESTION DE RAMAS EN GIT

 __Perderse por las ramas en Git es fácil.__


 Con Git es muy común y sencillo crear ramas para desarrollar las diferentes funcionalidades y versiones de nuestra aplicación. Sin embargo, esta facilidad para crear ramas puede llevar al repositorio al caos más absoluto si son creadas sin ningún criterio y sin ningún flujo de información detrás que las sustente.

 __CHISTE MALO:__ _«No te andes por las ramas»_

 Para que todos en un equipo sigamos una misma dirección a la hora de gestionar el código de cada proyecto, el paso de los años me ha llevado a identificar unas pautas y buenas prácticas a seguir basadas en GitFlow que te mostraré a continuación. Aquí __No he reinventado la rueda__. __No obstante__, _se  puede (y debe) adaptarse dependiendo de las necesidades y particularidades de cada proyecto_.

## Flujo de trabajo general para el control de versiones

 El flujo de trabajo que aquí defino es un flujo de trabajo general que puede ser adaptado en función de las necesidades y particularidades de cada proyecto.

 La idea principal de este flujo es que el código de cada proyecto se organiza en base a dos ramas principales:
   - master: cualquier commit que pongamos en esta rama debe estar preparado para subir a producción.
   - dev: rama en la que está el código que conformará la siguiente versión planificada del proyecto.


 Cada vez que se incorpora código a master, tendremos una nueva versión de nuestra aplicación.

 Adicionalmente a estas ramas principales, en el ciclo de vida del proyecto jugaremos con las siguientes ramas auxiliares y no otras:
   - __feature__.
   - __release__.
   - __hotfix__.


 Cada una de estas ramas tiene sus propias reglas, que intentaré resumir a continuación paso a paso.

## Inicialización del repositorio

 Para __inicializar__ un repositorio ejecutaremos los siguientes comandos en un terminal:

  ```console
  git init
  git commit --allow-empty -m "Initial commit"
  git checkout -b dev master
  ```

 Los comandos anteriores nos crearán un repositorio local con las ramas master y dev. Ahora podemos integrarlo con un repositorio remoto ejecutando:

```console
git remote add origin https://server/namespace/project.git
```

 El estado del repositorio debe ser como el que se muestra en la siguiente imagen:

<div align="center">
  <img src="https://j2logo.com/wp-content/uploads/git-ramas-principales.jpg" alt="Ramas principales de Git" >
</div>


## Integrando una nueva funcionalidad en el proyecto

Los desarrollos de __nuevas funcionalidades__ (_evolutivos_) y __bugfixes__ (_errores_) planificados se realizan sobre ramas __feature__:


<div align="center">
  <img src="https://j2logo.com/wp-content/uploads/git-ramas-principales.jpg" alt="Ramas feature en Git" >
</div>

_Las reglas para estas ramas son_:
  - Normalmente, estas ramas existen únicamente en los repositorios locales de cada desarrollador aunque, si la funcionalidad se desarrolla entre varias personas, la rama puede existir en el repositorio remoto. También puede existir en el repositorio remoto como copia de seguridad si el desarrollo se prolonga por varios días.
  - Siempre se originan a partir de la rama dev.
  - Se incorporan siempre a la rama dev y solo cuando se dan por terminadas.
  - Las nombraremos como feature/<issue_id>[-short_description], donde issue_id es el identificador de la incidencia del gestor de proyectos que usemos.

 Los comandos para gestionar todo el ciclo son:

```console
# Crear la rama a partir de dev
git checkout -b feature/<issue_id>[-short_description] dev
# Compartir la rama (en caso necesario)
git checkout feature/<issue_id>[-short_description]
git push origin feature/<issue_id>[-short_description]
# Finalizar una rama Feature
git checkout dev
git pull origin dev
git merge --no-ff feature/<issue_id>[-short_description]
git branch -d feature/<issue_id>[-short_description]
git push origin dev
# Si se compartió la rama en el servidor
git push origin :feature/<issue_id>[-short_description]
```
Es importante la opción __--no-ff__ para que quede constancia en la rama dev de todos los commits que se hicieron en la rama __feature__.

‼️ También es importante recordar eliminar la rama una vez que ha sido incorporada a dev, tanto en local como en origin.

### Release branches

 Cuando ha llegado la hora de lanzar una nueva __release__, se crea una rama __release__.

 El código de esta rama se debe desplegar en un entorno de test adecuado, se prueba y cualquier problema se soluciona directamente en dicha rama. Este proceso de __prueba > bugfix > prueba >…__ se repite hasta que el código sea lo suficientemente bueno como para lanzarlo (__desplegarlo en un entorno de explotación__).

 Cuando finaliza la versión, la rama _release_ se fusiona con _master_ y _dev_, para asegurarnos de que cualquier cambio realizado no se pierda accidentalmente por un nuevo desarrollo.

  <div align="center">
    <img src="https://j2logo.com/wp-content/uploads/git-ramas-release.jpg" alt="Ramas release en Git" >
  </div>


 Las normas de estas ramas son:
  - Se originan a partir de la rama dev.
  - Se incorporan a _master_ y _dev_ una vez que el código está probado y listo para la siguiente versión.
  - Las nombraremos __release/x.y.z__
  - Se etiqueta la rama master con la nueva versión.

 Los comandos para gestionar todo el ciclo son:
```console
  # Crear la rama a partir de dev
  git checkout -b release/x.y.z dev
  # Compartir la rama (en caso necesario)
  git checkout release/x.y.z
  git push origin release/x.y.z
  # Finalizar una rama Release
  git checkout master
  git pull origin master
  git merge --no-ff release/x.y.z
  git tag -a x.y.z
  git checkout dev
  git pull origin dev
  git merge --no-ff release/x.y.z
  git branch -d release/x.y.z
  git push origin master
  git push origin dev
  git push origin --tags
  # Si se compartió la rama
  git push origin :release/x.y.z
```

‼️ Es importante recordar eliminar la rama una vez que
ha sido incorporada a dev y master, tanto en local como en origin.

### Hotfixes

 Las ramas __hotfix__ se utilizan para corregir fallos urgentes e imprevistos directamente del código de producción. Una vez corregido el código, los cambios son incorporados a las ramas _master_ y _dev_:

#### Ramas hotfix en Git

 Las normas para estas ramas son:
 - La creación de estas ramas no está planificada.
 - Se originan a partir de la rama master.
 - Se incorporan a las ramas master y dev.
 - Las nombraremos __hotfix/<issue_id>[-short_description]__, donde __issue_id__ (_por ejemplo los issus en github_) es el identificador de la incidencia del gestor de proyectos que usemos.

 Los comandos para gestionar todo el ciclo son:

```console
  # Crear la rama a partir de una versión de master
  git checkout -b hotfix/x.y.z [commit-id]
  # Finalizar una rama Hotfix
  git checkout master
  git pull origin master
  git merge --no-ff hotfix/x.y.z
  git tag -a x.y.z
  git checkout dev
  git pull origin dev
  git merge --no-ff hotfix/x.y.z
  git branch -d hotfix/x.y.z
  git push origin master
  git push origin dev
  git push origin --tags
```

 Este tipo de versionado (_x.y.z_) se conoce como versionado semántico, y puedes obtener algo más de información [aquí](..(/../../comun/SEMANTICO.md)).

<div align="center">
  <img src="https://j2logo.com/wp-content/uploads/git-ramas-hotfix.jpg" alt="Hotfix en Git" >
</div>  

‼️ Es importante recordar eliminar la rama una vez que ha sido incorporada a dev y master, tanto en local como en origin.

<div align="center">
    <a href="OPERACIONES_ESENCIALES.md"><img src="../../img/before.png" alt="Operaciones esenciales" style="width:42px;height:42px;"></a>
    <a href="README.md"><img src="../../img/home.png" alt="XML Home" style="width:42px;height:42px;"></a>
    <a href="HISTORIA.md"><img src="../../img/next.png" alt="History" style="width:42px;height:42px;">
</div>

</div>
