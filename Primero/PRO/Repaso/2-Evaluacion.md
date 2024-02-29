<div align="justify">

# Ejercicios de Repaso Java (II)

## Ejercicio de Listas

1. Implementa un programa en Java que solicite al usuario ingresar nombres de estudiantes y los almacene en una lista. Luego, el programa debe imprimir la lista de nombres ordenada alfabéticamente.
2. Pide al usuario que ingrese un nombre y verifica si ese nombre está en la lista. Imprime un mensaje indicando si el nombre está o no presente.
3. Inserta un nombre duplicado, y elimina los nombres duplicados antes de imprimir la lista.
4. Mejora el programa para que, después de imprimir la lista de nombres ordenada alfabéticamente, solicite al usuario ingresar un nuevo nombre para agregar a la lista. Asegúrate de que la lista siga ordenada alfabéticamente después de agregar el nuevo nombre y luego muestra la lista actualizada.
5. Modifica el programa para que, después de imprimir la lista de nombres ordenada alfabéticamente, solicite al usuario ingresar una letra. Luego, muestra todos los nombres de la lista que comiencen con esa letra.

## Ejercicio de Mapas

1. Crea un programa en Java que simule un diccionario simple. El programa debe permitir al usuario ingresar palabras y sus definiciones, y almacenarlas en un mapa. Luego, el usuario debería poder buscar palabras y ver sus definiciones
2. Modifica el programa para permitir que el usuario actualice las definiciones existentes. Después de mostrar la definición de una palabra, pregunta al usuario si desea actualizar la definición. Si sí, permite al usuario ingresar la nueva definición y actualiza la definición en el diccionario
3. Agrega la funcionalidad para que el usuario pueda eliminar palabras del diccionario. Después de buscar una palabra y mostrar su definición, pregunta al usuario si desea eliminar la palabra. Si sí, elimina la palabra y su definición del diccionario.
4. Permite al usuario buscar definiciones incluso si no conoce la palabra completa. Implementa una función de búsqueda que busque palabras que contengan la cadena ingresada por el usuario. Muestra todas las palabras que coincidan con la búsqueda y permite al usuario seleccionar una para ver su definición
5. Agrega la capacidad de exportar el diccionario a un archivo y de importar un diccionario desde un archivo. Permite al usuario guardar el diccionario actual en un archivo de texto y cargar un diccionario desde un archivo existente. Esto permite al usuario mantener su diccionario incluso después de cerrar el programa.

## Ejercicio de Conjuntos

1. Desarrolla un programa en Java que solicite al usuario ingresar una serie de números enteros. El programa debe almacenar estos números en un conjunto y luego imprimir los números únicos ingresados por el usuario
2. Modifica el programa para que, además de imprimir los números únicos ingresados por el usuario, también imprima los números duplicados. Esto ayudará al usuario a identificar los números que ingresó más de una vez
3. Extiende el programa para calcular la suma de los números únicos ingresados por el usuario y luego imprime el resultado. Esto proporcionará al usuario una idea de la suma total de los valores únicos que ha ingresado.
4. Mejora el programa para que permita al usuario buscar un número específico dentro del conjunto ingresado. Después de imprimir los números únicos, solicita al usuario que ingrese un número y verifica si está presente en el conjunto. Luego, imprime un mensaje indicando si el número está presente o no.
5. Agrega funcionalidades matemáticas al programa, como encontrar el número más grande, el número más pequeño y el promedio de los números únicos ingresados por el usuario. Después de imprimir los números únicos, calcula y muestra estos resultados adicionales.

## Ejercicio de Clases y Objetos

1. Define una clase Persona con atributos como nombre, edad y ciudad. Luego, implementa un programa en Java que permita al usuario crear instancias de esta clase, ingresar los datos de las personas y almacenarlas en una lista. Posteriormente, el programa debe imprimir la lista de personas.
2. Modifica el programa para que permita al usuario ordenar la lista de personas por edad. Después de imprimir la lista de personas, pregunta al usuario si desea ordenar la lista por edad de forma ascendente o descendente, y luego muestra la lista ordenada en consecuencia.
3. Mejora el programa para que permita al usuario filtrar la lista de personas por ciudad. Después de imprimir la lista de personas, pregunta al usuario qué ciudad desea filtrar y muestra solo las personas que viven en esa ciudad.
4. Agrega la capacidad para que el usuario actualice los datos de una persona específica en la lista. Después de imprimir la lista de personas, pregunta al usuario si desea actualizar los datos de alguna persona. Si lo hace, permite al usuario seleccionar una persona de la lista y luego ingresar los nuevos datos (nombre, edad, ciudad).
5. Agrega la funcionalidad para que el usuario pueda eliminar personas de la lista. Después de imprimir la lista de personas, pregunta al usuario si desea eliminar alguna persona de la lista. Si lo hace, permite al usuario seleccionar una persona de la lista y elimina esa persona de la lista.
6. Extiende el programa para que calcule y muestre estadísticas sobre las edades de las personas en la lista. Después de imprimir la lista de personas, muestra la edad promedio, la edad mínima y la edad máxima de las personas en la lista.

