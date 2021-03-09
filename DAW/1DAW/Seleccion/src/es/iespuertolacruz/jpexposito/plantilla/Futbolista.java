
package es.iespuertolacruz.jpexposito.plantilla;

/**
 *
 * @author jpexposito
 */
public class Futbolista extends Integrante{
    
    Integer dorsal;
    String demarcacion;

    public Futbolista() {
    }
    
    public Futbolista(Integer dorsal, String demarcacion, Integer id,
            String nombre, String apellidos, Integer edad) {
        
        super(id, nombre, apellidos, edad);
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public String getDemarcacion() {
        return demarcacion;
    }

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }
    
    public void jugarPartido() {
        //....
    }
    
    public void entrenar() {
        //....
    }
    
    @Override
    public void concentrarse() {
        System.out.println("No se concentra");

    }

    @Override
    public void concentrarse2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
