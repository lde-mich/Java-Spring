package com.gestioneUtente.DTO;

import java.util.Date;

public class MovimentoDTO {

	private int idMovimento;
	private String tipo;
	private double importo;
	private Date dataOperazione;
	
	
	public MovimentoDTO()
	{
		
	}

	public MovimentoDTO(int idMovimento, String tipo, double importo, Date dataOperazione)
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

	public Date getDataOperazione() {
		return dataOperazione;
	}

	public void setDataOperazione(Date dataOperazione) {
		this.dataOperazione = dataOperazione;
	}
	
	
}
