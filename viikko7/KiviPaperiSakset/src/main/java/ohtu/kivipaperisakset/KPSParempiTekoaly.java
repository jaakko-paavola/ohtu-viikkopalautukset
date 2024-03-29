package ohtu.kivipaperisakset;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends Pelimuoto {
	private String[] muisti;
	private int vapaaMuistiIndeksi;

	public KPSParempiTekoaly(int muistinKoko) {
		muisti = new String[muistinKoko];
		vapaaMuistiIndeksi = 0;
	}

	public void asetaSiirto(String siirto) {
		// jos muisti täyttyy, unohdetaan viimeinen alkio
		if (vapaaMuistiIndeksi == muisti.length) {
			for (int i = 1; i < muisti.length; i++) {
				muisti[i - 1] = muisti[i];
			}

			vapaaMuistiIndeksi--;
		}

		muisti[vapaaMuistiIndeksi] = siirto;
		vapaaMuistiIndeksi++;
	}

	public String annaSiirto() {
		if (vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1) {
			return "k";
		}

		String viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];

		int k = 0;
		int p = 0;
		int s = 0;

		for (int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
			if (viimeisinSiirto.equals(muisti[i])) {
				String seuraava = muisti[i + 1];

				if ("k".equals(seuraava)) {
					k++;
				} else if ("p".equals(seuraava)) {
					p++;
				} else {
					s++;
				}
			}
		}

		// Tehdään siirron valinta esimerkiksi seuraavasti;
		// - jos kiviä eniten, annetaan aina paperi
		// - jos papereita eniten, annetaan aina sakset
		// muulloin annetaan aina kivi
		if (k > p && k > s) {
			return "p";
		} else if (p > k && p > s) {
			return "s";
		} else {
			return "k";
		}

		// Tehokkaampiakin tapoja löytyy, mutta niistä lisää 
		// Johdatus Tekoälyyn kurssilla!
	}

	@Override
    protected String pelaaToinenOsapuoli(String ekanSiirto) {
            String tokanSiirto = annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
            asetaSiirto(ekanSiirto);
			return tokanSiirto;
    }
}
