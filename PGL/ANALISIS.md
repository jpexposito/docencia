# Análisis

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

En la actualidad han desaparecido multitud de lenguajes y sistemas operativos. Veamos como se encuentra el mercado a 31 de diciembre de 2020.

<img align="center" src="../img/so-smarthones2020.png" alt="Entornos de desarrollo integrado">



### Entornos integrados de trabajo.

### Módulos para el desarrollo de aplicaciones móviles.

### Emuladores.

### Configuraciones. Tipos y características. Dispositivos soportados.


### Perfiles. Características. Arquitectura y requerimientos. Dispositivos soportados.


### Ciclo de vida de una aplicación: descubrimiento, instalación, ejecución, actualización y borrado.

### Modificación de aplicaciones existentes.

### Utilización del entorno de ejecución del administrador de aplicaciones.

