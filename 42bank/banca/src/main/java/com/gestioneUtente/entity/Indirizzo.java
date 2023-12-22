package com.gestioneUtente.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idIndirizzo")
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIndirizzo;
	private String via;
	private String cap;
	private String citta;
	private String provincia;
	
	@OneToMany(mappedBy = "indirizzo")
	List<Utente> elencoUtenti;
	
	public Indirizzo()
	{
		
	}
	
	public Indirizzo(int idIndirizzo, String via, String cap, String citta, String provincia)
	{
		this.idIndirizzo = idIndirizzo;
		this.via = via;
		this.cap = cap;
		this.citta = citta;
		this.provincia = provincia;
	}
	

	public int getIdIndirizzo() {
		return idIndirizzo;
	}

	public void setIdIndirizzo(int idIndirizzo) {
		this.idIndirizzo = idIndirizzo;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
}
