package clase;

public class Echipa {
	
	private int nrPersoane;

	public int getNrPersoane() {
		return nrPersoane;
	}

	public void setNrPersoane(int nrPersoane) {
		this.nrPersoane = nrPersoane;
	}

	public Echipa(int nrPersoane) {
		super();
		this.nrPersoane = nrPersoane;
	}
	
	public Echipa() {
		super();
		this.nrPersoane = 10;
	}

	@Override
	public String toString() {
		return "Echipa [nrPersoane=" + nrPersoane + "]";
	}
	
	

}
