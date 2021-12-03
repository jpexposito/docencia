<div align="justify">


<div align="center">
 	<img src="https://disenowebakus.net/imagenes/articulos/aprender-css-hojas-de-estilo-en-cascada.jpg">
</div>

## ¿Que es CSS?
  Puede que ya hayas oído hablar de CSS sin saber realmente qué es. En esta lección aprenderás más cosas sobre CSS y qué puede hacer por ti.

  CSS es el acrónicmo de CascadingStyle Sheets (es decir, hojas de estilo en cascada).

## ¿Qué puedo hacer con CSS?

  CSS es un lenguaje de estilo que define la presentación de los documentos HTML. Por ejemplo, CSS abarca cuestiones relativas a fuentes, colores, márgenes, líneas, altura, anchura, imágenes de fondo, posicionamiento avanzado y muchos otros temas. ¡Espera unos segundos y ya verás!

  Es posible usar HTML, o incluso abusar del mismo, para añadir formato a los sitios web. Sin embargo, CSS ofrece más opciones y es más preciso y sofisticado. CSS está soportado por todos los navegadores hoy día.

  Después de unas cuantas lecciones de este tutorial serás capaz de crear tus propias hojas de estilo usando CSS para dar a tu sitio web un aspecto nuevo y genial.

## ¿Qué diferencia hay entre CSS y HTML?

  HTML se usa para estructurar el contenido; CSS se usa para formatear el contenido previamente estructurado.

  Vale, suena un poco técnico y confuso... pero sigue leyendo; pronto todo tendrá sentido.

  Allá en los buenos tiempos en que Madonna era una "Virgen" y un tipo llamado Tim Berners Lee inventó el World Wide Web, el lenguaje HTML sólo se usaba para añadir estructura al texto. Los autores podían marcar sus textos diciendo "esto en un título" o "esto es un párrafo", usando las etiquetas HTML \<h1> y \<p>, respectivamente.

  A medida que la Web fue ganando popularidad, los diseñadores empezaron a buscar posibilidades para añadir formato a los documentos en línea. Para satisfacer esta reclamación, los fabricantes de los navegadores (en ese momento, Netscape y Microsoft) inventaron nuevas etiquetas HTML, entre las que se encontraban, por ejemplo, <font>, que se diferenciaba de las etiquetas originales HTML en que definían el formato... y no la estructura.

  Esto también llevó a una situación en la que las etiquetas estructurales originales, por ejemplo, <table>, se usaban cada vez más de manera incorrecta para dar formato a las páginas en vez de para añadir estructura al texto. Muchas nuevas etiquetas que añadían formato, por ejemplo, <blink>, sólo las soportaban un tipo determinado de navegador. "Necesitas el navegador X para visualizar esta página" se convirtió en una declaración de descargo común en los sitios web.

  CSS se inventó para remediar esta situación, proporcionando a los diseñadores web con sofisticadas oportunidades de presentación soportadas por todos los navegadores. Al mismo tiempo, la separación de la presentación de los documentos del contenido de los mismos, hace que el mantenimiento del sitio sea mucho más fácil.

## ¿Qué beneficios me ofrece CSS?

  CSS fue toda una revolución en el mundo del diseño web. Entre los beneficios concretos de CSS encontramos:

  - control de la presentación de muchos documentos desde una única hoja de estilo;
  - control más preciso de la presentación;
  - aplicación de diferentes presentaciones a diferentes tipos de medios (pantalla, impresión, etc.);
  - numerosas técnicas avanzadas y sofisticadas.

## ¿Cómo funciona CSS?

  En esta lección aprenderás a crear tu primera hoja de estilo; conocerás el modelo básico de CSS y qué código es necesario para usar CSS en un documento HTML.

  Muchas de las propiedades que se usan en
  las hojas de estilo en cascada (CSS) son parecidas a las de HTML. Así pues, si estás acostumbrado a usar HTML para cuestiones de presentación, lo más probable es que reconozcas gran parte del código usado. Examinemos un ejemplo concreto.

### La sintaxis básica de CSS

  Digamos que queremos un bonito color rojo como fondo de nuestra página web:

  Usando HTML podríamos haberlo conseguido así:

```html
  <body bgcolor="#FF0000">
```

  Con CSS el mismo resultado puede lograrse así:

```html
  body {background-color: #FF0000;}
```  

  Como verás, el código usado es más o menos idéntico para HTML y CSS. El ejemplo anterior te muestra además el modelo CSS fundamental:

  Imagen explicativa de los términos selector, propiedad y valor.

  Pero ¿dónde se sitúa el código CSS? Eso, precisamente, es lo que vamos a estudiar ahora mismo.

