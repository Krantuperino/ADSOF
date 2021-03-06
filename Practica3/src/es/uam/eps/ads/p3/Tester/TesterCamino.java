package es.uam.eps.ads.p3.Tester;

import es.uam.eps.ads.p3.Classes.*;

public class TesterCamino{
	
	public static void main(String[] args) {
		Posada dark = new Posada("Darkness", 10);
		Posada light = new Posada("Light", 10);
		Posada vacio = new Posada("Void", 1);
		Camino camino1 = new Camino(dark, light, 5);
		Camino camino2 = new Camino(light, dark, 0); //El coste deberia ser 1;
		Trampa trampa = new Trampa(dark, light, 4, 6, 1f);
		
		if(camino1.getCoste() != 5 || camino1.getDestino() != light 
		|| camino1.getOrigen() != dark){
			System.out.println("\033[31;1mGetters are not ok\033[0m");
		}
		else{
			System.out.println("\033[32;1mGetters are all OK\033[0m\n");
		}
		
		//Comprobamos que la formula de costeEspecial funciona bien
		//ademas de esTrampa y de la probabilidad de retorno
		if(trampa.costeEspecial() != (4*6) || trampa.esTrampa() != true 
		|| trampa.getDestino() != dark) {
			System.out.println("\033[31;1mTrampa class is not OK\033[0m");
		}
		else {
			System.out.println("\033[32;1mTrampa class is OK\033[0m");
		}

		System.out.println("Camino 1 --> " + camino1);
		//Comprobamos que se han creado y se imprimen bien
		System.out.println("Camino 2 --> " + camino2);
		
		//Cambiamos el destino y comprobamos
		camino2.cambiarDestino(vacio, 100);
		System.out.println("Camino 2 modificado --> " + camino2);
		
		System.out.println("Camino trampa --> " + trampa + " -->" +" Es trampa: " + trampa.esTrampa());
	}
}