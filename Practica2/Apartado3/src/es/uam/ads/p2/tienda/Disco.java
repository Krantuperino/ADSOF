package es.uam.ads.p2.tienda;

/**
 * Define la clase Disco
 *
 * @author Juan Martin y Pablo Sanchez 
 */
public class Disco extends Articulo {

    /**
     * Interprete
     */
    public String interprete;

    /**
     * Año de salida del disco
     */
    public int anioPublicacion;

    /**
     * Constructor de clase
     *
     * @param id Id del libro para almacenaje
     * @param titulo Nombre del disco
     * @param autor Nombre del autor
     * @param anio Fecha de salida
     */
    public Disco(int id, String titulo, String autor, int anio) {

        super.idInterno = id;
        super.titulo = titulo;
        this.interprete = autor;
        this.anioPublicacion = anio;

    }

    /**
     * Cadena de caracteres con la info del disco
     *
     * @return String.
     */
    public String toString() {
        return "[" + super.idInterno + "] DISCO: " + this.interprete + " - " 
        + super.titulo + " (" + this.anioPublicacion + ")";
    }
}