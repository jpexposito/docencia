<div align="justify">

# CONSTRUCCIÓN DE UN SERVICIO DE EMPRESA

<div align="center">
  <img src="https://www.maquinasvirtuales.eu/ipsoapoo/2021/05/devops-integracion-continua-y-pipeline-1050x525.png" width="500px" />
</div>

</br>

El alumno deberá crear dicho domino con nombre __www.albertophsystem.com__ donde __Alberto Pérez Hernández__, es el nombre del alumno, y __albertoph__ su patrón. Dicho esto, este patrón debe de ser __sustituido por el nombre y los apellidos del alumno__.

La presente tarea tiene como objetivo la construcción de un __dominio y servicio de integración para el desarrollo__. Dicho dominio dispondrá de:
- __Servidor de BBDD (MySQL)__.
- __PhpMyAdmin__.
- __Soporte Php__.
- __Servidor de SFTP__.

Para verificar el correcto funcionamiento de la instalación el alumno debe de verificar:
- Dominio principal (__www.albertophsystem.com__), que contendrá una estructura similar a la siguiente:
 - Página:
   - __Inicial__, www.albertophsystem.com.
   ```
     <html>
      <head>
        <title>Alberto System Home</title>
      </head>
      <body>
        <?php echo '<p>Pagina inicial de Alberto System </p>'; ?>
      </body>
     </html>
   ```
   - __sftp__  www.sftp.albertophsystem.com/, verificando el correcto funcionamiento al servicio Sftp, subiendo un fichero de ejemplo y mostrando el resultado a través de un cliente sftp.
   - Se pretende crear un ___dominio___ de nombre __despligue__ (www.despligue.albertophsystem.com/), de modo que subiendo un fichero index.php, (puede contener un php.info(), se vea el resultado en dicho subdominio.
   - __jenkins__  www.jenkins.albertophsystem.com/, será la herramienta con la que verificaremos a través de un __Pipeline__ que el despliegue se ha realizado correctamente, con las siguientes fases:
      - _Deploy_. (A través del servicio de sftp).
      - _Test Integration_. Verificar que la url esta activa y contiene el contenido que se desea verificar. Además se verificará que el hosting para el desarrollo se encuentra activo.

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
