package it.tulchiar.autoscuola.db;

import java.time.LocalDate;

import it.tulchiar.autoscuola.Common;
import it.tulchiar.autoscuola.model.Cliente;

public class TestClienteDAO {
	public static void main(String[] args) {
		
		Common.loadProperties();
		
		ClienteDAO dao = new ClienteDAO();
		
//		ArrayList<Cliente> clienti = dao.getAll();
//		ArrayList<Cliente> clienti = dao.search("gori");
		
//		ArrayList<Cliente> clienti = dao.searchScadenza(11, 2017);
//		
//		if(!clienti.isEmpty()) {
//			for (Cliente cliente : clienti) {
//				System.out.format("[%d] %s %s - Scadenza %s - DataInvio %s\n", 
//						cliente.getId(), 
//						cliente.getCognome(), 
//						cliente.getNome(), 
//						cliente.getDataScadenza().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
//						cliente.getDataInvioLettera().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//			}
//		}
		
		Cliente c = new Cliente(1058, "Riprova DAO", "Marco");
		c.setIndirizzo("Via Guerra 15");
		c.setCap("59100");
		c.setLocalita("Prato");
		c.setProvincia("PO");
		c.setCellulare("349 0773441");
		c.setEmail("tulchiar@gmail.com");
		c.setNote("Annotazione inserita per appuntare qualcosa \nrelativo al cliente");
		c.setTipoPatente("AB");
		c.setDataScadenza(LocalDate.parse("2017-12-01", DB_common.formatterDB));
		
		
		//System.out.print(dao.add(c));
		//System.out.println(dao.delete(c));
		System.out.println(dao.update(c));
	}
}
