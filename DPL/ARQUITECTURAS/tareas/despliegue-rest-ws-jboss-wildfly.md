<div align="justify">

# Tarea: Instalación de servicios REST/WS Wildfly

<div align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/a/a3/Wildfly_logo.png"  />
</div>


  En esta tarea, instalaremos un servicio rest y otro soap en el contenedor de aplicaciones __Wildfly__.


## Requisitos previos

  Necesitará un servidor Ubuntu 20.04 con una cuenta de _superusuario_ no root.

  Además como requisito previo es necesario disponer de __Java__ instalado. Si no sabes como hacerlo, puedes seguir esta [guía](../../../comun/JDK.md).

  Además y para ir adelantando para siguientes tareas, debes realizar la instalación de [MAVEN](../../../comun/MAVEN.md).

  Además deberá de tener desplegado el servidor de aplicaciones [Wildfly](instalacion-jboss-wildfly.md)-

## Pasos para realizar la de los servicios rest/ws en Wildfly

### Descarga de los ejemplos

  Para la ejecución de la tarea se debe de recurrir al siguiente enlace de ejemplos para [Wildfly quickstart ejemplos](https://github.com/wildfly/quickstart/).


### Instalación de Servicio Hello-RS

  Una vez descargado el [Wildfly quickstart ejemplos](https://github.com/wildfly/quickstart/), se debe de acceder al directori  helloworld-rs y ejecurar el siguiente comando:

```console
  mvn clean install
```
  Una vez realizada la compilación se debe de acudir a la instalación de _wildfly_, acudimos a la pestama __deployments__. A continuación pulsamos sobre la pestaña __+__, y seleccionamos la carpeta donde se encuentra el proyecto _helloworld-rs_. En concreto debe de ser la ruta _helloworld-rs/target/helloworld-rs.war.
  Una vez desplegado el servicio acude a la url de despliegue _ip:8083/helloworld-rs_, y verifica el despliegue correcto del servicio.

### Instalación de Servicio Hello-WS

    Una vez descargado el [Wildfly quickstart ejemplos](https://github.com/wildfly/quickstart/), se debe de acceder al directori  helloworld-rs y ejecurar el siguiente comando:

  ```console
    mvn clean install
  ```
    Una vez realizada la compilación se debe de acudir a la instalación de _wildfly_, acudimos a la pestama __deployments__. A continuación pulsamos sobre la pestaña __+__, y seleccionamos la carpeta donde se encuentra el proyecto _helloworld-rs_. En concreto debe de ser la ruta _helloworld-rs/target/helloworld-rs.war.
    Una vez desplegado el servicio acude a la url de despliegue _ip:8083/helloworld-rs_, y verifica el despliegue correcto del servicio.  

## Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la instalación y se muestre la instalación de __WildFly__. Además del acceso a la consola de administración, etc, así como los diferentes pasos o problemas encontrados durante la instalación.

  Además el informe debe de contener:
   - Titulo de la tarea.
   - Nombre y Apellidos.
   - Indice
   - Pasos descritos.
   - Capturas de pantalla.

### A tener en cuenta:

  - Se pasará el programa antí copia para verificar autenticidad.
  - __5 faltas de ortografía se baja dos puntos__.
  - Al menos (1 folio indice, al menos 3 desarrollo de la práctica).
  - Carecer faltas de ortografía.
  - Capturas de pantalla con los resultados obtenidos.

</div>

## Referencias y Documentación

- [Documentación Oficial](https://docs.wildfly.org/).
