<div align="justify">

# DOCKER

<div align="center">
    <img src="https://ubunlog.com/wp-content/uploads/2018/05/instalar-docker-en-Ubuntu.jpg.webp">
</div>

## Introducción

  Docker es una aplicación que simplifica el proceso de administración de procesos de aplicación en contenedores. Los contenedores le permiten ejecutar sus aplicaciones en procesos con aislamiento de recursos. Son similares a las máquinas virtuales, pero los contenedores son más portátiles, más flexibles con los recursos y más dependientes del sistema operativo host.

  ___PODRÍAMOS DECIR QUE DOCKER ES UNA ESPECIE DE MÁQUINA VIRTUAL, PERO MUY LIGERA___.

   _Haciendo hincapié en la cita “Docker simplifica y acelera el flujo de trabajo”, podemos afirmar que Docker ahorra tiempo. Es por eso que el número de empresas que despliegan aplicaciones en Docker se ha incrementado tanto en este último año._

   Estos son algunos de los clientes que usan Docker en sus productos:
   - Adobe
   - AT&T
   - Netflix
   - Palo Alto Networks
   - Paypal
   - University of Calgary
   - Verizon
   - Yale
   - ...

## Docker en números

  En __2021__ el uso de Docker sigue incrementándose, tanto en las comunidades de desarrolladores como en el número de empresas que lo utilizan.

### Uso de Docker

  - __242 mil millones de pulls en el Hub__ _(cada año aumenta unos 5,5 mil millones)_.
  - siete millones de repositorios en su Hub.
  - siete millones de usuarios totales.

### Contenedores más populares

  - __Nginx__.
  - __Httpd__.
  - __Postgres__.
  - __Redis__.
  - __Ubuntu__.
  - __MySql__.
  - __Jenkins__.
  - __...__

  ___TE SUENAN ESTOS ELEMENTOS___.

### Facilita el testing

  Docker puede hacer que las pruebas de control de calidad sean más fáciles, rápidas y efectivas. Los contenedores se pueden configurar para que solo contengan una parte o partes de toda la configuración del entorno.

  De esta forma se puede construir pequeños subconjuntos de pruebas exploratorias y ser más efectivos para encontrar el problema. A todo esto hay que sumarle que el contenedor puede tener exactamente la misma configuración que el entorno de producción, por lo que nos evitaríamos sorpresas desagradables.

  <div align="center">
      <img src="https://programmaticponderings.files.wordpress.com/2015/06/docker-machine-with-ambassador.png">
  </div>


## Menus espacio de almacenamiento para los SO.

  Cada contenedor tiene su propio sistema operativo, menos el Kernel y algunas librerías de hardware que son _heredadas_ del hierro, es decir, todo estos cálculos de arranque no existen porque el sistema operativo principal ya lo ha hecho.

  Con ello, se ahorra archivos (ocupa menos espacio) y se ahorra tiempo al lanzar cada contenedor.

## Portabilidad

  Los contenedores se crean bien por líneas de comando, o bien mediante un archivo de plantilla (Docker-Compose). Igualmente todo funciona bajo Docker. Es decir, si lanzamos el mismo comando o usamos la misma plantilla (teniendo en cuenta los volúmenes y un par de detalles propios del hierro, como la RAM y la CPU, si se especifica), el contenedor que funciona en la máquina A será exactamente igual que el contenedor que funciona en la máquina B. Por tanto, no habrá ninguna variación entre los entornos de desarrollo, pre-producción o producción.

## Facilita el despliegue de Aplicaciones en cualquier entorno

  Al usar las plantillas, los desarrolladores pueden aprovechar los mismos flujos de trabajo y pueden centrarse en el código y no en el resto de configuraciones.


## Referencias

  - [gitlab-docker](https://docs.gitlab.com/ee/install/docker.html).



</div>
