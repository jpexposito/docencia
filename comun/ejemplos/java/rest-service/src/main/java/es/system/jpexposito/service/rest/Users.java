package es.system.jpexposito.service.rest;

import es.system.jpexposito.service.model.User;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/users")
public class Users {

    private static List<User> lista = new ArrayList<User>() {{
            add(new User("Rosa", "Marfil"));
            add(new User("Pepito", "Grillo"));
            add(new User("Manuela", "Lago"));
        }
    };

    /**
     * @return Retorna la lista de usuarios
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return Response.ok(lista).build();
    }


    /**
     *
     * @param name String
     * @return Response
     */
    @GET
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("name") String name) {
        User found = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getName().equalsIgnoreCase(name)) {
                found = lista.get(i);
            }
        }
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("User not found").build();
        } else {
            return Response.ok(found).build();
        }
    }

    /**
     * Postman: {"name":"Rosa3333","username":"Marfi3333l"}
     *
     * @param user
     * @return Response list NOTA: Si no existe el constructor vacío de User, da un
     *         error y el userRequest viene null.
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(User user) {

        this.lista.add(user);
        return Response.ok(lista).build();

    }

    /**
     * Postman: {"name":"Rosa","username":"Marfil3333"}
     *
     * @param user
     * @return user modified NOTA: Si no existe el constructor vacío de User, da un
     *         error y el userRequest viene null.
     */
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        User found = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getName().equalsIgnoreCase(user.getName())) {
                found = lista.get(i);
            }
        }

        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("User not found").build();
        } else {
            found.setUsername(user.getUsername());
            return Response.ok(found).build();
        }
    }

    /**
     *
     * @param name
     * @return Response
     */
    @DELETE
    @Path("/delete/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("name") String name) {
        User found = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getName().equalsIgnoreCase(name)) {
                found = lista.get(i);
                lista.remove(found);
            }
        }

        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("User not found").build();
        } else {
            return Response.ok(lista).build();
        }
    }
}
