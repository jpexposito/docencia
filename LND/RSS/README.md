<div align="justify">


# RSS

  <div align="center">
   	<img src="https://www.mediagroup.es/wp-content/uploads/2016/06/rss.jpg" width="500px">
  </div>

## Introducción

Muchas páginas web disponen de __«feeds»__. Un __«feed»__ es un mecanismo de suscripción que facilita la recepción de información.

En general, los feed utilizan un vocabulario XML llamado RSS o uno llamado __Atom__.

## RSS

RSS es un estándar para la __«sindicación»__ o __«agregación»__ de recursos (recursos web normalmente).

Su objetivo principal era permitir a un sitio web publicar las novedades con facilidad y que el usuario puede ir directamente al lugar que le interese.

## Formato de archivo RSS

Todo archivo RSS es, por supuesto, un XML

```xml
<?xml version="1.0" encoding="utf-8"?>
<rss version="2.0">
        <channel>
                <title>
                        Canal de noticias de SSOO de DAM
                </title>
                <link>
                        http://ssoo.jpexposito.com
                </link>
                <description>
                        En este canal...
                </description>
                <item>
                        <title>Nueva versión de Ubuntu</title>
                        <link>http://ubuntu.org</link>
                        <description>
                                Nueva versión...
                        </description>
                </item>
        </channel>
        <channel>
                <title>
                        Canal de Lenguajes de marcas
                </title>
                <link>
                        http://xml.jpexposito.com
                </link>
                <description>
                        En este canal...
                </description>
                <item>
                        <title>Publicado nuevo validador del W3C</title>
                        <link>http://validator.w3c.org</link>
                        <description>
                                Hay nuevo validador...
                        </description>
                </item>
        </channel>
</rss>
```

Las reglas serían las siguientes:

- Todo archivo de descripción de recursos en RSS utiliza el preámbulo típico de los documentos xml.
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  ```
- Todo RSS tiene un solo elemento raíz en el cual se puede indicar la versión RSS a la que nos ceñimos.
  ```xml
  <rss version="2.0">
  ```
- Un RSS tiene uno o más canales
  ```xml
  <channel>
  </channel>
  ```
- Todo canal debe tener, al menos un título, un enlace base (la dirección del propio sitio web) y una descripción:
  ```xml
  <channel>
          <title>
          </title>
          <link>
          </link>
          <description>
          </description>
          <item>
                  ...
          </item>
          <item>
                  ...
          </item>
  </channel>
  ```
Resumiendo los puntos más importantes:
- Usar como elemento raíz __rss__.
- Todo RSS tiene uno o más __channel__.
- Todo channel tiene al menos __title__, __link__ y __description__.
- Después de estos elementos, un __channel__ puede tener uno o más elementos __item__ (que son los que contienen las noticias).
- Todo __item__ también debe tener un __title__, un __link__ y __description__.

## Construcción de un servicio RSS

El servicio RSS es la solución a muchos de nuestros problemas de organización de contenido de nuestras webs y blogs.

### ¿en qué puede ayudarnos?

- El servicio RSS es un software, o lo que es lo mismo, un programa que nos permite tener centralizada toda la información y novedades de los sitios a los que estamos suscritos.
- El método RSS se puede encontrar tanto en programas como aplicaciones y lectores webs.
- Podemos encontrarlo en todos los soportes y dispositivos para recibir los titulares de las últimas novedades de las webs que nos interesan. Gracias al RSS, los lectores pasan a tener una herramienta útil para mantenerse informados, conservando y almacenando toda la información en un solo lugar que se actualiza de manera automática.

Por otro lado, ___ayuda al usuario a ahorrar tiempo consultando sus noticias diarias de internet y le permite que tenga que acceder a un solo sitio para consultar todas sus noticias___. Ese sitio, es _el lector RSS y el usuario puede elegir entre varios que están a su disposición tanto en el app store como en la web_. El RSS se conecta a todos los sitios en los que el usuario se ha suscrito para descargar las últimas novedades y, mantenerse informado de un simple vistazo.

### ¿Cómo funciona el sistema RSS?

Funciona mediante fuentes o canales RSS. Las fuentes RSS son un vehículo o forma de distribuir contenido web a los lectores RSS. Por medio de los programas de lectores RSS, el usuario se puede suscribir a las fuentes RSS que pertenecen a distintos sitios web.
Este proceso funciona de la siguiente forma: una página web a la que estemos suscritos generaría un contenido, noticia o post. A través de los canales RSS esta noticia se distribuiría y llegaría a nuestro lector RSS que es el que la hace visible, junto con otros contenidos de nuestro interés.
Por lo tanto, es importante para nuestra web o blog la técnica del Ibound Marketing, que consiste en crear un blog o apartado donde generar contenidos de interés para el usuario, de tal forma que acabe suscribiéndose a nuestra newsletter. También es esencial una buena estrategia en las redes sociales sobre los contenidos que generamos en nuestro blog. Según un estudio de internet, el 70% de los usuarios de una página accedió a ella por primera vez a través de las redes sociales. En realidad, el funcionamiento de las RSS se parece mucho a la forma de organizar los contenidos en los «times lines» de facebook, Twitter o Instagram. Cuantos más seguidores tengamos, mayor difusión de nuestros contenidos y productos podremos hacer, porque apareceremos en las time line de más personas. Por ello, una buena estrategia de social media es imprescindible para que podamos ampliar nuestra influencia, nuestras ventas y nuestra presencia en el mundo digital.


## Ejemplos de RSS
  - [El País](https://servicios.elpais.com/rss/).
  - [El Mundo](http://rss.elmundo.es/rss/).
  - Lectores de RSS:
    - [Inoreader](https://www.inoreader.com/).
    - [Newsblur](https://newsblur.com/).   

</div>
