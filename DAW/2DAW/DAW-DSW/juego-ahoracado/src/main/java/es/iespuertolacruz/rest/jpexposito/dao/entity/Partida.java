package es.iespuertolacruz.rest.jpexposito.dao.entity;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Partida {

    String dni;
    Integer jugadas;
    Integer ganadas;

    public Partida(String dni) {
        this.dni = dni;
        this.jugadas = 0;
        this.ganadas = 0;
    }

    public Partida(String dni, Integer jugadas, Integer ganadas) {
        this.dni = dni;
        this.jugadas = jugadas;
        this.ganadas = ganadas;
    }

    public String getDni() {
        return dni;
    }

    public Integer getJugadas() {
        return jugadas;
    }

    public void setJugadas(Integer jugadas) {
        this.jugadas = jugadas;
    }

    public Integer getGanadas() {
        return ganadas;
    }

    public void setGanadas(Integer ganadas) {
        this.ganadas = ganadas;
    }
}
