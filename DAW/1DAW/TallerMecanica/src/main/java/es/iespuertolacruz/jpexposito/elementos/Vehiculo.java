
package es.iespuertolacruz.jpexposito.elementos;

import java.util.Objects;


/**
 *
 * @author jpexposito
 */
public class Vehiculo extends Validaciones{
    

    
    private String marca;
    private String modelo;
    private String matricula;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, String matricula) throws Exception {
        this.marca = marca;
        this.modelo = modelo;
        validarMatricula(matricula);
        this.matricula = matricula;
        
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + '\n';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }
    
   
    
}
