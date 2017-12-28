package it.tulchiar.autoscuola.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import it.tulchiar.autoscuola.db.DB_common;

// "id";"cognome";"nome";"indirizzo";"cap";"localita";"provincia";
//"tipoPatente";"dataScadenza";"telefono";"cellulare";"email";"note"
public class Cliente {
	private int id;
	private String cognome;
	private String nome;
	private String indirizzo;
	private String cap;
	private String localita;
	private String provincia;
	private String tipoPatente;
	private LocalDate dataScadenza;
	private String telefono;
	private String cellulare;
	private String email;
	private String note;
	private LocalDate dataInvioLettera;
	
	
	public Cliente(int id, String cognome, String nome, String indirizzo, String cap, String localita, String provincia,
			String tipoPatente, LocalDate dataScadenza, String telefono, String cellulare, String email, String note, LocalDate dataInvioLettera) {
		super();
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.localita = localita;
		this.provincia = provincia;
		this.tipoPatente = tipoPatente;
		this.dataScadenza = dataScadenza;
		this.telefono = telefono;
		this.cellulare = cellulare;
		this.email = email;
		this.note = note;
		this.dataInvioLettera = dataInvioLettera;
	}

	public Cliente(int id, String cognome, String nome) {
		super();
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.indirizzo = null;
		this.cap = null;
		this.localita = null;
		this.provincia = null;
		this.tipoPatente = null;
		this.dataScadenza = null;
		this.telefono = null;
		this.cellulare = null;
		this.email = null;
		this.note = null;
		this.dataInvioLettera = null;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * @return the cap
	 */
	public String getCap() {
		return cap;
	}

	/**
	 * @param cap the cap to set
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}

	/**
	 * @return the localita
	 */
	public String getLocalita() {
		return localita;
	}

	/**
	 * @param localita the localita to set
	 */
	public void setLocalita(String localita) {
		this.localita = localita;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the tipoPatente
	 */
	public String getTipoPatente() {
		return tipoPatente;
	}

	/**
	 * @param tipoPatente the tipoPatente to set
	 */
	public void setTipoPatente(String tipoPatente) {
		this.tipoPatente = tipoPatente;
	}

	/**
	 * @return the dataScadenza
	 */
	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	/**
	 * @param dataScadenza the dataScadenza to set
	 */
	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the cellulare
	 */
	public String getCellulare() {
		return cellulare;
	}

	/**
	 * @param cellulare the cellulare to set
	 */
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the dataInvioLettera
	 */
	public LocalDate getDataInvioLettera() {
		return dataInvioLettera;
	}

	/**
	 * @param dataInvioLettera the dataInvioLettera to set
	 */
	public void setDataInvioLettera(LocalDate dataInvioLettera) {
		this.dataInvioLettera = dataInvioLettera;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String dataScadenza = this.dataScadenza == null ? "" : this.dataScadenza.format(DateTimeFormatter.ofPattern(DB_common.dataVisualizzata)) ;
		String dataInvioLettera = this.dataInvioLettera == null ? "" : this.dataInvioLettera.format(DateTimeFormatter.ofPattern(DB_common.dataVisualizzata)) ;
		
		return String.format(
				"Cliente [id=%s]\n"
				+ "Cognome e Nome - %s %s\n"
				+ "Indirizzo - %s - %s %s (%s)\n"
				+ "Tel. %s, Cell. %s email %s\n"
				+ "\n"
				+ "TipoPatente: %s - Scadenza - %s - Lettera inviata: %s\n"
				+ "\n"
				+ "Note: %s",
				id, cognome, nome, indirizzo, cap, localita, provincia, telefono, cellulare,
				email, tipoPatente, 
				dataScadenza,
				dataInvioLettera,
				note);
	}
}