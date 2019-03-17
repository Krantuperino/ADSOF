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
	 * Nuestros intrépidos aventureros
	 */
	private ArrayList<Explorador> exploradores;

	/**
	 * Constructor de simulacion, los ficheros deben estar en la carpeta input
	 * 
	 * @param camino archivo con caminos
	 * @param posad archivo con posadas
	 * @param explor archivo con el explorador y el camino a recorrer
	 * 
	 * @throws IOException in reading files
	 */
	public Simulacion(String posad, String camino, String explor)throws IOException{

		this.fileCaminos = "es/uam/eps/ads/p3/input/" + camino;
		this.filePosadas = "es/uam/eps/ads/p3/input/" + posad;
		this.fileExplorador = "es/uam/eps/ads/p3/input/" + explor;

		this.posadas = new ArrayList<Posada>();
		this.exploradores = new ArrayList<Explorador>();
		this.readPosadas();

		this.readCaminos();
		this.readExplorer();

	}

	/**
	 * Lee el archivo de posadas y añade todas al arraylist posadas
	 * 
	 * @throws IOException in reading files
	 */
	public void readPosadas()throws IOException{

		FileReader fr = new FileReader(this.filePosadas);
		BufferedReader br = new BufferedReader(fr);
		String sCurrentLine = null;
		Posada.LightLevel light;
	
		while((sCurrentLine = br.readLine()) != null){
		
			String[] array = sCurrentLine.split(" ");
			int energy = Integer.parseInt(array[1]);

			if(array.length > 2){
				switch(array[2]){
					case "DIABOLICA":
						light = Posada.LightLevel.DIABOLICA;
						break;
					case "NEGRA":
						light = Posada.LightLevel.NEGRA;
						break;
					case "TENEBROSA":
						light = Posada.LightLevel.TENEBROSA;
						break;
					case "GRIS":
						light = Posada.LightLevel.GRIS;
						break;
					case "CLARA":
						light = Posada.LightLevel.CLARA;
						break;
					case "BLANCA":
						light = Posada.LightLevel.BLANCA;
						break;
					case "DIVINA":
						light = Posada.LightLevel.DIVINA;
						break;
					default:
						System.out.println("No es un nivel de luz aceptable. Colocando en BLANCA");
						light = Posada.LightLevel.BLANCA;
				}

				this.posadas.add(new Posada(array[0], energy, light));
			}
			else
				this.posadas.add(new Posada(array[0], energy));
		}

		br.close();		
		fr.close();
	}

	/**
	 * Recoge una posada del arraylist de posadas por su nombre
	 * 
	 * @param name nombre de la posada
	 * @return posada in reading files
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
	 * 
	 * @throws IOException in reading files
	 */
	public void readCaminos()throws IOException{
		FileReader fr = new FileReader(this.fileCaminos);
		BufferedReader br = new BufferedReader(fr);
		String sCurrentLine;
		Posada origen;
		Posada destino;
	
		while((sCurrentLine = br.readLine()) != null){

			String[] array = sCurrentLine.split(" ");
			int coste = Integer.parseInt(array[2]);

			origen = this.getPosada(array[0]);
			destino = this.getPosada(array[1]);

			if(array.length == 5){
				float costeExtra = Float.parseFloat(array[3]);
				float returnProb = Float.parseFloat(array[4]);

				origen.addCamino(new Trampa(origen, destino, coste, costeExtra, returnProb));
			}
			else
				origen.addCamino(new Camino(origen, destino, coste));

		}
		
		br.close();
		fr.close();
	}

	/**
	 * Getter para un explorador dado su nombre
	 * 
	 * @param name del explorador
	 * @return Explorador
	 */
	private Explorador getExplorador(String name){
		
		for(Explorador explorador : this.exploradores){
			if(explorador.getNombre().equals(name))
				return explorador;
		}

		return null;
	}

	/**
	 * Lee el fichero de exploradores, los inicializa y recorre sus caminos
	 * 
	 * @throws IOException in reading files
	 */
	public void readExplorer()throws IOException{

		FileReader fr = new FileReader(this.fileExplorador);
		BufferedReader br = new BufferedReader(fr);
		String sCurrentLine;

		while((sCurrentLine = br.readLine()) != null){
			String[] array = sCurrentLine.split(" ");

			if(array.length > 2){
				
				int energia = Integer.parseInt(array[1]);
				Posada start = this.getPosada(array[2]);
				if(array.length == 5){
					int power = Integer.parseInt(array[4]);
					switch(array[3]){
						case "HECHICERO":
							Hechicero y = new Hechicero(array[0], energia, start, power);
							this.exploradores.add(y);
							break;
						case "HADA":
							Hada x = new Hada(array[0], energia, start, power);
							this.exploradores.add(x);
							break;
						default:
							System.out.println("No es un mago valido, creando explorador normal");
							this.exploradores.add(new Explorador(array[0], energia, start));
					}
				}
				else
					this.exploradores.add(new Explorador(array[0], energia, start));
			}
			else{

				Explorador explorador = getExplorador(array[0]);
				if(explorador == null){
					System.out.println("Explorer doesnt exist");
					return;
				}
				Posada posada = this.getPosada(array[1]);
				Camino camino = explorador.getLugar().getCamino(posada);

				if(camino != null && explorador.recorre(camino)){
					System.out.println(explorador);
				}
				else{
					System.out.println(explorador.getNombre() + " no puede llegar ahi");
				}
			}
		}

		br.close();
		fr.close();
	}

}