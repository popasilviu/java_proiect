package clase;

import abstract_interface.IAngajat;

public class Angajat extends Echipa implements IAngajat  {
	
	private String nume;
	private String prenume;
	private double salariu;
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public double getSalariu() {
		return salariu;
	}
	public void setSalariu(double salariu) {
		this.salariu = salariu;
	}
	
	
	@Override
	public String toString() {
		return "Angajat [nume=" + nume + ", prenume=" + prenume + ", salariu=" + salariu + "]";
	}
	
	public Angajat(String nume, String prenume, double salariu) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.salariu = salariu;
	}
	public Angajat() {
		super();
		this.nume = "Popescu";
		this.prenume = "Ion";
		this.salariu = 1750;
	}
	@Override
	public void modificaSalariu(double salariu) {
		// TODO Auto-generated method stub
		this.salariu=this.salariu+salariu;
	}

}
