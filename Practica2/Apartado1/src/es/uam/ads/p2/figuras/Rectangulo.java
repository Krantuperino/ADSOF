package es.uam.ads.p2.figuras;

/**
 * Define la clase rectangulo y calcula su area y perimetro
 *
 * @author Juan Martin y Pablo Sanchez
 */

public class Rectangulo extends Figura{ 
	
	/** 
	 * Longitud de las bases del rectangulo
	 */
	private double base;
	
	/** 
	 * Longitud de la altura del rectangulo
	 */
	private double altura; 


	/**
	 * Constructor de clase.
	 *
	 * @param x base del rectangulo
	 * @param y altura del rectangulo
	 */
	public Rectangulo(double x, double y){
		base = x;
		altura = y;
	}

	/**
	 * @return Cadena con los valores del rectangulo
	 */
	public String toString() {
		return "Rectangulo [area=" + getArea() + ", perimetro=" + getPerimetro() + "]";
	}

	/**
     * Getter de la base
     * 
	 * @return base del rectangulo
	 */
	public double getBase() {
		return base;
	}

	/**
     * Getter de la altura
     * 
	 * @return altura del rectangulo
	 */
	public double getAltura() {
		return altura;
	}

	/**
     * Calcula el perimetro del rectangulo
     *
	 * @return Perimetro del rectangulo
	 */
	public double getPerimetro() {
		return (base * 2) + (altura * 2);
	}

	/**
     * Calcula el area del rectangulo
     *
	 * @return Area del rectangulo
	 */
	public double getArea() {
		return base * altura;
	}

	/**
	 * Comprueba si el rectangulo es un cuadrado
	 *
	 * @return true si es un cuadrado false en caso contrario
	 */
	public boolean isCuadrado() {
		if(base == altura)
			return true;

		return false;
	}
}