<div align="justify">
  
# Ejemplo de construcción de fichero .gitignore

  Si mantenemos un repositorio de archivos bajo el control de versiones de git, un buena práctica es crear y configurar un archivo __.gitignore__ adecuadamente para mantener el repositorio “limpio y ordenado”.

## ¿Qué hace exactamente un archivo .gitignore y para qué sirve? 
  
  A grandes rasgos y simplificando mucho, la herramienta git, lleva un histórico de las modificaciones realizadas en un conjunto de archivos, guardando información sobre qué y quien realizó las modificaciones.

## ¿Qué es un archivo .gitignore? 
  
  Es un archivo de texto plano, donde especificamos aquellos archivos o carpetas que queremos que git no tenga en cuenta y no almacene las modificaciones que se han realizado sobre ellos durante el tiempo.

## ¿Y por qué queremos hacer eso?
  
  Porque puede ocurrir que durante nuestro manejo de esos archivos se creen archivos secundarios que se crean por herramientas externas, que no son relevantes y que su información es cambiante con el tiempo y no nos aporta nada.

Por ejemplo, quizás en nuestro repositorio debido a la herramienta que utilizamos, se generan archivos temporales, archivos logs, o similares que no nos sirven para nada y sobre los que no queremos tener control de versiones.

Al editar archivos de nuestro repositorio, quizás el editor que utilizamos genera archivos temporales de recuperación, quizás se generen bases de datos temporales, que tampoco queremos que git les siga el rastro.

Todos esos casos y muchos más se pueden especificar dentro del archivo .gitignore y así indicarle a git que se ahorre el trabajo de controlar esos archivos.

Como verás siempre he escrito .gitignore, con un punto delante del nombre, eso en GNU/Linux indica que es un archivo oculto.
Para crear un archivo .gitignore simplemente escribiremos en una línea de comandos, dentro de la carpeta de nuestro repositorio git. Un buen ejemplo para este fichero es el siguiente:

```console
##############################
## Java
##############################
.mtj.tmp/
*.class
*.jar
*.war
*.ear
*.nar
hs_err_pid*

##############################
## Maven
##############################
target/
pom.xml.tag
pom.xml.releaseBackup
pom.xml.versionsBackup
pom.xml.next
pom.xml.bak
release.properties
dependency-reduced-pom.xml
buildNumber.properties
.mvn/timing.properties
.mvn/wrapper/maven-wrapper.jar

##############################
## Gradle
##############################
bin/
build/
.gradle
.gradletasknamecache
gradle-app.setting
!gradle-wrapper.jar

##############################
## IntelliJ
##############################
out/
.idea/
.idea_modules/
*.iml
*.ipr
*.iws

##############################
## Eclipse
##############################
.settings/
bin/
tmp/
.metadata
.classpath
.project
*.tmp
*.bak
*.swp
*~.nib
local.properties
.loadpath
.factorypath

##############################
## NetBeans
##############################
nbproject/private/
build/
nbbuild/
dist/
nbdist/
nbactions.xml
nb-configuration.xml

##############################
## Visual Studio Code
##############################
.vscode/
.code-workspace

##############################
## OS X
##############################
.DS_Store
```

</div>  
  
