package es.iespuertolacruz.profesor;

public class Hilo extends Thread{

    public Hilo(String nombre) {
        super(nombre);
    }
    public void run(){
        for(int i=1; i<10; i++){
            System.out.println(getName()+": "+i);
            try{
                sleep(100);
            }catch(InterruptedException ex){}
        }
    }
}
