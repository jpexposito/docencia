package es.iespuertolacruz.jpexposito;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Conector {

    public static void main(String[] args) {
        String destino="www.google.com";
        int puertoDestino=80;
        Socket socket=new Socket();
        InetSocketAddress direccion=new InetSocketAddress(
                destino, puertoDestino);
        try {
            socket.connect(direccion);
            //Si llegamos aquí es que la conexión
            //sí se hizo.

            InputStream is=socket.getInputStream();
            OutputStream os=socket.getOutputStream();


        } catch (IOException e) {
            System.out.println(
                    "No se pudo establecer la conexion "+
                            " o hubo un fallo al leer datos."
            );
        }
    }
}
