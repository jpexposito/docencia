# Documentación y Sistemas de control de versiones

 Se llama control de versiones a la gestión de los diversos cambios que se realizan sobre los elementos de algún producto o una configuración del mismo. Una versión, revisión o edición de un producto, es el estado en el que se encuentra el mismo en un momento dado de su desarrollo o modificación.

 Aunque un sistema de control de versiones puede realizarse de forma manual, es muy aconsejable disponer de herramientas que faciliten esta gestión dando lugar a los llamados sistemas de control de versiones o VCS (del inglés Version Control System). Estos sistemas facilitan la administración de las distintas versiones de cada producto desarrollado, así como las posibles especializaciones realizadas (por ejemplo, para algún cliente específico). Ejemplos de este tipo de herramientas son entre otros: CVS, Subversion, SourceSafe, ClearCase, Darcs, Bazaar, Plastic SCM, Git, SCCS, Mercurial, Perforce, Fossil SCM, Team Foundation Server.

 El control de versiones se realiza principalmente en la industria informática para controlar las distintas versiones del código fuente dando lugar a los sistemas de control de código fuente o SCM (siglas del inglés Source Code Management). Sin embargo, los mismos conceptos son aplicables a otros ámbitos como documentos, imágenes, sitios web, etc.


## Características

 Un sistema de control de versiones debe proporcionar:
  - Mecanismo de almacenamiento de los elementos que deba gestionar (ej. archivos de texto, imágenes, documentación...).
  - Posibilidad de realizar cambios sobre los elementos almacenados (ej. modificaciones parciales, añadir, borrar, renombrar o mover elementos).
  - Registro histórico de las acciones realizadas con cada elemento o conjunto de elementos (normalmente pudiendo volver o extraer un estado anterior del producto).

  Aunque no es estrictamente necesario, suele ser muy útil la generación de informes con los cambios introducidos entre dos versiones, informes de estado, marcado con nombre identificativo de la versión de un conjunto de ficheros, etc.

## Terminología

  La terminología empleada puede variar de sistema a sistema, pero a continuación se describen algunos términos de uso común.

### Repositorio

  El repositorio es el lugar en el que se almacenan los datos actualizados e históricos de cambios, a menudo en un servidor. A veces se le denomina depósito o depot. Puede ser un sistema de archivos en un disco duro, un banco de datos, etc..

### Módulo

   Conjunto de directorios y/o archivos dentro del repositorio que pertenecen a un proyecto común.

### Revisión ("version")

   Una revisión es una versión determinada de la información que se gestiona. Hay sistemas que identifican las revisiones con un contador (Ej. subversion). Hay otros sistemas que identifican las revisiones mediante un código de detección de modificaciones (Ej. Git usa SHA1). A la última versión se le suele identificar de forma especial con el nombre de HEAD. Para marcar una revisión concreta se usan los rótulos o tags.

### Rotular ("tag")

   Darle a alguna versión de cada uno de los ficheros del módulo en desarrollo en un momento preciso un nombre común ("etiqueta" o "rótulo") para asegurarse de reencontrar ese estado de desarrollo posteriormente bajo ese nombre. En la práctica se rotula a todos los archivos en un momento determinado. Para eso el módulo se "congela" durante el rotulado para imponer una versión coherente. Pero bajo ciertas circunstancias puede ser necesario utilizar versiones de algunos ficheros que no coinciden temporalmente con las de los otros ficheros del módulo.

   Los tags permiten identificar de forma fácil revisiones importantes en el proyecto. Por ejemplo se suelen usar tags para identificar el contenido de las versiones publicadas del proyecto.

   En algunos sistemas se considera un tag como una rama en la que los ficheros no evolucionan, están congelados.

### Línea base ("baseline")

   Una revisión aprobada de un documento o fichero fuente, a partir del cual se pueden realizar cambios subsiguientes.

