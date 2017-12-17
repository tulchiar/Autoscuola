package it.tulchiar.autoscuola.model;

import java.time.LocalDate;

public class TestCliente {
	public static void main(String[] args) {
		
		Cliente c = new Cliente(1, "Chiarello", "Marco");
		c.setIndirizzo("Via Guerra 15");
		c.setCap("59100");
		c.setLocalita("Prato");
		c.setProvincia("PO");
		c.setCellulare("349 0773441");
		c.setEmail("tulchiar@gmail.com");
		c.setNote("Annotazione inserita per appuntare qualcosa \nrelativo al cliente");
		c.setTipoPatente("AB");
		c.setDataScadenza(LocalDate.parse("2019-05-07"));
		c.setDataInvioLettera(LocalDate.now());
		
		System.out.println(c);
		
	}
}
