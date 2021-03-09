package es.iespuertolacruz.jpexposito.refactor;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ClienteRest extends RestUtils{

    String service;
    Client client;
    WebTarget target;

    public ClienteRest() { }

    /**
     * Constructor del servicio con el nombre del servicio
     * @param service
     */
    public ClienteRest(String service) {
        this.service = service;
        client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();
    }


    /**
     * Funcion que invoca al metodo operacion del servicio correspondiente
     * @param numero1 para la operacion descrita en el servicio
     * @param numero2  para la operacion descrita en el servicio
     * @return String con los dos numeros de la operacion y el resultado de la misma
     */
    public String operation(int numero1, int numero2) {
        target = client.target(HTTP_LOCALHOST_8080).path(PATH_REST +service+"/"+numero1+"/"+numero2);
        String respuesta = target.request().post(null, String.class);
        return respuesta;
    }
}

