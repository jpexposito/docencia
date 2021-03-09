package es.iespuertolacruz.rest.jpexposito.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/dividir")
public class Dividir {

    @GET
    @Path("/info")
    public Response getInfo() {
        String output = "Servicio Dividir OK ";
        return Response.status(200).entity(output).build();
    }

    @POST
    @Path("/{valor1}/{valor2}")
    public Response operacion(@PathParam("valor1") Double valor1, @PathParam("valor2") Double valor2) {
        String output = valor1 + " / " +valor2 + " = " +(valor1/valor2) ;
        return Response.status(200).entity(output).build();
    }


}
