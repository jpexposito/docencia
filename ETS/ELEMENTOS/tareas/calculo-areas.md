<div align="justify">

# Cálculo de Áreas

  El área de una figura geométrica es todo el espacio que queda encerrado entre los límites de esa figura.

## Se plantea

<div align="center">
  <img src="https://www.profesorenlinea.cl/geometriaimagen/areas01.gif" >
</div>

  Para calcular el área de algunas figuras se utilizan las fórmulas que aparecen dentro del dibujo de arriba.

  En cada caso, debe reemplazarse los valores conocidos en los problemas expuestos y calcular los valores pedidos.


## Ejercicio  

  Realiza el análisis para una aplicación que pretende realizar el calculo de las áreas que muestra la imagen. Define clases y métodos necesarios que creas oportunos.


## Realización del informe

  Realiza un informe indicando los pasos que has seguido para la definición de requisitos y donde se muestre si fuera necesario los problemas encontrados.
  Además el informe debe de contener:
   - Titulo de la tarea.
   - Nombre y Apellidos.
   - Indice.
   - Pasos descritos.
   - Carecer faltas de ortografía.
   - Capturas de pantalla con los resultados. obtenidos.
   - Incluye el enlace de tu cuenta _GitHub_ en el detalle de la tarea.

<!--
  <details>
     <summary>PULSA PARA VER UNA APROXIMACIÓN A LA SOLUCIÓN:</summary>
-->

### Resolución

#### Cosas a tener en cuenta

  Para la resolución del problema hemos de tener en cuenta:
  - el número de áreas que se solicita crear.
  - el número de parámetros de entrada de cada una de las áreas.
  - la fórmula matemática de cada una de las áreas.

  Acciones que debe de realizar la aplicación:
  - Pedir datos de entrada.
    - Áreas que sólo necesitan un parámetro de entrada (l/r).
    - Áreas que necesitan dos parámetros de entrada(a/b/D/d,...).
  - Realizar el calculo del área.

#### Métodos o funciones a construir:

  Hemos de identificar aquellas __áreas__ cuya función matemática sea igual o similar para agrupar.

  _Pongamos un ejemplo_, el area del cuadrado o rectángulo lo podemos ver como la misma función (__l<sup>2</sup> = l*l__, que podría ser igual a __a*b__. Del mismo modo __r<sup>2</sup> = r*r__).

  Por este modo, debiéramos definir una función que calcule la _multimplicación de dos números_.

  ```
  funcion multiplicar(valorA, valorB)
    retorna valorB*valorB;
  ```

  De esta forma la función de calculo del área del _cuadrado_ será:
  ```
  funcion cuadrado(l, l)
    retorna multiplicar(l, l);
  ```

  Podemos observar la función para el ___cuadrado realiza la llamada a la función multiplicar___. Del mismo modo, la función del _rectángulo_ quedará como sigue:
  ```
  funcion rectangolo(valorA, valorB)
    retorna multiplicar(valorA, valorB);
  ```
  al igual que la del _romboide_
  ```
  funcion romboide(valorA, valorH)
    retorna multiplicar(valorA, valorH);
  ```

  Veamos ahora, la función para el cálculo del área del triángulo:
  ```
  funcion triangulo(valorA, valorB)
    retorna multiplicar(valorA, valorB)/2;
  ```

  Siguiendo el modelo anterior, podemos _reutilizar_ nuevamente código:
  ```
  funcion rombo(valorD, valorD)
    retorna triangulo(valorD, valorD);
  ```
  o en,
  ```
  funcion pentagono(valorA, valorP)
    retorna triangulo(valorA, valorP);
  ```
  Para el calculo del _circulo_, haremos:
  ```
  funcion circulo(valorR)
    retorna Pi*multiplicar(valorR, valorR);
  ```

  Para el _trapecio_ no podríamos seguir este patrón, dado que vemos que su fórmula es diferente a las vistas hasta ahora. Quedará como sigue:
  ```
  funcion trapecio(valorB, valorb, valorH)
    retorna ()(valorB, valorb)/2)*valorH;
  ```

  ___Como podemos observar, podremos agrupar todas las fórmulas, salvo esta última.___

  Podemos aplicar la misma técnica con la solicitud de datos, agrupando en aquellas fórmulas que requieren __uno/dos__ parámetros.

  _RECUERDA SIEMPRE APLICAR EL PRINCIPIO DE_ ___REUTILIZACIÓN___ _EN PROGRAMACIÓN, PARA QUE EL MANTENIMIENTO_ ___$___, _DE LA APP SEA MENOR Y DESARROLLAR Y PENSAR EN ESA LÍNEA_.


  <div align="center">
    <img src="https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1#G1eYF0tzUB12cDQUFzNFeA0kqAGT1WV8wp" >
  </div>

  ![](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1#G1eYF0tzUB12cDQUFzNFeA0kqAGT1WV8wp)






  </details>

<div>
