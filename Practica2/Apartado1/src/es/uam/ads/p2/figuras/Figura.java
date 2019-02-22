package es.uam.ads.p2.figuras;

/**
 * Clase abstracta que se aplica a las figuras geometricas. 
 *
 * @author Juan Martin y Pablo Sanchez
 */

public abstract class Figura {

    /**
     * Llama a la funcion perimetro de la figura.
     *
     * @return Perimetro de la figura
     */
    public abstract double getPerimetro();


    /**
     * Llama a la funcion area de la figura.
     *
     * @return Area de la figura
     */
    public abstract double getArea();


    /**
     * Calcula si la figura es mayor que la figura dada por parametro
     *
     * @param fig1 Figura
     *
     * @return true si es mayor o false en caso contrario
     */
    public boolean esMayor(Figura fig1) {
        if(this.getArea() > fig1.getArea())
            return true;
        return false;
    }
}