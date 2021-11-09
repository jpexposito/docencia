<div align="justify">

# Elaboración de Diagramas

## Lenguaje de Modelado Unificado (UML)

<div align="center">
  <img src="https://folderit.net/wp-content/uploads/2014/06/uml-logo.jpg"  />
</div>


  Es un lenguaje de modelado universal para el campo del desarrollo de software que sirve de estándar a la hora de diseñar los sistemas.

  _No es un lenguaje para crear programas_ sino para diseñar partes del mismo, su estructura, cómo se relaciona con otras partes del programa, cómo se comporta o funciona ante un usuario, los estado por los que puede pasar en su ejecución, etc. **UML es un lenguaje, por lo que usa unos símbolos concretos para cada modelo**.

  Dentro de la familia de diagramas UML hay tipos más usados habitualmente, aunque cada uno tiene su finalidad:

  <div align="center">
    <img src="http://entornos.codeandcoke.com/lib/exe/fetch.php?cache=&w=900&h=450&tok=bb96cb&media=apuntes:diagramas_uml.png"  />
  </div>



### Diagramas de Casos de Uso

Un diagrama de casos de uso es una lista de pasos que definen la interacción entre un actor y el sistema propiamente dicho. Deben cumplir los siguientes objetivos:

- Indicar los requisitos funcionales: cómo funciona un programa/sistema.
- Proporcionar una descripción clara de su uso: cómo el usuario interactúa con el sistema.
- Se debe leer con claridad.
- Orientar en la realización de pruebas: nos dice cómo debe funcionar (requisitos).
- Sirve de guía para crear la documentación de uso del programa.

Un diagrama de casos de uso debe mostrar a simple vista, qué se puede hacer con un programa desde el punto de vista de un usuario. Cada cosa que el usuario hace, _es un caso de uso_.

### Elementos de un diagrama de casos de uso

UML es un lenguaje, por lo que debemos usar su notación concreta para cada elemento:

- __Actores__: Es cualquier cosa que interactúa con el sistema, y es externo a él. No es necesariamente una persona, puede ser un dispositivo u otro sistema. Se representan mediante un _monigote_.
- __Casos de uso__: Representan el funcionamiento que se produce tras la orden de un actor. Se representan con una _elipse_, y dentro se escribe la descripción textual.
- __Relaciones__: Relacionan a los actores con los casos de uso, aunque en algunos casos también permiten relacionar unos casos de uso con otros.
- __Un rectángulo__ se usa para representar los límites del sistema, si es necesario.

<div align="center">
  <img src="http://entornos.codeandcoke.com/lib/exe/fetch.php?w=400&tok=45df1c&media=apuntes:notacion_caso_de_uso.png
"  />
</div>

**Para diseñar un diagrama de casos de uso se comienza por reconocer los actores y los casos de uso, para posteriormente relacionarlos.**

<div align="center">
  <img src="http://entornos.codeandcoke.com/lib/exe/fetch.php?w=400&tok=61c229&media=apuntes:bank_use_case.png" />
</div>

### Relaciones entre casos de uso

Las principales relaciones entre casos de uso son las de inclusión y extensión. Muchas veces se suelen confundir:
- __Inclusión__: Un caso de uso inicial incluye a otro caso de uso secundaria, cuando para realizar el caso de uso inicial se debe _obligatoriamente_ realizar el caso de uso secundario.

  <div align="center">
    <img src="http://entornos.codeandcoke.com/lib/exe/fetch.php?w=500&tok=535536&media=apuntes:include_use_case_example.png"  />
  </div>

- __Extensión__: Un caso de uso extiende de otro, cuando hace algo similar pero amplía la funcionalidad. La idea es muy similar a la de herencia en programación.

  <div align="center">
    <img src="http://entornos.codeandcoke.com/lib/exe/fetch.php?w=500&tok=49a2b7&media=apuntes:extends_use_case_example.png"  />
  </div>

### Diagramas de Clases

___EN CONSTRUCCIÓN___

<!--

Un diagrama de clases nos ayuda a tener un enfoque de las relaciones entre las clases que conforman un programa. Está compuesto de los siguientes elementos:

1. **Clases**: Reflejan sus atributos y métodos, y la visibilidad de ambos.

