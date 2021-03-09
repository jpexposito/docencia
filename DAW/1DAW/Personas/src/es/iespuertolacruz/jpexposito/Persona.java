
package es.iespuertolacruz.jpexposito;

import java.util.Random;

/**
 *
 * @author jpexposito
 */
public class Persona {
    
   String nombre;
   int edad;
   String dni;
   char sexo;
   float peso;
   float altura;

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.sexo = ' ';
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.dni = "";
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, String dni,
            char sexo, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getDni() {
        return dni;
    }
    
    /**
     * Funcion que calcula el indice de masa corporal de la persona
     * @return (-1/0/1) en funcion del indice corporal
     */
    public int calcularIMC(){
        float imc = 0;
        
        imc = this.peso/(this.altura*this.altura);

        if (imc < 20) {
            return -1;
        } else if ((imc >= 20) && (imc <= 25)){
           return 0;
        } else {
            return 1;
        }
        
    }
    
    /**
     * Funcion que verifica si la persona es mayor de edad
     * @return false en caso de que no sea mayor edad, y true en caso contrario.
     */
    public boolean esMayorDeEdad() {
        boolean mayorEdad = false;
          
        if (this.edad >= 18) {
            mayorEdad = true;
        }
        return mayorEdad;
    }
    
    /**
     * Funcion que comprueba el sexo de la persona
     * @param sexo
     * @return 
     */
    private char comprobarSexo(char sexo) {
        char genero = 'H';
        /**    
        if (sexo == 'M' || sexo == 'm'
                || sexo == 'H' || sexo == 'h') {
            genero = sexo;
        } 
        
        return genero;
        **/
        
        /**
         if (sexo != 'M' || sexo != 'm'
                || sexo != 'H' || sexo != 'h') {
            
        } else {
            genero = sexo;
        }
        return genero;
         */
        
        if (sexo != 'M' || sexo != 'm'
                || sexo != 'H' || sexo != 'h') {
            return genero;
        } else {
            return sexo;
        }    
        
    }
    
    public String toString() {
        String persona = "Persona:";
               
        persona = persona + "nombre->" +this.nombre;
        persona = persona + ",edad->" +this.edad;
        persona = persona + ",dni->" +this.dni;        
        persona = persona + ",sexo->" +comprobarSexo(this.sexo);
        persona = persona + ",peso->" +this.peso;
        persona = persona + "altura->" +this.altura;

        return persona;
    }
    
    /**
     * Funcion encargada de realizar el calculo del dni de la persona
     * @return Un dni y letra generado de forma aleatoria
     */
    
    public String generaDNI() {
        String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKE";
        Random random = new Random();
        
        int dni = random.nextInt(90000000)+100000000; 
        int modulo= dni % 23;
        char letra = juegoCaracteres.charAt(modulo);

        return Integer.toString(dni) + letra;

    }
    
   
   
    
}
