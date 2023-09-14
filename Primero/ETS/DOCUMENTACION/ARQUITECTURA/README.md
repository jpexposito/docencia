<div align="justify">

# Arquitectura

</br>

<div align="center">
  <img src="https://www.researchgate.net/profile/Luis-Olsina/publication/334958467/figure/fig1/AS:788149827555328@1564920970309/Modelo-de-tres-capas-para-una-arquitectura-de-software-distribuida-homogenea.png" width="450px" />
</div>

</br>

  Incluso un software de tamaño pequeño consta de la composición de varios módulos o partes interconectados de alguna forma. La descripción de la arquitectura del sistema informa sobre cuáles son estas partes, qué rol tienen dentro del software y la forma en que estas se organizan e interconectan.

  La información sobre la arquitectura debería incluir como mínimo:
  - __Descripción jerárquica__: Indica de qué forma se organizan jerárquicamente los componentes del sistema. Es decir, indicar si los mismos están organizados en paquetes, espacios de nombres o bien si el software posee una estructura monolítica.

  <div align="center">
    <img src="https://www.desarrollodepaginasweb.com.mx/wp-content/uploads/2018/08/patrones-de-arquitectura-de-software.png" width="350px" />
  </div>

  </br>
  - __Diagrama de módulos__: Consiste en un diagrama donde se representan todas las partes que componen el sistema y las relaciones que existen entre estas. El objetivo de este diagrama consiste en presentar una perspectiva global de la arquitectura y los componentes del sistema, no debería contener detalles técnicos sobre los módulos o las conexiones entre estos.
  - __Descripción individual de los módulos__: Para cada módulo o parte del sistema, se debería realizar una breve descripción del mismo, la cual debería incluir mínimamente:
    - _Descripción general y propósito_: ¿qué es y qué debería hacer el módulo?
    - _Responsabilidad y restricciones_: ¿cuál es su función específica dentro del sistema? ¿qué cosas puede y no puede hacer?
    - _Dependencias_: Indicar cuales son los requisitos del módulo, es decir se debe contestar a preguntas tales como ¿qué necesita o requiere el módulo para funcionar? ¿necesita de servicios brindados por otros módulos o por librerías externas?
    - _Implementación_: indicar en qué archivo o archivos se encuentra la implementación del módulo.
    No es el objetivo de esta sección dar detalles de cómo se realiza la implementación de los módulos, sino únicamente dar una idea general de para qué existe el módulo dentro del sistema.
  - __Dependencias externas__: Si el software utiliza librerías o servicios externos estos deben listarse junto con una breve descripción de las mismas.

Adicionalmente en esta sección se deben listar los aspectos técnicos o tecnologías empleadas en el proyecto, ___tales como el lenguaje de programación, frameworks, librerías, etc___. Puede resultar de utilidad incluir junto a estos una breve descripción de las decisiones de diseño asociadas que llevaron a elegir la o las tecnologías en particular, es decir responder a ___¿por qué se utilizó esta tecnología y no otra?___.

</div>
