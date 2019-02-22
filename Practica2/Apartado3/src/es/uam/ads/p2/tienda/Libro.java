package es.uam.ads.p2.tienda;

/**
 * Define la clase Libro
 *
 * @author Juan Martin y Pablo Sanchez 
 */
public class Libro extends Articulo {

    /**
     * Autor del libro
     */
    public String autor;

    /**
     * Editorial
     */
    public String editorial;

    /**
     * Constructor de clase
     *
     * @param id Id del libro para almacenaje
     * @param titulo Nombre del libro
     * @param autor Nombre del autor
     * @param editorial Nombre de la editorial
     */
    public Libro(int id, String titulo, String autor, String editorial) {

        super.idInterno = id;
        super.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;

    }
    
    /**
     * Cadena de caracteres con la info del libro
     *
     * @return String.
     */
    public String toString() {
        return "[" + super.idInterno + "] LIBRO: " + super.titulo + ". " 
        + this.autor + ". " + this.editorial;
    }
}