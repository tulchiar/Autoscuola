package it.tulchiar.autoscuola.db;

import javafx.scene.control.TextField;

public class InputValidation {
	
	public static boolean isFilledByText(TextField textField) {
		
		if(!textField.getText().isEmpty()) {
			
			String regex = "^[A-Z][a-z]{1,254}";
			
			return textField.getText().matches(regex);		
		}
		
		return false;
	}
	
	public static boolean isCap(TextField textField) {
		
		if(!textField.getText().isEmpty()) {
			
			String regex = "^[0-9]{5}$";
			
			return textField.getText().matches(regex);		
		}
		
		return false;
	}
}
