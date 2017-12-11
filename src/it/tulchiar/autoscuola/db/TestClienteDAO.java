package it.tulchiar.autoscuola.db;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import it.tulchiar.autoscuola.model.Cliente;

public class TestClienteDAO {
	public static void main(String[] args) {
		
		ClienteDAO dao = new ClienteDAO();
		
//		ArrayList<Cliente> clienti = dao.getAll();
//		ArrayList<Cliente> clienti = dao.search("gori");
		
		ArrayList<Cliente> clienti = dao.searchScadenza(11, 2017);
		
		if(!clienti.isEmpty()) {
			for (Cliente cliente : clienti) {
				System.out.format("[%d] %s %s - Scadenza %s - DataInvio %s\n", 
						cliente.getId(), 
						cliente.getCognome(), 
						cliente.getNome(), 
						cliente.getDataScadenza().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
						cliente.getDataInvioLettera().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			}
		}
	}
}
