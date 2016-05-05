package clase;

import java.io.Serializable;

public class Utilaj implements Runnable,Serializable{
	
	private int nr;
	private double pret;
	private String denumire;
	
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public double getPret() {
		return pret;
	}
	public void setPret(float pret) {
		this.pret = pret;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	@Override
	public String toString() {
		return "Utilaj [nr=" + nr + ", pret=" + pret + ", denumire=" + denumire + "]";
	}	
	public Utilaj(int nr, float pret, String denumire) {
		super();
		this.nr = nr;
		this.pret = pret;
		this.denumire = denumire;
	}
	public Utilaj() {
		super();
		this.nr = 3;
		this.pret = 2568.66;
		this.denumire = "motostivuitor";
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		display();
	}
	
	public void display(){
		for(int i=0;i<nr;i++){System.out.println(denumire+" "+ i);
				try {
				Thread.sleep(10);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			}
	}
	
	
	

}
