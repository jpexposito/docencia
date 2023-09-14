
package es.ispuertolacruz.jpexposito.server;

import static es.iespuertolacruz.utils.SocketUtils.PORT;
import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 * 
 * @author jpexposito
 */

public class Servidor {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket;
        System.out.print("Inicializando servidor... ");
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("\t Servidor arrancado correctamente -> Estado [OK]");
            int idSession = 0;
            while (true) {
                Socket socket;
                socket = serverSocket.accept();
                System.out.println("Nueva conexion entrante: "+socket);
                ((ServidorThread) new ServidorThread(socket, idSession)).start();
                idSession++;
            }
        } catch (IOException ex) {
            Logger.getLogger("Se ha producido un error realoizando la conexion con el servidor:"+Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
