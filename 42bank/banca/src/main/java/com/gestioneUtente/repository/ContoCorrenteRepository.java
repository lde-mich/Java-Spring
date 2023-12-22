package com.gestioneUtente.repository;

import org.springframework.stereotype.Repository;

import com.gestioneUtente.entity.ContoCorrente;
import com.gestioneUtente.entity.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ContoCorrenteRepository {

	@PersistenceContext
	EntityManager em;
	
	
	public Utente getUtenteById(int idUtente)
	{
		Utente p = em.find(Utente.class, idUtente);
		
		return p;
	}

	public ContoCorrente getContoCorrenteById(int numeroConto)
	{
		ContoCorrente cc = em.find(ContoCorrente.class, numeroConto);
		
		return cc;
	}
	
	public ContoCorrente creaContoCorrenteRepository(ContoCorrente contoCorrente)
	{
		em.persist(contoCorrente);
		
		return contoCorrente;
	}
	
	
	public ContoCorrente modificaContoCorrenteRepository(ContoCorrente contoCorrente)
	{
		em.merge(contoCorrente);
		
		return contoCorrente;
		
	}
	
	
	public void cancellaContoCorrenteRepository(ContoCorrente contoCorrente)
	{
		
		em.remove(contoCorrente);
				
	}
}























