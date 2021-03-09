package es.iespuertolacruz.jpexposito.synchronize;

/**
 *
 * @author jpexposito
 */
public class CubbyHole {
    
    private int contents; 
    private boolean available = false; // this is the condition variable.
 
    public synchronized int get() {
   
        while (available == false) {
        try {
            wait();
        } catch (InterruptedException e) { }
        }
        
        available = false;
        notifyAll();
    
        return contents;
    }
    
    public synchronized void put(int value) {
        
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {}
            }
            contents = value;
            available = true;
            notifyAll();
        }
    
}
