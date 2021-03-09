package es.iespuertolacruz.jpexposito.thread;

/**
 *
 * @author jpexposito
 */
public class ThreadsReloj {
    
    public static void main(String[] args){
        new Reloj("RelojOn",10).start();
        new Reloj("RelojOff",15).start();
}
    
}
