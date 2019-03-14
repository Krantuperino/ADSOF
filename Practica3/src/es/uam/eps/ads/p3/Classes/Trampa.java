package es.uam.eps.ads.p3.Classes;

public class Trampa extends Camino{

	/**
	 * Coste extra, si no es 0.0 el camino es trampa
	 */
	private float costeExtra;

	/**
	 * Probabilidad de que vuelva al origen, si no es 0.0 el camino es trampa
	 */
	private float returnProb;

	/**
	 * Constructor de caminos trampa
	 * 
	 * @param origen Posada de origen
	 * @param destino Posada de destino
	 * @param coste de energia
	 * @param extraCost coste extra que tienen los caminos trampa
	 * @param returnProb probabilidad de que los caminos te devuelvan al mismo sitio
	 */
	public Trampa(Posada origen, Posada destino, int coste, float extraCost, float returnProb) {

		super(origen, destino, coste);
		this.costeExtra = extraCost;
		this.returnProb = returnProb;
	}

	public Posada getDestino(){
		
		if(Math.random() < this.returnProb)
			return this.getOrigen();

		return super.getDestino();
	}

	public float costeEspecial(){
		return this.costeExtra * this.getCoste();
	}

	public Boolean esTrampa(){
		return true;
	}
}