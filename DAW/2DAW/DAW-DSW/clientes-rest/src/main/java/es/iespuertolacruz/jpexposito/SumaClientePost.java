package es.iespuertolacruz.jpexposito;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class SumaClientePost {

    public static void main(String[] args) {

        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        WebTarget target = client.target("http://localhost:8080").path("/rest/sumar/1/2");
        String response = target.request().post(null, String.class);

        //Entity es nulo porque los parametros van en el path.
        //String.class porque es el tipo de dato que me responde el servicio.

        //Ejemplos de Entity´s en otros casos de uso,
        //.post(Entity.xml(new Cliente("Alvaro", "Gomez"))); Se le pasa un XML a la peticion
        //
        //response.close();
        //
        //Cliente cliente = target.queryParam("nombre", "Alvaro Gomez")
        //                        .request()
        //                        .get(Cliente.class);
        // Se le pasa un parametro llamado nombre con valor Alvaro Gomez, y
        // y retorna un objeto de tipo Cliente

        System.out.println("Respuesta :"+response);

    }
}

