# Instalación de SublimeText 3

## Introducción

 Esta tarea explica cómo instalar Sublime Text Linux Ubuntu y también cómo usar Sublime Text.

 Sublime Text es un potente editor de texto construido a partir de componentes personalizados, que proporciona una capacidad de respuesta inigualable. Desde un potente kit de herramientas de interfaz de usuario multiplataforma personalizado hasta un motor de resaltado de sintaxis sin igual, Sublime Text establece el estándar de rendimiento.


## Pasos 

 Se debe de ejecutar cada uno de los siguientes pasos para la instalación de Ubuntu:

 - Paso 1:
```
sudo apt-get upgrade
```
  - Paso 2: 

```
wget -qO - https://download.sublimetext.com/sublimehq-pub.gpg | sudo apt-key add -
```
 - Paso 3:
```
sudo apt-get install apt-transport-https
```
 - Paso 4:
```
echo "deb https://download.sublimetext.com/ apt/stable/" | sudo tee /etc/apt/sources.list.d/sublime-text.list
```
 - Paso 5:
```
sudo apt update
```
 - Paso 6:
```
sudo apt install sublime-text
```
 - Paso 7:
  Pulsa el símbolo de ubuntu en la esquina superior izquierda en azul y busca _sublime_.