### Abrir rama ("branch") o ramificar

   Un módulo puede ser branched o bifurcado en un instante de tiempo de forma que, desde ese momento en adelante se tienen dos copias (ramas) que evolucionan de forma independiente siguiendo su propia línea de desarrollo. El módulo tiene entonces 2 (o más) "ramas". La ventaja es que se puede hacer un "merge" de las modificaciones de ambas ramas, posibilitando la creación de "ramas de prueba" que contengan código para evaluación, si se decide que las modificaciones realizadas en la "rama de prueba" sean preservadas, se hace un "merge" con la rama principal. Son motivos habituales para la creación de ramas la creación de nuevas funcionalidades o la corrección de errores.

### Desplegar ("Check-out", "checkout", "co")

   Un despliegue crea una copia de trabajo local desde el repositorio. Se puede especificar una revisión concreta, y predeterminadamente se suele obtener la última.

### "Publicar" o "Enviar" ("commit", "check-in", "ci", "install", "submit")

   Un commit sucede cuando una copia de los cambios hechos a una copia local es escrita o integrada sobre el repositorio.

### Conflicto

   Un conflicto ocurre cuando el sistema no puede manejar adecuadamente cambios realizados por dos o más usuarios en un mismo archivo. Por ejemplo, si se da esta secuencia de circunstancias:
    - Los usuarios X e Y despliegan versiones del archivo A en que las líneas n1 hasta n2 son comunes.
    - El usuario X envía cambios entre las líneas n1 y n2 al archivo A.
    - El usuario Y no actualiza el archivo A tras el envío del usuario X.
    - El usuario Y realiza cambios entre las líneas n1 y n2.
    - El usuario Y intenta posteriormente enviar esos cambios al archivo A.
    - El sistema es incapaz de fusionar los cambios. El usuario Y debe resolver el conflicto combinando los cambios, o eligiendo uno de ellos para descartar el otro.

### Resolver

   El acto de la intervención del usuario para atender un conflicto entre diferentes cambios al mismo archivo.

### Cambio ("change", "diff", "delta")

   Un cambio representa una modificación específica a un archivo bajo control de versiones. La granularidad de la modificación considerada un cambio varía entre diferentes sistemas de control de versiones.

### Lista de cambios ("changelist", "change set", "patch")

   En muchos sistemas de control de versiones con commits multi-cambio atómicos, una lista de cambios identifica el conjunto de cambios hechos en un único commit. Esto también puede representar una vista secuencial del código fuente, permitiendo que el fuente sea examinado a partir de cualquier identificador de lista de cambios particular.

### Exportación ("export")

   Una exportación es similar a un check-out, salvo porque crea un árbol de directorios limpio sin los metadatos de control de versiones presentes en la copia de trabajo. Se utiliza a menudo de forma previa a la publicación de los contenidos.

### Importación ("import")
 
   Una importación es la acción de copia un árbol de directorios local (que no es en ese momento una copia de trabajo) en el repositorio por primera vez.

### Integración o fusión ("merge")
 
   Una integración o fusión une dos conjuntos de cambios sobre un fichero o un conjunto de ficheros en una revisión unificada de dicho fichero o ficheros.
 
   Esto puede suceder cuando un usuario, trabajando en esos ficheros, actualiza su copia local con los cambios realizados, y añadidos al repositorio, por otros usuarios. Análogamente, este mismo proceso puede ocurrir en el repositorio cuando un usuario intenta check-in sus cambios.
 
   Puede suceder después de que el código haya sido branched, y un problema anterior al branching sea arreglado en una rama, y se necesite incorporar dicho arreglo en la otra.
  
   Puede suceder después de que los ficheros hayan sido branched, desarrollados de forma independiente por un tiempo, y que entonces se haya requerido que fueran fundidos de nuevo en un único trunk unificado.

### Integración inversa

   El proceso de fundir ramas de diferentes equipos en el trunk principal del sistema de versiones.

### Actualización ("sync" o "update")
 
   Una actualización integra los cambios que han sido hechos en el repositorio (por ejemplo por otras personas) en la copia de trabajo local.

### Copia de trabajo ("workspace")

   La copia de trabajo es la copia local de los ficheros de un repositorio, en un momento del tiempo o revisión específicos. Todo el trabajo realizado sobre los ficheros en un repositorio se realiza inicialmente sobre una copia de trabajo, de ahí su nombre. Conceptualmente, es un cajón de arena o sandbox.

