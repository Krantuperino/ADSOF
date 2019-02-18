package es.uam.ads.p2.tienda;

public class Libro extends Articulo {

    public String autor;
    public String editorial;

    public Libro(int id, String titulo, String autor, String editorial) {

        super.idInterno = id;
        super.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;

    }

    public String toString() {
        return "[" + super.idInterno + "] LIBRO: " + super.titulo + ". " 
        + this.autor + ". " + this.editorial;
    }
}