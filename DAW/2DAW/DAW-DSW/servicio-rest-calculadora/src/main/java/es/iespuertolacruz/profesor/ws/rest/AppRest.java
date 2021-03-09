package es.iespuertolacruz.profesor.ws.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class AppRest extends ResourceConfig {

    public AppRest() {
        packages("es.iespuertolacruz.profesor.ws.rest");
    }
}
