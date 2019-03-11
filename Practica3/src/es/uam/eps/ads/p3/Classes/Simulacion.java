package es.uam.eps.ads.p3.Classes;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Clase que inicializa las posadas, los caminos y al explorador y ejecuta la funcion recorre
 * 
 * @author Juan Martin (juan.martinp@estudiante.uam.es) y 
 * Pablo Sanchez (pablo.sanchezredondo@estudiante.uam.es)
 */

public class Simulacion{

	/**
	 * Nombre del archivo que contiene los caminos
	 */
	private String fileCaminos;

	/**
	 * Nombre del archivo que contiene las posadas
	 */
	private String filePosadas;

	/**
	 * Array de posadas
	 */
	private ArrayList<Posada>posadas;

	/**
	 * Nombre del archivo que contiene al explorador y los pueblos a recorrer
	 */
	private String fileExplorador;

	/**
	 * Nuestro intrépido aventurero
	 */
	private Explorador explorador;

	/**
	 * Constructor de simulacion, los ficheros deben estar en la carpeta input
	 * 
	 * @param camino archivo con caminos
	 * @param posad archivo con posadas
	 * @param explor archivo con el explorador y el camino a recorrer
	 */
	public Simulacion(String posad, String camino, String explor)throws IOException{

		this.fileCaminos = "es/uam/eps/ads/p3/input/" + camino;
		this.filePosadas = "es/uam/eps/ads/p3/input/" + posad;
		this.fileExplorador = "es/uam/eps/ads/p3/input/" + explor;

		this.posadas = new ArrayList<Posada>();
		this.readPosadas();

		this.readCaminos();
		this.readExplorer();

	}

	/**
	 * Lee el archivo de posadas y añade todas al arraylist posadas
	 */
	public void readPosadas()throws IOException{

		FileReader fr = new FileReader(this.filePosadas);
		BufferedReader br = new BufferedReader(fr);
		String sCurrentLine = null;
	
		while((sCurrentLine = br.readLine()) != null){
		
			String[] array = sCurrentLine.split(" ");
			int energy = Integer.parseInt(array[1]);
	
			this.posadas.add(new Posada(array[0], energy));
		}

		if(br != null)
			br.close();
		
		if(fr != null)
			fr.close();
	}

	/**
	 * Recoge una posada del arraylist de posadas por su nombre
	 * 
	 * @param name nombre de la posada
	 * @return posada
	 */
	private Posada getPosada(String name){

		for(Posada posad : this.posadas){
			if(posad.getNombre().equals(name)){
				return posad;
			}
		}

		return null;
	}

	/**
	 * Lee el archivo de caminos y crea y los añade a sus respectivas posadas
	 */
	public void readCaminos()throws IOException{
		FileReader fr = new FileReader(this.fileCaminos);
		BufferedReader br = new BufferedReader(fr);
		String sCurrentLine;
		Posada origen;
		Posada destino;
	
		while((sCurrentLine = br.readLine()) != null){

			String[] array = sCurrentLine.split(" ", 3);
			int coste = Integer.parseInt(array[2]);

			origen = this.getPosada(array[0]);
			destino = this.getPosada(array[1]);
			
			Camino camino = new Camino(origen, destino, coste);

			origen.addCamino(camino);

		}
		
		if(br != null)
			br.close();
		
		if(fr != null)
			fr.close();
	}

	public void readExplorer()throws IOException{

		FileReader fr = new FileReader(this.fileExplorador);
		BufferedReader br = new BufferedReader(fr);
		String sCurrentLine;

		sCurrentLine = br.readLine();
		String[] array = sCurrentLine.split(" ", 3);
		int energia = Integer.parseInt(array[1]);
		Posada start = this.getPosada(array[2]);

		this.explorador = new Explorador(array[0], energia, start);

		while((sCurrentLine = br.readLine()) != null){
			Posada posada = this.getPosada(sCurrentLine);
			Camino camino = this.explorador.getLugar().getCamino(posada);

			if(this.explorador.recorre(camino)){
				System.out.println(explorador);
			}
			else{
				System.out.println("Could not move");
			}
		}

		if(br != null)
		br.close();
	
		if(fr != null)
		fr.close();
	}

}