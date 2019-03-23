package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.polito.tdp.alien.model.AlienModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

	private AlienModel model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtWord;

	@FXML
	private Button btnTranslate;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	void doReset(ActionEvent event) {
		txtWord.clear();
		txtResult.clear();
		model.reset();
	}

	@FXML
	void handleTranslate(ActionEvent event) {

		String s = txtWord.getText();
		String[] words = s.split(" ");

		if (!model.testoValido(s)) {
			txtResult.appendText("Testo non valido\n");
			txtWord.clear();
		} else {
			String res = model.AnalisiTesto(words);
			if (res == null) {
				txtResult.appendText("Parola non presente nel dizionario \n");
				txtWord.clear();
			} else if (res == words[0]) {
				txtResult.appendText("Parola inserita nel dizionario \n");
				txtWord.clear();
			} else {
				txtResult.appendText(res + "\n");
				txtWord.clear();
			}
		}

	}

	@FXML
	void initialize() {
		assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

	}

	public AlienModel getModel() {
		return model;
	}

	public void setModel(AlienModel model) {
		this.model = model;
	}
}
