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

## Conclusión

 __Multipass__ está pensado para desarrolladores o para entusiastas que necesitan probar cosas nuevas, para mi caso particular, que necesito tener instancias para probar crear sistemas algo más complejos entre varias máquinas, es una solución ideal, es gratuita, las VMs pesan muy poco y lo mejor de todo, es que se maneja todo de manera bastante simplificada desde una línea de comandos.

 Espero que te sirva de ayuda. Cualquier duda [sígueme](https:www.jpexposito.com).


</div>
