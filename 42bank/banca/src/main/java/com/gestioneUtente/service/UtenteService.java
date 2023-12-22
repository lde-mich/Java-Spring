package com.gestioneUtente.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioneUtente.DTO.UtenteDTO;
import com.gestioneUtente.entity.ContoCorrente;
import com.gestioneUtente.entity.Utente;
import com.gestioneUtente.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository repo;
	
	
	public UtenteDTO utenteDTOpopolato(Utente utente)
	{
		UtenteDTO udto= new UtenteDTO(	utente.getIdUtente(), 
										utente.getNome(), 
										utente.getCognome(),
										utente.getMail(),
										utente.getTelefono(),
										utente.getIndirizzo().getIdIndirizzo(),
										utente.getIndirizzo().getVia(),
										utente.getIndirizzo().getCap(),
										utente.getIndirizzo().getCitta(),
										utente.getIndirizzo().getProvincia());
		
		return (udto);
	}
	
	
	public Utente utentePopolato(UtenteDTO utente)
	{
		Utente u= new Utente(	utente.getIdUtente(), 
								utente.getNome(), 
								utente.getCognome(),
								utente.getMail(),
								utente.getTelefono(),
								utente.getIndirizzo().getIdIndirizzo(),
								utente.getIndirizzo().getVia(),
								utente.getIndirizzo().getCap(),
								utente.getIndirizzo().getCitta(),
								utente.getIndirizzo().getProvincia());
		
		return (u);
	}
	
	
	public UtenteDTO creaUtenteService(UtenteDTO utente)
	{
		Utente u = utentePopolato(utente);
		Utente u2 = repo.creaUtenteRepository(u);
		UtenteDTO uDTO = utenteDTOpopolato(u2);
		
		return(uDTO);
	}
	
	
	public UtenteDTO modificaUtenteService(UtenteDTO utente) throws Exception
	{
		if (repo.checkMail(utente.getMail()))
		{
			throw new RuntimeException("Mail già esistente nel DB");
		}
		
		Utente u = utentePopolato(utente);
		Utente u2 = repo.modificaUtenteRepository(u);
		UtenteDTO uDTO = utenteDTOpopolato(u2);
		
		return(uDTO);
	}
	
	
	public UtenteDTO getUtenteService(int idUtente) throws Exception
	{
		try
		{
			Utente u2 = repo.getUtenteRepository(idUtente);
			UtenteDTO uDTO = utenteDTOpopolato(u2);
			
			return(uDTO);
		}
		catch(Exception e)
		{
			throw new Exception("Utente non registrato");
		}
	}
	
	
	
	public UtenteDTO utenteDatiSalientiDTOpopolato(Utente utente)
	{
		UtenteDTO udto= new UtenteDTO(	utente.getIdUtente(), 
										utente.getNome(), 
										utente.getCognome(),
										utente.getContiIntestati(),
										utente.getContiCointestati());
		
		return (udto);
	}
	
	
	public UtenteDTO getSalientiUtenteService(int idUtente) throws Exception
	{
		try 
		{
			Utente u2 = repo.getSalientiUtenteRepository(idUtente);
			UtenteDTO uDTO = utenteDatiSalientiDTOpopolato(u2);
			
			return(uDTO);
		}
		catch(Exception e)
		{
			throw new Exception("Utente non registrato");
		}
	}
	
	
	public List<UtenteDTO> reportUtentiService()
	{
		List<Utente> listaUtenti = repo.reportUtentiRepository();
		List<UtenteDTO> listaUtentiDTO = new ArrayList<UtenteDTO>();
		
		double saldoTotale = 0;
		
		for (Utente utente : listaUtenti)
		{
			for(ContoCorrente intestatario : utente.getContiIntestati())
			{
				saldoTotale += intestatario.getSaldo();
			}
//			for(ContoCorrente cointestatario : utente.getContiCointestati())
//			{
//				saldoTotale += cointestatario.getSaldo();
//			}
			UtenteDTO uDTO = new UtenteDTO();
			uDTO = utenteDTOpopolato(utente);
			uDTO.setSaldoTotale(saldoTotale);
			listaUtentiDTO.add(uDTO);
			saldoTotale = 0;
		}
		return (listaUtentiDTO);
	}
	
	
	public void cancellaUtenteService(int idUtente) throws Exception
	{
		try
		{
			repo.cancellaUtenteRepository(idUtente);
		}
		catch(Exception e)
		{
			throw new Exception("L'utente non si può eliminare");
		}
	}
	
}
























