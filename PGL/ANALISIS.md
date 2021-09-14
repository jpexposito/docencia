# Análisis de tecnologías para aplicaciones en dispositivos móviles

[[_TOC_]]

## Introducción

El uso generalizado en los últimos tiempos de dispositivos móviles como smartPhones ha dado lugar a una gran demanda de software para este nuevo tipo de hardware. 

## Introducción. ¿Qué es un dispositivo móvil?

La primera pregunta que podemos hacernos es ¿qué entendemos por "móvil"? Si se nos ocurre investigar sobre ese término, a través de algún buscador de Internet, podremos observar que no hay una respuesta única y que en algunas ocasiones las diferencias pueden ser sustanciales en función de qué es lo que consideremos "móvil". Obviamente esto da lugar a su vez a muchas otras preguntas como por ejemplo: Es móvil… ¿alguna parte del dispositivo? ¿El dispositivo completo? ¿La aplicación que usamos en el dispositivo? ¿Una aplicación cliente? ¿Una aplicación servidor? ¿El usuario del dispositivo? ¿Es "móvil" sinónimo de "portátil"? ¿Es "móvil" sinónimo de "limitado"? ¿Hasta qué punto "móvil" es sinónimo de "autónomo"? ¿Existen diversos grados de "movilidad"? ¿Se pueden clasificar los dispositivos móviles en distintos tipos? ¿Bajo qué criterios? Y así sucesivamente podríamos plantearnos más y más preguntas…

Para evitar este tipo de controversias, en nuestro caso vamos a intentar dar una definición con la que trabajaremos a lo largo del desarrollo del módulo:

¿Qué es un dispositivo móvil? Se trata de un aparato de pequeño tamaño (normalmente que quepa en un bolsillo) y de poco peso, con pantalla, con capacidades de procesamiento medias, memoria limitada y conexión a una red. Este tipo de dispositivos están diseñados para cumplir algún tipo de función específica (realizar llamadas telefónicas, servir como agendas, jugar, navegación GPS, escuchar música, acceso al correo electrónico, navegar por Internet, etc.) aunque normalmente pueden llevar a cabo también funciones más generales. Es importante tener en cuenta que aunque existan dispositivos de alta gama los desarrollos deben cubrir la mayor cuota de mercado posible.

Estos aparatos a día de hoy son indispensables en el día a día de mucha gente.

##  Limitaciones que plantea la ejecución de aplicaciones en los dispositivos móviles: desconexión, seguridad, memoria, consumo batería, almacenamiento.

Antes de comenzar a desarrollar software para alguno de estos dispositivos, es necesario ser conscientes de las limitaciones con las que nos podemos encontrar en estos aparatos. ¿Cuáles son las restricciones a las que nos vamos a tener que enfrentar?

Algunas de estas restricciones son:

 - Suministro de energía limitado (normalmente dependiente de baterías).
 - Procesadores con capacidad de cómputo reducida en dispositivos de gama baja. Suelen tener una baja frecuencia de reloj por la necesidad de ahorrar energía. En dispositivos de gama media alta, la capacidad de cómputo es alta.
 - Poca memoria principal (RAM) en dispositivos de gama baja. En dispositivos de gama media la memoria no es una limitación.
 - Almacenamiento de datos limitado. A pesar de contar con altas capacidades las aplicaciones y archivos son cada vez más pesados.
 - Conexión a red. Aunque el ancho de banda puede ser reducido en función de tarifas.
 Este tipo de restricciones, y algunas otras que dependerán de cada dispositivo en concreto, habrán de ser tenidas muy en cuenta a la hora del análisis y diseño de una aplicación "móvil", pues no podemos pretender, que esa aplicación pueda contener la misma funcionalidad, que la que podemos encontrar habitualmente en un programa que es ejecutado en un ordenador de sobremesa o un portátil.

Por otro lado, no todo va a ser restricciones. También habrá que tener en consideración que esta tecnología va a aportar una serie de ventajas muy importantes: movilidad, poco peso, pequeño tamaño, facilidad para el transporte, conectividad a diversos tipos de redes de comunicaciones (mensajería SMS y MMS; voz; Internet; Bluetooth; infrarrojos; radiofrecuencia, etc.). Ésas serán las ventajas que podrás explotar en tus aplicaciones.

### Tecnologías disponibles

