package com.gestioneUtente.repository;

import org.springframework.stereotype.Repository;

import com.gestioneUtente.entity.Movimento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MovimentoRepository {

	@PersistenceContext
	EntityManager em;
	
	
	public Movimento creaMovimentoRepository(Movimento movimento)
	{
		em.persist(movimento);
		
		return movimento;
	}
	
}
