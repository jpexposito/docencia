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


  [Solución en Casos de Uso](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Caso-Uso-Area.drawio#R7V1bc5s6EP41fqwHkBDoMXXanjPTzuQ0PXPaR2xkmym2XIxz6a8%2Fko1sdIlNMPc0DwmIi2C%2F%2FVa7Ky0Zgcnq6VMSbJZfaEjikWOFTyNwO3IcDBH7zRueDw3IsQ8NiyQKD025hvvoN8karax1F4VkK52YUhqn0UZunNH1msxSqS1IEvoonzansdzrJlgQreF%2BFsR6639RmC4Prb7jndr%2FItFiKXq2ET4cWQXi5OxNtssgpI%2B5JvBhBCYJpelha%2FU0ITGXnZDL4bqPLxw9PlhC1mmRC6YfLfpj8ffnyLLvvc1XSH99%2BfgOOofbPATxLnvj7GnTZyGCRUJ3G7237AEeSJKSJxMWwVTc4fS6TE0IXZE0eWbnZVfBTECZhnjZ7uNJ3C7O2pY5UUPHzWDOIF4c73ySAtvIBGEWim9H6eOcvp%2BvnubffsWf%2F3n4FLzDmkz%2B3e6CJKIjB8Ws9%2FfThG0t%2BJYmLIbyhm%2FuVvHNLKUJO2eZrlj3tzbb5MKKmHJ9DqYkvqPbKI3omh2b0jSlq9wJN3G04AdSumGtQbY3Y8InybHbPBrn0VUx0rHIhG8DXfrAIHxk1SR7wftzCilknOwJb5KvLL45Xaf32eX8rMdllJL7TTDjDY%2FMbJlEPI%2FieEJjjuDtmq5JLVIXR22ZArargQBNFAB%2BbTBADYZJEM92ccBU37pJSMD%2BTHZBmDCj9iJArCNmp4mM0TZN6M%2BjMQVl8dmQJGLvyrdFP3enJgm%2BkQPm87kzmx17zx0J0RS5qFZ0PRldqFPsqACSgasNXN3AHS2bMGxj9iMaWSfTFw0eE0JqAljhjoFOGqQqe1dRGPJujArBBqV1SPhrWrWCh10JPGAwkMhEzQrAM74C0LC7I2HEWXkbpHTbAy6GLvFDaOKi70wBqpWLEMhw%2BgYumsa7KrhofAVXg%2FMrYfL9vbezk9EEjG5sbnf7YGRbBRaqQyjWkXWaRNYvMIJ%2B5R7MHuP1oh8Yd2kgPeLZxEhqfAd9INUx%2FpZEfyAuDTE20LhRiA0BiYHHdDWlUUj%2BoPsqdI3Db7Po2hq6GoZkHd7wTBKXeRxst9FMhlH2RJnMkufv%2BZ0ffGfsit3bp%2FzB2%2BdyHmwaJAty7sTMTyShlN%2FSoUlIHKTRg5zuMsk5u%2FSORuwBj5A6WIZUjUi3dJfMSHZRPjul3AcCPMbYt1zM1cKDAMl2wEJj4Ho%2BgsBDDsKWkvs5iEPrZq8Tx5e9Qk1MaTIUrDgfsxApvxetZ%2FGOW4OscSGdYo6jOFD7tBDXKLJlHuAhfWbJylY8aCqoUPbZpF0hdhdWoeuoqqckWqIqeYrS79kd%2BXbuKrZ3uojvlKT3gTaXvcvOmAFfdb%2FL2gFkjS1wsgNQti7u2G%2FRCujB2mCsAOyLFfC6YgWqHrDdlpgKwRjBkmSF%2BAxZWQjOhvQcW5Ve6marHoAPhq1eT9jq6MHTtWwtMfY2xPD8mH12UqU7pgDLhAXXmALFrHiKA1Az2x1TIDcMtgsSdZ%2Ft%2BtxEVWPzO%2BYV2q5MX%2BDX4Kfv75BLn9TivOOu2QHvPHcLGwEXnfMH%2FFZjeMcUPw7EQoC%2BWAhUm4XoYQwvMp2dsQNYsQOlk3norB3A7doBUwQ5EDuA%2BmIHTCtQ3qwdKOoOtJTSP6rP1TGB1WxMAEzR50CYjnvCdGDKmQ4iX9dSZh2oJCrNRrthNpp8v2GwUSh599loyol2aNwFys%2F5UJ3tVBipnysFyBuDs6m9i9YgX9VgWOgg2q40GtpiuLI2w7rgCtRtMzrjJzagWOfmeTuqV2oZSFG9spVBreFkMTQ5hm9KrXCn1aps3sG%2BsBipbrXq62KyytRKuJQd1StckblyRPhVvWKZvQtdse6jbUpWwQjcjNQ6AYvv%2BfZ%2BZaqifQMv1gGKuwKwXkhnLO%2BorVoH6pMO3a8lfamy90W5K8t6kQs0sddVRGqWeoGkQ3eKSF8tbnUZtevo8kaWSc2rqBc1S1wP7odloV4NErTlWQ9s6SA1bIv0iY%2B3V9P7ahxVJ8JFBhwbrVmAxoVtAyvffT1OSKnsNAxCjRbqQj130btK3YD4cyPD0Mwn03k1yCHFa0Omsr5mi3L1%2FECPq3JbAdGziw53fl0g6kHTmy3AvXrUQ7DtUc91CsD5Nmptr0bTE%2FFQe2jqS0XfXlXt1Tj6ppiiURw9faTU0BrYhGKG2sVVPSL1czFpKuKyi0lTc7bFFP2fy6kWT5%2Bqn6VCHpBvUXgaUXlkDyo3qjkx73U4MV%2B5Ogm%2Fp%2Fvq5JdUp2Pf4pFxw%2BqkuyIDVienJ%2BrkWWXVCSl6qd6obnWqr2ymg%2BpUdNlc6%2BpkV2SdPMGgptRJn3L6RLZ8cmjvW7%2Bceu%2BeV13qg2JXZ%2BqPbo7kVSNdyerzqjuzaLaa5fFFrYhX2GUuun7l2gUEahqk7OJbLcfZ8FJ4b7iLb72%2BLL71Or74tnVWi4Gzbla7Iud89BzhWKlBK8xrNaZRHY%2B6eW38lO8weO33hNd%2B9TmwKvl5kXaCn3XTDqhhu1%2BadlCIWNxKncWtmXb%2BcL82IbS5%2B7SrPgvT6rdlig6nbud4rTrJrj8WOe1XE1sdT3GzxeG%2BKRczEGI7fSF29R96vIrYY2A5MrmxBy552MU%2BI1OY86BrnFeX%2FNp26bHcYwIF2IYA2Q4GNpa%2F%2FMqdc8vxXOgD2%2FZdsSj8gj1gyhE8507b8BO2tViM4X4UUhCx%2Bxaj%2Bs%2FK9MMVcLpmFhxlEaat3KK4g69O7hRz8Bvk%2FXA%2FI%2BO3%2FxkZtnv6z3gHyE7%2FXhB8%2BB8%3D)








  </details>

<div>
