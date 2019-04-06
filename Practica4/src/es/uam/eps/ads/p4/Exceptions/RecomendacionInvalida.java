package es.uam.eps.ads.p4.Exceptions;

public class RecomendacionInvalida extends Exception {

	private static final long serialVersionUID = 3726284682L;
	private long id = 0L;

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