package es.uam.eps.ads.p4.Classes;

import es.uam.eps.ads.p4.Interface.Recomendador;

public class RecomendadorDeVecinos implements Recomendador {

	private ModeloDeDatos datos;
	private List<Long> similarUsers;

	//public CONSTRUCTOR 

	public Recomendacion recomienda(Long u, int longitudRecomendacion) 
		throws RecomendacionInvalida {
			if(longitudRecomendacion <= 0)
				throw new RecomendacionInvalida(0);
			else if(true)
				throw new RecomendacionInvalida(1);
	}
}