/**
 * Sample Skeleton for 'Autoscuola.fxml' Controller Class
 */

package it.tulchiar.autoscuola;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.ResourceBundle;

import it.tulchiar.autoscuola.model.Cliente;
import it.tulchiar.autoscuola.model.Lettera;
import it.tulchiar.autoscuola.model.Model;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.LocalDateStringConverter;

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

    @FXML // fx:id="btnInserisciModifica"
    private Button btnInserisciModifica; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnnulla"
    private Button btnAnnulla; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader
    
    @FXML
    void doMostraDettagli(MouseEvent event) {
    		ObservableList<Cliente> clientiSelezionati = tblClienti.getSelectionModel().getSelectedItems();
    		
    		txtDettagliCliente.setText(clientiSelezionati.get(0).toString());
    		Cliente cliente0 = clientiSelezionati.get(0);
    		
    		if(chkCreazioneLettere.isSelected()) {
	    		Lettera l = new Lettera();
	    		l.creaLetteraScadenzaPatente("", "", clientiSelezionati.get(0));
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
			txtDataScadenza.setText(new LocalDateStringConverter(FormatStyle.SHORT).toString(cliente0.getDataScadenza()));
			txtTelefono.setText(cliente0.getTelefono());
			txtCellulare.setText(cliente0.getCellulare());
			txtEmail.setText(cliente0.getEmail());
			txtNote.setText(cliente0.getNote());
			txtDataInvioLettera.setText(new LocalDateStringConverter(FormatStyle.SHORT).toString(cliente0.getDataInvioLettera()));
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
		colDataScadenza.setCellValueFactory( new PropertyValueFactory<>("dataScadenza"));
		colDataInvioLettera.setCellValueFactory( new PropertyValueFactory<>("dataInvioLettera") );
		
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
//TODO controllare con la data 1/2018 va in errore    		
    		if(txtMese.getText().isEmpty() || !txtMese.getText().chars().allMatch( Character::isDigit ) 
    				|| txtAnno.getText().isEmpty() || !txtAnno.getText().chars().allMatch( Character::isDigit )) {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Errore inserimento data");
    			alert.setHeaderText("Errore inserimento Mese o Anno!");
    			alert.setContentText("Non hai inserito corretamente la data, verifica e riprova.");
    				alert.show();
    			return;
    		}
    		
    		int mese = Integer.parseInt(txtMese.getText());
    		int anno = Integer.parseInt(txtAnno.getText());
    		ArrayList<Cliente> clienti = model.searchScadenza(mese, anno);
    		
    		colCognome.setCellValueFactory( new PropertyValueFactory<>("cognome") );
		colNome.setCellValueFactory( new PropertyValueFactory<>("nome") );
		colTipoPatente.setCellValueFactory( new PropertyValueFactory<>("tipoPatente") );
		colDataScadenza.setCellValueFactory( new PropertyValueFactory<>("dataScadenza"));
		colDataInvioLettera.setCellValueFactory( new PropertyValueFactory<>("dataInvioLettera") );
    	
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
			}
    }

    @FXML
    void doInserisciModifica(ActionEvent event) {
    		
    		int id = -1;
    		
    		try {
    			id = Integer.parseInt(txtId.getText());
		} catch (NumberFormatException e) {
			id = -1;				
		}
    		
    		Alert a1 = new Alert(AlertType.INFORMATION, "Id: " + id, ButtonType.OK);
    		a1.showAndWait();
	    
    		if(id == -1) { //Aggiungo un nuovo cliente
		    	String cognome = txtCognome.getText();
		    	String nome = txtNome.getText();
		    	String indirizzo = txtIndirizzo.getText();
		    	String cap = txtCap.getText();
		    	String localita = txtCap.getText();
		    	String provincia = txtProvincia.getText();
		    	String tipoPatente = txtTipoPatente.getText();
		    	
		    	LocalDate dataScadenza = null;
		    	try {
		    		dataScadenza = LocalDate.parse(txtDataScadenza.getText());
		    	} catch(DateTimeParseException e) {
		    		Alert alert = new Alert(AlertType.ERROR);
		    		alert.setTitle("Formato data errato");
		    		alert.setHeaderText("Formato data errato");
		    		alert.setContentText("La data inserita non è nel formato corretto\\n\\n 2017-12-31");
		    		alert.showAndWait();
		    		return;
		    	}
		    	
		    	String telefono = txtTelefono.getText();
		    	String cellulare = txtCellulare.getText();
		    	String email = txtEmail.getText();
		    	String note = txtNote.getText();
		    	
		    	Cliente nuovoCliente = new Cliente(id, cognome, nome, indirizzo, cap, localita, provincia, tipoPatente, dataScadenza, telefono, cellulare, email, note, null);
		    	
		    	if(model.add(nuovoCliente)) {
		    		Alert alert = new Alert(AlertType.INFORMATION);
		    		alert.setTitle("Nuovo cliente inserito correttamente.");
		    		alert.setHeaderText("");
		    		alert.setContentText("Il cliente è stato aggiunto correttamente!\n\n" + nuovoCliente.toString());
		    		alert.showAndWait();
		    		return;
		    }
    		} else { //modifico il cliente con id = txtId
    			Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setTitle("Modifica cliente");
	    		alert.setHeaderText("");
	    		alert.setContentText("Modifico il cliente con id: " + id);
	    		alert.showAndWait();
	    		return;
    		}
    }
    
    @FXML
    void doAnnulla(ActionEvent event) {
    		resetPannelloAggiungiModifica();
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    		int id = Integer.parseInt(txtId.getText());
    		Cliente cliente = new Cliente(id,null,null);
    		if(model.delete(cliente)) {
    			resetPannelloAggiungiModifica();
    			Alert alert = new Alert(AlertType.INFORMATION, "Cancellazione avvenuta con successo.\n "
    					+ "(in caso di necessità il record è recuperabile)", ButtonType.OK);
    			alert.showAndWait();
    			return;
    		}
    		
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
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
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
        assert btnInserisciModifica != null : "fx:id=\"btnInserisciModifica\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert btnAnnulla != null : "fx:id=\"btnAnnulla\" was not injected: check your FXML file 'Autoscuola.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Autoscuola.fxml'.";

    }
}
