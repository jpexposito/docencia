package es.iespuertolacruz.jpexposito.refactor;

public class DividirCliente {

    public static void main(String[] args) {

        ClienteRest clienteRest = new ClienteRest("dividir");
        String respuesta = clienteRest.operation(1,2);

        System.out.println("Respuesta :"+respuesta);

    }
}

