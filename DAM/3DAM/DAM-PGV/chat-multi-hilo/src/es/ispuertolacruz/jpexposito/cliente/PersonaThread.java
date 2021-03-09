package es.ispuertolacruz.jpexposito.cliente;

import static es.iespuertolacruz.utils.SocketUtils.*;
import java.io.*;
import java.net.Socket;
import java.util.logging.*;

public class PersonaThread extends Thread {
    protected Socket socket;
    protected DataOutputStream outputStream;
    protected DataInputStream inputStream;
    private int id;
    
    public PersonaThread(int id) {
        this.id = id;
    }
    
    @Override
    public void run() {
        try {
            socket = new Socket(IP_SERVER, PORT);
            outputStream = new DataOutputStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());
            System.out.println(id + " envía saludo");
            outputStream.writeUTF("hola");
            String respuesta="";
            respuesta = inputStream.readUTF();
            System.out.println(id + " Servidor devuelve saludo: " + respuesta);
            
        } catch (IOException ex) {
            Logger.getLogger(PersonaThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally  {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
                   
            } catch (Exception ex) {
                Logger.getLogger("Cerrando el objetos abiertos: " + PersonaThread.class.getName()).log(Level.SEVERE, null, ex);

            }
            
        }
    }
}
