<div align="justify">

# Manipulación y almacenamiento de información en ficheros

- [Manipulación y almacenamiento de información en ficheros](#manipulación-y-almacenamiento-de-información-en-ficheros)
  - [Contenidos](#contenidos)
  - [Ficheros](#ficheros)
    - [Try-Catch con recursos](#try-catch-con-recursos)
    - [Use](#use)
    - [Flujos](#flujos)
  - [Ficheros de texto](#ficheros-de-texto)
    - [Leer ficheros de texto](#leer-ficheros-de-texto)
    - [Escribir ficheros de texto](#escribir-ficheros-de-texto)
  - [Ficheros binarios](#ficheros-binarios)
    - [Leer ficheros binarios](#leer-ficheros-binarios)
    - [Escribir ficheros binarios](#escribir-ficheros-binarios)
  - [Ficheros de acceso aleatorio](#ficheros-de-acceso-aleatorio)
    - [Leer ficheros de acceso aleatorio](#leer-ficheros-de-acceso-aleatorio)
    - [Escribir ficheros de acceso aleatorio](#escribir-ficheros-de-acceso-aleatorio)
  - [Serialización](#serialización)
    - [Leer objetos serializados](#leer-objetos-serializados)
    - [Escribir objetos serializados](#escribir-objetos-serializados)
  - [Ficheros y Directorios. Utilidades](#ficheros-y-directorios-utilidades)
    - [Clase File](#clase-file)
    - [Clase Path](#clase-path)
    - [Clase Files](#clase-files)
    - [Clase Paths](#clase-paths)
    - [Directorio Resources](#directorio-resources)
    - [Fichero properties](#fichero-properties)
  - [DTO](#dto)
  - [CSV](#csv)
  - [JSON](#json)
    - [Lectura de JSON](#lectura-de-json)
    - [Objeto a JSON](#objeto-a-json)
    - [Pretty print](#pretty-print)
    - [JSON a Objeto](#json-a-objeto)
  - [XML](#xml)
    - [Lectura de XML](#lectura-de-xml)
    - [Escritura de XML](#escritura-de-xml)
  - [Ficheros Temporales](#ficheros-temporales)
  - [Ficheros Zip](#ficheros-zip)

## Contenidos

1. Ficheros
2. Ficheros de texto
3. Ficheros binarios
4. Ficheros de acceso aleatorio
5. Serialización de objetos
6. Ficheros y Directorios. Utilidades
7. CSV
8. JSON
9. XML
10. DTO
11. Ficheros Temporales
12. Ficheros Zip

## Ficheros

Un fichero es un conjunto de datos almacenados en un dispositivo de almacenamiento secundario. Los ficheros se pueden clasificar en dos grandes grupos: ficheros de texto y ficheros binarios y en función de su acceso: ficheros de acceso secuencial y ficheros de acceso aleatorio.

__XML__ _(Extensible Markup Language)_, __CSV__ _(Comma-Separated Values)_ y __JSON__ _(JavaScript Object Notation)_ son ___formatos de intercambio de datos comúnmente utilizados en programación y en la transferencia de información entre sistemas___, así como ___estructuras de datos formateadas para el almacenamento de información___.

<img src="../img/xml-json-csv.png">

### Try-Catch con recursos

A partir de Java 7 se puede utilizar el try-catch con recursos, que nos permite cerrar los recursos que se abren en el bloque try. Para ello, se debe implementar la interfaz java.lang.AutoCloseable en la clase que queremos cerrar. Por ejemplo, si queremos cerrar un fichero, la clase que implementa la interfaz AutoCloseable es java.io.Closeable.

```java
try (BufferedReader br = new BufferedReader(new FileReader("fichero.txt"))) {
    // Acciones
} catch (IOException e) {
    // Excepciones
}

// Antes 
BufferedReader br = null;
try {
    br = new BufferedReader(new FileReader("fichero.txt"));
    // Acciones
} catch (IOException e) {
    // Excepciones
} finally {
    if (br != null) {
        try {
            br.close();
        } catch (IOException e) {
            // Excepciones
        }
    }
}
```
En el ejemplo anterior, el fichero se cierra automáticamente al salir del bloque try. Si se produce una excepción, el fichero se cierra automáticamente al salir del bloque catch.

### Use
En Kotlin podemos usar el uso de recursos de una forma más sencilla y segura. Para ello, usamos la función use, que nos permite cerrar el recurso automáticamente al salir del bloque de código.

```kotlin
File("fichero.txt").bufferedReader().use { br ->
    // Acciones
}
```

### Flujos
Flujos: son un canal de comunicación de las operaciones de entrada salida. Este esquema nos da independencia para poder trabajar igual tanto si estamos escribiendo en un fichero, como en consola, o si estamos leyendo de teclado, o de una conexión de red.
- Flujos de entrada: sirven para introducir datos en la aplicación.
- Flujos de salida: sirven para sacar datos de la aplicación.
- Flujos de bytes: manejan datos en crudo.
- Flujos de caracteres: manejan caracteres o cadenas

![imagen](./images/jeraquia.png)

## Ficheros de texto
Los ficheros de texto son ficheros que contienen caracteres. Los ficheros de texto se pueden leer y escribir.

### Leer ficheros de texto
Podemos leerlos linea a linea o todo el fichero de golpe. Ademas podemos hacer uso de un buffer para mejorar la lectura.
Debes tener en cuenta cómo se implementan los métodos de lectura, pues mucho de ellos aunque no lo parezca hacen uso del buffer de lectura internamente. como radLines(), forEachLine{ } o readText().
```kotlin
val fileOrigen = File(filePath)

// existe
if (fileOrigen.exists()) {
    println("El fichero existe")
} else {
    println("El fichero no existe")
}

// Si puedo leerlo
if (fileOrigen.canRead()) {
    println("El fichero se puede leer")
} else {
    println("El fichero no se puede leer")
}

// Devuelve una lista de líneas
fileOrigen.readLines().forEach { println(it) }
println()

// Procesa linea a linea, es la forma simplificada del anterior
fileOrigen.forEachLine { println(it) }

// Lee el fichero completo en una cadena, cuidado con ficheros grandes
fileOrigen.readText().also { println(it) }

// Usa usa una secuencia y se le procesa un callback en el lambda
fileOrigen.useLines { it.toList() }.forEach { println(it) }
// fileOrigen.useLines { it.forEach { line -> println(line) } }

// Buffer de lectura
// Lee el fichero completo en una lista de cadena
fileOrigen.bufferedReader().forEachLine { println(it) }
// Use equivale al try-with-resources de Java
// Dentro del use podemos hacer uso de los métodos de BufferedReader
fileOrigen.bufferedReader().use { it.forEachLine { line -> println(line) } }

// InputStreamReader
fileOrigen.inputStream().reader().readText().let { println(it) }

// InputStream + BufferedReader
fileOrigen.inputStream().bufferedReader().readText().let { println(it) }

// InputStreamReader + BufferedReader + use
fileOrigen.inputStream().reader().buffered().use { it.readText() }.let { println(it) }
```

### Escribir ficheros de texto
Podemos escribirlos linea a linea o todo el fichero de golpe. Ademas podemos hacer uso de un buffer para mejorar la escritura. Haremos uso de writeText() o appendText() para escribir ficheros de texto. Debes tener en cuenta cómo se implementan los métodos de escritura, pues mucho de ellos aunque no lo parezca hacen uso del buffer de escritura internamente. 

```kotlin
val fileDestino = File(filePath)

// Con writeText escribimos todo el contenido  de String en el fichero, si existe lo sobreescribe, si no existe lo crea
fileDestino.writeText("Hola mundo")

// Podemos añadir contenido al fichero
fileDestino.appendText("Hola de nuevo")

// Podemos usar el método writeBytes para escribir bytes
fileDestino.writeBytes("Hola mundo".toByteArray())

// printWriter
fileDestino.printWriter().use { it.println("Hola mundo") }

// bufferedWriter
fileDestino.bufferedWriter().use { it.write("Hola mundo") }

// bufferedWriter + append
fileDestino.bufferedWriter().use { it.append("Hola mundo") }

// printWriter + append
fileDestino.printWriter().use { it.append("Hola mundo") }
```

## Ficheros binarios
Los ficheros binarios son ficheros que contienen bytes. Los ficheros binarios se pueden leer y escribir. También poder usar este sistema para leer y escribir ficheros de texto.

### Leer ficheros binarios
Podemos leerlos byte a byte o todo el fichero de golpe. Ademas podemos hacer uso de un buffer para mejorar la lectura. Haremos uso de readBytes(), read()

```kotlin
val fileOrigen = File(filePath)

// readBytes
val bytes = fileOrigen.readBytes().toString(Charsets.UTF_8)

// con un inputStream
fileOrigen.inputStream().use { println(it.readBytes().toString(Charsets.UTF_8)) }

// con buffered
fileOrigen.inputStream().buffered().use { println(it.readBytes().toString(Charsets.UTF_8)) }
```

### Escribir ficheros binarios
Poder escribirlos byte a byte o todo el fichero de golpe. Ademas podemos hacer uso de un buffer para mejorar la escritura. Haremos uso de writeBytes(), write()

```kotlin
val fileDestino = File(filePath)

// writeBytes
fileDestino.writeBytes("Hola mundo!".toByteArray())

// outputStream
fileDestino.outputStream().use { it.write("Hola mundo!".toByteArray()) }

// bufferedOutputStream
fileDestino.outputStream().buffered().use { it.write("Hola mundo!".toByteArray()) }

// con bufferedWriter
fileDestino.bufferedWriter().use { it.write("Hola mundo!") }
```

## Ficheros de acceso aleatorio
Los ficheros de acceso aleatorio son ficheros que contienen bytes. No acceden a los datos de forma secuencial, sino que se puede acceder a cualquier parte del fichero. Los ficheros de acceso aleatorio se pueden leer y escribir. También poder usar este sistema para leer y escribir ficheros de texto.

Haremos uso de RandomAccessFile y de las funciones seek(), para mover el puntero de lectura/escritura, y read(), write() para leer y escribir.

¿Cómo saber la longitud de un fichero de acceso aleatorio y del tipo de dato?
|Tipo de Dato|Tamaño en Bytes|
|---|---|
|Char|2 bytes|
|Byte|1 byte|
|Short|2 bytes|
|Int|4 bytes|
|Long|8 bytes|
|Float|4 bytes|
|Double|8 bytes|
|Boolean|1 byte|
|Espacio en blanco (un char)|1 byte|
|Salto de línea (enter)|1 byte|
|String|2 bytes por cada char|


### Leer ficheros de acceso aleatorio
Podemos leerlos byte a byte o todo el fichero de golpe. Ademas podemos hacer uso de un buffer para mejorar la lectura. Haremos uso de los métodos de readInt(), readLong(), readFloat(), readDouble(), readChar(), readBoolean(), readByte(), readShort(), readUTF()

```kotlin
val aleatorio = RandomAccessFile(fileOrigen, "rw")
    // leermos una secuencia de numeros enteros
aleatorio.use {
    it.seek(0) // Nos situamos al principio del fichero si no lo está
    val longitud = it.length() // Obtenemos la longitud del fichero
    val numEnteros = longitud / 4 // Obtenemos el número de enteros 4 bytes = 1 entero de 32 bits
    val arrayEnteros = IntArray(numEnteros.toInt()) // Creamos un array de enteros
    for (i in 0 until numEnteros) {
        arrayEnteros[i] = it.readInt() // Leemos el entero
    }
}
```
### Escribir ficheros de acceso aleatorio
Poder escribirlos byte a byte o todo el fichero de golpe. Ademas podemos hacer uso de un buffer para mejorar la escritura. Haremos uso de los métodos de writeInt(), writeLong(), writeFloat(), writeDouble(), writeChar(), writeBoolean(), writeByte(), writeShort(), writeUTF()

```kotlin
val aleatorio = RandomAccessFile(fileOrigen, "rw")
    // Escribimos una secuencia de numeros enteros
aleatorio.use {
    it.seek(0) // Nos situamos al principio del fichero si no lo está
    for (i in 0 until 10) {
        it.writeInt(i) // Escribimos el entero
    }
}
```

## Serialización
La serialización es el proceso de convertir un objeto en una secuencia de bytes para poder almacenarlo en un fichero, enviarlo a través de una red o guardarlo en una base de datos. La deserialización es el proceso inverso, de convertir una secuencia de bytes en un objeto. Para poder serializar un objeto, este debe implementar la interfaz Serializable y sus atributos deben ser también serializables. 

### Leer objetos serializados
Para leer objetos serializados haremos uso de ObjectInputStream y del readObject() para leer el objeto o colección de objetos haciendo un casting adecuado.

```kotlin
data class Persona(val nombre: String, val edad: Int) : Serializable

val fileOrigen = File(filePath)

val ois = ObjectInputStream(fileOrigen.inputStream())
ois.use {
    val persona = it.readObject() as Persona
    println(persona)
}
```

### Escribir objetos serializados
Para escribir objetos serializados haremos uso de ObjectOutputStream y del writeObject() para escribir el objeto o colección de objetos.

```kotlin
data class Persona(val nombre: String, val edad: Int) : Serializable

val fileDestino = File(filePath)

val oos = ObjectOutputStream(fileDestino.outputStream())
oos.use {
    it.writeObject(Persona("Pepe", 20))
}
```

## Ficheros y Directorios. Utilidades

### Clase File
La clase File representa un fichero o directorio en el sistema de ficheros. La clase File proporciona métodos para crear, eliminar, renombrar, comprobar si existe, obtener información sobre un fichero o directorio, y para obtener una lista de los ficheros y directorios que contiene un directorio.

![File](./images/file.png)

### Clase Path
La clase Path representa una ruta de acceso a un fichero o directorio y nos ofrece métodos para trabajar con rutas

### Clase Files
La clase Files proporciona métodos estáticos para trabajar con ficheros y directorios usando Nio2, y con ello poder usar api de Streams, Paths, etc de una manera no bloqueante.

![Files](./images/java-io-vs-nio.png)

### Clase Paths
Nos permite obtener un objeto Path a partir de una cadena de texto que representa una ruta de acceso a un fichero o directorio en el sistema de ficheros usando Nio2.

```kotlin
// Dado un path si es un directorio nos devuelve una lista de los ficheros que contiene
val path = Paths.get("...")
val files = Files.list(path)
// comprobamos por cada fichero si es un fichero o directorio y si podemos leerlo
files.forEach {
    if (Files.isDirectory(it)) {
        println("Es un directorio")
    } else if (Files.isRegularFile(it)) {
        println("Es un fichero")
    }
    if (Files.isReadable(it)) {
        println("Es legible")
    }
}

// simular el comando ls -l
Files.list(path).forEach {
    println("${Files.getLastModifiedTime(it)} ${Files.size(it)} ${it.fileName}")
}

// simular el comando tree
Files.walk(path).forEach {
    println("${Files.getLastModifiedTime(it)} ${Files.size(it)} ${it.fileName}")
}
```

### Directorio Resources
En el directorio resources podemos almacenar ficheros que queramos que estén disponibles en el classpath de nuestro proyecto. Estos ficheros se pueden acceder desde el código de la aplicación usando la clase ClassLoader. Son muy útiles para almacenar ficheros de configuración, ficheros de datos, etc, pero solo de lectura. Estará disponible en el classpath de nuestro proyecto (incluso dentro del jar) y por tanto podremos acceder a él desde cualquier parte de nuestro proyecto.

```kotlin
fun getResourceText(path: String): String {
    return File(ClassLoader.getSystemResource(path).file).readText()
}
```

### Fichero properties
Los ficheros properties son ficheros de texto plano que contienen pares clave-valor. Estos ficheros son muy útiles para almacenar configuraciones de nuestra aplicación. Para poder leerlos haremos uso de la clase Properties.

```kotlin
val properties = Properties()
properties.load(ClassLoader.getSystemResourceAsStream("config.properties"))
val nombre = properties.getProperty("nombre")
val edad = properties.getProperty("edad").toInt()

// Si queremos guardar un fichero properties
val properties = Properties()
properties.setProperty("nombre", "Pepe")
properties.setProperty("edad", "20")
properties.store(FileOutputStream("config.properties"), "Fichero de configuración")
````

## DTO
El DTO (Data Transfer Object) es un objeto que se utiliza para transferir datos entre distintas capas de una aplicación. En nuestro caso lo usaremos para transferir datos entre la capa de datos y la capa de negocio. De esta manera podemos prescindir de los adaptadores o incompatibilidades de tipos de datos (UUID, DateTime, LocalDateTime y otros).

Para pasar de uno modelo a su dto y viceversa haremos uso de las funciones de extensión de Kotlin o un objeto mapeador o para empaquetar y desempaquetar los datos (embeberlos en un objeto) y así poder usarlos en la capa de negocio. Muy util con Json y XML.


```kotlin
data class Persona(
    val id: UUID,
    val nombre: String,
    val edad: Int
    val createdAt: LocalDateTime
)

data class PersonaDto(
    val id: String,
    val nombre: String,
    val edad: String,
    val createdAt: String
)

fun Persona.toDto() = PersonaDto(
    id.toString(),
    nombre,
    edad.toString(),
    createdAt.toString()
)

fun PersonaDto.toModel() = Persona(
    UUID.fromString(id),
    nombre,
    edad.toInt(),
    LocalDateTime.parse(createdAt)
)

```

## CSV
Los ficheros CSV (Comma Separated Values) son ficheros de texto plano que contienen datos separados por comas u otro delimitador. Estos ficheros son muy útiles para almacenar datos de forma sencilla y que puedan ser leídos por cualquier aplicación. Para poder leerlos como un fichero de texto y separar los datos por el limitador. Posteriormente podemos convertirlos a objetos.
```kotlin
// Leemos un fichero CSV
val file = File(filePath)
file.forEachLine {
    val datos = it.split(",") // Separamos los datos por comas
    println(datos)
}

// Escribimos un fichero CSV
val file = File(filePath)
file.writeText("Pepe,20\n")
file.appendText("Juan,30\n")
```

## JSON
Los ficheros JSON (JavaScript Object Notation) son ficheros de texto plano que contienen datos en formato JSON. Estos ficheros son muy útiles para almacenar datos de forma sencilla y que puedan ser leídos por cualquier aplicación. Para poder leerlos como un fichero de texto y convertirlos a objetos.
```json
{
  "nombre": "Pepe",
  "edad": 20
}
```

### Lectura de JSON
Para poder leer un fichero JSON haremos uso de la librería especial de [Kotlin](https://kotlinlang.org/docs/serialization.html) en [JSON](https://github.com/Kotlin/kotlinx.serialization) que es Kotlin Serialization.

Lo primero que tenemos que hacer en nuestro fichero build.gradle.kts es el plugin de serialization y la dependencia de la librería.

```kotlin
plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.22"
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
}
```

Para ello lo único que tenemos que usar en nuestros DTOs o clases es la anotación `@Serializable`.

### Objeto a JSON
Para poder obtener el JSON usaremos `Json.encodeToString<T>()`
    
```kotlin

@Serializable
data class Data(val a: Int, val b: String)

fun main() {
   val json = Json.encodeToString(Data(42, "str"))
}
```

### Pretty print
Para poder hacer un pretty print de nuestro JSON haremos uso de JsonBuilder:

```kotlin
val prettyJson = Json { // this returns the JsonBuilder
    prettyPrint = true
    // optional: specify indent
    prettyPrintIndent = " "
}

val myObject = MyObject(name = "hello", age = 2)
val string = prettyJson.encodeToString(myObject)
print(string)
```

### JSON a Objeto
Para poder pasar una cadena JSON a Objeto usamos Json.decodeFromString<T>
    
```kotlin

@Serializable
data class Data(val a: Int, val b: String)

fun main() {
   val obj = Json.decodeFromString<Data>("""{"a":42, "b": "str"}""")
}
```


## XML
Los ficheros XML (Extensible Markup Language) son ficheros de texto plano que contienen datos en formato XML. Estos ficheros son muy útiles para almacenar datos de forma sencilla y que puedan ser leídos por cualquier aplicación. Para poder leerlos como un fichero de texto y convertirlos a objetos.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persona>
    <nombre>Pepe</nombre>
    <edad>20</edad>
</persona>
```

### Lectura de XML
Para leer ficheros XML usaremos la librería [Simple XML](https://simple.sourceforge.net/). Esta librería nos permite convertir objetos a XML y viceversa y es optima para trabajar con Kotlin y Java. Además podemos usar otras como [Kotlin serialzation](https://kotlinlang.org/docs/serialization.html#example-xml-serialization) pero solo es compatible con Kotlin. OJO, la recomiendo mucho más que Simple XML si solo vas a trabajar con Kotlin y así la usaremos en un futuro.

```kotlin
data class Paciente(
    val uuid: UUID = UUID.randomUUID(),
    val nombre: String,
    val edad: Int,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)

// Para evitar los problemas de los tipos usamos un DTO con los tipos String
// Field es para poder escribir y param para crear el constructor
@Root(name = "paciente")
data class PacienteDto(
    @field:Attribute(name = "uuid") // es un atributo
    @param:Attribute(name = "uuid") // es un atributo
    val uuid: String,

    @field:Element(name = "nombre") // Si queremos cambiar el nombre del elemento
    @param:Element(name = "nombre") // Si queremos cambiar el nombre del elemento
    val nombre: String,

    @field:Element(name = "edad")
    @param:Element(name = "edad")
    val edad: String,

    @field:Element(name = "created_at")
    @param:Element(name = "created_at")
    val createdAt: String,
)

// Ademas de la clase Paciente, necesitamos una clase que se encargue de convertir
// entre Paciente y PacienteDTO
fun Paciente.toDto() = PacienteDto(
    uuid = uuid.toString(),
    nombre = nombre,
    edad = edad.toString(),
    createdAt = createdAt.toString(),
)

fun PacienteDto.toPaciente() = Paciente(
    uuid = UUID.fromString(uuid),
    nombre = nombre,
    edad = edad.toInt(),
    createdAt = LocalDateTime.parse(createdAt),
)

// Para las listas, necesitamos una clase contenedora
@Root(name = "pacientes_list")
data class PacientesDto(
    @field:ElementList(name = "pacientes", inline = true) // inline para que no se cree un elemento contenedor
    @param:ElementList(name = "pacientes", inline = true) // inline para que no se cree un elemento contenedor
    val pacientes: List<PacienteDto>,
)

fun List<Paciente>.toDto() = PacientesDto(pacientes = map { it.toDto() })
fun PacientesDto.toPacientes() = pacientes.map { it.toPaciente() }


 // ....
 // Vamos con una lista
val pacientes = listOf(
    Paciente(nombre = "Juan", edad = 30),
    Paciente(nombre = "Ana", edad = 25),
    Paciente(nombre = "Luis", edad = 40),
    Paciente(nombre = "María", edad = 35),
)
val serializer = Persister()
serializer.write(pacientes.toDto(), File(fichero));
println("Escrito de $fichero2")

```

### Escritura de XML
Para escribir un XML usaremos las mismas librerías que para leerlo. Para escribir un XML usaremos la librería [Simple XML](https://simple.sourceforge.net/). Esta librería nos permite convertir objetos a XML y viceversa y es optima para trabajar con Kotlin y Java. Además podemos usar otras como [Kotlin serialzation](https://kotlinlang.org/docs/serialization.html#example-xml-serialization) pero solo es compatible con Kotlin. OJO, la recomiendo mucho más que Simple XML si solo vas a trabajar con Kotlin y así la usaremos en un futuro.

```kotlin
val serializer = Persister()
val pacientes = serializer
    .read(PacientesDto::class.java, File(fichero2))
    .toPacientes()
println(pacientes2)
```



## Ficheros Temporales
Los ficheros o directorios temporales son muy útiles para almacenar datos que no queremos que persistan indefinidamente, o simplemente serán de intercambio o necesarios para operaciones intermedias.

Podemos crear un directorio temporal con `createTempDirectory()` y un fichero temporal con `createTempFile()`. Ambos métodos reciben como parámetro el nombre del fichero o directorio y opcionalmente el sufijo y prefijo del mismo. Por defecto se crean en el directorio temporal del sistema, pero podemos indicarle otro directorio con el parámetro `dir`.

Por otro lado, siempre podemos usar resolve y relativize para crear rutas relativas y absolutas.

Podemos borrarlos con `deleteOnExit()` (se borra automáticamente al terminar) o `delete()` o `deleteRecursively()`.

```kotlin
val tempDir = createTempDirectory("myTempDir")
println("Directorio temporal: $tempDir")

// ya es como un directorio normal, podemos copiar archivos
Files.copy(
    File("build.gradle.kts").toPath(),
    tempDir.resolve("build.gradle.kts"),
    StandardCopyOption.REPLACE_EXISTING
)

Files.copy(
        File("settings.gradle.kts").toPath(),
        tempDir.resolve("settings.gradle.kts"),
        StandardCopyOption.REPLACE_EXISTING
    )

// Listamos el contenido del directorio
println("Contenido del directorio temporal:")
tempDir.toFile().listFiles()?.forEach { if (it.isFile) println(it.name) }

// También podemos crear ficheros temporales
val tempFile = File.createTempFile("myTempFile", ".txt")
println("Fichero temporal: ${tempFile.absolutePath}")
// Podemos escribir el listado de ficheros de este proyecto allí
tempFile.writeText(archivos.joinToString("\n") { it.name })
// Y finalmente mostrarlo
println("Contenido del fichero temporal:")
println(tempFile.readText())

// Borramos el directorio temporal
tempDir.toFile().deleteRecursively() // Son directorios que pueden tener ficheros
tempFile.deleteOnExit() // Es un fichero, por eso podemos borrar al salir
```

## Ficheros Zip
Los ficheros Zip son ficheros comprimidos que contienen uno o más ficheros. Son muy útiles para intercambiar datos o para comprimirlos y ahorrar espacio. Podemos crearlos con `ZipOutputStream` y leerlos con `ZipInputStream`. Ambos reciben como parámetro el fichero a comprimir o descomprimir.

```kotlin
// Comprimimos los ficheros en el zip
ZipOutputStream(Files.newOutputStream(myZip)).use { zip ->
    archivos.forEach { archivo ->
        zip.putNextEntry(ZipEntry(archivo.name))
        Files.copy(archivo.toPath(), zip)
        zip.closeEntry()
    }
}

// Leemos el contenido
ZipFile(myZip).entries().asSequence().forEach { println(it.name) }

// Descomprimimos el zip
ZipFile(myZip).use { zip ->
    zip.entries().asSequence().forEach { archivos ->
        println("Descomprimiendo: ${archivos.name} en ${destino.fileName}")
        zip.getInputStream(archivos).use { input ->
            Files.copy(input, destino.resolve(entry.name))
        }
    }
}
```

</div>