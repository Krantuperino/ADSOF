import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Este programa crea una lista de primos desde 2 hasta el número dado y una lista con los
 * divisores del mismo si éste no es primo.
 * 
 * @author Juan Martin y Pablo Sánchez
 */

public class Primos {
	// usamos un conjunto ordenado, que implementa TreeSet
	private SortedSet<Integer> primos = new TreeSet<>();
	private int max = 1;
	
	/**
	*
	* @return cache con los primos calculados
	*/
	public SortedSet<Integer> getPrimos(){
		return primos;
	}
	
	/**
	 * @return Cadena con los primos
	 */
	public String toString(){
		return "Primos hasta " + max + ": " + primos;
	}
	
	/**
	 * Metodo para comprobar si n está en la lista de primos 
	 * 
	 * @param n número a comprobar
	 * 
	 * @return true si está en la lista o false en caso contrario
	 */
	public boolean esPrimo(int n){
		if (n<2) 
			return false;
		if (n > max) 
			actualizaPrimos(n);
		
		return primos.contains(n);
	}

	/**
	 * Metodo para comprobar si n es primo
	 * 
	 * @param n Numero a comprobar
	 * 
	 * @return true si es primo o false en caso contrario
	 */
	private boolean compruebaPrimo(int n) {
		for (int p:primos) {
			if(n%p == 0)
				return false;
		}

		return true;
	}

	/**
	 * Metodo para añadir todos los números primos de max+1 hasta n a la lista de primos
	 * 
	 * @param n Limite superior de la funcion
	 */
	private void  actualizaPrimos(int n) {
		for (int i = max + 1; i<=n ; i++){
			if(compruebaPrimo(i)){
				primos.add(i);
				max = i;
			}
		}
	}

	/**
	 * Metodo que crea una lista con los divisores de n
	 * 
	 * @param n número para escoger los divisores
	 * 
	 * @return lista con los divisores de n
	 */
	private SortedSet<Integer> divisoresPrimos(int n) {
		
		SortedSet<Integer> divisores = new TreeSet<>();

		for(int p:primos){
			if(n%p == 0) {
				divisores.add(p);
			}
		}

		return divisores;
	}

	/**
	 * Comienzo del programa
	 * 
	 * @param args Un número a comprobar si es primo o no
	 */
	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println("Necesita un numero para comprobar si es primo");
			return;
		}

		Primos c = new Primos();

		if(c.esPrimo(Integer.parseInt(args[0])))
			System.out.println("El numero "+ args[0] + " es primo");
		else
			System.out.println("El numero "+ args[0] + " no es primo");

		System.out.println(c);
		if(!c.esPrimo(Integer.parseInt(args[0]))){
			System.out.println("Divisores de "+ args[0] +  ": " + c.divisoresPrimos(Integer.parseInt(args[0])));
		}

		return;
	}
}