# Control de acceso, autentificación y autorización


## Control de acceso

El **Control de acceso** en un servidor web nos permite determinar desde donde podemos acceder a los recursos del servidor.

En **apache2** se utilizan las siguientes directivas: [order](http://httpd.apache.org/docs/2.2/mod/mod_authz_host.html#order), [allow](http://httpd.apache.org/docs/2.2/mod/mod_authz_host.html#allow) y [deny](http://httpd.apache.org/docs/2.2/mod/mod_authz_host.html#deny). Un buen manual para que quede más claro lo puedes encontrar en este [enlace](http://systemadmin.es/2011/04/la-directiva-order-de-apache).  La directiva [satisfy](http://httpd.apache.org/docs/2.2/mod/core.html#satisfy) controla como el se debe comportar el servidor cuando tenemos autorizaciones de control de acceso (allow, deny,...) y tenemos autorizaciones de usuarios (require).

En **apache2.4** se utilizan las siguientes directivas: [Require](https://httpd.apache.org/docs/2.4/es/mod/mod_authz_core.html#require), [RequireAll](https://httpd.apache.org/docs/2.4/es/mod/mod_authz_core.html#requireall), [RequireAny](https://httpd.apache.org/docs/2.4/es/mod/mod_authz_core.html#requireany) y [RequireNone](https://httpd.apache.org/docs/2.4/es/mod/mod_authz_core.html#requirenone)

1. Comprueba el control de acceso por defecto que tiene el virtual host por defecto (000-default).
2. Crea un escenario en Vagrant que tenga un servidor con una red publica, y una privada, un cliente conectada a la red privada. Crea un host virtual, que sólo se tenga acceso desde el cliente de la red local, y no se pueda acceder desde la anfitriona por la red pública.

## Autentificación básica

El servidor web Apache puede acompañarse de distintos módulos para proporcionar diferentes modelos de autenticación.
La primera forma que veremos es la más simple. Usamos para ello el módulo de autenticación básica que viene instalada "de serie" con cualquier Apache: [mod_auth_basic](http://httpd.apache.org/docs/2.4/es/mod/mod_auth_basic.html). La configuración que tenemos que añadir en el fichero de definición del Virtual Host a proteger podría ser algo así:

  ```bash
  <Directory "/var/www/miweb/privado">
    AuthUserFile "/etc/apache2/claves/passwd.txt"
    AuthName "Palabra de paso"
    AuthType Basic
    Require valid-user
  </Directory>
  ```

El método de autentificación básica se indica en la directiva [AuthType](http://httpd.apache.org/docs/2.4/es/mod/core.html#authtype).  

* En ``Directory`` escribimos el directorio a proteger, que puede ser el raíz de nuestro Virtual Host o un directorio interior a este.
* En [AuthUserFile](http://httpd.apache.org/docs/2.4/es/mod/mod_authn_file.html#authuserfile) ponemos el fichero que guardará la información de usuarios y contraseñas que debería de estar, como en este ejemplo, en un directorio que no sea visitable desde nuestro Apache. Ahora comentaremos la forma de generarlo.
* Por último, en [AuthName](http://httpd.apache.org/docs/2.4/es/mod/core.html#authname) personalizamos el mensaje que aparecerá en la ventana del navegador que nos pedirá la contraseña.
* Para controlar el control de acceso, es decir, que usuarios tienen permiso para obtener el recurso utilizamos las siguientes directivas: [AuthGroupFile](http://httpd.apache.org/docs/2.4/es/mod/mod_authz_groupfile.html#authgroupfile), [Require user](http://httpd.apache.org/docs/2.4/es/mod/core.html#require), [Require group](http://httpd.apache.org/docs/2.4/es/mod/core.html#require).

El fichero de contraseñas se genera mediante la utilidad ``htpasswd``. Su sintaxis es bien sencilla. Para añadir un nuevo usuario al fichero operamos así:

    $ htpasswd /etc/apache2/claves/passwd.txt carolina
    New password:
    Re-type new password:
    Adding password for user carolina

Para crear el fichero de contraseñas con la introducción del primer usuario tenemos que añadir la opción ``-c`` (create) al comando anterior. Si por error la seguimos usando al incorporar nuevos usuarios borraremos todos los anteriores, así que cuidado con esto. Las contraseñas, como podemos ver a continuación, no se guardan en claro. Lo que se almacena es el resultado de aplicar una [función hash](http://es.wikipedia.org/wiki/Hash):

    josemaria:rOUetcAKYaliE
    carolina:hmO6V4bM8KLdw
    alberto:9RjyKKYK.xyhk

Para denegar el acceso a algún usuario basta con que borremos la línea correspondiente al mismo. No es necesario que le pidamos a Apache que vuelva a leer su configuración cada vez que hagamos algún cambio en este fichero de contraseñas.

 La principal ventaja de este método es su sencillez. Sus inconvenientes: lo incómodo de delegar la generación de nuevos usuarios en alguien que no sea un administrador de sistemas o de hacer un front-end para que sea el propio usuario quien cambie su contraseña. Y, por supuesto, que dichas contraseñas viajan en claro a través de la red. Si queremos evitar esto último podemos crear una [instancia Apache con SSL](http://blog.unlugarenelmundo.es/2008/09/23/chuletillas-y-viii-apache-2-con-ssl-en-debian/).

**Cómo funciona este método de autentificación**

Cuando desde el cliente intentamos acceder a una URL que esta controlada por el método de autentificación básico:

1. El servidor manda una respuesta del tipo 401 *HTTP/1.1 401 Authorization Required* con  una cabecera *WWW-Authenticate* al cliente de la forma:

    ```bash
    WWW-Authenticate: Basic realm="Palabra de paso"
    ```

2. El navegador del cliente muestra una ventana emergente preguntando por el nombre de usuario y contraseña y cuando se rellena se manda una petición con una cabecera *Authorization*

    ```bash
    Authorization: Basic am9zZTpqb3Nl
    ```

En realidad la información que se manda es el nombre de usuario y la contraseña en base 64, que se puede decodificar fácilmente con cualquier [utilidad](http://www.base64decode.org/).

**Ejercicios**

1. Crea cuatro  usuarios de apache: pepe, maria, juan, ana.

2. Crea dos grupos de usuarios: grupo1 (pepe,maria), grupo2 (juan,ana).

3. Crea un directorio llamado privado1 en el host virtual default, que permita el acceso a todos los usuarios.

4. Crea un directorio llamado privado2 en el host virtual default, que permita el acceso sólo a juan y a ana.

5. Crea un directorio llamado privado3 en el host virtual default, que permita el acceso sólo los usuarios del grupo1.
6. El directorio privado3 del ejercicio5 haz que sólo sea accesible desde el localhost.


## Autentificación tipo digest

La autentificación tipo digest soluciona el problema de la transferencia de contraseñas en claro sin necesidad de usar SSL.  El procedimiento, como veréis, es muy similar al tipo básico pero cambiando algunas de las directivas y usando la utilidad ``htdigest`` en lugar de ``htpassword`` para crear el fichero de contraseñas. El módulo de autenticación necesario suele venir con Apache pero no habilitado por defecto. Para activarlo usamos la utilidad ``a2enmod`` y, a continuación reiniciamos el servidor Apache:

    $ a2enmod auth_digest
    $ /etc/init.d/apache2 restart

Luego incluimos una sección como esta en el fichero de configuración de nuestro Virtual Host:

  ```bash
  <Directory "/var/www/miweb/privado">
     AuthType Digest
     AuthName "dominio"
     AuthUserFile "/etc/claves/digest.txt"
     Require valid-user
  </Directory>
  ```

Como vemos, es muy similar a la configuración necesaria en la autenticación básica. La directiva ``AuthName`` que en la autenticación básica se usaba para mostrar un mensaje en la ventana que pide el usuario y contraseña, ahora se usa también para identificar un nombre de dominio (realm) que debe de coincidir con el que aparezca después en el fichero de contraseñas. Dicho esto, vamos a generar dicho fichero con la utilidad htdigest:

    $ htdigest -c /etc/claves/digest.txt dominio josemaria
    Adding password for josemaria in realm dominio.
    New password:
    Re-type new password:

Al igual que ocurría con htpassword, la opción ``-c`` (create) sólo debemos de usarla al crear el fichero con el primer usuario. Luego añadiremos los restantes usuarios prescindiendo de ella. A continuación vemos el fichero que se genera después de añadir un segundo usuario:

    josemaria:dominio:8d6af4e11e38ee8b51bb775895e11e0f
    gemma:dominio:dbd98f4294e2a49f62a486ec070b9b8c

**Cómo funciona este método de autentificación**

Cuando desde el cliente intentamos acceder a una URL que esta controlada por el método de autentificación de tipo digest:

1. El servidor manda una respuesta del tipo 401 *HTTP/1.1 401 Authorization Required* con  una cabecera *WWW-Authenticate* al cliente de la forma:

    ```bash
    WWW-Authenticate: Digest realm="dominio",
                     nonce="cIIDldTpBAA=9b0ce6b8eff03f5ef8b59da45a1ddfca0bc0c485",
                     algorithm=MD5,
                     qop="auth"

2. El navegador del cliente muestra una ventana emergente preguntando por el nombre de usuario y contraseña y cuando se rellena se manda una petición con una cabecera *Authorization*

    ```bash
    Authorization	Digest username="jose",
                    realm="dominio",
                    nonce="cIIDldTpBAA=9b0ce6b8eff03f5ef8b59da45a1ddfca0bc0c485",
                    uri="/digest/",
                    algorithm=MD5,
                    response="814bc0d6644fa1202650e2c404460a21",
                    qop=auth,
                    nc=00000001,
                    cnonce="3da69c14300e446b"

La información que se manda es *responde* que en este caso esta cifrada usando md5 y que se calcula de la siguiente manera:

* Se calcula el md5 del nombre de usuario, del dominio (realm) y la contraseña, la llamamos HA1.
* Se calcula el md5 del método de la petición (por ejemplo GET) y de la uri a la que estamos accediendo, la llamamos HA2.
* El reultado que se manda es el md5 de HA1, un número aleatorio (nonce), el contador de peticiones (nc), el qop y el HA2.

Una vez que lo recibe el servidor, puede hacer la misma operación y comprobar si la información que se ha enviado es válida, con lo que se permitiría el acceso.


**Ejercicio:**

1. Crea dos subdirectorios en el host virtual defaul que se llamen ``grupo1`` y ``grupo2``. Crea varios usuarios con la utilidad ``htdigest``, asignando a cada uno un dominio distinto (``domgrupo1`` y ``domgrupo2``). Configura los directorios para que al primero grupo1 sólo puedan acceder los usuarios del dominio domgrupo1, y el directorio grupo2 solo accedan los usuarios del dominio domgrupo2.
