package es.iespuertolacruz.rest.jpexposito.dao.entity;

import org.codehaus.jackson.map.ObjectMapper;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

@XmlRootElement
public class Partida {
    String titulo;
    Integer anio;
    String director;
    String actores;
    String poster;
    String imagenes;



    public Pelicula() {
    }


    public Pelicula(String titulo, Integer anio, String director, String actores, String poster, String imagenes) {
        this.titulo = titulo;
        this.anio = anio;
        this.director = director;
        this.actores = actores;
        this.poster = poster;
        this.imagenes = imagenes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        if (this != null) {
            return "hola";
        } else {
            return "";
        }
    }
}
