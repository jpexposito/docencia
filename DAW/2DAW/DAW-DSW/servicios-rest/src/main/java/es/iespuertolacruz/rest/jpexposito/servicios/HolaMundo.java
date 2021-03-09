package es.iespuertolacruz.rest.jpexposito.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;



@Path("/hola-mundo")
public class HolaMundo {

    @GET
    @Path("/{message}")
    public Response getMsg(@PathParam("message") String msg)
    {
        String output = "Message requested : " + msg;
        //Simply return the parameter passed as message
        return Response.status(200).entity(output).build();
    }


}