### Congelar

   Significa permitir los últimos cambios (commits) para solucionar las fallas a resolver en una entrega (release) y suspender cualquier otro cambio antes de una entrega, con el fin de obtener una versión consistente. Si no se congela el repositorio, un desarrollador podría comenzar a resolver una falla cuya resolución no está prevista y cuya solución dé lugar a efectos colaterales imprevistos.

 <img src="https://lh3.googleusercontent.com/-Txa_6CEnwuc/VmP4jONPIYI/AAAAAAAAB0o/Hjt91A7_1uo/s400-Ic42/pic1.jpg" alt="Operaciones sobre un respositorio">


## Formas de colaborar

 Para colaborar en un proyecto usando un sistema de control de versiones lo primero que hay que hacer es crearse una copia local obteniendo información del repositorio. A continuación el usuario puede modificar la copia. Existen dos esquemas básicos de funcionamiento para que los usuarios puedan ir aportando sus modificaciones:

  - _De forma exclusiva_: en este esquema para poder realizar un cambio es necesario comunicar al repositorio el elemento que se desea modificar y el sistema se encargará de impedir que otro usuario pueda modificar dicho elemento. Una vez hecha la modificación, esta se comparte con el resto de colaboradores. Si se ha terminado de modificar un elemento entonces se libera ese elemento para que otros lo puedan modificar.
 
  Este modo de funcionamiento es el que usa por ejemplo SourceSafe. Otros sistemas de control de versiones (ejemplo: subversion), aunque no obligan a usar este sistema, disponen de mecanismos que permiten implementarlo.
 
  - _De forma colaborativa_: en este esquema cada usuario modifica la copia local y cuando el usuario decide compartir los cambios el sistema automáticamente intenta combinar las diversas modificaciones. El principal problema es la posible aparición de conflictos que deban ser solucionados manualmente o las posibles inconsistencias que surjan al modificar el mismo fichero por varias personas no coordinadas. Además, esta semántica no es apropiada para ficheros binarios.
 
  __Los sistemas de control de versiones subversion o Git permiten implementar este modo de funcionamiento.__

  El control de versiones Team Foundation Server permite escoger cualquiera de las dos formas de colaboración.

## Arquitecturas de almacenamiento

 Podemos clasificar los sistemas de control de versiones atendiendo a la arquitectura utilizada para el almacenamiento del código:

  - _Distribuidos_: cada usuario tiene su propio repositorio. Los distintos repositorios pueden intercambiar y mezclar revisiones entre ellos. Es frecuente el uso de un repositorio, que está normalmente disponible, que sirve de punto de sincronización de los distintos repositorios locales. Ejemplos: Git y Mercurial.
 
  - _Centralizados_: existe un repositorio centralizado de todo el código, del cual es responsable un único usuario (o conjunto de ellos). Se facilitan las tareas administrativas a cambio de reducir flexibilidad, pues todas las decisiones fuertes (como crear una nueva rama) necesitan la aprobación del responsable. Algunos ejemplos son CVS, Subversion o Team Foundation Server.

 ### Ventajas de sistemas distribuidos

  - Necesita menos veces estar conectado a la red para hacer operaciones. Esto produce una mayor autonomía y una mayor rapidez.
 
  - Aunque se caiga el repositorio remoto la gente puede seguir trabajando
 
  - Al hacer de los distintos repositorio una réplica local de la información de los repositorios remotos a los que se conectan, la información está muy replicada y por tanto el sistema tiene menos problemas en recuperarse si por ejemplo se quema la máquina que tiene el repositorio remoto. Por tanto hay menos necesidad de backups. Sin embargo, los backups siguen siendo necesarios para resolver situaciones en las que cierta información todavía no haya sido replicada.
 
  - Permite mantener repositorios centrales más limpios en el sentido de que un usuario puede decidir que ciertos cambios realizados por él en el repositorio local, no son relevantes para el resto de usuarios y por tanto no permite que esa información sea accesible de forma pública, ya sea porque contiene versiones inestables, en proceso de codificación o con etiquetas personalizadas y de uso exclusivo del usuario.
 
  - El servidor remoto requiere menos recursos que los que necesitaría un servidor centralizado ya que gran parte del trabajo lo realizan los repositorios locales.
 
  - Al ser los sistemas distribuidos más recientes que los sistemas centralizados, y al tener más flexibilidad por tener un repositorio local y otro u otros remotos, estos sistemas han sido diseñados para hacer fácil el uso de ramas (creación, evolución y fusión) y poder aprovechar al máximo su potencial. Por ejemplo se pueden crear ramas en el repositorio remoto para corregir errores o crear funcionalidades nuevas. Pero también se pueden crear ramas en los repositorio locales para que los usuarios puedan hacer pruebas y dependiendo de los resultados fusionarlos con el desarrollo principal o no. Las ramas dan una gran flexibilidad en la forma de trabajo.