2. **Relaciones**: Reflejan la relación entre las clases/objetos: herencia, composición, agregación, asociación, uso, etc.

### 1 - Clases: Atributos, Métodos y Visibilidad

Define las características de un tipo de objeto concreto. Encapsula toda la información de un objeto, y está compuesta de métodos y atributos o campos.

El UML se representa por una _caja_ con 3 secciones:
- Superior: Nombre de la clase.
- Intermedio: Atributos de la clase.
- Inferior: Métodos de la clase.

#### Visibilidad

Se coloca alguno de los siguientes símbolos delante del nombre del miembro de la clase (atributo o método):
- \+ __Público__.
- \- __Privado__.
- \# __Protegido__.
- \~ __Default (Package-private)__.

#### Tipos de miembros

Los miembros de una clase pueden ser: instancias o clasificadores.
* Instancias: tienen como ámbito una instancia (objeto) específica.
* Clasificadores: (miembros estáticos) son los mismos para todas las instancias de esa clase. No dependen del estado del objeto (instancia). Se representan con su nombre **_subrayado_**.


[![](/lib/exe/fetch.php?w=500&tok=42994a&media=apuntes:uml_class_relation.png)](/lib/exe/detail.php?id=apuntes%3Adiagramas&media=apuntes:uml_class_relation.png "apuntes:uml_class_relation.png")

#### Tipo de clase

Si la clase es una clase abstracta o una interface (clase abstracta pura), se indica sobre el nombre de la clase con comillas: [![](/lib/exe/fetch.php?w=300&tok=31dbe3&media=apuntes:interface_uml.png)](/lib/exe/detail.php?id=apuntes%3Adiagramas&media=apuntes:interface_uml.png "apuntes:interface_uml.png")

### 2 - Relaciones entre objetos

Representa las _conexiones_ que hay entre las distintas clases u objetos de un programa. Indican de qué forma una clase usa elementos de otras clases.

1.  Herencia

2.  Asociación

    1.  Agregación

    2.  Composición


#### Herencia

Se representa por una línea con una flecha en el extremo de la superclase. [![](/lib/exe/fetch.php?w=300&tok=dd46b4&media=apuntes:uml_herencia.png)](/lib/exe/detail.php?id=apuntes%3Adiagramas&media=apuntes:uml_herencia.png "apuntes:uml_herencia.png")

Indica que una clase puede ser de distintos tipos de clase: varias subclases _extienden_ de una superclase.

[![](/lib/exe/fetch.php?w=400&tok=da97ea&media=apuntes:uml_herencia.jpg)](/lib/exe/detail.php?id=apuntes%3Adiagramas&media=apuntes:uml_herencia.jpg "apuntes:uml_herencia.jpg")

#### Asociación

Se representa por una flecha abierta. [![](/lib/exe/fetch.php?w=300&tok=0de6ce&media=apuntes:uml_asociacion.png)](/lib/exe/detail.php?id=apuntes%3Adiagramas&media=apuntes:uml_asociacion.png "apuntes:uml_asociacion.png") Representa cualquier tipo de asociación entre dos clases. Por ejemplo, cuando una clase usa métodos de otra clase, o cuando hay un método que recibe tipos de datos de otra clase.

Además, en cualquier tipo de relación de asociación se puede indicar la cardinalidad de la relación para indicar la cantidad de participación entre las dos clases.

Hay dos tipos de asociación mas restrictivos que concretan el tipo de relación de asociación entre dos clases: la agregación y la composición. Ambas representan relaciones entre objetos pero se diferencian en su rigidez. [![](/lib/exe/fetch.php?w=200&tok=c51d34&media=apuntes:association_aggregation_composition.jpg)](/lib/exe/detail.php?id=apuntes%3Adiagramas&media=apuntes:association_aggregation_composition.jpg "apuntes:association_aggregation_composition.jpg")

Para explicar el concepto vamos a plantear el siguiente ejemplo: _Una universidad posee varios departamentos, y cada departamento tiene un numero de profesores. Si la universidad cierra, los departamentos dejan de existir para siempre, pero los profesores de esos departamentos seguirán existiendo. Una Universidad es una composición de Departamentos, y un Departamento es una agregación de Profesores. Además un Profesor puede trabajar en más de un Departamento, pero un Departamento solo puede pertenecer a una Universidad._

