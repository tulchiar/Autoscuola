package it.tulchiar.autoscuola.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import it.tulchiar.autoscuola.model.Cliente;

public class ClienteDAO {
	
	/**
	 * Restituisce l'intero elenco dei clienti
	 * @return un ArrayList di oggetti CLiente, in caso di errore ritorna null
	 */
	public ArrayList<Cliente> getAll() {
		
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
		
		String sql = "SELECT id, cognome, nome, indirizzo, cap, localita, provincia, tipoPatente, "
						  + "dataScadenza, telefono, cellulare, email, note, dataInvioLettera "
				   + "FROM autoscuola.clienti;";
		
		Connection conn = DB_common.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String indirizzo = rs.getString("indirizzo");
				String cap = rs.getString("cap");
				String localita = rs.getString("localita");
				String provincia = rs.getString("provincia");
				String tipoPatente = rs.getString("tipoPatente");
				LocalDate dataScadenza = rs.getDate("dataScadenza").toLocalDate();
				String telefono = rs.getString("telefono");
				String cellulare = rs.getString("cellulare");
				String email = rs.getString("email");
				String note = rs.getString("note");
				
				//TODO Sistemare data invio lettera, se è null è un problema
				LocalDate dataInvioLettera;
				if(rs.getDate("dataInvioLettera") == null) {
					dataInvioLettera = LocalDate.MIN;
				} else {
					dataInvioLettera = rs.getDate("dataInvioLettera").toLocalDate();
				}
					
				Cliente c = new Cliente(id, cognome, nome, indirizzo, cap, localita, provincia, tipoPatente, dataScadenza, telefono, cellulare, email, note, dataInvioLettera);

				clienti.add(c);
			}	

			conn.close();
			return clienti;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Ricerca i clienti per cognome 'LIKE %?%'.
	 * @param _cognome il cognome o una parte del cognome.
	 * @return ArrayList contente oggetti Cliente, in caso di errore ritorna null.
	 */
	public ArrayList<Cliente> search(String _cognome) {
		
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
		
		String sql = "SELECT id, cognome, nome, indirizzo, cap, localita, provincia, tipoPatente, "
						  + "dataScadenza, telefono, cellulare, email, note, dataInvioLettera "
				   + "FROM autoscuola.clienti "
				   + "WHERE cognome LIKE ?;";
		
		Connection conn = DB_common.getConnection();
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + _cognome + "%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String indirizzo = rs.getString("indirizzo");
				String cap = rs.getString("cap");
				String localita = rs.getString("localita");
				String provincia = rs.getString("provincia");
				String tipoPatente = rs.getString("tipoPatente");
				LocalDate dataScadenza = rs.getDate("dataScadenza").toLocalDate();
				String telefono = rs.getString("telefono");
				String cellulare = rs.getString("cellulare");
				String email = rs.getString("email");
				String note = rs.getString("note");
				
				//TODO Sistemare data invio lettera
				LocalDate dataInvioLettera;
				if(rs.getDate("dataInvioLettera") == null) {
					dataInvioLettera = LocalDate.MIN;
				} else {
					dataInvioLettera = rs.getDate("dataInvioLettera").toLocalDate();
				}
					
				Cliente c = new Cliente(id, cognome, nome, indirizzo, cap, localita, provincia, tipoPatente, dataScadenza, telefono, cellulare, email, note, dataInvioLettera);

				clienti.add(c);
			}	

