package es.uam.eps.ads.p3.Classes;

/**
 * Clase que define a los magos de tipo hada, que son exploradores
 */
public class Hada extends Mago{

	/**
	 * Constructor de la clase Hada
	 * 
	 * @param nombre del hada
	 * @param energia que tiene como explorador
	 * @param start Posada de inicio
	 * @param magePower poder del hada, (actualmente en desuso)
	 */
	public Hada(String nombre,  int energia, Posada start, int magePower){
		super(nombre, energia, start, magePower);
	}

	/**
	 * Comprueba si el hada puede alojarse en posada
	 * 
	 * @param posada donde va a alojarse
	 * 
	 * @return boolean
	 */
	@Override
	public Boolean puedeAlojarseEn(Posada posada){

		Posada.LightLevel light = posada.getLight();

		if(light.ordinal() > Posada.LightLevel.GRIS.ordinal())
			return true;
		
			return false;
	}
}