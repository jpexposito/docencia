package es.iespuertolacruz.jpexposito.refactor;

public class SumarCliente {

    public static void main(String[] args) {

        ClienteRest clienteRest = new ClienteRest("sumar");
        String respuesta = clienteRest.operation(1,2);

        System.out.println("Respuesta :"+respuesta);

    }
}

