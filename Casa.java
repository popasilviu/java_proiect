package clase;

import abstract_interface.ACasa;

public class Casa extends ACasa{
	
	private float suprafata;
	private double costuri;
	private int nrCamere;
	
	public float getSuprafata() {
		return suprafata;
	}

	public void setSuprafata(float suprafata) {
		this.suprafata = suprafata;
	}

	public double getCosturi() {
		return costuri;
	}

	public void setCosturi(double costuri) {
		this.costuri = costuri;
	}

	public int getNrCamere() {
		return nrCamere;
	}

	public void setNrCamere(int nrCamere) {
		this.nrCamere = nrCamere;
	}

	
	@Override
	public String toString() {
		return "Casa [suprafata=" + suprafata + ", costuri=" + costuri + ", nrCamere=" + nrCamere + "]";
	}

	
	public Casa(float suprafata, double costuri, int nrCamere) {
		super();
		this.suprafata = suprafata;
		this.costuri = costuri;
		this.nrCamere = nrCamere;
	}

	public Casa() {
		super();
		this.suprafata = 100;
		this.costuri = 10550;
		this.nrCamere = 3;
	}
	
	@Override
	public void modificaSuprafata(float suprafata, int nrCamere) {
		// TODO Auto-generated method stub
		this.suprafata=this.suprafata+suprafata;
		this.nrCamere=this.nrCamere+nrCamere;
	}

}
