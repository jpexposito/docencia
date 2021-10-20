package es.system.jpexposito.service.rest;

import es.system.jpexposito.service.model.User;

import java.util.ArrayList;
import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.*;


@Path("/users")
public class Users {

    private static List<User> lista = new ArrayList<User>() {
        {
            add(new User("Rosa", "Marfil"));
            add(new User("Pepito", "Grillo"));
            add(new User("Manuela", "Lago"));
        }
    };

    /**
     * http://localhost (o ip):puerto/rest-service/rest/users
     * @return Retorna la lista de usuarios
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return Response.ok(lista).build();
    }


    /**
     *
     * http://localhost (o ip):puerto/rest-service/rest/users/Rosa
     * Donde Rosa es el nombre del usuario que desamos obtener
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
            return Response.status(Response.Status.BAD_REQUEST).entity("User not found").build();
        } else {
            return Response.ok(found).build();
        }
    }

    /**
     * Postman: {"name":"Rosa3333","username":"Marfi3333l"}
     * http://localhost (o ip):puerto/rest-service/rest/users/create/{"name":"Rosa3333","username":"Marfi3333l"}
     * Peticion de tipo POST
     * @param user
     * @return Response list NOTA: Si no existe el constructor vacio de User, da un
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
     * http://localhost (o ip):puerto/rest-service/rest/users/update/{"name":"Rosa","username":"Marfi3333lUpdate"}
     * @param user
     * @return user modified NOTA: Si no existe el constructor vacío de User, da un
     *         error y el userRequest viene null.
     */
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(User user) {
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
     * http://localhost (o ip):puerto/rest-service/rest/users/delete/Rosa
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
