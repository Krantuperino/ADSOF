package es.uam.ads.p2.tienda;

/**
 * Define la clase pelicula
 *
 * @author Juan Martin y Pablo Sanchez 
 */
public class Pelicula extends Articulo {

    /**
     * Tipo de pelicula que es
     */
    public String genero;

    /**
     * Director de la pelicula
     */
    public String director;

    /**
     * Constructor de clase
     *
     * @param id Id de la pelicula para almacenaje
     * @param titulo Nombre de la pelicula
     * @param genero Tipo de pelicula
     * @param director Nombre del director
     */
    public Pelicula(int id, String titulo, String genero, String director) {

        super.idInterno = id;
        super.titulo = titulo;
        this.genero = genero;
        this.director = director;

    }

    /**
     * Cadena de caracteres con la info de la pelicula
     *
     * @return String.
     */
    public String toString() {
        return "[" + super.idInterno + "] PELICULA: " + super.titulo + " (" 
        + this.genero + "). Dir: " + this.director;
    }
}