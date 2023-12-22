package com.gestioneUtente.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioneUtente.DTO.ContoCorrenteDTO;
import com.gestioneUtente.entity.ContoCorrente;
import com.gestioneUtente.entity.Movimento;
import com.gestioneUtente.entity.Utente;
import com.gestioneUtente.repository.ContoCorrenteRepository;
import com.gestioneUtente.repository.MovimentoRepository;

@Service
public class ContoCorrenteService {

	@Autowired
	ContoCorrenteRepository repo;
	@Autowired
	MovimentoRepository repo1;
	
	
	public ContoCorrenteDTO ContoCorrenteDTOpopolato(ContoCorrente contoCorrente)
	{
		ContoCorrenteDTO ccdto= new ContoCorrenteDTO(	contoCorrente.getNumeroConto(), 
														contoCorrente.getSaldo(), 
														contoCorrente.getDataApertura(),
														contoCorrente.getIntestatario().getIdUtente(), 
														contoCorrente.getIntestatario().getNome(), 
														contoCorrente.getIntestatario().getCognome(), 
														contoCorrente.getIntestatario().getMail(),
														contoCorrente.getCointestatario().getIdUtente(), 
														contoCorrente.getCointestatario().getNome(), 
														contoCorrente.getCointestatario().getCognome(), 
														contoCorrente.getCointestatario().getMail(),
														contoCorrente.getMovimenti());
		
		return (ccdto);
	}
	
	
	public ContoCorrenteDTO creaContoCorrenteService(double saldo, int idUtenteIntestatario, int idUtenteCointestatario)
	{

			Utente intestatario = repo.getUtenteById(idUtenteIntestatario);
			Utente cointestatario = repo.getUtenteById(idUtenteCointestatario);
			
			if (intestatario == null)
			{
				throw new IllegalArgumentException("Id non esistente");
			}
			
			List<Movimento> movimenti = new ArrayList<Movimento>();
			
			ContoCorrente cc = new ContoCorrente(saldo, intestatario, cointestatario, movimenti);		
			ContoCorrente cc2 = repo.creaContoCorrenteRepository(cc);
			
			if (saldo > 0)
			{
				Movimento m = new Movimento();
				m.setImporto(saldo);
				m.setUtente(intestatario);
				m.setContoCorrente(cc2);
				m.setTipo("Versamento");
				movimenti.add(m);
				repo1.creaMovimentoRepository(m);
			}
	
			ContoCorrenteDTO ccDTO = ContoCorrenteDTOpopolato(cc2);
			
			return ccDTO;
	}
	
	
	public ContoCorrenteDTO modificaContoCorrenteService(int numeroConto, double newSaldo, int idUtenteOperatore)
	{

		Utente operatore = repo.getUtenteById(idUtenteOperatore);
		ContoCorrente cc = repo.getContoCorrenteById(numeroConto);
		
		List<Movimento> movimenti = new ArrayList<Movimento>();
		
//		ContoCorrente cc = new ContoCorrente(numeroConto, newSaldo, operatore);
		
		double operazione = 0;
				
		if (newSaldo > cc.getSaldo())
		{
			operazione = newSaldo - cc.getSaldo();
			
			Movimento m = new Movimento();
			m.setImporto(operazione);
			m.setUtente(operatore);
			m.setContoCorrente(cc);
			m.setTipo("Versamento");
			movimenti.add(m);
			repo1.creaMovimentoRepository(m);
		}
		else if (newSaldo < cc.getSaldo())
		{
			operazione = cc.getSaldo() - newSaldo;
			
			Movimento m = new Movimento();
			m.setImporto(operazione);
			m.setUtente(operatore);
			m.setContoCorrente(cc);
			m.setTipo("Prelievo");
			movimenti.add(m);
			repo1.creaMovimentoRepository(m);
		}
		
		cc.setSaldo(newSaldo);
		
		ContoCorrente cc2 = repo.modificaContoCorrenteRepository(cc);
		ContoCorrenteDTO ccDTO = ContoCorrenteDTOpopolato(cc2);
		return ccDTO;
	}
	
	
	public void cancellaContoCorrenteService(int numeroConto)
	{
		
		ContoCorrente cc = repo.getContoCorrenteById(numeroConto);
		
		if (cc == null)
		{
			throw new IllegalArgumentException("Conto non esistente");
		}
		if (cc.getSaldo() != 0)
		{
			throw new IllegalArgumentException("Impossibile cancellare conto, il saldo è diverso da 0");
		}
		
		cc.getMovimenti().clear();
		cc.setCointestatario(null);
		cc.setIntestatario(null);
		
		repo.cancellaContoCorrenteRepository(cc);
	}
}





























