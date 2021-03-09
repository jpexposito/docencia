/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.elementos;

import java.util.Objects;

/**
 *
 * @author jpexposito
 */
public class Direccion {
    
    private String calle;
    private int cp;
    private String provincia;

    public Direccion(String calle, int cp, String provincia) {
        this.calle = calle;
        this.cp = cp;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
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
        final Direccion other = (Direccion) obj;
        if (this.cp != other.cp) {
            return false;
        }
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        if (!Objects.equals(this.provincia, other.provincia)) {
            return false;
        }
        return true;
    }
    
    
    
}
