package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				// Crea un nuovo JAVA Bean Corso
				Corso c = new Corso (rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd")) ;
	
				// Aggiungi il nuovo Corso alla lista
				corsi.add(c);
			}

			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db get tutti i corsi");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		String sql = "SELECT codins, crediti, nome, pd "+ 
				"FROM corso "+
				"WHERE codins=?" ;
		
		Corso result = null ;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1,corso.getCodice());
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				corso.setNumCrediti(rs.getInt("crediti"));
				corso.setNomeCorso(rs.getString("nome"));
				corso.setPeriodo(rs.getInt("pd"));
			}
			conn.close();
		}
		
		 catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db get corso");
		 }
	}
	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public void getStudentiIscrittiAlCorso(Corso corso) {
		 String sql = "SELECT matricola "+
							"FROM iscrizione "+
							"WHERE codins = ?" ;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1,corso.getCodice());
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				corso.addStudente(rs.getInt("matricola")) ;
				
			}
			 
		conn.close();
	}
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db get tudenti iscritti");
	 }

		}

	/*
	 * Data una matricola ed il codice insegnamento,
	 * iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		
		return false;
	}
}
