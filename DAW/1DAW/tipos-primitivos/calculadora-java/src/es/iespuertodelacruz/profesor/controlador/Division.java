package es.iespuertodelacruz.profesor.controlador;

public class Division extends Operacion {

    Double division;
    
    public Division(double n1, double n2) {
        super(n1, n2,  n1/n2,'/');
    }
}
