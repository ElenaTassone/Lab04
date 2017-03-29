package it.polito.tdp.lab04.model;

import java.util.*;
public class Corso {
	
	private String codCorso;
	private int numCrediti;
	private String nomeCorso;
	private int periodo;
	
	private List <Integer> iscritti = new LinkedList<Integer> ();
	
	public Corso(String codCorso, int numCrediti, String nomeCorso, int periodo) {
		super();
		this.codCorso = codCorso;
		this.numCrediti = numCrediti;
		this.nomeCorso = nomeCorso;
		this.periodo = periodo;
	}

	public void addStudente (int m){
		if(!iscritti.contains(m)){
			iscritti.add(m);
		}
	}
	
	

	public List<Integer> getIscritti() {
		return iscritti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCorso == null) ? 0 : codCorso.hashCode());
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
		Corso other = (Corso) obj;
		if (codCorso == null) {
			if (other.codCorso != null)
				return false;
		} else if (!codCorso.equals(other.codCorso))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return nomeCorso;
	}
	
	public String getCodice(){
		return codCorso;
	}



	public String getCodCorso() {
		return codCorso;
	}



	public void setCodCorso(String codCorso) {
		this.codCorso = codCorso;
	}



	public void setNumCrediti(int numCrediti) {
		this.numCrediti = numCrediti;
	}



	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}



	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	

	public String toString2(){
		return codCorso+" "+nomeCorso;
	}
}
