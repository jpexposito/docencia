package es.iespuertolacruz.jpexposito;


import es.iespuertolacruz.jpexposito.controlador.Calculo;
import es.iespuertolacruz.jpexposito.controlador.Operacion;

public class AppSemaforo {


    public static void main(String[] args) {

        Operacion operacionSuma = new Operacion('+', 3.0,2.0);
        Operacion operacionResta = new Operacion('-', 3.0,2.0);
        Operacion operacionDivision = new Operacion('/', 3.0,2.0);
        Operacion operacionMultiplicacion = new Operacion('*', 3.0,2.0);

        long initialTime = System.currentTimeMillis();
        Calculo calculoSuma = new Calculo(operacionSuma, initialTime);
        Calculo calculoResta = new Calculo(operacionResta, initialTime);
        Calculo calculoDivision = new Calculo(operacionDivision, initialTime);
        Calculo calculoMultiplicacion = new Calculo(operacionMultiplicacion, initialTime);

        calculoSuma.start();
        calculoResta.start();
        calculoDivision.start();
        calculoMultiplicacion.start();



    }
}
