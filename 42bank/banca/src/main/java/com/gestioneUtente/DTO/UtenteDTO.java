package com.gestioneUtente.DTO;

import java.util.List;

import com.gestioneUtente.entity.ContoCorrente;

public class UtenteDTO {

	private int idUtente;
	private String nome;
	private String cognome;
	private String mail;
	private String telefono;
	private double saldoTotale;
	
	private IndirizzoDTO indirizzo;
	private List<ContoCorrente> contiIntestati;
	private List<ContoCorrente> contiCointestati;
	
	
	public UtenteDTO()
	{
		
	}

	public UtenteDTO(int idUtente, String nome, String cognome, String mail, String telefono,
			int fk_indirizzo, String via, String cap, String citta, String provincia)
	{
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.telefono = telefono;
		this.indirizzo = new IndirizzoDTO(fk_indirizzo, via, cap, citta, provincia);
	}
	
	public UtenteDTO(int idUtente, String nome, String cognome,
			List<ContoCorrente> contiIntestati, List<ContoCorrente> contiCointestati)
	{
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.contiIntestati = contiIntestati;
		this.contiCointestati = contiCointestati;
	}
	
	
	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public IndirizzoDTO getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(IndirizzoDTO indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<ContoCorrente> getContiIntestati() {
		return contiIntestati;
	}

	public void setContiIntestati(List<ContoCorrente> contiIntestati) {
		this.contiIntestati = contiIntestati;
	}

	public List<ContoCorrente> getContiCointestati() {
		return contiCointestati;
	}

	public void setContiCointestati(List<ContoCorrente> contiCointestati) {
		this.contiCointestati = contiCointestati;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public double getSaldoTotale() {
		return saldoTotale;
	}

	public void setSaldoTotale(double saldoTotale) {
		this.saldoTotale = saldoTotale;
	}

}
