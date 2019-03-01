package es.uam.eps.ads.p3.Tester;

import es.uam.eps.ads.p3.Classes.*;

public class TesterPosada{

	public static void main(String[] args) {
		Posada paleta = new Posada("Palet", 10);
		Posada violeta = new Posada("Violet");
		Posada ceruleo = new Posada("Cerulean", 5);
		Camino camino1 = new Camino(paleta, violeta, 3);
		Camino camino2 = new Camino(paleta, ceruleo, 5);
		Camino camino3 = new Camino(violeta, ceruleo, 2);

		try{
			paleta.addCamino(camino1);
			paleta.addCamino(camino2);
			paleta.addCamino(camino3);
			violeta.addCamino(camino3);
		}
		catch(Exception e){
			System.out.println("\033[31;1mError\033[0m");
			return;
		}

		System.out.println("\033[32;1mOK\033[0m Everything generated correctly \n");

		//Comprobamos que se imprimen bien
		System.out.println("Num caminos: " + paleta.getNumCaminos() + "| Posada 1 --> " + paleta);//Dos caminos
		System.out.println("\nNum caminos: " + violeta.getNumCaminos() + "| Posada 2 --> " + violeta);//Un camino
		System.out.println("\nNum caminos: " + ceruleo.getNumCaminos() + "| Posada 3 --> " + ceruleo);//Ningun camino

		//Comprobamos getCamino
		System.out.println("\n" + paleta.getCamino(1));
		System.out.println("\n" + paleta.getCamino(violeta));
	}
}