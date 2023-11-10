<div align="justify">

# Supuesto 1

## Ejercicio 1: Búsqueda binaria

Implementa el algoritmo de _búsqueda binaria_ para encontrar la posición de un elemento en un array ordenado.

La búsqueda binaria es un algoritmo de búsqueda eficiente que sigue estos pasos:

1. **Inicio y Fin:**
   - Inicia con el array ordenado y establece un índice de inicio y fin.

2. **Punto Medio:**
   - Calcula el índice del punto medio entre el inicio y el fin.

3. **Comparación:**
   - Compara el valor buscado con el elemento en el punto medio.
     - Si son iguales, se ha encontrado el elemento y se devuelve su posición.
     - Si el valor buscado es menor, repite la búsqueda en la mitad izquierda.
     - Si el valor buscado es mayor, repite la búsqueda en la mitad derecha.

4. **Repetición:**
   - Repite los pasos 2 y 3 hasta encontrar el elemento o hasta que el índice de inicio sea mayor que el índice de fin.

### Pseudocódigo

El pseudocódigo para la búsqueda binaria podría ser:

```code
      function busquedaBinaria(array, value)
      start = 0
      end = length(array) - 1
      
      while start <= end
          mid = (start + end) / 2
          if array[mid] == value
              return mid
          else if array[mid] < value
              start = mid + 1
          else
              end = mid - 1
              
      return -1 // Valor no encontrado
```

## Ejercicio 2: Ordenamiento

Implementa el algoritmo de __ordenamiento de burbuja__ para ordenar un array de números enteros.

_El ordenamiento de burbuja es un algoritmo de ordenamiento simple que funciona comparando repetidamente pares de elementos adyacentes y intercambiándolos si están en el orden incorrecto. Este proceso se repite hasta que no se requieren más intercambios, lo que indica que el array está ordenado:

Pasos:

El ordenamiento de burbuja sigue estos pasos:

1. **Comparación de Elementos:**
   - Compara cada par de elementos adyacentes en el array.

2. **Intercambio de Elementos:**
   - Si los elementos están en el orden incorrecto, los intercambia.

3. **Repetición:**
   - Repite los pasos 1 y 2 para cada elemento en el array.

4. **Iteraciones:**
   - Repite todo el proceso para un número de iteraciones igual al tamaño del array.

5. **Array Ordenado:**
   - El array está ordenado cuando no se realizan más intercambios en una iteración completa.

    ```code
    procedure bubbleSort(array)
        n = length(array)
        do
            swapped = false
            for i from 1 to n-1
                if array[i-1] > array[i]
                    swap(array[i-1], array[i])
                    swapped = true
            n = n - 1
        while swapped
    ```    

## Ejercicio 3: Notas de examenes

Supongamos que tenemos que implementar un programa que clasifica a los estudiantes según sus calificaciones en un examen.

Las notas son:

- Entre 0-4.99. Suspenso.
- Entre 5-6. Aprobado.
- Entre 6-6.99. Bien.
- Entre 7-8.99. Notable.
- Entre 9-9.99. Sobresaliente.
- Entre 10. Matrícula.

- Implementa la solución realizando dos métodos/programas. El primero utilizando __if/else__ y el segundo utilizando __switch__.

## Ejercicio 4: Crear una Clase Estudiante

Implementa un programa que gestione las __cuentas de un banco__, teniendo en cuenta las siguientes consideraciones:
- La cuenta de ahorro tendrá las siguientes propiedades:
    - String titular;
    - double saldo;

Se pide:
- Implementa todos los constructores posiblems.
- Getters/Setters de las propiedades.
- Los siguientes métodos:
    - __Depositar__ un cantidad de dinero.
    - __Retirar__ una cantidad de dinero.
    - __informacion__ sobre el titular y la cantidad de dinero que tiene en ese momento en la cuenta.

