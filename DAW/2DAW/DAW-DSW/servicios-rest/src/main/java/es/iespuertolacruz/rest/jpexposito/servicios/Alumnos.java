package es.iespuertolacruz.rest.jpexposito.servicios;

import es.iespuertolacruz.rest.jpexposito.exception.ExisteException;
import es.iespuertolacruz.rest.jpexposito.modelo.Alumno;
import es.iespuertolacruz.rest.jpexposito.modelo.dao.AlumnosDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import java.util.ArrayList;


@Path("/alumnos")
public class Alumnos {

    @GET
    @Path("/info")
    public Response getInfo() {
        String output = "Servicio Alumnos OK ";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/xml/{dni}")
    @Produces({MediaType.APPLICATION_XML})
    public Alumno getXml(@PathParam("dni") String dni) {
       return AlumnosDAO.find(dni);
    }

    @GET
    @Path("/json/{dni}")
    @Produces({MediaType.APPLICATION_JSON})
    public Alumno getJson(@PathParam("dni") String dni) {
        return AlumnosDAO.find(dni);
    }

    @POST
    @Path("/json/{alumno}")
    //@Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Alumno addAlumno() throws ExisteException {
       // return AlumnosDAO.insert(generarAlumno());
        throw new ExisteException();
    }


    @GET
    @Path("/text/{id}")
    @Produces({ MediaType.TEXT_PLAIN })
    public String getHTML(@PathParam("dni") String dni) {
        Alumno alumno = AlumnosDAO.find(dni);
        if (alumno != null) {
            return alumno.toString();
        } else {
            return null;
        }
    }



}
