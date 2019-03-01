package es.uam.eps.ads.p3.Tester;

import es.uam.eps.ads.p3.Classes.*;

public class TesterExplorador{

	public static void main(String[] args) {
		Posada hobbit = new Posada("Hobbiton", 20);
		Posada elfo = new Posada("Rivendell", 10);
		Posada humano = new Posada("Minas Tirith", 14);
		Posada orco = new Posada("Mordor", -10);
		Camino cam1 = new Camino(hobbit, elfo, 5);
		Camino cam2 = new Camino(elfo, orco, 20);
		Camino cam3 = new Camino(elfo, humano, 10);
		Camino cam4 = new Camino(humano, orco, 15);
		Camino cam5 = new Camino(orco, elfo, 20);

		hobbit.addCamino(cam1);
		elfo.addCamino(cam2);
		elfo.addCamino(cam3);
		humano.addCamino(cam4);
		orco.addCamino(cam5);

		//Caminos y posadas inicializados

		Explorador frodo = new Explorador("Frodo", 100, hobbit);

		//Comprobamos los getters
		if(frodo.getNombre() != "Frodo" || frodo.getLugar() != hobbit
		|| frodo.getStamina() != 100){
			System.out.println("\033[31;1mGetters are not ok\033[0m");
		}
		else{
			System.out.println("\n\033[32;1mGetters are all OK\033[0m\n");
		}

		//Comprobamos toString
		System.out.println(frodo + "\n");

		if(!frodo.recorre(elfo, humano, orco, elfo)){
			System.out.println("\033[31,1mRecorre function not functioning\033[0m\n");
		}
		else{
			frodo.recorre(hobbit, orco, humano, elfo);
			if(frodo.getLugar() == elfo)
				System.out.println("\033[32;1mRecorre function is OK\033[0m\n");
			else
				System.out.println("\033[31,1mRecorre function not functioning\033[0m\n");
		}

	}
}