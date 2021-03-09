package es.iespuertolacruz.jpexposito.controlador;

public class Operacion  {

    Character operador;
    Double numero1;
    Double numero2;
    Double resultado;

    public Operacion(Character operador, Double numero1, Double numero2) {
        this.operador = operador;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public void mostrarResultado() {
        System.out.println(numero1 + " "+operador+" " + numero2 + " = "+resultado);
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
        mostrarResultado();
    }

    public Character getOperador() {
        return operador;
    }

    public Double getNumero1() {
        return numero1;
    }

    public void setNumero1(Double numero1) {
        this.numero1 = numero1;
    }

    public Double getNumero2() {
        return numero2;
    }

    public void setNumero2(Double numero2) {
        this.numero2 = numero2;
    }
}
