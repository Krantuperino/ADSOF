package es.uam.ads.p2.tienda;

public class Disco extends Articulo {

    public String interprete;
    public int anioPublicacion;

    public Disco(int id, String titulo, String autor, int anio) {

        super.idInterno = id;
        super.titulo = titulo;
        this.interprete = autor;
        this.anioPublicacion = anio;

    }

    public String toString() {
        return "[" + super.idInterno + "] DISCO: " + this.interprete + " - " 
        + super.titulo + " (" + this.anioPublicacion + ")";
    }
}