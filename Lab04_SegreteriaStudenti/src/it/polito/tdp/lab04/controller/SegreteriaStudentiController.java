package it.polito.tdp.lab04.controller;

import it.polito.tdp.lab04.DAO.ConnectDB;
import it.polito.tdp.lab04.DAO.CorsoDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	private Model model;
	List<Corso> corsi = new LinkedList<Corso>();

	@FXML
	private ComboBox<Corso> comboCorso;

	@FXML
	private Button btnCercaIscrittiCorso;

	@FXML
	private Button btnCercaCorsi;

	@FXML
	private Button btnCercaNome;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnIscrivi;

	@FXML
	private TextField txtMatricola;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCognome;

	public void setModel(Model model) {
		this.model = model ;
		corsi = this.model.addCorsi();
		
		for(Corso c : corsi){
			comboCorso.getItems().add(c);
		}
		comboCorso.getItems().add(null) ;
	}

	@FXML
	void doReset(ActionEvent event) {
		txtResult.clear() ;
		txtMatricola.clear() ;
		txtNome.clear() ;
		txtCognome.clear() ;
	}

	@FXML
	void doCercaNome(ActionEvent event) {
		int m = Integer.parseInt(txtMatricola.getText());
		Studente s = this.model.cercaStudente(m);
		if(s!=null){
		txtNome.setText(s.getNomeS());
		txtCognome.setText(s.getCognomeS());
		}
		else{
			txtResult.setText("Studente non esistente");}
		}
		

	@FXML
	void doCercaIscrittiCorso(ActionEvent event) {
		Corso c = comboCorso.getValue();
		if(c==null){
			txtResult.setText("nessun corso selezionato");
		}
		else{
		List<Studente> iscritti = this.model.cercaIscritti(c);
		for(Studente s : iscritti){
			txtResult.appendText(s.toString()+"\n");
			}
		}
	}

	@FXML
	void doCercaCorsi(ActionEvent event) {
		Studente s = this.model.cercaStudente(Integer.parseInt(txtMatricola.getText())) ;
		if(s==null){
			txtResult.setText("studente non trovato");
		}
		else{
		List<Corso> frequentati = this.model.corsiFrequentati(s);
		for(Corso c : frequentati){
			txtResult.appendText(c.toString()+"\n");
			}
		
		}

	}

	@FXML
	void doIscrivi(ActionEvent event) {
		Studente s =  this.model.cercaStudente(Integer.parseInt(txtMatricola.getText())) ;
		Corso c = comboCorso.getValue();
		if(c!=null && s!=null){
		List<Corso> frequentati = this.model.corsiFrequentati(s);
		if(frequentati.contains(c)){
			txtResult.setText("Studente iscritto");
			}
		}
		else{
			txtResult.setText("Studente non iscritto");
			}
		}

	@FXML
	void initialize() {
		assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

		}

}
