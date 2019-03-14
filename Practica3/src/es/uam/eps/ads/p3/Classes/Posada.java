package es.uam.eps.ads.p3.Classes;

import java.util.ArrayList;

/**
 * Clase Posada. Lugar de descanso y conexion de caminos
 * 
 * @author Juan Martin (juan.martinp@estudiante.uam.es) y Pablo Sanchez (pablo.sanchezredondo@estudiante.uam.es)Juan Martin (juan.martinp@estudiante.uam.es) y Pablo Sanchez (pablo.sanchezredondo@estudiante.uam.es)
 */
public class Posada{

	public enum LightLevel{
		DIABOLICA,
		NEGRA,
		TENEBROSA,
		GRIS,
		CLARA,
		BLANCA,
		DIVINA;
	}

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
	 * Nivel de luz
	 */
	private LightLevel light;

	/**
	 * Constructor de clase con energia recuperada fijo, 2 y luz BLANCA
	 * 
	 * @param nombre de la nueva posada
	 */
	public Posada(String nombre){

		this(nombre, 2);
	}

	/**
	 * Constructor de clase con energia recuperada variable y luz BLANCA
	 * 
	 * @param nombre de la nueva posada
	 * @param energia que recupera la posada
	 */
	public Posada(String nombre, int energia){
		this(nombre, energia, LightLevel.BLANCA);
	}

	/**
	 * Constructor de clase con energia variable y luz variable
	 * 
	 * @param nombre de la nueva posada
	 * @param energia que recupera en la posada
	 * @param light que hay en la posada
	 */
	public Posada(String nombre, int energia, LightLevel light){
		
		this.nombre = nombre;
		this.energiaRecup = energia;
		this.light = light;
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

	public LightLevel getLight(){
		return this.light;
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
		return this.nombre + "(" + this.energiaRecup + ") Luz " + this.light + " ->" + this.caminos;
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

	public void cambiarLuz(LightLevel light){
		this.light = light;
	} 
}