#### Agregación

[![](/lib/exe/fetch.php?w=300&tok=197411&media=apuntes:uml_agregacion.png)](/lib/exe/detail.php?id=apuntes%3Adiagramas&media=apuntes:uml_agregacion.png "apuntes:uml_agregacion.png") Se representa por una línea con un rombo. Es un tipo de relación de Asociación, pero más específica.

Una agregación se da cuando una clase es una colección o un contenedor de otras clases, pero no depende de la existencia de esas otras clases. Si la clase que contiene a la colección desaparecen, no afecta a las clases contenidas.

En el siguiente ejemplo, la clase Departamento es un contenedor de clases Profesor:

public class Departamento{
   private [String](https://www.google.com/search?hl=en&q=allinurl%3Adocs.oracle.com+javase+docs+api+string) nombreDepartamento;
   private ArrayList<Profesor\> listadoProfesores;
 
   //Los profesores ya existen y recibo un listado por parámetro
   public Departamento(ArrayList<Profesor\> listadoProfesores){
      this.listadoProfesores \= listadoProfesores;
   }
}

Los Profesores no desaparecen porque desaparezca el objeto Departamento.

#### Composición

[![](/lib/exe/fetch.php?w=300&tok=b4cffb&media=apuntes:uml_composicion.png)](/lib/exe/detail.php?id=apuntes%3Adiagramas&media=apuntes:uml_composicion.png "apuntes:uml_composicion.png") Se representa por una línea con un rombo negro.

La composición de clases es una relación aun más estricta que la agregación. Se da cuando una clase contiene referencias a otra clase, pero la vida de las instancias contenidas está ligada a la vida de la instancia contenedora. O sea, si la clase compuesta desaparece también lo harán las clase contenidas.

public class Universidad{
   private [String](https://www.google.com/search?hl=en&q=allinurl%3Adocs.oracle.com+javase+docs+api+string) nombreUniversidad;
   private ArrayList<Departamento\> listadoDepartamentos;
 
   public Universidad(){
      this.listadoDepartamentos \= new ArrayList<>();
   }
 
   public void nuevoDepartamento([String](https://www.google.com/search?hl=en&q=allinurl%3Adocs.oracle.com+javase+docs+api+string) codigo, [String](https://www.google.com/search?hl=en&q=allinurl%3Adocs.oracle.com+javase+docs+api+string) nombreDepartamento){
      Departamento nuevoDepartamento \= new Departamento(codigo, nombreDepartamento);
      listadoDepartamentos.add(nuevoDepartamento);
   }
}

Si desaparece el objeto Universidad desaparecen también los departamentos que posee. Además un departamento solo puede pertenecer a una sola Universidad.

Herramientas para diseñar diagramas
-----------------------------------

Para crear un diagramas de clases y casos de uso nos basta con alguna aplicación que permita crear cajas, elipses, etc. Podemos usar la herramienta [yEd](https://www.yworks.com/products/yed "http://www.yworks.com/products/yed").

Por otra parte, también existen diferentes herramientas para crear diagramas de clases y generar el código posterior. Una de las herramientas más famosas para el modelado UML de clases es [ArgoUML](http://argouml.tigris.org "http://argouml.tigris.org"). También hay diversos _plugins_ que podemos integrar con eclipse.

Ingeniería inversa
------------------

Se conoce con este término el proceso de obtener un modelo a partir del código ya realizado. Este proceso es **inverso** al órden de las etapas a la hora de desarrollar software, ya que primero se realiza el modelado, para posteriormente tener claro qué se debe programar.

Existen distintas herramientas para obtener el diagrama de clases a partir de un código fuente ya creado. También podemos crear un diagrama de una bbdd a partir del código sql con el que hemos definido la base de datos.

PhpMyAdmin y MySQL WorkBench permiten realizar ingeniería inversa a partir de una base de datos. Para Java existe la herramienta ArgoUML y también existen diversos pluggins para hacerlo desde Eclipse.
-->

### Prácticas


1.  Modelado del comportamiento de un programa que calcula las area. Diagrama de casos de uso.

2.  Modelado de la estructura de un programa. Diagramas de clases.

</div>
