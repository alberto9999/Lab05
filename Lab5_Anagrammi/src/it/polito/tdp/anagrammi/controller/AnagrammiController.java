package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserisci;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtAreaCorretti;

    @FXML
    private TextArea txtAreaErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	String parola= txtInserisci.getText();
    	model.risolvi(parola);
    	txtAreaCorretti.setText(model.getAnagrammiCorretti());
    	txtAreaErrati.setText(model.getAnagrammiErrati());
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInserisci.setText("");
    	txtAreaCorretti.setText("");
    	txtAreaErrati.setText("");
    }

    
    @FXML
    void initialize() {
        assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAreaCorretti != null : "fx:id=\"txtAreaCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAreaErrati != null : "fx:id=\"txtAreaErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(Model model) {
		this.model= model;
		
	}
}