Cuando vas a desarrollar una aplicación para un dispositivo móvil, algunas de las primeras preguntas que te puedes hacer son:
 - ¿Sobre qué tipos de dispositivos móviles se pueden hacer programas? ¿Sobre qué tipo de hardware se puede programar?
 - ¿Qué sistema operativo puede llevar ese hardware?
 - ¿Qué plataformas de desarrollo existen para desarrollar sobre ese hardware y ese sistema operativo? ¿con qué lenguajes puedo programar? ¿qué herramientas (compiladores, bibliotecas, entornos, etc.) hay disponibles?
Las respuestas a este tipo de preguntas pueden ser múltiples y muy variadas:

 - Respecto al hardware, te puedes encontrar, como has visto ya, con teléfonos móviles (smartPhones), PDA y con otros dispositivos. Entre los principales fabricantes de teléfonos móviles se encuentran Nokia (el mayor proveedor de teléfonos móviles en 2010 con una gran diferencia del segundo, que sería Samsung), Samsung, HTC, Apple, Motorola, LG, Sony Ericsson, Alcatel-Lucent, etc. Entre los principales fabricantes de PDA se encuentran HP, HTC, Palm (adquirida por HP en 2010), Motorola, Samsung o LG. En realidad muchas veces coinciden los proveedores que desarrollan smartPhones con los que fabrican PDA. Por otro lado, ambos tipos de productos están en muchas ocasiones convergiendo hacia un único dispositivo final que cumple las dos funciones (telefonía móvil y asistente personal).
 - En cuanto a los sistemas operativos, dependiendo del hardware habrá sistemas diseñados para unos u otros dispositivos. Los hay basados en Microsoft Windows, en Linux, y en MAC OS X, así como otros totalmente originales y desarrollados específicamente para estos nuevos tipos de dispositivos. Entre los más populares se encuentran Symbian OS, Android, iOS, Blackberry OS y Windows Phone.
 - Si lo que deseas es conocer algo acerca de las plataformas de desarrollo disponibles para cada entorno (hardware y/o sistema operativo), podemos hablar de Java ME, Windows Mobile SDK, Maemo SDK, o bien de IDE como Microsoft Visual Studio, CodeWarrior, Eclipse, Netbeans.
 - Si te refieres a lenguajes de programación, normalmente te encontrarás con lenguajes que son ya viejos conocidos para otras plataformas, como pueden ser las aplicaciones de escritorio para los PCs o las aplicaciones web (Java, C#, C, etc.).
En definitiva puedes observar que en este nuevo mundo del desarrollo para dispositivos móviles te encuentras con una problemática similar a la que te puedes enfrentar con los ordenadores convencionales: distintos tipos de hardware, distintas opciones de sistemas operativos dependiendo del hardware que los soporte, diferentes lenguajes de programación, plataformas, API y bibliotecas, entornos de desarrollo, etc.

#### Hardware

Como has visto en los apartados anteriores, dependiendo de los criterios que se utilicen para clasificar los dispositivos móviles se puede hablar de más o menos tipos. Este curso se va a centrar sobre todo en smartPhones.

##### Smartphones

Se puede definir un smartPhone o "teléfono inteligente" como un terminal de telefonía móvil que proporciona unas prestaciones y una funcionalidad mayor que la que podría ofrecer un teléfono móvil normal. Hoy día una buena parte de los teléfonos móviles que se pueden adquirir en el mercado son de este tipo.

Este tipo de terminales se caracteriza por tener instalado un sistema operativo y por tanto la posibilidad de ejecutar aplicaciones desarrolladas bien por el propio fabricante del terminal, bien por el operador de telefonía móvil, o bien por un tercero (empresa de desarrollo de software).

Algunas otras características que suelen tener este tipo de dispositivos son:

- Funcionamiento en multitarea (ejecución concurrente de varios procesos en el sistema operativo).
- Acceso a Internet.
- Conectividad Wi-Fi, Bluetooth, etc.
- Posibilidad de conexión con un ordenador para cargar y descargar información. Normalmente con conexión USB o bien una conexión inalámbrica.
- Posibilidad de ampliación de memoria mediante tarjetas externas de memoria (por ejemplo SD).
- Pequeñas pantallas pero de alta resolución y/o con millones de colores.
- Posibilidad de pantallas táctiles o incluso multitáctiles (multitouch).
- Sensores (de orientación, de temperatura, de presión, acelerómetros, magnetómetros, etc.).
- Cámaras digitales integradas. Capacidades fotográficas. Grabación de audio y vídeo.
- Receptor GPS.
- Receptor de radio FM.
- Emisor de radio FM.
- Posibilidad de instalar y ejecutar aplicaciones sofisticadas:
  - Aplicaciones de asistente personal (gestión de contactos, calendarios, citas, agendas, alarmas, etc.).
  - Gestión del correo electrónico.
  - Gestión del sistema archivos del dispositivo.
  - Microaplicaciones de ofimática (procesador de textos, hoja de cálculo, etc.).
  - Aplicaciones multimedia (reproducción de audio y vídeo en diversos formatos).
  - Aplicaciones de cartografía y navegación.
  - Diccionarios.
  - Pequeñas aplicaciones científicas (matemáticas, física, medicina, etc.).
  - Juegos.
  - Aplicaciones de mensajería instantánea. Chats.
Puedes observar que aunque el dispositivo es un teléfono móvil muchas veces su uso principal no va a ser necesariamente el de un teléfono (hacer y recibir llamadas) sino que podrá estar dedicado a muchos otros usos (hacer fotos, navegar por Internet, reproducir archivos de audio, jugar, gestionar la agenda personal, consultar un mapa, usar un diccionario, escuchar la radio, ver una película, trazar una ruta para el navegador por satélite, etc.).

Dentro de muy poco tiempo es probable que se deje de emplear el término smartPhone o "móvil inteligente" pues todos los terminales móviles serán de este tipo y se hablará simplemente de "teléfonos móviles". De hecho en la práctica ya ocurre hoy día, pues cuando nos acercamos a algún catálogo de productos la inmensa mayoría de terminales que se nos ofrecen son de este tipo.

Fabricantes de smartPhones

- Algunos ejemplos de smartPhones son:
  - Los iPhone de Apple.
  - Las series Galaxy y Nexus de Samsung (con Android).
  - En general cualquier fabricante de terminales de telefonía móvil actual desarrolla smartPhones.

#### Sistemas operativos

Los sistemas operativos que fueron más habituales en un dispositivo móvil eran:

- Symbian OS. La mayoría de teléfonos móviles con Symbian son del fabricante Nokia (entre ellos la mayoría de los de la serie N).
- Android. Desarrollado inicialmente por Google y basado en el núcleo de Linux. El primer fabricante de móviles que lo incorporó fue HTC.
- iOS. Desarrollado por Apple para el iPhone y usado más tarde también para el iPod Touch y el iPad.
- Windows Phone (anteriormente llamado Windows Mobile). Desarrollado por Microsoft tanto para smartPhones como para otros dispositivos móviles (por ejemplo PDA). Algunos fabricantes de teléfonos móviles que incorporan este sistema operativo son Samsung, LG o HTC.
- Blackberry OS. Desarrollado por Research in Motion (RIM) para sus dispositivos Blackberry.
- HP webOS, desarrollado por Palm, adquirido por HP (Palm era la desarrolladora del más antiguo Palm OS). Está basado en un kernel de Linux.
Palm OS. Desarrollado por PalmSource para PDA, aunque las últimas versiones también funcionan para smartPhones.
- Maemo OS. Desarrollado por Nokia para smartPhones, PDA e Internet tables.
- Bada. Desarrollado por Samsung.

Hay que tener en cuenta que a medida que los teléfonos móviles crecen en popularidad, los sistemas operativos con los que trabajan también adquieren mayor importancia. Según un artículo en la publicación española "Cinco días", la cuota de mercado de sistemas operativos móviles en noviembre de 2010 era la siguiente:

 - Symbian OS 36,6% (51% en 2010).
 - Android 25% (1,8% en 2010).
 - iOS 16,7% (13% en 2010).
 - BlackBerry OS 14,8% (19% en 2010).
 - Windows Phone 2,8% (9,3% en 2010).

En la actualidad han desaparecido multitud de lenguajes y sistemas operativos. Veamos como se encuentra el mercado a 31 de diciembre de 2020.

<img align="center" src="../img/so-smarthones2020.png" alt="Entornos de desarrollo integrado">

Es sumamente probable que quienes adquieran en la actualidad un nuevo teléfono móvil, basen su elección entre sólo dos sistemas operativos: Android y iOS, pero esto no siempre fue así.

Habiendo comenzado como un mercado multi-plataforma, el panorama de los smartphones se ha convertido en un duopolio en los últimos años, después de que el iOS de Apple y el Android de Google desplazaran al resto de plataformas, incluyendo el Windows Phone de Microsoft y el sistema operativo BlackBerry.

Según datos de la consultora de tecnología IDC, los dispositivos Android representaron algo más del 84% de las unidades enviadas en 2020, y los iOS de Apple casi el 16% restante. En cambio, en 2010, hace poco más de una década, la cuota de mercado combinada de Android e iOS era inferior al 40%, con BlackBerry, Windows Phone y otros sistemas operativos compartiendo el resto del mercado.

##### Android.

Android fue inicialmente desarrollado por Android Inc., hoy día parte de la compañía Google. Está basado en una versión modificada del kernel de Linux.

El primer fabricante que incorporó Android en sus dispositivos fue HTC con su terminal HTC Dream (comercializado también como T-Mobile G1 y popularmente conocido con los nombres de Google Phone o GPhone) en 2008.

Es uno de los más "jóvenes" dentro del grupo de sistemas operativos para dispositivos móviles y se ha hecho un notable hueco alcanzando un tercio de la cuota de mercado a comienzos de 2011. Existen miles de aplicaciones que funcionan sobre Android, con un crecimiento cada vez mayor.

Hoy día podemos encontrar multitud de fabricantes que incorporan Android en sus terminales: Sony Ericsson (Xperia X10 y X8), HTC (Serie A), Acer (beTouch E110), Motorola (Droid X), Samsung (series Galaxy y Nexus), Garmin (GarminPhone), Dell, Alcatel, LG, etc.

A mediados de 2011, la última de versión de Android era la 2.3 (GingerBread, o "pan de jengibre"). Algunas versiones anteriores han sido: 2.2 (FroYo), 2.1 (Éclair), 1.6 (Donut) o 1.5 (Cupcake). Podemos observar que los nombres de las versiones corresponden con postres y que además según avanzan la versión avanza alfabéticamente la letra del postre.

##### iOS.

Se trata del sistema operativo desarrollado por Apple originalmente para su iPhone, aunque hoy día también es utilizado por otros dispositivos de la empresa.

Apple sólo permite que este sistema operativo funcione sobre hardware Apple. Es un sistema operativo derivado del Mac OS X, también de Apple.

En octubre de 2010 la tienda de aplicaciones de Apple (servicio de descarga de aplicaciones), llamada Apple Store, disponía ya de más de 300000 productos. A finales de 2010 la cuota de mercado de iOS en los dispositivos móviles que se vendían era de aproximadamente un 17%.

Como se ha comentado antes, los únicos dispositivos que incorporan este sistema operativo son los distintos modelos de dispositivos fabricados por la propia compañía Apple. Es decir, los iPhones (iPhone, iPhone 3G, iPhone 3GS, iPhone 4, etc.), el iPod Touch, el iPad, y la Apple TV.

Para desarrollar aplicaciones sobre iOS, las aplicaciones deben ser compiladas específicamente para este sistema operativo basado en la arquitectura ARM. Para ello puede utilizarse el kit de desarrollo iPhone SDK. El lenguaje de programación principal para este conjunto de herramientas es el Objective-C. Para poder utilizar este kit de desarrollo es necesario un ordenador MAC con un sistema operativo MAC OS X Leopard o superior. A mediados de 2011 ni el entorno .NET y ni Adobe Flash son soportados por iOS. Lo mismo sucede con Java, aunque se han producido algunos intentos de máquinas virtuales de Java (basadas en JAVA ME) para iOS, que rozan la legalidad a la que están sometidas las restrictivas licencias de Apple. Por supuesto, siempre habrá comunidades de usuarios y desarrolladores que intentarán saltarse estas restricciones (para más información al respecto puedes consultar el término iOS Jailbreaking en la web).

El iOS SDK se puede descargar gratuitamente, aunque es necesario registrarse en el Programa de Desarrollo del iPhone para poder publicar el software creado, lo cual requiere la aprobación de la compañía Apple y un pago por ese servicio, que proporcionará al programador las claves firmadas que le permitirán publicar en la Apple Store.

### Entornos integrados de trabajo.

### Módulos para el desarrollo de aplicaciones móviles.

### Emuladores.

### Configuraciones. Tipos y características. Dispositivos soportados.


### Perfiles. Características. Arquitectura y requerimientos. Dispositivos soportados.


### Ciclo de vida de una aplicación: descubrimiento, instalación, ejecución, actualización y borrado.

### Modificación de aplicaciones existentes.

### Utilización del entorno de ejecución del administrador de aplicaciones.

