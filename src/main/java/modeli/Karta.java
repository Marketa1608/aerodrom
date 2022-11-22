package modeli;

import java.time.LocalDateTime;

public class Karta {
	
	private long id;
	private int brojSedista;
	private int cena;
	private Kupac kupac;
	private LocalDateTime vreme;
	private String destinacija;
	
	
	public String getDestinacija() {
		return destinacija;
	}
	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getBrojSedista() {
		return brojSedista;
	}
	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public Kupac getKupac() {
		return kupac;
	}
	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}
	public LocalDateTime getVreme() {
		return vreme;
	}
	public void setVreme(LocalDateTime vreme) {
		this.vreme = vreme;
	}
	

}
