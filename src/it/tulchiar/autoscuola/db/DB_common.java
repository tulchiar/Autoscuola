package it.tulchiar.autoscuola.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class DB_common {

	
	private static final String pattern = "yyyy-MM-dd";
	/**
	 * DateTimeFormatter formatter da utilizzare epr impostare correttamente le date
	 */
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
	
	private static final String DB_CONNECTION_STRING = "jdbc:mysql://localhost/autoscuola?user=root&password=Chrmrc84a15";

	/**
	 * Crea la connessione e la restituisce, in caso di errore restituisce null
	 * @return la connessione se stabilità, null in caso di errore.
	 */
	public static Connection getConnection() {
		
		try {
			Connection conn = DriverManager.getConnection(DB_CONNECTION_STRING);	
			return conn;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore di connessione con il database, verificare la connessione alla rete"
					+ "e che il server database sia avviato.");
			e.printStackTrace();
		}
		return null;
	}
}