			conn.close();
			return clienti;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	/**
	 * Ricerca i clienti che hanno le patenti in scadenza nel mese/anno indicato
	 * @param _mese il mese su cui effettuare la ricerca
	 * @param _anno l'anno su cui effettuare la ricerca
	 * @return un ArrayList di oggetti CLiente, ritorna null in caso di errore
	 */
	public ArrayList<Cliente> searchScadenza(int _mese, int _anno) {
		
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
				
		String sql = "SELECT id, cognome, nome, indirizzo, cap, localita, provincia, tipoPatente, "
						  + "dataScadenza, telefono, cellulare, email, note, dataInvioLettera "
				   + "FROM autoscuola.clienti "
				   + "WHERE dataScadenza  >= ?" //'20171201' 
				   + "AND dataScadenza < ?;";
		
		Connection conn = DB_common.getConnection();
		
		try {
			
			LocalDate data = LocalDate.parse(_anno+"-"+_mese+"-01");
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, data.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
			ps.setString(2, data.plusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
			
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String indirizzo = rs.getString("indirizzo");
				String cap = rs.getString("cap");
				String localita = rs.getString("localita");
				String provincia = rs.getString("provincia");
				String tipoPatente = rs.getString("tipoPatente");
				LocalDate dataScadenza = rs.getDate("dataScadenza").toLocalDate();
				String telefono = rs.getString("telefono");
				String cellulare = rs.getString("cellulare");
				String email = rs.getString("email");
				String note = rs.getString("note");
				
				//TODO Sistemare data invio lettera
				LocalDate dataInvioLettera;
				if(rs.getDate("dataInvioLettera") == null) {
					dataInvioLettera = LocalDate.MIN;
				} else {
					dataInvioLettera = rs.getDate("dataInvioLettera").toLocalDate();
				}
					
				Cliente c = new Cliente(id, cognome, nome, indirizzo, cap, localita, provincia, tipoPatente, dataScadenza, telefono, cellulare, email, note, dataInvioLettera);

				clienti.add(c);
			}	

			conn.close();
			return clienti;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "La data inserita non è valida!");
			return null;
		}
	}

	
	
public int add(Cliente cliente) {
		String sql = "INSERT INTO `autoscuola`.`clienti` (`cognome`, `nome`, `indirizzo`, `cap`, `localita`, `provincia`, `tipoPatente`, `dataScadenza`, `telefono`, `cellulare`, `email`, `note`, `dataInvioLettera`) VALUES ('a', 'c', 'd', 'd', 'd', 'd', 'f', '2012-10-21 00:00:00', 'e', 'e', 'd', 'd', '2012-10-21 00:00:00');";
				
		
//		"SELECT id, cognome, nome, indirizzo, cap, localita, provincia, tipoPatente, "
//				  + "dataScadenza, telefono, cellulare, email, note, dataInvioLettera "
//		   + "FROM autoscuola.clienti "
//		   + "WHERE dataScadenza  >= ?" //'20171201' 
//		   + "AND dataScadenza < ?;";

		Connection conn = DB_common.getConnection();

//		try {
//		
//		LocalDate data = LocalDate.parse(_anno+"-"+_mese+"-01");
//		
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, data.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
//		ps.setString(2, data.plusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
//		
//		
//		
//		ResultSet rs = ps.executeQuery();
//		
//		while(rs.next()) {
//			int id = rs.getInt("id");
//			String cognome = rs.getString("cognome");
//			String nome = rs.getString("nome");
//			String indirizzo = rs.getString("indirizzo");
//			String cap = rs.getString("cap");
//			String localita = rs.getString("localita");
//			String provincia = rs.getString("provincia");
//			String tipoPatente = rs.getString("tipoPatente");
//			LocalDate dataScadenza = rs.getDate("dataScadenza").toLocalDate();
//			String telefono = rs.getString("telefono");
//			String cellulare = rs.getString("cellulare");
//			String email = rs.getString("email");
//			String note = rs.getString("note");
//			
//			//TODO Sistemare data invio lettera
//			LocalDate dataInvioLettera;
//			if(rs.getDate("dataInvioLettera") == null) {
//				dataInvioLettera = LocalDate.MIN;
//			} else {
//				dataInvioLettera = rs.getDate("dataInvioLettera").toLocalDate();
//			}
//				
//			Cliente c = new Cliente(id, cognome, nome, indirizzo, cap, localita, provincia, tipoPatente, dataScadenza, telefono, cellulare, email, note, dataInvioLettera);
//	
//			clienti.add(c);
//		}	
//	
//		conn.close();
//		return clienti;
//		
//	} catch (SQLException e) {
//		e.printStackTrace();
//		return null;
//	} catch (DateTimeParseException e) {
//		JOptionPane.showMessageDialog(null, "La data inserita non è valida!");
//		return null;
//	}
//			
//			
			return 1;
	}

}
