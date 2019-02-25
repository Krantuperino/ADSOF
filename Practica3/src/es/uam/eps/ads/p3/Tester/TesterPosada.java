package es.uam.eps.ads.p3.Tester;

import es.uam.eps.ads.p3.Classes.*;

public class TesterPosada{

	public static void main(String[] args) {
		Posada p = new Posada("Palet", 10);
		Posada v = new Posada("Violet");
		Posada c = new Posada("Celurean", 5);
		Camino c1 = new Camino(p, v, 3);
		Camino c2 = new Camino(p, c, 5);
		Camino c3 = new Camino(v, c, 2);

		try{
			p.addCamino(c1);
			p.addCamino(c2);
			p.addCamino(c3);
			v.addCamino(c3);
		}
		catch(Exception e){
			System.out.println("\033[31;1mError\033[0m");
		}

		System.out.println("\033[32;1mOK\033[0m Everything generated correctly");

		//Comprobamos que se imprimen bien
		System.out.println("Num caminos " + p.getNumCaminos() + " Posada 1 --> " + p);//Dos caminos
		System.out.println("Num caminos " + v.getNumCaminos() + " Posada 2 --> " + v);//Un camino
		System.out.println("Num caminos " + c.getNumCaminos() + " Posada 3 --> " + c);//Ningun camino

		//Comprobamos getCamino
		System.out.println(p.getCamino(1));
		System.out.println(p.getCamino(v));
	}
}