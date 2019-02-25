package es.uam.eps.ads.p3;

/**
 * Clase que define la persona que viaja por los caminos
 * 
 * @author Juan Martin (juan.martinp@estudiante.uam.es) y Pablo Sanchez (pablo.sanchezredondo@estudiante.uam.es)
 */
public class Explorador{

    /**
     * Nombre del explorador
     */
    private String nombre;

    /**
     * Cantidad de energia disponible
     */
    private int stamina;

    /**
     * Posada donde se encuentra el explorador
     */
    private Posada lugarActual;

    /**
     * Constructor de clase
     * 
     * @param nombre Como se llama nuestro explorador
     * @param energia Energia con la que comienza
     * @param start Desde donde comienza la aventura
     */
    public Explorador(String nombre, int energia, Posada start){
        
        this.nombre = nombre;
        this.stamina = energia;
        this.lugarActual = start;
    }

    /**
     * Nombre del explorador
     * 
     * @return como se llama
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Energia actual
     * 
     * @return stamina
     */
    public int getStamina(){
        return this.stamina;
    }

    /**
     * Donde se encuentra el explorador
     * 
     * @return Posada
     */
    public Posada getLugar(){
        return this.lugarActual;
    }

    public String toString(){
        return this.nombre + " (e:" + this.stamina + ") en " + this.lugarActual.getNombre();
    }
}