<div align="justify">

<div align="center">
<img src="https://luciamonterorodriguez.com/wp-content/uploads/2021/03/computer-1331579_640.png" width="200px"/>
</div>

> __Nota__. Seguiremos trabajando con la tabla __usuario__.

Para aclarar algunas instrucciones, en ocasiones, necesitamos agregar comentarios. También para evitar que se ejecuten uno o más comandos podemos marcar dichas instrucciones con comentarios.
Es posible ingresar comentarios en la línea de comandos, es decir, un texto que no se ejecuta; para ello se emplean dos guiones __(--)__ al comienzo de la línea:

```sql
 select * from usuario; -- mostramos los usuarios
```

en la línea anterior, todo lo que está luego de los guiones (hacia la derecha) no se ejecuta.

Para agregar varias líneas de comentarios, se coloca una barra seguida de un asterisco (/\*) al comienzo del bloque de comentario y al finalizarlo, un asterisco seguido de una barra (\*/).

```sql
  select nombre, clave 
 /* mostramos el usuario
  y clave de toda la tabla */
 from usuario;
 ```

 todo lo que está entre los símbolos __/\*__ y __\*/__ no se ejecuta.

</div>