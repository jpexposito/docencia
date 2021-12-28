<div align="justify">

# Servicios implicados en el despliegue de una aplicación Web (Despliegue de aplicaciones web).  
  
<div align="center">
  <img src="https://cybercom.com/images/18.403ac7ba177db4f8d1a35bae/1614864782653/CI_CD_przezroczyste.png" width="500px" />
</div>

___En este tema nos vamos a ir realizando una serie de preguntas, para llegar finalmente a la respuesta___.

## 1. ¿Cómo era el desarrollo y despliegue de aplicaciones?

### El despliegue en el pasado

  La forma tradicional de un sitio web era crear las diferentes páginas html en el __entorno de desarrollo__, con la respectiva funcionalidad, que se ejecutaba en el cliente. En el __entorno de producción__ _(servidor web, el despliegue se realizaba usando un cliente ftp, para subir los ficheros al servidor)_.

  En él se veían implicados como vemos: ftp, dns, hosting etc. Todas acciones se realizaban generalmente en un __proceso donde la interacción es humana y sobre toda repetitiva__.

  <div align="center">
    <img src="https://miro.medium.com/max/1400/0*seEqG3JtD2RO_8k8" width="400px" />
  </div>
  </br>

  La pregunta que nos podríamos realizar es: ___¿Será para toda la vida?___.

### Entornos utilizados

  Se pueden tener varios entornos como el __local, o el de desarrollo__, para que en este último se publiquen ahí los cambios, para realizar las respectivas pruebas antes de moverse a __producción__.
  Los entornos adicionales pueden ser un entorno de preparación (también conocido como sitio de preparación o staging).

  _La cantidad de entornos necesarios depende del equipo de trabajo y de la complejidad del proyecto en el que se esté trabajando_.

  El número de entornos generalmente será el que se muestra en la siguiente imagen:

  <div align="center">
    <img src="https://lh5.googleusercontent.com/NPbifuNe-e_CbyxsmeHzNppXPasxD482F8WRHHtZ_42rgi1pjX1tRtK7ODs9SCds-Rd924Rzoo5wrGyep55OBBIV62ieVznzkrO5zHdaQRtjNoyaoN6lrfVSs8RplwXkjMjthjz3" width="300px" />
  </div>

  </br>

  ___Pregunta: ¿Tengo que hacer los despliegues en cada uno de los entornos de forma tradicional?___.

### Errores comunes en el desarrollo de aplicaciones

  No existe aplicación perfecta, ni desarrollador que ejecute un desarrollo de forma correcta inicial, por mucha experiencia que se tenga. Los errores más comunes a los que nos vamos a enfrentar son:

#### Problemas de trabajo en equipo.

  No existe trabajo en equipo, ni uso de herramientas que permitan la gestión, la puesta en común del código. Esto se conoce como: ___Guerra de guerrillas___.

#### Aplicaciones son testear.

  Las aplicaciones no se testean (prueban), lo que repercute en que lleguen al _entorno de producción con errores_.

#### Arquitecturas NO ESCALABLES.

  La arquitectura de la aplicación no esta preparada para soportar altas cargas de peticiones. _Lo cual genera un problema_.

  ___Pregunta: ¿Todos estos problemas descritos generan un nuevo despliegue?___.

  La respuesta a todas estas preguntas es ___SI___, y resulta un __trabajo tedioso y monótono__.

  </br>
  <div align="center">
    <img src="https://imagenes.elpais.com/resizer/Psh303KBBpjrrIN70zU1pjqEwv8=/1960x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/BH6YVCPDPL52NT2L4YZEM7XURI.jpg" width="300px" />
  </div>

