<div align="justify">


<div align="center">
 	<img src="https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2019/01/Picture1-7-291x180.png">
</div>

## Introducción a XPath.

  El término inglés Path podemos traducirlo como “ruta”, “camino” o “sendero”. __Xpath__ es un lenguaje dise ado para acceder a partes de un documento XML y es la base para seleccionar mediante una ruta elementos concretos dentro de los datos. Con este lenguaje, podremos acceder tanto al texto, a los elementos, a los atributos y en general a cualquier informaci n del fichero XML.

  Por sí solo XPath no nos permitir  hacer nada más que acceder a partes de los datos, pero lo realmente interesante es que utilizando este lenguaje en combinación con otros como XSLT o _XQuery_ podremos realizar transformaciones y operaciones complejas con los datos, transformar un documento en otro, aplicarle estilos a algunas partes, agregar marcas no existentes, ordenar contenido, etc. Por lo tanto para aprender estos lenguajes tendremos que conocer la sintaxis de _XPath_.

  <div align="center">
   	<img src="https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2019/01/Picture1-7-291x180.png">
  </div>

## El árbol sintáctico.

  Como ya sabemos los documentos XML se procesan con un programa llamado parser o analizador sint ctico. Este programa genera un árbol jer rquico de elementos. Este  rbol comienza con un elemento raíz, que se diversifica a lo largo de los elementos que cuelgan de él y acaba en nodos hoja, que contienen solo texto, comentarios, intrucciones de procesamiento o incluso que estén vacíos y s lo tienen atributos.

  La forma en que _XPath_ selecciona partes del documento XML se basa precisamente en la representación de este árbol. De hecho, los "_operadores_" de que consta este lenguaje nos recordar én la terminología que se utiliza a la hora de hablar de árboles en informática: raíz, hijo, ancestro, descendiente, etc.

  Un caso especial de nodo son los nodos atributo. Un nodo puede tener tantos atributos como desee, y para cada uno se le crear un nodo atributo. No obstante, dichos nodos atributo NO se consideran como hijos suyos, sino m s bien como etiquetas a adidas al nodo elemento.

  Para comprender bien los ejemplos en este tema trabajaremos con un documento XML llamado “_alumnos.xml_” con información de los alumnos del ciclo de Administración de Sistemas Informáticos en Red en nuestro instituto (mira un extracto):

```xml
<instituto codigo="38010700" nombre="IES Puerto">
    <curso codigo="1" nombre="1 ASIR">
        <alumno cial="A18X111">
            <nombre>Javier</nombre>
            <apellidos>Marquez Fernandez</apellidos>
            <repetidor>False</repetidor>
            <notas>
                <asignatura>Lenguajes de marcas</asignatura>
                <nota>8</nota>
                <asignatura>Redes</asignatura>
                <nota>7</nota>
                <asignatura>Fundamentos de hardware</asignatura>
                <nota>3</nota>
                <asignatura>Sistemas Operativos</asignatura>
                <nota>6</nota>
            </notas>
        </alumno>
        <alumno cial="A27M242">
            <nombre>Maria</nombre>
            <apellidos>Alvarez Perez</apellidos>
            <repetidor>True</repetidor>
            <notas>
                <asignatura>Lenguajes de marcas</asignatura>
                <nota>5</nota>
                <asignatura>Redes</asignatura>
                <nota>5</nota>
                <asignatura>Fundamentos de hardware</asignatura>
                <nota>7</nota>
                <asignatura>Sistemas Operativos</asignatura>
                <nota>6</nota>
            </notas>
        </alumno>
    </curso>
</instituto>
```
### Los nodos del árbol.

  Para XPath, un documento XML es como un árbol, que está compuesto por dos conceptos. Por un lado, la representación de distintos tipos de nodos; por el otro, las posibles relaciones que existen entre estos nodos.

  Existen varios tipos de nodos, los más básicos se denominan:
  - Nodo Elemento.
  - Nodo Atributo.
  - Nodo Texto.
  - Nodo raíz.
  - Elemento raíz.
  - Valores atómicos.

  ___El nodo raíz del árbol contiene al elemento raíz del documento. Todos los documentos XML tienen un nodo raíz que indica el inicio del documento, de donde dependen todos los demás nodos del documento___.

