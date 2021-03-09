package es.iespuertolacruz.jpexposito;

/**
 *
 * @author jpexposito
 */
public class Libro {
    
    String titulo;
    String autor;
    int ejemplares;
    int prestados;
    
    public Libro() {
        this.titulo = "";
        this.autor = "";
        this.ejemplares = 0;
        this.prestados = 0;
    }
    
    public Libro(String titulo, String autor, int ejemplares, int prestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
        this.prestados = prestados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public int getPrestados() {
        return prestados;
    }

    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }
    
    public boolean prestar() {
        boolean prestado = false;
        
        if (prestados < ejemplares) {
            prestados++;
            prestado = true;
        }
        
        return prestado;  
    }
    
    
    
}
