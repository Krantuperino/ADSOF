package es.uam.eps.ads.p4.Tester;

import es.uam.eps.ads.p4.Interface.ModeloDatos;

import java.io.IOException;

import es.uam.eps.ads.p4.Classes.*;

public class Tester {

	public static void main(String[] args) {
		
		ModeloDatos mod = new Datos(); 
		
		try{
			mod.leeFicheroPreferencias("../txt/PruebaTraining.txt");
		}
		catch(IOException e){
			System.out.println("Shiet");
		}
	}
}