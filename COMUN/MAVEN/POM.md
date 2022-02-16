# Explicación detallada del archivo pom.xml

<div align="justify">

<div align="center">
  <img src="https://javadesde0.com/wp-content/uploads/maven-project-structure.png" width="300px">
</div>


## ¿Qué es POM?

  __Project Object Model__, El modelo de objetos del proyecto. El archivo pom.xml guardado en el formato de lenguaje de marcado extensible xml (lenguaje de marcado extensible). La función es similar al archivo build.xml de ant, con funciones más potentes. Este archivo se utiliza para administrar: código fuente, archivos de configuración, información y roles del desarrollador, sistema de seguimiento de problemas, información de la organización, autorización del proyecto, URL del proyecto, dependencias del proyecto, etc.

  __Un archivo pom.xml completo, ubicado en el directorio raíz del proyecto__.

  ```xml
  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

  <modelVersion>4.0.0</modelVersion><!– The Basics –>

  <parent>…</parent>

  <groupId>…</groupId>
  <artifactId>…</artifactId>
  <version>…</version>

  <packaging>…</packaging>

  <name>…</name>

  <description>…</description>

  <url>…</url>

  <modules>…</modules>

  <dependencies>…</dependencies>

  <build>…</build>

  <developers>…</developers>

  <contributors>…</contributors>

  <repositories>…</repositories>

  <profiles>…</profiles>
</project>
  ```

## Configuración básica en maven

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                      http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>es.centrodocente</groupId>
    <artifactId>libreria-A</artifactId>
    <version>1.0.0</version>
    <packaging>war</packaging>
    <name>Libreria A </name>
    <url>www.jpexposito.com</url>
