package servis;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import bazaPodataka.BazaHandler;
import modeli.Karta;
import modeli.Kupac;

public class Core {

	public static HashMap<String, String> ucitajVremeIDestinacije() throws IOException {

		HashMap<String, String> mapa = new HashMap<String, String>();
		List<String> vreme = BazaHandler.ucitajVreme();
		List<String> destinacija = BazaHandler.ucitajDestinacije();
		for (int i = 0; i < vreme.size(); i++) {
			if (i < destinacija.size()) {
				String vremeCurrent = vreme.get(i);
				String destinacijaCurrent = destinacija.get(i);

				mapa.put(destinacijaCurrent, vremeCurrent);
			}
		}
		System.out.println("Key set-> " + mapa.keySet());
		System.out.println("Value set-> " + mapa.values());

		return mapa;

	}

	public static void login() throws IOException {
		HashMap<String, String> mapa = ucitajVremeIDestinacije();
		Scanner sc = new Scanner(System.in);
		Kupac kupac = new Kupac();
		System.out.println("Dobrodosli! Unesite vase ime:");
		String ime = sc.nextLine();
		// password treba da ima vise od 6 karaktera i barem jedan broj
		System.out.println("Unesite vas username: ");
		String username = sc.nextLine();
		System.out.println("Unesite vasu lozinku: ");
		String lozinka = sc.nextLine();
		while (lozinka.length() < 6 || lozinka.matches(".*\\d.*") == false) {
			System.out.println("*Lozinka mora imati bar 6 karaktera i bar jedan broj*");
			lozinka = sc.nextLine();
		}
		kupac.setIme(ime);
		kupac.setPassword(lozinka);
		kupac.setUsername(username);

		System.out.println("Uspesna registracija! Unesite vas username da biste se ulogovali: ");

		username = sc.nextLine();
		while (!username.equalsIgnoreCase(kupac.getUsername())) {
			System.out.println("Username nepostoji. Unesite ponovo vas username: ");
			username = sc.nextLine();
		}
		System.out.println("Unesite vasu lozinku: ");
		lozinka = sc.nextLine();
		while (!lozinka.equals(kupac.getPassword())) {
			System.out.println("Pogresna lozinka. Unesite ponovo vasu lozinku: ");
			lozinka = sc.nextLine();
		}

		System.out.println("Dobro dosli u terminal AirMargite. Dostupni su Vam sledeci letovi: ");
		int counter = 1;
		for (String str : mapa.keySet()) {

			System.out.println(counter + ") " + str + " - " + mapa.get(str));
			counter++;
		}
		System.out.println("Izaberite kartu koju zelite da kupite unosom ID-a:");
		List<Karta> karte = new ArrayList<Karta>();
		Karta karta = new Karta();
		karta.setBrojSedista(22);
		karta.setCena(150);
		karta.setDestinacija("Beograd");

		karta.setId(3);
		karta.setVreme(LocalDateTime.now());
		karte.add(karta);
		Karta karta2 = new Karta();
		karta2.setBrojSedista(12);
		karta2.setCena(190);
		karta2.setId(5);
		karta2.setVreme(LocalDateTime.now());
		karta2.setDestinacija("Barselona");
		karte.add(karta2);
		for (Karta k : karte) {
			System.out.println(k.getId() + ") " + k.getDestinacija() + " - " + k.getCena() + " eur.");
		}
		Optional<Karta> nadjenaKartaOpt = null;
		while (nadjenaKartaOpt == null || nadjenaKartaOpt.isEmpty()) {
			int kartaUnos = sc.nextInt();
			nadjenaKartaOpt = karte.stream().filter(k -> k.getId() == kartaUnos).findFirst();
		}

		System.out.println("Uspesno ste kupili kartu. Vas polazak je u " + nadjenaKartaOpt.get().getVreme());
		nadjenaKartaOpt.get().setKupac(kupac);

	}

	public static void main(String[] args) throws IOException {
		login();
	}
}