<div align="justify">

# Tarea: Instalación de Docker en linux

## Paso 1: Instalar Docker

  Es posible que la versión del paquete de instalación de Docker disponible en el repositorio oficial de Ubuntu no sea la más reciente. Para asegurarnos de contar con la versión más reciente, instalaremos Docker desde el repositorio oficial de Docker. Para hacerlo, agregaremos una nueva fuente de paquetes y la clave GPG de Docker para garantizar que las descargas sean válidas, y luego instalaremos el paquete.

  Primero, actualice su lista de paquetes existente:

  ```console
  sudo apt update
  ```

  A continuación, instale algunos paquetes de requisitos previos que permitan a apt usar paquetes a través de HTTPS:

  ```console
  sudo apt install apt-transport-https ca-certificates curl software-properties-common
  ```

  Luego, añade la clave de GPG para el repositorio oficial de Docker en su sistema:

  ```console
  curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
  ```

  Agrega el repositorio de Docker a las fuentes de APT:

  ```console
  sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"
  ```

  A continuación, actualice el paquete de base de datos con los paquetes de Docker del repositorio recién agregado:

  ```console
  sudo apt update
  ```

  Asegúrate de estar a punto de realizar la instalación desde el repositorio de Docker en lugar del repositorio predeterminado de Ubuntu:

  ```console
  apt-cache policy docker-ce
  ```

  Si bien el número de versión de Docker puede ser distinto, verá un resultado como el siguiente:

```
  Installed: (none)
  Candidate: 5:19.03.9~3-0~ubuntu-focal
  Version table:
     5:19.03.9~3-0~ubuntu-focal 500
        500 https://download.docker.com/linux/ubuntu focal/stable amd64 Packages
```

  Observa que docker-ce no está instalado, pero la opción más viable para la instalación es del repositorio de Docker para Ubuntu 20.04 (focal).

  Por último, instale Docker:

  ```console
  sudo apt install docker-ce
  ```

  Con esto, Docker quedará instalado, el demonio se iniciará y el proceso se habilitará para ejecutarse en el inicio. Compruebe que funcione:

  ```console
  sudo systemctl status docker
  ```

  El resultado debe ser similar al siguiente, y mostrar que el servicio está activo y en ejecución:

  ```
  docker.service - Docker Application Container Engine
       Loaded: loaded (/lib/systemd/system/docker.service; enabled; vendor preset>
       Active: active (running) since Fri 2021-10-29 19:21:13 WEST; 28min ago
  TriggeredBy: ● docker.socket
         Docs: https://docs.docker.com
     Main PID: 3169 (dockerd)
        Tasks: 10
       Memory: 38.3M
       CGroup: /system.slice/docker.service
               └─3169 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/cont>
```

  La instalación de Docker ahora le proporcionará no solo el servicio de Docker (demonio) sino también la utilidad de línea de comandos docker o el cliente de Docker. Más adelante, exploraremos la forma de usar el comando docker en este tutorial.
  
