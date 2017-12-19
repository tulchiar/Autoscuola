package it.tulchiar.autoscuola.model;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Lettera {
	
//	final static String PATH ="/Users/Marco/Desktop/Autoscuola/";
	final static String PATH ="C:\\Autoscuola\\LettereScadenze\\";
	
	private String file;
	private String path;
	
	
	public void creaLetteraScadenzaPatente(String path, String file, Cliente cliente) {
	
		//2017_01_01_Chiarello_Marco_lettera scadenza patente.odt
		this.file = LocalDate.now().getYear() + "_" 
				+ String.format("%02d",LocalDate.now().getMonthValue()) +"_"
				+ String.format("%02d",LocalDate.now().getDayOfMonth()) + "_"
				+ cliente.getCognome()+"_"+cliente.getNome()+"_lettera scadenza patente.pdf";  //file;
		
		this.path = PATH + this.file;
		
		final PDPage singlePage = new PDPage(PDRectangle.A4);
		   final PDFont timesRoman = PDType1Font.TIMES_ROMAN;
		   final PDFont helveticaBoldOblique = PDType1Font.HELVETICA_BOLD_OBLIQUE;
		   final PDFont helveticaBold = PDType1Font.HELVETICA_BOLD;
		   final int fontSize = 15;
		   try (final PDDocument document = new PDDocument()) {
			   
		      document.addPage(singlePage);
		      final PDPageContentStream contentStream = new PDPageContentStream(document, singlePage);
		     
//		      PDImageXObject pdImage = PDImageXObject.createFromFile("/Users/Marco/Desktop/Autoscuola/LogoSenzaScritte.gif", document);
		      
		      
//		      PDImageXObject pdImage = PDImageXObject.createFromFile("./img/LogoSenzaScritte.gif", document);
//		      contentStream.drawImage(pdImage, 20, 690);
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(320,710);
		      contentStream.showText(cliente.getCognome() + " " + cliente.getNome());
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(320, 690);
		      contentStream.showText(cliente.getIndirizzo());
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(320, 670);
		      contentStream.showText(cliente.getCap() + " " + cliente.getLocalita() + " (" + cliente.getProvincia() + ")");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(helveticaBoldOblique, fontSize);
		      contentStream.newLineAtOffset(40, 520);
		      contentStream.showText("OGGETTO: SCADENZA PATENTE DI GUIDA");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(60, 480);
		      contentStream.showText("Egregio Signore/a,");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(40, 450);
		      contentStream.showText("con la presente la informiamo che il giorno " + cliente.getDataScadenza().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		    		  					+ " viene a scadere la sua patente di");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(40, 420);
		      contentStream.showText("guida.");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(60, 390);
		      contentStream.showText("E' opportuno pertanto che provveda in tempo utile al rinnovo della stessa, che potrà");
		      contentStream.endText();

		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(40, 360);
		      contentStream.showText("effettuare presso il nostro ufficio, presentandosi munito di ");
		      contentStream.endText();

		      contentStream.beginText();
		      contentStream.setFont(helveticaBold, fontSize);
		      contentStream.newLineAtOffset(200, 330);
		      contentStream.showText("patente, codice fiscale, 1 foto");
		      contentStream.endText();

		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(40, 300);
		      contentStream.showText("nei giorni in cui è a disposizione per i nostri clienti l'Ufficiale Sanitario e cioè:");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(helveticaBoldOblique, fontSize);
		      contentStream.newLineAtOffset(230, 270);
		      contentStream.showText("LUNEDI' ORE 18.00");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(290, 250);
		      contentStream.showText("e");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(helveticaBoldOblique, fontSize);
		      contentStream.newLineAtOffset(227, 230);
		      contentStream.showText("GIOVEDI' ORE 17.15");
		      contentStream.endText();
		      
		      contentStream.beginText();
		      contentStream.setFont(helveticaBold, fontSize);
		      contentStream.newLineAtOffset(230, 200);
		      contentStream.showText("per appuntamento");
		      contentStream.endText();

		      contentStream.beginText();
		      contentStream.setFont(timesRoman, fontSize);
		      contentStream.newLineAtOffset(40, 160);
		      contentStream.showText("Distinti saluti");
		      contentStream.endText();

		      contentStream.beginText();
		      contentStream.setFont(helveticaBoldOblique, fontSize);
		      contentStream.newLineAtOffset(390, 130);
		      contentStream.showText("AUTOSCUOLA");
		      contentStream.endText();

		      contentStream.beginText();
		      contentStream.setFont(helveticaBoldOblique, fontSize);
		      contentStream.newLineAtOffset(396, 117);
		      contentStream.showText("LA QUERCE");
		      contentStream.endText();
		      
		      contentStream.setNonStrokingColor(Color.BLUE);
		      contentStream.addRect(30, 25, 550, 1);
		      contentStream.fill();
		         
		      contentStream.beginText();
		      contentStream.setFont(helveticaBoldOblique, 8);
		      contentStream.newLineAtOffset(60, 17);
		      contentStream.showText("Via F. Mazzei, 5 - 59100 La Querce (PO) - Tel/Fax 0574 560700 - eMail: autoscuolalaquerce@virgilio.it - P.IVA/C.F. 02192770978");
		      contentStream.endText();
		      

		      contentStream.close();  // Stream must be closed before saving document.
		      document.save(this.path);
		  
		   } catch (IOException ioEx) {
		      System.err.println(
		         "Exception while trying to create simple document - " + ioEx);
		   }

	}

	
}


