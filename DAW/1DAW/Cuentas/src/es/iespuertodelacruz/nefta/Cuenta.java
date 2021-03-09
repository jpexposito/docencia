package es.iespuertodelacruz.nefta;

/**
 *
 * @author Nefta
 */
public class Cuenta {
    //Declaracion de variables
    String titular;
    double cantidad;

    
    //Constructores
    
    public Cuenta() {
    }

    public Cuenta(String titular) {
        titular = "";
        this.titular = titular;
    }

    public Cuenta(String titular, double cantidad) {
        cantidad = 0D;
        this.titular = titular;
        this.cantidad = cantidad;
    }
    
    //Getters y Setters
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Funcion que permite ingresar dinero en la cuenta
     * @param cantidad
    */
    public void Ingresar (double cantidad){
        if(cantidad >0){
            this.cantidad = this.cantidad + cantidad;
        }
    }
    /**
     * Funcion que permite retirar dinero de la cuenta
     * @param cantidad
     */
    public void Retirar (double cantidad){
        if((cantidad > 0) && (cantidad > this.cantidad)){
        this.cantidad = 0D;
    }else{
            this.cantidad = this.cantidad - cantidad;
        }
    }
    /**
     * Funcion que recoge los datos 
     * @return titular y cantidad
     */
    @Override
    public String toString() {
        return titular+" "+this.cantidad+" euros";
    }
    
    
    
}