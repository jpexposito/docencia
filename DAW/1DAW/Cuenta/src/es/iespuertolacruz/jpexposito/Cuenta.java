
package es.iespuertolacruz.jpexposito;

/**
 *
 * @author jpexposito
 */
public class Cuenta {
    String titular;
    Double cantidad;

    // -- Contructores
    public Cuenta() {
        this.titular = "";
        this.cantidad = 0D;
    }
    
    public Cuenta(String titular) {
        this.titular = titular;
    }

    public Cuenta(String titular, Double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    // Getters and Setters
    
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * Funcion que obtiene la informacion del objeto
     * @return Titular y cantidad en un preciso instante
     */
    @Override
    public String toString() {
        return "Titular:"+this.titular + ", cantidad:"+this.cantidad;
    }
    
    /**
     * Metodo que permite ingresar una cantidad en una cuenta
     * @param cantidad valor a ingresar en la cuenta
     */
    public void ingresar(double cantidad) {
        if (cantidad > 0){
            this.cantidad = this.cantidad + cantidad;
        }
    }
    
    /**
     * Metodo que permite retirar una cantidad de una cuenta
     * @param cantidad valor a retirar de la cuenta
     */
    public void retirar(double cantidad) {
        
        if ((this.cantidad > 0 ) && (cantidad > this.cantidad)) {
            this.cantidad = 0d;
        } else {
            this.cantidad = this.cantidad - cantidad;
        }
    }
    
}
