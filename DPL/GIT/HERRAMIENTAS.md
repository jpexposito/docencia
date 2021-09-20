# Herramientas externas para la generación de documentación. Instalación, configuración y uso

## Introducción 

En este punto hablaremos de dos herramientas para el control de versiones, para conocer sus diferencias y centrarnos en una de ellas.

<img width="50%" src="https://miro.medium.com/max/1400/1*YCRvmmb9wbGAqKYVfJNyLw.png" alt="Top respositorio de codigo">

## CVS

Es otro sistema de control de versiones muy popular. Es un modelo de repositorio cliente-servidor donde varios desarrolladores pueden trabajar en el mismo proyecto en paralelo. El cliente CVS mantendrá actualizada la copia de trabajo del archivo y requiere intervención manual sólo cuando ocurre un conflicto de edición.

## Mercurial

Es una herramienta distribuida de control de versiones que está escrita en Python y destinada a desarrolladores de software. Los sistemas operativos que admite son similares a Unix, Windows y macOS. Tiene un alto rendimiento y escalabilidad con capacidades avanzadas de ramificación y fusión y un desarrollo colaborativo totalmente distribuido. Además, posee una interfaz web integrada.

## Monotone
Está escrito en C ++ y es una herramienta para el control de versiones distribuido. El sistema operativo que admite incluye Unix, Linux, BSD, Mac OS X y Windows. Brinda un buen apoyo para la internacionalización y localización. Además, utiliza un protocolo personalizado muy eficiente y robusto llamado Netsync.

## SVN

__Apache Subversion__ (abreviado frecuentemente como SVN, por el comando svn) es una herramienta de control de versiones open source basada en un repositorio cuyo funcionamiento se asemeja enormemente al de un sistema de ficheros. Es software libre bajo una licencia de tipo Apache/BSD.

Utiliza el concepto de revisión para guardar los cambios producidos en el repositorio. Entre dos revisiones solo guarda el conjunto de modificaciones (delta), optimizando así al máximo el uso de espacio en disco. SVN permite al usuario crear, copiar y borrar carpetas con la misma flexibilidad con la que lo haría si estuviese en su disco duro local. Dada su flexibilidad, es necesaria la aplicación de buenas prácticas para llevar a cabo una correcta gestión de las versiones del software generado.

Subversion puede acceder al repositorio a través de redes, lo que le permite ser usado por personas que se encuentran en distintas computadoras. A cierto nivel, la posibilidad de que varias personas puedan modificar y administrar el mismo conjunto de datos desde sus respectivas ubicaciones fomenta la colaboración. Se puede progresar más rápidamente sin un único conducto por el cual deban pasar todas las modificaciones. Y puesto que el trabajo se encuentra bajo el control de versiones, no hay razón para temer porque la calidad del mismo vaya a verse afectada —si se ha hecho un cambio incorrecto a los datos, simplemente deshaga ese cambio.

### Ventajas

- Se sigue la historia de los archivos y directorios a través de copias y renombrados.
- Las modificaciones (incluyendo cambios a varios archivos) son atómicas.
- La creación de ramas y etiquetas es una operación más eficiente. Tiene coste de complejidad constante (O(1)) y no lineal (O(n)) como en CVS.
- Se envían solo las diferencias en ambas direcciones (en CVS siempre se envían al servidor archivos completos).
- Puede ser servido mediante Apache, sobre WebDAV/DeltaV. Esto permite que clientes WebDAV utilicen Subversion de forma transparente.
- Maneja eficientemente archivos binarios (a diferencia de CVS que los trata internamente como si fueran de texto).
- Permite selectivamente el bloqueo de archivos. Se usa en archivos binarios que, al no poder fusionarse fácilmente, conviene que no sean editados por más de una persona a la vez.
- Cuando se usa integrado a Apache permite utilizar todas las opciones que este servidor provee a la hora de autentificar archivos (SQL, LDAP, PAM, etc.).

### Árbol de proyecto subversion.

- Carencias
- El manejo de cambio de nombres de archivos no es completo. Lo maneja como la suma de una operación de copia y una de borrado.
- No resuelve el problema de aplicar repetidamente parches entre ramas, no facilita llevar la cuenta de qué cambios se han realizado. Esto se resuelve siendo cuidadoso con los mensajes de commit.

