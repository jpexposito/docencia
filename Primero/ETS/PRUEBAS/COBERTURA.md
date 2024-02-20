<div align="justify">

# Cobertura de Código

La _cobertura de código_ __(code coverage)__ es una __métrica que indica qué parte del código__ fuente de un programa ha sido ejecutada durante la ejecución de un conjunto de __test__. Es una herramienta que ayuda a medir la eficacia de las pruebas y proporciona información sobre qué porcentaje del código está siendo validado por los tests.

Existen diferentes tipos de cobertura de código, y aquí se presentan algunos de los más comunes:

- __Cobertura de Instrucciones (Line Coverage)__: Mide qué porcentaje de las líneas de código ha sido ejecutado al menos una vez durante las pruebas.

- __Cobertura de Ramas (Branch Coverage)__: Evalúa si todas las ramas de control de flujo en el código han sido atravesadas al menos una vez. Esto incluye la ejecución de ambos caminos en una instrucción condicional (if-else).

- __Cobertura de Condición (Condition Coverage)__: Se centra en evaluar todas las condiciones booleanas en el código y determina si cada una ha sido evaluada tanto como verdadera como falsa.

- __Cobertura de Rutas (Path Coverage)__: Mide si se han recorrido todas las posibles rutas a través del código. Es una métrica más avanzada y compleja.

## Cómo Utilizar la Cobertura de Código

- Ejecución de Pruebas: Se ejecutan las pruebas automatizadas para el código.

- Instrumentación del Código: Durante la ejecución de las pruebas, el código se instrumenta para rastrear qué partes han sido ejecutadas.

- Generación de Informes: Se genera un informe de cobertura que muestra qué porcentaje del código ha sido ejecutado y qué partes no han sido alcanzadas.

- Análisis del Informe: Los equipos de desarrollo pueden utilizar esta información para identificar áreas no probadas o insuficientemente probadas y mejorar sus conjuntos de pruebas.

- Herramientas de Cobertura de Código en Java:
  - JaCoCo: Java Code Coverage Tool es una herramienta de código abierto que proporciona informes de cobertura para aplicaciones Java.
  - Cobertura: Otra herramienta popular para medir la cobertura de código en aplicaciones Java.

## Ejemplo de Informe de Cobertura:

```plaintext
Clases: 80% (20/25)
Métodos: 90% (45/50)
Líneas: 85% (850/1000)
Ramas: 75% (30/40)
Condiciones: 80% (80/100)
```

>__Nota__:Este informe muestra la cobertura de instrucciones, métodos, líneas, ramas y condiciones. Cada porcentaje indica el grado de cobertura alcanzado en cada área específica del código.

Es importante destacar que aunque una alta cobertura de código es deseable, no garantiza la ausencia de errores. Es posible tener un código con alta cobertura y aún así tener defectos. Por lo tanto, la cobertura de código debe ser utilizada como una herramienta complementaria en conjunto con otras prácticas de prueba y revisión de código.

</div>