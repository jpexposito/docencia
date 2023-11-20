<div align="justify">

<div align="center">
    <img src="https://www.jetbrains.com/idea/whatsnew/2023-2/img/AI_Assistant.png" width="400px" >
</div>

# Crear Proyecto en IntelliJ IDEA

Crear un proyecto en [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/?section=windows) es un proceso bastante sencillo. 

## Descargar e instalar IntelliJ IDEA

Si aún no tienes IntelliJ IDEA instalado, descárgalo desde el sitio web oficial de JetBrains e instálalo en tu sistema.

De no tenerlo instalado, debes acceder al siguiente enlace para descargar [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/?section=windows).

## Configurar OpenJdk

## OpenJdk en Windows

Configurar OpenJDK 11 en Windows implica descargar e instalar el JDK (Kit de Desarrollo de Java) y configurar las variables de entorno. Aquí te dejo los pasos detallados:

- __Paso 1__: Descargar OpenJDK 11
Visita el sitio web de [AdoptOpenJDK](https://jdk.java.net/archive/).
  - Selecciona la versión de Java que desees. En este caso, elige __OpenJDK 11__.
  - Selecciona la JVM (HotSpot es la opción común).
  - Selecciona el sistema operativo como "Windows".
  - Descarga el instalador (un archivo con extensión .msi).
- __Paso 2__: Instalar OpenJDK 11
  - Ejecuta el instalador que has descargado.
  - Sigue las instrucciones del asistente de instalación.
  - Selecciona la ubicación donde deseas instalar OpenJDK.
  - Completa la instalación.
- __Paso 3__: Configurar las variables de entorno
  - Abre el __Panel de control__ de Windows.
  - Haz clic en __Sistema y seguridad__ y luego en __Sistema__.
  - Haz clic en __Configuración avanzada del sistema__ en el panel izquierdo.
  - En la pestaña __Opciones avanzadas__, haz clic en __Variables de entorno__.
  - Variables del sistema:
   - __JAVA_HOME__:
    Haz clic en __Nuevo__ en la sección __Variables del sistema__.
    - Ingresa __JAVA_HOME__ en el campo __Nombre de la variable__.
    - Ingresa la ruta de instalación de OpenJDK (por ejemplo, __C:\Program Files\AdoptOpenJDK\jdk-11.x.x.x__) en el campo __Valor de la variable__.
    - Haz clic en __Aceptar__.
  - Path (Agregar la ruta al ejecutable):
     - Busca la variable __Path__ en la sección __Variables del sistema__ y haz clic en __Editar__.
     - Haz clic en __Nuevo__ y agrega la ruta a la carpeta bin de OpenJDK (por ejemplo, __C:\Program Files\AdoptOpenJDK\jdk-11.x.x.x\bin__).
     - Haz clic en "Aceptar".
- Paso 4: Verificar la instalación
  - Abre una nueva ventana de la línea de comandos (cmd) o PowerShell.
  - Ingresa ___java -version___ y presiona Enter. _Deberías ver la información de la versión de Java instalada_.
  - Ingresa ___javac -version___ y presiona Enter. Deberías ver la información de la versión del compilador Java instalado.

## Iniciar IntelliJ IDEA

Abre IntelliJ IDEA después de la instalación.

### Crear un nuevo proyecto

En la pantalla de inicio, haz clic en "Create New Project" o selecciona "File" en la barra de menú y luego elige "New Project".

<div align="center">
    <img src="https://www.tutorialesprogramacionya.com/kotlinya/imagentema/foto008.jpg" width="400px" >
</div>

### Seleccionar tipo de proyecto

IntelliJ IDEA te ofrecerá diferentes tipos de proyectos y plantillas. Selecciona el tipo de proyecto que mejor se adapte a tus necesidades. Por ejemplo, puedes elegir un proyecto Java, Kotlin, Python, etc.
Configurar el SDK (Kit de Desarrollo de Software):

En la ventana de configuración del proyecto, selecciona la versión del SDK que deseas utilizar. Si aún no tienes uno instalado, puedes descargarlo e instalarlo desde esta ventana.
Configurar opciones adicionales:

Dependiendo del tipo de proyecto, es posible que se te pida configurar opciones adicionales, como el nombre del proyecto, la ubicación del proyecto en el sistema de archivos, y otras configuraciones específicas del lenguaje o framework que estás utilizando.

<div align="center">
    <img src="https://chuidiang.org/images/6/61/New-java-1.png" width="400px" >
</div>

### Finalizar la configuración

Haz clic en __Finish__ o __Create__ para finalizar la configuración del proyecto.
Explorar la interfaz de IntelliJ IDEA.


>__Nota__: Las imágenes son orientativas.

</div>