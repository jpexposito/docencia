<div align="justify">

<div align="center">
  <img src="https://static3.abc.es/Media/201503/25/39295348--644x362.jpg" />
</div>

</br>

  Una empresa de transporte de mercancías quiere hacer una supervisión de todos los camiones de los que dispone. Para eso ha diseñado una nueva aplicación web llamada GPSPuerto.

  En esta aplicación un administrador registra unos GPS especiales con 4G y les asigna un nombre. Básicamente el nombre es la matrícula del camión o furgoneta.

  Para la aplicación un GPS y un vehículo es la misma cosa.

  El administrador programa unas rutas para cada transporte con una fecha/hora de salida, fecha/hora de llegada (prevista). Y de esa manera se puede conocer qué vehículos están operativos en un momento determinado.

  Estos GPS envían cada 5 minutos la localización exacta del dispositivo a la web mediante comunicación 4G.

  El administrador puede acceder a un mapa en el que aparecen en el mismo geolocalizados los distintos camiones y dependiendo de su ubicación puede modificar la ruta. Dentro del mismo mapa puede elegir mostrar solamente aquellos vehículos que tengan una ruta programada en ese momento. También puede pedir mostrar aquellos vehículos que no tienen ninguna ruta programada y de esa manera ver dónde se ubican por si hiciese falta realizar un porte. El administrador generalmente elige el vehículo más cerca del origen de la ruta.

