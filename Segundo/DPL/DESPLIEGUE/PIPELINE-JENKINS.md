<div align="justify">

# Fundamentos de un Pipeline Jenkins

<div align="center">
  <img src="https://www.maquinasvirtuales.eu/ipsoapoo/2021/05/devops-integracion-continua-y-pipeline-1050x525.png" width="500px" />
</div>

## Introducción

Un __Pipeline Jenkins__ es la clave para el despliegue continuo en esta herramienta open source

___¿sabes cómo funciona?___

Una de las ventajas sobre DevOps es el hecho de ___realizar despliegues de forma automática___.

Para poder realizar esos despliegues, _se debe configurar un pipeline, que definirá el ciclo de vida de tu aplicación desde que descargas el código de repositorio, hasta que despliegas en el entorno que necesites_.

Los pipelines no son nuevos, llevamos años utilizándolos.

## Qué es un Pipeline Jenkins

  Un ___pipeline Jenkins___ es un ___conjunto de plugins___ que soporta la implementación e integración de pipelines (tuberías) de despliegue continuo en Jenkins.

  ___Un pipeline es un conjunto de instrucciones del proceso que siga una aplicación desde el repositorio de control de versiones hasta que llega a los usuarios___.

  _Cada cambio en tu software, lleva a un complejo proceso hasta que es desplegado_.

  Este proceso incluye desde construir software de forma fiable y repetible (conocido como __“build”__), hasta realizar todos los pasos de __testing__ y __despliegues necesarios__.

  _Un pipeline Jenkins provee un gran conjunto de herramientas para dar forma con código a un pipeline de entrega de la aplicación_.

  <div align="center">
    <img src="https://i0.wp.com/oscarmoreno.com/wp-content/uploads/2019/10/Jenkins-Pipeline.png?w=1552" width="500px" />
  </div>

  </br>

  La definición de un pipeline Jenkins, se escribe en un fichero de texto (llamado Jenkinsfile) que se puede subir al repositorio junto con el resto del proyecto de software.

  Ésta es la base del “__Pipeline como código__”: tratar el pipeline de despliegue continua como parte de la aplicación para que sea versionado y revisado como cualquier otra parte del código.

  _Para crear el código de ese Jenkinsfile, se hace uso de una sintaxis propia que puedes consultar aquí_.

  La creación de un Jenkinsfile y su subida al repositorio de control de versiones, otorga una serie de inmediatos beneficios:

  - Crear automáticamente un pipeline de todo el proceso de construcción para todas las ramas y todos los pull request.
  - Revisión del código en el ciclo del pipeline.
  Auditar todos los pasos a seguir en el pipeline
  - Una sencilla y fiable fuente única, que puede ser vista y editada por varios miembros del proyecto.
  - Aunque la sintaxis para definir un pipeline Jenkins es igual, tanto a través de la interfaz web como con un Jenkinsfile, generalmente se considera como una mejor práctica realizarlo de la segunda forma y subirlo al repositorio.


## Tipos de sintaxis para un pipeline Jenkins

  Un _Jenkinsfile_ puede ser escrito usando dos tipos de sintaxis: Declarative (declarativa)  o Scripted (guionizada).

  Ambos tipos se construyen de forma diferente.

  Un pipeline declarative es una característica reciente en un pipeline Jenkins que:

  - Provee unas características sintácticas más completas que sobre las de tipo scripted.
  - Está hecho para que tanto su escritura como lectura sean más sencillas.


  Muchos de los componentes individuales de un Jenkinsfile, llamados pasos (steps), a menudo, son iguales en ambas sintaxis.

  Después te enseñaré con más detalle las diferencias entre los dos tipos.

