package it.tulchiar.autoscuola;
	
import it.tulchiar.autoscuola.model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	public String isDebug = System.getProperty("isRunningInEclipse");
	
	@Override
	public void start(Stage primaryStage) {
		try {	
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Autoscuola.fxml"));
			
			BorderPane root = (BorderPane)loader.load();

			AutoscuolaController controller = loader.getController();
			Model model = new Model();
			controller.setModel(model);
			
			Scene scene = new Scene(root, 1100, 700);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
	
			// Verifico	se l'applicazione sta girando da dentro Eclipse o da una versione compilata	
			if(Common.isDevelopmentEnvironment()) {
				System.out.println("APLICATION RUNNING IN ECLIPSE");
			} else {
				Alert alert = new Alert(AlertType.INFORMATION, "Autoscuol La Querce", ButtonType.OK);
				alert.show();
			}
			
			Common.loadProperties();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
