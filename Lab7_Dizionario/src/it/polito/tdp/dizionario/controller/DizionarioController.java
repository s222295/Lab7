package it.polito.tdp.dizionario.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;

import it.polito.tdp.dizionario.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioController {
	
	private Model model;
	String testo="";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNumLettere;

    @FXML
    private TextField txtParolaDaCercare;

    @FXML
    private Button btnGeneraGrafo;

    @FXML
    private Button btnTrovaVicini;

    @FXML
    private Button btnTrovaConnessi;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnReset;

    public void setModel(Model model) {
		this.model=model;
	}
    
    @FXML
    void doGeneraGrafo(ActionEvent event) {
    	int n = Integer.parseInt(txtNumLettere.getText()) ;
    	model.creaGrafo(n); 	
    }

    @FXML
    void doReset(ActionEvent event) {
    	model=new Model();
    	txtArea.clear();
    	txtParolaDaCercare.clear();
    	txtNumLettere.clear();
    	testo="";
    }

    
    
    @FXML
    void doTrovaConnessi(ActionEvent event) {
    	Set<String> vertici = new HashSet<String>();
    	String parola = txtParolaDaCercare.getText();
    	vertici.addAll(model.verticiConnessi(parola));

    	testo += "\nTutti i nodi connessi sono: "+vertici.toString();
    	txtArea.setText(testo);
    	
    }

    @FXML
    void doTrovaVicini(ActionEvent event) {

    	Set<String> vertici = new HashSet<String>();
    	String parola = txtParolaDaCercare.getText();
    	vertici.addAll(model.verticiVicini(parola));

    	testo += "\nTutti i nodi vicini sono: "+vertici.toString();
    	txtArea.setText(testo);
    }

    @FXML
    void initialize() {
        assert txtNumLettere != null : "fx:id=\"txtNumLettere\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert txtParolaDaCercare != null : "fx:id=\"txtParolaDaCercare\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnGeneraGrafo != null : "fx:id=\"btnGeneraGrafo\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnTrovaVicini != null : "fx:id=\"btnTrovaVicini\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnTrovaConnessi != null : "fx:id=\"btnTrovaConnessi\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Dizionario.fxml'.";

    }

	
}

