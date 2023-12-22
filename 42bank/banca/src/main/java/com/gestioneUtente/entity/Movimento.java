package com.gestioneUtente.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMovimento")
public class Movimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMovimento;
	private String tipo;
	private double importo;
	
	@CreationTimestamp
	private Timestamp dataOperazione;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_contoCorrente")
	private ContoCorrente contoCorrente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_utente")
	private Utente utente;
	
	
	
	public Movimento()
	{
		
	}
	
	public Movimento(int idMovimento, String tipo, double importo, Timestamp dataOperazione)
	{
		this.idMovimento = idMovimento;
		this.tipo = tipo;
		this.importo = importo;
		this.dataOperazione = dataOperazione;
	}



	public int getIdMovimento() {
		return idMovimento;
	}

	public void setIdMovimento(int idMovimento) {
		this.idMovimento = idMovimento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public Timestamp getDataOperazione() {
		return dataOperazione;
	}

	public void setDataOperazione(Timestamp dataOperazione) {
		this.dataOperazione = dataOperazione;
	}

	public ContoCorrente getContoCorrente() {
		return contoCorrente;
	}

	public void setContoCorrente(ContoCorrente contoCorrente) {
		this.contoCorrente = contoCorrente;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
}
