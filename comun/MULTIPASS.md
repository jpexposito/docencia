<div align="justify">

# MULTIPASS

## Introducción

  Existe una solución que te permite correr instancias frescas de Ubuntu desde tu línea de comandos, no importando si estás en Windows, Linux o Mac.

  <div align="center">
    <img src="https://assets.ubuntu.com/v1/0698ab2d-muiltipass-promo-header.png" with="200px" alt="Multipass">
  </div>

  He llegado hasta __Multipass__ después de probar distintas soluciones de instalar __Ubuntu__ en mi MacBook Pro. Recuerdo a un amigo que realizo la aventura en el pasado, y lo que tuvo que pelear con los drivers de su equipo. Sin más preámbulos, __Multipass__, puede cumplir con tus necesidades sí, buscas:
    - Simplicidad.
    - Eficiencia.
    - Una distribución Linux en tu vida configurable.

## Comandos




## Instalación en Mac

  Para realizar la instalación solo debes de seguir las guías que están disponibles en su web:
  - [Windows](https://multipass.run/docs/installing-on-windows).
  - [Linux](https://multipass.run/docs/installing-on-linux).
  - [Mac](https://multipass.run/docs/installing-on-macos).

En mi caso particular la instalación la he realizado a través de __brew__.
```console
   brew install --cask multipass
```
  Obteniendo como resultado:
```console
  installer: Package name is multipass
  installer: Installing at base path /
  installer: The install was successful.
  🍺  multipass was successfully installed!                                                      
```

## Comenzando

  No voy a entrar a describir cada uno de los comandos que existen en la herramienta, para ello solo debes de acceder al [manual oficial](https://multipass.run/docs/alias-command).

  Solo destacaré tres comandos:
   - Creación de una nueva máquina virtual, donde _nombre-vm_ es el nombre que deseas dar a la máquina virtual.
   ```console
     multipass launch --name nombre-vm
    ````  
   - Creación de una nueva máquina virtual, donde _nombre-vm_ es el nombre que deseas dar a la máquina virtual y posee unas características específicas.

  ```console
    multipass launch --name nombre-vm  -c 8  -m 3G -d 40G
  ````  


   - Listado de las máquinas virtuales:
   ```console
     multipass ls  
    ````
  - Entrar en una máquina virtual:
  ```console
      multipass launch --name nombre-vm
   ````
  - Eliminar una máquina vistural:
  ```console
        multipass delete nombre-vm
        multipass purge
   ````

## Modo Gráfico

 <div align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Screenshot_Desktop_Ubuntu_20.04_Focal_Fossa_2160p.png/440px-Screenshot_Desktop_Ubuntu_20.04_Focal_Fossa_2160p.png" >
 </div>  

 Multipass está pensado para ejecutar Ubuntu en modo texto y utilizar la máquina para temas avanzados, como servidores, etc. Sin embargo, al ser una versión completa de Ubuntu Linux, puedes lanzarlo en modo gráfico. Para ello deberás instalar el escritorio de Ubuntu propiamente.

 Primero accedemos a la sesión de Ubuntu instalada. Para ello, deberás lanzar el comando _multipass shell nombre-vm_. Y, a continuación, lanzamos los comandos ya conocidos.
  - __sudo apt update__. Para realizar la actualización de paquetes.
  - __sudo apt install ubuntu-desktop xrdp__. Para instalar el escritorio.
  - __sudo passwd ubuntu__. Finalmente indicamos la contraseña de usuario, que por defecto es ubuntu.

Para ver el escritorio, deberás emplear una herramienta de escritorio remoto tipo [__Microsoft Remote Desktop__](https://www.microsoft.com/en-us/p/microsoft-remote-desktop/9wzdncrfj3ps?activetab=pivot:overviewtab). Para acceder a la máquina virtual de Ubuntu, deberemos indicarle la dirección IP. La obtendrás si en Multipass lanzas la orden ip addr. Además, en su debido momento deberás indicar el usuario y contraseña de Ubuntu.

## Instalar idioma

  Vamos a instalar y configurar el idioma español en Linux Ubuntu a través del terminal:

  Instalar los paquetes de idioma en Linux para su traducción al español:

  - sudo apt-get install language-pack-es
  - sudo apt-get install language-pack-es-base
  - sudo apt-get install language-support-es


  Si lo que queremos es instalar los diccionarios en español, debemos ejecutar lo siguiente:
  - sudo apt-get install aspell-es
  - sudo apt-get install myspell-es


  Para traducir los manuales del sistema al español en Linux Ubuntu:
  - sudo apt-get install manpages-es


  Ahora ya hemos instalado el idioma español en nuestro sistema Linux, pero para configurarlo como idioma por defecto en nuestro sistema, debemos realizar aun un par de pasos más, pero tranquilos que son bastante sencillos, tan solo debemos ir al terminal de nuevo y ejecutar el siguiente comando.

  Comando para reconfigurar el idioma de todo el sistema y ponerlo en español:
  - sudo dpkg-reconfigure locales

## Conclusión

  __Multipass__ está pensado para desarrolladores o para entusiastas que necesitan probar cosas nuevas, para mi caso particular, que necesito tener instancias para probar crear sistemas algo más complejos entre varias máquinas, es una solución ideal, es gratuita, las VMs pesan muy poco y lo mejor de todo, es que se maneja todo de manera bastante simplificada desde una línea de comandos.

  Espero que te sirva de ayuda. Cualquier duda [sígueme](https:www.jpexposito.com).


</div>
