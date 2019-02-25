package es.uam.eps.ads.p3.Tester;

import es.uam.eps.ads.p3.Classes.*;

public class TesterCamino{
	
	public static void main(String[] args) {
		Posada d = new Posada("Darkness", 10);
		Posada l = new Posada("Light", 10);
		Camino c1 = new Camino(d, l, 5);
		Camino c2 = new Camino(l, d, 0); //El coste deberia ser 1;

		System.out.println(c1);
		System.out.println(c2);//Comprobamos que se han creado y se imprimen bien
	}
}