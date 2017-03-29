package it.polito.tdp.lab04.model;

import java.util.*;

public class Studente {
	
	private int matricola;
	private String nomeS;
	private String cognomeS;
	private String cds;
	
	List <String> corsiFrequentati = new ArrayList <String> () ;
	

	public Studente(int matricola, String nomeS, String cognomeS, String cds) {
		super();
		this.matricola = matricola;
		this.nomeS = nomeS;
		this.cognomeS = cognomeS;
		this.cds = cds;
	}

	public int getMatricola(){
		return matricola;
	}
	public String getNomeS() {
		return nomeS;
	}

	public String getCognomeS() {
		return cognomeS;
	}

	

	public void setNomeS(String nomeS) {
		this.nomeS = nomeS;
	}

	public void setCognomeS(String cognomeS) {
		this.cognomeS = cognomeS;
	}

	public void setCds(String cds) {
		this.cds = cds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricola;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (matricola != other.matricola)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return matricola+" "+nomeS + " " + cognomeS + " " + cds ;
	}
	
	public void addCorsi(String c){
		if(!corsiFrequentati.contains(c)){
			corsiFrequentati.add(c);
		}
	}
	
	public List<String> getFrequentati(){
		return corsiFrequentati;
	}
	
	
}
