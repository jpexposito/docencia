<div align="justify">

# CONSTRUCCIÓN DE UN SERVICIO DE EMPRESA BASADO EN JAVA

<div align="center">
  <img src="https://www.maquinasvirtuales.eu/ipsoapoo/2021/05/devops-integracion-continua-y-pipeline-1050x525.png" width="500px" />
</div>

</br>

El alumno deberá crear dicho domino con nombre __www.systemalbertoph.com__ donde __Alberto Pérez Hernández__, es el nombre del alumno, y __albertoph__ su patrón. Dicho esto, este patrón debe de ser __sustituido por el nombre y los apellidos del alumno__.

La presente tarea tiene como objetivo la construcción de un __dominio y servicio de integración para el desarrollo__. Dicho dominio dispondrá de:
- __Servidor de BBDD (MySQL)__.
- __PhpMyAdmin__.
- __Soporte Java__.
- __Servidor de SFTP__.

Para verificar el correcto funcionamiento de la instalación el alumno debe de verificar:
- Dominio principal (__www.systemalbertoph.com__), que contendrá una estructura similar a la siguiente:
 - Página:
   - __Principal__, www.systemalbertoph.com.
   - __sftp__  www.albertophsystem.com/sftp, verificando el correcto funcionamiento al servicio __Sftp__, subiendo una aplicación (war de ejemplo) y mostrando el resultado a través de un cliente sftp.
   - Se pretende tener un __jenkins__  en la siguiente url www.albertophsystem.com/jenkins, donde será la herramienta con la que verificaremos a través de un __Pipeline__ que el despliegue se ha realizado correctamente, con las siguientes fases:
      - _Deploy_. (A través del servicio de sftp) __www.albertophsystem.com/sftp__.
      - _Test Integration_. Verificar que la url esta activa y contiene el contenido que se desea verificar (todo aquello que este desplegado).
   - __PhpMyAdmin__, www.systemalbertoph.com/phpmyadmin.

 - Recursos:
  - Ficheros para la construcciónd del [war](https://github.com/jpexposito/docencia/tree/master/COMUN/ejemplos/java/app-web-demo).


## Realización del informe

  Realiza un informe indicando los pasos que has seguido para la instalación del servicio __DOMAIN__ y donde se muestre cada uno de los pasos detallados, pasos y problemas encontrados. __El alumno debe de incluir los ficheros de configuración necesarios, en un zip, y el pdf de forma independiente__.

  Además el informe debe de contener:
   - Titulo de la tarea.
   - Nombre y Apellidos.
   - Indice.
   - Pasos descritos.
   - Carecer faltas de ortografía.
   - Capturas de pantalla con los resultados. obtenidos.
   - Incluye el enlace de tu cuenta _GitHub_ en el detalle de la tarea.

</div>        
