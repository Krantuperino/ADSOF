import java.util.SortedSet;
import java.util.TreeSet;

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
	
	public String toString(){
		return "Primos hasta " + max + ": " + primos;
	}
	
	public boolean esPrimo(int n){
		if (n<2) 
			return false;
		if (n > max) 
			actualizaPrimos(n);
		
		return primos.contains(n);
	}

	private boolean compruebaPrimo(int n) {
		for (int p:primos) {
			if(n%p == 0)
				return false;
		}

		return true;
	}

	private void  actualizaPrimos(int n) {
		for (int i = max + 1; i<=n ; i++){
			if(compruebaPrimo(i) == true){
				primos.add(i);
				max = i;
			}
		}
	}

	private SortedSet<Integer> divisoresPrimos(int n) {
		
		SortedSet<Integer> divisores = new TreeSet<>();

		for(int p:primos){
			if(n%p == 0) {
				divisores.add(p);
			}
		}

		return divisores;
	}

	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println("Necesita un numero para comprobar si es primo");
			return;
		}

		Primos c = new Primos();

		if(c.esPrimo(Integer.parseInt(args[0])) == true)
			System.out.println("El numero "+ args[0] + " es primo");
		else
			System.out.println("El numero "+ args[0] + " no es primo");

		System.out.println(c);
		if(c.esPrimo(Integer.parseInt(args[0])) == false){
			System.out.println("Divisores de "+ args[0] +  ": " + c.divisoresPrimos(Integer.parseInt(args[0])));
		}

		return;
	}
}