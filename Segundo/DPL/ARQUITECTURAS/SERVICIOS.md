<div align="justify">

# TRABAJO CON SERVICIOS

<div align="center">
    <img src="https://www.ajfriesen.com/content/images/size/w2000/2021/06/featured-4.png">
</div>

## Listar servicios en Ubuntu

  Antes de poder administrar un servicio debemos conocer su nombre. El siguiente comando te mostrar una lista con todos los servicios que se encuentran actualmente en Ubuntu.

```console
  systemctl list-unit-files
```

## Deshabilitar de un servicio en concreto

  Para deshabilitar un servicio en concreto debemos de realizar:

  ```console
  systemctl list-unit-files | grep -i apache2
  ```
  Donde __apache2__ es el servicio que deseamos _conocer su estado_.

  ```console
  sudo systemctl disable apache2
  ```


## Deshabilitar de un servicio en concreto

  Para habilitar un servicio en concreto debemos de realizar:

  ```console
  systemctl list-unit-files | grep -i apache2
  ```
  Donde __apache2__ es el servicio que deseamos _conocer su estado_.

  ```console
  sudo systemctl enable apache2
  ```  

  Se debe de realizar la acción para todos los servicios instalados hasta el momento:
  - apache2.
  - tomcat.
  - ...

  Con el fin de liberar todos los recursos posibles de la máquina.


</div>
