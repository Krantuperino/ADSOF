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
	 * Exploradores actualmente en esta posada
	 */
	private ArrayList<Explorador> huespedes;
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
		this.huespedes = new ArrayList<Explorador>();
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

	/**
	 * Setter para la luz
	 * 
	 * @param light nuevo nivel de luz
	 */
	public void cambiarLuz(LightLevel light){
		this.light = light;
	}

	/**
	 * E Llama a la puerta y si necesita subir o bajar el nivel de luz la posada
	 * lo sube o lo baja un solo nivel
	 * 
	 * @param e explorador que llama
	 */
	public void llamar(Explorador e){

		switch(e.tipoDeMago()){
			case "HECHICERO":
				if(this.light.ordinal() >= LightLevel.GRIS.ordinal())
					this.light = LightLevel.values()[this.light.ordinal() - 1];
				break;
			case "HADA":
				if(this.light.ordinal() <= LightLevel.GRIS.ordinal())
					this.light = LightLevel.values()[this.light.ordinal() + 1];
				break;
			default:
				break;
		}
	}

	/**
	 * Añade a la lista de huespedes al explorador E
	 * 
	 * @param e que va a la posada
	 */
	public void bookIn(Explorador e){
		this.huespedes.add(e);
	}

	/**
	 * El explorador e sale de la lista de huespedes
	 * 
	 * @param e que sale de la posada
	 */
	public void bookOut(Explorador e){
		this.huespedes.remove(e);
	}
}