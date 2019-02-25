package es.uam.eps.ads.p3;

import es.uam.ads.p3.Camino;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

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
     * @param String nombre de la nueva posada
     */
    public Posada(String nombre){

        this.nombre = nombre;
        this.energiaRecup = 2;
        this.caminos = new ArrayList<Camino>();
    }

    /**
     * Constructor de clase con energia recuperada variable
     * 
     * @param String nombre de la nueva posada
     * @param int 
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
     * Numero de caminos desde esta posada
     * 
     * @return numero de caminos
     */
    public int getNumCaminos(){
        return caminos.size();
    }

    public toString(){
        return this.nombre + "(" + this.energiaRecup + ") " + this.caminos;
    }
    
    /**
     * Añade un camino a la posada
     * 
     * @param newCamino camino
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