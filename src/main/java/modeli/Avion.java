package modeli;

public class Avion {

	private String ime;
	private int brojSedista;
	
	
	
	public Avion(String ime, int brojSedista) {
		super();
		this.ime = ime;
		this.brojSedista = brojSedista;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public int getBrojSedista() {
		return brojSedista;
	}
	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}

	
}
