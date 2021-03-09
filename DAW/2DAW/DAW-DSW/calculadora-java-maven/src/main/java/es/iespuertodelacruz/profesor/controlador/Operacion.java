package es.iespuertodelacruz.profesor.controlador;

import es.iespuertodelacruz.profesor.model.ConecionInicioBBDD;
import es.iespuertodelacruz.profesor.model.OperacionBBDD;

public class Operacion {

    double n1;
    double n2;
    double resultado;
    char operacion;


    public Operacion(double n1, double n2, char operacion) {

        this.n1 = n1;
        this.n2 = n2;
        this.operacion = operacion;
    }

    /**
     * Metodo que muestra el resultado de la operacion
     */
    public void mostrarResultado(){
        System.out.println(this.n1+" "+this.operacion+" "+this.n2+" = "+this.resultado);
    }

    public void almacenarBDD() {
        ConecionInicioBBDD.crearTabla();
        OperacionBBDD.insert(n1,n2,operacion,resultado);
        String palabra = "textp";
        palabra.contains("s");
    }

    /*
     * ************************************* Gettes && Setters de la Calculdora
     */
    
    protected void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
