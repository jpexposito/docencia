package es.iespuertolacruz.rest.jpexposito.exception;

public class ExisteException extends Exception{

    public ExisteException() {
        super("El alumno existe en el sistema");
    }

}
