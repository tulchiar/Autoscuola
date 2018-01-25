package it.tulchiar.autoscuola.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import it.tulchiar.autoscuola.Common;

public class DB_common {

	public static final String dataVisualizzata = "dd/MM/yyyy";
	public static final String dataScritturaDb = "yyyy-MM-dd";
	
	/**
	 * DateTimeFormatter formatter da utilizzare epr impostare correttamente le date
	 */
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dataVisualizzata);
	public static DateTimeFormatter formatterDB = DateTimeFormatter.ofPattern(dataScritturaDb);

	
	private static String getConnectionString() {
		String dbConnectionStringBuild = "";
		String dbConnectionStringDev = "";
		
		if(it.tulchiar.autoscuola.Common.isDevelopmentEnvironment()) {
			dbConnectionStringDev = Common.dbConnectionStringDev;
			return dbConnectionStringDev;
		} else {
			dbConnectionStringBuild = Common.dbConnectionStringBuild;
			return dbConnectionStringBuild;
		}
	}
	
	/**
	 * Crea la connessione e la restituisce, in caso di errore restituisce null
	 * @return la connessione se stabilità, null in caso di errore.
	 */
	public static Connection getConnection() {
		
		String dbConnectionString = getConnectionString();
		
		try {
			Connection conn = DriverManager.getConnection(dbConnectionString);	
			return conn;
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR, "Errore di connessione con il database, verificare la connessione alla rete"
					+ "e  che il server database sia avviato."
					+ "Connection String: " + dbConnectionString, ButtonType.OK);
			alert.show();
			e.printStackTrace();
		}
		return null;
	}
}
