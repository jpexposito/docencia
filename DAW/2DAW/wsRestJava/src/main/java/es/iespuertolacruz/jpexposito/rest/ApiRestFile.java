/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.rest;

import es.iespuertodelacruz.jpexposito.controlador.UsuarioFileControlador;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jpexposito
 */

@Path("/file")
public class ApiRestFile {
    
    String version = "1.0";
    UsuarioFileControlador usuarioFileControlador = new UsuarioFileControlador();
    
    
    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)    

    public Response generateRndNumber(){      
        return Response.ok(
                response("Numero Aleatorio", "", version), 
                MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/buscar")
    @Produces(MediaType.APPLICATION_JSON)    

    public Response buscar(){      
        return Response.ok(
                response("Numero Aleatorio", "", version), 
                MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/insertar")
    @Produces(MediaType.APPLICATION_JSON)    

    public Response insertar(){  
        
        usuarioFileControlador.
        return Response.ok(
                response("Numero Aleatorio", "", version), 
                MediaType.APPLICATION_JSON).build();
    }

    
    
    /**
     * metodo privado para dar formato al JSON de respuesta
     * @param operation Operacion que se realiza en el APIREST
     * @param paramater parametro de entrada
     * @param result resultado de la operacion realizada
     * @return String Respuesta en formato JSON
     */
    private String response(String operation, String parameter, String result) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("operation", operation);
            obj.put("parameter", parameter);
            obj.put("result", result);            
            return obj.toString(4);
        } catch (JSONException ex) {
            System.err.println("JSONException: " + ex.getMessage());
        }
        return "";
    }

}
