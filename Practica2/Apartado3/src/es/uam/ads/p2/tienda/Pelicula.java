package es.uam.ads.p2.tienda;

public class Pelicula extends Articulo {

    public String genero;
    public String director;

    public Pelicula(int id, String titulo, String genero, String director) {

        super.idInterno = id;
        super.titulo = titulo;
        this.genero = genero;
        this.director = director;

    }

    public String toString() {
        return "[" + super.idInterno + "] PELICULA: " + super.titulo + " (" 
        + this.genero + "). Dir: " + this.director;
    }
}