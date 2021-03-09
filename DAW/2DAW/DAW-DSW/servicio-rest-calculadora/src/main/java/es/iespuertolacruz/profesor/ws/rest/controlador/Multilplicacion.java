package es.iespuertolacruz.profesor.ws.rest.controlador;

public class Multilplicacion extends Operacion{
    
    Double multiplicacion;
    
    public Multilplicacion(double n1, double n2) {
        super(n1, n2, n1*n2,'*');
    }
}
