package es.iespuertolacruz.jpexposito.refactor;

public class MultiplicarCliente {

    public static void main(String[] args) {

        ClienteRest clienteRest = new ClienteRest("multiplicar");
        String respuesta = clienteRest.operation(1,2);

        System.out.println("Respuesta :"+respuesta);

    }
}

