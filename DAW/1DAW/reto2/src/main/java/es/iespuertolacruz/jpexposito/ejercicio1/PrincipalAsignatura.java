
package es.iespuertolacruz.jpexposito.ejercicio1;

import es.iespuertolacruz.jpexposito.ejercicio1.exception.AsignaturaExpcetion;
import java.util.ArrayList;

/**
 *
 * @author jpexposito
 */
public class PrincipalAsignatura {
    
    ArrayList<Asignatura> listaAsignaturas;

    public PrincipalAsignatura(ArrayList<Asignatura> lista) {
        this.listaAsignaturas = lista;
    }
    
    
    
    public String mostrar_v1() {
        eliminarAprobadas();
        return listaAsignaturas.toString();   
    }
    
    public String mostrar_v2() {
        String mensaje = "";
        for(Asignatura asignatura:listaAsignaturas) {
            if (asignatura.getNota() < 5) {
                mensaje += asignatura.toString();
            }
        }
        return mensaje;
    }
    
    /**
     * Metodo que verifica si verificarAsignatura una asignatura en la lista
     * @param asignatura
     * @throws AsignaturaExpcetion 
     */
    public void verificarAsignatura(Asignatura asignatura) throws AsignaturaExpcetion {
        if (this.listaAsignaturas.contains(asignatura)) {
            throw new AsignaturaExpcetion("La asignatua existe en la lista");
        }
    }
    
    /**
     * Metodo que elimina de la lista las asignaturas aprobadas
     */
    public void eliminarAprobadas() {
        for (Asignatura asignatura:this.listaAsignaturas) {
            if (asignatura.getNota() >= 5) {
                listaAsignaturas.remove(asignatura);
            } 
        }
    }
    
}
