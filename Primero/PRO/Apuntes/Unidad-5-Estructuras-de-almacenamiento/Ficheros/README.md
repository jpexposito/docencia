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

</div>