### Aplicando CSS a un documento HTML

  Podemos aplicar CSS a un documento HTML de tres maneras diferentes. Todos estos métodos se explican a continuación. Te recomendamos que te centres en el tercero, es decir, el externo.

### Método 1: En línea (el atributo style)

  Un modo de aplicar CSS a HTML es usando el atributo de HTML style. Si ampliamos el ejemplo anterior sobre el color de fondo rojo, CSS se puede aplicar así:

```html
  	<html>
  	  <head>
  		<title>Ejemplo</title>
  	  </head>
  	  <body style="background-color: #FF0000;">
  		<p>Esta es una página con fondo rojo</p>
  	  </body>
  	</html>
  ```

### Método 2: Interno (la etiqueta style)

  Otra forma es incluir el código CSS usando la etiqueta HTML <style>. Por ejemplo, así:

```html
  	<html>
  	  <head>
  		<title>Ejemplo</title>
  		<style type="text/css">
  		  body {background-color: #FF0000;}
  		</style>
  	  </head>
  	  <body>
  		<p>Esta es una página con fondo rojo</p>
  	  </body>
  	</html>
```

### Método 3: Externo (enlace a una hoja de estilo)

  El método recomendado es enlazar con lo que se denomina hoja de estilo externa. A lo largo de este tutorial usaremos este método en todos nuestros ejemplos.

  Una hoja de estilo externa es sencillamente un fichero de texto con la extensión .css. Como cualquier otro fichero, puedes colocar la hoja de estilo en el servidor web o en el disco duro.

  Por ejemplo, digamos que tu hoja de estilo se llama style.css y está localizada en una carpeta que se llama style. Esta situación se puede ilustrar de la siguiente manera:

  ___La carpeta "style" que contiene el fichero "style.css"___.

  El truco consiste en crear un vínculo desde el documento HTML (por ejemplo, default.htm) con la hoja de estilo (style.css). Dicho vínculo se puede crear con una sencilla línea de código HTML:

```html
  	<link rel="stylesheet" type="text/css" href="style/style.css" />
```

  Fíjate cómo la ruta a nuestra hoja de estilo aparece indicada por medio del atributo href.

  La línea de código debe insertarse en la sección de encabezado del código HTML, es decir, entre la etiqueta <head> y </head>. De esta manera:

```html
  	<html>
  	  <head>
  		<title>Mi documento</title>
  		<link rel="stylesheet" type="text/css" href="style/style.css" />
  	  </head>
  	  <body>
  	  ...
  ```

  Este vínculo indica al navegador que debería usar la presentación del fichero CSS al mostrar el fichero HTML. Lo realmente bueno de este método es que se pueden vincular varios documentos HTML con la misma hoja de estilo. En otras palabras, se puede usar un único fichero CSS para controlar la presentación del muchos documentos HTML.

  Imagen que muestra cómo varios documentos HTML se pueden vincular con la misma hoja de estilo

  Esta técnica puede ahorrarte mucho trabajo. Si quisieras cambiar, por ejemplo, el color de fondo de un sitio web compuesto por 100 páginas, un hoja de estilo puede ahorrarte el tener que cambiar de forma manual los 100 documentos HTML. Con CSS, el cambio se puede llevar a cabo en unos segundos modificando parte del código de la hoja de estilo principal.

  Vamos a llevar a la práctica lo que acabamos de aprender.

#### Pruébalo tú mismo

  Abre el Bloc de notas (o el editor de texto que utilices) y crea dos ficheros - un fichero HTML y un fichero CSS - con el siguiente contenido:

  Fichero default.htm

```html
  	<html>
  	  <head>
  		<title>Mi documento</title>
  		<link rel="stylesheet" type="text/css" href="style.css" />
  	  </head>
  	  <body>
  		<h1>Mi primera hoja de estilo</h1>
  	  </body>
  	</html>
```

  Fichero style.css

```css
  	body {
  	  background-color: #FF0000;
  	}
```
_Ahora coloca los dos ficheros en la misma carpeta. Recuerda grabar los ficheros con las extensiones correctas (".htm" y ".css", respectivamente)._

  ___Abre el fichero default.htm___ con el navegador y observa que la página tiene un color de fondo rojo. ¡Enhorabuena! ¡Acabas de crear tu primera hoja de estilo!

  Y ahora sin parar pasa a la lección siguiente en la que examinaremos algunas de la propiedades de CSS.

  

</div>
