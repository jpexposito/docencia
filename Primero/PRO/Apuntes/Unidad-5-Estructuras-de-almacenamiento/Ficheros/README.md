<div align="justify">

# Manipulación y almacenamiento de información en ficheros

__XML__ _(Extensible Markup Language)_, __CSV__ _(Comma-Separated Values)_ y __JSON__ _(JavaScript Object Notation)_ son ___formatos de intercambio de datos comúnmente utilizados en programación y en la transferencia de información entre sistemas___, así como ___estructuras de datos formateadas para el almacenamento de información___.

<img src="../img/xml-json-csv.png">

## Estrucura de la información

Supongamos que deseamos intercambiar o almacenar la siguiente información de un __libro__:

| Título           | Autor     | Publicación |
| ---------------- | --------- | ----------- |
| Java Programming | John Doe  | 2022        |

Dicha información en cada uno de los tipos de ficheros se representa de la siguiente forma:

### XML

La representación de la información anterior en un xml es la siguiente:

```xml
<libro>
    <titulo>Java Programming</titulo>
    <autor>John Doe</autor>
    <publicacion>2022</publicacion>
</libro>
```

### CSV

La representación de la información anterior en un __csv__ es la siguiente:

```csv
titulo,autor,publicacion
Java Programming,John Doe,2022
```

### JSON

La representación de la información anterior en un __json__ es la siguiente:

```json
{
    "titulo": "Java Programming",
    "autor": "John Doe",
    "publicacion": 2022
}
```

### Representación de la información en clases y objetos

La información que tenemos almacenada en cualquiera de las formas anteriores debemos trasladarla a __objetos java__ a través de __clases__. Dicha transformación se realiza a través de la clase __Libro__.

```java
public class Libro {
    // Campos de la clase
    private String titulo;
    private String autor;
    private int publicacion;

    // construcores
    // ...
    // -- getters/setters
    // ...
}
```

con la instanciación correspondiente:

```java
Libro miLibro = new Libro("Java Programming", "John Doe", 2022);
```

>__Nota__:_Teniendo esto claro, sólo debemos indicar un elemento más y es el_ ___conjunto de libros___, que podrían formar una_ ___biblioteca__, _en formato_ ___xml, csv___, o ___json___.

### XML

```xml
<?xml version="1.0" encoding="UTF-8"?>
<biblioteca>
    <libro id="1">
        <titulo>Java Programming</titulo>
        <autor>John Doe</autor>
        <publicacion>2022</publicacion>
    </libro>
    <libro id="2">
        <titulo>Python for Beginners</titulo>
        <autor>Jane Smith</autor>
        <publicacion>2023</publicacion>
    </libro>
</biblioteca>
```

### CSV

```csv
id,titulo,autor,publicacion
1,Java Programming,John Doe,2022
2,Python for Beginners,Jane Smith,2023
```

### JSON

```json
[
  {
    "id": "1",
    "titulo": "Java Programming",
    "autor": "John Doe",
    "publicacion": "2022"
  },
  {
    "id": "2",
    "titulo": "Python for Beginners",
    "autor": "Jane Smith",
    "publicacion": "2023"
  }
]
```

### Java

En este caso almacenariamos la información en:
- __List<Libro>__ __ArrayList/HashSet__.
- __HasHMap<String, Libro>__ en cualquiera de sus posibilidades.

Como resulta obvio el nombre del elemento se llamaría __libros__ y formaria parte de la clase __Biblioteca__.

```java
public class Biblioteca {
    private String nombre;
    // .. Otras propiedades ..
    private List<Libro> libros;

    // .. Constructores
    // .. Getters and Setters

    // .. Otros métodos
}
```

## Características, fortalezas y devilidades

Aunque tienen sintaxis y estructuras diferentes, comparten algunas características y propósitos comunes:

- __Formatos de texto plano__: __XML, CSV y JSON__ son formatos de texto plano, lo que significa que los datos son __legibles por humanos__ y pueden ser editados con un editor de texto.
- __Interoperabilidad__: Los tres formatos son independientes del lenguaje y son ampliamente compatibles con diferentes plataformas y sistemas.
- __Estructura jerárquica__:
__XML y JSON__ son formatos __jerárquicos__ y pueden representar datos de manera __estructurada y anidada__. Ambos permiten la creación de __estructuras complejas__ mediante la anidación de elementos u objetos.
- __Representación de datos__: Los tres formatos permiten representar datos de diferentes tipos, como: ___cadenas de texto, números, booleanos, listas y objetos__ (en el caso de JSON). CSV es más simple y se centra en la representación tabular de datos.
- __Facilidad de lectura y escritura__:Aunque __XML y JSON__ son __más legibles__ para los humanos, __CSV__ es especialmente fácil de entender y manipular para datos tabulares simples.
- __Amplia adopción__: Los tres formatos son ampliamente utilizados en diversas aplicaciones y entornos. __XML__ ha sido utilizado durante mucho tiempo en diversas industrias, __JSON__ es común en el __desarrollo web y API__, y __CSV__ es comúnmente utilizado en __hojas de cálculo__ y aplicaciones que requieren datos tabulares.
- __Soporte para arrays o listas__: Tanto __JSON__ como __XML__ pueden representar __listas o arrays__ de elementos. En __JSON__, esto se logra mediante la notación de corchetes __([])__, mientras que en __XML__, se utiliza la __repetición__ de elementos.
- __Facilidad de procesamiento__: Los tres formatos son relativamente fáciles de procesar mediante código en diferentes lenguajes de programación. Existen bibliotecas y herramientas que facilitan la lectura y escritura de datos en estos formatos.
- __Uso en la transferencia de datos__: Los tres formatos son utilizados para la transferencia de datos entre sistemas. JSON es comúnmente utilizado en servicios web y API debido a su simplicidad y eficiencia en la transmisión de datos.

>__Nota__:_A pesar de estas similitudes, es importante destacar que cada formato tiene sus propias fortalezas y debilidades, y la elección entre ellos depende del contexto específico y de los requisitos del sistema o aplicación en cuestión_.

## Métodos comunes a implementar siempre

Existe un conjunto de métodos a implementar siempre que trajamos con ficheros, pero antes de ello debemos de conocer la clase __File__.

La clase __File__ proporciona una __interfaz abstracta para interactuar con el sistema de archivos__. Esta clase no tiene métodos para realizar operaciones en el sistema de archivos, pero te permite obtener información sobre archivos y directorios, así como crear, eliminar y manipular caminos de archivos.

Algunos de estos métodos son:

- __Creación de una instancia de la clase File__: Puedes crear una instancia de la clase __File__ para representar un archivo o directorio en el sistema de archivos. Puedes proporcionar la __ruta del archivo o directorio__ como argumento al constructor.

    ```java
    File archivo = new File("ruta/del/archivo.txt");
    ```

- __Comprobación de existencia__:cPuedes verificar si un archivo o directorio existe en el sistema de archivos.

    ```java
    File archivo = new File("ruta/del/archivo.txt");
    boolean existe = archivo.exists();
    ```

- __Obtención de información sobre el archivo o directorio__: Puedes obtener información como el _nombre_ del archivo, la _ruta  absoluta_, si _es un directorio_, la fecha de _última modificación_, entre otros.

    ```java
    File archivo = new File("ruta/del/archivo.txt");
    String nombre = archivo.getName();
    String rutaAbsoluta = archivo.getAbsolutePath();
    boolean esDirectorio = archivo.isDirectory();
    long ultimaModificacion = archivo.lastModified();
    ```

- __Operaciones sobre archivos y directorios__:Puedes realizar operaciones como crear un nuevo archivo, crear un nuevo directorio, eliminar un archivo o directorio, y más.

    ```java
    // Crear un nuevo archivo
    File nuevoArchivo = new File("ruta/del/nuevoArchivo.txt");
    nuevoArchivo.createNewFile();

    // Crear un nuevo directorio
    File nuevoDirectorio = new File("ruta/del/nuevoDirectorio");
    nuevoDirectorio.mkdir();

    // Eliminar un archivo o directorio
    File archivoAEliminar = new File("ruta/del/archivoAEliminar.txt");
    archivoAEliminar.delete();
    ```

- Listado de archivos en un directorio: Puedes obtener un array de objetos File que representan los archivos en un directorio.
  
    ```java
    File directorio = new File("ruta/del/directorio");
    File[] archivos = directorio.listFiles();
    ```

- __Operaciones de rutas y caminos__:Puedes realizar operaciones en las rutas, como obtener la ruta canónica, la ruta padre, etc.

    ```java
    File archivo = new File("ruta/del/archivo.txt");
    String rutaCanonica = archivo.getCanonicalPath();
    File padre = archivo.getParentFile();
    ```

## IOException

Debemos de tener en cuenta que tratamos con ficheros, y por lo tanto en caso de no existir deberemos lanzar una Exception de tipo __IOException__.

## Métodos que se deben de implementar

### Lectura de fichero

### Modificación de fichero

### Almacenamiento en fichero

</div>