### Ventajas de sistemas centralizados

  - En los sistemas distribuidos hay menos control a la hora de trabajar en equipo ya que no se tiene una versión centralizada de todo lo que se está haciendo en el proyecto.
 
  - En los sistemas centralizados las versiones vienen identificadas por un número de versión. Sin embargo en los sistemas de control de versiones distribuidos no hay números de versión, ya que cada repositorio tendría sus propios números de revisión dependiendo de los cambios. En lugar de eso cada versión tiene un identificador al que se le puede asociar una etiqueta (tag).

## Flujos de trabajo

  El flujo de trabajo de un sistema de control de versiones indica cómo se relacionan los distintos usuarios para colaborar entre sí en la consecución de los objetivos del proyecto.

  En los sistemas de control de versiones centralizados el diseño del sistema restringe la forma en que los distintos usuarios colaboran entre sí. Sin embargo en los sistemas de control de versiones distribuidos hay mucha más flexibilidad en la forma de colaborar ya que cada desarrollador puede tanto contribuir como recibir contribuciones. Hay distintos flujos de trabajo, donde cada uno se adapta mejor a cierto tipo de proyectos. Veamos algunos ejemplo habituales que también se pueden combinar para así adaptarse mejor al proyecto concreto (por ejemplo podría usarse en general un flujo centralizado, y usar un gestor de integraciones para ciertas partes críticas y de especial importancia).

### Flujo de trabajo centralizado 

  En el flujo de trabajo centralizado (en inglés Centralized Workflow) cada desarrollador es un nodo de trabajo. Por otro lado hay un repositorio remoto central que funciona a modo de punto de sincronización. Todos los nodos de trabajo operan en pie de igualdad sobre el repositorio remoto central.

  Si se trata de un sistema de control de versiones distribuido cada nodo de trabajo consiste en un repositorio local privado.

  Una desventaja de este modo de trabajo es que si dos usuarios clonan desde un punto central, y ambos hacen cambios; tan solo el primero que envíe sus cambios lo podrá hacer limpiamente. El segundo desarrollador deberá fusionar previamente su trabajo con el del primero, antes de enviarlo, para evitar sobreescribir los cambios del primero. Es decir, es necesario hacer un paso previo ya que no se pueden subir cambios no directos (non-fast-forward changes).

### Flujo de trabajo con un Gestor de Integraciones

  En el flujo de trabajo con un Gestor de Integraciones (en inglés Integration-Manager Workflow) en el que cada desarrollador tiene acceso de escritura a un repositorio propio público y acceso de lectura a los repositorios públicos de todos los demás usuarios. Por otro lado hay un repositorio canónico, representante 'oficial' del proyecto.

  Para contribuir en estos proyectos cada desarrollador crea su propio clon público del repositorio canónico y envía sus cambios (realizados en un repositorio privado) a él. Para 'subir' sus cambios al repositorio canónico cada desarrollador tiene que realizar una petición a la persona gestora del mismo.

  La principal ventaja de esta forma de trabajar es que puedes continuar trabajando, y la persona gestora del repositorio canónico podrá recuperar tus cambios en cualquier momento. Las personas colaboradoras no tienen por qué esperar a que sus cambio sean incorporados al proyecto, cada cual puede trabajar a su propio ritmo.

