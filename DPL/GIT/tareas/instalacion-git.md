# Tarea 1: Instalación de Git en linux

Los sistemas de control de versiones como Git son imprescindibles para las prácticas recomendadas del desarrollo de software moderno. El control de versiones le permite realizar un seguimiento de su software a nivel de fuente. Puede rastrear cambios, volver a etapas anteriores y producir ramificaciones para crear versiones alternativas de archivos y directorios.

Los archivos de muchos proyectos de software se mantienen en repositorios de Git y las plataformas como GitHub, GitLab y Bitbucket facilitan el intercambio y la colaboración en proyectos de desarrollo de software.

En esta guía, mostraremos cómo instalar y configurar Git en un servidor de Ubuntu 20.04. Abordaremos la instalación del software de dos formas diferentes: a través del *administrador de paquetes integrado* y a *través de la fuente*. Cada uno de estos enfoques ofrece sus propios beneficios, dependiendo de sus necesidades específicas.

## Requisitos previos

Necesitará un servidor Ubuntu 20.04 con una cuenta de superusuario no root.

Una vez que tenga el servidor y el usuario configurados, estará listo para comenzar.

## Instalación de Git con paquetes predeterminados

La opción de instalar con paquetes predeterminados es recomendable si quiere activar y ejecutar con Git rápidamente, si prefiere una versión estable ampliamente utilizada o si no busca las funciones más recientes disponibles. Si busca la versión más reciente, debería ir directamente a la sección sobre la instalación desde la fuente.

Es probable que Git ya esté instalado en el servidor Ubuntu 20.04. Puede confirmar que ese es el caso de su servidor con el siguiente comando:


```
git --version
```
 
Si obtiene un resultado similar al siguiente, significa que Git ya está instalado.

__Output__

```
git version 2.25.1
```

De ser así, puede pasar a la configuración de Git, o bien si necesita una versión más actualizada, puede leer la siguiente sección sobre cómo instalar desde la fuente.

Sin embargo, si no obtuvo como resultado un número de versión de Git, puede instalarlo con el administrador de paquetes predeterminado APT de Ubuntu.

Primero, utilice las herramientas de administración de paquetes apt para actualizar su índice local de paquetes.

```
sudo apt update
``` 

Una vez completada la actualización, puede instalar Git:

```
sudo apt install git
``` 

Para confirmar que instaló Git correctamente, ejecute el siguiente comando y compruebe que recibe un resultado pertinente.

```
git --version
```

__Output__

```
git version 2.25.1
```

Una vez que instale Git correctamente, podrá pasar a la sección Configuración de Git de este tutorial para completar su configuración.

## Instalación de Git desde la fuente

Si busca un método más flexible para instalar Git, puede optar por compilar el software desde la fuente, lo cual explicaremos en esta sección. Esto toma más tiempo y no se mantendrá en su administrador de paquetes, pero le permitirá descargar la versión más reciente y le brindará mayor control sobre las opciones que incluya si quiere personalizarlo.

Verifique la versión de Git que está instalada actualmente en el servidor:

```
git --version
```

Si Git está instalado, obtendrá un resultado similar al siguiente:

__Output__

```
git version 2.25.1
```

Antes de comenzar, debe instalar el software necesario para Git. Todo se encuentra disponible en los repositorios predeterminados, de modo que podemos actualizar nuestro índice local de paquetes y luego instalar los paquetes pertinentes.

```
sudo apt update
sudo apt install libz-dev libssl-dev libcurl4-gnutls-dev libexpat1-dev gettext cmake gcc
``` 

Tras haber instalado las dependencias necesarias, cree un directorio temporal y vaya a él. Aquí es donde descargaremos nuestro tarball de Git.

```
mkdir tmp
cd /tmp
``` 

Desde el sitio web del proyecto Git, podemos navegar a la lista de tarball disponible en https://mirrors.edge.kernel.org/pub/software/scm/git/ y descargar la versión que quiera utilizar. En el momento de escribir este artículo, la versión más reciente es 2.29.3, así que descargaremos esa versión para nuestra demostración. Utilizaremos curl y enviaremos el archivo que descarguemos a git.tar.gz.

```
curl -o git.tar.gz https://mirrors.edge.kernel.org/pub/software/scm/git/git-2.29.3.tar.gz
``` 

Descomprima el archivo tarball:

```
tar -zxf git.tar.gz
``` 

A continuación, vaya al nuevo directorio de Git:

```
cd git-*
``` 

Ahora, podrá crear el paquete e instalarlo escribiendo estos dos comandos:

```
make prefix=/usr/local all
sudo make prefix=/usr/local install
``` 

Ahora, sustituya el proceso de shell para que se utilice la versión de Git que acabamos de instalar:

```
 exec bash
```

Una vez completado esto, puede estar seguro de que su instalación se realizó correctamente comprobando la versión.

```
git --version
```

__Output__
git version 2.29.3

Con Git instalado correctamente, ahora puede finalizar su configuración.

## Configuración de Git

Una vez que esté satisfecho con la versión de Git, debería configurar Git de modo que los mensajes de confirmación que genere contengan la información correcta y lo respalden a medida que compile su proyecto de software.

Esta configuración es posible si aplicamos el comando git config. Específicamente, debemos proporcionar nuestro nombre y nuestra dirección de correo electrónico debido a que Git inserta esta información en cada confirmación que hacemos. Podemos añadir esta información escribiendo lo siguiente:

```
git config --global user.name "Your Name"
git config --global user.email "youremail@domain.com"
```

Podemos ver todos los elementos de configuración creados escribiendo lo siguiente:

```
git config --list
```

__Output__

```
user.name=Your Name
user.email=youremail@domain.com
...
```

La información que ingresa se almacena en el archivo de configuración de Git. Tendrá la opción de editarlo manualmente con el editor de texto que prefiera (en este tutorial utilizaremos nano) como se muestra a continuación:

```
nano ~/.gitconfig
```

``` 
~/.gitconfig contents
[user]
  name = Your Name
  email = youremail@domain.com (Un correo personal que indique que es el creador de la tarea)
```

Para salir del editor de texto pulse CTRL y X, luego Y y, a continuación, ENTER.

Existen muchas otras opciones que puede configurar, pero estas son las dos esenciales que se necesitan. Si omite este paso, probablemente verá mensajes de advertencia cuando realice una confirmación con Git. Esto implica un mayor trabajo para usted, pues tendrá que revisar las confirmaciones que haya realizado con la información corregida.

## Informe:

Realiza un informe indicando los pasos que has seguido para la instalación de la versión _2.29.3_ de _GIT_ y se muestre la versión de _GIT_ que esta corriendo en el sistema, la cual debe indicar la versión 2.29.3.
Además el informe debe de contener:
 - Titulo de la tarea.
 - Nombre y Apellidos.
 - Indice
 - Pasos descritos.
 - Capturas de pantalla.

### A tener en cuenta:
- Se pasará el programa antí copia para verificar autenticidad.
- + 5 faltas de ortografía se baja dos puntos.
- Al menos (1 folio indice, al menos 3 desarrollo de la práctica)


 - Carecer faltas de ortografía.
 - Capturas de pantalla con los resultados obtenidos.