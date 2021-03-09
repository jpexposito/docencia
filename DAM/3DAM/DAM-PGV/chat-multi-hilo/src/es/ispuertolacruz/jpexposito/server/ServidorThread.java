package es.ispuertolacruz.jpexposito.server;


import java.io.*;
import java.net.*;
import java.util.logging.*;
public class ServidorThread extends Thread {
    private Socket socket;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;
    private int idSession;
    
    public ServidorThread(Socket socket, int id) {
        this.socket = socket;
        this.idSession = id;
        try {
            outputStream = new DataOutputStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desconnectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        String accion = "";
        try {
            accion = inputStream.readUTF();
            if(accion.equals("hola")){
                System.out.println("El cliente con idSesion "+this.idSession+" saluda");
                outputStream.writeUTF("adios");
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconnectar();
    }
}

