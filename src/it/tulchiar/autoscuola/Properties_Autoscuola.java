package it.tulchiar.autoscuola;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Properties_Autoscuola{
		
	public static String dbConnectionString = "";
		
		public static void main(String[] s) {
			
			//////verifico se il file esiste//////
			if(new File("properties").exists()) {
				
				System.out.println("Il file properties esiste già, ne recupero il contenuto");
				
				////////////Reading properties////////////////////////////////
				try (InputStream in = new FileInputStream("properties")) {
					Properties prop = new Properties();
					prop.load(in);
							
					dbConnectionString = prop.getProperty("dbConnectionString");

					System.out.println("####Properties.stringPropertyNames usage####");
					for (String property : prop.stringPropertyNames()) {
						String value = prop.getProperty(property);
						System.out.println(property + " ==> " + value);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				////////////////////////////////////////////////////
				
			} else {
				
				System.out.println("Il file properties non esiste, lo creo con valori di default");
					
				//////saving properties into example.properties file/////////
				try (OutputStream out = new FileOutputStream("properties")) {
					Properties properties = new Properties();
					properties.setProperty("dbConnectionString", "jdbc:mysql://localhost/autoscuola?user=root&password=");
					properties.store(out, "Impostazioni per Autoscuola La Querce");
	
				} catch (IOException e) {
					e.printStackTrace();
				}
				///////////////////////////////////////////////////////////////
			}
						System.out.println();

//			/////////writing and reading fromxml////////////////
//			try (OutputStream out = new FileOutputStream("example.xml")) {
//				Properties properties = new Properties();
//				properties.setProperty("article", "JavaProperties");
//				properties.setProperty("version", "1.0");
//				properties.setProperty("ide", "eclipse");
//				properties.storeToXML(out,
//						"This is how we can have properties as xml");
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			///////////////////////////////////////////////////////

//			///////////Reading properties from xml/////////////////
//			try (InputStream in = new FileInputStream("example.xml")) {
//				Properties prop = new Properties();
//				prop.loadFromXML(in);
//
//				System.out.println("####Properties.load from xml usage####");
//				for (String property : prop.stringPropertyNames()) {
//					String value = prop.getProperty(property);
//					System.out.println(property + "=" + value);
//				}
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println();
//
//			///////////////////////////////////////////////////////

		}
	}

