/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
	Summa(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus) {
		super(tuloskentta, syotekentta, sovellus);
	}

	@Override
	public void suorita() {
		super.suorita();
		sovellus.plus(syotekentanArvo);
	}

	@Override
	public void peru() {
		super.peru();
	}	
}