<img width="50%" align="center" src="https://codentrick.com/content/images/size/w2000/2015/07/SVN_Server_Client_Structure.png" alt="svn" >


## GIT

Git es un software de control de versiones diseñado por Linus Torvalds, pensando en la eficiencia, la confiabilidad y compatibilidad del mantenimiento de versiones de aplicaciones cuando estas tienen un gran número de archivos de código fuente. Su propósito es llevar registro de los cambios en archivos de computadora incluyendo coordinar el trabajo que varias personas realizan sobre archivos compartidos en un repositorio de código.

Al principio, Git se pensó como un motor de bajo nivel sobre el cual otros pudieran escribir la interfaz de usuario o front end como Cogito o StGIT. Sin embargo, Git se ha convertido desde entonces en un sistema de control de versiones con funcionalidad plena. Hay algunos proyectos de mucha relevancia que ya usan Git, en particular, el grupo de programación del núcleo Linux.

El mantenimiento del software Git está actualmente (2009) supervisado por Junio Hamano, quien recibe contribuciones al código de alrededor de 280 programadores. En cuanto a derechos de autor Git es un software libre distribuible bajo los términos de la versión 2 de la Licencia Pública General de GNU.

<img width="50%" src="https://diegobersano.files.wordpress.com/2017/06/introgit-distribuido1.png" alt="git"/>

### Características

El diseño de Git se basó en BitKeeper y en Monotone. Originalmente fue diseñado como un motor de sistema de control de versiones de bajo nivel sobre el cual otros podrían codificar interfaces frontales, tales como Cogito o StGIT.Desde ese entonces hasta ahora el núcleo del proyecto Git se ha vuelto un sistema de control de versiones completo, utilizable en forma directa.

Linus Torvalds buscaba un sistema distribuido que pudiera usar en forma semejante a BitKeeper, pero ninguno de los sistemas bajo software libre disponibles cumplía con sus requerimientos, especialmente en cuanto a desempeño. El diseño de Git mantiene una enorme cantidad de código distribuida y gestionada por mucha gente, que incide en numerosos detalles de rendimiento, y de la necesidad de rapidez en una primera implementación.

##### Entre las características más relevantes se encuentran:

 - Fuerte apoyo al desarrollo no lineal, por ende rapidez en la gestión de ramas y mezclado de diferentes versiones. Git incluye herramientas específicas para navegar y visualizar un historial de desarrollo no lineal. Una presunción fundamental en Git, es que un cambio será fusionado mucho más frecuentemente de lo que se escribe originalmente, conforme se pasa entre varios programadores que lo revisan.
 - Gestión distribuida. Al igual que Darcs, BitKeeper, Mercurial, SVK, Bazaar y Monotone, Git le da a cada programador una copia local del historial del desarrollo entero, y los cambios se propagan entre los repositorios locales. Los cambios se importan como ramas adicionales y pueden ser fusionados en la misma manera que se hace con la rama local.
 - Los almacenes de información pueden publicarse por HTTP, FTP, rsync o mediante un protocolo nativo, ya sea a través de una conexión TCP/IP simple o a través de cifrado SSH. Git también puede emular servidores CVS, lo que habilita el uso de clientes CVS pre-existentes y módulos IDE para CVS pre-existentes en el acceso de repositorios Git.
 - Los repositorios Subversion y svk se pueden usar directamente con git-svn.
 - Gestión eficiente de proyectos grandes, dada la rapidez de gestión de diferencias entre archivos, entre otras mejoras de optimización de velocidad de ejecución.
 - Todas las versiones previas a un cambio determinado, implican la notificación de un cambio posterior en cualquiera de ellas a ese cambio (denominado autenticación criptográfica de historial). Esto existía en Monotone.
 - Resulta algo más caro trabajar con ficheros concretos frente a proyectos, eso diferencia el trabajo frente a CVS, que trabaja con base en cambios de fichero, pero mejora el trabajo con afectaciones de código que concurren en operaciones similares en varios archivos.
 - Los renombrados se trabajan basándose en similitudes entre ficheros, aparte de nombres de ficheros, pero no se hacen marcas explícitas de cambios de nombre con base en supuestos nombres únicos de nodos de sistema de ficheros, lo que evita posibles y desastrosas coincidencias de ficheros diferentes en un único nombre.
 - Realmacenamiento periódico en paquetes (ficheros). Esto es relativamente eficiente para escritura de cambios y relativamente ineficiente para lectura si el reempaquetado (con base en diferencias) no ocurre cada cierto tiempo.
 - Compatibilidad con Github y Microsoft Visual Studio Code