### ¿Por qué utilizar un Pipeline Jenkins?

  Jenkins es, sobretodo, una herramienta que soporta patrones de automatización.

  Un Pipeline Jenkins añade un potente conjunto de herramientas de automatización que, soporta casos de uso que van desde una simple integración continua, hasta exhaustivos pipelines de entrega continua.

  Dando forma a una serie de tareas relacionadas, los usuarios pueden aprovechar muchas de las características de un pipeline, cómo por ejemplo:

  - __Código__: los Pipelines Jenkins se implementan en el código y suelen incorporarse al proyecto a través del sistema de control de versiones, facilitando a los equipos la habilidad para editar y revisar a través de su pipeline.
  - __Durable__: Los pipelines, perduran tanto a los reinicios planificados como a los no planificados del servidor de Jenkins.
  - __Pausable__: Opcionalmente, pueden parar y esperar la intervención o la aprobación de una persona, antes de continuar su ciclo.
  - __Versátil__: Soportan complejos requisitos de despliegue continuo, incluyendo la habilidad de hacer forks, loops, o realizar trabajo en paralelo.
  - __Extensible__: Además, también soporte extensiones personalizadas de su lenguaje específico de dominio, así como múltiples opciones para la integración con otros plugins.


  Mientras que Jenkins siempre ha permitido formas rudimentarias de enlazar jobs para realizar tareas secuencialmente, los Pipelines Jenkins hacen de este concepto algo mucho más destacable.

  Aquí puedes ver un ejemplo de escenario de despliegue continuo configurable en un Pipeline Jenkins.

  <div align="center">
    <img src="https://i1.wp.com/oscarmoreno.com/wp-content/uploads/2019/10/Pipeline-min.png?w=1322" width="500px" />
  </div>
  </br>

### Conceptos más importantes

  - __Pipeline__: Modelo definido por un usuario de un proceso de despliegue continuo
  - __Node (nodo)__: Máquina que es parte del entorno de Jenkins y es capaz de ejecutar un Pipeline Jenkins
  - __Stage (etapa)__: Subconjunto de tareas que se realizan a través de todo el ciclo del pipeline (Construir, Probar, Desplegar, etc…), que es utilizado por varios plugins para visualizar o mostrar el estado y progreso del proceso.
  - __Step (paso)__: Cada una de las tareas que componen una etapa. Básicamente, cada paso le dice a Jenkins, que hacer en cada uno de los puntos concretos del ciclo a realizar.

## Sintaxis de un Pipeline Jenkins

  Éstas son las diferencias entre los dos tipos de sintaxis, la de los Declarative Pipelines, y la de los Scripted Pipelines.

  Ten en cuenta que tiene elementos comunes que pueden ser fácil de confundir.

### Fundamentos de los Declarative Pipelines

  Éste sería un ejemplo:

```
  pipeline {
      agent any    
      stages {
          stage('Construir') {  
              steps {
                  //  
              }
          }
          stage('Probar') {  
              steps {
                  //  
              }
          }
          stage('Desplegar') {  
              steps {
                  //  
              }
          }
      }
```

  En este Pipeline podemos destacar los siguientes elementos:
  - __agent any__ : Esto indica que el pipeline se ejecutará en cualquiera de los nodos.
  - __stage(‘Construir’)__: Define la etapa para “Construir”
  - __//__ : Esta parte contiene cada uno de los pasos a realizar en la etapa de “Construir”
### Fundamentos de los Scripted Pipelines.

  En los Pipelines Scripted, one o más de los bloques del nodo hacen el trabajo principal a través de todo el ciclo. Aunque no es un requisito imprescindible, al encerrar las tareas en el bloque del nodo se consiguen dos cosas:
  - __Programar los pasos del bloque para ejecutarse añadiendo un elemento a la cola de trabajo de Jenkins__. Tan pronto como haya una ejecución disponible en un nodo, los pasos se ejecutarán.
  - __Crear un workspace (un directorio específico para un Pipeline particular) donde las tareas se pueden realizar sobre los ficheros descargados del repositorio__. Ten en cuenta que dependiendo de la configuración de Jenkins, algunos workspaces no se limpian automáticamente después de un periodo de inactividad.
  Y aquí puedes ver un ejemplo de un Scripted Pipeline:

  ```
  node {
      stage(‘Construir’) {
           //
      }
      stage(‘Probar’) {
           //
      }
      stage(‘Deploy’) {
           //
      }
  }
  ```

  En este caso, lo más destacable sería:
  - __node__: Esto indica que el pipeline se ejecutará en cualquiera de los nodos.
  - __stage(‘Construir’)__: Define la etapa de __‘Construir’__. Este bloque es opcional en los __Scripted Pipelines__, pero, facilitará la lectura de cada una de las fases y tareas a seguir en la interfaz de Jenkins.
  - __//__: Esta parte contiene cada uno de los pasos a realizar en la etapa de “Construir”.

  Un ejemplo más complejo sería:

  <div align="center">
    <img src="https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/07/4.png" width="500px" />
  </div>

