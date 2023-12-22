package com.gestioneUtente.entity;

import java.sql.Timestamp;
import java.util.List;

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
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "numeroConto")
public class ContoCorrente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numeroConto;
	private double saldo;
	
	@CreationTimestamp
	private Timestamp dataApertura;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_intestatario")
	private Utente intestatario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_cointestatario")
	private Utente cointestatario;
	
	@OneToMany(mappedBy = "contoCorrente")
	List<Movimento> movimenti;
	
	
	public ContoCorrente()
	{
		
	}
	
	public ContoCorrente(int numeroConto, double saldo, Timestamp dataApertura,
			int idUtenteInt, String nomeInt, String cognomeInt, String mailInt,
			int idUtenteCoint, String nomeCoint, String cognomeCoint, String mailCoint,
			List<Movimento> movimenti)
	{
		this.numeroConto = numeroConto;
		this.saldo = saldo;
		this.dataApertura = dataApertura;
		this.intestatario = new Utente(idUtenteInt, nomeInt, cognomeInt, mailInt);
		this.cointestatario = new Utente(idUtenteCoint, nomeCoint, cognomeCoint, mailCoint);
		this.movimenti = movimenti;
	}

	//utilizzato per la creazione contoCorrente
	public ContoCorrente(double saldo, Utente intestatario, Utente cointestatario, List<Movimento> movimenti)
	{
		this.saldo = saldo;
		this.intestatario = intestatario;
		this.cointestatario = cointestatario;
		this.movimenti = movimenti;
	}
	
	//utilizzato per la modifica contoCorrente
	public ContoCorrente(int numeroConto, double newSaldo, Utente operatore)
	{
		this.numeroConto = numeroConto;
		this.saldo = newSaldo;
		this.intestatario = operatore;
		this.cointestatario = operatore;
	}
	
	

	public int getNumeroConto() {
		return numeroConto;
	}

	public void setNumeroConto(int numeroConto) {
		this.numeroConto = numeroConto;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Timestamp getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Timestamp dataApertura) {
		this.dataApertura = dataApertura;
	}

	public Utente getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(Utente intestatario) {
		this.intestatario = intestatario;
	}

	public Utente getCointestatario() {
		return cointestatario;
	}

	public void setCointestatario(Utente cointestatario) {
		this.cointestatario = cointestatario;
	}

	public List<Movimento> getMovimenti() {
		return movimenti;
	}

	public void setMovimenti(List<Movimento> movimenti) {
		this.movimenti = movimenti;
	}
	
	
}
