
package es.iespuertolacruz.jpexposito;

/**
 *
 * @author jpexposito
 */
public class Aclaracion {
    private int atributo1;
    private int atributo2;
    private String atributo3;

    public Aclaracion() {
    }

    public void setAtributo1(int atributo1) {
        this.atributo1 = atributo1;
    }

    public void setAtributo2(int atributo2) {
        this.atributo2 = atributo2;
    }

    public void setAtributo3(String atributo3) {
        this.atributo3 = atributo3;
    }
    
    
    
    public Aclaracion(int atributo1, int atributo2, String atributo3) {
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
        this.atributo3 = atributo3;
    }
    
    public static void main(String[] args){
        Aclaracion aclaracion = new Aclaracion(5, 10, "x");//Creamos un objeto enviando parámetros al constructor

        System.out.println(aclaracion.atributo1 + ", " + aclaracion.atributo2 + ", " +aclaracion.atributo3);//Mostramos el valor de los atributos
        //Imprime '5, 10, x'
        
        Aclaracion usoSeter = new Aclaracion();
        usoSeter.setAtributo1(6);
        usoSeter.setAtributo2(12);
        usoSeter.setAtributo3("y");
        
       System.out.println(usoSeter.atributo1 + ", " + usoSeter.atributo2 + ", " +usoSeter.atributo3);
//Mostramos el valor de los atributos

        
        
    }
    
    
    
}