### Tipos de Pipeline en Jenkins

Existen dos tipos de definición de Pipelines en Jenkins:
- Declarando el fichero _Jenkinsfile_, que contiene el Pipeline.
- Declarando el Pipeline en el mismo proyecto de Jenkins.

Los pasos para realizarlo son:
1. Creación de __Pipeline__
<div align="center">
  <img src="https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/07/seven.png" width="500px" />
</div>

2. Define el nombre de __Pipeline__
<div align="center">
  <img src="https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/07/eight.png" width="500px" />
</div>
3. Selecciona el tipo de __Pipeline__
<div align="center">
  <img src="https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/07/nine.png" width="500px" />
</div>
4. Definición del __Pipeline__ dentro de __Jenkins__.
<div align="center">
  <img src="https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/07/ten.png" width="500px" />
</div>
4. Obtención del __Pipeline__ en el proyecto __Git__ a través del fichero __Jenkinsfile__.
<div align="center">
  <img src="https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/07/eleven.png" width="500px" />
</div>
5. Configuración del __Pipeline__ en el proyecto __Git__ a través del fichero __Jenkinsfile__.
<div align="center">
  <img src="https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2018/07/twelve.png" width="500px" />
</div>


#### Ejemplo de un Pipeline Jenkins

  Aquí puedes ver un ejemplo más completo de un Pipeline Jenkins, utilizando la sintaxis declarativa.

```
   pipeline {  
      agent any  
      options {
          skipStagesAfterUnstable()
      }
      stages {
          stage('Construir') {  
              steps {  
                  sh 'make'  
              }
          }
          stage('Probar'){
              steps {
                  sh 'make check'
                  junit 'reports/**/*.xml'  
              }
          }
          stage('Desplegar') {
              steps {
                  sh 'make publish'
              }
          }
      }
  }  
```

##### Ejemplo de un Pipeline Jenkins en distintos lenguajes

  A continuación a vamos a realizar la construcción de distintos __Pipeline__ en algunos de los lenguajes que podemos trabajar.

###### Java Jenkinsfile (Declarative Pipeline)

  ```
  pipeline {
      agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }
      stages {
          stage('build') {
              steps {
                  sh 'mvn --version'
              }
          }
      }
  }
  ```

###### Node.js / JavaScript Jenkinsfile (Declarative Pipeline)

  ```
  pipeline {
      agent { docker { image 'node:16.13.1-alpine' } }
      stages {
          stage('build') {
              steps {
                  sh 'node --version'
              }
          }
      }
  }
  ```

###### Ruby Jenkinsfile (Declarative Pipeline)

  ```
  pipeline {
      agent { docker { image 'ruby:3.0.3-alpine' } }
      stages {
          stage('build') {
              steps {
                  sh 'ruby --version'
              }
          }
      }
  }
  ```

###### Python Jenkinsfile (Declarative Pipeline)

  ```
  pipeline {
      agent { docker { image 'python:3.10.1-alpine' } }
      stages {
          stage('build') {
              steps {
                  sh 'python --version'
              }
          }
      }
  }
  ```

###### PHP Jenkinsfile (Declarative Pipeline)

  ```
  pipeline {
      agent { docker { image 'php:8.1.0-alpine' } }
      stages {
          stage('build') {
              steps {
                  sh 'php --version'
              }
          }
      }
  }
  ```

###### Go Jenkinsfile (Declarative Pipeline)

  ```
  pipeline {
      agent { docker { image 'golang:1.17.5-alpine' } }
      stages {
          stage('build') {
              steps {
                  sh 'go version'
              }
          }
      }
  }
  ```




## Referencias
  - [Pipelines en Jenkins](https://www.jenkins.io/doc/book/pipeline/).
  - [Ejemplos de Pipeline](https://www.jenkins.io/doc/pipeline/tour/hello-world/).

</div>
