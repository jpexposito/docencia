
package es.iespuertolacruz.jpexposito.plantilla;

/**
 *
 * @author jpexposito
 */
public class Entrenador extends Integrante {
    
    Integer idFederacion;

    public Entrenador(Integer idFederacion, Integer id, String nombre, 
            String apellidos, Integer edad) {
        
        super(id, nombre, apellidos, edad);
        this.idFederacion = idFederacion;
    }

    public Integer getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(Integer idFederacion) {
        this.idFederacion = idFederacion;
    }
    
    
    public void dirigirPartido() {
        //...
    }
    
    public void dirigirEntrenamiento() {
        //..
    }

    @Override
    public void concentrarse2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
