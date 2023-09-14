package es.iespuertolacruz.jpexposito;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DescargasApp {

    public void descargarArchivo(
            String url_descargar,
            String nombreArchivo){
        System.out.println("Descargando "
                +url_descargar);
        try {
            URL laUrl=new URL(url_descargar);
            InputStream is=laUrl.openStream();
            InputStreamReader reader=
                    new InputStreamReader(is);
            BufferedReader bReader=
                    new BufferedReader(reader);
            FileWriter escritorFichero=
                    new FileWriter(nombreArchivo);
            String linea;
            while ((linea=bReader.readLine())!=null){
                escritorFichero.write(linea);
            }
            escritorFichero.close();
            bReader.close();
            reader.close();
            is.close();
        } catch (MalformedURLException e) {
            System.out.println("URL mal escrita!");
            return ;
        } catch (IOException e) {
            System.out.println(
                    "Fallo en la lectura del fichero");
            return ;
        }
    }
    public static void main (String[] argumentos){
        DescargasApp gd = new DescargasApp();
        String base=
                "http://IP_DEL_SERVIDOR:PUERTO"+
                        "/ServiciosProcesos/textos/";
        for (int i=1; i<=5; i++){
            String url=base+"tema"+i+".rst";
            gd.descargarArchivo(url, "prueba.txt");
        }
    }
}
