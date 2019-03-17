package es.uam.eps.ads.p3.Classes;

/**
 * Clase general para todos los exploradores de tipo mago
 */
public class Mago extends Explorador {

	/**
	 * Cuanto poder tiene un mago
	 */
	private int magePower;

	/**
	 * Constructor de clase para magos
	 * 
	 * @param nombre del mago
	 * @param energia inicial del mago
	 * @param start Posada de comienzo
	 * @param magePower nivel de poder del mago
	 */
	public Mago(String nombre, int energia, Posada start, int magePower){
		
		super(nombre, energia, start);
		this.magePower = magePower;
	}

	/**
	 * Getter de magePower
	 * 
	 * @return el poder que tiene el mago
	 */
	public int getMagePower() {
		return magePower;
	}

	/**
	 * Marca si el mago puede recorrer dicho camino
	 * 
	 * @param camino a comprobar
	 * 
	 * @return False si es un camino trampa
	 */
	@Override
	public Boolean puedeRecorrerCamino(Camino camino){
	
		if(camino.esTrampa())
			return false;
		
		return this.getStamina() >= camino.costeReal();
	}
}