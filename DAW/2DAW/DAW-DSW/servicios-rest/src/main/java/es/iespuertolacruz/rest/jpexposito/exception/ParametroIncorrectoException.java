package es.iespuertolacruz.rest.jpexposito.exception;

public class ParametroIncorrectoException extends Exception{

    public ParametroIncorrectoException(String parametro) {
        super("El parametro introducido no es correcto " +parametro);
    }

}
