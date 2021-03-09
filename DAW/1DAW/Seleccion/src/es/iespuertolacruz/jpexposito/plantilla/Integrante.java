package es.iespuertolacruz.jpexposito.plantilla;

/**
 *
 * @author jpexposito
 */
public abstract class Integrante {
    
    Integer id;
    String nombre;
    String apellidos;
    Integer edad;

    public Integrante() {}
    
    public Integrante(Integer id, String nombre, String apellidos, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    
    public void concentrarse() {
        System.out.println("Si se concentra");
    }
    
    public void viajar() {
                System.out.println("Si se concentra");

    }
    
    public abstract void concentrarse2();
    
    
}
