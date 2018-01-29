package it.tulchiar.autoscuola;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Common {
	
	public static boolean isDevelopmentEnvironment() {
		System.out.println(System.getenv("isRunningInEclipse"));
		boolean isEclipse = true;
	    if (System.getenv("isRunningInEclipse") == null) {
	        isEclipse = false;
	        System.out.println("#### NON STA GIRANDO IN ECLIPSE ####");
	    } else {
	    		isEclipse = true;
	    		System.out.println("#### STA GIRANDO IN ECLIPSE ####");
	    }
	    	return isEclipse;
	
	}
	//////////// Properties ///////////////////
	public static String dbConnectionStringBuild = "";
	public static String dbConnectionStringDev = "";
	public static String letteraScadenzaPatente_WIN_PATH = "";
	public static String letteraScadenzaPatente_OSX_PATH = "";
	
	
	//////////////////////////////////////////
	
	public static void loadProperties() {
		
		//////saving properties into example.properties file/////////
//		try (OutputStream out = new FileOutputStream("properties")) {
//			Properties properties = new Properties();
//			properties.setProperty("dbConnectionStringBuild", "jdbc:mysql://localhost/autoscuola?user=root&password=");
//			properties.setProperty("dbConnectionStringDev", "jdbc:mysql://localhost/autoscuola?user=root&password=Chrmrc84a15");
//			properties.setProperty("letteraScadenzaPatente_WIN_PATH", "C:\\Autoscuola\\LettereScadenze\\");
//			properties.setProperty("letteraScadenzaPatente_OSX_PATH", "/Users/Marco/Desktop/Autoscuola/");
//			properties.store(out, "Impostazioni per Autoscuola La Querce");
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		///////////////////////////////////////////////////////////////

		////////////Reading properties////////////////////////////////
		try (InputStream in = new FileInputStream("properties")) {
			Properties prop = new Properties();
			prop.load(in);
					
			dbConnectionStringBuild = prop.getProperty("dbConnectionStringBuild");
			dbConnectionStringDev = prop.getProperty("dbConnectionStringDev");
			letteraScadenzaPatente_WIN_PATH = prop.getProperty("letteraScadenzaPatente_WIN_PATH");
			letteraScadenzaPatente_OSX_PATH = prop.getProperty("letteraScadenzaPatente_OSX_PATH");
			System.out.println("dbConnectionStringBuild ==> " + dbConnectionStringBuild);
			System.out.println("dbConnectionStringDev ==> " + dbConnectionStringDev);
			System.out.println("letteraScadenzaPatente_WIN_PATH ==> " + letteraScadenzaPatente_WIN_PATH);
			System.out.println("letteraScadenzaPatente_OSX_PATH ==> " + letteraScadenzaPatente_OSX_PATH);

//			System.out.println("####Properties.stringPropertyNames usage####");
//			for (String property : prop.stringPropertyNames()) {
//				String value = prop.getProperty(property);
//				System.out.println(property + "=" + value);
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();

		////////////////////////////////////////////////////

//		/////////writing and reading fromxml////////////////
//		try (OutputStream out = new FileOutputStream("example.xml")) {
//			Properties properties = new Properties();
//			properties.setProperty("article", "JavaProperties");
//			properties.setProperty("version", "1.0");
//			properties.setProperty("ide", "eclipse");
//			properties.storeToXML(out,
//					"This is how we can have properties as xml");
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		///////////////////////////////////////////////////////

//		///////////Reading properties from xml/////////////////
//		try (InputStream in = new FileInputStream("example.xml")) {
//			Properties prop = new Properties();
//			prop.loadFromXML(in);
//
//			System.out.println("####Properties.load from xml usage####");
//			for (String property : prop.stringPropertyNames()) {
//				String value = prop.getProperty(property);
//				System.out.println(property + "=" + value);
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
//
//		///////////////////////////////////////////////////////

	}
	
}
