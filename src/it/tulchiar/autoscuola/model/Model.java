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
		
		/**
		 * Aggiunge un nuovo cliente al database, richiede tutti i campi tranne 'dataInvioLettera'
		 * @param cliente l'oggetto Cliente da inserire nel databse
		 * @return True se l'inserimento è andato a buon fine, False se fallito
		 */
		public boolean add(Cliente cliente) {
			return dao.add(cliente);
		}

		/**
		 * Modifica i dati del cliente nel database, richiede tutti i campi tranne 'dataInvioLettera'
		 * @param cliente l'oggetto Cliente da inserire nel databse
		 * @return True se la modifica è andata a buon fine, False se fallita
		 */
		public boolean update(Cliente cliente) {
			return dao.update(cliente);
		}
		
		
		/**
		 * Cancella logicamente un cliente impostando la data nel campo cancellato del cliente
		 * @param cliente il cliente da cancellare
		 * @return true se la data di cancellazione è stata impostata correttamente, false se
		 * qualcosa è andato storto
		 */
		public boolean delete(Cliente cliente) {
			return dao.delete(cliente);
		}

}
