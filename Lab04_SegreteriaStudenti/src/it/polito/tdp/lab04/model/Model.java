package it.polito.tdp.lab04.model;

import java.util.*;
import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	private List<Corso> corsi = new LinkedList <Corso> () ;
	private CorsoDAO cd = new CorsoDAO() ;
	private StudenteDAO sd = new StudenteDAO() ;
	
	public List<Corso> addCorsi(){
		corsi=cd.getTuttiICorsi() ;
		return corsi ;
	}
	
	public Studente cercaStudente(int m){
		List<Studente> studenti =sd.getTuttiGliStudenti() ;
		Studente s = null;
		for(Studente st : studenti){
			if(st.getMatricola()==m){
				s=st;
			}
		}
		if(s!=null)
			sd.getStudente(s);
		return s;
		
	}
	
	public List <Studente> cercaIscritti(Corso c){
		cd.getStudentiIscrittiAlCorso(c);
		List<Studente> result = new LinkedList<Studente> () ;
		for(Integer matricola : c.getIscritti()){
			result.add(this.cercaStudente(matricola));
		}
		return result;
}

	public List<Corso> corsiFrequentati(Studente s) {
		sd.getCorsi(s);
		List<Corso> result = new LinkedList<Corso> ();
		for(String st : s.getFrequentati()){
			Corso c = new Corso(st, 0, null, 0);
			cd.getCorso(c);
			result.add(c);
		}
		return result;
	}
}
