package com.gestioneUtente.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUtente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUtente;
	private String nome;
	private String cognome;
	private String mail;
	private String telefono;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_indirizzo")
	private Indirizzo indirizzo;
	
	@OneToMany(mappedBy = "intestatario")
	List<ContoCorrente> contiIntestati;
	
	@OneToMany(mappedBy = "cointestatario")
	List<ContoCorrente> contiCointestati;
	
	@OneToMany(mappedBy = "utente")
	List<Movimento> movimenti;
	
	
	
	public Utente()
	{
		
	}

	public Utente(int idUtente, String nome, String cognome, String mail, String telefono,
			int fk_indirizzo, String via, String cap, String citta, String provincia)
	{
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.telefono = telefono;
		this.indirizzo = new Indirizzo(fk_indirizzo, via, cap, citta, provincia);
	}

	public Utente(int idUtente, String nome, String cognome, String mail)
	{
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
	}
	
	public Utente(int idUtente, String nome, String cognome,
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
	
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(Indirizzo indirizzo) {
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
	
}