</project>
```

| Campo             | Descripción    |
|-------------------|-------------|
| modelVersion |	Declare qué versión del modelo POM sigue el descriptor del proyecto. La versión del modelo en sí rara vez se cambia, aunque sigue siendo esencial. Esto es para garantizar la estabilidad cuando Maven introduce nuevas funciones u otros cambios de modelo. |
| groupId | Por ejemplo, com.winner.trade, maven colocará el paquete jar del proyecto en la ruta local: / com / ganador / comercio |
| artifactId |	El ID único de este proyecto. Puede haber varios proyectos bajo un groupId, que se distinguen por artifactId. |
| version	| El número de versión actual de este proyecto |
| packaging	| Tipo de paquete, valores posibles: pom, jar, maven-plugin, ejb, war, ear, rar, par, etc.|
| name	| El nombre del proyecto, utilizado por la documentación generada por Maven, se puede omitir
| url	| La URL de la página de inicio del proyecto, utilizada por los documentos de Maven, se puede omitir |

### La relación entre POM

  _Las dependencias, son componentes que nuestro software necesitará para su correcta ejecución durante algún ciclo de vida. Si descargamos un proyecto y lo implementamos en nuestro sistema. Maven, obtendrá las dependencias del proyecto que son necesarias o bien desde el repositorio local, o bien desde un repositorio remoto_.

  Para declarar dependencias a la hora de crear un proyecto de Spring, tenemos dos opciones:

  Añadirlas directamente al __IDE__, de manera que si suministramos el proyecto a una tercera persona debemos de indicar las librerías y versiones de estas que utilizamos.

  Declararlas manualmente visitando el maven central repository (link a la maven central repository).

  En el caso que las añadamos de una manera o de otra las dependencias, el resultado final será el mismo, un fichero pom.xml. Que deberá contener un elemento root llamado __<dependencies></dependencies>__  que contendrá dependencias __<dependency></dependency>__ en su interior.

  Si por ejemplo quisiéramos añadir una dependencia y ya tenemos el proyecto creado (o las queremos añadir manualmente), vamos al mvnrepository, copiamos la dependencia y la añadimos dentro de nuestro elemento root dependencies.

  Un ejemplo de dependencia en __maven__:

  ```xml
  <dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>2.1.6.RELEASE</version>
    </dependency>
  </dependencies>
  ```

#### Elementos de una dependencia Maven

Las dependencias en Maven suelen tener:
- __dependency__: elemento contenedor padre que especifica que es una dependencia.
- __groudId__: puede no ser obligatorio dependiendo del caso aunque si se pone no pasa nada.
- __artifactId__: Es obligatorio definir el artifactId de una dependencia.
- __version__: Si no lo especificamos Maven cogerá la última versión o la que especifiquemos en el pom padre (superpom.xml). Si lo especificamos no está demás pero sino se especifica no pasa nada, siempre que esta dependencia no entre en conflicto con otras.

<div align="center">
  <img src="https://javadesde0.com/wp-content/uploads/maven-overview-1.png" width="400px">
</div>

</br>

#### Búsqueda de dependencias

  A la hora de buscar las dependencias de un proyecto, Maven, va al pom y comprueba primeramente si existen en el repositorio m2 (repositorio remoto). En caso de que allí no existan, irá al maven central repository (repositorio central) y las descargará en nuestro repositorio remoto (m2) para que se pueda utilizar en todos los repositorios locales (proyectos).

</br>

  <div align="center">
    <img src="https://javadesde0.com/wp-content/uploads/Screenshot_6-1.png" width="400px">
  </div>

</br>

  Para la próxima compilación, ya dispondrá de dicha dependencies dentro del depositorio remoto. Y por tanto, si cargamos un proyecto, este mirará en su repositorio local, no encontrará las dependencies e irá al repositorio remoto donde sí que las encontrará. De modo que, no será necesario descargarla otra vez del Maven Central Repository. Ya que esa dependencia la podemos satisfacer sin necesidad de contarnos a internet.

### Ubicación del Maven repository remote m2

</br>

<div align="center">
  <img src="https://javadesde0.com/wp-content/uploads/mavendependency.png" width="250px">
</div>

</br>

  El repositorio m2 (remote repositorio) por defecto está ubicado por defecto en directorio: __${user.home}/.m2/repository__
  - __Unix/Mac OS X__ – ~/.m2/repository.
  - __Windows__ – C:\Users\{your-username}\.m2\repository.

  Aunque la ruta varía dependiendo del sistema operativo que se utilice:

  </br>

<div align="center">
  <img src="http://www.avajava.com/tutorials/maven/what-is-maven-and-how-do-i-install-it/what-is-maven-and-how-do-i-install-it-09.gif" width="400px">
</div>

</br>

  Otra manera de ver es utilizar el comando:

  ```
  mvn help:evaluate -Dexpression=settings.localRepository
  ```

  Obteniendo algo similar a lo siguiente:

  ```
  [INFO] Scanning for projects...
  [INFO]
  [INFO] ------------------< org.apache.maven:standalone-pom >-------------------
  [INFO] Building Maven Stub Project (No POM) 1
  [INFO] --------------------------------[ pom ]---------------------------------
  [INFO]
  [INFO] --- maven-help-plugin:3.2.0:evaluate (default-cli) @ standalone-pom ---
  [INFO] No artifact parameter specified, using 'org.apache.maven:standalone-pom:pom:1' as project.
  [INFO]
  /Users/jpexposito/.m2/repository
  [INFO] ------------------------------------------------------------------------
  [INFO] ------------------------------------------------------------------------
  ```

  ___IMPORTANTE:Realmente estás dependencias Maven, no son nada más que archivos con extensión .jar___.

### Plugins

  Maven emplea un robusto conjunto de plugins que brindan toda su funcionalidad. En Maven, los plugins tienen metas, que según el técnico son solo métodos Java. Las metas ejecutan tareas de construcción como: compilar el proyecto, empaquetarlo e implementarlo en un servidor local o remoto. Esas actividades se correlacionan perfectamente para construir fases del ciclo de vida.

  Maven incluye sus plugins de construcción empaquetados y listos para usar, y los valores predeterminados son previamente configurados. La convención sobre la configuración asegura que la configuración se escale para la complejidad de la tarea dada. La mayor parte de las tareas de construcción requieren una configuración mínima.

  ```xml
  <plugin>
   <groupId>org.apache.maven.plugins</groupId>
   <artifactId>maven-compiler-plugin</artifactId>
   <version>3.6.1</version>
   <configuration>
       <source>1.8</source>
       <target>1.8</target>
   </configuration> </plugin>
  ```

</div>
