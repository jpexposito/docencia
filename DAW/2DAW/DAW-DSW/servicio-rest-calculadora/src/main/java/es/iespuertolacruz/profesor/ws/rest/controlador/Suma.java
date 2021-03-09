package es.iespuertolacruz.profesor.ws.rest.controlador;

public class Suma  extends Operacion{

    double suma;

    public Suma(double n1, double n2) {
        super(n1, n2, n1 + n2, '+');
    }
}
