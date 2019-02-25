package es.uam.eps.ads.p3.Tester;

import es.uam.eps.ads.p3.Classes.*;

public class TesterCamino{
	
	public static void main(String[] args) {
		Posada d = new Posada("Darkness", 10);
		Posada l = new Posada("Light", 10);
		Posada v = new Posada("Void", 1);
		Camino c1 = new Camino(d, l, 5);
		Camino c2 = new Camino(l, d, 0); //El coste deberia ser 1;

		System.out.println("Camino 1 --> " + c1);
		//Comprobamos que se han creado y se imprimen bien
		System.out.println("Camino 2 --> " + c2);

		//Cambiamos el destino y comprobamos
		c2.cambiarDestino(v, 100);
		System.out.println("Camino 2 modificado --> " + c2);
	}
}