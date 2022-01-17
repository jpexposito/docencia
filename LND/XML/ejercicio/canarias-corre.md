<div align="justify">

# CANARIAS CORRE


<div align="center">
  <img width="300px" src="https://www.maratonesespana.es/wp-content/uploads/2020/07/salida-maraton-tenerife.jpg">
</div>

  CanariasCorre es una empresa dedicada a la gestión de eventos deportivos al aire libre. Necesita pedir permisos al Cabildo de Tenerife para sus carreras, por lo que decide pasarle la información en formato XML, con las siguientes reglas:
  - El elemento raíz es canariascorre y contiene uno o más evento.
  - Cada evento tiene: titulo, km, uno o más organizador seguidos de uno o más
  participante.
  - El titulo y los km contienen texto.
  - Un organizador contiene: empresa, telefono, direccion y municipio.
  - Un participante contiene: nombre, telefono, direccion y municipio.
  - Empresa, nombre, telefono, direccion y municipio contienen texto.
  - El elemento evento tiene el atributo tipo que puede ser “carrera”, “trail” o
  “maraton” y es obligatorio.
  - El elemento evento también tiene el atributo fecha, texto obligatorio.
  - El elemento participante tiene el atributo categoria que puede ser “profesional” o
  “amateur”. Casi todos los corredores son amateur, de forma que sólo será
  necesario indicarlo cuando el participante sea un profesional.
  - El elemento nombre contiene el atributo sexo que puede ser H o M. Es
  obligatorio.
  - El elemento nombre también contiene el atributo atletafederado que puede valer
  si o no. Lo normal es que participen atletas que no están federados.

  Después crea el fichero canariascorre.xml con los siguientes datos:
  - EVENTO 1: es un maratón con fecha 08/05/2014. Su título es Anaga Maraton y tiene 42 km de recorrido.
    - Organizadores: la empresa Gesport Canarias con tfl 922740025. Está en la C/El Juego nº 25 de La Laguna. La empresa Producciones Anaga con tlf 922350035, que está en C/ Desengaño nº 21 de Santa Cruz de Tenerife.
    - Participan:
      - Esteban Jodrá, atleta federado y profesional. Tlf 630101010. C/Las Rosas 25 de Santa Cruz de Tenerife.
      - Eva Mérida, tlf 640000099, C/Las Margaritas 25, Santa Cruz de Tfe.
      - Ana Covadonga, federada, tfl 922787878, C/ Las Dalias nº 28, Arafo.
  - EVENTO 2: es una carrera con fecha 31/12/2014. Su título es IV San Silvestre El Médano y tiene 10 km de recorrido.
    - Organiza: Gesport Canarias con tfl 922740025. Está en la C/El Juego nº 25 de La Laguna.
    - Participan:
      - Javier Madrigal y Víctor Madrigal, hermanos, atletas federados y profesionales. Tlf 92220025. C/Las Petunias s/n, de La Laguna.

Genera los ficheros dtd, xsd y xml de la solución.