## 2. El desarrollo y despliegue de aplicaciones en la actualidad.

  Se pueden destacar 5 pasos en el proceso de despliegue de nuestras aplicaciones en la actualidad:
  - __Planeación__. El plan debe incluir reglas sobre cuándo implementar desde los diferentes entornos, al entorno en vivo o producción. Tener un plan, reduce el riesgo de conflictos entre los diferentes cambios y se asegura de que el proceso de implementación sea lo más fluido y sencillo posible.
  - __Desarrollo__. Una vez se determina el plan se procede a desarrollar las diferentes tareas de la aplicación, en el entorno local o de desarrollo. Finalizado el proceso de desarrollo, se realizan las pruebas de código.
  - __Pruebas__. Probar los cambios es crucial para asegurarse de que ningún error llegue al entorno de producción final. Una vez probados los cambios en el entorno local o de desarrollo, se pueden implementar los cambios en el siguiente entorno (como el de ensayo o staging), donde se deben realizar las pruebas de control de calidad finales. Una vez probado todo se implementa en vivo.
  - __Despliegue en el entorno en vivo__. Terminadas las pruebas y solucionados los errores, se procede a implementar los cambios en el entorno en vivo.
  - __Monitoreo de los cambios__. Estando los cambios en el entorno de producción, es muy importante monitorear constantemente la aplicación para evitar que los usuarios tengan una mala experiencia con ella. Es recomendable al momento de realizar el despliegue a producción realizarse en una hora que no perturbe a muchos usuarios, para realizar las respectivas pruebas en el entorno y que de esta manera se pueda solucionar rápidamente el problema o se puedan revertir los cambios a tiempo.

  Teniendo en cuenta todo lo anteriormente descrito, hemos de hacer uso de herramientas que favorezcan:
    - La Planificación.
    - Pruebas.
    - Despliegue.
    - Monitorización.

### ¿Cuáles son las ventajas?
  - __Se reduce el riesgo en el que la aplicación se rompa__. Esta es una principales razones para usar múltiples entornos, de esta manera se reduce el riesgo de que los cambios tengan un impacto negativo.
  - __Ahorro de tiempo__. Sin la preocupación de que se rompa algo, se puede optimizar el flujo de trabajo para realizar los cambios. Si está trabajando en el entorno local, los cambios se procesan más rápido y a la hora de la implementación, se ahorra tiempo.
  - __Lo prioritario es sencillo de actualizar__. Hay contenido que puede tener mucha mayor prioridad y ser sensible para algunos usuarios, el poder realizar el despliegue en diferentes entornos para realizar las pruebas pertinentes, ayuda que se pueda cumplir en plan de despliegue al entorno de producción, de forma efectiva.

  ___Pregunta: ¿Cómo puedo hacer todo esto si parece que debo de trabajar mucho más?___.

## 3. La respuesta: CI/DC.

<div align="center">
  <img src="https://miro.medium.com/max/1400/0*HDGKaQN2dkbfXgav" width="600px" />
</div>

### ¿Qué es CI/CD?

  __Es una práctica recomendada de las metodologías ágiles__, que implementan los __equipos de desarrollo__ junto con la __infraestructura__, para con ella ___cumplir los requerimientos, hacer código de calidad y pensar en que la aplicación sea segura de usar___.

  __CI/CD__ incorpora una __automatización continua__ y un __control permanente en el ciclo de vida de la aplicación__.
  - __CI__. _Continuous Integration o Integración Contínua_. Se integran los cambios en el código a la rama principal de un repositorio común. Para evitar que cada desarrollador, cree código de manera aislado y que se una todo en el despliegue a producción, se trabaja realizando un flujo de trabajo donde cada desarrollador contribuye a una parte del repositorio, dependiendo de las tareas que deba realizar. Con el CI, las integraciones de código son más rápidas y con mayor frecuencia.

  - __CD__ _Continuous Delivery/Deployment o Entrega Contínua_. Inicia donde termina la CI, el CD automatiza la entrega de aplicaciones a determinados entornos, para permitir implementaciones fáciles y confiables en el entorno de producción. En la Entrega Continua, los despliegues ocurren frecuentemente, al ser automatizados los procesos no se requiere de procesos manuales. Los despliegues a producción no requieren una validación manual, si se identifica una falla en el proceso o se identifica un error este proceso se detiene.

  <div align="center">
    <img src="https://www.techuz.com/blog/wp-content/uploads/2019/06/CI-CD_Banner-1.jpg" width="600px" />
  </div>  

## Referencias
- [Integración y despliegue continuo en Redhat](https://www.redhat.com/es/topics/devops/what-is-ci-cd).



</div>
