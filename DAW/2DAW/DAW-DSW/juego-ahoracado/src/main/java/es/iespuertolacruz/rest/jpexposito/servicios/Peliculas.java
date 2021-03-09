package es.iespuertolacruz.rest.jpexposito.servicios;

import es.iespuertolacruz.rest.jpexposito.dao.PeliculasDao;
import es.iespuertolacruz.rest.jpexposito.dao.entity.Pelicula;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.ArrayList;

import static es.iespuertolacruz.rest.jpexposito.utils.RestServiceUtils.*;

@Path("/peliculas")
public class Peliculas {

    private final ObjectMapper mapper = new ObjectMapper();

    @GET
    @Path("/info")
    public Response getInfo() {
        String output = ESTADO_SERVICIO + getClass().getSimpleName() + OK;
        return Response.status(200).entity(output).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insert(String jsonPelicula) {
        Pelicula pelicula = null;
        try {
            JSONObject jsonValue = new JSONObject(jsonPelicula);
            pelicula = mapper.readValue(jsonValue.toString(), Pelicula.class);
        } catch (IOException | JSONException e) {
            return Response.status(400).entity(ERROR).build();
        }
        if (PeliculasDao.find(pelicula.getTitulo()) != null) {
            return Response.status(400).entity(ELEMENTO_EXISTE).build();
        }
        PeliculasDao.insert(pelicula);
        return Response.status(200).entity(OK).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Pelicula> getPeliculas() {
        return PeliculasDao.find(null);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Response deletePeliculas(String titulo) {
        if (PeliculasDao.find(titulo) != null) {
            PeliculasDao.delete(titulo);
            return Response.status(200).entity(OK).build();
        }

        return Response.status(404).entity(ELEMENTO_EXISTE).build();

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{aleatorio}")
    public Pelicula aleatoriaPelicula(String aleatorio) {
        return PeliculasDao.aleatorio();
    }

}
