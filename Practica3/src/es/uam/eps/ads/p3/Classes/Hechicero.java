package es.uam.eps.ads.p3.Classes;

public class Hechicero extends Mago{
		
		public Hechicero(String nombre, int energia, Posada start, int magePower){
			super(nombre, energia, start, magePower);
		}

		@Override
		public Boolean puedeAlojarseEn(Posada posada){

			Posada.LightLevel light = posada.getLight();

			if(light.ordinal() < Posada.LightLevel.GRIS.ordinal() ||
				light.ordinal() < this.getMagePower() + Posada.LightLevel.TENEBROSA.ordinal())
					return true;
				return false;
		}
	}