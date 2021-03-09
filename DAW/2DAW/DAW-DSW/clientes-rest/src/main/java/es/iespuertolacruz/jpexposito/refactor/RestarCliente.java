package es.iespuertolacruz.jpexposito.refactor;

public class RestarCliente {

    public static void main(String[] args) {

        ClienteRest clienteRest = new ClienteRest("restar");
        String respuesta = clienteRest.operation(1,2);

        System.out.println("Respuesta :"+respuesta);

    }
}

