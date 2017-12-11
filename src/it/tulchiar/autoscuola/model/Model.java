package it.tulchiar.autoscuola.model;

import java.util.ArrayList;

import it.tulchiar.autoscuola.db.ClienteDAO;

public class Model {
		
		ClienteDAO dao = new ClienteDAO();
		
		/**
		 * Restituisce l'intero elenco dei clienti
		 * @return un ArrayList di oggetti CLiente, in caso di errore ritorna null
		 */
		public ArrayList<Cliente> getAll() {
			return dao.getAll();
		}
		
		/**
		 * Ricerca i clienti per cognome o parte di cognome
		 * @param cognome il cognome del cliente o una parte del cognome
		 * @return ArrayList contente oggetti Cliente o null in caso di errore
		 */
		public ArrayList<Cliente> searchByCognome(String cognome) {
			return dao.search(cognome);
		}
		
		/**
		 * Ricerca i clienti che hanno le patenti in scadenza nel mese/anno indicato
		 * @param mese il mese su cui effettuare la ricerca
		 * @param anno l'anno su cui effettuare la ricerca
		 * @return un ArrayList di oggetti CLiente, ritorna null in caso di errore
		 */
		public ArrayList<Cliente> searchScadenza(int mese, int anno) {
			return dao.searchScadenza(mese, anno);
		}
}
