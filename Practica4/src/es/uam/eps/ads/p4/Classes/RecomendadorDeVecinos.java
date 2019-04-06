package es.uam.eps.ads.p4.Classes;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import es.uam.eps.ads.p4.Interface.Recomendador;
import es.uam.eps.ads.p4.Interface.Similitud;
import es.uam.eps.ads.p4.Interface.ModeloDatos;

public class RecomendadorDeVecinos implements Recomendador {

	private ModeloDeDatos datos;
	private Similitud sim;
	private int number;

	public RecomendadorDeVecinos(ModeloDatos mod, int k){
		this.datos = mod;
		this.sim = new Similitud(mod);
		this.number = k;
		
	}


	public Recomendacion recomienda(Long u, int longitudRecomendacion) 
		throws RecomendacionInvalida {
			if(longitudRecomendacion <= 0)
				throw new RecomendacionInvalida(0);
			else if(!this.datos.isInIdUsuarios(u))
				throw new RecomendacionInvalida(1);

			TreeMap<Double, Long> map = new TreeMap<Double, Long>();
			for(Long user : datos.getUsuariosUnicos()){
				map.put(sim.sim(u, user), user);
			}
			
			List<Long> vecinos = new List<Long>();
			for(int i=0; i < number; i++){
				Double d = map.lastKey();
				vecinos.add(map.remove(d));
			}

			Recomendacion rec = new Recomendacion(u);

			Double suma = 0.0;
			for(Long i : datos.getItemsUnicos()){
				if(!datos.getPreferenciasUsuario(u).containsKey(i)){
					for(Long v : vecinos){
						suma += sim.sim(u, v) * datos.getPreferenciasItem.get(v);
					}
					rec.insertRecommendation(i, suma);
				}
			}
			rec.onlyBest(longitudRecomendacion);
			return rec;
	}
}