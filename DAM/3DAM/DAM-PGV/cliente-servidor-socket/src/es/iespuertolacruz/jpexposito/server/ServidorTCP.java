package es.iespuertolacruz.jpexposito.server;

import static es.iespuertolacruz.jpexposito.utils.SocketUtils.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServidorTCP {
   
    public static void main(String args[]) throws IOException {
        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;
        ServerSocket serverSocket;
        String accion = "";
        System.out.print("Inicializando servidor... ");
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("\t Servidor arrancado correctamente -> Estado [OK]");
            int idSession = 0;
            while (true) {
                Socket socket;
                socket = serverSocket.accept();
                outputStream = new DataOutputStream(socket.getOutputStream());
                inputStream = new DataInputStream(socket.getInputStream());
                System.out.println("Nueva conexion entrante: "+socket);
                accion = inputStream.readUTF();
                if(accion.equals("hola")){
                    outputStream.writeUTF("adios");
                }
       
                idSession++;
            }
        } catch (IOException ex) {
            Logger.getLogger("Se ha producido un error realoizando la conexion con el servidor:"+ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
   
}
