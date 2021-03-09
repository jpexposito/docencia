package es.iespuertolacruz.rest.jpexposito.servicios;

import es.iespuertolacruz.rest.jpexposito.dao.UsuariosDao;
import es.iespuertolacruz.rest.jpexposito.dao.entity.Pelicula;
import es.iespuertolacruz.rest.jpexposito.dao.entity.Usuario;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;

import static es.iespuertolacruz.rest.jpexposito.utils.RestServiceUtils.*;

@Path("/usuarios")
public class Usuarios {

    private final ObjectMapper mapper = new ObjectMapper();

    @GET
    @Path("/info")
    public Response getInfo() {
        String output = ESTADO_SERVICIO + getClass().getSimpleName() + OK;
        return Response.status(200).entity(output).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insert(String json) {
        Usuario usuario = null;
        try {
            JSONObject jsonValue = new JSONObject(json);
            usuario = mapper.readValue(jsonValue.toString(), Usuario.class);
        } catch (IOException | JSONException e) {
            return Response.status(400).entity(ERROR).build();
        }
        if (UsuariosDao.find(usuario.getDni()) != null) {
            return Response.status(400).entity(ELEMENTO_EXISTE).build();
        }
        UsuariosDao.insert(usuario);
        return Response.status(200).entity(OK).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Usuario> getUsuarios() {
        return UsuariosDao.find(null);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteUsuarios(String dni) {
        if (UsuariosDao.find(dni) != null) {
            UsuariosDao.delete(dni);
            return Response.status(200).entity(OK).build();
        }

        return Response.status(404).entity(ELEMENTO_EXISTE).build();

    }

}
