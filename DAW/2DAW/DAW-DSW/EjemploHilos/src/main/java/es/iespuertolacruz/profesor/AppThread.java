package es.iespuertolacruz.profesor;

public class AppThread {

    public static void main(String[] args) {
        Hilo hilo1=new Hilo("Subproceso 1");
        Hilo hilo2=new Hilo("Supproceso 2");
        hilo1.start();
        hilo2.start();
    }
}
