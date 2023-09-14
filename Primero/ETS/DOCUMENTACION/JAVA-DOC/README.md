<div align="justify">

# Documentación Específica (Javadocs)

</br>

<div align="center">
  <img src="https://www3.gobiernodecanarias.org/medusa/mediateca/ecoescuela/wp-content/uploads/sites/2/2013/11/11-Libro.png" width="150px" />
</div>

</br>


## Introducción

  Lo ideal es que la documentación específica de cada proyecto esta disponible mediante Javadocs, donde cada proyecto debe de hacer lo mejor para estar bien documentado con el formato para generar Javadocs y así se pueda generar y hostear los Javadocs en su propia página de Github Pages.

### Instrucciones para agregar documentación

  A continuación un paso a paso de como generar Javadocs y hostear en Github Pages:

  1- Comentar el código de su proyecto en el formato usado para generar Javadocs y de forma completa:

  | Etiqueta |	Descripción |
  |-------------------|-------------|
  | @author	| Indica el nombre de quien desarrollo el componente.
  | @deprecated	| Indica que algún método o clase u otro componente está obsoleto.
  | @param	| Indica un parámetro de un método, se tiene que usar para todos los parámetros del método.
  | @return	| Indica el valor de retorno de un método
  | @see	| Indica que el componente puede hacer referencia a otro. Ejemplo: #método(); clase#método();
  | @throw	| Indica que excepción lanza el método.
  | @version | 	Indica la versión actual del componente.

      [Javadocs Cheatsheet] (https://binfalse.de/2015/10/05/javadoc-cheats-sheet/

  2- Una vez se quiera levantar cambios al repositorio "master" se deben generar/regenerar los Javadocs del proyecto (No se olvide de seleccionar la codificación correcta a la hora de generar! Si el proyecto esta en castellano los acentos o la “ñ” no se desplegaran bien con la codificación por defecto) y subir lo generado al directorio /docs (Reemplazando los archivos antiguos de existir).

      `Javadocs Generator <https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javadoc.html>`_

  3- Si su proyecto tiene habilitada su propia página de GitHub Pages se actualizará todo automáticamente al subir cambios a /docs del "master", pero si no tiene la página habilitada haga lo siguiente:
  Una vez tenga creado el directorio /docs (Sino no le dejara elegir la opción!) en la raíz del proyecto con lo generado por Javadocs entrar a la página de GitHub del proyecto y de la página principal ir a “Settings” y en la sección de “GitHub Pages” de esta página debe seleccionar la opción “master branch /docs folder” en el campo "Source", tras un momento el link de su página será mostrado en esta sección una vez rellene el campo.

## Ejemplo de uso

```java
package es.system.jpexposito;

/**
 * Una clase para representar circulos situados sobre el plano.
 * Cada circulo queda determinado por su radio junto con las
 * coordenadas de su  centro.
 * @version 1.2, 24/12/20
 * @author Joatham Perez Exposito
 */

public class Circulo {
    protected double x,y; // coordenadas del centro
    protected double r;  // radio del circulo

    /**
     * Crea un circulo a partir de su origen su radio.
     * @param x La coordenada x del centro del circulo.
     * @param y La coordenada y del centro del circulo.
     * @param r El radio del circulo. Debe ser mayor o igual a 0.
     */
    public Circulo(double x, double y, double r) {
        this.x=x; this.y = y; this.r = r;
    }   

    /**
     * Calculo del area de este circulo.
     * @return El area (mayor o igual que 0) del circulo.
     */
     public double area() {
        return Math.PI*r*r;
     }

     /**
      * Indica si un punto esta dentro del circulo.
      * @param px componente x del punto
      * @param py componente y del punto
      * @return true si el punto esta dentro del circulo o false en otro caso.
      */
     public boolean contiene(double px, double py) {
        /* Calculamos la distancia de (px,py) al centro del circulo (x,y),
           que se obtiene como raíz cuadrada de (px-x)^2+(py-y)^2 */
        double d = Math.sqrt((px-x)*(px-x)+(py-y)*(py-y));

        // el circulo contiene el punto si d es menor o igual al radio
        return  d <= r;
     }
}
```

o el siguiente

```java
package es.system.jpexposito;
/**
 * Esta clase contiene los atributos y metodos de un empleado
 * @author Joatham Perez Exposito
 * @version 1.0
 * @see Persona
 */
public class Empleado extends Persona{

    private int numeroEmpleado;
    private String departamento;
    private String puesto;

    /**
     * Metodo constructor por defecto
     */
    public Empleado(){
    }

    /**
     * Metodo constructor parametrizado
     * @param nombre Nombre del empleado
     * @param edad Edad del empleado
     * @param sexo Sexo del empleado en formato H o M
     * @param numeroEmpleado Numero de empleado
     * @param departamento Departamento donde trabajara el empleado
     * @param puesto Puesto que ocupara el empleado dentro de la empresa
     */
    public Empleado(String nombre,
                    int edad,
                    char sexo,
                    int numeroEmpleado,
                    String departamento,
                    String puesto){
        super(nombre, edad, sexo);
        this.numeroEmpleado = numeroEmpleado;
        this.departamento = departamento;
        this.puesto = puesto;
    }

    /**
     * Metodo para regresar el numero de empelado
     * @return Regresa el numero del empleado
     */
    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    /**
     * Establece el numero del empleado
     * @param numeroEmpleado Numero que se le asignara al empleado
     */
    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    /**
     * Metodo que regresa el nombre del departamento asignado al empleado
     * @return Regresa el departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Metodo que le asigna departamento a un empelado
     * @param departamento Nombre de departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Metodo que regresa el puesto del empleado
     * @return Regresa un String que indica el puesto
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Metodo que establece el puesto del empleado
     * @param puesto Indica el puesto del empleado
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
```

</div>
