
package es.iespuertolacruz.jpexposito.thread;

/**
 *
 * @author jpexposito
 */
public class Reloj extends Thread {
    
    int cuenta=0;
    String name; 

    Reloj(String name, int cuenta) {
        this.name = name;
        this.cuenta = cuenta;
    }

    public void run() {
        
        for (int i = 1; i <= cuenta; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
                System.out.println(name + " : " + (cuenta - i));
        }
        System.out.println(name + "Riiinnnng!!!");
     }
    
   

    }
