
package es.iespuertolacruz.jpexposito.client;

import static es.iespuertolacruz.jpexposito.utils.SocketUtils.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.*;


public class ClienteTCP {

    
     public static void main(String[] args) {
        Socket socket = null;
        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;
        int id = 0;
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
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger("Cerrando el objetos abiertos: " + ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);

            }
            
        }
     }
    
}
