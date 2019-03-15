package es.uam.eps.ads.p3.Classes;

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
	 * @param start Podada de comienzo
	 * @param mage tipo de mago
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

	public class Hechicero extends Mago{
		
		public Hechicero(String nombre, int energia, Posada start, int magePower){
			super(nombre, energia, start, magePower);
		}

		@Override
		public Boolean puedeAlojarseEn(Posada posada){

			posada.llamar(this);
			Posada.LightLevel light = posada.getLight();

			if(light.ordinal() < Posada.LightLevel.GRIS.ordinal() ||
				light.ordinal() < this.getMagePower() + Posada.LightLevel.TENEBROSA.ordinal())
					return true;
				return false;
		}

		@Override
		public String tipoDeMago(){
			return "HECHICERO";
		}
	}

	public class Hada extends Mago{

		public Hada(String nombre,  int energia, Posada start, int magePower){
			super(nombre, energia, start, magePower);
		}

		@Override
		public Boolean puedeAlojarseEn(Posada posada){

			posada.llamar(this);
			Posada.LightLevel light = posada.getLight();

			if(light.ordinal() > Posada.LightLevel.GRIS.ordinal())
				return true;
			
				return false;
		}

		@Override
		public String tipoDeMago(){
			return "HADA";
		}
	}
}