### Flujo de trabajo con Dictador y Tenientes

  El flujo de trabajo con Dictador y Tenientes (en inglés Dictator and Lieutenants Workflow) es una ampliación del flujo de trabajo con gestor de integraciones. Es utilizado en proyectos muy grandes, con cientos de colaboradores, como el núcleo Linux.

  Hay una serie de gestores de integración que se encargan de partes concretas del repositorio, a los que se denominan tenientes. Todos los tenientes rinden cuentas a un gestor de integración; conocido como el dictador. El dictador integra todos los aportes de los tenientes publicando el trabajo en un repositorio de referencia del que recuperan todos los colaboradores.

  Este sistema de trabajo permite al líder del grupo (el dictador) delegar gran parte del trabajo en los tenientes, relegando su trabajo en recolectar el fruto de múltiples puntos de trabajo.

## Uso de ramas

  Las ramas, en un sistema de control de versiones, constituyen una potente herramienta que flexibiliza la forma en la que los colaboradores cooperan en el proyecto (en inglés Branching Workflows). Las ramas son solo una herramienta que es posible utilizar de distintas formas para conseguir distintos objetivos. Veamos algunas posibilidades.

   <img src="https://i.stack.imgur.com/mvLUy.png" alt="Operaciones sobre un respositorio">

### Ramas de largo recorrido

  En algunos proyectos se tienen varias ramas siempre abiertas, que indican diversos grados de estabilidad del contenido. Por ejemplo, en la rama ‘master’ es frecuente mantener únicamente lo que es totalmente estable. Luego se tienen otras ramas que revelan distintos grados de estabilidad. Por ejemplo podríamos tener una rama 'beta' (versión beta) y otra 'alfa' (versión alfa), en las que se va trabajando. Cuando se alcanza cierto grado de estabilidad superior a la rama en la que se está entonces se realiza una fusión con rama de estabilidad superior.

### Ramas puntuales

  Las ramas puntuales, también llamadas ramas de soporte, son ramas que se crean de forma puntual para realizar una funcionalidad muy concreta. Por ejemplo añadir una nueva característica (se les llama ramas de nueva funcionalidad o directamente por su nombre en inglés topic branch o feature branch) o corregir un fallo concreto (se les llama ramas para corregir error o directamente por su nombre en inglés hotfix branch).

  Este tipo de ramas permiten trabajar centrándonos exclusivamente en el desarrollo de una característica concreta y cuando esta esté concluida se fusiona con una de las ramas de largo recorrido (normalmente con la de más bajo nivel de estabilidad, para que sea probada en ese entorno). La fusión solo se realiza cuando se está 'seguro' de que esa característica está correctamente implementada, en lugar de fusionar en el orden que se van desarrollando las cosas. Esto permite por un lado tener un historial de las distintas versiones que se han tenido hasta conseguir la funcionalidad. Por otro lado permiten que el historial de las ramas de largo recorrido no sea 'ensuciados' con distintas modificaciones relativas a una funcionalidad concreta.

  El uso de este tipo de ramas permiten más flexibilidad a la hora de probar posibles soluciones. Solo se fusiona con ramas de largo recorrido una vez que estamos seguros de elegir la solución mejor.

  Un tipo de ramas de este tipo que tienen un funcionamiento especial son las llamadas ramas de versión o ramas de release (en inglés release branch). Este tipo de ramas se crean para dar soporte a la preparación de una nueva versión de producción. Permiten tener bajo control el contenido de la versión y poder realizar cierto mantenimiento sobre ella (añadirle pequeñas mejoras y corrección de errores).

  Es frecuente y una buena práctica utilizar en el nombre de la rama un prefijo que indique el tipo de rama de la que se trata. Por ejemplo podría usar ‘feature-’ para ramas de nueva funcionalidad, ‘hotfix-’ para ramas que arreglan errores, y ‘release-’ para ramas de versión.

- [Herramientas externas para la generación de documentación](GIT/HERRAMIENTAS.md)  
- [Instalación, configuración y uso de sistemas de control de versiones](GIT/INSTALACION.md)   
- [Operaciones avanzadas](GIT/OPERACIONES_ESENCIALES.md)   
- [Operaciones avanzadas](GIT/OPERACIONES_AVANZADAS.md)   
- [Seguridad de los sistemas de control de versiones](GIT/SEGURIDAD.md)  
- [Historia de un repositorio](GIT/HISTORIA.md)  
