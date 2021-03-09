
package es.iespuertolacruz.jpexposito.usuarios;

/**
 *
 * @author jpexposito
 */
public class Cliente {
    
    String codigo;
    String nombre;
    String dni;
    String direccion;
    String telefono;

    public Cliente(String codigo, String nombre, String dni, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    
    @Override
    public String toString(){
        String salida =  "Codigo:" +codigo +
                         ", Nombre:" +nombre +
                ", Dni:" +dni +
                ", Direccion:" +direccion +
                ", Telefono:" +telefono;

        return salida;
    } 
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
