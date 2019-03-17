package es.uam.eps.ads.p3.Classes;

/**
 * Clase para los caminos trampa
 */
public class Trampa extends Camino{

	/**
	 * Coste extra
	 */
	private float costeExtra;

	/**
	 * Probabilidad de que vuelva al origen
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

	/**
	 * Getter del destino para que a veces te devuelva al inicio
	 * 
	 * @return destino
	 */
	@Override
	public Posada getDestino(){
		
		if(Math.random() < this.returnProb)
			return this.getOrigen();

		return super.getDestino();
	}

	/**
	 * Calcula el coste especial
	 * 
	 * @return costeExtra * coste
	 */
	@Override
	public float costeEspecial(){
		return this.costeExtra * this.getCoste();
	}

	/**
	 * Devuelve true
	 * 
	 * @return true
	 */
	@Override
	public Boolean esTrampa(){
		return true;
	}
	
}