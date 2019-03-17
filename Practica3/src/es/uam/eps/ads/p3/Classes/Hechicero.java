package es.uam.eps.ads.p3.Classes;

/**
 * Clase de magos de tipo hechicero, que son exploradores
 */
public class Hechicero extends Mago{
		
		/**
		 * Constructor de clase Hechicero
		 * 
		 * @param nombre del hechicero
		 * @param energia stamina de explorador
		 * @param start Posada donde comienza
		 * @param magePower Poder del mago
		 */
		public Hechicero(String nombre, int energia, Posada start, int magePower){
			super(nombre, energia, start, magePower);
		}

		/**
		 * Comprueba si el hechicero puede alojarse en posada
		 * 
		 * @param posada donde va a alojarse
		 * 
		 * @return boolean
		 */
		@Override
		public Boolean puedeAlojarseEn(Posada posada){

			Posada.LightLevel light = posada.getLight();

			if(light.ordinal() < Posada.LightLevel.GRIS.ordinal() ||
				light.ordinal() < this.getMagePower() + Posada.LightLevel.TENEBROSA.ordinal())
					return true;
				return false;
		}
	}