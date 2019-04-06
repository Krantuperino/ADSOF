package es.uam.eps.ads.p4.Exceptions;

public class RecomendacionInvalida extends Exception {

	private static long serialVersionUID;			//he quitado el "final" de este atributo

	public RecomendacionInvalida(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		if(this.id == 1)
			return "Invalid User (" + this.id + ")";
		else
			return "Recommendation lenght 0 or less (" + this.id +")";
	}
}