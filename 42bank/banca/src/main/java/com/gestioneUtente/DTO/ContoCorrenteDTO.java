package com.gestioneUtente.DTO;

import java.util.Date;
import java.util.List;

import com.gestioneUtente.entity.Movimento;
import com.gestioneUtente.entity.Utente;

public class ContoCorrenteDTO {

	private int numeroConto;
	private double saldo;
	private Date dataApertura;
	
	private Utente intestatario;
	private Utente cointestatario;
	List<Movimento> movimenti;
//	private int intestatario;
//	private int cointestatario;
	
	
	public ContoCorrenteDTO()
	{
		
	}

	public ContoCorrenteDTO(int numeroConto, double saldo, Date dataApertura)
	{
		this.numeroConto = numeroConto;
		this.saldo = saldo;
		this.dataApertura = dataApertura;
	}
	
	public ContoCorrenteDTO(int numeroConto, double saldo, Date dataApertura,
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
	
//	public ContoCorrenteDTO(int numeroConto, double saldo, Date dataApertura,
//			int idUtenteInt,
//			int idUtenteCoint,
//			List<Movimento> movimenti)
//	{
//		this.numeroConto = numeroConto;
//		this.saldo = saldo;
//		this.dataApertura = dataApertura;
//		this.intestatario = idUtenteInt;
//		this.cointestatario = idUtenteCoint;
//		this.movimenti = movimenti;
//	}
	
	public ContoCorrenteDTO(double saldo, Utente intestatario, Utente cointestatario)
	{
		this.saldo = saldo;
		this.intestatario = intestatario;
		this.cointestatario = cointestatario;
	}
	

	public ContoCorrenteDTO(int numeroConto, double newSaldo, Utente operatore)
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

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public Date getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}

//	public Utente getIntestatario() {
//		return intestatario;
//	}
//
//	public void setIntestatario(Utente intestatario) {
//		this.intestatario = intestatario;
//	}
//
//	public Utente getCointestatario() {
//		return cointestatario;
//	}
//
//	public void setCointestatario(Utente cointestatario) {
//		this.cointestatario = cointestatario;
//	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<Movimento> getMovimenti() {
		return movimenti;
	}

	public void setMovimenti(List<Movimento> movimenti) {
		this.movimenti = movimenti;
	}

	@Override
	public String toString() {
		return "ContoCorrenteDTO [numeroConto=" + numeroConto + ", saldo=" + saldo + ", dataApertura=" + dataApertura
				+ ", intestatario=" + intestatario + ", cointestatario=" + cointestatario + ", movimenti=" + movimenti
				+ "]";
	}
	
	
}