## Se pide:

  Realice el diagrama de casos de uso del sistema GPSPuerto.

  [Solución en Casos de Uso](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&nav=1&title=gps.drawio#Uhttps%3A%2F%2Fdrive.google.com%2Fuc%3Fid%3D18l2tf7L_WNP5hujetdGB8zo_i4wY0_oY%26export%3Ddownload)

## Especificación de Casos de Uso:

<div align="center">
  <img src="https://static3.abc.es/Media/201503/25/39295348--644x362.jpg" />
</div>

## Índice
  - [Introducción](#introducción).
  - [Descripción](#descripción).
  - [Especificación de actores](#especificación-de-actores).
  - [Especificación de casos de uso](#especificación-de-casos-de-uso-1).

### Introducción

  El presente documento especifica el __diagrama de casos de uso__ de la aplicación __GPSNorte__ solicitada por la empresa de transporte del norte de Tenerife.

  Este documento trata a grandes rasgos, los casos de uso identificados, así como los actores que intervienen en ellos.

  <div align="center">
    <img src="img/gps.png" />
  </div>

### Descripción

  Una empresa de transporte de mercancías quiere hacer una supervisión de todos los camiones de los que dispone. Para ello, se han especificado una serie de requisitos descritos en el presente documento.

### Especificación de Actores

  En el presente documento se realiza la especificación de los diferentes actores que intervienen en la solución propuesta.

#### GPS

  |  Actor | GPS |
  |---|---|
  | Descripción  | Sistema encargado del envío de la señal de gps cada 5 minutos  |
  | Características  | |
  | Relaciones |   |
  | Referencias | __Enviar ubicación__ |   
  |  Notas |   |
  | Autor  | _Joatham Pérez Expósito_ |
  |Fecha | _01/12/2021_ |

  |  Atributo |||
  |---|---|---|
  | _Nombre_  | _Descripción_  | _Tipo_ |
  | ubicación | Ubicación del vehículo | double[2] |

#### Administrador

  |  Actor | GPS |
  |---|---|
  | Descripción  | Gestor de GPSPuerto | |
  | Relaciones |   |
  | Referencias | __Elegir Vehículo, Programar Ruta, Registrar GPS, Visualizar Mapa (Vehículos Activos Vehículos Parados), Modificar Ruta , Mostrar Ruta (Programadas, No Programadas)__ |   
  |  Notas |   |
  | Autor  | _Joatham Pérez Expósito_ |
  |Fecha | _01/12/2021_ |

### Especificación de Casos de uso

#### Elegir Vehículo

|  Caso de Uso	CU | Elegir Vehículo |
|---|---|
| Fuentes  | El caso de uso se sustenta en [este documento](https://github.com/jpexposito/docencia/blob/master/ETS/DIAGRAMAS/ejemplos/gps.md).  |
| Actor  |  Administrador |
| Descripción | El administrador elige el vehículo más cerca del origen de la ruta. |
| Flujo básico | El administrador realizara la elección de un vehículo que previamente debe estar dado de alta, para seleccionar el más cercano. |
| Pre-condiciones | El vehículo debe de estar dado de alta, el vehículo debe estar disponible. |  
| Post-condiciones  | Seleccionar vehículo / Seleccionar Ruta. |  
|  Requerimientos |  |
|  Notas |  |
| Autor  | _Joatham Pérez Expósito_ |
|Fecha | _01/12/21_ |

#### Programar Ruta

|  Caso de Uso	CU | Programar Ruta |
|---|---|
| Fuentes  | El caso de uso se sustenta en [este documento](https://github.com/jpexposito/docencia/blob/master/ETS/DIAGRAMAS/ejemplos/gps.md).  |
| Actor  |  Administrador |
| Descripción | El administrador programa unas rutas para cada transporte con una fecha/hora de salida, fecha/hora de llegada (prevista). Y de esa manera se puede conocer qué vehículos están operativos en un momento determinado. |
| Flujo básico | El administrador seleccionara un vehículo para programar la ruta adecuada. |
| Pre-condiciones | Seleccionar vehículo disponible. |  
| Post-condiciones  |  |  
|  Requerimientos |  |
|  Notas |  |
| Autor  | _Joatham Pérez Expósito_ |
|Fecha | _01/12/21_ |

#### Registrar GPS

|  Caso de Uso	CU | Registrar GPS |
|---|---|
| Fuentes  | El caso de uso se sustenta en [este documento](https://github.com/jpexposito/docencia/blob/master/ETS/DIAGRAMAS/ejemplos/gps.md).  |
| Actor  |  Administrador |
| Descripción | El administrador guarda un gps/vehículo en la aplicación. |
| Flujo básico | El administrador realiza el almacenamiento del GPS para la adjudicación de una ruta. |
| Pre-condiciones |  |  
| Post-condiciones  | Programar ruta |  
|  Requerimientos |  |
|  Notas |  |
| Autor  | _Joatham Pérez Expósito_ |
|Fecha | _01/12/21_ |

#### Visualizar Mapa

|  Caso de Uso	CU | Visualizar Mapa |
|---|---|
| Fuentes  | El caso de uso se sustenta en [este documento](https://github.com/jpexposito/docencia/blob/master/ETS/DIAGRAMAS/ejemplos/gps.md).  |
| Actor  |  Administrador |
| Descripción | El administrador puede acceder a un mapa en el que aparecen en el mismo geolocalizados los distintos camiones. |
| Flujo básico | Escoger mapa, para seleccionar el tipo de vehículos. |
| Pre-condiciones |  |  
| Post-condiciones | Visualizar vehículo activos / parados. |  
| Requerimientos |  |
| Notas |  |
| Autor  | _Joatham Pérez Expósito_ |
| Fecha | _01/12/21_ |

##### Visualizar Mapa Vehículos Activos

|  Caso de Uso	CU | Visualizar Mapa Vehículos Activos |
|---|---|
| Fuentes  | El caso de uso se sustenta en [este documento](https://github.com/jpexposito/docencia/blob/master/ETS/DIAGRAMAS/ejemplos/gps.md).  |
| Actor  |  Administrador |
| Descripción | Muestra los vehículos activos |
| Flujo básico | Seleccionar un mapa, y sobre este escoger los vehículos activos |
| Pre-condiciones | Visualizar Mapa |  
| Post-condiciones  |  |  
| Requerimientos |  |
| Notas |  |
| Autor  | _Joatham Pérez Expósito_ |
| Fecha | _01/12/21_ |

##### Visualizar Mapa Vehículos No Activos

|  Caso de Uso	CU | Visualizar Mapa Vehículos No Activos |
|---|---|
| Fuentes  | El caso de uso se sustenta en [este documento](https://github.com/jpexposito/docencia/blob/master/ETS/DIAGRAMAS/ejemplos/gps.md).  |
| Actor  |  Administrador |
| Descripción | Muestra los vehículos activos |
| Flujo básico | Seleccionar un mapa, y sobre este escoger los vehículos no activos |
| Pre-condiciones | Visualizar Mapa |  
| Post-condiciones  |  |  
| Requerimientos |  |
| Notas |  |
| Autor  | _Joatham Pérez Expósito_ |
| Fecha | _01/12/21_ |

#### Modificar Ruta

|  Caso de Uso	CU | Modificar Ruta  |
|---|---|
| Fuentes  | El caso de uso se sustenta en [este documento](https://github.com/jpexposito/docencia/blob/master/ETS/DIAGRAMAS/ejemplos/gps.md).  |
| Actor  |  Administrador |
| Descripción | La aplicación permite la modificación de una ruta creada. |
| Flujo básico | Seleccionar un vehículo/ruta y realizar su modificación |
| Pre-condiciones | Seleccionar de vehículo/ruta |  
| Post-condiciones  |  |  
|  Requerimientos |  |
|  Notas |  |
| Autor  | _Joatham Pérez Expósito_ |
|Fecha | _01/12/21_ |

#### Mostrar Ruta

|  Caso de Uso	CU | Mostrar Ruta  |
|---|---|
| Fuentes  | El caso de uso se sustenta en [este documento](https://github.com/jpexposito/docencia/blob/master/ETS/DIAGRAMAS/ejemplos/gps.md).  |
| Actor  |  Administrador |
| Descripción | La aplicación permite mostrar una ruta creada. |
| Flujo básico | Seleccionar un vehículo/ruta y mostrar |
| Pre-condiciones | Seleccionar de vehículo/ruta |  
| Post-condiciones  |  |  
| Requerimientos |  |
| Notas |  |
| Autor  | _Joatham Pérez Expósito_ |
|Fecha | _01/12/21_ |

#### Mostrar Ruta Programada

|  Caso de Uso	CU | Mostrar Ruta  |
|---|---|
| Fuentes  | El caso de uso se sustenta en [este documento](https://github.com/jpexposito/docencia/blob/master/ETS/DIAGRAMAS/ejemplos/gps.md).  |
| Actor  |  Administrador |
| Descripción | La aplicación permite mostrar una ruta creada y que se encuentra programada |
| Flujo básico | Seleccionar un vehículo/ruta y mostrar la ruta programada. |
| Pre-condiciones | Seleccionar de vehículo/ruta |  
| Post-condiciones  |  |  
| Requerimientos |  |
| Notas |  |
| Autor  | _Joatham Pérez Expósito_ |
|Fecha | _01/12/21_ |

#### Mostrar Ruta No Programada

|  Caso de Uso	CU | Mostrar Ruta  |
|---|---|
| Fuentes  | El caso de uso se sustenta en [este documento](https://github.com/jpexposito/docencia/blob/master/ETS/DIAGRAMAS/ejemplos/gps.md).  |
| Actor  |  Administrador |
| Descripción | La aplicación permite mostrar una ruta creada y que se encuentra programada |
| Flujo básico | Seleccionar un vehículo/ruta y mostrar la ruta no programada. |
| Pre-condiciones | Seleccionar de vehículo/ruta |  
| Post-condiciones  |  |  
| Requerimientos |  |
| Notas |  |
| Autor  | _Joatham Pérez Expósito_ |
|Fecha | _01/12/21_ |

#### Enviar Ubicación

|  Caso de Uso	CU | Enviar Ubicación |
|---|---|
| Fuentes  | El caso de uso se sustenta en [este documento](https://github.com/jpexposito/docencia/blob/master/ETS/DIAGRAMAS/ejemplos/gps.md).  |
| Actor  |  GPS |
| Descripción | El sistema enviará su ubicación cada 5 minutos. |
| Flujo básico | El sistema debe ser automata para el envío de su ubicación |
| Pre-condiciones |  |  
| Post-condiciones  |  |  
|  Requerimientos |  |
|  Notas |  |
| Autor  | _Joatham Pérez Expósito_ |
|Fecha | _01/12/21_ |

<div>
