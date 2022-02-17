# Módulos en Maven

<div align="justify">

<div align="center">
  <img src="https://javadesde0.com/wp-content/uploads/maven-project-structure.png" width="300px">
</div>

Imagine que está trabajando en un proyecto basado en una arquitectura tradicional de 3 capas, en la que las capas se denominan: ___presentación, negocio e integración___. Por supuesto, se desea que cada capa sea __independiente__ de todas las demás capas y, por lo tanto, hemos de generar un __artefacto__ _(modulo)_ para cada una. Siguiendo la norma de Maven, necesitará tener un proyecto para cada capa. Por lo tanto, su configuración debería verse así:

</br>
<div align="center">
  <img src="http://www.javavillage.in/img/maven/project-structure.png" width="300px">
</div>
</br>

Entonces, para compilar su proyecto de presentación, primero debe compilar el proyecto comercial. Pero espera, el proyecto __business__ depende del proyecto de __integration__, por lo que debe compilarse primero.

Pensé que Maven era simple. Por supuesto, __Maven ofrece una solución a este problema en forma de un proyecto de varios módulos__.

_Un proyecto de varios módulos es un tipo de proyecto muy particular_: no produce ningún artefacto y __se compone de varios otros proyectos conocidos como módulos__. Cuando ejecuta un comando en el proyecto, lo ejecutará en todos sus proyectos secundarios. Aún mejor, _Maven es capaz, a través de su componente reactor (no te preocupes por eso por ahora), de descubrir el orden de ejecución correcto y detectar dependencias circulares_. Así que apliquemos esta solución al último ejemplo. Su proyecto debe tener la siguiente estructura al final será:

</br>
<div align="center">
  <img src="http://www.javavillage.in/img/maven/multi-module-structure.png" width="300px">
</div>
</br>

 Bueno la estructura es simple de crear. Los pasos son:
 - Creamos un proyecto _simple de maven_, de nombre __Banco__, por ejemplo e indicamos que su ___\<packaging>pom\</packaging>___. A continuación eliminamos la carpeta __src__, dado que este proyecto sólo va a contener _información del proyecto y elementos a reutilizar_.
 - Creamos un módulo llamado __presentation__.
 - Creamos un módulo llamado __business__.
 - Creamos un módulo llamado __integration__.

 El fichero __pom.xml__ tendrá una estructura similar a la siguiente:

 ```xml
 <project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
  http://maven.apache.org/xsd/maven-4.0.0.xsd">

  <modelVersion>4.0.0</modelVersion>
  <groupId>es.iespuerto.ets</groupId>
  <artifactId>Banco</artifactId>
  <version>4.0.0-SNAPSHOT</version>
  <packaging>pom</packaging>
  <name>Parent del proyecto Banco</name>
  <modules>
    <module>presentaion</module>
    <module>business</module>
    <module>integration</module>
  </modules>
  <dependencies>
    <dependency>
      <groupId>es.iespuerto.ets</groupId>
      <artifactId>presentation</artifactId>
      <version>${version}</version>
    </dependency>
    <dependency>
      <groupId>es.iespuerto.ets</groupId>
      <artifactId>business</artifactId>
      <version>${version}</version>
    </dependency>
    <dependency>
      <groupId>es.iespuerto.ets</groupId>
      <artifactId>integration</artifactId>
      <version>${version}</version>
    </dependency>
  </dependencies>
</project>
 ```

 Este es un ejemplo del trabajo con __maven__.
