package es.uam.eps.ads.p3.Tester;

import java.io.IOException;
import es.uam.eps.ads.p3.Classes.*;

public class EjemploDeUsoSimulacion {
	
	public static void main(String[] args) {
	try {
		Simulacion s;
		
		s = new Simulacion("POSADAS.txt", "CAMINOS.txt", "EXPLORADOR.txt");
		s = new Simulacion("POSADAS.txt", "CAMINOS.txt", "EXPLORADOR2.txt");
	} catch (IOException e) { 
		System.out.println ("Error en archivos"); }
	}
}