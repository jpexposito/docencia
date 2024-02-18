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

>__Nota__:_Teniendo esto claro, sólo debemos indicar un elemento más y es el_ ___conjunto de libros___, que podrían formar una __biblioteca__, _en formato_ ___xml, csv___, o ___json___.

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

>__Nota__: Cada __libro__ se representa entre las etiquetas ```xml <libro>...</libro>``` y la __biblioteca__ entre ```xml <biblioteca>...</biblioteca>```.

### CSV

```csv
id,titulo,autor,publicacion
1,Java Programming,John Doe,2022
2,Python for Beginners,Jane Smith,2023
```
>__Nota__: Cada __libro__ se representa por cada una de las filas del fichero. La __biblioteca__, es el conjunto del fichero.


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
>__Nota__: Cada __libro__ se representa entre __{}__, mientras que el conjunto de los libros en __[{},{}]__.


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

### Existencia del fichero

Este método es transversal para cualquiera de los métodos siguientes. Debe de devolver __true/false__, indicando si existe o no, y realizando la siguiente acción.

```java
public static boolean existeFichero(String path) {
    if (path == null || path.isEmpty()) {
        return false;
        }
    File fichero = new File(path);
    return fichero.exists() && fichero.isFile();
    }
```

>__Nota__: ¿Por qué debemos de implementarlo?. En las operaciones de __lectura/escritura__ siempre debemos de verificar si existe el fichero sobre el que se va a realizar la __operación__.

### Lectura de fichero

```java
// Ejemplo básico de lectura de ficheros linea a linea
public static void lectura(String path) {
        // Crear un objeto File
        File fichero = new File(path);
        // Verificar si el fichero existe antes de intentar leerlo
        if (fichero.exists() && fichero.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
                String linea;
                // Leer cada línea del fichero
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El fichero no existe o no es un fichero válido.");
        }
    }
```

```java
    // Invocando al método anterior
    public static void lectura(String path) {
        if(!existeFichero(path)) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            // Leer cada línea del fichero
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            // Manejar la excepción en caso de error de lectura
            e.printStackTrace();
        }
    }
```

Se verifica la existenca el fichero, en caso de no existir, no hace ninguna acción, y se evita un posible __NullPointer__.

```java
try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
    String linea;

    // Leer cada línea del fichero
    while ((linea = br.readLine()) != null) {
        System.out.println(linea);
    }
```

Utilizamos un bloque __try-with-resources__ para asegurarnos de que el __BufferedReader__ se cierre adecuadamente al finalizar. Luego, leemos __cada línea__ del fichero y la imprimimos en la consola.

```java
} catch (IOException e) {
    // Manejar la excepción en caso de error de lectura
    e.printStackTrace();
}
```

__Capturamos y manejamos cualquier excepción__ que pueda ocurrir durante la __lectura del fichero__. En este caso, __imprimimos__ el rastreo de la pila en la consola.

### Almacenamiento en fichero

```java
// Método para almacenar texto en un fichero
    public static void almacenarEnFichero(String rutaFichero, String texto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFichero, true))) {
            // El parámetro 'true' en FileWriter permite la escritura en modo de añadir al final del fichero

            bw.write(texto);
            bw.newLine(); // Agregar una nueva línea después del texto

            System.out.println("Texto almacenado en el fichero.");

        } catch (IOException e) {
            // Manejar la excepción en caso de error de escritura
            e.printStackTrace();
        }
    }
```

>__Nota__: _¿Qué deberiamos tener en cuenta antes de escribir en un fichero?_

### Eliminar el contenido de en fichero

Para eliminar el contenido de un fichero, podemos escribir una cadena __vacía__, y cerrar el fichero.

```java
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Ruta del archivo
        String filePath = "ruta/al/archivo.txt";

        try {
            // Crear un objeto File
            File file = new File(filePath);

            // Crear un FileOutputStream para escribir en el archivo
            FileOutputStream outputStream = new FileOutputStream(file);

            // Escribir un contenido vacío
            byte[] emptyContent = {};
            outputStream.write(emptyContent);

            // Cerrar el FileOutputStream
            outputStream.close();

            System.out.println("Contenido del archivo eliminado con éxito.");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al eliminar el contenido del archivo: " + e.getMessage());
        }
    }
}

```

## Trabajando con ficheros en proyectos maven

Si deseas __leer y escribir__ archivos en el directorio __src/main/resources__ de un proyecto Maven, ten en cuenta que _los archivos en este directorio se consideran recursos y generalmente son de solo lectura durante la ejecución_. Sin embargo, puedes copiarlos a un directorio temporal o al sistema de archivos local para realizar operaciones de escritura.

```java
public static void leerFichero(String nombreRecurso) {
        try (InputStream inputStream = OperacionesFicheroResources.class.getResourceAsStream("/" + nombreRecurso);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```


</div>