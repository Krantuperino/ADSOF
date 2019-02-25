package es.uam.eps.ads.p3.Tester;

import es.uam.eps.ads.p3.Classes.*;

public class EjemploDeUsoExploradoresBasicos {

    public static void main(String[] args) {
        
        Posada solana = new Posada("Solana", 1);
        Posada romeral = new Posada("Romeral", 5); 
        Posada tomelloso = new Posada("Tomelloso"); // por defecto energ�a recuperada 2
        Explorador sancho = new Explorador("Sancho", 50, solana);
        solana.addCamino(new Camino(solana, romeral, 68));
        solana.addCamino(new Camino(solana, tomelloso, 33));
        System.out.println(sancho);
        sancho.recorre(romeral, tomelloso); // ir� directo a tomelloso sin pasar por romeral
        System.out.println(sancho); // energ�a  19 = 50 - 33  + 2
        tomelloso.addCamino(new Camino(tomelloso, romeral, 11));
        sancho.recorre(tomelloso.getCamino(romeral)); // getCaminoHacia
        System.out.println(sancho); // en Romeral con energ�a 13 = 19 - 11  + 5
        
    }
}


