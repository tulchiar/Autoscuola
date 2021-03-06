package it.tulchiar.autoscuola;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import it.tulchiar.autoscuola.db.DB_common;
import it.tulchiar.autoscuola.model.Cliente;
import it.tulchiar.autoscuola.model.Lettera;
import it.tulchiar.autoscuola.model.Model;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class AutoscuolaController {
	
	private Model model;
		
	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

		
	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML // fx:id="chkCreazioneLettere"
    private CheckBox chkCreazioneLettere; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtAnno"
    private TextField txtAnno; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognomeRicerca"
    private TextField txtCognomeRicerca; // Value injected by FXMLLoader

    @FXML // fx:id="txtMese"
    private TextField txtMese; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaCognome"
    private Button btnCercaCognome; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnCercaMeseAnno"
    private Button btnCercaMeseAnno; // Value injected by FXMLLoader

    @FXML // fx:id="tblClienti"
    private TableView<Cliente> tblClienti; // Value injected by FXMLLoader

    @FXML // fx:id="colCognome"
    private TableColumn<Cliente, String> colCognome; // Value injected by FXMLLoader

    @FXML // fx:id="colNome"
    private TableColumn<Cliente, String> colNome; // Value injected by FXMLLoader

    @FXML // fx:id="colTipoPatente"
    private TableColumn<Cliente, String> colTipoPatente; // Value injected by FXMLLoader

    @FXML // fx:id="colDataScadenza"
    private TableColumn<Cliente, String> colDataScadenza; // Value injected by FXMLLoader

    @FXML // fx:id="colDataInvioLettera"
    private TableColumn<Cliente, String> colDataInvioLettera; // Value injected by FXMLLoader

    @FXML // fx:id="colSelezionato"
    private TableColumn<Cliente, Boolean> colSelezionato; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtDettagliCliente"
    private TextArea txtDettagliCliente; // Value injected by FXMLLoader

    @FXML // fx:id="txtId"
    private TextField txtId; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtIndirizzo"
    private TextField txtIndirizzo; // Value injected by FXMLLoader

    @FXML // fx:id="txtCap"
    private TextField txtCap; // Value injected by FXMLLoader

    @FXML // fx:id="txtLocalita"
    private TextField txtLocalita; // Value injected by FXMLLoader

    @FXML // fx:id="txtProvincia"
    private TextField txtProvincia; // Value injected by FXMLLoader

    @FXML // fx:id="txtTipoPatente"
    private TextField txtTipoPatente; // Value injected by FXMLLoader

    @FXML // fx:id="txtDataScadenza"
    private TextField txtDataScadenza; // Value injected by FXMLLoader

    @FXML // fx:id="txtTelefono"
    private TextField txtTelefono; // Value injected by FXMLLoader

    @FXML // fx:id="txtCellulare"
    private TextField txtCellulare; // Value injected by FXMLLoader

    @FXML // fx:id="txtEmail"
    private TextField txtEmail; // Value injected by FXMLLoader

    @FXML // fx:id="txtDataInvioLettera"
    private TextField txtDataInvioLettera; // Value injected by FXMLLoader

    @FXML // fx:id="txtNote"
    private TextArea txtNote; // Value injected by FXMLLoader

    @FXML // fx:id="btnSalva"
    private Button btnSalva; // Value injected by FXMLLoader

    @FXML // fx:id="btnNuovo"
    private Button btnNuovo; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader
 
    @FXML // fx:id="btnSelezionaTutti"
    private Button btnSelezionaTutti; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnCreaLettere"
    private Button btnCreaLettere; // Value injected by FXMLLoader

    @FXML // fx:id="tabPane"
    private TabPane tabPane; // Value injected by FXMLLoader

    @FXML // fx:id="tabRicerca"
    private Tab tabRicerca; // Value injected by FXMLLoader
    
    @FXML
    private BorderPane tabRicercaInner;

    @FXML // fx:id="tabAggiungiModifica"
    private Tab tabAggiungiModifica; // Value injected by FXMLLoader

    private ObservableList<Cliente> clientiSelezionati;
    
    
    //TODO implementare il metodo doCreaLettere
    @FXML
    void doCreaLettere() {
    		// Stampo l'elenco dei clienti selezionati
    			
    		System.out.println(clientiSelezionati.toString());
    		
    }
    
    //TODO implementare il metodo doSelezionaTutti
    @FXML
    void doSelezionaTutti() {
    		
    }

    
    // Cambio il colore della finestra per segnalare la modalità di creazione delle lettere
    @FXML
    void doCheckCreazioneLettere() {
    		if (chkCreazioneLettere.isSelected()) {
	    		tabRicercaInner.getStyleClass().add("custom");
    		} else {
	    		tabRicercaInner.getStyleClass().remove("custom");
    		}
    	}
    
    
    /** Quando seleziono una riga visualizzo i dettagli e passo i valori alla schermata di modifica.
    * Se selezionata la checkbox creo la lettera de l cliente su cui è stato fatto click.
    * @param event MouseEvent
    */
    @FXML
    void doMostraDettagli(MouseEvent event) {
		clientiSelezionati = tblClienti.getSelectionModel().getSelectedItems();
    		
    		txtDettagliCliente.setText(clientiSelezionati.get(0).toString());
    		Cliente cliente0 = clientiSelezionati.get(0);
    		
    		// Creo la lettera da inviare al cliente
    		if(chkCreazioneLettere.isSelected()) {
	    		Lettera l = new Lettera();
	    		l.creaLetteraScadenzaPatente("", "", clientiSelezionati.get(0));
	    		model.setDataInvioLettera(clientiSelezionati.get(0));
    		} else {
    			// Passo i parametri alla schermata di modifica
    			txtId.setText( Integer.toString(cliente0.getId()));
    			txtCognome.setText(cliente0.getCognome());
			txtNome.setText(cliente0.getNome());
			txtIndirizzo.setText(cliente0.getIndirizzo());
			txtCap.setText(cliente0.getCap());
			txtLocalita.setText(cliente0.getLocalita());
			txtProvincia.setText(cliente0.getProvincia());
			txtTipoPatente.setText(cliente0.getTipoPatente());
			
			if(cliente0.getDataScadenza() == null) {
				txtDataScadenza.setText("");
			} else {
				txtDataScadenza.setText(cliente0.getDataScadenza().format(DateTimeFormatter.ofPattern(DB_common.dataVisualizzata)));
			}
			
			txtTelefono.setText(cliente0.getTelefono());
			txtCellulare.setText(cliente0.getCellulare());
			txtEmail.setText(cliente0.getEmail());
			txtNote.setText(cliente0.getNote());
			
			if(cliente0.getDataInvioLettera() == null) {
				txtDataInvioLettera.setText("");
			} else {
				txtDataInvioLettera.setText(cliente0.getDataInvioLettera().format(DateTimeFormatter.ofPattern(DB_common.dataVisualizzata)));
			}
			
    		}
    }
    
    /**
     * Ricerca per cognome, se vuoto restituisce tutti i clienti
     * @param event
     */
    @FXML
    void doCercaCognome(ActionEvent event) {
    	
    		colCognome.setCellValueFactory( new PropertyValueFactory<>("cognome") );
		colNome.setCellValueFactory( new PropertyValueFactory<>("nome") );
		colTipoPatente.setCellValueFactory( new PropertyValueFactory<>("tipoPatente") );

		colDataScadenza.setCellValueFactory( 
			Cliente -> {
				SimpleStringProperty property = new SimpleStringProperty();
				
				if(Cliente.getValue().getDataScadenza() == null ) {
					property.setValue("");
				} else {
					property.setValue(Cliente.getValue().getDataScadenza().format(DateTimeFormatter.ofPattern(DB_common.dataVisualizzata)));
				}
				return property;
		});
				
		colDataInvioLettera.setCellValueFactory( 
			Cliente -> {
				SimpleStringProperty property = new SimpleStringProperty();
				if(Cliente.getValue().getDataInvioLettera() == null) {
					property.setValue("");
				} else {
					property.setValue(Cliente.getValue().getDataInvioLettera().format(DateTimeFormatter.ofPattern(DB_common.dataVisualizzata)));
				}
				return property;
		});
		
//TODO aggiungere colonna con checkbox
		
		colSelezionato.setCellFactory(column -> new CheckBoxTableCell<>());
		
		colSelezionato.setCellValueFactory(cellData -> {
            Cliente cellValue = cellData.getValue();
            BooleanProperty property = cellValue.getSelezionato();

            // Add listener to handler change
//            property.addListener((observable, oldValue, newValue) -> cellValue.setSelezionato(newValue));
            property.addListener(new ChangeListener<Boolean>(){
            
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					cellValue.setSelezionato(new SimpleBooleanProperty(cellValue.getSelezionato().getValue()));
//					clientiSelezionati.add(cellValue);
					System.out.println("Nuovo Valore Selezionato: " + cellValue.getSelezionato().getValue());
					
					if(cellValue.getSelezionato().getValue()) {
						clientiSelezionati.add(cellValue);
					}
					
					System.out.println(clientiSelezionati);
					
				}
            	
            });

            return property;
        });
		
		colSelezionato.setEditable(true);
		tblClienti.setEditable(true);
		
	
//####################################################################
		
		tblClienti.getItems().clear();
    		ArrayList<Cliente> clienti;
    		if(!txtCognomeRicerca.getText().isEmpty()) {
   
    			String cognome = txtCognomeRicerca.getText();
    			clienti = model.searchByCognome(cognome);
    			
    		} else {
    			clienti = model.getAll();
		}
    		
    		for (Cliente cliente : clienti) {
				tblClienti.getItems().add( new Cliente(
						cliente.getId(), 
						cliente.getCognome(),
						cliente.getNome(),
						cliente.getIndirizzo(),
						cliente.getCap(),
						cliente.getLocalita(),
						cliente.getProvincia(),
						cliente.getTipoPatente(),
						cliente.getDataScadenza(),
						cliente.getTelefono(),
						cliente.getCellulare(),
						cliente.getEmail(),
						cliente.getNote(), 
						cliente.getDataInvioLettera() ) );		
    		}   		
    }
    
    @FXML
    void doCercaMeseAnno(ActionEvent event) {
    		
    		int mese = Integer.parseInt(txtMese.getText());
    		int anno = Integer.parseInt(txtAnno.getText());
    		ArrayList<Cliente> clienti = model.searchScadenza(mese, anno);
    		
    		colCognome.setCellValueFactory( new PropertyValueFactory<>("cognome") );
		colNome.setCellValueFactory( new PropertyValueFactory<>("nome") );
		colTipoPatente.setCellValueFactory( new PropertyValueFactory<>("tipoPatente") );
				
		colDataScadenza.setCellValueFactory( 
				Cliente -> {
					SimpleStringProperty property = new SimpleStringProperty();
					
					if(Cliente.getValue().getDataScadenza() == null ) {
						property.setValue("");
					} else {
						property.setValue(Cliente.getValue().getDataScadenza().format(DateTimeFormatter.ofPattern(DB_common.dataVisualizzata)));
					}
					return property;
			});
		
		
		colDataInvioLettera.setCellValueFactory( 
				Cliente -> {
					SimpleStringProperty property = new SimpleStringProperty();
					if(Cliente.getValue().getDataInvioLettera() == null) {
						property.setValue("");
					} else {
						property.setValue(Cliente.getValue().getDataInvioLettera().format(DateTimeFormatter.ofPattern(DB_common.dataVisualizzata)));
					}
					return property;
			});	
		
		colSelezionato.setCellFactory(column -> new CheckBoxTableCell<>());
//		colSelezionato.addEventHandler(E, new EventHandler<T>());
		colSelezionato.setEditable(true);
		tblClienti.setEditable(true);
		
		
		
		
//checkedCol.setCellFactory(CheckBoxTableCell.forTableColumn(checkedCol));
	    
		
		
    		tblClienti.getItems().clear();
    		
    		for (Cliente cliente : clienti) {
    			tblClienti.getItems().add( new Cliente(
						cliente.getId(), 
						cliente.getCognome(),
						cliente.getNome(),
						cliente.getIndirizzo(),
						cliente.getCap(),
						cliente.getLocalita(),
						cliente.getProvincia(),
						cliente.getTipoPatente(),
						cliente.getDataScadenza(),
						cliente.getTelefono(),
						cliente.getCellulare(),
						cliente.getEmail(),
						cliente.getNote(), 
						cliente.getDataInvioLettera() ) );
//TODO verificare date
    		}
    }

    @FXML
    void doSalva(ActionEvent event) {
    	    	
    		int id = -1; // Stato di nuovo
    		
    		try { // recupero lo stato attuale
    			id = Integer.parseInt(txtId.getText());
		} catch (NumberFormatException e) {
			id = -1;				
		}
    		
    		String cognome = txtCognome.getText();
	    	String nome = txtNome.getText();
	    	String indirizzo = txtIndirizzo.getText();
	    	String cap = txtCap.getText();
	    	String localita = txtLocalita.getText();
	    	String provincia = txtProvincia.getText();
	    	String tipoPatente = txtTipoPatente.getText();
    		
	    	LocalDate dataScadenza = null;
	    	if(txtDataScadenza.getText().isEmpty()) {
	    		dataScadenza = null;
	    	} else {
		    	try {
		    		dataScadenza = LocalDate.parse(txtDataScadenza.getText(), DB_common.formatter);
		    	} catch(DateTimeParseException e) {
		    		Alert alert = new Alert(AlertType.ERROR, "Errore inserimento data", ButtonType.OK);
		    		alert.setTitle("Formato data errato");
		    		alert.setHeaderText("Formato data errato");
		    		alert.showAndWait();
		    		return;
		    	}
	    	}
	    	
	    	String telefono = txtTelefono.getText();
	    	String cellulare = txtCellulare.getText();
	    	String email = txtEmail.getText();
	    	String note = txtNote.getText();
	    	
	    	LocalDate dataInvioLettera = null;
	    if(txtDataInvioLettera.getText().isEmpty()) {
	    		dataInvioLettera = null;
	    } else {
		    	try {
		    		dataInvioLettera = LocalDate.parse(txtDataInvioLettera.getText(), DB_common.formatter);
		    	} catch(DateTimeParseException e) {
		    		Alert alert = new Alert(AlertType.ERROR, "Errore inserimento data", ButtonType.OK);
		    		alert.setTitle("Formato data errato");
		    		alert.setHeaderText("Formato data errato");
		    		alert.showAndWait();
		    		return;
		    	}
	    }
    		
    		
    		if(id == -1) { //Se sono nello stato di nuovo - Aggiungo un nuovo cliente
   	
		    	Cliente nuovoCliente = new Cliente(id, cognome, nome, indirizzo, cap, localita, provincia, tipoPatente, dataScadenza, telefono, cellulare, email, note, null);
		    	
		    	if(model.add(nuovoCliente)) {
		    		tabPane.getSelectionModel().select(tabRicerca);
		    		return;
		    }
    		} else { //Se sono nello stato di modifica - modifico il cliente con id = txtId
    			
    			Cliente cliente = new Cliente(id, cognome, nome, indirizzo, cap, localita, provincia, tipoPatente, dataScadenza, telefono, cellulare, email, note, dataInvioLettera);
    		    
    			if(model.update(cliente)) {
    				tabPane.getSelectionModel().select(tabRicerca);
		    		
		    		return;
    			}
    		}
    }
    
    @FXML
    void doNuovo(ActionEvent event) {
    		tabPane.getSelectionModel().select(tabAggiungiModifica);
    		resetPannelloAggiungiModifica();
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    		int id = Integer.parseInt(txtId.getText());
    		Cliente cliente = new Cliente(id,null,null);
    		
    		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, 
    				"Sei sicuro di voler cancellare il Cliente selezionato?", 
    				ButtonType.NO, ButtonType.YES);
    		alert.setHeaderText("Cancellazione Cliente");
    		alert.showAndWait().ifPresent(type -> {
    			System.out.println(type.toString());
    		        if (type == ButtonType.YES) {
    		        	System.out.println("Cancello");
    		        		if(model.delete(cliente)) {
	    		    			resetPannelloAggiungiModifica();
	    		    			Alert alert2 = new Alert(AlertType.INFORMATION, "Cancellazione avvenuta con successo.\n "
	    		    					+ "(in caso di necessità il record è recuperabile)", ButtonType.OK);
	    		    			alert2.setHeaderText("Cliente cancellato!");
	    		    			alert2.showAndWait();
	    		    			return;
    		        		}
    		        }
    		});	
    	
    }
     
    private void resetPannelloAggiungiModifica() {
    	// Passo i parametri alla schermata di modifica
		txtId.setText( "-1" );
		txtCognome.setText( "" );
		txtNome.setText( "" );
		txtIndirizzo.setText( "" );
		txtCap.setText( "" );
		txtLocalita.setText( "" );
		txtProvincia.setText( "" );
		txtTipoPatente.setText( "" );
		txtDataScadenza.setText( "" );
		txtTelefono.setText( "" );
		txtCellulare.setText( "" );
		txtEmail.setText( "" );
		txtNote.setText( "" );
		txtDataInvioLettera.setText( "" );
		
    }
    
    //TODO 
    	
    private boolean validationCognomeRicerca() {
    	
    		ValidationSupport validationSupport = new ValidationSupport();
    		validationSupport.registerValidator(txtCognomeRicerca, false, Validator.createRegexValidator("Cognome non iserito", "([A-Z]([a-zàèéìòù'/-]?+)+\\s?)+", Severity.ERROR));
    		
    		validationSupport.invalidProperty().addListener(new ChangeListener<Boolean>() {

				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if(validationSupport.isInvalid()) {
						btnCercaCognome.setDisable(true);
					} else {
						btnCercaCognome.setDisable(false);
					}				
				}
			});
    	
    		return false;
    }
    
    private boolean validationDataRicerca() {
       	
    		ValidationSupport validationSupport = new ValidationSupport();
		validationSupport.registerValidator(txtMese, false, Validator.createRegexValidator("Mese non valido", "([0][0-9])|([1][0-2])", Severity.ERROR));
		validationSupport.registerValidator(txtAnno, false, Validator.createRegexValidator("Anno non valido (1990-2059)", "([1][9][9][0-9]|[2][0][0-5][0-9])", Severity.ERROR));
	
		validationSupport.invalidProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(validationSupport.isInvalid()) {
					btnCercaMeseAnno.setDisable(true);
				} else {
					btnCercaMeseAnno.setDisable(false);
				}
			}			
		});
		
		return false;   	
    }
    
    	private boolean validation() {
    	
    		ValidationSupport validationSupport = new ValidationSupport();
    		validationSupport.registerValidator(txtCognome, true, Validator.createRegexValidator("Cognome non inserito", "([A-Z]([a-zàèéìòù'/-]?+)+\\s?)+", Severity.ERROR));
    		validationSupport.registerValidator(txtNome, true, Validator.createRegexValidator("Nome non inserito", "([A-Z]([a-zàèéìòù'/-]?+)+\\s?)+", Severity.ERROR));
    		validationSupport.registerValidator(txtIndirizzo, false, Validator.createRegexValidator("Indirizzo non inserito correttamente", "(^[A-Z][A-Za-z0-9àèéìòù'/\\s.()//-]+)?", Severity.ERROR));
    		validationSupport.registerValidator(txtCap, false, Validator.createRegexValidator("Cap non corretto", "^([0-9]{5})?$", Severity.ERROR));
    		validationSupport.registerValidator(txtLocalita, false, Validator.createRegexValidator("Località non inserita correttamente", "(([A-Z]([a-z]?+)+\\s?)+)?", Severity.ERROR));
    		validationSupport.registerValidator(txtProvincia, false, Validator.createRegexValidator("Provincia non inserita correttamente Es. PO", "([A-Z][A-Z])?", Severity.ERROR));
    		validationSupport.registerValidator(txtTipoPatente, false, Validator.createRegexValidator("Tipo patente non inserita correttamente", "(([A-Z][A-Z]?[0-9]?\\s?)+)?", Severity.ERROR));
    		validationSupport.registerValidator(txtTelefono, false, Validator.createRegexValidator("Solo numeri ammessi", "(([0-9]?\\s?)+)?", Severity.ERROR));
    		validationSupport.registerValidator(txtCellulare, false, Validator.createRegexValidator("Solo numeri ammessi", "(([0-9]?\\s?)+)?", Severity.ERROR));
    		validationSupport.registerValidator(txtEmail, false, Validator.createRegexValidator("Indirizzo eMail non valido", "(^[a-z0-9_]+@[a-z0-9-]+[.][a-z0-9-.]+)?", Severity.ERROR));
    		validationSupport.registerValidator(txtDataScadenza, false, Validator.createRegexValidator("Data scadenza patente non valida", "((0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[-/.](19|20)\\d\\d)?", Severity.ERROR));
    		validationSupport.registerValidator(txtDataInvioLettera, false, Validator.createRegexValidator("Data scadenza patente non valida", "((0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[-/.](19|20)\\d\\d)?", Severity.ERROR));
    		
    		
    		validationSupport.invalidProperty().addListener(new ChangeListener<Boolean>() {

				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if(validationSupport.isInvalid()) {
						btnSalva.setDisable(true);
					} else {
						btnSalva.setDisable(false);
					}
				}				
    		});
   	
    		System.out.println(validationSupport.getValidationResult());    
    		return false;   	
    }
    
    	private void btnCercaCognomeSetDefault() {
    		txtCognomeRicerca.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					btnCercaMeseAnno.setDefaultButton(false);
					btnCercaCognome.setDefaultButton(true);
				}
			});
    	}    		
    	
    	private void btnCercaMeseAnnoSetDefault() {
    		txtMese.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					btnCercaCognome.setDefaultButton(false);
					btnCercaMeseAnno.setDefaultButton(true);
				}
			});
    		
    		txtAnno.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					btnCercaCognome.setDefaultButton(false);
					btnCercaMeseAnno.setDefaultButton(true);
				}
			});	
    	}
    	
    	
    	
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    		
    		//Disabilito i pulsanti in fase di test
    		btnSelezionaTutti.setDisable(true);
    		btnSelezionaTutti.setVisible(false);
    		btnCreaLettere.setDisable(true);
    		btnCreaLettere.setVisible(false);
    		colSelezionato.setVisible(false);
    		
    		btnCercaCognomeSetDefault();
    		btnCercaMeseAnnoSetDefault();
    		validationCognomeRicerca();
    		validationDataRicerca();
    		validation();
    		
    		
    		assert tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file 'Autoscuola.fxml'.";
    		assert tabRicerca != null : "fx:id=\"tabRicerca\" was not injected: check your FXML file 'Autoscuola.fxml'.";
    		assert tabRicercaInner != null : "fx:id=\"tabRicercaInner\" was not injected: check your FXML file 'Autoscuola.fxml'.";
    		assert tabAggiungiModifica != null : "fx:id=\"tabAggiungiModifica\" was not injected: check your FXML file 'Autoscuola.fxml'.";
    		assert chkCreazioneLettere != null : "fx:id=\"chkCreazioneLettere\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtCognomeRicerca != null : "fx:id=\"txtCognomeRicerca\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtMese != null : "fx:id=\"txtMese\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert btnCercaCognome != null : "fx:id=\"btnCercaCognome\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert btnCercaMeseAnno != null : "fx:id=\"btnCercaMeseAnno\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert tblClienti != null : "fx:id=\"tblClienti\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert colCognome != null : "fx:id=\"colCognome\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert colNome != null : "fx:id=\"colNome\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert colTipoPatente != null : "fx:id=\"colTipoPatente\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert colDataScadenza != null : "fx:id=\"colDataScadenza\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert colDataInvioLettera != null : "fx:id=\"colDataInvioLetteradataInvioLettera\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert colSelezionato != null : "fx:id=\"colSelezionato\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtDettagliCliente != null : "fx:id=\"txtDettagliCliente\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtIndirizzo != null : "fx:id=\"txtIndirizzo\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtCap != null : "fx:id=\"txtCap\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtLocalita != null : "fx:id=\"txtLocalita\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtProvincia != null : "fx:id=\"txtProvincia\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtTipoPatente != null : "fx:id=\"txtTipoPatente\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtDataScadenza != null : "fx:id=\"txtDataScadenza\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtCellulare != null : "fx:id=\"txtCellulare\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtDataInvioLettera != null : "fx:id=\"txtDataInvioLettera\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert txtNote != null : "fx:id=\"txtNote\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert btnSalva != null : "fx:id=\"btnSalva\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert btnNuovo != null : "fx:id=\"btnAnnulla\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert btnCreaLettere != null : "fx:id=\"btnCreaLettere\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert btnSelezionaTutti != null : "fx:id=\"btnSelezionaTutti\" was not injected: check your FXML file 'Autoscuola.fxml'.";
    }
}

//cancellato rimane visibile
//TODO date obbligatorie in modifica nuovo cliente
//quando salvi deve resettare la pagina
//ingrandire caratteri dettagli
//TODO checkbox e pulsante per la creazione delle lettere
//regex // \\ nel controllo indirizzo
//TODO pulsante stampa silenzioso
//TODO scorrimento elenco con le frecce
//TODO installazione su windows
//backup su dropbox