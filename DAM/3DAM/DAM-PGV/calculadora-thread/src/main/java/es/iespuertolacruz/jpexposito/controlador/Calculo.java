package es.iespuertolacruz.jpexposito.controlador;

public class Calculo extends Thread {

    Operacion operacion;
    private long initialTime;

    public Calculo () { }

    public Calculo (Operacion operacion, long inicio) {
        this.operacion = operacion;
        this.initialTime = inicio;
    }

    @Override
    public void run() {
        switch (operacion.getOperador()) {
            case '+' :
                esperarXsegundos(1);
                operacion.setResultado(operacion.getNumero1() + operacion.getNumero2());
                break;
            case '-' :
                esperarXsegundos(1);
                operacion.setResultado(operacion.getNumero1() - operacion.getNumero2());
                break;
            case '/' :
                esperarXsegundos(1);
                operacion.setResultado(operacion.getNumero1() / operacion.getNumero2());
                break;
            case '*' :
                esperarXsegundos(1);
                operacion.setResultado(operacion.getNumero1() * operacion.getNumero2());
                break;
            default: break;
        }
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
