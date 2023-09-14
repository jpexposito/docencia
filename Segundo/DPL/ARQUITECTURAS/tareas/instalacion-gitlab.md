<div align="justify">

# Tarea 1: Instalación de GitLab en linux

  En esta tarea vamos a realizar la instalación Gitlab y además vamos a realizar los primeros pasos de configuración.

  __Gitlab__ es un servicio web de control de versiones además también es un gestor de repositorios donde alojar por ejemplo diferentes versiones para descargar un producto.

  __Gitlab__ aparece como producto en 2011 y aunque aparece como una herramienta de código libre lo cierto es que tiene dos vertientes: una de código libre abierta y otra bajo licencia que incluye más características. Cada vez es una herramienta más extendida a nivel global junto con __Github__, la cual también conoces.

## Requisitos previos

Necesitará un servidor Ubuntu 20.04 con una cuenta de superusuario no root.

Una vez que tenga el servidor y el usuario configurados, estará listo para comenzar.

## Pasos para realizar la instalación en local

### Actualización de los repositorios

  Antes de comenzar, yo diría que cualquier instalación, yo recomiendo siempre actualizar tanto el repositorio como el sistema operativo. De esta manera siempre nos vamos a asegurar que vamos a realizar en este caso instalar Gitlab en una instalación de ubuntu segura y actualizada.

  Para ello ejecutamos estos dos comandos:

```console
  sudo apt update && sudo apt upgrade
```

### Instalación de paquetes adiciones

  Además, instale algunos paquetes necesarios para instalar Gitlab en sistemas Ubuntu.

```console
  sudo apt install -y vim curl ca-certificates apt-transport-https
```

### Instalación de Gitlab

  El equipo oficial de Gitlab proporciona un script de shell para configurar el repositorio APT en su sistema, así como para instalar algunas dependencias necesarias.

  Abra una terminal y ejecute el siguiente comando:

```console
  curl -s https://packages.gitlab.com/install/repositories/gitlab/gitlab-ce/script.deb.sh | sudo bash
```
  y a continuación

```console
  sudo apt install gitlab-ce
```

  hasta finalizar con un  mensaje similar a:
```console
  Thank you for installing GitLab!
```

  Para terminar la instalación deberá ejecutar el siguiente comando que llevará algo de tiempo terminar de configurar:

```console
  sudo gitlab-ctl reconfigure
```  

  Comenzará ejecutarse el proceso de configuración. Llevará unos minutos.

### Acceso

  Una vez finalizada la instalación deberemos acceder a un navegador e introducir la ip del servidor. y mi caso haciendo un ifconfig me dice que la ip es la __http:/TU_IP/__ por lo tanto voy a un navegador y pongo esa ip o localhost.

  En el primer acceso debes de realizar la configuración del usuario __root__.

  Si tienes problemas de acceso para este usuario, debes de visitar el siguiente enlace, [congigurar usuario root desde linea comandos](https://lab.las3.de/gitlab/help/security/reset_root_password.md), y lanzar el comando:

  ```console
    sudo gitlab-ctl reconfigure
  ```

## Realiza el Informe

  Realiza un informe indicando los pasos que has seguido para la instalación y se muestre la instalación de _GitLab_.

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
