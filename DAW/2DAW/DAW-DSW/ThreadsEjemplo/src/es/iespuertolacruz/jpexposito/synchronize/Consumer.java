
package es.iespuertolacruz.jpexposito.synchronize;

/**
 *
 * @author jpexposito
 */
public class Consumer extends Thread {
    private CubbyHole cubbyhole;
    private int number;

    Consumer(CubbyHole c, int i) {
        cubbyhole = c;
        this.number = number;
    }
 
    
    public void run() {
        int value = 0;
        
        for (int i = 0; i < 10; i++) {
            value = cubbyhole.get();
            System.out.println("Consumer #" + this.number
            + " got: " + value);
            }
        }
}
