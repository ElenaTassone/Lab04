package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public List<Studente> getTuttiGliStudenti() {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				// Crea un nuovo JAVA Bean Corso
				Studente s = new Studente (rs.getInt("matricola"), rs.getString("cognome"),rs.getString("nome"), rs.getString("CDS")) ;
	
				// Aggiungi il nuovo Corso alla lista
				studenti.add(s);
			}

			return studenti;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db get tutti gli studenti");
		}
	}


	public void getStudente(Studente s) {
		String sql = "SELECT matricola, cognome, nome, CDS "+ 
				"FROM studente "+
				"WHERE matricola=?" ;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1,s.getMatricola());
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				s.setCognomeS(rs.getString("cognome"));
				s.setNomeS(rs.getString("nome"));
				s.setCds(rs.getString("CDS"));
			}
		}
		 catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db getstudente");
		 }
	}
	
	public void getCorsi(Studente s){
		 String sql = "SELECT codins "+
					"FROM iscrizione "+
					"WHERE matricola = ?" ;
		 try {
			 Connection conn = ConnectDB.getConnection();
			 PreparedStatement st = conn.prepareStatement(sql);

			 st.setInt(1,s.getMatricola());
	
			 ResultSet rs = st.executeQuery();
	
			 while (rs.next()) {
				 s.addCorsi(rs.getString("codins"));
		
				 
				 
	}
	 
conn.close();
}
catch (SQLException e) {
	 //e.printStackTrace();
	throw new RuntimeException("Errore Db get tudenti iscritti");
}

}
	}

