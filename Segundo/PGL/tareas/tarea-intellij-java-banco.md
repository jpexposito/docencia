# Tarea : Gestión de Bancos 


## Introducción

 Para comenzar el curso vamos realizar un pequeño ejercicio con el fin de irnos familiarizando con el nuevo IDE, además de conocer el nivel de programación en Java de los estudiantes.

### Verificación de la instalación de Java u OpenJDK

 Desde un terminal del SO, se debe de ejecutar:
 
```java
	java -version
```
 Si no hemos obtenido una versión debemos de realizar la instalación en la máquina virtual.

#### ¿Cómo instalar Java en Ubuntu desde repositorios?

Lo primero debemos de actualizar el sistema con:

```   
  sudo apt-get upgrade
  
```

e instalamos Java con este comando:

```
  sudo apt-get install default-jdk
```

comprobamos que tenemos instalado Java en nuestro sistema solo debemos de ejecutar:
```
  java --version
```

#### ¿Cómo instalar una versión específica de Java?

Para instalar Ubuntu Java Open JDK ("la que utilizaremos en 1º").
 - OpenJDK:
   - 11 
   ```
   sudo apt install openjdk-11-jdk
   ```
    - 9 
   ```
   sudo apt install openjdk-9-jdk
   ```
    - 8
   ```
   sudo apt install openjdk-8-jdk
   ```
La versión que se debe de trabajar es la versión 8. Para ello verificaremos la versión de java que se esta ejecutando con la sentencia:
```
  java --version
```
En caso que no se ejecuta la versión 8 se debe configurar las variables de entorno.

#### Configuración de las variables de entorno

El siguiente paso consiste en establecer  las variables de entorno. Es necesario porque cuando se usa Java, Linux necesita saber dónde está ubicado el programa para ejecutarlo y qué versión de Java usar de forma predeterminada. Para modificar esto, usaremos el editor de texto nano. Primero, abra el archivo en Nano.

```
nano /etc/profile
```

```
# Java version
JAVA_HOME=/usr/java/_____openJdk_____
PATH=$PATH:$HOME/bin:$JAVA_HOME/bin
export JAVA_HOME
export JRE_HOME
export PATH
```

## IDE (Intellij Idea)

 Descargar el Ide con el que comenzaremos a trabajar: Intellij Idea, versión comunity.
 
- [Descarga](https://www.jetbrains.com/es-es/idea/)  


<a href="https://www.jetbrains.com/es-es/idea/"><img src="https://resources.jetbrains.com/storage/products/intellij-idea/img/meta/intellij-idea_logo_300x300.png?raw=true" title="Intellij" alt="Intellij"></a>

<img src=" " alt="Intellij">


## Planteamento del Ejercicio (Gestión de Bancos)

Para comenzar y conocer el nivel de conocimiento en Java, vamos a desarrollar una pequeña aplicación que tenga las siguientes restricciones:
- Banco:
	- dirección
	- monedas (lista <String()>) o ENUM. Ejemplo (EURO, DOLAR,…)
	- lista <Cliente>

- Cliente:
	- nombre
	- apellidos
	- lista <Cuenta>

- Cuenta:
	- numero
	- saldo
	- moneda (elemento de lista de monedas del banco o ENUM creado)

- Persistencia en
  - Fichero: (XML/CSV)
  - BBDD: (MySQL/SQLite/H2”).

- Arquitectura: Si conoces el mvc puedes implementar la arquitectura.

