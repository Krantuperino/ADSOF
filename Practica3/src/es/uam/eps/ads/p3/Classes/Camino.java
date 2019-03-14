package es.uam.eps.ads.p3.Classes;
/**
 * Clase camino, define el trayecto de una Posada a otra y el coste de energia que
 * conlleva recorrerlo.
 *
 * @author Juan Martin (juan.martinp@estudiante.uam.es) y Pablo Sanchez (pablo.sanchezredondo@estudiante.uam.es)
 */
public class Camino{

	/**
	 * Posada desde donde comienza el camino
	 */
	private Posada origen;

	/**
	 * Posada donde termina el camino
	 */
	private Posada destino;

	/**
	 * Coste energetico al recorrer el camino
	 */
	private int costeEnergia;

	/**
	 * Constructor de clase basico
	 *
	 * @param origen Posada de origen
	 * @param destino Posada de destino
	 * @param coste de energia
	 */
	public Camino(Posada origen, Posada destino, int coste){

		this.origen = origen;
		this.destino = destino;
		this.costeEnergia = coste;

		if(coste <= 0)
			this.costeEnergia = 1;

	}

	/**
	 * Getter de la posada de origen
	 *
	 * @return posada de origen del camino
	 */
	public Posada getOrigen(){
		
		return this.origen;
	}


	/**
	 * Getter de la posada de destino, a veces te devuelve al origen si el camino es trampa
	 *
	 * @return posada de destino del camino
	 */
	public Posada getDestino(){

		return this.destino;
	}


	/**
	 * Getter del coste de energia
	 *
	 * @return coste de energia
	 */
	public int getCoste(){
		
		return this.costeEnergia;
	}

	/**
	 * Redefinicion de toString
	 * 
	 * @return String
	 */
	@Override
	public String toString(){
		
		return "(" + this.origen.getNombre() + "--" + this.costeEnergia + "-->" + this.destino.getNombre() + ")";
	}

	/**
	 * Modifica el destino y el coste
	 *
	 * @param newDestino nuevo destino
	 * @param newCoste nuevo coste
	 */
	public void cambiarDestino(Posada newDestino, int newCoste){
		
		this.destino = newDestino;
		this.costeEnergia = newCoste;

		if(newCoste <= 0)
			this.costeEnergia = 1;
	}

	/**
	 * Coste especial, si es una trampa devuelve costeExtra * costeEnergia
	 * 
	 * @return 0 si no es trampa, el coste especial si lo es
	 */
	public float costeEspecial(){

		return 0;
	}

	/**
	 * Coste real. Suma el coste mas el coste especial
	 * 
	 * @return coste real
	 */
	public int costeReal(){
		
		return Math.round(costeEspecial() + this.costeEnergia);
	}

	/**
	 * Devuelve si el camino ES UNA TRAMPA
	 * 
	 * @return Boolean. True es trampa
	 */
	public Boolean esTrampa(){
		
		return false;
	}
}