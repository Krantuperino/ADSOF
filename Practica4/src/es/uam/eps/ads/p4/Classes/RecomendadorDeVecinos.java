package es.uam.eps.ads.p4.Classes;

import java.util.List;

import es.uam.eps.ads.p4.Exceptions.RecomendacionInvalida;
import es.uam.eps.ads.p4.Interface.ModeloDatos;
import es.uam.eps.ads.p4.Interface.Recomendador;

public class RecomendadorDeVecinos implements Recomendador {

	private ModeloDatos datos;
	private List<Long> similarUsers;

	//public CONSTRUCTOR 

	public Recomendacion recomienda(Long u, int longitudRecomendacion)                   //tiene que tener un return
		throws RecomendacionInvalida {
			if(longitudRecomendacion <= 0)
				throw new RecomendacionInvalida(0);
			else if(true)
				throw new RecomendacionInvalida(1);
	}
}