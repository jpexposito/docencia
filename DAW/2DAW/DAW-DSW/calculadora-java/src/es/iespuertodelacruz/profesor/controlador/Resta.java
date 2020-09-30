package es.iespuertodelacruz.profesor.controlador;

public class Resta extends Operacion{
    
    Double resta;

    /**
     * Contructucto .....
     * @param n1
     * @param n2
     */
    public Resta(double n1, double n2) {
        super(n1, n2, n1 - n2,'-');
    }
}
