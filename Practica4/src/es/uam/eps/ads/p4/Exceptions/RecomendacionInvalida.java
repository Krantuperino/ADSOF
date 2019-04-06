package es.uam.eps.ads.p4.Exceptions;

public class RecomendacionInvalida extends Exception {

	private static long serialVersionUID;			//he quitado el "final" de este atributo

	public RecomendacionInvalida(long id) {
		serialVersionUID = id;
	}

	@Override
	public String toString() {
		if(serialVersionUID == 1)
			return "Invalid User (" + serialVersionUID + ")";
		else
			return "Recommendation lenght 0 or less (" + serialVersionUID +")";
	}
}