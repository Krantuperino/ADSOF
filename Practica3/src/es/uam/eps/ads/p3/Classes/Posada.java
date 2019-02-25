package es.uam.eps.ads.p3.Classes;

import java.util.ArrayList;

/**
 * Clase Posada. Lugar de descanso y conexion de caminos
 * 
 * @author Juan Martin (juan.martinp@estudiante.uam.es) y Pablo Sanchez (pablo.sanchezredondo@estudiante.uam.es)Juan Martin (juan.martinp@estudiante.uam.es) y Pablo Sanchez (pablo.sanchezredondo@estudiante.uam.es)
 */
public class Posada{

	/**
	 * Energia que recuperas al descansar aqui.
	 */
	private int energiaRecup;

	/**
	 * Nombre de la posada
	 */
	private String nombre;

	/**
	 * Caminos que salen de la posada
	 */
	private ArrayList<Camino> caminos;

	/**
	 * Constructor de clase con energia recuperada fijo, 2
	 * 
	 * @param nombre de la nueva posada
	 */
	public Posada(String nombre){

		this.nombre = nombre;
		this.energiaRecup = 2;
		this.caminos = new ArrayList<Camino>();
	}

	/**
	 * Constructor de clase con energia recuperada variable
	 * 
	 * @param nombre de la nueva posada
	 * @param energia que recupera la posada
	 */
	public Posada(String nombre, int energia){
		
		this.nombre = nombre;
		this.energiaRecup = energia;
		this.caminos = new ArrayList<Camino>();
	}

	/**
	 * Getter de la energia recuperada
	 * 
	 * @return la energia recuperada
	 */
	public int getEnergia(){
		return this.energiaRecup;
	}


	/**
	 * Getter del nombre de la posada
	 * 
	 * @return nombre de la posada
	 */
	public String getNombre(){
		return this.nombre;
	}

	/**
	 * Getter del camino iesimo
	 * 
	 * @param i numero del camino
	 * 
	 * @return Camino iesimo
	 */
	public Camino getCamino(int i){
		return this.caminos.get(i);
	}

	/**
	 * Getter del camino con destino destino
	 * 
	 * @param destino Posada al final del camino a buscar
	 * 
	 * @return camino
	 */
	public Camino getCamino(Posada destino){
	
		for(Camino camino : this.caminos){
			if(camino.getDestino() == destino)
				return camino;
		}

		return null;
	}

	/**
	 * Numero de caminos desde esta posada
	 * 
	 * @return numero de caminos
	 */
	public int getNumCaminos(){
		return caminos.size();
	}

	public String toString(){
		return this.nombre + "(" + this.energiaRecup + ") " + this.caminos;
	}
	
	/**
	 * Añade un camino a la posada
	 * 
	 * @param newCamino camino nuevo
	 * 
	 * @return false si hay algun error
	 */
	public Boolean addCamino(Camino newCamino){

		if( newCamino.getOrigen() != this)
			return false;

		this.caminos.add(newCamino);
		return true;
	}
}