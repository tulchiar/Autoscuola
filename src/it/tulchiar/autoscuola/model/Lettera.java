package it.tulchiar.autoscuola.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javafx.geometry.Dimension2D;



public class Lettera {
	
	final static String PATH ="/Users/Marco/Desktop/Autoscuola/";
	private String file;
	private String path;
	
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
		
		Lettera l = new Lettera();
		l.creaLetteraPdf(PATH, "", c);
	}
	
	public void creaLetteraScadenzaPatente(String path, String file, Cliente cliente) {
		
		//2017_01_01_Chiarello_Marco_lettera scadenza patente.odt
		this.file = LocalDate.now().getYear() + "_" 
				+ String.format("%02d",LocalDate.now().getMonthValue()) +"_"
				+ String.format("%02d",LocalDate.now().getDayOfMonth()) + "_"
				+ cliente.getCognome()+"_"+cliente.getNome()+"_lettera scadenza patente.html";  //file;
		
		this.path = PATH + this.file;
	    
		
		String html = "<html><head>"
		        +"<title>" + file + "</title>"
		        +"</head>"
		        +"<body>"
		        +"<img src='/Logo.bmp'>"
		        +"<p>" + cliente.getCognome() + " " + cliente.getNome() + "</p>"
		        +"<p>" + cliente.getIndirizzo() + "</p>"
		        +"<p>" + cliente.getCap() + " " + cliente.getLocalita() + " (" + cliente.getProvincia() +")</p>"
		        +"<p></p>"
		        +"<p>OGGETTO: SCADENZA PATENTE DI GUIDA</p>"
		        +"<p></p>"
		        +"<p>   Egregio Signore/a,</p>"	        
		        +"<p>con la presente la informiamo che il giorno " + cliente.getDataScadenza().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		        + " viene a scadere la sua patente di guida.</p>"	   
		        +"<p></p>"
		        +"<p>   E' opportuno pertanto che provveda in tempo utile al rinnovo della stessa, che potrà effettuare presso ill nostro ufficio,"
		        + "presentandosi munito di patente, codice fiscale, 1 foto nei giorni in cui è a disposizione per i nostri clienti l'Ufficiale Sanitario"
		        + "e cioè:</p>"
		        +"<p></p>"
		        +"<h2>LUNEDI' ORE 18.00</h2>"
		        +"<p></p>"
		        +"<p>e</p>"
		        +"<p></p>"
		        +"<h2>GIOVEDI' ORE 17.15</h2>"
		        +"<p></p>"
		        +"<p><b>Per appuntamento</b></p>"
		        +"<p></p>"
		        +"<p>Distinti saluti</p>"
		        +"<p></p>"
		        +"<p><c>AUTOSCUOLA LA QUERCE</c></p>"
		        +"</body></html>";
				
	    try {
	        File f = new File(this.path);
	        FileWriter fw = new FileWriter(f);
	        fw.write(html);
	        
	        fw.flush();
	        fw.close();
	    }
	    catch(IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void creaLetteraPdf(String path, String file, Cliente cliente) {
		
		//2017_01_01_Chiarello_Marco_lettera scadenza patente.odt
		this.file = LocalDate.now().getYear() + "_" 
				+ String.format("%02d",LocalDate.now().getMonthValue()) +"_"
				+ String.format("%02d",LocalDate.now().getDayOfMonth()) + "_"
				+ cliente.getCognome()+"_"+cliente.getNome()+"_lettera scadenza patente.pdf";  //file;
		
		this.path = PATH + this.file;
		
		final PDPage singlePage = new PDPage();
		   final PDFont timesRoman = PDType1Font.TIMES_ROMAN;
		   final PDFont helveticaBoldOblique = PDType1Font.HELVETICA_BOLD_OBLIQUE;
		   final PDFont helveticaBold = PDType1Font.HELVETICA_BOLD;
		   final int fontSize = 15;
		   try (final PDDocument document = new PDDocument()) {
			   
		      document.addPage(singlePage);
		      final PDPageContentStream contentStream = new PDPageContentStream(document, singlePage);
		     
		      PDImageXObject pdImage = PDImageXObject.createFromFile("/Users/Marco/Desktop/Autoscuola/Logo.bmp", document);
		      contentStream.drawImage(pdImage, 100, 600);
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(450, 650);
		      contentStream.showText(cliente.getCognome() + " " + cliente.getNome());
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(450, 630);
		      contentStream.showText(cliente.getIndirizzo());
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(450, 610);
		      contentStream.showText(cliente.getCap() + " " + cliente.getLocalita() + " (" + cliente.getProvincia() + ")");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(helveticaBoldOblique, fontSize);
		      contentStream.newLineAtOffset(40, 540);
		      contentStream.showText("OGGETTO: SCADENZA PATENTE DI GUIDA");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(60, 500);
		      contentStream.showText("Egregio Signore/a,");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(40, 470);
		      contentStream.showText("con la presente la informiamo che il giorno " + cliente.getDataScadenza().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		    		  					+ " viene a scadere la sua patente di");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(40, 440);
		      contentStream.showText("guida.");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(60, 410);
		      contentStream.showText("E' opportuno pertanto che provveda in tempo utile al rinnovo della stessa, che potrà");
		      contentStream.endText();

		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(40, 380);
		      contentStream.showText("effettuare presso il nostro ufficio, presentandosi munito di ");
		      contentStream.endText();

		      contentStream.beginText();
		      contentStream.setFont(helveticaBold, fontSize);
		      contentStream.newLineAtOffset(160, 350);
		      contentStream.showText("patente, codice fiscale, 1 foto");
		      contentStream.endText();

		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(40, 320);
		      contentStream.showText("nei giorni in cui è a disposizione per i nostri clienti l'Ufficiale Sanitario e cioè:");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(helveticaBoldOblique, fontSize);
		      contentStream.newLineAtOffset(200, 290);
		      contentStream.showText("LUNEDI' ORE 18.00");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(250, 260);
		      contentStream.showText("e");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(helveticaBoldOblique, fontSize);
		      contentStream.newLineAtOffset(200, 230);
		      contentStream.showText("GIOVEDI' ORE 17.15");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(helveticaBold, fontSize);
		      contentStream.newLineAtOffset(200, 200);
		      contentStream.showText("per appuntamento");
		      contentStream.endText();

		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(40, 160);
		      contentStream.showText("Distinti saluti");
		      contentStream.endText();

		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(380, 130);
		      contentStream.showText("AUTOSCUOLA LA QUERCE");
		      contentStream.endText();
		      
		      contentStream.close();  // Stream must be closed before saving document.
		      document.save(this.path);
		  
		   } catch (IOException ioEx) {
		      System.err.println(
		         "Exception while trying to create simple document - " + ioEx);
		   }

	}
		
}
