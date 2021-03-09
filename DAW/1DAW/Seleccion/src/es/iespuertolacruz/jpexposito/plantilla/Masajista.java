/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.plantilla;

/**
 *
 * @author jpexposito
 */
public class Masajista extends Integrante{
    
    String titulacion;
    Integer aniosExperiencia;

    public Masajista(String titulacion, Integer aniosExperiencia, Integer id,
            String nombre, String apellidos, Integer edad) {
        
        super(id, nombre, apellidos, edad);
        this.titulacion = titulacion;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public Integer getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(Integer aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
    
   
    public void darMasaje() {
        
    }

    @Override
    public void concentrarse2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