## Ejercicio de Herencia

1. Crea una clase Vehiculo con atributos como marca, modelo y año. Luego, define subclases como Coche, Camioneta y Motocicleta que hereden de la clase Vehiculo y agreguen atributos específicos para cada tipo de vehículo. Implementa un programa en Java que permita al usuario ingresar información sobre diferentes vehículos y almacenarlos en una lista, luego imprime la lista de vehículos.
2. Extiende el programa para que permita al usuario ordenar la lista de personas por edad. Después de imprimir la lista de personas, pregunta al usuario si desea ordenar la lista por edad. Si lo hace, ordena la lista según la edad de las personas y luego imprime la lista ordenada.
3. Agrega la capacidad de buscar personas por ciudad. Después de imprimir la lista de personas, solicita al usuario que ingrese una ciudad y luego muestra todas las personas que viven en esa ciudad.
4. Mejora el programa para permitir que el usuario actualice los datos de una persona específica en la lista. Después de imprimir la lista de personas, pregunta al usuario si desea actualizar los datos de alguna persona. Si lo hace, solicita al usuario que ingrese el nombre de la persona cuyos datos desea actualizar, y luego permite al usuario actualizar la edad y/o la ciudad de esa persona.
5. Agrega la funcionalidad para que el usuario pueda eliminar personas de la lista. Después de imprimir la lista de personas, pregunta al usuario si desea eliminar a alguna persona de la lista. Si lo hace, solicita al usuario que ingrese el nombre de la persona que desea eliminar y elimina esa persona de la lista.

## Ejercicio de Interfaces

1. Define una interfaz FiguraGeometrica con métodos para calcular el área y el perímetro. Luego, implementa clases como Circulo, Cuadrado y Triangulo que implementen esta interfaz y proporcionen la implementación de los métodos. Crea un programa en Java que permita al usuario ingresar dimensiones de diferentes figuras geométricas, almacenarlas en una lista y luego imprimir el área y el perímetro de cada figura.
2. Extiende el programa para que también permita al usuario ingresar dimensiones de otras figuras geométricas, como rectángulos, trapecios o polígonos regulares. Implementa las clases correspondientes y asegúrate de que cumplan con la interfaz __FiguraGeometrica__. Luego, permite al usuario ingresar dimensiones de estas nuevas figuras y calcular su área y perímetro.
3. Mejora el programa para que valide las dimensiones ingresadas por el usuario antes de calcular el área y el perímetro de la figura. Por ejemplo, asegúrate de que los valores ingresados para el radio de un círculo sean positivos y que los lados de un triángulo o cuadrado formen un polígono válido.
4. Después de imprimir el área y el perímetro de cada figura, clasifica cada figura en el tipo de figura geométrica correspondiente (círculo, cuadrado, triángulo, etc.). Esto se puede hacer verificando qué tipo de objeto se almacena en la lista en función de su implementación de la interfaz __FiguraGeometrica__.
5. Agrega funcionalidades matemáticas al programa, como calcular el área total y el perímetro total de todas las figuras ingresadas por el usuario. Después de imprimir los datos de cada figura, calcula y muestra estos resultados adicionales.

## Ejercicio Combinado

1. Desarrolla un programa en Java que simule un sistema de gestión de empleados. Define una clase Empleado con atributos como nombre, apellido, salario y cargo. Luego, crea un programa que permita al usuario agregar nuevos empleados, modificar salarios, buscar empleados por nombre, etc. Utiliza colecciones como lista o mapa para almacenar los empleados.
2. Modifica el programa para que permita al usuario clasificar a los empleados por su cargo. Después de agregar nuevos empleados, pide al usuario que seleccione un cargo y muestra todos los empleados que tienen ese cargo.
3. Agrega la funcionalidad para que el usuario pueda aplicar un aumento de salario a todos los empleados que tengan un cargo específico. Después de mostrar la lista de empleados por cargo, pregunta al usuario cuánto desea aumentar el salario y aplica el aumento solo a los empleados de ese cargo.
4. Mejora el programa para que permita al usuario buscar empleados cuyos salarios estén dentro de un rango específico. Después de agregar nuevos empleados, pregunta al usuario que ingrese un rango salarial (por ejemplo, de salario mínimo a salario máximo) y muestra todos los empleados cuyos salarios estén dentro de ese rango.
5. Extiende el programa para que permita al usuario ordenar la lista de empleados por salario. Después de agregar nuevos empleados, pregunta al usuario si desea ordenar la lista por salario de forma ascendente o descendente y muestra la lista ordenada en consecuencia.
6. Agrega la capacidad de que el usuario elimine empleados que estén inactivos. Después de mostrar la lista de empleados, pregunta al usuario si desea eliminar empleados que estén inactivos (por ejemplo, aquellos cuyo salario sea cero o menor). Si el usuario lo desea, elimina esos empleados de la lista.

</div>