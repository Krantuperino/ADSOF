package es.uam.ads.p2.figuras;

/**
 * Define la clase circulo y calcula su area y perimetro
 *
 * @author Juan Martin y Pablo Sanchez
 */

public class Circulo extends Figura{
    
    /**
     * Valor del radio del circulo
     */
    private double radio;

    /**
     * Constructor de clase.
     *
     * @param x radio del circulo
     */
    public Circulo(double x){
        radio = x;
    }

    /**
	 * @return Cadena con los valores del circulo
	 */
     public String toString() {
        return "Circulo [area=" + getArea() + ", perimetro=" + getPerimetro() + "]";
    }

    /**
     * Getter del radio
     * 
	 * @return radio del circulo
	 */
    public double getRadio(){
        return radio;
    } 

    /**
     * Calcula el perimetro del circulo
     *
	 * @return Perimetro del circulo
	 */
    public double getPerimetro() {
        return 2 * Math.PI * radio;
    }

    /**
     * Calcula el area del circulo
     *
	 * @return Area del circulo
	 */
    public double getArea() {
        return Math.PI * radio * radio;
    }
}