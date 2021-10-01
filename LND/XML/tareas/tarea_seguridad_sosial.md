<div align="justify">

# Tarea Sistema de Información de la Seguridad Social


<div align="center">
  <img width="300px" src="https://static1.elcorreo.com/www/multimedia/201911/25/media/cortadas/carta-sms-seguridad-social-vida-laboral-2017-2018-2019-kIaG-U907937571379IF-624x385@El%20Correo.png">
</div>


## Se pide

  La Seguridad Social necesita un formato de intercambio unificado para distribuir la información personal de los afiliados.

  Todo archivo XML contiene un listado de uno o mas afiliados
  Todo afiliado tiene los siguientes elementos:
  - DNI o NIE
  - Nombre
  - Apellidos
  - Situación laboral: que tiene que ser una y solo una de entre estas posibilidades: «en_paro», _en_activo_, _jubilado_, _edad_no_laboral_
  - Fecha de nacimiento: que se desglosa en los elementos obligatorios día, mes y anio.
  - Listado de bajas: que indica las situaciones de baja laboral del empleado. Dicho listado consta de una repetición de 0 o más bajas:
    - Una baja consta de tres elementos: causa (obligatoria), fecha de inicio (obligatorio) y fecha de final (optativa),
  - Listado de prestaciones cobradas: consta de 0 o más elementos prestación, donde se indicará la cantidad percibida (obligatorio), la fecha de inicio (obligatorio) y la fecha de final (obligatorio).

  ## Entrega

    - Recuerda que debes de generar el informe en __pdf__ + __github__ (enlace en la descripción de la entrega de la tarea).
    - La entrega fuera de hora supondrá un __40%__ menos de la __nota__.