## Git vs. SVN: ¿cuál es el mejor sistema de control de versiones?

Los llamados sistemas de control de versiones fueron creados con el fin de detectar cambios en los documentos o archivos y se encargan de guardar todas las versiones anteriores, incluyendo el registro de fecha y hora, así como el identificador del usuario de un archivo para que los datos puedan ser recuperados y restaurados en cualquier momento. De esta forma, es posible determinar qué usuario ha realizado cambios en un punto determinado. Los objetivos generales de este tipo de sistemas consisten en coordinar el acceso compartido de varios usuarios a los archivos y permitir el desarrollo simultáneo de varias bifurcaciones o branches.  

Generalmente, los sistemas de control de versiones se utilizan para el desarrollo de software, para aplicaciones de oficina y para gestores de contenido. Dos de los más conocidos son Apache Subversion (SVN) y Git, los cuales pueden ser instalados internamente en el servidor propio o externamente en el servidor de algún proveedor de alojamiento web. El servicio de alojamiento basado en la web para proyectos Git es GitHub, mientras que en  RiouxSVN aloja a Subversion. Proveedores como SourceForge ofrecen alojamiento para ambos sistemas.

### SVN vs. Git: una comparación directa

Aunque muchos usuarios se preguntan cuál de los dos programas de control de versiones es mejor, no existe una respuesta general. La elección del sistema de control de versiones más adecuado para uno u otro proyecto dependerá de tus objetivos específicos. Ambos sistemas difieren en su estructura y en el proceso de trabajo resultante. La siguiente tabla resume sus principales diferencias:

| | SVN | Git |
| -------------| ------------- | ------------- |	
| Control de versiones | Centralizada | Distribuida |
| Repositorio | Un repositorio central donde se generan copias de trabajo | Copias locales del repositorio en las que se trabaja directamente | 
| Autorización de acceso | Dependiendo de la ruta de acceso	Para la totalidad del directorio | 
| Seguimiento de cambios | Basado en archivos | Basado en contenido | 
| Historial de cambios | Solo en el repositorio completo, las copias de trabajo incluyen únicamente la versión más reciente | Tanto el repositorio como las copias de trabajo individuales incluyen el historial completo | 
| Conectividad de red | Con cada acceso | Solo necesario para la sincronización | 

<img width="50%" src="https://scriptcrunch.com/wp-content/uploads/2016/03/centralized-vs-distributed-advantages.png" alt="Comparativa svn git">

#### Estas son las principales ventajas de ambos sistemas:

- __Debes decantarte por Git cuando…__ 
 - no quieres depender de una conexión de red permanente, pues quieres trabajar en tu proyecto desde cualquier lugar.
 - quieres seguridad en caso de fallo o pérdida de los repositorios principales.
 - no necesitas contar con permisos especiales de lectura y escritura para los diferentes directorios (aunque, de ser así, será posible y complejo implementarlo).
 - la transmisión rápida de los cambios es una de tus prioridades. 
- __Subversion será la opción indicada, si…__
 - necesitas permisos de acceso basados en rutas de acceso para las diferentes áreas de tu proyecto.
 - deseas agrupar todo tu trabajo en un solo lugar.
 - trabajas con numerosos archivos binarios de gran tamaño.
 - también quieres guardar la estructura de los directorios vacíos (estos son rechazados por Git, debido a que no contienen ningún tipo de contenido).

En caso de que las características enumeradas anteriormente no hayan sido decisivas para decantarse por alguno de los dos, siempre es recomendable realizar una prueba con cualquiera de los sistemas de control de versiones. En ambos casos encontrarás el apoyo de una gran comunidad, proveedores de alojamiento de gran calidad como GitHub y ofertas de soporte profesional.

## Tareas a realizar

 - [Tarea 1: Instalacíon de Git en local](tareas/instalacion-git.md)  
 - [Tarea 1: Manipulación básica de repositorios](tareas/manipulacion-repositorios.md)  