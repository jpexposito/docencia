<div align="justify">

# Ejercicios de Herencia (Interfaces)

Teniendo como referencia: la documentación, los ejemplos realizados en clase, y los que se encuentran en el siguiente [enlace](../../Ejemplos/).

Realiza:

- Crea una interfaz llamada __IReproductor__ que contenga dos métodos: _reproducir() y detener()_. Luego, implementa la interfaz en una clase __ReproductorMP3__ que proporciona una implementación concreta para ambos métodos. _(Reproduciendo mp3 y Deteniendo mp3 respectivamente)_.
    
    __Nota__:
    - Crea la __interfaz__ en el paquete __ies.puerto.interfaz__ y la implementación en el paquete __ies.puerto.impl__.
    - Realiza el ejercicio creando una clase __abstracta__, en el paquete __ies.puerto.abstractas__ y realizando la implemetación de los __métodos abstractos__ en una clase declarada en el paquete __ies.puerto.implementation__.  
    - Crea un programa que demuestre el comportamiento correcto del programa AppReproductor, o __test unitarios__ que sistituyen a este.
- Define una interfaz __IFormaGeometrica__ que contenga un método abstracto llamado _calcularArea_(). Implementa esta interfaz en dos clases: __Circulo y Rectangulo__. Proporciona implementaciones concretas para calcular el área en ambas clases.
    
    __Nota__:
    - Crea la __interfaz__ en el paquete __ies.puerto.interfaz__ y la implementación en el paquete __ies.puerto.impl__.
    - Realiza el ejercicio creando una clase __abstracta__, en el paquete __ies.puerto.abstractas__ _(Los métodos abstractos_ ___NO___ _comienzan por_ ___I___ _)_ y realizando la implemetación de los __métodos abstractos__ en una clase declarada en el paquete __ies.puerto.implementation__.  
    - Crea un programa que demuestre el comportamiento correcto del programa AppReproductor, o __test unitarios__ que sistituyen a este.
- Crea una interfaz __IConductor__ con dos métodos: _arrancar() y detener()_. Implementa la interfaz en una clase __Automovil__ que proporciona una implementación concreta para ambos métodos. Además, agrega un método adicional __conducir()__ que sea específico de la clase Automovil.
    
    __Nota__:
    - Crea la __interfaz__ en el paquete __ies.puerto.interfaz__ y la implementación en el paquete __ies.puerto.impl__.
    - Realiza el ejercicio creando una clase __abstracta__, en el paquete __ies.puerto.abstractas__ _(Los métodos abstractos_ ___NO___ _comienzan por_ ___I___ _)_ y realizando la implemetación de los __métodos abstractos__ en una clase declarada en el paquete __ies.puerto.implementation__.  
    - Crea un programa que demuestre el comportamiento correcto del programa AppReproductor, o __test unitarios__ que sistituyen a este.
- Define una interfaz __IConexionRed__ que declare un método __conectar()__. Implementa esta interfaz en dos clases: __ConexionEthernet y ConexionWifi__. Proporciona implementaciones concretas para conectar en ambas clases. _(Conectando vía Ethernet y Conectando vía Wifi) respectivamente_.
    
    __Nota__:
    - Crea la __interfaz__ en el paquete __ies.puerto.interfaz__ y la implementación en el paquete __ies.puerto.impl__.
    - Realiza el ejercicio creando una clase __abstracta__, en el paquete __ies.puerto.abstractas__ _(Los métodos abstractos_ ___NO___ _comienzan por_ ___I___ _)_ y realizando la implemetación de los __métodos abstractos__ en una clase declarada en el paquete __ies.puerto.implementation__.  
    - Crea un programa que demuestre el comportamiento correcto del programa AppReproductor, o __test unitarios__ que sistituyen a este.
- Crea una interfaz __IInstrumentoMusical__ con dos métodos: __tocarNota(String nota) y afinar()__. Luego, implementa la interfaz en una clase __Guitarra__ que proporciona implementaciones concretas para ambos métodos _(Tocar nota de guitarra y afinada la guitarra respectivamente)_. Además, agrega un método adicional __cambiarCuerdas()__ que sea específico de la clase Guitarra.
    
    __Nota__:
    - Crea la __interfaz__ en el paquete __ies.puerto.interfaz__ y la implementación en el paquete __ies.puerto.impl__.
    - Realiza el ejercicio creando una clase __abstracta__, en el paquete __ies.puerto.abstractas__ _(Los métodos abstractos_ ___NO___ _comienzan por_ ___I___ _)_ y realizando la implemetación de los __métodos abstractos__ en una clase declarada en el paquete __ies.puerto.implementation__.  
    - Crea un programa que demuestre el comportamiento correcto del programa AppReproductor, o __test unitarios__ que sistituyen a este.
- El siguiente ejercicio tiene como objetivo la comprensión de jerarquías en programación. Para ello debe de implementarse las siguientes estruturas:    
 - Una clase abstracta llamada Persona que contenga los siguientes atributos:
  - nombre (String)
  - fechaNacimiento(String)
  - Define el método __anios__, que retorno un __int__ que calcule la edad a partir de la fecha de nacimiento.
 - Define una interfaz llamada Trabajador que tenga un método abstracto llamado trabajar(), que retorne un String.
 - Crea una clase abstracta llamada Empleado que implemente la interfaz Trabajador, que extienda de Persona y contenga un atributo adicional:
  - salario (float).
  - trabajo.
 - Agrega métodos abstractos para calcular el salario () y mostrar información específica del empleado (toString()).    
 - Crea una clase llamada Profesor que herede de Persona y de la clase abstracta Empleado. La clase Profesor debe tener un atributo adicional:
  - especialidad(String) 
 - Implementa los métodos abstractos de la clase Empleado y agrega un método específico para los profesores, por ejemplo, impartirClase().
 - Crea una clase llamada Alumno que herede de Persona. La clase Alumno debe tener un atributo adicional:
  - nivel(String)
 - Agrega métodos específicos para los alumnos, por ejemplo, estudiar().
    
    __Nota__:
    - Crea la __interfaz__ en el paquete __ies.puerto.interfaz__ y la implementación en el paquete __ies.puerto.impl__.
    - Realiza el ejercicio creando una clase __abstracta__, en el paquete __ies.puerto.abstractas__ _(Los métodos abstractos_ ___NO___ _comienzan por_ ___I___ _)_ y realizando la implemetación de los __métodos abstractos__ en una clase declarada en el paquete __ies.puerto.implementation__.
    - ___CREA LAS CLASES CON LOS NOMBRES ADECUADOS EN FUNCIÓN DEL TIPO DE CLASE QUE SEA Y EL PAQUETE DONDE ESTE___.  
    - Crea un programa que demuestre el comportamiento correcto del programa AppReproductor, o __test unitarios__ que sistituyen a este.

</div>