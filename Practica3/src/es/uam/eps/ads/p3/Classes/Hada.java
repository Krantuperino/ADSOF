package es.uam.eps.ads.p3.Classes;

public class Hada extends Mago{

	public Hada(String nombre,  int energia, Posada start, int magePower){
		super(nombre, energia, start, magePower);
	}

	@Override
	public Boolean puedeAlojarseEn(Posada posada){

		Posada.LightLevel light = posada.getLight();

		if(light.ordinal() > Posada.LightLevel.GRIS.ordinal())
			return true;
		
			return false;
	}
}