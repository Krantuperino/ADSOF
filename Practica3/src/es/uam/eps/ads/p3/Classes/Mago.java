package es.uam.eps.ads.p3.Classes;

public class Mago extends Explorador {

	/**
	 * Tipo de mago enumeracion
	 */
	private enum MageType{
		HECHICERO,
		HADA
	}

	/**
	 * Que tipo de mago es
	 */
	private MageType mage;

	/**
	 * Cuanto poder tiene un mago
	 */
	private int magePower;

	/**
	 * Constructor de clase para magos
	 * 
	 * @param nombre del mago
	 * @param energia inicial del mago
	 * @param start Podada de comienzo
	 * @param mage tipo de mago
	 * @param magePower nivel de poder del mago
	 */
	public Mago(String nombre, int energia, Posada start, MageType mage, int magePower){
		
		super(nombre, energia, start);
		this.mage = mage;
		this.magePower = magePower;
	}

	public Boolean puedeRecorrerCamino(Camino camino){
	
		if(camino.esTrampa())
			return false;
		
		return this.getStamina() >= camino.costeReal();
	}

	public Boolean puedeAlojarseEn(Posada posada){
		Posada.LightLevel light = posada.getLight();

		switch(this.mage){
			case HADA:
				if(light.ordinal() > Posada.LightLevel.GRIS.ordinal())
					return true;
				break;
			case HECHICERO:
				if(light.ordinal() < Posada.LightLevel.GRIS.ordinal() ||
				light.ordinal() < this.magePower + Posada.LightLevel.TENEBROSA.ordinal())
					return true;
				break;
		}

		return false;
	}
}