### Nodo Raíz:

  Se identifica por /. Es el nodo del que parte todo el árbol del documento y está  justo encima del primer elemento de nuestro fichero xml. En nuestro ejemplo está  por encima del nodo “_instituto_”. Luego una cosa es el nodo raíz, y otra el elemento principal del fichero xml, no debemos confundirlos.

### Nodo Elemento:

  Habrá un nodo elemento por cada etiqueta (o elemento) de nuestro fichero xml. __Todos los nodos elemento tendrán un único nodo padre, que es el elemento que lo encierra__ (salvo el elemento principal, cuyo padre es el nodo raíz).

  Los nodos elemento tienen a su vez hijos, que podrían ser otros nodos elemento, nodos de texto, nodos comentario y nodos de instrucciones de procesamiento.

  Los nodos elemento también tienen propiedades tales como su nombre, sus atributos e información sobre los "_espacios de nombre_", si estos están utilizándose.

  Una propiedad interesante de los nodos elemento es que pueden tener identificadores únicos (para ello deben ir acompañados de un __DTD__ que especifique al atributo como de tipo ID). El uso de IDs permite referenciar a dichos elementos de una forma mucho más directa.

### Nodos texto:

  Aquí entendemos por texto a cualquier cadena que no está dentro de los s mbolos de etiqueta __<__ y __>__. Típicamente la información suele estar en un nodo de texto. En nuestro fichero de ejemplo:

  __<asignatura>Lenguajes de marcas</asignatura>__   tenemos un nodo elemento llamado asignatura que es padre de un nodo texto que contiene __“Lenguajes de marcas”__.

  Un nodo texto no tiene hijos, es decir, los distintos caracteres que lo forman no se consideran hijos suyos.  

### Nodos atributo:

  Como ya hemos indicado, los nodo atributo no son tanto hijos del nodo elemento que los contiene como etiquetas a adidas a dicho nodo elemento. Cada nodo atributo consta de un nombre, un valor (que es siempre una cadena) y un posible "espacio de nombres".

  Aquellos atributos que tienen valor por defecto asignado en el _DTD_ se tratarán como si el valor se le hubiese escrito en el documento XML (aunque no fuera así). Al contrario, no se crea nodo para atributos no especificados en el documento XML, y con la propiedad ___#IMPLIED___ definida en su DTD. Tampoco se crean nodos atributo para las definiciones de los espacios de nombre. Todo esto es normal si tenemos en cuenta que no es necesario tener un DTD para procesar un documento XML.

### Nodos comentario y de instrucciones de proceso:

  Aparte de los nodos indicados, en el árbol también se generan nodos para cada comentarios (recuerda que en XML se escriben con __<!—texto -->)__ y para cada intrucción de procesamiento (recuerda que en XML se escriben con __<? Instrucción ?>__). Al contenido de estos nodos se puede acceder con la propiedad string-value.

## Expresiones de localización.

  En XPath a cada instrucción se le llama “__expresión__”, e indica un camino dentro de la estructura del árbol. El resultado de la misma podrá ser un nodo concreto o un conjunto de nodos.

  Las expresiones pueden incluir desde operaciones (veremos el conjunto de operadores en XPath) hasta llamadas a funciones más o menos complejas. Sin embargo el tipo más común de expresión en __XPath__ se llama “location Path” (ruta de localización). La sintaxis de los “location Path” es similar a la utilizada en sistemas Unix y Linux para movernos por el  rbol de directorios y subcarpetas en el sistema de archivos:

  __Ejemplo: /instituto/curso/alumno/nombre__   es un location Path que devolver  un conjunto de nodos, en este caso los formados por TODOS los nodos elemento <nombre> de nuestro fichero. Esto tendremos que tenerlo en cuenta, muchas veces un location Path hace referencia no a un  nico elemento sino a todos los elementos del árbol que cumplen esa ruta de localización.

  En el ejemplo que acabamos de ver tendr amos que leer la ruta como:
  “Todos los nodos “nombre” que cuelguen de cualquier nodo “alumno” que a su vez cuelgue de cualquier nodo “curso” que a su vez cuelgue del nodo principal “instituto”.

  Si se diera el caso de que no hay en nuestro fichero ning n elemento que cumpla con este location Path se devolver a una lista vacía. En otro caso se devolver  una lista de referencias (o apuntadores) a cada nodo que cumplir  con los requisitos de la localización.
</div>
